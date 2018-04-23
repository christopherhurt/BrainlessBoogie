package menus;

import java.awt.Color;
import main.Game;
import main.Menu;
import main.MenuLabel;
import main.Texture;

public class HelpMenu {

private Menu helpMenu;

private static final float HOME_X = .025f;
private static final float HOME_Y = .875f;
private static final float HOME_HEIGHT = .1f;    
private static final float HOME_WIDTH = HOME_HEIGHT;

private static final float CONTROLS_X = .2f;
private static final float CONTROLS_Y = .875f;
private static final float CONTROLS_HEIGHT = .1f;    
private static final float CONTROLS_WIDTH = .35f;

private static final float GAME_INSTRUCTIONS_X = .6f;
private static final float GAME_INSTRUCTIONS_Y = CONTROLS_Y;
private static final float GAME_INSTRUCTIONS_HEIGHT = .1f;    
private static final float GAME_INSTRUCTIONS_WIDTH = .35f;

private static final float INSTRUCTION_LABEL_X = Game.getWindowSize().width/10 + .05f;
private static final float INSTRUCTION_LABEL_Y = .125f;

private static Texture homeUnhovered;
private static Texture homeHovered;
private static Texture homeClicked;

private static Texture controlsUnhovered;
private static Texture controlsHovered;
private static Texture controlsClicked;

private static Texture gameInstructionsUnhovered;
private static Texture gameInstructionsHovered;
private static Texture gameInstructionsClicked;
    
    public HelpMenu(Texture homeUnhovered, Texture homeHovered, Texture homeClicked, 
        Texture controlsUnhovered, Texture controlsHovered, Texture controlsClicked,
        Texture gameInstructionsUnhovered, Texture gameInstructionsHovered, Texture gameInstructionsClicked) {
        
        HelpMenu.homeUnhovered = homeUnhovered;
        HelpMenu.homeHovered = homeHovered;
        HelpMenu.homeClicked = homeClicked;
        
        HelpMenu.controlsUnhovered = controlsUnhovered;
        HelpMenu.controlsHovered = controlsHovered;
        HelpMenu.controlsClicked = controlsClicked;
        
        HelpMenu.gameInstructionsUnhovered = gameInstructionsUnhovered;
        HelpMenu.gameInstructionsHovered = gameInstructionsHovered;
        HelpMenu.gameInstructionsClicked = gameInstructionsClicked; 
        
        
        Game.createScene("help");
        helpMenu = new Menu("help");
        constructMenu();
        Game.attachMenuToScene("help", helpMenu);
    }
    
    public void constructMenu() {
        
        HomeButton homeButton = new HomeButton(HOME_X, HOME_Y, HOME_WIDTH, HOME_HEIGHT, homeUnhovered, homeHovered, homeClicked, "home");
        ControlsButton controlsButton = new ControlsButton(CONTROLS_X, CONTROLS_Y, CONTROLS_WIDTH, CONTROLS_HEIGHT, controlsUnhovered, controlsHovered, controlsClicked, "controls");
        HelpButton gameInstructionsButton = new HelpButton(GAME_INSTRUCTIONS_X, GAME_INSTRUCTIONS_Y, GAME_INSTRUCTIONS_WIDTH, GAME_INSTRUCTIONS_HEIGHT, gameInstructionsUnhovered, gameInstructionsHovered, gameInstructionsClicked, "help");
        MenuLabel gameInstructionsLabel = new MenuLabel("Game Instructions", "Sans Serif", 1, 0.1f, Color.BLACK, INSTRUCTION_LABEL_X, INSTRUCTION_LABEL_Y, "instructions");
        
        helpMenu.addButton(homeButton);
        helpMenu.addButton(controlsButton);
        helpMenu.addButton(gameInstructionsButton);
        helpMenu.addLabel(gameInstructionsLabel);
    }
    
}
