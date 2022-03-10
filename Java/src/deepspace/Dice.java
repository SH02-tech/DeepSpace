/**
 * @brief DEEPSPACE (Java). 
 * Class that represents the supplies package of a space station. 
 * @author Mario Megías Mateo and Shao Jie Hu Chen.
 */
package deepspace;
import java.util.Random;

class Dice {

    // Attributes
    private final float NHANGARSPROB;
    private final float NSHIELDSPROB;
    private final float NWEAPONSPROB;
    private final float FIRSTSHOTPROB;

    private Random generator;
    
    // Constructor
    
    /** 
     * @brief Constructor. Initializes probabilities and random number generator.
     */
    Dice() {
        this.NHANGARSPROB = 0.25f;
        this.NSHIELDSPROB = 0.25f;
        this.NWEAPONSPROB = 0.33f;
        this.FIRSTSHOTPROB = 0.5f;
        
        generator = new Random();
    }
    
    // Initialization methods
    
    /**
     * @brief It sets the number of hangars of a space station at initialization.  
     * @return Number of hangars: 0 or 1. 
     */
    public int initWithNHangars() {
        float randomNumber = generator.nextFloat();
        
        if (randomNumber < this.NHANGARSPROB)
            return 0;
        else
            return 1;
    }
    
    /**
     * @brief It sets the number of weapons of a space station at initialization.  
     * @return Number of weapons: 1, 2 or 3. 
     */
    public int initWithNWeapons() {
        float randomNumber = generator.nextFloat();
        
        if (randomNumber < this.NWEAPONSPROB)
            return 1;
        else if (this.NWEAPONSPROB < randomNumber && randomNumber < 2*this.NWEAPONSPROB)
            return 2;
        else 
            return 3;
    }
    
    /**
     * @brief It sets the number of shields of a space station at initialization.  
     * @return Number of weapons: 0 or 1. 
     */
    public int initWithNShields() {
        float randomNumber = generator.nextFloat();
        
        if (randomNumber < this.NSHIELDSPROB)
            return 0;
        else
            return 1;
    }
    
    /**
     * @brief It sets the first player to start.  
     * @param nPlayers Number of players in the battle. 
     * @return Index that represent a player, between 0 and nPlayers-1.
     */
    public int whoStarts(int nPlayers) {
        int randomPlayer = generator.nextInt(nPlayers);
        
        return randomPlayer;
    }
    
    /** 
     * @brief Method that decides the first space station to start the battle.
     * @return SPACESTATION or ENEMYSTARSHIP. 
     */
    public GameCharacter firstShot() {
        float randomNumber = generator.nextFloat();
        
        if (randomNumber < this.FIRSTSHOTPROB) 
            return GameCharacter.SPACESTATION;
        else
            return GameCharacter.ENEMYSTARSHIP;
    }
    
    // State methods 
    
    /** 
     * @brief This methods determine whether a space station shall be able to avoid a shot. 
     * @param speed Speed of the space station.
     * @pre 0 <= speed and speed < 1
     * @return True if it avoided the shot. Otherwise, false. 
     */
    public boolean spaceStationMoves(float speed) {
        float randomNumber = generator.nextFloat();
        
        return (randomNumber < speed);
    }
}
