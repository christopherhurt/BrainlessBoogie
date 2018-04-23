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

public class Runner {
    
    public static void main(String[] args) {
        Settings.readSettings();
        Settings.readHighScores();
        
        new HelpMenu(new Texture("textures/homeButtU.png"), new Texture("textures/homeButtH.png"), 
            new Texture("textures/homeButtP.png"), new Texture("textures/controlsButtU.png"), new Texture("textures/controlsButtH.png"), 
            new Texture("textures/controlsButtP.png"), new Texture("textures/instructionsButtU.png"), new Texture("textures/instructionsButtH.png"), 
            new Texture("textures/instructionsButtP.png"));
        new HighScoreMenu(new Texture("textures/homeButtU.png"), new Texture("textures/homeButtH.png"), 
            new Texture("textures/homeButtP.png"), new Texture("textures/deoderant.png"), 
            new Texture("textures/dumbbell.png"), new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), 
            new Texture("textures/dumbbell.png"), new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), 
            new Texture("textures/dumbbell.png"), new Texture("textures/golden_fedora.png"));
        new HighScoreSong1Menu(new Texture("textures/backButtU.png"), new Texture("textures/backButtH.png"), 
            new Texture("textures/backButtP.png"));
        new HighScoreSong2Menu(new Texture("textures/backButtU.png"), new Texture("textures/backButtH.png"), 
            new Texture("textures/backButtP.png"));
        new HighScoreSong3Menu(new Texture("textures/backButtU.png"), new Texture("textures/backButtH.png"), 
            new Texture("textures/backButtP.png"));
        new OptionsMenu(new Texture("textures/homeButtU.png"), new Texture("textures/homeButtH.png"), 
            new Texture("textures/homeButtP.png"), new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), 
            new Texture("textures/dumbbell.png"), new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), 
            new Texture("textures/dumbbell.png"), new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), 
            new Texture("textures/dumbbell.png"), new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), 
            new Texture("textures/dumbbell.png"), new Texture("textures/golden_fedora.png"));
        
        new MainMenu(new Texture("textures/playButtU.png"), new Texture("textures/playButtH.png"), 
            new Texture("textures/playButtP.png"), new Texture("textures/highScoreButtU.png"), new Texture("textures/highScoreButtH.png"), 
            new Texture("textures/highScoreButtP.png"), new Texture("textures/optionsButtU.png"), new Texture("textures/optionsButtH.png"), 
            new Texture("textures/optionsButtP.png"), new Texture("textures/helpButtU.png"), new Texture("textures/helpButtH.png"), 
            new Texture("textures/helpButtP.png"), new Texture("textures/exitButtU.png"), new Texture("textures/exitButtH.png"), 
            new Texture("textures/exitButtP.png"));
        
        new PlayMenu(new Texture("textures/homeButtU.png"), new Texture("textures/homeButtH.png"), 
            new Texture("textures/homeButtP.png"), new Texture("textures/deoderant.png"), new Texture("textures/dumbbell.png"), 
            new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), new Texture("textures/dumbbell.png"), 
            new Texture("textures/golden_fedora.png"), new Texture("textures/deoderant.png"), new Texture("textures/dumbbell.png"), 
            new Texture("textures/golden_fedora.png"));
        
        new ControlsMenu(new Texture("textures/homeButtU.png"), new Texture("textures/homeButtH.png"), 
            new Texture("textures/homeButtP.png"), new Texture("textures/controlsButtU.png"), new Texture("textures/controlsButtH.png"), 
            new Texture("textures/controlsButtP.png"), new Texture("textures/instructionsButtU.png"), new Texture("textures/instructionsButtH.png"), 
            new Texture("textures/instructionsButtP.png"));
        
        Game.setCurrentScene("main menu");
        
        Utils.constructWinScreen();
        Utils.constructLoseScreen();
        Game.createScene("game");
        
        Utils.MENU_MUSIC.play();
        Game.start(1600, 1600, "Brainless Boogie", "textures/icon.png", 60, Color.blue);
        
        // TODO: TEMP
//        Game.setWindowSize(Settings.getWindowWidth(), Settings.getWindowWidth());
    }
    
}
