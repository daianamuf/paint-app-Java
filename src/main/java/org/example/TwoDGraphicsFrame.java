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
        JButton lineButton = new JButton("Line");
        lineButton.addActionListener(e -> toolManager.setCurrentTool("Line"));
        toolBar.add(lineButton);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            try {
                FileManager.savePanelAsImage(drawingPanel, "drawing.png");
                JOptionPane.showMessageDialog(this, "Saved Successfully!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error Saving File: " + ex.getMessage());
            }
        });
        toolBar.add(saveButton);

        add(toolBar, BorderLayout.NORTH);
    }


}
