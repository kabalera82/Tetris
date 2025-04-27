package kabaDev.mino;

import java.awt.*;

public class Mino_L1 extends Mino {

    public Mino_L1() {
        super.create(Color.orange);
    }

    @Override
    public void setXY(int x, int y) {
        // o
        // 0
        // o o

        b[0].x = x;
        b[0].y = y;

        b[1].x = x;
        b[1].y = y - Block.SIZE;

        b[2].x = x;
        b[2].y = y + Block.SIZE;

        b[3].x = x + Block.SIZE;
        b[3].y = y + Block.SIZE;
    }

    @Override
    public void getDirection1() {
        // Igual a setXY
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;

        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y - Block.SIZE;

        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y + Block.SIZE;
        tempB[3].x = b[0].x + Block.SIZE;
        tempB[3].y = b[0].y + Block.SIZE;

        super.updateXY(1);
    }

    @Override
    public void getDirection2() {
        //
        // o o o
        // o

        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;

        tempB[1].x = b[0].x + Block.SIZE;
        tempB[1].y = b[0].y;

        tempB[2].x = b[0].x - Block.SIZE;
        tempB[2].y = b[0].y;

        tempB[3].x = b[0].x - Block.SIZE;
        tempB[3].y = b[0].y + Block.SIZE;

        super.updateXY(2);
    }

    @Override
    public void getDirection3() {
        // o o
        //   o
        //   o

        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;

        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y + Block.SIZE;

        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y - Block.SIZE;

        tempB[3].x = b[0].x - Block.SIZE;
        tempB[3].y = b[0].y - Block.SIZE;

        super.updateXY(3);
    }

    @Override
    public void getDirection4() {
        //     o
        // o o o

        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;

        tempB[1].x = b[0].x - Block.SIZE;
        tempB[1].y = b[0].y;

        tempB[2].x = b[0].x + Block.SIZE;
        tempB[2].y = b[0].y;

        tempB[3].x = b[0].x + Block.SIZE;
        tempB[3].y = b[0].y - Block.SIZE;

        super.updateXY(4);
    }
}
