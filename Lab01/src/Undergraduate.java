
public class Undergraduate extends Student {

	public Undergraduate(String id, double GPA) {
		super(id, GPA);
	}

	@Override
	public String getStatus() {
		if (getGPA() >= 3 && getGPA() <= 4) {
			return "honor";
		} else if (getGPA() < 3 && getGPA() <= 2) {
			return "good";
		} else {
			return "probation";
		}
	}

	@Override
	public final void displayStudent() {
		System.out.printf("S%s\t| %.1f\t| %s%n", getId(), getGPA(), getStatus());

	}

}
