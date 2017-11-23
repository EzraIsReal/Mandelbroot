/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.awt.image.BufferedImage;
import java.util.Observable;


public class Modele extends Observable{
	
    public static final int CANVAS_WIDTH = 740;
    public static final int CANVAS_HEIGHT = 605;
    // Left and right border
    public static final int X_OFFSET = 25;
    // Top and Bottom border
    public static final int Y_OFFSET = 25;
    // Values for the Mandelbrot set
    public double MANDELBROT_RE_MIN = -2;   
	public double MANDELBROT_RE_MAX = 1;
    public double MANDELBROT_IM_MIN = -1.2;
    public double MANDELBROT_IM_MAX = 1.2;
    
    public static BufferedImage img;
	
	public Modele (double MANDELBROT_RE_MIN, double MANDELBROT_RE_MAX, double MANDELBROT_IN_MIN, double MANDELBROT_IN_MAX) {
		this.MANDELBROT_RE_MIN = MANDELBROT_RE_MIN ;
		this.MANDELBROT_RE_MAX = MANDELBROT_RE_MAX ;
		this.MANDELBROT_IM_MIN = MANDELBROT_IN_MIN ;
		this.MANDELBROT_IM_MAX = MANDELBROT_IN_MAX ;			
	}  
	
    public double getMANDELBROT_RE_MIN() {
		return MANDELBROT_RE_MIN;
	}

	public void setMANDELBROT_RE_MIN(double mANDELBROT_RE_MIN) {
		System.out.println("Modele - Changement Etat - RE_MIN Modifie");
		MANDELBROT_RE_MIN = mANDELBROT_RE_MIN;
		fire();
	}

	public double getMANDELBROT_RE_MAX() {
		return MANDELBROT_RE_MAX;
	}

	public void setMANDELBROT_RE_MAX(double mANDELBROT_RE_MAX) {
		System.out.println("Modele - Changement Etat - RE_MAX Modifie");
		MANDELBROT_RE_MAX = mANDELBROT_RE_MAX;
		fire();
	}

	public double getMANDELBROT_IM_MIN() {
		return MANDELBROT_IM_MIN;
	}

	public void setMANDELBROT_IM_MIN(double mANDELBROT_IM_MIN) {
		System.out.println("Modele - Changement Etat - IM_MIN Modifie");
		MANDELBROT_IM_MIN = mANDELBROT_IM_MIN;
		fire();
	}

	public double getMANDELBROT_IM_MAX() {
		return MANDELBROT_IM_MAX;
	}

	public void setMANDELBROT_IM_MAX(double mANDELBROT_IM_MAX) {
		System.out.println("Modele - Changement Etat - IM_MAX Modifie");
		MANDELBROT_IM_MAX = mANDELBROT_IM_MAX;
		fire();
	}
	
	private void fire() {
		System.out.println("Modele - appel Fire - Changement Etat envoie de notification aux observateurs - modifie");
		setChanged();
		notifyObservers();
	}
}

