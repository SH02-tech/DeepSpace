/**
 * @brief DEEPSPACE (Java). 
 * Class that represents the supplies package of a space station. 
 * @author Mario Megías Mateo and Shao Jie Hu Chen.
 */

package deepspace;

class SuppliesPackage {
    
    // Attributes
    private float ammoPower;
    private float fuelUnits;
    private float shieldPower;
    
    // Constructors
    SuppliesPackage(float theAmmoPower, float theFuelUnits, float theShieldPower) {
        this.ammoPower = theAmmoPower;
        this.fuelUnits = theFuelUnits;
        this.shieldPower = theShieldPower;
    }
    
    SuppliesPackage(SuppliesPackage s) {
        this.ammoPower = s.ammoPower;
        this.fuelUnits = s.fuelUnits;
        this.shieldPower = s.shieldPower;
    }
    
    // Get methods
    
    float getAmmoPower() {
        return this.ammoPower;
    }
    
    float getFuelUnits() {
        return this.fuelUnits;
    }
    
    float getShieldPower() {
        return this.shieldPower;
    }
}
