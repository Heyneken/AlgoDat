package helperPackage;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Heyneken on 12.04.15.
 */
public class Helper {

    /**
     * Macht aus einem String einen Iterator.
     *
     * @param string Wort, welches ins Alphabet mit aufgenommen werden soll.
     * @return iterator
     */
    public static Iterator createIterator (String string) {

        ArrayList<Character> arrayList = new ArrayList<>();

        for (char character : string.toCharArray()) {
            arrayList.add(character);
        }


        return arrayList.iterator();
    }

}