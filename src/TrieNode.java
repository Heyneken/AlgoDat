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


    /*
    Konstruiert einen Zwischenknoten
     */
    public TrieNode(IMapFactory mapFactory, ITrieNode parent, Comparable ingoingPartialKey) {
        this.mapFactory = mapFactory;
        this.edgeMap = this.mapFactory.create();
        this.parent = parent;
        this.ingoingPartialKey = ingoingPartialKey;
    }

    /*
    Konstruiert einen Wurzelknoten
     */
    public TrieNode(IMapFactory mapFactory) {
        this.mapFactory = mapFactory;

    }

    /**
     *
     * @param allCharacters
     * @param actionAtInsert
     * @return
     */
    @Override
    public ITrieReference recursiveInsert(Iterator<Comparable<Character>> allCharacters, IActionAtInsert actionAtInsert) {
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
                return recursiveInsert(allCharacters, actionAtInsert);
            }
            /*
            Ist die Abfolge der Knoten noch nicht vorhanden, wird ein neuer TrieNode mit, welcher eine neue "Abzweigung"
            darstellt, instanziert. Auch hier geht der Iterator einen Schritt vorwärts.
             */
            else {
                ITrieNode newTrieNode = new TrieNode(mapFactory, this, nextCharacter);
                this.edgeMap.put(nextCharacter, newTrieNode);
                return recursiveInsert(allCharacters, actionAtInsert);
            }
        }
        else {
            /*
            Hat ein Knoten keine ausgehenden Kanten mehr, handelt es sich um einen bekannten Schlüsselendknoten
            (Ende eines Wortes im Aplphabet)
             */
            if (edgeMap.isEmpty()) {
                actionAtInsert.trieNodeFound(this);
                return new TrieReference(true, actionAtInsert.getValue());
            }
            /*
            Hat ein Knoten nach komplettem Durchlauf des Iterators noch weitere Kanten, handelt es sich um einen
            Teilschlüsselknoten, der nun zum gemacht wird.
            (Wort in einem bekanntem Wort im Alphabet)
             */
            else {
                actionAtInsert.trieNodeNotFound();
                actionAtInsert.setValue(this);
                return new TrieReference(false, actionAtInsert.getValue());
            }
        }
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
