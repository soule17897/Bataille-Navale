package main.bataillenavale.model.joueur;

import main.bataillenavale.model.Bataille;
import main.bataillenavale.model.Grille;
import main.bataillenavale.model.Position;
import main.bataillenavale.model.navire.Navire;

import java.util.*;

/**
 * Une classe pour représenter un joueur machine intelligent
 * 
 * @author Jerome Dagnon & Youra Ahmed
 */
public class JoueurMachine extends Joueur {

    /**
     * Liste des positions appartenant à un navire qui ont déjà été touchées
     * */
    private List<Position> naviresPositionsTouches;

    /**
     * Liste des coups valides
     * */
    private List<Position> coupsValides;

    /**
     * Construit une nouvelle instance <br>
     *
     * Pour la version jouable ligne de commande
     * */
    public JoueurMachine(){
        super("");
        this.naviresPositionsTouches = new ArrayList<Position>();
        this.coupsValides = new ArrayList<Position>();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Grille g = this.getGrille();
                if (!(g.getGrille()[i][j].estTouche())){
                    coupsValides.add(new Position(i, j));
                }
            }
        }
    }
    
    /**
     * Construit une nouvelle instance <br>
     *
     * Pour la version avec l'interface graphique
     *
     * @param nom le nom du joueur
     * */
    public JoueurMachine(String nom){
        super(nom);
        this.naviresPositionsTouches = new ArrayList<Position>();
        this.coupsValides = new ArrayList<Position>();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Grille g = this.getGrille();
                if (!(g.getGrille()[i][j].estTouche())){
                    coupsValides.add(new Position(i, j));
                }
            }
        }
    }
    
    /**
     * Vérifie si un coup a touché un navire
     *
     * @param bataille la bataille concernée
     * @param coup le coup tiré
     * @return vrai si le coup a touché un navire, faux sinon
     * */
    public boolean navireTouche(Bataille bataille, Position coup){
        if (coup.estValide()){
            if(bataille.getJoueurAdverse().getGrille().getEmplacementsOccupes()[coup.getX()][coup.getY()]){
                return true;
            }
        }
        return false;
    }


    /**
     * Choisit la position au niveau de la grille de l'adversaire sur laquelle tirer
     *
     * @param bataille la bataille à laquelle le joueur participe
     * @return la position choisie
     * */
    @Override
    public Position choisirCoup(Bataille bataille) {
        Position coupChoisi;
        do {
            // Si un bateau a déjà été touché, mais pas encore coulé
            if(naviresPositionsTouches.size() > 0) {
                //verifier si le navire n'as pas deja ete touche
                coupChoisi = tirerAdjacent(bataille);
            } else {
                coupChoisi = Position.genererAleatoire();
            }
        }while (bataille.getJoueurAdverse().getGrille().getGrille()[coupChoisi.getX()][coupChoisi.getY()].estTouche());

        miseAJourListePositionsNaviresTouches(bataille, coupChoisi);
        coupsValides.remove(coupChoisi);

        return coupChoisi;
    }

    /**
     * Effectue un tir intelligent par rapport à la dernière position quand elle a touché un navire
     *
     * @param bataille la bataille concernée
     * @return la position où tirer
     * */
    public Position tirerAdjacent(Bataille bataille){
        // On récupère la dernière position touchée
        Position dernierCoup = naviresPositionsTouches.get(naviresPositionsTouches.size() - 1);
        // On récupère les positions adjacentes à la dernière position touchée
        List<Position> adjacents = positionsAdjacentes(bataille, dernierCoup);
        // On choisit une position aléatoire parmi les positions adjacentes
        if (adjacents.size() > 0){
            Random random = new Random();
            int nbr = random.nextInt(adjacents.size());
            return adjacents.get(nbr);
        }

        return Position.genererAleatoire();
    }

    /**
     * Mets à jour la liste des positions touchées appartenant à un navire
     *
     * @param bataille la bataille concernée
     * @param coup le coup tiré
     * */
    public void miseAJourListePositionsNaviresTouches(Bataille bataille, Position coup){
        // si le coup touche un navire, l'ajouter à la liste des positions touchées appartenant à un navire
        if (navireTouche(bataille, coup)){
            this.naviresPositionsTouches.add(coup);
        }
    }

    /**
     * Trouve toutes les positions non encore touchées et adjacentes à une position donnée
     *
     * @param bataille la bataille concernée
     * @param position la position dont on cherche les positions adjacentes
     * @return la liste des positions adjacentes
     * **/
    public List<Position> positionsAdjacentes(Bataille bataille, Position position){
        List<Position> res = new ArrayList<Position>();

        // si position.x (numéro de ligne) different de 0,
        if (position.getX() != 0){
            Position enHaut = new Position(position.getX() - 1, position.getY());
            if (!bataille.getJoueurAdverse().getGrille().getGrille()[enHaut.getX()][enHaut.getY()].estTouche()){
                res.add(enHaut);
            }
        }

        // si position.x (numéro de ligne) different de 10,
        if (position.getX() != 9){
            Position enBas = new Position(position.getX() + 1, position.getY());
            if (!bataille.getJoueurAdverse().getGrille().getGrille()[enBas.getX()][enBas.getY()].estTouche()){
                res.add(enBas);
            }
        }

        // si position.y (numéro de colonne) different de 0,
        if (position.getY() != 0){
            Position aGauche = new Position(position.getX(), position.getY() - 1);
            if (!bataille.getJoueurAdverse().getGrille().getGrille()[aGauche.getX()][aGauche.getY()].estTouche()){
                res.add(aGauche);
            }
        }

        // si position.y (numéro de colonne) different de 10,
        if (position.getY() != 9){
            Position aDroite = new Position(position.getX(), position.getY() + 1);
            if (!bataille.getJoueurAdverse().getGrille().getGrille()[aDroite.getX()][aDroite.getY()].estTouche()){
                res.add(aDroite);
            }
        }

        return res;
    }





    /**
     * Redéfinition de la méthode toString() de la classe
     *
     * @return une chaîne de caractères
     */
    @Override
    public String toString(){
        return "Joueur Machine n° " + this.hashCode();
    }
}
