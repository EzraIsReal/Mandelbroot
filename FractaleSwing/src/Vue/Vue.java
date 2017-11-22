/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Vue extends JFrame implements Observer {
    
    private int WIDTH = 1080;
    private int HEIGHT = 720;
    
    public Vue (String titre)
    {
        super(titre);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
	setBounds(200,150,WIDTH,HEIGHT);
        
	JPanel panel1 = new JPanel();
        
        JButton bouton1 = new JButton("Bouton 1");
        JButton bouton2 = new JButton("Bouton 2");
        Canva c = new Canva(700,600);        
        
        bouton1.setBackground(Color.green);
        bouton2.setBackground(Color.MAGENTA);           
    
        add(panel1,BorderLayout.WEST);
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));        
        panel1.add(bouton1);
        panel1.add(bouton2);
        
        add(c);        
       
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}
