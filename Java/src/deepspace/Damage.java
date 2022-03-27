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
        this(-1, s); // -1 denotes that an array list is used. 
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

    public Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s) {
        Damage newDamage = new Damage(this);

        newDamage.nShields -= Math.min(s.size(), newDamage.nShields);

        if (newDamage.nWeapons < 0) {     // Array Case
            for (WeaponType weapon : newDamage.weapons) {
                int pos = this.arrayContainsType(w, weapon);

                if (pos >= 0) {
                    w.remove(pos);
                    newDamage.weapons.remove(weapon);
                    --newDamage.nWeapons;
                }
            }
        } else {                        // Numeric Case
            newDamage.nWeapons -= Math.min(w.size(), newDamage.nWeapons);
        }

        return newDamage;
    }

    // TODO: Use of arrayContains?

    public void discardWeapon(Weapon w) {
        throw new UnsupportedOperationException();
    }

    public void discardShieldBooster() {
        if (this.nShields > 0) {
            --this.nShields;
        }
    }

    public boolean hasNoEffect() {
        return ((this.nWeapons == 0 || this.weapons.isEmpty()) && this.nShields == 0);
    }

    public int getNShields() {
        return this.nShields;
    }

    // TODO: ¿Sólo se llama para uno de los casos? Para ambos métodos. 

    public int getNWeapons() {
        if (this.nWeapons < 0)
            return this.weapons.size();
        else
            return this.nWeapons;
    }

    public ArrayList<WeaponType> getWeapons() {
        return new ArrayList<WeaponType>(this.weapons);
    }
}
