package deepspace;

/**
 * @brief DEEPSPACE (Java). 
 * Practise 1 test
 * @author Mario Megías Mateo and Shao Jie Hu Chen.
 */
public class TestP1 {
    public static void main(String[] args) {
        
        // Statements
        
        Loot loot = new Loot(5,6,7,8,9);
        SuppliesPackage supplies = new SuppliesPackage(1.5f, 10, 2);
        ShieldBooster shiled = new ShieldBooster("resistencia", 2.5f, 5);
        Weapon weapon = new Weapon("pistola", WeaponType.MISSILE, 10);
        Dice dice = new Dice();
        
        // Output
        
        // Information of loot
        
        System.out.println("Attributes of loot:");
        System.out.println("\tNumber of supplies: " + loot.getNSupplies());
        System.out.println("\tNumber of weapons: " + loot.getNWeapons());
        System.out.println("\tNumber of hangars: " + loot.getNHangars());
        System.out.println("\tNumber of medals: " + loot.getNMedals());
        System.out.println("\tNumber of shields: " + loot.getNShields());
        
        // Information of supplies 
        
        System.out.println("Attributes of supplies:");
        System.out.println("\tAmmo Powers: " + supplies.getAmmoPower());
        System.out.println("\tFuel Units: " + supplies.getFuelUnits());
        System.out.println("\tShield Power: " + supplies.getShieldPower());
        
        // Information of shield 
        
        System.out.println("Attributes of shield:");
        System.out.println("\tBoost: " + shiled.getBoost());
        System.out.println("\tUses: " + shiled.getUses());
        System.out.println("\tOutput of useIt(): " + shiled.useIt());
        System.out.println("\tUses after useIt(): " + shiled.getUses());
        
        // Information of weapon
        
        System.out.println("Attributes of weapon:");
        System.out.println("\tType of weapon: " + weapon.getType());
        System.out.println("\tUses: " + weapon.getUses());
        System.out.println("\tPower: " + weapon.power());
        System.out.println("\tOutput of useIt(): " + weapon.useIt());
        System.out.println("\tUses after useIt(): " + weapon.getUses());
        
        // Operations with Dice
        
        int nPlayers = 10, speed = 20;
        int[] possiblePlayer = new int[nPlayers];
        int[] possibleHangars = new int[2];
        int[] possibleShields = new int[2];
        int[] possibleWeapons = new int[3];
        int[] possibleFirstShots = new int[2];
        int[] possibilityOfMove = new int[2];
        
        for (int i = 0; i < 100; i++) {
            
            possibleHangars[dice.initWithNHangars()]++;
            possibleShields[dice.initWithNShields()]++;
            possibleWeapons[dice.initWithNWeapons()-1]++;
            possiblePlayer[dice.whoStarts(nPlayers)]++;
            
            if (dice.firstShot() == GameCharacter.SPACESTATION)
                possibleFirstShots[0]++;
            else
                possibleFirstShots[1]++;
            
            if (dice.spaceStationMoves(speed))
                possibilityOfMove[0]++;
            else
                possibilityOfMove[1]++;
        }
        
        // Output
        
        System.out.println("Information of dice:");
        System.out.println("1. Number of hangars: 0(" + possibleHangars[0] + "), 1(" + possibleHangars[1] + ")");
        System.out.println("2. Number of shileds: 0(" + possibleShields[0] + "), 1(" + possibleShields[1] + ")");
        System.out.println("3. Number of weapons: 1(" + possibleWeapons[0] + "), 2(" + possibleWeapons[1] + "), 3(" + possibleWeapons[2] + ")");
        
        System.out.println("4. Number of the player: ");
        for (int i = 0; i < possiblePlayer.length; i++) {
            System.out.print(i + "(" + possiblePlayer[i] + "), ");
        }
        
        System.out.println();
        System.out.println("5. First shot: SPACESTATION(" + possibleFirstShots[0] + "), ENEMYSTARSHIP(" + possibleFirstShots[1] + ")");
        System.out.println("6. Will the space station move? YES(" + possibilityOfMove[0] + "), NO(" + possibilityOfMove[1] + ")");
    }
}
