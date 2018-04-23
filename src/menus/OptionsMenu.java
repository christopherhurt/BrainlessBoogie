package menus;

import main.Game;
import main.Menu;
import main.Texture;

public class OptionsMenu {
    
private Menu optionsMenu;

private static final float HOME_X = .025f;
private static final float HOME_Y = .875f;
private static final float HOME_HEIGHT = .1f;    
private static final float HOME_WIDTH = HOME_HEIGHT;

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

private static final float WINDOW_BUTTON_WIDTH = .1f;
private static final float WINDOW_BUTTON_HEIGHT = .05f;
private static final float WINDOW_BUTTON_Y = .75f;
private static final float WINDOW_BUTTON_OFFSET = .1f;
private static final float WINDOW_BUTTON1_X = .2f;
private static final float WINDOW_BUTTON2_X = WINDOW_BUTTON1_X + WINDOW_BUTTON_OFFSET;
private static final float WINDOW_BUTTON3_X = WINDOW_BUTTON2_X + WINDOW_BUTTON_OFFSET;
private static final float WINDOW_BUTTON4_X = WINDOW_BUTTON3_X + WINDOW_BUTTON_OFFSET;
private static final int WINDOW_BUTTON1_VALUE = 400;
private static final int WINDOW_BUTTON2_VALUE = 600;
private static final int WINDOW_BUTTON3_VALUE = 800;
private static final int WINDOW_BUTTON4_VALUE = 1000;

private static Texture volumeTexture;
private static Texture scaleTexture;

private static Texture homeUnhovered;
private static Texture homeHovered;
private static Texture homeClicked;

private static Texture window1Unhovered;
private static Texture window1Hovered;
private static Texture window1Clicked;
private static Texture window2Unhovered;
private static Texture window2Hovered;
private static Texture window2Clicked;
private static Texture window3Unhovered;
private static Texture window3Hovered;
private static Texture window3Clicked;
private static Texture window4Unhovered;
private static Texture window4Hovered;
private static Texture window4Clicked;

    
    public OptionsMenu(Texture homeUnhovered, Texture homeHovered, Texture homeClicked, Texture volumeTexture, Texture scaleTexture, Texture window1Unhovered, 
        Texture window1Hovered, Texture window1Clicked, Texture window2Unhovered, Texture window2Hovered, Texture window2Clicked,
        Texture window3Unhovered, Texture window3Hovered, Texture window3Clicked, Texture window4Unhovered, Texture window4Hovered, 
        Texture window4Clicked) {
        
        OptionsMenu.homeUnhovered = homeUnhovered;
        OptionsMenu.homeHovered = homeHovered;
        OptionsMenu.homeClicked = homeClicked;
        
        OptionsMenu.window1Unhovered = window1Unhovered;
        OptionsMenu.window1Hovered = window1Hovered;
        OptionsMenu.window1Clicked = window1Clicked;
        OptionsMenu.window2Unhovered = window2Unhovered;
        OptionsMenu.window2Hovered = window2Hovered;
        OptionsMenu.window2Clicked = window2Clicked;
        OptionsMenu.window3Unhovered = window3Unhovered;
        OptionsMenu.window3Hovered = window3Hovered;
        OptionsMenu.window3Clicked = window3Clicked;
        OptionsMenu.window4Unhovered = window4Unhovered;
        OptionsMenu.window4Hovered = window4Hovered;
        OptionsMenu.window4Clicked = window4Clicked;
        
        OptionsMenu.volumeTexture = volumeTexture;
        OptionsMenu.scaleTexture = scaleTexture;
        
        Game.createScene("options");
        optionsMenu = new Menu("options");
        constructMenu();
        Game.attachMenuToScene("options", optionsMenu);
    }
    
    public void constructMenu() {
        
        HomeButton homeButton = new HomeButton(HOME_X, HOME_Y, HOME_WIDTH, HOME_HEIGHT, homeUnhovered, homeHovered, homeClicked, "home");
        VolumeButton sfxButton = new VolumeButton(SFX_MINX, SFX_MAXX, VOLUME_Y, VOLUME_WIDTH, VOLUME_HEIGHT, volumeTexture, "sfx");
        VolumeButton musicButton = new VolumeButton(MUSIC_MINX, MUSIC_MAXX, VOLUME_Y, VOLUME_WIDTH, VOLUME_HEIGHT, volumeTexture, "music");
        VolumeScale sfxScale = new VolumeScale(SFX_MINX, VOLUME_Y, VOLUME_WIDTH, VOLUME_HEIGHT, scaleTexture, "sfx scale");
        VolumeScale musicScale = new VolumeScale(MUSIC_MINX, VOLUME_Y, VOLUME_WIDTH, VOLUME_HEIGHT, scaleTexture, "music scale");
        WindowSizeButton windowButton1 = new WindowSizeButton(WINDOW_BUTTON1_X, WINDOW_BUTTON_Y, WINDOW_BUTTON_WIDTH, WINDOW_BUTTON_HEIGHT, 
            WINDOW_BUTTON1_VALUE, window1Unhovered, window1Hovered, window1Clicked, "window size 1");
        WindowSizeButton windowButton2 = new WindowSizeButton(WINDOW_BUTTON2_X, WINDOW_BUTTON_Y, WINDOW_BUTTON_WIDTH, WINDOW_BUTTON_HEIGHT, 
            WINDOW_BUTTON2_VALUE, window2Unhovered, window2Hovered, window2Clicked, "window size 2");
        WindowSizeButton windowButton3 = new WindowSizeButton(WINDOW_BUTTON3_X, WINDOW_BUTTON_Y, WINDOW_BUTTON_WIDTH, WINDOW_BUTTON_HEIGHT, 
            WINDOW_BUTTON3_VALUE, window3Unhovered, window3Hovered, window3Clicked, "window size 3");
        WindowSizeButton windowButton4 = new WindowSizeButton(WINDOW_BUTTON4_X, WINDOW_BUTTON_Y, WINDOW_BUTTON_WIDTH, WINDOW_BUTTON_HEIGHT, 
            WINDOW_BUTTON4_VALUE, window4Unhovered, window4Hovered, window4Clicked, "window size 4");
        
        optionsMenu.addButton(homeButton);
        optionsMenu.addButton(sfxButton);
        optionsMenu.addButton(musicButton);
        Game.addObjectToScene("options", sfxScale);
        Game.addObjectToScene("options", musicScale);
        optionsMenu.addButton(windowButton1);
        optionsMenu.addButton(windowButton2);
        optionsMenu.addButton(windowButton3);
        optionsMenu.addButton(windowButton4);
    }

}
