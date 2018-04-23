package objects;

import main.Texture;
import main.TexturedGameObject;
import main.Utils;

public class DropNote extends TexturedGameObject {
    
    public static final int NOTE1 = 0;
    public static final int NOTE2 = 1;
    public static final int NOTE3 = 2;
    public static final int NOTE4 = 3;
    
    private static final Texture NOTE1_TEX = Utils.BUTTON_SHEET.getTexture(0, 0);
    private static final Texture NOTE2_TEX = Utils.BUTTON_SHEET.getTexture(0, 1);
    private static final Texture NOTE3_TEX = Utils.BUTTON_SHEET.getTexture(0, 2);
    private static final Texture NOTE4_TEX = Utils.BUTTON_SHEET.getTexture(0, 3);
    
    private int type;
    
    public DropNote(String id, int type) {
        super(0, -Button.BUTTON_SIZE, 0, 0, 0, 0, Button.BUTTON_SIZE, Button.BUTTON_SIZE, id, NOTE1_TEX);
        
        this.type = type;
        
        setVelY((float)((Button.BUTTON_Y - getY()) / (Song.RELEASE_TIME_OFFSET * Utils.FPS)));
        
        switch(type) {
            case NOTE1:
                setX(NotesPanel.PANEL_WIDTH / 2 - 2 * Button.BUTTON_SIZE - NotesBar.DISTANCE_BETWEEN_BUTTONS * 3f / 2);
                setTexture(NOTE1_TEX);
                break;
            case NOTE2:
                setX(NotesPanel.PANEL_WIDTH / 2 - Button.BUTTON_SIZE - NotesBar.DISTANCE_BETWEEN_BUTTONS / 2);
                setTexture(NOTE2_TEX);
                break;
            case NOTE3:
                setX(NotesPanel.PANEL_WIDTH / 2 + NotesBar.DISTANCE_BETWEEN_BUTTONS / 2);
                setTexture(NOTE3_TEX);
                break;
            case NOTE4:
                setX(NotesPanel.PANEL_WIDTH / 2 + Button.BUTTON_SIZE + NotesBar.DISTANCE_BETWEEN_BUTTONS * 3f / 2);
                setTexture(NOTE4_TEX);
                break;
            default:
                throw new IllegalArgumentException("DropNote type invalid");
        }
    }
    
    public int getType() {
        return type;
    }
    
}
