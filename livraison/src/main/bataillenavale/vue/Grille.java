package main.bataillenavale.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.bataillenavale.model.Bataille;
import main.bataillenavale.model.joueur.Joueur;
import main.bataillenavale.observer.Observateur;



/**
 * cette classe represente la grille d'un joueur de taille 10x10
 * une  grille contient un  ensemble de cellule  qui peuvent etre occupe par un navire ou pas,
 * pour le joueur humain cette cellule  est cliquable par contre pour le joueur machine cette derniére  ne l'est pas !   
 * @author thiam221
 *
 */
public class Grille extends JPanel implements Observateur{

   /** le nombre de ligne de la grille  */	
	private final int LIGNES = 10;
	/** le nombre de colonne de la grille   */
	private final int COLONNES  = 10;
	/** la taille d'une case  */
	private final int TAILLE_CELLULE = 40;	
	/** un tableau a deux dimensions de cellule qui forme une grille   */
	private Cellule   cells[][] = new Cellule[10][10];
	/** cest le containeur principale qui va englober tous les sous containeurs  */
	private JPanel grilles = new JPanel();
	/**  represente le panel au dessus de la grille contenant de lettres alphabetiques */
	private JPanel labelHaut = new JPanel();
	/**  represente le panel en dessous de la grille contenant des chiffres  */
	private JPanel labelgauche = new JPanel();
	/**  c'est le joueur a qui appartient la grille  */
	private Joueur joueur;
	/**  elle permet de simuler  une bataille entre deux joueur */
	private Bataille bataille;
    
	
    /** 
     * Un constructeur de la classe Grille perméttant de créer une nouvelle Grille
     * 	
     * @param joueur   le joueur a qui appartient la grille
     * @param bataille une instance de bataille pour simuler une partie   
     */
	public Grille(Joueur joueur,Bataille bataille ) {
		this.joueur=joueur;
		this.bataille=bataille;
		this.bataille.addObsever(this);
		this.setLayout(new BorderLayout());
		this.grilles.setLayout(new GridLayout(LIGNES,COLONNES));

		this.labelHaut.setLayout(new GridLayout(1,10,30,30));
		this.labelgauche.setLayout(new GridLayout(10,1,30,30));

		for(char alphabet = 'A'; alphabet <=  'J'; alphabet++) {
			labelHaut.add(new JLabel("   "+ String.valueOf(alphabet)));
		}

		for(int i=1; i<= 10 ; i++) {
			labelgauche.add(new JLabel("   "+String.valueOf(i)));
		}


		for (int i = 0; i < LIGNES; i++) {
			for (int j = 0; j < COLONNES ; j++) {
				this.cells[i][j] = new Cellule(i,j,bataille);
				this.grilles.add(cells[i][j]); 
			}
		}

		this.add(labelgauche, BorderLayout.WEST);
		this.add(labelHaut, BorderLayout.NORTH);
		this.add(grilles, BorderLayout.CENTER);
		grilles.setPreferredSize(new Dimension(COLONNES  * TAILLE_CELLULE, LIGNES  * TAILLE_CELLULE ));
		this.setPreferredSize(new Dimension(500,500));

	}

	/**
	 * cette une methode de type void qui n'a aucun type de retour
	 * qui permet de définir l'état de la grille cliquable ou pas en 
	 * faisant appel a a la methode setEnabled        
	 * @param état qui peut valoire true ou false 
	 */
	public void setCLickable( boolean etat) {


		for (int i = 0; i < LIGNES; i++) {
			for (int j = 0; j < COLONNES ; j++) {
				cells[i][j].setEnabled(etat);
			}
		}			
	}

/**
 * cette une methode de type void 
 * elle permet de mettre a jour l'etat de la grille  
 * 
 * si une case est touche et qu'elle est déja occupé par un navire on la colorie en rouge 
 * si une case est touche et qu'elle n'est occupé par un navire on la colorie en vert 
 * si un navire est coulé un colorie toutes ses cases en bleus 
 * 
 */
	
	@Override
	public void update(Object o) {
	
       
		for (int i = 0; i < LIGNES; i++) {
			for (int j = 0; j < COLONNES ; j++) {
				if(this.joueur.getGrille().getGrille()[i][j].estTouche()) {
					if(this.joueur.getGrille().getGrille()[i][j].getNavire()!= null) {
						this.cells[i][j].setBackground(Color.red);
						if(this.joueur.getGrille().getGrille()[i][j].getNavire().estCoule())
							this.cells[i][j].setBackground(new Color(0,51,51));
					}
					else
						this.cells[i][j].setBackground(Color.green);
				}

			}
		}
		
		if(bataille.isOver()) {
			this.setCLickable(false);
			
			JOptionPane jop = new JOptionPane();
			JOptionPane.showMessageDialog(null, bataille.getJoueurGagnant().toString() + " a gagné", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}





}
