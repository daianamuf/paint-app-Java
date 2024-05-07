package org.example;

import java.awt.*;

public class Circle extends Shape{
    private int radius;

    public Circle(int x, int y, int radius, java.awt.Color color){
        super(x, y, color);
        this.radius = radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override public void draw(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, radius*2, radius*2);
    }
}
