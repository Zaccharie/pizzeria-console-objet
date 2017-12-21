package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.model.*;

public interface IPizzaDao {
	
	public List<Pizza> findAllPizzas();
	public void saveNewPizza(Pizza pizza);
	public void updatePizza(String codePizza, Pizza pizza);
	public void deletePizza(String codePizza);
	public boolean pizzaExist(String codePizza);
	
}
