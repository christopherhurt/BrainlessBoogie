package main;

import java.awt.Color;
import objects.Gun;
import objects.NotesBar;
import objects.NotesPanel;
import objects.Zombie;

public class Runner {
    
    public static void main(String[] args) {
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
