package menus;

import java.awt.Dimension;
import java.awt.Point;
import main.Game;
import main.Texture;
import main.TexturedMenuButton;
import main.Utils;

public class VolumeButton extends TexturedMenuButton {
    
    private float minX;
    private float maxX;
    private boolean musicSlider;
    private float lockedOffset;
    
    public VolumeButton(VolumeScale slider, float w, float h, Texture unhoveredTex, Texture hoveredTex, Texture clickedTex, String id, boolean musicSlider) {
        super(0, slider.getY() + (slider.getHeight() - h) / 2, w, h, unhoveredTex, hoveredTex, clickedTex, id);
        
        float sliderOffset = slider.getWidth() * 4f / 100f - 0.001f;
        
        minX = slider.getX() + sliderOffset;
        maxX = slider.getX() + slider.getWidth() - sliderOffset - w;
        lockedOffset = 0;
        
        this.musicSlider = musicSlider;
        
        setX(minX + (maxX - minX) * (musicSlider ? Settings.getMusicVolume() : Settings.getSFXVolume()));
    }
    
    @Override
    public void update() {
        if(isClicked()) {
            Point mouseLoc = Game.getMouseLocation();
            Dimension windowSize = Game.getWindowSize();
            
            if(mouseLoc != null) {
                float mouseX = (float)(mouseLoc.getX() / windowSize.getWidth());
                
                lockedOffset = getX() - mouseX;
            }
        }
        
        if(isHeld()) {
            Point mouseLoc = Game.getMouseLocation();
            Dimension windowSize = Game.getWindowSize();
            
            if(mouseLoc != null) {
                float mouseX = (float)(mouseLoc.getX() / windowSize.getWidth());
                
                if(mouseX + lockedOffset < minX) {
                    mouseX = minX - lockedOffset;
                }
                
                if(mouseX + lockedOffset > maxX) {
                    mouseX = maxX - lockedOffset;
                }
                
                setX(mouseX + lockedOffset);
            }
            
            float volume = (getX() - minX) / (maxX - minX);
            
            if(musicSlider) {
                Utils.updateVolume(volume, Settings.getSFXVolume());
            } else {
                Utils.updateVolume(Settings.getMusicVolume(), volume);
            }
        }
        
        if(isReleased()) {
            float volume = (getX() - minX) / (maxX - minX);
            
            if(musicSlider) {
                Utils.updateVolume(volume, Settings.getSFXVolume());
                Settings.setMusicVolume(volume);
            } else {
                Utils.updateVolume(Settings.getMusicVolume(), volume);
                Settings.setSFXVolume(volume);
            }
            
            Settings.writeSettings();
        }
    }

}
