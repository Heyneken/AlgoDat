/**
 * Created by Heyneken on 10.04.15.
 */
public class TrieReference implements ITrieReference {

    final private boolean found;
    final private Object value;

    public TrieReference(boolean found, Object value) {
        this.found = found;
        this.value = value;
    }

    @Override
    public boolean getFound() {
        return false;
    }

    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public ITrieNode getNode() {
        return null;
    }
}
