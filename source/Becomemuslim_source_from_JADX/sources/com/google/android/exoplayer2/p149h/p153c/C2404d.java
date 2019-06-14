package com.google.android.exoplayer2.p149h.p153c;

import android.net.Uri;
import android.os.SystemClock;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p149h.C2393b;
import com.google.android.exoplayer2.p149h.C2438p;
import com.google.android.exoplayer2.p149h.p150a.C2373h;
import com.google.android.exoplayer2.p149h.p150a.C4168c;
import com.google.android.exoplayer2.p149h.p150a.C4710j;
import com.google.android.exoplayer2.p149h.p153c.p154a.C4190a.C2394a;
import com.google.android.exoplayer2.p149h.p153c.p154a.C4191b;
import com.google.android.exoplayer2.p149h.p153c.p154a.C4191b.C2395a;
import com.google.android.exoplayer2.p149h.p153c.p154a.C4194e;
import com.google.android.exoplayer2.p162j.C2484f;
import com.google.android.exoplayer2.p162j.C4236b;
import com.google.android.exoplayer2.p163k.C2498g;
import com.google.android.exoplayer2.p163k.C2501j;
import com.google.android.exoplayer2.p164l.C2537s;
import com.google.android.exoplayer2.p164l.C2539u;
import com.google.android.exoplayer2.p164l.C2541v;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/* compiled from: HlsChunkSource */
/* renamed from: com.google.android.exoplayer2.h.c.d */
class C2404d {
    /* renamed from: a */
    private final C2406f f5917a;
    /* renamed from: b */
    private final C2498g f5918b;
    /* renamed from: c */
    private final C2498g f5919c;
    /* renamed from: d */
    private final C2409m f5920d;
    /* renamed from: e */
    private final C2394a[] f5921e;
    /* renamed from: f */
    private final C4194e f5922f;
    /* renamed from: g */
    private final C2438p f5923g;
    /* renamed from: h */
    private final List<C2515k> f5924h;
    /* renamed from: i */
    private boolean f5925i;
    /* renamed from: j */
    private byte[] f5926j;
    /* renamed from: k */
    private IOException f5927k;
    /* renamed from: l */
    private C2394a f5928l;
    /* renamed from: m */
    private boolean f5929m;
    /* renamed from: n */
    private Uri f5930n;
    /* renamed from: o */
    private byte[] f5931o;
    /* renamed from: p */
    private String f5932p;
    /* renamed from: q */
    private byte[] f5933q;
    /* renamed from: r */
    private C2484f f5934r;
    /* renamed from: s */
    private long f5935s = 1;

    /* compiled from: HlsChunkSource */
    /* renamed from: com.google.android.exoplayer2.h.c.d$b */
    public static final class C2403b {
        /* renamed from: a */
        public C4168c f5914a;
        /* renamed from: b */
        public boolean f5915b;
        /* renamed from: c */
        public C2394a f5916c;

        public C2403b() {
            m6611a();
        }

        /* renamed from: a */
        public void m6611a() {
            this.f5914a = null;
            this.f5915b = false;
            this.f5916c = null;
        }
    }

    /* compiled from: HlsChunkSource */
    /* renamed from: com.google.android.exoplayer2.h.c.d$c */
    private static final class C4717c extends C4236b {
        /* renamed from: d */
        private int f12766d;

        /* renamed from: b */
        public int mo3217b() {
            return 0;
        }

        /* renamed from: c */
        public Object mo3218c() {
            return null;
        }

        public C4717c(C2438p c2438p, int[] iArr) {
            super(c2438p, iArr);
            this.f12766d = mo2298a((C2515k) c2438p.m6712a((int) null));
        }

        /* renamed from: a */
        public void mo3216a(long j, long j2, long j3) {
            j = SystemClock.elapsedRealtime();
            if (m13733b(this.f12766d, j) != null) {
                j2 = this.b - 1;
                while (j2 >= null) {
                    if (m13733b(j2, j)) {
                        j2--;
                    } else {
                        this.f12766d = j2;
                        return;
                    }
                }
                throw new IllegalStateException();
            }
        }

        /* renamed from: a */
        public int mo3215a() {
            return this.f12766d;
        }
    }

    /* compiled from: HlsChunkSource */
    /* renamed from: com.google.android.exoplayer2.h.c.d$a */
    private static final class C4855a extends C4710j {
        /* renamed from: i */
        public final String f13829i;
        /* renamed from: j */
        private byte[] f13830j;

