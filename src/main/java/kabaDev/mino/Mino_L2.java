package kabaDev.mino;

import java.awt.*;

public class Mino_L2 extends Mino {

    public Mino_L2() {
        super.create(Color.blue);
    }

    @Override
    public void setXY(int x, int y) {
        // Esquema inicial:
        //   o
        //   o BO
        // o o
        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x;
        b[1].y = b[0].y + Block.SIZE;
        b[2].x = b[0].x;
        b[2].y = b[0].y - Block.SIZE;
        b[3].x = b[0].x - Block.SIZE;
        b[3].y = b[0].y - Block.SIZE;
    }

    @Override
    public void getDirection1() {
        // Dirección 1: Vertical
        //    o        b3
        //    o        b0
        //  o o     b2 b1
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y + Block.SIZE;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y - Block.SIZE;
        tempB[3].x = b[0].x - Block.SIZE;
        tempB[3].y = b[0].y - Block.SIZE;

        super.updateXY(1);
    }

    @Override
    public void getDirection2() {
        // Dirección 2: Horizontal
        // o
        // o o o
        //
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x - Block.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x + Block.SIZE;
        tempB[2].y = b[0].y;
        tempB[3].x = b[0].x + Block.SIZE;
        tempB[3].y = b[0].y - Block.SIZE;

        super.updateXY(2);
    }

    @Override
    public void getDirection3() {
        // Dirección 3: Vertical invertida
        // o o
        // o
        // o
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y - Block.SIZE;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y + Block.SIZE;
        tempB[3].x = b[0].x + Block.SIZE;
        tempB[3].y = b[0].y + Block.SIZE;

        super.updateXY(3);
    }

    @Override
    public void getDirection4() {
        // Dirección 4: Horizontal invertida
        //
        // o o o
        //     o
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x + Block.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x - Block.SIZE;
        tempB[2].y = b[0].y;
        tempB[3].x = b[0].x - Block.SIZE;
        tempB[3].y = b[0].y + Block.SIZE;

        super.updateXY(4);
    }
}