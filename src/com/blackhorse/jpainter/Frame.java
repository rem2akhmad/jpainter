package com.blackhorse.jpainter;

import java.awt.geom.Point2D;

/**
 * Рамка в которой будут рисоваться различные изображения
 * User: ra
 * Date: 19.10.2007
 */
public class Frame {
    // координаты исходной точки
    private Point2D origin = null;
    // горизонтальный вектор от исходной точки
    private Point2D edge1 = null;
    // вертикальный вектор от исходной точки
    private Point2D edge2 = null;

    public Frame(Point2D origin, Point2D edge1, Point2D edge2) {
        this.origin = origin;
        this.edge1 = edge1;
        this.edge2 = edge2;
    }


    public Point2D getOrigin() {
        return origin;
    }

    public Point2D getEdge1() {
        return edge1;
    }

    public Point2D getEdge2() {
        return edge2;
    }

    public Point2D vectorTransform(Point2D v) {
        return Vector.addVectors(origin,
                    Vector.addVectors(Vector.scaleVector((float) v.getX(),  edge1),
                                      Vector.scaleVector((float) v.getY(),  edge2))); 
    }
    
}
