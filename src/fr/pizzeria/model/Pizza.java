package fr.pizzeria.model;

/**
 * @author Zaccharie Meddah
 *
 */
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

}
