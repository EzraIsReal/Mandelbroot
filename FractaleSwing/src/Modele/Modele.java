/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.awt.image.BufferedImage;

/**
 *
 * @author gbchamoulaud
 */
public class Modele {
    
     // Size of the canvas for the Mandelbrot set
    public static final int CANVAS_WIDTH = 740;
    public static final int CANVAS_HEIGHT = 605;
    // Left and right border
    public static final int X_OFFSET = 25;
    // Top and Bottom border
    public static final int Y_OFFSET = 25;
    // Values for the Mandelbro set
    public static double MANDELBROT_RE_MIN = -2;
    public static double MANDELBROT_RE_MAX = 1;
    public static double MANDELBROT_IM_MIN = -1.2;
    public static double MANDELBROT_IM_MAX = 1.2;
    
    public static BufferedImage img;
}
