package Drawing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import VectorOperations.*;
import Vector2D.*;
import VectorOperations.VectorAddition;

public class Canvas extends JPanel {
    private Line line1;
    private Line line2;
    private boolean areParallel;
    private float angleDegrees;
    private Vector2D sumVector;

    public Canvas(Line l1, Line l2) {
        this.line1 = l1;
        this.line2 = l2;
        calculateParallel();
    }

    private void calculateParallel() {
        Vector2D v1 = VectorSubtraction.subtract(line1.getEnd(), line1.getStart());
        Vector2D v2 = VectorSubtraction.subtract(line2.getEnd(), line2.getStart());

        //Check if parallel
        float cross = VectorProduct.crossProduct(v1, v2);
        areParallel = (cross == 0);

        // Calculate dot product
        float dot = VectorProduct.dotProduct(v1, v2);

        // Calculate magnitudes
        float magV1 = (float) Math.sqrt(v1.getX() * v1.getX() + v1.getY() * v1.getY());
        float magV2 = (float) Math.sqrt(v2.getX() * v2.getX() + v2.getY() * v2.getY());

        // Calculate angle in degrees
        angleDegrees = (float) Math.toDegrees(Math.acos(dot / (magV1 * magV2)));

        sumVector = VectorAddition.add(v1, v2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Draw first line
        g2.drawLine(
                (int) line1.getStart().getX(), (int) line1.getStart().getY(),
                (int) line1.getEnd().getX(), (int) line1.getEnd().getY()
        );

        // Draw second line
        g2.drawLine(
                (int) line2.getStart().getX(), (int) line2.getStart().getY(),
                (int) line2.getEnd().getX(), (int) line2.getEnd().getY()
        );

        // Draw sumVector starting at (50, 300) for visibility
        int baseX = 50;
        int baseY = 300;
        g2.setColor(Color.RED);
        g2.drawLine(baseX, baseY, baseX + (int) sumVector.getX(), baseY + (int) sumVector.getY());

        g2.setColor(Color.BLACK);
        // Draw message
        g2.setFont(new Font("Arial", Font.BOLD, 16));
        g2.drawString(areParallel ? "Lines are parallel" : "Lines are NOT parallel", 20, 20);
        g2.drawString(String.format("Angle between lines: %.2f degrees", angleDegrees), 20, 40);
        g2.drawString("Red line = sum of direction vectors", 20, 60);
    }


}
