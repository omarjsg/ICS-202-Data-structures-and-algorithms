public class Entry {
    public Object dataObject;
    public String status;

    public Entry() {
        status = "E";
    }

    @Override
    public String toString() {

        return String.format("|%-10s", dataObject.toString());
    }

    public int hash() {
        return dataObject.hashCode();
    }
}