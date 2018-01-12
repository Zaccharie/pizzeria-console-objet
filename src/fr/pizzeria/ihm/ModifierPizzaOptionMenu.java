package fr.pizzeria.ihm;

import java.util.Scanner;

import static fr.pizzeria.console.PizzeriaAdminConsoleApp.LOG;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {
	
	public ModifierPizzaOptionMenu(IPizzaDao dao, Scanner scan, String libelle) {
		super(dao, scan, libelle);
	}

	public void execute() throws UpdatePizzaException{
					
		LOG.info("***** Mise à jour d'une pizza");
		LOG.info("Veuillez saisir le code de la pizza à modifier:");
		LOG.info("(99 pour abandonner)");
		String codePizzaUpdate = scan.next();
		
		if(codePizzaUpdate.equals("99")) {
			return;
		}
		else if(!dao.pizzaExist(codePizzaUpdate)) {
			throw new UpdatePizzaException("La pizza que vous voulez modifier n'existe pas");
		}
		else {
	
			LOG.info("Veuillez saisir le code:");
			String codeUpdate = scan.next();
			if(codeUpdate.length() > 3 || codeUpdate.length() == 0) {
				throw new UpdatePizzaException("Le code doit etre de 3 caractères maximum ");
			}
			
			LOG.info("Veuillez saisir le numero de categorie: ");
			LOG.info("1. Viande");
			LOG.info("2. Sans viande");
			LOG.info("3. Poisson");
			String numeroCategorie = scan.next();
			Integer numeroCategorieParse = Integer.parseInt(numeroCategorie);
			if(!(numeroCategorieParse == 1  || numeroCategorieParse == 2 || numeroCategorieParse == 3)) {
				throw new UpdatePizzaException("Veuillez choisir un des choix present sur la liste proposée");
			}
			CategoriePizza categorie = CategoriePizza.getCategorie(numeroCategorieParse);
			
			LOG.info("Veuillez saisir le nom:");
			String nomUpdate = scan.next();
			
			
			LOG.info("Veuillez saisir le prix:");
			String prixUpdate = scan.next();
			double prixUpdateParse = Double.parseDouble(prixUpdate);
			if(prixUpdateParse <= 0) {
				throw new UpdatePizzaException("Le prix ne peut pas etre négatif ou de 0");
			}
			
			Pizza pizza = new Pizza(codeUpdate, nomUpdate, prixUpdateParse, categorie);
			dao.updatePizza(codePizzaUpdate, pizza);
	
		}
			
	}
}
