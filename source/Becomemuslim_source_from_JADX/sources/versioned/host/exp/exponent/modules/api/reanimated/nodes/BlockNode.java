package versioned.host.exp.exponent.modules.api.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import versioned.host.exp.exponent.modules.api.reanimated.NodesManager;
import versioned.host.exp.exponent.modules.api.reanimated.Utils;

public class BlockNode extends Node {
    private final int[] mBlock;

    public BlockNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mBlock = Utils.processIntArray(readableMap.getArray("block"));
    }

    protected Object evaluate() {
        Object obj = null;
        for (int findNodeById : this.mBlock) {
            obj = this.mNodesManager.findNodeById(findNodeById, Node.class).value();
        }
        return obj;
    }
}
