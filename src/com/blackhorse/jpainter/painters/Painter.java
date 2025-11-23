package com.blackhorse.jpainter.painters;

import com.blackhorse.jpainter.Frame;

/**
 * User: ra
 * Date: 19.10.2007
 */
public interface Painter {
    /**
     * Рисует на указанном фрейме
     * @param frame
     */
    public void draw(Frame frame);
}
