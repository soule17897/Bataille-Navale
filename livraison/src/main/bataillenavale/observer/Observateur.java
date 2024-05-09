package main.bataillenavale.observer;


public interface Observateur {
   
	/** This method is called whenever the observed object is changed. */
	
	public void update(Object o );
	
}
