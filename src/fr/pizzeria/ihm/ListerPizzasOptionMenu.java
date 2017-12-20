package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends OptionMenu {
	
	public ListerPizzasOptionMenu(Pizza[] pizzaTab, Scanner scan, String libelle) {
		super(pizzaTab, scan, libelle);
	}
	

	public void execute() {
		System.out.println("***** Liste des pizzas: ");
		for(Pizza currentPizza: pizzaTab) {
			if(currentPizza != null) {
				System.out.println(currentPizza.getCode() + " -> " + currentPizza.getNom() + " ("+currentPizza.getPrix()+") ");
			}
		}
	}
}
