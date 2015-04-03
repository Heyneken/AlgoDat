import java.util.HashMap;
import java.util.Map;

/**
 * Created by Heyneken on 03.04.15.
 */
public class HashMapFactory implements IMapFactory {

    @Override
    public Map create() {
        return new HashMap();
    }
}
