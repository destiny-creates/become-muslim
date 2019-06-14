package com.facebook.react.uimanager;

import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.react.uimanager.annotations.ReactPropertyHolder;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaBaselineFunction;
import com.facebook.yoga.YogaConfig;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaNodeCloneFunction;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaValue;
import com.facebook.yoga.YogaWrap;
import expolib_v1.com.facebook.infer.annotation.Assertions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ReactPropertyHolder
public class ReactShadowNodeImpl implements ReactShadowNode<ReactShadowNodeImpl> {
    private static final boolean DEBUG = PrinterHolder.getPrinter().shouldDisplayLogMessage(ReactDebugOverlayTags.FABRIC_UI_MANAGER);
    private static final String TAG = ReactShadowNodeImpl.class.getSimpleName();
    private static final YogaConfig sYogaConfig = ReactYogaConfigProvider.get();
    private ArrayList<ReactShadowNodeImpl> mChildren;
    private final Spacing mDefaultPadding;
    private int mGenerationDebugInformation;
    private long mInstanceHandle;
    private boolean mIsLayoutOnly;
    private boolean mIsSealed;
    private ArrayList<ReactShadowNodeImpl> mNativeChildren;
    private ReactShadowNodeImpl mNativeParent;
    private ReactStylesDiffMap mNewProps;
    private boolean mNodeUpdated;
    private ReactShadowNode mOriginalReactShadowNode;
    private final float[] mPadding;
    private final boolean[] mPaddingIsPercent;
    private ReactShadowNodeImpl mParent;
    private int mReactTag;
    private int mRootTag;
    private int mScreenHeight;
    private int mScreenWidth;
    private int mScreenX;
    private int mScreenY;
    private boolean mShouldNotifyOnLayout;
    private ThemedReactContext mThemedContext;
    private int mTotalNativeChildren;
    private String mViewClassName;
    private YogaNode mYogaNode;

    /* renamed from: com.facebook.react.uimanager.ReactShadowNodeImpl$1 */
    static class C38841 implements YogaNodeCloneFunction {
        C38841() {
        }

        public YogaNode cloneNode(YogaNode yogaNode, YogaNode yogaNode2, int i) {
            SystraceMessage.beginSection(0, "FabricReconciler.YogaNodeCloneFunction").flush();
            try {
                ReactShadowNodeImpl reactShadowNodeImpl = (ReactShadowNodeImpl) yogaNode2.getData();
                Assertions.assertNotNull(reactShadowNodeImpl);
                ReactShadowNodeImpl reactShadowNodeImpl2 = (ReactShadowNodeImpl) yogaNode.getData();
                Assertions.assertNotNull(reactShadowNodeImpl2);
                if (ReactShadowNodeImpl.DEBUG) {
                    String access$100 = ReactShadowNodeImpl.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("YogaNode started cloning: oldYogaNode: ");
                    stringBuilder.append(reactShadowNodeImpl2);
                    stringBuilder.append(" - parent: ");
                    stringBuilder.append(reactShadowNodeImpl);
                    stringBuilder.append(" index: ");
                    stringBuilder.append(i);
                    FLog.m5662d(access$100, stringBuilder.toString());
                }
                yogaNode = reactShadowNodeImpl2.mutableCopy(reactShadowNodeImpl2.getInstanceHandle());
                reactShadowNodeImpl.replaceChild(yogaNode, i);
                yogaNode = yogaNode.mYogaNode;
                return yogaNode;
            } finally {
                Systrace.endSection(0);
            }
        }
    }

    public boolean isVirtual() {
        return false;
    }

    public boolean isVirtualAnchor() {
        return false;
    }

    public void onAfterUpdateTransaction() {
    }

    public void onBeforeLayout() {
    }

    public void onCollectExtraUpdates(UIViewOperationQueue uIViewOperationQueue) {
    }

    public void setLocalData(Object obj) {
    }

    static {
        sYogaConfig.setOnCloneNode(new C38841());
    }

