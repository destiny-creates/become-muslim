package versioned.host.exp.exponent.modules.api.reanimated.nodes;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import versioned.host.exp.exponent.modules.api.reanimated.NodesManager;
import versioned.host.exp.exponent.modules.api.reanimated.Utils;

public class JSCallNode extends Node {
    private final int[] mInputIDs;

    public JSCallNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mInputIDs = Utils.processIntArray(readableMap.getArray("input"));
    }

    protected Double evaluate() {
        WritableArray createArray = Arguments.createArray();
        for (int findNodeById : this.mInputIDs) {
            Node findNodeById2 = this.mNodesManager.findNodeById(findNodeById, Node.class);
            if (findNodeById2.value() == null) {
                createArray.pushNull();
            } else {
                createArray.pushDouble(findNodeById2.doubleValue().doubleValue());
            }
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", this.mNodeID);
        createMap.putArray("args", createArray);
        this.mNodesManager.sendEvent("onReanimatedCall", createMap);
        return ZERO;
    }
}
