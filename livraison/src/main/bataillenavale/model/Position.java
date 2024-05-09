package main.bataillenavale.model;

import main.bataillenavale.model.navire.Direction;
import main.bataillenavale.model.navire.Navire;

import java.util.Random;

/**
 * Une classe pour représenter une position (case ou cellule) d'une grille
 * 
 * @author Jerome Dagnon & Youra Ahmed
 * */
public class Position {

	/**
	 * Le numéro de ligne de la case
	 */
	private final int x;

	/**
	 * Le numéro de colonne de la case
	 */
	private final int y;

	/**
	 * Attribut qui indique le statut touché ou non de la case
	 */
	private boolean touche;

	/**
	 * Le navire qui occupe la case
	 */
	private Navire navire;

	/**
	 * Construit une nouvelle instance de la classe Position
	 *
	 * @param x Le numéro de ligne de la case
	 * @param y Le numéro de colonne de la case
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
		this.touche = false;
		this.navire = null;
	}

	/**
	 * Récupère le numéro de ligne de la case
	 *
	 * @return le numéro de ligne de la case
	 */
	public int getX() {
		return x;
	}

	/**
	 * Récupère le numéro de colonne de la case
	 *
	 * @return le numéro de colonne de la case
	 */
	public int getY() {
		return y;
	}

	/**
	 * Vérifie si la case est touchée
	 *
	 * @return vrai si la case est touchée, faux sinon
	 */
	public boolean estTouche() {
		return touche;
	}

	/**
	 * Récupère le navire qui occupe la case
	 *
	 * @retun le navire qui occupe la case
	 */
	public Navire getNavire() {
		return navire;
	}

	/**
	 * Changer la valeur de l'attribut navire de la classe
	 *
	 * @param navire le navire qui occupe désormais la case
	 * */
	public void setNavire(Navire navire) {
		this.navire = navire;
	}

	/**
	 * Redéfinir la méthode toString() de la classe
	 *
	 * @return le nouveau caractère voulu
	 */
	@Override
	public String toString() {
		String ch = "";
		if (this.touche){
			if (this.navire != null)
				ch =  "X";
			else
				ch = "!";
		}
		else {
			if (this.navire != null)
				ch =  "0";
			else
				ch = "#";
		}
		return ch;
	}

	/**
	 * Change l'état de la position
	 *
	 * l'attribut touche passe de false à true,
	 * et si la case appartient à un navire,
	 * le nombre de case(s) touchée(s) du navire est incrémenté
	 */
	public void changeEtat() {
		this.touche = true;
		if (this.navire != null) {
			this.navire.incrementTouche();
		}
	}

	/**
	 * Génère une nouvelle position de façon pseudo-aléatoire
	 *
	 * @return une nouvelle position
	 * */
	public static Position genererAleatoire(){
		Random random = new Random();
		int x = random.nextInt(10);
		int y = random.nextInt(10);
		return new Position(x, y);
	}

	/**
	 * Récupère la position suivante selon une direction donnée
	 *
	 * @param direction la direction selon laquelle on cherche la position suivante
	 * @return la position suivante
	 * */
	public Position getPositionSuivante(Direction direction){
		if (direction == Direction.VERTICALE)
			return new Position(this.x + 1, this.y);
		return new Position(this.x, this.y + 1);
	}

    /**
	 * Vérifie si une position est valide
	 * la position doit appartenir à une grille de dimension 10*10
	 *
	 * @return vrai si la position est valide, faux sinon
	 * */
	public boolean estValide() {
		return (this.x >= 0 && this.x <= 9 && this.y >= 0 && this.y <= 9);
    }
}
