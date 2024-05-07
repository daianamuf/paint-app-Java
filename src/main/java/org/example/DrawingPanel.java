package org.example;

import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingPanel extends JPanel {
    private Point lastPoint;
    private ToolManager toolManager;
    public DrawingPanel(ToolManager toolManager) {
        setPreferredSize(new java.awt.Dimension(800, 800));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastPoint = e.getPoint();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(toolManager.getCurrentTool().equals("Line")) {
                    Graphics2D g = (Graphics2D) getGraphics();
                    g.drawLine(lastPoint.x, lastPoint.y, e.getX(), e.getY());
                    lastPoint = e.getPoint();
                }
            }
        });
    }
        @Override protected void paintComponent(Graphics g){
            super.paintComponent(g);
        }

}