        public C4855a(C2498g c2498g, C2501j c2501j, C2515k c2515k, int i, Object obj, byte[] bArr, String str) {
            super(c2498g, c2501j, 3, c2515k, i, obj, bArr);
            this.f13829i = str;
        }

        /* renamed from: a */
        protected void mo3421a(byte[] bArr, int i) {
            this.f13830j = Arrays.copyOf(bArr, i);
        }

        /* renamed from: g */
        public byte[] mo3422g() {
            return this.f13830j;
        }
    }

    public C2404d(C2406f c2406f, C4194e c4194e, C2394a[] c2394aArr, C2405e c2405e, C2409m c2409m, List<C2515k> list) {
        this.f5917a = c2406f;
        this.f5922f = c4194e;
        this.f5921e = c2394aArr;
        this.f5920d = c2409m;
        this.f5924h = list;
        c2406f = new C2515k[c2394aArr.length];
        c4194e = new int[c2394aArr.length];
        for (c2409m = null; c2409m < c2394aArr.length; c2409m++) {
            c2406f[c2409m] = c2394aArr[c2409m].f5898b;
            c4194e[c2409m] = c2409m;
        }
        this.f5918b = c2405e.mo2271a(1);
        this.f5919c = c2405e.mo2271a(3);
        this.f5923g = new C2438p(c2406f);
        this.f5934r = new C4717c(this.f5923g, c4194e);
    }

    /* renamed from: a */
    public void m6617a() {
        if (this.f5927k != null) {
            throw this.f5927k;
        } else if (this.f5928l != null) {
            this.f5922f.m13506c(this.f5928l);
        }
    }

    /* renamed from: b */
    public C2438p m6624b() {
        return this.f5923g;
    }

    /* renamed from: a */
    public void m6621a(C2484f c2484f) {
        this.f5934r = c2484f;
    }

    /* renamed from: c */
    public C2484f m6625c() {
        return this.f5934r;
    }

    /* renamed from: d */
    public void m6626d() {
        this.f5927k = null;
    }

    /* renamed from: a */
    public void m6622a(boolean z) {
        this.f5925i = z;
    }

