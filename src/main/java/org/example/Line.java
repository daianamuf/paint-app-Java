package org.example;

import java.awt.*;

public class Line extends Shape{
    private int x2, y2;

    public Line(int x1, int y1, int x2, int y2, Color color){
        super(x1, y1, color);
        this.x2 = x2;
        this.y2 = y2;
    }

    public void setEnd(int x, int y) {
        this.x2 = x;
        this.y2 = y;
    }

    @Override public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(x, y, x2, y2);
    }
}
