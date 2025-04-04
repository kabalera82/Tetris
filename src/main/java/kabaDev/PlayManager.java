package kabaDev;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Color;
public class PlayManager {
    
    //Main Play Area
    final int WIDTH = 360;
    final int HEIGHT = 640;
    public static int left_x;
    public static int right_x;
    public static int top_y;
    public static int bottom_y;

    //Main Play Area Frame
    public PlayManager(){
    left_x=(GamePanel.WIDTH/2)-(WIDTH/2); // left_x = 1280/2 - 360/2 = 460
    right_x= left_x + WIDTH;
    top_y = 50;
    bottom_y = top_y + HEIGHT;
    }
    public void update() {
       
    }

    public void draw(Graphics2D g2) {
        // Draw play area frame
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(4f));
        g2.drawRect(left_x-4, top_y-4, WIDTH+8, HEIGHT+8);

        // Draw Next Mino Frame
        int x = rigth_x + 100;
        int y = 

    }

}
