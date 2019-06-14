package versioned.host.exp.exponent.modules.api.components.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.view.View;
import android.view.ViewParent;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.OnLayoutEvent;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
public abstract class VirtualView extends ReactViewGroup {
    private static final int CLIP_RULE_EVENODD = 0;
    static final int CLIP_RULE_NONZERO = 1;
    static final float MIN_OPACITY_FOR_DRAW = 0.01f;
    private static final double M_SQRT1_2l = 0.7071067811865476d;
    private static final float[] sRawMatrix = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private double canvasDiagonal = -1.0d;
    private float canvasHeight = -1.0f;
    private float canvasWidth = -1.0f;
    private double fontSize = -1.0d;
    private GlyphContext glyphContext;
    RectF layoutRect = new RectF();
    RectF mBox;
    private Path mCachedClipPath;
    private RectF mClientRect;
    private String mClipPath;
    Region mClipRegion;
    Path mClipRegionPath;
    int mClipRule;
    final ReactContext mContext;
    Path mFillPath;
    Matrix mInvMatrix = new Matrix();
    Matrix mInvTransform = new Matrix();
    boolean mInvertible = true;
    String mMask;
    Matrix mMatrix = new Matrix();
    String mName;
    float mOpacity = 1.0f;
    Path mPath;
    Region mRegion;
    private boolean mResponsible;
    final float mScale;
    Path mStrokePath;
    Region mStrokeRegion;
    private GroupView mTextRoot;
    Matrix mTransform = new Matrix();
    boolean mTransformInvertible = true;
    private SvgView svgView;

