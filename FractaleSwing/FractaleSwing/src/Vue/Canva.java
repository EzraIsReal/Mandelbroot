//package Vue;
//import Modele.*;
//import Controleur.*;
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Rectangle;
//import java.awt.TexturePaint;
//import java.awt.image.BufferedImage;
//import javax.swing.JPanel;
//
//public class Canva extends JPanel {        
//   
//    public Canva (Controleur c)
//    {       
//    	super();
//    	c.m.img = c.dessiner(c.m.getMANDELBROT_RE_MIN(), c.m.getMANDELBROT_RE_MAX(),
//    							c.m.getMANDELBROT_IM_MIN(), c.m.getMANDELBROT_IM_MAX(),
//    								c.m.getCANVAS_WIDTH(), c.m.getCANVAS_HEIGHT() );
//    }
//    
//    public void paintComponent (Graphics g)
//    {
//        super.paintComponent(g);
//        g.drawImage(Modele.img, 0, 0, null);
//    }     
//}
