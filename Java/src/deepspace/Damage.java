package deepspace;

import java.util.ArrayList; // import the ArrayList class

public class Damage {
    private int nShields;
    private int nWeapons;

    Damage(int w, int s) {
        nWeapons = w;
        nShields = s;
    }

    Damage(ArrayList<WeaponType> wl, int s) {
        this(wl.size(), s);
    }

    Damage(Damage d) {
        this(d.getNShields(), d.getNWeapons());
    }

    DamageToUI getUIversion() {
        throw new UnsupportedOperationException();
    }

    private int arrayContainsType(ArrayList<Weapon> w, WeaponType t) {
        throw new UnsupportedOperationException();
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
