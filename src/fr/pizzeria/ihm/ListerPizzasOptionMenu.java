package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends OptionMenu {
	
	public ListerPizzasOptionMenu(PizzaDaoImpl dao, Scanner scan, String libelle) {
		super(dao, scan, libelle);
	}
	

	public void execute() {
		
		List<Pizza> pizzaTab = dao.findAllPizzas();
		
		System.out.println("***** Liste des pizzas: ");
		for(Pizza currentPizza: pizzaTab) {
			System.out.println(currentPizza.getCode() + " -> " + currentPizza.getNom() + " ("+currentPizza.getPrix()+") ");
		}
	}
}
