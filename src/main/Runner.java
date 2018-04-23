package main;

import java.awt.Color;
import menus.ControlsMenu;
import menus.HelpMenu;
import menus.HighScoreMenu;
import menus.HighScoreSong1Menu;
import menus.HighScoreSong2Menu;
import menus.HighScoreSong3Menu;
import menus.MainMenu;
import menus.OptionsMenu;
import menus.PlayMenu;
import menus.Settings;
import objects.Gun;
import objects.NotesBar;
import objects.NotesPanel;
import objects.Zombie;


public class Runner {
    
    public static void main(String[] args) {

        Settings.readSettings();
        Settings.readHighScores();
        Game.createScene("menu");
        
        HelpMenu helpMenu = new HelpMenu(new Texture("textures/homeButtU.png"), new Texture("textures/homeButtH.png"), 
            new Texture("textures/homeButtP.png"), new Texture("textures/controlsButtU.png"), new Texture("textures/controlsButtH.png"), 
            new Texture("textures/controlsButtP.png"), new Texture("textures/instructionsButtU.png"), new Texture("textures/instructionsButtH.png"), 
            new Texture("textures/instructionsButtP.png"));
        HighScoreMenu highScoreMenu = new HighScoreMenu(new Texture("textures/homeButtU.png"), new Texture("textures/homeButtH.png"), 
            new Texture("textures/homeButtP.png"), new Texture("textures/deoderant.png"), 
            new Texture("textures/dumbbell.png"), new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), 
            new Texture("textures/dumbbell.png"), new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), 
            new Texture("textures/dumbbell.png"), new Texture("textures/golden_fedora.png"));
        HighScoreSong1Menu highScoreSong1Menu = new HighScoreSong1Menu(new Texture("textures/backButtU.png"), new Texture("textures/backButtH.png"), 
            new Texture("textures/backButtP.png"));
        HighScoreSong2Menu highScoreSong2Menu = new HighScoreSong2Menu(new Texture("textures/backButtU.png"), new Texture("textures/backButtH.png"), 
            new Texture("textures/backButtP.png"));
        HighScoreSong3Menu highScoreSong3Menu = new HighScoreSong3Menu(new Texture("textures/backButtU.png"), new Texture("textures/backButtH.png"), 
            new Texture("textures/backButtP.png"));
        OptionsMenu optionsMenu = new OptionsMenu(new Texture("textures/homeButtU.png"), new Texture("textures/homeButtH.png"), 
            new Texture("textures/homeButtP.png"), new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), new Texture("textures/deoderant.png"), 
            new Texture("textures/dumbbell.png"), new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), 
            new Texture("textures/dumbbell.png"), new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), 
            new Texture("textures/dumbbell.png"), new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), 
            new Texture("textures/dumbbell.png"), new Texture("textures/golden_fedora.png"));
        
        MainMenu mainMenu = new MainMenu(new Texture("textures/playButtU.png"), new Texture("textures/playButtH.png"), 
            new Texture("textures/playButtP.png"), new Texture("textures/highScoreButtU.png"), new Texture("textures/highScoreButtH.png"), 
            new Texture("textures/highScoreButtP.png"), new Texture("textures/optionsButtU.png"), new Texture("textures/optionsButtH.png"), 
            new Texture("textures/optionsButtP.png"), new Texture("textures/helpButtU.png"), new Texture("textures/helpButtH.png"), 
            new Texture("textures/helpButtP.png"), new Texture("textures/exitButtU.png"), new Texture("textures/exitButtH.png"), 
            new Texture("textures/exitButtP.png"));
        
        PlayMenu playMenu = new PlayMenu(new Texture("textures/homeButtU.png"), new Texture("textures/homeButtH.png"), 
            new Texture("textures/homeButtP.png"), new Texture("textures/deoderant.png"), new Texture("textures/dumbbell.png"), 
            new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), new Texture("textures/dumbbell.png"), 
            new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), new Texture("textures/dumbbell.png"), 
            new Texture("textures/golden_fedora.png"));
        
        ControlsMenu controlsMenu = new ControlsMenu(new Texture("textures/homeButtU.png"), new Texture("textures/homeButtH.png"), 
            new Texture("textures/homeButtP.png"), new Texture("textures/controlsButtU.png"), new Texture("textures/controlsButtH.png"), 
            new Texture("textures/controlsButtP.png"), new Texture("textures/instructionsButtU.png"), new Texture("textures/instructionsButtH.png"), 
            new Texture("textures/instructionsButtP.png"));
        
        Game.setCurrentScene("main menu");
        
        Game.start(600, 600, "menu", null, 60, Color.blue);
        
        Game.setWindowSize(Settings.getWindowWidth(), Settings.getWindowWidth());
        
        Settings.setHighScoreSong2(8, 10f);
        Settings.setHighScoreSong2(5, 10f);
        Settings.setHighScoreSong2(4, 10f);
        Settings.setHighScoreSong2(3, 10f);
        Settings.setHighScoreSong2(5, 1f);
        Settings.setHighScoreSong2(5, 9f);

        /*Game.createScene("game");
        
        Zombie zombie = new Zombie(0.1f, 0.1f, "zombie", Color.blue);
        NotesPanel panel = new NotesPanel("panel", Color.DARK_GRAY);
        NotesBar bar = new NotesBar("bar");
        Gun gun = new Gun("gun", Color.MAGENTA, Color.CYAN);
        
        Game.addObjectToScene("game", zombie);
        Game.addObjectToScene("game", panel);
        Game.addObjectToScene("game", bar);
        Game.addObjectToScene("game", gun);
        
        Game.start(1600, 1600, "Our dank game", null, 60, Color.gray);*/
        

    }
    
}
