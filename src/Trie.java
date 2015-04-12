import java.util.Iterator;

/**
 * Created by Heyneken on 09.04.15.
 */
public class Trie implements ITrie {

    final private ITrieNode root;

    public Trie(IMapFactory mapFactory) {
        this.root = new TrieNode(mapFactory);
    }

    @Override
    public ITrieReference insert(Iterator<Comparable<Character>> allCharacters, IActionAtInsert actionAtInsert) {
        return root.recursiveInsert(allCharacters, actionAtInsert);
    }

    @Override
    public ITrieReference insert(String string, IActionAtInsert actionAtInsert) {
        return insert(Helper.createIterator(string), actionAtInsert);
    }
}
