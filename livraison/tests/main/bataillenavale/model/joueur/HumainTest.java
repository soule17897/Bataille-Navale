package main.bataillenavale.model.joueur;

import junit.framework.TestCase;
import main.bataillenavale.model.Bataille;
import main.bataillenavale.model.Position;
import main.bataillenavale.model.joueur.Humain;
import main.bataillenavale.model.joueur.Joueur;
import main.bataillenavale.model.joueur.JoueurMachine;
import main.bataillenavale.model.joueur.JoueurRandom;

import java.util.Scanner;

/**
 * Une classe pour fournir les tests unitaires des méthodes de la classe Humain
 * 
 * @author Jerome Dagnon & Yassmine Habil
 */
public class HumainTest extends TestCase {

    private Humain humain;

    public HumainTest(String string){
        super(string);
    }

    protected void setUp() throws Exception {
        super.setUp();
        Scanner scanner = new Scanner(System.in);
        humain = new Humain("Name", scanner);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        humain = null;
    }

    public void testHumain() {
        assertNotNull("L'instance n'est pas créée", humain);
    }

    /*public void testChoisirCoup(){
        Joueur adversaire = new JoueurRandom();
        Bataille bataille = new Bataille(humain, adversaire);

        Position position = humain.choisirCoup(bataille);
        assertNotNull(position);
        assertTrue(position.estValide());
    }*/
}
