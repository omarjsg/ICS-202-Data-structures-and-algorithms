
public class Graduate extends Student {

	public Graduate(String id, double GPA) {
		super(id, GPA);
	}
	@Override
	public String getStatus() {
		if (getGPA() >= 3) {
			return "good";
		} else {
			return "probation";
		}
	}

	@Override
	public final void displayStudent() {
		System.out.printf("G%s\t| %.1f\t| %s%n", getId(), getGPA(), getStatus());

	}

}
