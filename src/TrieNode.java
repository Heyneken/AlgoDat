import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Heyneken on 09.04.15.
 */
public class TrieNode implements ITrieNode {

    final private IMapFactory mapFactory;
    private Map<Comparable<Character>, ITrieNode> edgeMap;
    private TrieNode parent;
    private Comparable edgeName;
    private Integer value;

    /*
    Konstruiert einen Zwischenknoten
     */
    public TrieNode(IMapFactory mapFactory, TrieNode parent, Comparable edgeName) {
        this.mapFactory = mapFactory;
        this.edgeMap = this.mapFactory.create();
        this.parent = parent;
        this.edgeName = edgeName;
        this.value = null;
    }

    /*
    Konstruiert einen Wurzelknoten
     */
    public TrieNode(IMapFactory mapFactory) {
        this.mapFactory = mapFactory;
        this.edgeMap = this.mapFactory.create();
        this.value = null;
    }

    /**
     *
     * @param allCharacters
     * @param actionAtInsert
     * @return
     */
    @Override
    public ITrieReference recursiveInsert(Iterator allCharacters, IActionAtInsert actionAtInsert) {
        /*
        Es wird nur dann ein einzelner Character des Iterators abgefragt, sofern noch nicht alle Characters des
        Iterators überprüft wurden.
         */
        if (allCharacters.hasNext()) {
            Comparable nextCharacter = (Comparable) allCharacters.next();
            Set set = this.edgeMap.keySet();
            /*
            Ist die Abfolge der Knoten bereits vorhanden, geht der Iterator einen Schritt weiter, ohne einen
            neuen "Abzweigung" anzulegen.
            */
            if (set.contains(nextCharacter)) {
                return edgeMap.get(nextCharacter).recursiveInsert(allCharacters, actionAtInsert);
            }
            /*
            Ist die Abfolge der Knoten noch nicht vorhanden, wird ein neuer TrieNode mit, welcher eine neue "Abzweigung"
            darstellt, instanziert. Auch hier geht der Iterator einen Schritt vorwärts.
             */
            else {
                TrieNode childTrieNode = new TrieNode(mapFactory, this, nextCharacter);
                System.out.println(childTrieNode.edgeName.toString());
                edgeMap.put(nextCharacter, childTrieNode);
                return childTrieNode.recursiveInsert(allCharacters, actionAtInsert);
            }
        }
        else {
            /*

             */
            if (value == null) {
                actionAtInsert.trieNodeNotFound();
                this.setValue(actionAtInsert.getValue());
                System.out.println(value);
                return new TrieReference(false, actionAtInsert.getValue(), this);
            }
            /*

             */
            else {
                actionAtInsert.trieNodeFound(this);
                return new TrieReference(true, actionAtInsert.getValue(), this);
            }
        }

    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public Comparable getEdgeName() {
        return edgeName;
    }

    public Map<Comparable<Character>, ITrieNode> getEdgeMap() {
        return edgeMap;
    }

    /**
     *
     * @param string
     * @param actionAtInsert
     * @return
     */
    @Override
    public ITrieReference recursiveInsert(String string, IActionAtInsert actionAtInsert) {
        return recursiveInsert(Helper.createIterator(string), actionAtInsert);
    }

}
