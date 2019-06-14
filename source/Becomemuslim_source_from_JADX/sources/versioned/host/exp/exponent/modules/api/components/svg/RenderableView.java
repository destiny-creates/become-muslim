package versioned.host.exp.exponent.modules.api.components.svg;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Pattern;

public abstract class RenderableView extends VirtualView {
    private static final int CAP_BUTT = 0;
    static final int CAP_ROUND = 1;
    private static final int CAP_SQUARE = 2;
    private static final int FILL_RULE_EVENODD = 0;
    static final int FILL_RULE_NONZERO = 1;
    private static final int JOIN_BEVEL = 2;
    private static final int JOIN_MITER = 0;
    static final int JOIN_ROUND = 1;
    private static final Pattern regex = Pattern.compile("[0-9.-]+");
    public ReadableArray fill;
    public float fillOpacity = 1.0f;
    public FillType fillRule = FillType.WINDING;
    ArrayList<String> mAttributeList;
    ArrayList<String> mLastMergedList;
    ArrayList<Object> mOriginProperties;
    ArrayList<String> mPropList;
    public ReadableArray stroke;
    public SVGLength[] strokeDasharray;
    public float strokeDashoffset = 0.0f;
    public Cap strokeLinecap = Cap.ROUND;
    public Join strokeLinejoin = Join.ROUND;
    public float strokeMiterlimit = 4.0f;
    public float strokeOpacity = 1.0f;
    public SVGLength strokeWidth = new SVGLength(1.0d);

    private static double saturate(double d) {
        return d <= 0.0d ? 0.0d : d >= 1.0d ? 1.0d : d;
    }

    abstract Path getPath(Canvas canvas, Paint paint);

