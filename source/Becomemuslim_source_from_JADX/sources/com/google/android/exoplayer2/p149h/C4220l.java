package com.google.android.exoplayer2.p149h;

import android.support.v7.widget.LinearLayoutManager;
import com.facebook.common.time.Clock;
import com.facebook.login.widget.ProfilePictureView;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.C2543l;
import com.google.android.exoplayer2.p135b.C4085e;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p137e.C2329m.C2328a;
import com.google.android.exoplayer2.p149h.C2432k.C2431a;
import com.google.android.exoplayer2.p163k.C2491a;
import com.google.android.exoplayer2.p163k.C2492b;
import com.google.android.exoplayer2.p164l.C2529l;
import java.io.EOFException;
import java.nio.ByteBuffer;

/* compiled from: SampleQueue */
/* renamed from: com.google.android.exoplayer2.h.l */
public final class C4220l implements C2329m {
    /* renamed from: a */
    private final C2492b f11098a;
    /* renamed from: b */
    private final int f11099b;
    /* renamed from: c */
    private final C2432k f11100c = new C2432k();
    /* renamed from: d */
    private final C2431a f11101d = new C2431a();
    /* renamed from: e */
    private final C2529l f11102e = new C2529l(32);
    /* renamed from: f */
    private C2433a f11103f = new C2433a(0, this.f11099b);
    /* renamed from: g */
    private C2433a f11104g = this.f11103f;
    /* renamed from: h */
    private C2433a f11105h = this.f11103f;
    /* renamed from: i */
    private C2515k f11106i;
    /* renamed from: j */
    private boolean f11107j;
    /* renamed from: k */
    private C2515k f11108k;
    /* renamed from: l */
    private long f11109l;
    /* renamed from: m */
    private long f11110m;
    /* renamed from: n */
    private boolean f11111n;
    /* renamed from: o */
    private C2434b f11112o;

    /* compiled from: SampleQueue */
    /* renamed from: com.google.android.exoplayer2.h.l$a */
    private static final class C2433a {
        /* renamed from: a */
        public final long f6059a;
        /* renamed from: b */
        public final long f6060b;
        /* renamed from: c */
        public boolean f6061c;
        /* renamed from: d */
        public C2491a f6062d;
        /* renamed from: e */
        public C2433a f6063e;

        public C2433a(long j, int i) {
            this.f6059a = j;
            this.f6060b = j + ((long) i);
        }

        /* renamed from: a */
        public void m6702a(C2491a c2491a, C2433a c2433a) {
            this.f6062d = c2491a;
            this.f6063e = c2433a;
            this.f6061c = true;
        }

        /* renamed from: a */
        public int m6700a(long j) {
            return ((int) (j - this.f6059a)) + this.f6062d.f6341b;
        }

        /* renamed from: a */
        public C2433a m6701a() {
            this.f6062d = null;
            C2433a c2433a = this.f6063e;
            this.f6063e = null;
            return c2433a;
        }
    }

    /* compiled from: SampleQueue */
    /* renamed from: com.google.android.exoplayer2.h.l$b */
    public interface C2434b {
        /* renamed from: a */
        void mo2274a(C2515k c2515k);
    }

    public C4220l(C2492b c2492b) {
        this.f11098a = c2492b;
        this.f11099b = c2492b.mo2315c();
    }

    /* renamed from: a */
    public void m13663a() {
        m13671a(false);
    }

    /* renamed from: a */
    public void m13671a(boolean z) {
        this.f11100c.m6686a(z);
        m13656a(this.f11103f);
        this.f11103f = new C2433a(0, this.f11099b);
        this.f11104g = this.f11103f;
        this.f11105h = this.f11103f;
        this.f11110m = 0;
        this.f11098a.mo2314b();
    }

    /* renamed from: a */
    public void m13664a(int i) {
        this.f11100c.m6690b(i);
    }

    /* renamed from: b */
    public void m13673b() {
        this.f11111n = true;
    }

    /* renamed from: c */
    public int m13675c() {
        return this.f11100c.m6680a();
    }

