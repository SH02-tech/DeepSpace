package deepspace;

import java.util.ArrayList;

public class TestP4 {
    
    public static void main(String[] args) {
        
        // Algunas variables que usaremos posteriormente

        Weapon w0 = new Weapon("AR0", WeaponType.LASER, 1);
        Weapon w1 = new Weapon("AR1", WeaponType.LASER, 4);
        Weapon w2 = new Weapon("AR2", WeaponType.MISSILE, 2);

        ShieldBooster s0 = new ShieldBooster("ES0", 1.4f, 3);
        ShieldBooster s1 = new ShieldBooster("ES1", 1.5f, 3);
        ShieldBooster s2 = new ShieldBooster("ES2", 4f, 2);

        ArrayList<Weapon> weapons = new ArrayList<>();
        weapons.add(w0);
        weapons.add(w1);
        weapons.add(w2);
        ArrayList<WeaponType> weaponsTypes = new ArrayList<>();
        weaponsTypes.add(WeaponType.LASER);
        weaponsTypes.add(WeaponType.MISSILE);
        weaponsTypes.add(WeaponType.PLASMA);
        weaponsTypes.add(WeaponType.LASER);

        ArrayList<ShieldBooster> shields = new ArrayList<>();
        shields.add(s0);
        shields.add(s1);
        shields.add(s2);

        System.out.println("=============================================");
        System.out.println("Numeric Damage");
        System.out.println("=============================================");

        NumericDamage d0 = new NumericDamage(0, 0);
        NumericDamage d1 = new NumericDamage(5, 4);

        // Consultamos el estado y comprobamos consultores

        System.out.println("Damage 0...");
        System.out.println(d0.toString());
        System.out.println("Damage 1...");
        System.out.println(d1.toString());
        
        System.out.println("Damage 1...");
        System.out.println("Numero de escudos: " + d1.getNShields());
        System.out.println("Numero de armas: " + d1.getNWeapons());

        // Probando los discards

        d0.discardShieldBooster();
        d0.discardWeapon(w0);
        System.out.println("Damage 0 after discard...");
        System.out.println(d0.toString());

        d1.discardShieldBooster();
        d1.discardWeapon(w0);
        System.out.println("Damage 1 after discard...");
        System.out.println(d1.toString());

        // Probando los metodos copy

        System.out.println("Copy of Damage 0...");
        System.out.println(d0.copy().toString());
        System.out.println("Copy of Damage 1...");
        System.out.println(d1.copy().toString());
        
        // Probando adjust

        System.out.println("Damage 0 in adjust...");
        System.out.println(d0.adjust(weapons, shields).toString());
        System.out.println("Damage 1 in adjust...");
        System.out.println(d1.adjust(weapons, shields).toString());

        System.out.println("=============================================");
        System.out.println("Specific Damage");
        System.out.println("=============================================");

        SpecificDamage d2 = new SpecificDamage(null, 0);
        SpecificDamage d3 = new SpecificDamage(weaponsTypes, 4);

        // Consultamos el estado y comprobamos consultores

        System.out.println("Damage 2...");
        System.out.println(d2.toString());
        System.out.println("Damage 3...");
        System.out.println(d3.toString());
        
        System.out.println("Damage 3...");
        System.out.println("Numero de escudos: " + d3.getNShields());
        System.out.println("Armas: " + d3.getWeapons().toString());

        // Probando los discards

        d2.discardShieldBooster();
        d2.discardWeapon(w0);
        System.out.println("Damage 2 after discard...");
        System.out.println(d2.toString());

        d3.discardShieldBooster();
        d3.discardWeapon(w0);
        System.out.println("Damage 3 after discard...");
        System.out.println(d3.toString());

        // Probando los metodos copy

        System.out.println("Copy of Damage 2...");
        System.out.println(d2.copy().toString());
        System.out.println("Copy of Damage 3...");
        System.out.println(d3.copy().toString());
        
        // Probando adjust

        System.out.println("Damage 2 in adjust...");
        System.out.println(d2.adjust(weapons, shields).toString());
        System.out.println("Damage 3 in adjust...");
        System.out.println(d3.adjust(weapons, shields).toString());

        System.out.println("=============================================");
        System.out.println("SpaceStation");
        System.out.println("=============================================");

        // Simpelemente comprobaremos el constructor de copia y los metodos 
        // redefinidos

        SuppliesPackage supplies1 = new SuppliesPackage(5,10,10.5f);
        Loot l1 = new Loot(10, 5, 5, 5, 5, true, true);
        SpaceStation station1 = new SpaceStation("Station_1", supplies1);

        SpaceStation station0 = new SpaceStation(station1);

        System.out.println("SpaceStation 1...");
        System.out.println(station1.toString());
        System.out.println("Copia de SpaceStation 1...");
        System.out.println(station0.toString());
        System.out.println("Fire: " + station1.fire());
        System.out.println("Protection: " + station1.protection());
        System.out.println("Receive Shot: " + station1.receiveShot(10));
        System.out.println("Set loot: " + station1.setLoot(l1));
        System.out.println("SpaceStation 1 after setLoot...");
        System.out.println(station1.toString());

        System.out.println("=============================================");
        System.out.println("SpaceCity");
        System.out.println("=============================================");
        
        Loot l2 = new Loot(10, 5, 5, 5, 5, false, true);

        SpaceStation station2 = new SpaceStation("station2", supplies1);
        SpaceStation station3 = new SpaceStation("station3", supplies1);

        ArrayList<SpaceStation> stations = new ArrayList<>();
        stations.add(station1);
        stations.add(station2);
        stations.add(station3);

        SpaceCity city = new SpaceCity(station0, stations);


        System.out.println("Collaborators: " + city.getCollaborators());
        System.out.println("Fire: " + city.fire());
        System.out.println("Protection: " + city.protection());
        System.out.println("Set loot: " + city.setLoot(l2));
        
        System.out.println("=============================================");
        System.out.println("Efficient SpaceStations");
        System.out.println("=============================================");
        
        PowerEfficientSpaceStation estation2 = new PowerEfficientSpaceStation(station2);
        
        System.out.println("Fire: " + estation2.fire());
        System.out.println("Protection: " + estation2.protection());
        System.out.println("SetLoot: " + estation2.setLoot(l1));
        
        System.out.println("=============================================");
        System.out.println("Extraefficient SpaceStations");
        System.out.println("=============================================");
        
        BetaPowerEfficientSpaceStation bestation2 = new BetaPowerEfficientSpaceStation(station2);
        
        System.out.println("Fire: " + bestation2.fire());
        System.out.println("Protection: " + bestation2.protection());
        System.out.println("SetLoot: " + bestation2.setLoot(l1));
        
        System.out.println("=============================================");
        System.out.println("GameUniverse");
        System.out.println("=============================================");
        
        GameUniverse gu = new GameUniverse();
        ArrayList<String> names = new ArrayList<>();
        names.add("S1"); names.add("S2"); names.add("S3");
        gu.init(names);
    }
}