    /* renamed from: a */
    public void m6620a(C4856h c4856h, long j, long j2, C2403b c2403b) {
        int i;
        C2404d c2404d = this;
        C4856h c4856h2 = c4856h;
        long j3 = j;
        C2403b c2403b2 = c2403b;
        if (c4856h2 == null) {
            i = -1;
        } else {
            i = c2404d.f5923g.m6711a(c4856h2.c);
        }
        C2394a c2394a = null;
        c2404d.f5928l = null;
        long j4 = j2 - j3;
        long a = m6612a(j3);
        if (!(c4856h2 == null || c2404d.f5929m)) {
            long e = c4856h.m13261e();
            j4 = Math.max(0, j4 - e);
            if (a != -9223372036854775807L) {
                a = Math.max(0, a - e);
            }
        }
        c2404d.f5934r.mo3216a(j, j4, a);
        int i2 = c2404d.f5934r.mo2308i();
        boolean z = false;
        Object obj = i != i2 ? 1 : null;
        C2394a c2394a2 = c2404d.f5921e[i2];
        if (c2404d.f5922f.m13504b(c2394a2)) {
            int g;
            C2394a c2394a3;
            C4191b c4191b;
            int i3;
            C2395a c2395a;
            Uri a2;
            C2395a c2395a2;
            C2394a c2501j;
            C2394a c2394a4;
            long j5;
            long j6;
            int i4;
            C2537s a3;
            C2501j c2501j2;
            C2501j c2501j3;
            C4168c c4168c;
            C4168c c4856h3;
            long j7;
            List list;
            Object valueOf;
            C4191b a4 = c2404d.f5922f.m13495a(c2394a2);
            c2404d.f5929m = a4.f10919i;
            m6615a(a4);
            if (c4856h2 != null) {
                if (obj == null) {
                    g = c4856h.mo3525g();
                    i = i2;
                    c2394a3 = c2394a2;
                    c4191b = a4;
                    if (g >= c4191b.f10916f) {
                        c2404d.f5927k = new C2393b();
                        return;
                    }
                    i3 = g - c4191b.f10916f;
                    if (i3 < c4191b.f10924n.size()) {
                        if (c4191b.f10920j) {
                            c2403b2.f5916c = c2394a3;
                            c2404d.f5928l = c2394a3;
                        } else {
                            c2403b2.f5915b = true;
                        }
                        return;
                    }
                    c2395a = (C2395a) c4191b.f10924n.get(i3);
                    if (c2395a.f5903e == null) {
                        a2 = C2539u.m7158a(c4191b.p, c2395a.f5903e);
                        if (a2.equals(c2404d.f5930n)) {
                            c2403b2.f5914a = m6613a(a2, c2395a.f5904f, i, c2404d.f5934r.mo3217b(), c2404d.f5934r.mo3218c());
                            return;
                        } else if (!C2541v.m7179a(c2395a.f5904f, c2404d.f5932p)) {
                            m6614a(a2, c2395a.f5904f, c2404d.f5931o);
                        }
                    } else {
                        m6616e();
                    }
                    c2395a2 = c4191b.f10923m;
                    if (c2395a2 != null) {
                        c2501j = new C2501j(C2539u.m7158a(c4191b.p, c2395a2.f5899a), c2395a2.f5905g, c2395a2.f5906h, null);
                    }
                    c2394a4 = c2394a;
                    j5 = c4191b.f10913c + c2395a.f5902d;
                    j6 = j5;
                    i3 = c4191b.f10915e + c2395a.f5901c;
                    i4 = i3;
                    a3 = c2404d.f5920d.m6629a(i3);
                    c2501j2 = c2501j3;
                    c2501j3 = new C2501j(C2539u.m7158a(c4191b.p, c2395a.f5899a), c2395a.f5905g, c2395a.f5906h, null);
                    c4168c = c4856h3;
                    c4856h3 = new C4856h(c2404d.f5917a, c2404d.f5918b, c2501j2, c2394a4, c2394a3, c2404d.f5924h, c2404d.f5934r.mo3217b(), c2404d.f5934r.mo3218c(), j6, j5 + c2395a.f5900b, g, i4, c2404d.f5925i, a3, c4856h, c4191b.f10922l, c2404d.f5931o, c2404d.f5933q);
                    c2403b.f5914a = c4168c;
                    return;
                }
            }
            if (c4856h2 != null) {
                if (!c2404d.f5929m) {
                    j7 = c4856h2.f;
                    if (!a4.f10920j || j7 < a4.m13438a()) {
                        list = a4.f10924n;
                        valueOf = Long.valueOf(j7 - a4.f10913c);
                        if (!c2404d.f5922f.m13509e() || c4856h2 == null) {
                            z = true;
                        }
                        g = C2541v.m7165a(list, valueOf, true, z) + a4.f10916f;
                        if (g < a4.f10916f && c4856h2 != null) {
                            c2394a2 = c2404d.f5921e[i];
                            c4191b = c2404d.f5922f.m13495a(c2394a2);
                            g = c4856h.mo3525g();
                            a4 = c4191b;
                            i2 = i;
                        }
                        i = i2;
                        c2394a3 = c2394a2;
                        c4191b = a4;
                        if (g >= c4191b.f10916f) {
                            i3 = g - c4191b.f10916f;
                            if (i3 < c4191b.f10924n.size()) {
                                c2395a = (C2395a) c4191b.f10924n.get(i3);
                                if (c2395a.f5903e == null) {
                                    m6616e();
                                } else {
                                    a2 = C2539u.m7158a(c4191b.p, c2395a.f5903e);
                                    if (a2.equals(c2404d.f5930n)) {
                                        c2403b2.f5914a = m6613a(a2, c2395a.f5904f, i, c2404d.f5934r.mo3217b(), c2404d.f5934r.mo3218c());
                                        return;
                                    } else if (C2541v.m7179a(c2395a.f5904f, c2404d.f5932p)) {
                                        m6614a(a2, c2395a.f5904f, c2404d.f5931o);
                                    }
                                }
                                c2395a2 = c4191b.f10923m;
                                if (c2395a2 != null) {
                                    c2501j = new C2501j(C2539u.m7158a(c4191b.p, c2395a2.f5899a), c2395a2.f5905g, c2395a2.f5906h, null);
                                }
                                c2394a4 = c2394a;
                                j5 = c4191b.f10913c + c2395a.f5902d;
                                j6 = j5;
                                i3 = c4191b.f10915e + c2395a.f5901c;
                                i4 = i3;
                                a3 = c2404d.f5920d.m6629a(i3);
                                c2501j2 = c2501j3;
                                c2501j3 = new C2501j(C2539u.m7158a(c4191b.p, c2395a.f5899a), c2395a.f5905g, c2395a.f5906h, null);
                                c4168c = c4856h3;
                                c4856h3 = new C4856h(c2404d.f5917a, c2404d.f5918b, c2501j2, c2394a4, c2394a3, c2404d.f5924h, c2404d.f5934r.mo3217b(), c2404d.f5934r.mo3218c(), j6, j5 + c2395a.f5900b, g, i4, c2404d.f5925i, a3, c4856h, c4191b.f10922l, c2404d.f5931o, c2404d.f5933q);
                                c2403b.f5914a = c4168c;
                                return;
                            }
                            if (c4191b.f10920j) {
                                c2403b2.f5916c = c2394a3;
                                c2404d.f5928l = c2394a3;
                            } else {
                                c2403b2.f5915b = true;
                            }
                            return;
                        }
                        c2404d.f5927k = new C2393b();
                        return;
                    }
                    g = a4.f10916f + a4.f10924n.size();
                    i = i2;
                    c2394a3 = c2394a2;
                    c4191b = a4;
                    if (g >= c4191b.f10916f) {
                        c2404d.f5927k = new C2393b();
                        return;
                    }
                    i3 = g - c4191b.f10916f;
                    if (i3 < c4191b.f10924n.size()) {
                        if (c4191b.f10920j) {
                            c2403b2.f5915b = true;
                        } else {
                            c2403b2.f5916c = c2394a3;
                            c2404d.f5928l = c2394a3;
                        }
                        return;
                    }
                    c2395a = (C2395a) c4191b.f10924n.get(i3);
                    if (c2395a.f5903e == null) {
                        a2 = C2539u.m7158a(c4191b.p, c2395a.f5903e);
                        if (a2.equals(c2404d.f5930n)) {
                            c2403b2.f5914a = m6613a(a2, c2395a.f5904f, i, c2404d.f5934r.mo3217b(), c2404d.f5934r.mo3218c());
                            return;
                        } else if (C2541v.m7179a(c2395a.f5904f, c2404d.f5932p)) {
                            m6614a(a2, c2395a.f5904f, c2404d.f5931o);
                        }
                    } else {
                        m6616e();
                    }
                    c2395a2 = c4191b.f10923m;
                    if (c2395a2 != null) {
                        c2501j = new C2501j(C2539u.m7158a(c4191b.p, c2395a2.f5899a), c2395a2.f5905g, c2395a2.f5906h, null);
                    }
                    c2394a4 = c2394a;
                    j5 = c4191b.f10913c + c2395a.f5902d;
                    j6 = j5;
                    i3 = c4191b.f10915e + c2395a.f5901c;
                    i4 = i3;
                    a3 = c2404d.f5920d.m6629a(i3);
                    c2501j2 = c2501j3;
                    c2501j3 = new C2501j(C2539u.m7158a(c4191b.p, c2395a.f5899a), c2395a.f5905g, c2395a.f5906h, null);
                    c4168c = c4856h3;
                    c4856h3 = new C4856h(c2404d.f5917a, c2404d.f5918b, c2501j2, c2394a4, c2394a3, c2404d.f5924h, c2404d.f5934r.mo3217b(), c2404d.f5934r.mo3218c(), j6, j5 + c2395a.f5900b, g, i4, c2404d.f5925i, a3, c4856h, c4191b.f10922l, c2404d.f5931o, c2404d.f5933q);
                    c2403b.f5914a = c4168c;
                    return;
                }
            }
            j7 = j2;
            if (a4.f10920j) {
            }
            list = a4.f10924n;
            valueOf = Long.valueOf(j7 - a4.f10913c);
            z = true;
            g = C2541v.m7165a(list, valueOf, true, z) + a4.f10916f;
            c2394a2 = c2404d.f5921e[i];
            c4191b = c2404d.f5922f.m13495a(c2394a2);
            g = c4856h.mo3525g();
            a4 = c4191b;
            i2 = i;
            i = i2;
            c2394a3 = c2394a2;
            c4191b = a4;
            if (g >= c4191b.f10916f) {
                i3 = g - c4191b.f10916f;
                if (i3 < c4191b.f10924n.size()) {
                    c2395a = (C2395a) c4191b.f10924n.get(i3);
                    if (c2395a.f5903e == null) {
                        m6616e();
                    } else {
                        a2 = C2539u.m7158a(c4191b.p, c2395a.f5903e);
                        if (a2.equals(c2404d.f5930n)) {
                            c2403b2.f5914a = m6613a(a2, c2395a.f5904f, i, c2404d.f5934r.mo3217b(), c2404d.f5934r.mo3218c());
                            return;
                        } else if (C2541v.m7179a(c2395a.f5904f, c2404d.f5932p)) {
                            m6614a(a2, c2395a.f5904f, c2404d.f5931o);
                        }
                    }
                    c2395a2 = c4191b.f10923m;
                    if (c2395a2 != null) {
                        c2501j = new C2501j(C2539u.m7158a(c4191b.p, c2395a2.f5899a), c2395a2.f5905g, c2395a2.f5906h, null);
                    }
                    c2394a4 = c2394a;
                    j5 = c4191b.f10913c + c2395a.f5902d;
                    j6 = j5;
                    i3 = c4191b.f10915e + c2395a.f5901c;
                    i4 = i3;
                    a3 = c2404d.f5920d.m6629a(i3);
                    c2501j2 = c2501j3;
                    c2501j3 = new C2501j(C2539u.m7158a(c4191b.p, c2395a.f5899a), c2395a.f5905g, c2395a.f5906h, null);
                    c4168c = c4856h3;
                    c4856h3 = new C4856h(c2404d.f5917a, c2404d.f5918b, c2501j2, c2394a4, c2394a3, c2404d.f5924h, c2404d.f5934r.mo3217b(), c2404d.f5934r.mo3218c(), j6, j5 + c2395a.f5900b, g, i4, c2404d.f5925i, a3, c4856h, c4191b.f10922l, c2404d.f5931o, c2404d.f5933q);
                    c2403b.f5914a = c4168c;
                    return;
                }
                if (c4191b.f10920j) {
                    c2403b2.f5916c = c2394a3;
                    c2404d.f5928l = c2394a3;
                } else {
                    c2403b2.f5915b = true;
                }
                return;
            }
            c2404d.f5927k = new C2393b();
            return;
        }
        c2403b2.f5916c = c2394a2;
        c2404d.f5928l = c2394a2;
    }

