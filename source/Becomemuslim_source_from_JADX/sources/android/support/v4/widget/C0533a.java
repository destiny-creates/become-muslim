package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.C0517s;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.facebook.stetho.server.http.HttpStatus;

/* compiled from: AutoScrollHelper */
/* renamed from: android.support.v4.widget.a */
public abstract class C0533a implements OnTouchListener {
    /* renamed from: r */
    private static final int f1321r = ViewConfiguration.getTapTimeout();
    /* renamed from: a */
    final C0531a f1322a = new C0531a();
    /* renamed from: b */
    final View f1323b;
    /* renamed from: c */
    boolean f1324c;
    /* renamed from: d */
    boolean f1325d;
    /* renamed from: e */
    boolean f1326e;
    /* renamed from: f */
    private final Interpolator f1327f = new AccelerateInterpolator();
    /* renamed from: g */
    private Runnable f1328g;
    /* renamed from: h */
    private float[] f1329h = new float[]{0.0f, 0.0f};
    /* renamed from: i */
    private float[] f1330i = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    /* renamed from: j */
    private int f1331j;
    /* renamed from: k */
    private int f1332k;
    /* renamed from: l */
    private float[] f1333l = new float[]{0.0f, 0.0f};
    /* renamed from: m */
    private float[] f1334m = new float[]{0.0f, 0.0f};
    /* renamed from: n */
    private float[] f1335n = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    /* renamed from: o */
    private boolean f1336o;
    /* renamed from: p */
    private boolean f1337p;
    /* renamed from: q */
    private boolean f1338q;

    /* compiled from: AutoScrollHelper */
    /* renamed from: android.support.v4.widget.a$a */
    private static class C0531a {
        /* renamed from: a */
        private int f1309a;
        /* renamed from: b */
        private int f1310b;
        /* renamed from: c */
        private float f1311c;
        /* renamed from: d */
        private float f1312d;
        /* renamed from: e */
        private long f1313e = Long.MIN_VALUE;
        /* renamed from: f */
        private long f1314f = 0;
        /* renamed from: g */
        private int f1315g = 0;
        /* renamed from: h */
        private int f1316h = 0;
        /* renamed from: i */
        private long f1317i = -1;
        /* renamed from: j */
        private float f1318j;
        /* renamed from: k */
        private int f1319k;

        /* renamed from: a */
        private float m1770a(float f) {
            return ((-4.0f * f) * f) + (f * 4.0f);
        }

        C0531a() {
        }

        /* renamed from: a */
        public void m1774a(int i) {
            this.f1309a = i;
        }

        /* renamed from: b */
        public void m1776b(int i) {
            this.f1310b = i;
        }

        /* renamed from: a */
        public void m1772a() {
            this.f1313e = AnimationUtils.currentAnimationTimeMillis();
            this.f1317i = -1;
            this.f1314f = this.f1313e;
            this.f1318j = 0.5f;
            this.f1315g = 0;
            this.f1316h = 0;
        }

        /* renamed from: b */
        public void m1775b() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f1319k = C0533a.m1786a((int) (currentAnimationTimeMillis - this.f1313e), 0, this.f1310b);
            this.f1318j = m1771a(currentAnimationTimeMillis);
            this.f1317i = currentAnimationTimeMillis;
        }

        /* renamed from: c */
        public boolean m1777c() {
            return this.f1317i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f1317i + ((long) this.f1319k);
        }

        /* renamed from: a */
        private float m1771a(long j) {
            if (j < this.f1313e) {
                return 0.0f;
            }
            if (this.f1317i >= 0) {
                if (j >= this.f1317i) {
                    return (1.0f - this.f1318j) + (this.f1318j * C0533a.m1783a(((float) (j - this.f1317i)) / ((float) this.f1319k), 0.0f, 1.0f));
                }
            }
            return C0533a.m1783a(((float) (j - this.f1313e)) / ((float) this.f1309a), 0.0f, 1.0f) * 0.5f;
        }

