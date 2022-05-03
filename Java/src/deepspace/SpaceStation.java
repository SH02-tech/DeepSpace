package deepspace;
import java.util.ArrayList;
import java.lang.Math;

public class SpaceStation {
    
    // Attributes

    private static final int MAXFUEL = 100;
    private static final float SHIELDLOSSPERUNITSHOT = 0.1f;
    private float ammoPower;
    private float fuelUnits;
    private String name;
    private int nMedals;
    private float shieldPower;
    private ArrayList<Weapon> weapons;
    private ArrayList<ShieldBooster> shieldBoosters;
    private Hangar hangar;
    private Damage pendingDamage;

    // Methods

    // Constructor

    SpaceStation(String n, SuppliesPackage supplies) {
        name           = n;
        ammoPower      = supplies.getAmmoPower();
        fuelUnits      = supplies.getFuelUnits();
        shieldPower    = supplies.getShieldPower();
        nMedals        = 0;
        weapons        = new ArrayList<>();
        shieldBoosters = new ArrayList<>();
        hangar         = null;
        pendingDamage  = null;
    }

    private void assignFuelValue(float f) {
        if (0 <= f  && f <= MAXFUEL)
            fuelUnits = f;
        else if (f < 0)
            fuelUnits = 0;
        else
            fuelUnits = MAXFUEL;
    }

    private void cleanPendingDamage() {
        if (pendingDamage.hasNoEffect())
            pendingDamage = null;
    } 

    public void cleanUpMountedItems() {
        int pos = 0;
        while (pos < weapons.size()) {
            if (weapons.get(pos).getUses() == 0) 
                weapons.remove(pos);
            else
                pos++;
        }
        pos = 0;
        while (pos < shieldBoosters.size()) {
            if (shieldBoosters.get(pos).getUses() == 0) 
                shieldBoosters.remove(pos);
            else
                pos++;
        }
    }

    public void discardHangar() {
        if (hangar != null)
            hangar = null;
    }

    public void discardShieldBooster(int i) {   // P3
        if( i >= 0 && i < shieldBoosters.size()) {
            shieldBoosters.remove(i);
            if (pendingDamage != null) {
                pendingDamage.discardShieldBooster();
                cleanPendingDamage();
            }
        }
    }

    public void discardShieldBoosterInHangar(int i) {
        if (hangar != null) 
            hangar.removeShieldBooster(i);
    }

    public void discardWeapon(int i) { 
        if( i >= 0 && i < weapons.size()) {
            Weapon w = weapons.remove(i); 
            if (pendingDamage != null) {
                pendingDamage.discardWeapon(w);
                cleanPendingDamage();
            }
        }
    }

    public void discardWeaponInHangar(int i) {
        if (hangar != null) 
            hangar.removeWeapon(i);
    }
    
    public float fire() {   //P3
        float factor = 1f;
        for (Weapon weapon : weapons) {
            factor *= weapon.useIt();
        }
        return(ammoPower * factor);
    }

    // Getters

    public float getAmmoPower() {
        return ammoPower;
    }

    public float getFuelUnits() {
        return fuelUnits;
    }

    public Hangar getHangar() {
        if (hangar == null)
            return null;
        else {
            return new Hangar(hangar);
        }
    }

    public String getName() {
        return name;
    }

    public int getNMedals() {
        return nMedals;
    }

    public Damage getPendingDamage() {
        if (pendingDamage == null)
            return null;
        else {
            return new Damage(pendingDamage);
        }
    }

    public ArrayList<ShieldBooster> getShieldBoosters() {
        if (shieldBoosters.isEmpty())
            return new ArrayList<>(); 
        else
            return new ArrayList<ShieldBooster>(shieldBoosters);
    }

    public float getShieldPower() {
        return shieldPower;
    }

    public float getSpeed() {
        return (fuelUnits/((float)MAXFUEL));
    }

    public SpaceStationToUI getUIversion() {
        return new SpaceStationToUI(this);
    }

