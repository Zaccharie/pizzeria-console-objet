package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class AjouterPizzaOptionMenu extends OptionMenu {
	
	public AjouterPizzaOptionMenu(Pizza[] pizzaTab, Scanner scan, String libelle) {
		super(pizzaTab, scan, libelle);
	}
	
	public void execute() {
		
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
		Pizza[] tempTab = new Pizza[(pizzaTab.length + 1)]; //creer un tableau de longeur +1
		
		for(int i = 0; i < pizzaTab.length; i++) { //Copie des elements dans le tableau temporaire
			tempTab[i] = pizzaTab[i];
		}
		tempTab[(tempTab.length-1)] = newPizza; //On ajoute le dernier nombre dans le tableau
		
		pizzaTab = tempTab;
	}

}
