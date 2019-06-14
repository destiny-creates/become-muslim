package android.support.p016d.p017a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.support.v4.content.p027b.C0364b;
import android.support.v4.content.p027b.C0365c;
import android.support.v4.p020a.C0267b;
import android.support.v4.p020a.C0267b.C0266b;
import android.support.v4.p020a.p021a.C0259a;
import android.support.v4.util.C3211a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.facebook.imageutils.JfifUtil;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: VectorDrawableCompat */
/* renamed from: android.support.d.a.i */
public class C4441i extends C3115h {
    /* renamed from: a */
    static final Mode f11827a = Mode.SRC_IN;
    /* renamed from: c */
    private C0128f f11828c;
    /* renamed from: d */
    private PorterDuffColorFilter f11829d;
    /* renamed from: e */
    private ColorFilter f11830e;
    /* renamed from: f */
    private boolean f11831f;
    /* renamed from: g */
    private boolean f11832g;
    /* renamed from: h */
    private ConstantState f11833h;
    /* renamed from: i */
    private final float[] f11834i;
    /* renamed from: j */
    private final Matrix f11835j;
    /* renamed from: k */
    private final Rect f11836k;

    /* compiled from: VectorDrawableCompat */
    /* renamed from: android.support.d.a.i$c */
    private static class C0125c {
        /* renamed from: a */
        final ArrayList<Object> f269a = new ArrayList();
        /* renamed from: b */
        float f270b = 0.0f;
        /* renamed from: c */
        int f271c;
        /* renamed from: d */
        private final Matrix f272d = new Matrix();
        /* renamed from: e */
        private float f273e = 0.0f;
        /* renamed from: f */
        private float f274f = 0.0f;
        /* renamed from: g */
        private float f275g = 1.0f;
        /* renamed from: h */
        private float f276h = 1.0f;
        /* renamed from: i */
        private float f277i = 0.0f;
        /* renamed from: j */
        private float f278j = 0.0f;
        /* renamed from: k */
        private final Matrix f279k = new Matrix();
        /* renamed from: l */
        private int[] f280l;
        /* renamed from: m */
        private String f281m = null;

        public C0125c(C0125c c0125c, C3211a<String, Object> c3211a) {
            this.f270b = c0125c.f270b;
            this.f273e = c0125c.f273e;
            this.f274f = c0125c.f274f;
            this.f275g = c0125c.f275g;
            this.f276h = c0125c.f276h;
            this.f277i = c0125c.f277i;
            this.f278j = c0125c.f278j;
            this.f280l = c0125c.f280l;
            this.f281m = c0125c.f281m;
            this.f271c = c0125c.f271c;
            if (this.f281m != null) {
                c3211a.put(this.f281m, this);
            }
            this.f279k.set(c0125c.f279k);
            c0125c = c0125c.f269a;
            for (int i = 0; i < c0125c.size(); i++) {
                Object obj = c0125c.get(i);
                if (obj instanceof C0125c) {
                    this.f269a.add(new C0125c((C0125c) obj, c3211a));
                } else {
                    C0126d c3117b;
                    if (obj instanceof C3117b) {
                        c3117b = new C3117b((C3117b) obj);
                    } else if (obj instanceof C3116a) {
                        c3117b = new C3116a((C3116a) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f269a.add(c3117b);
                    if (c3117b.f283n != null) {
                        c3211a.put(c3117b.f283n, c3117b);
                    }
                }
            }
        }

        public String getGroupName() {
            return this.f281m;
        }

        public Matrix getLocalMatrix() {
            return this.f279k;
        }

        /* renamed from: a */
        public void m268a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            resources = C0365c.m1096a(resources, theme, attributeSet, C0114a.f247b);
            m266a(resources, xmlPullParser);
            resources.recycle();
        }

        /* renamed from: a */
        private void m266a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f280l = null;
            this.f270b = C0365c.m1094a(typedArray, xmlPullParser, "rotation", 5, this.f270b);
            this.f273e = typedArray.getFloat(1, this.f273e);
            this.f274f = typedArray.getFloat(2, this.f274f);
            this.f275g = C0365c.m1094a(typedArray, xmlPullParser, "scaleX", 3, this.f275g);
            this.f276h = C0365c.m1094a(typedArray, xmlPullParser, "scaleY", 4, this.f276h);
            this.f277i = C0365c.m1094a(typedArray, xmlPullParser, "translateX", 6, this.f277i);
            this.f278j = C0365c.m1094a(typedArray, xmlPullParser, "translateY", 7, this.f278j);
            typedArray = typedArray.getString(null);
            if (typedArray != null) {
                this.f281m = typedArray;
            }
            m265a();
        }

