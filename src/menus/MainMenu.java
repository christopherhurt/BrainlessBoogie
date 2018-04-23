package menus;

import java.awt.Color;
import main.Game;
import main.Menu;
import main.MenuButton;
import main.Texture;
import main.TexturedMenuButton;


public class MainMenu {
    
    private static final float BUTTON_X = .055f;
    private static final float BUTTON_HEIGHT = .1f;    
    private static final float BUTTON_WIDTH = .35f;
    
    private static final float BUTTON_SEPARATION = .125f;
    private static final float PLAY_BUTTON_Y = .4f - BUTTON_HEIGHT * 3 / 4; 
    private static final float HIGH_SCORE_BUTTON_Y = PLAY_BUTTON_Y + BUTTON_SEPARATION;
    private static final float OPTIONS_BUTTON_Y = HIGH_SCORE_BUTTON_Y + BUTTON_SEPARATION;
    private static final float HELP_BUTTON_Y = OPTIONS_BUTTON_Y + BUTTON_SEPARATION;
    private static final float QUIT_BUTTON_Y = HELP_BUTTON_Y + BUTTON_SEPARATION;
    
    private static Texture playUnhovered;
    private static Texture playHovered;
    private static Texture playClicked;
    private static Texture highScoreUnhovered;
    private static Texture highScoreHovered;
    private static Texture highScoreClicked;
    private static Texture optionsUnhovered;
    private static Texture optionsHovered;
    private static Texture optionsClicked;
    private static Texture helpUnhovered;
    private static Texture helpHovered;
    private static Texture helpClicked;
    private static Texture quitUnhovered;
    private static Texture quitHovered;
    private static Texture quitClicked;
    
    private Menu mainMenu;
    
    
    public MainMenu(Texture playUnhovered, Texture playHovered, Texture playClicked, Texture highScoreUnhovered, Texture highScoreHovered, Texture highScoreClicked, Texture optionsUnhovered, Texture optionsHovered, 
        Texture optionsClicked, Texture helpUnhovered, Texture helpHovered, Texture helpClicked, Texture quitUnhovered, Texture quitHovered, Texture quitClicked) {
        
        MainMenu.playUnhovered = playUnhovered;
        MainMenu.playHovered = playHovered;
        MainMenu.playClicked = playClicked;
        MainMenu.highScoreUnhovered = highScoreUnhovered;
        MainMenu.highScoreHovered = highScoreHovered;
        MainMenu.highScoreClicked = highScoreClicked;
        MainMenu.optionsUnhovered = optionsUnhovered;
        MainMenu.optionsHovered = optionsHovered;
        MainMenu.optionsClicked = optionsClicked;
        MainMenu.helpUnhovered = helpUnhovered;
        MainMenu.helpHovered = helpHovered;
        MainMenu.helpClicked = helpClicked;
        MainMenu.quitUnhovered = quitUnhovered;
        MainMenu.quitHovered = quitHovered;
        MainMenu.quitClicked = quitClicked;
        Game.createScene("main menu");
        mainMenu = new Menu("main menu");
        constructMenu();
        Game.attachMenuToScene("main menu", mainMenu);
        
    }
    
    public void constructMenu() {
        
        PlayButton playButton = new PlayButton(BUTTON_X, PLAY_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT, playUnhovered,
            playHovered, playClicked, "play");
        HighScoreButton highScoreButton = new HighScoreButton(BUTTON_X, HIGH_SCORE_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT, highScoreUnhovered,
            highScoreHovered, highScoreClicked, "high score");
        OptionsButton optionsButton = new OptionsButton(BUTTON_X, OPTIONS_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT, optionsUnhovered,
            optionsHovered, optionsClicked, "options");
        HelpButton helpButton = new HelpButton(BUTTON_X, HELP_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT, helpUnhovered,
            helpHovered, helpClicked, "help");
        QuitButton quitButton = new QuitButton(BUTTON_X, QUIT_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT, quitUnhovered,
            quitHovered, quitClicked, "quit");
        
        mainMenu.addButton(playButton);
        mainMenu.addButton(highScoreButton);
        mainMenu.addButton(optionsButton);
        mainMenu.addButton(helpButton);
        mainMenu.addButton(quitButton);
        
        
    }

}
