package objects;

import java.awt.Color;
import java.awt.event.KeyEvent;
import main.ColoredGameObject;
import main.Game;
import main.Utils;

public class NotesBar extends ColoredGameObject {
    
    public static final int KEY_1 = KeyEvent.VK_Q;
    public static final int KEY_2 = KeyEvent.VK_W;
    public static final int KEY_3 = KeyEvent.VK_E;
    public static final int KEY_4 = KeyEvent.VK_R;
    
    public static final float DISTANCE_BETWEEN_BUTTONS = 0.0065f;
    
    private static final String GAME_SCENE = "game";
    
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    
    public NotesBar(String id) {
        super(0, 0, 0, 0, 0, 0, 0, 0, id, Color.BLACK);
        
        float x1 = NotesPanel.PANEL_WIDTH / 2 - 2 * Button.BUTTON_SIZE - DISTANCE_BETWEEN_BUTTONS * 3f / 2;
        float x2 = NotesPanel.PANEL_WIDTH / 2 - Button.BUTTON_SIZE - DISTANCE_BETWEEN_BUTTONS / 2;
        float x3 = NotesPanel.PANEL_WIDTH / 2 + DISTANCE_BETWEEN_BUTTONS / 2;
        float x4 = NotesPanel.PANEL_WIDTH / 2 + Button.BUTTON_SIZE + DISTANCE_BETWEEN_BUTTONS * 3f / 2;
        
        button1 = new Button(x1, "button", KEY_1, Utils.BUTTON_SHEET.getTexture(1, 0), Utils.BUTTON_SHEET.getTexture(2, 0), Utils.BUTTON_SHEET.getTexture(3, 0));
        button2 = new Button(x2, "button", KEY_2, Utils.BUTTON_SHEET.getTexture(1, 1), Utils.BUTTON_SHEET.getTexture(2, 1), Utils.BUTTON_SHEET.getTexture(3, 1));
        button3 = new Button(x3, "button", KEY_3, Utils.BUTTON_SHEET.getTexture(1, 2), Utils.BUTTON_SHEET.getTexture(2, 2), Utils.BUTTON_SHEET.getTexture(3, 2));
        button4 = new Button(x4, "button", KEY_4, Utils.BUTTON_SHEET.getTexture(1, 3), Utils.BUTTON_SHEET.getTexture(2, 3), Utils.BUTTON_SHEET.getTexture(3, 3));
        
        Game.addObjectToScene(GAME_SCENE, button1);
        Game.addObjectToScene(GAME_SCENE, button2);
        Game.addObjectToScene(GAME_SCENE, button3);
        Game.addObjectToScene(GAME_SCENE, button4);
    }
    
    public void flareButton(int button) {
        switch(button) {
            case 1:
                button1.setFlared();
                break;
            case 2:
                button2.setFlared();
                break;
            case 3:
                button3.setFlared();
                break;
            case 4:
                button4.setFlared();
                break;
            default:
                throw new IllegalArgumentException("Tried to flare invalid button");
        }
    }
    
}
