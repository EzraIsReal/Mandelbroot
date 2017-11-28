package Modele;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Modele extends Observable{
	
    // Left and right border
    //public static final int X_OFFSET = 25;
    // Top and Bottom border
    //public static final int Y_OFFSET = 25;
	
    // Values for the Mandelbrot set
    public final int CANVAS_WIDTH = 930;
    public final int CANVAS_HEIGHT = 720;
    
    public int SCREEN_WIDTH = 1080;
    public int SCREEN_HEIGHT = 720;
    
    public double MANDELBROT_RE_MIN = -2; 
    public double MANDELBROT_RE_MAX = 1;
    public double MANDELBROT_IM_MIN = -1.2;
    public double MANDELBROT_IM_MAX = 1.2;
    
    public JPanel panel1;
    
    public JButton zoom_Plus;
    public JButton bouton2;
    public JLabel label_RE_MIN;
    public JLabel label_RE_MAX;
    public JLabel label_IM_MIN;
    public JLabel label_IM_MAX;
   
    public static BufferedImage img;
    public Graphics2D g;
	
	public Modele (double MANDELBROT_RE_MIN, double MANDELBROT_RE_MAX, double MANDELBROT_IN_MIN, double MANDELBROT_IN_MAX) {
		this.MANDELBROT_RE_MIN = MANDELBROT_RE_MIN ;
		this.MANDELBROT_RE_MAX = MANDELBROT_RE_MAX ;
		this.MANDELBROT_IM_MIN = MANDELBROT_IN_MIN ;
		this.MANDELBROT_IM_MAX = MANDELBROT_IN_MAX ;			
	}  
	
    public double getMANDELBROT_RE_MIN() {
		return this.MANDELBROT_RE_MIN;
	}

	public void setMANDELBROT_RE_MIN(double mANDELBROT_RE_MIN) {
		System.out.println("Modele - Changement Etat - RE_MIN Modifie");
		this.MANDELBROT_RE_MIN = mANDELBROT_RE_MIN;
		fire();
	}

    public double getMANDELBROT_RE_MAX() {
		return this.MANDELBROT_RE_MAX;
	}
    
	public void setMANDELBROT_RE_MAX(double mANDELBROT_RE_MAX) {
		System.out.println("Modele - Changement Etat - RE_MAX Modifie");
		this.MANDELBROT_RE_MAX = mANDELBROT_RE_MAX;
		fire();
	}

    public double getMANDELBROT_IM_MIN() {
		return MANDELBROT_IM_MIN;
	}
	public void setMANDELBROT_IM_MIN(double mANDELBROT_IM_MIN) {
		System.out.println("Modele - Changement Etat - IM_MIN Modifie");
		this.MANDELBROT_IM_MIN = mANDELBROT_IM_MIN;
		fire();
	}

    public double getMANDELBROT_IM_MAX() {
		return this.MANDELBROT_IM_MAX;
	}
	public void setMANDELBROT_IM_MAX(double mANDELBROT_IM_MAX) {
		System.out.println("Modele - Changement Etat - IM_MAX Modifie");
		this.MANDELBROT_IM_MAX = mANDELBROT_IM_MAX;
		fire();
	}
        
    public int getCANVAS_WIDTH(){
            return this.CANVAS_WIDTH;
        }
        
    public int getCANVAS_HEIGHT(){
            return this.CANVAS_HEIGHT;
    }
    
    public int getSCREEN_WIDTH(){
        return this.SCREEN_WIDTH;
    }
    
    public int getSCREEN_HEIGHT(){
        return SCREEN_HEIGHT;
    }
    
    public BufferedImage getBuffImg(){
        return img;
    }
	
    private void fire() {
    	System.out.println("Modele - appel Fire - Changement Etat envoie de notification aux observateurs - modifie");
    	setChanged();
    	notifyObservers();
    }
}

