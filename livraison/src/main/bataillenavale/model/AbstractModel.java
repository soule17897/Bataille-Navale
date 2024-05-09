package main.bataillenavale.model;

import main.bataillenavale.observer.ModeleObservable;
import main.bataillenavale.observer.Observateur;

import java.util.ArrayList;



public abstract class AbstractModel implements ModeleObservable {
    
	private ArrayList<Observateur> listesObservateures = new ArrayList<>();
	

	@Override 
	public void addObsever(Observateur obs ) {
		this.listesObservateures.add(obs);
	}
	
	
	@Override
	public void removeObserver() {
		this.listesObservateures = new ArrayList<>();
	}
	

	public void notifyObserver() {
		for(Observateur obs : listesObservateures)
			 obs.update(this);
	}
	
 }
