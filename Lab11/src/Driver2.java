public class Driver2 {
    public static void main(String[] args) {
        Hashtable map = new Hashtable(13);
        map.insert(1);
        map.insert(2);
        map.insert(3);
        map.insert(4);
        map.insert(17);
        map.insert(30);
        map.insert(5);
        map.insert(6);
        map.insert(7);
        map.insert(8);
        map.insert(9);
        map.insert(22);
        map.insert(35);
        map.delete(4);
        map.insert(4);
        System.out.println(map.toString());
    }
}
