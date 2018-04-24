package objects;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import main.Game;
import main.GameObject;
import main.Input;
import main.Menu;
import main.MenuLabel;
import main.Sound;
import main.SoundBank;
import main.Texture;
import main.TexturedGameObject;
import main.Utils;
import menus.Settings;

public class NotesPanel extends TexturedGameObject {
    
    public static final float PANEL_WIDTH = 0.2f;
    
    private static final double ZOMBIE_SPAWN_CHANCE = 0.075;
    
    private static final float HEALTH_BAR_WIDTH = 0.15f;
    private static final float HEALTH_BAR_HEIGHT = 0.15f;
    private static final float HEALTH_BAR_OFFSET = 0.055f;
    
    private static final float SCORE_SIZE = 0.04f;
    private static final float SCORE_OFFSET = 0.0125f;
    
    private static final int SCORE_PER_NOTE = 25;
    private static final int SCORE_PER_ZOMBIE_BODY = 25;
    private static final int SCORE_PER_ZOMBIE_HEAD = 100;
    
    private static final float MISCLICK_HEALTH_LOSS = 0.1f;
    private static final float PASSED_NOTE_HEALTH_LOSS = 0.05f;
    private static final float MISSED_ON_ZOMBIE_HEALTH_LOSS = 0.025f;
    private static final float NOTE_HIT_HEALTH_GAIN = 0.1f;
    private static final float HIT_THRESHOLD = Button.BUTTON_SIZE;
    private static final float DISAPPEAR_Y = Button.BUTTON_Y + HIT_THRESHOLD;
    
    private List<DropNote> buttons1;
    private List<DropNote> buttons2;
    private List<DropNote> buttons3;
    private List<DropNote> buttons4;
    
    private MenuLabel scoreLabel;
    private Song song;
    private Health health;
    private NotesBar notesBar;
    private int score;
    private int notesHit;
    private int totalNotes;
    
    public NotesPanel(String id, Texture texture, String songFile, Sound music, NotesBar notesBar) {
        super(0, 0, 0, 0, 0, 0, PANEL_WIDTH, 1, id, texture);
        
        buttons1 = new ArrayList<>();
        buttons2 = new ArrayList<>();
        buttons3 = new ArrayList<>();
        buttons4 = new ArrayList<>();
        
        song = new Song(songFile, music);
        song.start();
        
        health = new Health((PANEL_WIDTH - HEALTH_BAR_WIDTH) / 2, 1 - HEALTH_BAR_HEIGHT - HEALTH_BAR_OFFSET, HEALTH_BAR_WIDTH, HEALTH_BAR_HEIGHT, "health", song,
                    Utils.DIAL_SHEET.getTexture(3, 0), Utils.DIAL_SHEET.getTexture(2, 0), Utils.DIAL_SHEET.getTexture(1, 0), Utils.DIAL_SHEET.getTexture(0, 0),
                    Utils.DIAL_SHEET.getTexture(4, 0), Utils.DIAL_SHEET.getTexture(5, 0), Utils.DIAL_SHEET.getTexture(6, 0));
        Game.addObjectToScene("game", health);
        
        score = 0;
        notesHit = 0;
        totalNotes = 0;
        
        Menu gameMenu = new Menu("gameMenu");
        scoreLabel = new MenuLabel("0", "arial", Font.PLAIN, SCORE_SIZE, Color.WHITE, SCORE_OFFSET, 1 - SCORE_OFFSET, "scoreLabel");
        gameMenu.addLabel(scoreLabel);
        Game.attachMenuToScene("game", gameMenu);
        
        this.notesBar = notesBar;
    }
    
