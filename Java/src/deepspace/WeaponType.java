package deepspace;

/**
 * @brief DEEPSPACE (Java). 
 * Enumeration of different weapons and their damage powers. 
 * @author Mario Megías Mateo and Shao Jie Hu Chen.
 */
public enum WeaponType {
    
    LASER(2.0f), MISSILE(3.0f), PLASMA(4.0f);
    
    private final float power;
    
    /**
     * @brief Constructor with parameter. 
     * @param thePower Power associated to the weapon. 
     */
    WeaponType(float thePower) {
        this.power = thePower;
    }
    
    /**
     * @brief Get method
     * @return Power associated to weapon. 
     */
    float getPower() {
        return this.power;
    } 
}
