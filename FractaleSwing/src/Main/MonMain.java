/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Vue.*;
import Modele.*;
import Controleur.*;

/**
 *
 * @author gbchamoulaud
 */
public class MonMain {
    public static void main(String[] args) {
    	
    		Modele modele = new Modele(-2.1, 1, -1, 1.2);
    		Canva canva = new Canva(700, 600, modele);
    		Controleur controleur = new Controleur(modele,canva);
            Vue fenetre = new Vue("Ma fenetre",modele,controleur);
	}
}
