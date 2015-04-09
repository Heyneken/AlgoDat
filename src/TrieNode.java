import java.util.Iterator;
import java.util.Map;

/**
 * Created by Heyneken on 09.04.15.
 */
public class TrieNode implements ITrieNode {

    final private IMapFactory mapFactory;
    private Map outgoingEdgeMap;
    private ITrieNode parent;
    private Comparable ingoingPartialKey;

    public TrieNode(IMapFactory mapFactory, ITrieNode parent, Comparable ingoingPartialKey) {
        this.mapFactory = mapFactory;
        this.outgoingEdgeMap = this.mapFactory.create();
        this.parent = parent;
        this.ingoingPartialKey = ingoingPartialKey;
    }

    public TrieNode(IMapFactory mapFactory) {
        this.mapFactory = mapFactory;
    }

    @Override
    public ITrieReference recursiveInsert(Iterator iterator, IActionAtInsert actionAtInsert) {
        return null;
    }
}
