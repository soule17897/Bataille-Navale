package main.bataillenavale.model.navire;

import java.util.Random;

/**
 * Une classe enum pour définir la direction d'un navire
 */
public enum Direction {
    VERTICALE,
    HORIZONTALE;

    /**
     * Génère une nouvelle direction de façon pseudo-aléatoire
     *
     * @return une nouvelle direction
     * */
    public static Direction genererAleatoire() {
        Random random = new Random();
        int choix = random.nextInt(2);
        if (choix == 0)
            return Direction.VERTICALE;
        return Direction.HORIZONTALE;
    }
}
