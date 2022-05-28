
public class DLL<T> {
	private DLLNode<T> head, tail;

	public DLL() {
		head = tail = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void setToNull() {
		head = tail = null;
	}

	public T firstEl() {
		if (head != null)
			return head.data;
		else
			return null;
	}

	public void addToHead(T el) {
		if (head != null) {
			head = new DLLNode<T>(el, head, null);
			head.next.previous = head;
		} else
			head = tail = new DLLNode<T>(el);
	}

	public void addToTail(T el) {
		if (tail != null) {
			tail = new DLLNode<T>(el, null, tail);
			tail.previous.next = tail;
		} else
			head = tail = new DLLNode<T>(el);
	}

	public T deleteFromHead() {
		if (isEmpty())
			return null;
		T el = head.data;
		if (head == tail) // if only one node on the list;
			head = tail = null;
		else { // if more than one node in the list;
			head = head.next;
			head.previous = null;
		}
		return el;
	}

	public T deleteFromTail() {
		if (isEmpty())
			return null;
		T el = tail.data;
		if (head == tail) // if only one node on the list;
			head = tail = null;
		else { // if more than one node in the list;
			tail = tail.previous;
			tail.next = null;
		}
		return el;
	}

	public void printAll() {
		if (isEmpty()) {
			System.out.println("Error: the list is empty.");
			return;
		}
		for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
			System.out.print(tmp.data + " ");
		System.out.println();
	}

	public void printReverse() {
		for (DLLNode<T> tmp = tail; tmp != null; tmp = tmp.previous) {
			System.out.print(tmp.data + " ");
		}
		System.out.println();
	}

	public T find(T el) {
		DLLNode<T> tmp;
		for (tmp = head; tmp != null && !tmp.data.equals(el); tmp = tmp.next)
			;
		if (tmp == null)
			return null;
		else
			return tmp.data;
	}

	public void insertAfter(T newElem, DLLNode<T> existingNode) {
		if (existingNode == null) {
			System.out.println("Insertion failed");
			return;
		}
		DLLNode<T> newNode = new DLLNode<T>(newElem);
		newNode.next = existingNode.next;
		existingNode.next = newNode;
	}

	public int length() {
		int length = 0;
		DLLNode<T> counter = head;
		while (counter != null) {
			length++;
			counter = counter.next;
		}
		return length;
	}

	public void delete7() {
		int moves = 7 - 1;
		if (isEmpty()) {
			System.out.println("The list is empty");
			return;
		} else if (length() == 1) {
			System.out.println("Element " + head.data + " is deleted");
			setToNull();
			return;
		}
		DLLNode<T> pointer = head;
		pointer = loopUntilFind(pointer, moves);
		if (pointer == tail) {
			System.out.println("Element " + pointer.data + " is deleted");
			deleteFromTail();
			System.out.print("List after deletion: ");
			printAll();
			return;
		} else if (pointer == head) {
			System.out.println("Element " + pointer.data + " is deleted");
			deleteFromHead();
			System.out.print("List after deletion: ");
			printAll();
			return;
		} else {
			System.out.println("Element " + pointer.data + " is deleted");
			pointer.previous.next = pointer.next;
			pointer.next.previous = pointer.previous;
			System.out.print("List after deletion: ");
			printAll();
		}

	}

	public void deleteNth(int n) {
		int moves = n - 1;
		if (isEmpty()) {
			System.out.println("The list is empty");
			return;
		} else if (length() == 1) {
			System.out.println("Element " + head.data + " is deleted");
			setToNull();
			return;
		}
		DLLNode<T> pointer = head;
		pointer = loopUntilFind(pointer, moves);
		if (pointer == tail) {
			System.out.println("Element " + pointer.data + " is deleted");
			deleteFromTail();
			System.out.print("List after deletion: ");
			printAll();
			return;
		} else if (pointer == head) {
			System.out.println("Element " + pointer.data + " is deleted");
			deleteFromHead();
			System.out.print("List after deletion: ");
			printAll();
			return;
		} else {
			System.out.println("Element " + pointer.data + " is deleted");
			pointer.previous.next = pointer.next;
			pointer.next.previous = pointer.previous;
			System.out.print("List after deletion: ");
			printAll();
		}

	}

	public DLLNode<T> loopUntilFind(DLLNode<T> pointer, int moves) {
		for (pointer = head; pointer != tail && moves >= 1; moves--) {
			pointer = pointer.next;
		}
		if (moves >= 1) {
			for (pointer = tail; pointer != head && moves >= 1; moves--) {
				pointer = pointer.previous;
			}
		}
		if (moves <= 1) {
			return pointer;
		} else {
			return loopUntilFind(pointer, moves);
		}
	}

	public DLL<T> insertAlternate(DLL<T> newList) {
		DLLNode<T> newListPointer = newList.head;
		DLL<T> Alternated = new DLL<>();
		if (length() == newList.length()) {
			DLLNode<T> pointer = head;
			for (int i = 0; i < length(); i++) {
				Alternated.addToTail(pointer.data);
				pointer = pointer.next;
			}
			int i = 0;
			for (DLLNode<T> thisPointer = Alternated.head; i < newList.length() && thisPointer != null; i++) {
				insertAfter(newListPointer.data, thisPointer);
				thisPointer = thisPointer.next.next;
				newListPointer = newListPointer.next;
			}
			return Alternated;

		} else {
			System.out.println("Error: inserted lists lengths are not equivalent.");
			return Alternated;
		}
	}
}
