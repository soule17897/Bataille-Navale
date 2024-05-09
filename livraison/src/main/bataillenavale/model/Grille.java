package main.bataillenavale.model;

import main.bataillenavale.model.navire.Direction;
import main.bataillenavale.model.navire.Navire;

/**
 * Une classe pour représenter une grille de jeu
 * 
 * @author Jerome Dagnon & Youra Ahmed
 */
public class Grille {
	/**
	 * Le tableau à 2 dimensions de positions de la grille
	 */
	private Position[][] grille;

	/**
	 * Matrice des emplacements déjà occupés
	 * */
	private boolean[][] emplacementsOccupes;


	/**
	 * Construit une nouvelle instance de la classe Grille
	 */
	public Grille() {
		this.grille = new Position[10][10];
		this.emplacementsOccupes = new boolean[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				this.grille[i][j] = new Position(i, j);
				this.emplacementsOccupes[i][j] = false;
			}
		}
	}

	/**
	 * Récupère le tableau à 2 dimensions de positions de la grille
	 *
	 * @return la grille
	 */
	public Position[][] getGrille() {
		return this.grille;
	}

	/**
	 * Récupérer une position donnée
	 *
	 * @param x le numéro de ligne de la case
	 * @param y le numéro de colonne de la case
	 * @return la position recherchée
	 */
	public Position getPosition(int x, int y) {
		return this.grille[x][y];
	}

	/**
	 * Vérifie si une case est dans la grille
	 *
	 * @param pos position de la case
	 * @return vrai si la case est dans la grille, faux sinon
	 */
	public boolean estDansGrille(Position pos) {
		return this.estDansGrille(pos.getX(), pos.getY());
	}

	/**
	 * Vérifie si une case est dans la grille
	 *
	 * @param x coordonnée x de la case
	 * @param y coordonnée y de la case
	 * @return vrai si la case est dans la grille, faux sinon
	 */
	public boolean estDansGrille(int x, int y) {
		return (x >= 0 && x < 10 && y >= 0 && y < 10);
	}

	/**
	 * Récupérer la matrice des emplacements déjà occupés
	 *
	 * @return la matrice des emplacements déjà occupés
	 * */
	public boolean[][] getEmplacementsOccupes() {
		return emplacementsOccupes;
	}

	/**
	 * Redéfinir la méthode toString() de la classe
	 *
	 * @return l'affichage de la grille
	 */
	@Override
	public String toString() {
		int format = String.valueOf(10).length();
		String ch = String.format("%" + format + "s", " ");
		for (int i = 0; i < 10; i++) {
			//afficher les indices des colonnes en lettres
			ch += String.format("%" + format + "s", (char) (i + 65));
			//ch += String.format("%" + format + "s", i);
		}
		ch += "\n";
		for (int i = 0; i < 10; i++) {
			ch += String.format("%" + format + "s", i);
			for (int j = 0; j < 10; j++) {
				ch += String.format("%" + format + "s", this.grille[i][j]);
			}
			ch += "\n";
		}
		return ch;
	}

	/**
	 * Afficher la grille de l'adversaire de sorte à ne pas voir l'emplacement de ses navires
	 *
	 * @return l'affichage de la grille
	 */
	public String toStringAdverse() {
		int format = String.valueOf(10).length();
		String ch = String.format("%" + format + "s", " ");
		for (int i = 0; i < 10; i++) {
			ch += String.format("%" + format + "s", (char) (i + 65));
		}
		ch += "\n";
		for (int i = 0; i < 10; i++) {
			ch += String.format("%" + format + "s", i);
			for (int j = 0; j < 10; j++) {
				Position pos = new Position(i, j);
				if (this.getPosition(pos.getX(), pos.getY()).getNavire() != null) {
					if (this.getPosition(pos.getX(), pos.getY()).estTouche()) {
						ch += String.format("%" + format + "s", "X");
					} else {
						ch += String.format("%" + format + "s", "#");
					}
				} else {
					ch += String.format("%" + format + "s", this.grille[i][j]);
				}
			}
			ch += "\n";
		}
		return ch;
	}

	/**
	 * Vérifie si un navire peut être placé sur la grille
	 *
	 * @param navire le navire à placer
	 * @param position la position de début du navire
	 * @param direction la direction du navire
	 *
	 * @return vrai si le navire peut être placé, faux sinon
	 * */
	public boolean peutPlacer(Navire navire, Position position, Direction direction){
		// Vérifie si la position est bien dans la grille et n'est pas encore touchée
		if (!this.estDansGrille(position) || this.emplacementsOccupes[position.getX()][position.getY()])
			return false;

		// Vérifie si le navire croise un autre navire ou déborde la grille
		Position positionTmp = new Position(position.getX(), position.getY());
		for (int i = 0; i < navire.getTaille() - 1; i++) {
			Position positionCase = positionTmp.getPositionSuivante(direction);
			if (!this.estDansGrille(positionCase))
				return false;
			if (emplacementsOccupes[positionCase.getX()][positionCase.getY()]) {
				return false;
			}
			positionTmp = positionTmp.getPositionSuivante(direction);
		}

		return true;
	}

	/**
	 * Place un navire sur la grille
	 *
	 * @param navire le navire à placer
	 */
	public void placerNavire(Navire navire) {
		if (navire.getDirection() == Direction.VERTICALE){
			for (int i = 0; i < navire.getTaille(); i++){
				// un seul sens : du haut vers le bas
				this.getPosition(navire.getPosDebut().getX()+ i, navire.getPosDebut().getY()).setNavire(navire);
				this.emplacementsOccupes[navire.getPosDebut().getX()+ i][navire.getPosDebut().getY()] = true;
			}
		}

		if (navire.getDirection() == Direction.HORIZONTALE){
			for (int i = 0; i < navire.getTaille(); i++){
				// un seul sens : de la gauche vers la droite
				this.getPosition(navire.getPosDebut().getX(), navire.getPosDebut().getY() + i).setNavire(navire);
				this.emplacementsOccupes[navire.getPosDebut().getX()][navire.getPosDebut().getY() + i] = true;
			}
		}
	}
}