    @Override
    public void update() {
        if(Math.random() < ZOMBIE_SPAWN_CHANCE) {
            Zombie zombie = new Zombie("zombie");
            Game.addObjectToScene("game", zombie);
        }
        
        int note = song.getNote();
        
        if(note != 0) {
            boolean hasNote1 = ((note >> 3) & 1) == 1;
            boolean hasNote2 = ((note >> 2) & 1) == 1;
            boolean hasNote3 = ((note >> 1) & 1) == 1;
            boolean hasNote4 = (note & 1) == 1;
            
            if(hasNote1) {
                DropNote dropNote = new DropNote("note", DropNote.NOTE1);
                buttons1.add(dropNote);
                Game.addObjectToScene("game", dropNote);
            }
            
            if(hasNote2) {
                DropNote dropNote = new DropNote("note", DropNote.NOTE2);
                buttons2.add(dropNote);
                Game.addObjectToScene("game", dropNote);
            }
            
            if(hasNote3) {
                DropNote dropNote = new DropNote("note", DropNote.NOTE3);
                buttons3.add(dropNote);
                Game.addObjectToScene("game", dropNote);
            }
            
            if(hasNote4) {
                DropNote dropNote = new DropNote("note", DropNote.NOTE4);
                buttons4.add(dropNote);
                Game.addObjectToScene("game", dropNote);
            }
            
            totalNotes++;
        }
        
        DropNote note1Inside = null;
        DropNote note2Inside = null;
        DropNote note3Inside = null;
        DropNote note4Inside = null;
        
        boolean noteMissed = false;
        
        for(int i = 0; i < buttons1.size(); i++) {
            DropNote dropNote = buttons1.get(i);
            
            if(dropNote.getY() >= DISAPPEAR_Y) {
                buttons1.remove(i);
                i--;
                Game.removeObjectFromScene("game", dropNote);
                noteMissed = true;
            } else if(dropNote.getY() >= (Button.BUTTON_Y - HIT_THRESHOLD) && dropNote.getY() <= (Button.BUTTON_Y + HIT_THRESHOLD)) {
                note1Inside = dropNote;
            }
        }
        
        for(int i = 0; i < buttons2.size(); i++) {
            DropNote dropNote = buttons2.get(i);
            
            if(dropNote.getY() >= DISAPPEAR_Y) {
                buttons2.remove(i);
                i--;
                Game.removeObjectFromScene("game", dropNote);
                noteMissed = true;
            } else if(dropNote.getY() >= (Button.BUTTON_Y - HIT_THRESHOLD) && dropNote.getY() <= (Button.BUTTON_Y + HIT_THRESHOLD)) {
                note2Inside = dropNote;
            }
        }
        
        for(int i = 0; i < buttons3.size(); i++) {
            DropNote dropNote = buttons3.get(i);
            
            if(dropNote.getY() >= DISAPPEAR_Y) {
                buttons3.remove(i);
                i--;
                Game.removeObjectFromScene("game", dropNote);
                noteMissed = true;
            } else if(dropNote.getY() >= (Button.BUTTON_Y - HIT_THRESHOLD) && dropNote.getY() <= (Button.BUTTON_Y + HIT_THRESHOLD)) {
                note3Inside = dropNote;
            }
        }
        
        for(int i = 0; i < buttons4.size(); i++) {
            DropNote dropNote = buttons4.get(i);
            
            if(dropNote.getY() >= DISAPPEAR_Y) {
                buttons4.remove(i);
                i--;
                Game.removeObjectFromScene("game", dropNote);
                noteMissed = true;
            } else if(dropNote.getY() >= (Button.BUTTON_Y - HIT_THRESHOLD) && dropNote.getY() <= (Button.BUTTON_Y + HIT_THRESHOLD)) {
                note4Inside = dropNote;
            }
        }
        
        if(noteMissed) {
            passedNote();
        }
        
        if(Input.isButtonPressed(MouseEvent.BUTTON1)) {
            List<GameObject> zombies = Game.getGameObjects("zombie");
            boolean zombieShot = false;
            
            for(int i = zombies.size() - 1; i >= 0; i--) {
                Zombie zombie = (Zombie)(zombies.get(i));
                
                if(Utils.mouseOverObject(zombie)) {
                    if(zombie.headshot()) {
                        Utils.HEADSHOT_SOUND.play();
                        score += SCORE_PER_ZOMBIE_HEAD;
                    } else {
                        score += SCORE_PER_ZOMBIE_BODY;
                    }
                    
                    zombie.vaporize();
                    zombieShot = true;
                    break;
                }
            }
            
            if(zombieShot) {
                if(note1Inside == null && note2Inside == null && note3Inside == null && note4Inside == null) {
                    noteMissed(zombieShot);
                } else {
                    boolean button1Correct = Input.isKeyDown(NotesBar.KEY_1) == (note1Inside != null);
                    boolean button2Correct = Input.isKeyDown(NotesBar.KEY_2) == (note2Inside != null);
                    boolean button3Correct = Input.isKeyDown(NotesBar.KEY_3) == (note3Inside != null);
                    boolean button4Correct = Input.isKeyDown(NotesBar.KEY_4) == (note4Inside != null);
                    
                    if(button1Correct && button2Correct && button3Correct && button4Correct) {
                        int buttonsHit = 0;
                        
                        if(note1Inside != null) {
                            buttons1.remove(note1Inside);
                            Game.removeObjectFromScene("game", note1Inside);
                            buttonsHit++;
                            notesBar.flareButton(1);
                        }
                        
                        if(note2Inside != null) {
                            buttons2.remove(note2Inside);
                            Game.removeObjectFromScene("game", note2Inside);
                            buttonsHit++;
                            notesBar.flareButton(2);
                        }
                        
                        if(note3Inside != null) {
                            buttons3.remove(note3Inside);
                            Game.removeObjectFromScene("game", note3Inside);
                            buttonsHit++;
                            notesBar.flareButton(3);
                        }
                        
                        if(note4Inside != null) {
                            buttons4.remove(note4Inside);
                            Game.removeObjectFromScene("game", note4Inside);
                            buttonsHit++;
                            notesBar.flareButton(4);
                        }
                        
                        noteHit(buttonsHit);
                    } else {
                        noteMissed(zombieShot);
                    }
                }
            } else {
                noteMissed(zombieShot);
            }
        }
        
        scoreLabel.setText(score + "");
        
        if(song.isEnded()) {
            winGame();
        }
        
        Game.readdObjects("panel");
        Game.readdObjects("button");
        Game.readdObjects("bar");
        Game.readdObjects("note");
        Game.readdObjects("health");
        Game.readdObjects("gun");
    }
    
