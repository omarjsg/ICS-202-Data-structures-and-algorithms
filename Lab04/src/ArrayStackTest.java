
public class ArrayStackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack as = new ArrayStack();
		as.push(1);
		as.push(13);
		as.push("Hello");
		System.out.println(as.toString());
		as.push("Hello");
		System.out.println(as.toString());
		as.pop();
		System.out.println(as.toString());
		as.clear();
		System.out.println(as.toString());
		System.out.println("Is the stack empty? " +as.isEmpty());
		as.push(10);
		as.push(2.5);
		as.push('c');
		System.out.println("Top element: " + as.topEl());
		System.out.println("Is the stack empty? " +as.isEmpty());
		System.out.println(as.toString());
		as.clear();
		System.out.println("Is the stack full? " +as.isFull());
		for (int i = 1; i <= 101; i++) {
			as.push(i);
		}
		System.out.println("Top element: " + as.topEl());
		System.out.println("Is the stack full? " +as.isFull());
	}

}
