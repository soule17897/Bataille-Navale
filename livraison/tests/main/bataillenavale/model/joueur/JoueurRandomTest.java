package main.bataillenavale.model.joueur;

import junit.framework.TestCase;
import main.bataillenavale.model.Bataille;
import main.bataillenavale.model.Position;
import main.bataillenavale.model.joueur.Joueur;
import main.bataillenavale.model.joueur.JoueurMachine;
import main.bataillenavale.model.joueur.JoueurRandom;

/**
 * Une classe pour fournir les tests unitaires des méthodes de la classe JoueurRandom
 * 
 * @author Jerome Dagnon & Yassmine Habil
 */
public class JoueurRandomTest extends TestCase {

    private JoueurRandom joueurRandom;

    public JoueurRandomTest(String string){
        super(string);
    }

    protected void setUp() throws Exception {
        super.setUp();
        joueurRandom = new JoueurRandom();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        joueurRandom = null;
    }

    public void testJoueurRandom() {
        assertNotNull("L'instance n'est pas créée", joueurRandom);
    }

    public void testChoisirCoup(){
        Joueur adversaire = new JoueurRandom();
        Bataille bataille = new Bataille(joueurRandom, adversaire);

        Position position = joueurRandom.choisirCoup(bataille);
        assertNotNull(position);
        assertTrue(position.estValide());
    }
}
