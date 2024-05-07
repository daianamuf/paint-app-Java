package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorPanel extends JPanel {
    private JPanel colorPreview;
    private ToolManager toolManager;

    public ColorPanel(ToolManager toolManager) {
        this.toolManager = toolManager;
        setLayout(new BorderLayout());


        colorPreview = new JPanel();
        colorPreview.setBackground(toolManager.getCurrentColor());
        colorPreview.setPreferredSize(new Dimension(50, 50));
        add(colorPreview, BorderLayout.CENTER);


        JButton chooseColorButton = new JButton("Choose Color");
        chooseColorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color newColor = JColorChooser.showDialog(ColorPanel.this, "Choose a Color", toolManager.getCurrentColor());
                if (newColor != null) {
                    toolManager.setCurrentColor(newColor);
                    colorPreview.setBackground(newColor);
                }
            }
        });
        add(chooseColorButton, BorderLayout.SOUTH);
    }
}
