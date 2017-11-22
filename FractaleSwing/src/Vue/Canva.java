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

/**
 *
 * @author gbchamoulaud
 */
public class Canva extends JPanel{        
    
    public Canva (){
        super();
        Modele.img.dessiner();
    }
    
    public void paintComponent (Graphics g)
    {
        Graphics2D g2D = (Graphics2D) g;
        super.paintComponent(g);
        g.drawImage(Modele.img, 0, 0, null);
    }
    
    public void dessiner(Graphics g , double reMin, double reMax, double imMin, double imMax, JPanel panel) {
        
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2D = (Graphics2D) g;
        g = image.createGraphics();
                
        double precision = Math.max((reMax - reMin) / img.getWidth(), (imMax - imMin) / img.getHeight());
        int convergenceSteps = 50;
        for (double abs = reMin, xR = 0; xR < img.getWidth(); abs = abs + precision, xR++) {
            for (double ord = imMin, yR = 0; yR < img.getHeight(); ord = ord + precision, yR++) {
                double convergenceValue = checkConvergence(ord, abs, convergenceSteps);
                double t1 = (double) convergenceValue / convergenceSteps;
                double c1 = Math.min(255 * 2 * t1, 255);
                double c2 = Math.max(255 * (2 * t1 - 1), 0);
 
                if (convergenceValue != convergenceSteps) {                    
                    ctx.setFill(Color.color(c2 / 255.0, c1 / 255.0, c2 / 255.0));
                } else {
                    ctx.setFill(Color.BLUE); // Convergence Color
                }
                ctx.fillRect(xR, yR, 1, 1);
            }
        }
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
