package kabaDev.mino;

import java.awt.Color;

public class Mino_Bar extends Mino {

    public Mino_Bar(){ super.create(Color.cyan);}

    @Override
    public void setXY(int x, int y){

        //El contructor del Mino Barra
        //
        // o o o o
        //
        b[0].x = x;
        b[0].y = y;
        b[1].x = b[0].x - Block.SIZE;
        b[1].y = b[0].y;
        b[2].x = b[0].x + Block.SIZE;
        b[2].y = b[0].y;
        b[3].x = b[0].x + Block.SIZE*2;
        b[3].y = b[0].y;

    }
    @Override
    public void getDirection1 (){
        //
        // o o o o
        //
        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x - Block.SIZE;
        tempB[1].y = b[0].y;
        tempB[2].x = b[0].x + Block.SIZE;
        tempB[2].y = b[0].y;
        tempB[3].x = b[0].x + Block.SIZE*2;
        tempB[3].y = b[0].y;

        super.updateXY(1);
    }
    @Override
    public void getDirection2 (){
         // o
         // o
         // o
         // o

        tempB[0].x = b[0].x;
        tempB[0].y = b[0].y;
        tempB[1].x = b[0].x;
        tempB[1].y = b[0].y - Block.SIZE;
        tempB[2].x = b[0].x;
        tempB[2].y = b[0].y + Block.SIZE;
        tempB[3].x = b[0].x;
        tempB[3].y = b[0].y + Block.SIZE*2;

        super.updateXY(2);
    }
    @Override
    public void getDirection3(){
        getDirection1();
    }

    @Override
    public void getDirection4() {
        getDirection2();
    }
}
