package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;

class MultiplicationAnimatedNode extends ValueAnimatedNode {
    private final int[] mInputNodes;
    private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;

    public MultiplicationAnimatedNode(ReadableMap readableMap, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        this.mNativeAnimatedNodesManager = nativeAnimatedNodesManager;
        readableMap = readableMap.getArray("input");
        this.mInputNodes = new int[readableMap.size()];
        for (nativeAnimatedNodesManager = null; nativeAnimatedNodesManager < this.mInputNodes.length; nativeAnimatedNodesManager++) {
            this.mInputNodes[nativeAnimatedNodesManager] = readableMap.getInt(nativeAnimatedNodesManager);
        }
    }

    public void update() {
        this.mValue = 1.0d;
        for (int nodeById : this.mInputNodes) {
            AnimatedNode nodeById2 = this.mNativeAnimatedNodesManager.getNodeById(nodeById);
            if (nodeById2 == null || !(nodeById2 instanceof ValueAnimatedNode)) {
                throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.multiply node");
            }
            this.mValue *= ((ValueAnimatedNode) nodeById2).getValue();
        }
    }
}
