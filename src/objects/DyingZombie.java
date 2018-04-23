package objects;

import main.AnimatedGameObject;
import main.Animation;
import main.Game;
import main.Texture;
import main.Utils;

public class DyingZombie extends AnimatedGameObject {
    
    public static final float ANIM_LENGTH = 0.5f;
    public static final int TICK_LIFE_LENGTH = (int)(Utils.FPS * ANIM_LENGTH);
    
    private int currTick;
    
    public static final Texture[] TEXTURES = {
        Utils.ZOMBIE_SHEET.getTexture(0, 4), Utils.ZOMBIE_SHEET.getTexture(1, 4), Utils.ZOMBIE_SHEET.getTexture(2, 4),
        Utils.ZOMBIE_SHEET.getTexture(3, 4), Utils.ZOMBIE_SHEET.getTexture(4, 4), Utils.ZOMBIE_SHEET.getTexture(5, 4),
        Utils.ZOMBIE_SHEET.getTexture(6, 4)
    };
    
    public DyingZombie(float x, float y, String id, Animation animation) {
        super(x, y, 0, 0, 0, 0, Zombie.ZOMBIE_WIDTH, Zombie.ZOMBIE_HEIGHT, id, animation);
        
        currTick = 0;
    }
    
    @Override
    public void update() {
        currTick++;
        
        if(currTick >= TICK_LIFE_LENGTH) {
            Game.removeObjectFromScene("game", this);
        }
    }
    
}
