package menus;

import java.util.ArrayList;
import java.util.List;
import main.SaveFile;

public class Settings {
    
    private static final SaveFile optionsSettings = new SaveFile("/data/settings.zmb");
    private static final SaveFile highScoreSong1Settings = new SaveFile("/data/highScoresSong1.zmb");
    private static final SaveFile highScoreSong2Settings = new SaveFile("/data/highScoresSong2.zmb");
    private static final SaveFile highScoreSong3Settings = new SaveFile("/data/highScoresSong3.zmb");
    
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
    
    public static void writeOptions(){        
        
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
    }
    
    public static float getMusicVolume(){
        return musicVolume;
    }
    
    public static void setMusicVolume(float volume){
        musicVolume = volume;
    }
    
    public static float getSFXVolume(){
        return sfxVolume;
    }
    
    public static void setSFXVolume(float volume){
        sfxVolume = volume;
    }
    
    public static int getWindowWidth(){
        return windowWidth;
    }
    
    public static void setWindowWidth(int width){
        windowWidth = width;
    }
    
    public static int[] getHighScoresSong1(){
        return highScoresSong1;
    }
    
    public static void setHighScoreSong1(int score){
        int newPos = 0;
        for (int i = 0; i < 5; i++) {
            if (score > highScoresSong1[i]) {
                newPos = i;
                i++;
                while (i < 5) {
                    highScoresSong1[i] = highScoresSong1[i - 1];
                    i++;
                }
                highScoresSong1[newPos] = score;
            } 
        }
    }
    
    public static int[] getHighScoresSong2(){
        return highScoresSong2;
    }
    
    public static void setHighScoreSong2(int index, int score){
        int newPos = 0;
        for (int i = 0; i < 5; i++) {
            if (score > highScoresSong2[i]) {
                newPos = i;
                i++;
                while (i < 5) {
                    highScoresSong2[i] = highScoresSong2[i - 1];
                    i++;
                }
                highScoresSong2[newPos] = score;
            } 
        }
    }
    
    public static int[] getHighScoresSong3(){
        return highScoresSong3;
    }
    
    public static void setHighScoreSong3(int index, int score){
        int newPos = 0;
        for (int i = 0; i < 5; i++) {
            if (score > highScoresSong3[i]) {
                newPos = i;
                i++;
                while (i < 5) {
                    highScoresSong3[i] = highScoresSong3[i - 1];
                    i++;
                }
                highScoresSong3[newPos] = score;
            } 
        }
    }
    
    public static float[] getHighPercentagesSong1(){
        return highPercentagesSong1;
    }
    
    public static void setHighPercentageSong1(int index, float score){
        int newPos = 0;
        for (int i = 0; i < 5; i++) {
            if (score > highPercentagesSong1[i]) {
                newPos = i;
                i++;
                while (i < 5) {
                    highPercentagesSong1[i] = highPercentagesSong1[i - 1];
                    i++;
                }
                highPercentagesSong1[newPos] = score;
            } 
        }
    }
    
    public static float[] getHighPercentagesSong2(){
        return highPercentagesSong2;
    }
    
    public static void setHighScoreSong2(int index, float score){
        int newPos = 0;
        for (int i = 0; i < 5; i++) {
            if (score > highPercentagesSong2[i]) {
                newPos = i;
                i++;
                while (i < 5) {
                    highPercentagesSong2[i] = highPercentagesSong2[i - 1];
                    i++;
                }
                highPercentagesSong2[newPos] = score;
            } 
        }
    }
    
    public static float[] getHighPerentagesSong3(){
        return highPercentagesSong3;
    }
    
    public static void setHighPercentageSong3(int index, float score){
        int newPos = 0;
        for (int i = 0; i < 5; i++) {
            if (score > highPercentagesSong3[i]) {
                newPos = i;
                i++;
                while (i < 5) {
                    highPercentagesSong3[i] = highPercentagesSong3[i - 1];
                    i++;
                }
                highPercentagesSong3[newPos] = score;
            } 
        }
    }

}