    /* renamed from: b */
    public void m13674b(int i) {
        this.f11110m = this.f11100c.m6683a(i);
        if (this.f11110m != 0) {
            if (this.f11110m != this.f11103f.f6059a) {
                i = this.f11103f;
                while (this.f11110m > i.f6060b) {
                    i = i.f6063e;
                }
                C2433a c2433a = i.f6063e;
                m13656a(c2433a);
                i.f6063e = new C2433a(i.f6060b, this.f11099b);
                this.f11105h = this.f11110m == i.f6060b ? i.f6063e : i;
                if (this.f11104g == c2433a) {
                    this.f11104g = i.f6063e;
                    return;
                }
                return;
            }
        }
        m13656a(this.f11103f);
        this.f11103f = new C2433a(this.f11110m, this.f11099b);
        this.f11104g = this.f11103f;
        this.f11105h = this.f11103f;
    }

    /* renamed from: d */
    public boolean m13676d() {
        return this.f11100c.m6693d();
    }

    /* renamed from: e */
    public int m13677e() {
        return this.f11100c.m6688b();
    }

    /* renamed from: f */
    public int m13678f() {
        return this.f11100c.m6692c();
    }

    /* renamed from: g */
    public C2515k m13679g() {
        return this.f11100c.m6694e();
    }

    /* renamed from: h */
    public long m13680h() {
        return this.f11100c.m6695f();
    }

    /* renamed from: i */
    public void m13681i() {
        this.f11100c.m6696g();
        this.f11104g = this.f11103f;
    }

    /* renamed from: a */
    public void m13667a(long j, boolean z, boolean z2) {
        m13659c(this.f11100c.m6689b(j, z, z2));
    }

    /* renamed from: j */
    public void m13682j() {
        m13659c(this.f11100c.m6698i());
    }

    /* renamed from: k */
    public void m13683k() {
        m13659c(this.f11100c.m6699j());
    }

    /* renamed from: l */
    public int m13684l() {
        return this.f11100c.m6697h();
    }

    /* renamed from: b */
    public int m13672b(long j, boolean z, boolean z2) {
        return this.f11100c.m6681a(j, z, z2);
    }

    /* renamed from: a */
    public int m13662a(C2543l c2543l, C4085e c4085e, boolean z, boolean z2, long j) {
        switch (this.f11100c.m6682a(c2543l, c4085e, z, z2, this.f11106i, this.f11101d)) {
            case true:
                this.f11106i = c2543l.f6476a;
                return -5;
            case ProfilePictureView.LARGE /*-4*/:
                if (c4085e.m6206c() == null) {
                    if (c4085e.f10319c < j) {
                        c4085e.m6204b(LinearLayoutManager.INVALID_OFFSET);
                    }
                    if (c4085e.m12755g() != null) {
                        m13655a(c4085e, this.f11101d);
                    }
                    c4085e.m12753e(this.f11101d.f6038a);
                    m13653a(this.f11101d.f6039b, c4085e.f10318b, this.f11101d.f6038a);
                }
                return -4;
            case ProfilePictureView.NORMAL /*-3*/:
                return -3;
            default:
                throw new IllegalStateException();
        }
    }

