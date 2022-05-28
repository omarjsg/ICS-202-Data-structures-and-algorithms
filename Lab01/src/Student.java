
public abstract class Student {
	private String id;
	private double GPA;

	public Student(String id, double GPA) {
		setId(id);
		setGPA(GPA);
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double gPA) {
		GPA = gPA;
	}

	public abstract String getStatus();

	public abstract void displayStudent();

}
