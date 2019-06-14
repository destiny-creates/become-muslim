package com.theartofdev.edmodo.cropper;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import com.theartofdev.edmodo.cropper.CropImageView.C5820b;
import com.theartofdev.edmodo.cropper.CropImageView.C5821c;
import java.util.Arrays;

public class CropOverlayView extends View {
    /* renamed from: A */
    private final Rect f19325A;
    /* renamed from: B */
    private boolean f19326B;
    /* renamed from: C */
    private Integer f19327C;
    /* renamed from: a */
    private ScaleGestureDetector f19328a;
    /* renamed from: b */
    private boolean f19329b;
    /* renamed from: c */
    private final C5846g f19330c;
    /* renamed from: d */
    private C5830a f19331d;
    /* renamed from: e */
    private final RectF f19332e;
    /* renamed from: f */
    private Paint f19333f;
    /* renamed from: g */
    private Paint f19334g;
    /* renamed from: h */
    private Paint f19335h;
    /* renamed from: i */
    private Paint f19336i;
    /* renamed from: j */
    private Path f19337j;
    /* renamed from: k */
    private final float[] f19338k;
    /* renamed from: l */
    private final RectF f19339l;
    /* renamed from: m */
    private int f19340m;
    /* renamed from: n */
    private int f19341n;
    /* renamed from: o */
    private float f19342o;
    /* renamed from: p */
    private float f19343p;
    /* renamed from: q */
    private float f19344q;
    /* renamed from: r */
    private float f19345r;
    /* renamed from: s */
    private float f19346s;
    /* renamed from: t */
    private C5849h f19347t;
    /* renamed from: u */
    private boolean f19348u;
    /* renamed from: v */
    private int f19349v;
    /* renamed from: w */
    private int f19350w;
    /* renamed from: x */
    private float f19351x;
    /* renamed from: y */
    private C5821c f19352y;
    /* renamed from: z */
    private C5820b f19353z;

    /* renamed from: com.theartofdev.edmodo.cropper.CropOverlayView$a */
    public interface C5830a {
        /* renamed from: a */
        void mo5081a(boolean z);
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropOverlayView$b */
    private class C5831b extends SimpleOnScaleGestureListener {
        /* renamed from: a */
        final /* synthetic */ CropOverlayView f19324a;

        private C5831b(CropOverlayView cropOverlayView) {
            this.f19324a = cropOverlayView;
        }

        @TargetApi(11)
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            RectF a = this.f19324a.f19330c.m24660a();
            float focusX = scaleGestureDetector.getFocusX();
            float focusY = scaleGestureDetector.getFocusY();
            float currentSpanY = scaleGestureDetector.getCurrentSpanY() / 2.0f;
            scaleGestureDetector = scaleGestureDetector.getCurrentSpanX() / 1073741824;
            float f = focusY - currentSpanY;
            float f2 = focusX - scaleGestureDetector;
            focusX += scaleGestureDetector;
            focusY += currentSpanY;
            if (f2 < focusX && f <= focusY && f2 >= 0.0f && focusX <= this.f19324a.f19330c.m24667d() && f >= 0.0f && focusY <= this.f19324a.f19330c.m24668e()) {
                a.set(f2, f, focusX, focusY);
                this.f19324a.f19330c.m24663a(a);
                this.f19324a.invalidate();
            }
            return true;
        }
    }

    public CropOverlayView(Context context) {
        this(context, null);
    }

