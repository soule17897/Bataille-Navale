package main.bataillenavale.vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import main.bataillenavale.model.Bataille;
import main.bataillenavale.model.Position;
import main.bataillenavale.model.joueur.Joueur;
import main.bataillenavale.observer.Observateur;


/**
 * cette classe represente une cellule qui n'est d'autres qu'un JButton 
 * @author thiam221
 *
 */
public class Cellule  extends JButton implements ActionListener{
   
	/**
	 * c'est  la position sur une ligne 
	 */
	private int x;
	/**
	 * c'est la position sur une colonne 
	 */
	private int y;
	
	/**  elle permet de simuler  une bataille entre deux joueur */
	
	private Bataille bataille;

	/**
	 * constructeur de la classe Cellule permetant de creer une nouvelle Cellule(position). 
	 * 
	 * @param x c'est  la position sur une ligne
	 * @param y c'est  la position sur une colonne
	 * @param b elle permet de simuler  une bataille entre deux joueur 
	 */
	public Cellule(int x , int y, Bataille b ) {

		super();
		this.x= x;
		this.y= y;
		this.bataille = b;

		this.setBackground(Color.WHITE);
		this.addActionListener(this);

	}
    
	/**
	 * cette une methode permettant de realiser une actions lors d'un clique sur un bouton. 
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
     
		
		this.bataille.execute(x,y);// tir du joueur humain sur la position(x,y) 
		
		Position coupJ2  = bataille.getJoueurCourant().choisirCoup(bataille); // choix du coup pour le joueur machine 
		
		this.bataille.execute(coupJ2.getX(),coupJ2.getY()); //  le joueur machine tire sur la grille du joueur humain 
		
		this.setEnabled(false); 
	}


}
