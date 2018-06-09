package Control;

import Model.CellMatrix;
import VIew.GameFrame;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class controller implements Runnable {
    private CellMatrix cellMatrix;
    private GameFrame gameFrame;

    public controller() {
        this.cellMatrix = new CellMatrix(50, 50, 1000);
        this.gameFrame = new GameFrame(cellMatrix);
        init();
    }

    public void init() {
        Random random = new Random();
        int temp=0;
        for (int i = 0; i < cellMatrix.getWeight(); i++) {
            for (int j = 0; j < cellMatrix.getHeigh(); j++) {
                temp=random.nextInt(2);
                cellMatrix.setCell(i, j, temp);
            }

        }
    }


    @Override
    public void run() {
        while (true) {
            System.out.println(gameFrame.getstatus());
            cellMatrix.LifeRule();
            gameFrame.loadCell();
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
