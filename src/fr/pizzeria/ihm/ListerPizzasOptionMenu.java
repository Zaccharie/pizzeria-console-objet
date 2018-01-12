package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import static fr.pizzeria.console.PizzeriaAdminConsoleApp.LOG;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class ListerPizzasOptionMenu extends OptionMenu {
	
	public ListerPizzasOptionMenu(IPizzaDao dao, Scanner scan, String libelle) {
		super(dao, scan, libelle);
	}
	

	public void execute(){
		
		List<Pizza> pizzaTab = dao.findAllPizzas();
		
		LOG.info("***** Liste des pizzas: ");
		for(Pizza currentPizza: pizzaTab) {
			LOG.info(currentPizza.getCode() + " -> " + currentPizza.getNom() + ", categorie: " + currentPizza.getCategorie() + ", " + currentPizza.getPrix());
		}
	}
}
