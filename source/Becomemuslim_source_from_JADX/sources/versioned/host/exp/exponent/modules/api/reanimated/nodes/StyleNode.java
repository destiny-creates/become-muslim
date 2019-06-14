package versioned.host.exp.exponent.modules.api.reanimated.nodes;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.Map;
import java.util.Map.Entry;
import versioned.host.exp.exponent.modules.api.reanimated.NodesManager;
import versioned.host.exp.exponent.modules.api.reanimated.Utils;

public class StyleNode extends Node {
    private final Map<String, Integer> mMapping;

    public StyleNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mMapping = Utils.processMapping(readableMap.getMap(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE));
    }

    protected WritableMap evaluate() {
        WritableMap javaOnlyMap = new JavaOnlyMap();
        for (Entry entry : this.mMapping.entrySet()) {
            Node findNodeById = this.mNodesManager.findNodeById(((Integer) entry.getValue()).intValue(), Node.class);
            if (findNodeById instanceof TransformNode) {
                javaOnlyMap.putArray((String) entry.getKey(), (WritableArray) findNodeById.value());
            } else {
                Object value = findNodeById.value();
                if (value instanceof Double) {
                    javaOnlyMap.putDouble((String) entry.getKey(), ((Double) value).doubleValue());
                } else if (value instanceof String) {
                    javaOnlyMap.putString((String) entry.getKey(), (String) value);
                } else {
                    throw new IllegalStateException("Wrong style form");
                }
            }
        }
        return javaOnlyMap;
    }
}
