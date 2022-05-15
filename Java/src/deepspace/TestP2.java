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

        w2.useIt();

        System.out.println("Hangar (should be equal to last one) after using weapon: ");
        System.out.println(hangar.toString());

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

        // Damage dam = new Damage(4,3);

        // System.out.println("Damage: " + dam.toString());
        // System.out.println("ArrayContains (number should be equal): " + dam.getNShields() + " " + dam.getNWeapons());

        // Damage copy = new Damage(dam);

        // System.out.println("Copy Damage: " + copy.toString());

        // ArrayList<Weapon> arr_w = new ArrayList<Weapon>();
        // arr_w.add(w1);
        // arr_w.add(w2);
        // arr_w.add(w2);
        
        // ArrayList<ShieldBooster> arr_s = new ArrayList<ShieldBooster>();
        // arr_s.add(s1);
        // arr_s.add(s2);

        // Damage new_damage = dam.adjust(arr_w, arr_s);
        // System.out.println("Adjusted damage: " + new_damage.toString());

        // new_damage.discardWeapon(w1);
        // new_damage.discardWeapon(w2);
        // new_damage.discardShieldBooster();
        // new_damage.discardShieldBooster();

        // System.out.println("Copy damage (not modified): " + copy.toString());
        // System.out.println("Old damage (should be equal): " + dam.toString());
        // System.out.println("New damage with discards: " + new_damage.toString());
        
        // if (new_damage.hasNoEffect()) {
        //     System.out.println("No effect (as expected).");
        // }

        // System.out.println("=============================================");
        // System.out.println("DAMAGE 2");
        // System.out.println("=============================================");

        // ArrayList<WeaponType> arr_wt = new ArrayList<WeaponType>();

        // arr_wt.add(WeaponType.LASER);
        // arr_wt.add(WeaponType.LASER);
        // arr_wt.add(WeaponType.LASER);

        // arr_wt.add(WeaponType.MISSILE);

        // arr_wt.add(WeaponType.PLASMA);
        // arr_wt.add(WeaponType.PLASMA);


        // Damage dam2 = new Damage(arr_wt,3);

        // System.out.println("ArrayContains: " + dam2.toString());
        // System.out.println("ArrayContains (nweapons should be -1): " + dam2.getNShields() + " " + dam2.getNWeapons());

        // Damage copy2 = new Damage(dam2);

        // Damage new_damage_2 = dam2.adjust(arr_w, arr_s);

        // // TODO: Neccesary toString in arr_w?
        // System.out.println("Copy Damage: " + copy2.toString());
        // System.out.println("Adjust weapons: " + arr_w.toString());
        // System.out.println("Adjusted damage: " + new_damage_2.toString());

        // new_damage_2.discardWeapon(w1);
        // new_damage_2.discardWeapon(w2);
        // new_damage_2.discardShieldBooster();
        // new_damage_2.discardShieldBooster();

        // System.out.println("Old damage (should be equal): " + dam2.toString());
        // System.out.println("New damage with discards: " + new_damage_2.toString());
        
        // if (new_damage_2.hasNoEffect()) {
        //     System.out.println("No effect (as expected).");
        // }

        // System.out.println("=============================================");
        // System.out.println("EnemyStarShip");
        // System.out.println("=============================================");

        // Loot l = new Loot(10, 5, 5, 5, 5);
        // Damage d = new Damage(2,3);

        // EnemyStarShip ess = new EnemyStarShip("Diógenes", 4, 3, l, d);

        // System.out.println("ToString: " + ess.toString());
        // System.out.println("Fire: " + ess.fire());
        // System.out.println("AmmoPower: " + ess.getAmmoPower());
        // System.out.println("Damage: " + ess.getDamage().toString());
        // System.out.println("Loot: " + ess.getLoot().toString());
        // System.out.println("Name: " + ess.getName());
        // System.out.println("ShieldPower: " + ess.getShieldPower());
        // System.out.println("Protection: " + ess.protection());

        // ShotResult ess_shot = ess.receiveShot(2);
        // System.out.println("ShotResult: " + ess_shot.toString());

        // EnemyStarShip ess_copy = new EnemyStarShip(ess);
        // System.out.println("Copy: " + ess_copy.toString());

        // ShotResult sr_not = ess_copy.receiveShot(50);
        // System.out.println(sr_not);

        // System.out.println("=============================================");
        // System.out.println("SpaceStation");
        // System.out.println("=============================================");

        // // La prueba consistirá:
        // // 1. Crear varias instancias de SpaceStation
        // // 2. Comprobar que funcionan los receive y seters
        // // 3. Hacer cambios en los parametros reales y comprobar si se modifica
        // //  el estado interno del objeto
        // // 4. Comprobar que funcionan los getters
        // // 5. Escoger una instancia, y comprobar que los elementos obtenidos
        // //  usando los getters no modifican el estado interno del objeto.
        // // 6. Comprobar el funcionamiento del resto de métodos de la práctica 2
        
        // SuppliesPackage supplies1 = new SuppliesPackage(5,10,10.5f);
        // SuppliesPackage supplies2 = new SuppliesPackage(4,14,27.4f);
        // SuppliesPackage supplies3 = new SuppliesPackage(1,2,9.8f);
        // SuppliesPackage supplies4 = new SuppliesPackage(0,0,0f);
        
        // w1 = new Weapon("AR1", WeaponType.LASER, 4);
        // w2 = new Weapon("AR2", WeaponType.MISSILE, 2);
        // Weapon w3 = new Weapon("AR3", WeaponType.PLASMA, 0);
        // Weapon w4 = new Weapon("AR4", WeaponType.PLASMA, 0);
        
        // s1 = new ShieldBooster("ES1", 1.5f, 3);
        // s2 = new ShieldBooster("ES2", 4f, 2);
        // ShieldBooster s3 = new ShieldBooster("ES3", 2.8f, 0);
        // ShieldBooster s4 = new ShieldBooster("ES4", 3f, 0);
        
        // Hangar hangar1 = new Hangar(5);
        // Hangar hangar2 = new Hangar(4);
        // hangar1.addShieldBooster(s1);
        // hangar1.addWeapon(w1);
        // hangar2.addShieldBooster(s3);
        // hangar2.addWeapon(w3);

        // Damage d1 = new Damage(4,5);
        // Damage d2 = new Damage(7,8);
        
        // SpaceStation station1 = new SpaceStation("Estación_1", supplies1);
        // SpaceStation station2 = new SpaceStation("Estación_2", supplies2);
        // SpaceStation station3 = new SpaceStation("Estación_3", supplies3);
        // SpaceStation station4 = new SpaceStation("Estación_4", supplies4);
        
        // // receive y set aplicado a station1
        
        // System.out.println("Estacion 1 antes de receive y set: ");
        // System.out.println(station1.toString());
        
        // station1.receiveHangar(hangar1);
        // station1.receiveShieldBooster(s1);
        // station1.receiveWeapon(w1);
        // station1.receiveSupplies(supplies1);
        // station1.setPendingDamage(d1);
        
        // System.out.println("Estacion 1 despues de receive y set: ");
        // System.out.println(station1.toString());
        
        // // Modificmos los elementos anteriores
        
        // hangar1.removeShieldBooster(0);
        // s1.useIt();
        // w1.useIt();
        // supplies1 = new SuppliesPackage(supplies2);
        // d1.discardShieldBooster();
        
        // // Comprobamos el estado del objeto
        
        // System.out.println("Estacion 1 despues de modificaciones en los parametros reales(debe ser la misma que en la anterior): ");
        // System.out.println(station1.toString());
        
        // // Reestablecemos los valores modificados
        
        // hangar1 = new Hangar(5);
        // w1 = new Weapon("AR1", WeaponType.LASER, 4);
        // w2 = new Weapon("AR2", WeaponType.MISSILE, 2);
        // supplies1 = new SuppliesPackage(5,10,10.5f);
        // d1 = new Damage(4,5);
        
        // // Veamos si funcionan los getters. 
        
        // float ammo_power_s1 = station1.getAmmoPower();
        // float fuel_units_s1 = station1.getFuelUnits();
        // Hangar hangar_s1 = station1.getHangar();
        // String name_s1 = station1.getName();
        // int nMedals_s1 = station1.getNMedals();
        // Damage damage_s1 = station1.getPendingDamage();
        // ArrayList<ShieldBooster> shields_s1 = station1.getShieldBoosters();
        // float shield_power_s1 = station1.getShieldPower();
        // float speed_s1 = station1.getSpeed();
        // ArrayList<Weapon> weapon_s1 = station1.getWeapons();
        
