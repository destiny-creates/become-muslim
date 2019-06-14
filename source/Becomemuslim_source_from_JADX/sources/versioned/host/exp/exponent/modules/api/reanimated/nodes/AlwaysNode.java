package versioned.host.exp.exponent.modules.api.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import versioned.host.exp.exponent.modules.api.reanimated.NodesManager;

public class AlwaysNode extends Node implements FinalNode {
    private int mNodeToBeEvaluated;

    public AlwaysNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mNodeToBeEvaluated = readableMap.getInt("what");
    }

    public void update() {
        value();
    }

    protected Double evaluate() {
        this.mNodesManager.findNodeById(this.mNodeToBeEvaluated, Node.class).value();
        return ZERO;
    }
}
