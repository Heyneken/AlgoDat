import java.util.Iterator;

/**
 * Created by Heyneken on 09.04.15.
 */
public class Trie implements ITrie{

    private IMapFactory mapFactory;
    final private ITrieNode root;

    public Trie(IMapFactory mapFactory) {
        root = new TrieNode(mapFactory);
    }

    @Override
    public ITrieReference insert(Iterator<Character> iterator, IActionAtInsert actionAtInsert) {
        return null;
    }

    @Override
    public ITrieReference insert(String string, IActionAtInsert actionAtInsert) {
        return null;
    }
}
