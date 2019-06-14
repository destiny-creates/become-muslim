package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.UIImplementation;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class PropsAnimatedNode extends AnimatedNode {
    private int mConnectedViewTag = -1;
    private final ReactStylesDiffMap mDiffMap;
    private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;
    private final JavaOnlyMap mPropMap;
    private final Map<String, Integer> mPropNodeMapping;
    private final UIImplementation mUIImplementation;

    PropsAnimatedNode(ReadableMap readableMap, NativeAnimatedNodesManager nativeAnimatedNodesManager, UIImplementation uIImplementation) {
        readableMap = readableMap.getMap("props");
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        this.mPropNodeMapping = new HashMap();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            this.mPropNodeMapping.put(nextKey, Integer.valueOf(readableMap.getInt(nextKey)));
        }
        this.mPropMap = new JavaOnlyMap();
        this.mDiffMap = new ReactStylesDiffMap(this.mPropMap);
        this.mNativeAnimatedNodesManager = nativeAnimatedNodesManager;
        this.mUIImplementation = uIImplementation;
    }

    public void connectToView(int i) {
        if (this.mConnectedViewTag == -1) {
            this.mConnectedViewTag = i;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Animated node ");
        stringBuilder.append(this.mTag);
        stringBuilder.append(" is already attached to a view");
        throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
    }

    public void disconnectFromView(int i) {
        if (this.mConnectedViewTag == i) {
            this.mConnectedViewTag = -1;
            return;
        }
        throw new JSApplicationIllegalArgumentException("Attempting to disconnect view that has not been connected with the given animated node");
    }

    public void restoreDefaultValues() {
        ReadableMapKeySetIterator keySetIterator = this.mPropMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            this.mPropMap.putNull(keySetIterator.nextKey());
        }
        this.mUIImplementation.synchronouslyUpdateViewOnUIThread(this.mConnectedViewTag, this.mDiffMap);
    }

    public final void updateView() {
        if (this.mConnectedViewTag != -1) {
            for (Entry entry : this.mPropNodeMapping.entrySet()) {
                AnimatedNode nodeById = this.mNativeAnimatedNodesManager.getNodeById(((Integer) entry.getValue()).intValue());
                if (nodeById == null) {
                    throw new IllegalArgumentException("Mapped property node does not exists");
                } else if (nodeById instanceof StyleAnimatedNode) {
                    ((StyleAnimatedNode) nodeById).collectViewUpdates(this.mPropMap);
                } else if (nodeById instanceof ValueAnimatedNode) {
                    this.mPropMap.putDouble((String) entry.getKey(), ((ValueAnimatedNode) nodeById).getValue());
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unsupported type of node used in property node ");
                    stringBuilder.append(nodeById.getClass());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            this.mUIImplementation.synchronouslyUpdateViewOnUIThread(this.mConnectedViewTag, this.mDiffMap);
        }
    }
}
