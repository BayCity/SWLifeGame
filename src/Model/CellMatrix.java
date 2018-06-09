package Model;

public class CellMatrix {
    private int weight;
    private int heigh;

    private int[][] cell;

    private double rate;

    public CellMatrix() {
    }

    public CellMatrix(int weight, int heigh, double rate) {
        this.weight = weight;
        this.heigh = heigh;
        this.rate = rate;
        cell = new int[heigh][weight];
    }

    public void LifeRule() {
        int[][] tempMatrix=new int[heigh][weight];
        for (int i = 0; i < weight; i++)
            for (int j = 0; j < heigh; j++) {
                tempMatrix[i][j]=0;
                int num=AroundCellNumbers(i,j);
                System.out.println(num);
                if (num == 3) {
                    tempMatrix[i][j] = 1;
                }
                else if(num==2){
                    tempMatrix[i][j] = cell[i][j];
                }
            }
        cell=tempMatrix;
    }

    public int AroundCellNumbers(int x, int y) {
        int count = 0;

        //上方
        if (x != 0)
            count += cell[x-1][y ];
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

    public void setCell(int x,int y,int value) {
        this.cell[x][y]=value;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