        /* renamed from: a */
        private void m265a() {
            this.f279k.reset();
            this.f279k.postTranslate(-this.f273e, -this.f274f);
            this.f279k.postScale(this.f275g, this.f276h);
            this.f279k.postRotate(this.f270b, 0.0f, 0.0f);
            this.f279k.postTranslate(this.f277i + this.f273e, this.f278j + this.f274f);
        }

        public float getRotation() {
            return this.f270b;
        }

        public void setRotation(float f) {
            if (f != this.f270b) {
                this.f270b = f;
                m265a();
            }
        }

        public float getPivotX() {
            return this.f273e;
        }

        public void setPivotX(float f) {
            if (f != this.f273e) {
                this.f273e = f;
                m265a();
            }
        }

        public float getPivotY() {
            return this.f274f;
        }

        public void setPivotY(float f) {
            if (f != this.f274f) {
                this.f274f = f;
                m265a();
            }
        }

        public float getScaleX() {
            return this.f275g;
        }

        public void setScaleX(float f) {
            if (f != this.f275g) {
                this.f275g = f;
                m265a();
            }
        }

        public float getScaleY() {
            return this.f276h;
        }

        public void setScaleY(float f) {
            if (f != this.f276h) {
                this.f276h = f;
                m265a();
            }
        }

        public float getTranslateX() {
            return this.f277i;
        }

        public void setTranslateX(float f) {
            if (f != this.f277i) {
                this.f277i = f;
                m265a();
            }
        }

        public float getTranslateY() {
            return this.f278j;
        }

        public void setTranslateY(float f) {
            if (f != this.f278j) {
                this.f278j = f;
                m265a();
            }
        }
    }

    /* compiled from: VectorDrawableCompat */
    /* renamed from: android.support.d.a.i$d */
    private static class C0126d {
        /* renamed from: m */
        protected C0266b[] f282m = null;
        /* renamed from: n */
        String f283n;
        /* renamed from: o */
        int f284o;

        /* renamed from: a */
        public boolean mo40a() {
            return false;
        }

        public C0126d(C0126d c0126d) {
            this.f283n = c0126d.f283n;
            this.f284o = c0126d.f284o;
            this.f282m = C0267b.m730a(c0126d.f282m);
        }

        /* renamed from: a */
        public void m269a(Path path) {
            path.reset();
            if (this.f282m != null) {
                C0266b.m722a(this.f282m, path);
            }
        }

        public String getPathName() {
            return this.f283n;
        }

        public C0266b[] getPathData() {
            return this.f282m;
        }

        public void setPathData(C0266b[] c0266bArr) {
            if (C0267b.m728a(this.f282m, c0266bArr)) {
                C0267b.m731b(this.f282m, c0266bArr);
            } else {
                this.f282m = C0267b.m730a(c0266bArr);
            }
        }
    }

    /* compiled from: VectorDrawableCompat */
    /* renamed from: android.support.d.a.i$e */
    private static class C0127e {
        /* renamed from: k */
        private static final Matrix f285k = new Matrix();
        /* renamed from: a */
        final C0125c f286a;
        /* renamed from: b */
        float f287b;
        /* renamed from: c */
        float f288c;
        /* renamed from: d */
        float f289d;
        /* renamed from: e */
        float f290e;
        /* renamed from: f */
        int f291f;
        /* renamed from: g */
        String f292g;
        /* renamed from: h */
        final C3211a<String, Object> f293h;
        /* renamed from: i */
        private final Path f294i;
        /* renamed from: j */
        private final Path f295j;
        /* renamed from: l */
        private final Matrix f296l;
        /* renamed from: m */
        private Paint f297m;
        /* renamed from: n */
        private Paint f298n;
        /* renamed from: o */
        private PathMeasure f299o;
        /* renamed from: p */
        private int f300p;

        /* renamed from: a */
        private static float m271a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        public C0127e() {
            this.f296l = new Matrix();
            this.f287b = 0.0f;
            this.f288c = 0.0f;
            this.f289d = 0.0f;
            this.f290e = 0.0f;
            this.f291f = JfifUtil.MARKER_FIRST_BYTE;
            this.f292g = null;
            this.f293h = new C3211a();
            this.f286a = new C0125c();
            this.f294i = new Path();
            this.f295j = new Path();
        }

        public void setRootAlpha(int i) {
            this.f291f = i;
        }

