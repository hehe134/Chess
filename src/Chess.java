import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by 中奇 on 2017/5/16.
 */

public class Chess extends JPanel implements MouseListener {
    final private int ROWS = 14;
    final private int chess_width = 40;

    int[][] allChess = new int[15][15];
    int x, y;
    int[] chessX = new int[255];
    int[] chessY = new int[255];
    int countX, countY;
    Boolean isblack = true; //true-black，false-white
    Boolean canPlay = true;

    void Chess() {
        setBounds(200, 200, 840, 840);
        setVisible(true);
    }

    public void paint(Graphics g) {
        //setBounds(200, 200, 840, 840);
        //setVisible(true);

        //setPreferredSize(Dimension preferredSize);
        System.out.println("draw\r\n");
        Color c = g.getColor();
//
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 840, 840);
        g.setColor(c);
//
        g.setColor(Color.black);
        g.fillOval(356, 356, 8, 8);
        g.setColor(Color.black);
        g.fillOval(196, 196, 8, 8);
        g.setColor(Color.black);
        g.fillOval(516, 196, 8, 8);
        g.setColor(Color.black);
        g.fillOval(196, 516, 8, 8);
        g.setColor(Color.black);
        g.fillOval(516, 516, 8, 8);
//
        for (int i = 0; i <= ROWS; i++) {
            g.drawLine(80, 80 + chess_width * i, ROWS * chess_width + 80, 80 + chess_width * i);
        }
        for (int i = 0; i <= ROWS; i++) {
            g.drawLine(80 + chess_width * i, 80, 80 + chess_width * i, ROWS * chess_width + 80);
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {

                if (allChess[i][j] == 1) {
                    int tempX = i * chess_width + 80;
                    int tempY = j * chess_width + 80;
                    g.setColor(Color.BLACK);
                    g.fillOval(tempX - 13, tempY - 13, 26, 26);
                    g.setColor(Color.BLACK);
                    g.drawOval(tempX - 13, tempY - 13, 26, 26);
                }

                if (allChess[i][j] == 10) {
                    int tempX = i * chess_width + 80;
                    ;
                    int tempY = j * chess_width + 80;
                    g.setColor(Color.WHITE);
                    g.fillOval(tempX - 13, tempY - 13, 26, 26);
                    g.setColor(Color.BLACK);
                    g.drawOval(tempX - 13, tempY - 13, 26, 26);
                }
            }
        }

    }

    public boolean isWin() {
        boolean flag = false;

        int x1, y1, z1, z2;
        x1=0;
        y1=0;
        z1=0;
        z2=0;
            for (int i = 0; i < ROWS+1; i++) {
                for (int j = 0; j < ROWS+1; j++) {
                   if(i<10) x1 = allChess[i][j] + allChess[i + 1][j] + allChess[i + 2][j] + allChess[i + 3][j] + allChess[i + 4][j];
                   if(j<10) y1 = allChess[i][j] + allChess[i][j + 1] + allChess[i][j + 2] + allChess[i][j + 3] + allChess[i][j + 4];
                   if(i<10&&j<10) z1 = allChess[i][j] + allChess[i + 1][j + 1] + allChess[i + 2][j + 2] + allChess[i + 3][j + 3] + allChess[i + 4][j + 4];
                   if(i<10&&j>3) z2 = allChess[i][j] + allChess[i + 1][j - 1] + allChess[i + 2][j - 2] + allChess[i + 3][j - 3] + allChess[i + 4][j - 4];
                    if (x1 == 5 || y1 == 50 || x1 == 50 || y1 == 5 || z1 == 5 || z1 == 50 || z2 == 5 || z2 == 50) {
                        flag = true;
                        System.out.println("Win");
                        break;
                    }
                }
            }

        return flag;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (canPlay) {
            int point_x = e.getX() - 80;
            int point_y = e.getY() - 80;

            //if (point_x >= 60 && point_x <= ROWS * chess_width + 100 && point_y >= 60 && point_y <= ROWS * chess_width + 100) {
            System.out.println("OK");
            if (point_x % chess_width > chess_width/2) {
                x = point_x / chess_width + 1;
            } else {
                x = point_x / chess_width;
            }
            if (point_y % chess_width > chess_width/2) {
                y = point_y / chess_width;
            } else {
                y = point_y / chess_width - 1;
            }

            if (allChess[x][y] == 0) {
                chessX[countX++] = x;
                chessY[countY++] = y;

                if (isblack) {
                    allChess[x][y] = 1;
                    isblack = false;
                } else {
                    allChess[x][y] = 10;
                    isblack = true;
                }
                this.repaint();
            }
            if (this.isWin()) {
                if (allChess[x][y] == 1) {
                    JOptionPane.showMessageDialog(this, "black win");
                } else {
                    JOptionPane.showMessageDialog(this, "white win");
                }
                this.canPlay = false;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }

}
