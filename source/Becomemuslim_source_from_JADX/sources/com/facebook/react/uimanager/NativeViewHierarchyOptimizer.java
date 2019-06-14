package com.facebook.react.uimanager;

import android.util.SparseBooleanArray;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import expolib_v1.com.facebook.infer.annotation.Assertions;

public class NativeViewHierarchyOptimizer {
    private static final boolean ENABLED = true;
    private final ShadowNodeRegistry mShadowNodeRegistry;
    private final SparseBooleanArray mTagsWithLayoutVisited = new SparseBooleanArray();
    private final UIViewOperationQueue mUIViewOperationQueue;

    private static class NodeIndexPair {
        public final int index;
        public final ReactShadowNode node;

        NodeIndexPair(ReactShadowNode reactShadowNode, int i) {
            this.node = reactShadowNode;
            this.index = i;
        }
    }

    public NativeViewHierarchyOptimizer(UIViewOperationQueue uIViewOperationQueue, ShadowNodeRegistry shadowNodeRegistry) {
        this.mUIViewOperationQueue = uIViewOperationQueue;
        this.mShadowNodeRegistry = shadowNodeRegistry;
    }

    public void handleCreateView(ReactShadowNode reactShadowNode, ThemedReactContext themedReactContext, ReactStylesDiffMap reactStylesDiffMap) {
        boolean z = (reactShadowNode.getViewClass().equals("RCTView") && isLayoutOnlyAndCollapsable(reactStylesDiffMap)) ? ENABLED : false;
        reactShadowNode.setIsLayoutOnly(z);
        if (!z) {
            this.mUIViewOperationQueue.enqueueCreateView(themedReactContext, reactShadowNode.getReactTag(), reactShadowNode.getViewClass(), reactStylesDiffMap);
        }
    }

    public static void handleRemoveNode(ReactShadowNode reactShadowNode) {
        reactShadowNode.removeAllNativeChildren();
    }

    public void handleUpdateView(ReactShadowNode reactShadowNode, String str, ReactStylesDiffMap reactStylesDiffMap) {
        Object obj = (!reactShadowNode.isLayoutOnly() || isLayoutOnlyAndCollapsable(reactStylesDiffMap)) ? null : 1;
        if (obj != null) {
            transitionLayoutOnlyViewToNativeView(reactShadowNode, reactStylesDiffMap);
        } else if (!reactShadowNode.isLayoutOnly()) {
            this.mUIViewOperationQueue.enqueueUpdateProperties(reactShadowNode.getReactTag(), str, reactStylesDiffMap);
        }
    }

    public void handleManageChildren(ReactShadowNode reactShadowNode, int[] iArr, int[] iArr2, ViewAtIndex[] viewAtIndexArr, int[] iArr3) {
        for (int i : iArr2) {
            boolean z;
            for (int i2 : iArr3) {
                if (i2 == i) {
                    z = ENABLED;
                    break;
                }
            }
            z = false;
            removeNodeFromParent(this.mShadowNodeRegistry.getNode(i), z);
        }
        for (int[] iArr22 : viewAtIndexArr) {
            addNodeToNode(reactShadowNode, this.mShadowNodeRegistry.getNode(iArr22.mTag), iArr22.mIndex);
        }
    }

    public void handleSetChildren(ReactShadowNode reactShadowNode, ReadableArray readableArray) {
        for (int i = 0; i < readableArray.size(); i++) {
            addNodeToNode(reactShadowNode, this.mShadowNodeRegistry.getNode(readableArray.getInt(i)), i);
        }
    }

    public void handleUpdateLayout(ReactShadowNode reactShadowNode) {
        applyLayoutBase(reactShadowNode);
    }

    public void onBatchComplete() {
        this.mTagsWithLayoutVisited.clear();
    }

    private NodeIndexPair walkUpUntilNonLayoutOnly(ReactShadowNode reactShadowNode, int i) {
        while (reactShadowNode.isLayoutOnly()) {
            ReactShadowNode parent = reactShadowNode.getParent();
            if (parent == null) {
                return null;
            }
            i += parent.getNativeOffsetForChild(reactShadowNode);
            reactShadowNode = parent;
        }
        return new NodeIndexPair(reactShadowNode, i);
    }

    private void addNodeToNode(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i) {
        i = reactShadowNode.getNativeOffsetForChild(reactShadowNode.getChildAt(i));
        if (reactShadowNode.isLayoutOnly()) {
            reactShadowNode = walkUpUntilNonLayoutOnly(reactShadowNode, i);
            if (reactShadowNode != null) {
                ReactShadowNode reactShadowNode3 = reactShadowNode.node;
                i = reactShadowNode.index;
                reactShadowNode = reactShadowNode3;
            } else {
                return;
            }
        }
        if (reactShadowNode2.isLayoutOnly()) {
            addLayoutOnlyNode(reactShadowNode, reactShadowNode2, i);
        } else {
            addNonLayoutNode(reactShadowNode, reactShadowNode2, i);
        }
    }

    private void removeNodeFromParent(ReactShadowNode reactShadowNode, boolean z) {
        ReactShadowNode nativeParent = reactShadowNode.getNativeParent();
        if (nativeParent != null) {
            nativeParent.removeNativeChildAt(nativeParent.indexOfNativeChild(reactShadowNode));
            this.mUIViewOperationQueue.enqueueManageChildren(nativeParent.getReactTag(), new int[]{nativeParent.indexOfNativeChild(reactShadowNode)}, null, z ? new int[]{reactShadowNode.getReactTag()} : false);
            return;
        }
        for (int childCount = reactShadowNode.getChildCount() - 1; childCount >= 0; childCount--) {
            removeNodeFromParent(reactShadowNode.getChildAt(childCount), z);
        }
    }

