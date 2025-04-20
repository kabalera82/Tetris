package kabaDev;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.util.Random;

import kabaDev.mino.Mino;
import kabaDev.mino.Block;
import kabaDev.mino.Mino_L1;
import kabaDev.mino.Mino_L2;
import kabaDev.mino.Mino_Bar;
import kabaDev.mino.Mino_T;
import kabaDev.mino.Mino_Z1;
import kabaDev.mino.Mino_Z2;
import kabaDev.mino.Mino_Square;

public class PlayManager {

    //Main Play Area
    final int WIDTH = 360;
    final int HEIGHT = 640;
    public static int left_x;
    public static int right_x;
    public static int top_y;
    public static int bottom_y;

    //Mino
    Mino currentMino;
    final int MINO_START_X;
    final int MINO_START_Y;

    //Others
    public static int dropInterval = 60; // mino drops in every 60 frames


    public PlayManager() {

        //Main Play Area Frame
        left_x = (GamePanel.WIDTH / 2) - (WIDTH / 2); // left_x = 1280/2 - 360/2 = 460
        right_x = left_x + WIDTH;
        top_y = 50;
        bottom_y = top_y + HEIGHT;

        MINO_START_X = left_x + (WIDTH / 2) - Block.SIZE;
        MINO_START_Y = top_y + Block.SIZE;

        //Set the starting Mino
        currentMino = pickMino();
        currentMino.setXY(MINO_START_X, MINO_START_Y);

    }

    // Picking up a random tetromino
    private Mino pickMino() {
        //Pick a random mino.
        Mino mino = null;
        int i = new Random().nextInt(7);

        switch (i) {
            case 0:
                mino = new Mino_L1();
                break;
            case 1:
                mino = new Mino_L2();
                break;
            case 2:
                mino = new Mino_Square();
                break;
            case 3:
                mino = new Mino_Bar();
                break;
            case 4:
                mino = new Mino_T();
                break;
            case 5:
                mino = new Mino_Z1();
                break;
            case 6:
                mino = new Mino_Z2();
                break;
        }
        return mino;
    }

    public void update() {
        currentMino.update();
    }

    public void draw(Graphics2D g2) {

        // Draw play area frame
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(4f));
        g2.drawRect(left_x - 4, top_y - 4, WIDTH + 8, HEIGHT + 8);

        // Draw Next Mino Frame
        int x = right_x + 100;
        int y = bottom_y - 200;
        g2.drawRect(x, y, 200, 200);
        g2.setFont(new Font("Arial", Font.PLAIN, 30));
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.drawString("Next", x + 60, y + 60);//AQUI SE DIBUJA EL TEXTO "NEXT"

        //Draw current mino
        if (currentMino != null) {
            currentMino.draw(g2);
        }


    }

}
