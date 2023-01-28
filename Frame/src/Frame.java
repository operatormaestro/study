import jdk.jfr.Event;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Frame {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->
                var frame = new DrawFrame());
    }
    class DrawFrame extends JFrame {
        public DrawFrame () {
            add(new DrawCompanent());
        }
    }
    class DrawCompanent extends JComponent {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
        }
    }
}
