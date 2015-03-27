/**
 * Created by Heyneken on 27.03.15.
 */
public class PlagiCheck {

    public static void main(String [] args) throws Exception {
        if (args.length == 2) {
            AlignmentController alignmentController = new AlignmentController(args[0], args[1]);
            alignmentController.run();
        }
        else {
            throw new Exception("Wir erwarten den Namen des Originals und den Namen des Plagiats");
        }
    }

}
