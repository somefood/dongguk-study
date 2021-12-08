import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.util.Arrays;

public class ColorFrame extends JFrame {

    ColorFrame() {
        setTitle("video");
        setContentPane(new MyPanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // 1. File Read
            int data[] = new int[600 * 2000];
            int W = 256;
            int H = 256;
            int n = 0, temp;

            int colorW = W * 3;

            try {
                FileInputStream fin = new FileInputStream("girl.raw");
                while ((temp = fin.read()) != -1) {
                    data[n++] = temp;
                }
                fin.close();
            } catch (Exception e) {
                System.out.println("file read error");
            }
            // 2. 1 Array -> 2 Array
            int R[][] = new int[600][600];
            int G[][] = new int[600][600];
            int B[][] = new int[600][600];

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < colorW; j++) {
                    switch (j % 3) {
                        case 0:
                            R[i][j / 3] = data[i * colorW + j];
                            break;
                        case 1:
                            G[i][j / 3] = data[i * colorW + j];
                            break;
                        case 2:
                            B[i][j / 3] = data[i * colorW + j];
                    }
                }
            }

            // 3. GUI Graphic print
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    g.setColor(new Color(R[i][j], G[i][j], B[i][j]));
                    g.drawOval(20 + j, 20 + i, 1, 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        new ColorFrame();
    }
}
