package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends OptionMenu {
	
	public SupprimerPizzaOptionMenu(Pizza[] pizzaTab, Scanner scan, String libelle) {
		super(pizzaTab, scan, libelle);
	}
	
	public void execute() {
		
		System.out.println("***** Suppression d'une pizza");
		System.out.println("Veuillez saisir le code de la pizza à supprimer:");
		System.out.println("(99 pour abandonner)");
		String codePizzaDelete = scan.next();
		
		if(codePizzaDelete.equals("99")) {
			return;
		}
		else {
			Pizza[] tempTab = new Pizza[(pizzaTab.length)]; //creer un tableau de longeur - 1
			for(int i = 0; i < pizzaTab.length; i++){
				if(pizzaTab[i].getCode().equals(codePizzaDelete)) {
					tempTab[i] = null;
				}
				else {
					tempTab[i] = pizzaTab[i];
				}
			}
			pizzaTab = tempTab; 
		}
		
	}
}
