package kabaDev.mino;

import java.awt.Color;

public class Mino_L2 extends Mino {

    public Mino_L2() {
        create(Color.cyan);
    }

    @Override
    public void setXY(int x, int y){

        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x;
        b[1].y = b[0].y - Block.SIZE;
        b[2].x = b[0].x;
        b[2].y = b[0].y + Block.SIZE;
        b[3].x = b[0].x + Block.SIZE;
        b[3].y = b[0].y + Block.SIZE;
    }

    @Override
    public void getDirection1() {
        // Dirección 1: Vertical
        //    o        b3
        //    o        b2
        //  o o     b1 b0
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y + Block.SIZE;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y - Block.SIZE;
        tempB[3].x = b[0].x - Block.SIZE;
        tempB[3].y = b[0].y - Block.SIZE;
        updateXY(1);
    }
    @Override
    public void getDirection2() {
        // Dirección 2: Horizontal
        // o o
        //   o
        //   o
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x + Block.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x - Block.SIZE;
        tempB[2].y = b[0].y;
        tempB[3].x = b[0].x - Block.SIZE;
        tempB[3].y = b[0].y + Block.SIZE;

        updateXY(2);
    }

    @Override
    public void getDirection3() {
        // Dirección 3: Vertical invertida
        //     o
        // o o o 
        //
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y + Block.SIZE;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y - Block.SIZE;
        tempB[3].x = b[0].x - Block.SIZE;
        tempB[3].y = b[0].y - Block.SIZE;

        updateXY(3);
    }

    @Override
    public void getDirection4() {
        // Dirección 4: Horizontal invertida
        //     o
        // o o o
        //
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x - Block.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x + Block.SIZE;
        tempB[2].y = b[0].y;
        tempB[3].x = b[0].x - Block.SIZE;
        tempB[3].y = b[0].y - Block.SIZE;
    
        updateXY(4);
    }
    @Override
    public void updateXY(int direction) {
        // Actualiza las posiciones de los bloques
        for (int i = 0; i < 4; i++) {
            b[i].x = tempB[i].x;
            b[i].y = tempB[i].y;
        }
    }
    
    
}
