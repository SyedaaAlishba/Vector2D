package VectorOperations;

import Vector2D.Vector2D;

public class VectorProduct {
    public static float dotProduct(Vector2D v1, Vector2D v2){
        return (v1.getX()*v2.getX()+v1.getY()*v2.getY());
    }

    public static float crossProduct(Vector2D v1, Vector2D v2){
        return (v1.getX() * v2.getY()) - (v1.getY() * v2.getX());
    }

}
