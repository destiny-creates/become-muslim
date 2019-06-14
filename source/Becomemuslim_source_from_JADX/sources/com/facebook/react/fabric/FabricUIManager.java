package com.facebook.react.fabric;

import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View.MeasureSpec;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.fabric.events.FabricEventEmitter;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.ReactRootViewTagGenerator;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.react.uimanager.common.MeasureSpecProvider;
import com.facebook.react.uimanager.common.SizeMonitoringFrameLayout;
import com.facebook.react.uimanager.common.SizeMonitoringFrameLayout.OnSizeChangedListener;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.facebook.yoga.YogaDirection;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@DoNotStrip
public class FabricUIManager implements UIManager, JSHandler {
    private static final boolean DEBUG = PrinterHolder.getPrinter().shouldDisplayLogMessage(ReactDebugOverlayTags.FABRIC_UI_MANAGER);
    private static final String TAG = "FabricUIManager";
    private FabricBinding mBinding;
    private volatile int mCurrentBatch = 0;
    private final EventDispatcher mEventDispatcher;
    private long mEventHandlerPointer;
    private final FabricEventEmitter mFabricEventEmitter;
    private final FabricReconciler mFabricReconciler;
    private final JavaScriptContextHolder mJSContext;
    private long mLastCalculateLayoutTime = 0;
    private final NativeViewHierarchyManager mNativeViewHierarchyManager;
    private final ReactApplicationContext mReactApplicationContext;
    private final RootShadowNodeRegistry mRootShadowNodeRegistry = new RootShadowNodeRegistry();
    private final UIViewOperationQueue mUIViewOperationQueue;
    private final ViewManagerRegistry mViewManagerRegistry;

    public void clearJSResponder() {
    }

    public void setJSResponder(int i, boolean z) {
    }

    public FabricUIManager(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, JavaScriptContextHolder javaScriptContextHolder, EventDispatcher eventDispatcher) {
        DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(reactApplicationContext);
        this.mReactApplicationContext = reactApplicationContext;
        this.mViewManagerRegistry = viewManagerRegistry;
        this.mNativeViewHierarchyManager = new NativeViewHierarchyManager(viewManagerRegistry);
        this.mUIViewOperationQueue = new UIViewOperationQueue(reactApplicationContext, this.mNativeViewHierarchyManager, 0);
        this.mFabricReconciler = new FabricReconciler(this.mUIViewOperationQueue);
        this.mFabricEventEmitter = new FabricEventEmitter(this.mReactApplicationContext, this);
        this.mEventDispatcher = eventDispatcher;
        this.mJSContext = javaScriptContextHolder;
    }

    public void setBinding(FabricBinding fabricBinding) {
        this.mBinding = fabricBinding;
    }

    @DoNotStrip
    public ReactShadowNode createNode(int i, String str, int i2, ReadableNativeMap readableNativeMap, long j) {
        if (DEBUG) {
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("createNode \n\ttag: ");
            stringBuilder.append(i);
            stringBuilder.append("\n\tviewName: ");
            stringBuilder.append(str);
            stringBuilder.append("\n\trootTag: ");
            stringBuilder.append(i2);
            stringBuilder.append("\n\tprops: ");
            stringBuilder.append(readableNativeMap);
            FLog.m5662d(str2, stringBuilder.toString());
        }
        try {
            ReactShadowNode createShadowNodeInstance = this.mViewManagerRegistry.get(str).createShadowNodeInstance(this.mReactApplicationContext);
            ReactShadowNode rootNode = getRootNode(i2);
            createShadowNodeInstance.setRootTag(rootNode.getReactTag());
            createShadowNodeInstance.setViewClassName(str);
            createShadowNodeInstance.setInstanceHandle(j);
            createShadowNodeInstance.setReactTag(i);
            createShadowNodeInstance.setThemedContext(rootNode.getThemedContext());
            readableNativeMap = updateProps(createShadowNodeInstance, readableNativeMap);
            if (createShadowNodeInstance.isVirtual() == null) {
                this.mUIViewOperationQueue.enqueueCreateView(rootNode.getThemedContext(), i, str, readableNativeMap);
            }
            return createShadowNodeInstance;
        } catch (int i3) {
            handleException(getRootNode(i2), i3);
            return 0;
        }
    }

    @VisibleForTesting
    ReactShadowNode getRootNode(int i) {
        return this.mRootShadowNodeRegistry.getNode(i);
    }

