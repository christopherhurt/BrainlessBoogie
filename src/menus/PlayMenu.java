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
        
        float songHeight = 0.1f;
        float distanceBetweenSongs = 0.05f;
        float song1Y = 0.5f - 1.5f * songHeight - distanceBetweenSongs;
        float songWidth = songHeight * 141f / 25f;
        float songX = 0.055f;
        
        Song1Button song1Button = new Song1Button(songX, song1Y, songWidth, songHeight, song1Unhovered, song1Hovered, song1Clicked, "song1");
        Song2Button song2Button = new Song2Button(songX, song1Y + songHeight + distanceBetweenSongs, songWidth, songHeight, song2Unhovered, song2Hovered, song2Clicked, "song2");
        Song3Button song3Button = new Song3Button(songX, song1Y + 2 * songHeight + 2 * distanceBetweenSongs, songWidth, songHeight, song3Unhovered, song3Hovered, song3Clicked, "song3");
        
        playMenu.addButton(homeButton);
        playMenu.addButton(song1Button);
        playMenu.addButton(song2Button);
        playMenu.addButton(song3Button);
    }

}
