package Main;
import Vue.*;
import Modele.*;
import Controleur.*;

public class MonMain {
    //public static Vue fenetre;
    public static void main(String[] args) {
    	
            Modele modele = new Modele(-2.1, 1, -1, 1.2);
            Controleur controleur = new Controleur(modele);
            Vue fenetre = new Vue("Ma fenetre",modele,controleur);
	}
}
