
public class SLLDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SLL<Integer> integerList = new SLL<Integer>();
		integerList.addToTail(3);
		integerList.addToTail(5);
		integerList.addToTail(4);
		integerList.addToTail(2);
		integerList.addToTail(9);
		integerList.printAll();
		integerList.insertBefore(5, 9);
		integerList.printAll();
		integerList.insertBefore(7, 5);
		integerList.printAll();
		integerList.insertBefore(8, 10);
		integerList.printAll();
		SLL<String> fruitList = new SLL<>();
		fruitList.addToTail("Apple");
		fruitList.addToTail("Mango");
		fruitList.addToTail("Banana");
		fruitList.addToTail("Peach");
		fruitList.addToTail("Watermelon");
		fruitList.printAll();
		fruitList.insertAfter("Kiwi", "Apple");
		fruitList.printAll();
		fruitList.insertBefore("Fruits", "Apple");
		fruitList.printAll();
		fruitList.insertBefore("Orange", "Banana");
		fruitList.printAll();
		fruitList.deleteBefore("Watermelon");
		fruitList.printAll();
		fruitList.deleteAfter("Watermelon");
		fruitList.printAll();
		SortedSLL<String> SortedList = new SortedSLL<>();
		SortedList.insert("Omar");
		SortedList.insert("Ahmed");
		SortedList.insert("Ali");
		SortedList.insert("Fadi");
		SortedList.insert("Hady");
		SortedList.insert("Said");
		SortedList.insert("Yahya");
		SortedList.insert("Jarallah");
		SortedList.insert("Othman");
		SortedList.printAll();
	}

}
