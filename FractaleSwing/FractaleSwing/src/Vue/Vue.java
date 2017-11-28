package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	
	private static final long serialVersionUID = 1L;
	
	private Modele modele = new Modele(-2, 1, -1.2, 1.2);
    private Controleur controleur = new Controleur(modele);
        
    public Vue (String titre, Modele modele, Controleur controleur)
    {
        super(titre);
        
        this.modele = modele;
        this.controleur = controleur;
		modele.addObserver(this);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        setBounds(200, 150, modele.getSCREEN_WIDTH(), modele.getSCREEN_HEIGHT());
        
        modele.panel1 = new JPanel();
        
        modele.zoom_Plus = new JButton("ZOOM +");
        modele.bouton2 = new JButton("Bouton 2");
        modele.label_RE_MIN = new JLabel("RE_MIN");
        modele.label_RE_MAX = new JLabel("RE_MAX");
        modele.label_IM_MIN = new JLabel("IM_MIN");
        modele.label_IM_MAX = new JLabel("IM_MAX");
        
        modele.zoom_Plus.setBackground(Color.green);
        modele.bouton2.setBackground(Color.MAGENTA);   
        
        modele.label_RE_MIN.setPreferredSize(new Dimension(150, 20));
        modele.label_RE_MIN.setBorder(BorderFactory.createLineBorder(Color.black));
        modele.label_RE_MAX.setPreferredSize(new Dimension(150, 20));
        modele.label_RE_MAX.setBorder(BorderFactory.createLineBorder(Color.black));
        modele.label_IM_MIN.setPreferredSize(new Dimension(150, 20));
        modele.label_IM_MIN.setBorder(BorderFactory.createLineBorder(Color.black));
        modele.label_IM_MAX.setPreferredSize(new Dimension(150, 20));
        modele.label_IM_MAX.setBorder(BorderFactory.createLineBorder(Color.black));
    
        add(modele.panel1,BorderLayout.WEST);
        modele.panel1.setPreferredSize(new Dimension(150, modele.getSCREEN_HEIGHT()));
        modele.panel1.setBackground(Color.GRAY);

        modele.panel1.add(modele.zoom_Plus);
        modele.panel1.add(modele.bouton2);
        modele.panel1.add(modele.label_RE_MIN);
        modele.panel1.add(modele.label_RE_MAX);
        modele.panel1.add(modele.label_IM_MIN);
        modele.panel1.add(modele.label_IM_MAX);
        
        modele.zoom_Plus.addActionListener((ActionEvent e) ->
		{System.out.println("Vue - ZOOM"); 
		controleur.zoom();});        
        
        modele.label_RE_MIN.setText( "RE MIN | " + String.valueOf(modele.getMANDELBROT_RE_MIN() ) );
        modele.label_RE_MAX.setText( "RE MAX | " + String.valueOf(modele.getMANDELBROT_RE_MAX() ) );
        modele.label_IM_MIN.setText( "IM MIN | " + String.valueOf(modele.getMANDELBROT_IM_MIN() ) );
        modele.label_IM_MAX.setText( "IM MAX | " + String.valueOf(modele.getMANDELBROT_IM_MAX() ) );        
        
        modele.img = controleur.appliquerGraphics(modele);
		paint(modele.img.getGraphics());
       
        setVisible(true);
    }

    @Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(Modele.img, modele.panel1.getWidth(), 0, null); 
	}

	@Override
    public void update(Observable o, Object arg) {
    	System.out.println("Vue - Notification Recue");
    	modele.label_RE_MIN.setText( "RE MIN | " + String.valueOf(modele.getMANDELBROT_RE_MIN() ) );
    	modele.label_RE_MAX.setText( "RE MAX | " + String.valueOf(modele.getMANDELBROT_RE_MAX() ) );
    	modele.label_IM_MIN.setText( "IM MIN | " + String.valueOf(modele.getMANDELBROT_IM_MIN() ) );
    	modele.label_IM_MAX.setText( "IM MAX | " + String.valueOf(modele.getMANDELBROT_IM_MAX() ) );
    	
    	Modele.img = controleur.appliquerGraphics(modele);
    	paint(Modele.img.getGraphics());
    }   
}