    /* renamed from: a */
    private void m13655a(C4085e c4085e, C2431a c2431a) {
        int h;
        int[] iArr;
        int[] iArr2;
        C2328a c2328a;
        int i;
        C4085e c4085e2 = c4085e;
        C2431a c2431a2 = c2431a;
        long j = c2431a2.f6039b;
        this.f11102e.m7089a(1);
        m13654a(j, this.f11102e.f6441a, 1);
        j++;
        int i2 = 0;
        byte b = this.f11102e.f6441a[0];
        Object obj = (b & 128) != 0 ? 1 : null;
        int i3 = b & 127;
        if (c4085e2.f10317a.f5355a == null) {
            c4085e2.f10317a.f5355a = new byte[16];
        }
        m13654a(j, c4085e2.f10317a.f5355a, i3);
        j += (long) i3;
        if (obj != null) {
            r0.f11102e.m7089a(2);
            m13654a(j, r0.f11102e.f6441a, 2);
            j += 2;
            h = r0.f11102e.m7104h();
        } else {
            h = 1;
        }
        int[] iArr3 = c4085e2.f10317a.f5358d;
        if (iArr3 != null) {
            if (iArr3.length < h) {
            }
            iArr = iArr3;
            iArr3 = c4085e2.f10317a.f5359e;
            if (iArr3 != null) {
                if (iArr3.length < h) {
                }
                iArr2 = iArr3;
                if (obj == null) {
                    i3 = h * 6;
                    r0.f11102e.m7089a(i3);
                    m13654a(j, r0.f11102e.f6441a, i3);
                    j += (long) i3;
                    r0.f11102e.m7096c(0);
                    while (i2 < h) {
                        iArr[i2] = r0.f11102e.m7104h();
                        iArr2[i2] = r0.f11102e.m7117u();
                        i2++;
                    }
                } else {
                    iArr[0] = 0;
                    iArr2[0] = c2431a2.f6038a - ((int) (j - c2431a2.f6039b));
                }
                c2328a = c2431a2.f6040c;
                c4085e2.f10317a.m6214a(h, iArr, iArr2, c2328a.f5778b, c4085e2.f10317a.f5355a, c2328a.f5777a, c2328a.f5779c, c2328a.f5780d);
                i = (int) (j - c2431a2.f6039b);
                c2431a2.f6039b += (long) i;
                c2431a2.f6038a -= i;
            }
            iArr3 = new int[h];
            iArr2 = iArr3;
            if (obj == null) {
                iArr[0] = 0;
                iArr2[0] = c2431a2.f6038a - ((int) (j - c2431a2.f6039b));
            } else {
                i3 = h * 6;
                r0.f11102e.m7089a(i3);
                m13654a(j, r0.f11102e.f6441a, i3);
                j += (long) i3;
                r0.f11102e.m7096c(0);
                while (i2 < h) {
                    iArr[i2] = r0.f11102e.m7104h();
                    iArr2[i2] = r0.f11102e.m7117u();
                    i2++;
                }
            }
            c2328a = c2431a2.f6040c;
            c4085e2.f10317a.m6214a(h, iArr, iArr2, c2328a.f5778b, c4085e2.f10317a.f5355a, c2328a.f5777a, c2328a.f5779c, c2328a.f5780d);
            i = (int) (j - c2431a2.f6039b);
            c2431a2.f6039b += (long) i;
            c2431a2.f6038a -= i;
        }
        iArr3 = new int[h];
        iArr = iArr3;
        iArr3 = c4085e2.f10317a.f5359e;
        if (iArr3 != null) {
            if (iArr3.length < h) {
            }
            iArr2 = iArr3;
            if (obj == null) {
                i3 = h * 6;
                r0.f11102e.m7089a(i3);
                m13654a(j, r0.f11102e.f6441a, i3);
                j += (long) i3;
                r0.f11102e.m7096c(0);
                while (i2 < h) {
                    iArr[i2] = r0.f11102e.m7104h();
                    iArr2[i2] = r0.f11102e.m7117u();
                    i2++;
                }
            } else {
                iArr[0] = 0;
                iArr2[0] = c2431a2.f6038a - ((int) (j - c2431a2.f6039b));
            }
            c2328a = c2431a2.f6040c;
            c4085e2.f10317a.m6214a(h, iArr, iArr2, c2328a.f5778b, c4085e2.f10317a.f5355a, c2328a.f5777a, c2328a.f5779c, c2328a.f5780d);
            i = (int) (j - c2431a2.f6039b);
            c2431a2.f6039b += (long) i;
            c2431a2.f6038a -= i;
        }
        iArr3 = new int[h];
        iArr2 = iArr3;
        if (obj == null) {
            iArr[0] = 0;
            iArr2[0] = c2431a2.f6038a - ((int) (j - c2431a2.f6039b));
        } else {
            i3 = h * 6;
            r0.f11102e.m7089a(i3);
            m13654a(j, r0.f11102e.f6441a, i3);
            j += (long) i3;
            r0.f11102e.m7096c(0);
            while (i2 < h) {
                iArr[i2] = r0.f11102e.m7104h();
                iArr2[i2] = r0.f11102e.m7117u();
                i2++;
            }
        }
        c2328a = c2431a2.f6040c;
        c4085e2.f10317a.m6214a(h, iArr, iArr2, c2328a.f5778b, c4085e2.f10317a.f5355a, c2328a.f5777a, c2328a.f5779c, c2328a.f5780d);
        i = (int) (j - c2431a2.f6039b);
        c2431a2.f6039b += (long) i;
        c2431a2.f6038a -= i;
    }

    /* renamed from: a */
    private void m13653a(long j, ByteBuffer byteBuffer, int i) {
        m13657b(j);
        while (i > 0) {
            int min = Math.min(i, (int) (this.f11104g.f6060b - j));
            byteBuffer.put(this.f11104g.f6062d.f6340a, this.f11104g.m6700a(j), min);
            i -= min;
            j += (long) min;
            if (j == this.f11104g.f6060b) {
                this.f11104g = this.f11104g.f6063e;
            }
        }
    }

