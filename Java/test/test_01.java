/**
 * @brief Programa de prueba para los tipos enumerados.
 * @author Mario Megías Mateo and Shao Jie Hu Shen.
 */
public class test_01 {
    public static void main(String[] args) {
        
        CombatResult cResult = CombatResult.ENEMYWINS;
        GameCharacter gCharacter = GameCharacter.ENEMYSTARSHIP;
        ShotResult sResult = ShotResult.DONOTRESIST;
        WeaponType wType = WeaponType.LASER;
        
        System.out.println(cResult);
        System.out.println(gCharacter);
        System.out.println(sResult);
        System.out.println(wType);
    }
}
