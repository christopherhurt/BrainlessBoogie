package main;

import java.awt.Dimension;
import java.awt.Point;

public class Utils {
    
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
