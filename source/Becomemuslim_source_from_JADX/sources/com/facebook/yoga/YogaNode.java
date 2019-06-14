package com.facebook.yoga;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import java.util.ArrayList;
import java.util.List;

@DoNotStrip
public class YogaNode implements Cloneable {
    private static final int BORDER = 4;
    private static final int MARGIN = 1;
    private static final int PADDING = 2;
    private YogaBaselineFunction mBaselineFunction;
    @DoNotStrip
    private float mBorderBottom;
    @DoNotStrip
    private float mBorderLeft;
    @DoNotStrip
    private float mBorderRight;
    @DoNotStrip
    private float mBorderTop;
    private List<YogaNode> mChildren;
    private Object mData;
    @DoNotStrip
    private boolean mDoesLegacyStretchFlagAffectsLayout;
    @DoNotStrip
    private int mEdgeSetFlag;
    @DoNotStrip
    private boolean mHasNewLayout;
    private boolean mHasSetPosition;
    @DoNotStrip
    private float mHeight;
    @DoNotStrip
    private int mLayoutDirection;
    @DoNotStrip
    private float mLeft;
    @DoNotStrip
    private float mMarginBottom;
    @DoNotStrip
    private float mMarginLeft;
    @DoNotStrip
    private float mMarginRight;
    @DoNotStrip
    private float mMarginTop;
    private YogaMeasureFunction mMeasureFunction;
    private long mNativePointer;
    private YogaNode mOwner;
    @DoNotStrip
    private float mPaddingBottom;
    @DoNotStrip
    private float mPaddingLeft;
    @DoNotStrip
    private float mPaddingRight;
    @DoNotStrip
    private float mPaddingTop;
    @DoNotStrip
    private float mTop;
    @DoNotStrip
    private float mWidth;

    private native void jni_YGNodeCalculateLayout(long j, float f, float f2);

    private native void jni_YGNodeClearChildren(long j);

    private native long jni_YGNodeClone(long j, Object obj);

    private native void jni_YGNodeCopyStyle(long j, long j2);

    private static native void jni_YGNodeFree(long j);

    static native int jni_YGNodeGetInstanceCount();

    private native void jni_YGNodeInsertChild(long j, long j2, int i);

    private native void jni_YGNodeInsertSharedChild(long j, long j2, int i);

    private native boolean jni_YGNodeIsDirty(long j);

    private native void jni_YGNodeMarkDirty(long j);

    private native void jni_YGNodeMarkDirtyAndPropogateToDescendants(long j);

    private native long jni_YGNodeNew();

    private native long jni_YGNodeNewWithConfig(long j);

    private native void jni_YGNodePrint(long j);

    private native void jni_YGNodeRemoveChild(long j, long j2);

    private native void jni_YGNodeReset(long j);

    private native void jni_YGNodeSetHasBaselineFunc(long j, boolean z);

    private native void jni_YGNodeSetHasMeasureFunc(long j, boolean z);

    private native void jni_YGNodeSetOwner(long j, long j2);

    private native int jni_YGNodeStyleGetAlignContent(long j);

    private native int jni_YGNodeStyleGetAlignItems(long j);

    private native int jni_YGNodeStyleGetAlignSelf(long j);

    private native float jni_YGNodeStyleGetAspectRatio(long j);

    private native float jni_YGNodeStyleGetBorder(long j, int i);

    private native int jni_YGNodeStyleGetDirection(long j);

    private native int jni_YGNodeStyleGetDisplay(long j);

    private native Object jni_YGNodeStyleGetFlexBasis(long j);

    private native int jni_YGNodeStyleGetFlexDirection(long j);

    private native float jni_YGNodeStyleGetFlexGrow(long j);

    private native float jni_YGNodeStyleGetFlexShrink(long j);

    private native Object jni_YGNodeStyleGetHeight(long j);

    private native int jni_YGNodeStyleGetJustifyContent(long j);

    private native Object jni_YGNodeStyleGetMargin(long j, int i);

    private native Object jni_YGNodeStyleGetMaxHeight(long j);

    private native Object jni_YGNodeStyleGetMaxWidth(long j);

    private native Object jni_YGNodeStyleGetMinHeight(long j);

    private native Object jni_YGNodeStyleGetMinWidth(long j);

    private native int jni_YGNodeStyleGetOverflow(long j);

