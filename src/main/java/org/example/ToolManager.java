package org.example;

import java.awt.*;

public class ToolManager {
    private Shape currentShape;
    private String currentTool = "Brush";
    private Color currentColor = Color.BLACK;


    public String getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(String tool) {
        this.currentTool = tool;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }
}
