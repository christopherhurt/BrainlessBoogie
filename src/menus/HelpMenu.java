package menus;

import main.Game;
import main.Menu;
import main.Texture;
import main.TexturedGameObject;

public class HelpMenu {
    
    private Menu helpMenu;
    
    private static final float HOME_X = .025f;
    private static final float HOME_Y = .875f;
    private static final float HOME_HEIGHT = .1f;    
    private static final float HOME_WIDTH = HOME_HEIGHT;
    
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
        
        float insH = 0.1f;
        float insW = insH * 145f / 26f;
        float insX = 0.5f - insW / 2;
        float insY = 0.075f;
        TexturedGameObject insBanner = new TexturedGameObject(insX, insY, 0, 0, 0, 0, insW, insH, "insBanner", new Texture("textures/instructionsBanner.png"));
        Game.addObjectToScene("help", insBanner);
        
        float boxH = 0.23f;
        float boxW = boxH * 3868f / 1120f;
        float boxX = 0.5f - boxW / 2;
        float boxY = 0.5f - boxH / 2;
        TexturedGameObject box = new TexturedGameObject(boxX, boxY, 0, 0, 0, 0, boxW, boxH, "box", new Texture("textures/instructionsLabel.png"));
        Game.addObjectToScene("help", box);
    }
    
    public void constructMenu() {
        HomeButton homeButton = new HomeButton(HOME_X, HOME_Y, HOME_WIDTH, HOME_HEIGHT, homeUnhovered, homeHovered, homeClicked, "home");
        
        float spaceBetween = 0.05f;
        float controlsH = 0.0642f;
        float controlsW = controlsH * 141f / 25f;
        float controlsX = HOME_X + HOME_WIDTH + spaceBetween;
        float controlsY = HOME_Y + HOME_HEIGHT - controlsH;
        ControlsButton controlsButton = new ControlsButton(controlsX, controlsY, controlsW, controlsH, controlsUnhovered, controlsHovered, controlsClicked, "controls");
        
        float insW = controlsH * 141f / 25f;
        float insX = controlsX + controlsW + spaceBetween;
        HelpButton gameInstructionsButton = new HelpButton(insX, controlsY, insW, controlsH, gameInstructionsUnhovered, gameInstructionsHovered, gameInstructionsClicked, "help");
                
        helpMenu.addButton(homeButton);
        helpMenu.addButton(controlsButton);
        helpMenu.addButton(gameInstructionsButton);
    }
    
}
