package main.bataillenavale.model.joueur;

import junit.framework.TestCase;
import main.bataillenavale.model.Position;
import main.bataillenavale.model.joueur.Joueur;
import main.bataillenavale.model.joueur.JoueurRandom;
import main.bataillenavale.model.navire.Direction;
import main.bataillenavale.model.navire.Navire;

/**
 * Une classe pour fournir les tests unitaires des méthodes de la classe Joueur
 * 
 * @author Jerome Dagnon & Yassmine Habil
 */
public class JoueurTest extends TestCase {

    private Joueur joueur;

    public JoueurTest(String string){
        super(string);
    }

    protected void setUp() throws Exception {
        super.setUp();
        joueur = new JoueurRandom();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        joueur = null;
    }

    public void testJoueur() {
        assertNotNull("L'instance n'est pas créée", joueur);
    }

    public void testPlacerNaviresAleatoires(){
        joueur.placerNaviresAleatoires();

        int compteur = 0;
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if (joueur.getGrille().getEmplacementsOccupes()[i][j]){
                    compteur++;
                }
            }
        }

        assertEquals(17, compteur);
        assertEquals(5, joueur.getNavires().size());

    }
}
