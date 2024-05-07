package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileManager {
private static String generateFilename(){
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
    return "drawing_" + sdf.format(new Date()) + ".png";
}
    public static void savePanelAsImage(JPanel panel) throws IOException{
        String path = generateFilename();
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
