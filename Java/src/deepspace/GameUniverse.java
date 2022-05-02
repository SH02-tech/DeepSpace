package deepspace;
import java.util.ArrayList;

public class GameUniverse {
    
    // Atributes

    private static final int WIN = 10;
    private static final int INVALIDSTATIONINDEX = -1;
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
        currentStationIndex = INVALIDSTATIONINDEX;
        currentEnemy        = null;
        currentStation      = null;
        spaceStations       = new ArrayList<SpaceStation>();
    }

    CombatResult combat(SpaceStation station, EnemyStarShip enemy) {
        GameCharacter ch = this.dice.firstShot();
        CombatResult combatResult;
        boolean enemyWins;

        if (ch == GameCharacter.ENEMYSTARSHIP) {
            float fire = this.currentEnemy.fire();
            ShotResult result = this.currentStation.receiveShot(fire);

            if (result == ShotResult.RESIST) {
                fire = this.currentStation.fire();
                result = this.currentEnemy.receiveShot(fire);

                enemyWins = (result == ShotResult.RESIST);
            } else {
                enemyWins = true;
            }
        } 
        else {
            float fire = this.currentStation.fire();
            ShotResult result = this.currentEnemy.receiveShot(fire);

            enemyWins = (result == ShotResult.RESIST);
        }

        if (enemyWins) {
            float s = this.currentStation.getSpeed();
            boolean moves = dice.spaceStationMoves(s);

            if (!moves) {
                Damage damage = this.currentEnemy.getDamage();
                this.currentStation.setPendingDamage(damage);

                combatResult = CombatResult.ENEMYWINS;
            } 
            else {
                this.currentStation.move();

                combatResult = CombatResult.STATIONESCAPES;
            }
        } 
        else {
            Loot aLoot = this.currentEnemy.getLoot();
            this.currentStation.setLoot(aLoot);

            combatResult = CombatResult.STATIONWINS;
        }

        this.gameState.next(this.turns, this.spaceStations.size());

        return combatResult;
    }

    public CombatResult combat() {
        GameState state = this.gameState.getState();

        if (state == GameState.BEFORECOMBAT || state == GameState.INIT) {
            return combat(this.currentStation, this.currentEnemy);
        } 
        else {
            return CombatResult.NOCOMBAT;
        }
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
            currentStation.discardWeapon(i);
    }

    public void discardWeaponInHangar(int i) {
        GameState state = getState();
        if (state == GameState.INIT || state == GameState.AFTERCOMBAT)
            currentStation.discardWeaponInHangar(i);
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

    public void init(ArrayList<String> names) {
        GameState state = this.gameState.getState();
        this.spaceStations = new ArrayList<SpaceStation>();

        if (state == GameState.CANNOTPLAY) {
            CardDealer dealer = CardDealer.getInstance();

            for (int i=0; i<names.size(); ++i) {
                SuppliesPackage supplies = dealer.nextSuppliesPackage();
                SpaceStation station = new SpaceStation(names.get(i), supplies);
                
                this.spaceStations.add(station);

                int nh = dice.initWithNHangars();
                int nw = dice.initWithNWeapons();
                int ns = dice.initWithNShields();
                
                Loot lo = new Loot(0, nw, ns, nh, 0);

                this.spaceStations.get(i).setLoot(lo); // Más intuitivo de esta manera.
            }

            this.currentStationIndex = dice.whoStarts(names.size());
            this.currentStation = this.spaceStations.get(this.currentStationIndex);
            this.currentEnemy = dealer.nextEnemy();
            this.gameState.next(this.turns, this.spaceStations.size());
        }
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

    /**
     * @brief This function change the turn of the game.
     * @return True when there's no pending damage. False otherwise. 
     */
    public boolean nextTurn() {
        GameState state = this.gameState.getState();

        if (state == GameState.AFTERCOMBAT) {
            boolean stationState = this.currentStation.validState();

            if (stationState) {
                this.currentStationIndex = (this.currentStationIndex+1)%this.spaceStations.size();
                ++turns;

                this.currentStation = this.spaceStations.get(this.currentStationIndex);
                this.currentStation.cleanUpMountedItems();
                
                CardDealer dealer = CardDealer.getInstance();
                this.currentEnemy = dealer.nextEnemy();
                this.gameState.next(this.turns, this.spaceStations.size());
                return true;
            }

            return false;
        }

        return false;
    }

    public String toString() {
        String s = "[";
        s += "game state: " + this.gameState.getState();
        s += "; dice: " + this.dice.toString();
        s += "; turns: " + this.turns;
        s += "; currentStationIndex: " + this.currentStationIndex;
        
        if (this.currentEnemy != null)
            s += "; currentEnemy: " + this.currentStation.toString();
        else
            s += "; currentEnemy: NULL";
        
        if (this.currentStation != null)
            s += "; currentStation: " + this.currentStation.toString();
        else 
            s += "; currentStation: NULL";

        s += "; spaceStations: " + this.spaceStations.toString(); 
        s += "]";
        return s;
    }
}
