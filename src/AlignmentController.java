import java.io.*;

/**
 * Created by Heyneken on 27.03.15.
 */
public class AlignmentController {

    final private String original;
    final private String suspect;

    public AlignmentController(String original, String suspect) {
        this.original = original;
        this.suspect = suspect;
    }

    public void run() throws FileNotFoundException, IOException {

        /* erstes File lesen */
        InputStream istreamOriginal = new FileInputStream(original);
        Reader readerOriginal = new InputStreamReader(istreamOriginal);
        BufferedReader inputOriginal = new BufferedReader(readerOriginal);

        /* später: hier zweites File */
        //TODO: Code für supect file

        ILexer lexer = new SimpleLexer(inputOriginal);
        IToken token = lexer.getNextToken();
        while (token != null) {
            System.out.println("Gelesen: " + token);
            token = lexer.getNextToken();
        }
        /* später: hier Lexer an zweiten Input binden; Leseschleife */
    }
}
