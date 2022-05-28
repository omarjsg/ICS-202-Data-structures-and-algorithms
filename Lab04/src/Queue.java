public class Queue {
    private java.util.LinkedList<Object> list = new java.util.LinkedList<Object>();
    
    public Queue() {
    }
    
    public void clear() {
        list.clear();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public Object firstEl() {
        return list.getFirst();
    }
    
    public Object dequeue() {
        return list.removeFirst();
    }
    
    public void enqueue(Object el) {
        list.add(el);
    }
    
    public String toString() {
        return list.toString();
    }
}
