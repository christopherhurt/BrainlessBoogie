package menus;

import main.Game;
import main.Menu;
import main.Texture;

public class OptionsMenu {
    
private Menu optionsMenu;

private static final float HOME_X = .025f;
private static final float HOME_Y = .875f;
private static final float HOME_HEIGHT = .1f;    
private static final float HOME_WIDTH = HOME_HEIGHT * 3 / 4;

private static final float VOLUME_Y = .5f;
private static final float VOLUME_OFFSET = .2f;
private static final float SFX_X = .25f;
private static final float MUSIC_X = .75f;
private static final float SFX_MINX = SFX_X - VOLUME_OFFSET;
private static final float SFX_MAXX = SFX_X + VOLUME_OFFSET;
private static final float MUSIC_MINX = MUSIC_X - VOLUME_OFFSET;
private static final float MUSIC_MAXX = MUSIC_X + VOLUME_OFFSET;
private static final float VOLUME_WIDTH = .1f;
private static final float VOLUME_HEIGHT = .1f;

private static Texture volumeTexture;

private static Texture homeUnhovered;
private static Texture homeHovered;
private static Texture homeClicked;
    
    public OptionsMenu(Texture homeUnhovered, Texture homeHovered, Texture homeClicked, Texture volumeTexture) {
        
        OptionsMenu.homeUnhovered = homeUnhovered;
        OptionsMenu.homeHovered = homeHovered;
        OptionsMenu.homeClicked = homeClicked;
        
        OptionsMenu.volumeTexture = volumeTexture;
        
        Game.createScene("options");
        optionsMenu = new Menu("options");
        constructMenu();
        Game.attachMenuToScene("options", optionsMenu);
    }
    
    public void constructMenu() {
        
        HomeButton homeButton = new HomeButton(HOME_X, HOME_Y, HOME_WIDTH, HOME_HEIGHT, homeUnhovered, homeHovered, homeClicked, "home");
        VolumeButton sfxButton = new VolumeButton(SFX_MINX, SFX_MAXX, VOLUME_Y, VOLUME_WIDTH, VOLUME_HEIGHT, volumeTexture, volumeTexture, 
            volumeTexture, "sfx");
        VolumeButton musicButton = new VolumeButton(MUSIC_MINX, MUSIC_MAXX, VOLUME_Y, VOLUME_WIDTH, VOLUME_HEIGHT, volumeTexture, volumeTexture, 
            volumeTexture, "music");
        
        optionsMenu.addButton(homeButton);
        optionsMenu.addButton(sfxButton);
        optionsMenu.addButton(musicButton);
    }

}
