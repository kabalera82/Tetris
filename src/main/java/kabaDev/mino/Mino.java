package kabaDev.mino;

import java.awt.Color;
import java.awt.Graphics2D;


import kabaDev.KeyHandler;
import kabaDev.PlayManager;

public class Mino {

    public Block b []= new Block[4]; // Variable de tipo Array para el mino
    public Block tempB [] = new Block[4]; // Variable de tipo Array para el mino temporal
    int autoDropCounter = 0; // Variable para el autoDrop
    public int direction = 1; // Variable para la rotacion del mino habrá 4 direcciones (0,1,2,3)

    public void create(Color c) {
        b[0] = new Block(c);
        b[1] = new Block(c);
        b[2] = new Block(c);
        b[3] = new Block(c);
        tempB[0] = new Block(c);
        tempB[1] = new Block(c);
        tempB[2] = new Block(c);
        tempB[3] = new Block(c);
    }

    public void setXY(int x, int y) {}
    public void updateXY(int direction) {

        b[0].x = tempB[0].x;
        b[0].y = tempB[0].y;
        b[1].x = tempB[1].x;
        b[1].y = tempB[1].y;
        b[2].x = tempB[2].x;
        b[3].y = tempB[2].y;
        b[2].y = tempB[3].x;
        b[3].x = tempB[3].y;
    }
    public void getDirection1() {}
    public void getDirection2() {}
    public void getDirection3() {}
    public void getDirection4() {}
    public void update() {
        // Movimiento del mino
        if (KeyHandler.upPressed) {
            // Cambiar la dirección y rotar
            direction++;
            if (direction > 4) {
                direction = 1; // Volver a la dirección 1 si supera 4
            }
    
            switch (direction) {
                case 1 -> getDirection1();
                case 2 -> getDirection2();
                case 3 -> getDirection3();
                case 4 -> getDirection4();
            }
    
            KeyHandler.upPressed = false; // Reiniciar la variable después de procesar
        }
    
        if (KeyHandler.downPressed) {
            for (Block block : b) {
                block.y += Block.SIZE;
            }
            autoDropCounter = 0;
            KeyHandler.downPressed = false;
        }
    
        if (KeyHandler.LeftPressed) {
            for (Block block : b) {
                block.x -= Block.SIZE;
            }
            KeyHandler.LeftPressed = false;
        }
    
        if (KeyHandler.rightPressed) {
            for (Block block : b) {
                block.x += Block.SIZE;
            }
            KeyHandler.rightPressed = false;
        }
    
        // Auto-drop
        autoDropCounter++;
        if (autoDropCounter == PlayManager.dropInterval) {
            for (Block block : b) {
                block.y += Block.SIZE;
            }
            autoDropCounter = 0;
        }
    }

    public void draw(Graphics2D g2) {
        int margin = 2;
        g2.setColor(b[0].c);
        g2.fillRect(b[0].x, b[0].y, Block.SIZE-(margin*2), Block.SIZE-(margin*2));
        g2.fillRect(b[1].x, b[1].y, Block.SIZE-(margin*2), Block.SIZE-(margin*2));
        g2.fillRect(b[2].x, b[2].y, Block.SIZE-(margin*2), Block.SIZE-(margin*2));
        g2.fillRect(b[3].x, b[3].y, Block.SIZE-(margin*2), Block.SIZE-(margin*2));
    }
}