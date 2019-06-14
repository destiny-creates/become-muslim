package com.google.android.exoplayer2.p137e.p139b;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p164l.C2516a;
import java.util.Stack;

/* compiled from: DefaultEbmlReader */
/* renamed from: com.google.android.exoplayer2.e.b.a */
final class C4098a implements C2263b {
    /* renamed from: a */
    private final byte[] f10385a = new byte[8];
    /* renamed from: b */
    private final Stack<C2262a> f10386b = new Stack();
    /* renamed from: c */
    private final C2267f f10387c = new C2267f();
    /* renamed from: d */
    private C2264c f10388d;
    /* renamed from: e */
    private int f10389e;
    /* renamed from: f */
    private int f10390f;
    /* renamed from: g */
    private long f10391g;

    /* compiled from: DefaultEbmlReader */
    /* renamed from: com.google.android.exoplayer2.e.b.a$a */
    private static final class C2262a {
        /* renamed from: a */
        private final int f5391a;
        /* renamed from: b */
        private final long f5392b;

        private C2262a(int i, long j) {
            this.f5391a = i;
            this.f5392b = j;
        }
    }

    C4098a() {
    }

    /* renamed from: a */
    public void mo2171a(C2264c c2264c) {
        this.f10388d = c2264c;
    }

    /* renamed from: a */
    public void mo2170a() {
        this.f10389e = 0;
        this.f10386b.clear();
        this.f10387c.m6267a();
    }

    /* renamed from: a */
    public boolean mo2172a(C2304f c2304f) {
        C2516a.m7019b(this.f10388d != null);
        while (true) {
            if (this.f10386b.isEmpty() || c2304f.mo2189c() < ((C2262a) this.f10386b.peek()).f5392b) {
                if (this.f10389e == 0) {
                    long a = this.f10387c.m6266a(c2304f, true, false, 4);
                    if (a == -2) {
                        a = m12830b(c2304f);
                    }
                    if (a == -1) {
                        return false;
                    }
                    this.f10390f = (int) a;
                    this.f10389e = 1;
                }
                if (this.f10389e == 1) {
                    this.f10391g = this.f10387c.m6266a(c2304f, false, true, 8);
                    this.f10389e = 2;
                }
                int a2 = this.f10388d.mo2173a(this.f10390f);
                StringBuilder stringBuilder;
                switch (a2) {
                    case 0:
                        c2304f.mo2186b((int) this.f10391g);
                        this.f10389e = 0;
                    case 1:
                        long c = c2304f.mo2189c();
                        this.f10386b.add(new C2262a(this.f10390f, this.f10391g + c));
                        this.f10388d.mo2177a(this.f10390f, c, this.f10391g);
                        this.f10389e = 0;
                        return true;
                    case 2:
                        if (this.f10391g <= 8) {
                            this.f10388d.mo2176a(this.f10390f, m12828a(c2304f, (int) this.f10391g));
                            this.f10389e = 0;
                            return true;
                        }
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Invalid integer size: ");
                        stringBuilder.append(this.f10391g);
                        throw new C2571p(stringBuilder.toString());
                    case 3:
                        if (this.f10391g <= 2147483647L) {
                            this.f10388d.mo2178a(this.f10390f, m12831c(c2304f, (int) this.f10391g));
                            this.f10389e = 0;
                            return true;
                        }
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("String element size: ");
                        stringBuilder.append(this.f10391g);
                        throw new C2571p(stringBuilder.toString());
                    case 4:
                        this.f10388d.mo2175a(this.f10390f, (int) this.f10391g, c2304f);
                        this.f10389e = 0;
                        return true;
                    case 5:
                        if (this.f10391g != 4) {
                            if (this.f10391g != 8) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("Invalid float size: ");
                                stringBuilder.append(this.f10391g);
                                throw new C2571p(stringBuilder.toString());
                            }
                        }
                        this.f10388d.mo2174a(this.f10390f, m12829b(c2304f, (int) this.f10391g));
                        this.f10389e = 0;
                        return true;
                    default:
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Invalid element type ");
                        stringBuilder2.append(a2);
                        throw new C2571p(stringBuilder2.toString());
                }
            }
            this.f10388d.mo2180c(((C2262a) this.f10386b.pop()).f5391a);
            return true;
        }
    }

    /* renamed from: b */
    private long m12830b(C2304f c2304f) {
        c2304f.mo2183a();
        while (true) {
            c2304f.mo2191c(this.f10385a, 0, 4);
            int a = C2267f.m6264a(this.f10385a[0]);
            if (a != -1 && a <= 4) {
                int a2 = (int) C2267f.m6265a(this.f10385a, a, false);
                if (this.f10388d.mo2179b(a2)) {
                    c2304f.mo2186b(a);
                    return (long) a2;
                }
            }
            c2304f.mo2186b(1);
        }
    }

    /* renamed from: a */
    private long m12828a(C2304f c2304f, int i) {
        int i2 = 0;
        c2304f.mo2187b(this.f10385a, 0, i);
        long j = 0;
        while (i2 < i) {
            j = (j << 8) | ((long) (this.f10385a[i2] & JfifUtil.MARKER_FIRST_BYTE));
            i2++;
        }
        return j;
    }

    /* renamed from: b */
    private double m12829b(C2304f c2304f, int i) {
        long a = m12828a(c2304f, i);
        if (i == 4) {
            return (double) Float.intBitsToFloat((int) a);
        }
        return Double.longBitsToDouble(a);
    }

    /* renamed from: c */
    private String m12831c(C2304f c2304f, int i) {
        if (i == 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        c2304f.mo2187b(bArr, 0, i);
        return new String(bArr);
    }
}
