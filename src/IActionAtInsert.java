/**
 * Created by Heyneken on 09.04.15.
 */
public interface IActionAtInsert {

    public Object actionAtKeyNotFound();
    public Object actionAtKeyFound(Object previous);
    public Object getValue();
    public void setValue(Object value);

}
