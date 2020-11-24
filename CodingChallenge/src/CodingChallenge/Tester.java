package CodingChallenge;

public class Tester {//Klasse zum Modultesten
	
	public static void main(String[] args) {
		//Modultest-Methode einfügen (gewünschte Ausgabe in der jeweiligen Methode nachlesen)
	}
	
	public static void testSell() {
		Customer kunde = new Customer("Max Mustemann", 40);
		Book buch1 = new Book("Ein verheißenes Land", 42, 1024, 9783328600626L, "Biography");
		Book buch2 = new Book("Ein verheißenes Land", 9.99, 1024, 9783328600626L, "Biography");
		Shop shop = new Shop("Musterladen");
		shop.giveBook(buch1);
		shop.giveBook(buch2);
		shop.sellBook(kunde, buch1); //erzeugt Fehlerfall Preis des Buches zu hoch
		System.out.println(shop.sellBook(kunde, buch2)); //sollte true ausgeben
		shop.sellBook(kunde, buch2); //erzeugt Fehlerfall kein Buch im Shop gefunden (wenn buch2 vorher entfernt wurde)
		System.out.println(kunde.getMoney()); //Wenn korrekt verkauft wurde hat der Kunde noch 30.01€
	}
	
	public static void testFilter() {
		Book buch1 = new Book("Ein verheißenes Land", 42, 1024, 9783328600626L, "Biography");
		Book buch2 = new Book("Ein Abenteuerbuch", 10, 10, 9783328600626L, "Adventure");
		Shop shop = new Shop("Musterladen");
		shop.giveBook(buch1);
		shop.giveBook(buch2);
		for(Book book : shop.getBooks("Adventure")) {//Sollte genau das eine Abenteuerbuch ausgeben
			System.out.println(book.toString());
		}
	}
	
	public static void testDuplikate() {
		Book buch1 = new Book("Ein verheißenes Land", 42, 1024, 9783328600626L, "Biography");
		Book buch2 = new Book("Ein Abenteuerbuch", 10, 10, 9783328600626L, "Adventure");
		Shop shop = new Shop("Musterladen");
		shop.giveBook(buch1);
		shop.giveBook(buch2);
		shop.giveBook(buch1);
		for(Book book : shop.getUniqueBooks()) {//Sollte die beiden Bücher dublikatfrei ausgeben
			System.out.println(book.toString());
		}
	}
	
	public static void testVergleich() {
		Book buch1 = new Book("Ein verheißenes Land", 42, 1024, 9783328600626L, "Biography");
		Book buch2 = new Book("Ein Abenteuerbuch", 10, 10, 9783328600626L, "Adventure");
		Book buch3 = new Book("Noch ein Buch", 10, 10, 9783328600626L, "Adventure");
		Shop shop1 = new Shop("Musterladen");
		Shop shop2 = new Shop("Saftladen");
		shop1.giveBook(buch1);
		shop1.giveBook(buch2);
		shop1.giveBook(buch1);
		shop1.giveBook(buch2);
		shop2.giveBook(buch1);
		shop2.giveBook(buch2);
		System.out.println(shop1.equals(shop2)); //sollte true ausgeben
		shop1.giveBook(buch3);
		System.out.println(shop1.equals(shop2)); //sollte false ausgeben
	}
	
	public static void testHinzufügen() {
		Book buch1 = new Book("Testbuch1", 42, 1024, 9783608963762L, "Adventure");
		Book buch2 = new Book("Fehlerbuch Prüfziffer falsch", 42, 1024, 9783442267747L, "Adventure");
		Book buch3 = new Book("Fehlerbuch zu kurze ISBN", 42, 1024, 978758245159L, "Adventure");
		Book buch4 = new Book("Testbuch2", 42, 1024, 9783841335180L, "Adventure");
		Book buch5 = new Book("Testbuch3", 42, 1024, 9783608963762L, "Adventure");
		Book buch6 = new Book("Fehlerbuch Präfix falsch", 42, 1024, 1110000000005L, "Adventure");
		Shop shop = new Shop("Musterladen");
		shop.giveBook(buch1);
		shop.giveBook(buch2);
		shop.giveBook(buch3);
		shop.giveBook(buch4);
		shop.giveBook(buch5);
		shop.giveBook(buch6);
		for(Book book : shop.getUniqueBooks()) {//Sollte die Testbücher ausgeben
			System.out.println(book.toString());
		}
	}
}
