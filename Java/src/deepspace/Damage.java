package deepspace;

import java.util.ArrayList; // import the ArrayList class

/**
 *
 * @author Mario Megías Mateo and Shao Jie Hu Chen.
 */
public abstract class Damage {

    private int nShields;

    /**
     * @brief Constructor
     * @param s Number of shields
     */
    Damage(int s) {
        nShields = s;
    }

    /**
     * @brief Copies the implicit object. ABSTRACT.
     * @return A copy of the implicit object.
     */
    public abstract Damage copy();
         
    /**
     * @brief UI Interface. ABSTRACT.
     * @return Interface to UI
     */
    abstract DamageToUI getUIversion();

    /**
     * @brief auxiliary method to calculate the adjusted number of shields.
     * @param s ArrayList of ShieldsBooster to adjust.
     * @return the adjusted number of shields.
     */
    public int adjustShields(ArrayList<ShieldBooster> s) {
        return Math.min(s.size(), nShields);
    }

    /**
     * @brief It reduces the Damage according to restrictions provided by w 
     * and s. ABSTRACT.
     * @param w ArrayList of Weapons to adjust.
     * @param s ArrayList of ShieldsBooster to adjust.
     * @return New instance of Damage, with adjusted restrictions.
     */    
    public abstract Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s);

    /**
     * @brief It discards a Weapon from the Damage. ABSTRACT.
     * @param w
     */
    public abstract void discardWeapon(Weapon w);
    
    /**
     * @brief It discards a shield booster from the Damage. 
     */
    public void discardShieldBooster() {
        if (nShields > 0) {
            nShields--;
        } else {
            nShields = 0;
        }
    }

    /**
     * @brief Establishes when a Damage is inoffensive.
     * @return True when there are not shields nor weapons. False otherwise. 
     */
    public boolean hasNoEffect() {
        return nShields == 0;
    }
    
    /**
    * @brief Getter
    * @return nShields attribute
    */
    public int getNShields() {
        return nShields;
    }

    /**
     * @brief toString.
     * @return A string with the information of the state of the object
     */
    public String toString() {
        return "[nShields: " + nShields + "]";
    }
    
}
