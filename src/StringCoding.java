/**
 * Created by Heyneken on 09.04.15.
 */
public class StringCoding implements IActionAtInsert {

    /* Code (Wert) eines Schlüsselendknotens */
    private int counter;

    public StringCoding(int start) {
        this.counter = start;
    }

    @Override
    public Object trieNodeNotFound() {
        return counter++;
    }

    @Override
    public Object trieNodeFound(Object parentNode) {
        return parentNode;
    }

    @Override
    public int getValue() {
        return counter;
    }

    @Override
    public void setValue(int newValue) {
        this.counter = newValue;
    }

    @Override
    public String toString() {
        return "StringCoding{" + "counter = " + counter + '}';
    }

}
