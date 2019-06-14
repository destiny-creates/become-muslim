package versioned.host.exp.exponent.modules.api.reanimated.nodes;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import java.util.ArrayList;
import java.util.List;
import versioned.host.exp.exponent.modules.api.reanimated.NodesManager;

public class EventNode extends Node implements RCTEventEmitter {
    private final List<EventMap> mMapping;

    private static class EventMap {
        private final int nodeID;
        private final String[] path;

        public EventMap(ReadableArray readableArray) {
            int size = readableArray.size() - 1;
            this.path = new String[size];
            for (int i = 0; i < size; i++) {
                this.path[i] = readableArray.getString(i);
            }
            this.nodeID = readableArray.getInt(size);
        }

        public Double lookupValue(ReadableMap readableMap) {
            String str;
            int i = 0;
            while (true) {
                Double d = null;
                if (readableMap != null && i < this.path.length - 1) {
                    String str2 = this.path[i];
                    readableMap = readableMap.hasKey(str2) ? readableMap.getMap(str2) : null;
                    i++;
                } else if (readableMap != null) {
                    return null;
                } else {
                    str = this.path[this.path.length - 1];
                    if (readableMap.hasKey(str)) {
                        d = Double.valueOf(readableMap.getDouble(str));
                    }
                    return d;
                }
            }
            if (readableMap != null) {
                return null;
            }
            str = this.path[this.path.length - 1];
            if (readableMap.hasKey(str)) {
                d = Double.valueOf(readableMap.getDouble(str));
            }
            return d;
        }
    }

    private static List<EventMap> processMapping(ReadableArray readableArray) {
        int size = readableArray.size();
        List<EventMap> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new EventMap(readableArray.getArray(i)));
        }
        return arrayList;
    }

    public EventNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mMapping = processMapping(readableMap.getArray("argMapping"));
    }

    public void receiveEvent(int i, String str, WritableMap writableMap) {
        if (writableMap != null) {
            for (i = 0; i < this.mMapping.size(); i++) {
                EventMap eventMap = (EventMap) this.mMapping.get(i);
                Double lookupValue = eventMap.lookupValue(writableMap);
                if (lookupValue != null) {
                    ((ValueNode) this.mNodesManager.findNodeById(eventMap.nodeID, ValueNode.class)).setValue(lookupValue);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Animated events must have event data.");
    }

    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
        throw new RuntimeException("receiveTouches is not support by animated events");
    }

    protected Double evaluate() {
        return ZERO;
    }
}
