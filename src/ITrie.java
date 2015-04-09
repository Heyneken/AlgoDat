import java.util.Iterator;

/**
 * Created by Heyneken on 09.04.15.
 */
public interface ITrie {

    public ITrieReference insert(Iterator<Character> iterator, IActionAtInsert actionAtInsert);

    public ITrieReference insert(String string, IActionAtInsert actionAtInsert);

}
