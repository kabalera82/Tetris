package kabaDev.mino;

import java.awt.*;

public class Mino_Z1 extends Mino {

    public Mino_Z1() {
        super.create(Color.red);
    }

    public void setXY(int x, int y) {

        //  o
        //  o  o
        //     o
        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x;
        b[1].y = b[0].y - Block.SIZE;
        b[2].x = b[0].x + Block.SIZE;
        b[2].y = b[0].y;
        b[3].x = b[0].x + Block.SIZE;
        b[3].y = b[0].y + Block.SIZE;


    }

    @Override
    public void getDirection1() {
        // Dirección 1: Horizontal
        //  o
        //  o  o
        //     o
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y - Block.SIZE;
        tempB[2].x = b[0].x + Block.SIZE;
        tempB[2].y = b[0].y;
        tempB[3].x = b[0].x + Block.SIZE;
        tempB[3].y = b[0].y + Block.SIZE;

        super.updateXY(1);
    }

    @Override
    public void getDirection2() {
        // Dirección 2: Vertical
        //     o  o
        //  o  o
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x - Block.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y - Block.SIZE;
        tempB[3].x = b[0].x + Block.SIZE;
        tempB[3].y = b[0].y - Block.SIZE;

        super.updateXY(2);
    }

    @Override
    public void getDirection3() {
        // Igual a Dirección 1 (Horizontal)
        getDirection1();
    }

    @Override
    public void getDirection4() {
        // Igual a Dirección 2 (Vertical)
        getDirection2();
    }
}
