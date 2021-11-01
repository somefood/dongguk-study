import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    Main() {
        Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK, Color.magenta, Color.LIGHT_GRAY, Color.CYAN, Color.GRAY};
        setTitle("실습");

        Container c = getContentPane();

        c.setLayout(null);

        for (int i=0; i<10; i++) {
            JButton bt = new JButton(Integer.toString(i));
            bt.setLocation(i * 80, 0);
            bt.setSize(80, 300);
            bt.setBackground(colors[i]);

            bt.addActionListener(new MyActionLi());

            c.add(bt);
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}

class MyActionLi implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        b.setBackground(Color.WHITE);
    }
}