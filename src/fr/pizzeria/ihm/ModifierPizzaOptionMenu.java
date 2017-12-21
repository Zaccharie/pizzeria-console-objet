package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {
	
	public ModifierPizzaOptionMenu(PizzaDaoImpl dao, Scanner scan, String libelle) {
		super(dao, scan, libelle);
	}

	public void execute() throws UpdatePizzaException{
					
		System.out.println("***** Mise à jour d'une pizza");
		System.out.println("Veuillez saisir le code de la pizza à modifier:");
		System.out.println("(99 pour abandonner)");
		String codePizzaUpdate = scan.next();
		
		if(codePizzaUpdate.equals("99")) {
			return;
		}
		else if(!dao.pizzaExist(codePizzaUpdate)) {
			throw new UpdatePizzaException("La pizza que vous voulez modifier n'existe pas");
		}
		else {
	
			System.out.println("Veuillez saisir le code:");
			String codeUpdate = scan.next();
			if(codeUpdate.length() > 3 || codeUpdate.length() == 0) {
				throw new UpdatePizzaException("Le code doit etre de 3 caractères maximum ");
			}
			
			System.out.println("Veuillez saisir le nom:");
			String nomUpdate = scan.next();
			if(nomUpdate.length() > 3 || nomUpdate.length() == 0) {
				throw new UpdatePizzaException("Le nom ne peut pas etre une chaine de caractere vide");
			}
			
			System.out.println("Veuillez saisir le prix:");
			String prixUpdate = scan.next();
			double prixUpdateParse = Double.parseDouble(prixUpdate);
			if(prixUpdateParse <= 0) {
				throw new UpdatePizzaException("Le prix ne peut pas etre négatif ou de 0");
			}
			
			if(prixUpdateParse <= 0) {
				throw new UpdatePizzaException("Le prix ne peut pas etre négatif ou de 0");
			}
			
			Pizza pizza = new Pizza(codeUpdate, nomUpdate, prixUpdateParse);
			dao.updatePizza(codePizzaUpdate, pizza);
	
		}
			
	}
}
