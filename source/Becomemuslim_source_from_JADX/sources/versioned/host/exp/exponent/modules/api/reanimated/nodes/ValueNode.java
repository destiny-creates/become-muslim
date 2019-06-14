package versioned.host.exp.exponent.modules.api.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import versioned.host.exp.exponent.modules.api.reanimated.NodesManager;

public class ValueNode extends Node {
    private Object mValue;

    public ValueNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        if (readableMap != null) {
            if (readableMap.hasKey("value") != null) {
                nodesManager = readableMap.getType("value");
                if (nodesManager == ReadableType.String) {
                    this.mValue = readableMap.getString("value");
                } else if (nodesManager == ReadableType.Number) {
                    this.mValue = Double.valueOf(readableMap.getDouble("value"));
                } else if (nodesManager == ReadableType.Null) {
                    this.mValue = null;
                } else {
                    throw new IllegalStateException("Not supported value type. Must be boolean, number or string");
                }
                return;
            }
        }
        this.mValue = null;
    }

    public void setValue(Object obj) {
        this.mValue = obj;
        forceUpdateMemoizedValue(this.mValue);
    }

    protected Object evaluate() {
        return this.mValue;
    }
}
