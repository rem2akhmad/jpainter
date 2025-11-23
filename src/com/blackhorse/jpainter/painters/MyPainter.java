package com.blackhorse.jpainter.painters;

import com.blackhorse.jpainter.Frame;
import com.blackhorse.jpainter.transformers.CornerSplit;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: ra
 * Date: 19.10.2007
 */
public class MyPainter implements Painter {
    private Graphics2D gr = null;
    private List lines = new ArrayList();
    /**
     * Создает паинтер с рисованием на указанном устройстве
     * @param gr
     */
    public MyPainter(Graphics2D gr) {
        this.gr = gr;
        drawTri();
    }

    private void drawTri() {
        lines.add(new Line2D.Float(0.350f, 0.010f, 0.600f ,0.350f));
        lines.add(new Line2D.Float(0.600f, 0.350f, 0.010f, 0.350f));
        lines.add(new Line2D.Float(0.010f, 0.350f, 0.350f, 0.010f)); 
    }

    private void drawLine(Frame frame, Line2D line) {
        Point2D p1 = line.getP1();
        Point2D p2 = line.getP2();
        Point2D newp1 = frame.vectorTransform(p1);
        Point2D newp2 = frame.vectorTransform(p2);
        gr.drawLine((int)newp1.getX(), (int)newp1.getY(), (int)newp2.getX(), (int)newp2.getY());
    }

    
    public void draw(Frame frame) {
        Iterator linesIt = lines.iterator();
        while(linesIt.hasNext()) {
            Line2D line = (Line2D) linesIt.next();
            drawLine(frame, line);
        }
    }

    public static void main(String [] args) throws IOException {
        JFrame frame = new JFrame("my canvas");
        ImageIcon icon = new ImageIcon(new BufferedImage(700, 700, BufferedImage.TYPE_INT_RGB));
        JLabel label = new JLabel(icon);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(label);
        frame.pack();
        //////////////--------------
        //Painter painter = new MyPainter((Graphics2D) icon.getImage().getGraphics());
        Painter painter = new PicturePainter("./image.jpg", (Graphics2D) icon.getImage().getGraphics());
        Frame myFrame = new Frame(new Point2D.Float(0, 0), new Point2D.Float(600f, 100f), new Point2D.Float(100f, 600f));
        painter = new CornerSplit(painter, 10) ;
        painter.draw(myFrame);
        /////////////--------------
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