    public CropOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19330c = new C5846g();
        this.f19332e = new RectF();
        this.f19337j = new Path();
        this.f19338k = new float[8];
        this.f19339l = new RectF();
        this.f19351x = ((float) this.f19349v) / ((float) this.f19350w);
        this.f19325A = new Rect();
    }

    public void setCropWindowChangeListener(C5830a c5830a) {
        this.f19331d = c5830a;
    }

    public RectF getCropWindowRect() {
        return this.f19330c.m24660a();
    }

    public void setCropWindowRect(RectF rectF) {
        this.f19330c.m24663a(rectF);
    }

    /* renamed from: a */
    public void m24583a() {
        RectF cropWindowRect = getCropWindowRect();
        m24573a(cropWindowRect);
        this.f19330c.m24663a(cropWindowRect);
    }

    /* renamed from: a */
    public void m24585a(float[] fArr, int i, int i2) {
        if (fArr == null || !Arrays.equals(this.f19338k, fArr)) {
            if (fArr == null) {
                Arrays.fill(this.f19338k, 0.0f);
            } else {
                System.arraycopy(fArr, 0, this.f19338k, 0, fArr.length);
            }
            this.f19340m = i;
            this.f19341n = i2;
            fArr = this.f19330c.m24660a();
            if (fArr.width() == 0 || fArr.height() == null) {
                m24579d();
            }
        }
    }

    /* renamed from: b */
    public void m24587b() {
        if (this.f19326B) {
            setCropWindowRect(C5838c.f19393b);
            m24579d();
            invalidate();
        }
    }

    public C5820b getCropShape() {
        return this.f19353z;
    }

    public void setCropShape(C5820b c5820b) {
        if (this.f19353z != c5820b) {
            this.f19353z = c5820b;
            if (VERSION.SDK_INT <= 17) {
                if (this.f19353z == C5820b.OVAL) {
                    this.f19327C = Integer.valueOf(getLayerType());
                    if (this.f19327C.intValue() != 1) {
                        setLayerType(1, null);
                    } else {
                        this.f19327C = null;
                    }
                } else if (this.f19327C != null) {
                    setLayerType(this.f19327C.intValue(), null);
                    this.f19327C = null;
                }
            }
            invalidate();
        }
    }

    public C5821c getGuidelines() {
        return this.f19352y;
    }

    public void setGuidelines(C5821c c5821c) {
        if (this.f19352y != c5821c) {
            this.f19352y = c5821c;
            if (this.f19326B != null) {
                invalidate();
            }
        }
    }

    /* renamed from: c */
    public boolean m24588c() {
        return this.f19348u;
    }

    public void setFixedAspectRatio(boolean z) {
        if (this.f19348u != z) {
            this.f19348u = z;
            if (this.f19326B) {
                m24579d();
                invalidate();
            }
        }
    }

    public int getAspectRatioX() {
        return this.f19349v;
    }

    public void setAspectRatioX(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        } else if (this.f19349v != i) {
            this.f19349v = i;
            this.f19351x = ((float) this.f19349v) / ((float) this.f19350w);
            if (this.f19326B != 0) {
                m24579d();
                invalidate();
            }
        }
    }

    public int getAspectRatioY() {
        return this.f19350w;
    }

    public void setAspectRatioY(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        } else if (this.f19350w != i) {
            this.f19350w = i;
            this.f19351x = ((float) this.f19349v) / ((float) this.f19350w);
            if (this.f19326B != 0) {
                m24579d();
                invalidate();
            }
        }
    }

    public void setSnapRadius(float f) {
        this.f19346s = f;
    }

    /* renamed from: a */
    public boolean m24586a(boolean z) {
        if (this.f19329b == z) {
            return false;
        }
        this.f19329b = z;
        if (this.f19329b && !this.f19328a) {
            this.f19328a = new ScaleGestureDetector(getContext(), new C5831b());
        }
        return true;
    }

    /* renamed from: a */
    public void m24584a(float f, float f2, float f3, float f4) {
        this.f19330c.m24662a(f, f2, f3, f4);
    }

    public Rect getInitialCropWindowRect() {
        return this.f19325A;
    }

    public void setInitialCropWindowRect(Rect rect) {
        Rect rect2 = this.f19325A;
        if (rect == null) {
            rect = C5838c.f19392a;
        }
        rect2.set(rect);
        if (this.f19326B != null) {
            m24579d();
            invalidate();
            m24576b((boolean) null);
        }
    }

    public void setInitialAttributeValues(C5845f c5845f) {
        this.f19330c.m24664a(c5845f);
        setCropShape(c5845f.f19434a);
        setSnapRadius(c5845f.f19435b);
        setGuidelines(c5845f.f19437d);
        setFixedAspectRatio(c5845f.f19445l);
        setAspectRatioX(c5845f.f19446m);
        setAspectRatioY(c5845f.f19447n);
        m24586a(c5845f.f19442i);
        this.f19345r = c5845f.f19436c;
        this.f19344q = c5845f.f19444k;
        this.f19333f = m24568a(c5845f.f19448o, c5845f.f19449p);
        this.f19342o = c5845f.f19451r;
        this.f19343p = c5845f.f19452s;
        this.f19334g = m24568a(c5845f.f19450q, c5845f.f19453t);
        this.f19335h = m24568a(c5845f.f19454u, c5845f.f19455v);
        this.f19336i = m24569a(c5845f.f19456w);
    }

    /* renamed from: d */
    private void m24579d() {
        float max = Math.max(C5838c.m24594a(this.f19338k), 0.0f);
        float max2 = Math.max(C5838c.m24617b(this.f19338k), 0.0f);
        float min = Math.min(C5838c.m24618c(this.f19338k), (float) getWidth());
        float min2 = Math.min(C5838c.m24619d(this.f19338k), (float) getHeight());
        if (min > max) {
            if (min2 > max2) {
                RectF rectF = new RectF();
                this.f19326B = true;
                float f = min - max;
                float f2 = this.f19344q * f;
                float f3 = min2 - max2;
                float f4 = this.f19344q * f3;
                if (this.f19325A.width() > 0 && this.f19325A.height() > 0) {
                    rectF.left = (((float) this.f19325A.left) / this.f19330c.m24669f()) + max;
                    rectF.top = (((float) this.f19325A.top) / this.f19330c.m24670g()) + max2;
                    rectF.right = rectF.left + (((float) this.f19325A.width()) / this.f19330c.m24669f());
                    rectF.bottom = rectF.top + (((float) this.f19325A.height()) / this.f19330c.m24670g());
                    rectF.left = Math.max(max, rectF.left);
                    rectF.top = Math.max(max2, rectF.top);
                    rectF.right = Math.min(min, rectF.right);
                    rectF.bottom = Math.min(min2, rectF.bottom);
                } else if (!this.f19348u || min <= max || min2 <= max2) {
                    rectF.left = max + f2;
                    rectF.top = max2 + f4;
                    rectF.right = min - f2;
                    rectF.bottom = min2 - f4;
                } else if (f / f3 > this.f19351x) {
                    rectF.top = max2 + f4;
                    rectF.bottom = min2 - f4;
                    max = ((float) getWidth()) / 2.0f;
                    this.f19351x = ((float) this.f19349v) / ((float) this.f19350w);
                    max2 = Math.max(this.f19330c.m24665b(), rectF.height() * this.f19351x) / 2.0f;
                    rectF.left = max - max2;
                    rectF.right = max + max2;
                } else {
                    rectF.left = max + f2;
                    rectF.right = min - f2;
                    max = ((float) getHeight()) / 2.0f;
                    max2 = Math.max(this.f19330c.m24666c(), rectF.width() / this.f19351x) / 2.0f;
                    rectF.top = max - max2;
                    rectF.bottom = max + max2;
                }
                m24573a(rectF);
                this.f19330c.m24663a(rectF);
            }
        }
    }

    /* renamed from: a */
    private void m24573a(RectF rectF) {
        if (rectF.width() < this.f19330c.m24665b()) {
            float b = (this.f19330c.m24665b() - rectF.width()) / 2.0f;
            rectF.left -= b;
            rectF.right += b;
        }
        if (rectF.height() < this.f19330c.m24666c()) {
            b = (this.f19330c.m24666c() - rectF.height()) / 2.0f;
            rectF.top -= b;
            rectF.bottom += b;
        }
        if (rectF.width() > this.f19330c.m24667d()) {
            b = (rectF.width() - this.f19330c.m24667d()) / 2.0f;
            rectF.left += b;
            rectF.right -= b;
        }
        if (rectF.height() > this.f19330c.m24668e()) {
            b = (rectF.height() - this.f19330c.m24668e()) / 2.0f;
            rectF.top += b;
            rectF.bottom -= b;
        }
        m24577b(rectF);
        if (this.f19339l.width() > 0.0f && this.f19339l.height() > 0.0f) {
            b = Math.max(this.f19339l.left, 0.0f);
            float max = Math.max(this.f19339l.top, 0.0f);
            float min = Math.min(this.f19339l.right, (float) getWidth());
            float min2 = Math.min(this.f19339l.bottom, (float) getHeight());
            if (rectF.left < b) {
                rectF.left = b;
            }
            if (rectF.top < max) {
                rectF.top = max;
            }
            if (rectF.right > min) {
                rectF.right = min;
            }
            if (rectF.bottom > min2) {
                rectF.bottom = min2;
            }
        }
        if (this.f19348u && ((double) Math.abs(rectF.width() - (rectF.height() * this.f19351x))) > 0.1d) {
            if (rectF.width() > rectF.height() * this.f19351x) {
                b = Math.abs((rectF.height() * this.f19351x) - rectF.width()) / 2.0f;
                rectF.left += b;
                rectF.right -= b;
                return;
            }
            b = Math.abs((rectF.width() / this.f19351x) - rectF.height()) / 2.0f;
            rectF.top += b;
            rectF.bottom -= b;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m24572a(canvas);
        if (this.f19330c.m24671h()) {
            if (this.f19352y == C5821c.ON) {
                m24575b(canvas);
            } else if (this.f19352y == C5821c.ON_TOUCH && this.f19347t != null) {
                m24575b(canvas);
            }
        }
        m24578c(canvas);
        m24580d(canvas);
    }

    /* renamed from: a */
    private void m24572a(Canvas canvas) {
        RectF a = this.f19330c.m24660a();
        float max = Math.max(C5838c.m24594a(this.f19338k), 0.0f);
        float max2 = Math.max(C5838c.m24617b(this.f19338k), 0.0f);
        float min = Math.min(C5838c.m24618c(this.f19338k), (float) getWidth());
        float min2 = Math.min(C5838c.m24619d(this.f19338k), (float) getHeight());
        if (this.f19353z == C5820b.RECTANGLE) {
            if (m24582f()) {
                if (VERSION.SDK_INT > 17) {
                    this.f19337j.reset();
                    this.f19337j.moveTo(this.f19338k[0], this.f19338k[1]);
                    this.f19337j.lineTo(this.f19338k[2], this.f19338k[3]);
                    this.f19337j.lineTo(this.f19338k[4], this.f19338k[5]);
                    this.f19337j.lineTo(this.f19338k[6], this.f19338k[7]);
                    this.f19337j.close();
                    canvas.save();
                    canvas.clipPath(this.f19337j, Op.INTERSECT);
                    canvas.clipRect(a, Op.XOR);
                    canvas.drawRect(max, max2, min, min2, this.f19336i);
                    canvas.restore();
                    return;
                }
            }
            Canvas canvas2 = canvas;
            float f = max;
            float f2 = min;
            canvas2.drawRect(f, max2, f2, a.top, this.f19336i);
            canvas2.drawRect(f, a.bottom, f2, min2, this.f19336i);
            canvas2.drawRect(f, a.top, a.left, a.bottom, this.f19336i);
            canvas.drawRect(a.right, a.top, min, a.bottom, this.f19336i);
            return;
        }
        this.f19337j.reset();
        if (VERSION.SDK_INT > 17 || this.f19353z != C5820b.OVAL) {
            this.f19332e.set(a.left, a.top, a.right, a.bottom);
        } else {
            this.f19332e.set(a.left + 2.0f, a.top + 2.0f, a.right - 2.0f, a.bottom - 2.0f);
        }
        this.f19337j.addOval(this.f19332e, Direction.CW);
        canvas.save();
        canvas.clipPath(this.f19337j, Op.XOR);
        canvas.drawRect(max, max2, min, min2, this.f19336i);
        canvas.restore();
    }

    /* renamed from: b */
    private void m24575b(Canvas canvas) {
        if (this.f19335h != null) {
            float strokeWidth = r0.f19333f != null ? r0.f19333f.getStrokeWidth() : 0.0f;
            RectF a = r0.f19330c.m24660a();
            a.inset(strokeWidth, strokeWidth);
            float width = a.width() / 3.0f;
            float height = a.height() / 3.0f;
            float f;
            if (r0.f19353z == C5820b.OVAL) {
                float width2 = (a.width() / 2.0f) - strokeWidth;
                float height2 = (a.height() / 2.0f) - strokeWidth;
                float f2 = a.left + width;
                f = a.right - width;
                strokeWidth = (float) (((double) height2) * Math.sin(Math.acos((double) ((width2 - width) / width2))));
                canvas.drawLine(f2, (a.top + height2) - strokeWidth, f2, (a.bottom - height2) + strokeWidth, r0.f19335h);
                canvas.drawLine(f, (a.top + height2) - strokeWidth, f, (a.bottom - height2) + strokeWidth, r0.f19335h);
                float f3 = a.top + height;
                float f4 = a.bottom - height;
                strokeWidth = (float) (((double) width2) * Math.cos(Math.asin((double) ((height2 - height) / height2))));
                canvas.drawLine((a.left + width2) - strokeWidth, f3, (a.right - width2) + strokeWidth, f3, r0.f19335h);
                canvas.drawLine((a.left + width2) - strokeWidth, f4, (a.right - width2) + strokeWidth, f4, r0.f19335h);
                return;
            }
            float f5 = a.left + width;
            float f6 = a.right - width;
            Canvas canvas2 = canvas;
            canvas2.drawLine(f5, a.top, f5, a.bottom, r0.f19335h);
            canvas.drawLine(f6, a.top, f6, a.bottom, r0.f19335h);
            float f7 = a.top + height;
            f = a.bottom - height;
            canvas2.drawLine(a.left, f7, a.right, f7, r0.f19335h);
            canvas.drawLine(a.left, f, a.right, f, r0.f19335h);
        }
    }

    /* renamed from: c */
    private void m24578c(Canvas canvas) {
        if (this.f19333f != null) {
            float strokeWidth = this.f19333f.getStrokeWidth();
            RectF a = this.f19330c.m24660a();
            strokeWidth /= 2.0f;
            a.inset(strokeWidth, strokeWidth);
            if (this.f19353z == C5820b.RECTANGLE) {
                canvas.drawRect(a, this.f19333f);
            } else {
                canvas.drawOval(a, this.f19333f);
            }
        }
    }

    /* renamed from: d */
    private void m24580d(Canvas canvas) {
        if (this.f19334g != null) {
            float f = 0.0f;
            float strokeWidth = this.f19333f != null ? this.f19333f.getStrokeWidth() : 0.0f;
            float strokeWidth2 = this.f19334g.getStrokeWidth();
            float f2 = strokeWidth2 / 2.0f;
            if (this.f19353z == C5820b.RECTANGLE) {
                f = this.f19342o;
            }
            f += f2;
            RectF a = this.f19330c.m24660a();
            a.inset(f, f);
            strokeWidth2 = (strokeWidth2 - strokeWidth) / 2.0f;
            f2 += strokeWidth2;
            Canvas canvas2 = canvas;
            canvas2.drawLine(a.left - strokeWidth2, a.top - f2, a.left - strokeWidth2, a.top + this.f19343p, this.f19334g);
            canvas2.drawLine(a.left - f2, a.top - strokeWidth2, a.left + this.f19343p, a.top - strokeWidth2, this.f19334g);
            canvas2.drawLine(a.right + strokeWidth2, a.top - f2, a.right + strokeWidth2, a.top + this.f19343p, this.f19334g);
            canvas2.drawLine(a.right + f2, a.top - strokeWidth2, a.right - this.f19343p, a.top - strokeWidth2, this.f19334g);
            canvas2.drawLine(a.left - strokeWidth2, a.bottom + f2, a.left - strokeWidth2, a.bottom - this.f19343p, this.f19334g);
            canvas2.drawLine(a.left - f2, a.bottom + strokeWidth2, a.left + this.f19343p, a.bottom + strokeWidth2, this.f19334g);
            canvas2.drawLine(a.right + strokeWidth2, a.bottom + f2, a.right + strokeWidth2, a.bottom - this.f19343p, this.f19334g);
            canvas2.drawLine(a.right + f2, a.bottom + strokeWidth2, a.right - this.f19343p, a.bottom + strokeWidth2, this.f19334g);
        }
    }

    /* renamed from: a */
    private static Paint m24569a(int i) {
        Paint paint = new Paint();
        paint.setColor(i);
        return paint;
    }

    /* renamed from: a */
    private static Paint m24568a(float f, int i) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        Paint paint = new Paint();
        paint.setColor(i);
        paint.setStrokeWidth(f);
        paint.setStyle(Style.STROKE);
        paint.setAntiAlias(Float.MIN_VALUE);
        return paint;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        if (this.f19329b) {
            this.f19328a.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                m24571a(motionEvent.getX(), motionEvent.getY());
                return true;
            case 1:
            case 3:
                getParent().requestDisallowInterceptTouchEvent(false);
                m24581e();
                return true;
            case 2:
                m24574b(motionEvent.getX(), motionEvent.getY());
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    private void m24571a(float f, float f2) {
        this.f19347t = this.f19330c.m24661a(f, f2, this.f19345r, this.f19353z);
        if (this.f19347t != null) {
            invalidate();
        }
    }

    /* renamed from: e */
    private void m24581e() {
        if (this.f19347t != null) {
            this.f19347t = null;
            m24576b(false);
            invalidate();
        }
    }

    /* renamed from: b */
    private void m24574b(float f, float f2) {
        if (this.f19347t != null) {
            float f3 = this.f19346s;
            RectF a = this.f19330c.m24660a();
            this.f19347t.m24688a(a, f, f2, this.f19339l, this.f19340m, this.f19341n, m24577b(a) ? 0.0f : f3, this.f19348u, this.f19351x);
            this.f19330c.m24663a(a);
            m24576b((boolean) Float.MIN_VALUE);
            invalidate();
        }
    }

    /* renamed from: b */
    private boolean m24577b(RectF rectF) {
        RectF rectF2 = rectF;
        float a = C5838c.m24594a(this.f19338k);
        float b = C5838c.m24617b(this.f19338k);
        float c = C5838c.m24618c(this.f19338k);
        float d = C5838c.m24619d(this.f19338k);
        if (m24582f()) {
            float f = r0.f19338k[0];
            float f2 = r0.f19338k[1];
            float f3 = r0.f19338k[4];
            float f4 = r0.f19338k[5];
            float f5 = r0.f19338k[6];
            float f6 = r0.f19338k[7];
            if (r0.f19338k[7] < r0.f19338k[1]) {
                if (r0.f19338k[1] < r0.f19338k[3]) {
                    f = r0.f19338k[6];
                    f2 = r0.f19338k[7];
                    f3 = r0.f19338k[2];
                    f4 = r0.f19338k[3];
                    f5 = r0.f19338k[4];
                    f6 = r0.f19338k[5];
                } else {
                    f = r0.f19338k[4];
                    f2 = r0.f19338k[5];
                    f3 = r0.f19338k[0];
                    f4 = r0.f19338k[1];
                    f5 = r0.f19338k[2];
                    f6 = r0.f19338k[3];
                }
            } else if (r0.f19338k[1] > r0.f19338k[3]) {
                f = r0.f19338k[2];
                f2 = r0.f19338k[3];
                f3 = r0.f19338k[6];
                f4 = r0.f19338k[7];
                f5 = r0.f19338k[0];
                f6 = r0.f19338k[1];
            }
            f6 = (f6 - f2) / (f5 - f);
            float f7 = -1.0f / f6;
            float f8 = f2 - (f6 * f);
            f2 -= f * f7;
            f = f4 - (f6 * f3);
            f4 -= f3 * f7;
            f3 = (rectF.centerY() - rectF2.top) / (rectF.centerX() - rectF2.left);
            f5 = -f3;
            float f9 = rectF2.top - (rectF2.left * f3);
            float f10 = rectF2.top - (rectF2.right * f5);
            float f11 = f6 - f3;
            float f12 = (f9 - f8) / f11;
            float f13 = d;
            if (f12 >= rectF2.right) {
                f12 = a;
            }
            f12 = Math.max(a, f12);
            a = (f9 - f2) / (f7 - f3);
            if (a >= rectF2.right) {
                a = f12;
            }
            f12 = Math.max(f12, a);
            d = f7 - f5;
            a = (f10 - f4) / d;
            if (a >= rectF2.right) {
                a = f12;
            }
            f12 = Math.max(f12, a);
            a = (f10 - f2) / d;
            if (a <= rectF2.left) {
                a = c;
            }
            a = Math.min(c, a);
            c = (f10 - f) / (f6 - f5);
            if (c <= rectF2.left) {
                c = a;
            }
            a = Math.min(a, c);
            c = (f9 - f) / f11;
            if (c <= rectF2.left) {
                c = a;
            }
            float min = Math.min(a, c);
            a = Math.max(b, Math.max((f6 * f12) + f8, (f7 * min) + f2));
            b = Math.min(f13, Math.min((f7 * f12) + f4, (f6 * min) + f));
            this.f19339l.left = f12;
            this.f19339l.top = a;
            this.f19339l.right = min;
            this.f19339l.bottom = b;
            return true;
        }
        r0.f19339l.set(a, b, c, d);
        return false;
    }

    /* renamed from: f */
    private boolean m24582f() {
        return (this.f19338k[0] == this.f19338k[6] || this.f19338k[1] == this.f19338k[7]) ? false : true;
    }

    /* renamed from: b */
    private void m24576b(boolean z) {
        try {
            if (this.f19331d != null) {
                this.f19331d.mo5081a(z);
            }
        } catch (boolean z2) {
            Log.e("AIC", "Exception in crop window changed", z2);
        }
    }
}
