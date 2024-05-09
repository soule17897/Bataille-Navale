package main.bataillenavale.model.joueur;

import main.bataillenavale.model.Bataille;
import main.bataillenavale.model.Grille;
import main.bataillenavale.model.Position;

/**
 * Une classe pour représenter un joueur machine qui tire de façon aléatoire
 * 
 * @author Jerome Dagnon & Youra Ahmed
 * */
public class JoueurRandom extends Joueur{

    /**
     * Construit une nouvelle instance <br>
     *
     * Pour la version jouable ligne de commande
     * */
    public JoueurRandom(){
        super("");
    }

    /**
     * Construit une nouvelle instance <br>
     *
     * Pour la version avec l'interface graphique
     *
     * @param nom le nom du joueur
     * */
    public JoueurRandom(String nom) {
		super(nom);
	}

    /**
     * Choisit la position au niveau de la grille de l'adversaire sur laquelle tirer
     *
     * @param bataille la bataille à laquelle le joueur participe
     * @return la position choisie
     * */
    @Override
    public Position choisirCoup(Bataille bataille) {
        Position coup = Position.genererAleatoire();
        while (bataille.getJoueurAdverse().getGrille().getGrille()[coup.getX()][coup.getY()].estTouche()){
            coup = Position.genererAleatoire();
        }
        return coup;
    }

    /**
     * Redéfinition de la méthode toString() de la classe
     *
     * @return une chaîne de caractères
     */
    @Override
    public String toString(){
        return "Joueur Random n° " + this.hashCode();
    }
}
