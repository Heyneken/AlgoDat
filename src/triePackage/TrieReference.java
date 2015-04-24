package triePackage;

/**
 * Created by Heyneken on 10.04.15.
 */
public class TrieReference implements ITrieReference {

    final private boolean found;
    final private Object value;
    final private ITrieNode trieNode;

    public TrieReference(boolean found, Object value, TrieNode trieNode) {
        this.found = found;
        this.value = value;
        this.trieNode = trieNode;
    }

    @Override
    public boolean gotFound() {
        return false;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public ITrieNode getTrieNode() {
        return trieNode;
    }
}
