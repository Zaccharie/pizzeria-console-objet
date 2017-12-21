package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.ListerPizzasOptionMenu;
import fr.pizzeria.ihm.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.SupprimerPizzaOptionMenu;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean printMenu = true;

		PizzaDaoImpl dao = new PizzaDaoImpl();
		
		Scanner scan = new Scanner(System.in);
		ListerPizzasOptionMenu lister = new ListerPizzasOptionMenu(dao, scan, "1. Lister les pizzas");
		AjouterPizzaOptionMenu ajouter = new AjouterPizzaOptionMenu(dao, scan, "2. Ajouter une nouvelle pizza");
		ModifierPizzaOptionMenu modifier = new ModifierPizzaOptionMenu(dao, scan, "3. Modifier une pizza");
		SupprimerPizzaOptionMenu supprimer = new SupprimerPizzaOptionMenu(dao, scan, "4. Supprimer une pizza");
		
		do {
			System.out.println("***** Pizzeria Administration *****");
			System.out.println(lister.getLibelle());
			System.out.println(ajouter.getLibelle());
			System.out.println(modifier.getLibelle());
			System.out.println(supprimer.getLibelle());
			System.out.println("99. Sortir");
			
			int choix = scan.nextInt();
			
			try {
				
				switch(choix) {
				
				case(99):
					System.out.println("Au revoir");
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
				System.out.println(e.getMessage());
			}
			catch(NumberFormatException e) {
				System.out.println("Format du prix incorrect. Veuillez rentrer un nombre. Si virgule, veuillez utiliser \".\" ");
			}
	
			
		}while(printMenu);
		
		scan.close();

	}

}
