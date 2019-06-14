package versioned.host.exp.exponent.modules.api.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import versioned.host.exp.exponent.modules.api.reanimated.NodesManager;
import versioned.host.exp.exponent.modules.api.reanimated.Utils;

public class ConcatNode extends Node {
    private final int[] mInputIDs;

    public ConcatNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mInputIDs = Utils.processIntArray(readableMap.getArray("input"));
    }

    protected String evaluate() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int findNodeById : this.mInputIDs) {
            stringBuilder.append(this.mNodesManager.findNodeById(findNodeById, Node.class).value());
        }
        return stringBuilder.toString();
    }
}
