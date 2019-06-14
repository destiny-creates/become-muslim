package versioned.host.exp.exponent.modules.api.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import versioned.host.exp.exponent.modules.api.reanimated.NodesManager;

public class CondNode extends Node {
    private final int mCondID;
    private final int mElseBlockID;
    private final int mIfBlockID;

    public CondNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mCondID = readableMap.getInt("cond");
        nodesManager = -1;
        this.mIfBlockID = readableMap.hasKey("ifBlock") != 0 ? readableMap.getInt("ifBlock") : -1;
        if (readableMap.hasKey("elseBlock") != 0) {
            nodesManager = readableMap.getInt("elseBlock");
        }
        this.mElseBlockID = nodesManager;
    }

    protected Object evaluate() {
        Object nodeValue = this.mNodesManager.getNodeValue(this.mCondID);
        if (!(nodeValue instanceof Number) || ((Number) nodeValue).doubleValue() == 0.0d) {
            return this.mElseBlockID != -1 ? this.mNodesManager.getNodeValue(this.mElseBlockID) : ZERO;
        }
        return this.mIfBlockID != -1 ? this.mNodesManager.getNodeValue(this.mIfBlockID) : ZERO;
    }
}
