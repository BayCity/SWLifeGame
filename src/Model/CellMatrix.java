package Model;

import java.util.Random;

public class CellMatrix {
    private int weight;
    private int heigh;

    private int[][] cell;

    private int rate;

    public CellMatrix() {
    }

    public CellMatrix(int weight, int heigh, int rate) {
        this.weight = weight;
        this.heigh = heigh;
        this.rate = rate;
        cell = new int[heigh][weight];
        init();
    }

    public void LifeRule() {
        int[][] tempMatrix=new int[heigh][weight];
        for (int i = 0; i < weight; i++)
            for (int j = 0; j < heigh; j++) {
                tempMatrix[i][j]=0;
                int num=AroundCellNumbers(i,j);
                if (num == 3) {
                    cell[i][j] = 1;
                }
                else if(num==2){
                    cell[i][j] = cell[i][j];
                }
                else{
                    cell[i][j]=0;
                }
            }
    }
    public void init() {
        Random random = new Random();
        int temp=0;
        for (int i = 0; i < weight; i++) {
            for (int j = 0; j < heigh; j++) {
                temp=random.nextInt(2);
                cell[i][j]= temp;
            }
        }
    }

    public int AroundCellNumbers(int x, int y) {
        int count = 0;

        //上方
        if (x != 0)
            count += cell[x-1][y];
        //下方
        if (x != heigh - 1)
            count += cell[x+1][y];
        //左方
        if (y != 0)
            count += cell[x][y-1];
        //右方
        if (y != weight - 1)
            count += cell[x][y+1];
        //右下
        if (y != weight - 1 && x != heigh - 1)
            count += cell[x + 1][y + 1];
        //左上
        if (x != 0 && y != 0)
            count += cell[x - 1][y - 1];
        //右上
        if (y != weight - 1 && x != 0)
            count += cell[x -1][y + 1];
        //左下
        if (x != heigh - 1 && y != 0)
            count += cell[x + 1][y - 1];

        return count;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeigh() {
        return heigh;
    }

    public void setHeigh(int heigh) {
        this.heigh = heigh;
    }

    public int[][] getCell() {
        return cell;
    }

    public void setCell(int[][] cell) {
        this.cell=cell;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
