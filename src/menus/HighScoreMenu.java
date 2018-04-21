package menus;

import java.awt.Color;
import main.Game;
import main.Menu;
import main.MenuButton;
import main.Texture;
import main.TexturedMenuButton;

public class HighScoreMenu {
    
    private Menu highScoreMenu;
    
    private static final float HOME_X = .025f;
    private static final float HOME_Y = .875f;
    private static final float HOME_HEIGHT = .1f;    
    private static final float HOME_WIDTH = HOME_HEIGHT * 3 / 4;

    private static Texture homeUnhovered;
    private static Texture homeHovered;
    private static Texture homeClicked;
    
    public HighScoreMenu(Texture homeUnhovered, Texture homeHovered, Texture homeClicked) {
        
        HighScoreMenu.homeUnhovered = homeUnhovered;
        HighScoreMenu.homeHovered = homeHovered;
        HighScoreMenu.homeClicked = homeClicked;
        
        Game.createScene("high score");
        highScoreMenu = new Menu("high score");
        constructMenu();
        Game.attachMenuToScene("high score", highScoreMenu);
    }
    
    public void constructMenu() {
        
        HomeButton homeButton = new HomeButton(HOME_X, HOME_Y, HOME_WIDTH, HOME_HEIGHT, homeUnhovered, homeHovered, homeClicked, "home");
        
        highScoreMenu.addButton(homeButton);
    }

}