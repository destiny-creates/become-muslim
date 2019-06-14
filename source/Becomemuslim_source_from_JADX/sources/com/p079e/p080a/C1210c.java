package com.p079e.p080a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.NetworkInfo;
import com.facebook.internal.NativeProtocol;
import com.p079e.p080a.C1236t.C1233d;
import com.p079e.p080a.C1236t.C1234e;
import com.p079e.p080a.C1245y.C1244a;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: BitmapHunter */
/* renamed from: com.e.a.c */
class C1210c implements Runnable {
    /* renamed from: t */
    private static final Object f3397t = new Object();
    /* renamed from: u */
    private static final ThreadLocal<StringBuilder> f3398u = new C12051();
    /* renamed from: v */
    private static final AtomicInteger f3399v = new AtomicInteger();
    /* renamed from: w */
    private static final C1245y f3400w = new C35002();
    /* renamed from: a */
    final int f3401a = f3399v.incrementAndGet();
    /* renamed from: b */
    final C1236t f3402b;
    /* renamed from: c */
    final C1219i f3403c;
    /* renamed from: d */
    final C1211d f3404d;
    /* renamed from: e */
    final aa f3405e;
    /* renamed from: f */
    final String f3406f;
    /* renamed from: g */
    final C1242w f3407g;
    /* renamed from: h */
    final int f3408h;
    /* renamed from: i */
    int f3409i;
    /* renamed from: j */
    final C1245y f3410j;
    /* renamed from: k */
    C1194a f3411k;
    /* renamed from: l */
    List<C1194a> f3412l;
    /* renamed from: m */
    Bitmap f3413m;
    /* renamed from: n */
    Future<?> f3414n;
    /* renamed from: o */
    C1233d f3415o;
    /* renamed from: p */
    Exception f3416p;
    /* renamed from: q */
    int f3417q;
    /* renamed from: r */
    int f3418r;
    /* renamed from: s */
    C1234e f3419s;

    /* compiled from: BitmapHunter */
    /* renamed from: com.e.a.c$1 */
    static class C12051 extends ThreadLocal<StringBuilder> {
        C12051() {
        }

        protected /* synthetic */ Object initialValue() {
            return m4230a();
        }

        /* renamed from: a */
        protected StringBuilder m4230a() {
            return new StringBuilder("Picasso-");
        }
    }

    /* compiled from: BitmapHunter */
    /* renamed from: com.e.a.c$2 */
    static class C35002 extends C1245y {
        /* renamed from: a */
        public boolean mo821a(C1242w c1242w) {
            return true;
        }

        C35002() {
        }

