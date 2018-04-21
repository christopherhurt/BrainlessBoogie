package objects;

import java.util.LinkedList;
import java.util.List;
import main.SaveFile;

public class Song {
    
    public static final double RELEASE_TIME_OFFSET = 2.0;
    
    private long startTime;
    private long currentTime;
    private int currNote;
    private double duration;
    private List<Note> notes;
    
    public Song(String file) {
        SaveFile songFile = new SaveFile(file);
        List<String> lines = songFile.readLines();
        notes = new LinkedList<>();
        
        if(lines.size() < 2) {
            throw new IllegalStateException("Song file has too few lines");
        }
        
        duration = Double.parseDouble(lines.get(0));
        
        for(int i = 1; i < lines.size(); i++) {
            String[] notesParts = lines.get(i).split(" ");
            
            if(notesParts.length != 2) {
                throw new IllegalStateException("Song file has a note line that doesn't contain two values");
            }
            
            notes.add(new Note(Integer.parseInt(notesParts[0]), Double.parseDouble(notesParts[1])));
        }
        
        startTime = 0;
        currentTime = 0;
        currNote = 0;
    }
    
    public void start() {
        currNote = 0;
        startTime = System.nanoTime();
    }
    
    public int getNote() {
        if(currNote < notes.size()) {
            Note note = notes.get(currNote);
            double time = normalizeTime();
            
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
