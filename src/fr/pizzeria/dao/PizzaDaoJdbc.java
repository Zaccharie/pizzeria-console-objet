package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJdbc implements IPizzaDao {
	
	private static Connection myConnection;
	private static Statement statement;
	private static ResultSet resultat;
	
	private static String URL = ResourceBundle.getBundle("jdbc").getString("URL");
	private static String PILOTE = ResourceBundle.getBundle("jdbc").getString("PILOTE");
	private static String USER = ResourceBundle.getBundle("jdbc").getString("USER");
	private static String PASSWORD = ResourceBundle.getBundle("jdbc").getString("PASSWORD");
	
	
	public PizzaDaoJdbc() throws ClassNotFoundException, SQLException {
	
			Class.forName(PizzaDaoJdbc.PILOTE);
			PizzaDaoJdbc.myConnection = DriverManager.
					getConnection(PizzaDaoJdbc.URL,PizzaDaoJdbc.USER,PizzaDaoJdbc.PASSWORD);
			PizzaDaoJdbc.statement = PizzaDaoJdbc.myConnection.createStatement();
	}
	
	@Override
	public List<Pizza> findAllPizzas(){
		
		List<Pizza> pizzaTab = new ArrayList<Pizza>();
		
		try {
			new PizzaDaoJdbc();
			resultat = PizzaDaoJdbc.statement.executeQuery("SELECT * FROM pizzas");
			
			//stock resultat dans list
			while(resultat.next()) {
				String nom = resultat.getString("Pizza_nom"); 
				String code = resultat.getString("Pizza_code");
				Double prix= resultat.getDouble("Pizza_prix");
				CategoriePizza categorie = CategoriePizza.valueOf(resultat.getString("Pizza_categorie").toUpperCase());
				
				pizzaTab.add(new Pizza(code,nom,prix,categorie));
			}
			
			PizzaDaoJdbc.resultat.close();
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();

		}
		finally {
			try {
				PizzaDaoJdbc.myConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return pizzaTab;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		
		PizzaDaoJdbc dao;
		
		try {
			
			dao = new PizzaDaoJdbc();
			PreparedStatement insertPizzaSt = (PreparedStatement) PizzaDaoJdbc.myConnection
					.prepareStatement(("INSERT INTO pizzas(Pizza_code, Pizza_nom, Pizza_prix, Pizza_categorie) VALUES(?,?,?,?)"));
			
			insertPizzaSt.setString(1, pizza.getCode());
			insertPizzaSt.setString(2, pizza.getNom());
			insertPizzaSt.setDouble(3, pizza.getPrix());
			insertPizzaSt.setString(4, pizza.getCategorie().toString());
			insertPizzaSt.executeUpdate();
			insertPizzaSt.close();
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();

		}

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		
		PizzaDaoJdbc dao;
		
		try {
			dao = new PizzaDaoJdbc();
			PreparedStatement updatePizzaSt = (PreparedStatement) PizzaDaoJdbc.myConnection
					.prepareStatement("UPDATE pizzas SET Pizza_code=?, Pizza_categorie=?, Pizza_nom=?, Pizza_prix=? WHERE Pizza_code=?");
			updatePizzaSt.setString(1, pizza.getCode());
			updatePizzaSt.setString(2, pizza.getCategorie().toString());
			updatePizzaSt.setString(3, pizza.getNom());
			updatePizzaSt.setDouble(4, pizza.getPrix());
			updatePizzaSt.setString(5, codePizza);
			updatePizzaSt.executeUpdate();
			updatePizzaSt.close();
			
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deletePizza(String codePizza) {
		
		PizzaDaoJdbc dao;
		
		try {
			dao = new PizzaDaoJdbc();
			PreparedStatement deletePizzaSt = (PreparedStatement) PizzaDaoJdbc.myConnection.prepareStatement("DELETE FROM pizzas WHERE Pizza_code=?");
			deletePizzaSt.setString(1, codePizza);
			deletePizzaSt.executeUpdate();
			deletePizzaSt.close();
			
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean pizzaExist(String codePizza) {
		
		PizzaDaoJdbc dao;
		
		try {
			dao = new PizzaDaoJdbc();
			PreparedStatement deletePizzaSt = (PreparedStatement) PizzaDaoJdbc.myConnection.prepareStatement("SELECT Pizza_id FROM pizzas WHERE Pizza_code=?");
			deletePizzaSt.setString(1, codePizza);
			ResultSet res = deletePizzaSt.executeQuery();
						
			if(res.next()) {
				res.close();
				return true;
			}
			else 
			{
				res.close();
				return false;
			}
			
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