    public ReactShadowNodeImpl() {
        this.mNodeUpdated = true;
        this.mTotalNativeChildren = 0;
        this.mPadding = new float[9];
        this.mPaddingIsPercent = new boolean[9];
        this.mGenerationDebugInformation = 1;
        this.mOriginalReactShadowNode = null;
        this.mIsSealed = false;
        this.mDefaultPadding = new Spacing(0.0f);
        if (isVirtual()) {
            this.mYogaNode = null;
            return;
        }
        YogaNode yogaNode = (YogaNode) YogaNodePool.get().acquire();
        if (yogaNode == null) {
            yogaNode = new YogaNode(sYogaConfig);
        }
        this.mYogaNode = yogaNode;
        this.mYogaNode.setData(this);
        Arrays.fill(this.mPadding, 1.0E21f);
    }

    protected ReactShadowNodeImpl(ReactShadowNodeImpl reactShadowNodeImpl) {
        this.mNodeUpdated = true;
        this.mTotalNativeChildren = 0;
        this.mPadding = new float[9];
        this.mPaddingIsPercent = new boolean[9];
        this.mGenerationDebugInformation = 1;
        this.mOriginalReactShadowNode = null;
        this.mIsSealed = false;
        this.mReactTag = reactShadowNodeImpl.mReactTag;
        this.mRootTag = reactShadowNodeImpl.mRootTag;
        this.mViewClassName = reactShadowNodeImpl.mViewClassName;
        this.mThemedContext = reactShadowNodeImpl.mThemedContext;
        this.mShouldNotifyOnLayout = reactShadowNodeImpl.mShouldNotifyOnLayout;
        this.mIsLayoutOnly = reactShadowNodeImpl.mIsLayoutOnly;
        this.mNativeParent = reactShadowNodeImpl.mNativeParent;
        this.mDefaultPadding = new Spacing(reactShadowNodeImpl.mDefaultPadding);
        this.mNodeUpdated = true;
        this.mScreenX = 0;
        this.mScreenY = 0;
        this.mScreenWidth = 0;
        this.mScreenHeight = 0;
        this.mGenerationDebugInformation = reactShadowNodeImpl.mGenerationDebugInformation + 1;
        System.arraycopy(reactShadowNodeImpl.mPadding, 0, this.mPadding, 0, reactShadowNodeImpl.mPadding.length);
        System.arraycopy(reactShadowNodeImpl.mPaddingIsPercent, 0, this.mPaddingIsPercent, 0, reactShadowNodeImpl.mPaddingIsPercent.length);
        this.mNewProps = null;
        this.mParent = null;
        this.mOriginalReactShadowNode = reactShadowNodeImpl;
        this.mIsSealed = false;
    }

    private void replaceChild(ReactShadowNodeImpl reactShadowNodeImpl, int i) {
        this.mChildren.remove(i);
        this.mChildren.add(i, reactShadowNodeImpl);
        reactShadowNodeImpl.mParent = this;
    }

    protected ReactShadowNodeImpl copy() {
        return new ReactShadowNodeImpl(this);
    }

    public ReactShadowNodeImpl mutableCopy(long j) {
        ReactShadowNodeImpl copy = copy();
        Assertions.assertCondition(getClass() == copy.getClass(), "Copied shadow node must use the same class");
        copy.mInstanceHandle = j;
        if (this.mYogaNode != null) {
            copy.mYogaNode = this.mYogaNode.clone();
            copy.mYogaNode.setData(copy);
        } else {
            copy.mYogaNode = 0;
        }
        copy.mTotalNativeChildren = this.mTotalNativeChildren;
        copy.mNativeChildren = copyChildren(this.mNativeChildren);
        copy.mChildren = copyChildren(this.mChildren);
        return copy;
    }

    private ArrayList<ReactShadowNodeImpl> copyChildren(List<ReactShadowNodeImpl> list) {
        ArrayList<ReactShadowNodeImpl> arrayList = list == null ? null : new ArrayList(list);
        if (arrayList != null) {
            list = arrayList.iterator();
            while (list.hasNext()) {
                ((ReactShadowNodeImpl) list.next()).mParent = null;
            }
        }
        return arrayList;
    }

