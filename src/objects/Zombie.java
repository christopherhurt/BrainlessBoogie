package objects;

import java.awt.Color;
import java.awt.event.MouseEvent;
import main.ColoredGameObject;
import main.Input;
import main.Utils;

public class Zombie extends ColoredGameObject {
    
    private static final float ZOMBIE_SPEED = 0.005f;
    
    private int side;
    
    public Zombie(float w, float h, String id, Color color) {
        super(1, 1, 0, 0, 0, 0, w, h, id, color);
        
        side = (int)(Math.random() * 4);
        float dist;
        
        switch(side) {
            case 0:
                dist = (float)(Math.random() * (1 - getWidth() - NotesPanel.PANEL_WIDTH)) + NotesPanel.PANEL_WIDTH;
                setX(dist);
                setY(-getHeight());
                setVelY(ZOMBIE_SPEED);
                break;
            case 1:
                dist = (float)(Math.random() * (1 - getHeight()));
                setX(1);
                setY(dist);
                setVelX(-ZOMBIE_SPEED);
                break;
            case 2:
                dist = (float)(Math.random() * (1 - getWidth() - NotesPanel.PANEL_WIDTH)) + NotesPanel.PANEL_WIDTH;
                setX(dist);
                setY(1);
                setVelY(-ZOMBIE_SPEED);
                break;
            case 3:
                dist = (float)(Math.random() * (1 - getHeight()));
                setX(NotesPanel.PANEL_WIDTH - getWidth());
                setY(dist);
                setVelX(ZOMBIE_SPEED);
                break;
            default:
                System.err.println("Zombie side generated incorrectly");
                System.exit(-1);
        }
    }
    
    @Override
    public void update() {
        if(Input.isButtonPressed(MouseEvent.BUTTON1)) {
            if(Utils.mouseOverObject(this)) {
                System.out.println("Zombie hit!");
            }
        }
        
        // TODO: Remove offscreen zombies
        // TODO: lose health/points for offscreen zombies
    }
    
}
