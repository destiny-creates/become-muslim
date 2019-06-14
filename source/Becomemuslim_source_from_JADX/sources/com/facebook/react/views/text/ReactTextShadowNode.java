package com.facebook.react.views.text;

import android.os.Build.VERSION;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextPaint;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactShadowNodeImpl;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.yoga.YogaConstants;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import expolib_v1.com.facebook.infer.annotation.Assertions;

public class ReactTextShadowNode extends ReactBaseTextShadowNode {
    private static final TextPaint sTextPaintInstance = new TextPaint(1);
    private Spannable mPreparedSpannableText;
    private final YogaMeasureFunction mTextMeasureFunction = new C38941();

    /* renamed from: com.facebook.react.views.text.ReactTextShadowNode$1 */
    class C38941 implements YogaMeasureFunction {
        C38941() {
        }

        public long measure(YogaNode yogaNode, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
            TextPaint access$000 = ReactTextShadowNode.sTextPaintInstance;
            Spanned spanned = (Spanned) Assertions.assertNotNull(ReactTextShadowNode.this.mPreparedSpannableText, "Spannable element has not been prepared in onBeforeLayout");
            Metrics isBoring = BoringLayout.isBoring(spanned, access$000);
            float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spanned, access$000) : 2143289344;
            if (yogaMeasureMode != YogaMeasureMode.UNDEFINED) {
                if (f >= 0.0f) {
                    yogaMeasureMode = null;
                    if (isBoring != null && (r12 != null || (!YogaConstants.isUndefined(desiredWidth) && desiredWidth <= f))) {
                        yogaNode = (int) Math.ceil((double) desiredWidth);
                        if (VERSION.SDK_INT < 3.2E-44f) {
                            StaticLayout staticLayout = new StaticLayout(spanned, access$000, yogaNode, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, ReactTextShadowNode.this.mIncludeFontPadding);
                        } else {
                            f = Builder.obtain(spanned, 0, spanned.length(), access$000, yogaNode).setAlignment(Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(ReactTextShadowNode.this.mIncludeFontPadding).setBreakStrategy(ReactTextShadowNode.this.mTextBreakStrategy).setHyphenationFrequency(1).build();
                        }
                    } else if (isBoring == null && (r12 != null || ((float) isBoring.width) <= f)) {
                        f = BoringLayout.make(spanned, access$000, isBoring.width, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, isBoring, ReactTextShadowNode.this.mIncludeFontPadding);
                    } else if (VERSION.SDK_INT >= 23) {
                        f = new StaticLayout(spanned, access$000, (int) f, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, ReactTextShadowNode.this.mIncludeFontPadding);
                    } else {
                        f = Builder.obtain(spanned, 0, spanned.length(), access$000, (int) f).setAlignment(Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(ReactTextShadowNode.this.mIncludeFontPadding).setBreakStrategy(ReactTextShadowNode.this.mTextBreakStrategy).setHyphenationFrequency(1).build();
                    }
                    if (ReactTextShadowNode.this.mNumberOfLines != -1 || ReactTextShadowNode.this.mNumberOfLines >= f.getLineCount()) {
                        return YogaMeasureOutput.make(f.getWidth(), f.getHeight());
                    }
                    return YogaMeasureOutput.make(f.getWidth(), f.getLineBottom(ReactTextShadowNode.this.mNumberOfLines - 1));
                }
            }
            yogaMeasureMode = true;
            if (isBoring != null) {
            }
            if (isBoring == null) {
            }
            if (VERSION.SDK_INT >= 23) {
                f = Builder.obtain(spanned, 0, spanned.length(), access$000, (int) f).setAlignment(Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setIncludePad(ReactTextShadowNode.this.mIncludeFontPadding).setBreakStrategy(ReactTextShadowNode.this.mTextBreakStrategy).setHyphenationFrequency(1).build();
            } else {
                f = new StaticLayout(spanned, access$000, (int) f, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, ReactTextShadowNode.this.mIncludeFontPadding);
            }
            if (ReactTextShadowNode.this.mNumberOfLines != -1) {
            }
            return YogaMeasureOutput.make(f.getWidth(), f.getHeight());
        }
    }

    public boolean isVirtualAnchor() {
        return true;
    }

    public ReactTextShadowNode() {
        initMeasureFunction();
    }

    private ReactTextShadowNode(ReactTextShadowNode reactTextShadowNode) {
        super(reactTextShadowNode);
        this.mPreparedSpannableText = reactTextShadowNode.mPreparedSpannableText;
    }

    private void initMeasureFunction() {
        if (!isVirtual()) {
            setMeasureFunction(this.mTextMeasureFunction);
        }
    }

    protected LayoutShadowNode copy() {
        return new ReactTextShadowNode(this);
    }

    public ReactShadowNodeImpl mutableCopy(long j) {
        ReactTextShadowNode reactTextShadowNode = (ReactTextShadowNode) super.mutableCopy(j);
        reactTextShadowNode.initMeasureFunction();
        return reactTextShadowNode;
    }

    public ReactShadowNodeImpl mutableCopyWithNewChildren(long j) {
        ReactTextShadowNode reactTextShadowNode = (ReactTextShadowNode) super.mutableCopyWithNewChildren(j);
        reactTextShadowNode.initMeasureFunction();
        return reactTextShadowNode;
    }

    private int getTextAlign() {
        int i = this.mTextAlign;
        if (getLayoutDirection() != YogaDirection.RTL) {
            return i;
        }
        if (i == 5) {
            return 3;
        }
        return i == 3 ? 5 : i;
    }

    public void onBeforeLayout() {
        this.mPreparedSpannableText = ReactBaseTextShadowNode.spannedFromShadowNode(this, null);
        markUpdated();
    }

    public void markUpdated() {
        super.markUpdated();
        super.dirty();
    }

    public void onCollectExtraUpdates(UIViewOperationQueue uIViewOperationQueue) {
        super.onCollectExtraUpdates(uIViewOperationQueue);
        if (this.mPreparedSpannableText != null) {
            uIViewOperationQueue.enqueueUpdateExtraData(getReactTag(), new ReactTextUpdate(this.mPreparedSpannableText, -1, this.mContainsImages, getPadding(4), getPadding(1), getPadding(5), getPadding(3), getTextAlign(), this.mTextBreakStrategy));
        }
    }
}
