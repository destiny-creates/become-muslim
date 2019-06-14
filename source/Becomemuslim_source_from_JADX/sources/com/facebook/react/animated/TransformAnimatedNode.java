package com.facebook.react.animated;

import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;
import java.util.List;

class TransformAnimatedNode extends AnimatedNode {
    private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;
    private final List<TransformConfig> mTransformConfigs;

    private class TransformConfig {
        public String mProperty;

        private TransformConfig() {
        }
    }

    private class AnimatedTransformConfig extends TransformConfig {
        public int mNodeTag;

        private AnimatedTransformConfig() {
            super();
        }
    }

    private class StaticTransformConfig extends TransformConfig {
        public double mValue;

        private StaticTransformConfig() {
            super();
        }
    }

    TransformAnimatedNode(ReadableMap readableMap, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        readableMap = readableMap.getArray("transforms");
        this.mTransformConfigs = new ArrayList(readableMap.size());
        for (int i = 0; i < readableMap.size(); i++) {
            ReadableMap map = readableMap.getMap(i);
            String string = map.getString("property");
            if (map.getString("type").equals("animated")) {
                AnimatedTransformConfig animatedTransformConfig = new AnimatedTransformConfig();
                animatedTransformConfig.mProperty = string;
                animatedTransformConfig.mNodeTag = map.getInt("nodeTag");
                this.mTransformConfigs.add(animatedTransformConfig);
            } else {
                StaticTransformConfig staticTransformConfig = new StaticTransformConfig();
                staticTransformConfig.mProperty = string;
                staticTransformConfig.mValue = map.getDouble("value");
                this.mTransformConfigs.add(staticTransformConfig);
            }
        }
        this.mNativeAnimatedNodesManager = nativeAnimatedNodesManager;
    }

    public void collectViewUpdates(JavaOnlyMap javaOnlyMap) {
        List arrayList = new ArrayList(this.mTransformConfigs.size());
        for (TransformConfig transformConfig : this.mTransformConfigs) {
            double value;
            if (transformConfig instanceof AnimatedTransformConfig) {
                AnimatedNode nodeById = this.mNativeAnimatedNodesManager.getNodeById(((AnimatedTransformConfig) transformConfig).mNodeTag);
                if (nodeById == null) {
                    throw new IllegalArgumentException("Mapped style node does not exists");
                } else if (nodeById instanceof ValueAnimatedNode) {
                    value = ((ValueAnimatedNode) nodeById).getValue();
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unsupported type of node used as a transform child node ");
                    stringBuilder.append(nodeById.getClass());
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            value = ((StaticTransformConfig) transformConfig).mValue;
            arrayList.add(JavaOnlyMap.of(transformConfig.mProperty, Double.valueOf(value)));
        }
        javaOnlyMap.putArray("transform", JavaOnlyArray.from(arrayList));
    }
}