    private ReactStylesDiffMap updateProps(ReactShadowNode reactShadowNode, ReadableNativeMap readableNativeMap) {
        if (readableNativeMap == null) {
            return null;
        }
        ReactStylesDiffMap reactStylesDiffMap = new ReactStylesDiffMap(readableNativeMap);
        reactShadowNode.updateProperties(reactStylesDiffMap);
        return reactStylesDiffMap;
    }

    @DoNotStrip
    public ReactShadowNode cloneNode(ReactShadowNode reactShadowNode) {
        if (DEBUG) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("cloneNode \n\tnode: ");
            stringBuilder.append(reactShadowNode);
            FLog.m5662d(str, stringBuilder.toString());
        }
        SystraceMessage.beginSection(0, "FabricUIManager.cloneNode").flush();
        try {
            ReactShadowNode mutableCopy = reactShadowNode.mutableCopy(reactShadowNode.getInstanceHandle());
            assertReactShadowNodeCopy(reactShadowNode, mutableCopy);
            Systrace.endSection(0);
            return mutableCopy;
        } catch (ReactShadowNode reactShadowNode2) {
            Systrace.endSection(0);
            throw reactShadowNode2;
        }
    }

    @DoNotStrip
    public ReactShadowNode cloneNodeWithNewChildren(ReactShadowNode reactShadowNode) {
        if (DEBUG) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("cloneNodeWithNewChildren \n\tnode: ");
            stringBuilder.append(reactShadowNode);
            FLog.m5662d(str, stringBuilder.toString());
        }
        SystraceMessage.beginSection(0, "FabricUIManager.cloneNodeWithNewChildren").flush();
        try {
            ReactShadowNode mutableCopyWithNewChildren = reactShadowNode.mutableCopyWithNewChildren(reactShadowNode.getInstanceHandle());
            assertReactShadowNodeCopy(reactShadowNode, mutableCopyWithNewChildren);
            Systrace.endSection(0);
            return mutableCopyWithNewChildren;
        } catch (ReactShadowNode reactShadowNode2) {
            Systrace.endSection(0);
            throw reactShadowNode2;
        }
    }

    @DoNotStrip
    public ReactShadowNode cloneNodeWithNewProps(ReactShadowNode reactShadowNode, ReadableNativeMap readableNativeMap) {
        if (DEBUG) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("cloneNodeWithNewProps \n\tnode: ");
            stringBuilder.append(reactShadowNode);
            stringBuilder.append("\n\tprops: ");
            stringBuilder.append(readableNativeMap);
            FLog.m5662d(str, stringBuilder.toString());
        }
        SystraceMessage.beginSection(0, "FabricUIManager.cloneNodeWithNewProps").flush();
        try {
            readableNativeMap = reactShadowNode.mutableCopyWithNewProps(reactShadowNode.getInstanceHandle(), readableNativeMap == null ? null : new ReactStylesDiffMap(readableNativeMap));
            assertReactShadowNodeCopy(reactShadowNode, readableNativeMap);
            return readableNativeMap;
        } catch (Throwable th) {
            readableNativeMap = th;
            handleException(reactShadowNode, readableNativeMap);
            return null;
        } finally {
            Systrace.endSection(0);
        }
    }

    @DoNotStrip
    public ReactShadowNode cloneNodeWithNewChildrenAndProps(ReactShadowNode reactShadowNode, ReadableNativeMap readableNativeMap) {
        if (DEBUG) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("cloneNodeWithNewChildrenAndProps \n\tnode: ");
            stringBuilder.append(reactShadowNode);
            stringBuilder.append("\n\tnewProps: ");
            stringBuilder.append(readableNativeMap);
            FLog.m5662d(str, stringBuilder.toString());
        }
        SystraceMessage.beginSection(0, "FabricUIManager.cloneNodeWithNewChildrenAndProps").flush();
        try {
            readableNativeMap = reactShadowNode.mutableCopyWithNewChildrenAndProps(reactShadowNode.getInstanceHandle(), readableNativeMap == null ? null : new ReactStylesDiffMap(readableNativeMap));
            assertReactShadowNodeCopy(reactShadowNode, readableNativeMap);
            return readableNativeMap;
        } catch (Throwable th) {
            readableNativeMap = th;
            handleException(reactShadowNode, readableNativeMap);
            return null;
        } finally {
            Systrace.endSection(0);
        }
    }

    private void assertReactShadowNodeCopy(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2) {
        boolean equals = reactShadowNode.getClass().equals(reactShadowNode2.getClass());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Found ");
        stringBuilder.append(reactShadowNode2.getClass());
        stringBuilder.append(" class when expecting: ");
        stringBuilder.append(reactShadowNode.getClass());
        stringBuilder.append(". Check that ");
        stringBuilder.append(reactShadowNode.getClass());
        stringBuilder.append(" implements the copy() method correctly.");
        Assertions.assertCondition(equals, stringBuilder.toString());
    }

    @DoNotStrip
    public void appendChild(ReactShadowNode reactShadowNode, ReactShadowNode reactShadowNode2) {
        if (DEBUG) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("appendChild \n\tparent: ");
            stringBuilder.append(reactShadowNode);
            stringBuilder.append("\n\tchild: ");
            stringBuilder.append(reactShadowNode2);
            FLog.m5662d(str, stringBuilder.toString());
        }
        SystraceMessage.beginSection(0, "FabricUIManager.appendChild").flush();
        try {
            if (reactShadowNode2.isSealed()) {
                reactShadowNode2 = reactShadowNode2.mutableCopy(reactShadowNode2.getInstanceHandle());
            }
            reactShadowNode.addChildAt(reactShadowNode2, reactShadowNode.getChildCount());
        } catch (Throwable th) {
            Systrace.endSection(0);
        }
        Systrace.endSection(0);
    }

    @DoNotStrip
    public List<ReactShadowNode> createChildSet(int i) {
        if (DEBUG) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("createChildSet rootTag: ");
            stringBuilder.append(i);
            FLog.m5662d(str, stringBuilder.toString());
        }
        return new ArrayList(1);
    }

    @DoNotStrip
    public void appendChildToSet(List<ReactShadowNode> list, ReactShadowNode reactShadowNode) {
        list.add(reactShadowNode);
    }

    @DoNotStrip
    public synchronized void completeRoot(int i, List<ReactShadowNode> list) {
        SystraceMessage.beginSection(0, "FabricUIManager.completeRoot").flush();
        try {
            String str;
            StringBuilder stringBuilder;
            long uptimeMillis = SystemClock.uptimeMillis();
            if (list == null) {
                list = new LinkedList();
            }
            if (DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("completeRoot rootTag: ");
                stringBuilder.append(i);
                stringBuilder.append(", childList: ");
                stringBuilder.append(list);
                FLog.m5662d(str, stringBuilder.toString());
            }
            ReactShadowNode rootNode = getRootNode(i);
            stringBuilder = new StringBuilder();
            stringBuilder.append("Root view with tag ");
            stringBuilder.append(i);
            stringBuilder.append(" must be added before completeRoot is called");
            Assertions.assertNotNull(rootNode, stringBuilder.toString());
            list = calculateDiffingAndCreateNewRootNode(rootNode, list);
            if (DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("ReactShadowNodeHierarchy after diffing: ");
                stringBuilder.append(list.getHierarchyInfo());
                FLog.m5662d(str, stringBuilder.toString());
            }
            applyUpdatesRecursive(list);
            UIViewOperationQueue uIViewOperationQueue = this.mUIViewOperationQueue;
            int i2 = this.mCurrentBatch;
            this.mCurrentBatch = i2 + 1;
            uIViewOperationQueue.dispatchViewUpdates(i2, uptimeMillis, this.mLastCalculateLayoutTime);
            this.mRootShadowNodeRegistry.replaceNode(list);
        } catch (List<ReactShadowNode> list2) {
            try {
                handleException(getRootNode(i), list2);
            } catch (Throwable th) {
                Systrace.endSection(0);
            }
        }
        Systrace.endSection(0);
    }

    public void dispatchCommand(int i, int i2, ReadableArray readableArray) {
        this.mUIViewOperationQueue.enqueueDispatchCommand(i, i2, readableArray);
    }

    private void notifyOnBeforeLayoutRecursive(ReactShadowNode reactShadowNode) {
        if (reactShadowNode.hasUpdates()) {
            for (int i = 0; i < reactShadowNode.getChildCount(); i++) {
                notifyOnBeforeLayoutRecursive(reactShadowNode.getChildAt(i));
            }
            reactShadowNode.onBeforeLayout();
        }
    }

    private ReactShadowNode calculateDiffingAndCreateNewRootNode(ReactShadowNode reactShadowNode, List<ReactShadowNode> list) {
        ReactShadowNode beginSection = SystraceMessage.beginSection(0, "FabricUIManager.calculateDiffingAndCreateNewRootNode");
        beginSection.flush();
        try {
            String str;
            StringBuilder stringBuilder;
            beginSection = reactShadowNode.mutableCopyWithNewChildren(reactShadowNode.getInstanceHandle());
            for (ReactShadowNode appendChild : list) {
                appendChild(beginSection, appendChild);
            }
            if (DEBUG != null) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("ReactShadowNodeHierarchy before calculateLayout: ");
                stringBuilder.append(beginSection.getHierarchyInfo());
                FLog.m5662d(str, stringBuilder.toString());
            }
            notifyOnBeforeLayoutRecursive(beginSection);
            calculateLayout(beginSection);
            if (DEBUG != null) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("ReactShadowNodeHierarchy after calculateLayout: ");
                stringBuilder.append(beginSection.getHierarchyInfo());
                FLog.m5662d(str, stringBuilder.toString());
            }
            this.mFabricReconciler.manageChildren(reactShadowNode, beginSection);
            return beginSection;
        } finally {
            Systrace.endSection(0);
        }
    }

    private void calculateLayout(ReactShadowNode reactShadowNode) {
        SystraceMessage.beginSection(0, "FabricUIManager.calculateLayout").flush();
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            reactShadowNode.calculateLayout();
        } finally {
            this.mLastCalculateLayoutTime = SystemClock.uptimeMillis() - uptimeMillis;
            Systrace.endSection(0);
        }
    }

    private void applyUpdatesRecursive(ReactShadowNode reactShadowNode) {
        SystraceMessage.beginSection(0, "FabricUIManager.applyUpdatesRecursive").flush();
        try {
            applyUpdatesRecursive(reactShadowNode, 0.0f, 0.0f);
        } finally {
            SystraceMessage.endSection(0);
        }
    }

    private void applyUpdatesRecursive(ReactShadowNode reactShadowNode, float f, float f2) {
        if (reactShadowNode.hasUpdates()) {
            if (!reactShadowNode.isVirtualAnchor()) {
                for (int i = 0; i < reactShadowNode.getChildCount(); i++) {
                    applyUpdatesRecursive(reactShadowNode.getChildAt(i), reactShadowNode.getLayoutX() + f, reactShadowNode.getLayoutY() + f2);
                }
            }
            int reactTag = reactShadowNode.getReactTag();
            if (!(getRootNode(reactTag) != null || reactShadowNode.dispatchUpdates(f, f2, this.mUIViewOperationQueue, null) == null || reactShadowNode.shouldNotifyOnLayout() == null)) {
                this.mUIViewOperationQueue.enqueueOnLayoutEvent(reactTag, reactShadowNode.getScreenX(), reactShadowNode.getScreenY(), reactShadowNode.getScreenWidth(), reactShadowNode.getScreenHeight());
            }
            reactShadowNode.setOriginalReactShadowNode(null);
            reactShadowNode.markUpdateSeen();
            reactShadowNode.markAsSealed();
        }
    }

    @DoNotStrip
    public <T extends SizeMonitoringFrameLayout & MeasureSpecProvider> int addRootView(T t) {
        int beginSection = SystraceMessage.beginSection(0, "FabricUIManager.addRootView");
        beginSection.flush();
        try {
            beginSection = ReactRootViewTagGenerator.getNextRootViewTag();
            ThemedReactContext themedReactContext = new ThemedReactContext(this.mReactApplicationContext, t.getContext());
            ReactShadowNode createRootShadowNode = createRootShadowNode(beginSection, themedReactContext);
            updateRootView(createRootShadowNode, ((MeasureSpecProvider) t).getWidthMeasureSpec(), ((MeasureSpecProvider) t).getHeightMeasureSpec());
            t.setOnSizeChangedListener(new OnSizeChangedListener() {
                public void onSizeChanged(int i, int i2, int i3, int i4) {
                    FabricUIManager.this.updateRootSize(beginSection, i, i2);
                }
            });
            this.mRootShadowNodeRegistry.registerNode(createRootShadowNode);
            this.mUIViewOperationQueue.addRootView(beginSection, t, themedReactContext);
            return beginSection;
        } finally {
            Systrace.endSection(0);
        }
    }

    @DoNotStrip
    public synchronized void updateRootLayoutSpecs(int i, int i2, int i3) {
        ReactShadowNode rootNode = getRootNode(i);
        if (rootNode == null) {
            String str = ReactConstants.TAG;
            i3 = new StringBuilder();
            i3.append("Tried to update non-existent root tag: ");
            i3.append(i);
            FLog.m5714w(str, i3.toString());
            return;
        }
        i = rootNode.mutableCopy(rootNode.getInstanceHandle());
        updateRootView(i, i2, i3);
        this.mRootShadowNodeRegistry.replaceNode(i);
    }

    private synchronized void updateRootSize(int i, int i2, int i3) {
        ReactShadowNode rootNode = getRootNode(i);
        if (rootNode == null) {
            String str = ReactConstants.TAG;
            i3 = new StringBuilder();
            i3.append("Tried to update size of non-existent tag: ");
            i3.append(i);
            FLog.m5714w(str, i3.toString());
            return;
        }
        rootNode = rootNode.mutableCopy(rootNode.getInstanceHandle());
        updateRootView(rootNode, MeasureSpec.makeMeasureSpec(i2, 1073741824), MeasureSpec.makeMeasureSpec(i3, 1073741824));
        completeRoot(i, rootNode.getChildrenList());
    }

    public void removeRootView(int i) {
        this.mRootShadowNodeRegistry.removeNode(Integer.valueOf(i));
    }

    private ReactShadowNode createRootShadowNode(int i, ThemedReactContext themedReactContext) {
        ReactShadowNode reactShadowNodeImpl = new ReactShadowNodeImpl();
        if (I18nUtil.getInstance().isRTL(themedReactContext)) {
            reactShadowNodeImpl.setLayoutDirection(YogaDirection.RTL);
        }
        reactShadowNodeImpl.setViewClassName("Root");
        reactShadowNodeImpl.setReactTag(i);
        reactShadowNodeImpl.setThemedContext(themedReactContext);
        return reactShadowNodeImpl;
    }

    private void updateRootView(ReactShadowNode reactShadowNode, int i, int i2) {
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

    private void handleException(ReactShadowNode reactShadowNode, Throwable th) {
        try {
            reactShadowNode.getThemedContext().handleException(new RuntimeException(th));
        } catch (ReactShadowNode reactShadowNode2) {
            FLog.m5675e(TAG, "Exception while executing a Fabric method", th);
            throw new RuntimeException(reactShadowNode2.getMessage(), th);
        }
    }

    @DoNotStrip
    public long getEventTarget(int i) {
        return this.mNativeViewHierarchyManager.getInstanceHandle(i);
    }

    @DoNotStrip
    public void registerEventHandler(long j) {
        this.mEventHandlerPointer = j;
    }

    @DoNotStrip
    public void releaseEventTarget(long j) {
        this.mBinding.releaseEventTarget(this.mJSContext.get(), j);
    }

    @DoNotStrip
    public void releaseEventHandler(long j) {
        this.mBinding.releaseEventHandler(this.mJSContext.get(), j);
    }

    @DoNotStrip
    public void invoke(long j, String str, WritableMap writableMap) {
        if (DEBUG) {
            String str2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Dispatching event for target: ");
            stringBuilder.append(j);
            FLog.m5662d(str2, stringBuilder.toString());
        }
        if (writableMap == null) {
            writableMap = new WritableNativeMap();
        }
        this.mBinding.dispatchEventToTarget(this.mJSContext.get(), this.mEventHandlerPointer, j, str, (WritableNativeMap) writableMap);
    }

    public void initialize() {
        FabricEventEmitter fabricEventEmitter = new FabricEventEmitter(this.mReactApplicationContext, this);
        this.mEventDispatcher.registerEventEmitter(2, this.mFabricEventEmitter);
    }

    public void onCatalystInstanceDestroy() {
        this.mBinding.releaseEventHandler(this.mJSContext.get(), this.mEventHandlerPointer);
        this.mEventDispatcher.unregisterEventEmitter(2);
        this.mFabricEventEmitter.close();
    }

    public void profileNextBatch() {
        this.mUIViewOperationQueue.profileNextBatch();
    }

    public Map<String, Long> getPerformanceCounters() {
        return this.mUIViewOperationQueue.getProfiledBatchPerfCounters();
    }
}
