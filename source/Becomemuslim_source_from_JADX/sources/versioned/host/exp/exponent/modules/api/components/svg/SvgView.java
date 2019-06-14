package versioned.host.exp.exponent.modules.api.components.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.Base64;
import android.view.View;
import android.view.ViewParent;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.ReactCompoundView;
import com.facebook.react.uimanager.ReactCompoundViewGroup;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"ViewConstructor"})
public class SvgView extends ReactViewGroup implements ReactCompoundView, ReactCompoundViewGroup {
    private String mAlign;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private final Map<String, Brush> mDefinedBrushes = new HashMap();
    private final Map<String, VirtualView> mDefinedClipPaths = new HashMap();
    private final Map<String, VirtualView> mDefinedMasks = new HashMap();
    private final Map<String, VirtualView> mDefinedTemplates = new HashMap();
    private final Matrix mInvViewBoxMatrix = new Matrix();
    private boolean mInvertible = true;
    private int mMeetOrSlice;
    private float mMinX;
    private float mMinY;
    private boolean mRendered = false;
    private boolean mResponsible = false;
    private final float mScale = DisplayMetricsHolder.getScreenDisplayMetrics().density;
    int mTintColor = 0;
    private float mVbHeight;
    private float mVbWidth;
    private String mbbHeight;
    private String mbbWidth;

    public enum Events {
        EVENT_DATA_URL("onDataURL");
        
        private final String mName;

        private Events(String str) {
            this.mName = str;
        }

        public String toString() {
            return this.mName;
        }
    }

    public boolean interceptsTouchEvent(float f, float f2) {
        return true;
    }

    public SvgView(ReactContext reactContext) {
        super(reactContext);
    }

    public void setId(int i) {
        super.setId(i);
        SvgViewManager.setSvgView(i, this);
    }

