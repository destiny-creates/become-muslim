package com.facebook.react.views.textinput;

import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.text.ReactBaseTextShadowNode;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.view.MeasureUtil;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import expolib_v1.com.facebook.infer.annotation.Assertions;

@VisibleForTesting
public class ReactTextInputShadowNode extends ReactBaseTextShadowNode implements YogaMeasureFunction {
    @VisibleForTesting
    public static final String PROP_PLACEHOLDER = "placeholder";
    @VisibleForTesting
    public static final String PROP_TEXT = "text";
    private EditText mDummyEditText;
    private ReactTextInputLocalData mLocalData;
    private int mMostRecentEventCount = -1;
    private String mPlaceholder = null;
    private String mText = null;

    public boolean isVirtualAnchor() {
        return true;
    }

    public boolean isYogaLeafNode() {
        return true;
    }

    public ReactTextInputShadowNode() {
        int i = VERSION.SDK_INT;
        this.mTextBreakStrategy = 0;
        initMeasureFunction();
    }

    private ReactTextInputShadowNode(ReactTextInputShadowNode reactTextInputShadowNode) {
        super(reactTextInputShadowNode);
        this.mMostRecentEventCount = reactTextInputShadowNode.mMostRecentEventCount;
        this.mText = reactTextInputShadowNode.mText;
        this.mLocalData = reactTextInputShadowNode.mLocalData;
    }

    protected ReactTextInputShadowNode copy() {
        return new ReactTextInputShadowNode(this);
    }

    public ReactTextInputShadowNode mutableCopy(long j) {
        ReactTextInputShadowNode reactTextInputShadowNode = (ReactTextInputShadowNode) super.mutableCopy(j);
        reactTextInputShadowNode.initMeasureFunction();
        ThemedReactContext themedContext = getThemedContext();
        if (themedContext != null) {
            reactTextInputShadowNode.setThemedContext(themedContext);
        }
        return reactTextInputShadowNode;
    }

    private void initMeasureFunction() {
        setMeasureFunction(this);
    }

    public ReactTextInputShadowNode mutableCopyWithNewChildren(long j) {
        ReactTextInputShadowNode reactTextInputShadowNode = (ReactTextInputShadowNode) super.mutableCopyWithNewChildren(j);
        reactTextInputShadowNode.initMeasureFunction();
        ThemedReactContext themedContext = getThemedContext();
        if (themedContext != null) {
            reactTextInputShadowNode.setThemedContext(themedContext);
        }
        return reactTextInputShadowNode;
    }

    public void setThemedContext(ThemedReactContext themedReactContext) {
        super.setThemedContext(themedReactContext);
        themedReactContext = new EditText(getThemedContext());
        setDefaultPadding(4, (float) themedReactContext.getPaddingStart());
        setDefaultPadding(1, (float) themedReactContext.getPaddingTop());
        setDefaultPadding(5, (float) themedReactContext.getPaddingEnd());
        setDefaultPadding(3, (float) themedReactContext.getPaddingBottom());
        this.mDummyEditText = themedReactContext;
        this.mDummyEditText.setPadding(0, 0, 0, 0);
        this.mDummyEditText.setLayoutParams(new LayoutParams(-2, -2));
    }

    public long measure(YogaNode yogaNode, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
        EditText editText = (EditText) Assertions.assertNotNull(this.mDummyEditText);
        if (this.mLocalData != null) {
            this.mLocalData.apply(editText);
        } else {
            editText.setTextSize(0, (float) (this.mFontSize == -1 ? (int) Math.ceil((double) PixelUtil.toPixelFromSP(14.0f)) : this.mFontSize));
            if (this.mNumberOfLines != -1) {
                editText.setLines(this.mNumberOfLines);
            }
            if (VERSION.SDK_INT >= 23 && editText.getBreakStrategy() != this.mTextBreakStrategy) {
                editText.setBreakStrategy(this.mTextBreakStrategy);
            }
        }
        editText.setHint(getPlaceholder());
        editText.measure(MeasureUtil.getMeasureSpec(f, yogaMeasureMode), MeasureUtil.getMeasureSpec(f2, yogaMeasureMode2));
        return YogaMeasureOutput.make(editText.getMeasuredWidth(), editText.getMeasuredHeight());
    }

    public void setLocalData(Object obj) {
        Assertions.assertCondition(obj instanceof ReactTextInputLocalData);
        this.mLocalData = (ReactTextInputLocalData) obj;
        dirty();
    }

    @ReactProp(name = "mostRecentEventCount")
    public void setMostRecentEventCount(int i) {
        this.mMostRecentEventCount = i;
    }

    @ReactProp(name = "text")
    public void setText(String str) {
        this.mText = str;
        markUpdated();
    }

    public String getText() {
        return this.mText;
    }

    @ReactProp(name = "placeholder")
    public void setPlaceholder(String str) {
        this.mPlaceholder = str;
        markUpdated();
    }

    public String getPlaceholder() {
        return this.mPlaceholder;
    }

    public void setTextBreakStrategy(String str) {
        if (VERSION.SDK_INT >= 23) {
            if (str != null) {
                if (!"simple".equals(str)) {
                    if ("highQuality".equals(str)) {
                        this.mTextBreakStrategy = 1;
                    } else if ("balanced".equals(str)) {
                        this.mTextBreakStrategy = 2;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid textBreakStrategy: ");
                        stringBuilder.append(str);
                        throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
                    }
                }
            }
            this.mTextBreakStrategy = null;
        }
    }

    public void onCollectExtraUpdates(UIViewOperationQueue uIViewOperationQueue) {
        super.onCollectExtraUpdates(uIViewOperationQueue);
        if (this.mMostRecentEventCount != -1) {
            uIViewOperationQueue.enqueueUpdateExtraData(getReactTag(), new ReactTextUpdate(ReactBaseTextShadowNode.spannedFromShadowNode(this, getText()), this.mMostRecentEventCount, this.mContainsImages, getPadding(0), getPadding(1), getPadding(2), getPadding(3), this.mTextAlign, this.mTextBreakStrategy));
        }
    }

    public void setPadding(int i, float f) {
        super.setPadding(i, f);
        markUpdated();
    }
}
