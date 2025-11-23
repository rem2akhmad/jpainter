package com.blackhorse.jpainter.transformers;

import com.blackhorse.jpainter.Frame;
import com.blackhorse.jpainter.painters.Painter;

/**
 * User: ra
 * Date: 19.10.2007
 */
public class FlippedPairs implements Painter {
    private Painter resP = null;
    public FlippedPairs(Painter painter) {
        Painter flipV = new FlipVertical(painter);
        Painter painter2 = new Beside(painter, flipV);
        resP = new Below(painter2, painter2);
    }

    public void draw(Frame frame) {
        resP.draw(frame);
    }
}
