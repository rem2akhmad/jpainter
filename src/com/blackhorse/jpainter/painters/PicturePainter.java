package com.blackhorse.jpainter.painters;

import com.blackhorse.jpainter.Frame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * User: ra
 * Date: 19.10.2007
 */
public class PicturePainter implements Painter{
    private BufferedImage image = null;
    private Graphics2D gr = null;
    private AffineTransform transform = null;
    public PicturePainter(String filename, Graphics2D gr) throws IOException {
        image = ImageIO.read(new File(filename));
        this.gr = gr;
        transform = new AffineTransform();
    }

    public void draw(Frame frame) {
        this.gr.drawImage(image,
                (int)frame.getOrigin().getX(),
                (int)frame.getOrigin().getY(),
                (int)frame.getEdge1().getX(),
                (int)frame.getEdge2().getY(),
                null); 
    }
}
