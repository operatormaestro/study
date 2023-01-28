import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Environment {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
                {
                    Frame frame = new Frame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                }
                );
        }
    }
class Frame extends JFrame {
    private JPanel buttonpanel;
    public Frame () {
        setSize(500,500);

        JButton red = new JButton("Красный");
        JButton green = new JButton("Зеленый");
        JButton blue = new JButton("Синий");

        buttonpanel = new JPanel();

        buttonpanel.add(red);
        buttonpanel.add(green);
        buttonpanel.add(blue);

        add(buttonpanel);

        ColorAction redaction = new ColorAction(Color.RED);
        ColorAction greenaction = new ColorAction(Color.GREEN);
        ColorAction blueaction = new ColorAction(Color.BLUE);

        red.addActionListener(redaction);
        green.addActionListener(greenaction);
        blue.addActionListener(blueaction);
    }

    private class ColorAction implements ActionListener {

        private Color background;

        public ColorAction (Color c) {
            background = c;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            buttonpanel.setBackground(background);
        }
    }
}