        public int getRootAlpha() {
            return this.f291f;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public C0127e(C0127e c0127e) {
            this.f296l = new Matrix();
            this.f287b = 0.0f;
            this.f288c = 0.0f;
            this.f289d = 0.0f;
            this.f290e = 0.0f;
            this.f291f = JfifUtil.MARKER_FIRST_BYTE;
            this.f292g = null;
            this.f293h = new C3211a();
            this.f286a = new C0125c(c0127e.f286a, this.f293h);
            this.f294i = new Path(c0127e.f294i);
            this.f295j = new Path(c0127e.f295j);
            this.f287b = c0127e.f287b;
            this.f288c = c0127e.f288c;
            this.f289d = c0127e.f289d;
            this.f290e = c0127e.f290e;
            this.f300p = c0127e.f300p;
            this.f291f = c0127e.f291f;
            this.f292g = c0127e.f292g;
            if (c0127e.f292g != null) {
                this.f293h.put(c0127e.f292g, this);
            }
        }

        /* renamed from: a */
        private void m275a(C0125c c0125c, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            c0125c.f272d.set(matrix);
            c0125c.f272d.preConcat(c0125c.f279k);
            canvas.save();
            for (matrix = null; matrix < c0125c.f269a.size(); matrix++) {
                Object obj = c0125c.f269a.get(matrix);
                if (obj instanceof C0125c) {
                    m275a((C0125c) obj, c0125c.f272d, canvas, i, i2, colorFilter);
                } else if (obj instanceof C0126d) {
                    m276a(c0125c, (C0126d) obj, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        /* renamed from: a */
        public void m279a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            m275a(this.f286a, f285k, canvas, i, i2, colorFilter);
        }

        /* renamed from: a */
        private void m276a(C0125c c0125c, C0126d c0126d, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            i = ((float) i) / this.f289d;
            i2 = ((float) i2) / this.f290e;
            float min = Math.min(i, i2);
            Matrix a = c0125c.f272d;
            this.f296l.set(a);
            this.f296l.postScale(i, i2);
            c0125c = m272a(a);
            if (c0125c != null) {
                c0126d.m269a(this.f294i);
                i2 = this.f294i;
                this.f295j.reset();
                if (c0126d.mo40a()) {
                    this.f295j.addPath(i2, this.f296l);
                    canvas.clipPath(this.f295j);
                } else {
                    C3117b c3117b = (C3117b) c0126d;
                    if (!(c3117b.f7949g == 0.0f && c3117b.f7950h == 1.0f)) {
                        float f = (c3117b.f7949g + c3117b.f7951i) % 1.0f;
                        float f2 = (c3117b.f7950h + c3117b.f7951i) % 1.0f;
                        if (this.f299o == null) {
                            this.f299o = new PathMeasure();
                        }
                        this.f299o.setPath(this.f294i, false);
                        float length = this.f299o.getLength();
                        f *= length;
                        f2 *= length;
                        i2.reset();
                        if (f > f2) {
                            this.f299o.getSegment(f, length, i2, true);
                            this.f299o.getSegment(0.0f, f2, i2, true);
                        } else {
                            this.f299o.getSegment(f, f2, i2, true);
                        }
                        i2.rLineTo(0.0f, 0.0f);
                    }
                    this.f295j.addPath(i2, this.f296l);
                    if (c3117b.f7945c != 0) {
                        if (this.f298n == 0) {
                            this.f298n = new Paint();
                            this.f298n.setStyle(Style.FILL);
                            this.f298n.setAntiAlias(true);
                        }
                        i = this.f298n;
                        i.setColor(C4441i.m14753a(c3117b.f7945c, c3117b.f7948f));
                        i.setColorFilter(colorFilter);
                        this.f295j.setFillType(c3117b.f7947e == 0 ? FillType.WINDING : FillType.EVEN_ODD);
                        canvas.drawPath(this.f295j, i);
                    }
                    if (c3117b.f7943a != 0) {
                        if (this.f297m == 0) {
                            this.f297m = new Paint();
                            this.f297m.setStyle(Style.STROKE);
                            this.f297m.setAntiAlias(true);
                        }
                        i = this.f297m;
                        if (c3117b.f7953k != 0) {
                            i.setStrokeJoin(c3117b.f7953k);
                        }
                        if (c3117b.f7952j != 0) {
                            i.setStrokeCap(c3117b.f7952j);
                        }
                        i.setStrokeMiter(c3117b.f7954l);
                        i.setColor(C4441i.m14753a(c3117b.f7943a, c3117b.f7946d));
                        i.setColorFilter(colorFilter);
                        i.setStrokeWidth(c3117b.f7944b * (min * c0125c));
                        canvas.drawPath(this.f295j, i);
                    }
                }
            }
        }

        /* renamed from: a */
        private float m272a(Matrix matrix) {
            float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
            float hypot2 = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
            matrix = C0127e.m271a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max(hypot, hypot2);
            if (max > 0.0f) {
                return Math.abs(matrix) / max;
            }
            return 0.0f;
        }
    }

    /* compiled from: VectorDrawableCompat */
    /* renamed from: android.support.d.a.i$f */
    private static class C0128f extends ConstantState {
        /* renamed from: a */
        int f301a;
        /* renamed from: b */
        C0127e f302b;
        /* renamed from: c */
        ColorStateList f303c;
        /* renamed from: d */
        Mode f304d;
        /* renamed from: e */
        boolean f305e;
        /* renamed from: f */
        Bitmap f306f;
        /* renamed from: g */
        ColorStateList f307g;
        /* renamed from: h */
        Mode f308h;
        /* renamed from: i */
        int f309i;
        /* renamed from: j */
        boolean f310j;
        /* renamed from: k */
        boolean f311k;
        /* renamed from: l */
        Paint f312l;

        public C0128f(C0128f c0128f) {
            this.f303c = null;
            this.f304d = C4441i.f11827a;
            if (c0128f != null) {
                this.f301a = c0128f.f301a;
                this.f302b = new C0127e(c0128f.f302b);
                if (c0128f.f302b.f298n != null) {
                    this.f302b.f298n = new Paint(c0128f.f302b.f298n);
                }
                if (c0128f.f302b.f297m != null) {
                    this.f302b.f297m = new Paint(c0128f.f302b.f297m);
                }
                this.f303c = c0128f.f303c;
                this.f304d = c0128f.f304d;
                this.f305e = c0128f.f305e;
            }
        }

        /* renamed from: a */
        public void m282a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f306f, null, rect, m280a(colorFilter));
        }

        /* renamed from: a */
        public boolean m283a() {
            return this.f302b.getRootAlpha() < JfifUtil.MARKER_FIRST_BYTE;
        }

        /* renamed from: a */
        public Paint m280a(ColorFilter colorFilter) {
            if (!m283a() && colorFilter == null) {
                return null;
            }
            if (this.f312l == null) {
                this.f312l = new Paint();
                this.f312l.setFilterBitmap(true);
            }
            this.f312l.setAlpha(this.f302b.getRootAlpha());
            this.f312l.setColorFilter(colorFilter);
            return this.f312l;
        }

        /* renamed from: a */
        public void m281a(int i, int i2) {
            this.f306f.eraseColor(0);
            this.f302b.m279a(new Canvas(this.f306f), i, i2, null);
        }

        /* renamed from: b */
        public void m284b(int i, int i2) {
            if (this.f306f == null || !m287c(i, i2)) {
                this.f306f = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                this.f311k = true;
            }
        }

        /* renamed from: c */
        public boolean m287c(int i, int i2) {
            return i == this.f306f.getWidth() && i2 == this.f306f.getHeight();
        }

        /* renamed from: b */
        public boolean m285b() {
            return !this.f311k && this.f307g == this.f303c && this.f308h == this.f304d && this.f310j == this.f305e && this.f309i == this.f302b.getRootAlpha();
        }

        /* renamed from: c */
        public void m286c() {
            this.f307g = this.f303c;
            this.f308h = this.f304d;
            this.f309i = this.f302b.getRootAlpha();
            this.f310j = this.f305e;
            this.f311k = false;
        }

        public C0128f() {
            this.f303c = null;
            this.f304d = C4441i.f11827a;
            this.f302b = new C0127e();
        }

        public Drawable newDrawable() {
            return new C4441i(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new C4441i(this);
        }

        public int getChangingConfigurations() {
            return this.f301a;
        }
    }

    /* compiled from: VectorDrawableCompat */
    /* renamed from: android.support.d.a.i$g */
    private static class C0129g extends ConstantState {
        /* renamed from: a */
        private final ConstantState f313a;

        public C0129g(ConstantState constantState) {
            this.f313a = constantState;
        }

        public Drawable newDrawable() {
            Drawable c4441i = new C4441i();
            c4441i.b = (VectorDrawable) this.f313a.newDrawable();
            return c4441i;
        }

        public Drawable newDrawable(Resources resources) {
            Drawable c4441i = new C4441i();
            c4441i.b = (VectorDrawable) this.f313a.newDrawable(resources);
            return c4441i;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            Drawable c4441i = new C4441i();
            c4441i.b = (VectorDrawable) this.f313a.newDrawable(resources, theme);
            return c4441i;
        }

        public boolean canApplyTheme() {
            return this.f313a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f313a.getChangingConfigurations();
        }
    }

    /* compiled from: VectorDrawableCompat */
    /* renamed from: android.support.d.a.i$a */
    private static class C3116a extends C0126d {
        /* renamed from: a */
        public boolean mo40a() {
            return true;
        }

        public C3116a(C3116a c3116a) {
            super(c3116a);
        }

        /* renamed from: a */
        public void m9156a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            if (C0365c.m1099a(xmlPullParser, "pathData") != null) {
                resources = C0365c.m1096a(resources, theme, attributeSet, C0114a.f249d);
                m9155a(resources);
                resources.recycle();
            }
        }

        /* renamed from: a */
        private void m9155a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.n = string;
            }
            typedArray = typedArray.getString(1);
            if (typedArray != null) {
                this.m = C0267b.m732b(typedArray);
            }
        }
    }

