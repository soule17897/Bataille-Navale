package main.bataillenavale.model;

import junit.framework.TestCase;
import main.bataillenavale.model.Grille;
import main.bataillenavale.model.Position;
import main.bataillenavale.model.navire.Direction;
import main.bataillenavale.model.navire.Navire;

/**
 * Une classe pour fournir les tests unitaires des méthodes de la classe Grille
 * 
 * @author Youra Ahmed
 */
public class GrilleTest extends TestCase {

    // Tests getters
    public void testGetGrille() {
        Grille grille = new Grille();
        Position[][] Positions = grille.getGrille();
        assertNotNull(Positions);
        assertEquals(10, Positions.length);//teste si la longueur de la grille est bien de 10
        assertEquals(10, Positions[0].length); //teste si la longueur de la première ligne est bien de 10
        System.out.println("testGetGrille OK");
    }
    public void testGetPosition() {
        Grille grille = new Grille();
        Position position = grille.getPosition(0, 0);
        assertNotNull(position);
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
        System.out.println("testGetPosition OK");
    }
    public void testEstDansGrille() {
        Grille grille = new Grille();
        Position position = new Position(0, 0);
        assertTrue(grille.estDansGrille(position));
        assertFalse(grille.estDansGrille(10, 10));
        System.out.println("testEstDansGrille OK");
    }
    public void testEstDansGrille2() {
        Grille grille = new Grille();
        Position position = new Position(0, 0);
        Position position2 = new Position(10, 10);
        assertTrue(grille.estDansGrille(position));
        assertFalse(grille.estDansGrille(position2));
        System.out.println("testEstDansGrille2 OK");
    }
    public void testGetEmplacementsOccupes(){
        Grille grille = new Grille();
        boolean[][] emplacements = grille.getEmplacementsOccupes();
        assertNotNull(emplacements);
        assertEquals(10, emplacements.length);
        assertEquals(10, emplacements[0].length);
        System.out.println("testGetEmplacementsOccupes OK");
    }
    public void testPeutPlacer(){
        Grille grille = new Grille();
        Position position = new Position(0, 0);
        Navire navire = new Navire(position, Direction.VERTICALE , 2);
        Navire navire2 = new Navire(new Position(10, 10), Direction.VERTICALE, 4);
        assertTrue(grille.peutPlacer(navire , position , Direction.VERTICALE));
        assertFalse(grille.peutPlacer(navire2, new Position(10, 10), Direction.VERTICALE));
        System.out.println("testPeutPlacer OK");
    }
    public void testPlacerNavire(){
        Grille grille = new Grille();
        Position position = new Position(0, 0);
        Navire navire = new Navire(position, Direction.VERTICALE , 2);
        Navire navire2 = new Navire(new Position(5, 5), Direction.VERTICALE, 4);
        grille.placerNavire(navire);
        grille.placerNavire(navire2);
        for(int i = 0; i < navire.getTaille(); i++){
            assertNotNull(grille.getPosition(position.getX(), position.getY()).getNavire());
        }
        for(int i = 0; i < navire2.getTaille(); i++){
            assertNotNull(grille.getPosition(position.getX(), position.getY()).getNavire());
        }
        System.out.println("testPlacerNavire OK");
    }

}
