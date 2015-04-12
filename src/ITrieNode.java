import java.util.Iterator;

/**
 * Created by Heyneken on 09.04.15.
 */
public interface ITrieNode {

    ITrieReference recursiveInsert(Iterator<Comparable<Character>> allCharacters, IActionAtInsert actionAtInsert);

    ITrieReference recursiveInsert(String string, IActionAtInsert actionAtInsert);
}
