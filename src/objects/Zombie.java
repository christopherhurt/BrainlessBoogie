package objects;

import java.awt.Dimension;
import java.awt.Point;
import main.AnimatedGameObject;
import main.Animation;
import main.Game;
import main.Texture;
import main.Utils;

public class Zombie extends AnimatedGameObject {
    
    public static final float ZOMBIE_WIDTH = 0.1f;
    public static final float ZOMBIE_HEIGHT = 0.1f;
    
    private static final float ZOMBIE_SPEED = 0.002f;
    private static final float ANIM_LENGTH = 0.7f;
    private static final float RELATIVE_HEAD_SIZE = 0.3f;
    
    private static final Texture[] RIGHT_TEXTURES = {
        Utils.ZOMBIE_SHEET.getTexture(0, 0), Utils.ZOMBIE_SHEET.getTexture(1, 0), Utils.ZOMBIE_SHEET.getTexture(2, 0),
        Utils.ZOMBIE_SHEET.getTexture(3, 0), Utils.ZOMBIE_SHEET.getTexture(4, 0), Utils.ZOMBIE_SHEET.getTexture(5, 0)
    };
    private static final Texture[] LEFT_TEXTURES = {
        Utils.ZOMBIE_SHEET.getTexture(0, 1), Utils.ZOMBIE_SHEET.getTexture(1, 1), Utils.ZOMBIE_SHEET.getTexture(2, 1),
        Utils.ZOMBIE_SHEET.getTexture(3, 1), Utils.ZOMBIE_SHEET.getTexture(4, 1), Utils.ZOMBIE_SHEET.getTexture(5, 1)
    };
    private static final Texture[] DOWN_TEXTURES = {
        Utils.ZOMBIE_SHEET.getTexture(0, 2), Utils.ZOMBIE_SHEET.getTexture(1, 2), Utils.ZOMBIE_SHEET.getTexture(2, 2),
        Utils.ZOMBIE_SHEET.getTexture(3, 2), Utils.ZOMBIE_SHEET.getTexture(4, 2), Utils.ZOMBIE_SHEET.getTexture(5, 2)
    };
    private static final Texture[] UP_TEXTURES = {
        Utils.ZOMBIE_SHEET.getTexture(0, 3), Utils.ZOMBIE_SHEET.getTexture(1, 3), Utils.ZOMBIE_SHEET.getTexture(2, 3),
        Utils.ZOMBIE_SHEET.getTexture(3, 3), Utils.ZOMBIE_SHEET.getTexture(4, 3), Utils.ZOMBIE_SHEET.getTexture(5, 3)
    };
    
    private static final int TOP = 0;
    private static final int RIGHT = 1;
    private static final int BOTTOM = 2;
    private static final int LEFT = 3;
    
    private int side;
    
    public Zombie(String id) {
        super(1, 1, 0, 0, 0, 0, ZOMBIE_WIDTH, ZOMBIE_HEIGHT, id, null);
        
        side = (int)(Math.random() * 4);
        float dist;
        
        switch(side) {
            case TOP:
                dist = (float)(Math.random() * (1 - getWidth() - NotesPanel.PANEL_WIDTH)) + NotesPanel.PANEL_WIDTH;
                setX(dist);
                setY(-getHeight());
                setVelY(ZOMBIE_SPEED);
                Animation downAnim = new Animation(ANIM_LENGTH, DOWN_TEXTURES);
                setAnimation(downAnim);
                break;
            case RIGHT:
                dist = (float)(Math.random() * (1 - getHeight()));
                setX(1);
                setY(dist);
                setVelX(-ZOMBIE_SPEED);
                Animation leftAnim = new Animation(ANIM_LENGTH, LEFT_TEXTURES);
                setAnimation(leftAnim);
                break;
            case BOTTOM:
                dist = (float)(Math.random() * (1 - getWidth() - NotesPanel.PANEL_WIDTH)) + NotesPanel.PANEL_WIDTH;
                setX(dist);
                setY(1);
                setVelY(-ZOMBIE_SPEED);
                Animation upAnim = new Animation(ANIM_LENGTH, UP_TEXTURES);
                setAnimation(upAnim);
                break;
            case LEFT:
                dist = (float)(Math.random() * (1 - getHeight()));
                setX(NotesPanel.PANEL_WIDTH - getWidth());
                setY(dist);
                setVelX(ZOMBIE_SPEED);
                Animation rightAnim = new Animation(ANIM_LENGTH, RIGHT_TEXTURES);
                setAnimation(rightAnim);
                break;
            default:
                System.err.println("Zombie side generated incorrectly");
                System.exit(-1);
        }
    }
    
    public boolean headshot() {
        Point mouseLoc = Game.getMouseLocation();
        Dimension windowSize = Game.getWindowSize();
        
        float mouseX = (float)(mouseLoc.getX() / windowSize.getWidth());
        float mouseY = (float)(mouseLoc.getY() / windowSize.getHeight());
        
        float headWidth = ZOMBIE_WIDTH * RELATIVE_HEAD_SIZE;
        float headHeight = ZOMBIE_HEIGHT * RELATIVE_HEAD_SIZE;
        
        float minX = getX() + (ZOMBIE_WIDTH - headWidth) / 2;
        float maxX = getX() + (ZOMBIE_WIDTH + headWidth) / 2;
        
        float minY = getY();
        float maxY = getY() + headHeight;
        
        boolean xInside = mouseX >= minX && mouseX <= maxX;
        boolean yInside = mouseY >= minY && mouseY <= maxY;
        
        return xInside && yInside;
    }
    
    public void vaporize() {
        Game.removeObjectFromScene("game", this);
        DyingZombie dyingZombie = new DyingZombie(getX(), getY(), "dyingZombie", new Animation(DyingZombie.ANIM_LENGTH, DyingZombie.TEXTURES));
        Game.addObjectToScene("game", dyingZombie);
        Utils.ZOMBIE_DEATH_SOUND.play();
    }
    
    @Override
    public void update() {
        switch(side) {
            case TOP:
                if(getY() > 1) {
                    Game.removeObjectFromScene("game", this);
                }
                break;
            case RIGHT:
                if(getX() < -getWidth()) {
                    Game.removeObjectFromScene("game", this);
                }
                break;
            case BOTTOM:
                if(getY() < -getHeight()) {
                    Game.removeObjectFromScene("game", this);
                }
                break;
            case LEFT:
                if(getX() > 1) {
                    Game.removeObjectFromScene("game", this);
                }
                break;
            default:
                throw new IllegalStateException("Zombie side value is invalid");
        }
    }
    
}
