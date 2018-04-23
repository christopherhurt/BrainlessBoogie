package menus;

import java.util.ArrayList;
import java.util.List;
import main.Game;
import main.SaveFile;

public class Settings {
    
    private static final SaveFile optionsSettings = new SaveFile("data/settings.zmb");
    private static final SaveFile highScoreSong1Settings = new SaveFile("data/highScoresSong1.zmb");
    private static final SaveFile highScoreSong2Settings = new SaveFile("data/highScoresSong2.zmb");
    private static final SaveFile highScoreSong3Settings = new SaveFile("data/highScoresSong3.zmb");
    
    private static float musicVolume = 0;
    private static float sfxVolume = 0;
    private static int windowWidth = 0;
    private static int[] highScoresSong1 = new int[5]; // high score at 0
    private static float[] highPercentagesSong1 = new float[5];
    private static int[] highScoresSong2 = new int[5];
    private static float[] highPercentagesSong2 = new float[5];
    private static int[] highScoresSong3 = new int[5];
    private static float[] highPercentagesSong3 = new float[5];
    
    public static void readSettings(){
        List<String> options = optionsSettings.readLines();
        musicVolume = Float.parseFloat(options.get(0));
        sfxVolume = Float.parseFloat(options.get(1));
        windowWidth = Integer.parseInt(options.get(2));
    }
    
    public static void writeSettings(){        
        
        List<String> settings = new ArrayList<String>(); // music volume 1st line, sfx 2nd, windowwidth 3rd
        settings.add(String.valueOf(musicVolume));
        settings.add(String.valueOf(sfxVolume));
        settings.add(String.valueOf(windowWidth));
        
        optionsSettings.writeLines(settings);
    }
    
    public static void readHighScores(){
        List<String> scoresSong1 = highScoreSong1Settings.readLines(); // even lines score, odd percentage
        List<String> scoresSong2 = highScoreSong2Settings.readLines();
        List<String> scoresSong3 = highScoreSong3Settings.readLines();
        
        for (int i = 0; i < 5; i++) { // score on even, percentage on odd.  1st line high score. 2nd line high percentage
            
            highScoresSong1[i] = Integer.parseInt(scoresSong1.get(2 * i));
            highPercentagesSong1[i] = Float.parseFloat(scoresSong1.get(2 * i + 1));
            
            highScoresSong2[i] = Integer.parseInt(scoresSong2.get(2 * i));
            highPercentagesSong2[i] = Float.parseFloat(scoresSong2.get(2 * i + 1));
            
            highScoresSong3[i] = Integer.parseInt(scoresSong3.get(2 * i));
            highPercentagesSong3[i] = Float.parseFloat(scoresSong3.get(2 * i + 1));
        }
    }
    
    public static void writeHighScores(){        
        
        List<String> scoresSong1 = new ArrayList<String>();
        List<String> scoresSong2 = new ArrayList<String>();
        List<String> scoresSong3 = new ArrayList<String>();
        
        for (int i = 0; i < 5; i++) { // score on even, percentage on odd
            
            scoresSong1.add(String.valueOf(highScoresSong1[i]));
            scoresSong1.add(String.valueOf(highPercentagesSong1[i]));
            
            scoresSong2.add(String.valueOf(highScoresSong2[i]));
            scoresSong2.add(String.valueOf(highPercentagesSong2[i]));
            
            scoresSong3.add(String.valueOf(highScoresSong3[i]));
            scoresSong3.add(String.valueOf(highPercentagesSong3[i]));
        }
        
        highScoreSong1Settings.writeLines(scoresSong1);
        highScoreSong2Settings.writeLines(scoresSong2);
        highScoreSong3Settings.writeLines(scoresSong3);
    }
    
    public static float getMusicVolume(){
        return musicVolume;
    }
    
    public static void setMusicVolume(float volume){
        musicVolume = volume;
        writeSettings();
    }
    
    public static float getSFXVolume(){
        return sfxVolume;
    }
    