//        System.out.println("Elementos devueltos por los getters: ");
//        System.out.println("Ammo power:" + ammo_power_s1);
//        System.out.println("fuel units:" + fuel_units_s1);
//        System.out.println("hangar:" + hangar_s1.toString());
//        System.out.println("Name:" + name_s1);
//        System.out.println("Medals: " + nMedals_s1);
//        System.out.println("Damage: " + damage_s1.toString());
//        System.out.println("Escudos: " + shields_s1.toString());
//        System.out.println("Shield power: " + shield_power_s1);
//        System.out.println("Velocidad: " + speed_s1);
//        System.out.println("Weapons: " + weapon_s1.toString());
        
        // Modifiquemos los objetos devueltos
        
        // ammo_power_s1 = 0f;
        // fuel_units_s1 = 0f;
        // hangar_s1 = null;
        // name_s1 = "";
        // nMedals_s1 = 2000;
        // damage_s1 = null;
        // shields_s1.add(s4);
        // shield_power_s1 = 0f;
        // speed_s1 = 0f;
        // weapon_s1.add(w4);
        
        // // Veamos el estado del objeto
        
        // System.out.println("Estación 1 despues de cambiar los elementos devueltos por los setters: ");
        // System.out.println(station1.toString());
        
        // // Probemos los mount
        
        // station1.mountShieldBooster(0);
        // station1.mountWeapon(0);
        
        // // Veamos el estado del objeto
        
        // System.out.println("Estación 1 despues de mount: ");
        // System.out.println(station1.toString());
        
        // // Probemos los discard de los hangares
        
        // station1.discardShieldBoosterInHangar(0);
        // station1.discardWeaponInHangar(0);
        
        // // Veamos el estado del objeto
        
        // System.out.println("Estación 1 despues de discardInHangar: ");
        // System.out.println(station1.toString());
        
        // // Por ultimo porbamos cleanUpMountedItems en station 1 y 2
        
        // station1.cleanUpMountedItems();
        // System.out.println("Estación 1 despues de cleanUp: ");
        // System.out.println(station1.toString());
        
        // System.out.println("Estacion 2: ");
        // System.out.println(station2.toString());
        
        // station2.receiveHangar(hangar2);
        // station2.mountShieldBooster(0);
        // station2.mountWeapon(0);
        
        // System.out.println("Estacion 2 despues de añadir: ");
        // System.out.println(station2.toString());
        
        // station2.cleanUpMountedItems();
        
        // System.out.println("Estacion 2 despues de cleanUp: ");
        // System.out.println(station2.toString());
        
    }
}