    public ReactShadowNodeImpl mutableCopyWithNewChildren(long j) {
        ReactShadowNodeImpl copy = copy();
        copy.mInstanceHandle = j;
        Assertions.assertCondition(getClass() == copy.getClass() ? 1 : null, "Copied shadow node must use the same class");
        if (this.mYogaNode != null) {
            copy.mYogaNode = this.mYogaNode.cloneWithNewChildren();
            copy.mYogaNode.setData(copy);
        } else {
            copy.mYogaNode = null;
        }
        copy.mNativeChildren = null;
        copy.mChildren = null;
        copy.mTotalNativeChildren = 0;
        return copy;
    }

    public ReactShadowNodeImpl mutableCopyWithNewProps(long j, ReactStylesDiffMap reactStylesDiffMap) {
        j = mutableCopy(j);
        if (reactStylesDiffMap != null) {
            j.updateProperties(reactStylesDiffMap);
            j.mNewProps = reactStylesDiffMap;
        }
        return j;
    }

    public ReactShadowNodeImpl mutableCopyWithNewChildrenAndProps(long j, ReactStylesDiffMap reactStylesDiffMap) {
        j = mutableCopyWithNewChildren(j);
        if (reactStylesDiffMap != null) {
            j.updateProperties(reactStylesDiffMap);
            j.mNewProps = reactStylesDiffMap;
        }
        return j;
    }

    public boolean isYogaLeafNode() {
        return isMeasureDefined();
    }

    public final String getViewClass() {
        return (String) Assertions.assertNotNull(this.mViewClassName);
    }

    public final boolean hasUpdates() {
        if (!(this.mNodeUpdated || hasNewLayout())) {
            if (!isDirty()) {
                return false;
            }
        }
        return true;
    }

    public final void markUpdateSeen() {
        assertNotSealed();
        this.mNodeUpdated = false;
        if (hasNewLayout()) {
            markLayoutSeen();
        }
    }

    public void markUpdated() {
        if (!this.mNodeUpdated) {
            this.mNodeUpdated = true;
            ReactShadowNodeImpl parent = getParent();
            if (parent != null) {
                parent.markUpdated();
            }
        }
    }

    public final boolean hasUnseenUpdates() {
        return this.mNodeUpdated;
    }

    public void dirty() {
        assertNotSealed();
        if (!isVirtual()) {
            this.mYogaNode.dirty();
        }
    }

    public final boolean isDirty() {
        return this.mYogaNode != null && this.mYogaNode.isDirty();
    }

    public void addChildAt(ReactShadowNodeImpl reactShadowNodeImpl, int i) {
        assertNotSealed();
        if (this.mChildren == null) {
            this.mChildren = new ArrayList(4);
        }
        this.mChildren.add(i, reactShadowNodeImpl);
        reactShadowNodeImpl.mParent = this;
        if (!(this.mYogaNode == null || isYogaLeafNode())) {
            YogaNode yogaNode = reactShadowNodeImpl.mYogaNode;
            if (yogaNode != null) {
                this.mYogaNode.addChildAt(yogaNode, i);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot add a child that doesn't have a YogaNode to a parent without a measure function! (Trying to add a '");
                stringBuilder.append(reactShadowNodeImpl.toString());
                stringBuilder.append("' to a '");
                stringBuilder.append(toString());
                stringBuilder.append("')");
                throw new RuntimeException(stringBuilder.toString());
            }
        }
        markUpdated();
        reactShadowNodeImpl = reactShadowNodeImpl.isLayoutOnly() != 0 ? reactShadowNodeImpl.getTotalNativeChildren() : true;
        this.mTotalNativeChildren += reactShadowNodeImpl;
        updateNativeChildrenCountInParent(reactShadowNodeImpl);
    }

