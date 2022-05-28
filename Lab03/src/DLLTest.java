
public class DLLTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DLL<String> test = new DLL<String>();
		for (int i = 0; i < 5; i++)
			test.addToTail("a" + i);
		System.out.print("Normal list: ");
		test.printAll();
		System.out.print("Reversed list: ");
		test.printReverse();
		DLL<Integer> integers = new DLL<>();
		integers.addToTail(3);
		integers.addToTail(1);
		integers.addToTail(2);
		integers.addToTail(5);
		integers.addToTail(8);
		integers.addToTail(7);
		integers.addToTail(9);
		integers.addToTail(0);
		System.out.print("The list before deletion: ");
		integers.printAll();
		for (int i = 0; i < 4; i++) {
			integers.delete7();
		}
		DLL<Integer> oldList = new DLL<>();
		oldList.addToTail(1);
		oldList.addToTail(2);
		oldList.addToTail(3);
		oldList.addToTail(4);
		System.out.print("Old list: ");
		oldList.printAll();
		DLL<Integer> newList = new DLL<>();
		newList.addToTail(5);
		newList.addToTail(6);
		newList.addToTail(7);
		newList.addToTail(8);
		System.out.print("New list: ");
		newList.printAll();
		DLL<Integer> alternatedList = oldList.insertAlternate(newList);
		System.out.print("Alternated list: ");
		alternatedList.printAll();
	}

}
