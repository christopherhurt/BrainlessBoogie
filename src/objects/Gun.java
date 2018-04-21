package objects;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import main.ColoredGameObject;
import main.Game;

public class Gun extends ColoredGameObject {
    
    private static final float GUN_WIDTH = 0.15f;
    private static final float GUN_HEIGHT = 0.15f;
    private static final int SHOT_TICKS = 30;
    
    private Color defaultColor;
    private Color shotColor; // TODO: just do animation
    
    private boolean shot; // TODO: Do shit with this
    private int shotTimer;
    
    public Gun(String id, Color defaultColor, Color shotColor) {
        super(NotesPanel.PANEL_WIDTH, 1 - GUN_HEIGHT, 0, 0, 0, 0, GUN_WIDTH, GUN_HEIGHT, id, defaultColor);
        
        this.defaultColor = defaultColor;
        this.shotColor = shotColor;
        
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
    }
    
}