    private native Object jni_YGNodeStyleGetPadding(long j, int i);

    private native Object jni_YGNodeStyleGetPosition(long j, int i);

    private native int jni_YGNodeStyleGetPositionType(long j);

    private native Object jni_YGNodeStyleGetWidth(long j);

    private native void jni_YGNodeStyleSetAlignContent(long j, int i);

    private native void jni_YGNodeStyleSetAlignItems(long j, int i);

    private native void jni_YGNodeStyleSetAlignSelf(long j, int i);

    private native void jni_YGNodeStyleSetAspectRatio(long j, float f);

    private native void jni_YGNodeStyleSetBorder(long j, int i, float f);

    private native void jni_YGNodeStyleSetDirection(long j, int i);

    private native void jni_YGNodeStyleSetDisplay(long j, int i);

    private native void jni_YGNodeStyleSetFlex(long j, float f);

    private native void jni_YGNodeStyleSetFlexBasis(long j, float f);

    private native void jni_YGNodeStyleSetFlexBasisAuto(long j);

    private native void jni_YGNodeStyleSetFlexBasisPercent(long j, float f);

    private native void jni_YGNodeStyleSetFlexDirection(long j, int i);

    private native void jni_YGNodeStyleSetFlexGrow(long j, float f);

    private native void jni_YGNodeStyleSetFlexShrink(long j, float f);

    private native void jni_YGNodeStyleSetFlexWrap(long j, int i);

    private native void jni_YGNodeStyleSetHeight(long j, float f);

    private native void jni_YGNodeStyleSetHeightAuto(long j);

    private native void jni_YGNodeStyleSetHeightPercent(long j, float f);

    private native void jni_YGNodeStyleSetJustifyContent(long j, int i);

    private native void jni_YGNodeStyleSetMargin(long j, int i, float f);

    private native void jni_YGNodeStyleSetMarginAuto(long j, int i);

    private native void jni_YGNodeStyleSetMarginPercent(long j, int i, float f);

    private native void jni_YGNodeStyleSetMaxHeight(long j, float f);

    private native void jni_YGNodeStyleSetMaxHeightPercent(long j, float f);

    private native void jni_YGNodeStyleSetMaxWidth(long j, float f);

    private native void jni_YGNodeStyleSetMaxWidthPercent(long j, float f);

    private native void jni_YGNodeStyleSetMinHeight(long j, float f);

    private native void jni_YGNodeStyleSetMinHeightPercent(long j, float f);

    private native void jni_YGNodeStyleSetMinWidth(long j, float f);

    private native void jni_YGNodeStyleSetMinWidthPercent(long j, float f);

    private native void jni_YGNodeStyleSetOverflow(long j, int i);

    private native void jni_YGNodeStyleSetPadding(long j, int i, float f);

    private native void jni_YGNodeStyleSetPaddingPercent(long j, int i, float f);

    private native void jni_YGNodeStyleSetPosition(long j, int i, float f);

    private native void jni_YGNodeStyleSetPositionPercent(long j, int i, float f);

    private native void jni_YGNodeStyleSetPositionType(long j, int i);

    private native void jni_YGNodeStyleSetWidth(long j, float f);

    private native void jni_YGNodeStyleSetWidthAuto(long j);

    private native void jni_YGNodeStyleSetWidthPercent(long j, float f);

    static {
        SoLoader.loadLibrary("yoga");
    }

