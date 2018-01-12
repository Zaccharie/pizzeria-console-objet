package fr.pizzeria.console;

import java.sql.SQLException;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoJdbc;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.ListerPizzasOptionMenu;
import fr.pizzeria.ihm.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.SupprimerPizzaOptionMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PizzeriaAdminConsoleApp {
	
	public static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		boolean printMenu = true;

		IPizzaDao dao = new PizzaDaoJdbc();
		
		Scanner scan = new Scanner(System.in);
		ListerPizzasOptionMenu lister = new ListerPizzasOptionMenu(dao, scan, "1. Lister les pizzas");
		AjouterPizzaOptionMenu ajouter = new AjouterPizzaOptionMenu(dao, scan, "2. Ajouter une nouvelle pizza");
		ModifierPizzaOptionMenu modifier = new ModifierPizzaOptionMenu(dao, scan, "3. Modifier une pizza");
		SupprimerPizzaOptionMenu supprimer = new SupprimerPizzaOptionMenu(dao, scan, "4. Supprimer une pizza");
		
		do {
			LOG.info("***** Pizzeria Administration *****");
			LOG.info(lister.getLibelle());
			LOG.info(ajouter.getLibelle());
			LOG.info(modifier.getLibelle());
			LOG.info(supprimer.getLibelle());
			LOG.info("99. Sortir");
			
			int choix = scan.nextInt();
			
			try {
				
				switch(choix) {
				
				case(99):
					LOG.info("Au revoir");
					printMenu = false;
				break;
				
				case(1):
					lister.execute();
				break;
				
				case(2):
					ajouter.execute();
				break;
				
				case(3):
					modifier.execute();
				break;
				
				case(4):
					supprimer.execute();
				break;
				}
			}
			catch(StockageException e){
				LOG.info(e.getMessage());
			}
			catch(NumberFormatException e) {
				LOG.info("Format du prix incorrect. Veuillez rentrer un nombre. Si virgule, veuillez utiliser \".\" ");
			}
	
			
		}while(printMenu);
		
		scan.close();

	}

}
