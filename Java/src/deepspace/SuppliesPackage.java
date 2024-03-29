/**
 * @brief DEEPSPACE (Java). 
 * Class that represents the supplies package of a space station. 
 * @author Mario Megías Mateo and Shao Jie Hu Chen.
 */

package deepspace;

class SuppliesPackage {
    
    // Attributes
    private float ammoPower;    // Armament power. 
    private float fuelUnits;
    private float shieldPower;
    
    // Constructors
    
    /** 
     * @brief Constructor with parameters.
     * @param theAmmoPower Number corresponding to armamment power of package. 
     * @param theFuelUnits Number of capacity units of fuel.
     * @param theShieldPower Number that represents the protection offered by shield. 
     */
    SuppliesPackage(float theAmmoPower, float theFuelUnits, float theShieldPower) {
        this.ammoPower   = theAmmoPower;
        this.fuelUnits   = theFuelUnits;
        this.shieldPower = theShieldPower;
    }
    
    /** 
     * @brief Copy constructor.
     * @param s Instance of SuppliesPackage. 
     */
    SuppliesPackage(SuppliesPackage s) {
        this.ammoPower   = s.ammoPower;
        this.fuelUnits   = s.fuelUnits;
        this.shieldPower = s.shieldPower;
    }
    
    // Get methods
    
    /** 
     * @brief Get method. 
     * @return Armament power. 
     */
    float getAmmoPower() {
        return this.ammoPower;
    }
    
    /** 
     * @brief Get method. 
     * @return Fuel units. 
     */
    float getFuelUnits() {
        return this.fuelUnits;
    }
    
    /** 
     * @brief Get method. 
     * @return Shield power. 
     */
    float getShieldPower() {
        return this.shieldPower;
    }

    public String toString() {
        String data = "";

        data += "[ammPower: " + this.ammoPower + ", fuelUnits: " + this.fuelUnits + ", shieldPower: " + this.shieldPower + "]";

        return data;
    }
    
    /*
    public static void main(String[] args) {
        SuppliesPackage s = new SuppliesPackage(10f, 1.2f,8f);
        float fuel = s.getFuelUnits();
        System.out.println("Probemos a modificar el fuel: " + fuel);
        fuel = fuel - 100;
        System.out.println("Nuevo estado de la variable: " + fuel );
        System.out.println("Estado de fuel en el obejtos: " + s.getFuelUnits());
        // Los tipos primitivos no pasan las referencias sino las copias.
    }
    */
}


