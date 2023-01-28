import javax.swing.*;
import java.awt.*;

public class Color_button {
    public static void main(String[] args) {

        EventQueue.invokeLater(() ->
        {
            Frame frame = new Frame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Colors!");
            Image image = new ImageIcon("c:\\1\\pirate.jpg").getImage();
            frame.setIconImage(image);
            frame.setVisible(true);
        });


    }
    static class Frame extends JFrame {
        private final JPanel button_panel;
        public Frame () {

            setSize(400,400);

            button_panel = new JPanel();
            make_button("Red", Color.RED);
            make_button("Green",Color.GREEN);
            make_button("Blue", Color.BLUE);
            make_button("Yellow", Color.YELLOW);
            make_button("Black", Color.BLACK);
            make_button("Pink", Color.PINK);
            add(button_panel);
        }
        public void make_button(String name, Color bgColor) {
            JButton button = new JButton(name);
            button_panel.add(button);
            button.addActionListener(event ->
                    button_panel.setBackground(bgColor));

        }
    }
}