    private void winGame() {
        SoundBank.stopAll();
        
        Menu gameMenu = Game.getMenu();
        gameMenu.clearAll();
        
        Game.detachMenuFromScene("game");
        Game.clearScene("game");
        Game.setCurrentScene("win");
        Game.setCursor(Cursor.getDefaultCursor());
        
        int percentageHit = (int)(((float)notesHit / totalNotes) * 100);
        Menu winMenu = Game.getMenu();
        MenuLabel scoreLabel = winMenu.getLabel("scoreLabel");
        scoreLabel.setText(score + "");
        MenuLabel percentageLabel = winMenu.getLabel("percentageLabel");
        percentageLabel.setText(percentageHit + "%");
        
        switch(Utils.getCurrentSong()) {
            case 1:
                Settings.setHighScoreSong1(score, percentageHit);
                break;
            case 2:
                Settings.setHighScoreSong2(score, percentageHit);
                break;
            case 3:
                Settings.setHighScoreSong3(score, percentageHit);
                break;
            default:
                throw new IllegalStateException("WTF Utils.getCurrentSong() is invalid");
        }
        
        Utils.WIN_SOUND.play();
    }
    
    private void noteHit(int buttonsHit) {
        health.addHealth(NOTE_HIT_HEALTH_GAIN);
        score += buttonsHit * SCORE_PER_NOTE;
        notesHit++;
    }
    
    private void passedNote() {
        health.removeHealth(PASSED_NOTE_HEALTH_LOSS);
    }
    
    private void noteMissed(boolean zombieShot) {
        if(zombieShot) {
            health.removeHealth(MISSED_ON_ZOMBIE_HEALTH_LOSS);
        } else {
            health.removeHealth(MISCLICK_HEALTH_LOSS);
        }        
    }
    
}
