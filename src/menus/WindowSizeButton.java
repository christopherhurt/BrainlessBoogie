package menus;

import main.Texture;
import main.TexturedMenuButton;
import main.Utils;

public class WindowSizeButton extends TexturedMenuButton {
    
    private int windowWidth;
    
    public WindowSizeButton(float x, float y, float w, float h, int windowWidth, Texture unhoveredTex,
        Texture hoveredTex, Texture clickedTex, String id) {
        
        super(x, y, w, h, unhoveredTex, hoveredTex, clickedTex, id);
        this.windowWidth = windowWidth;
    }
    
    @Override
    public void update() {
        
        if (isReleased()) {
            Utils.MOUSE_CLICK_SOUND.play();
            Settings.setWindowWidth(windowWidth);
        }
        
    }

}
