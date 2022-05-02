package deepspace;

import java.util.ArrayList; // import the ArrayList class

public class Damage {
    private final static int NOTUSED = -1;

    private int nShields;
    private int nWeapons;
    private ArrayList<WeaponType> weapons;

    /**
     * @brief Constructor
     * @param w Number of weapons
     * @param s Number of shields
     */
    Damage(int w, int s) {
        nWeapons = w;
        nShields = s;
        weapons = null;
    }

    /**
     * @brief Constructor
     * @param wl ArrayList of WeaponType
     * @param s Number of shields
     */
    Damage(ArrayList<WeaponType> wl, int s) {
        this(NOTUSED, s);

        if (wl != null)
            weapons = new ArrayList<WeaponType>(wl);
        else
            weapons = null;
    }

    /**
     * @brief Copy constructor
     * @param d Instance of Damage
     */
    Damage(Damage d) {        
        nWeapons = d.nWeapons;
        nShields = d.nShields;

        if (d.weapons != null)
            weapons = new ArrayList<WeaponType>(d.weapons);
        else
            weapons = null;
    }

    /**
     * @brief UI Interface
     * @return Interface to UI
     */
    DamageToUI getUIversion() {
        return new DamageToUI(this);
    }

    /**
     * @brief This method finds whether w contains t type.
     * @param w ArrayList of Weapons
     * @param t WeaponType
     * @return Position at array if found. Else, a negative number. 
     */
    private int arrayContainsType(ArrayList<Weapon> w, WeaponType t) {
        int pos = -1;
        boolean found = false;

        for (int i=0; i<w.size() && !found; ++i) {
            if (w.get(i).getType() == t) {
                pos = i;
                found = true;
            }
        }

        return pos;
    }

    /**
     * @brief It reduces the Damage according to restrictions provided by w and s.
     * @param w ArrayList of Weapons to adjust.
     * @param s ArrayList of ShieldsBooster to adjust.
     * @return New instance of Damage, with adjusted restrictions.
     */
    public Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s) {
        
        Damage newDamage = new Damage(this);

        // newDamage.nShields -= Math.min(s.size(), newDamage.nShields);
        newDamage.nShields = Math.min(s.size(), newDamage.nShields);

        if (newDamage.nWeapons == NOTUSED) {     // Array Case
            
            int pos = 0;
            ArrayList<Weapon> wCopy = new ArrayList<Weapon>(w);

            while (pos < newDamage.weapons.size()) {
                
                WeaponType weapon = newDamage.weapons.get(pos);
                int pos_encountered = this.arrayContainsType(wCopy, weapon);

                if (pos_encountered >= 0) {
                    wCopy.remove(pos_encountered);
                    ++pos;
                    // newDamage.weapons.remove(weapon);
                } else {
                    newDamage.weapons.remove(weapon);
                    // ++pos;
                }
            }
            
        } else {                        // Numeric Case
            // newDamage.nWeapons -= Math.min(w.size(), newDamage.nWeapons);
            newDamage.nWeapons = Math.min(w.size(), newDamage.nWeapons);
        }

        return newDamage;
    }

    /**
     * @brief It discards a Weapon from the Damage. 
     * @param w
     */
    public void discardWeapon(Weapon w) {
        if (this.nWeapons == NOTUSED)
            this.weapons.remove(w.getType());
        else
            if (this.nWeapons > 0)
                --this.nWeapons;
    }

    public void discardShieldBooster() {
        if (this.nShields > 0) {
            --this.nShields;
        }
    }
    
    /**
     * @brief Establishes when a Damage is inoffensive. 
     * @return True when there are nor shields nor weapons. False otherwise. 
     */
    public boolean hasNoEffect() {
        if (this.nWeapons == NOTUSED) {
            return (this.nShields == 0 && this.weapons.isEmpty());
        } else {
            return (this.nShields == 0 && this.nWeapons == 0);
        }
    }

    public int getNShields() {
        return this.nShields;
    }

    public int getNWeapons() {
        return this.nWeapons;
    }

    public ArrayList<WeaponType> getWeapons() {
        if (this.nWeapons == NOTUSED)
            return new ArrayList<WeaponType>(this.weapons);
        else
            return null;
    }

    public String toString() {
        String info = "";

        info += "[nShields: " + this.nShields + ", nWeapons: " + this.nWeapons + ", weapons: ";
        
        if (this.nWeapons == NOTUSED) {
            info += this.weapons.toString();
        } else {
            info += "NULL";
        }

        info += "]";

        return info;
    }
}
