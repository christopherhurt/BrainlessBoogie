package objects;

import main.Input;
import main.Texture;
import main.TexturedGameObject;
import main.Utils;

public class Button extends TexturedGameObject {
    
    public static final float BUTTON_SIZE = 0.04f;
    public static final float BUTTON_Y = 0.8f;
    
    private static final int FLARED_TICKS = (int)(0.25f * Utils.FPS);
    
    private int keyCode;
    
    private Texture unpressedTex;
    private Texture pressedTex;
    private Texture flaredTex;
    
    private boolean flared;
    private int flaredTimer;
    
    public Button(float x, String id, int keyCode, Texture unpressedTex, Texture pressedTex, Texture flaredTex) {
        super(x, BUTTON_Y, 0, 0, 0, 0, BUTTON_SIZE, BUTTON_SIZE, id, unpressedTex);
        
        this.keyCode = keyCode;
        this.unpressedTex = unpressedTex;
        this.pressedTex = pressedTex;
        this.flaredTex = flaredTex;
        
        flared = false;
        flaredTimer = 0;
    }
    
    public void setFlared() {
        flared = true;
        flaredTimer = 0;
    }
    
    @Override
    public void update() {
        if(flared) {
            setTexture(flaredTex);
            flaredTimer++;
            
            if(flaredTimer >= FLARED_TICKS) {
                flared = false;
            }
        } else {
            if(Input.isKeyDown(keyCode)) {
                setTexture(pressedTex);
            } else {
                setTexture(unpressedTex);
            }
        }
    }
    
}
