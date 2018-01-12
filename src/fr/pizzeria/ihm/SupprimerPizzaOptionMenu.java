package fr.pizzeria.ihm;

import java.util.Scanner;

import static fr.pizzeria.console.PizzeriaAdminConsoleApp.LOG;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;

public class SupprimerPizzaOptionMenu extends OptionMenu {
	
	public SupprimerPizzaOptionMenu(IPizzaDao dao, Scanner scan, String libelle) {
		super(dao, scan, libelle);
	}
	
	public void execute() throws DeletePizzaException {
		
		LOG.info("***** Suppression d'une pizza");
		LOG.info("Veuillez saisir le code de la pizza à supprimer:");
		LOG.info("(99 pour abandonner)");
		String codePizzaDelete = scan.next();
		
		if(codePizzaDelete.equals("99")) {
			return;
		}
		else if(dao.pizzaExist(codePizzaDelete)) {
			dao.deletePizza(codePizzaDelete);
			LOG.info("Pizza avec code pizza "+codePizzaDelete+" supprimée");
		}
		else {
			throw new DeletePizzaException("La pizza que vous voulez supprimer n'existe pas");
		}
		
	}
}
