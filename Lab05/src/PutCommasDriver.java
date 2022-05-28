public class PutCommasDriver {
    public static void main(String[] args) {
        System.out.println(putCommas(1234567));
    }
    public static String putCommas(int x){
        String strX = "" + x;
        if(x < 999){
            return strX;
        } else {
            return putCommas(Integer.parseInt(strX.substring(0, strX.length() - 3))) + "," + strX.substring(strX.length() - 3);
        }
    }
}
