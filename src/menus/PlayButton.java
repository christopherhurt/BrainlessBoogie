package menus;

import main.Texture;
import main.TexturedMenuButton;

public class PlayButton extends TexturedMenuButton {
    
    public PlayButton(float x, float y, float w, float h, Texture unhoveredTex,
        Texture hoveredTex, Texture clickedTex, String id) {
        
        super(x, y, w, h, unhoveredTex, hoveredTex, clickedTex, id);
    }
    
    @Override
    public void update() {
        
        
    }

}
