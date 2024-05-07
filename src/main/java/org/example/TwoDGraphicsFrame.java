package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class TwoDGraphicsFrame extends JFrame {
    private ToolManager toolManager = new ToolManager();
    public TwoDGraphicsFrame(){
        setTitle("Java Paint Application :)");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        DrawingPanel drawingPanel = new DrawingPanel(toolManager);
        add(drawingPanel, BorderLayout.CENTER);

        JToolBar toolBar = new JToolBar();
        JButton brushButton = new JButton("Brush");
        brushButton.addActionListener(e -> toolManager.setCurrentTool("Brush"));
        toolBar.add(brushButton);

        JButton lineButton = new JButton("Line");
        lineButton.addActionListener(e -> toolManager.setCurrentTool("Line"));
        toolBar.add(lineButton);

        JButton rectangleButton = new JButton("Rectangle");
        rectangleButton.addActionListener(e -> toolManager.setCurrentTool("Rectangle"));
        toolBar.add(rectangleButton);

        JButton circleButton = new JButton("Circle");
        circleButton.addActionListener(e -> toolManager.setCurrentTool("Circle"));
        toolBar.add(circleButton);

        JButton undoButton = new JButton("Undo");
        undoButton.addActionListener(e -> drawingPanel.undoLastShape());
        toolBar.add(undoButton);

        JButton eraseAllButton = new JButton("Erase All");
        eraseAllButton.addActionListener(e -> drawingPanel.clearAllShapes());
        toolBar.add(eraseAllButton);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            try {
                FileManager.savePanelAsImage(drawingPanel);
                JOptionPane.showMessageDialog(this, "Saved Successfully!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error Saving File: " + ex.getMessage());
            }
        });
        toolBar.add(saveButton);

        add(toolBar, BorderLayout.NORTH);

        ColorPanel colorPanel = new ColorPanel(toolManager);
        add(colorPanel, BorderLayout.EAST);


    }


}
