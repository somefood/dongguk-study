import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;

public class Main extends JFrame {

    Main() {
        setTitle("영상 뷰어");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setContentPane(new MyPanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    class MyPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int data[] = new int[600 * 2000];
            int W = 512;
            int H = 512;
            int n=0, temp;

            int colorW = W * 3;

            try {
                FileInputStream fin = new FileInputStream("girl.raw");

                while ((temp=fin.read())!= -1) {
                    data[n++] = temp;
                }
                fin.close();
            } catch (Exception e) {
                System.out.println("Error");
            }

            int pix[][] = new int[300][300];
            for(int i=0; i<H; i++) {
                for(int j=0; j<W; j++) {
                    pix[i][j] = data[i*W+j];
                }
            }

            int R[][] = new int[600][600];
            int G[][] = new int[600][600];
            int B[][] = new int[600][600];
            for(int i=0; i<H; i++) {
                for(int j=0; j<W; j++) {
                    switch (j % 3) {
                        case 0:
                            R[i][j/3] = data[i * colorW + j];
                            break;
                        case 1:
                            G[i][j/3] = data[i * colorW + j];
                            break;
                        case 2:
                            B[i][j/3] = data[i * colorW + j];
                            break;
                    }
                }
            }

            for (int i=0; i<H; i++) {
                for(int j=0; j<W; j++) {
                    g.setColor(new Color(R[i][j], G[i][j], B[i][j]));
                    g.drawRect(20 + j, 20 + i, 1, 1);
                }
            }

        }
    }
}