    public ReactShadowNodeImpl removeChildAt(int i) {
        assertNotSealed();
        if (this.mChildren != null) {
            ReactShadowNodeImpl reactShadowNodeImpl = (ReactShadowNodeImpl) this.mChildren.remove(i);
            reactShadowNodeImpl.mParent = null;
            if (!(this.mYogaNode == null || isYogaLeafNode())) {
                this.mYogaNode.removeChildAt(i);
            }
            markUpdated();
            i = reactShadowNodeImpl.isLayoutOnly() != 0 ? reactShadowNodeImpl.getTotalNativeChildren() : 1;
            this.mTotalNativeChildren -= i;
            updateNativeChildrenCountInParent(-i);
            return reactShadowNodeImpl;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index ");
        stringBuilder.append(i);
        stringBuilder.append(" out of bounds: node has no children");
        throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
    }

    public final int getChildCount() {
        return this.mChildren == null ? 0 : this.mChildren.size();
    }

    public final ReactShadowNodeImpl getChildAt(int i) {
        if (this.mChildren != null) {
            return (ReactShadowNodeImpl) this.mChildren.get(i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index ");
        stringBuilder.append(i);
        stringBuilder.append(" out of bounds: node has no children");
        throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
    }

    public final int indexOf(ReactShadowNodeImpl reactShadowNodeImpl) {
        return this.mChildren == null ? -1 : this.mChildren.indexOf(reactShadowNodeImpl);
    }

    public void removeAndDisposeAllChildren() {
        if (getChildCount() != 0) {
            int i = 0;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!(this.mYogaNode == null || isYogaLeafNode())) {
                    this.mYogaNode.removeChildAt(childCount);
                }
                ReactShadowNodeImpl childAt = getChildAt(childCount);
                childAt.mParent = null;
                childAt.dispose();
                i += childAt.isLayoutOnly() ? childAt.getTotalNativeChildren() : 1;
            }
            ((ArrayList) Assertions.assertNotNull(this.mChildren)).clear();
            markUpdated();
            this.mTotalNativeChildren -= i;
            updateNativeChildrenCountInParent(-i);
        }
    }

    private void updateNativeChildrenCountInParent(int i) {
        if (this.mIsLayoutOnly) {
            ReactShadowNodeImpl parent = getParent();
            while (parent != null) {
                parent.mTotalNativeChildren += i;
                if (parent.isLayoutOnly()) {
                    parent = parent.getParent();
                } else {
                    return;
                }
            }
        }
    }

    public final void updateProperties(ReactStylesDiffMap reactStylesDiffMap) {
        ViewManagerPropertyUpdater.updateProps(this, reactStylesDiffMap);
        onAfterUpdateTransaction();
    }

    public ReactStylesDiffMap getNewProps() {
        return this.mNewProps;
    }

    public boolean dispatchUpdates(float f, float f2, UIViewOperationQueue uIViewOperationQueue, NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        if (this.mNodeUpdated) {
            onCollectExtraUpdates(uIViewOperationQueue);
        }
        boolean z = false;
        if (!hasNewLayout()) {
            return false;
        }
        float layoutX = getLayoutX();
        float layoutY = getLayoutY();
        f += layoutX;
        int round = Math.round(f);
        f2 += layoutY;
        int round2 = Math.round(f2);
        f = Math.round(f + getLayoutWidth());
        f2 = Math.round(f2 + getLayoutHeight());
        int round3 = Math.round(layoutX);
        int round4 = Math.round(layoutY);
        int i = f - round;
        int i2 = f2 - round2;
        if (!(round3 == this.mScreenX && round4 == this.mScreenY && i == this.mScreenWidth && i2 == this.mScreenHeight)) {
            z = true;
        }
        this.mScreenX = round3;
        this.mScreenY = round4;
        this.mScreenWidth = i;
        this.mScreenHeight = i2;
        if (z) {
            if (nativeViewHierarchyOptimizer != null) {
                nativeViewHierarchyOptimizer.handleUpdateLayout(this);
            } else {
                uIViewOperationQueue.enqueueUpdateLayout(getParent().getReactTag(), getReactTag(), getScreenX(), getScreenY(), getScreenWidth(), getScreenHeight());
            }
        }
        return z;
    }

    public final int getReactTag() {
        return this.mReactTag;
    }

    public void setReactTag(int i) {
        assertNotSealed();
        this.mReactTag = i;
    }

    public final int getRootTag() {
        Assertions.assertCondition(this.mRootTag != 0);
        return this.mRootTag;
    }

    public final void setRootTag(int i) {
        assertNotSealed();
        this.mRootTag = i;
    }

    public final void setViewClassName(String str) {
        assertNotSealed();
        this.mViewClassName = str;
    }

    public final ReactShadowNodeImpl getParent() {
        return this.mParent;
    }

    public final ThemedReactContext getThemedContext() {
        return (ThemedReactContext) Assertions.assertNotNull(this.mThemedContext);
    }

    public void setThemedContext(ThemedReactContext themedReactContext) {
        this.mThemedContext = themedReactContext;
    }

    public final boolean shouldNotifyOnLayout() {
        return this.mShouldNotifyOnLayout;
    }

    public void calculateLayout() {
        this.mYogaNode.calculateLayout(1.0E21f, 1.0E21f);
    }

    public final boolean hasNewLayout() {
        return this.mYogaNode != null && this.mYogaNode.hasNewLayout();
    }

    public final void markLayoutSeen() {
        assertNotSealed();
        if (this.mYogaNode != null) {
            this.mYogaNode.markLayoutSeen();
        }
    }

    public final void addNativeChildAt(ReactShadowNodeImpl reactShadowNodeImpl, int i) {
        assertNotSealed();
        Assertions.assertCondition(this.mIsLayoutOnly ^ 1);
        Assertions.assertCondition(reactShadowNodeImpl.mIsLayoutOnly ^ 1);
        if (this.mNativeChildren == null) {
            this.mNativeChildren = new ArrayList(4);
        }
        this.mNativeChildren.add(i, reactShadowNodeImpl);
        reactShadowNodeImpl.mNativeParent = this;
    }

    public final ReactShadowNodeImpl removeNativeChildAt(int i) {
        Assertions.assertNotNull(this.mNativeChildren);
        ReactShadowNodeImpl reactShadowNodeImpl = (ReactShadowNodeImpl) this.mNativeChildren.remove(i);
        reactShadowNodeImpl.mNativeParent = null;
        return reactShadowNodeImpl;
    }

    public final void removeAllNativeChildren() {
        if (this.mNativeChildren != null) {
            for (int size = this.mNativeChildren.size() - 1; size >= 0; size--) {
                ((ReactShadowNodeImpl) this.mNativeChildren.get(size)).mNativeParent = null;
            }
            this.mNativeChildren.clear();
        }
    }

    public final int getNativeChildCount() {
        return this.mNativeChildren == null ? 0 : this.mNativeChildren.size();
    }

    public final int indexOfNativeChild(ReactShadowNodeImpl reactShadowNodeImpl) {
        Assertions.assertNotNull(this.mNativeChildren);
        return this.mNativeChildren.indexOf(reactShadowNodeImpl);
    }

    public final ReactShadowNodeImpl getNativeParent() {
        return this.mNativeParent;
    }

    public final void setIsLayoutOnly(boolean z) {
        assertNotSealed();
        boolean z2 = false;
        Assertions.assertCondition(getParent() == null, "Must remove from no opt parent first");
        Assertions.assertCondition(this.mNativeParent == null, "Must remove from native parent first");
        if (getNativeChildCount() == 0) {
            z2 = true;
        }
        Assertions.assertCondition(z2, "Must remove all native children first");
        this.mIsLayoutOnly = z;
    }

    public final boolean isLayoutOnly() {
        return this.mIsLayoutOnly;
    }

    public final int getTotalNativeChildren() {
        return this.mTotalNativeChildren;
    }

    public boolean isDescendantOf(ReactShadowNodeImpl reactShadowNodeImpl) {
        for (ReactShadowNodeImpl parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent == reactShadowNodeImpl) {
                return true;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(this.mViewClassName);
        stringBuilder.append(" ");
        stringBuilder.append(getReactTag());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final int getNativeOffsetForChild(ReactShadowNodeImpl reactShadowNodeImpl) {
        Object obj = null;
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = 1;
            if (i >= getChildCount()) {
                break;
            }
            ReactShadowNodeImpl childAt = getChildAt(i);
            if (reactShadowNodeImpl == childAt) {
                break;
            }
            if (childAt.isLayoutOnly()) {
                i3 = childAt.getTotalNativeChildren();
            }
            i2 += i3;
            i++;
        }
        obj = 1;
        if (obj != null) {
            return i2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Child ");
        stringBuilder.append(reactShadowNodeImpl.getReactTag());
        stringBuilder.append(" was not a child of ");
        stringBuilder.append(this.mReactTag);
        throw new RuntimeException(stringBuilder.toString());
    }

    public final float getLayoutX() {
        return this.mYogaNode.getLayoutX();
    }

    public final float getLayoutY() {
        return this.mYogaNode.getLayoutY();
    }

    public final float getLayoutWidth() {
        return this.mYogaNode.getLayoutWidth();
    }

    public final float getLayoutHeight() {
        return this.mYogaNode.getLayoutHeight();
    }

    public int getScreenX() {
        return this.mScreenX;
    }

    public int getScreenY() {
        return this.mScreenY;
    }

    public int getScreenWidth() {
        return this.mScreenWidth;
    }

    public int getScreenHeight() {
        return this.mScreenHeight;
    }

    public final YogaDirection getLayoutDirection() {
        return this.mYogaNode.getLayoutDirection();
    }

    public void setLayoutDirection(YogaDirection yogaDirection) {
        assertNotSealed();
        this.mYogaNode.setDirection(yogaDirection);
    }

    public final YogaValue getStyleWidth() {
        return this.mYogaNode.getWidth();
    }

    public void setStyleWidth(float f) {
        assertNotSealed();
        this.mYogaNode.setWidth(f);
    }

    public void setStyleWidthPercent(float f) {
        assertNotSealed();
        this.mYogaNode.setWidthPercent(f);
    }

    public void setStyleWidthAuto() {
        assertNotSealed();
        this.mYogaNode.setWidthAuto();
    }

    public void setStyleMinWidth(float f) {
        assertNotSealed();
        this.mYogaNode.setMinWidth(f);
    }

    public void setStyleMinWidthPercent(float f) {
        assertNotSealed();
        this.mYogaNode.setMinWidthPercent(f);
    }

    public void setStyleMaxWidth(float f) {
        assertNotSealed();
        this.mYogaNode.setMaxWidth(f);
    }

    public void setStyleMaxWidthPercent(float f) {
        assertNotSealed();
        this.mYogaNode.setMaxWidthPercent(f);
    }

    public final YogaValue getStyleHeight() {
        return this.mYogaNode.getHeight();
    }

    public void setStyleHeight(float f) {
        assertNotSealed();
        this.mYogaNode.setHeight(f);
    }

    public void setStyleHeightPercent(float f) {
        assertNotSealed();
        this.mYogaNode.setHeightPercent(f);
    }

    public void setStyleHeightAuto() {
        assertNotSealed();
        this.mYogaNode.setHeightAuto();
    }

    public void setStyleMinHeight(float f) {
        assertNotSealed();
        this.mYogaNode.setMinHeight(f);
    }

    public void setStyleMinHeightPercent(float f) {
        assertNotSealed();
        this.mYogaNode.setMinHeightPercent(f);
    }

    public void setStyleMaxHeight(float f) {
        assertNotSealed();
        this.mYogaNode.setMaxHeight(f);
    }

    public void setStyleMaxHeightPercent(float f) {
        assertNotSealed();
        this.mYogaNode.setMaxHeightPercent(f);
    }

    public void setFlex(float f) {
        assertNotSealed();
        this.mYogaNode.setFlex(f);
    }

    public void setFlexGrow(float f) {
        assertNotSealed();
        this.mYogaNode.setFlexGrow(f);
    }

    public void setFlexShrink(float f) {
        assertNotSealed();
        this.mYogaNode.setFlexShrink(f);
    }

    public void setFlexBasis(float f) {
        assertNotSealed();
        this.mYogaNode.setFlexBasis(f);
    }

    public void setFlexBasisAuto() {
        assertNotSealed();
        this.mYogaNode.setFlexBasisAuto();
    }

    public void setFlexBasisPercent(float f) {
        assertNotSealed();
        this.mYogaNode.setFlexBasisPercent(f);
    }

    public void setStyleAspectRatio(float f) {
        assertNotSealed();
        this.mYogaNode.setAspectRatio(f);
    }

    public void setFlexDirection(YogaFlexDirection yogaFlexDirection) {
        assertNotSealed();
        this.mYogaNode.setFlexDirection(yogaFlexDirection);
    }

    public void setFlexWrap(YogaWrap yogaWrap) {
        assertNotSealed();
        this.mYogaNode.setWrap(yogaWrap);
    }

    public void setAlignSelf(YogaAlign yogaAlign) {
        assertNotSealed();
        this.mYogaNode.setAlignSelf(yogaAlign);
    }

    public void setAlignItems(YogaAlign yogaAlign) {
        assertNotSealed();
        this.mYogaNode.setAlignItems(yogaAlign);
    }

    public void setAlignContent(YogaAlign yogaAlign) {
        assertNotSealed();
        this.mYogaNode.setAlignContent(yogaAlign);
    }

    public void setJustifyContent(YogaJustify yogaJustify) {
        assertNotSealed();
        this.mYogaNode.setJustifyContent(yogaJustify);
    }

    public void setOverflow(YogaOverflow yogaOverflow) {
        assertNotSealed();
        this.mYogaNode.setOverflow(yogaOverflow);
    }

    public void setDisplay(YogaDisplay yogaDisplay) {
        assertNotSealed();
        this.mYogaNode.setDisplay(yogaDisplay);
    }

    public void setMargin(int i, float f) {
        assertNotSealed();
        this.mYogaNode.setMargin(YogaEdge.fromInt(i), f);
    }

    public void setMarginPercent(int i, float f) {
        assertNotSealed();
        this.mYogaNode.setMarginPercent(YogaEdge.fromInt(i), f);
    }

    public void setMarginAuto(int i) {
        assertNotSealed();
        this.mYogaNode.setMarginAuto(YogaEdge.fromInt(i));
    }

    public final float getPadding(int i) {
        return this.mYogaNode.getLayoutPadding(YogaEdge.fromInt(i));
    }

    public final YogaValue getStylePadding(int i) {
        return this.mYogaNode.getPadding(YogaEdge.fromInt(i));
    }

    public void setDefaultPadding(int i, float f) {
        assertNotSealed();
        this.mDefaultPadding.set(i, f);
        updatePadding();
    }

    public void setPadding(int i, float f) {
        assertNotSealed();
        this.mPadding[i] = f;
        this.mPaddingIsPercent[i] = false;
        updatePadding();
    }

    public void setPaddingPercent(int i, float f) {
        assertNotSealed();
        this.mPadding[i] = f;
        this.mPaddingIsPercent[i] = YogaConstants.isUndefined(f) ^ 1;
        updatePadding();
    }

    private void updatePadding() {
        assertNotSealed();
        int i = 0;
        while (i <= 8) {
            if (!(i == 0 || i == 2 || i == 4)) {
                if (i != 5) {
                    if (i != 1) {
                        if (i != 3) {
                            if (YogaConstants.isUndefined(this.mPadding[i])) {
                                this.mYogaNode.setPadding(YogaEdge.fromInt(i), this.mDefaultPadding.getRaw(i));
                                i++;
                            }
                            if (this.mPaddingIsPercent[i]) {
                                this.mYogaNode.setPaddingPercent(YogaEdge.fromInt(i), this.mPadding[i]);
                            } else {
                                this.mYogaNode.setPadding(YogaEdge.fromInt(i), this.mPadding[i]);
                            }
                            i++;
                        }
                    }
                    if (YogaConstants.isUndefined(this.mPadding[i]) && YogaConstants.isUndefined(this.mPadding[7]) && YogaConstants.isUndefined(this.mPadding[8])) {
                        this.mYogaNode.setPadding(YogaEdge.fromInt(i), this.mDefaultPadding.getRaw(i));
                        i++;
                    }
                    if (this.mPaddingIsPercent[i]) {
                        this.mYogaNode.setPadding(YogaEdge.fromInt(i), this.mPadding[i]);
                    } else {
                        this.mYogaNode.setPaddingPercent(YogaEdge.fromInt(i), this.mPadding[i]);
                    }
                    i++;
                }
            }
            if (YogaConstants.isUndefined(this.mPadding[i]) && YogaConstants.isUndefined(this.mPadding[6]) && YogaConstants.isUndefined(this.mPadding[8])) {
                this.mYogaNode.setPadding(YogaEdge.fromInt(i), this.mDefaultPadding.getRaw(i));
                i++;
            }
            if (this.mPaddingIsPercent[i]) {
                this.mYogaNode.setPaddingPercent(YogaEdge.fromInt(i), this.mPadding[i]);
            } else {
                this.mYogaNode.setPadding(YogaEdge.fromInt(i), this.mPadding[i]);
            }
            i++;
        }
    }

    public void setBorder(int i, float f) {
        assertNotSealed();
        this.mYogaNode.setBorder(YogaEdge.fromInt(i), f);
    }

    public void setPosition(int i, float f) {
        assertNotSealed();
        this.mYogaNode.setPosition(YogaEdge.fromInt(i), f);
    }

    public void setPositionPercent(int i, float f) {
        assertNotSealed();
        this.mYogaNode.setPositionPercent(YogaEdge.fromInt(i), f);
    }

    public void setPositionType(YogaPositionType yogaPositionType) {
        assertNotSealed();
        this.mYogaNode.setPositionType(yogaPositionType);
    }

    public void setShouldNotifyOnLayout(boolean z) {
        assertNotSealed();
        this.mShouldNotifyOnLayout = z;
    }

    public void setBaselineFunction(YogaBaselineFunction yogaBaselineFunction) {
        assertNotSealed();
        this.mYogaNode.setBaselineFunction(yogaBaselineFunction);
    }

    public void setMeasureFunction(YogaMeasureFunction yogaMeasureFunction) {
        assertNotSealed();
        this.mYogaNode.setMeasureFunction(yogaMeasureFunction);
    }

    public boolean isMeasureDefined() {
        return this.mYogaNode.isMeasureDefined();
    }

    public String getHierarchyInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        getHierarchyInfoWithIndentation(stringBuilder, 0);
        return stringBuilder.toString();
    }

    private void getHierarchyInfoWithIndentation(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append("  ");
        }
        stringBuilder.append("<");
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(" view='");
        stringBuilder.append(getViewClass());
        stringBuilder.append("' tag=");
        stringBuilder.append(getReactTag());
        stringBuilder.append(" gen=");
        stringBuilder.append(this.mGenerationDebugInformation);
        if (this.mYogaNode != null) {
            stringBuilder.append(" layout='x:");
            stringBuilder.append(getScreenX());
            stringBuilder.append(" y:");
            stringBuilder.append(getScreenY());
            stringBuilder.append(" w:");
            stringBuilder.append(getLayoutWidth());
            stringBuilder.append(" h:");
            stringBuilder.append(getLayoutHeight());
            stringBuilder.append("'");
        } else {
            stringBuilder.append("(virtual node)");
        }
        stringBuilder.append(">\n");
        if (getChildCount() != 0) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                getChildAt(i3).getHierarchyInfoWithIndentation(stringBuilder, i + 1);
            }
        }
    }

    public void dispose() {
        if (this.mYogaNode != null) {
            this.mYogaNode.reset();
            YogaNodePool.get().release(this.mYogaNode);
        }
    }

    public List<ReactShadowNode> getChildrenList() {
        return this.mChildren == null ? null : Collections.unmodifiableList(this.mChildren);
    }

    public ReactShadowNode getOriginalReactShadowNode() {
        return this.mOriginalReactShadowNode;
    }

    public void setOriginalReactShadowNode(ReactShadowNode reactShadowNode) {
        this.mOriginalReactShadowNode = reactShadowNode;
    }

    public long getInstanceHandle() {
        return this.mInstanceHandle;
    }

    public void setInstanceHandle(long j) {
        assertNotSealed();
        this.mInstanceHandle = j;
    }

    public void markAsSealed() {
        this.mIsSealed = true;
    }

    public boolean isSealed() {
        return this.mIsSealed;
    }

    private void assertNotSealed() {
        if (this.mIsSealed) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Can not modify sealed node ");
            stringBuilder.append(toString());
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public void updateScreenLayout(ReactShadowNode reactShadowNode) {
        this.mScreenHeight = reactShadowNode.getScreenHeight();
        this.mScreenWidth = reactShadowNode.getScreenWidth();
        this.mScreenX = reactShadowNode.getScreenX();
        this.mScreenY = reactShadowNode.getScreenY();
    }
}
