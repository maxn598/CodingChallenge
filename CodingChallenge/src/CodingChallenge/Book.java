package CodingChallenge;

public class Book {
	private String titel;
	private double price;
	private int pages;
	private long ISBN;
	private String genre;
	
	public Book(String titel, double price, int pages, long ISBN, String genre) {
		this.titel = titel;
		this.price = Math.floor(price * 100) / 100.0;
		this.pages = pages;
		this.ISBN = ISBN;
		this.genre = genre;
	}
	
	/**
     * Die Getter Methoden
     */
	public String getTitel() {
		return titel;
	}
	public double getPrice() {
		return price;
	}
	public int getPage() {
		return pages;
	}
	public String getGenre() {
		return genre;
	}
	public long getISBN() {
		return ISBN;
	}
	
	/**
     * Überprüft, ob das Buch eine gültige ISBN-13 Nummer hat
     * @return true, wenn das Buch eine gültige ISBN-13 Nummer hat
     */
	public boolean hasValidISBN() {
		if(ISBN < 0){return false;}
		int length = (int)Math.log10(ISBN) + 1; //Länge der ISBN
		int[] ISBNArray = new int[length];	//Array aus einzelnen Zahlen der ISBN, um geziehlt auf jede Zahl zugreifen zu können
		if( length == 13 && ISBNArray[0] == 9 && ISBNArray[1] == 7 && (ISBNArray[2] == 8 || ISBNArray[2] == 9) ) {	//ISBN-13 ist 13 Stellige Zahl, Präfix 978 oder 979
			for(int i=1; i<=length; i++) {
				ISBNArray[length - i] = (int)( (ISBN % Math.pow(10, i)) * 10 / Math.pow(10.0, i) );
			}
			int pruefzahl = 0;
			for(int i = 0; i < 12; i++) { //Berechne die prüfziffer
				if(i%2 == 0) {
					pruefzahl += ISBNArray[i];
				}
				else {
					pruefzahl += 3*ISBNArray[i];
				}
			}
				return ISBNArray[12] == (10 - pruefzahl%10)%10 ;	//Prüfziffer überprüfen
		}
		return false;
	}
	
	/**
     * Vergleicht das Buch mit dem übergebenen Buch
     * @return true, wenn das Buch gleiche Attribute wie das übergebene Buch hat
     */
	public boolean equals(Book book) {
		if( titel.equals(book.getTitel()) && price == book.getPrice() && pages == book.getPage() && genre.equals(book.getGenre()) ) {
			return true;
		}
		return false;
	}
	
	/**
     * Gibt einen Sinnvollen Text aus, der die Attribute des Buches enthält.
     */
	public String toString() {
		return "Titel:\t"+titel+"\nPreis:\t"+price+"€\nSeitenzahl: "+pages+"\nISBN:\t"+ISBN+"\nGenre:\t"+genre+"\n";
	}
}
