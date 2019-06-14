package versioned.host.exp.exponent.modules.api.components.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region.Op;
import android.view.ViewParent;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
class TextView extends GroupView {
    AlignmentBaseline mAlignmentBaseline;
    String mBaselineShift = null;
    ArrayList<SVGLength> mDeltaX;
    ArrayList<SVGLength> mDeltaY;
    TextLengthAdjust mLengthAdjust = TextLengthAdjust.spacing;
    ArrayList<SVGLength> mPositionX;
    ArrayList<SVGLength> mPositionY;
    ArrayList<SVGLength> mRotate;
    SVGLength mTextLength = null;

    public TextView(ReactContext reactContext) {
        super(reactContext);
    }

    public void invalidate() {
        super.invalidate();
        releaseCachedPath();
    }

    @ReactProp(name = "textLength")
    public void setTextLength(Dynamic dynamic) {
        this.mTextLength = getLengthFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "lengthAdjust")
    public void setLengthAdjust(String str) {
        this.mLengthAdjust = TextLengthAdjust.valueOf(str);
        invalidate();
    }

    @ReactProp(name = "alignmentBaseline")
    public void setMethod(String str) {
        this.mAlignmentBaseline = AlignmentBaseline.getEnum(str);
        invalidate();
    }

    @ReactProp(name = "baselineShift")
    public void setBaselineShift(Dynamic dynamic) {
        this.mBaselineShift = getStringFromDynamic(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.annotations.ReactProp(name = "verticalAlign")
    public void setVerticalAlign(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 0;
        if (r4 == 0) goto L_0x0027;
    L_0x0003:
        r4 = r4.trim();
        r1 = 32;
        r1 = r4.lastIndexOf(r1);
        r2 = r4.substring(r1);	 Catch:{ IllegalArgumentException -> 0x0018 }
        r2 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.AlignmentBaseline.getEnum(r2);	 Catch:{ IllegalArgumentException -> 0x0018 }
        r3.mAlignmentBaseline = r2;	 Catch:{ IllegalArgumentException -> 0x0018 }
        goto L_0x001c;
    L_0x0018:
        r2 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.AlignmentBaseline.baseline;
        r3.mAlignmentBaseline = r2;
    L_0x001c:
        r2 = 0;
        r4 = r4.substring(r2, r1);	 Catch:{ IndexOutOfBoundsException -> 0x0024 }
        r3.mBaselineShift = r4;	 Catch:{ IndexOutOfBoundsException -> 0x0024 }
        goto L_0x002d;
    L_0x0024:
        r3.mBaselineShift = r0;
        goto L_0x002d;
    L_0x0027:
        r4 = versioned.host.exp.exponent.modules.api.components.svg.TextProperties.AlignmentBaseline.baseline;
        r3.mAlignmentBaseline = r4;
        r3.mBaselineShift = r0;
    L_0x002d:
        r3.invalidate();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.components.svg.TextView.setVerticalAlign(java.lang.String):void");
    }

    @ReactProp(name = "rotate")
    public void setRotate(Dynamic dynamic) {
        this.mRotate = getLengthArrayFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "dx")
    public void setDeltaX(Dynamic dynamic) {
        this.mDeltaX = getLengthArrayFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "dy")
    public void setDeltaY(Dynamic dynamic) {
        this.mDeltaY = getLengthArrayFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "x")
    public void setPositionX(Dynamic dynamic) {
        this.mPositionX = getLengthArrayFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "y")
    public void setPositionY(Dynamic dynamic) {
        this.mPositionY = getLengthArrayFromDynamic(dynamic);
        invalidate();
    }

    void draw(Canvas canvas, Paint paint, float f) {
        if (f > 0.01f) {
            setupGlyphContext(canvas);
            clip(canvas, paint);
            getGroupPath(canvas, paint);
            drawGroup(canvas, paint, f);
        }
    }

    Path getPath(Canvas canvas, Paint paint) {
        setupGlyphContext(canvas);
        return getGroupPath(canvas, paint);
    }

    Path getPath(Canvas canvas, Paint paint, Op op) {
        return getPath(canvas, paint);
    }

    AlignmentBaseline getAlignmentBaseline() {
        if (this.mAlignmentBaseline == null) {
            for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof TextView) {
                    AlignmentBaseline alignmentBaseline = ((TextView) parent).mAlignmentBaseline;
                    if (alignmentBaseline != null) {
                        this.mAlignmentBaseline = alignmentBaseline;
                        return alignmentBaseline;
                    }
                }
            }
        }
        if (this.mAlignmentBaseline == null) {
            this.mAlignmentBaseline = AlignmentBaseline.baseline;
        }
        return this.mAlignmentBaseline;
    }

    String getBaselineShift() {
        if (this.mBaselineShift == null) {
            for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof TextView) {
                    String str = ((TextView) parent).mBaselineShift;
                    if (str != null) {
                        this.mBaselineShift = str;
                        return str;
                    }
                }
            }
        }
        return this.mBaselineShift;
    }

    Path getGroupPath(Canvas canvas, Paint paint) {
        pushGlyphContext();
        canvas = super.getPath(canvas, paint);
        popGlyphContext();
        return canvas;
    }

    void pushGlyphContext() {
        boolean z = ((this instanceof TextPathView) || (this instanceof TSpanView)) ? false : true;
        getTextRootGlyphContext().pushContext(z, this, this.mFont, this.mPositionX, this.mPositionY, this.mDeltaX, this.mDeltaY, this.mRotate);
    }
}
