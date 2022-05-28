import java.text.DecimalFormat;
import java.util.Random;

public class StudentDriver {

	public static void main(String[] args) {
		Random random = new Random();
		Student[] students = new Student[10];
		DecimalFormat myFormatter = new DecimalFormat("00000000");
		System.out.println("ID\t\t| GPA\t| Status");
		System.out.println("----------------|-------|----------");
		for (int index = 0; index < 10; index++) {
			{
				int randomStudent = random.nextInt(2) + 1;
				if (randomStudent == 1) {
					students[index] = new Undergraduate(myFormatter.format((int) (Math.random()*(20219999 - 20042704)+20042704))+"0", random.nextDouble() * 4);
					students[index].displayStudent();
				} else if (randomStudent == 2) {
					students[index] = new Graduate(myFormatter.format((int) (Math.random()*(20219999 - 19886666)+19886666))+"0", random.nextDouble() * 4);
					students[index].displayStudent();
				}
			}
		}
	}

}
