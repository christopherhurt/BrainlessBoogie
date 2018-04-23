package objects;

import java.awt.Cursor;
import main.Game;
import main.Menu;
import main.MenuLabel;
import main.SoundBank;
import main.Texture;
import main.TexturedGameObject;
import main.Utils;

public class Health extends TexturedGameObject {
    
    private static final float STARTING_HEALTH = 0.5f;
    
    private float health;
    private Texture[] textures;
    private Song song;
    
    public Health(float x, float y, float w, float h, String id, Song song, Texture ... textures) {
        super(x, y, 0, 0, 0, 0, w, h, id, textures[0]);
        
        this.song = song;
        this.textures = textures;
        
        health = STARTING_HEALTH;
    }
    
    public void setHealth(float health) {
        this.health = health;
        
        if(this.health < 0) {
            this.health = 0;
        }
        
        if(this.health > 1) {
            this.health = 1;
        }
    }
    
    public void addHealth(float health) {
        this.health += health;
        
        if(this.health > 1) {
            this.health = 1;
        }
    }
    
    public void removeHealth(float health) {
        this.health -= health;
        
        if(this.health < 0) {
            this.health = 0;
        }
    }
    
    @Override
    public void update() {
        Texture currTex = textures[(int)(health * (textures.length - 1))];
        setTexture(currTex);
        
        if(health <= 0) {
            loseGame();
        }
    }
    
    private void loseGame() {
        SoundBank.stopAll();
        
        Menu gameMenu = Game.getMenu();
        gameMenu.clearAll();
        
        Game.detachMenuFromScene("game");
        Game.clearScene("game");
        Game.setCurrentScene("lose");
        Game.setCursor(Cursor.getDefaultCursor());
        
        int completionPercentage = song.getCompletionPercentage();
        Menu loseMenu = Game.getMenu();
        MenuLabel completionLabel = loseMenu.getLabel("completionLabel");
        completionLabel.setText(completionPercentage + "%");
        
        Utils.LOSE_SOUND.play();
    }
    
}
