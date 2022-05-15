package deepspace;

import java.util.ArrayList; // import the ArrayList class

/**
 *
 * @author Mario Megías Mateo and Shao Jie Hu Chen.
 */
public class NumericDamage extends Damage {
    
    private int nWeapons;
    
    /**
     * @brief Constructor
     * @param s Number of shields
     * @param w Number of weapons
     */
    NumericDamage(int w, int s) {
        super(s);
        nWeapons = w;
    }
    
    /**
     * @brief Copies the implicit object. ABSTRACT.
     * @return A copy of the implicit object.
     */
    @Override
    public NumericDamage copy() {
        return new NumericDamage(nWeapons, getNShields());
    }
    
    /**
     * @brief UI Interface. Overrride.
     * @return Interface to UI
     */
    @Override
    NumericDamageToUI getUIversion() {
        return new NumericDamageToUI(this);
    }
    
    /**
     * @brief It reduces the Damage according to restrictions provided by w 
     * and s. Override.
     * @param w ArrayList of Weapons to adjust.
     * @param s ArrayList of ShieldsBooster to adjust.
     * @return New instance of Damage, with adjusted restrictions.
     */
    @Override
    public NumericDamage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s) {
        int numberofShields = adjustShields(s);
        int numberofWeapons = Math.min(w.size(), this.nWeapons);
        return new NumericDamage(numberofWeapons, numberofShields);
    }
    
    /**
     * @brief It discards a Weapon from the Damage. Override.
     * @param w
     */
    @Override
    public void discardWeapon(Weapon w) {
        if (this.nWeapons > 0)
            this.nWeapons--;
        else
            this.nWeapons = 0;
    }
        
    /**
     * @brief Establishes when a Damage is inoffensive.
     * @return True when there are not shields not weapons. False otherwise. 
     */
    @Override
    public boolean hasNoEffect() {
        return (super.hasNoEffect() && nWeapons == 0);
    }
    
    /**
     * @brief Getter
     * @return nWeapons attribute
     */
    public int getNWeapons() {
        return nWeapons;
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
        info += ", nWeapons: " + nWeapons;
        info += "]";
        return info;
    }
             
}
