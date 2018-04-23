package objects;

import main.Game;
import main.SoundBank;
import main.Texture;
import main.TexturedMenuButton;
import main.Utils;
import menus.ZombieSpawner;

public class EndHomeButton extends TexturedMenuButton {
    
    private static final float X = (1 + EndRestartButton.DISTANCE_BETWEEN_END_BUTTONS) / 2;
    private static final float Y = 0.8f;
    private static final float W = 0.1f;
    private static final float H = 0.1f;
    private static final Texture UNHOVERED_WIN = new Texture("textures/homeButtU.png");
    private static final Texture HOVERED_WIN = new Texture("textures/homeButtH.png");
    private static final Texture CLICKED_WIN = new Texture("textures/homeButtP.png");
    private static final Texture UNHOVERED_LOSE = new Texture("textures/homeButtUSuck.png");
    private static final Texture HOVERED_LOSE = new Texture("textures/homeButtHSuck.png");
    private static final Texture CLICKED_LOSE = new Texture("textures/homeButtPSuck.png");
    private static final String ID = "endHomeButton";
    
    public EndHomeButton(boolean win) {
        super(X, Y, W, H, win ? UNHOVERED_WIN : UNHOVERED_LOSE, win ? HOVERED_WIN : HOVERED_LOSE, win ? CLICKED_WIN : CLICKED_LOSE, ID);
    }
    
    @Override
    public void update() {
        if(isReleased()) {
            SoundBank.stopAll();
            Utils.MOUSE_CLICK_SOUND.play();
            Utils.MENU_MUSIC.play();
            Game.setCurrentScene("main menu");
            ZombieSpawner.clearZombies();
        }
    }
    
}
