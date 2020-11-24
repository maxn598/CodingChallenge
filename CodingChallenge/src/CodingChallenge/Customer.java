package CodingChallenge;

import java.util.LinkedList;

public class Customer {
	private String name;
	private LinkedList<Book> books;
	private double money;	//das dem Kunden zu verfügung stehende Geld
	
	public Customer(String name) {
		this.name = name;
		books = new LinkedList<Book>();
		this.money = 0;
	}
	public Customer(String name, double money) {
		this.name = name;
		books = new LinkedList<Book>();
		this.money = Math.floor(money * 100) / 100.;
	}
	
	/**
     * Die Getter Methoden
     */
	public double getMoney() {
		return money;
	}
	public String getName() {
		return name;
	}
	
	/**
     * gibt dem Kunden die übergebene Geldmenge, bzw. nimmt wenn Übergabewert negativ ist
     * @return true, wenn die Transaktion erfolgreich war (also der Kunde genug Geld hatte)
     */
	public boolean giveMoney(double amount) {
		amount = Math.floor(amount * 100) / 100.0;
		if( money >= -amount ) {
			money += amount;
			money = Math.round(money*100)/100.0;
			return true;
		}
		return false;
	}
	
	/**
     * Gibt dem Kunden das übergebene Buch
     */
	public void giveBook(Book book) {
		books.add(book);
	}
}