    public static void setSFXVolume(float volume){
        sfxVolume = volume;
        writeSettings();
    }
    
    public static int getWindowWidth(){
        return windowWidth;
    }
    
    public static void setWindowWidth(int width){
        windowWidth = width;
        Game.setWindowSize(windowWidth, windowWidth);
        writeSettings();
    }
    
    public static int[] getHighScoresSong1(){
        return highScoresSong1;
    }
    
    public static void setHighScoreSong1(int score, float percent){
        int firstIndex = 5;
        int index = 1;
        float[] equalScorePercent = new float[5];
        float highPercentVal = 0;
        for (int i = 0; i < 5; i++) {
            if (score >= highScoresSong1[i]) {
                
                // array that holds percentages for equal scores.  
                //float[] equalScorePercent = new float[5];
                boolean isFirstIndex = true;
                //int firstIndex = 5;
                //int index = 1;
                
                for (int j = 4; j > i; j--) {               
                    
                    highScoresSong1[j] = highScoresSong1[j - 1];              
                    highPercentagesSong1[j] = highPercentagesSong1[j - 1];
                    
                    if (highScoresSong1[i] == highScoresSong1[j]) {
                        equalScorePercent[index] = highPercentagesSong1[j]; // add percentage to equalScorePercent if equal score
                        // percents will be in reverse order (smallest to largest
                        index++;
                        if (isFirstIndex) { // set first index where equals occur
                            isFirstIndex = false;
                            firstIndex = j;
                        }
                    }
                }
                /*for (int k = 1; k < index; k++) {
                    if (highPercentagesSong1[i] > equalScorePercent[k]) {
                        equalScorePercent[k - 1] = equalScorePercent[k];
                    } else {
                        equalScorePercent[k - 1] = highPercentagesSong1[i];
                        k = index;
                    }
                }
                for (int l = firstIndex; l > firstIndex - index; l--) {
                    highPercentagesSong1[1] = equalScorePercent[firstIndex - l];
                }*/
                highScoresSong1[i] = score;
                highPercentVal = highPercentagesSong1[i];
                i = 5;
            } 
        }
        for (int k = 1; k < index; k++) {
            if (highPercentVal > equalScorePercent[k]) {
                equalScorePercent[k - 1] = equalScorePercent[k];
            } else {
                equalScorePercent[k - 1] = highPercentVal;
                k = index;
            }
        }
        for (int l = firstIndex; l > firstIndex - index; l--) {
            highPercentagesSong1[1] = equalScorePercent[firstIndex - l];
        }
        writeHighScores();
    }
    
    public static int[] getHighScoresSong2(){
        return highScoresSong2;
    }
    
    public static void setHighScoreSong2(int score, float percent){
        for (int i = 0; i < 5; i++) {
            if (score > highScoresSong2[i]) {
                for (int j = 4; j > i; j--) {
                    highScoresSong2[j] = highScoresSong2[j - 1];
                    highPercentagesSong2[j] = highPercentagesSong2[j - 1];
                }
                highScoresSong2[i] = score;
                highPercentagesSong2[i] = percent;
                i = 5;
            } 
        }
        writeHighScores();
    }
    
    public static int[] getHighScoresSong3(){
        return highScoresSong3;
    }
    
    public static void setHighScoreSong3(int score, float percent){
        for (int i = 0; i < 5; i++) {
            if (score > highScoresSong3[i]) {
                for (int j = 4; j > i; j--) {
                    highScoresSong3[j] = highScoresSong3[j - 1];
                    highPercentagesSong3[j] = highPercentagesSong3[j - 1];
                }
                highScoresSong3[i] = score;
                highPercentagesSong3[i] = percent;
                i = 5;
            } 
        }
        writeHighScores();
    }
    
    public static float[] getHighPercentagesSong1(){
        return highPercentagesSong1;
    }
    
    public static float[] getHighPercentagesSong2(){
        return highPercentagesSong2;
    }
    
    public static float[] getHighPercentagesSong3(){
        return highPercentagesSong3;
    }

}
