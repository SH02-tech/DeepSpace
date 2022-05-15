package deepspace;

import java.util.ArrayList; // import the ArrayList class

/**
 *
 * @author Mario Megías Mateo and Shao Jie Hu Chen.
 */
public class SpecificDamage extends Damage {
    
    private ArrayList<WeaponType> weapons;
    
    /**
     * @brief Constructor
     * @param s Number of shields
     * @param wl List of types of weapons
     */
    SpecificDamage(ArrayList<WeaponType> wl, int s) {
        super(s);
        if (wl != null) {
            weapons = new ArrayList<WeaponType>(wl);
        } else {
            weapons = new ArrayList<WeaponType>();
        }
    }
    
    /**
     * @brief Copies the implicit object. ABSTRACT.
     * @return A copy of the implicit object.
     */
    @Override
    public SpecificDamage copy() {
        return new SpecificDamage(weapons, getNShields());
    }
    
    /**
     * @brief UI Interface. Overrride.
     * @return Interface to UI
     */
    @Override
    SpecificDamageToUI getUIversion(){
        return new SpecificDamageToUI(this);
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
     * @brief It reduces the Damage according to restrictions provided by w 
     * and s. Override.
     * @param w ArrayList of Weapons to adjust.
     * @param s ArrayList of ShieldsBooster to adjust.
     * @return New instance of Damage, with adjusted restrictions.
     */
    @Override
    public SpecificDamage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s) {
        int numberofshields = adjustShields(s);
        int pos = 0;
        ArrayList<Weapon> wCopy = new ArrayList<Weapon>(w);
        ArrayList<WeaponType> weaponsCopy = new ArrayList<WeaponType>(this.weapons);
        
        while (pos < weaponsCopy.size()) {
            WeaponType weapon = weaponsCopy.get(pos);
            int pos_encountered = this.arrayContainsType(wCopy, weapon);

            if (pos_encountered >= 0) {
                wCopy.remove(pos_encountered);
                ++pos;
            } else {
                weaponsCopy.remove(weapon); // first element found 
            }
        }
        
        return new SpecificDamage(weaponsCopy, numberofshields);
    }
    
    /**
     * @brief It discards a Weapon from the Damage. Override.
     * @param w
     */
    @Override
    public void discardWeapon(Weapon w) {
        weapons.remove(w.getType());
    }
    
    /**
     * @brief Establishes when a Damage is inoffensive.
     * @return True when there are not shields not weapons. False otherwise. 
     */
    @Override
    public boolean hasNoEffect() {
        return (super.hasNoEffect() && weapons.isEmpty());
    }
    
    /**
     * @brief Getter
     * @return weapons attribute
     */
    public ArrayList<WeaponType> getWeapons() {
        return new ArrayList<WeaponType>(weapons);
    }
    
    /**
     * @brief toString
     * @return A string with the information of the state of the object
     */
    @Override
    public String toString() {
        String cadSuper = super.toString();
        String info = "";
        info += cadSuper.substring(0, cadSuper.length()-1);
        info += ", weapons: " + weapons.toString();
        info += "]";
        return info;
    }
    
}
