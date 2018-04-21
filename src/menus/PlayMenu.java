package menus;

import main.Game;
import main.Menu;
import main.Texture;

public class PlayMenu {
    
private Menu playMenu;

private static final float HOME_X = .025f;
private static final float HOME_Y = .875f;
private static final float HOME_HEIGHT = .1f;    
private static final float HOME_WIDTH = HOME_HEIGHT * 3 / 4;

private static final float BUTTON_X = .055f;
private static final float BUTTON_HEIGHT = .1f;    
private static final float BUTTON_WIDTH = .35f;

private static final float BUTTON_SEPARATION = .125f;
private static final float PLAY_BUTTON_Y = .4f - BUTTON_HEIGHT * 3 / 4; 
private static final float HIGH_SCORE_BUTTON_Y = PLAY_BUTTON_Y + BUTTON_SEPARATION;
private static final float OPTIONS_BUTTON_Y = HIGH_SCORE_BUTTON_Y + BUTTON_SEPARATION;

private static Texture homeUnhovered;
private static Texture homeHovered;
private static Texture homeClicked;

private static Texture playUnhovered;
private static Texture playHovered;
private static Texture playClicked;
private static Texture highScoreUnhovered;
private static Texture highScoreHovered;
private static Texture highScoreClicked;
private static Texture optionsUnhovered;
private static Texture optionsHovered;
private static Texture optionsClicked;
    
    public PlayMenu(Texture homeUnhovered, Texture homeHovered, Texture homeClicked, Texture playUnhovered, Texture playHovered, Texture playClicked, Texture highScoreUnhovered, Texture highScoreHovered, Texture highScoreClicked, Texture optionsUnhovered, Texture optionsHovered, 
        Texture optionsClicked) {
        
        PlayMenu.homeUnhovered = homeUnhovered;
        PlayMenu.homeHovered = homeHovered;
        PlayMenu.homeClicked = homeClicked;
        
        PlayMenu.playUnhovered = playUnhovered;
        PlayMenu.playHovered = playHovered;
        PlayMenu.playClicked = playClicked;
        PlayMenu.highScoreUnhovered = highScoreUnhovered;
        PlayMenu.highScoreHovered = highScoreHovered;
        PlayMenu.highScoreClicked = highScoreClicked;
        PlayMenu.optionsUnhovered = optionsUnhovered;
        PlayMenu.optionsHovered = optionsHovered;
        PlayMenu.optionsClicked = optionsClicked;
        
        Game.createScene("play");
        playMenu = new Menu("play");
        constructMenu();
        Game.attachMenuToScene("play", playMenu);
    }
    
    public void constructMenu() {
        
        HomeButton homeButton = new HomeButton(HOME_X, HOME_Y, HOME_WIDTH, HOME_HEIGHT, homeUnhovered, homeHovered, homeClicked, "home");
        Song1Button song1Button = new Song1Button(BUTTON_X, PLAY_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT, playUnhovered, playHovered, playClicked, "song1");
        Song2Button song2Button = new Song2Button(BUTTON_X, HIGH_SCORE_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT, highScoreUnhovered, highScoreHovered, highScoreClicked, "song2");
        Song3Button song3Button = new Song3Button(BUTTON_X, OPTIONS_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT, optionsUnhovered, optionsHovered, optionsClicked, "song3");
        
        
        playMenu.addButton(homeButton);
        playMenu.addButton(song1Button);
        playMenu.addButton(song2Button);
        playMenu.addButton(song3Button);
        
    }

}
