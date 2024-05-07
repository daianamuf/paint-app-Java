package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileManager {

    public static void savePanelAsImage(JPanel panel, String path) throws IOException{
        int width = panel.getWidth();
        int height = panel.getHeight();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        panel.paint(g2d);
        g2d.dispose();

        File file = new File(path);
        ImageIO.write(image, "PNG", file);
    }
}
