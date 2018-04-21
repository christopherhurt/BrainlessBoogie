package menus;

import main.Game;
import main.Texture;
import main.TexturedMenuButton;

public class HomeButton extends TexturedMenuButton {
    
    public HomeButton(float x, float y, float w, float h, Texture unhoveredTex,
        Texture hoveredTex, Texture clickedTex, String id) {
        
        super(x, y, w, h, unhoveredTex, hoveredTex, clickedTex, id);
    }
    
    @Override
    public void update() {
        
        if (isReleased()) {
            Game.setCurrentScene("main menu");
        }
    }

}