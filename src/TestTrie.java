import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by benjaminarnold on 13.04.15.
 */
public class TestTrie {

    @Test
    public void testTrie() {
        Trie trie = new Trie(new HashMapFactory());
        trie.insert("Alfons", new StringCoding(4711));

        assertEquals("Trie falsch aufgebaut", "A\n..l\n....f\n......o\n........n\n..........s |-> 4711", trie.toString());

    }
}
