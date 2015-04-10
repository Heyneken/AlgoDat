import java.util.Iterator;

/**
 * Created by Heyneken on 09.04.15.
 */
public interface ITrieNode {

    public ITrieReference recursiveInsert(Iterator allCharacters, IActionAtInsert actionAtInsert);

}
