package menus;

import java.awt.Color;
import main.Game;
import main.Menu;
import main.MenuLabel;
import main.Texture;

public class ControlsMenu {
    
private Menu controlsMenu;

private static final float HOME_X = .025f;
private static final float HOME_HEIGHT = .07f;  
private static final float HOME_Y = 1 - HOME_HEIGHT - HOME_X;  
private static final float HOME_WIDTH = HOME_HEIGHT;

private static final float BUTTON_Y = HOME_Y;
private static final float BUTTON_HEIGHT = HOME_HEIGHT;    
private static final float BUTTON_WIDTH = BUTTON_HEIGHT * 141 / 25;
private static final float BUTTON_SEPERATION = BUTTON_WIDTH * 1.087f;

private static final float GAME_INSTRUCTIONS_X = .15f;
private static final float GAME_INSTRUCTIONS_Y = BUTTON_Y;
private static final float GAME_INSTRUCTIONS_HEIGHT = BUTTON_HEIGHT;    
private static final float GAME_INSTRUCTIONS_WIDTH = BUTTON_WIDTH;

private static final float CONTROLS_X = GAME_INSTRUCTIONS_X + BUTTON_SEPERATION;
private static final float CONTROLS_Y = BUTTON_Y;
private static final float CONTROLS_HEIGHT = BUTTON_HEIGHT;    
private static final float CONTROLS_WIDTH =  BUTTON_WIDTH;

private static final float CONTROLS_LABEL_X = Game.getWindowSize().width + .3f;
private static final float CONTROLS_LABEL_Y = .125f;

private static Texture homeUnhovered;
private static Texture homeHovered;
private static Texture homeClicked;

private static Texture controlsUnhovered;
private static Texture controlsHovered;
private static Texture controlsClicked;

private static Texture gameInstructionsUnhovered;
private static Texture gameInstructionsHovered;
private static Texture gameInstructionsClicked;

    
    public ControlsMenu(Texture homeUnhovered, Texture homeHovered, Texture homeClicked, 
        Texture controlsUnhovered, Texture controlsHovered, Texture controlsClicked,
        Texture gameInstructionsUnhovered, Texture gameInstructionsHovered, Texture gameInstructionsClicked) {
        
        ControlsMenu.homeUnhovered = homeUnhovered;
        ControlsMenu.homeHovered = homeHovered;
        ControlsMenu.homeClicked = homeClicked;
        
        ControlsMenu.controlsUnhovered = controlsUnhovered;
        ControlsMenu.controlsHovered = controlsHovered;
        ControlsMenu.controlsClicked = controlsClicked;
        
        ControlsMenu.gameInstructionsUnhovered = gameInstructionsUnhovered;
        ControlsMenu.gameInstructionsHovered = gameInstructionsHovered;
        ControlsMenu.gameInstructionsClicked = gameInstructionsClicked;
        
        Game.createScene("controls");
        controlsMenu = new Menu("controls");
        constructMenu();
        Game.attachMenuToScene("controls", controlsMenu);
    }
    
    public void constructMenu() {
        
        HomeButton homeButton = new HomeButton(HOME_X, HOME_Y, HOME_WIDTH, HOME_HEIGHT, homeUnhovered, homeHovered, homeClicked, "home");
        ControlsButton controlsButton = new ControlsButton(CONTROLS_X, CONTROLS_Y, CONTROLS_WIDTH, CONTROLS_HEIGHT, controlsUnhovered, controlsHovered, controlsClicked, "controls");
        HelpButton gameInstructionsButton = new HelpButton(GAME_INSTRUCTIONS_X, GAME_INSTRUCTIONS_Y, GAME_INSTRUCTIONS_WIDTH, GAME_INSTRUCTIONS_HEIGHT, gameInstructionsUnhovered, gameInstructionsHovered, gameInstructionsClicked, "help");
        MenuLabel controlsLabel = new MenuLabel("Controls", "Sans Serif", 1, 0.1f, Color.BLACK, CONTROLS_LABEL_X, CONTROLS_LABEL_Y, "instructions");
        
        controlsMenu.addButton(homeButton);
        controlsMenu.addButton(controlsButton);
        controlsMenu.addButton(gameInstructionsButton);
        controlsMenu.addLabel(controlsLabel);
        
    }

}