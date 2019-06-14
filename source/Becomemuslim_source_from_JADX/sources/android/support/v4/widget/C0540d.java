package android.support.v4.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.C0462k;
import android.support.v4.view.p034b.C3220b;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.facebook.imageutils.JfifUtil;

/* compiled from: CircularProgressDrawable */
/* renamed from: android.support.v4.widget.d */
public class C0540d extends Drawable implements Animatable {
    /* renamed from: a */
    private static final Interpolator f1370a = new LinearInterpolator();
    /* renamed from: b */
    private static final Interpolator f1371b = new C3220b();
    /* renamed from: c */
    private static final int[] f1372c = new int[]{-16777216};
    /* renamed from: d */
    private final C0539a f1373d = new C0539a();
    /* renamed from: e */
    private float f1374e;
    /* renamed from: f */
    private Resources f1375f;
    /* renamed from: g */
    private Animator f1376g;
    /* renamed from: h */
    private float f1377h;
    /* renamed from: i */
    private boolean f1378i;

    /* compiled from: CircularProgressDrawable */
    /* renamed from: android.support.v4.widget.d$a */
    private static class C0539a {
        /* renamed from: a */
        final RectF f1349a = new RectF();
        /* renamed from: b */
        final Paint f1350b = new Paint();
        /* renamed from: c */
        final Paint f1351c = new Paint();
        /* renamed from: d */
        final Paint f1352d = new Paint();
        /* renamed from: e */
        float f1353e = 0.0f;
        /* renamed from: f */
        float f1354f = 0.0f;
        /* renamed from: g */
        float f1355g = 0.0f;
        /* renamed from: h */
        float f1356h = 5.0f;
        /* renamed from: i */
        int[] f1357i;
        /* renamed from: j */
        int f1358j;
        /* renamed from: k */
        float f1359k;
        /* renamed from: l */
        float f1360l;
        /* renamed from: m */
        float f1361m;
        /* renamed from: n */
        boolean f1362n;
        /* renamed from: o */
        Path f1363o;
        /* renamed from: p */
        float f1364p = 1.0f;
        /* renamed from: q */
        float f1365q;
        /* renamed from: r */
        int f1366r;
        /* renamed from: s */
        int f1367s;
        /* renamed from: t */
        int f1368t = JfifUtil.MARKER_FIRST_BYTE;
        /* renamed from: u */
        int f1369u;

        C0539a() {
            this.f1350b.setStrokeCap(Cap.SQUARE);
            this.f1350b.setAntiAlias(true);
            this.f1350b.setStyle(Style.STROKE);
            this.f1351c.setStyle(Style.FILL);
            this.f1351c.setAntiAlias(true);
            this.f1352d.setColor(0);
        }

        /* renamed from: a */
        void m1810a(float f, float f2) {
            this.f1366r = (int) f;
            this.f1367s = (int) f2;
        }

        /* renamed from: a */
        void m1813a(Canvas canvas, Rect rect) {
            RectF rectF = this.f1349a;
            float f = this.f1365q + (this.f1356h / 2.0f);
            if (this.f1365q <= 0.0f) {
                f = (((float) Math.min(rect.width(), rect.height())) / 2.0f) - Math.max((((float) this.f1366r) * this.f1364p) / 2.0f, this.f1356h / 2.0f);
            }
            rectF.set(((float) rect.centerX()) - f, ((float) rect.centerY()) - f, ((float) rect.centerX()) + f, ((float) rect.centerY()) + f);
            rect = (this.f1353e + this.f1355g) * 1135869952;
            float f2 = ((this.f1354f + this.f1355g) * 360.0f) - rect;
            this.f1350b.setColor(this.f1369u);
            this.f1350b.setAlpha(this.f1368t);
            f = this.f1356h / 2.0f;
            rectF.inset(f, f);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f1352d);
            f = -f;
            rectF.inset(f, f);
            canvas.drawArc(rectF, rect, f2, false, this.f1350b);
            m1812a(canvas, rect, f2, rectF);
        }

        /* renamed from: a */
        void m1812a(Canvas canvas, float f, float f2, RectF rectF) {
            if (this.f1362n) {
                if (this.f1363o == null) {
                    this.f1363o = new Path();
                    this.f1363o.setFillType(FillType.EVEN_ODD);
                } else {
                    this.f1363o.reset();
                }
                float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f3 = (((float) this.f1366r) * this.f1364p) / 2.0f;
                this.f1363o.moveTo(0.0f, 0.0f);
                this.f1363o.lineTo(((float) this.f1366r) * this.f1364p, 0.0f);
                this.f1363o.lineTo((((float) this.f1366r) * this.f1364p) / 2.0f, ((float) this.f1367s) * this.f1364p);
                this.f1363o.offset((min + rectF.centerX()) - f3, rectF.centerY() + (this.f1356h / 2.0f));
                this.f1363o.close();
                this.f1351c.setColor(this.f1369u);
                this.f1351c.setAlpha(this.f1368t);
                canvas.save();
                canvas.rotate(f + f2, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f1363o, this.f1351c);
                canvas.restore();
            }
        }

