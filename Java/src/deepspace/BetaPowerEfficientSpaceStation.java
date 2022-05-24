package deepspace;

/**
 *
 * @author Shao Jie Hu Chen
 * @author Mario Megías Mateo
 */
public class BetaPowerEfficientSpaceStation extends PowerEfficientSpaceStation {
    private static final float EFFICIENCYFACTOR = 1.20f;
    private Dice dice;
    
    public BetaPowerEfficientSpaceStation(SpaceStation station) {
        super(station);
        dice = new Dice();
    }
    
    @Override
    public float fire() {
        float firePower = super.fire();
        
        if (dice.extraEfficiency())
            firePower *= EFFICIENCYFACTOR;
        
        return firePower;
    }
}
