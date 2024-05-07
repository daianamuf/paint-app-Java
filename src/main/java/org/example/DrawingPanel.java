package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {
    private ToolManager toolManager;
    private Point startPoint;
    private List<Shape> shapes = new ArrayList<>();
    private Shape currentShape;

    public DrawingPanel(ToolManager toolManager) {
        this.toolManager = toolManager;
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
                switch (toolManager.getCurrentTool()) {
                    case "Brush":
                        currentShape = new Brush(startPoint.x, startPoint.y, toolManager.getCurrentColor() );
                        break;
                    case "Line":
                        currentShape = new Line(startPoint.x, startPoint.y, startPoint.x, startPoint.y, toolManager.getCurrentColor());
                        break;
                    case "Rectangle":
                        currentShape = new Rectangle(startPoint.x, startPoint.y, 0,0, toolManager.getCurrentColor());
                        break;
                    case "Circle":
                        currentShape = new Circle(startPoint.x, startPoint.y, 0 , toolManager.getCurrentColor());
                        break;

                }
                shapes.add(currentShape);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                repaint();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point endPoint = e.getPoint();
                if (currentShape instanceof Line) {
                    ((Line) currentShape).setEnd(endPoint.x, endPoint.y);
                } else if(currentShape instanceof Rectangle){
                    int width = e.getX() - startPoint.x;
                    int height = e.getY() - startPoint.y;
                    ((Rectangle) currentShape).setDimensions(width, height);
                } else if (currentShape instanceof Circle){
                    int radius = (int) Math.hypot(e.getX() - startPoint.x, e.getY() - startPoint.y);
                    ((Circle) currentShape).setRadius(radius);
                } else if(currentShape instanceof Brush){
                    ((Brush) currentShape).addPoint(e.getX(), e.getY());
                }
                repaint();
            }
        });
    }

    public void clearAllShapes() {
        shapes.clear();
        repaint();
    }

    public void undoLastShape() {
        if (!shapes.isEmpty()) {
            shapes.remove(shapes.size() - 1);
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }
}
