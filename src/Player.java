/**
 * Class for a Player object.
 * Encapsulates all information about a player:
 * - Hitpoints
 */
public class Player {
    private int hp = 5; // 5 by default

    // Invincibility properties
    private boolean isInvincible = false;
    private long invincibilityStartTime = 0;
    private static final long INVINICIBILITY_DURATION = 1500; // 1500 ms --> 1.5 seconds

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public int getHP(){
        return hp;
    }

    public void setHP(int hp){
        if(!isInvincible()){
            this.hp = hp;
            // Start invincibility frames after taking damage
            isInvincible = true;
            invincibilityStartTime = System.currentTimeMillis();
        }
    }

    public boolean isInvincible(){
        if(isInvincible){
            long currentTime = System.currentTimeMillis();
            if(currentTime - invincibilityStartTime >= INVINICIBILITY_DURATION){
                isInvincible = false;
            }
        }
        return isInvincible;
    }
}
