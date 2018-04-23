package menus;

import java.awt.Point;
import main.Game;
import main.SoundBank;
import main.Texture;
import main.TexturedMenuButton;

public class VolumeButton extends TexturedMenuButton {
    
    private float minX;
    private float maxX;
    
    public VolumeButton(float minX, float maxX, float y, float w, float h, Texture unhoveredTex,
        Texture hoveredTex, Texture clickedTex, String id) {
        
        super((maxX + minX) / 2, y, w, h, unhoveredTex, hoveredTex, clickedTex, id);
        
        this.minX = minX;
        this.maxX = maxX;
        
        float volume;
        
        if (id.equals("music")) {
            volume = Settings.getMusicVolume();
        } else {
            volume = Settings.getSFXVolume();
        }
        
        setX(volume * (maxX - minX) + minX);
    }
    
    @Override
    public void update() {
        
        if(isHeld()){
            Point mouseLoc = Game.getMouseLocation();
            
            if(mouseLoc != null){
                double mouseX = Game.getMouseLocation().getX() / Game.getWindowSize().getWidth();
                float grabbedX = (float)Math.min(Math.max(mouseX, minX), maxX);
                setX(grabbedX);
            }
        }
        
        float volume = (getX() - minX) / (maxX - minX);
        
        if(getID().equals("music")){
            SoundBank.setVolume(volume, true);
        }else{
            SoundBank.setVolume(volume, false);
        }
        
        if(isReleased()){
            if(getID().equals("music")){
                Settings.setMusicVolume(volume);
            }else if(getID().equals("sfx")){
                Settings.setSFXVolume(volume);
            }
        }
    }

}
