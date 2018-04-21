package menus;

import main.Game;
import main.Menu;
import main.Texture;

public class HelpMenu {

private Menu helpMenu;

private static final float HOME_X = .025f;
private static final float HOME_Y = .875f;
private static final float HOME_HEIGHT = .1f;    
private static final float HOME_WIDTH = HOME_HEIGHT * 3 / 4;

private static Texture homeUnhovered;
private static Texture homeHovered;
private static Texture homeClicked;
    
    public HelpMenu(Texture homeUnhovered, Texture homeHovered, Texture homeClicked) {
        
        HelpMenu.homeUnhovered = homeUnhovered;
        HelpMenu.homeHovered = homeHovered;
        HelpMenu.homeClicked = homeClicked;
        
        
        Game.createScene("help");
        helpMenu = new Menu("help");
        constructMenu();
        Game.attachMenuToScene("help", helpMenu);
    }
    
    public void constructMenu() {
        
        HomeButton homeButton = new HomeButton(HOME_X, HOME_Y, HOME_WIDTH, HOME_HEIGHT, homeUnhovered, homeHovered, homeClicked, "home");
        
        helpMenu.addButton(homeButton);
    }
    
}
