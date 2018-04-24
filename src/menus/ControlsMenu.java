package menus;

import main.Game;
import main.Menu;
import main.Texture;
import main.TexturedGameObject;

public class ControlsMenu {
    
    private Menu controlsMenu;
    
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
        
        float controlsH = 0.1f;
        float controlsW = controlsH * 102f / 26f;
        float controlsX = 0.5f - controlsW / 2;
        float controlsY = 0.075f;
        TexturedGameObject controlsBanner = new TexturedGameObject(controlsX, controlsY, 0, 0, 0, 0, controlsW, controlsH, "controlsBanner", new Texture("textures/controlsBanner.png"));
        Game.addObjectToScene("controls", controlsBanner);
        
        float qwerH = 0.12f;
        float qwerW = qwerH * 47f / 11f;
        float qwerX = 0.055f;
        float qwerY = 0.375f;
        TexturedGameObject qwer = new TexturedGameObject(qwerX, qwerY, 0, 0, 0, 0, qwerW, qwerH, "qwer", new Texture("textures/qwer.png"));
        Game.addObjectToScene("controls", qwer);
        
        float mouseH = 0.5f;
        float mouseW = mouseH * 30f / 55f;
        float mouseX = 0.68f;
        float mouseY = 0.5f - mouseH / 2 + 0.05f;
        TexturedGameObject mouse = new TexturedGameObject(mouseX, mouseY, 0, 0, 0, 0, mouseW, mouseH, "mouse", new Texture("textures/mouse.png"));
        Game.addObjectToScene("controls", mouse);
        
        float shootH = 0.05f;
        float shootW = shootH * 432f / 248f;
        float shootX = 0.65f;
        float shootY = mouseY;
        TexturedGameObject shoot = new TexturedGameObject(shootX, shootY, 0, 0, 0, 0, shootW, shootH, "shoot", new Texture("textures/shootLabel.png"));
        Game.addObjectToScene("controls", shoot);
        
        float noteH = 0.065f;
        float noteW = noteH * 432f / 248f;
        float note1X = qwerX + 0.002f;
        float spaceBetween = 0.02f;
        float noteY = 0.55f;
        
        TexturedGameObject note1 = new TexturedGameObject(note1X, noteY, 0, 0, 0, 0, noteW, noteH, "note1", new Texture("textures/redNoteLabel.png"));
        TexturedGameObject note2 = new TexturedGameObject(note1X + noteW + spaceBetween, noteY, 0, 0, 0, 0, noteW, noteH, "note2", new Texture("textures/blueNoteLabel.png"));
        TexturedGameObject note3 = new TexturedGameObject(note1X + 2 * (noteW + spaceBetween), noteY, 0, 0, 0, 0, noteW, noteH, "note3", new Texture("textures/orangeNoteLabel.png"));
        TexturedGameObject note4 = new TexturedGameObject(note1X + 3 * (noteW + spaceBetween), noteY, 0, 0, 0, 0, noteW, noteH, "note4", new Texture("textures/greenNoteLabel.png"));
    
        Game.addObjectToScene("controls", note1);
        Game.addObjectToScene("controls", note2);
        Game.addObjectToScene("controls", note3);
        Game.addObjectToScene("controls", note4);
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
        
        controlsMenu.addButton(homeButton);
        controlsMenu.addButton(controlsButton);
        controlsMenu.addButton(gameInstructionsButton);
    }

}