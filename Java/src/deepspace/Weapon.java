/**
 * @brief DEEPSPACE (Java). 
 * Class that represents the arms of a space station to increase the shot power
 * @author Mario Megías Mateo and Shao Jie Hu Chen.
 */

package deepspace;

class Weapon {
    
    private static final float DEFAULTPOWER = 1.0f;
    
    private String name;
    private WeaponType type;
    private int uses;
    
    /**
     * @brief Constructor with parameters
     * @param theName Name associated to weapon. 
     * @param theType Type associated to weapon. 
     * @param theUses Uses associated to weapon. 
     */
    Weapon(String theName, WeaponType theType, int theUses) {
        this.name = theName;
        this.type = theType;
        this.uses = theUses;
    }
    
    /**
     * @brief Copy constructor
     * @param instance Another instance of Weapon. 
     */
    Weapon(Weapon instance) {
        this.name = instance.name;
        this.type = instance.type;
        this.uses = instance.uses;
    }

    WeaponToUI getUIversion() {
        return new WeaponToUI(this);
    }
    
    /**
     * @brief Get method
     * @return Type associated to weapon. 
     */
    public WeaponType getType() {
        return this.type;
    }
    
    /**
     * @brief Get method
     * @return Uses associated to weapon. 
     */
    public int getUses() {
        return this.uses;
    }
    
    /**
     * @brief It indicates the power of the weapon.
     * @return Power associated to weapon. 
     */
    public float power() {
        return this.type.getPower();
    }
    
    /**
     * @brief It decreases the uses of the weapon.
     * @return Weapon power if uses > 0. Otherwise, 1.0. 
     */
    public float useIt() {
        if(uses > 0) {
            uses--;
            return this.power();
        } else {
            return DEFAULTPOWER;
        }
    } 

    public String toString() {
        String data = "[";

        data += "Name:" + this.name + "; ";
        data += "WeaponType:" + this.type + "; ";
        data += "Uses:" + this.uses;

        data += "]";
        
        return data;
    }
}
