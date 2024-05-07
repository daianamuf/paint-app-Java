package org.example;

import java.awt.*;

public class Rectangle extends Shape {
    private int width, height;

    public Rectangle(int x, int y, int width, int height, java.awt.Color color){
        super(x,y, color);
        this.width = width;
        this.height = height;
    }

    @Override public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
