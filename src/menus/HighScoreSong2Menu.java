package menus;

import java.awt.Color;
import main.Game;
import main.Menu;
import main.MenuLabel;
import main.Texture;

public class HighScoreSong2Menu {
    
    private Menu highScoreSong2Menu;

    private static final float SCORE_OFFSET = .15f;
    private static final float SCORE_X = .1f;
    private static final float PERCENT_OFFSET = .6f;
    private static final float PERCENT_X = SCORE_X + PERCENT_OFFSET;
    private static final float SCORE1_Y = .3f;
    private static final float SCORE2_Y = SCORE1_Y + SCORE_OFFSET;
    private static final float SCORE3_Y = SCORE2_Y + SCORE_OFFSET;
    private static final float SCORE4_Y = SCORE3_Y + SCORE_OFFSET;
    private static final float SCORE5_Y = SCORE4_Y + SCORE_OFFSET;
    
    private static final float BACK_X = .025f;
    private static final float BACK_Y = .875f;
    private static final float BACK_HEIGHT = .1f;    
    private static final float BACK_WIDTH = BACK_HEIGHT * 3 / 4;
    
    private static Texture backUnhovered;
    private static Texture backHovered;
    private static Texture backClicked;
    
    public HighScoreSong2Menu(Texture backUnhovered, Texture backHovered, Texture backClicked) {
        
        HighScoreSong2Menu.backUnhovered = backUnhovered;
        HighScoreSong2Menu.backHovered = backHovered;
        HighScoreSong2Menu.backClicked = backClicked;
        
        Game.createScene("high score song 2");
        highScoreSong2Menu = new Menu("high score song 2");
        constructMenu();
        Game.attachMenuToScene("high score song 2", highScoreSong2Menu);
    }
    
    public void constructMenu() {
        
        BackButton backButton = new BackButton(BACK_X, BACK_Y, BACK_WIDTH, BACK_HEIGHT, backUnhovered, backHovered, backClicked, "home");
        
        MenuLabel score1 = new MenuLabel("1.  " + scoreOf(Settings.getHighScoresSong2()[0]), 
            "Sans Serif", 1, 0.1f, Color.BLACK, SCORE_X, SCORE1_Y, "score1song2");
        MenuLabel score2 = new MenuLabel("2.  " + scoreOf(Settings.getHighScoresSong2()[1]), 
            "Sans Serif", 1, 0.1f, Color.BLACK, SCORE_X, SCORE2_Y, "score2song2");
        MenuLabel score3 = new MenuLabel("3.  " + scoreOf(Settings.getHighScoresSong2()[2]), 
            "Sans Serif", 1, 0.1f, Color.BLACK, SCORE_X, SCORE3_Y, "score3song2");
        MenuLabel score4 = new MenuLabel("4.  " + scoreOf(Settings.getHighScoresSong2()[3]), 
            "Sans Serif", 1, 0.1f, Color.BLACK, SCORE_X, SCORE4_Y, "score4song2");
        MenuLabel score5 = new MenuLabel("5.  " + scoreOf(Settings.getHighScoresSong2()[4]), 
            "Sans Serif", 1, 0.1f, Color.BLACK, SCORE_X, SCORE5_Y, "score5song2");
        MenuLabel percent1 = new MenuLabel(percentOf(Settings.getHighPercentagesSong2()[0]), 
            "Sans Serif", 1, 0.1f, Color.BLACK, PERCENT_X, SCORE1_Y, "percent1song2");
        MenuLabel percent2 = new MenuLabel(percentOf(Settings.getHighPercentagesSong2()[1]), 
            "Sans Serif", 1, 0.1f, Color.BLACK, PERCENT_X, SCORE2_Y, "percent2song2");
        MenuLabel percent3 = new MenuLabel(percentOf(Settings.getHighPercentagesSong2()[2]), 
            "Sans Serif", 1, 0.1f, Color.BLACK, PERCENT_X, SCORE3_Y, "percent3song2");
        MenuLabel percent4 = new MenuLabel(percentOf(Settings.getHighPercentagesSong2()[3]), 
            "Sans Serif", 1, 0.1f, Color.BLACK, PERCENT_X, SCORE4_Y, "percent4song2");
        MenuLabel percent5 = new MenuLabel(percentOf(Settings.getHighPercentagesSong2()[4]), 
            "Sans Serif", 1, 0.1f, Color.BLACK, PERCENT_X, SCORE5_Y, "percent5song2");
       
        highScoreSong2Menu.addButton(backButton);
        highScoreSong2Menu.addLabel(score1);
        highScoreSong2Menu.addLabel(score2);
        highScoreSong2Menu.addLabel(score3);
        highScoreSong2Menu.addLabel(score4);
        highScoreSong2Menu.addLabel(score5);
        highScoreSong2Menu.addLabel(percent1);
        highScoreSong2Menu.addLabel(percent2);
        highScoreSong2Menu.addLabel(percent3);
        highScoreSong2Menu.addLabel(percent4);
        highScoreSong2Menu.addLabel(percent5);
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
