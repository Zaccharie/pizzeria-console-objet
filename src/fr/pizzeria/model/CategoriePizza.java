package fr.pizzeria.model;

public enum CategoriePizza {
	
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");
	
	private String value;
	
	private CategoriePizza(String value) {
		this.value = value;
	}
	
	public static CategoriePizza getCategorie(int numero) {
		if(numero == 1) {
			return CategoriePizza.VIANDE;
		}
		else if(numero == 2) {
			return CategoriePizza.SANS_VIANDE;
		}
		else {
			return CategoriePizza.POISSON;
		}
	}
	
	public String getValue() {
		return value;
	}
}
