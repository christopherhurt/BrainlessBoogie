package menus;

import main.Game;
import main.Menu;
import main.Texture;
import main.TexturedGameObject;

public class HighScoreMenu {
    
    private Menu highScoreMenu;    
    
    private static final float HOME_X = .025f;
    private static final float HOME_Y = .875f;
    private static final float HOME_HEIGHT = .1f;    
    private static final float HOME_WIDTH = HOME_HEIGHT;

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
        
        float hsH = 0.125f;
        float hsW = hsH * 117f / 26f;
        float hsX = 0.5f - hsW / 2;
        float hsY = 0.073f;
        TexturedGameObject hsBanner = new TexturedGameObject(hsX, hsY, 0, 0, 0, 0, hsW, hsH, "hsBanner", new Texture("textures/highScoreBanner.png"));
        Game.addObjectToScene("high score", hsBanner);
    }
    
    public void constructMenu() {
        float songHeight = 0.1f;
        float distanceBetweenSongs = 0.05f;
        float song1Y = 0.5f - 1.5f * songHeight - distanceBetweenSongs;
        float songWidth = songHeight * 141f / 25f;
        float songX = 0.5f - songWidth / 2;
        
        HomeButton homeButton = new HomeButton(HOME_X, HOME_Y, HOME_WIDTH, HOME_HEIGHT, homeUnhovered, homeHovered, homeClicked, "home");
        HighScoreSong1Button song1 = new HighScoreSong1Button(songX, song1Y, songWidth, songHeight, song1Unhovered, song1Hovered, song1Clicked, "song1");
        HighScoreSong2Button song2 = new HighScoreSong2Button(songX, song1Y + songHeight + distanceBetweenSongs, songWidth, songHeight, song2Unhovered, song2Hovered, song2Clicked, "song2");
        HighScoreSong3Button song3 = new HighScoreSong3Button(songX, song1Y + 2 * (songHeight + distanceBetweenSongs), songWidth, songHeight, song3Unhovered, song3Hovered, song3Clicked, "song3");
        
        highScoreMenu.addButton(homeButton);
        highScoreMenu.addButton(song1);
        highScoreMenu.addButton(song2);
        highScoreMenu.addButton(song3);
    }

}