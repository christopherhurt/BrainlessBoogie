package menus;

import main.Game;
import main.Menu;
import main.Texture;

public class PlayMenu {
    
private Menu playMenu;

private static final float HOME_X = .025f;
private static final float HOME_Y = .875f;
private static final float HOME_HEIGHT = .1f;    
private static final float HOME_WIDTH = HOME_HEIGHT;

private static final float BUTTON_X = .055f;
private static final float BUTTON_HEIGHT = .1f;    
private static final float BUTTON_WIDTH = BUTTON_HEIGHT * 115 / 25;

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
    
    public PlayMenu(Texture homeUnhovered, Texture homeHovered, Texture homeClicked, 
        Texture song1Unhovered, Texture song1Hovered, Texture song1Clicked, 
        Texture song2Unhovered, Texture song2Hovered, Texture song2Clicked, 
        Texture song3Unhovered, Texture song3Hovered, Texture song3Clicked) {
        
        PlayMenu.homeUnhovered = homeUnhovered;
        PlayMenu.homeHovered = homeHovered;
        PlayMenu.homeClicked = homeClicked;
        
        PlayMenu.song1Unhovered = song1Unhovered;
        PlayMenu.song1Hovered = song1Hovered;
        PlayMenu.song1Clicked = song1Clicked;
        PlayMenu.song2Unhovered = song2Unhovered;
        PlayMenu.song2Hovered = song2Hovered;
        PlayMenu.song2Clicked = song2Clicked;
        PlayMenu.song3Unhovered = song3Unhovered;
        PlayMenu.song3Hovered = song3Hovered;
        PlayMenu.song3Clicked = song3Clicked;
        
        Game.createScene("play");
        playMenu = new Menu("play");
        constructMenu();
        Game.attachMenuToScene("play", playMenu);
    }
    
    public void constructMenu() {
        
        HomeButton homeButton = new HomeButton(HOME_X, HOME_Y, HOME_WIDTH, HOME_HEIGHT, homeUnhovered, homeHovered, homeClicked, "home");
        Song1Button song1Button = new Song1Button(BUTTON_X, SONG1_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT, song1Unhovered, song1Hovered, song1Clicked, "song1");
        Song2Button song2Button = new Song2Button(BUTTON_X, SONG2_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT, song2Unhovered, song2Hovered, song2Clicked, "song2");
        Song3Button song3Button = new Song3Button(BUTTON_X, SONG3_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT, song3Unhovered, song3Hovered, song3Clicked, "song3");
        
        
        playMenu.addButton(homeButton);
        playMenu.addButton(song1Button);
        playMenu.addButton(song2Button);
        playMenu.addButton(song3Button);
        
    }

}
