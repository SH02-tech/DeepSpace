package deepspace;

import java.util.ArrayList; // import the ArrayList class

public class Damage {
    private int nShields;
    private int nWeapons;
    private ArrayList<WeaponType> weapons;

    Damage(int w, int s) {
        nWeapons = w;
        nShields = s;
        weapons = new ArrayList<WeaponType>();
    }

    Damage(ArrayList<WeaponType> wl, int s) {
        this(wl.size(), s);
        weapons = new ArrayList<WeaponType>(wl);
    }

    Damage(Damage d) {
        this(d.weapons, d.nShields);
    }

    DamageToUI getUIversion() {
        return new DamageToUI(this);
    }

    private int arrayContainsType(ArrayList<Weapon> w, WeaponType t) {
        int pos = -1;
        boolean found = false;

        for (int i=0; i<w.size() && !found; ++i) {
            if (w.get(i).getType() == t) {
                pos = i;
                found = true;
            }
        }

        return pos;
    }

    public Damage adjust(ArrayList<Weapon> w, ShieldBooster[] s) {
        throw new UnsupportedOperationException();
    }

    public void discardWeapon(Weapon w) {
        throw new UnsupportedOperationException();
    }

    public void discardShieldBooster() {
        throw new UnsupportedOperationException();
    }

    public boolean hasNoEffect() {
        throw new UnsupportedOperationException();
    }

    public int getNShields() {
        throw new UnsupportedOperationException();
    }

    public int getNWeapons() {
        throw new UnsupportedOperationException();
    }

    public ArrayList<WeaponType> getWeapons() {
        throw new UnsupportedOperationException();
    }
}
