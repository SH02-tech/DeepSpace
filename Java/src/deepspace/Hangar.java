/**
 * @brief DEEPSPACE (Java). Hangar
 * This class specifies the characteristics of an Hangar. 
 * 
 * @author Mario Megías Mateo and Shao Jie Hu Chen.
 */

package deepspace;
import java.util.ArrayList;

public class Hangar {
    private int maxElements;

    /**
     * @brief Constructor
     * @param capacity Initial capacity of the plane. 
     */
    Hangar(int capacity) {
        maxElements = capacity;
    }

    Hangar(Hangar one) {
        this.maxElements = one.maxElements;
    }

    // TODO
    public HangarToUI getUIversion() {
        throw new UnsupportedOperationException();
    }

    private boolean spaceAvailable() {
        throw new UnsupportedOperationException();
    }

    public boolean addWeapon(Weapon w) {
        throw new UnsupportedOperationException();
    }

    public boolean addShieldBooster(ShieldBooster s) {
        throw new UnsupportedOperationException();
    }

    public int getMaxElements() {
        return maxElements;
    }

    public int getShieldBoosters() {
        throw new UnsupportedOperationException();
    }

    public ArrayList<Weapon> getWeapons() {
        throw new UnsupportedOperationException();
    }

    public ShieldBooster removeShieldBooster(int s) {
        throw new UnsupportedOperationException();
    }

    public Weapon removeWeapon(int w) {
        throw new UnsupportedOperationException();
    }
}