        /* renamed from: a */
        void m1816a(int[] iArr) {
            this.f1357i = iArr;
            m1819b((int) null);
        }

        /* renamed from: a */
        void m1811a(int i) {
            this.f1369u = i;
        }

        /* renamed from: b */
        void m1819b(int i) {
            this.f1358j = i;
            this.f1369u = this.f1357i[this.f1358j];
        }

        /* renamed from: a */
        int m1808a() {
            return this.f1357i[m1817b()];
        }

        /* renamed from: b */
        int m1817b() {
            return (this.f1358j + 1) % this.f1357i.length;
        }

        /* renamed from: c */
        void m1820c() {
            m1819b(m1817b());
        }

        /* renamed from: a */
        void m1814a(ColorFilter colorFilter) {
            this.f1350b.setColorFilter(colorFilter);
        }

        /* renamed from: c */
        void m1822c(int i) {
            this.f1368t = i;
        }

        /* renamed from: d */
        int m1823d() {
            return this.f1368t;
        }

        /* renamed from: a */
        void m1809a(float f) {
            this.f1356h = f;
            this.f1350b.setStrokeWidth(f);
        }

        /* renamed from: b */
        void m1818b(float f) {
            this.f1353e = f;
        }

        /* renamed from: e */
        float m1825e() {
            return this.f1353e;
        }

        /* renamed from: f */
        float m1827f() {
            return this.f1359k;
        }

        /* renamed from: g */
        float m1829g() {
            return this.f1360l;
        }

        /* renamed from: h */
        int m1830h() {
            return this.f1357i[this.f1358j];
        }

        /* renamed from: c */
        void m1821c(float f) {
            this.f1354f = f;
        }

        /* renamed from: i */
        float m1831i() {
            return this.f1354f;
        }

        /* renamed from: d */
        void m1824d(float f) {
            this.f1355g = f;
        }

        /* renamed from: e */
        void m1826e(float f) {
            this.f1365q = f;
        }

        /* renamed from: a */
        void m1815a(boolean z) {
            if (this.f1362n != z) {
                this.f1362n = z;
            }
        }

        /* renamed from: f */
        void m1828f(float f) {
            if (f != this.f1364p) {
                this.f1364p = f;
            }
        }

        /* renamed from: j */
        float m1832j() {
            return this.f1361m;
        }

        /* renamed from: k */
        void m1833k() {
            this.f1359k = this.f1353e;
            this.f1360l = this.f1354f;
            this.f1361m = this.f1355g;
        }

