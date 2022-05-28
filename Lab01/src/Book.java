
public class Book {
	private String title;
	private int pages;

	public Book(String title, int pages) {
		this.title = title;
		this.pages = pages;
	}

	public String getTitle() {
		return title;
	}

	public int getPages() {
		return pages;
	}

	@Override
	public String toString() {
		return String.format("Book title: %s, number of pages: %d.%n", getTitle(), getPages());
	}
}
