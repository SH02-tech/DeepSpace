package deepspace;

public class GameUniverse {
    
    // Atributes

    private static final int WIN = 10;
    private int currentStationIndex;
    private int turns; 
    private GameStateController gameState;
    private Dice dice;
    private EnemyStarShip currentEnemy;
    private SpaceStation spaceStations;
    private SpaceStation SpaceStation;


    // Constructors

    public GameUniverse() {
        throw new UnsupportedOperationException();
    }

    CombatResult combat(SpaceStation station, EnemyStarShip enemy) {
        throw new UnsupportedOperationException();
    }

    public CombatResult combat() {
        throw new UnsupportedOperationException();
    }

    public void discardHangar() {
        throw new UnsupportedOperationException();
    } 

    public void discardShieldBooster(int i) {
        throw new UnsupportedOperationException();
    }

    public void discardShieldBoosterHangar(int i) {
        throw new UnsupportedOperationException();
    }

    public void discardWeapon(int i) {
        throw new UnsupportedOperationException();
    }

    public void discardWeaponInHangar(int i) {
        throw new UnsupportedOperationException();
    }

    public GameState getState() {
        throw new UnsupportedOperationException();
    }

    public bool haveAWinner {
        throw new UnsupportedOperationException();
    }

    public void init(String[] names) {
        throw new UnsupportedOperationException();
    }

    public void mountShieldBooster(int i) {
        throw new UnsupportedOperationException();
    }

    public void mountWeapon(int i) {
        throw new UnsupportedOperationException();
    }

    public boolean nextTurn() {
        throw new UnsupportedOperationException();
    }
}
