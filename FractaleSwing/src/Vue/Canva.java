/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;
import Modele.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Canva extends JPanel{        
     public Graphics2D g;
     int width;
     int height;
    
    public Canva (int width, int height){       
        super();
        this.width = width;
        this.height = height;
        Modele.img = dessiner(Modele.MANDELBROT_RE_MIN,Modele.MANDELBROT_RE_MAX,Modele.MANDELBROT_IM_MIN,Modele.MANDELBROT_IM_MIN, width, height);
    }
    
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(Modele.img, 0, 0, null);
        Modele.img = dessiner(Modele.MANDELBROT_RE_MIN,Modele.MANDELBROT_RE_MAX,Modele.MANDELBROT_IM_MIN,Modele.MANDELBROT_IM_MIN, width, height);
    }
    
    public BufferedImage dessiner(double reMin, double reMax, double imMin, double imMax, int width, int height) {
        
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) image.createGraphics();
                
        double precision = Math.max((reMax - reMin) / image.getWidth(), (imMax - imMin) / image.getHeight());
        int convergenceSteps = 50;
        for (double abs = reMin, xR = 0; xR < image.getWidth(); abs = abs + precision, xR++) {
            for (double ord = imMin, yR = 0; yR < image.getHeight(); ord = ord + precision, yR++) {
                double convergenceValue = checkConvergence(ord, abs, convergenceSteps);
                double t1 = (double) convergenceValue / convergenceSteps;
                double c1 = Math.min(255 * 2 * t1, 255);
                double c2 = Math.max(255 * (2 * t1 - 1), 0);
                
                if (convergenceValue != convergenceSteps) {                    
                    float f1 = (float) (c1/255.0);
                    float f2 = (float) (c2/255.0);
                    Color col = new Color(f2,f1,f2);
                    g.setColor(col);
                    
                } else {
                    g.setColor(Color.BLUE);
                }
                g.fillRect((int)xR, (int)yR, 1, 1);
            }
        }
        g.dispose();
        return image;
    }
    
    private int checkConvergence(double ci, double c, int convergenceSteps) {
        double z = 0;
        double zi = 0;
        for (int i = 0; i < convergenceSteps; i++) {
            double ziT = 2 * (z * zi);
            double zT = z * z - (zi * zi);
            z = zT + c;
            zi = ziT + ci;
 
            if (z * z + zi * zi >= 4.0) {
                return i;
            }
        }
        return convergenceSteps;
    }
}
