/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author gbchamoulaud
 */
public class Vue extends JFrame implements Observer {
    
    private int WIDTH = 1080;
    private int HEIGHT = 720;
    
    public Vue (String titre)
    {
        super(titre);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	setBounds(200,150,WIDTH,HEIGHT);			
	JPanel panel = new JPanel();
        //JPanel panel2 = new JPanel();
        
        //panel.setBounds(0, 0, WIDTH*10/100, HEIGHT);
        //panel2.setBounds(WIDTH*10/100, 0 , WIDTH*90/100, HEIGHT);
        
        JButton bouton1 = new JButton("Bouton 1");
        JButton bouton2 = new JButton("Bouton 2");
        
        bouton1.setBackground(Color.green);
        bouton2.setBackground(Color.MAGENTA);       
        //panel.setBackground(Color.blue);
        //panel2.setBackground(Color.red);       
    
        add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(bouton1);
        panel.add(bouton2);
        
        //BufferedImageTYPE_INT_RGB img = new BufferedImageTYPE_INT_RGB();        
        //add(new Panel());
        //add(panel2);            
        
        
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*private void paintSet(GraphicsContext ctx, double reMin, double reMax, double imMin, double imMax, JPanel panel) {
        double precision = Math.max((reMax - reMin) / panel.getWidth(), (imMax - imMin) / panel.getHeight());
        int convergenceSteps = 50;
        for (double abs = reMin, xR = 0; xR < panel.getWidth(); abs = abs + precision, xR++) {
            for (double ord = imMin, yR = 0; yR < panel.getHeight(); ord = ord + precision, yR++) {
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
 
    /**
     * Checks the convergence of a coordinate (c, ci) The convergence factor
     * determines the color of the point.
     */
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
