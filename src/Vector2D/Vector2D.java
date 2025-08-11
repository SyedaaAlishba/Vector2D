package Vector2D;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D(){
        this.x=0;
        this.y=0;
    }
    public Vector2D(float x,float y){
        this.x=x;
        this.y=y;
    }

    public float getY() {
        return y;
    }

    public float getX() {
        return x;
    }

    @Override
    public String toString() {
        return "x "+this.getX()+" y "+this.getY();
    }
}
