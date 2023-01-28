import javafx.scene.shape.Circle;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class test {

    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
                {
                    SimpleFrame frame = null;
                    try {
                        frame = new SimpleFrame();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    frame.setTitle("FUCK YOU!!!");
                    frame.isResizable();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                } );

    }
    static class SimpleFrame extends JFrame {


        public SimpleFrame () throws InterruptedException {
            // getPreferredSize();
            //for (int i = 1; i <= 1000; i++) {
                add(new mycomp());
                //Thread.sleep(10);
                pack();
           // }


        }

    }
    static class mycomp extends JComponent {
        private static final int MESSAGE_X = 200;
        private static final int MESSAGE_Y = 300;
        private static final int DEFAULT_WIDTH = 1800;
        private static final int DEFAULT_HEIGTH = 960;

        @Override
        public void paint(Graphics g) {

            Graphics2D g2 = (Graphics2D) g;
            //for (int i = 1; i < 500000; i++){
               // Rectangle2D rect = new Rectangle2D.Double(100+2*i,100+2*i,300-4*i,300-4*i);
               // g2.draw(rect);
              /*  double red = Math.random()*255;
                double green = Math.random()*255;1  
                double blue = Math.random()*255;
                int redd = (int) red;
                int greenn = (int) green;
                int bluee = (int) blue;
                g2.setColor(new Color(redd, greenn, bluee));
                Point2D point2D = new Point2D.Double(Math.random()*1500,Math.random()*1500);
                Point2D point2D1 = new Point2D.Double(Math.random()*1500, Math.random()*1500);
                Line2D line2D = new Line2D.Double(point2D1, point2D);
                g2.draw( line2D);
            //} */
            String [] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
            int num = 0;
           for(int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {

                    num+=2;
                    System.out.println(num);
                    Font font = new Font(fonts[num], Font.BOLD,24);
                    g2.setFont(font);
                    g2.drawString("Fuck you!!!", j * 140, i * 100);
                }
            }
        }
        public Dimension getPreferredSize() {
            return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGTH);
        }
    }
}
