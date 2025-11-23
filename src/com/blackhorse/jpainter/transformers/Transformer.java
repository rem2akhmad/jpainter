package com.blackhorse.jpainter.transformers;

import com.blackhorse.jpainter.Frame;
import com.blackhorse.jpainter.Vector;
import com.blackhorse.jpainter.painters.Painter;

import java.awt.geom.Point2D;

/**
 * User: ra
 * Date: 19.10.2007
 */
public class Transformer implements Painter {
    private Point2D origin = null;
    private Point2D corner1 = null;
    private Point2D corner2 = null;
    private Painter painter = null;

    /**
     *
     * @param painter
     * @param origin
     * @param corner1
     * @param corner2
     */
    protected Transformer(final Painter painter, final Point2D origin, final Point2D corner1, final Point2D corner2) {
        this.painter = painter;
        this.origin = origin;
        this.corner1 = corner1;
        this.corner2 = corner2;
    }

    public void draw(Frame frame) {
        Point2D newOrigin = frame.vectorTransform(origin);
        Point2D newEdge1 = Vector.subVectors(frame.vectorTransform(corner1), newOrigin);
        Point2D newEdge2 = Vector.subVectors(frame.vectorTransform(corner2), newOrigin);
        painter.draw(new Frame(newOrigin, newEdge1, newEdge2));
    }
}
