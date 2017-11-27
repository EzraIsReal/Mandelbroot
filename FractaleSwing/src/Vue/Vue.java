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
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modele.*;
import Controleur.*;

public class Vue extends JFrame implements Observer {
	
    JButton zoom_Plus;
    JButton bouton2;
    JLabel label_RE_MIN;
    JLabel label_RE_MAX;
    JLabel label_IM_MIN;
    JLabel label_IM_MAX;
    Canva c;
	
    private Modele modele = new Modele(-2, 1, -1.2, 1.2);
    private Controleur controleur = new Controleur(modele, c);
        
    public Vue (String titre, Modele modele, Controleur controleur)
    {
        super(titre);
        
        this.modele = modele;
	this.controleur = controleur;
	modele.addObserver(this);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        setBounds(200, 150, modele.getSCREEN_WIDTH(), modele.getSCREEN_HEIGHT());
        
        JPanel panel1 = new JPanel();
        
        zoom_Plus = new JButton("ZOOM +");
        bouton2 = new JButton("Bouton 2");
        label_RE_MIN = new JLabel("RE_MIN");
        label_RE_MAX = new JLabel("RE_MAX");
        label_IM_MIN = new JLabel("IM_MIN");
        label_IM_MAX = new JLabel("IM_MAX");
        c = new Canva(modele);        
        
        zoom_Plus.setBackground(Color.green);
        bouton2.setBackground(Color.MAGENTA);   
        
        label_RE_MIN.setPreferredSize(new Dimension(150, 20));
        label_RE_MIN.setBorder(BorderFactory.createLineBorder(Color.black));
        label_RE_MAX.setPreferredSize(new Dimension(150, 20));
        label_RE_MAX.setBorder(BorderFactory.createLineBorder(Color.black));
        label_IM_MIN.setPreferredSize(new Dimension(150, 20));
        label_IM_MIN.setBorder(BorderFactory.createLineBorder(Color.black));
        label_IM_MAX.setPreferredSize(new Dimension(150, 20));
        label_IM_MAX.setBorder(BorderFactory.createLineBorder(Color.black));
    
        add(panel1,BorderLayout.WEST);
        panel1.setPreferredSize(new Dimension(150, modele.getSCREEN_HEIGHT()));
        panel1.setBackground(Color.GRAY);

        panel1.add(zoom_Plus);
        panel1.add(bouton2);
        panel1.add(label_RE_MIN);
        panel1.add(label_RE_MAX);
        panel1.add(label_IM_MIN);
        panel1.add(label_IM_MAX);
        
        zoom_Plus.addActionListener((ActionEvent e) ->
		{System.out.println("Vue - ZOOM"); 
		controleur.zoom(c);});        
        
        label_RE_MIN.setText( "RE MIN | " + String.valueOf(modele.getMANDELBROT_RE_MIN() ) );
        label_RE_MAX.setText( "RE MAX | " + String.valueOf(modele.getMANDELBROT_RE_MAX() ) );
        label_IM_MIN.setText( "IM MIN | " + String.valueOf(modele.getMANDELBROT_IM_MIN() ) );
        label_IM_MAX.setText( "IM MAX | " + String.valueOf(modele.getMANDELBROT_IM_MAX() ) );        
        
        add(c);        
       
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
    	System.out.println("Vue - Notification Recue");
    	label_RE_MIN.setText( "RE MIN | " + String.valueOf(modele.getMANDELBROT_RE_MIN() ) );
        label_RE_MAX.setText( "RE MAX | " + String.valueOf(modele.getMANDELBROT_RE_MAX() ) );
        label_IM_MIN.setText( "IM MIN | " + String.valueOf(modele.getMANDELBROT_IM_MIN() ) );
        label_IM_MAX.setText( "IM MAX | " + String.valueOf(modele.getMANDELBROT_IM_MAX() ) );   
    }   
}
