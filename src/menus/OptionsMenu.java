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

private static Texture homeUnhovered;
private static Texture homeHovered;
private static Texture homeClicked;
    
    public OptionsMenu(Texture homeUnhovered, Texture homeHovered, Texture homeClicked) {
        
        OptionsMenu.homeUnhovered = homeUnhovered;
        OptionsMenu.homeHovered = homeHovered;
        OptionsMenu.homeClicked = homeClicked;
        
        Game.createScene("options");
        optionsMenu = new Menu("options");
        constructMenu();
        Game.attachMenuToScene("options", optionsMenu);
    }
    
    public void constructMenu() {
        
        HomeButton homeButton = new HomeButton(HOME_X, HOME_Y, HOME_WIDTH, HOME_HEIGHT, homeUnhovered, homeHovered, homeClicked, "home");
        
        optionsMenu.addButton(homeButton);
    }

}
