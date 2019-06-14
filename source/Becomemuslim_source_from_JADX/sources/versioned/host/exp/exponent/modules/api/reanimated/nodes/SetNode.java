package versioned.host.exp.exponent.modules.api.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import versioned.host.exp.exponent.modules.api.reanimated.NodesManager;

public class SetNode extends Node {
    private int mValueNodeID;
    private int mWhatNodeID;

    public SetNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mWhatNodeID = readableMap.getInt("what");
        this.mValueNodeID = readableMap.getInt("value");
    }

    protected Object evaluate() {
        Object nodeValue = this.mNodesManager.getNodeValue(this.mValueNodeID);
        ((ValueNode) this.mNodesManager.findNodeById(this.mWhatNodeID, ValueNode.class)).setValue(nodeValue);
        return nodeValue;
    }
}
