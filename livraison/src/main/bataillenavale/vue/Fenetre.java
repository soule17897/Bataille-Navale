package main.bataillenavale.vue;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.bataillenavale.model.Bataille;
import main.bataillenavale.model.Position;
import main.bataillenavale.model.joueur.Humain;
import main.bataillenavale.model.joueur.Joueur;
import main.bataillenavale.model.joueur.JoueurMachine;

/**
 * Une classe fenetre est une classe heritant de JFrame  
 * permentant de  visualiser une partie du jeux bataille navale! 
 * elle contient deux grille celle de gauche est celui du joueur humain 
 * et a droite celui du joueur machine 
 * @author thiam221
 *
 */

public class Fenetre  extends JFrame {

    /**  Grille du joueur2   */
	
	private Grille grilleJoueur2;
	
	/**  Grille du joueur1 */    
     
	 private Grille grilleJoueur1; 
	 
	/** le containeur principale contenant les deux grilles   */
    
	private JPanel container = new JPanel();
	
	/**  elle permet de simuler  une bataille entre deux joueur */
	
	private Bataille bataille;	
   
	/**
	 * 
	 * constructeur de la classe Fenetre permettant de creer un plateau de jeu 
	 * et de jouer une partie ! 
	 * 
	 * @param bataille 
	 */
	public Fenetre(Bataille bataille) {
		this.bataille= bataille;
		this.grilleJoueur2= new Grille(this.bataille.getJoueur2(),this.bataille);
		this.grilleJoueur1= new Grille(this.bataille.getJoueur1(),this.bataille);
		this.grilleJoueur1.setCLickable(false);
		this.setTitle("Bataille Navale ");
		this.setSize(1200,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		container.add(grilleJoueur2);
		container.add(grilleJoueur1);
		
		this.setContentPane(container);
		this.setVisible(true);
	}


}
