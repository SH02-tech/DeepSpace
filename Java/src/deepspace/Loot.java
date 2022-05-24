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
    private boolean getEfficient;
    private boolean spaceCity;
    
    // Constructor

    /**
     * @brief Constructor
     * @param nsu Supplies of the loot.
     * @param nw Weapons obtained from the loot.
     * @param nsh Number of shields obtained from the loot.
     * @param nh Number of hangars winned.
     * @param nm Number of medals winned.
     * @param ef indicate if there is a conversation to efficient station
     * @param city indicate if there is a conversation to station city
     */
    Loot(int nsu, int nw, int nsh, int nh, int nm, boolean ef, boolean city) {
        nSupplies    = nsu;
        nWeapons     = nw;
        nShields     = nsh;
        nHangars     = nh;
        nMedals      = nm;
        getEfficient = ef;
        spaceCity    = city;
    }
    
    /**
     * @brief Constructor
     * @param nsu Supplies of the loot.
     * @param nw Weapons obtained from the loot.
     * @param nsh Number of shields obtained from the loot.
     * @param nh Number of hangars winned.
     * @param nm Number of medals winned.
     */
    Loot(int nsu, int nw, int nsh, int nh, int nm) {
        this(nsu, nw, nsh, nh, nm, false, false);
    }
    
    // Get methods

    LootToUI getUIversion() {
        return new LootToUI(this);
    }
    
    /**
     * @brief Get method.
     * @return Number of supplies obtained from loot.
     */
    public int getNSupplies() {
        return nSupplies;
    }
    
    /**
     * @brief Get method.
     * @return Number of weapons obtained from loot.
     */
    public int getNWeapons() {
        return nWeapons;
    }
    
    /**
     * @brief Get method.
     * @return Number of shields obtained from loot. 
     */
    public int getNShields() {
        return nShields;
    }
    
    /** 
     * @brief Get method.
     * @return Number of hangars obtained from loot. 
     */
    
    public int getNHangars() {
        return nHangars;
    }
    
    /** 
     * @brief Get method.
     * @return Number of medals obtained from loot. 
     */
    public int getNMedals() {
        return nMedals;
    }

    /** 
     * @brief Get method.
     * @return if there is a conversion in an efficient spaceStation
     */
    public boolean getEfficient() {
        return getEfficient;
    }

    /** 
     * @brief Get method.
     * @return if there is a conversion in a 
     */
    public boolean spaceCity() {
        return spaceCity;
    }

    public String toString() {
        String data = "";

        data += "[nSupplies: " + nSupplies + ", nWeapons: " + nWeapons + ", nShields: " + nShields;
        data += ", nHangars: " + nHangars + ", nMedals: " + nMedals + ", getEfficient: " + getEfficient;
        data += ", spaceCity: " + spaceCity + "]";

        return data;
    }
}