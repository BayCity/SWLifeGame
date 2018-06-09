package Control;

import Model.CellMatrix;
import VIew.GameFrame;

public class controller {
    private CellMatrix cellMatrix;
    private GameFrame gameFrame;

    public controller() {
        this.cellMatrix = new CellMatrix(50,50,1000);
        this.gameFrame = new GameFrame(cellMatrix);
    }
    public void init(){
        for (int i=0;i<cellMatrix.getWeight();i++)
    }
}
