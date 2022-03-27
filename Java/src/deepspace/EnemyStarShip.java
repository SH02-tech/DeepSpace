package deepspace;

public class EnemyStarShip {
    private float ammoPower;
    private String name;
    private float shieldPower;
    private Loot loot;
    private Damage damage;

    EnemyStarShip(String n, float a, float s, Loot l, Damage d) {
        this.ammoPower = a;
        this.name = n;
        this.shieldPower = s;
        this.loot = l; // Not usual.
        this.damage = new Damage(d);
    }

    EnemyStarShip(EnemyStarShip e) {
        this(e.name, e.ammoPower, e.shieldPower, e.loot, e.damage);
    }

    EnemyToUI getUIversion() {
        return new EnemyToUI(this);
    }

    public float fire() {
        return this.getAmmoPower();
    }

    public float getAmmoPower() {
        return this.ammoPower;
    }

    public Damage getDamage() {
        return new Damage(this.damage);
    }

    public Loot getLoot() {
        return this.loot; // Not usual.
    }

    public String getName() {
        return new String(this.name);
    }

    public float getShieldPower() {
        return this.shieldPower;
    }

    public float protection() {
        return this.getShieldPower();
    }

    public ShotResult receiveShot(float shot) {
        if (this.shieldPower < shot) {
            return ShotResult.DONOTRESIST;
        } else {
            return ShotResult.RESIST;
        }
    }
}
