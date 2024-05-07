package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Brush extends Shape {
    private List<Point> points = new ArrayList<>();

    public Brush(int x, int y, Color color){
        super(x, y, color);
        points.add(new Point(x,y));
    }

    public void addPoint(int x, int y){
        points.add(new Point(x,y));
    }

    @Override public void draw(Graphics g) {
        g.setColor(color);
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
