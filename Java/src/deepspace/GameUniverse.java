package deepspace;
import java.util.ArrayList;

public class GameUniverse {
    
    // Atributes

    private static final int WIN = 10;
    private int turns; 
    private GameStateController gameState;
    private Dice dice;
    private EnemyStarShip currentEnemy;
    private int currentStationIndex;
    private ArrayList<SpaceStation> spaceStations;
    private SpaceStation currentStation;

    // Constructors

    public GameUniverse() {
        gameState           = new GameStateController();
        dice                = new Dice();
        turns               = 0;
        currentStationIndex = -1;
        currentEnemy        = null;
        currentStation      = null;
        spaceStations       = null;
    }

    CombatResult combat(SpaceStation station, EnemyStarShip enemy) {
        throw new UnsupportedOperationException();
    }

    public CombatResult combat() {
        throw new UnsupportedOperationException();
    }

    public void discardHangar() {
        GameState state = getState();
        if (state == GameState.INIT || state == GameState.AFTERCOMBAT)
            currentStation.discardHangar();
    } 

    public void discardShieldBooster(int i) {
        GameState state = getState();
        if (state == GameState.INIT || state == GameState.AFTERCOMBAT)
            currentStation.discardShieldBooster(i);
    }

    public void discardShieldBoosterInHangar(int i) {
        GameState state = getState();
        if (state == GameState.INIT || state == GameState.AFTERCOMBAT)
            currentStation.discardShieldBoosterInHangar(i);
    }

    public void discardWeapon(int i) {
        GameState state = getState();
        if (state == GameState.INIT || state == GameState.AFTERCOMBAT)
            currentStation.discardShieldBooster(i);
    }

    public void discardWeaponInHangar(int i) {
        GameState state = getState();
        if (state == GameState.INIT || state == GameState.AFTERCOMBAT)
            currentStation.discardWeapon(i);;
    }

    public GameState getState() {
        return gameState.getState();
    }

    public GameUniverseToUI getUIversion() {
        return new GameUniverseToUI(currentStation, currentEnemy);
    }

    public boolean haveAWinner() {
        return currentStation.getNMedals() >= WIN;
    }

    public void init(ArrayList<String> names) { //P3
        throw new UnsupportedOperationException();
    }

    public void mountShieldBooster(int i) { 
        GameState state = getState();
        if (state == GameState.INIT || state == GameState.AFTERCOMBAT)
            currentStation.mountShieldBooster(i);
    }

    public void mountWeapon(int i) {
        GameState state = getState();
        if (state == GameState.INIT || state == GameState.AFTERCOMBAT)
            currentStation.mountWeapon(i);
    }

    public boolean nextTurn() { // P3
        throw new UnsupportedOperationException();
    }

    public String toString() {
        String s = "[";
        s += "game state: " + this.gameState.getState();
        s += "current station index: " + this.currentStationIndex;
        s += "current station: " + this.currentStation.toString();
        s += "current enemy: " + this.currentEnemy.toString();
        for (SpaceStation spaceStation : spaceStations) {
            s += spaceStation.toString();
        }
        s += "]";
        return s;
    }
}
