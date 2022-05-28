public class LengthDriver {
    public static void main(String[] args) {
        String[] array = {"apple", "mango", "banana", "nut", "watermelon"};
        System.out.println("The smallest string in the array is: " + findSmallest(array, 0));
        System.out.println("The largest string in the array is: " + findLongest(array, 0));
    }
    public static String findSmallest(String[] array, int index){
        array = array.clone();
        if(index < array.length - 1){
            if (array[0].length() > array[index].length()) {
                array[0] = array[index];
                return findSmallest(array, index + 1);
            } else {
                return findSmallest(array, index + 1);
            }
        } else {
            if (array[0].length() > array[index].length()) {
                return array[index];
            } else {
                return array[0];
            }
        }
    }
    public static String findLongest(String[] array, int index){
        array = array.clone();
        if(index < array.length - 1){
            if (array[0].length() < array[index].length()) {
                array[0] = array[index];
                return findLongest(array, index + 1);
            } else {
                return findLongest(array, index + 1);
            }
        } else {
            if (array[0].length() < array[index].length()) {
                return array[index];
            } else {
                return array[0];
            }
        }
    }
}
