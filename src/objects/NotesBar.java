package objects;

import java.awt.Color;
import java.awt.event.KeyEvent;
import main.ColoredGameObject;
import main.Game;

public class NotesBar extends ColoredGameObject {
    
    private static final String GAME_SCENE = "game";
    private static final float DISTANCE_BETWEEN_BUTTONS = 0.0125f;
    private static final float HIT_THRESHOLD = 0.0125f;
    private static final Color HIT_COLOR = new Color(255, 165, 0);
    
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
        
        button1 = new Button(x1, "button", KeyEvent.VK_Q, new Color(0, 255, 0), new Color(0, 150, 0), HIT_COLOR);
        button2 = new Button(x2, "button", KeyEvent.VK_W, new Color(255, 0, 0), new Color(150, 0, 0), HIT_COLOR);
        button3 = new Button(x3, "button", KeyEvent.VK_E, new Color(255, 255, 0), new Color(150, 150, 0), HIT_COLOR);
        button4 = new Button(x4, "button", KeyEvent.VK_R, new Color(0, 0, 255), new Color(0, 0, 150), HIT_COLOR);
        
        Game.addObjectToScene(GAME_SCENE, button1);
        Game.addObjectToScene(GAME_SCENE, button2);
        Game.addObjectToScene(GAME_SCENE, button3);
        Game.addObjectToScene(GAME_SCENE, button4);
    }
    
    @Override
    public void update() {
        // TODO: do note hitting (with clicking) here
    }
    
}
