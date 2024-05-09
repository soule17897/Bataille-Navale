package main.bataillenavale.model;

import junit.framework.TestCase;
import main.bataillenavale.model.Bataille;
import main.bataillenavale.model.Position;
import main.bataillenavale.model.joueur.Joueur;
import main.bataillenavale.model.joueur.JoueurRandom;

/**
 * Une classe pour fournir les tests unitaires des méthodes de la classe Bataille
 * 
 * @author Jerome Dagnon & Yassmine Habil
 */
public class BatailleTest extends TestCase {

    private Bataille bataille;

    public BatailleTest(String string){
        super(string);
    }

    protected void setUp() throws Exception {
        super.setUp();
        Joueur joueur1 = new JoueurRandom();
        Joueur joueur2 = new JoueurRandom();
        bataille = new Bataille(joueur1, joueur2);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        bataille = null;
    }

    public void testBataille() {
        assertNotNull("L'instance n'est pas créée", bataille);
        assertEquals(bataille.getJoueur1().toString(), bataille.getJoueurCourant().toString());


        assertFalse(bataille.getJoueur2().getGrille().getPosition(5, 3).estTouche());
        bataille.execute(5, 3);
        assertTrue(bataille.getJoueur2().getGrille().getPosition(5, 3).estTouche());
    }



}
