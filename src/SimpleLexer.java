import AlgoDat.IMapFactory;

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
    private StringTokenizer tk = null;

    public SimpleLexer(BufferedReader reader) throws IOException {
        this.reader = reader;
        line = reader.readLine();
        if (line != null) tk = new StringTokenizer(line);
        this.trie = new Trie(mapFactory); // DIC
    }

    public IToken getNextToken() throws IOException {
        Logger.getLogger(SimpleLexer.class.getName()).log(Level.INFO, "--> next token");
        IToken result;
        boolean foundToken = false;
        boolean noMoreToken = false;
        do // Invariante: Es gibt einen Tokenizer; tk != null;
        {
            result = null;
            if (tk != null) {
                if (tk.hasMoreElements()) {
                    String intermediate = tk.nextToken();
                    Logger.getLogger(SimpleLexer.class.getName()).log(Level.INFO, "--- next token:" + intermediate);
                    // später: result =
                    // trie.insert(intermediate, action);
                    // DIC
                    result = new Token(-1, -1); // ein Dummy
                    foundToken = true;
                }
                else {
                    // neue Zeile einlesen
                    tk = null;
                    line = reader.readLine();
                    if (line != null) {
                        tk = new StringTokenizer(line);
                    }
                }
            }
            else {
                noMoreToken = true;
            }
        }
        while (!foundToken && !noMoreToken);
        Logger.getLogger(SimpleLexer.class.getName()).log(Level.INFO, "<-- result Token: " + result);
        return result;
    }

    public String decode(IToken tk) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("nochNichtImplementiert");
    }

    public  String toString() {
        return "\nResult Trie \n" + trie;
    }
}
