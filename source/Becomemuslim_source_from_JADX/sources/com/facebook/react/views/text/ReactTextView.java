package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextUtils.TruncateAt;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.facebook.react.uimanager.ReactCompoundView;
import com.facebook.react.views.view.ReactViewBackgroundManager;

public class ReactTextView extends TextView implements ReactCompoundView {
    private static final LayoutParams EMPTY_LAYOUT_PARAMS = new LayoutParams(0, 0);
    private boolean mContainsImages;
    private int mDefaultGravityHorizontal = (getGravity() & 8388615);
    private int mDefaultGravityVertical = (getGravity() & 112);
    private TruncateAt mEllipsizeLocation = TruncateAt.END;
    private float mLineHeight = Float.NaN;
    private int mNumberOfLines = Integer.MAX_VALUE;
    private ReactViewBackgroundManager mReactBackgroundManager = new ReactViewBackgroundManager(this);
    private int mTextAlign = null;
    private boolean mTextIsSelectable;

    public ReactTextView(Context context) {
        super(context);
    }

    public void setText(ReactTextUpdate reactTextUpdate) {
        this.mContainsImages = reactTextUpdate.containsImages();
        if (getLayoutParams() == null) {
            setLayoutParams(EMPTY_LAYOUT_PARAMS);
        }
        setText(reactTextUpdate.getText());
        setPadding((int) Math.floor((double) reactTextUpdate.getPaddingLeft()), (int) Math.floor((double) reactTextUpdate.getPaddingTop()), (int) Math.floor((double) reactTextUpdate.getPaddingRight()), (int) Math.floor((double) reactTextUpdate.getPaddingBottom()));
        int textAlign = reactTextUpdate.getTextAlign();
        if (this.mTextAlign != textAlign) {
            this.mTextAlign = textAlign;
        }
        setGravityHorizontal(this.mTextAlign);
        if (VERSION.SDK_INT >= 23 && getBreakStrategy() != reactTextUpdate.getTextBreakStrategy()) {
            setBreakStrategy(reactTextUpdate.getTextBreakStrategy());
        }
    }

    public int reactTagForTouch(float f, float f2) {
        CharSequence text = getText();
        int id = getId();
        int i = (int) f;
        f2 = (int) f2;
        Layout layout = getLayout();
        if (layout == null) {
            return id;
        }
        f2 = layout.getLineForVertical(f2);
        int lineLeft = (int) layout.getLineLeft(f2);
        int lineRight = (int) layout.getLineRight(f2);
        if ((text instanceof Spanned) && i >= lineLeft && i <= lineRight) {
            Spanned spanned = (Spanned) text;
            i = layout.getOffsetForHorizontal(f2, (float) i);
            ReactTagSpan[] reactTagSpanArr = (ReactTagSpan[]) spanned.getSpans(i, i, ReactTagSpan.class);
            if (reactTagSpanArr != null) {
                int length = text.length();
                for (int i2 = 0; i2 < reactTagSpanArr.length; i2++) {
                    lineRight = spanned.getSpanStart(reactTagSpanArr[i2]);
                    int spanEnd = spanned.getSpanEnd(reactTagSpanArr[i2]);
                    if (spanEnd > i) {
                        spanEnd -= lineRight;
                        if (spanEnd <= length) {
                            id = reactTagSpanArr[i2].getReactTag();
                            length = spanEnd;
                        }
                    }
                }
            }
        }
        return id;
    }

    public void setTextIsSelectable(boolean z) {
        this.mTextIsSelectable = z;
        super.setTextIsSelectable(z);
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            int i = 0;
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                if (textInlineImageSpanArr[i].getDrawable() == drawable) {
                    return true;
                }
                i++;
            }
        }
        return super.verifyDrawable(drawable);
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            int i = 0;
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                if (textInlineImageSpanArr[i].getDrawable() == drawable) {
                    invalidate();
                }
                i++;
            }
        }
        super.invalidateDrawable(drawable);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            int i = 0;
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                textInlineImageSpanArr[i].onDetachedFromWindow();
                i++;
            }
        }
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            int i = 0;
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                textInlineImageSpanArr[i].onStartTemporaryDetach();
                i++;
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            int i = 0;
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                textInlineImageSpanArr[i].onAttachedToWindow();
                i++;
            }
        }
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            int i = 0;
            TextInlineImageSpan[] textInlineImageSpanArr = (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class);
            int length = textInlineImageSpanArr.length;
            while (i < length) {
                textInlineImageSpanArr[i].onFinishTemporaryDetach();
                i++;
            }
        }
    }

    void setGravityHorizontal(int i) {
        if (i == 0) {
            i = this.mDefaultGravityHorizontal;
        }
        setGravity(i | ((getGravity() & -8) & -8388616));
    }

    void setGravityVertical(int i) {
        if (i == 0) {
            i = this.mDefaultGravityVertical;
        }
        setGravity(i | (getGravity() & -113));
    }

    public void setNumberOfLines(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        this.mNumberOfLines = i;
        boolean z = true;
        if (this.mNumberOfLines != 1) {
            z = false;
        }
        setSingleLine(z);
        setMaxLines(this.mNumberOfLines);
    }

    public void setEllipsizeLocation(TruncateAt truncateAt) {
        this.mEllipsizeLocation = truncateAt;
    }

    public void updateView() {
        setEllipsize(this.mNumberOfLines == Integer.MAX_VALUE ? null : this.mEllipsizeLocation);
    }

    public void setBackgroundColor(int i) {
        this.mReactBackgroundManager.setBackgroundColor(i);
    }

    public void setBorderWidth(int i, float f) {
        this.mReactBackgroundManager.setBorderWidth(i, f);
    }

    public void setBorderColor(int i, float f, float f2) {
        this.mReactBackgroundManager.setBorderColor(i, f, f2);
    }

    public void setBorderRadius(float f) {
        this.mReactBackgroundManager.setBorderRadius(f);
    }

    public void setBorderRadius(float f, int i) {
        this.mReactBackgroundManager.setBorderRadius(f, i);
    }

    public void setBorderStyle(String str) {
        this.mReactBackgroundManager.setBorderStyle(str);
    }
}
