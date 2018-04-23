package menus;

import main.SoundBank;
import main.Texture;
import main.TexturedMenuButton;
import main.Utils;

public class Song1Button extends TexturedMenuButton {
    
    public Song1Button(float x, float y, float w, float h, Texture unhoveredTex,
        Texture hoveredTex, Texture clickedTex, String id) {
        
        super(x, y, w, h, unhoveredTex, hoveredTex, clickedTex, id);
    }
    
    @Override
    public void update() {
        if (isReleased()) {
            SoundBank.stopAll();
            Utils.MOUSE_CLICK_SOUND.play();
            Utils.startGame(1);
        }
    }

}