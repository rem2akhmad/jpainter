package com.blackhorse.jpainter;

import java.awt.geom.Point2D;

/**
 * User: ra
 * Date: 19.10.2007
 */
public class Vector {

    /**
     * Сложение двух векторов, представленных точками v2 и v2 соответственно
     * @param v1 - вектор от начала координат до точки v1
     * @param v2 - вектор от начала координат до точки v2
     * @return сумма векторов
     */
    public static Point2D addVectors(Point2D v1, Point2D v2) {
        return new Point2D.Float((float)(v1.getX() + v2.getX()), (float)(v1.getY() + v2.getY()));
    }

    /**
     * Вычитание вектора v2 из вектора v1
     * @param v1
     * @param v2
     * @return
     */
    public static Point2D subVectors(Point2D v1, Point2D v2) {
        return new Point2D.Float((float)(v1.getX() - v2.getX()), (float)(v1.getY() - v2.getY()));
    }

    /**
     * Умножение вектора на число
     * @param s
     * @param v
     * @return
     */
    public static Point2D scaleVector(float s, Point2D v) {
        return new Point2D.Float((float)(v.getX() * s), (float) (v.getY() * s));
    }

}
