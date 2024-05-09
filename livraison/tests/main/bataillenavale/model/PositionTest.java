package main.bataillenavale.model;

import junit.framework.*;
import main.bataillenavale.model.Position;
import main.bataillenavale.model.navire.Direction;
import main.bataillenavale.model.navire.Navire;

/**
 * Une classe pour fournir les tests unitaires des méthodes de la classe Position
 * 
 * @author Jerome Dagnon & Yassmine Habil
 */
public class PositionTest extends TestCase {

    private Position position;

    public PositionTest(String string){
        super(string);
    }

    protected void setUp() throws Exception {
        super.setUp();
        position = new Position(0, 0);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        position = null;
    }

    public void testPosition() {
        assertNotNull("L'instance n'est pas créée", position);
    }

    public void testGetX() {
        assertEquals("Le numéro de ligne est incorrect", 0, position.getX());
    }

    public void testGetY() {
        assertEquals("Le numéro de colonne est incorrect", 0, position.getY());
    }

    public void testEstTouche() {
        assertFalse("La valeur retournée est incorrecte", position.estTouche());

        position.changeEtat();
        assertTrue("La valeur retournée est incorrecte", position.estTouche());
    }

    public void testGetNavire() {
        assertNull(position.getNavire());

        Navire navire = new Navire(position, Direction.VERTICALE, 3);
        position.setNavire(navire);
        assertNotNull(position.getNavire());
    }

    /**
     * La position n'appartient pas à un navire
     */
    public void testToString1(){
        assertEquals("Le caractère de la position est incorrect", "#", position.toString());

        position.changeEtat();
        assertEquals("Le caractère de la position est incorrect", "!", position.toString());
    }

    /**
     * La position appartient à un navire
     * */
    public void testToString2(){
        Navire navire = new Navire(position, Direction.VERTICALE, 3);
        position.setNavire(navire);

        assertEquals("Le caractère de la position est incorrect", "0", position.toString());

        position.changeEtat();
        assertEquals("Le caractère de la position est incorrect", "X", position.toString());
    }

    public void testGenererAleatoire(){
        Position position1 = Position.genererAleatoire();

        assertNotNull(position1);
        assertTrue(position1.estValide());
    }

    public void testGetPositionSuivante(){
        Position positionSuivante = position.getPositionSuivante(Direction.VERTICALE);

        // Vérifie que l'objet retourné n'est pas null
        assertNotNull(positionSuivante);

        // Vérifie que les coordonnées de l'objet retourné sont correctes
        assertEquals(1, positionSuivante.getX());
        assertEquals(0, positionSuivante.getY());


        Position positionSuivante1 = position.getPositionSuivante(Direction.HORIZONTALE);

        // Vérifie que l'objet retourné n'est pas null
        assertNotNull(positionSuivante1);

        // Vérifie que les coordonnées de l'objet retourné sont correctes
        assertEquals(0, positionSuivante1.getX());
        assertEquals(1, positionSuivante1.getY());
    }

}
