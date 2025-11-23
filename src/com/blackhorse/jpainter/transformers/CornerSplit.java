package com.blackhorse.jpainter.transformers;

import com.blackhorse.jpainter.Frame;
import com.blackhorse.jpainter.painters.Painter;

/**
 * User: ra
 * Date: 19.10.2007
 */
public class CornerSplit implements Painter {
    private Painter painter = null;

    public CornerSplit(Painter painter, int n) {
        Painter corner = painter;
        for(int i = 0; i < n; i++) {
            Painter up = new UpSplit(painter, i);
            Painter right = new RightSplit(painter, i);
            Painter topLeft = new Beside(up, up);
            Painter bottomRight = new Below(right, right);

            corner = new Beside(new Below(painter, topLeft),
                                new Below(bottomRight, corner));
        }
        this.painter = corner;
    }
    
    public void draw(Frame frame) {
        painter.draw(frame);
    }
}
