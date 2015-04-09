/**
 * Created by Heyneken on 09.04.15.
 */
public interface IActionAtInsert {

    public Object actionAtKeyNotFound();

    public Object actionAtKeyFound(Object previous);

}
