package main.bataillenavale.model.navire;

import junit.framework.*;
import main.bataillenavale.model.navire.*;
import main.bataillenavale.model.Position;

/**
 * Une classe pour fournir les tests unitaires des méthodes de la classe Navire
 * 
 * @author Jerome Dagnon & Yassmine Habil
 */
public class NavireTest extends TestCase {

    private Navire navire;

    public NavireTest(String string){
        super(string);
    }

    protected void setUp() throws Exception {
        super.setUp();
        navire = new Navire(new Position(0, 1), Direction.VERTICALE, 3);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        navire = null;
    }

    public void testNavire() {
        assertNotNull("L'instance n'est pas créée", navire);
        assertEquals(0, navire.getPosDebut().getX());
        assertEquals(1, navire.getPosDebut().getY());
        assertEquals(Direction.VERTICALE, navire.getDirection());
        assertEquals(3, navire.getTaille());
        assertEquals(0, navire.getNbCasesTouchees());
    }

    public void testEstCoule() {
        assertFalse(navire.estCoule());
    }

    public void testIncrementTouche() {
        navire.incrementTouche();
        assertEquals(1, navire.getNbCasesTouchees());
    }

    
}