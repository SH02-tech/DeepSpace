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
    private ArrayList<Weapon> weapons;
    private ArrayList<ShieldBooster> shieldBoosters;

    /**
     * @brief Constructor
     * @param capacity Initial capacity of the plane. 
     */
    Hangar(int capacity) {
        maxElements = capacity;
        weapons = new ArrayList<Weapon>();
        shieldBoosters = new ArrayList<ShieldBooster>();
    }

    Hangar(Hangar one) {
        this.maxElements = one.maxElements;
        this.weapons = new ArrayList<Weapon>(one.weapons);
        this.shieldBoosters = new ArrayList<ShieldBooster>(one.shieldBoosters);
    }

    public HangarToUI getUIversion() {
        return new HangarToUI(this);
    }

    private boolean spaceAvailable() {
        return (this.weapons.size() + this.shieldBoosters.size()) < this.maxElements;
    }

    public boolean addWeapon(Weapon w) {
        if (this.spaceAvailable()) {
            this.weapons.add(new Weapon(w));
            return true;
        } else {
            return false;
        }
    }

    public boolean addShieldBooster(ShieldBooster s) {
        if (this.spaceAvailable()) {
            this.shieldBoosters.add(new ShieldBooster(s));
            return true;
        } else {
            return false;
        }
    }

    public int getMaxElements() {
        return this.maxElements;
    }

    public ArrayList<ShieldBooster> getShieldBoosters() {
        return new ArrayList<ShieldBooster>(this.shieldBoosters);
    }

    public ArrayList<Weapon> getWeapons() {
        return new ArrayList<Weapon>(this.weapons);
    }

    public ShieldBooster removeShieldBooster(int s) {
        if (0 <= s && s < this.shieldBoosters.size()) {
            ShieldBooster removedShieldBooster = new ShieldBooster(this.shieldBoosters.get(s));
            this.shieldBoosters.remove(s);

            return removedShieldBooster;
        } else {
            return null;
        }
    }

    public Weapon removeWeapon(int w) {
        if (0 <= w && w < this.weapons.size()) {
            Weapon removedWeapon = new Weapon(this.weapons.get(w));
            this.weapons.remove(w);

            return removedWeapon;
        } else {
            return null;
        }
    }

    public String toString() {
        String data = "";

        data += "Max Elements: " + this.maxElements + "\n";
        data += "Weapons: " + this.weapons.toString() + "\n";
        data += "ShieldBoosters: " + this.shieldBoosters.toString() + "\n";

        return data;
    }
}
