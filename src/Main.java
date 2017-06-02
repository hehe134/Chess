import javax.swing.*;
import java.awt.*;

/**
 * Created by 中奇 on 2017/5/18.
 */


public class Main extends JFrame{
    private Chess drawChessBoard;
    public Main() {
        drawChessBoard = new Chess();

        setTitle("Гомоку");

        setContentPane(drawChessBoard);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        addMouseListener(drawChessBoard);
    }
    public static void main(String[] args) {
        Main m = new Main();
        m.setSize(840, 840);
        m.setVisible(true);
        //m.setLocation();
    }
}