package deepspace;

/**
 * File: TestP3.java
 * Description: Test file to check the performance of the third practice
 */
public class TestP3 {
    public static void main(String[] args) {
        
        // SpaceStation
        // Checking fire, protection, receiveShot, setLoot, discardWeapon and
        // DiscardShieldBooster
        
        System.out.println("=============================================");
        System.out.println("SpaceStation");
        System.out.println("=============================================");
        
        SuppliesPackage supplies1 = new SuppliesPackage(5,10,10.5f);;
        Loot l1 = new Loot(10, 5, 5, 5, 5);
        SpaceStation station1 = new SpaceStation("Station_1", supplies1);
        
        System.out.println("----> Station1 before setLoot: ");
        System.out.println(station1.toString());

        station1.setLoot(l1);
        
        System.out.println("----> Station1 after setLoot: ");
        System.out.println(station1.toString());
        
        System.out.println("Fire: " + station1.fire());
        System.out.println("Power of protection: " + station1.protection());
        System.out.println("Receive shot: " + station1.receiveShot(10));
        
        System.out.println("Mounting items from the hangar...");
        
        // It could not appear these weapons and shiedls in the hangar, 
        // all depends on CardDealer
        
        station1.mountWeapon(0);
        station1.mountWeapon(1);
        station1.mountWeapon(2);
        station1.mountShieldBooster(0);
        station1.mountShieldBooster(1);
        
        System.out.println("----> Station1 after Mount: ");
        System.out.println(station1.toString());
        
        System.out.println("Fire: " + station1.fire());
        System.out.println("Power of protection: " + station1.protection());
        System.out.println("Receive shot: " + station1.receiveShot(10));
        
        // Testing discards with another instance
        
        Weapon w1 = new Weapon("AR1", WeaponType.LASER, 4);
        Weapon w2 = new Weapon("AR2", WeaponType.MISSILE, 2);
        ShieldBooster s1 = new ShieldBooster("ES1", 1.5f, 3);
        
        SuppliesPackage supplies2 = new SuppliesPackage(4,14,27.4f);
        
        Hangar hangar2 = new Hangar(5);
        hangar2.addWeapon(w1);
        hangar2.addWeapon(w2);
        hangar2.addShieldBooster(s1);
        
        SpaceStation station2 = new SpaceStation("Estación_2", supplies2);
        station2.receiveHangar(hangar2);
        station2.mountWeapon(0);
        station2.mountWeapon(0);
        station2.mountShieldBooster(0);
        
        System.out.println("----> Station2 after Mount: ");
        System.out.println(station2.toString());
        
        station2.discardWeapon(0);
        station2.discardWeapon(0);
        station2.discardWeapon(0);
        station2.discardShieldBooster(0);
        station2.discardShieldBooster(0);
        
        System.out.println("----> Station2 after discard: ");
        System.out.println(station2.toString());
    }
}