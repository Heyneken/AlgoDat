/**
 * Created by Heyneken on 09.04.15.
 */
public class StringCoding implements IActionAtInsert {

    /* Value of one entry in the dictionary */
    private int counter;

    public StringCoding(int start) {
        this.counter = start;
    }

    @Override
    public Object actionAtKeyNotFound() {
        return counter++;
    }

    @Override
    public Object actionAtKeyFound(Object previous) {
        return previous;
    }

    @Override
    public Object getValue() {
        return counter;
    }

    @Override
    public void setValue(Object newValue) {
        this.counter = (int) newValue;
    }

    @Override
    public String toString() {
        return "StringCoding{" + "counter = " + counter + '}';
    }

}
