package menus;

import main.Game;
import main.Texture;
import main.TexturedMenuButton;
import main.Utils;

public class HighScoreSong2Button extends TexturedMenuButton {
    
    public HighScoreSong2Button(float x, float y, float w, float h, Texture unhoveredTex,
        Texture hoveredTex, Texture clickedTex, String id) {
        
        super(x, y, w, h, unhoveredTex, hoveredTex, clickedTex, id);
    }
    
    @Override
    public void update() {
        if (isReleased()) {
            Utils.MOUSE_CLICK_SOUND.play();
            
            Game.setCurrentScene("high score song 2");
            Game.getMenu().getLabel("score1song2").setText(scoreOf(Settings.getHighScoresSong2()[0]));
            Game.getMenu().getLabel("percent1song2").setText(percentOf(Settings.getHighPercentagesSong2()[0]));
            
            Game.getMenu().getLabel("score2song2").setText(scoreOf(Settings.getHighScoresSong2()[1]));
            Game.getMenu().getLabel("percent2song2").setText(percentOf(Settings.getHighPercentagesSong2()[1]));
            
            Game.getMenu().getLabel("score3song2").setText(scoreOf(Settings.getHighScoresSong2()[2]));
            Game.getMenu().getLabel("percent3song2").setText(percentOf(Settings.getHighPercentagesSong2()[2]));
            
            Game.getMenu().getLabel("score4song2").setText(scoreOf(Settings.getHighScoresSong2()[3]));
            Game.getMenu().getLabel("percent4song2").setText(percentOf(Settings.getHighPercentagesSong2()[3]));
            
            Game.getMenu().getLabel("score5song2").setText(scoreOf(Settings.getHighScoresSong2()[4]));
            Game.getMenu().getLabel("percent5song2").setText(percentOf(Settings.getHighPercentagesSong2()[4]));
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
            return (int)percent + "";
        }
    }

}
