package versioned.host.exp.exponent.modules.api.reanimated.nodes;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.UIImplementation;
import java.util.Map;
import java.util.Map.Entry;
import versioned.host.exp.exponent.modules.api.reanimated.NodesManager;
import versioned.host.exp.exponent.modules.api.reanimated.Utils;

public class PropsNode extends Node implements FinalNode {
    private int mConnectedViewTag = -1;
    private final ReactStylesDiffMap mDiffMap;
    private final Map<String, Integer> mMapping;
    private final JavaOnlyMap mPropMap;
    private final UIImplementation mUIImplementation;

    /* renamed from: versioned.host.exp.exponent.modules.api.reanimated.nodes.PropsNode$1 */
    static /* synthetic */ class C67511 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType = new int[ReadableType.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = com.facebook.react.bridge.ReadableType.values();
            r0 = r0.length;
            r0 = new int[r0];
            $SwitchMap$com$facebook$react$bridge$ReadableType = r0;
            r0 = $SwitchMap$com$facebook$react$bridge$ReadableType;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = com.facebook.react.bridge.ReadableType.Number;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = $SwitchMap$com$facebook$react$bridge$ReadableType;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = com.facebook.react.bridge.ReadableType.String;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = $SwitchMap$com$facebook$react$bridge$ReadableType;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = com.facebook.react.bridge.ReadableType.Array;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.reanimated.nodes.PropsNode.1.<clinit>():void");
        }
    }

    public PropsNode(int i, ReadableMap readableMap, NodesManager nodesManager, UIImplementation uIImplementation) {
        super(i, readableMap, nodesManager);
        this.mMapping = Utils.processMapping(readableMap.getMap("props"));
        this.mUIImplementation = uIImplementation;
        this.mPropMap = new JavaOnlyMap();
        this.mDiffMap = new ReactStylesDiffMap(this.mPropMap);
    }

    public void connectToView(int i) {
        this.mConnectedViewTag = i;
        dangerouslyRescheduleEvaluate();
    }

    public void disconnectFromView(int i) {
        this.mConnectedViewTag = -1;
    }

    protected Double evaluate() {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        for (Entry entry : this.mMapping.entrySet()) {
            Node findNodeById = this.mNodesManager.findNodeById(((Integer) entry.getValue()).intValue(), Node.class);
            if (findNodeById instanceof StyleNode) {
                WritableMap writableMap = (WritableMap) findNodeById.value();
                ReadableMapKeySetIterator keySetIterator = writableMap.keySetIterator();
                while (keySetIterator.hasNextKey()) {
                    WritableMap writableMap2;
                    Object obj4;
                    String nextKey = keySetIterator.nextKey();
                    if (this.mNodesManager.uiProps.contains(nextKey)) {
                        writableMap2 = this.mPropMap;
                        obj4 = 1;
                    } else if (this.mNodesManager.nativeProps.contains(nextKey)) {
                        obj4 = obj;
                        obj2 = 1;
                        writableMap2 = createMap2;
                    } else {
                        obj4 = obj;
                        obj3 = 1;
                        writableMap2 = createMap;
                    }
                    ReadableType type = writableMap.getType(nextKey);
                    switch (C67511.$SwitchMap$com$facebook$react$bridge$ReadableType[type.ordinal()]) {
                        case 1:
                            writableMap2.putDouble(nextKey, writableMap.getDouble(nextKey));
                            break;
                        case 2:
                            writableMap2.putString(nextKey, writableMap.getString(nextKey));
                            break;
                        case 3:
                            writableMap2.putArray(nextKey, (WritableArray) writableMap.getArray(nextKey));
                            break;
                        default:
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Unexpected type ");
                            stringBuilder.append(type);
                            throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    obj = obj4;
                }
                continue;
            } else {
                String str = (String) entry.getKey();
                if (this.mNodesManager.uiProps.contains(str)) {
                    this.mPropMap.putDouble(str, findNodeById.doubleValue().doubleValue());
                    obj = 1;
                } else {
                    createMap2.putDouble(str, findNodeById.doubleValue().doubleValue());
                    obj2 = 1;
                }
            }
        }
        if (this.mConnectedViewTag != -1) {
            if (obj != null) {
                this.mUIImplementation.synchronouslyUpdateViewOnUIThread(this.mConnectedViewTag, this.mDiffMap);
            }
            if (obj2 != null) {
                this.mNodesManager.enqueueUpdateViewOnNativeThread(this.mConnectedViewTag, createMap2);
            }
            if (obj3 != null) {
                createMap2 = Arguments.createMap();
                createMap2.putInt("viewTag", this.mConnectedViewTag);
                createMap2.putMap("props", createMap);
                this.mNodesManager.sendEvent("onReanimatedPropsChange", createMap2);
            }
        }
        return ZERO;
    }

    public void update() {
        if (this.mConnectedViewTag != -1) {
            value();
        }
    }
}
