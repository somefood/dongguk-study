import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Main extends JFrame {
    private JLabel la = new JLabel("c");

    Main() {
        setTitle("Mouse Event");

        Container c = getContentPane();
        c.setLayout(null);
        c.addMouseListener(new MyMouseLi());

        la.setSize(50, 20);
        la.setLocation(30, 30);

        c.add(la);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    private class MyMouseLi implements MouseListener {

        Random rand = new Random();

        @Override
        public void mouseClicked(MouseEvent e) {
            int x = rand.nextInt(400);
            int y = rand.nextInt(300);
            la.setLocation(x, y);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}