package menus;

import main.Game;
import main.Texture;
import main.TexturedMenuButton;
import main.Utils;

public class HighScoreSong1Button extends TexturedMenuButton {
    
    public HighScoreSong1Button(float x, float y, float w, float h, Texture unhoveredTex,
        Texture hoveredTex, Texture clickedTex, String id) {
        
        super(x, y, w, h, unhoveredTex, hoveredTex, clickedTex, id);
    }
    
    @Override
    public void update() {
        if (isReleased()) {
            Utils.MOUSE_CLICK_SOUND.play();
            
            Game.setCurrentScene("high score song 1");
            Game.getMenu().getLabel("score1song1").setText("1.  " + scoreOf(Settings.getHighScoresSong1()[0]));
            Game.getMenu().getLabel("percent1song1").setText(percentOf(Settings.getHighPercentagesSong1()[0]));
            
            Game.getMenu().getLabel("score2song1").setText("2.  " + scoreOf(Settings.getHighScoresSong1()[1]));
            Game.getMenu().getLabel("percent2song1").setText(percentOf(Settings.getHighPercentagesSong1()[1]));
            
            Game.getMenu().getLabel("score3song1").setText("3.  " + scoreOf(Settings.getHighScoresSong1()[2]));
            Game.getMenu().getLabel("percent3song1").setText(percentOf(Settings.getHighPercentagesSong1()[2]));
            
            Game.getMenu().getLabel("score4song1").setText("4.  " + scoreOf(Settings.getHighScoresSong1()[3]));
            Game.getMenu().getLabel("percent4song1").setText(percentOf(Settings.getHighPercentagesSong1()[3]));
            
            Game.getMenu().getLabel("score5song1").setText("5.  " + scoreOf(Settings.getHighScoresSong1()[4]));
            Game.getMenu().getLabel("percent5song1").setText(percentOf(Settings.getHighPercentagesSong1()[4]));
        }
    }
    
    private String scoreOf(int score) {
        if (score == 0) {
            return "---";
        } else {
            return score + "";
        }
    }
    
    private String percentOf(float percent) {
        if (percent == 0) {
            return "";
        } else {
            return percent + "";
        }
    }

}
