import java.util.Arrays;

public class BinaryHeap {
    protected Comparable array[];
    int count;

    public BinaryHeap(int i) {
        array = new Comparable[i + 1];
    }

    public BinaryHeap(Comparable[] comparable) {
        this(comparable.length);

        for (int i = 0; i < comparable.length; i++)
            array[i + 1] = comparable[i];

        count = comparable.length;
        buildHeapTopDown();
        // buildHeapBottomUp();
    }

    private void buildHeapBottomUp() {
        for (int i = count / 2; i >= 1; i--) {
            percolateDown(i);
        }
    }

    private void buildHeapTopDown() {
        for (int i = 1; i <= count; i++) {
            percolateUp(i);
        }
    }

    private void percolateDown(int hole) {
        int child;
        Comparable tmp = array[hole];

        for (; hole * 2 <= count; hole = child) {
            child = hole * 2;
            if (child != count && array[child + 1].compareTo(array[child]) < 0)
                child++;
            if (array[child].compareTo(tmp) < 0)
                array[hole] = array[child];
            else
                break;
        }
        array[hole] = tmp;
    }

    private void percolateUp(int hole) {
        Comparable x = array[hole];
        for (; hole > 1 && x.compareTo(array[hole / 2]) < 0; hole /= 2)
            array[hole] = array[hole / 2];
        array[hole] = x;
    }

    public void purge() {
        while (count > 0)
            array[count--] = null;
    }

    public void enqueue(Comparable comparable) {
        int hole = ++count;
        // percolate up via a hole
        while (hole > 1 && array[hole / 2].compareTo(comparable) > 0) {
            array[hole] = array[hole / 2];
            hole = hole / 2;
        }
        array[hole] = comparable;
    }

    public Comparable findMin() {
        return array[1];
    }

    public Comparable dequeueMin() {
        Comparable minItem = array[1];
        array[1] = array[count];
        count--;
        percolateDown(1);
        return minItem;
    }

    public Comparable[] heapSort() {
        Comparable[] x = new Comparable[count];
        int total = count;
        for (int i = 0; i < total; i++) {
            x[i] = dequeueMin();
        }
        return x;
    }

    public boolean isFull() {
        return count == array.length - 1;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public String toString() {
        Comparable[] tempArray = new Comparable[array.length - 1];
        System.arraycopy(array, 1, tempArray, 0, array.length - 1);
        return Arrays.toString(tempArray);

    }

    public static void main(String[] args) {
        Integer[] a = { 10, 2, 8, 9, 1, 6, 3, 4, 0, 5 };
        System.out.println("The original array is: " + Arrays.toString(a));
        BinaryHeap bh = new BinaryHeap(a);
        // builds heap bottom up: change the constructor to build it top-down
        System.out.println("\nThe heap is: " + bh);
        System.out.println("\nSorted Array is: " + Arrays.toString(bh.heapSort()));
        BinaryHeap ph = new BinaryHeap(10);
        ph.enqueue(new Patient("Omar", 0));
        ph.enqueue(new Patient("Ali", 0));
        ph.enqueue(new Patient("Fadi", 0));
        ph.enqueue(new Patient("Zahra", 2));
        ph.enqueue(new Patient("Fatimah", 5));
        ph.enqueue(new Patient("Huda", 4));
        ph.enqueue(new Patient("Hady", 3));
        ph.enqueue(new Patient("Mustafa", 1));
        ph.enqueue(new Patient("Mohammed", 0));
        ph.enqueue(new Patient("Husni", 3));
        System.out.println("\nSorted patients from most urgent to least urgent:\n" + Arrays.toString(ph.heapSort()));
    }
}