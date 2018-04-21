package main;

import java.awt.Color;

import menus.HelpMenu;
import menus.HighScoreMenu;
import menus.MainMenu;
import menus.OptionsMenu;
import menus.PlayMenu;
import objects.Gun;
import objects.NotesBar;
import objects.NotesPanel;
import objects.Zombie;


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
        
        PlayMenu playMenu = new PlayMenu(new Texture("textures/deoderant.png"), new Texture("textures/dumbbell.png"), 
            new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), new Texture("textures/dumbbell.png"), 
            new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), new Texture("textures/dumbbell.png"), 
            new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), new Texture("textures/dumbbell.png"), 
            new Texture("textures/golden_fedora.png"));
        
        Game.setCurrentScene("main menu");
        
        Game.start(600, 600, "menu", null, 60, Color.blue);

        Game.createScene("game");
        
        Zombie zombie = new Zombie(0.1f, 0.1f, "zombie", Color.blue);
        NotesPanel panel = new NotesPanel("panel", Color.DARK_GRAY);
        NotesBar bar = new NotesBar("bar");
        Gun gun = new Gun("gun", Color.MAGENTA, Color.CYAN);
        
        Game.addObjectToScene("game", zombie);
        Game.addObjectToScene("game", panel);
        Game.addObjectToScene("game", bar);
        Game.addObjectToScene("game", gun);
        
        Game.start(1600, 1600, "Our dank game", null, 60, Color.gray);

    }
    
}
