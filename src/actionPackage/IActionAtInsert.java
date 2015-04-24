package actionPackage;

/**
 * Created by Heyneken on 09.04.15.
 */
public interface IActionAtInsert {

    Object trieNodeNotFound();

    Object trieNodeFound(Object previous);

    int getValue();

    void setValue(Integer value);

}
