package fr.pizzeria.console;

import fr.pizzeria.model.Pizza;
import java.util.Scanner;

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
		
		do {
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");
			
			int choix = scan.nextInt();
			
			switch(choix) {
			
				case(99):
					System.out.println("Au revoir");
					printMenu = false;
				break;
				
				case(1):
					System.out.println("***** Liste des pizzas: ");
					Pizza.readTab(pizzaTab);
				break;
				
				case(2):
					System.out.println("***** Ajout d'une nouvelle pizza");	
					System.out.println("Veuillez saisir le code:");
					String code = scan.next();
					System.out.println("Veuillez saisir le nom:");
					String nom = scan.next();
					System.out.println("Veuillez saisir le prix:");
					double prix = scan.nextDouble();
					
					//creation de l'objet Pizza
					Pizza newPizza  = new Pizza(code,nom,prix);
					//nouveau tableau de pizzas
					pizzaTab = Pizza.addPizza(newPizza, pizzaTab);
					
				break;
				
				case(3):
					System.out.println("***** Mise à jour d'une pizza");
					Pizza.readTab(pizzaTab);
					System.out.println("Veuillez saisir le code de la pizza à modifier:");
					System.out.println("(99 pour abandonner)");
					String codePizzaUpdate = scan.next();
					
					if(codePizzaUpdate.equals("99")) {
						break;
					}
					else {
						System.out.println("Veuillez saisir le code:");
						String codeUpdate = scan.next();
						System.out.println("Veuillez saisir le nom:");
						String nomUpdate = scan.next();
						System.out.println("Veuillez saisir le prix:");
						double prixUpdate = scan.nextDouble();
						
						Pizza.updatePizza(codePizzaUpdate, codeUpdate, nomUpdate, prixUpdate, pizzaTab);
					}
				break;
				
				case(4):
					System.out.println("***** Suppression d'une pizza");
					Pizza.readTab(pizzaTab);
					System.out.println("Veuillez saisir le code de la pizza à supprimer:");
					System.out.println("(99 pour abandonner)");
					String codePizzaDelete = scan.next();
					
					if(codePizzaDelete.equals("99")) {
						break;
					}
					else {
						pizzaTab = Pizza.deletePizza(codePizzaDelete, pizzaTab);
					}
				break;
			}
			
		}while(printMenu);

	}

}
