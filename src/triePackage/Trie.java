package triePackage;

import actionPackage.IActionAtInsert;
import helperPackage.Helper;
import mapPackage.IMapFactory;

import java.util.Iterator;

/**
 * Created by Heyneken on 09.04.15.
 */
public class Trie implements ITrie {

    final private TrieNode root;

    public Trie(IMapFactory mapFactory) {
        this.root = new TrieNode(mapFactory);
    }

    @Override
    public ITrieReference insert(Iterator allCharacters, IActionAtInsert actionAtInsert) {
                return root.recursiveInsert(allCharacters, actionAtInsert);
    }

    @Override
    public ITrieReference insert(String string, IActionAtInsert actionAtInsert) {
        return insert(Helper.createIterator(string), actionAtInsert);
    }

    @Override
    public String toString() {
        root.showValues(0);
        return "";
    }

}
