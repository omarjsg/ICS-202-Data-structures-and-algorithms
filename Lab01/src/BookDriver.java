
public class BookDriver {

	public static void main(String[] args) {
		Book[] books = new Book[10];
		int nBooks = 0, nTextBooks = 0;
		books[0] = new Book("Promise NeverLand", 599);
		books[1] = new TextBook("Data Structures And Algorithms In Java", 802, "ICS201");
		books[2] = new Book("Seven deadly sins", 306);
		books[3] = new TextBook("Writing for professional nneds", 347, "IAS201");
		books[4] = new Book("Diamond ace", 243);
		books[5] = new TextBook("Advanced English", 130, "ENGL003");
		books[6] = new Book("Digital art using Procreate v4.6", 167);
		books[7] = new TextBook("Discrete Mathematics", 1389, "ICS253");
		books[8] = new Book("Deadly prison", 249);
		books[9] = new TextBook("Computer Organiation and Design", 955, "ICS233");
		for (Book book : books) {
			System.out.println(book);
			if (book instanceof TextBook) {
				nTextBooks++;
			}
			if (book instanceof Book) {
				nBooks++;
			}
		}
		System.out.printf("Number of books = %d, number of textbooks = %d", nBooks, nTextBooks);

	}

}
