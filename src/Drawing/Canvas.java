package Drawing;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import Vector2D.*;
import VectorOperations.VectorAddition;

public class Canvas extends JPanel {
//    private List<Line> lines = new ArrayList<>();
//
//    public void addLine(Vector2D start, Vector2D end) {
//        lines.add(new Line(start, end));
//        repaint();
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2 = (Graphics2D) g;
//
//        for (Line line : lines) {
//            g2.drawLine((int) line.start.getX(), (int) line.start.getY(), (int) line.end.getX(), (int) line.end.getY());
//
//        }
//    }
private List<Line> lines = new ArrayList<>();
    private Vector2D velocity = new Vector2D(1, 0);  // Moves horizontally right

    public void addLine(Line line) {
        lines.add(line);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Draw all lines
        for (Line line : lines) {
            g2.drawLine(
                    (int) line.getStart().getX(), (int) line.getStart().getY(),
                    (int) line.getEnd().getX(), (int) line.getEnd().getY()
            );
        }
    }

    // Call this method to update positions of line endpoints
    public void animate() {
        if (lines.size() < 2) return;

        // Move second line by velocity vector
        Line movingLine = lines.get(1);

        Vector2D newStart = VectorAddition.add(movingLine.getStart(), velocity);
        Vector2D newEnd = VectorAddition.add(movingLine.getEnd(), velocity);

        movingLine.setStart(newStart);
        movingLine.setEnd(newEnd);

        repaint();
    }


}
