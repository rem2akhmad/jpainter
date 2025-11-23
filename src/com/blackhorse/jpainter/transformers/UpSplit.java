package com.blackhorse.jpainter.transformers;

import com.blackhorse.jpainter.Frame;
import com.blackhorse.jpainter.painters.Painter;

/**
 * User: ra
 * Date: 19.10.2007
 */
public class UpSplit implements Painter {
    private Painter painter = null;
    public UpSplit(Painter painter, int n) {
        Painter smaller = painter;
        for(int i = 0; i < n; i++ ) {
            smaller = new Below(painter, new Beside(smaller, smaller));
        }
        this.painter = smaller;
        
    }

    public void draw(Frame frame) {
        painter.draw(frame);
    }
}
