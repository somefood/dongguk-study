import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    private JLabel la = new JLabel("Hello");

//    Main() {
//        setTitle("Action Event");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Container c = getContentPane();
//        c.setLayout(new FlowLayout());
//        JButton btn = new JButton("Action");
//        btn.addActionListener(new MyActionListener());
//        c.add(btn);
//
//        setSize(350, 150);
//        setVisible(true);
//    }
//
//    private class MyActionListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            JButton b = (JButton) e.getSource();
//            if (b.getText().equals("Action")) {
//                b.setText("액션");
//            } else {
//                b.setText("Action");
//            }
//            Main.this.setTitle(b.getText());
//        }
//    }
    Main() {
        setTitle("mouse event");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.addMouseListener(new MyMouseListener());

        c.setLayout(null);
        la.setSize(50, 20);
        la.setLocation(30, 30);
        c.add(la);

        setSize(250, 250);
        setVisible(true);
    }

    class MyMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            la.setLocation(x, y);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}