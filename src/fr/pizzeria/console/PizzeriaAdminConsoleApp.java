package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.ihm.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.ListerPizzasOptionMenu;
import fr.pizzeria.ihm.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.SupprimerPizzaOptionMenu;
import fr.pizzeria.model.*;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean printMenu = true;
		Pizza[] pizzaTab = new Pizza[8];
		
		//initialisation du tableau avec les valeurs par defaut
		pizzaTab[0] = new Pizza("PEP", "Pépéroni", 12.50);
		pizzaTab[1] = new Pizza("MAR", "Margherita", 14.00);
		pizzaTab[2] = new Pizza("REIN", "La Reine", 11.50);
		pizzaTab[3] = new Pizza("FRO", "La 4 fromages", 12.00);
		pizzaTab[4] = new Pizza("CAN", "La cannibale", 12.50);
		pizzaTab[5] = new Pizza("SAV", "La savoyarde", 13.00);
		pizzaTab[6] = new Pizza("ORI", "L'orientale", 13.50);
		pizzaTab[7] = new Pizza("IND", "L'indienne", 14.00);
		
		Scanner scan = new Scanner(System.in);
		ListerPizzasOptionMenu lister = new ListerPizzasOptionMenu(pizzaTab, scan, "1. Lister les pizzas");
		AjouterPizzaOptionMenu ajouter = new AjouterPizzaOptionMenu(pizzaTab, scan, "2. Ajouter une nouvelle pizza");
		ModifierPizzaOptionMenu modifier = new ModifierPizzaOptionMenu(pizzaTab, scan, "3. Modifier une pizza");
		SupprimerPizzaOptionMenu supprimer = new SupprimerPizzaOptionMenu(pizzaTab, scan, "4. Supprimer une pizza");
		
		do {
			System.out.println("***** Pizzeria Administration *****");
			System.out.println(lister.getLibelle());
			System.out.println(ajouter.getLibelle());
			System.out.println(modifier.getLibelle());
			System.out.println(supprimer.getLibelle());
			System.out.println("99. Sortir");
			
			int choix = scan.nextInt();
			
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
			
		}while(printMenu);

	}

}
