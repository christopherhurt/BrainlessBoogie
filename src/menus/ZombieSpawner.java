package menus;

import java.awt.Color;
import java.util.List;
import main.AnimatedGameObject;
import main.Animation;
import main.ColoredGameObject;
import main.Game;
import main.GameObject;
import objects.Zombie;

public class ZombieSpawner extends ColoredGameObject {
    
    private static final float MIN_SPAWN_Y = 0.35f;
    private static final float MAX_SPAWN_Y = 0.85f;
    
    private static final float ZOMBIE_SIZE = 0.15f;
    private static final float ZOMBIE_SPEED = 0.002f;
    
    private static final float SPAWN_CHANCE = 0.01f;
    
    public ZombieSpawner() {
        super(0, 0, 0, 0, 0, 0, 0, 0, "zombie spawner", Color.BLACK);
    }
    
    @Override
    public void update() {
        if(Math.random() < SPAWN_CHANCE) {
            boolean leftSide = Math.random() < 0.5;
            float y = (float)(MIN_SPAWN_Y + Math.random() * (MAX_SPAWN_Y - MIN_SPAWN_Y));
            AnimatedGameObject zombie;
            
            if(leftSide) {
                float x = -ZOMBIE_SIZE;
                zombie = new AnimatedGameObject(x, y, ZOMBIE_SPEED, 0, 0, 0, ZOMBIE_SIZE, ZOMBIE_SIZE, "spawned zombie", new Animation(Zombie.ANIM_LENGTH, Zombie.RIGHT_TEXTURES));
            } else {
                float x = 1f;
                zombie = new AnimatedGameObject(x, y, -ZOMBIE_SPEED, 0, 0, 0, ZOMBIE_SIZE, ZOMBIE_SIZE, "spawned zombie", new Animation(Zombie.ANIM_LENGTH, Zombie.LEFT_TEXTURES));
            }
            
            sortZombieInto(zombie, "main menu");
            sortZombieInto(zombie, "help");
            sortZombieInto(zombie, "options");
            sortZombieInto(zombie, "play");
            sortZombieInto(zombie, "controls");
            sortZombieInto(zombie, "high score");
            sortZombieInto(zombie, "high score song 1");
            sortZombieInto(zombie, "high score song 2");
            sortZombieInto(zombie, "high score song 3");
        }
        
        List<GameObject> zombies = Game.getGameObjects("spawned zombie");
        
        for(GameObject zombie : zombies) {
            if((zombie.getVelX() > 0 && zombie.getX() > 1f) || (zombie.getVelX() < 0 && zombie.getX() < -ZOMBIE_SIZE)) {
                Game.removeObjectFromScene("main menu", zombie);
                Game.removeObjectFromScene("help", zombie);
                Game.removeObjectFromScene("options", zombie);
                Game.removeObjectFromScene("play", zombie);
                Game.removeObjectFromScene("controls", zombie);
                Game.removeObjectFromScene("high score", zombie);
                Game.removeObjectFromScene("high score song 1", zombie);
                Game.removeObjectFromScene("high score song 2", zombie);
                Game.removeObjectFromScene("high score song 3", zombie);
            }
        }
    }
    
    private void sortZombieInto(AnimatedGameObject zombie, String sceneID) {
        List<GameObject> objects = Game.getObjectList(sceneID);
        
        for(int i = 1; i < objects.size(); i++) {
            GameObject obj = objects.get(i);
            
            if(!obj.getID().equals("spawned zombie") || (obj.getID().equals("spawned zombie") && obj.getY() > zombie.getY())) {
                objects.add(i, zombie);
                return;
            }
        }
        
        objects.add(zombie);
    }
    
    public static void clearZombies() {
        List<GameObject> zombies = Game.getGameObjects("spawned zombie");
        
        for(GameObject zombie : zombies) {
            Game.removeObjectFromScene("main menu", zombie);
            Game.removeObjectFromScene("help", zombie);
            Game.removeObjectFromScene("options", zombie);
            Game.removeObjectFromScene("play", zombie);
            Game.removeObjectFromScene("controls", zombie);
            Game.removeObjectFromScene("high score", zombie);
            Game.removeObjectFromScene("high score song 1", zombie);
            Game.removeObjectFromScene("high score song 2", zombie);
            Game.removeObjectFromScene("high score song 3", zombie);
        }
    }
    
}
