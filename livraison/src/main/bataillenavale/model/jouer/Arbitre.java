package main.bataillenavale.model.jouer;

import main.bataillenavale.model.Bataille;
import main.bataillenavale.model.Position;


/**
 * Une classe pour arbitrer une bataille
 * 
 * @author Jerome Dagnon & Youra Ahmed
 * */
public class Arbitre {

    /**
     * La bataille concernée
     * */
    private Bataille bataille;

    /**
     * Construit une nouvelle instance
     *
     * @param bataille la bataille concernée
     * */
    public Arbitre(Bataille bataille){
        this.bataille = bataille;
    }

    /**
     * Dirige une partie
     * */
    public void jouer(){
        do {
            // Disposition des grilles des joueurs
            System.out.println("Grille du joueur 1 :");
            System.out.println(bataille.getJoueur1().getGrille());
            System.out.println("Grille du joueur 2 :");
            System.out.println(bataille.getJoueur2().getGrille().toStringAdverse());

            System.out.println("C'est au tour de " + bataille.getJoueurCourant());
            Position coup = bataille.getJoueurCourant().choisirCoup(this.bataille);

            // verifier si le coup est valide puis l'exécuter sinon redemander un coup
            while (!bataille.getJoueurAdverse().getGrille().estDansGrille(coup) || bataille.getJoueurAdverse().getGrille().getPosition(coup.getX(), coup.getY()).estTouche()){
                System.out.println("Coup invalide");
                coup = bataille.getJoueurCourant().choisirCoup(this.bataille);
            }

            bataille.execute(coup.getX(), coup.getY());
            System.out.println("Position : (" + coup.getX() + ", " + coup.getY() + ")");
        }while (!bataille.isOver());


        if(bataille.isOver()){
            System.out.println("============ JEU TERMINE ==============");
            System.out.println("Grille du joueur 1 :");
            System.out.println(bataille.getJoueur1().getGrille());
            System.out.println("Grille du joueur 2 :");
            System.out.println(bataille.getJoueur2().getGrille());
            System.out.println("Le gagnant est " + bataille.getJoueurGagnant());
        }
    }
}
