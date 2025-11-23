package com.blackhorse.jpainter.transformers;

import com.blackhorse.jpainter.painters.Painter;

import java.awt.geom.Point2D;

/**
 * User: ra
 * Date: 19.10.2007
 */
public class FlipVertical extends Transformer {
    public FlipVertical(Painter painter) {
        super(
            painter,
            new Point2D.Float(0.0f, 1.0f),
            new Point2D.Float(1.0f, 1.0f),
            new Point2D.Float(0.0f, 0.0f)
         );
    }
}
