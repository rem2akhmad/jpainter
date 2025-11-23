package com.blackhorse.jpainter.transformers;

import com.blackhorse.jpainter.Frame;
import com.blackhorse.jpainter.painters.Painter;

import java.awt.geom.Point2D;

/**
 * User: ra
 * Date: 19.10.2007
 */
public class Below implements Painter {
    private Painter upP = null;
    private Painter bottomP = null;

    /**
     * 
     * @param painter1
     * @param painter2
     */
    public Below(Painter painter1, Painter painter2) {
        Point2D splitPoint = new Point2D.Float(0.0f, 0.5f);
        upP = new Transformer(
                painter1,
                new Point2D.Float(0.0f, 0.0f),
                new Point2D.Float(1.0f, 0.0f),
                splitPoint
        );
        bottomP = new Transformer(
                painter2,
                splitPoint,
                new Point2D.Float(1.0f, 0.5f),
                new Point2D.Float(0.0f, 1.0f)
        );

    }

    public void draw(Frame frame) {
        upP.draw(frame);
        bottomP.draw(frame);
    }
}
