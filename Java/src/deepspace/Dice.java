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
    Dice() {
        this.NHANGARSPROB = 0.25f;
        this.NSHIELDSPROB = 0.25f;
        this.NWEAPONSPROB = 0.33f;
        this.FIRSTSHOTPROB = 0.5f;
        
        generator = new Random();
    }
    
    public int initWithNHangars() {
        float randomNumber = generator.nextFloat();
        
        if (randomNumber < this.NHANGARSPROB)
            return 0;
        else
            return 1;
    }
    
    public int initWithNWeapons() {
        float randomNumber = generator.nextFloat();
        
        if (randomNumber < this.NWEAPONSPROB)
            return 1;
        else if (this.NWEAPONSPROB < randomNumber && randomNumber < 2*this.NWEAPONSPROB)
            return 2;
        else 
            return 3;
    }
    
    public int initWithNShields() {
        float randomNumber = generator.nextFloat();
        
        if (randomNumber < this.NSHIELDSPROB)
            return 0;
        else
            return 1;
    }
    
    public int whoStarts(int nPlayers) {
        int randomPlayer = generator.nextInt(nPlayers);
        
        return randomPlayer;
    }
    
    public GameCharacter firstShot() {
        float randomNumber = generator.nextFloat();
        
        if (randomNumber < this.FIRSTSHOTPROB) 
            return GameCharacter.SPACESTATION;
        else
            return GameCharacter.ENEMYSTARSHIP;
    }
    
    public boolean spaceStationMoves(float speed) {
        float randomNumber = generator.nextFloat();
        
        return (randomNumber < speed);
    }
}