    /* renamed from: versioned.host.exp.exponent.modules.api.components.svg.VirtualView$1 */
    static /* synthetic */ class C67491 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType = new int[ReadableType.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = com.facebook.react.bridge.ReadableType.values();
            r0 = r0.length;
            r0 = new int[r0];
            $SwitchMap$com$facebook$react$bridge$ReadableType = r0;
            r0 = 1;
            r1 = $SwitchMap$com$facebook$react$bridge$ReadableType;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = com.facebook.react.bridge.ReadableType.Number;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = r2.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r1 = 2;
            r2 = $SwitchMap$com$facebook$react$bridge$ReadableType;	 Catch:{ NoSuchFieldError -> 0x001f }
            r3 = com.facebook.react.bridge.ReadableType.String;	 Catch:{ NoSuchFieldError -> 0x001f }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2[r3] = r1;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r2 = 3;
            r3 = $SwitchMap$com$facebook$react$bridge$ReadableType;	 Catch:{ NoSuchFieldError -> 0x002a }
            r4 = com.facebook.react.bridge.ReadableType.Array;	 Catch:{ NoSuchFieldError -> 0x002a }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r3[r4] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r3 = versioned.host.exp.exponent.modules.api.components.svg.SVGLengthUnitType.values();
            r3 = r3.length;
            r3 = new int[r3];
            f23513xbf71c080 = r3;
            r3 = f23513xbf71c080;	 Catch:{ NoSuchFieldError -> 0x003d }
            r4 = versioned.host.exp.exponent.modules.api.components.svg.SVGLengthUnitType.SVG_LENGTHTYPE_EMS;	 Catch:{ NoSuchFieldError -> 0x003d }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x003d }
            r3[r4] = r0;	 Catch:{ NoSuchFieldError -> 0x003d }
        L_0x003d:
            r0 = f23513xbf71c080;	 Catch:{ NoSuchFieldError -> 0x0047 }
            r3 = versioned.host.exp.exponent.modules.api.components.svg.SVGLengthUnitType.SVG_LENGTHTYPE_EXS;	 Catch:{ NoSuchFieldError -> 0x0047 }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x0047 }
            r0[r3] = r1;	 Catch:{ NoSuchFieldError -> 0x0047 }
        L_0x0047:
            r0 = f23513xbf71c080;	 Catch:{ NoSuchFieldError -> 0x0051 }
            r1 = versioned.host.exp.exponent.modules.api.components.svg.SVGLengthUnitType.SVG_LENGTHTYPE_CM;	 Catch:{ NoSuchFieldError -> 0x0051 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0051 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0051 }
        L_0x0051:
            r0 = f23513xbf71c080;	 Catch:{ NoSuchFieldError -> 0x005c }
            r1 = versioned.host.exp.exponent.modules.api.components.svg.SVGLengthUnitType.SVG_LENGTHTYPE_MM;	 Catch:{ NoSuchFieldError -> 0x005c }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x005c }
            r2 = 4;	 Catch:{ NoSuchFieldError -> 0x005c }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x005c }
        L_0x005c:
            r0 = f23513xbf71c080;	 Catch:{ NoSuchFieldError -> 0x0067 }
            r1 = versioned.host.exp.exponent.modules.api.components.svg.SVGLengthUnitType.SVG_LENGTHTYPE_IN;	 Catch:{ NoSuchFieldError -> 0x0067 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0067 }
            r2 = 5;	 Catch:{ NoSuchFieldError -> 0x0067 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0067 }
        L_0x0067:
            r0 = f23513xbf71c080;	 Catch:{ NoSuchFieldError -> 0x0072 }
            r1 = versioned.host.exp.exponent.modules.api.components.svg.SVGLengthUnitType.SVG_LENGTHTYPE_PT;	 Catch:{ NoSuchFieldError -> 0x0072 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0072 }
            r2 = 6;	 Catch:{ NoSuchFieldError -> 0x0072 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0072 }
        L_0x0072:
            r0 = f23513xbf71c080;	 Catch:{ NoSuchFieldError -> 0x007d }
            r1 = versioned.host.exp.exponent.modules.api.components.svg.SVGLengthUnitType.SVG_LENGTHTYPE_PC;	 Catch:{ NoSuchFieldError -> 0x007d }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x007d }
            r2 = 7;	 Catch:{ NoSuchFieldError -> 0x007d }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x007d }
        L_0x007d:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.components.svg.VirtualView.1.<clinit>():void");
        }
    }

    abstract void draw(Canvas canvas, Paint paint, float f);

    abstract Path getPath(Canvas canvas, Paint paint);

    abstract int hitTest(float[] fArr);

    VirtualView(ReactContext reactContext) {
        super(reactContext);
        this.mContext = reactContext;
        this.mScale = DisplayMetricsHolder.getScreenDisplayMetrics().density;
    }

    public void invalidate() {
        super.invalidate();
        clearPath();
    }

    private void clearPath() {
        this.canvasDiagonal = -1.0d;
        this.canvasHeight = -1.0f;
        this.canvasWidth = -1.0f;
        this.fontSize = -1.0d;
        this.mRegion = null;
        this.mPath = null;
    }

    void releaseCachedPath() {
        clearPath();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof VirtualView) {
                ((VirtualView) childAt).releaseCachedPath();
            }
        }
    }

    GroupView getTextRoot() {
        if (this.mTextRoot == null) {
            VirtualView virtualView = this;
            while (virtualView != null) {
                if (virtualView instanceof GroupView) {
                    GroupView groupView = (GroupView) virtualView;
                    if (groupView.getGlyphContext() != null) {
                        this.mTextRoot = groupView;
                        break;
                    }
                }
                ViewParent parent = virtualView.getParent();
                if (parent instanceof VirtualView) {
                    virtualView = (VirtualView) parent;
                } else {
                    virtualView = null;
                }
            }
        }
        return this.mTextRoot;
    }

    GroupView getParentTextRoot() {
        ViewParent parent = getParent();
        if (parent instanceof VirtualView) {
            return ((VirtualView) parent).getTextRoot();
        }
        return null;
    }

    private double getFontSizeFromContext() {
        if (this.fontSize != -1.0d) {
            return this.fontSize;
        }
        GroupView textRoot = getTextRoot();
        if (textRoot == null) {
            return 12.0d;
        }
        if (this.glyphContext == null) {
            this.glyphContext = textRoot.getGlyphContext();
        }
        this.fontSize = this.glyphContext.getFontSize();
        return this.fontSize;
    }

    void render(Canvas canvas, Paint paint, float f) {
        draw(canvas, paint, f);
    }

    int saveAndSetupCanvas(Canvas canvas) {
        int save = canvas.save();
        canvas.concat(this.mMatrix);
        canvas.concat(this.mTransform);
        return save;
    }

    void restoreCanvas(Canvas canvas, int i) {
        canvas.restoreToCount(i);
    }

    @ReactProp(name = "name")
    public void setName(String str) {
        this.mName = str;
        invalidate();
    }

    @ReactProp(name = "mask")
    public void setMask(String str) {
        this.mMask = str;
        invalidate();
    }

    @ReactProp(name = "clipPath")
    public void setClipPath(String str) {
        this.mCachedClipPath = null;
        this.mClipPath = str;
        invalidate();
    }

    @ReactProp(defaultInt = 1, name = "clipRule")
    public void setClipRule(int i) {
        this.mClipRule = i;
        invalidate();
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(float f) {
        this.mOpacity = f;
        invalidate();
    }

    @ReactProp(name = "matrix")
    public void setMatrix(Dynamic dynamic) {
        ReadableType type = dynamic.getType();
        if (dynamic.isNull() || !type.equals(ReadableType.Array)) {
            this.mMatrix = null;
            this.mInvMatrix = null;
            this.mInvertible = null;
        } else {
            dynamic = PropHelper.toMatrixData(dynamic.asArray(), sRawMatrix, this.mScale);
            if (dynamic == 6) {
                if (this.mMatrix == null) {
                    this.mMatrix = new Matrix();
                    this.mInvMatrix = new Matrix();
                }
                this.mMatrix.setValues(sRawMatrix);
                this.mInvertible = this.mMatrix.invert(this.mInvMatrix);
            } else if (dynamic != -1) {
                FLog.w(ReactConstants.TAG, "RNSVG: Transform matrices must be of size 6");
            }
        }
        super.invalidate();
    }

    @ReactProp(name = "responsible")
    public void setResponsible(boolean z) {
        this.mResponsible = z;
        invalidate();
    }

    Path getClipPath() {
        return this.mCachedClipPath;
    }

    Path getClipPath(Canvas canvas, Paint paint) {
        if (this.mClipPath != null) {
            ClipPathView clipPathView = (ClipPathView) getSvgView().getDefinedClipPath(this.mClipPath);
            if (clipPathView != null) {
                if (clipPathView.mClipRule == 0) {
                    canvas = clipPathView.getPath(canvas, paint);
                } else {
                    canvas = clipPathView.getPath(canvas, paint, Op.UNION);
                }
                switch (clipPathView.mClipRule) {
                    case null:
                        canvas.setFillType(FillType.EVEN_ODD);
                        break;
                    case 1:
                        break;
                    default:
                        paint = ReactConstants.TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("RNSVG: clipRule: ");
                        stringBuilder.append(this.mClipRule);
                        stringBuilder.append(" unrecognized");
                        FLog.w(paint, stringBuilder.toString());
                        break;
                }
                this.mCachedClipPath = canvas;
            } else {
                canvas = ReactConstants.TAG;
                paint = new StringBuilder();
                paint.append("RNSVG: Undefined clipPath: ");
                paint.append(this.mClipPath);
                FLog.w(canvas, paint.toString());
            }
        }
        return getClipPath();
    }

    void clip(Canvas canvas, Paint paint) {
        paint = getClipPath(canvas, paint);
        if (paint != null) {
            canvas.clipPath(paint);
        }
    }

    boolean isResponsible() {
        return this.mResponsible;
    }

    SvgView getSvgView() {
        if (this.svgView != null) {
            return this.svgView;
        }
        ViewParent parent = getParent();
        if (parent == null) {
            return null;
        }
        if (parent instanceof SvgView) {
            this.svgView = (SvgView) parent;
        } else if (parent instanceof VirtualView) {
            this.svgView = ((VirtualView) parent).getSvgView();
        } else {
            String str = ReactConstants.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("RNSVG: ");
            stringBuilder.append(getClass().getName());
            stringBuilder.append(" should be descendant of a SvgView.");
            FLog.e(str, stringBuilder.toString());
        }
        return this.svgView;
    }

    double relativeOnWidth(SVGLength sVGLength) {
        SVGLengthUnitType sVGLengthUnitType = sVGLength.unit;
        if (sVGLengthUnitType == SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER) {
            return sVGLength.value * ((double) this.mScale);
        }
        if (sVGLengthUnitType == SVGLengthUnitType.SVG_LENGTHTYPE_PERCENTAGE) {
            return (sVGLength.value / 100.0d) * ((double) getCanvasWidth());
        }
        return fromRelativeFast(sVGLength);
    }

    double relativeOnHeight(SVGLength sVGLength) {
        SVGLengthUnitType sVGLengthUnitType = sVGLength.unit;
        if (sVGLengthUnitType == SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER) {
            return sVGLength.value * ((double) this.mScale);
        }
        if (sVGLengthUnitType == SVGLengthUnitType.SVG_LENGTHTYPE_PERCENTAGE) {
            return (sVGLength.value / 100.0d) * ((double) getCanvasHeight());
        }
        return fromRelativeFast(sVGLength);
    }

    double relativeOnOther(SVGLength sVGLength) {
        SVGLengthUnitType sVGLengthUnitType = sVGLength.unit;
        if (sVGLengthUnitType == SVGLengthUnitType.SVG_LENGTHTYPE_NUMBER) {
            return sVGLength.value * ((double) this.mScale);
        }
        if (sVGLengthUnitType == SVGLengthUnitType.SVG_LENGTHTYPE_PERCENTAGE) {
            return (sVGLength.value / 100.0d) * getCanvasDiagonal();
        }
        return fromRelativeFast(sVGLength);
    }

    double fromRelativeFast(SVGLength sVGLength) {
        double fontSizeFromContext;
        switch (sVGLength.unit) {
            case SVG_LENGTHTYPE_EMS:
                fontSizeFromContext = getFontSizeFromContext();
                break;
            case SVG_LENGTHTYPE_EXS:
                fontSizeFromContext = getFontSizeFromContext() / 2.0d;
                break;
            case SVG_LENGTHTYPE_CM:
                fontSizeFromContext = 35.43307d;
                break;
            case SVG_LENGTHTYPE_MM:
                fontSizeFromContext = 3.543307d;
                break;
            case SVG_LENGTHTYPE_IN:
                fontSizeFromContext = 90.0d;
                break;
            case SVG_LENGTHTYPE_PT:
                fontSizeFromContext = 1.25d;
                break;
            case SVG_LENGTHTYPE_PC:
                fontSizeFromContext = 15.0d;
                break;
            default:
                fontSizeFromContext = 1.0d;
                break;
        }
        return (sVGLength.value * fontSizeFromContext) * ((double) this.mScale);
    }

    private float getCanvasWidth() {
        if (this.canvasWidth != -1.0f) {
            return this.canvasWidth;
        }
        GroupView textRoot = getTextRoot();
        if (textRoot == null) {
            this.canvasWidth = (float) getSvgView().getCanvasBounds().width();
        } else {
            this.canvasWidth = textRoot.getGlyphContext().getWidth();
        }
        return this.canvasWidth;
    }

    private float getCanvasHeight() {
        if (this.canvasHeight != -1.0f) {
            return this.canvasHeight;
        }
        GroupView textRoot = getTextRoot();
        if (textRoot == null) {
            this.canvasHeight = (float) getSvgView().getCanvasBounds().height();
        } else {
            this.canvasHeight = textRoot.getGlyphContext().getHeight();
        }
        return this.canvasHeight;
    }

    private double getCanvasDiagonal() {
        if (this.canvasDiagonal != -1.0d) {
            return this.canvasDiagonal;
        }
        this.canvasDiagonal = Math.sqrt(Math.pow((double) getCanvasWidth(), 2.0d) + Math.pow((double) getCanvasHeight(), 2.0d)) * M_SQRT1_2l;
        return this.canvasDiagonal;
    }

    void saveDefinition() {
        if (this.mName != null) {
            getSvgView().defineTemplate(this, this.mName);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.mClientRect != null) {
            i = (int) Math.ceil((double) this.mClientRect.width());
        } else {
            i = getDefaultSize(getSuggestedMinimumWidth(), i);
        }
        if (this.mClientRect != null) {
            i2 = (int) Math.ceil((double) this.mClientRect.height());
        } else {
            i2 = getDefaultSize(getSuggestedMinimumHeight(), i2);
        }
        setMeasuredDimension(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mClientRect) {
            if (!(this instanceof GroupView)) {
                i = (int) Math.floor((double) this.mClientRect.top);
                i2 = (int) Math.ceil((double) this.mClientRect.right);
                i3 = (int) Math.ceil((double) this.mClientRect.bottom);
                setLeft((int) Math.floor((double) this.mClientRect.left));
                setTop(i);
                setRight(i2);
                setBottom(i3);
            }
            setMeasuredDimension((int) Math.ceil((double) this.mClientRect.width()), (int) Math.ceil((double) this.mClientRect.height()));
        }
    }

    void setClientRect(RectF rectF) {
        if (this.mClientRect == null || !this.mClientRect.equals(rectF)) {
            this.mClientRect = rectF;
            if (this.mClientRect != null) {
                rectF = (int) Math.floor((double) this.mClientRect.left);
                int floor = (int) Math.floor((double) this.mClientRect.top);
                int ceil = (int) Math.ceil((double) this.mClientRect.right);
                int ceil2 = (int) Math.ceil((double) this.mClientRect.bottom);
                int ceil3 = (int) Math.ceil((double) this.mClientRect.width());
                int ceil4 = (int) Math.ceil((double) this.mClientRect.height());
                if (!(this instanceof GroupView)) {
                    setLeft(rectF);
                    setTop(floor);
                    setRight(ceil);
                    setBottom(ceil2);
                }
                setMeasuredDimension(ceil3, ceil4);
                ((UIManagerModule) this.mContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(OnLayoutEvent.obtain(getId(), rectF, floor, ceil3, ceil4));
            }
        }
    }

    RectF getClientRect() {
        return this.mClientRect;
    }

    SVGLength getLengthFromDynamic(Dynamic dynamic) {
        switch (C67491.$SwitchMap$com$facebook$react$bridge$ReadableType[dynamic.getType().ordinal()]) {
            case 1:
                return new SVGLength(dynamic.asDouble());
            case 2:
                return new SVGLength(dynamic.asString());
            default:
                return new SVGLength();
        }
    }

    String getStringFromDynamic(Dynamic dynamic) {
        switch (C67491.$SwitchMap$com$facebook$react$bridge$ReadableType[dynamic.getType().ordinal()]) {
            case 1:
                return String.valueOf(dynamic.asDouble());
            case 2:
                return dynamic.asString();
            default:
                return null;
        }
    }

    ArrayList<SVGLength> getLengthArrayFromDynamic(Dynamic dynamic) {
        ArrayList<SVGLength> arrayList;
        switch (C67491.$SwitchMap$com$facebook$react$bridge$ReadableType[dynamic.getType().ordinal()]) {
            case 1:
                arrayList = new ArrayList(1);
                arrayList.add(new SVGLength(dynamic.asDouble()));
                return arrayList;
            case 2:
                arrayList = new ArrayList(1);
                arrayList.add(new SVGLength(dynamic.asString()));
                return arrayList;
            case 3:
                dynamic = dynamic.asArray();
                int size = dynamic.size();
                ArrayList<SVGLength> arrayList2 = new ArrayList(size);
                for (int i = 0; i < size; i++) {
                    arrayList2.add(getLengthFromDynamic(dynamic.getDynamic(i)));
                }
                return arrayList2;
            default:
                return null;
        }
    }
}
