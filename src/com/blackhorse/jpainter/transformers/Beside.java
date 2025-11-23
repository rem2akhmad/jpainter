package com.blackhorse.jpainter.transformers;

import com.blackhorse.jpainter.Frame;
import com.blackhorse.jpainter.painters.Painter;

import java.awt.geom.Point2D;

/**
 * User: ra
 * Date: 19.10.2007
 */
public class Beside implements Painter{
    private Painter leftP = null;
    private Painter rightP = null;

    /**
     *
     * @param painter1
     * @param painter2
     */
    public Beside(Painter painter1, Painter painter2) {
        Point2D splitPoint = new Point2D.Float(0.5f, 0.0f);
        leftP = new Transformer(
                painter1,
                new Point2D.Float(0.0f, 0.0f),
                splitPoint,
                new Point2D.Float(0.0f, 1.0f)
        );
        rightP = new Transformer(
                painter2,
                splitPoint,
                new Point2D.Float(1.0f, 0.0f),
                new Point2D.Float(0.5f, 1.0f)
        );
    }


    public void draw(Frame frame) {
        leftP.draw(frame);
        rightP.draw(frame);
    }
}