    /* renamed from: a */
    public void m6618a(C4168c c4168c) {
        if (c4168c instanceof C4855a) {
            C4855a c4855a = (C4855a) c4168c;
            this.f5926j = c4855a.m16061d();
            m6614a(c4855a.a.f6349a, c4855a.f13829i, c4855a.mo3422g());
        }
    }

    /* renamed from: a */
    public boolean m6623a(C4168c c4168c, boolean z, IOException iOException) {
        return (!z || C2373h.m6564a(this.f5934r, this.f5934r.mo2302c(this.f5923g.m6711a(c4168c.f10806c)), iOException) == null) ? null : true;
    }

    /* renamed from: a */
    public void m6619a(C2394a c2394a, long j) {
        c2394a = this.f5923g.m6711a(c2394a.f5898b);
        if (c2394a != -1) {
            c2394a = this.f5934r.mo2302c(c2394a);
            if (c2394a != -1) {
                this.f5934r.mo2300a(c2394a, j);
            }
        }
    }

    /* renamed from: a */
    private long m6612a(long j) {
        if ((this.f5935s != -9223372036854775807L ? 1 : null) != null) {
            return this.f5935s - j;
        }
        return -9223372036854775807L;
    }

    /* renamed from: a */
    private void m6615a(C4191b c4191b) {
        this.f5935s = c4191b.f10920j ? -9223372036854775807L : c4191b.m13438a();
    }

    /* renamed from: a */
    private C4855a m6613a(Uri uri, String str, int i, int i2, Object obj) {
        return new C4855a(this.f5919c, new C2501j(uri, 0, -1, null, 1), this.f5921e[i].f5898b, i2, obj, this.f5926j, str);
    }

    /* renamed from: a */
    private void m6614a(Uri uri, String str, byte[] bArr) {
        Object toByteArray = new BigInteger(C2541v.m7190d(str).startsWith("0x") ? str.substring(2) : str, 16).toByteArray();
        Object obj = new byte[16];
        int length = toByteArray.length > 16 ? toByteArray.length - 16 : 0;
        System.arraycopy(toByteArray, length, obj, (obj.length - toByteArray.length) + length, toByteArray.length - length);
        this.f5930n = uri;
        this.f5931o = bArr;
        this.f5932p = str;
        this.f5933q = obj;
    }

    /* renamed from: e */
    private void m6616e() {
        this.f5930n = null;
        this.f5931o = null;
        this.f5932p = null;
        this.f5933q = null;
    }
}
