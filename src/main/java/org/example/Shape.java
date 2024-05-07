package org.example;

import java.awt.*;

public abstract class Shape {
    protected int x, y;
    protected java.awt.Color color;

    public Shape(int x, int y, java.awt.Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public abstract void draw(Graphics g);
}
