package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.DeletePizzaException;

public class SupprimerPizzaOptionMenu extends OptionMenu {
	
	public SupprimerPizzaOptionMenu(PizzaDaoImpl dao, Scanner scan, String libelle) {
		super(dao, scan, libelle);
	}
	
	public void execute() throws DeletePizzaException {
		
		System.out.println("***** Suppression d'une pizza");
		System.out.println("Veuillez saisir le code de la pizza à supprimer:");
		System.out.println("(99 pour abandonner)");
		String codePizzaDelete = scan.next();
		
		if(codePizzaDelete.equals("99")) {
			return;
		}
		else if(!dao.pizzaExist(codePizzaDelete)) {
			throw new DeletePizzaException("La pizza que vous voulez supprimer n'existe pas");
		}
		else {
			dao.deletePizza(codePizzaDelete);
		}
		
	}
}
