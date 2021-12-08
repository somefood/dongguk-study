import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.util.Arrays;

public class MyFrame extends JFrame {

    MyFrame() {
        setTitle("video");
        setContentPane(new MyPanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // 1. File Read
            int data[] = new int[500 * 500];
            int W = 256;
            int H = 256;
            int n = 0, temp;

            try {
                FileInputStream fin = new FileInputStream("GIRL.dat");
                while ((temp = fin.read()) != -1) {
                    data[n++] = temp;
                }
                fin.close();
            } catch (Exception e) {
                System.out.println("file read error");
            }
            // 2. 1 Array -> 2 Array
            int bright = 0;
            int pix[][] = new int[300][300];
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
//                    pix[i][j] = data[i*W+j] + bright;
//                    if(pix[i][j] > 255)
//                        pix[i][j] = 255;
                    pix[i][j] = 255 - data[i * W + j] + bright; // 양화
                    if (pix[i][j] > 255)
                        pix[i][j] = 255;
                }
            }
            System.out.println(Arrays.toString(pix));
            // 3. GUI Graphic print
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    g.setColor(new Color(pix[i][j], pix[i][j], pix[i][j]));
                    g.drawOval(20 + j, 20 + i, 1, 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
