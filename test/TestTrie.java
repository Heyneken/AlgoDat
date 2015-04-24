import actionPackage.*;
import mapPackage.TreeMapFactory;
import org.junit.Test;
import triePackage.Trie;

/**
 * Created by benjaminarnold on 13.04.15.
 */
public class TestTrie {

    @Test
    public void testTrie() {
        Trie trie = new Trie(new TreeMapFactory());
        StringCoding stringCoding = new StringCoding(4711);
        trie.insert("Alphabet", stringCoding);
        trie.insert("Alpha", stringCoding);
        trie.insert("Alfa", stringCoding);
        trie.insert("Alf", stringCoding);
        trie.insert("Alphabet", stringCoding);
        trie.insert("Alphabet", stringCoding);
        trie.insert("Backgammon", stringCoding);
        trie.insert("Backup", stringCoding);
        trie.insert("A", stringCoding);


        System.out.println(trie.toString());


    }


}
