package deepspace;
import java.util.ArrayList;

public class SpaceStation {
    private static int MAXFUEL = 100;
    private static float SHIELDLOSSPERUNITSHOT = 0.1f;

    private int ammoPower;
    private float fuelUnits;
    private String name;
    private int nMedals;
    private float shieldPower;
    private Damage pendingDamage;
    private ArrayList<Weapon> weapons;
    private ArrayList<ShieldBooster> shieldBoosters;
    private Hangar hangar;

    // TODO

    private void assignFuelValue(float f) {
        throw new UnsupportedOperationException();
    }

    private void cleanPendingDamage() {
        throw new UnsupportedOperationException();
    }

    SpaceStation(String n, SuppliesPackage supplies) {
        throw new UnsupportedOperationException();
    }

    public void cleanUpMountedItems() {
        throw new UnsupportedOperationException();
    }

    public void discardHangar() {
        throw new UnsupportedOperationException();
    }

    public void discardShieldBooster(int i) {
        throw new UnsupportedOperationException();
    }

    public void discardShieldBoosterInHangar(int i) {
        throw new UnsupportedOperationException();
    }

    public float fire() {
        throw new UnsupportedOperationException();
    }

    public float getAmmoPower() {
        throw new UnsupportedOperationException();
    }

    public float getFuelUnits() {
        throw new UnsupportedOperationException();
    }

    public Hangar getHangar() {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public int getNMedals() {
        throw new UnsupportedOperationException();
    }

    public Damage getPendingDamage() {
        throw new UnsupportedOperationException();
    }

    public ArrayList<ShieldBooster> getShieldBoosters() {
        throw new UnsupportedOperationException();
    }

    public float getShieldPower() {
        throw new UnsupportedOperationException();
    }

    public float getSpeed() {
        throw new UnsupportedOperationException();
    }

    public SpaceStationToUI getUIversion() {
        throw new UnsupportedOperationException();
    }

    public ArrayList<Weapon> getWeapons() {
        throw new UnsupportedOperationException();
    }

    public void mountWeapon(int i) {
        throw new UnsupportedOperationException();
    }

    public void move() {
        throw new UnsupportedOperationException();
    }

    public float protection() {
        throw new UnsupportedOperationException();
    }

    public void receiveHangar(Hangar h) {
        throw new UnsupportedOperationException();
    }

    public boolean receiveShieldBooster(ShieldBooster s) {
        throw new UnsupportedOperationException();
    }

    public ShotResult receiveShot(float shot) {
        throw new UnsupportedOperationException();
    }

    public void receiveSupplies(SuppliesPackage s) {
        throw new UnsupportedOperationException();
    }

    public boolean receiveWeapon(Weapon w) {
        throw new UnsupportedOperationException();
    }

    public void setLoot(Loot loot) {
        throw new UnsupportedOperationException();
    }

    public void setPendingDamage(Damage d) {
        throw new UnsupportedOperationException();
    }

    public boolean validState() {
        throw new UnsupportedOperationException();
    }
}
