package deepspace;

/**
 * @brief DEEPSPACE (Java). 
 * Class that represents the arms of a space station to increase the shot power
 * @author Mario Megías Mateo and Shao Jie Hu Shen.
 */
class Weapon {
    
    private String name;
    private WeaponType type;
    private int uses;
    
    /**
     * @brief Constructor with parameters
     * @param the_name
     * @param the_type
     * @param the_uses 
     */
    Weapon(String the_name, WeaponType the_type, int the_uses) {
        this.name = the_name;
        this.type = the_type;
        this.uses = the_uses;
    }
    
    /**
     * @brief Copy constructor
     * @param instance 
     */
    Weapon(Weapon instance) {
        this.name = instance.name;
        this.type = instance.type;
        this.uses = instance.uses;
    }
    
    /**
     * @brief get method
     * @return type attribute
     */
    public WeaponType getType() {
        return this.type;
    }
    
    /**
     * @brief get method
     * @return uses attribute
     */
    public int getUses() {
        return this.uses;
    }
    
    /**
     * @brief indicates the power of the weapon
     * @return the power of the weapon
     */
    public float power() {
        return this.type.getPower();
    }
    
     /**
     * @brief decrease the uses of the weapon
     * @pre uses > 0
     * @return weapon power if uses > 0 or 1.0 in other case
     */
    public float useIt() {
        if(uses > 0) {
            uses--;
            return this.power();
        } else {
            return 1.0f;
        }
    } 
}
