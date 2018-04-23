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
import menus.ZombieSpawner;

public class Runner {
    
    public static void main(String[] args) {
        Settings.readSettings();
        Settings.readHighScores();
        
        Game.createScene("main menu");
        Game.createScene("help");
        Game.createScene("options");
        Game.createScene("play");
        Game.createScene("controls");
        Game.createScene("high score");
        Game.createScene("high score song 1");
        Game.createScene("high score song 2");
        Game.createScene("high score song 3");
        
        TexturedGameObject menuBackground = new TexturedGameObject(0, 0, 0, 0, 0, 0, 1, 1, "menuBackground", new Texture("textures/backgroundMainMenu.png"));
        Game.addObjectToScene("main menu", menuBackground);
        Game.addObjectToScene("help", menuBackground);
        Game.addObjectToScene("options", menuBackground);
        Game.addObjectToScene("play", menuBackground);
        Game.addObjectToScene("controls", menuBackground);
        Game.addObjectToScene("high score", menuBackground);
        Game.addObjectToScene("high score song 1", menuBackground);
        Game.addObjectToScene("high score song 2", menuBackground);
        Game.addObjectToScene("high score song 3", menuBackground);
        
        Game.addObjectToScene("main menu", new ZombieSpawner());
        Game.addObjectToScene("help", new ZombieSpawner());
        Game.addObjectToScene("options", new ZombieSpawner());
        Game.addObjectToScene("play", new ZombieSpawner());
        Game.addObjectToScene("controls", new ZombieSpawner());
        Game.addObjectToScene("high score", new ZombieSpawner());
        Game.addObjectToScene("high score song 1", new ZombieSpawner());
        Game.addObjectToScene("high score song 2", new ZombieSpawner());
        Game.addObjectToScene("high score song 3", new ZombieSpawner());
        
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
            new Texture("textures/homeButtP.png"), new Texture("textures/slider.png"), new Texture("textures/sliderH.png"), new Texture("textures/sliderP.png"), new Texture("textures/sliderBar.png"),
            new Texture("textures/size800U.png"), new Texture("textures/size800H.png"), new Texture("textures/size800P.png"),
            new Texture("textures/size1200U.png"), new Texture("textures/size1200H.png"), new Texture("textures/size1200P.png"),
            new Texture("textures/size1600U.png"), new Texture("textures/size1600H.png"), new Texture("textures/size1600P.png"),
            new Texture("textures/size2000U.png"), new Texture("textures/size2000H.png"), new Texture("textures/size2000P.png"));
        
        new MainMenu(new Texture("textures/playButtU.png"), new Texture("textures/playButtH.png"), 
            new Texture("textures/playButtP.png"), new Texture("textures/highScoreButtU.png"), new Texture("textures/highScoreButtH.png"), 
            new Texture("textures/highScoreButtP.png"), new Texture("textures/optionsButtU.png"), new Texture("textures/optionsButtH.png"), 
            new Texture("textures/optionsButtP.png"), new Texture("textures/helpButtU.png"), new Texture("textures/helpButtH.png"), 
            new Texture("textures/helpButtP.png"), new Texture("textures/exitButtU.png"), new Texture("textures/exitButtH.png"), 
            new Texture("textures/exitButtP.png"));
        
        new PlayMenu(new Texture("textures/homeButtU.png"), new Texture("textures/homeButtH.png"), new Texture("textures/homeButtP.png"),
            new Texture("textures/song1ButtU.png"), new Texture("textures/song1ButtH.png"), new Texture("textures/song1ButtP.png"),
            new Texture("textures/song2ButtU.png"), new Texture("textures/song2ButtH.png"), new Texture("textures/song2ButtP.png"),
            new Texture("textures/song3ButtU.png"), new Texture("textures/song3ButtH.png"), new Texture("textures/song3ButtP.png"));
        
        new ControlsMenu(new Texture("textures/homeButtU.png"), new Texture("textures/homeButtH.png"), 
            new Texture("textures/homeButtP.png"), new Texture("textures/controlsButtU.png"), new Texture("textures/controlsButtH.png"), 
            new Texture("textures/controlsButtP.png"), new Texture("textures/instructionsButtU.png"), new Texture("textures/instructionsButtH.png"), 
            new Texture("textures/instructionsButtP.png"));
        
        Game.setCurrentScene("main menu");
        
        Utils.constructWinScreen();
        Utils.constructLoseScreen();
        Utils.updateVolume(Settings.getMusicVolume(), Settings.getSFXVolume());
        Game.createScene("game");
        
        Utils.MENU_MUSIC.play();
        Game.start(1600, 1600, "Brainless Boogie", "textures/icon.png", 60, Color.blue);
        Game.setWindowSize(Settings.getWindowWidth(), Settings.getWindowWidth());
    }
    
}
