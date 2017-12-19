package fr.pizzeria.model;

public class Pizza {
	
	private Integer id;
	private String code;
	private String nom;
	private double prix;
	private static int nombrePizzaTot;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public Pizza(String code, String nom, double prix) {
		super();
		this.id = Pizza.nombrePizzaTot;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		Pizza.nombrePizzaTot++;
	}
	
	public static void readTab(Pizza[] pizzaTab) {
		for(Pizza currentPizza: pizzaTab) {
			if(currentPizza != null) {
				System.out.println(currentPizza.getCode() + " -> " + currentPizza.getNom() + " ("+currentPizza.getPrix()+") ");
			}
		}
	}
	
	
	public static Pizza[] addPizza(Pizza newPizza, Pizza[] pizzaTab) {
		
		Pizza[] tempTab = new Pizza[(pizzaTab.length + 1)]; //creer un tableau de longeur +1
		
		for(int i = 0; i < pizzaTab.length; i++) { //Copie des elements dans le tableau temporaire
			tempTab[i] = pizzaTab[i];
		}
		tempTab[(tempTab.length-1)] = newPizza; //On ajoute le dernier nombre dans le tableau
		
		return tempTab; //on retourne le tableau tempTab
	}
	
	public static Pizza[] deletePizza(String code, Pizza[] pizzaTab) {
		int offset = 0;
		Pizza[] tempTab = new Pizza[(pizzaTab.length)]; //creer un tableau de longeur - 1
		for(int i = 0; i < pizzaTab.length; i++){
			if(pizzaTab[i].getCode().equals(code)) {
				tempTab[i] = null;
			}
			else {
				tempTab[i] = pizzaTab[i];
			}
		}
		return tempTab; //on retourne le tableau tempTab
	}
	
	public static void updatePizza(String code, String codeUpdate, String nomUpdate, double prixUpdate, Pizza[] pizzaTab) {
		for(Pizza current: pizzaTab) {
			if(current != null) {
				if(current.getCode().equals(code)) {
					current.setCode(codeUpdate);
					current.setNom(nomUpdate);
					current.setPrix(prixUpdate);
				}
			}
		}
	}

}
