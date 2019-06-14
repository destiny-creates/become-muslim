package com.google.android.exoplayer2.p137e.p141e;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.p141e.C2295h.C2294a;
import com.google.android.exoplayer2.p137e.p141e.C2302k.C2299b;
import com.google.android.exoplayer2.p137e.p141e.C2302k.C2300c;
import com.google.android.exoplayer2.p137e.p141e.C2302k.C2301d;
import com.google.android.exoplayer2.p164l.C2529l;
import java.util.ArrayList;
import java.util.List;

/* compiled from: VorbisReader */
/* renamed from: com.google.android.exoplayer2.e.e.j */
final class C4124j extends C2295h {
    /* renamed from: a */
    private C2297a f10565a;
    /* renamed from: b */
    private int f10566b;
    /* renamed from: c */
    private boolean f10567c;
    /* renamed from: d */
    private C2301d f10568d;
    /* renamed from: e */
    private C2299b f10569e;

    /* compiled from: VorbisReader */
    /* renamed from: com.google.android.exoplayer2.e.e.j$a */
    static final class C2297a {
        /* renamed from: a */
        public final C2301d f5650a;
        /* renamed from: b */
        public final C2299b f5651b;
        /* renamed from: c */
        public final byte[] f5652c;
        /* renamed from: d */
        public final C2300c[] f5653d;
        /* renamed from: e */
        public final int f5654e;

        public C2297a(C2301d c2301d, C2299b c2299b, byte[] bArr, C2300c[] c2300cArr, int i) {
            this.f5650a = c2301d;
            this.f5651b = c2299b;
            this.f5652c = bArr;
            this.f5653d = c2300cArr;
            this.f5654e = i;
        }
    }

    /* renamed from: a */
    static int m13030a(byte b, int i, int i2) {
        return (b >> i2) & (JfifUtil.MARKER_FIRST_BYTE >>> (8 - i));
    }

    C4124j() {
    }

    /* renamed from: a */
    public static boolean m13033a(com.google.android.exoplayer2.p164l.C2529l r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = 1;
        r1 = com.google.android.exoplayer2.p137e.p141e.C2302k.m6364a(r0, r1, r0);	 Catch:{ p -> 0x0006 }
        return r1;
    L_0x0006:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.e.j.a(com.google.android.exoplayer2.l.l):boolean");
    }

    /* renamed from: a */
    protected void mo2204a(boolean z) {
        super.mo2204a(z);
        if (z) {
            this.f10565a = null;
            this.f10568d = null;
            this.f10569e = null;
        }
        this.f10566b = 0;
        this.f10567c = false;
    }

    /* renamed from: c */
    protected void mo2207c(long j) {
        super.mo2207c(j);
        int i = 0;
        this.f10567c = j != 0 ? 1 : null;
        if (this.f10568d != null) {
            i = this.f10568d.f5673g;
        }
        this.f10566b = i;
    }

    /* renamed from: b */
    protected long mo2206b(C2529l c2529l) {
        int i = 0;
        if ((c2529l.f6441a[0] & 1) == 1) {
            return -1;
        }
        int a = C4124j.m13031a(c2529l.f6441a[0], this.f10565a);
        if (this.f10567c) {
            i = (this.f10566b + a) / 4;
        }
        long j = (long) i;
        C4124j.m13032a(c2529l, j);
        this.f10567c = true;
        this.f10566b = a;
        return j;
    }

    /* renamed from: a */
    protected boolean mo2205a(C2529l c2529l, long j, C2294a c2294a) {
        if (this.f10565a != null) {
            return null;
        }
        this.f10565a = m13037c(c2529l);
        if (this.f10565a == null) {
            return true;
        }
        List arrayList = new ArrayList();
        arrayList.add(this.f10565a.f5650a.f5676j);
        arrayList.add(this.f10565a.f5652c);
        c2294a.f5631a = C2515k.m6988a(null, "audio/vorbis", null, this.f10565a.f5650a.f5671e, -1, this.f10565a.f5650a.f5668b, (int) this.f10565a.f5650a.f5669c, arrayList, null, 0, null);
        return true;
    }

    /* renamed from: c */
    C2297a m13037c(C2529l c2529l) {
        if (this.f10568d == null) {
            this.f10568d = C2302k.m6362a(c2529l);
            return null;
        } else if (this.f10569e == null) {
            this.f10569e = C2302k.m6367b(c2529l);
            return null;
        } else {
            Object obj = new byte[c2529l.m7095c()];
            System.arraycopy(c2529l.f6441a, 0, obj, 0, c2529l.m7095c());
            C2300c[] a = C2302k.m6366a(c2529l, this.f10568d.f5668b);
            return new C2297a(this.f10568d, this.f10569e, obj, a, C2302k.m6360a(a.length - 1));
        }
    }

    /* renamed from: a */
    static void m13032a(C2529l c2529l, long j) {
        c2529l.m7094b(c2529l.m7095c() + 4);
        c2529l.f6441a[c2529l.m7095c() - 4] = (byte) ((int) (j & 255));
        c2529l.f6441a[c2529l.m7095c() - 3] = (byte) ((int) ((j >>> 8) & 255));
        c2529l.f6441a[c2529l.m7095c() - 2] = (byte) ((int) ((j >>> 16) & 255));
        c2529l.f6441a[c2529l.m7095c() - 1] = (byte) ((int) ((j >>> 24) & 255));
    }

    /* renamed from: a */
    private static int m13031a(byte b, C2297a c2297a) {
        if (c2297a.f5653d[C4124j.m13030a(b, c2297a.f5654e, 1)].f5663a == (byte) 0) {
            return c2297a.f5650a.f5673g;
        }
        return c2297a.f5650a.f5674h;
    }
}
