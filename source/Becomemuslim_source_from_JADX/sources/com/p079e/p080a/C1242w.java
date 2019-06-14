package com.p079e.p080a;

import android.graphics.Bitmap.Config;
import android.net.Uri;
import com.p079e.p080a.C1236t.C1234e;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: Request */
/* renamed from: com.e.a.w */
public final class C1242w {
    /* renamed from: s */
    private static final long f3536s = TimeUnit.SECONDS.toNanos(5);
    /* renamed from: a */
    int f3537a;
    /* renamed from: b */
    long f3538b;
    /* renamed from: c */
    int f3539c;
    /* renamed from: d */
    public final Uri f3540d;
    /* renamed from: e */
    public final int f3541e;
    /* renamed from: f */
    public final String f3542f;
    /* renamed from: g */
    public final List<ac> f3543g;
    /* renamed from: h */
    public final int f3544h;
    /* renamed from: i */
    public final int f3545i;
    /* renamed from: j */
    public final boolean f3546j;
    /* renamed from: k */
    public final boolean f3547k;
    /* renamed from: l */
    public final boolean f3548l;
    /* renamed from: m */
    public final float f3549m;
    /* renamed from: n */
    public final float f3550n;
    /* renamed from: o */
    public final float f3551o;
    /* renamed from: p */
    public final boolean f3552p;
    /* renamed from: q */
    public final Config f3553q;
    /* renamed from: r */
    public final C1234e f3554r;

    /* compiled from: Request */
    /* renamed from: com.e.a.w$a */
    public static final class C1241a {
        /* renamed from: a */
        private Uri f3521a;
        /* renamed from: b */
        private int f3522b;
        /* renamed from: c */
        private String f3523c;
        /* renamed from: d */
        private int f3524d;
        /* renamed from: e */
        private int f3525e;
        /* renamed from: f */
        private boolean f3526f;
        /* renamed from: g */
        private boolean f3527g;
        /* renamed from: h */
        private boolean f3528h;
        /* renamed from: i */
        private float f3529i;
        /* renamed from: j */
        private float f3530j;
        /* renamed from: k */
        private float f3531k;
        /* renamed from: l */
        private boolean f3532l;
        /* renamed from: m */
        private List<ac> f3533m;
        /* renamed from: n */
        private Config f3534n;
        /* renamed from: o */
        private C1234e f3535o;

        C1241a(Uri uri, int i, Config config) {
            this.f3521a = uri;
            this.f3522b = i;
            this.f3534n = config;
        }

        /* renamed from: a */
        boolean m4326a() {
            if (this.f3521a == null) {
                if (this.f3522b == 0) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: b */
        boolean m4327b() {
            if (this.f3524d == 0) {
                if (this.f3525e == 0) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: a */
        public C1241a m4325a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            } else if (i2 >= 0) {
                if (i2 == 0) {
                    if (i == 0) {
                        throw new IllegalArgumentException("At least one dimension has to be positive number.");
                    }
                }
                this.f3524d = i;
                this.f3525e = i2;
                return this;
            } else {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            }
        }

        /* renamed from: c */
        public C1242w m4328c() {
            if (this.f3527g) {
                if (r0.f3526f) {
                    throw new IllegalStateException("Center crop and center inside can not be used together.");
                }
            }
            if (r0.f3526f && r0.f3524d == 0) {
                if (r0.f3525e == 0) {
                    throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
                }
            }
            if (r0.f3527g && r0.f3524d == 0) {
                if (r0.f3525e == 0) {
                    throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
                }
            }
            if (r0.f3535o == null) {
                r0.f3535o = C1234e.NORMAL;
            }
            C1242w c1242w = r2;
            C1242w c1242w2 = new C1242w(r0.f3521a, r0.f3522b, r0.f3523c, r0.f3533m, r0.f3524d, r0.f3525e, r0.f3526f, r0.f3527g, r0.f3528h, r0.f3529i, r0.f3530j, r0.f3531k, r0.f3532l, r0.f3534n, r0.f3535o);
            return c1242w;
        }
    }

    private C1242w(Uri uri, int i, String str, List<ac> list, int i2, int i3, boolean z, boolean z2, boolean z3, float f, float f2, float f3, boolean z4, Config config, C1234e c1234e) {
        this.f3540d = uri;
        this.f3541e = i;
        this.f3542f = str;
        if (list == null) {
            this.f3543g = null;
        } else {
            this.f3543g = Collections.unmodifiableList(list);
        }
        this.f3544h = i2;
        this.f3545i = i3;
        this.f3546j = z;
        this.f3547k = z2;
        this.f3548l = z3;
        this.f3549m = f;
        this.f3550n = f2;
        this.f3551o = f3;
        this.f3552p = z4;
        this.f3553q = config;
        this.f3554r = c1234e;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Request{");
        if (this.f3541e > 0) {
            stringBuilder.append(this.f3541e);
        } else {
            stringBuilder.append(this.f3540d);
        }
        if (!(this.f3543g == null || this.f3543g.isEmpty())) {
            for (ac acVar : this.f3543g) {
                stringBuilder.append(' ');
                stringBuilder.append(acVar.m4200a());
            }
        }
        if (this.f3542f != null) {
            stringBuilder.append(" stableKey(");
            stringBuilder.append(this.f3542f);
            stringBuilder.append(')');
        }
        if (this.f3544h > 0) {
            stringBuilder.append(" resize(");
            stringBuilder.append(this.f3544h);
            stringBuilder.append(',');
            stringBuilder.append(this.f3545i);
            stringBuilder.append(')');
        }
        if (this.f3546j) {
            stringBuilder.append(" centerCrop");
        }
        if (this.f3547k) {
            stringBuilder.append(" centerInside");
        }
        if (this.f3549m != 0.0f) {
            stringBuilder.append(" rotation(");
            stringBuilder.append(this.f3549m);
            if (this.f3552p) {
                stringBuilder.append(" @ ");
                stringBuilder.append(this.f3550n);
                stringBuilder.append(',');
                stringBuilder.append(this.f3551o);
            }
            stringBuilder.append(')');
        }
        if (this.f3553q != null) {
            stringBuilder.append(' ');
            stringBuilder.append(this.f3553q);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    /* renamed from: a */
    String m4329a() {
        long nanoTime = System.nanoTime() - this.f3538b;
        if (nanoTime > f3536s) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(m4330b());
            stringBuilder.append('+');
            stringBuilder.append(TimeUnit.NANOSECONDS.toSeconds(nanoTime));
            stringBuilder.append('s');
            return stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(m4330b());
        stringBuilder.append('+');
        stringBuilder.append(TimeUnit.NANOSECONDS.toMillis(nanoTime));
        stringBuilder.append("ms");
        return stringBuilder.toString();
    }

    /* renamed from: b */
    String m4330b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[R");
        stringBuilder.append(this.f3537a);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    /* renamed from: c */
    String m4331c() {
        if (this.f3540d != null) {
            return String.valueOf(this.f3540d.getPath());
        }
        return Integer.toHexString(this.f3541e);
    }

    /* renamed from: d */
    public boolean m4332d() {
        if (this.f3544h == 0) {
            if (this.f3545i == 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    boolean m4333e() {
        if (!m4334f()) {
            if (!m4335g()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    boolean m4334f() {
        if (!m4332d()) {
            if (this.f3549m == 0.0f) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    boolean m4335g() {
        return this.f3543g != null;
    }
}
