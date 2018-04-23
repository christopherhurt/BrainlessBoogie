package main;

import java.awt.Color;

public class Runner {
    
    public static void main(String[] args) {
        Utils.constructWinScreen();
        Utils.constructLoseScreen();
        Game.createScene("game");
        Utils.startGame();
        Game.start(1600, 1600, "Our dank game", null, Utils.FPS, Color.GREEN);
        
        // TODO: remove this line when menus are added
        Game.setCursor(Utils.GUN_CROSSHAIR);
    }
    
}
