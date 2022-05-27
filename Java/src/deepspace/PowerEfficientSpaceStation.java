package deepspace;

/**
 *
 * @author Shao Jie Hu Chen
 * @author Mario Megías Mateo
 */
public class PowerEfficientSpaceStation extends SpaceStation {
    private static final float EFFICIENCYFACTOR = 1.10f;
    
    public PowerEfficientSpaceStation(SpaceStation station) {
        super(station);
    }
    
    @Override
    public PowerEfficientSpaceStationToUI getUIversion() {
        return new PowerEfficientSpaceStationToUI(this);
    }
    
    @Override
    public float fire() {
        return super.fire()*EFFICIENCYFACTOR;
    }
    
    @Override
    public float protection() {
        return super.fire()*EFFICIENCYFACTOR;
    }
    
    @Override
    public Transformation setLoot(Loot loot) {
        super.setLoot(loot);
        return Transformation.NOTRANSFORM;
    }
}