    RenderableView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "fill")
    public void setFill(Dynamic dynamic) {
        if (dynamic != null) {
            if (!dynamic.isNull()) {
                if (dynamic.getType().equals(ReadableType.Array)) {
                    this.fill = dynamic.asArray();
                } else {
                    ReadableArray javaOnlyArray = new JavaOnlyArray();
                    int i = 0;
                    javaOnlyArray.pushInt(0);
                    dynamic = regex.matcher(dynamic.asString());
                    while (dynamic.find()) {
                        Double valueOf = Double.valueOf(Double.parseDouble(dynamic.group()));
                        int i2 = i + 1;
                        javaOnlyArray.pushDouble(i < 3 ? valueOf.doubleValue() / 255.0d : valueOf.doubleValue());
                        i = i2;
                    }
                    this.fill = javaOnlyArray;
                }
                invalidate();
                return;
            }
        }
        this.fill = null;
        invalidate();
    }

    @ReactProp(defaultFloat = 1.0f, name = "fillOpacity")
    public void setFillOpacity(float f) {
        this.fillOpacity = f;
        invalidate();
    }

    @ReactProp(defaultInt = 1, name = "fillRule")
    public void setFillRule(int i) {
        switch (i) {
            case 0:
                this.fillRule = FillType.EVEN_ODD;
                break;
            case 1:
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("fillRule ");
                stringBuilder.append(this.fillRule);
                stringBuilder.append(" unrecognized");
                throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
        }
        invalidate();
    }

    @ReactProp(name = "stroke")
    public void setStroke(Dynamic dynamic) {
        if (dynamic != null) {
            if (!dynamic.isNull()) {
                if (dynamic.getType().equals(ReadableType.Array)) {
                    this.stroke = dynamic.asArray();
                } else {
                    ReadableArray javaOnlyArray = new JavaOnlyArray();
                    javaOnlyArray.pushInt(0);
                    dynamic = regex.matcher(dynamic.asString());
                    while (dynamic.find()) {
                        javaOnlyArray.pushDouble(Double.valueOf(Double.parseDouble(dynamic.group())).doubleValue());
                    }
                    this.stroke = javaOnlyArray;
                }
                invalidate();
                return;
            }
        }
        this.stroke = null;
        invalidate();
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeOpacity")
    public void setStrokeOpacity(float f) {
        this.strokeOpacity = f;
        invalidate();
    }

    @ReactProp(name = "strokeDasharray")
    public void setStrokeDasharray(ReadableArray readableArray) {
        if (readableArray != null) {
            int size = readableArray.size();
            this.strokeDasharray = new SVGLength[size];
            for (int i = 0; i < size; i++) {
                this.strokeDasharray[i] = new SVGLength(readableArray.getString(i));
            }
        } else {
            this.strokeDasharray = null;
        }
        invalidate();
    }

    @ReactProp(name = "strokeDashoffset")
    public void setStrokeDashoffset(float f) {
        this.strokeDashoffset = f * this.mScale;
        invalidate();
    }

    @ReactProp(name = "strokeWidth")
    public void setStrokeWidth(Dynamic dynamic) {
        this.strokeWidth = getLengthFromDynamic(dynamic);
        invalidate();
    }

    @ReactProp(defaultFloat = 4.0f, name = "strokeMiterlimit")
    public void setStrokeMiterlimit(float f) {
        this.strokeMiterlimit = f;
        invalidate();
    }

    @ReactProp(defaultInt = 1, name = "strokeLinecap")
    public void setStrokeLinecap(int i) {
        switch (i) {
            case 0:
                this.strokeLinecap = Cap.BUTT;
                break;
            case 1:
                this.strokeLinecap = Cap.ROUND;
                break;
            case 2:
                this.strokeLinecap = Cap.SQUARE;
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("strokeLinecap ");
                stringBuilder.append(this.strokeLinecap);
                stringBuilder.append(" unrecognized");
                throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
        }
        invalidate();
    }

    @ReactProp(defaultInt = 1, name = "strokeLinejoin")
    public void setStrokeLinejoin(int i) {
        switch (i) {
            case 0:
                this.strokeLinejoin = Join.MITER;
                break;
            case 1:
                this.strokeLinejoin = Join.ROUND;
                break;
            case 2:
                this.strokeLinejoin = Join.BEVEL;
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("strokeLinejoin ");
                stringBuilder.append(this.strokeLinejoin);
                stringBuilder.append(" unrecognized");
                throw new JSApplicationIllegalArgumentException(stringBuilder.toString());
        }
        invalidate();
    }

    @ReactProp(name = "propList")
    public void setPropList(ReadableArray readableArray) {
        if (readableArray != null) {
            ArrayList arrayList = new ArrayList();
            this.mAttributeList = arrayList;
            this.mPropList = arrayList;
            for (int i = 0; i < readableArray.size(); i++) {
                this.mPropList.add(readableArray.getString(i));
            }
        }
        invalidate();
    }

    void render(Canvas canvas, Paint paint, float f) {
        Paint paint2 = paint;
        MaskView maskView = this.mMask != null ? (MaskView) getSvgView().getDefinedMask(r0.mMask) : null;
        if (maskView != null) {
            Paint paint3;
            Rect clipBounds = canvas.getClipBounds();
            int height = clipBounds.height();
            int width = clipBounds.width();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
            Bitmap createBitmap2 = Bitmap.createBitmap(width, height, Config.ARGB_8888);
            Bitmap createBitmap3 = Bitmap.createBitmap(width, height, Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            Canvas canvas3 = new Canvas(createBitmap);
            Canvas canvas4 = new Canvas(createBitmap3);
            int i = width;
            canvas3.clipRect((float) relativeOnWidth(maskView.mX), (float) relativeOnWidth(maskView.mY), (float) relativeOnWidth(maskView.mW), (float) relativeOnWidth(maskView.mH));
            Paint paint4 = new Paint(1);
            maskView.draw(canvas3, paint4, 1.0f);
            width = i * height;
            int[] iArr = new int[width];
            Canvas canvas5 = canvas4;
            Canvas canvas6 = canvas2;
            Bitmap bitmap = createBitmap3;
            createBitmap.getPixels(iArr, 0, i, 0, 0, i, height);
            int i2 = 0;
            while (i2 < width) {
                int i3 = iArr[i2];
                paint3 = paint4;
                int i4 = width;
                iArr[i2] = ((int) (((double) (i3 >>> 24)) * saturate((((((double) ((i3 >> 16) & JfifUtil.MARKER_FIRST_BYTE)) * 0.299d) + (((double) ((i3 >> 8) & JfifUtil.MARKER_FIRST_BYTE)) * 0.587d)) + (((double) (i3 & JfifUtil.MARKER_FIRST_BYTE)) * 0.144d)) / 255.0d))) << 24;
                i2++;
                paint4 = paint3;
                width = i4;
            }
            paint3 = paint4;
            createBitmap.setPixels(iArr, 0, i, 0, 0, i, height);
            draw(canvas6, paint2, f);
            paint4 = paint3;
            paint4.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
            Canvas canvas7 = canvas5;
            canvas7.drawBitmap(createBitmap2, 0.0f, 0.0f, null);
            canvas7.drawBitmap(createBitmap, 0.0f, 0.0f, paint4);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint2);
            return;
        }
        Canvas canvas8 = canvas;
        float f2 = f;
        draw(canvas, paint, f);
    }

    void draw(Canvas canvas, Paint paint, float f) {
        f *= this.mOpacity;
        if (f > 0.01f) {
            Object obj = this.mPath == null ? 1 : null;
            if (obj != null) {
                this.mPath = getPath(canvas, paint);
                this.mPath.setFillType(this.fillRule);
            }
            Path path = this.mPath;
            RectF rectF = new RectF();
            path.computeBounds(rectF, true);
            this.mBox = new RectF(rectF);
            new Matrix(canvas.getMatrix()).mapRect(rectF);
            setClientRect(rectF);
            clip(canvas, paint);
            if (setupFillPaint(paint, this.fillOpacity * f)) {
                if (obj != null) {
                    this.mFillPath = new Path();
                    paint.getFillPath(path, this.mFillPath);
                }
                canvas.drawPath(path, paint);
            }
            if (setupStrokePaint(paint, f * this.strokeOpacity) != null) {
                if (obj != null) {
                    this.mStrokePath = new Path();
                    paint.getFillPath(path, this.mStrokePath);
                }
                canvas.drawPath(path, paint);
            }
        }
    }

    private boolean setupFillPaint(Paint paint, float f) {
        if (this.fill == null || this.fill.size() <= 0) {
            return null;
        }
        paint.reset();
        paint.setFlags(385);
        paint.setStyle(Style.FILL);
        setupPaint(paint, f, this.fill);
        return true;
    }

    private boolean setupStrokePaint(Paint paint, float f) {
        paint.reset();
        double relativeOnOther = relativeOnOther(this.strokeWidth);
        int i = 0;
        if (!(relativeOnOther == 0.0d || this.stroke == null)) {
            if (this.stroke.size() != 0) {
                paint.setFlags(385);
                paint.setStyle(Style.STROKE);
                paint.setStrokeCap(this.strokeLinecap);
                paint.setStrokeJoin(this.strokeLinejoin);
                paint.setStrokeMiter(this.strokeMiterlimit * this.mScale);
                paint.setStrokeWidth((float) relativeOnOther);
                setupPaint(paint, f, this.stroke);
                if (this.strokeDasharray != null) {
                    int length = this.strokeDasharray.length;
                    float[] fArr = new float[length];
                    while (i < length) {
                        fArr[i] = (float) relativeOnOther(this.strokeDasharray[i]);
                        i++;
                    }
                    paint.setPathEffect(new DashPathEffect(fArr, this.strokeDashoffset));
                }
                return true;
            }
        }
        return false;
    }

    private void setupPaint(Paint paint, float f, ReadableArray readableArray) {
        switch (readableArray.getInt(0)) {
            case 0:
                paint.setARGB((int) (readableArray.size() > 4 ? (readableArray.getDouble(4) * ((double) f)) * 255.0d : (double) (f * 255.0f)), (int) (readableArray.getDouble(1) * 255.0d), (int) (readableArray.getDouble(2) * 255.0d), (int) (readableArray.getDouble(3) * 255.0d));
                return;
            case 1:
                readableArray = getSvgView().getDefinedBrush(readableArray.getString(1));
                if (readableArray != null) {
                    readableArray.setupPaint(paint, this.mBox, this.mScale, f);
                    return;
                }
                return;
            case 2:
                paint.setColor(getSvgView().mTintColor);
                return;
            default:
                return;
        }
    }

    int hitTest(float[] fArr) {
        if (this.mPath != null && this.mInvertible) {
            if (this.mTransformInvertible) {
                float[] fArr2 = new float[2];
                this.mInvMatrix.mapPoints(fArr2, fArr);
                this.mInvTransform.mapPoints(fArr2);
                fArr = Math.round(fArr2[null]);
                int round = Math.round(fArr2[1]);
                if (this.mRegion == null && this.mFillPath != null) {
                    this.mRegion = getRegion(this.mFillPath);
                }
                if (this.mRegion == null && this.mPath != null) {
                    this.mRegion = getRegion(this.mPath);
                }
                if (this.mStrokeRegion == null && this.mStrokePath != null) {
                    this.mStrokeRegion = getRegion(this.mStrokePath);
                }
                if (this.mRegion == null || !this.mRegion.contains(fArr, round)) {
                    if (this.mStrokeRegion != null) {
                        if (!this.mStrokeRegion.contains(fArr, round)) {
                        }
                    }
                    return -1;
                }
                Path clipPath = getClipPath();
                if (clipPath != null) {
                    if (this.mClipRegionPath != clipPath) {
                        this.mClipRegionPath = clipPath;
                        this.mClipRegion = getRegion(clipPath);
                    }
                    if (this.mClipRegion.contains(fArr, round) == null) {
                        return -1;
                    }
                }
                return getId();
            }
        }
        return -1;
    }

    Region getRegion(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        Region region = new Region();
        region.setPath(path, new Region((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom)));
        return region;
    }

    private ArrayList<String> getAttributeList() {
        return this.mAttributeList;
    }

    void mergeProperties(RenderableView renderableView) {
        ArrayList attributeList = renderableView.getAttributeList();
        if (attributeList != null) {
            if (attributeList.size() != 0) {
                this.mOriginProperties = new ArrayList();
                this.mAttributeList = this.mPropList == null ? new ArrayList() : new ArrayList(this.mPropList);
                int i = 0;
                int size = attributeList.size();
                while (i < size) {
                    try {
                        String str = (String) attributeList.get(i);
                        Field field = getClass().getField(str);
                        Object obj = field.get(renderableView);
                        this.mOriginProperties.add(field.get(this));
                        if (!hasOwnProperty(str)) {
                            this.mAttributeList.add(str);
                            field.set(this, obj);
                        }
                        i++;
                    } catch (RenderableView renderableView2) {
                        throw new IllegalStateException(renderableView2);
                    }
                }
                this.mLastMergedList = attributeList;
            }
        }
    }

    void resetProperties() {
        if (this.mLastMergedList != null && this.mOriginProperties != null) {
            try {
                for (int size = this.mLastMergedList.size() - 1; size >= 0; size--) {
                    getClass().getField((String) this.mLastMergedList.get(size)).set(this, this.mOriginProperties.get(size));
                }
                this.mLastMergedList = null;
                this.mOriginProperties = null;
                this.mAttributeList = this.mPropList;
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private boolean hasOwnProperty(String str) {
        return (this.mAttributeList == null || this.mAttributeList.contains(str) == null) ? null : true;
    }
}
