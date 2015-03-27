import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by Heyneken on 27.03.15.
 */
public class SimpleLexer implements ILexer {

    final private BufferedReader reader;
    final private IMapFactory mapFactory = new TreeMapFactory();
    final private IActionAtInsert actionAtInsert = new StringCoding(4711);
    final private ITrie trie;
    private String line;
    private StringTokenizer tk = null;

    public SimpleLexer(BufferedReader reader) throws IOException {
        this.reader = reader;
        line = reader.readLine();
        if (line != null) tk = new StringTokenizer(line);
        this.trie = new Trie(mapFactory);
    }
}
