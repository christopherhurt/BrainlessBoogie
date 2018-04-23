package objects;

import java.util.LinkedList;
import java.util.List;
import main.SaveFile;
import main.Sound;
import main.Utils;

public class Song {
    
    public static final double RELEASE_TIME_OFFSET = 5;
    
    private static final int TICKS_TIL_SONG_START = (int)(5.0f * Utils.FPS);
    
    private long startTime;
    private long currentTime;
    private int currNote;
    private double duration;
    private List<Note> notes;
    private Sound music;
    private boolean musicStarted;
    
    public Song(String file, Sound music) {
        SaveFile songFile = new SaveFile(file);
        List<String> lines = songFile.readLines();
        notes = new LinkedList<>();
        
        if(lines.size() < 2) {
            throw new IllegalStateException("Song file has too few lines");
        }
        
        duration = Double.parseDouble(lines.get(0));
        
        for(int i = 1; i < lines.size(); i++) {
            String[] notesParts = lines.get(i).split(",| ");
            
            if(notesParts.length != 2) {
                throw new IllegalStateException("Song file has a note line that doesn't contain two values");
            }
            
            notes.add(new Note(Integer.parseInt(notesParts[0]), Double.parseDouble(notesParts[1])));
        }
        
        this.music = music;
        startTime = 0;
        currNote = 0;
        musicStarted = false;
    }
    
    public void start() {
        currNote = 0;
        currentTime = System.nanoTime(); ;
        startTime = currentTime + (long)(((double)TICKS_TIL_SONG_START / Utils.FPS) * 1000000000.0);
    }
    
    public int getNote() {
        double time = normalizeTime();
        
        if(!musicStarted && time > 0) {
            music.play();
            musicStarted = true;
        }
        
        if(currNote < notes.size()) {
            Note note = notes.get(currNote);
            
            if(time >= note.getTime() - RELEASE_TIME_OFFSET / duration) {
                currNote++;
                return note.getType();
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
    
    public int getCompletionPercentage() {
        double time = normalizeTime();
        
        if(time < 0) {
            time = 0;
        }
        
        if(time > 1) {
            time = 1;
        }
        
        return (int)(time * 100);
    }
    
    public boolean isEnded() {
        double time = normalizeTime();
        return time >= 1;
    }
    
    private double normalizeTime() {
        currentTime = System.nanoTime();
        double seconds = (currentTime - startTime) / 1000000000.0;
        return seconds / duration;
    }
    
    private class Note {
        
        private int type;
        private double time;
        
        public Note(int type, double time) {
            this.type = type;
            this.time = time;
        }
        
        public int getType() {
            return type;
        }
        
        public double getTime() {
            return time;
        }
        
    }
    
}
