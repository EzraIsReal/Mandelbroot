package Controleur;
import java.awt.Graphics2D;

import Modele.*;
import Vue.*;

public class Controleur {

	private Modele m = new Modele(-2,1,-1.2,1.2);
	private Canva canva = new Canva(700, 600, m);
	public Graphics2D g;
	
	public Controleur(Modele modele, Canva c)
	{
		this.m = modele;
		this.canva =c;
	}
	
	//SETTERS
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
	
	//ZOOM
	public void zoom () {
		m.setMANDELBROT_RE_MIN( m.getMANDELBROT_RE_MIN()-100 );
		m.setMANDELBROT_RE_MAX( m.getMANDELBROT_RE_MAX()-100 );
		m.setMANDELBROT_IM_MIN( m.getMANDELBROT_IM_MIN()-100 );
		m.setMANDELBROT_IM_MAX( m.getMANDELBROT_IM_MAX()-100 );
		
		canva.dessiner(m.getMANDELBROT_RE_MIN(), m.getMANDELBROT_RE_MAX(), m.getMANDELBROT_IM_MIN(), m.getMANDELBROT_IM_MAX(), canva.getWidth(), canva.getHeight());
		canva.paintComponent(g);

	}
}
