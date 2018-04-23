package menus;

import main.Game;
import main.Texture;
import main.TexturedMenuButton;
import main.Utils;

public class ControlsButton extends TexturedMenuButton {
    
    public ControlsButton(float x, float y, float w, float h, Texture unhoveredTex,
        Texture hoveredTex, Texture clickedTex, String id) {
        
        super(x, y, w, h, unhoveredTex, hoveredTex, clickedTex, id);
    }
    
    @Override
    public void update() {
        if (isReleased()) {
            Utils.MOUSE_CLICK_SOUND.play();
            Game.setCurrentScene("controls");
        }
    }

}
