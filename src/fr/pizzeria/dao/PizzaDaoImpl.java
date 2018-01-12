package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
	
	private List<Pizza> pizzaTab; 
	
	public PizzaDaoImpl() {
		pizzaTab = new ArrayList<Pizza>();
		pizzaTab.add(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		pizzaTab.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		pizzaTab.add(new Pizza("REIN", "La Reine", 11.50, CategoriePizza.VIANDE));
		pizzaTab.add(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		pizzaTab.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		pizzaTab.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.SANS_VIANDE));
		pizzaTab.add(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VIANDE));
		pizzaTab.add(new Pizza("IND", "L'indienne", 14.00, CategoriePizza.VIANDE));
	}
	
	@Override
	public List<Pizza> findAllPizzas() {
		return pizzaTab;
	}
	
	@Override
	public boolean pizzaExist(String codePizza) {
		for(Pizza currentPizza : pizzaTab) {
			if(currentPizza.getCode().equals(codePizza)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void saveNewPizza(Pizza pizza) {
		pizzaTab.add(pizza);
	}
	
	@Override
	public void updatePizza(String codePizza, Pizza pizza){
		for(Pizza currentPizza: pizzaTab) {
			if(currentPizza != null) {
				if(currentPizza.getCode().equals(codePizza)) {
					pizzaTab.set(pizzaTab.indexOf(currentPizza), pizza);
				}
			}
		}
	}
	
	@Override
	public void deletePizza(String codePizza) {
		Pizza pizzaToRemove = null;
		for(Pizza currentPizza: pizzaTab) {
			if(currentPizza.getCode().equals(codePizza)) {
				pizzaToRemove = currentPizza; //Attention : On ne remove pas dans la boucle sinon -> ConcurrentModificationException
			}
		}
		pizzaTab.remove(pizzaToRemove);
	}

}
