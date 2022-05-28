
public class TextBook extends Book {
	private String course;

	public TextBook(String title, int pages, String course) {
		super(title, pages);
		this.course = course;
	}

	public String getTitle() {
		return super.getTitle() + ", course: " + getCourse();
	}

	public String getCourse() {
		return course;
	}
}
