import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Mouse {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
                {
                    Frame frame = new Frame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    frame.setTitle("Mouse");
                    Image image = new ImageIcon("c:\\1\\pirate.jpg").getImage();
                    frame.setIconImage(image);
                }
        );
    }
    static class Frame extends JFrame {
        Frame () {
            add(new MouseComponent());
            pack();
        }
    }
    public static class MouseComponent extends JComponent {
        private static final int SIDELONG = 20;
        private final ArrayList<Rectangle2D> squares;
        private Rectangle2D current;

        public MouseComponent ()
        {
            squares = new ArrayList<>();
            current = null;
            addMouseListener(new MouseHandler());
            addMouseMotionListener(new MouseMotionHandler());

        }

        public Dimension getPreferredSize (){
            return new Dimension(500, 500);
        }

        @Override
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            for(Rectangle2D r : squares){
                g2.draw(r);
            }
        }
        public Rectangle2D find(Point2D p) {
            for (Rectangle2D r : squares) {
                if(r.contains(p)) return r;
            }
            return null;
        }
        public void add (Point2D p) {
            double x = p.getX();
            double y = p.getY();
            current = new Rectangle2D.Double(
                    x - SIDELONG/2,
                    y - SIDELONG/2,
                    SIDELONG, SIDELONG
            );
            squares.add(current);
            repaint();
        }
        public void remove(Rectangle2D s) {
            if (s == null) return;
            if (s == current) current = null;
            squares.remove(s);
            repaint();
        }
        private class MouseHandler extends MouseAdapter {

            @Override
            public void mousePressed(MouseEvent e) {
                current = find(e.getPoint());
                if (current == null) add(e.getPoint());
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                current = find(e.getPoint());
                if(current != null && e.getClickCount() >=2) remove(current);
            }
        }
        private class MouseMotionHandler implements MouseMotionListener {

            @Override
            public void mouseDragged(MouseEvent e) {
                if (current != null) {
                    int x = e.getX();
                    int y = e.getY();
                    current.setFrame(x - SIDELONG/2,
                            y - SIDELONG/2,
                            SIDELONG, SIDELONG);
                    repaint();
                }

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if (find(e.getPoint()) == null) {
                    setCursor(Cursor.getDefaultCursor());
                } else {
                    setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
                }
            }
        }
    }
}
