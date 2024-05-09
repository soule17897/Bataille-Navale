package main.bataillenavale.core;
import main.bataillenavale.model.*;

import java.util.Scanner;

import main.bataillenavale.model.jouer.Arbitre;
import main.bataillenavale.model.joueur.Humain;
import main.bataillenavale.model.joueur.Joueur;
import main.bataillenavale.model.joueur.JoueurMachine;
import main.bataillenavale.model.joueur.JoueurRandom;

/**
 * Une classe exécutable pour simuler le  déroulement d'une partie en ligne de commande
 * */
public class Demo {

	/**
	 * Lance la démo
	 *
	 * @param args ignored
	 * */
	public static void main(String[] args) {
		Scanner scan1 = new Scanner(System.in);

		// Instanciation des joueurs
		Joueur joueur1 = new Humain("Aux", scan1);
		Joueur joueur2 = new JoueurMachine();

		// Placement des navires sur les grilles des joueurs
		joueur1.placerNaviresAleatoires();
		joueur2.placerNaviresAleatoires();

		Bataille bataille = new Bataille(joueur1, joueur2);
		Arbitre arbitre = new Arbitre(bataille);
		arbitre.jouer();
	}

}