    public ArrayList<Weapon> getWeapons() {
        return new ArrayList<Weapon>(weapons);
    }

    public void mountShieldBooster(int i) {
        if (hangar != null) {
            ShieldBooster shield = hangar.removeShieldBooster(i);  
            if (shield != null) {
                shieldBoosters.add(shield);
            }
        }
    }

    public void mountWeapon(int i) {
        if (hangar != null) {
            Weapon weapon = hangar.removeWeapon(i);  
            if (weapon != null) {
                weapons.add(weapon); 
            }
        }
    }

    public void move() {
        float fuel = fuelUnits*(1-getSpeed()); 
        assignFuelValue(fuel);
    }
 
    public float protection() { //P3
        float factor = 1f;
        for (ShieldBooster shieldBooster : shieldBoosters) {
            factor *= shieldBooster.useIt();
        }
        return (shieldPower * factor);
    }

    public void receiveHangar(Hangar h) {
        if (hangar == null) {
            hangar = new Hangar(h);
        }
    }

    public boolean receiveShieldBooster(ShieldBooster s) {
        if (hangar != null) 
            return hangar.addShieldBooster(s);
        else 
            return false;
    }
    
    public ShotResult receiveShot(float shot) { // P3
        if (protection() >= shot) {
            shieldPower -= SHIELDLOSSPERUNITSHOT * shot;
            shieldPower = Math.max(0f, shieldPower);
            return ShotResult.RESIST;
        } else {
            shieldPower = 0f;
            return ShotResult.DONOTRESIST;
        }
    }

    public void receiveSupplies(SuppliesPackage s) {
        ammoPower   = s.getAmmoPower();
        fuelUnits   = s.getFuelUnits();
        shieldPower = s.getShieldPower();
    }

    public boolean receiveWeapon(Weapon w) {
        if (hangar != null) 
            return hangar.addWeapon(w);
        else 
            return false;
    }
    
    public void setLoot(Loot loot) {
        CardDealer dealer = CardDealer.getInstance();
        
        int h = loot.getNHangars();
        if (h > 0) {
            this.receiveHangar(dealer.nextHangar()); 
        } 

        int elements = loot.getNSupplies();
        for (int i = 0; i < elements; i++) {
            this.receiveSupplies(dealer.nextSuppliesPackage());
        }

        elements = loot.getNWeapons();
        for (int i = 0; i < elements; i++) {
            this.receiveWeapon(dealer.nextWeapon()); 
        }

        elements = loot.getNShields();
        for (int i = 0; i < elements; i++) {
            this.receiveShieldBooster(dealer.nextShieldBooster());
        }

        this.nMedals += loot.getNMedals();
    }

    public void setPendingDamage(Damage d) {
        if (d != null) {
            pendingDamage = d.adjust(weapons, shieldBoosters);
            cleanPendingDamage();
        }
    }

    /**
     * @brief This function determines the state of SpaceStation.
     * @return False when there's pendingDamage with effect. True otherwise. 
     */
    public boolean validState() {
        boolean state = true;
        if (pendingDamage != null &&  !pendingDamage.hasNoEffect())
            state = false;
        
        return state;
    }

    public String toString() {
        
        String s = "[";
        s += "ammoPower: " + this.ammoPower + ", fuelUnits: " + this.fuelUnits;
        s += ", name: " + this.name + ", nMedals: " + this.nMedals+ ", shieldPower: " ;
        s += this.shieldPower;

        if (this.pendingDamage != null) {
            s += ", pendingDamage: " + this.pendingDamage.toString();
        } else {
            s += ", pendingDamage: NULL";
        }

        s += ", weapons: " + weapons.toString() + ", shieldBoosters: " + shieldBoosters.toString();

        if (this.hangar != null) {
            s += ", hangar: " + this.hangar.toString();
        } else {
            s += ", hangar: NULL";
        }

        s += "]";
        return s;
    }
        
}
