package Control;

import Model.CellMatrix;
import VIew.GameFrame;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class controller implements Runnable{
    private CellMatrix cellMatrix;
    private GameFrame gameFrame;

    public controller() {
        this.cellMatrix = new CellMatrix(50,50,1000);
        this.gameFrame = new GameFrame(cellMatrix);
        init();

    }
    public void init(){
        Random random=new Random();
        for (int i=0;i<cellMatrix.getWeight();i++){
            for(int j=0;j<cellMatrix.getHeigh();j++){
                cellMatrix.setCell(i,j,random.nextInt(2));
            }
        }
    }


    @Override
    public void run() {
        cellMatrix.LifeRule();
        gameFrame.start();
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
