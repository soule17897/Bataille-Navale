package main.bataillenavale.model.joueur;

import main.bataillenavale.model.Bataille;
import main.bataillenavale.model.Grille;
import main.bataillenavale.model.Position;

import java.util.Scanner;

/**
 * Une classe pour représenter un joueur humain
 * 
 * @author Jerome Dagnon & Youra Ahmed
 */

public class Humain extends Joueur {

    /** Instance de la classe java.util.Scanner */
    Scanner scan;

    /**
     * Construit une nouvelle instance <br>
     *
     * Pour la version jouable ligne de commande
     *
     * @param nom le nom du joueur
     * @param scan l'instance de la classe java.util.Scanner
     * */
    public Humain(String nom, Scanner scan){
        super(nom);
        this.scan = scan;
    }

    /**
     * Construit une nouvelle instance <br>
     *
     * Pour la version avec l'interface graphique
     *
     * @param nom le nom du joueur
     * */
    public Humain(String nom) {
        this(nom, new Scanner(System.in));
    }

    /**
     * Choisit la position au niveau de la grille de l'adversaire sur laquelle tirer
     *
     * @param bataille la bataille à laquelle le joueur participe
     * @return la position choisie
     * */
    @Override
    public Position choisirCoup(Bataille bataille) {
        System.out.println("choisissez une position x");
        int x;
        while (true) {
            if (scan.hasNextInt()) {
                x = scan.nextInt();
                break;
            } else {
                System.out.println("Erreur: veuillez entrer un entier pour x");
                scan.next(); // vide le scanner de l'entrée invalide
            }
        }
        System.out.println("choisissez une position y");
        int y;
        while (true) {
            if (scan.hasNextInt()) {
                y = scan.nextInt();
                break;
            } else {
                System.out.println("Erreur: veuillez entrer un entier pour y");
                scan.next(); // vide le scanner de l'entrée invalide
            }
        }
        return new Position(x, y);
    }

    /**
     * Redéfinition de la méthode toString() de la classe
     *
     * @return le nom du joueur
     */
    @Override
    public String toString() {
        return super.getNom();
    }
}
