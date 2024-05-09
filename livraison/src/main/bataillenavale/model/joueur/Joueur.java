package main.bataillenavale.model.joueur;

import main.bataillenavale.model.Bataille;
import main.bataillenavale.model.Grille;
import main.bataillenavale.model.Position;
import main.bataillenavale.model.navire.Direction;
import main.bataillenavale.model.navire.Navire;

import java.util.ArrayList;
import java.util.List;

/**
 * Une classe pour représenter un joueur
 * 
 * @author Jerome Dagnon & Youra Ahmed
 * */
public abstract class Joueur {

	/**
	 * Nom du joueur
	 */
	private final String nom;

	/**
	 * Nombre de navires du joueur ayant été coulés
	 */
	private int nbrNaviresCoules;

	/**
	 * Nombre total de navires du joueur
	 */
	private final int nbrTotalNavires = 5;

	/**
	 * Liste des navires du joueur
	 * */
	private List<Navire> navires;

	/**
	 * Liste des coups tirés par le joueur
	 * */
	private ArrayList<Position> coupsTires;

	/**
	 * Grille du joueur
	 */
	private Grille grille;


	/**
	 * Constructeur
	 *
	 * @param nom le nom du joueur
	 */
	public Joueur(String nom) {
		this.nom = nom;
		this.grille = new Grille();
		this.nbrNaviresCoules = 0;
		this.navires = new ArrayList<Navire>();
		this.coupsTires = new ArrayList<Position>();
	}
	
	/**
	 * Place les navires du joueur de façon aléatoire sur sa grille <br>
	 * Nombre de navires fixé à 5 dans notre cas avec des tailles prédéfinies : <br>
	 * <ul>
	 * 	<li>1 navire de taille 5 (un porte-avion)</li>
	 * 	<li>1 navire de taille 4 (un croiseur)</li>
	 * 	<li>2 navires de taille 3 (un contre-torpilleur et un sous-marin)</li>
	 * 	<li>1 navire de taille 2 (un torpilleur)</li>
	 * </ul>
	 *  
	 * */
	public void placerNaviresAleatoires(){
		// tableau trié dans l'ordre décroissant pour simplifier le placement
		int[] tableauTailles = {5, 4, 3, 3, 2};

		for (int i = 0; i < 5; i++){
			boolean estPlace = false;

			while (!estPlace){
				// générer aléatoirement une position et une direction
				Position position = Position.genererAleatoire();
				Direction direction = Direction.genererAleatoire();

				// créer un navire avec les précédents paramètres
				Navire navire = new Navire(position, direction, tableauTailles[i]);

				if (this.grille.peutPlacer(navire, position, direction)){
					this.grille.placerNavire(navire);
					this.navires.add(navire);
					estPlace = true;
				}
			}
		}
	}



	/**
	 * Récupère le nom du joueur
	 *
	 * @return le nom du joueur
	 * */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Récupère la liste des navires
	 *
	 * @return la liste des navires
	 * */
	public List<Navire> getNavires() {
		return navires;
	}

	/**
	 * Incrémente la liste des coups tirés par le joueur
	 *
	 * @param coup le coup tiré qui doit être ajouté à la liste
	 * */
	public void incrementerListeCoupsTires(Position coup){
		this.coupsTires.add(coup);
	}

	public ArrayList<Position> getCoupsTires() {
		return coupsTires;
	}

	/**
	 * Incrémente le nombre de navires coulés
	 * */
	public void incrementerNaviresCoules() {
		this.nbrNaviresCoules++;
	}

	/**
	 * Vérifie si un joueur est mort <br>
	 * Un joueur est mort quand tous ses navires ont été coulés
	 */
	public boolean isDead(){
		return this.nbrNaviresCoules == this.nbrTotalNavires;
	}

	/**
	 * Récupère le nombre de navires coulés
	 * 
	 * @return le nombre de navires coulés
	 */
	public int getNbrNaviresCoules() {
		return nbrNaviresCoules;
	}

	/**
	 * Récupère la grille du joueur
	 *
	 * @return la grille du joueur
	 * */
	public Grille getGrille() {
		return this.grille;
	}

	public void setGrille(Grille grille) {
		this.grille = grille;
	}

	/**
	 * Choisit la position au niveau de la grille de l'adversaire sur laquelle tirer
	 *
	 * @param bataille la bataille à laquelle le joueur participe
	 * */
	public abstract Position choisirCoup(Bataille bataille);
    
}