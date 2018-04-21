package objects;

import java.awt.Color;
import main.ColoredGameObject;
import main.Input;

public class Button extends ColoredGameObject {
    
    public static final float BUTTON_SIZE = 0.03f;
    
    private static final float BUTTON_Y = 0.8f;
    private static final int NUM_HIT_TICKS = 15;
    
    private int keyCode;
    
    private Color unpressedColor;
    private Color pressedColor;
    private Color hitColor; // TODO: Change for animation?
    
    private boolean isHeld;
    private boolean hit;
    private int hitTimer;
    
    public Button(float x, String id, int keyCode, Color unpressedColor, Color pressedColor, Color hitColor) {
        super(x, BUTTON_Y, 0, 0, 0, 0, BUTTON_SIZE, BUTTON_SIZE, id, unpressedColor);
        
        this.keyCode = keyCode;
        this.unpressedColor = unpressedColor;
        this.pressedColor = pressedColor;
        this.hitColor = hitColor;
        
        isHeld = false;
        hit = false;
        hitTimer = 0;
    }
    
    public boolean isHeld() {
        return isHeld;
    }
    
    public void setHit() {
        hit = true;
        setColor(hitColor);
        hitTimer = 0;
    }
    
    @Override
    public void update() {
        isHeld = Input.isKeyDown(keyCode);
        
        if(hit) {
            hitTimer++;
        } else {
            if(isHeld) {
                setColor(pressedColor);
            } else {
                setColor(unpressedColor);
            }
        }
        
        if(hitTimer >= NUM_HIT_TICKS) {
            hit = false;
            
            if(isHeld) {
                setColor(pressedColor);
            } else {
                setColor(unpressedColor);
            }
        }
    }
    
}
