package main;

import java.awt.Color;
import menus.HelpMenu;
import menus.HighScoreMenu;
import menus.MainMenu;
import menus.OptionsMenu;

public class Runner {
    
    public static void main(String[] args) {
        Game.createScene("menu");
        
        HelpMenu helpMenu = new HelpMenu(new Texture("textures/deoderant.png"), new Texture("textures/dumbbell.png"), 
            new Texture("textures/golden_fedora.png"));
        HighScoreMenu highScoreMenu = new HighScoreMenu(new Texture("textures/deoderant.png"), new Texture("textures/dumbbell.png"), 
            new Texture("textures/golden_fedora.png"));
        OptionsMenu optionsMenu = new OptionsMenu(new Texture("textures/deoderant.png"), new Texture("textures/dumbbell.png"), 
            new Texture("textures/golden_fedora.png"));
        
        MainMenu mainMenu = new MainMenu(new Texture("textures/deoderant.png"), new Texture("textures/dumbbell.png"), 
            new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), new Texture("textures/dumbbell.png"), 
            new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), new Texture("textures/dumbbell.png"), 
            new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), new Texture("textures/dumbbell.png"), 
            new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), new Texture("textures/dumbbell.png"), 
            new Texture("textures/golden_fedora.png"));
        
        Game.setCurrentScene("main menu");
        
        Game.start(600, 600, "menu", null, 60, Color.blue);
    }
    
}
