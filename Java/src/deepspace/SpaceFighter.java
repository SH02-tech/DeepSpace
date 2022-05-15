package deepspace;

/**
 *
 * @author Mario Megías Mateo and Shao Jie Hu Chen.
 */
interface SpaceFighter {
    
    public float fire();

    public float protection();

    public ShotResult receiveShot(float shot);
    
}
