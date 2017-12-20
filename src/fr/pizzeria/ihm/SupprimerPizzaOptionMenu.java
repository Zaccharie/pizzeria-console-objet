package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends OptionMenu {
	
	public SupprimerPizzaOptionMenu(PizzaDaoImpl dao, Scanner scan, String libelle) {
		super(dao, scan, libelle);
	}
	
	public void execute() {
		
		System.out.println("***** Suppression d'une pizza");
		System.out.println("Veuillez saisir le code de la pizza à supprimer:");
		System.out.println("(99 pour abandonner)");
		String codePizzaDelete = scan.next();
		
		if(codePizzaDelete.equals("99")) {
			return;
		}
		else {
			dao.deletePizza(codePizzaDelete);
		}
		
	}
}
