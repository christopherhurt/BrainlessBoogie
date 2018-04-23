package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import objects.EndHomeButton;
import objects.EndRestartButton;
import objects.Gun;
import objects.NotesBar;
import objects.NotesPanel;

public class Utils {
    
    public static final int FPS = 60;
    
    public static final Sound SONG_1_MUSIC = genSound("gameMusic1", "music/ludem1song.wav", false, 1); // TODO: adjust for proper volume settings
    public static final Sound SONG_2_MUSIC = genSound("gameMusic2", "music/ludem2song.wav", false, 1);
    public static final Sound SONG_3_MUSIC = genSound("gameMusic3", "music/ludem3song.wav", false, 1);
    
    public static final String SONG_1_NOTES = "res/notes/ludem1.txt";
    public static final String SONG_2_NOTES = "res/notes/ludem2.txt";
    public static final String SONG_3_NOTES = "res/notes/ludem3.txt";
    
    public static final SpriteSheet BUTTON_SHEET = new SpriteSheet("textures/buttons.png", 8, 8);
    public static final SpriteSheet ZOMBIE_SHEET = new SpriteSheet("textures/zombieshites53.png", 8, 8);
    public static final SpriteSheet DIAL_SHEET = new SpriteSheet("textures/dial.png", 8, 8);
    public static final SpriteSheet GUN_SHEET = new SpriteSheet("textures/gun.png", 8, 8);
    
    public static final Cursor GUN_CROSSHAIR = genGunCrosshair();
    
    public static final float ZOMBIE_DEATH_VOLUME_MULTIPLIER = 0.75f; // TODO: adjust for volume settings
    public static final Sound ZOMBIE_DEATH_SOUND = genSound("zombieDeath", "sounds/zombieDeath.wav", false, ZOMBIE_DEATH_VOLUME_MULTIPLIER);
    
    public static final float GUNSHOT_VOLUME_MULTIPLIER = 0.4f;
    public static final Sound GUNSHOT_SOUND = genSound("gunshot", "sounds/gunshot.wav", false, GUNSHOT_VOLUME_MULTIPLIER);
    
    public static final float HEADSHOT_VOLUME_MULTIPLIER = 1f;
    public static final Sound HEADSHOT_SOUND = genSound("headshot", "sounds/headshot.wav", false, HEADSHOT_VOLUME_MULTIPLIER);
    
    public static final float WIN_VOLUME_MULTIPLIER = 0.3f;
    public static final Sound WIN_SOUND = genSound("win", "sounds/yay.wav", false, WIN_VOLUME_MULTIPLIER);
    
    public static final float LOSE_VOLUME_MULTIPLIER = 1f;
    public static final Sound LOSE_SOUND = genSound("lose", "sounds/usuck.wav", false, LOSE_VOLUME_MULTIPLIER);
    
    public static final float MOUSE_CLICK_MULTIPLIER = 0.4f;
    public static final Sound MOUSE_CLICK_SOUND = genSound("mouseClick", "sounds/mouseClick.wav", false, MOUSE_CLICK_MULTIPLIER);
    
    public static final float MENU_MULTIPLIER = 1f;
    public static final Sound MENU_MUSIC = genSound("menuMusic", "music/ludummenu.wav", true, MENU_MULTIPLIER);
    
    private static int currentSong = 0;
    
    public static void constructWinScreen() {
        Game.createScene("win");
        
        TexturedGameObject winBackground = new TexturedGameObject(0, 0, 0, 0, 0, 0, 1, 1, "winBackground", new Texture("textures/winBackground.png"));
        float winBannerHeight = 0.15f;
        float winBannerWidth = winBannerHeight * 90f / 26f;
        float winBannerX = (1 - winBannerWidth) / 2;
        float winBannerY = 0.1f;
        TexturedGameObject winBanner = new TexturedGameObject(winBannerX, winBannerY, 0, 0, 0, 0, winBannerWidth, winBannerHeight, "winBanner", new Texture("textures/youWin.png"));
        float spaceBetweenLabelsX = 0.1f;
        float spaceBetweenLabelsY = 0.1f;
        float labelOffsetY = 0.03f;
        float scoreLabelHeight = 0.04f;
        float scoreLabelWidth = scoreLabelHeight * 57f / 12f;
        TexturedGameObject scoreLabel = new TexturedGameObject((1 - spaceBetweenLabelsX) / 2 - scoreLabelWidth, (1 - spaceBetweenLabelsY) / 2 - scoreLabelHeight + labelOffsetY, 0, 0, 0, 0, scoreLabelWidth, scoreLabelHeight, "scoreLabel", new Texture("textures/scoreLabel.png"));
        float percentageLabelHeight = 0.025f;
        float percentageLabelWidth = percentageLabelHeight * 161f / 12f;
        TexturedGameObject percentageLabel = new TexturedGameObject((1 - spaceBetweenLabelsX) / 2 - percentageLabelWidth, (1 + spaceBetweenLabelsY) / 2 + labelOffsetY, 0, 0, 0, 0, percentageLabelWidth, percentageLabelHeight, "percentageLabel", new Texture("textures/notePercentLabel.png"));
        
        Game.addObjectToScene("win", winBackground);
        Game.addObjectToScene("win", winBanner);
        Game.addObjectToScene("win", scoreLabel);
        Game.addObjectToScene("win", percentageLabel);
        
        Menu winMenu = new Menu("winMenu");
        winMenu.addButton(new EndRestartButton(true));
        winMenu.addButton(new EndHomeButton(true));
        float fontSize = scoreLabelHeight * 1f;
        Color fontColor = Color.WHITE;
        float scoreX = (1 + spaceBetweenLabelsX) / 2;
        float scoreYOffset = 0.025f;
        float scoreY = (1 - spaceBetweenLabelsY) / 2 + scoreYOffset;
        winMenu.addLabel(new MenuLabel("0", "arial", Font.PLAIN, fontSize, fontColor, scoreX, scoreY, "scoreLabel"));
        float percentageX = scoreX;
        float percentageYOffset = 0.017f;
        float percentageY = (1 + spaceBetweenLabelsY) / 2 + fontSize + percentageYOffset;
        winMenu.addLabel(new MenuLabel("0%", "arial", Font.PLAIN, fontSize, fontColor, percentageX, percentageY, "percentageLabel"));
        
        Game.attachMenuToScene("win", winMenu);
    }
    
