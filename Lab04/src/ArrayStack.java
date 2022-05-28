
public class ArrayStack {
	private Object arr[] = new Object[100];
	private int top = -1;

	public ArrayStack() {
	}

	public void clear() {
		for (int index = 0; index < arr.length; index++) {
			arr[index] = null;
		}
		top = -1;
	}

	public boolean isEmpty() {
		for (int index = 0; index < arr.length; index++) {
			if (arr[index] != null) {
				return false;
			}
		}
		return true;
	}

	public Object topEl() {
		if (isEmpty())
			throw new java.util.EmptyStackException();
		return arr[top];
	}

	public Object pop() {
		if (isEmpty())
			throw new java.util.EmptyStackException();
		return arr[top--];
	}

	public void push(Object el) {
		if(!isFull()) {
		arr[++top] = el;
		} else {
			System.err.println("Error: Stack is full, cannot add more elements.");
		}
	}

	public boolean isFull() {
		return top == arr.length - 1;
	}
	public String toString() {
		String str = "";
		if (!isEmpty()) {
			for (int index = 0; index <= top; index++) {
				str += arr[index]+ " ";
			}
		} else {
			return "Stack is empty";
		}
		return str;
	}
}
