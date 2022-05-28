
public class DLLNode<T> {
    public T data;
    public DLLNode<T> next, previous;
    public DLLNode() {
		next = null;
		previous = null;
    }
    public DLLNode(T el) {
        data = el; next = null; previous = null;
    }
    public DLLNode(T el, DLLNode<T> n, DLLNode<T> p) {
        data = el; next = n; previous = p; 
    }
}