    /* compiled from: VectorDrawableCompat */
    /* renamed from: android.support.d.a.i$b */
    private static class C3117b extends C0126d {
        /* renamed from: a */
        int f7943a = 0;
        /* renamed from: b */
        float f7944b = 0.0f;
        /* renamed from: c */
        int f7945c = 0;
        /* renamed from: d */
        float f7946d = 1.0f;
        /* renamed from: e */
        int f7947e = 0;
        /* renamed from: f */
        float f7948f = 1.0f;
        /* renamed from: g */
        float f7949g = 0.0f;
        /* renamed from: h */
        float f7950h = 1.0f;
        /* renamed from: i */
        float f7951i = 0.0f;
        /* renamed from: j */
        Cap f7952j = Cap.BUTT;
        /* renamed from: k */
        Join f7953k = Join.MITER;
        /* renamed from: l */
        float f7954l = 4.0f;
        /* renamed from: p */
        private int[] f7955p;

        public C3117b(C3117b c3117b) {
            super(c3117b);
            this.f7955p = c3117b.f7955p;
            this.f7943a = c3117b.f7943a;
            this.f7944b = c3117b.f7944b;
            this.f7946d = c3117b.f7946d;
            this.f7945c = c3117b.f7945c;
            this.f7947e = c3117b.f7947e;
            this.f7948f = c3117b.f7948f;
            this.f7949g = c3117b.f7949g;
            this.f7950h = c3117b.f7950h;
            this.f7951i = c3117b.f7951i;
            this.f7952j = c3117b.f7952j;
            this.f7953k = c3117b.f7953k;
            this.f7954l = c3117b.f7954l;
        }

