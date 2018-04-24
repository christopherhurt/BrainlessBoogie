package menus;

import java.awt.Color;
import main.Game;
import main.Menu;
import main.MenuLabel;
import main.Texture;
import main.TexturedGameObject;

public class HighScoreSong1Menu {
    
    private Menu highScoreSong1Menu;

    private static final float SCORE_OFFSET = .121f;
    private static final float SCORE_X = .15f;
    private static final float PERCENT_OFFSET = .43f;
    private static final float PERCENT_X = SCORE_X + PERCENT_OFFSET;
    private static final float SCORE1_Y = .296f;
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
    
    public HighScoreSong1Menu(Texture backUnhovered, Texture backHovered, Texture backClicked) {
        HighScoreSong1Menu.backUnhovered = backUnhovered;
        HighScoreSong1Menu.backHovered = backHovered;
        HighScoreSong1Menu.backClicked = backClicked;
        
        Game.createScene("high score song 1");
        highScoreSong1Menu = new Menu("high score song 1");
        constructMenu();
        Game.attachMenuToScene("high score song 1", highScoreSong1Menu);
        
        float num1Y = 0.23f;
        float numH = 0.08f;
        float numW = numH * 24f / 26f;
        float numX = .05f;
        float distBetween = 0.04f;
        
        TexturedGameObject num1 = new TexturedGameObject(numX, num1Y, 0, 0, 0, 0, numW, numH, "num1", new Texture("textures/1Label.png"));
        TexturedGameObject num2 = new TexturedGameObject(numX, num1Y + numH + distBetween, 0, 0, 0, 0, numW, numH, "num2", new Texture("textures/2Label.png"));
        TexturedGameObject num3 = new TexturedGameObject(numX, num1Y + 2 * (numH + distBetween), 0, 0, 0, 0, numW, numH, "num3", new Texture("textures/3Label.png"));
        TexturedGameObject num4 = new TexturedGameObject(numX, num1Y + 3 * (numH + distBetween), 0, 0, 0, 0, numW, numH, "num4", new Texture("textures/4Label.png"));
        TexturedGameObject num5 = new TexturedGameObject(numX, num1Y + 4 * (numH + distBetween), 0, 0, 0, 0, numW, numH, "num5", new Texture("textures/5Label.png"));
        
        Game.addObjectToScene("high score song 1", num1);
        Game.addObjectToScene("high score song 1", num2);
        Game.addObjectToScene("high score song 1", num3);
        Game.addObjectToScene("high score song 1", num4);
        Game.addObjectToScene("high score song 1", num5);
        
        float scoreY = 0.075f;
        float scoreH = 0.1f;
        float scoreW = scoreH * 68f / 26f;
        float distanceFromCenter = 0.25f;
        float scoreX = 0.5f - scoreW / 2 - distanceFromCenter;
        TexturedGameObject scoreBanner = new TexturedGameObject(scoreX, scoreY, 0, 0, 0, 0, scoreW, scoreH, "scoreBanner", new Texture("textures/scoreBanner.png"));
        Game.addObjectToScene("high score song 1", scoreBanner);
        
        float percentW = scoreH * 90f / 26f;
        float percentX = 0.5f - percentW / 2 + distanceFromCenter;
        TexturedGameObject percentBanner = new TexturedGameObject(percentX, scoreY, 0, 0, 0, 0, percentW, scoreH, "percentBanner", new Texture("textures/percentBanner.png"));
        Game.addObjectToScene("high score song 1", percentBanner);
    }
    
    public void constructMenu() {        
        BackButton backButton = new BackButton(BACK_X, BACK_Y, BACK_WIDTH, BACK_HEIGHT, backUnhovered, backHovered, backClicked, "home");
        
        int[] highScores = Settings.getHighScoresSong1();
        float[] percentages = Settings.getHighPercentagesSong1();
        
        MenuLabel score1 = new MenuLabel(scoreOf(highScores[0]), 
            "Sans Serif", 1, FONT_SIZE, Color.WHITE, SCORE_X, SCORE1_Y, "score1song1");
        MenuLabel score2 = new MenuLabel(scoreOf(highScores[1]), 
            "Sans Serif", 1, FONT_SIZE, Color.WHITE, SCORE_X, SCORE2_Y, "score2song1");
        MenuLabel score3 = new MenuLabel(scoreOf(highScores[2]), 
            "Sans Serif", 1, FONT_SIZE, Color.WHITE, SCORE_X, SCORE3_Y, "score3song1");
        MenuLabel score4 = new MenuLabel(scoreOf(highScores[3]), 
            "Sans Serif", 1, FONT_SIZE, Color.WHITE, SCORE_X, SCORE4_Y, "score4song1");
        MenuLabel score5 = new MenuLabel(scoreOf(highScores[4]), 
            "Sans Serif", 1, FONT_SIZE, Color.WHITE, SCORE_X, SCORE5_Y, "score5song1");
        MenuLabel percent1 = new MenuLabel(percentOf(percentages[0]), 
            "Sans Serif", 1, FONT_SIZE, Color.WHITE, PERCENT_X, SCORE1_Y, "percent1song1");
        MenuLabel percent2 = new MenuLabel(percentOf(percentages[1]), 
            "Sans Serif", 1, FONT_SIZE, Color.WHITE, PERCENT_X, SCORE2_Y, "percent2song1");
        MenuLabel percent3 = new MenuLabel(percentOf(percentages[2]), 
            "Sans Serif", 1, FONT_SIZE, Color.WHITE, PERCENT_X, SCORE3_Y, "percent3song1");
        MenuLabel percent4 = new MenuLabel(percentOf(percentages[3]), 
            "Sans Serif", 1, FONT_SIZE, Color.WHITE, PERCENT_X, SCORE4_Y, "percent4song1");
        MenuLabel percent5 = new MenuLabel(percentOf(percentages[4]), 
            "Sans Serif", 1, FONT_SIZE, Color.WHITE, PERCENT_X, SCORE5_Y, "percent5song1");
        
        highScoreSong1Menu.addButton(backButton);
        highScoreSong1Menu.addLabel(score1);
        highScoreSong1Menu.addLabel(score2);
        highScoreSong1Menu.addLabel(score3);
        highScoreSong1Menu.addLabel(score4);
        highScoreSong1Menu.addLabel(score5);
        highScoreSong1Menu.addLabel(percent1);
        highScoreSong1Menu.addLabel(percent2);
        highScoreSong1Menu.addLabel(percent3);
        highScoreSong1Menu.addLabel(percent4);
        highScoreSong1Menu.addLabel(percent5);
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
