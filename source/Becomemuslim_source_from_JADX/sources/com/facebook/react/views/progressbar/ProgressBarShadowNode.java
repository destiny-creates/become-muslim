package com.facebook.react.views.progressbar;

import android.util.SparseIntArray;
import android.view.View.MeasureSpec;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import java.util.HashSet;
import java.util.Set;

public class ProgressBarShadowNode extends LayoutShadowNode implements YogaMeasureFunction {
    private final SparseIntArray mHeight;
    private final Set<Integer> mMeasured;
    private String mStyle;
    private final SparseIntArray mWidth;

    public ProgressBarShadowNode() {
        this.mStyle = "Normal";
        this.mHeight = new SparseIntArray();
        this.mWidth = new SparseIntArray();
        this.mMeasured = new HashSet();
        initMeasureFunction();
    }

    public ProgressBarShadowNode(ProgressBarShadowNode progressBarShadowNode) {
        super(progressBarShadowNode);
        this.mStyle = "Normal";
        this.mWidth = progressBarShadowNode.mWidth.clone();
        this.mHeight = progressBarShadowNode.mHeight.clone();
        this.mMeasured = new HashSet(progressBarShadowNode.mMeasured);
    }

    public ReactShadowNodeImpl mutableCopyWithNewChildren(long j) {
        ProgressBarShadowNode progressBarShadowNode = (ProgressBarShadowNode) super.mutableCopyWithNewChildren(j);
        progressBarShadowNode.initMeasureFunction();
        return progressBarShadowNode;
    }

    private void initMeasureFunction() {
        setMeasureFunction(this);
    }

    public ReactShadowNodeImpl mutableCopy(long j) {
        ProgressBarShadowNode progressBarShadowNode = (ProgressBarShadowNode) super.mutableCopy(j);
        progressBarShadowNode.initMeasureFunction();
        return progressBarShadowNode;
    }

    public ProgressBarShadowNode copy() {
        return new ProgressBarShadowNode(this);
    }

    public String getStyle() {
        return this.mStyle;
    }

    @ReactProp(name = "styleAttr")
    public void setStyle(String str) {
        if (str == null) {
            str = "Normal";
        }
        this.mStyle = str;
    }

    public long measure(YogaNode yogaNode, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
        yogaNode = ReactProgressBarViewManager.getStyleFromString(getStyle());
        if (this.mMeasured.contains(Integer.valueOf(yogaNode)) == null) {
            f = ReactProgressBarViewManager.createProgressBar(getThemedContext(), yogaNode);
            yogaMeasureMode = MeasureSpec.makeMeasureSpec(-2, 0.0f);
            f.measure(yogaMeasureMode, yogaMeasureMode);
            this.mHeight.put(yogaNode, f.getMeasuredHeight());
            this.mWidth.put(yogaNode, f.getMeasuredWidth());
            this.mMeasured.add(Integer.valueOf(yogaNode));
        }
        return YogaMeasureOutput.make(this.mWidth.get(yogaNode), this.mHeight.get(yogaNode));
    }
}
