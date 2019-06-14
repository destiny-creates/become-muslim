package versioned.host.exp.exponent.modules.api.components.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

@SuppressLint({"ViewConstructor"})
class TextPathView extends TextView {
    private String mHref;
    private TextPathMethod mMethod = TextPathMethod.align;
    private TextPathMidLine mMidLine;
    private TextPathSide mSide;
    private TextPathSpacing mSpacing = TextPathSpacing.exact;
    private SVGLength mStartOffset;

    void popGlyphContext() {
    }

    void pushGlyphContext() {
    }

    public TextPathView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "href")
    public void setHref(String str) {
        this.mHref = str;
        invalidate();
    }

    @ReactProp(name = "startOffset")
    public void setStartOffset(Dynamic dynamic) {
        this.mStartOffset = getLengthFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(name = "method")
    public void setMethod(String str) {
        this.mMethod = TextPathMethod.valueOf(str);
        invalidate();
    }

    @ReactProp(name = "spacing")
    public void setSpacing(String str) {
        this.mSpacing = TextPathSpacing.valueOf(str);
        invalidate();
    }

    @ReactProp(name = "side")
    public void setSide(String str) {
        this.mSide = TextPathSide.valueOf(str);
        invalidate();
    }

    @ReactProp(name = "midLine")
    public void setSharp(String str) {
        this.mMidLine = TextPathMidLine.valueOf(str);
        invalidate();
    }

    TextPathMethod getMethod() {
        return this.mMethod;
    }

    TextPathSpacing getSpacing() {
        return this.mSpacing;
    }

    TextPathSide getSide() {
        return this.mSide;
    }

    TextPathMidLine getMidLine() {
        return this.mMidLine;
    }

    SVGLength getStartOffset() {
        return this.mStartOffset;
    }

    void draw(Canvas canvas, Paint paint, float f) {
        drawGroup(canvas, paint, f);
    }

    Path getTextPath(Canvas canvas, Paint paint) {
        VirtualView definedTemplate = getSvgView().getDefinedTemplate(this.mHref);
        if (definedTemplate != null) {
            if (definedTemplate instanceof RenderableView) {
                return ((RenderableView) definedTemplate).getPath(canvas, paint);
            }
        }
        return null;
    }

    Path getPath(Canvas canvas, Paint paint) {
        return getGroupPath(canvas, paint);
    }
}
