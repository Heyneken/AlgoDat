package mapPackage;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Heyneken on 03.04.15.
 */
public class TreeMapFactory implements IMapFactory {

    @Override
    public Map create() {
        return new TreeMap();
    }

}
