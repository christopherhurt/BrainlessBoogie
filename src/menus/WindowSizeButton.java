package menus;

import main.Game;
import main.Texture;
import main.TexturedMenuButton;

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
            Settings.setWindowWidth(windowWidth);
        }
        
    }

}
