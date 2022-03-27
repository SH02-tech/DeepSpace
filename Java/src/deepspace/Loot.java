/**
 * @brief DEEPSPACE (Java). 
 * Class that represents the loot which may be obtained from a battle.
 * @author Mario Megías Mateo and Shao Jie Hu Chen
 */

package deepspace;

class Loot {
    
    // Attributes
    
    private int nSupplies;
    private int nWeapons;
    private int nShields;
    private int nHangars;
    private int nMedals;
    
    // Constructor
    
    /**
     * @brief Constructor
     * @param theSupplies Supplies of the loot.
     * @param theWeapons Weapons obtained from the loot.
     * @param theShields Number of shields obtained from the loot.
     * @param theHangars Number of hangars winned.
     * @param theMedals Number of medals winned.
     */
    Loot(int theSupplies, int theWeapons, int theShields, int theHangars, int theMedals) {
        this.nSupplies = theSupplies;
        this.nWeapons = theWeapons;
        this.nShields = theShields;
        this.nHangars = theHangars;
        this.nMedals = theMedals;
    }
    
    // Get methods

    LootToUI getUIversion() {
        throw new UnsupportedOperationException();
    }
    
    /**
     * @brief Get method.
     * @return Number of supplies obtained from loot.
     */
    public int getNSupplies() {
        return this.nSupplies;
    }
    
    /**
     * @brief Get method.
     * @return Number of weapons obtained from loot.
     */
    public int getNWeapons() {
        return this.nWeapons;
    }
    
    /**
     * @brief Get method.
     * @return Number of shields obtained from loot. 
     */
    public int getNShields() {
        return this.nShields;
    }
    
    /** 
     * @brief Get method.
     * @return Number of hangars obtained from loot. 
     */
    
    public int getNHangars() {
        return this.nHangars;
    }
    
    /** 
     * @brief Get method.
     * @return Number of medals obtained from loot. 
     */
    public int getNMedals() {
        return this.nMedals;
    }
}