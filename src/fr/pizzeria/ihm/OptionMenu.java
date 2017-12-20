package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

abstract class OptionMenu {
	
	protected String libelle;
	protected Scanner scan;
	protected static Pizza[] pizzaTab;
	
	
	public OptionMenu(Pizza[] pizzaTab, Scanner scan, String libelle) {
		// TODO Auto-generated constructor stub
		this.libelle = libelle;
		this.pizzaTab = pizzaTab;
		this.scan = scan;
	}
	
	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}	

	public abstract void execute();

}
