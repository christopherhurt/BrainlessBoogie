package objects;

import main.SoundBank;
import main.Texture;
import main.TexturedMenuButton;
import main.Utils;

public class EndRestartButton extends TexturedMenuButton {
    
    public static final float DISTANCE_BETWEEN_END_BUTTONS = 0.1f;
    
    private static final float W = 0.1f;
    private static final float H = 0.1f;
    private static final float X = (1 - DISTANCE_BETWEEN_END_BUTTONS) / 2 - W;
    private static final float Y = 0.8f;
    private static final Texture UNHOVERED_WIN = new Texture("textures/restartButtU.png");
    private static final Texture HOVERED_WIN = new Texture("textures/restartButtH.png");
    private static final Texture CLICKED_WIN = new Texture("textures/restartButtP.png");
    private static final Texture UNHOVERED_LOSE = new Texture("textures/restartButtUSuck.png");
    private static final Texture HOVERED_LOSE = new Texture("textures/restartButtHSuck.png");
    private static final Texture CLICKED_LOSE = new Texture("textures/restartButtPSuck.png");
    private static final String ID = "endRestartButton";
    
    public EndRestartButton(boolean win) {
        super(X, Y, W, H, win ? UNHOVERED_WIN : UNHOVERED_LOSE, win ? HOVERED_WIN : HOVERED_LOSE, win ? CLICKED_WIN : CLICKED_LOSE, ID);
    }
    
    @Override
    public void update() {
        if(isReleased()) {
            SoundBank.stopAll();
            Utils.MOUSE_CLICK_SOUND.play();
            Utils.startGame(Utils.getCurrentSong());
        }
    }
    
}
