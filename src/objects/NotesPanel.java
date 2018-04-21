package objects;

import java.awt.Color;
import main.ColoredGameObject;
import main.Game;

public class NotesPanel extends ColoredGameObject {
    
    public static final float PANEL_WIDTH = 0.2f;
    
    public NotesPanel(String id, Color color) {
        super(0, 0, 0, 0, 0, 0, PANEL_WIDTH, 1, id, color);
    }
    
    @Override
    public void update() {
        // TODO: Do note adding from file here
        
        Game.readdObjects("panel");
        Game.readdObjects("button");
        Game.readdObjects("bar");
        
        // TODO: Readd notes
    }
    
}