    public static void constructLoseScreen() {
        Game.createScene("lose");
        
        TexturedGameObject loseBackground = new TexturedGameObject(0, 0, 0, 0, 0, 0, 1, 1, "loseBackground", new Texture("textures/suckBackground.png"));
        float loseBannerHeight = 0.15f;
        float loseBannerWidth = loseBannerHeight * 91f / 26f;
        float loseBannerX = (1 - loseBannerWidth) / 2;
        float loseBannerY = 0.1f;
        TexturedGameObject loseBanner = new TexturedGameObject(loseBannerX, loseBannerY, 0, 0, 0, 0, loseBannerWidth, loseBannerHeight, "loseBanner", new Texture("textures/youSuck.png"));
        float labelOffset = 0.025f;
        float spaceBetweenLabelsX = 0.1f;
        float completionLabelHeight = 0.025f;
        float completionLabelWidth = completionLabelHeight * 161f / 12f;
        TexturedGameObject completionLabel = new TexturedGameObject((1 - spaceBetweenLabelsX) / 2 - completionLabelWidth, (1 - completionLabelHeight) / 2 + labelOffset, 0, 0, 0, 0, completionLabelWidth, completionLabelHeight, "completionLabel", new Texture("textures/songCompletionLabel.png"));
        
        Game.addObjectToScene("lose", loseBackground);
        Game.addObjectToScene("lose", loseBanner);
        Game.addObjectToScene("lose", completionLabel);
        
        Menu loseMenu = new Menu("loseMenu");
        loseMenu.addButton(new EndRestartButton(false));
        loseMenu.addButton(new EndHomeButton(false));
        float fontSize = completionLabelHeight * 1.7f;
        Color fontColor = Color.WHITE;
        float completionX = (1 + spaceBetweenLabelsX) / 2;
        float completionYOffset = -0.006f;
        float completionY = (1 + fontSize) / 2 + completionYOffset + labelOffset;
        loseMenu.addLabel(new MenuLabel("0%", "arial", Font.PLAIN, fontSize, fontColor, completionX, completionY, "completionLabel"));
        
        Game.attachMenuToScene("lose", loseMenu);
    }
    
    public static int getCurrentSong() {
        return currentSong;
    }
    
    public static void startGame(int song) {
        Game.clearScene("game");
        Game.detachMenuFromScene("game");
        
        NotesBar bar = new NotesBar("bar");
        
        currentSong = song;
        
        String notes = null;
        Sound music = null;
        
        switch(song) {
            case 1:
                notes = SONG_1_NOTES;
                music = SONG_1_MUSIC;
                break;
            case 2:
                notes = SONG_2_NOTES;
                music = SONG_2_MUSIC;
                break;
            case 3:
                notes = SONG_3_NOTES;
                music = SONG_3_MUSIC;
                break;
            default:
                throw new IllegalStateException("");
        }
        
        NotesPanel panel = new NotesPanel("panel", new Texture("textures/fret.png"), notes, music, bar);
        Gun gun = new Gun("gun", Utils.GUN_SHEET.getTexture(1, 0), Utils.GUN_SHEET.getTexture(2, 0));
        TexturedGameObject background = new TexturedGameObject(NotesPanel.PANEL_WIDTH, 0, 0, 0, 0, 0, 1 - NotesPanel.PANEL_WIDTH, 1, "background", new Texture("textures/backgroundStreet.png"));
        
        Game.addObjectToScene("game", background);
        Game.addObjectToScene("game", panel);
        Game.addObjectToScene("game", bar);
        Game.addObjectToScene("game", gun);
        
        Game.setCursor(GUN_CROSSHAIR);
        Game.setCurrentScene("game");
    }
    
    private static Cursor genGunCrosshair() {
        BufferedImage cursorImage = (GUN_SHEET.getTexture(0, 1)).getImage();
        Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(31, 31), "gunCrosshair");
        return cursor;
    }
    
    private static Sound genSound(String id, String file, boolean looping, float volume) {
        Sound sound = new Sound(id, file, looping);
        sound.setVolume(volume);
        return sound;
    }
    
    public static boolean mouseOverObject(GameObject obj) {
        Point mouseLoc = Game.getMouseLocation();
        Dimension windowSize = Game.getWindowSize();
        
        if(mouseLoc != null) {
            float mouseX = (float)(mouseLoc.getX() / windowSize.getWidth());
            float mouseY = (float)(mouseLoc.getY() / windowSize.getHeight());
            
            boolean insideX = mouseX >= obj.getX() && mouseX <= (obj.getX() + obj.getWidth());
            boolean insideY = mouseY >= obj.getY() && mouseY <= (obj.getY() + obj.getHeight());
            
            return insideX && insideY;
        } else {
            return false;
        }
    }
    
}
