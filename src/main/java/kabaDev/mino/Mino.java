package kabaDev.mino;

import kabaDev.GamePanel;
import kabaDev.KeyHandler;
import kabaDev.PlayManager;

import java.awt.*;

public class Mino {

    public Block[] b = new Block[4]; // Variable de tipo Array para el mino
    public Block[] tempB = new Block[4]; // Variable de tipo Array para el mino temporal
    public int direction = 1; // Variable para la rotacion del mino habrá 4 direcciones (0,1,2,3)
    int autoDropCounter = 0; // Variable para el autoDrop
    boolean leftCollision, rigthCollision, bottomCollision;
    public boolean active = true;
    public boolean  deactivating;
    int deactivateCounter = 0;

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

    public void setXY(int x, int y) {
    }

    public void updateXY(int direction) {

        chekRotationCollision();

        if (!leftCollision && !rigthCollision && !bottomCollision) {
            this.direction = direction;
            b[0].x = tempB[0].x;
            b[0].y = tempB[0].y;
            b[1].x = tempB[1].x;
            b[1].y = tempB[1].y;
            b[2].x = tempB[2].x;
            b[2].y = tempB[2].y;
            b[3].x = tempB[3].x;
            b[3].y = tempB[3].y;
        }
    }

    public void getDirection1() {
    }

    public void getDirection2() {
    }

    public void getDirection3() {
    }

    public void getDirection4() {
    }

    public void checkMovementCollision() {

        leftCollision = false;
        rigthCollision = false;
        bottomCollision = false;

        //check static block collision
        checkStaticBlockCollision();

        // Check frame collision
        //left wall
        for (int i = 0; i < b.length; i++) {
            if (b[i].x == PlayManager.left_x) {
                leftCollision = true;
                break;
            }
        }
        //Right wall
        for (int i = 0; i < b.length; i++) {
            if (b[i].x + Block.SIZE == PlayManager.right_x) {
                rigthCollision = true;
                break;
            }
        }
        // Bottom floor
        for (int i = 0; i < b.length; i++) {
            if (b[i].y + Block.SIZE == PlayManager.bottom_y) {
                bottomCollision = true;
                break;
            }
        }
    }


    public void chekRotationCollision() {

        leftCollision = false;
        rigthCollision = false;
        bottomCollision = false;

        //Check static block collision
        checkStaticBlockCollision();

        // Check frame collision
        //left wall
        for (int i = 0; i < b.length; i++) {
            if (tempB[i].x < PlayManager.left_x) {
                leftCollision = true;
                break;
            }
        }
        //Right wall
        for (int i = 0; i < b.length; i++) {
            if (tempB[i].x + Block.SIZE > PlayManager.right_x) {
                rigthCollision = true;
                break;
            }
        }
        // Bottom floor
        for (int i = 0; i < b.length; i++) {
            if (tempB[i].y + Block.SIZE > PlayManager.bottom_y) {
                bottomCollision = true;
                break;
            }
        }
    }

    private void checkStaticBlockCollision() {

        for (int i = 0; i < PlayManager.staticBlocks.size(); i++) {
            int targetX = PlayManager.staticBlocks.get(i).x;
            int targetY = PlayManager.staticBlocks.get(i).y;

            //check down
            for (int ii = 0; ii < b.length; ii++) {
                if (b[ii].y + Block.SIZE == targetY && b[ii].x == targetX) {
                    bottomCollision = true;
                }
            }
            // check left
            for (int ii = 0; ii < b.length; ii++) {
                if (b[ii].x - Block.SIZE == targetX && b[ii].y == targetY) {
                    leftCollision = true;
                }
            }
            for (int ii = 0; ii < b.length; ii++) {
                if (b[ii].x + Block.SIZE == targetX && b[ii].y == targetY) {
                    rigthCollision = true;
                }
            }
        }
    }

    public void update() {
        if(deactivating){
            deactivating();
        }

        // Movimiento del mino
        if (KeyHandler.upPressed) {
            switch (direction) {
                case 1: getDirection2(); break;
                case 2: getDirection3(); break;
                case 3: getDirection4(); break;
                case 4: getDirection1(); break;
            }
            KeyHandler.upPressed = false; // Reiniciar la variable después de procesar
            GamePanel.se.play(2,false);
        }
        checkMovementCollision();

        if (KeyHandler.downPressed) {
            //Si el mino de la parte inferior no toca lo bajamos
            if (!bottomCollision) {
                for (Block block : b) {
                    block.y += Block.SIZE;
                }
            }
            KeyHandler.downPressed = false;
        }

        if (KeyHandler.LeftPressed) {
            if (!leftCollision) {
                for (Block block : b) {
                    block.x -= Block.SIZE;
                }
            }
            KeyHandler.LeftPressed = false;
        }

        if (KeyHandler.rightPressed) {
            if (!rigthCollision) {
                for (Block block : b) {
                    block.x += Block.SIZE;
                }
            }
            KeyHandler.rightPressed = false;
        }

        if (bottomCollision) {
            if(deactivating == false){
                GamePanel.se.play(3,false);
            }
            deactivating = true;
        } else {
            // Auto-drop
            autoDropCounter++;
            if (autoDropCounter == PlayManager.dropInterval) {
                b[0].y += Block.SIZE;
                b[1].y += Block.SIZE;
                b[2].y += Block.SIZE;
                b[3].y += Block.SIZE;

                autoDropCounter = 0;
            }
        }

    }
    private void deactivating (){
        deactivateCounter++;
        //wait 45 frames until deactivate
        if(deactivateCounter == 45){
            deactivateCounter = 0;
            checkMovementCollision();//cheakea si esta pulsado el botomo

            //Si el botom esta pulsado despues de 45 frames
            if(bottomCollision){
                active = false;
            }
        }
    }
    public void draw(Graphics2D g2) {
        int margin = 2;
        g2.setColor(b[0].c);
        g2.fillRect(b[0].x, b[0].y, Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
        g2.fillRect(b[1].x, b[1].y, Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
        g2.fillRect(b[2].x, b[2].y, Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
        g2.fillRect(b[3].x, b[3].y, Block.SIZE - (margin * 2), Block.SIZE - (margin * 2));
    }
}