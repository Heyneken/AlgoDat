package triePackage;

import actionPackage.IActionAtInsert;

import java.util.Iterator;

/**
 * Created by Heyneken on 09.04.15.
 */
public interface ITrie {

    ITrieReference insert(Iterator<Comparable<Character>> allCharacters, IActionAtInsert actionAtInsert);

    ITrieReference insert(String string, IActionAtInsert actionAtInsert);

}
