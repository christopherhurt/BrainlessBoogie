package menus;

import java.awt.Color;
import main.Game;
import main.Menu;
import main.MenuLabel;
import main.Texture;

public class HighScoreSong3Menu {
    
    private Menu highScoreSong3Menu;

    private static final float SCORE_OFFSET = .12f;
    private static final float SCORE_X = .075f;
    private static final float PERCENT_OFFSET = .6f;
    private static final float PERCENT_X = SCORE_X + PERCENT_OFFSET;
    private static final float SCORE1_Y = .35f;
    private static final float SCORE2_Y = SCORE1_Y + SCORE_OFFSET;
    private static final float SCORE3_Y = SCORE2_Y + SCORE_OFFSET;
    private static final float SCORE4_Y = SCORE3_Y + SCORE_OFFSET;
    private static final float SCORE5_Y = SCORE4_Y + SCORE_OFFSET;
    
    
    private static final float FONT_SIZE = .08f;
    
    private static final float BACK_X = .025f;
    private static final float BACK_Y = .875f;
    private static final float BACK_HEIGHT = .1f;    
    private static final float BACK_WIDTH = BACK_HEIGHT;
    
    private static Texture backUnhovered;
    private static Texture backHovered;
    private static Texture backClicked;
    
    public HighScoreSong3Menu(Texture backUnhovered, Texture backHovered, Texture backClicked) {
        
        HighScoreSong3Menu.backUnhovered = backUnhovered;
        HighScoreSong3Menu.backHovered = backHovered;
        HighScoreSong3Menu.backClicked = backClicked;
        
        Game.createScene("high score song 3");
        highScoreSong3Menu = new Menu("high score song 3");
        constructMenu();
        Game.attachMenuToScene("high score song 3", highScoreSong3Menu);
    }
    
    public void constructMenu() {
        
        BackButton backButton = new BackButton(BACK_X, BACK_Y, BACK_WIDTH, BACK_HEIGHT, backUnhovered, backHovered, backClicked, "home");
        MenuLabel score1 = new MenuLabel("1.  " + scoreOf(Settings.getHighScoresSong3()[0]), 
            "Sans Serif", 1, FONT_SIZE, Color.BLACK, SCORE_X, SCORE1_Y, "score1song3");
        MenuLabel score2 = new MenuLabel("2.  " + scoreOf(Settings.getHighScoresSong3()[1]), 
            "Sans Serif", 1, FONT_SIZE, Color.BLACK, SCORE_X, SCORE2_Y, "score2song3");
        MenuLabel score3 = new MenuLabel("3.  " + scoreOf(Settings.getHighScoresSong3()[2]), 
            "Sans Serif", 1, FONT_SIZE, Color.BLACK, SCORE_X, SCORE3_Y, "score3song3");
        MenuLabel score4 = new MenuLabel("4.  " + scoreOf(Settings.getHighScoresSong3()[3]), 
            "Sans Serif", 1, FONT_SIZE, Color.BLACK, SCORE_X, SCORE4_Y, "score4song3");
        MenuLabel score5 = new MenuLabel("5.  " + scoreOf(Settings.getHighScoresSong3()[4]), 
            "Sans Serif", 1, FONT_SIZE, Color.BLACK, SCORE_X, SCORE5_Y, "score5song3");
        MenuLabel percent1 = new MenuLabel(percentOf(Settings.getHighPercentagesSong3()[0]), 
            "Sans Serif", 1, FONT_SIZE, Color.BLACK, PERCENT_X, SCORE1_Y, "percent1song3");
        MenuLabel percent2 = new MenuLabel(percentOf(Settings.getHighPercentagesSong3()[1]), 
            "Sans Serif", 1, FONT_SIZE, Color.BLACK, PERCENT_X, SCORE2_Y, "percent2song3");
        MenuLabel percent3 = new MenuLabel(percentOf(Settings.getHighPercentagesSong3()[2]), 
            "Sans Serif", 1, FONT_SIZE, Color.BLACK, PERCENT_X, SCORE3_Y, "percent3song3");
        MenuLabel percent4 = new MenuLabel(percentOf(Settings.getHighPercentagesSong3()[3]), 
            "Sans Serif", 1, FONT_SIZE, Color.BLACK, PERCENT_X, SCORE4_Y, "percent4song3");
        MenuLabel percent5 = new MenuLabel(percentOf(Settings.getHighPercentagesSong3()[4]), 
            "Sans Serif", 1, FONT_SIZE, Color.BLACK, PERCENT_X, SCORE5_Y, "percent5song3");
        
        highScoreSong3Menu.addButton(backButton);
        highScoreSong3Menu.addLabel(score1);
        highScoreSong3Menu.addLabel(score2);
        highScoreSong3Menu.addLabel(score3);
        highScoreSong3Menu.addLabel(score4);
        highScoreSong3Menu.addLabel(score5);
        highScoreSong3Menu.addLabel(percent1);
        highScoreSong3Menu.addLabel(percent2);
        highScoreSong3Menu.addLabel(percent3);
        highScoreSong3Menu.addLabel(percent4);
        highScoreSong3Menu.addLabel(percent5);
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
        } else if (percent < 10){
            return "  " + percent + "%";
        } else if (percent < 100) {
            return " " + percent + "%";
        } else {
            return "" + percent + "%";
        }
    }

}
