package Drawing;
import Vector2D.*;
public class Line {
    public Vector2D start;
    public Vector2D end;

    public Line(Vector2D start, Vector2D end) {
        this.start = start;
        this.end = end;
    }

    public Vector2D getStart() {
        return start;
    }

    public Vector2D getEnd() {
        return end;
    }

}