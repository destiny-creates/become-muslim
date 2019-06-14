package com.facebook.react.uimanager;

import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View.MeasureSpec;
import com.facebook.common.logging.FLog;
import com.facebook.react.animation.Animation;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.UIManagerModule.ViewManagerResolver;
import com.facebook.react.uimanager.common.MeasureSpecProvider;
import com.facebook.react.uimanager.common.SizeMonitoringFrameLayout;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.facebook.yoga.YogaDirection;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UIImplementation {
    protected final EventDispatcher mEventDispatcher;
    private long mLastCalculateLayoutTime;
    protected LayoutUpdateListener mLayoutUpdateListener;
    private final int[] mMeasureBuffer;
    private final Set<Integer> mMeasuredRootNodes;
    private final NativeViewHierarchyOptimizer mNativeViewHierarchyOptimizer;
    private final UIViewOperationQueue mOperationsQueue;
    protected final ReactApplicationContext mReactContext;
    protected final ShadowNodeRegistry mShadowNodeRegistry;
    private final ViewManagerRegistry mViewManagers;

    public interface LayoutUpdateListener {
        void onLayoutUpdated(ReactShadowNode reactShadowNode);
    }

    public void onHostDestroy() {
    }

    public UIImplementation(ReactApplicationContext reactApplicationContext, ViewManagerResolver viewManagerResolver, EventDispatcher eventDispatcher, int i) {
        this(reactApplicationContext, new ViewManagerRegistry(viewManagerResolver), eventDispatcher, i);
    }

    public UIImplementation(ReactApplicationContext reactApplicationContext, List<ViewManager> list, EventDispatcher eventDispatcher, int i) {
        this(reactApplicationContext, new ViewManagerRegistry((List) list), eventDispatcher, i);
    }

    private UIImplementation(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, EventDispatcher eventDispatcher, int i) {
        this(reactApplicationContext, viewManagerRegistry, new UIViewOperationQueue(reactApplicationContext, new NativeViewHierarchyManager(viewManagerRegistry), i), eventDispatcher);
    }

    protected UIImplementation(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, UIViewOperationQueue uIViewOperationQueue, EventDispatcher eventDispatcher) {
        this.mShadowNodeRegistry = new ShadowNodeRegistry();
        this.mMeasuredRootNodes = new HashSet();
        this.mMeasureBuffer = new int[4];
        this.mLastCalculateLayoutTime = 0;
        this.mReactContext = reactApplicationContext;
        this.mViewManagers = viewManagerRegistry;
        this.mOperationsQueue = uIViewOperationQueue;
        this.mNativeViewHierarchyOptimizer = new NativeViewHierarchyOptimizer(this.mOperationsQueue, this.mShadowNodeRegistry);
        this.mEventDispatcher = eventDispatcher;
    }

    protected ReactShadowNode createRootShadowNode() {
        ReactShadowNode reactShadowNodeImpl = new ReactShadowNodeImpl();
        if (I18nUtil.getInstance().isRTL(this.mReactContext)) {
            reactShadowNodeImpl.setLayoutDirection(YogaDirection.RTL);
        }
        reactShadowNodeImpl.setViewClassName("Root");
        return reactShadowNodeImpl;
    }

    protected ReactShadowNode createShadowNode(String str) {
        return this.mViewManagers.get(str).createShadowNodeInstance(this.mReactContext);
    }

    public final ReactShadowNode resolveShadowNode(int i) {
        return this.mShadowNodeRegistry.getNode(i);
    }

    protected final ViewManager resolveViewManager(String str) {
        return this.mViewManagers.get(str);
    }

    UIViewOperationQueue getUIViewOperationQueue() {
        return this.mOperationsQueue;
    }

    public void updateRootView(int i, int i2, int i3) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i);
        if (node == null) {
            String str = ReactConstants.TAG;
            i3 = new StringBuilder();
            i3.append("Tried to update non-existent root tag: ");
            i3.append(i);
            FLog.m5714w(str, i3.toString());
            return;
        }
        updateRootView(node, i2, i3);
    }

    public void updateRootView(ReactShadowNode reactShadowNode, int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        i = MeasureSpec.getSize(i);
        if (mode == LinearLayoutManager.INVALID_OFFSET) {
            reactShadowNode.setStyleMaxWidth((float) i);
        } else if (mode == 0) {
            reactShadowNode.setStyleWidthAuto();
        } else if (mode == 1073741824) {
            reactShadowNode.setStyleWidth((float) i);
        }
        i = MeasureSpec.getMode(i2);
        i2 = MeasureSpec.getSize(i2);
        if (i == LinearLayoutManager.INVALID_OFFSET) {
            reactShadowNode.setStyleMaxHeight((float) i2);
        } else if (i == 0) {
            reactShadowNode.setStyleHeightAuto();
        } else if (i == 1073741824) {
            reactShadowNode.setStyleHeight((float) i2);
        }
    }

    public <T extends SizeMonitoringFrameLayout & MeasureSpecProvider> void registerRootView(T t, int i, ThemedReactContext themedReactContext) {
        final ReactShadowNode createRootShadowNode = createRootShadowNode();
        createRootShadowNode.setReactTag(i);
        createRootShadowNode.setThemedContext(themedReactContext);
        MeasureSpecProvider measureSpecProvider = (MeasureSpecProvider) t;
        updateRootView(createRootShadowNode, measureSpecProvider.getWidthMeasureSpec(), measureSpecProvider.getHeightMeasureSpec());
        themedReactContext.runOnNativeModulesQueueThread(new Runnable() {
            public void run() {
                UIImplementation.this.mShadowNodeRegistry.addRootNode(createRootShadowNode);
            }
        });
        this.mOperationsQueue.addRootView(i, t, themedReactContext);
    }

    public void removeRootView(int i) {
        removeRootShadowNode(i);
        this.mOperationsQueue.enqueueRemoveRootView(i);
    }

    public void removeRootShadowNode(int i) {
        this.mShadowNodeRegistry.removeRootNode(i);
    }

    public void updateNodeSize(int i, int i2, int i3) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i);
        if (node == null) {
            String str = ReactConstants.TAG;
            i3 = new StringBuilder();
            i3.append("Tried to update size of non-existent tag: ");
            i3.append(i);
            FLog.m5714w(str, i3.toString());
            return;
        }
        node.setStyleWidth((float) i2);
        node.setStyleHeight((float) i3);
        dispatchViewUpdatesIfNeeded();
    }

    public void setViewLocalData(int i, Object obj) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i);
        if (node == null) {
            String str = ReactConstants.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Attempt to set local data for view with unknown tag: ");
            stringBuilder.append(i);
            FLog.m5714w(str, stringBuilder.toString());
            return;
        }
        node.setLocalData(obj);
        dispatchViewUpdatesIfNeeded();
    }

    public void profileNextBatch() {
        this.mOperationsQueue.profileNextBatch();
    }

    public Map<String, Long> getProfiledBatchPerfCounters() {
        return this.mOperationsQueue.getProfiledBatchPerfCounters();
    }

    public void createView(int i, String str, int i2, ReadableMap readableMap) {
        ReactShadowNode createShadowNode = createShadowNode(str);
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Root node with tag ");
        stringBuilder.append(i2);
        stringBuilder.append(" doesn't exist");
        Assertions.assertNotNull(node, stringBuilder.toString());
        createShadowNode.setReactTag(i);
        createShadowNode.setViewClassName(str);
        createShadowNode.setRootTag(node.getReactTag());
        createShadowNode.setThemedContext(node.getThemedContext());
        this.mShadowNodeRegistry.addNode(createShadowNode);
        if (readableMap != null) {
            i = new ReactStylesDiffMap(readableMap);
            createShadowNode.updateProperties(i);
        } else {
            i = 0;
        }
        handleCreateView(createShadowNode, i2, i);
    }

    protected void handleCreateView(ReactShadowNode reactShadowNode, int i, ReactStylesDiffMap reactStylesDiffMap) {
        if (reactShadowNode.isVirtual() == 0) {
            this.mNativeViewHierarchyOptimizer.handleCreateView(reactShadowNode, reactShadowNode.getThemedContext(), reactStylesDiffMap);
        }
    }

    public void updateView(int i, String str, ReadableMap readableMap) {
        if (this.mViewManagers.get(str) != null) {
            ReactShadowNode node = this.mShadowNodeRegistry.getNode(i);
            if (node == null) {
                readableMap = new StringBuilder();
                readableMap.append("Trying to update non-existent view with tag ");
                readableMap.append(i);
                throw new IllegalViewOperationException(readableMap.toString());
            } else if (readableMap != null) {
                i = new ReactStylesDiffMap(readableMap);
                node.updateProperties(i);
                handleUpdateView(node, str, i);
                return;
            } else {
                return;
            }
        }
        readableMap = new StringBuilder();
        readableMap.append("Got unknown view type: ");
        readableMap.append(str);
        throw new IllegalViewOperationException(readableMap.toString());
    }

    public void synchronouslyUpdateViewOnUIThread(int i, ReactStylesDiffMap reactStylesDiffMap) {
        UiThreadUtil.assertOnUiThread();
        this.mOperationsQueue.getNativeViewHierarchyManager().updateProperties(i, reactStylesDiffMap);
    }

    protected void handleUpdateView(ReactShadowNode reactShadowNode, String str, ReactStylesDiffMap reactStylesDiffMap) {
        if (!reactShadowNode.isVirtual()) {
            this.mNativeViewHierarchyOptimizer.handleUpdateView(reactShadowNode, str, reactStylesDiffMap);
        }
    }

    public void manageChildren(int i, ReadableArray readableArray, ReadableArray readableArray2, ReadableArray readableArray3, ReadableArray readableArray4, ReadableArray readableArray5) {
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr;
        int i6;
        ReadableArray readableArray6 = readableArray;
        ReadableArray readableArray7 = readableArray2;
        ReadableArray readableArray8 = readableArray3;
        ReadableArray readableArray9 = readableArray4;
        ReadableArray readableArray10 = readableArray5;
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i);
        if (readableArray6 == null) {
            i2 = 0;
        } else {
            i2 = readableArray.size();
        }
        if (readableArray8 == null) {
            i3 = 0;
        } else {
            i3 = readableArray3.size();
        }
        if (readableArray10 == null) {
            i4 = 0;
        } else {
            i4 = readableArray5.size();
        }
        if (i2 != 0) {
            if (readableArray7 == null || i2 != readableArray2.size()) {
                throw new IllegalViewOperationException("Size of moveFrom != size of moveTo!");
            }
        }
        if (i3 != 0) {
            if (readableArray9 == null || i3 != readableArray4.size()) {
                throw new IllegalViewOperationException("Size of addChildTags != size of addAtIndices!");
            }
        }
        ViewAtIndex[] viewAtIndexArr = new ViewAtIndex[(i2 + i3)];
        int[] iArr2 = new int[(i2 + i4)];
        int[] iArr3 = new int[iArr2.length];
        int[] iArr4 = new int[i4];
        if (i2 > 0) {
            Assertions.assertNotNull(readableArray);
            Assertions.assertNotNull(readableArray2);
            int i7 = 0;
            while (i7 < i2) {
                i5 = readableArray6.getInt(i7);
                int reactTag = node.getChildAt(i5).getReactTag();
                iArr = iArr4;
                viewAtIndexArr[i7] = new ViewAtIndex(reactTag, readableArray7.getInt(i7));
                iArr2[i7] = i5;
                iArr3[i7] = reactTag;
                i7++;
                iArr4 = iArr;
                UIImplementation uIImplementation = this;
                i6 = i;
                readableArray6 = readableArray;
            }
        }
        iArr = iArr4;
        if (i3 > 0) {
            Assertions.assertNotNull(readableArray3);
            Assertions.assertNotNull(readableArray4);
            for (i5 = 0; i5 < i3; i5++) {
                viewAtIndexArr[i2 + i5] = new ViewAtIndex(readableArray8.getInt(i5), readableArray9.getInt(i5));
            }
        }
        if (i4 > 0) {
            Assertions.assertNotNull(readableArray5);
            for (i5 = 0; i5 < i4; i5++) {
                i6 = readableArray10.getInt(i5);
                reactTag = node.getChildAt(i6).getReactTag();
                int i8 = i2 + i5;
                iArr2[i8] = i6;
                iArr3[i8] = reactTag;
                iArr[i5] = reactTag;
            }
        }
        Arrays.sort(viewAtIndexArr, ViewAtIndex.COMPARATOR);
        Arrays.sort(iArr2);
        i5 = iArr2.length - 1;
        i6 = -1;
        while (i5 >= 0) {
            if (iArr2[i5] != i6) {
                node.removeChildAt(iArr2[i5]);
                i6 = iArr2[i5];
                i5--;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Repeated indices in Removal list for view tag: ");
                stringBuilder.append(i);
                throw new IllegalViewOperationException(stringBuilder.toString());
            }
        }
        i5 = 0;
        while (i5 < viewAtIndexArr.length) {
            ViewAtIndex viewAtIndex = viewAtIndexArr[i5];
            ReactShadowNode node2 = this.mShadowNodeRegistry.getNode(viewAtIndex.mTag);
            if (node2 != null) {
                node.addChildAt(node2, viewAtIndex.mIndex);
                i5++;
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Trying to add unknown view tag: ");
                stringBuilder2.append(viewAtIndex.mTag);
                throw new IllegalViewOperationException(stringBuilder2.toString());
            }
        }
        UIImplementation uIImplementation2 = this;
        if (!(node.isVirtual() || node.isVirtualAnchor())) {
            uIImplementation2.mNativeViewHierarchyOptimizer.handleManageChildren(node, iArr2, iArr3, viewAtIndexArr, iArr);
        }
        int[] iArr5 = iArr;
        for (int node3 : iArr5) {
            removeShadowNode(uIImplementation2.mShadowNodeRegistry.getNode(node3));
        }
    }

    public void setChildren(int i, ReadableArray readableArray) {
        i = this.mShadowNodeRegistry.getNode(i);
        int i2 = 0;
        while (i2 < readableArray.size()) {
            ReactShadowNode node = this.mShadowNodeRegistry.getNode(readableArray.getInt(i2));
            if (node != null) {
                i.addChildAt(node, i2);
                i2++;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Trying to add unknown view tag: ");
                stringBuilder.append(readableArray.getInt(i2));
                throw new IllegalViewOperationException(stringBuilder.toString());
            }
        }
        if (!i.isVirtual() && !i.isVirtualAnchor()) {
            this.mNativeViewHierarchyOptimizer.handleSetChildren(i, readableArray);
        }
    }

    public void replaceExistingNonRootView(int i, int i2) {
        if (this.mShadowNodeRegistry.isRootNode(i) || this.mShadowNodeRegistry.isRootNode(i2)) {
            throw new IllegalViewOperationException("Trying to add or replace a root tag!");
        }
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i);
        if (node != null) {
            ReactShadowNode parent = node.getParent();
            if (parent != null) {
                i = parent.indexOf(node);
                if (i >= 0) {
                    ReadableArray createArray = Arguments.createArray();
                    createArray.pushInt(i2);
                    ReadableArray createArray2 = Arguments.createArray();
                    createArray2.pushInt(i);
                    ReadableArray createArray3 = Arguments.createArray();
                    createArray3.pushInt(i);
                    manageChildren(parent.getReactTag(), null, null, createArray, createArray2, createArray3);
                    return;
                }
                throw new IllegalStateException("Didn't find child tag in parent");
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Node is not attached to a parent: ");
            stringBuilder.append(i);
            throw new IllegalViewOperationException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Trying to replace unknown view tag: ");
        stringBuilder.append(i);
        throw new IllegalViewOperationException(stringBuilder.toString());
    }

    public void removeSubviewsFromContainerWithID(int i) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i);
        if (node != null) {
            ReadableArray createArray = Arguments.createArray();
            for (int i2 = 0; i2 < node.getChildCount(); i2++) {
                createArray.pushInt(i2);
            }
            manageChildren(i, null, null, null, null, createArray);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Trying to remove subviews of an unknown view tag: ");
        stringBuilder.append(i);
        throw new IllegalViewOperationException(stringBuilder.toString());
    }

    public void findSubviewIn(int i, float f, float f2, Callback callback) {
        this.mOperationsQueue.enqueueFindTargetForTouch(i, f, f2, callback);
    }

    public void viewIsDescendantOf(int i, int i2, Callback callback) {
        i = this.mShadowNodeRegistry.getNode(i);
        i2 = this.mShadowNodeRegistry.getNode(i2);
        if (i != 0) {
            if (i2 != 0) {
                callback.invoke(Boolean.valueOf(i.isDescendantOf(i2)));
                return;
            }
        }
        callback.invoke(new Object[]{Boolean.valueOf(false)});
    }

    public void measure(int i, Callback callback) {
        this.mOperationsQueue.enqueueMeasure(i, callback);
    }

    public void measureInWindow(int i, Callback callback) {
        this.mOperationsQueue.enqueueMeasureInWindow(i, callback);
    }

    public void measureLayout(int i, int i2, Callback callback, Callback callback2) {
        try {
            measureLayout(i, i2, this.mMeasureBuffer);
            i = PixelUtil.toDIPFromPixel((float) this.mMeasureBuffer[0]);
            i2 = PixelUtil.toDIPFromPixel((float) this.mMeasureBuffer[1]);
            float toDIPFromPixel = PixelUtil.toDIPFromPixel((float) this.mMeasureBuffer[2]);
            float toDIPFromPixel2 = PixelUtil.toDIPFromPixel((float) this.mMeasureBuffer[3]);
            callback2.invoke(Float.valueOf(i), Float.valueOf(i2), Float.valueOf(toDIPFromPixel), Float.valueOf(toDIPFromPixel2));
        } catch (int i3) {
            callback.invoke(new Object[]{i3.getMessage()});
        }
    }

    public void measureLayoutRelativeToParent(int i, Callback callback, Callback callback2) {
        try {
            measureLayoutRelativeToParent(i, this.mMeasureBuffer);
            i = PixelUtil.toDIPFromPixel((float) this.mMeasureBuffer[0]);
            float toDIPFromPixel = PixelUtil.toDIPFromPixel((float) this.mMeasureBuffer[1]);
            float toDIPFromPixel2 = PixelUtil.toDIPFromPixel((float) this.mMeasureBuffer[2]);
            float toDIPFromPixel3 = PixelUtil.toDIPFromPixel((float) this.mMeasureBuffer[3]);
            callback2.invoke(Float.valueOf(i), Float.valueOf(toDIPFromPixel), Float.valueOf(toDIPFromPixel2), Float.valueOf(toDIPFromPixel3));
        } catch (int i2) {
            callback.invoke(new Object[]{i2.getMessage()});
        }
    }

    public void dispatchViewUpdates(int i) {
        SystraceMessage.beginSection(0, "UIImplementation.dispatchViewUpdates").arg("batchId", i).flush();
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            updateViewHierarchy();
            this.mNativeViewHierarchyOptimizer.onBatchComplete();
            this.mOperationsQueue.dispatchViewUpdates(i, uptimeMillis, this.mLastCalculateLayoutTime);
        } finally {
            Systrace.endSection(0);
        }
    }

    private void dispatchViewUpdatesIfNeeded() {
        if (this.mOperationsQueue.isEmpty()) {
            dispatchViewUpdates(-1);
        }
    }

    protected void updateViewHierarchy() {
        Systrace.beginSection(0, "UIImplementation.updateViewHierarchy");
        int i = 0;
        while (i < this.mShadowNodeRegistry.getRootNodeCount()) {
            try {
                int rootTag = this.mShadowNodeRegistry.getRootTag(i);
                ReactShadowNode node = this.mShadowNodeRegistry.getNode(rootTag);
                if (this.mMeasuredRootNodes.contains(Integer.valueOf(rootTag))) {
                    SystraceMessage.beginSection(0, "UIImplementation.notifyOnBeforeLayoutRecursive").arg("rootTag", node.getReactTag()).flush();
                    notifyOnBeforeLayoutRecursive(node);
                    calculateRootLayout(node);
                    SystraceMessage.beginSection(0, "UIImplementation.applyUpdatesRecursive").arg("rootTag", node.getReactTag()).flush();
                    applyUpdatesRecursive(node, 0.0f, 0.0f);
                    if (this.mLayoutUpdateListener != null) {
                        this.mLayoutUpdateListener.onLayoutUpdated(node);
                    }
                    i++;
                } else {
                    continue;
                    i++;
                }
            } catch (Throwable th) {
                i = th;
            } finally {
                Systrace.endSection(0);
            }
        }
        Systrace.endSection(0);
    }

    public void registerAnimation(Animation animation) {
        this.mOperationsQueue.enqueueRegisterAnimation(animation);
    }

    public void addAnimation(int i, int i2, Callback callback) {
        assertViewExists(i, "addAnimation");
        this.mOperationsQueue.enqueueAddAnimation(i, i2, callback);
    }

    public void removeAnimation(int i, int i2) {
        assertViewExists(i, "removeAnimation");
        this.mOperationsQueue.enqueueRemoveAnimation(i2);
    }

    public void setLayoutAnimationEnabledExperimental(boolean z) {
        this.mOperationsQueue.enqueueSetLayoutAnimationEnabled(z);
    }

    public void configureNextLayoutAnimation(ReadableMap readableMap, Callback callback, Callback callback2) {
        this.mOperationsQueue.enqueueConfigureLayoutAnimation(readableMap, callback, callback2);
    }

    public void setJSResponder(int i, boolean z) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i);
        if (node != null) {
            while (true) {
                if (!node.isVirtual()) {
                    if (!node.isLayoutOnly()) {
                        this.mOperationsQueue.enqueueSetJSResponder(node.getReactTag(), i, z);
                        return;
                    }
                }
                node = node.getParent();
            }
        }
    }

    public void clearJSResponder() {
        this.mOperationsQueue.enqueueClearJSResponder();
    }

    public void dispatchViewManagerCommand(int i, int i2, ReadableArray readableArray) {
        assertViewExists(i, "dispatchViewManagerCommand");
        this.mOperationsQueue.enqueueDispatchCommand(i, i2, readableArray);
    }

    public void showPopupMenu(int i, ReadableArray readableArray, Callback callback, Callback callback2) {
        assertViewExists(i, "showPopupMenu");
        this.mOperationsQueue.enqueueShowPopupMenu(i, readableArray, callback, callback2);
    }

    public void dismissPopupMenu() {
        this.mOperationsQueue.enqueueDismissPopupMenu();
    }

    public void sendAccessibilityEvent(int i, int i2) {
        this.mOperationsQueue.enqueueSendAccessibilityEvent(i, i2);
    }

    public void onHostResume() {
        this.mOperationsQueue.resumeFrameCallback();
    }

    public void onHostPause() {
        this.mOperationsQueue.pauseFrameCallback();
    }

    public void setViewHierarchyUpdateDebugListener(NotThreadSafeViewHierarchyUpdateDebugListener notThreadSafeViewHierarchyUpdateDebugListener) {
        this.mOperationsQueue.setViewHierarchyUpdateDebugListener(notThreadSafeViewHierarchyUpdateDebugListener);
    }

    protected final void removeShadowNode(ReactShadowNode reactShadowNode) {
        removeShadowNodeRecursive(reactShadowNode);
        reactShadowNode.dispose();
    }

    private void removeShadowNodeRecursive(ReactShadowNode reactShadowNode) {
        NativeViewHierarchyOptimizer.handleRemoveNode(reactShadowNode);
        this.mShadowNodeRegistry.removeNode(reactShadowNode.getReactTag());
        this.mMeasuredRootNodes.remove(Integer.valueOf(reactShadowNode.getReactTag()));
        for (int childCount = reactShadowNode.getChildCount() - 1; childCount >= 0; childCount--) {
            removeShadowNodeRecursive(reactShadowNode.getChildAt(childCount));
        }
        reactShadowNode.removeAndDisposeAllChildren();
    }

    private void measureLayout(int i, int i2, int[] iArr) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i);
        ReactShadowNode node2 = this.mShadowNodeRegistry.getNode(i2);
        if (node != null) {
            if (node2 != null) {
                if (node != node2) {
                    ReactShadowNode parent = node.getParent();
                    while (parent != node2) {
                        if (parent != null) {
                            parent = parent.getParent();
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Tag ");
                            stringBuilder.append(i2);
                            stringBuilder.append(" is not an ancestor of tag ");
                            stringBuilder.append(i);
                            throw new IllegalViewOperationException(stringBuilder.toString());
                        }
                    }
                }
                measureLayoutRelativeToVerifiedAncestor(node, node2, iArr);
                return;
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Tag ");
        if (node != null) {
            i = i2;
        }
        stringBuilder2.append(i);
        stringBuilder2.append(" does not exist");
        throw new IllegalViewOperationException(stringBuilder2.toString());
    }

    private void measureLayoutRelativeToParent(int i, int[] iArr) {
        ReactShadowNode node = this.mShadowNodeRegistry.getNode(i);
        if (node != null) {
            ReactShadowNode parent = node.getParent();
            if (parent != null) {
                measureLayoutRelativeToVerifiedAncestor(node, parent, iArr);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("View with tag ");
            stringBuilder.append(i);
            stringBuilder.append(" doesn't have a parent!");
            throw new IllegalViewOperationException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("No native view for tag ");
        stringBuilder.append(i);
        stringBuilder.append(" exists!");
        throw new IllegalViewOperationException(stringBuilder.toString());
    }

    private void measureLayoutRelativeToVerifiedAncestor(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2, int[] iArr) {
        int round;
        int round2;
        if (reactShadowNode != reactShadowNode2) {
            round = Math.round(reactShadowNode.getLayoutX());
            round2 = Math.round(reactShadowNode.getLayoutY());
            for (ReactShadowNode parent = reactShadowNode.getParent(); parent != reactShadowNode2; parent = parent.getParent()) {
                Assertions.assertNotNull(parent);
                assertNodeDoesNotNeedCustomLayoutForChildren(parent);
                round += Math.round(parent.getLayoutX());
                round2 += Math.round(parent.getLayoutY());
            }
            assertNodeDoesNotNeedCustomLayoutForChildren(reactShadowNode2);
        } else {
            round = 0;
            round2 = 0;
        }
        iArr[0] = round;
        iArr[1] = round2;
        iArr[2] = reactShadowNode.getScreenWidth();
        iArr[3] = reactShadowNode.getScreenHeight();
    }

    private void assertViewExists(int i, String str) {
        if (this.mShadowNodeRegistry.getNode(i) == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to execute operation ");
            stringBuilder.append(str);
            stringBuilder.append(" on view with tag: ");
            stringBuilder.append(i);
            stringBuilder.append(", since the view does not exists");
            throw new IllegalViewOperationException(stringBuilder.toString());
        }
    }

    private void assertNodeDoesNotNeedCustomLayoutForChildren(ReactShadowNode reactShadowNode) {
        ViewManager viewManager = (ViewManager) Assertions.assertNotNull(this.mViewManagers.get(reactShadowNode.getViewClass()));
        if (viewManager instanceof ViewGroupManager) {
            ViewGroupManager viewGroupManager = (ViewGroupManager) viewManager;
            if (viewGroupManager == null) {
                return;
            }
            if (viewGroupManager.needsCustomLayoutForChildren()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Trying to measure a view using measureLayout/measureLayoutRelativeToParent relative to an ancestor that requires custom layout for it's children (");
                stringBuilder.append(reactShadowNode.getViewClass());
                stringBuilder.append("). Use measure instead.");
                throw new IllegalViewOperationException(stringBuilder.toString());
            }
            return;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Trying to use view ");
        stringBuilder.append(reactShadowNode.getViewClass());
        stringBuilder.append(" as a parent, but its Manager doesn't extends ViewGroupManager");
        throw new IllegalViewOperationException(stringBuilder.toString());
    }

    private void notifyOnBeforeLayoutRecursive(ReactShadowNode reactShadowNode) {
        if (reactShadowNode.hasUpdates()) {
            for (int i = 0; i < reactShadowNode.getChildCount(); i++) {
                notifyOnBeforeLayoutRecursive(reactShadowNode.getChildAt(i));
            }
            reactShadowNode.onBeforeLayout();
        }
    }

    protected void calculateRootLayout(ReactShadowNode reactShadowNode) {
        SystraceMessage.beginSection(0, "cssRoot.calculateLayout").arg("rootTag", reactShadowNode.getReactTag()).flush();
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            reactShadowNode.calculateLayout();
        } finally {
            Systrace.endSection(0);
            this.mLastCalculateLayoutTime = SystemClock.uptimeMillis() - uptimeMillis;
        }
    }

    protected void applyUpdatesRecursive(ReactShadowNode reactShadowNode, float f, float f2) {
        if (reactShadowNode.hasUpdates()) {
            int i;
            if (!reactShadowNode.isVirtualAnchor()) {
                for (i = 0; i < reactShadowNode.getChildCount(); i++) {
                    applyUpdatesRecursive(reactShadowNode.getChildAt(i), reactShadowNode.getLayoutX() + f, reactShadowNode.getLayoutY() + f2);
                }
            }
            i = reactShadowNode.getReactTag();
            if (!(this.mShadowNodeRegistry.isRootNode(i) || reactShadowNode.dispatchUpdates(f, f2, this.mOperationsQueue, this.mNativeViewHierarchyOptimizer) == null || reactShadowNode.shouldNotifyOnLayout() == null)) {
                this.mEventDispatcher.dispatchEvent(OnLayoutEvent.obtain(i, reactShadowNode.getScreenX(), reactShadowNode.getScreenY(), reactShadowNode.getScreenWidth(), reactShadowNode.getScreenHeight()));
            }
            reactShadowNode.markUpdateSeen();
        }
    }

    public void addUIBlock(UIBlock uIBlock) {
        this.mOperationsQueue.enqueueUIBlock(uIBlock);
    }

    public void prependUIBlock(UIBlock uIBlock) {
        this.mOperationsQueue.prependUIBlock(uIBlock);
    }

    public int resolveRootTagFromReactTag(int i) {
        if (this.mShadowNodeRegistry.isRootNode(i)) {
            return i;
        }
        ReactShadowNode resolveShadowNode = resolveShadowNode(i);
        int i2 = 0;
        if (resolveShadowNode != null) {
            i2 = resolveShadowNode.getRootTag();
        } else {
            String str = ReactConstants.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Warning : attempted to resolve a non-existent react shadow node. reactTag=");
            stringBuilder.append(i);
            FLog.m5714w(str, stringBuilder.toString());
        }
        return i2;
    }

    public void enableLayoutCalculationForRootNode(int i) {
        this.mMeasuredRootNodes.add(Integer.valueOf(i));
    }

    public void setLayoutUpdateListener(LayoutUpdateListener layoutUpdateListener) {
        this.mLayoutUpdateListener = layoutUpdateListener;
    }

    public void removeLayoutUpdateListener() {
        this.mLayoutUpdateListener = null;
    }
}
