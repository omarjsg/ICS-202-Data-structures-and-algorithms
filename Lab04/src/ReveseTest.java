
public class ReveseTest {
	public static void main(String[] args) {
		Stack s = new Stack();
		Queue queue = new Queue();
		String str = new String("Wlcome to ICS 202");
		for (int index = 0; index < str.length(); index++) {
			s.push(str.charAt(index));
		}
		System.out.println("Reversing the stack using queue:");
		System.out.println("Previous String: " + str);
		System.out.println("Reversing the String...");
		while(!s.isEmpty()) {
			queue.enqueue(s.pop());
		}
		while (!queue.isEmpty()) {
			System.out.print(queue.dequeue());
		}
	}
}
