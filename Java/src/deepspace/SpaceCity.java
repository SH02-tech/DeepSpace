package deepspace;

import java.util.ArrayList;

/**
 *
 * @author Mario Megías Mateo and Shao Jie Hu Chen.
 */
public class SpaceCity extends SpaceStation {
    
    // Attributes

    private SpaceStation base;
    private ArrayList<SpaceStation> collaborators;

    // Methods

    // Constructor

    SpaceCity(SpaceStation base, ArrayList<SpaceStation> rest) {
        super(base);
        this.base          = base;
        this.collaborators = new ArrayList<SpaceStation>(rest);
    }

    public ArrayList<SpaceStation> getCollaborators() {
        return new ArrayList<SpaceStation>(collaborators);
    }

    @Override
    public float fire() {
        float totalPower =super.fire();
        for (SpaceStation station : collaborators) {
            totalPower += station.fire();
        }
        return totalPower;
    }

    @Override
    public float protection() {
        float totalProtection = super.protection();
        for (SpaceStation station : collaborators) {
            totalProtection += station.protection();
        }
        return totalProtection;
    }

    @Override
    public Transformation setLoot(Loot loot) {
        super.setLoot(loot);
        return Transformation.NOTRANSFORM;
    }

}
