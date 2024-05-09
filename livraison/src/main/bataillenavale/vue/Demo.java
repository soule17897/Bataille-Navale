package main.bataillenavale.vue;

import main.bataillenavale.model.Bataille;
import main.bataillenavale.model.joueur.Humain;
import main.bataillenavale.model.joueur.Joueur;
import main.bataillenavale.model.joueur.JoueurMachine;
import main.bataillenavale.model.joueur.JoueurRandom;


/**
 * La classe Demo est une classe éxécutable permettant de simuler une partie du jeux bataille navale 
 * entre un joueur humain et un joueur machine.
 * 
 * @author thiam221
 *
 */
public class Demo {
    
	/**
     *la classe Demo contient une methode main  permettant de lancer un demo du jeux. 
     * @param args
     */
	public static void main(String[] args)  {
		 
	    Joueur joueur1 = new Humain("Joueur Humain");
		Joueur joueur2 = new JoueurMachine("Joueur Machine");
		joueur1.placerNaviresAleatoires(); 
		joueur2.placerNaviresAleatoires();
		Bataille bat = new Bataille(joueur1, joueur2);
		Fenetre fen = new Fenetre(bat);
		
	}

}
