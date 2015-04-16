import org.junit.Test;

/**
 * Created by benjaminarnold on 13.04.15.
 */
public class TestTrie {

    @Test
    public void testTrie() {
        Trie trie = new Trie(new TreeMapFactory());
        trie.insert("Alfons", new StringCoding(4711));

        System.out.println(trie.toString());

        //assertEquals("Trie falsch aufgebaut", "A\n..l\n....f\n......o\n........n\n..........s |-> 4711", trie.toString());

    }


}
