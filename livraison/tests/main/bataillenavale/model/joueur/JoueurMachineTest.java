package main.bataillenavale.model.joueur;

import junit.framework.TestCase;
import main.bataillenavale.model.Bataille;
import main.bataillenavale.model.Position;
import main.bataillenavale.model.joueur.Joueur;
import main.bataillenavale.model.joueur.JoueurRandom;
import main.bataillenavale.model.joueur.JoueurMachine;

/**
 * Une classe pour fournir les tests unitaires des méthodes de la classe JoueurMachine
 * 
 * @author Jerome Dagnon & Yassmine Habil
 */
public class JoueurMachineTest extends TestCase {

    private JoueurMachine joueurMachine;

    public JoueurMachineTest(String string){
        super(string);
    }

    protected void setUp() throws Exception {
        super.setUp();
        joueurMachine = new JoueurMachine();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        joueurMachine = null;
    }

    public void testJoueurMachine() {
        assertNotNull("L'instance n'est pas créée", joueurMachine);
    }

    public void testChoisirCoup(){
        Joueur adversaire = new JoueurRandom();
        Bataille bataille = new Bataille(joueurMachine, adversaire);

        Position position = joueurMachine.choisirCoup(bataille);
        assertNotNull(position);
        assertTrue(position.estValide());
    }
}
