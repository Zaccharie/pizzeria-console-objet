package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.StockageException;

abstract class OptionMenu {
	
	protected String libelle;
	protected Scanner scan;
	protected PizzaDaoImpl dao;
	
	
	public OptionMenu(PizzaDaoImpl dao, Scanner scan, String libelle) {
		// TODO Auto-generated constructor stub
		this.libelle = libelle;
		this.dao = dao;
		this.scan = scan;
	}
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}	

	public abstract void execute() throws StockageException;

}
