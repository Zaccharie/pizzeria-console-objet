package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
	
	private Pizza[] pizzaTab; 
	
	public PizzaDaoImpl() {
		pizzaTab = new Pizza[8];
		pizzaTab[0] = new Pizza("PEP", "Pépéroni", 12.50);
		pizzaTab[1] = new Pizza("MAR", "Margherita", 14.00);
		pizzaTab[2] = new Pizza("REIN", "La Reine", 11.50);
		pizzaTab[3] = new Pizza("FRO", "La 4 fromages", 12.00);
		pizzaTab[4] = new Pizza("CAN", "La cannibale", 12.50);
		pizzaTab[5] = new Pizza("SAV", "La savoyarde", 13.00);
		pizzaTab[6] = new Pizza("ORI", "L'orientale", 13.50);
		pizzaTab[7] = new Pizza("IND", "L'indienne", 14.00);
	}
	
	@Override
	public Pizza[] findAllPizzas() {
		return pizzaTab;
	}
	
	@Override
	public void saveNewPizza(Pizza pizza) {
		//nouveau tableau de pizzas
		Pizza[] tempTab = new Pizza[(pizzaTab.length + 1)]; //creer un tableau de longeur +1
		
		for(int i = 0; i < pizzaTab.length; i++) { //Copie des elements dans le tableau temporaire
			tempTab[i] = pizzaTab[i];
		}
		tempTab[(tempTab.length-1)] = pizza; //On ajoute le dernier nombre dans le tableau
		
		pizzaTab = tempTab;
	}
	
	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		for(Pizza current: pizzaTab) {
			if(current != null) {
				if(current.getCode().equals(codePizza)) {
					current.setCode(pizza.getCode());
					current.setNom(pizza.getNom());
					current.setPrix(pizza.getPrix());
				}
			}
		}
	}
	
	@Override
	public void deletePizza(String codePizza) {
		Pizza[] tempTab = new Pizza[(pizzaTab.length)];
		for(int i = 0; i < pizzaTab.length; i++){
			if(pizzaTab[i].getCode().equals(codePizza)) {
				tempTab[i] = null;
			}
			else {
				tempTab[i] = pizzaTab[i];
			}
		}
		pizzaTab = tempTab; 
	}

}
