public class Hashtable {
	private Entry[] entry;
	private int n;
	private int occupied;

	public Hashtable() {
		n = 100;
		entry = new Entry[n];
		for (int i = 0; i < n; i++) {
			Entry newEntry = new Entry();
			entry[i] = newEntry;
		}
		occupied = 0;
	}

	public Hashtable(int n) {
		this.n = n;
		entry = new Entry[n];
		for (int i = 0; i < n; i++) {
			Entry newEntry = new Entry();
			entry[i] = newEntry;
		}
		occupied = 0;
	}

	private int getHash(Object o) {
		return (o.hashCode()) % n;
	}

	public int findNextVacantSlot(Object o) {
		int hash = getHash(o);
		if (occupied == n)
			return hash;
		while (entry[hash].status != "E" && entry[hash].hash() != o.hashCode()) {
			System.out.println("Collision at position " + hash + ". Linear probing");
			hash = (hash + 1) % n;
		}
		return hash;
	}

	public boolean insert(Object o) {
		int hash = findNextVacantSlot(o);
		if (entry[hash].status != "O") {
			entry[hash].dataObject = o;
			entry[hash].status = "O";
			occupied += 1;
			return true;
		}
		return false;
	}

	public int isPresent(Object o) {
		int hash = getHash(o);
		int iterations = 0;
		while (iterations < n && entry[hash].status != "E" && entry[hash].hash() != o.hashCode()) {
			System.out.println("The status at position " + hash + " is " + entry[hash].status + ". Linear probing");
			hash = (hash + 1) % n;
			iterations += 1;
		}
		if (entry[hash].status == "O" && entry[hash].hash() == o.hashCode())
			return hash;

		return -1;
	}

	public boolean find(Object o) {
		int i = isPresent(o);
		if (i == -1)
			return false;
		return true;
	}

	public boolean delete(Object o) {
		int index = isPresent(o);
		if (index != -1) {
			entry[index].status = "D";
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String up = "", cell = "", bottom = "";
		System.out.println("Table:");
		for (int i = 0; i < n; i++) {
			if (entry[i].status == "O") {
				up = up + " __________";
				cell = cell + entry[i].toString();
				bottom = bottom + "|__________";
			}
		}
		if (!cell.equals("")) {
			return up + "" + "\n" + cell + "|" + "\n" + bottom + "|\n";
		} else {
			return "Empty";
		}
	}
}