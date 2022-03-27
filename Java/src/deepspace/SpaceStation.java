package deepspace;
import java.util.ArrayList;

public class SpaceStation {
<<<<<<< HEAD
    private static int MAXFUEL = 100;
    private static float SHIELDLOSSPERUNITSHOT = 0.1f;

    private int ammoPower;
=======
    
    // Attributes

    private static final int MAXFUEL = 100;
    private static final float SHIELDLOSSPERUNITSHOT = 0.1f;
    private float ammoPower;
>>>>>>> 9500dac1b78110166374204a286a24fc594d230c
    private float fuelUnits;
    private String name;
    private int nMedals;
    private float shieldPower;
<<<<<<< HEAD
    private Damage pendingDamage;
    private ArrayList<Weapon> weapons;
    private ArrayList<ShieldBooster> shieldBoosters;
    private Hangar hangar;

    // TODO

    private void assignFuelValue(float f) {
        throw new UnsupportedOperationException();
    }

    private void cleanPendingDamage() {
        throw new UnsupportedOperationException();
    }

    SpaceStation(String n, SuppliesPackage supplies) {
        throw new UnsupportedOperationException();
    }

    public void cleanUpMountedItems() {
        throw new UnsupportedOperationException();
    }

    public void discardHangar() {
        throw new UnsupportedOperationException();
    }

    public void discardShieldBooster(int i) {
=======
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
        weapons        = null;
        shieldBoosters = null;
        hangar         = null;
        pendingDamage  = null;
    }

    private void assignFuelValue(float f) {
        if ((f + getFuelUnits()) <= MAXFUEL) 
            fuelUnits += f;
    }

    private void cleanPendingDamage() {
        if (pendingDamage.hasNoEffect())
            pendingDamage = null;
    } 

    public void cleanUpMountedItems() {
        if (weapons != null) {
            ArrayList<Weapon> localWeapons = new ArrayList<Weapon>();
            for (int i = 0; i < weapons.size(); i++) {
                if (weapons.get(i).getUses() != 0)
                    localWeapons.add(weapons.get(i));
            }
            weapons = localWeapons;
        }
        if (shieldBoosters != null) {
            ArrayList<ShieldBooster> localShieldBoosters = new ArrayList<ShieldBooster>();
            for (int i = 0; i < shieldBoosters.size(); i++) {
                if(shieldBoosters.get(i).getUses() != 0)
                    localShieldBoosters.add(localShieldBoosters.get(i));
            }
            shieldBoosters = localShieldBoosters;
        }
    }

    public void discardHangar() {
        if (hangar != null)
            hangar = null;
    }

    public void discardShieldBooster(int i) {   // P3
>>>>>>> 9500dac1b78110166374204a286a24fc594d230c
        throw new UnsupportedOperationException();
    }

    public void discardShieldBoosterInHangar(int i) {
<<<<<<< HEAD
        throw new UnsupportedOperationException();
    }

    public float fire() {
        throw new UnsupportedOperationException();
    }

    public float getAmmoPower() {
        throw new UnsupportedOperationException();
    }

    public float getFuelUnits() {
        throw new UnsupportedOperationException();
    }

    public Hangar getHangar() {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public int getNMedals() {
        throw new UnsupportedOperationException();
    }

    public Damage getPendingDamage() {
        throw new UnsupportedOperationException();
    }

    public ArrayList<ShieldBooster> getShieldBoosters() {
        throw new UnsupportedOperationException();
    }

    public float getShieldPower() {
        throw new UnsupportedOperationException();
=======
        if (hangar != null) 
            hangar.removeShieldBooster(i);
    }

    public float fire() {   //P3
        throw new UnsupportedOperationException();
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
            Hangar copyHangar = new Hangar(hangar);
            return copyHangar;
        }
    }

    public String getName() {
        return name;
    }

    public int getNMedals() {
        return nMedals;
    }

    public Damage getPendingDamage() {
        Damage copyDamage = new Damage(pendingDamage);
        return copyDamage;
    }

    public ArrayList<ShieldBooster> getShieldBoosters() {
        if (shieldBoosters == null)
            return null;
        else
            return new ArrayList<ShieldBooster>(shieldBoosters);
    }

    public float getShieldPower() {
        return shieldPower;
>>>>>>> 9500dac1b78110166374204a286a24fc594d230c
    }

    public float getSpeed() {
        throw new UnsupportedOperationException();
    }

    public SpaceStationToUI getUIversion() {
<<<<<<< HEAD
        throw new UnsupportedOperationException();
    }

    public ArrayList<Weapon> getWeapons() {
        throw new UnsupportedOperationException();
    }

    public void mountWeapon(int i) {
        throw new UnsupportedOperationException();
    }

    public void move() {
        throw new UnsupportedOperationException();
    }

    public float protection() {
=======
        return new SpaceStationToUI(this);
    }

    public ArrayList<Weapon> getWeapons() {
        if (weapons == null)
            return null;
        else
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
        fuelUnits -= getSpeed()*fuelUnits;
        if (fuelUnits < 0)
            fuelUnits = 0; 
    }

    public float protection() { //P3
>>>>>>> 9500dac1b78110166374204a286a24fc594d230c
        throw new UnsupportedOperationException();
    }

    public void receiveHangar(Hangar h) {
<<<<<<< HEAD
        throw new UnsupportedOperationException();
    }

    public boolean receiveShieldBooster(ShieldBooster s) {
        throw new UnsupportedOperationException();
=======
        if (hangar == null) {
            hangar = new Hangar(h);
        }
    }

    public boolean receiveShieldBooster(ShieldBooster s) {
        if (hangar != null) 
            return hangar.addShieldBooster(s);
        else 
            return false;
>>>>>>> 9500dac1b78110166374204a286a24fc594d230c
    }

    public ShotResult receiveShot(float shot) {
        throw new UnsupportedOperationException();
    }

<<<<<<< HEAD
    public void receiveSupplies(SuppliesPackage s) {
        throw new UnsupportedOperationException();
    }

    public boolean receiveWeapon(Weapon w) {
        throw new UnsupportedOperationException();
    }

=======
>>>>>>> 9500dac1b78110166374204a286a24fc594d230c
    public void setLoot(Loot loot) {
        throw new UnsupportedOperationException();
    }

    public void setPendingDamage(Damage d) {
<<<<<<< HEAD
        throw new UnsupportedOperationException();
    }

    public boolean validState() {
        throw new UnsupportedOperationException();
    }
=======
        if (d != null)
            pendingDamage = d.adjust(weapons, shieldBoosters);
    }

    public boolean validState() {
        return (pendingDamage == null) || (pendingDamage.hasNoEffect());
    }

>>>>>>> 9500dac1b78110166374204a286a24fc594d230c
}
