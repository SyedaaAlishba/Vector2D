package VectorOperations;
import Vector2D.*;
public class VectorAddition {
    public static Vector2D add(Vector2D v1, Vector2D v2){
        return new Vector2D(v1.getX()+v2.getX(), v1.getY()+v2.getY());
    }
}
