package deepspace;
import java.util.ArrayList;

public class TestP2 {
    public static void main(String[] args) {
        Weapon w1 = new Weapon("AR1", WeaponType.LASER, 4);
        Weapon w2 = new Weapon("AR2", WeaponType.MISSILE, 2);

        ShieldBooster s1 = new ShieldBooster("ES1", 1.5f, 3);
        ShieldBooster s2 = new ShieldBooster("ES2", 4f, 2);

        Hangar hangar = new Hangar(4);
        hangar.addShieldBooster(s1);
        hangar.addShieldBooster(s2);
        hangar.addWeapon(w1);
        hangar.addWeapon(w1);

        ArrayList<Weapon> listWeapons = hangar.getWeapons();
        ArrayList<ShieldBooster> listShieldBoosters = hangar.getShieldBoosters();

        System.out.println("\n---------------------------------------------");
        System.out.println("STAGE 1");
        System.out.println("---------------------------------------------");

        System.out.println("Hangar:");
        System.out.println(hangar.toString());

        System.out.println("Array of Weapons:");
        System.out.println(listWeapons.toString());

        System.out.println("Array of ShieldBoosters:");
        System.out.println(listShieldBoosters.toString());

        System.out.println("\n---------------------------------------------");
        System.out.println("STAGE 2");
        System.out.println("---------------------------------------------");

        listWeapons.remove(0);
        hangar.addWeapon(w2);

        System.out.println("Hangar (should not be equal to last one): ");
        System.out.println(hangar.toString());
        System.out.println("List of Weapons: ");
        System.out.print(listWeapons.toString());

        System.out.println("\n---------------------------------------------");
        System.out.println("STAGE 3");
        System.out.println("---------------------------------------------");

        Weapon removedWeapon = hangar.removeWeapon(1);
        hangar.addShieldBooster(s1);
        
        System.out.println("Hangar (weapon should not be equal to last one): ");
        System.out.println(hangar.toString());

        System.out.println("Removed weapon: " + removedWeapon.toString());

        System.out.println("\n---------------------------------------------");
        System.out.println("STAGE 4");
        System.out.println("---------------------------------------------");

        int maxElements = hangar.getMaxElements();
        maxElements = 3;

        System.out.println("Hangar (should be equal to last one): ");
        System.out.println(hangar.toString());


        System.out.println("=============================================");
        System.out.println("DAMAGE 1");
        System.out.println("=============================================");

        Damage dam = new Damage(4,3);

        System.out.println("ArrayContains: " + dam.toString());
        System.out.println("ArrayContains (number should be equal): " + dam.getNShields() + " " + dam.getNWeapons());

        Damage copy = new Damage(dam);

        System.out.println("Copy Damage: " + copy.toString());

        ArrayList<Weapon> arr_w = new ArrayList<Weapon>();
        arr_w.add(w1);
        arr_w.add(w2);
        
        ArrayList<ShieldBooster> arr_s = new ArrayList<ShieldBooster>();
        arr_s.add(s1);
        arr_s.add(s2);

        Damage new_damage = dam.adjust(arr_w, arr_s);
        System.out.println("Adjusted damage: " + new_damage.toString());

        new_damage.discardWeapon(w1);
        new_damage.discardWeapon(w2);
        new_damage.discardShieldBooster();

        System.out.println("New damage with discards: " + new_damage.toString());
        
        if (new_damage.hasNoEffect()) {
            System.out.println("No effect (as expected).");
        }

        System.out.println("=============================================");
        System.out.println("DAMAGE 2");
        System.out.println("=============================================");

        ArrayList<WeaponType> arr_wt = new ArrayList<WeaponType>();

        arr_wt.add(WeaponType.LASER);
        arr_wt.add(WeaponType.LASER);
        arr_wt.add(WeaponType.LASER);

        arr_wt.add(WeaponType.MISSILE);

        arr_wt.add(WeaponType.PLASMA);
        arr_wt.add(WeaponType.PLASMA);


        Damage dam2 = new Damage(arr_wt,3);

        System.out.println("ArrayContains: " + dam2.toString());
        System.out.println("ArrayContains (nweapons should be -1): " + dam2.getNShields() + " " + dam2.getNWeapons());

        Damage copy2 = new Damage(dam2);

        System.out.println("Copy Damage: " + copy2.toString());

        Damage new_damage_2 = dam2.adjust(arr_w, arr_s);

        // TODO: Neccesary toString in arr_w?
        // System.out.println("Adjust weapons: " + arr_w.toString());
        System.out.println("Adjusted damage: " + new_damage_2.toString());

        new_damage_2.discardWeapon(w1);
        new_damage_2.discardWeapon(w2);
        new_damage_2.discardShieldBooster();

        System.out.println("New damage with discards: " + new_damage_2.toString());
        
        if (new_damage_2.hasNoEffect()) {
            System.out.println("No effect (as expected).");
        }

        System.out.println("=============================================");
        System.out.println("EnemyStarShip");
        System.out.println("=============================================");

        Loot l = new Loot(10, 5, 5, 5, 5);
        Damage d = new Damage(2,3);

        EnemyStarShip ess = new EnemyStarShip("Diógenes", 4, 3, l, d);

        System.out.println("ToString: " + ess.toString());
        System.out.println("Fire: " + ess.fire());
        System.out.println("AmmoPower: " + ess.getAmmoPower());
        System.out.println("Damage: " + ess.getDamage().toString());
        System.out.println("Loot: " + ess.getLoot().toString());
        System.out.println("Name: " + ess.getName());
        System.out.println("ShieldPower: " + ess.getShieldPower());
        System.out.println("Protection: " + ess.protection());

        ShotResult ess_shot = ess.receiveShot(2);
        System.out.println("ShotResult: " + ess_shot.toString());

        EnemyStarShip ess_copy = new EnemyStarShip(ess);
        System.out.println("Copy: " + ess_copy.toString());

        ShotResult sr_not = ess_copy.receiveShot(50);
        System.out.println(sr_not);

        System.out.println("=============================================");
        System.out.println("SpaceSatation");
        System.out.println("=============================================");

        // Construiremos el objeto, probaremos los getters, discards, mount
        // receive

        Weapon w3 = new Weapon("AR3", WeaponType.LASER, 4);
        Weapon w4 = new Weapon("AR4", WeaponType.MISSILE, 2);

        ShieldBooster s3 = new ShieldBooster("ES3", 1.5f, 3);
        ShieldBooster s4 = new ShieldBooster("ES4", 4f, 2);

        SuppliesPackage supplies = new SuppliesPackage(5,10,10.5f);
        Hangar hangar2 = new Hangar(10);
        SpaceStation station1 = new SpaceStation("Estación_1", supplies);

        System.out.println("Space station 1: " + station1.toString());
        station1.receiveHangar(hangar2);
        System.out.println("Space station 1: " + station1.toString());
        station1.receiveShieldBooster(s3);
        station1.receiveShieldBooster(s4);
        station1.receiveWeapon(w3);
        station1.receiveWeapon(w4);
        System.out.println("Testing the getters methods: ");
        System.out.println("Ammo Power: " + station1.getAmmoPower());
        System.out.println("Fuel Units: " + station1.getFuelUnits());
        System.out.println("Hangar: " + station1.getHangar().toString());
        System.out.println("Name: " + station1.getName());
        System.out.println("N medals: " + station1.getNMedals());
        System.out.println("Pending damage: " + station1.getPendingDamage().toString());
        System.out.println("Shield Booosters: " + station1.getShieldBoosters().toString());
        System.out.println("Shield power: " + station1.getShieldPower());
        System.out.println("Speed: " + station1.getSpeed());
        System.out.println("Weapons: " + station1.getWeapons().toString());
        System.out.println("Trying to modified some atributes to see if the object state changes...");
        float ammo = station1.getAmmoPower();
        ammo = -10000f;
        System.out.println("Space station 1: " + station1.toString());

        
        




    }
}