        /* renamed from: a */
        public C1244a mo820a(C1242w c1242w, int i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unrecognized type of request: ");
            stringBuilder.append(c1242w);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    private static boolean m4236a(boolean z, int i, int i2, int i3, int i4) {
        if (z && i <= i3) {
            if (i2 <= i4) {
                return false;
            }
        }
        return true;
    }

    C1210c(C1236t c1236t, C1219i c1219i, C1211d c1211d, aa aaVar, C1194a c1194a, C1245y c1245y) {
        this.f3402b = c1236t;
        this.f3403c = c1219i;
        this.f3404d = c1211d;
        this.f3405e = aaVar;
        this.f3411k = c1194a;
        this.f3406f = c1194a.m4177e();
        this.f3407g = c1194a.m4175c();
        this.f3419s = c1194a.m4183k();
        this.f3408h = c1194a.m4180h();
        this.f3409i = c1194a.m4181i();
        this.f3410j = c1245y;
        this.f3418r = c1245y.mo829a();
    }

    /* renamed from: a */
    static Bitmap m4232a(InputStream inputStream, C1242w c1242w) {
        InputStream c1223n = new C1223n(inputStream);
        long a = c1223n.m4293a((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        Options c = C1245y.m4348c(c1242w);
        boolean a2 = C1245y.m4347a(c);
        boolean c2 = ae.m4228c(c1223n);
        c1223n.m4294a(a);
        if (c2) {
            byte[] b = ae.m4226b(c1223n);
            if (a2) {
                BitmapFactory.decodeByteArray(b, 0, b.length, c);
                C1245y.m4346a(c1242w.f3544h, c1242w.f3545i, c, c1242w);
            }
            return BitmapFactory.decodeByteArray(b, 0, b.length, c);
        }
        if (a2) {
            BitmapFactory.decodeStream(c1223n, null, c);
            C1245y.m4346a(c1242w.f3544h, c1242w.f3545i, c, c1242w);
            c1223n.m4294a(a);
        }
        inputStream = BitmapFactory.decodeStream(c1223n, null, c);
        if (inputStream != null) {
            return inputStream;
        }
        throw new IOException("Failed to decode stream.");
    }

    public void run() {
        try {
            C1210c.m4235a(this.f3407g);
            if (this.f3402b.f3506l) {
                ae.m4220a("Hunter", "executing", ae.m4213a(this));
            }
            this.f3413m = m4238a();
            if (this.f3413m == null) {
                this.f3403c.m4283c(this);
            } else {
                this.f3403c.m4273a(this);
            }
        } catch (Exception e) {
            if (!(e.f3448a && e.f3449b == 504)) {
                this.f3416p = e;
            }
            this.f3403c.m4283c(this);
        } catch (Exception e2) {
            this.f3416p = e2;
            this.f3403c.m4279b(this);
        } catch (Exception e22) {
            this.f3416p = e22;
            this.f3403c.m4279b(this);
        } catch (Throwable e3) {
            Writer stringWriter = new StringWriter();
            this.f3405e.m4197e().m4198a(new PrintWriter(stringWriter));
            this.f3416p = new RuntimeException(stringWriter.toString(), e3);
            this.f3403c.m4283c(this);
        } catch (Exception e222) {
            this.f3416p = e222;
            this.f3403c.m4283c(this);
        } catch (Throwable th) {
            Thread.currentThread().setName("Picasso-Idle");
        }
        Thread.currentThread().setName("Picasso-Idle");
    }

    /* renamed from: a */
    Bitmap m4238a() {
        Bitmap a;
        if (C1225p.m4295a(this.f3408h)) {
            a = this.f3404d.mo823a(this.f3406f);
            if (a != null) {
                this.f3405e.m4187a();
                this.f3415o = C1233d.MEMORY;
                if (this.f3402b.f3506l) {
                    ae.m4221a("Hunter", "decoded", this.f3407g.m4329a(), "from cache");
                }
                return a;
            }
        }
        a = null;
        this.f3407g.f3539c = this.f3418r == 0 ? C1226q.OFFLINE.f3470d : this.f3409i;
        C1244a a2 = this.f3410j.mo820a(this.f3407g, this.f3409i);
        if (a2 != null) {
            this.f3415o = a2.m4343c();
            this.f3417q = a2.m4344d();
            a = a2.m4341a();
            if (a == null) {
                InputStream b = a2.m4342b();
                try {
                    Bitmap a3 = C1210c.m4232a(b, this.f3407g);
                    a = a3;
                } finally {
                    ae.m4219a(b);
                }
            }
        }
        if (a != null) {
            if (this.f3402b.f3506l) {
                ae.m4220a("Hunter", "decoded", this.f3407g.m4329a());
            }
            this.f3405e.m4189a(a);
            if (this.f3407g.m4333e() || this.f3417q != 0) {
                synchronized (f3397t) {
                    if (this.f3407g.m4334f() || this.f3417q != 0) {
                        a = C1210c.m4231a(this.f3407g, a, this.f3417q);
                        if (this.f3402b.f3506l) {
                            ae.m4220a("Hunter", "transformed", this.f3407g.m4329a());
                        }
                    }
                    if (this.f3407g.m4335g()) {
                        a = C1210c.m4233a(this.f3407g.f3543g, a);
                        if (this.f3402b.f3506l) {
                            ae.m4221a("Hunter", "transformed", this.f3407g.m4329a(), "from custom transformations");
                        }
                    }
                }
                if (a != null) {
                    this.f3405e.m4193b(a);
                }
            }
        }
        return a;
    }

    /* renamed from: a */
    void m4239a(C1194a c1194a) {
        boolean z = this.f3402b.f3506l;
        C1242w c1242w = c1194a.f3349b;
        if (this.f3411k == null) {
            this.f3411k = c1194a;
            if (z) {
                if (this.f3412l != null) {
                    if (this.f3412l.isEmpty() == null) {
                        ae.m4221a("Hunter", "joined", c1242w.m4329a(), ae.m4214a(this, "to "));
                    }
                }
                ae.m4221a("Hunter", "joined", c1242w.m4329a(), "to empty hunter");
            }
            return;
        }
        if (this.f3412l == null) {
            this.f3412l = new ArrayList(3);
        }
        this.f3412l.add(c1194a);
        if (z) {
            ae.m4221a("Hunter", "joined", c1242w.m4329a(), ae.m4214a(this, "to "));
        }
        c1194a = c1194a.m4183k();
        if (c1194a.ordinal() > this.f3419s.ordinal()) {
            this.f3419s = c1194a;
        }
    }

    /* renamed from: b */
    void m4241b(C1194a c1194a) {
        boolean z;
        if (this.f3411k == c1194a) {
            this.f3411k = null;
            z = true;
        } else {
            z = this.f3412l != null ? this.f3412l.remove(c1194a) : false;
        }
        if (z && c1194a.m4183k() == this.f3419s) {
            this.f3419s = m4237o();
        }
        if (this.f3402b.f3506l) {
            ae.m4221a("Hunter", "removed", c1194a.f3349b.m4329a(), ae.m4214a(this, "from "));
        }
    }

    /* renamed from: o */
    private C1234e m4237o() {
        C1234e c1234e = C1234e.LOW;
        Object obj = 1;
        Object obj2 = (this.f3412l == null || this.f3412l.isEmpty()) ? null : 1;
        if (this.f3411k == null) {
            if (obj2 == null) {
                obj = null;
            }
        }
        if (obj == null) {
            return c1234e;
        }
        if (this.f3411k != null) {
            c1234e = this.f3411k.m4183k();
        }
        if (obj2 != null) {
            int size = this.f3412l.size();
            for (int i = 0; i < size; i++) {
                C1234e k = ((C1194a) this.f3412l.get(i)).m4183k();
                if (k.ordinal() > c1234e.ordinal()) {
                    c1234e = k;
                }
            }
        }
        return c1234e;
    }

    /* renamed from: b */
    boolean m4242b() {
        if (this.f3411k != null) {
            return false;
        }
        if ((this.f3412l == null || this.f3412l.isEmpty()) && this.f3414n != null && this.f3414n.cancel(false)) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    boolean m4243c() {
        return this.f3414n != null && this.f3414n.isCancelled();
    }

    /* renamed from: a */
    boolean m4240a(boolean z, NetworkInfo networkInfo) {
        if ((this.f3418r > 0 ? 1 : null) == null) {
            return false;
        }
        this.f3418r--;
        return this.f3410j.mo830a(z, networkInfo);
    }

    /* renamed from: d */
    boolean m4244d() {
        return this.f3410j.mo831b();
    }

    /* renamed from: e */
    Bitmap m4245e() {
        return this.f3413m;
    }

    /* renamed from: f */
    String m4246f() {
        return this.f3406f;
    }

    /* renamed from: g */
    int m4247g() {
        return this.f3408h;
    }

    /* renamed from: h */
    C1242w m4248h() {
        return this.f3407g;
    }

    /* renamed from: i */
    C1194a m4249i() {
        return this.f3411k;
    }

    /* renamed from: j */
    C1236t m4250j() {
        return this.f3402b;
    }

    /* renamed from: k */
    List<C1194a> m4251k() {
        return this.f3412l;
    }

    /* renamed from: l */
    Exception m4252l() {
        return this.f3416p;
    }

    /* renamed from: m */
    C1233d m4253m() {
        return this.f3415o;
    }

    /* renamed from: n */
    C1234e m4254n() {
        return this.f3419s;
    }

    /* renamed from: a */
    static void m4235a(C1242w c1242w) {
        c1242w = c1242w.m4331c();
        StringBuilder stringBuilder = (StringBuilder) f3398u.get();
        stringBuilder.ensureCapacity("Picasso-".length() + c1242w.length());
        stringBuilder.replace("Picasso-".length(), stringBuilder.length(), c1242w);
        Thread.currentThread().setName(stringBuilder.toString());
    }

    /* renamed from: a */
    static C1210c m4234a(C1236t c1236t, C1219i c1219i, C1211d c1211d, aa aaVar, C1194a c1194a) {
        C1242w c = c1194a.m4175c();
        List a = c1236t.m4310a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            C1245y c1245y = (C1245y) a.get(i);
            if (c1245y.mo821a(c)) {
                return new C1210c(c1236t, c1219i, c1211d, aaVar, c1194a, c1245y);
            }
        }
        return new C1210c(c1236t, c1219i, c1211d, aaVar, c1194a, f3400w);
    }

    /* renamed from: a */
    static Bitmap m4233a(List<ac> list, Bitmap bitmap) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            final ac acVar = (ac) list.get(i);
            try {
                Bitmap a = acVar.m4199a(bitmap);
                if (a == null) {
                    bitmap = new StringBuilder();
                    bitmap.append("Transformation ");
                    bitmap.append(acVar.m4200a());
                    bitmap.append(" returned null after ");
                    bitmap.append(i);
                    bitmap.append(" previous transformation(s).\n\nTransformation list:\n");
                    for (ac a2 : list) {
                        bitmap.append(a2.m4200a());
                        bitmap.append('\n');
                    }
                    C1236t.f3495a.post(new Runnable() {
                        public void run() {
                            throw new NullPointerException(bitmap.toString());
                        }
                    });
                    return null;
                } else if (a == bitmap && bitmap.isRecycled()) {
                    C1236t.f3495a.post(new Runnable() {
                        public void run() {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Transformation ");
                            stringBuilder.append(acVar.m4200a());
                            stringBuilder.append(" returned input Bitmap but recycled it.");
                            throw new IllegalStateException(stringBuilder.toString());
                        }
                    });
                    return null;
                } else if (a == bitmap || bitmap.isRecycled() != null) {
                    i++;
                    bitmap = a;
                } else {
                    C1236t.f3495a.post(new Runnable() {
                        public void run() {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Transformation ");
                            stringBuilder.append(acVar.m4200a());
                            stringBuilder.append(" mutated input Bitmap but failed to recycle the original.");
                            throw new IllegalStateException(stringBuilder.toString());
                        }
                    });
                    return null;
                }
            } catch (final List<ac> list2) {
                C1236t.f3495a.post(new Runnable() {
                    public void run() {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Transformation ");
                        stringBuilder.append(acVar.m4200a());
                        stringBuilder.append(" crashed with exception.");
                        throw new RuntimeException(stringBuilder.toString(), list2);
                    }
                });
                return null;
            }
        }
        return bitmap;
    }

    /* renamed from: a */
    static Bitmap m4231a(C1242w c1242w, Bitmap bitmap, int i) {
        int i2;
        int i3;
        int i4;
        Bitmap createBitmap;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        boolean z = c1242w.f3548l;
        Matrix matrix = new Matrix();
        int i5 = 0;
        if (c1242w.m4334f()) {
            int i6 = c1242w.f3544h;
            i2 = c1242w.f3545i;
            float f = c1242w.f3549m;
            if (f != 0.0f) {
                if (c1242w.f3552p) {
                    matrix.setRotate(f, c1242w.f3550n, c1242w.f3551o);
                } else {
                    matrix.setRotate(f);
                }
            }
            float f2;
            if (c1242w.f3546j) {
                C1242w c1242w2;
                c1242w = (float) i6;
                f = (float) width;
                f2 = c1242w / f;
                float f3 = (float) i2;
                float f4 = (float) height;
                float f5 = f3 / f4;
                if (f2 > f5) {
                    c1242w = (int) Math.ceil((double) (f4 * (f5 / f2)));
                    i3 = (height - c1242w) / 2;
                    f5 = f3 / ((float) c1242w);
                    c1242w2 = c1242w;
                    c1242w = f2;
                    i4 = width;
                } else {
                    i3 = (int) Math.ceil((double) (f * (f2 / f5)));
                    c1242w /= (float) i3;
                    c1242w2 = height;
                    i5 = (width - i3) / 2;
                    i4 = i3;
                    i3 = 0;
                }
                if (C1210c.m4236a(z, width, height, i6, i2)) {
                    matrix.preScale(c1242w, f5);
                }
                i2 = i3;
                i3 = i4;
                i4 = c1242w2;
                if (i != 0) {
                    matrix.preRotate((float) i);
                }
                createBitmap = Bitmap.createBitmap(bitmap, i5, i2, i3, i4, matrix, true);
                if (createBitmap != bitmap) {
                    return bitmap;
                }
                bitmap.recycle();
                return createBitmap;
            } else if (c1242w.f3547k != null) {
                c1242w = ((float) i6) / ((float) width);
                f = ((float) i2) / ((float) height);
                if (c1242w >= f) {
                    c1242w = f;
                }
                if (C1210c.m4236a(z, width, height, i6, i2)) {
                    matrix.preScale(c1242w, c1242w);
                }
            } else if (!((i6 == 0 && i2 == 0) || (i6 == width && i2 == height))) {
                if (i6 != 0) {
                    c1242w = (float) i6;
                    f = (float) width;
                } else {
                    c1242w = (float) i2;
                    f = (float) height;
                }
                c1242w /= f;
                if (i2 != 0) {
                    f = (float) i2;
                    f2 = (float) height;
                } else {
                    f = (float) i6;
                    f2 = (float) width;
                }
                f /= f2;
                if (C1210c.m4236a(z, width, height, i6, i2)) {
                    matrix.preScale(c1242w, f);
                }
            }
        }
        i3 = width;
        i4 = height;
        i2 = 0;
        if (i != 0) {
            matrix.preRotate((float) i);
        }
        createBitmap = Bitmap.createBitmap(bitmap, i5, i2, i3, i4, matrix, true);
        if (createBitmap != bitmap) {
            return bitmap;
        }
        bitmap.recycle();
        return createBitmap;
    }
}
