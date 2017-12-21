package fr.pizzeria.dao;

import fr.pizzeria.model.*;

public interface IPizzaDao {
	
	public Pizza[] findAllPizzas();
	public void saveNewPizza(Pizza pizza);
	public void updatePizza(String codePizza, Pizza pizza);
	public void deletePizza(String codePizza);
	public boolean pizzaExist(String codePizza);
	
}
