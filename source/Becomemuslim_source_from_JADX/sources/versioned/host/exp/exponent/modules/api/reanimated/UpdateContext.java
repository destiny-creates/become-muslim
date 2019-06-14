package versioned.host.exp.exponent.modules.api.reanimated;

import java.util.ArrayList;
import versioned.host.exp.exponent.modules.api.reanimated.nodes.Node;

public class UpdateContext {
    public long updateLoopID = 0;
    public final ArrayList<Node> updatedNodes = new ArrayList();
}