        /* renamed from: l */
        void m1834l() {
            this.f1359k = 0.0f;
            this.f1360l = 0.0f;
            this.f1361m = 0.0f;
            m1818b(0.0f);
            m1821c(0.0f);
            m1824d(0.0f);
        }
    }

    /* renamed from: a */
    private int m1836a(float f, int i, int i2) {
        int i3 = (i >> 24) & JfifUtil.MARKER_FIRST_BYTE;
        int i4 = (i >> 16) & JfifUtil.MARKER_FIRST_BYTE;
        int i5 = (i >> 8) & JfifUtil.MARKER_FIRST_BYTE;
        i &= JfifUtil.MARKER_FIRST_BYTE;
        return ((((i3 + ((int) (((float) (((i2 >> 24) & JfifUtil.MARKER_FIRST_BYTE) - i3)) * f))) << 24) | ((i4 + ((int) (((float) (((i2 >> 16) & JfifUtil.MARKER_FIRST_BYTE) - i4)) * f))) << 16)) | ((i5 + ((int) (((float) (((i2 >> 8) & JfifUtil.MARKER_FIRST_BYTE) - i5)) * f))) << 8)) | (i + ((int) (f * ((float) ((i2 & JfifUtil.MARKER_FIRST_BYTE) - i)))));
    }

    public int getOpacity() {
        return -3;
    }

    public C0540d(Context context) {
        this.f1375f = ((Context) C0462k.m1451a(context)).getResources();
        this.f1373d.m1816a(f1372c);
        m1848a(2.5f);
        m1837a();
    }

    /* renamed from: a */
    private void m1838a(float f, float f2, float f3, float f4) {
        C0539a c0539a = this.f1373d;
        float f5 = this.f1375f.getDisplayMetrics().density;
        c0539a.m1809a(f2 * f5);
        c0539a.m1826e(f * f5);
        c0539a.m1819b((int) 0.0f);
        c0539a.m1810a(f3 * f5, f4 * f5);
    }

    /* renamed from: a */
    public void m1850a(int i) {
        if (i == 0) {
            m1838a((float) 1093664768, 3.0f, 12.0f, 6.0f);
        } else {
            m1838a((float) 1089470464, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    /* renamed from: a */
    public void m1848a(float f) {
        this.f1373d.m1809a(f);
        invalidateSelf();
    }

    /* renamed from: a */
    public void m1851a(boolean z) {
        this.f1373d.m1815a(z);
        invalidateSelf();
    }

    /* renamed from: b */
    public void m1853b(float f) {
        this.f1373d.m1828f(f);
        invalidateSelf();
    }

    /* renamed from: a */
    public void m1849a(float f, float f2) {
        this.f1373d.m1818b(f);
        this.f1373d.m1821c(f2);
        invalidateSelf();
    }

    /* renamed from: c */
    public void m1854c(float f) {
        this.f1373d.m1824d(f);
        invalidateSelf();
    }

    /* renamed from: a */
    public void m1852a(int... iArr) {
        this.f1373d.m1816a(iArr);
        this.f1373d.m1819b(0);
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f1374e, bounds.exactCenterX(), bounds.exactCenterY());
        this.f1373d.m1813a(canvas, bounds);
        canvas.restore();
    }

    public void setAlpha(int i) {
        this.f1373d.m1822c(i);
        invalidateSelf();
    }

    public int getAlpha() {
        return this.f1373d.m1823d();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1373d.m1814a(colorFilter);
        invalidateSelf();
    }

    /* renamed from: d */
    private void m1847d(float f) {
        this.f1374e = f;
    }

    public boolean isRunning() {
        return this.f1376g.isRunning();
    }

    public void start() {
        this.f1376g.cancel();
        this.f1373d.m1833k();
        if (this.f1373d.m1831i() != this.f1373d.m1825e()) {
            this.f1378i = true;
            this.f1376g.setDuration(666);
            this.f1376g.start();
            return;
        }
        this.f1373d.m1819b(0);
        this.f1373d.m1834l();
        this.f1376g.setDuration(1332);
        this.f1376g.start();
    }

    public void stop() {
        this.f1376g.cancel();
        m1847d(0.0f);
        this.f1373d.m1815a(false);
        this.f1373d.m1819b(0);
        this.f1373d.m1834l();
        invalidateSelf();
    }

    /* renamed from: a */
    private void m1839a(float f, C0539a c0539a) {
        if (f > 0.75f) {
            c0539a.m1811a(m1836a((f - 0.75f) / 0.25f, c0539a.m1830h(), c0539a.m1808a()));
        } else {
            c0539a.m1811a(c0539a.m1830h());
        }
    }

    /* renamed from: b */
    private void m1846b(float f, C0539a c0539a) {
        m1839a(f, c0539a);
        float floor = (float) (Math.floor((double) (c0539a.m1832j() / 0.8f)) + 1.0d);
        c0539a.m1818b(c0539a.m1827f() + (((c0539a.m1829g() - 0.01f) - c0539a.m1827f()) * f));
        c0539a.m1821c(c0539a.m1829g());
        c0539a.m1824d(c0539a.m1832j() + ((floor - c0539a.m1832j()) * f));
    }

    /* renamed from: a */
    private void m1840a(float f, C0539a c0539a, boolean z) {
        if (this.f1378i) {
            m1846b(f, c0539a);
        } else if (f != 1.0f || z) {
            float f2;
            float f3;
            z = c0539a.m1832j();
            if (f < 0.5f) {
                f2 = f / 0.5f;
                f3 = c0539a.m1827f();
                float f4 = f3;
                f3 = ((f1371b.getInterpolation(f2) * 0.79f) + 0.01f) + f3;
                f2 = f4;
            } else {
                f3 = c0539a.m1827f() + 0.79f;
                f2 = f3 - (((1.0f - f1371b.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
            }
            z += 0.20999998f * f;
            f = (f + this.f1377h) * 216.0f;
            c0539a.m1818b(f2);
            c0539a.m1821c(f3);
            c0539a.m1824d(z);
            m1847d(f);
        }
    }

    /* renamed from: a */
    private void m1837a() {
        final C0539a c0539a = this.f1373d;
        Animator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new AnimatorUpdateListener(this) {
            /* renamed from: b */
            final /* synthetic */ C0540d f1346b;

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                this.f1346b.m1839a(floatValue, c0539a);
                this.f1346b.m1840a(floatValue, c0539a, false);
                this.f1346b.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f1370a);
        ofFloat.addListener(new AnimatorListener(this) {
            /* renamed from: b */
            final /* synthetic */ C0540d f1348b;

            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                this.f1348b.f1377h = 0.0f;
            }

            public void onAnimationRepeat(Animator animator) {
                this.f1348b.m1840a(1.0f, c0539a, true);
                c0539a.m1833k();
                c0539a.m1820c();
                if (this.f1348b.f1378i) {
                    this.f1348b.f1378i = false;
                    animator.cancel();
                    animator.setDuration(1332);
                    animator.start();
                    c0539a.m1815a(false);
                    return;
                }
                this.f1348b.f1377h = this.f1348b.f1377h + 1.0f;
            }
        });
        this.f1376g = ofFloat;
    }
}
