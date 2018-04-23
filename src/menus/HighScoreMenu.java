package menus;

import java.awt.Color;
import main.Game;
import main.Menu;
import main.MenuButton;
import main.MenuLabel;
import main.Texture;
import main.TexturedMenuButton;

public class HighScoreMenu {
    
    private Menu highScoreMenu;    
    
    private static final float HOME_X = .025f;
    private static final float HOME_Y = .875f;
    private static final float HOME_HEIGHT = .1f;    
    private static final float HOME_WIDTH = HOME_HEIGHT;
    
    private static final float BUTTON_X = .055f;
    private static final float BUTTON_HEIGHT = .1f;    
    private static final float BUTTON_WIDTH =  BUTTON_HEIGHT * 115 / 25;

    private static final float BUTTON_SEPARATION = .125f;
    private static final float SONG1_BUTTON_Y = .4f - BUTTON_HEIGHT * 3 / 4; 
    private static final float SONG2_BUTTON_Y = SONG1_BUTTON_Y + BUTTON_SEPARATION;
    private static final float SONG3_BUTTON_Y = SONG2_BUTTON_Y + BUTTON_SEPARATION;

    private static Texture homeUnhovered;
    private static Texture homeHovered;
    private static Texture homeClicked;
    
    private static Texture song1Unhovered;
    private static Texture song1Hovered;
    private static Texture song1Clicked;
    private static Texture song2Unhovered;
    private static Texture song2Hovered;
    private static Texture song2Clicked;
    private static Texture song3Unhovered;
    private static Texture song3Hovered;
    private static Texture song3Clicked;
    
    public HighScoreMenu(Texture homeUnhovered, Texture homeHovered, Texture homeClicked, 
        Texture song1Unhovered, Texture song1Hovered, Texture song1Clicked, 
        Texture song2Unhovered, Texture song2Hovered, Texture song2Clicked, 
        Texture song3Unhovered, Texture song3Hovered, Texture song3Clicked) {
        
        HighScoreMenu.homeUnhovered = homeUnhovered;
        HighScoreMenu.homeHovered = homeHovered;
        HighScoreMenu.homeClicked = homeClicked;
        
        HighScoreMenu.song1Unhovered = song1Unhovered;
        HighScoreMenu.song1Hovered = song1Hovered;
        HighScoreMenu.song1Clicked = song1Clicked;
        HighScoreMenu.song2Unhovered = song2Unhovered;
        HighScoreMenu.song2Hovered = song2Hovered;
        HighScoreMenu.song2Clicked = song2Clicked;
        HighScoreMenu.song3Unhovered = song3Unhovered;
        HighScoreMenu.song3Hovered = song3Hovered;
        HighScoreMenu.song3Clicked = song3Clicked;
        
        Game.createScene("high score");
        highScoreMenu = new Menu("high score");
        constructMenu();
        Game.attachMenuToScene("high score", highScoreMenu);
    }
    
    public void constructMenu() {
        
        HomeButton homeButton = new HomeButton(HOME_X, HOME_Y, HOME_WIDTH, HOME_HEIGHT, homeUnhovered, homeHovered, homeClicked, "home");
        HighScoreSong1Button song1 = new HighScoreSong1Button(BUTTON_X, SONG1_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT, song1Unhovered, song1Hovered, song1Clicked, "song1");
        HighScoreSong2Button song2 = new HighScoreSong2Button(BUTTON_X, SONG2_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT, song2Unhovered, song2Hovered, song2Clicked, "song2");
        HighScoreSong3Button song3 = new HighScoreSong3Button(BUTTON_X, SONG3_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT, song3Unhovered, song3Hovered, song3Clicked, "song3");
        
        highScoreMenu.addButton(homeButton);
        highScoreMenu.addButton(song1);
        highScoreMenu.addButton(song2);
        highScoreMenu.addButton(song3);
    }

}