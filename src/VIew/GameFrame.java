package VIew;

import Model.CellMatrix;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PrivateKey;

public class GameFrame extends JFrame {
    private JTextField[][] celltext;
    private JPanel panel;
    private CellMatrix cellMatrix;
    private JButton start = new JButton("Start");
    private JButton pause = new JButton("Pause");
    private JLabel weigth = new JLabel("宽度");
    private JTextField weighttext = new JTextField();
    private JLabel height = new JLabel("高度");
    private JTextField heighttext = new JTextField();
    private JLabel rate = new JLabel("时间间隔");
    private JTextField ratetext = new JTextField();
    private JPanel controlpanel = new JPanel();
    private boolean isStart = false;
    private boolean isPause = false;

    public GameFrame(CellMatrix cellMatrix) {
        setTitle("Life Game");
        this.cellMatrix=cellMatrix;
        start.addActionListener(new StartGame());
        pause.addActionListener(new PauseGame());
        this.setSize(1000, 1200);

        controlpanel = new JPanel();
        controlpanel.setLayout(new GridLayout(1, 8));
        controlpanel.add(start);
        controlpanel.add(pause);
        controlpanel.add(weigth);
        controlpanel.add(weighttext);
        controlpanel.add(height);
        controlpanel.add(heighttext);
        controlpanel.add(rate);
        controlpanel.add(ratetext);
        add(controlpanel, BorderLayout.NORTH);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void start() {
        int rows=Integer.parseInt(heighttext.getText().trim());
        int cols=Integer.parseInt(weighttext.getText().trim());
        int rate=Integer.parseInt(ratetext.getText().trim());
        int[][] cell=new int[rows][cols];
        cellMatrix.setCell(cell);
        cellMatrix.setRate(rate);
        cellMatrix.init();
        System.out.print(rows+" "+cols+" "+rate);
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
        this.add("Center", panel);
    }

    private class StartGame implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!isStart) {
                isStart=true;
                start();
            }
            if(isPause)
                isPause=false;
            panel.updateUI();
        }
    }

    private class PauseGame implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            isPause = true;
        }
    }

    public boolean getstatus() {
        return isStart;
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
