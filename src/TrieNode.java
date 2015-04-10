import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Heyneken on 09.04.15.
 */
public class TrieNode implements ITrieNode {

    final private IMapFactory mapFactory;
    private Map<Comparable<Character>, ITrieNode> edgeMap;
    private ITrieNode parent;
    private Comparable ingoingPartialKey;



    public TrieNode(IMapFactory mapFactory, ITrieNode parent, Comparable ingoingPartialKey) {
        this.mapFactory = mapFactory;
        this.edgeMap = this.mapFactory.create();
        this.parent = parent;
        this.ingoingPartialKey = ingoingPartialKey;
    }

    public TrieNode(IMapFactory mapFactory) {
        this.mapFactory = mapFactory;

    }

    @Override
    public ITrieReference recursiveInsert(Iterator allCharacters, IActionAtInsert actionAtInsert) {
        if (allCharacters.hasNext()) {
            Comparable nextCharacter = (Comparable) allCharacters.next();
            Set set = this.edgeMap.keySet();
            if (set.contains(nextCharacter)) {
                return recursiveInsert(allCharacters, actionAtInsert);
            } else {
                ITrieNode temporaryTrieNode = new TrieNode(mapFactory, this, nextCharacter);
                this.edgeMap.put(nextCharacter, temporaryTrieNode);
                return recursiveInsert(allCharacters, actionAtInsert);
            }
        } else {
            // Aktueller Konten ist Endknoten
            if (edgeMap.isEmpty()) {
                return new TrieReference(false, 3); {
                }
            } else {

            }
        }
    }
}
