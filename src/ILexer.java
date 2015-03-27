import java.io.IOException;

/**
 * Created by Heyneken on 27.03.15.
 */
public interface ILexer {

    IToken getNextToken() throws IOException;
    String decode(IToken tk);

}
