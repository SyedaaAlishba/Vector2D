package App;

import Drawing.*;
import Vector2D.Vector2D;
import VectorOperations.VectorAddition;
import VectorOperations.VectorProduct;
import VectorOperations.VectorSubtraction;

import javax.swing.*;

public class Program {
    public void run(){
//        Vector2D v1= new Vector2D(3,4);
//        Vector2D v2= new Vector2D(1,2);
//        Vector2D sum= VectorAddition.add(v1,v2);
//        Vector2D sub= VectorSubtraction.subtract(v1,v2);
//
//        float dot = VectorProduct.dotProduct(v1, v2);
//        float cross = VectorProduct.crossProduct(v1,v2);
//
//        System.out.println("Sum: " + sum);
//        System.out.println("Diff: " + sub);
//        System.out.println("Dot: " + dot);
//        System.out.println("Cross: " + cross);
//
//        JFrame frame = new JFrame("Canvas Demo");
//        Canvas canvas = new Canvas();
//
//        frame.add(canvas);
//        frame.setSize(600, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
////        canvas.addLine(new Vector2D(100, 100), new Vector2D(400, 400));
////        canvas.addLine(new Vector2D(50, 300), new Vector2D(300, 100));
//        Vector2D start = new Vector2D(50, 300);
//        Vector2D direction = new Vector2D(250, -200); // vector pointing up-right
//        Vector2D end = new Vector2D(start.getX() + direction.getX(), start.getY() + direction.getY());
//
//        canvas.addLine(start, end);

        JFrame frame = new JFrame("Vector Animation Demo");
        Canvas canvas = new Canvas();

        // Define two lines
        Line line1 = new Line(new Vector2D(100, 100), new Vector2D(300, 300));
        Line line2 = new Line(new Vector2D(100, 200), new Vector2D(300, 400));

        canvas.addLine(line1);
        canvas.addLine(line2);

        frame.add(canvas);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Check if lines are parallel initially
        Vector2D v1 = VectorSubtraction.subtract(line1.getEnd(), line1.getStart());
        Vector2D v2 = VectorSubtraction.subtract(line2.getEnd(), line2.getStart());
        float cross = VectorProduct.crossProduct(v1, v2);
        System.out.println(cross == 0 ? "Lines are parallel" : "Lines are NOT parallel");

        // Animate: Move line2 to the right every 50 ms
        new Timer(50, e -> {
            canvas.animate();

            // Optional: After moving, check if parallel again and print
            Vector2D newV2 = VectorSubtraction.subtract(line2.getEnd(), line2.getStart());
            float newCross = VectorProduct.crossProduct(v1, newV2);
            System.out.println(newCross == 0 ? "Lines are parallel" : "Lines are NOT parallel");
        }).start();


    }


}