    public YogaNode() {
        this.mEdgeSetFlag = 0;
        this.mHasSetPosition = false;
        this.mWidth = 1.0E21f;
        this.mHeight = 1.0E21f;
        this.mTop = 1.0E21f;
        this.mLeft = 1.0E21f;
        this.mMarginLeft = 0.0f;
        this.mMarginTop = 0.0f;
        this.mMarginRight = 0.0f;
        this.mMarginBottom = 0.0f;
        this.mPaddingLeft = 0.0f;
        this.mPaddingTop = 0.0f;
        this.mPaddingRight = 0.0f;
        this.mPaddingBottom = 0.0f;
        this.mBorderLeft = 0.0f;
        this.mBorderTop = 0.0f;
        this.mBorderRight = 0.0f;
        this.mBorderBottom = 0.0f;
        this.mLayoutDirection = 0;
        this.mHasNewLayout = true;
        this.mDoesLegacyStretchFlagAffectsLayout = false;
        this.mNativePointer = jni_YGNodeNew();
        if (this.mNativePointer == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
    }

    public YogaNode(YogaConfig yogaConfig) {
        this.mEdgeSetFlag = 0;
        this.mHasSetPosition = false;
        this.mWidth = 1.0E21f;
        this.mHeight = 1.0E21f;
        this.mTop = 1.0E21f;
        this.mLeft = 1.0E21f;
        this.mMarginLeft = 0.0f;
        this.mMarginTop = 0.0f;
        this.mMarginRight = 0.0f;
        this.mMarginBottom = 0.0f;
        this.mPaddingLeft = 0.0f;
        this.mPaddingTop = 0.0f;
        this.mPaddingRight = 0.0f;
        this.mPaddingBottom = 0.0f;
        this.mBorderLeft = 0.0f;
        this.mBorderTop = 0.0f;
        this.mBorderRight = 0.0f;
        this.mBorderBottom = 0.0f;
        this.mLayoutDirection = 0;
        this.mHasNewLayout = true;
        this.mDoesLegacyStretchFlagAffectsLayout = false;
        this.mNativePointer = jni_YGNodeNewWithConfig(yogaConfig.mNativePointer);
        if (this.mNativePointer == 0) {
            throw new IllegalStateException("Failed to allocate native memory");
        }
    }

    protected void finalize() {
        try {
            freeNatives();
        } finally {
            super.finalize();
        }
    }

    public void freeNatives() {
        if (this.mNativePointer > 0) {
            long j = this.mNativePointer;
            this.mNativePointer = 0;
            jni_YGNodeFree(j);
        }
    }

    public void reset() {
        this.mEdgeSetFlag = 0;
        this.mHasSetPosition = false;
        this.mHasNewLayout = true;
        this.mWidth = 1.0E21f;
        this.mHeight = 1.0E21f;
        this.mTop = 1.0E21f;
        this.mLeft = 1.0E21f;
        this.mMarginLeft = 0.0f;
        this.mMarginTop = 0.0f;
        this.mMarginRight = 0.0f;
        this.mMarginBottom = 0.0f;
        this.mPaddingLeft = 0.0f;
        this.mPaddingTop = 0.0f;
        this.mPaddingRight = 0.0f;
        this.mPaddingBottom = 0.0f;
        this.mBorderLeft = 0.0f;
        this.mBorderTop = 0.0f;
        this.mBorderRight = 0.0f;
        this.mBorderBottom = 0.0f;
        this.mLayoutDirection = 0;
        this.mMeasureFunction = null;
        this.mBaselineFunction = null;
        this.mData = null;
        this.mDoesLegacyStretchFlagAffectsLayout = false;
        jni_YGNodeReset(this.mNativePointer);
    }

    public int getChildCount() {
        return this.mChildren == null ? 0 : this.mChildren.size();
    }

    public YogaNode getChildAt(int i) {
        if (this.mChildren != null) {
            return (YogaNode) this.mChildren.get(i);
        }
        throw new IllegalStateException("YogaNode does not have children");
    }

    public void addChildAt(YogaNode yogaNode, int i) {
        if (yogaNode.mOwner == null) {
            if (this.mChildren == null) {
                this.mChildren = new ArrayList(4);
            }
            this.mChildren.add(i, yogaNode);
            yogaNode.mOwner = this;
            jni_YGNodeInsertChild(this.mNativePointer, yogaNode.mNativePointer, i);
            return;
        }
        throw new IllegalStateException("Child already has a parent, it must be removed first.");
    }

    public void addSharedChildAt(YogaNode yogaNode, int i) {
        if (this.mChildren == null) {
            this.mChildren = new ArrayList(4);
        }
        this.mChildren.add(i, yogaNode);
        yogaNode.mOwner = null;
        jni_YGNodeInsertSharedChild(this.mNativePointer, yogaNode.mNativePointer, i);
    }

    public YogaNode clone() {
        try {
            YogaNode yogaNode = (YogaNode) super.clone();
            long jni_YGNodeClone = jni_YGNodeClone(this.mNativePointer, yogaNode);
            if (this.mChildren != null) {
                for (YogaNode yogaNode2 : this.mChildren) {
                    yogaNode2.jni_YGNodeSetOwner(yogaNode2.mNativePointer, 0);
                    yogaNode2.mOwner = null;
                }
            }
            yogaNode.mNativePointer = jni_YGNodeClone;
            yogaNode.mOwner = null;
            yogaNode.mChildren = this.mChildren != null ? (List) ((ArrayList) this.mChildren).clone() : null;
            if (yogaNode.mChildren != null) {
                for (YogaNode yogaNode3 : yogaNode.mChildren) {
                    yogaNode3.mOwner = null;
                }
            }
            return yogaNode;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public YogaNode cloneWithNewChildren() {
        try {
            YogaNode yogaNode = (YogaNode) super.clone();
            long jni_YGNodeClone = jni_YGNodeClone(this.mNativePointer, yogaNode);
            yogaNode.mOwner = null;
            yogaNode.mNativePointer = jni_YGNodeClone;
            yogaNode.clearChildren();
            return yogaNode;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private void clearChildren() {
        this.mChildren = null;
        jni_YGNodeClearChildren(this.mNativePointer);
    }

    public YogaNode removeChildAt(int i) {
        if (this.mChildren != null) {
            YogaNode yogaNode = (YogaNode) this.mChildren.remove(i);
            yogaNode.mOwner = null;
            jni_YGNodeRemoveChild(this.mNativePointer, yogaNode.mNativePointer);
            return yogaNode;
        }
        throw new IllegalStateException("Trying to remove a child of a YogaNode that does not have children");
    }

    public YogaNode getOwner() {
        return this.mOwner;
    }

    @Deprecated
    public YogaNode getParent() {
        return getOwner();
    }

    public int indexOf(YogaNode yogaNode) {
        return this.mChildren == null ? -1 : this.mChildren.indexOf(yogaNode);
    }

    public void calculateLayout(float f, float f2) {
        jni_YGNodeCalculateLayout(this.mNativePointer, f, f2);
    }

    public boolean hasNewLayout() {
        return this.mHasNewLayout;
    }

    public void dirty() {
        jni_YGNodeMarkDirty(this.mNativePointer);
    }

    public void dirtyAllDescendants() {
        jni_YGNodeMarkDirtyAndPropogateToDescendants(this.mNativePointer);
    }

    public boolean isDirty() {
        return jni_YGNodeIsDirty(this.mNativePointer);
    }

    public void copyStyle(YogaNode yogaNode) {
        jni_YGNodeCopyStyle(this.mNativePointer, yogaNode.mNativePointer);
    }

    public void markLayoutSeen() {
        this.mHasNewLayout = false;
    }

    public YogaDirection getStyleDirection() {
        return YogaDirection.fromInt(jni_YGNodeStyleGetDirection(this.mNativePointer));
    }

    public void setDirection(YogaDirection yogaDirection) {
        jni_YGNodeStyleSetDirection(this.mNativePointer, yogaDirection.intValue());
    }

    public YogaFlexDirection getFlexDirection() {
        return YogaFlexDirection.fromInt(jni_YGNodeStyleGetFlexDirection(this.mNativePointer));
    }

    public void setFlexDirection(YogaFlexDirection yogaFlexDirection) {
        jni_YGNodeStyleSetFlexDirection(this.mNativePointer, yogaFlexDirection.intValue());
    }

    public YogaJustify getJustifyContent() {
        return YogaJustify.fromInt(jni_YGNodeStyleGetJustifyContent(this.mNativePointer));
    }

    public void setJustifyContent(YogaJustify yogaJustify) {
        jni_YGNodeStyleSetJustifyContent(this.mNativePointer, yogaJustify.intValue());
    }

    public YogaAlign getAlignItems() {
        return YogaAlign.fromInt(jni_YGNodeStyleGetAlignItems(this.mNativePointer));
    }

    public void setAlignItems(YogaAlign yogaAlign) {
        jni_YGNodeStyleSetAlignItems(this.mNativePointer, yogaAlign.intValue());
    }

    public YogaAlign getAlignSelf() {
        return YogaAlign.fromInt(jni_YGNodeStyleGetAlignSelf(this.mNativePointer));
    }

    public void setAlignSelf(YogaAlign yogaAlign) {
        jni_YGNodeStyleSetAlignSelf(this.mNativePointer, yogaAlign.intValue());
    }

    public YogaAlign getAlignContent() {
        return YogaAlign.fromInt(jni_YGNodeStyleGetAlignContent(this.mNativePointer));
    }

    public void setAlignContent(YogaAlign yogaAlign) {
        jni_YGNodeStyleSetAlignContent(this.mNativePointer, yogaAlign.intValue());
    }

    public YogaPositionType getPositionType() {
        return YogaPositionType.fromInt(jni_YGNodeStyleGetPositionType(this.mNativePointer));
    }

    public void setPositionType(YogaPositionType yogaPositionType) {
        jni_YGNodeStyleSetPositionType(this.mNativePointer, yogaPositionType.intValue());
    }

    public void setWrap(YogaWrap yogaWrap) {
        jni_YGNodeStyleSetFlexWrap(this.mNativePointer, yogaWrap.intValue());
    }

    public YogaOverflow getOverflow() {
        return YogaOverflow.fromInt(jni_YGNodeStyleGetOverflow(this.mNativePointer));
    }

    public void setOverflow(YogaOverflow yogaOverflow) {
        jni_YGNodeStyleSetOverflow(this.mNativePointer, yogaOverflow.intValue());
    }

    public YogaDisplay getDisplay() {
        return YogaDisplay.fromInt(jni_YGNodeStyleGetDisplay(this.mNativePointer));
    }

    public void setDisplay(YogaDisplay yogaDisplay) {
        jni_YGNodeStyleSetDisplay(this.mNativePointer, yogaDisplay.intValue());
    }

    public void setFlex(float f) {
        jni_YGNodeStyleSetFlex(this.mNativePointer, f);
    }

    public float getFlexGrow() {
        return jni_YGNodeStyleGetFlexGrow(this.mNativePointer);
    }

    public void setFlexGrow(float f) {
        jni_YGNodeStyleSetFlexGrow(this.mNativePointer, f);
    }

    public float getFlexShrink() {
        return jni_YGNodeStyleGetFlexShrink(this.mNativePointer);
    }

    public void setFlexShrink(float f) {
        jni_YGNodeStyleSetFlexShrink(this.mNativePointer, f);
    }

    public YogaValue getFlexBasis() {
        return (YogaValue) jni_YGNodeStyleGetFlexBasis(this.mNativePointer);
    }

    public void setFlexBasis(float f) {
        jni_YGNodeStyleSetFlexBasis(this.mNativePointer, f);
    }

    public void setFlexBasisPercent(float f) {
        jni_YGNodeStyleSetFlexBasisPercent(this.mNativePointer, f);
    }

    public void setFlexBasisAuto() {
        jni_YGNodeStyleSetFlexBasisAuto(this.mNativePointer);
    }

    public YogaValue getMargin(YogaEdge yogaEdge) {
        if ((this.mEdgeSetFlag & 1) != 1) {
            return YogaValue.UNDEFINED;
        }
        return (YogaValue) jni_YGNodeStyleGetMargin(this.mNativePointer, yogaEdge.intValue());
    }

    public void setMargin(YogaEdge yogaEdge, float f) {
        this.mEdgeSetFlag |= 1;
        jni_YGNodeStyleSetMargin(this.mNativePointer, yogaEdge.intValue(), f);
    }

    public void setMarginPercent(YogaEdge yogaEdge, float f) {
        this.mEdgeSetFlag |= 1;
        jni_YGNodeStyleSetMarginPercent(this.mNativePointer, yogaEdge.intValue(), f);
    }

    public void setMarginAuto(YogaEdge yogaEdge) {
        this.mEdgeSetFlag |= 1;
        jni_YGNodeStyleSetMarginAuto(this.mNativePointer, yogaEdge.intValue());
    }

    public YogaValue getPadding(YogaEdge yogaEdge) {
        if ((this.mEdgeSetFlag & 2) != 2) {
            return YogaValue.UNDEFINED;
        }
        return (YogaValue) jni_YGNodeStyleGetPadding(this.mNativePointer, yogaEdge.intValue());
    }

    public void setPadding(YogaEdge yogaEdge, float f) {
        this.mEdgeSetFlag |= 2;
        jni_YGNodeStyleSetPadding(this.mNativePointer, yogaEdge.intValue(), f);
    }

    public void setPaddingPercent(YogaEdge yogaEdge, float f) {
        this.mEdgeSetFlag |= 2;
        jni_YGNodeStyleSetPaddingPercent(this.mNativePointer, yogaEdge.intValue(), f);
    }

    public float getBorder(YogaEdge yogaEdge) {
        if ((this.mEdgeSetFlag & 4) != 4) {
            return 1.0E21f;
        }
        return jni_YGNodeStyleGetBorder(this.mNativePointer, yogaEdge.intValue());
    }

    public void setBorder(YogaEdge yogaEdge, float f) {
        this.mEdgeSetFlag |= 4;
        jni_YGNodeStyleSetBorder(this.mNativePointer, yogaEdge.intValue(), f);
    }

    public YogaValue getPosition(YogaEdge yogaEdge) {
        if (this.mHasSetPosition) {
            return (YogaValue) jni_YGNodeStyleGetPosition(this.mNativePointer, yogaEdge.intValue());
        }
        return YogaValue.UNDEFINED;
    }

    public void setPosition(YogaEdge yogaEdge, float f) {
        this.mHasSetPosition = true;
        jni_YGNodeStyleSetPosition(this.mNativePointer, yogaEdge.intValue(), f);
    }

    public void setPositionPercent(YogaEdge yogaEdge, float f) {
        this.mHasSetPosition = true;
        jni_YGNodeStyleSetPositionPercent(this.mNativePointer, yogaEdge.intValue(), f);
    }

    public YogaValue getWidth() {
        return (YogaValue) jni_YGNodeStyleGetWidth(this.mNativePointer);
    }

    public void setWidth(float f) {
        jni_YGNodeStyleSetWidth(this.mNativePointer, f);
    }

    public void setWidthPercent(float f) {
        jni_YGNodeStyleSetWidthPercent(this.mNativePointer, f);
    }

    public void setWidthAuto() {
        jni_YGNodeStyleSetWidthAuto(this.mNativePointer);
    }

    public YogaValue getHeight() {
        return (YogaValue) jni_YGNodeStyleGetHeight(this.mNativePointer);
    }

    public void setHeight(float f) {
        jni_YGNodeStyleSetHeight(this.mNativePointer, f);
    }

    public void setHeightPercent(float f) {
        jni_YGNodeStyleSetHeightPercent(this.mNativePointer, f);
    }

    public void setHeightAuto() {
        jni_YGNodeStyleSetHeightAuto(this.mNativePointer);
    }

    public YogaValue getMinWidth() {
        return (YogaValue) jni_YGNodeStyleGetMinWidth(this.mNativePointer);
    }

    public void setMinWidth(float f) {
        jni_YGNodeStyleSetMinWidth(this.mNativePointer, f);
    }

    public void setMinWidthPercent(float f) {
        jni_YGNodeStyleSetMinWidthPercent(this.mNativePointer, f);
    }

    public YogaValue getMinHeight() {
        return (YogaValue) jni_YGNodeStyleGetMinHeight(this.mNativePointer);
    }

    public void setMinHeight(float f) {
        jni_YGNodeStyleSetMinHeight(this.mNativePointer, f);
    }

    public void setMinHeightPercent(float f) {
        jni_YGNodeStyleSetMinHeightPercent(this.mNativePointer, f);
    }

    public YogaValue getMaxWidth() {
        return (YogaValue) jni_YGNodeStyleGetMaxWidth(this.mNativePointer);
    }

    public void setMaxWidth(float f) {
        jni_YGNodeStyleSetMaxWidth(this.mNativePointer, f);
    }

    public void setMaxWidthPercent(float f) {
        jni_YGNodeStyleSetMaxWidthPercent(this.mNativePointer, f);
    }

    public YogaValue getMaxHeight() {
        return (YogaValue) jni_YGNodeStyleGetMaxHeight(this.mNativePointer);
    }

    public void setMaxHeight(float f) {
        jni_YGNodeStyleSetMaxHeight(this.mNativePointer, f);
    }

    public void setMaxHeightPercent(float f) {
        jni_YGNodeStyleSetMaxHeightPercent(this.mNativePointer, f);
    }

    public float getAspectRatio() {
        return jni_YGNodeStyleGetAspectRatio(this.mNativePointer);
    }

    public void setAspectRatio(float f) {
        jni_YGNodeStyleSetAspectRatio(this.mNativePointer, f);
    }

    public float getLayoutX() {
        return this.mLeft;
    }

    public float getLayoutY() {
        return this.mTop;
    }

    public float getLayoutWidth() {
        return this.mWidth;
    }

    public float getLayoutHeight() {
        return this.mHeight;
    }

    public boolean getDoesLegacyStretchFlagAffectsLayout() {
        return this.mDoesLegacyStretchFlagAffectsLayout;
    }

    public float getLayoutMargin(YogaEdge yogaEdge) {
        switch (yogaEdge) {
            case LEFT:
                return this.mMarginLeft;
            case TOP:
                return this.mMarginTop;
            case RIGHT:
                return this.mMarginRight;
            case BOTTOM:
                return this.mMarginBottom;
            case START:
                return getLayoutDirection() == YogaDirection.RTL ? this.mMarginRight : this.mMarginLeft;
            case END:
                return getLayoutDirection() == YogaDirection.RTL ? this.mMarginLeft : this.mMarginRight;
            default:
                throw new IllegalArgumentException("Cannot get layout margins of multi-edge shorthands");
        }
    }

    public float getLayoutPadding(YogaEdge yogaEdge) {
        switch (yogaEdge) {
            case LEFT:
                return this.mPaddingLeft;
            case TOP:
                return this.mPaddingTop;
            case RIGHT:
                return this.mPaddingRight;
            case BOTTOM:
                return this.mPaddingBottom;
            case START:
                return getLayoutDirection() == YogaDirection.RTL ? this.mPaddingRight : this.mPaddingLeft;
            case END:
                return getLayoutDirection() == YogaDirection.RTL ? this.mPaddingLeft : this.mPaddingRight;
            default:
                throw new IllegalArgumentException("Cannot get layout paddings of multi-edge shorthands");
        }
    }

    public float getLayoutBorder(YogaEdge yogaEdge) {
        switch (yogaEdge) {
            case LEFT:
                return this.mBorderLeft;
            case TOP:
                return this.mBorderTop;
            case RIGHT:
                return this.mBorderRight;
            case BOTTOM:
                return this.mBorderBottom;
            case START:
                return getLayoutDirection() == YogaDirection.RTL ? this.mBorderRight : this.mBorderLeft;
            case END:
                return getLayoutDirection() == YogaDirection.RTL ? this.mBorderLeft : this.mBorderRight;
            default:
                throw new IllegalArgumentException("Cannot get layout border of multi-edge shorthands");
        }
    }

    public YogaDirection getLayoutDirection() {
        return YogaDirection.fromInt(this.mLayoutDirection);
    }

    public void setMeasureFunction(YogaMeasureFunction yogaMeasureFunction) {
        this.mMeasureFunction = yogaMeasureFunction;
        jni_YGNodeSetHasMeasureFunc(this.mNativePointer, yogaMeasureFunction != null ? true : null);
    }

    @DoNotStrip
    public final long measure(float f, int i, float f2, int i2) {
        if (isMeasureDefined()) {
            return this.mMeasureFunction.measure(this, f, YogaMeasureMode.fromInt(i), f2, YogaMeasureMode.fromInt(i2));
        }
        throw new RuntimeException("Measure function isn't defined!");
    }

    public void setBaselineFunction(YogaBaselineFunction yogaBaselineFunction) {
        this.mBaselineFunction = yogaBaselineFunction;
        jni_YGNodeSetHasBaselineFunc(this.mNativePointer, yogaBaselineFunction != null ? true : null);
    }

    @DoNotStrip
    public final float baseline(float f, float f2) {
        return this.mBaselineFunction.baseline(this, f, f2);
    }

    public boolean isMeasureDefined() {
        return this.mMeasureFunction != null;
    }

    public void setData(Object obj) {
        this.mData = obj;
    }

    public Object getData() {
        return this.mData;
    }

    public void print() {
        jni_YGNodePrint(this.mNativePointer);
    }

    @DoNotStrip
    private final long replaceChild(YogaNode yogaNode, int i) {
        if (this.mChildren != null) {
            this.mChildren.remove(i);
            this.mChildren.add(i, yogaNode);
            yogaNode.mOwner = this;
            return yogaNode.mNativePointer;
        }
        throw new IllegalStateException("Cannot replace child. YogaNode does not have children");
    }
}
