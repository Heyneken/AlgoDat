package lexerPackage;

import actionPackage.*;
import mapPackage.IMapFactory;
import mapPackage.TreeMapFactory;
import triePackage.ITrie;
import triePackage.Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Heyneken on 27.03.15.
 */
public class SimpleLexer implements ILexer {

    final private BufferedReader reader;
    final private IMapFactory mapFactory = new TreeMapFactory(); // DIC
    final private IActionAtInsert actionAtInsert = new StringCoding(4711); // DIC
    final private ITrie trie; // DIC
    private String line;
    // Teilt den eigelesenen String in einzelne Tokens (eg. Wörter)
    private StringTokenizer stringTokenizer = null;

    public SimpleLexer(BufferedReader reader) throws IOException {
        this.reader = reader;
        line = reader.readLine();
        if (line != null) stringTokenizer = new StringTokenizer(line);
        this.trie = new Trie(mapFactory); // DIC
    }

    public IToken getNextToken() throws IOException {
        Logger.getLogger(SimpleLexer.class.getName()).log(Level.INFO, "--> next token");
        IToken result;
        boolean foundToken = false;
        boolean noMoreToken = false;
        do // Invariante: Es gibt einen Tokenizer; stringTokenizer != null;
        {
            result = null;
            if (stringTokenizer != null) {
                if (stringTokenizer.hasMoreElements()) {
                    String intermediate = stringTokenizer.nextToken();
                    Logger.getLogger(SimpleLexer.class.getName()).log(Level.INFO, "--- next token:" + intermediate);
                    // später: result =
                    // trie.insert(intermediate, action);
                    // DIC
                    result = new Token(-1, -1); // ein Dummy
                    foundToken = true;
                }
                else {
                    // neue Zeile einlesen
                    stringTokenizer = null;
                    line = reader.readLine();
                    if (line != null) {
                        stringTokenizer = new StringTokenizer(line);
                    }
                }
            }
            else {
                noMoreToken = true;
            }
        }
        while (!foundToken && !noMoreToken);
        Logger.getLogger(SimpleLexer.class.getName()).log(Level.INFO, "<-- result lexerPackage.Token: " + result);
        return result;
    }

    public String decode(IToken token) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("nochNichtImplementiert");
    }

    public  String toString() {
        return "\nResult triePackage.Trie \n" + trie;
    }
}
