package menus;

import main.Game;
import main.Texture;
import main.TexturedMenuButton;
import main.Utils;

public class HighScoreSong3Button extends TexturedMenuButton {
    
    public HighScoreSong3Button(float x, float y, float w, float h, Texture unhoveredTex,
        Texture hoveredTex, Texture clickedTex, String id) {
        
        super(x, y, w, h, unhoveredTex, hoveredTex, clickedTex, id);
    }
    
    @Override
    public void update() {
        
        if (isReleased()) {
            Utils.MOUSE_CLICK_SOUND.play();
            
            Game.setCurrentScene("high score song 3");
            Game.getMenu().getLabel("score1song3").setText("1.  " + scoreOf(Settings.getHighScoresSong3()[0]));
            Game.getMenu().getLabel("percent1song3").setText(percentOf(Settings.getHighPercentagesSong3()[0]));
            
            Game.getMenu().getLabel("score2song3").setText("2.  " + scoreOf(Settings.getHighScoresSong3()[1]));
            Game.getMenu().getLabel("percent2song3").setText(percentOf(Settings.getHighPercentagesSong3()[1]));
            
            Game.getMenu().getLabel("score3song3").setText("3.  " + scoreOf(Settings.getHighScoresSong3()[2]));
            Game.getMenu().getLabel("percent3song3").setText(percentOf(Settings.getHighPercentagesSong3()[2]));
            
            Game.getMenu().getLabel("score4song3").setText("4.  " + scoreOf(Settings.getHighScoresSong3()[3]));
            Game.getMenu().getLabel("percent4song3").setText(percentOf(Settings.getHighPercentagesSong3()[3]));
            
            Game.getMenu().getLabel("score5song3").setText("5.  " + scoreOf(Settings.getHighScoresSong3()[4]));
            Game.getMenu().getLabel("percent5song3").setText(percentOf(Settings.getHighPercentagesSong3()[4]));
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
