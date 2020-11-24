package CodingChallenge;

import java.util.LinkedList;
import java.util.List;

public class Shop {
	private String name;
	private List<Book> books;
	private double umsatz;
	
	public Shop(String name) {
		this.name = name;
		books = new LinkedList<Book>();
		umsatz=0;
	}
	
	/**
     * Die Getter Methoden
     */
	public String getName() {
		return name;
	}
	public List<Book> getBooks() {
		return books;
	}
	public double getUmsatz() {
		return umsatz;
	}
	
	/**
     * Verkauft dem Kunden ein Buch
     * @return gibt true zurück, wenn das Buch erfolgreich verkauft wurde
     */
	public boolean sellBook(Customer customer, Book book) {
		if( customer.giveMoney(- book.getPrice()) ) {
			if( books.remove(book) ) {
				umsatz += book.getPrice();
				customer.giveBook(book);
				return true;
			}
			else {
				customer.giveMoney(book.getPrice());
				System.out.println("Es wurde kein Buch wie das übergebene Buch in diesem Shop gefunden.");
			}
		}
		else {
			System.out.println("Der Preis des Buches ist höher als das Geld des Kunden");
		}
		return false;
	}
	
	/**
     * Gibt die Liste aller Bücher des übergebenen Genres des Shops aus
     * @return eine Liste aller Bücher des übergebenen Genres des Shops
     */
	public List<Book> getBooks(String genre) {
		List<Book> dummy = new LinkedList<Book>();
		for(Book book : books) {
			dummy.add(book);
		}
		for(int i=0; i<dummy.size(); i++)
		{
			if( ! dummy.get(i).getGenre().equals(genre) ) {
				dummy.remove(i);
			i--;
			}
		}
		return dummy;
	}
	
	/**
     * Gibt eine dublikatfreie Liste Bücher des Shops aus
     * @return eine dublikatfreie Liste aller Bücher des Shops
     */
	public List<Book> getUniqueBooks() {
		List<Book> dummy = new LinkedList<Book>();
		for(Book book : books) {
			dummy.add(book);
		}
		for(int i=0; i<dummy.size(); i++)
		{
			for(int j=i+1; j<dummy.size(); j++)
			{
				if( dummy.get(j).equals(dummy.get(i)) ) {
					dummy.remove(j);
				}
			}
		}
		return dummy;
	}
	
	/**
     * Gibt dem Shop das übergebene Buch, falls es eine gültige ISBN hat
     */
	public void giveBook(Book book) {
		if(book.hasValidISBN() ) {
			this.books.add(book);
		}
	}
	
	/**
     * Gibt dem Shop die übergebenen Bücher, falls sie eine gültige ISBN haben
     */
	public void giveBooks(List<Book> books) {
		for(Book book : books) {
			giveBook(book);
		}
	}
	
	/**
	 * Vergleicht zwei Shops miteinander
     * @return true, wenn die Shops die gleichen Bücher anbieten
     */
	public boolean equals(Shop shop) {
		for(Book book : books) {
			if(!shop.getBooks().contains(book)) {
				return false;
			}
		}
		for(Book book : shop.getBooks()) {
			if(!books.contains(book)) {
				return false;
			}
		}
		return true;
	}
}
