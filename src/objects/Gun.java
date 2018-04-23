package objects;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import main.Game;
import main.Input;
import main.Texture;
import main.TexturedGameObject;
import main.Utils;

public class Gun extends TexturedGameObject {
    
    private static final float GUN_WIDTH = 0.12f;
    private static final float GUN_HEIGHT = 0.12f;
    private static final int SHOT_TICKS = (int)(0.1f * Utils.FPS);
    
    private Texture defaultTex;
    private Texture shotTex;
    
    private boolean shot;
    private int shotTimer;
    
    public Gun(String id, Texture defaultTex, Texture shotTex) {
        super(NotesPanel.PANEL_WIDTH, 1 - GUN_HEIGHT, 0, 0, 0, 0, GUN_WIDTH, GUN_HEIGHT, id, defaultTex);
        
        this.defaultTex = defaultTex;
        this.shotTex = shotTex;
        
        shot = false;
        shotTimer = 0;
    }
    
    @Override
    public void update() {
        Point mouseLoc = Game.getMouseLocation();
        Dimension windowSize = Game.getWindowSize();
        
        if(mouseLoc != null) {
            float mouseX = (float)(mouseLoc.getX() / windowSize.getWidth());
            float translatedX = mouseX - GUN_WIDTH / 2;
            
            if(translatedX < NotesPanel.PANEL_WIDTH) {
                translatedX = NotesPanel.PANEL_WIDTH;
            } else if(translatedX > 1 - GUN_WIDTH) {
                translatedX = 1 - GUN_WIDTH;
            }
            
            setX(translatedX);
        }
        
        if(shot) {
            shotTimer++;
        }
        
        if(shotTimer >= SHOT_TICKS) {
            shot = false;
            setTexture(defaultTex);
        }
        
        if(Input.isButtonPressed(MouseEvent.BUTTON1)) {
            shot = true;
            shotTimer = 0;
            setTexture(shotTex);
            Utils.GUNSHOT_SOUND.play();
        }
    }
    
}
