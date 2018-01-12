package fr.pizzeria.ihm;

import java.util.Scanner;

import static fr.pizzeria.console.PizzeriaAdminConsoleApp.LOG;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {
	
	public AjouterPizzaOptionMenu(IPizzaDao dao, Scanner scan, String libelle) {
		super(dao, scan, libelle);
	}
	
	public void execute() throws SavePizzaException {		

		LOG.info("***** Ajout d'une nouvelle pizza");	
		
		LOG.info("Veuillez saisir le code:");
		String code = scan.next();
		if(code.length() > 3 || code.length() == 0) {
			throw new SavePizzaException("Le code doit etre de 3 caractères maximum ");
		}
		
		LOG.info("Veuillez saisir le numero de categorie: ");
		LOG.info("1. Viande");
		LOG.info("2. Sans viande");
		LOG.info("3. Poisson");
		String numeroCategorie = scan.next();
		Integer numeroCategorieParse = Integer.parseInt(numeroCategorie);
		if(!(numeroCategorieParse == 1  || numeroCategorieParse == 2 || numeroCategorieParse == 3)) {
			throw new SavePizzaException("Veuillez choisir un des choix present sur la liste proposée");
		}
		CategoriePizza categorie = CategoriePizza.getCategorie(numeroCategorieParse);
		
		
		LOG.info("Veuillez saisir le nom:");
		String nom = scan.next();
		if(nom.length() == 0) {
			throw new SavePizzaException("Le nom ne peut pas etre une chaine de caractere vide");
		}
		
		LOG.info("Veuillez saisir le prix:");
		String prix = scan.next();
		double prixParse = Double.parseDouble(prix);
		
		if(prixParse <= 0) {
			throw new SavePizzaException("Le prix ne peut pas etre négatif ou de 0");
		}
		
		//creation de l'objet Pizza
		Pizza newPizza  = new Pizza(code,nom,prixParse, categorie);
		dao.saveNewPizza(newPizza);


	}

}
