package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;

class DivisionAnimatedNode extends ValueAnimatedNode {
    private final int[] mInputNodes;
    private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;

    public DivisionAnimatedNode(ReadableMap readableMap, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        this.mNativeAnimatedNodesManager = nativeAnimatedNodesManager;
        readableMap = readableMap.getArray("input");
        this.mInputNodes = new int[readableMap.size()];
        for (nativeAnimatedNodesManager = null; nativeAnimatedNodesManager < this.mInputNodes.length; nativeAnimatedNodesManager++) {
            this.mInputNodes[nativeAnimatedNodesManager] = readableMap.getInt(nativeAnimatedNodesManager);
        }
    }

    public void update() {
        for (int i = 0; i < this.mInputNodes.length; i++) {
            AnimatedNode nodeById = this.mNativeAnimatedNodesManager.getNodeById(this.mInputNodes[i]);
            if (nodeById == null || !(nodeById instanceof ValueAnimatedNode)) {
                throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.divide node");
            }
            double value = ((ValueAnimatedNode) nodeById).getValue();
            if (i == 0) {
                this.mValue = value;
            } else if (value != 0.0d) {
                this.mValue /= value;
            } else {
                throw new JSApplicationCausedNativeException("Detected a division by zero in Animated.divide node");
            }
        }
    }
}