    private void addLayoutOnlyNode(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i) {
        addGrandchildren(reactShadowNode, reactShadowNode2, i);
    }

    private void addNonLayoutNode(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i) {
        reactShadowNode.addNativeChildAt(reactShadowNode2, i);
        this.mUIViewOperationQueue.enqueueManageChildren(reactShadowNode.getReactTag(), null, new ViewAtIndex[]{new ViewAtIndex(reactShadowNode2.getReactTag(), i)}, null);
    }

    private void addGrandchildren(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int i) {
        Assertions.assertCondition(reactShadowNode.isLayoutOnly() ^ ENABLED);
        int i2 = i;
        for (i = 0; i < reactShadowNode2.getChildCount(); i++) {
            ReactShadowNode childAt = reactShadowNode2.getChildAt(i);
            Assertions.assertCondition(childAt.getNativeParent() == null ? ENABLED : false);
            if (childAt.isLayoutOnly()) {
                int nativeChildCount = reactShadowNode.getNativeChildCount();
                addLayoutOnlyNode(reactShadowNode, childAt, i2);
                i2 += reactShadowNode.getNativeChildCount() - nativeChildCount;
            } else {
                addNonLayoutNode(reactShadowNode, childAt, i2);
                i2++;
            }
        }
    }

    private void applyLayoutBase(ReactShadowNode reactShadowNode) {
        int reactTag = reactShadowNode.getReactTag();
        if (!this.mTagsWithLayoutVisited.get(reactTag)) {
            this.mTagsWithLayoutVisited.put(reactTag, ENABLED);
            ReactShadowNode parent = reactShadowNode.getParent();
            int screenX = reactShadowNode.getScreenX();
            int screenY = reactShadowNode.getScreenY();
            while (parent != null && parent.isLayoutOnly()) {
                screenX += Math.round(parent.getLayoutX());
                screenY += Math.round(parent.getLayoutY());
                parent = parent.getParent();
            }
            applyLayoutRecursive(reactShadowNode, screenX, screenY);
        }
    }

    private void applyLayoutRecursive(ReactShadowNode reactShadowNode, int i, int i2) {
        if (reactShadowNode.isLayoutOnly() || reactShadowNode.getNativeParent() == null) {
            for (int i3 = 0; i3 < reactShadowNode.getChildCount(); i3++) {
                ReactShadowNode childAt = reactShadowNode.getChildAt(i3);
                int reactTag = childAt.getReactTag();
                if (!this.mTagsWithLayoutVisited.get(reactTag)) {
                    this.mTagsWithLayoutVisited.put(reactTag, ENABLED);
                    applyLayoutRecursive(childAt, childAt.getScreenX() + i, childAt.getScreenY() + i2);
                }
            }
            return;
        }
        this.mUIViewOperationQueue.enqueueUpdateLayout(reactShadowNode.getNativeParent().getReactTag(), reactShadowNode.getReactTag(), i, i2, reactShadowNode.getScreenWidth(), reactShadowNode.getScreenHeight());
    }

    private void transitionLayoutOnlyViewToNativeView(ReactShadowNode reactShadowNode, ReactStylesDiffMap reactStylesDiffMap) {
        ReactShadowNode parent = reactShadowNode.getParent();
        int i = 0;
        if (parent == null) {
            reactShadowNode.setIsLayoutOnly(false);
            return;
        }
        int indexOf = parent.indexOf(reactShadowNode);
        parent.removeChildAt(indexOf);
        removeNodeFromParent(reactShadowNode, false);
        reactShadowNode.setIsLayoutOnly(false);
        this.mUIViewOperationQueue.enqueueCreateView(reactShadowNode.getThemedContext(), reactShadowNode.getReactTag(), reactShadowNode.getViewClass(), reactStylesDiffMap);
        parent.addChildAt(reactShadowNode, indexOf);
        addNodeToNode(parent, reactShadowNode, indexOf);
        for (reactStylesDiffMap = null; reactStylesDiffMap < reactShadowNode.getChildCount(); reactStylesDiffMap++) {
            addNodeToNode(reactShadowNode, reactShadowNode.getChildAt(reactStylesDiffMap), reactStylesDiffMap);
        }
        Assertions.assertCondition(this.mTagsWithLayoutVisited.size() == null ? ENABLED : null);
        applyLayoutBase(reactShadowNode);
        while (i < reactShadowNode.getChildCount()) {
            applyLayoutBase(reactShadowNode.getChildAt(i));
            i++;
        }
        this.mTagsWithLayoutVisited.clear();
    }

    private static boolean isLayoutOnlyAndCollapsable(ReactStylesDiffMap reactStylesDiffMap) {
        if (reactStylesDiffMap == null) {
            return ENABLED;
        }
        if (reactStylesDiffMap.hasKey(ViewProps.COLLAPSABLE) && !reactStylesDiffMap.getBoolean(ViewProps.COLLAPSABLE, ENABLED)) {
            return false;
        }
        ReadableMapKeySetIterator keySetIterator = reactStylesDiffMap.mBackingMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            if (!ViewProps.isLayoutOnly(reactStylesDiffMap.mBackingMap, keySetIterator.nextKey())) {
                return false;
            }
        }
        return ENABLED;
    }
}