        /* renamed from: a */
        private Cap m9158a(int i, Cap cap) {
            switch (i) {
                case 0:
                    return Cap.BUTT;
                case 1:
                    return Cap.ROUND;
                case 2:
                    return Cap.SQUARE;
                default:
                    return cap;
            }
        }

        /* renamed from: a */
        private Join m9159a(int i, Join join) {
            switch (i) {
                case 0:
                    return Join.MITER;
                case 1:
                    return Join.ROUND;
                case 2:
                    return Join.BEVEL;
                default:
                    return join;
            }
        }

        /* renamed from: a */
        public void m9161a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a = C0365c.m1096a(resources, theme, attributeSet, C0114a.f248c);
            m9160a(a, xmlPullParser);
            a.recycle();
        }

        /* renamed from: a */
        private void m9160a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f7955p = null;
            if (C0365c.m1099a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.n = string;
                }
                string = typedArray.getString(2);
                if (string != null) {
                    this.m = C0267b.m732b(string);
                }
                this.f7945c = C0365c.m1100b(typedArray, xmlPullParser, "fillColor", 1, this.f7945c);
                this.f7948f = C0365c.m1094a(typedArray, xmlPullParser, "fillAlpha", 12, this.f7948f);
                this.f7952j = m9158a(C0365c.m1095a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f7952j);
                this.f7953k = m9159a(C0365c.m1095a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f7953k);
                this.f7954l = C0365c.m1094a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f7954l);
                this.f7943a = C0365c.m1100b(typedArray, xmlPullParser, "strokeColor", 3, this.f7943a);
                this.f7946d = C0365c.m1094a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f7946d);
                this.f7944b = C0365c.m1094a(typedArray, xmlPullParser, "strokeWidth", 4, this.f7944b);
                this.f7950h = C0365c.m1094a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f7950h);
                this.f7951i = C0365c.m1094a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f7951i);
                this.f7949g = C0365c.m1094a(typedArray, xmlPullParser, "trimPathStart", 5, this.f7949g);
                this.f7947e = C0365c.m1095a(typedArray, xmlPullParser, "fillType", 13, this.f7947e);
            }
        }

        int getStrokeColor() {
            return this.f7943a;
        }

        void setStrokeColor(int i) {
            this.f7943a = i;
        }

        float getStrokeWidth() {
            return this.f7944b;
        }

        void setStrokeWidth(float f) {
            this.f7944b = f;
        }

        float getStrokeAlpha() {
            return this.f7946d;
        }

        void setStrokeAlpha(float f) {
            this.f7946d = f;
        }

        int getFillColor() {
            return this.f7945c;
        }

        void setFillColor(int i) {
            this.f7945c = i;
        }

        float getFillAlpha() {
            return this.f7948f;
        }

        void setFillAlpha(float f) {
            this.f7948f = f;
        }

        float getTrimPathStart() {
            return this.f7949g;
        }

        void setTrimPathStart(float f) {
            this.f7949g = f;
        }

        float getTrimPathEnd() {
            return this.f7950h;
        }

        void setTrimPathEnd(float f) {
            this.f7950h = f;
        }

        float getTrimPathOffset() {
            return this.f7951i;
        }

        void setTrimPathOffset(float f) {
            this.f7951i = f;
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    C4441i() {
        this.f11832g = true;
        this.f11834i = new float[9];
        this.f11835j = new Matrix();
        this.f11836k = new Rect();
        this.f11828c = new C0128f();
    }

    C4441i(C0128f c0128f) {
        this.f11832g = true;
        this.f11834i = new float[9];
        this.f11835j = new Matrix();
        this.f11836k = new Rect();
        this.f11828c = c0128f;
        this.f11829d = m14760a(this.f11829d, c0128f.f303c, c0128f.f304d);
    }

    public Drawable mutate() {
        if (this.b != null) {
            this.b.mutate();
            return this;
        }
        if (!this.f11831f && super.mutate() == this) {
            this.f11828c = new C0128f(this.f11828c);
            this.f11831f = true;
        }
        return this;
    }

    /* renamed from: a */
    Object m14761a(String str) {
        return this.f11828c.f302b.f293h.get(str);
    }

    public ConstantState getConstantState() {
        if (this.b != null && VERSION.SDK_INT >= 24) {
            return new C0129g(this.b.getConstantState());
        }
        this.f11828c.f301a = getChangingConfigurations();
        return this.f11828c;
    }

    public void draw(Canvas canvas) {
        if (this.b != null) {
            this.b.draw(canvas);
            return;
        }
        copyBounds(this.f11836k);
        if (this.f11836k.width() > 0) {
            if (this.f11836k.height() > 0) {
                ColorFilter colorFilter = this.f11830e == null ? this.f11829d : this.f11830e;
                canvas.getMatrix(this.f11835j);
                this.f11835j.getValues(this.f11834i);
                float abs = Math.abs(this.f11834i[0]);
                float abs2 = Math.abs(this.f11834i[4]);
                float abs3 = Math.abs(this.f11834i[1]);
                float abs4 = Math.abs(this.f11834i[3]);
                if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                    abs = 1.0f;
                    abs2 = 1.0f;
                }
                int height = (int) (((float) this.f11836k.height()) * abs2);
                int min = Math.min(2048, (int) (((float) this.f11836k.width()) * abs));
                height = Math.min(2048, height);
                if (min > 0) {
                    if (height > 0) {
                        int save = canvas.save();
                        canvas.translate((float) this.f11836k.left, (float) this.f11836k.top);
                        if (m14758a()) {
                            canvas.translate((float) this.f11836k.width(), 0.0f);
                            canvas.scale(-1.0f, 1.0f);
                        }
                        this.f11836k.offsetTo(0, 0);
                        this.f11828c.m284b(min, height);
                        if (!this.f11832g) {
                            this.f11828c.m281a(min, height);
                        } else if (!this.f11828c.m285b()) {
                            this.f11828c.m281a(min, height);
                            this.f11828c.m286c();
                        }
                        this.f11828c.m282a(canvas, colorFilter, this.f11836k);
                        canvas.restoreToCount(save);
                    }
                }
            }
        }
    }

    public int getAlpha() {
        if (this.b != null) {
            return C0259a.m699c(this.b);
        }
        return this.f11828c.f302b.getRootAlpha();
    }

    public void setAlpha(int i) {
        if (this.b != null) {
            this.b.setAlpha(i);
            return;
        }
        if (this.f11828c.f302b.getRootAlpha() != i) {
            this.f11828c.f302b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.b != null) {
            this.b.setColorFilter(colorFilter);
            return;
        }
        this.f11830e = colorFilter;
        invalidateSelf();
    }

    /* renamed from: a */
    PorterDuffColorFilter m14760a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, Mode mode) {
        if (colorStateList != null) {
            if (mode != null) {
                return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            }
        }
        return null;
    }

    public void setTint(int i) {
        if (this.b != null) {
            C0259a.m690a(this.b, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.b != null) {
            C0259a.m692a(this.b, colorStateList);
            return;
        }
        C0128f c0128f = this.f11828c;
        if (c0128f.f303c != colorStateList) {
            c0128f.f303c = colorStateList;
            this.f11829d = m14760a(this.f11829d, colorStateList, c0128f.f304d);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode mode) {
        if (this.b != null) {
            C0259a.m695a(this.b, mode);
            return;
        }
        C0128f c0128f = this.f11828c;
        if (c0128f.f304d != mode) {
            c0128f.f304d = mode;
            this.f11829d = m14760a(this.f11829d, c0128f.f303c, mode);
            invalidateSelf();
        }
    }

    public boolean isStateful() {
        if (this.b != null) {
            return this.b.isStateful();
        }
        boolean z;
        if (!super.isStateful()) {
            if (this.f11828c == null || this.f11828c.f303c == null || !this.f11828c.f303c.isStateful()) {
                z = false;
                return z;
            }
        }
        z = true;
        return z;
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.b != null) {
            return this.b.setState(iArr);
        }
        iArr = this.f11828c;
        if (iArr.f303c == null || iArr.f304d == null) {
            return null;
        }
        this.f11829d = m14760a(this.f11829d, iArr.f303c, iArr.f304d);
        invalidateSelf();
        return 1;
    }

    public int getOpacity() {
        return this.b != null ? this.b.getOpacity() : -3;
    }

    public int getIntrinsicWidth() {
        if (this.b != null) {
            return this.b.getIntrinsicWidth();
        }
        return (int) this.f11828c.f302b.f287b;
    }

    public int getIntrinsicHeight() {
        if (this.b != null) {
            return this.b.getIntrinsicHeight();
        }
        return (int) this.f11828c.f302b.f288c;
    }

    public boolean canApplyTheme() {
        if (this.b != null) {
            C0259a.m700d(this.b);
        }
        return false;
    }

    public boolean isAutoMirrored() {
        if (this.b != null) {
            return C0259a.m697b(this.b);
        }
        return this.f11828c.f305e;
    }

    public void setAutoMirrored(boolean z) {
        if (this.b != null) {
            C0259a.m696a(this.b, z);
        } else {
            this.f11828c.f305e = z;
        }
    }

    /* renamed from: a */
    public static C4441i m14755a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 24) {
            C4441i c4441i = new C4441i();
            c4441i.b = C0364b.m1093a(resources, i, theme);
            c4441i.f11833h = new C0129g(c4441i.b.getConstantState());
            return c4441i;
        }
        try {
            int next;
            i = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(i);
            while (true) {
                next = i.next();
                if (next == 2 || next == 1) {
                    if (next == 2) {
                        return C4441i.m14756a(resources, i, asAttributeSet, theme);
                    }
                    throw new XmlPullParserException("No start tag found");
                }
            }
            if (next == 2) {
                return C4441i.m14756a(resources, i, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (Resources resources2) {
            Log.e("VectorDrawableCompat", "parser error", resources2);
            return null;
        } catch (Resources resources22) {
            Log.e("VectorDrawableCompat", "parser error", resources22);
            return null;
        }
    }

    /* renamed from: a */
    public static C4441i m14756a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C4441i c4441i = new C4441i();
        c4441i.inflate(resources, xmlPullParser, attributeSet, theme);
        return c4441i;
    }

    /* renamed from: a */
    static int m14753a(int i, float f) {
        return (i & 16777215) | (((int) (((float) Color.alpha(i)) * f)) << 24);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.b != null) {
            this.b.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.b != null) {
            C0259a.m694a(this.b, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0128f c0128f = this.f11828c;
        c0128f.f302b = new C0127e();
        TypedArray a = C0365c.m1096a(resources, theme, attributeSet, C0114a.f246a);
        m14757a(a, xmlPullParser);
        a.recycle();
        c0128f.f301a = getChangingConfigurations();
        c0128f.f311k = true;
        m14759b(resources, xmlPullParser, attributeSet, theme);
        this.f11829d = m14760a(this.f11829d, c0128f.f303c, c0128f.f304d);
    }

    /* renamed from: a */
    private static Mode m14754a(int i, Mode mode) {
        if (i == 3) {
            return Mode.SRC_OVER;
        }
        if (i == 5) {
            return Mode.SRC_IN;
        }
        if (i == 9) {
            return Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                return Mode.ADD;
            default:
                return mode;
        }
    }

    /* renamed from: a */
    private void m14757a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        C0128f c0128f = this.f11828c;
        C0127e c0127e = c0128f.f302b;
        c0128f.f304d = C4441i.m14754a(C0365c.m1095a(typedArray, xmlPullParser, "tintMode", 6, -1), Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            c0128f.f303c = colorStateList;
        }
        c0128f.f305e = C0365c.m1098a(typedArray, xmlPullParser, "autoMirrored", 5, c0128f.f305e);
        c0127e.f289d = C0365c.m1094a(typedArray, xmlPullParser, "viewportWidth", 7, c0127e.f289d);
        c0127e.f290e = C0365c.m1094a(typedArray, xmlPullParser, "viewportHeight", 8, c0127e.f290e);
        StringBuilder stringBuilder;
        if (c0127e.f289d <= 0.0f) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(typedArray.getPositionDescription());
            stringBuilder.append("<vector> tag requires viewportWidth > 0");
            throw new XmlPullParserException(stringBuilder.toString());
        } else if (c0127e.f290e > 0.0f) {
            c0127e.f287b = typedArray.getDimension(3, c0127e.f287b);
            c0127e.f288c = typedArray.getDimension(2, c0127e.f288c);
            if (c0127e.f287b <= 0.0f) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(typedArray.getPositionDescription());
                stringBuilder.append("<vector> tag requires width > 0");
                throw new XmlPullParserException(stringBuilder.toString());
            } else if (c0127e.f288c > 0.0f) {
                c0127e.setAlpha(C0365c.m1094a(typedArray, xmlPullParser, "alpha", 4, c0127e.getAlpha()));
                typedArray = typedArray.getString(null);
                if (typedArray != null) {
                    c0127e.f292g = typedArray;
                    c0127e.f293h.put(typedArray, c0127e);
                }
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(typedArray.getPositionDescription());
                stringBuilder.append("<vector> tag requires height > 0");
                throw new XmlPullParserException(stringBuilder.toString());
            }
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(typedArray.getPositionDescription());
            stringBuilder.append("<vector> tag requires viewportHeight > 0");
            throw new XmlPullParserException(stringBuilder.toString());
        }
    }

    /* renamed from: b */
    private void m14759b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0128f c0128f = this.f11828c;
        C0127e c0127e = c0128f.f302b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(c0127e.f286a);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        Object obj = 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                C0125c c0125c = (C0125c) arrayDeque.peek();
                if ("path".equals(name)) {
                    C3117b c3117b = new C3117b();
                    c3117b.m9161a(resources, attributeSet, theme, xmlPullParser);
                    c0125c.f269a.add(c3117b);
                    if (c3117b.getPathName() != null) {
                        c0127e.f293h.put(c3117b.getPathName(), c3117b);
                    }
                    obj = null;
                    c0128f.f301a = c3117b.o | c0128f.f301a;
                } else if ("clip-path".equals(name)) {
                    C3116a c3116a = new C3116a();
                    c3116a.m9156a(resources, attributeSet, theme, xmlPullParser);
                    c0125c.f269a.add(c3116a);
                    if (c3116a.getPathName() != null) {
                        c0127e.f293h.put(c3116a.getPathName(), c3116a);
                    }
                    c0128f.f301a = c3116a.o | c0128f.f301a;
                } else if ("group".equals(name)) {
                    C0125c c0125c2 = new C0125c();
                    c0125c2.m268a(resources, attributeSet, theme, xmlPullParser);
                    c0125c.f269a.add(c0125c2);
                    arrayDeque.push(c0125c2);
                    if (c0125c2.getGroupName() != null) {
                        c0127e.f293h.put(c0125c2.getGroupName(), c0125c2);
                    }
                    c0128f.f301a = c0125c2.f271c | c0128f.f301a;
                }
            } else if (eventType == 3) {
                if ("group".equals(xmlPullParser.getName())) {
                    arrayDeque.pop();
                }
            }
            eventType = xmlPullParser.next();
        }
        if (obj != null) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* renamed from: a */
    void m14762a(boolean z) {
        this.f11832g = z;
    }

    /* renamed from: a */
    private boolean m14758a() {
        boolean z = false;
        if (VERSION.SDK_INT < 17) {
            return false;
        }
        if (isAutoMirrored() && C0259a.m705i(this) == 1) {
            z = true;
        }
        return z;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.b != null) {
            this.b.setBounds(rect);
        }
    }

    public int getChangingConfigurations() {
        if (this.b != null) {
            return this.b.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f11828c.getChangingConfigurations();
    }

    public void invalidateSelf() {
        if (this.b != null) {
            this.b.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public void scheduleSelf(Runnable runnable, long j) {
        if (this.b != null) {
            this.b.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.b != null) {
            return this.b.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.b != null) {
            this.b.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
