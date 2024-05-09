package main.bataillenavale.model;

import main.bataillenavale.model.joueur.Joueur;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Une classe pour représenter une partie entre 2 joueurs
 * 
 * @author Jerome Dagnon & Youra Ahmed
 * */
public class Bataille  extends AbstractModel{
    /**
     * Le premier joueur
     */
    private Joueur joueur1;

    /**
     * Le second joueur
     */
    private Joueur joueur2;

    /**
     * Le joueur courant
     */
    private Joueur joueurCourant;

    /**
     * Construit une nouvelle instance
     * 
     * On initialise le joueur courant en lui attribuant la valeur du premier joueur
     * 
     * @param joueur1 le premier joueur
     * @param joueur2 le second joueur
     */
    public Bataille(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.joueurCourant = joueur1;
    }

    /**
     * Récupère le premier joueur
     * 
     * @return le premier joueur
     */
    public Joueur getJoueur1() {
        return this.joueur1;
    }

    /**
     * Récupère le second joueur
     * 
     * @return le second joueur
     */
    public Joueur getJoueur2() {
        return this.joueur2;
    }

    /**
     * Récupère le joueur courant
     * 
     * @return le joueur courant
     */
    public Joueur getJoueurCourant() {
        return this.joueurCourant;
    }

    /**
     * Change le joueur courant
     */
    public void changeJoueurCourant() {
        if (this.joueurCourant == this.joueur1) {
            this.joueurCourant = this.joueur2;
        } else {
            this.joueurCourant = this.joueur1;
        }

    }
    /**
     * Récupère le joueur adverse
     * 
     * @return le joueur adverse
     */
    public Joueur getJoueurAdverse() {
        if (this.joueurCourant == this.joueur1) {
            return this.joueur2;
        } else {
            return this.joueur1;
        }
    }

    /**
     * Vérifie si la partie est terminée
     * 
     * @return vrai si la partie est terminée, faux sinon
     */
    public boolean isOver() {
        //le jeu est fini si tous les navires du joueurCourant ont été coulés
        return this.joueurCourant.isDead();
    }

    /**
     * Récupérer le vainqueur
     * 
     * @return le joueur gagnant
     */
    public Joueur getJoueurGagnant() {
        if (this.joueur1.isDead()) {
            return this.joueur2;
        } else {
            return this.joueur1;
        }
    }

    /**
     * Exécute un coup <br>
     * Effectuer un tir sur la grille du joueur adverse
     * 
     * @param x le numéro de ligne du coup
     * @param y le numéro de colonne du coup
     */
    public void execute(int x , int y) {
        //récupérer la grille du joueur adverse
        Grille grilleAdverse = this.getJoueurAdverse().getGrille();
        //récupérer la position du coup du joueur courant
        if (grilleAdverse.estDansGrille(x, y)){
            Position pos = grilleAdverse.getPosition(x, y);
            //vérifie si la position n'est pas touchée
            if (!pos.estTouche()) {
                //ajouter la position choisie sur la grille du joueur adverse
                pos.changeEtat();
                // verifier si la position touchée appartient à un navire
                
                if (pos.getNavire() != null){
                    // si oui, verifier si le navire est coulé
                    if (pos.getNavire().estCoule()){
                        // incrementer le nombre de navires coulés
                        this.getJoueurAdverse().incrementerNaviresCoules();
                    }
                }
                notifyObserver();
                this.joueurCourant.incrementerListeCoupsTires(pos);
                
                this.changeJoueurCourant();
                
            }
        }
    }

    /**
     * Redéfinition de la méthode equals(Object o) de la classe
     *
     * @param o l'objet à comparer
     * @return Vrai si les deux instances sont égales selon les critères définis et Faux sinon
     */
    @Override
    public boolean equals(Object o){
        if (!(o instanceof Bataille)){
            return false;
        }

        Bataille newObject = (Bataille) o;

        return Arrays.deepEquals(this.getJoueurCourant().getGrille().getGrille(), newObject.getJoueurCourant().getGrille().getGrille()) && this.joueurCourant.equals(newObject.joueurCourant);
    }
}
