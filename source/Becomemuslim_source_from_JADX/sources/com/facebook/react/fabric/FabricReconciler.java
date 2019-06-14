package com.facebook.react.fabric;

import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.react.common.ArrayUtils;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.ViewAtIndex;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FabricReconciler {
    private static final boolean DEBUG = PrinterHolder.getPrinter().shouldDisplayLogMessage(ReactDebugOverlayTags.FABRIC_RECONCILER);
    private static final String TAG = "FabricReconciler";
    private UIViewOperationQueue uiViewOperationQueue;

    public FabricReconciler(UIViewOperationQueue uIViewOperationQueue) {
        this.uiViewOperationQueue = uIViewOperationQueue;
    }

    public void manageChildren(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2) {
        SystraceMessage.beginSection(0, "FabricReconciler.manageChildren").flush();
        if (reactShadowNode == null) {
            reactShadowNode = null;
        } else {
            try {
                reactShadowNode = reactShadowNode.getChildrenList();
            } catch (Throwable th) {
                Systrace.endSection(0);
            }
        }
        manageChildren(reactShadowNode2, reactShadowNode, reactShadowNode2.getChildrenList());
        Systrace.endSection(0);
    }

    private void manageChildren(ReactShadowNode reactShadowNode, List<ReactShadowNode> list, List<ReactShadowNode> list2) {
        int i;
        if (list == null) {
            list = Collections.emptyList();
        }
        if (list2 == null) {
            list2 = Collections.emptyList();
        }
        int i2 = 0;
        while (i2 < Math.min(list.size(), list2.size())) {
            ReactShadowNode reactShadowNode2 = (ReactShadowNode) list.get(i2);
            ReactShadowNode reactShadowNode3 = (ReactShadowNode) list2.get(i2);
            if (reactShadowNode2 != reactShadowNode3) {
                if (reactShadowNode2.getReactTag() != reactShadowNode3.getReactTag()) {
                    break;
                }
                enqueueUpdateProperties(reactShadowNode3, reactShadowNode2);
                manageChildren(reactShadowNode2, reactShadowNode2.getChildrenList(), reactShadowNode3.getChildrenList());
                reactShadowNode3.setOriginalReactShadowNode(null);
            }
            i2++;
        }
        Set hashSet = new HashSet();
        List linkedList = new LinkedList();
        for (i = i2; i < list2.size(); i++) {
            ReactShadowNode reactShadowNode4 = (ReactShadowNode) list2.get(i);
            if (!reactShadowNode4.isVirtual()) {
                enqueueUpdateProperties(reactShadowNode4, reactShadowNode4.getOriginalReactShadowNode());
                linkedList.add(new ViewAtIndex(reactShadowNode4.getReactTag(), i));
                manageChildren(reactShadowNode4, reactShadowNode4.getOriginalReactShadowNode() == null ? null : reactShadowNode4.getOriginalReactShadowNode().getChildrenList(), reactShadowNode4.getChildrenList());
                reactShadowNode4.setOriginalReactShadowNode(null);
                hashSet.add(Integer.valueOf(reactShadowNode4.getReactTag()));
            }
        }
        list2 = new LinkedList();
        List linkedList2 = new LinkedList();
        for (i = list.size() - 1; i >= i2; i--) {
            reactShadowNode4 = (ReactShadowNode) list.get(i);
            if (!reactShadowNode4.isVirtual()) {
                linkedList2.add(0, Integer.valueOf(i));
                if (!hashSet.contains(Integer.valueOf(reactShadowNode4.getReactTag()))) {
                    list2.add(Integer.valueOf(reactShadowNode4.getReactTag()));
                }
            }
        }
        if (linkedList2.isEmpty() == null || linkedList.isEmpty() == null || list2.isEmpty() == null) {
            list = ArrayUtils.copyListToArray(linkedList2);
            ViewAtIndex[] viewAtIndexArr = (ViewAtIndex[]) linkedList.toArray(new ViewAtIndex[linkedList.size()]);
            list2 = ArrayUtils.copyListToArray(list2);
            if (DEBUG) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("manageChildren.enqueueManageChildren parent: ");
                stringBuilder.append(reactShadowNode.getReactTag());
                stringBuilder.append("\n\tIndices2Remove: ");
                stringBuilder.append(Arrays.toString(list));
                stringBuilder.append("\n\tViews2Add: ");
                stringBuilder.append(Arrays.toString(viewAtIndexArr));
                stringBuilder.append("\n\tTags2Delete: ");
                stringBuilder.append(Arrays.toString(list2));
                FLog.m5662d(str, stringBuilder.toString());
            }
            this.uiViewOperationQueue.enqueueManageChildren(reactShadowNode.getReactTag(), list, viewAtIndexArr, list2);
        }
    }

    private void enqueueUpdateProperties(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2) {
        int reactTag = reactShadowNode.getReactTag();
        if (DEBUG) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("manageChildren.enqueueUpdateProperties \n\ttag: ");
            stringBuilder.append(reactTag);
            stringBuilder.append("\n\tviewClass: ");
            stringBuilder.append(reactShadowNode.getViewClass());
            stringBuilder.append("\n\tinstanceHandle: ");
            stringBuilder.append(reactShadowNode.getInstanceHandle());
            stringBuilder.append("\n\tnewProps: ");
            stringBuilder.append(reactShadowNode.getNewProps());
            FLog.m5662d(str, stringBuilder.toString());
        }
        if (reactShadowNode2 != null) {
            reactShadowNode.updateScreenLayout(reactShadowNode2);
        }
        if (reactShadowNode.getNewProps() != null) {
            this.uiViewOperationQueue.enqueueUpdateProperties(reactTag, reactShadowNode.getViewClass(), reactShadowNode.getNewProps());
        }
        this.uiViewOperationQueue.enqueueUpdateInstanceHandle(reactTag, reactShadowNode.getInstanceHandle());
    }
}
