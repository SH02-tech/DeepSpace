package deepspace;

/**
 * @brief DEEPSPACE (Java). 
 * Class that represents the shield boosters that space stations can contain
 * @author Mario Megías Mateo and Shao Jie Hu Shen.
 */
class ShieldBooster {
    
    private String name;
    private float boost;
    private int uses;
    
    /**
     * @brief Constructor with parameters
     * @param the_name
     * @param the_boost
     * @param the_uses 
     */
    ShieldBooster(String the_name, float the_boost, int the_uses) {
        this.name = the_name;
        this.boost = the_boost;
        this.uses = the_uses;
    }
    
    /**
     * @brief Copy constructor
     * @param instance 
     */
    ShieldBooster(ShieldBooster instance) {
        this.name = instance.name;
        this.boost = instance.boost;
        this.uses = instance.uses;
    }
    
    /**
     * @brief get method
     * @return attribute boost
     */
    public float getBoost() {
        return this.boost;
    }
    
    /**
     * @brief get method
     * @return attribute uses
     */
    public int getUses() {
        return this.uses;
    }
    
    /**
     * @brief decrease the uses of the shield
     * @pre uses > 0
     * @return boost if uses > 0 or 1.0 in other case
     */
    public float useIt() {
        if(uses > 0) {
            uses--;
            return this.boost;
        } else {
            return 1.0f;
        }
    } 
}
