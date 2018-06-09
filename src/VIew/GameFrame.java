package VIew;

import Model.CellMatrix;

import javax.swing.*;
import java.awt.*;
import java.security.PrivateKey;

public class GameFrame extends JFrame {
    private JTextField[][] celltext;
    private JPanel panel;
    private CellMatrix cellMatrix;
    private JButton start=new JButton("Start");
    private JButton pause=new JButton("pause");
    private JLabel weigth=new JLabel("长度");
    private JLabel height=new JLabel("宽度");
    private JLabel rate=new JLabel("时间间隔");
    private JPanel controlpanel=new JPanel();


    public GameFrame(CellMatrix cellMatrix) {
        setTitle("Life Game");
        this.setSize(1000, 1200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start();
        this.cellMatrix = cellMatrix;
        this.setVisible(true);
        add("Center", panel);
        controlpanel=new JPanel();
        controlpanel.setLayout(new FlowLayout());
        add(LEFT_ALIGNMENT,controlpanel);

    }

    public void start() {
        int rows = 50;
        int cols = 50;
        panel = new JPanel();
        panel.setLayout(new GridLayout(rows, cols));
        celltext = new JTextField[rows][cols];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                JTextField text = new JTextField();
                text.setEditable(false);
                text.setBorder(BorderFactory.createRaisedBevelBorder());
                celltext[y][x] = text;
                panel.add(text);
            }
        }
    }

    public void loadCell() {
        for (int i = 0; i < celltext.length; i++) {
            for (int j = 0; j < celltext[0].length; j++) {
                if (cellMatrix.getCell()[i][j] == 1) {
                    celltext[i][j].setBackground(Color.red);
                } else {
                    celltext[i][j].setBackground(Color.white);
                }
            }
        }
        panel.updateUI();
    }
}
