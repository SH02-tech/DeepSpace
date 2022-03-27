/**
 * @brief DEEPSPACE (Java). 
 * Class that represents the shield boosters that space stations can contain
 * @author Mario Megías Mateo and Shao Jie Hu Chen.
 */

package deepspace;

class ShieldBooster {
    
    private String name;
    private float boost;
    private int uses;
    
    /**
     * @brief Constructor with parameters
     * @param theName Name.
     * @param theBoost Boost.
     * @param theUses Use.
     */
    ShieldBooster(String theName, float theBoost, int theUses) {
        this.name = theName;
        this.boost = theBoost;
        this.uses = theUses;
    }
    
    /**
     * @brief Copy constructor
     * @param instance 
     */
    ShieldBooster(ShieldBooster instance) {
        this.name = instance.name;
        this.boost = instance.boost;
        this.uses = instance.uses;
        // this(instance.name, instance.getBoost(), instance.getUses());
    }

    ShieldToUI getUIversion() {
        throw new UnsupportedOperationException();
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
}
