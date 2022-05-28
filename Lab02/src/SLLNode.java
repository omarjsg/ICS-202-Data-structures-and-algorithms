
public class SLLNode<T> {
	public T data;
	public SLLNode<T> next;

	public SLLNode() {
		this(null, null);
	}

	public SLLNode(T el) {
		this(el, null);
	}

	public SLLNode(T element, SLLNode<T> ptr) {
		data = element;
		next = ptr;
	}
}