        /* renamed from: d */
        public void m1778d() {
            if (this.f1314f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float a = m1770a(m1771a(currentAnimationTimeMillis));
                long j = currentAnimationTimeMillis - this.f1314f;
                this.f1314f = currentAnimationTimeMillis;
                float f = ((float) j) * a;
                this.f1315g = (int) (this.f1311c * f);
                this.f1316h = (int) (f * this.f1312d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        /* renamed from: a */
        public void m1773a(float f, float f2) {
            this.f1311c = f;
            this.f1312d = f2;
        }

        /* renamed from: e */
        public int m1779e() {
            return (int) (this.f1311c / Math.abs(this.f1311c));
        }

        /* renamed from: f */
        public int m1780f() {
            return (int) (this.f1312d / Math.abs(this.f1312d));
        }

        /* renamed from: g */
        public int m1781g() {
            return this.f1315g;
        }

        /* renamed from: h */
        public int m1782h() {
            return this.f1316h;
        }
    }

    /* compiled from: AutoScrollHelper */
    /* renamed from: android.support.v4.widget.a$b */
    private class C0532b implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C0533a f1320a;

        C0532b(C0533a c0533a) {
            this.f1320a = c0533a;
        }

        public void run() {
            if (this.f1320a.f1326e) {
                if (this.f1320a.f1324c) {
                    this.f1320a.f1324c = false;
                    this.f1320a.f1322a.m1772a();
                }
                C0531a c0531a = this.f1320a.f1322a;
                if (!c0531a.m1777c()) {
                    if (this.f1320a.m1794a()) {
                        if (this.f1320a.f1325d) {
                            this.f1320a.f1325d = false;
                            this.f1320a.m1797b();
                        }
                        c0531a.m1778d();
                        this.f1320a.mo345a(c0531a.m1781g(), c0531a.m1782h());
                        C0517s.m1697a(this.f1320a.f1323b, (Runnable) this);
                        return;
                    }
                }
                this.f1320a.f1326e = false;
            }
        }
    }

    /* renamed from: a */
    static float m1783a(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* renamed from: a */
    static int m1786a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    /* renamed from: a */
    public abstract void mo345a(int i, int i2);

    /* renamed from: e */
    public abstract boolean mo346e(int i);

    /* renamed from: f */
    public abstract boolean mo347f(int i);

    public C0533a(View view) {
        this.f1323b = view;
        view = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((view.density * 1575.0f) + 0.5f);
        view = (int) ((view.density * 315.0f) + 1056964608);
        float f = (float) i;
        m1790a(f, f);
        view = (float) view;
        m1795b(view, view);
        m1791a(1);
        m1802e(Float.MAX_VALUE, Float.MAX_VALUE);
        m1800d(0.2f, 0.2f);
        m1798c(1.0f, 1.0f);
        m1796b(f1321r);
        m1799c(HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
        m1801d(HttpStatus.HTTP_INTERNAL_SERVER_ERROR);
    }

    /* renamed from: a */
    public C0533a m1792a(boolean z) {
        if (this.f1337p && !z) {
            m1788d();
        }
        this.f1337p = z;
        return this;
    }

    /* renamed from: a */
    public C0533a m1790a(float f, float f2) {
        this.f1335n[0] = f / 1000.0f;
        this.f1335n[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: b */
    public C0533a m1795b(float f, float f2) {
        this.f1334m[0] = f / 1000.0f;
        this.f1334m[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: c */
    public C0533a m1798c(float f, float f2) {
        this.f1333l[0] = f / 1000.0f;
        this.f1333l[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: a */
    public C0533a m1791a(int i) {
        this.f1331j = i;
        return this;
    }

    /* renamed from: d */
    public C0533a m1800d(float f, float f2) {
        this.f1329h[0] = f;
        this.f1329h[1] = f2;
        return this;
    }

    /* renamed from: e */
    public C0533a m1802e(float f, float f2) {
        this.f1330i[0] = f;
        this.f1330i[1] = f2;
        return this;
    }

    /* renamed from: b */
    public C0533a m1796b(int i) {
        this.f1332k = i;
        return this;
    }

    /* renamed from: c */
    public C0533a m1799c(int i) {
        this.f1322a.m1774a(i);
        return this;
    }

    /* renamed from: d */
    public C0533a m1801d(int i) {
        this.f1322a.m1776b(i);
        return this;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = false;
        if (!this.f1337p) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f1325d = true;
                this.f1336o = false;
                break;
            case 1:
            case 3:
                m1788d();
                break;
            case 2:
                break;
            default:
                break;
        }
        this.f1322a.m1773a(m1785a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f1323b.getWidth()), m1785a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f1323b.getHeight()));
        if (this.f1326e == null && m1794a() != null) {
            m1787c();
        }
        if (!(this.f1338q == null || this.f1326e == null)) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    boolean m1794a() {
        C0531a c0531a = this.f1322a;
        int f = c0531a.m1780f();
        int e = c0531a.m1779e();
        return (f != 0 && mo347f(f)) || (e != 0 && mo346e(e));
    }

    /* renamed from: c */
    private void m1787c() {
        if (this.f1328g == null) {
            this.f1328g = new C0532b(this);
        }
        this.f1326e = true;
        this.f1324c = true;
        if (this.f1336o || this.f1332k <= 0) {
            this.f1328g.run();
        } else {
            C0517s.m1698a(this.f1323b, this.f1328g, (long) this.f1332k);
        }
        this.f1336o = true;
    }

    /* renamed from: d */
    private void m1788d() {
        if (this.f1324c) {
            this.f1326e = false;
        } else {
            this.f1322a.m1775b();
        }
    }

    /* renamed from: a */
    private float m1785a(int i, float f, float f2, float f3) {
        f = m1784a(this.f1329h[i], f2, this.f1330i[i], f);
        int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (i2 == 0) {
            return 0.0f;
        }
        f2 = this.f1333l[i];
        float f4 = this.f1334m[i];
        float f5 = this.f1335n[i];
        f2 *= f3;
        if (i2 > 0) {
            return C0533a.m1783a(f * f2, f4, f5);
        }
        return -C0533a.m1783a((-f) * f2, f4, f5);
    }

    /* renamed from: a */
    private float m1784a(float f, float f2, float f3, float f4) {
        f = C0533a.m1783a(f * f2, 0.0f, f3);
        f = m1789f(f2 - f4, f) - m1789f(f4, f);
        if (f < 0.0f) {
            f = -this.f1327f.getInterpolation(-f);
        } else if (f <= 0.0f) {
            return 0.0f;
        } else {
            f = this.f1327f.getInterpolation(f);
        }
        return C0533a.m1783a(f, -1.0f, 1.0f);
    }

    /* renamed from: f */
    private float m1789f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.f1331j) {
            case 0:
            case 1:
                if (f < f2) {
                    if (f >= 0.0f) {
                        return 1.0f - (f / f2);
                    }
                    return (this.f1326e == null || this.f1331j != Float.MIN_VALUE) ? 0.0f : 1.0f;
                }
                break;
            case 2:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                break;
            default:
                break;
        }
    }

    /* renamed from: b */
    void m1797b() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f1323b.onTouchEvent(obtain);
        obtain.recycle();
    }
}
