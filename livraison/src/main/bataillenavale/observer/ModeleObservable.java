package main.bataillenavale.observer;


/**
 * @author thiam221
 *
 */
public interface ModeleObservable {
     
/** Ajoute un observateur à l'ensemble des observateurs pour cet objet, à condition qu'il ne soit pas identique à un observateur déjà présent dans l'ensemble. */
	
	 public void addObsever(Observateur  o );
	 
/** Efface la liste des observateurs afin que cet objet n'ait plus d'observateurs */	
	 
	 public void removeObserver();

/**	Si cet objet a changé, comme indiqué par la méthode hasChanged, alors notifiez tous ses observateurs puis appelez la méthode clearChanged pour indiquer que cet objet n'a plus changé.*/
	 
	 public void notifyObserver();
	 
}
