package kabaDev.mino;

import java.awt.*;

public class Mino_L2 extends Mino {

    public Mino_L2() {
        super.create(Color.blue);
    }

    @Override
    public void setXY(int x, int y) {
        //   o
        //   o
        // o o

        b[0].x = x;
        b[0].y = y;

        b[1].x = x;
        b[1].y = y - Block.SIZE;

        b[2].x = x;
        b[2].y = y - 2 * Block.SIZE;

        b[3].x = x - Block.SIZE;
        b[3].y = y;
    }

    @Override
    public void getDirection1() {
        // Igual a setXY
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;

        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y - Block.SIZE;

        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y - 2 * Block.SIZE;

        tempB[3].x = b[0].x - Block.SIZE;
        tempB[3].y = b[0].y;

        super.updateXY(1);
    }

    @Override
    public void getDirection2() {
        // o
        // o o o

        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;

        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y + Block.SIZE;

        tempB[2].x = b[0].x - Block.SIZE;
        tempB[2].y = b[0].y + Block.SIZE;

        tempB[3].x = b[0].x + Block.SIZE;
        tempB[3].y = b[0].y + Block.SIZE;

        super.updateXY(2);
    }

    @Override
    public void getDirection3() {
        // o o
        // o
        // o

        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;

        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y + Block.SIZE;

        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y + 2 * Block.SIZE;

        tempB[3].x = b[0].x + Block.SIZE;
        tempB[3].y = b[0].y;

        super.updateXY(3);
    }

    @Override
    public void getDirection4() {
        // o o o
        //     o

        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;

        tempB[1].x = b[0].x - Block.SIZE;
        tempB[1].y = b[0].y;

        tempB[2].x = b[0].x + Block.SIZE;
        tempB[2].y = b[0].y;

        tempB[3].x = b[0].x + Block.SIZE;
        tempB[3].y = b[0].y + Block.SIZE;

        super.updateXY(4);
    }
}
