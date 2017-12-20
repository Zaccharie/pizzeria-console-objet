package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends OptionMenu {
	
	public ListerPizzasOptionMenu(PizzaDaoImpl dao, Scanner scan, String libelle) {
		super(dao, scan, libelle);
	}
	

	public void execute() {
		
		Pizza[] pizzaTab = dao.findAllPizzas();
		
		System.out.println("***** Liste des pizzas: ");
		for(Pizza currentPizza: pizzaTab) {
			if(currentPizza != null) {
				System.out.println(currentPizza.getCode() + " -> " + currentPizza.getNom() + " ("+currentPizza.getPrix()+") ");
			}
		}
	}
}
