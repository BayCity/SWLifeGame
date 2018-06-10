package Control;

import Model.CellMatrix;
import VIew.GameFrame;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class controller implements Runnable {
    private CellMatrix cellMatrix;
    private GameFrame gameFrame;

    public controller() {
        this.cellMatrix = new CellMatrix();
        this.gameFrame = new GameFrame(cellMatrix);
    }

    public boolean initcell() {
        if (gameFrame.getstatus())
            return true;
        else
            return false;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(gameFrame.getstatus());
            cellMatrix.LifeRule();
            gameFrame.loadCell();
            try {
                TimeUnit.MILLISECONDS.sleep(cellMatrix.getRate());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
