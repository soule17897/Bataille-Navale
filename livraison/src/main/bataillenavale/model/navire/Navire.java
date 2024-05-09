package main.bataillenavale.model.navire;

import main.bataillenavale.model.Position;

/**
 * Une classe pour représenter un navire
 * 
 * @author Jerome Dagnon & Youra Ahmed
 */
public class Navire {

	/**
	 * La position du début du navire
	 */
	private final Position posDebut;

	/**
	 * La direction du navire
	 */
	private final Direction direction;

	/**
	 * La taille du navire
	 */
	private final int taille;

	/**
	 * Le nombre de cases touchées
	 */
	private int nbCasesTouchees;

	/**
	 * Construit une nouvelle instance de la classe Navire
	 *
	 * @param posDebut La position du début du navire
	 * @param direction La direction du navire
	 * @param taille La taille du navire
	 */
	public Navire(Position posDebut, Direction direction, int taille) {
		this.posDebut = posDebut;
		this.direction = direction;
		this.taille = taille;
		this.nbCasesTouchees = 0;
	}


	/**
	 * Récupère la position du début du navire
	 *
	 * @return la position du debut du navire
	 */
	public Position getPosDebut() {
		return this.posDebut;
	}

	/**
	 * Récupère la direction du navire
	 *
	 * @return la direction du navire
	 */
	public Direction getDirection() {
		return this.direction;
	}

	/**
	 * Récupère la taille du navire
	 *
	 * @return la taille du navire
	 */
	public int getTaille() {
		return this.taille;
	}

	/**
	 * Récupère le nombre de cases touchées du navire
	 *
	 * @return le nombre de cases touchées
	 */
	public int getNbCasesTouchees() {
		return this.nbCasesTouchees;
	}

	/**
	 * Vérifie si le navire est coulé
	 *
	 * @return vrai si le navire est coulé, faux sinon
	 */
	public boolean estCoule() {
		return this.nbCasesTouchees == this.taille;
	}

	/**
	 * Incrémente le nombre de cases touchées
	 */
	public void incrementTouche() {
		this.nbCasesTouchees++;
	}

	/**
	 * Redéfinition de la méthode equals(Object o) de la classe
	 *
	 * @param o l'objet à comparer
	 * @return Vrai si les deux instances sont égales selon les critères définis et Faux sinon
	 */
	@Override
	public boolean equals(Object o){
		if (!(o instanceof Navire)){
			return false;
		}

		Navire newObject = (Navire) o;

		return this.posDebut.equals(newObject.posDebut) && this.direction.equals(newObject.direction) && this.taille == newObject.taille;
	}
}
