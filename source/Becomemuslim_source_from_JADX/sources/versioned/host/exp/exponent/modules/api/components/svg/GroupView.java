package versioned.host.exp.exponent.modules.api.components.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;

@SuppressLint({"ViewConstructor"})
class GroupView extends RenderableView {
    ReadableMap mFont;
    GlyphContext mGlyphContext;

    public GroupView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "font")
    public void setFont(ReadableMap readableMap) {
        this.mFont = readableMap;
        invalidate();
    }

    void setupGlyphContext(Canvas canvas) {
        RectF rectF = new RectF(canvas.getClipBounds());
        if (this.mMatrix != null) {
            this.mMatrix.mapRect(rectF);
        }
        if (this.mTransform != null) {
            this.mTransform.mapRect(rectF);
        }
        this.mGlyphContext = new GlyphContext(this.mScale, rectF.width(), rectF.height());
    }

    GlyphContext getGlyphContext() {
        return this.mGlyphContext;
    }

    private static <T> T requireNonNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    GlyphContext getTextRootGlyphContext() {
        return ((GroupView) requireNonNull(getTextRoot())).getGlyphContext();
    }

    void pushGlyphContext() {
        getTextRootGlyphContext().pushContext(this, this.mFont);
    }

    void popGlyphContext() {
        getTextRootGlyphContext().popContext();
    }

    void draw(Canvas canvas, Paint paint, float f) {
        setupGlyphContext(canvas);
        if (f > 0.01f) {
            clip(canvas, paint);
            drawGroup(canvas, paint, f);
        }
    }

    void drawGroup(Canvas canvas, Paint paint, float f) {
        pushGlyphContext();
        SvgView svgView = getSvgView();
        RectF rectF = new RectF();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof VirtualView) {
                VirtualView virtualView = (VirtualView) childAt;
                boolean z = virtualView instanceof RenderableView;
                if (z) {
                    ((RenderableView) virtualView).mergeProperties(this);
                }
                int saveAndSetupCanvas = virtualView.saveAndSetupCanvas(canvas);
                virtualView.render(canvas, paint, this.mOpacity * f);
                RectF clientRect = virtualView.getClientRect();
                if (clientRect != null) {
                    rectF.union(clientRect);
                }
                virtualView.restoreCanvas(canvas, saveAndSetupCanvas);
                if (z) {
                    ((RenderableView) virtualView).resetProperties();
                }
                if (virtualView.isResponsible()) {
                    svgView.enableTouchEvents();
                }
            } else if (childAt instanceof SvgView) {
                ((SvgView) childAt).drawChildren(canvas);
            }
        }
        setClientRect(rectF);
        popGlyphContext();
    }

    void drawPath(Canvas canvas, Paint paint, float f) {
        super.draw(canvas, paint, f);
    }

    Path getPath(Canvas canvas, Paint paint) {
        Path path = new Path();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof VirtualView) {
                VirtualView virtualView = (VirtualView) childAt;
                path.addPath(virtualView.getPath(canvas, paint), virtualView.mMatrix);
            }
        }
        return path;
    }

    Path getPath(Canvas canvas, Paint paint, Op op) {
        Path path = new Path();
        int i = 0;
        if (VERSION.SDK_INT >= 19) {
            Path.Op valueOf = Path.Op.valueOf(op.name());
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt instanceof VirtualView) {
                    Path path2;
                    VirtualView virtualView = (VirtualView) childAt;
                    Matrix matrix = virtualView.mMatrix;
                    if (virtualView instanceof GroupView) {
                        path2 = ((GroupView) virtualView).getPath(canvas, paint, op);
                    } else {
                        path2 = virtualView.getPath(canvas, paint);
                    }
                    path2.transform(matrix);
                    path.op(path2, valueOf);
                }
                i++;
            }
        } else {
            Region region = new Region(canvas.getClipBounds());
            Region region2 = new Region();
            while (i < getChildCount()) {
                View childAt2 = getChildAt(i);
                if (childAt2 instanceof VirtualView) {
                    Path path3;
                    VirtualView virtualView2 = (VirtualView) childAt2;
                    Matrix matrix2 = virtualView2.mMatrix;
                    if (virtualView2 instanceof GroupView) {
                        path3 = ((GroupView) virtualView2).getPath(canvas, paint, op);
                    } else {
                        path3 = virtualView2.getPath(canvas, paint);
                    }
                    if (matrix2 != null) {
                        path3.transform(matrix2);
                    }
                    Region region3 = new Region();
                    region3.setPath(path3, region);
                    region2.op(region3, op);
                }
                i++;
            }
            path.addPath(region2.getBoundaryPath());
        }
        return path;
    }

    int hitTest(float[] fArr) {
        if (this.mInvertible) {
            if (this.mTransformInvertible) {
                float[] fArr2 = new float[2];
                this.mInvMatrix.mapPoints(fArr2, fArr);
                this.mInvTransform.mapPoints(fArr2);
                fArr = Math.round(fArr2[null]);
                int round = Math.round(fArr2[1]);
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
                for (fArr = getChildCount() - 1; fArr >= null; fArr--) {
                    View childAt = getChildAt(fArr);
                    if (childAt instanceof VirtualView) {
                        VirtualView virtualView = (VirtualView) childAt;
                        int hitTest = virtualView.hitTest(fArr2);
                        if (hitTest != -1) {
                            if (virtualView.isResponsible() == null) {
                                if (hitTest == childAt.getId()) {
                                    hitTest = getId();
                                }
                            }
                            return hitTest;
                        }
                    }
                }
                return -1;
            }
        }
        return -1;
    }

    void saveDefinition() {
        if (this.mName != null) {
            getSvgView().defineTemplate(this, this.mName);
        }
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof VirtualView) {
                ((VirtualView) childAt).saveDefinition();
            }
        }
    }

    void resetProperties() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof RenderableView) {
                ((RenderableView) childAt).resetProperties();
            }
        }
    }
}
