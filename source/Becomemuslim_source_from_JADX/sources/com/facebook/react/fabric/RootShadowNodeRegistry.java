package com.facebook.react.fabric;

import com.facebook.react.uimanager.ReactShadowNode;
import java.util.concurrent.ConcurrentHashMap;

public class RootShadowNodeRegistry {
    private final ConcurrentHashMap<Integer, ReactShadowNode> mTagsToRootNodes = new ConcurrentHashMap();

    public synchronized void registerNode(ReactShadowNode reactShadowNode) {
        this.mTagsToRootNodes.put(Integer.valueOf(reactShadowNode.getReactTag()), reactShadowNode);
    }

    public void replaceNode(ReactShadowNode reactShadowNode) {
        this.mTagsToRootNodes.replace(Integer.valueOf(reactShadowNode.getReactTag()), reactShadowNode);
    }

    public void removeNode(Integer num) {
        this.mTagsToRootNodes.remove(num);
    }

    public ReactShadowNode getNode(int i) {
        return (ReactShadowNode) this.mTagsToRootNodes.get(Integer.valueOf(i));
    }
}
