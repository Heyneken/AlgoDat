/**
 * Created by Heyneken on 09.04.15.
 */
public class StringCoding implements IActionAtInsert {

    public StringCoding (int value) {

    }

    @Override
    public Object actionAtKeyNotFound() {
        return null;
    }

    @Override
    public Object actionAtKeyFound(Object previous) {
        return null;
    }
}
