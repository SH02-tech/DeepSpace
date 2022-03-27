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

    }
}
