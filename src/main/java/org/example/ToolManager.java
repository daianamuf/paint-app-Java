package org.example;

public class ToolManager {
    private Shape currentShape;
    private String currentTool;


    public void setCurrentShape(Shape shape){
        this.currentShape = shape;
    }

    public Shape getCurrentShape(){
        return currentShape;
    }

    public String getCurrentTool() {
        return currentTool;
    }

    public void setCurrentTool(String tool) {
        this.currentTool = tool;
    }
}