    public void invalidate() {
        super.invalidate();
        if (this.mBitmap != null) {
            this.mBitmap.recycle();
        }
        this.mBitmap = null;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mBitmap == null) {
            this.mBitmap = drawOutput();
        }
        if (this.mBitmap != null) {
            canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, null);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        invalidate();
    }

    public int reactTagForTouch(float f, float f2) {
        return hitTest(f, f2);
    }

    private void releaseCachedPath() {
        if (this.mRendered) {
            int i = 0;
            this.mRendered = false;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt instanceof VirtualView) {
                    ((VirtualView) childAt).releaseCachedPath();
                }
                i++;
            }
        }
    }

    @ReactProp(customType = "Color", name = "tintColor")
    public void setTintColor(Integer num) {
        if (num == null) {
            this.mTintColor = null;
        } else {
            this.mTintColor = num.intValue();
        }
    }

    @ReactProp(name = "minX")
    public void setMinX(float f) {
        this.mMinX = f;
        invalidate();
        releaseCachedPath();
    }

    @ReactProp(name = "minY")
    public void setMinY(float f) {
        this.mMinY = f;
        invalidate();
        releaseCachedPath();
    }

    @ReactProp(name = "vbWidth")
    public void setVbWidth(float f) {
        this.mVbWidth = f;
        invalidate();
        releaseCachedPath();
    }

    @ReactProp(name = "vbHeight")
    public void setVbHeight(float f) {
        this.mVbHeight = f;
        invalidate();
        releaseCachedPath();
    }

    @ReactProp(name = "bbWidth")
    public void setVbWidth(String str) {
        this.mbbWidth = str;
        invalidate();
        releaseCachedPath();
    }

    @ReactProp(name = "bbHeight")
    public void setVbHeight(String str) {
        this.mbbHeight = str;
        invalidate();
        releaseCachedPath();
    }

    @ReactProp(name = "align")
    public void setAlign(String str) {
        this.mAlign = str;
        invalidate();
        releaseCachedPath();
    }

    @ReactProp(name = "meetOrSlice")
    public void setMeetOrSlice(int i) {
        this.mMeetOrSlice = i;
        invalidate();
        releaseCachedPath();
    }

    private Bitmap drawOutput() {
        boolean z = true;
        this.mRendered = true;
        float width = (float) getWidth();
        float height = (float) getHeight();
        if (!(Float.isNaN(width) || Float.isNaN(height) || width * height == 0.0f)) {
            if (Math.log10((double) width) + Math.log10((double) height) <= 42.0d) {
                z = false;
            }
        }
        if (z) {
            float f;
            ViewParent parent = getParent();
            View view = parent instanceof View ? (View) parent : null;
            if (view == null) {
                width = 0.0f;
            } else {
                width = (float) view.getWidth();
            }
            if (view == null) {
                f = 0.0f;
            } else {
                f = (float) view.getHeight();
            }
            width = (float) PropHelper.fromRelative(this.mbbWidth, (double) width, 0.0d, (double) this.mScale, 12.0d);
            height = (float) PropHelper.fromRelative(this.mbbHeight, (double) f, 0.0d, (double) this.mScale, 12.0d);
            setMeasuredDimension((int) Math.ceil((double) width), (int) Math.ceil((double) height));
        }
        if (width != 0.0f) {
            if (height != 0.0f) {
                Bitmap createBitmap = Bitmap.createBitmap((int) width, (int) height, Config.ARGB_8888);
                drawChildren(new Canvas(createBitmap));
                return createBitmap;
            }
        }
        return null;
    }

    Rect getCanvasBounds() {
        return this.mCanvas.getClipBounds();
    }

    void drawChildren(Canvas canvas) {
        this.mCanvas = canvas;
        if (this.mAlign != null) {
            RectF viewBox = getViewBox();
            float width = (float) canvas.getWidth();
            float height = (float) canvas.getHeight();
            boolean z = getParent() instanceof VirtualView;
            if (z) {
                width = (float) PropHelper.fromRelative(this.mbbWidth, (double) width, 0.0d, (double) this.mScale, 12.0d);
                height = (float) PropHelper.fromRelative(this.mbbHeight, (double) height, 0.0d, (double) this.mScale, 12.0d);
            }
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            if (z) {
                canvas.clipRect(rectF);
            }
            Matrix transform = ViewBox.getTransform(viewBox, rectF, this.mAlign, this.mMeetOrSlice);
            this.mInvertible = transform.invert(this.mInvViewBoxMatrix);
            canvas.concat(transform);
        }
        Paint paint = new Paint();
        paint.setFlags(385);
        paint.setTypeface(Typeface.DEFAULT);
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof VirtualView) {
                ((VirtualView) childAt).saveDefinition();
            }
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt2 = getChildAt(i2);
            if (childAt2 instanceof VirtualView) {
                VirtualView virtualView = (VirtualView) childAt2;
                int saveAndSetupCanvas = virtualView.saveAndSetupCanvas(canvas);
                virtualView.render(canvas, paint, 1.0f);
                virtualView.restoreCanvas(canvas, saveAndSetupCanvas);
                if (virtualView.isResponsible() && !this.mResponsible) {
                    this.mResponsible = true;
                }
            }
        }
    }

    private RectF getViewBox() {
        return new RectF(this.mMinX * this.mScale, this.mMinY * this.mScale, (this.mMinX + this.mVbWidth) * this.mScale, (this.mMinY + this.mVbHeight) * this.mScale);
    }

    String toDataURL() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);
        drawChildren(new Canvas(createBitmap));
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        createBitmap.recycle();
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    void enableTouchEvents() {
        if (!this.mResponsible) {
            this.mResponsible = true;
        }
    }

    private int hitTest(float f, float f2) {
        if (this.mResponsible) {
            if (this.mInvertible) {
                float[] fArr = new float[]{f, f2};
                this.mInvViewBoxMatrix.mapPoints(fArr);
                int i = -1;
                for (f2 = getChildCount() - Float.MIN_VALUE; f2 >= null; f2--) {
                    View childAt = getChildAt(f2);
                    if (childAt instanceof VirtualView) {
                        i = ((VirtualView) childAt).hitTest(fArr);
                        if (i != -1) {
                            break;
                        }
                    }
                }
                if (i == -1) {
                    i = getId();
                }
                return i;
            }
        }
        return getId();
    }

    void defineClipPath(VirtualView virtualView, String str) {
        this.mDefinedClipPaths.put(str, virtualView);
    }

    VirtualView getDefinedClipPath(String str) {
        return (VirtualView) this.mDefinedClipPaths.get(str);
    }

    void defineTemplate(VirtualView virtualView, String str) {
        this.mDefinedTemplates.put(str, virtualView);
    }

    VirtualView getDefinedTemplate(String str) {
        return (VirtualView) this.mDefinedTemplates.get(str);
    }

    void defineBrush(Brush brush, String str) {
        this.mDefinedBrushes.put(str, brush);
    }

    Brush getDefinedBrush(String str) {
        return (Brush) this.mDefinedBrushes.get(str);
    }

    void defineMask(VirtualView virtualView, String str) {
        this.mDefinedMasks.put(str, virtualView);
    }

    VirtualView getDefinedMask(String str) {
        return (VirtualView) this.mDefinedMasks.get(str);
    }
}
