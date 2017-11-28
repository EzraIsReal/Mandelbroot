package Controleur;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Modele.*;
import Vue.*;

public class Controleur {

	public Modele m = new Modele(-2,1,-1.2,1.2);
	
	public Controleur(Modele modele)
	{
		this.m = modele;
	}
	
	//*** SETTERS MANDELBROT ***//
	public void set_MANDELBROT_RE_MIN(double MANDELBROT_RE_MIN)
	{
		m.setMANDELBROT_RE_MIN(MANDELBROT_RE_MIN);
	}
	public void set_MANDELBROT_RE_MAX(double MANDELBROT_RE_MAX)
	{
		m.setMANDELBROT_RE_MAX(MANDELBROT_RE_MAX);
	}
	public void set_MANDELBROT_IM_MIN(double MANDELBROT_IM_MIN)
	{
		m.setMANDELBROT_IM_MIN(MANDELBROT_IM_MIN);
	}
	public void set_MANDELBROT_IM_MAX(double MANDELBROT_IM_MAX)
	{
		m.setMANDELBROT_IM_MAX(MANDELBROT_IM_MAX);
	}
	
	//*** ZOOM ***//
	public void zoom () {
		System.out.println("CONTROLEUR - ZOOM - DEBUT");
		set_MANDELBROT_RE_MIN( m.getMANDELBROT_RE_MIN()-100 );
		set_MANDELBROT_RE_MAX( m.getMANDELBROT_RE_MAX()-100 );
		set_MANDELBROT_IM_MIN( m.getMANDELBROT_IM_MIN()-100 );
		set_MANDELBROT_IM_MAX( m.getMANDELBROT_IM_MAX()-100 );
		System.out.println("CONTROLEUR - ZOOM - FIN");
	}
	
	//*** APPLIQUER GRAPHICS ***//
	public BufferedImage appliquerGraphics (Modele modele)
	{
		return this.dessiner(modele.getMANDELBROT_RE_MIN(), modele.getMANDELBROT_RE_MAX(),
				modele.getMANDELBROT_IM_MIN(), modele.getMANDELBROT_IM_MAX(),
				modele.getCANVAS_WIDTH(), modele.getCANVAS_HEIGHT());
	}
	
	//*** DESSINER ***//
    public BufferedImage dessiner(double reMin, double reMax, double imMin,
    								double imMax, int width, int height/*,
    									Graphics2D g*/) {
        
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
    
  //*** CHECK CONVERGENCE ***//
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
