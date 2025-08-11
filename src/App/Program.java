package App;

import Drawing.*;
import Vector2D.Vector2D;
import VectorOperations.VectorAddition;
import VectorOperations.VectorProduct;
import VectorOperations.VectorSubtraction;

import javax.swing.*;

public class Program {
    public void run(){
        Vector2D v1= new Vector2D(3,4);
        Vector2D v2= new Vector2D(1,2);
        Vector2D sum= VectorAddition.add(v1,v2);
        Vector2D sub= VectorSubtraction.subtract(v1,v2);

        float dot = VectorProduct.dotProduct(v1, v2);
        float cross = VectorProduct.crossProduct(v1,v2);

        System.out.println("Sum: " + sum);
        System.out.println("Diff: " + sub);
        System.out.println("Dot: " + dot);
        System.out.println("Cross: " + cross);

        Line line1 = new Line(new Vector2D(50, 50), new Vector2D(200, 200));
        Line line2 = new Line(new Vector2D(50, 100), new Vector2D(200, 250));

        JFrame frame = new JFrame("Vector Lines");
        Canvas canvas = new Canvas(line1, line2);

        frame.add(canvas);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);



    }


}