    /* renamed from: a */
    private void m13654a(long j, byte[] bArr, int i) {
        m13657b(j);
        long j2 = j;
        j = i;
        while (j > null) {
            int min = Math.min(j, (int) (this.f11104g.f6060b - j2));
            System.arraycopy(this.f11104g.f6062d.f6340a, this.f11104g.m6700a(j2), bArr, i - j, min);
            j -= min;
            j2 += (long) min;
            if (j2 == this.f11104g.f6060b) {
                this.f11104g = this.f11104g.f6063e;
            }
        }
    }

    /* renamed from: b */
    private void m13657b(long j) {
        while (j >= this.f11104g.f6060b) {
            this.f11104g = this.f11104g.f6063e;
        }
    }

    /* renamed from: c */
    private void m13659c(long j) {
        if (j != -1) {
            while (j >= this.f11103f.f6060b) {
                this.f11098a.mo2312a(this.f11103f.f6062d);
                this.f11103f = this.f11103f.m6701a();
            }
            if (this.f11104g.f6059a < this.f11103f.f6059a) {
                this.f11104g = this.f11103f;
            }
        }
    }

    /* renamed from: a */
    public void m13668a(C2434b c2434b) {
        this.f11112o = c2434b;
    }

    /* renamed from: a */
    public void m13665a(long j) {
        if (this.f11109l != j) {
            this.f11109l = j;
            this.f11107j = 1;
        }
    }

    /* renamed from: a */
    public void mo2199a(C2515k c2515k) {
        C2515k a = C4220l.m13652a(c2515k, this.f11109l);
        boolean a2 = this.f11100c.m6687a(a);
        this.f11108k = c2515k;
        this.f11107j = null;
        if (this.f11112o != null && a2) {
            this.f11112o.mo2274a(a);
        }
    }

    /* renamed from: a */
    public int mo2197a(C2304f c2304f, int i, boolean z) {
        c2304f = c2304f.mo2182a(this.f11105h.f6062d.f6340a, this.f11105h.m6700a(this.f11110m), m13658c(i));
        if (c2304f != -1) {
            m13660d(c2304f);
            return c2304f;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    /* renamed from: a */
    public void mo2200a(C2529l c2529l, int i) {
        while (i > 0) {
            int c = m13658c(i);
            c2529l.m7092a(this.f11105h.f6062d.f6340a, this.f11105h.m6700a(this.f11110m), c);
            i -= c;
            m13660d(c);
        }
    }

    /* renamed from: a */
    public void mo2198a(long j, int i, int i2, int i3, C2328a c2328a) {
        long j2 = j;
        if (this.f11107j) {
            mo2199a(r0.f11108k);
        }
        if (r0.f11111n) {
            if ((i & 1) != 0) {
                if (r0.f11100c.m6691b(j)) {
                    r0.f11111n = false;
                }
            }
            return;
        }
        int i4 = i2;
        r0.f11100c.m6685a(j2 + r0.f11109l, i, (r0.f11110m - ((long) i4)) - ((long) i3), i4, c2328a);
    }

    /* renamed from: a */
    private void m13656a(C2433a c2433a) {
        if (c2433a.f6061c) {
            C2491a[] c2491aArr = new C2491a[(this.f11105h.f6061c + (((int) (this.f11105h.f6059a - c2433a.f6059a)) / this.f11099b))];
            for (int i = 0; i < c2491aArr.length; i++) {
                c2491aArr[i] = c2433a.f6062d;
                c2433a = c2433a.m6701a();
            }
            this.f11098a.mo2313a(c2491aArr);
        }
    }

    /* renamed from: c */
    private int m13658c(int i) {
        if (!this.f11105h.f6061c) {
            this.f11105h.m6702a(this.f11098a.mo2311a(), new C2433a(this.f11105h.f6060b, this.f11099b));
        }
        return Math.min(i, (int) (this.f11105h.f6060b - this.f11110m));
    }

    /* renamed from: d */
    private void m13660d(int i) {
        this.f11110m += (long) i;
        if (this.f11110m == this.f11105h.f6060b) {
            this.f11105h = this.f11105h.f6063e;
        }
    }

    /* renamed from: a */
    private static C2515k m13652a(C2515k c2515k, long j) {
        if (c2515k == null) {
            return null;
        }
        if (!(j == 0 || c2515k.f6397w == Clock.MAX_TIME)) {
            c2515k = c2515k.m7008a(c2515k.f6397w + j);
        }
        return c2515k;
    }
}
