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
        for (int i = 0; i < weight; i++)
            for (int j = 0; j < heigh; j++) {
                int num = AroundCellNumbers(i, j);
                if (num == 3) {
                    cell[i][j] = 1;
                } else if (num < 2 || num > 3) {
                    cell[i][j] = 0;
                }
            }
    }

    public int AroundCellNumbers(int x, int y) {
        int count = 0;

        //上方
        if (y != 0)
            count += cell[x][y - 1];
        //下方
        if (y != heigh - 1)
            count += cell[x][y + 1];
        //左方
        if (x != 0)
            count += cell[x - 1][y];
        //右方
        if (x != weight - 1)
            count += cell[x + 1][y];
        //右下
        if (x != weight - 1 && y != heigh - 1)
            count += cell[x + 1][y + 1];
        //左上
        if (x != 0 && y != 0)
            count += cell[x - 1][y - 1];
        //右上
        if (x != weight - 1 && y != 0)
            count = cell[x + 1][y - 1];
        //左下
        if (y != heigh - 1 && x != 0)
            count = cell[x - 1][y + 1];

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
        this.cell = cell;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
