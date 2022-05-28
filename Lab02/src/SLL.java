
public class SLL<T> {
	protected SLLNode<T> head, tail;

	public SLL() {
		head = tail = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addToHead(T element) {
		head = new SLLNode<T>(element, head);
		if (tail == null)
			tail = head;
	}

	public void addToTail(T element) {
		if (!isEmpty()) {
			tail.next = new SLLNode<T>(element);
			tail = tail.next;
		} else
			head = tail = new SLLNode<T>(element);
	}

	public T deleteFromHead() { // delete the head and return its info;
		if (isEmpty())
			return null;
		T element = head.data;
		if (head == tail) // if only one node on the list;
			head = tail = null;
		else
			head = head.next;
		return element;
	}

	public T deleteFromTail() { // delete the tail and return its info;
		if (isEmpty())
			return null;
		T element = tail.data;
		if (head == tail) // if only one node in the list;
			head = tail = null;
		else { // if more than one node in the list,
			SLLNode<T> tmp; // find the predecessor of tail;
			for (tmp = head; tmp.next != tail; tmp = tmp.next)
				;
			tail = tmp; // the predecessor of tail becomes tail;
			tail.next = null;
		}
		return element;
	}

	public void delete(T element) { // delete the node with an element el;
		if (!isEmpty())
			if (head == tail && element.equals(head.data)) // if only one
				head = tail = null; // node on the list;
			else if (element.equals(head.data)) // if more than one node on the list;
				head = head.next; // and el is in the head node;
			else { // if more than one node in the list
				SLLNode<T> pred, tmp;// and el is in a nonhead node;
				for (pred = head, tmp = head.next; tmp != null
						&& !tmp.data.equals(element); pred = pred.next, tmp = tmp.next)
					;
				if (tmp != null) { // if el was found;
					pred.next = tmp.next;
					if (tmp == tail) // if el is in the last node;
						tail = pred;
				}
			}
	}

	public void printAll() {
		System.out.print("[ ");
		for (SLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
			System.out.print(tmp.data + " ");
		System.out.print("]");
		System.out.println();
	}

	public boolean isInList(T el) {
		SLLNode<T> tmp;
		for (tmp = head; tmp != null && !tmp.data.equals(el); tmp = tmp.next)
			;
		return tmp != null;
	}

	public int length() {
		int length = 0;
		SLLNode<T> counter = head;
		while (counter != null) {
			length++;
			counter = counter.next;
		}
		return length;
	}

	public SLLNode<T> find(T element) {
		SLLNode<T> finder = head;
		while (finder != null) {
			if (finder.data == element) {
				return finder;
			}
			finder = finder.next;
		}
		System.out.println("WARNING: Element \"" + element + "\" does not exist in the linked list.");
		return null;
	}

	public void insertBefore(T newElem, T existingElem) {
		SLLNode<T> finder = find(existingElem);
		if (finder != null) {
			if (finder == head) {
				addToHead(newElem);
				return;
			}
			for (SLLNode<T> pointer = head; pointer != finder; pointer = pointer.next) {
				if (pointer.next.data.equals(existingElem)) {
					SLLNode<T> newNode = new SLLNode<T>(newElem);
					newNode.next = pointer.next;
					pointer.next = newNode;
					return;
				}
			}
		} else {
			System.out.println("Insertion failed");
			return;
		}
	}

	public void insertAfter(T newElem, T existingElem) {
		SLLNode<T> previousNode = find(existingElem);
		if (previousNode == null) {
			System.out.println("Insertion failed");
			return;
		}
		SLLNode<T> newNode = new SLLNode<T>(newElem);
		newNode.next = previousNode.next;
		previousNode.next = newNode;
	}

	public void deleteBefore(T element) {
		SLLNode<T> finder = find(element);
		if (finder != null) {
			if (finder == head) {
				System.out.println(
						"The element \"" + element + "\" is the head of the list, no element exists before it.");
			}
			for (SLLNode<T> pointer = head; pointer != finder; pointer = pointer.next) {
				if (pointer.next.next.data.equals(element)) {
					pointer.next = pointer.next.next;
					return;
				}
			}
		} else {
			return;
		}
	}

	public void deleteAfter(T element) {
		SLLNode<T> finder = find(element);
		if (finder != null) {
			if (finder == tail) {
				System.out.println(
						"The element \"" + element + "\" is the tail of the list, no element exists after it.");
			}
			for (SLLNode<T> pointer = head; pointer == finder; pointer = pointer.next) {
				if (pointer.data.equals(element)) {
					pointer.next = pointer.next.next;
					return;
				}
			}
		} else {
			return;
		}
	}
}
