package com.google.android.exoplayer2.p144f;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.exoplayer2.C2330e;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.C2543l;
import com.google.android.exoplayer2.C4690a;
import com.google.android.exoplayer2.p135b.C2249d;
import com.google.android.exoplayer2.p135b.C4085e;
import com.google.android.exoplayer2.p136c.C2257b;
import com.google.android.exoplayer2.p136c.C2258c;
import com.google.android.exoplayer2.p136c.C4088e;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2527j;
import com.google.android.exoplayer2.p164l.C2538t;
import com.google.android.exoplayer2.p164l.C2541v;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
/* compiled from: MediaCodecRenderer */
/* renamed from: com.google.android.exoplayer2.f.b */
public abstract class C4852b extends C4690a {
    /* renamed from: b */
    private static final byte[] f13777b = C2541v.m7194h("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    /* renamed from: A */
    private long f13778A;
    /* renamed from: B */
    private int f13779B;
    /* renamed from: C */
    private int f13780C;
    /* renamed from: D */
    private boolean f13781D;
    /* renamed from: E */
    private boolean f13782E;
    /* renamed from: F */
    private int f13783F;
    /* renamed from: G */
    private int f13784G;
    /* renamed from: H */
    private boolean f13785H;
    /* renamed from: I */
    private boolean f13786I;
    /* renamed from: J */
    private boolean f13787J;
    /* renamed from: K */
    private boolean f13788K;
    /* renamed from: L */
    private boolean f13789L;
    /* renamed from: M */
    private boolean f13790M;
    /* renamed from: a */
    protected C2249d f13791a;
    /* renamed from: c */
    private final C2335c f13792c;
    /* renamed from: d */
    private final C2258c<C4088e> f13793d;
    /* renamed from: e */
    private final boolean f13794e;
    /* renamed from: f */
    private final C4085e f13795f;
    /* renamed from: g */
    private final C4085e f13796g;
    /* renamed from: h */
    private final C2543l f13797h;
    /* renamed from: i */
    private final List<Long> f13798i;
    /* renamed from: j */
    private final BufferInfo f13799j;
    /* renamed from: k */
    private C2515k f13800k;
    /* renamed from: l */
    private C2257b<C4088e> f13801l;
    /* renamed from: m */
    private C2257b<C4088e> f13802m;
    /* renamed from: n */
    private MediaCodec f13803n;
    /* renamed from: o */
    private C2333a f13804o;
    /* renamed from: p */
    private int f13805p;
    /* renamed from: q */
    private boolean f13806q;
    /* renamed from: r */
    private boolean f13807r;
    /* renamed from: s */
    private boolean f13808s;
    /* renamed from: t */
    private boolean f13809t;
    /* renamed from: u */
    private boolean f13810u;
    /* renamed from: v */
    private boolean f13811v;
    /* renamed from: w */
    private boolean f13812w;
    /* renamed from: x */
    private boolean f13813x;
    /* renamed from: y */
    private ByteBuffer[] f13814y;
    /* renamed from: z */
    private ByteBuffer[] f13815z;

    /* compiled from: MediaCodecRenderer */
    /* renamed from: com.google.android.exoplayer2.f.b$a */
    public static class C2334a extends Exception {
        /* renamed from: a */
        public final String f5792a;
        /* renamed from: b */
        public final boolean f5793b;
        /* renamed from: c */
        public final String f5794c;
        /* renamed from: d */
        public final String f5795d;

        public C2334a(C2515k c2515k, Throwable th, boolean z, int i) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Decoder init failed: [");
            stringBuilder.append(i);
            stringBuilder.append("], ");
            stringBuilder.append(c2515k);
            super(stringBuilder.toString(), th);
            this.f5792a = c2515k.f6380f;
            this.f5793b = z;
            this.f5794c = null;
            this.f5795d = C2334a.m6480a(i);
        }

        public C2334a(C2515k c2515k, Throwable th, boolean z, String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Decoder init failed: ");
            stringBuilder.append(str);
            stringBuilder.append(", ");
            stringBuilder.append(c2515k);
            super(stringBuilder.toString(), th);
            this.f5792a = c2515k.f6380f;
            this.f5793b = z;
            this.f5794c = str;
            this.f5795d = C2541v.f6467a >= true ? C2334a.m6481a(th) : null;
        }

        @TargetApi(21)
        /* renamed from: a */
        private static String m6481a(Throwable th) {
            return th instanceof CodecException ? ((CodecException) th).getDiagnosticInfo() : null;
        }

        /* renamed from: a */
        private static String m6480a(int i) {
            String str = i < 0 ? "neg_" : "";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("com.google.android.exoplayer.MediaCodecTrackRenderer_");
            stringBuilder.append(str);
            stringBuilder.append(Math.abs(i));
            return stringBuilder.toString();
        }
    }

    /* renamed from: E */
    protected long m17257E() {
        return 0;
    }

    /* renamed from: a */
    protected abstract int mo3515a(C2335c c2335c, C2258c<C4088e> c2258c, C2515k c2515k);

    /* renamed from: a */
    protected void mo3517a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    /* renamed from: a */
    protected void mo3528a(C4085e c4085e) {
    }

    /* renamed from: a */
    protected abstract void mo3518a(C2333a c2333a, MediaCodec mediaCodec, C2515k c2515k, MediaCrypto mediaCrypto);

    /* renamed from: a */
    protected void mo3519a(String str, long j, long j2) {
    }

    /* renamed from: a */
    protected abstract boolean mo3520a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z);

    /* renamed from: a */
    protected boolean mo3529a(MediaCodec mediaCodec, boolean z, C2515k c2515k, C2515k c2515k2) {
        return false;
    }

    /* renamed from: a */
    protected boolean mo3530a(C2333a c2333a) {
        return true;
    }

    /* renamed from: c */
    protected void mo3532c(long j) {
    }

    /* renamed from: m */
    public final int mo3194m() {
        return 8;
    }

    /* renamed from: n */
    protected void mo3415n() {
    }

    /* renamed from: o */
    protected void mo3416o() {
    }

    /* renamed from: y */
    protected void mo3524y() {
    }

    public C4852b(int i, C2335c c2335c, C2258c<C4088e> c2258c, boolean z) {
        super(i);
        C2516a.m7019b(C2541v.f6467a >= 16 ? 1 : 0);
        this.f13792c = (C2335c) C2516a.m7015a((Object) c2335c);
        this.f13793d = c2258c;
        this.f13794e = z;
        this.f13795f = new C4085e(0);
        this.f13796g = C4085e.m12750e();
        this.f13797h = new C2543l();
        this.f13798i = new ArrayList();
        this.f13799j = new BufferInfo();
        this.f13783F = 0;
        this.f13784G = 0;
    }

    /* renamed from: a */
    public final int mo3411a(C2515k c2515k) {
        try {
            return mo3515a(this.f13792c, this.f13793d, c2515k);
        } catch (C2515k c2515k2) {
            throw C2330e.m6459a(c2515k2, m16026r());
        }
    }

    /* renamed from: a */
    protected C2333a mo3516a(C2335c c2335c, C2515k c2515k, boolean z) {
        return c2335c.mo2222a(c2515k.f6380f, z);
    }

    /* renamed from: z */
    protected final void m17280z() {
        if (this.f13803n == null) {
            if (this.f13800k != null) {
                MediaCrypto a;
                boolean a2;
                StringBuilder stringBuilder;
                this.f13801l = this.f13802m;
                String str = this.f13800k.f6380f;
                if (this.f13801l != null) {
                    C4088e c4088e = (C4088e) this.f13801l.m6236c();
                    if (c4088e == null) {
                        Exception b = this.f13801l.m6235b();
                        if (b != null) {
                            throw C2330e.m6459a(b, m16026r());
                        }
                        return;
                    }
                    a = c4088e.m12778a();
                    a2 = c4088e.m12779a(str);
                } else {
                    a = null;
                    a2 = false;
                }
                if (this.f13804o == null) {
                    try {
                        this.f13804o = mo3516a(this.f13792c, this.f13800k, a2);
                        if (this.f13804o == null && a2) {
                            this.f13804o = mo3516a(this.f13792c, this.f13800k, false);
                            if (this.f13804o != null) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("Drm session requires secure decoder for ");
                                stringBuilder.append(str);
                                stringBuilder.append(", but ");
                                stringBuilder.append("no secure decoder available. Trying to proceed with ");
                                stringBuilder.append(this.f13804o.f5786a);
                                stringBuilder.append(".");
                                Log.w("MediaCodecRenderer", stringBuilder.toString());
                            }
                        }
                    } catch (Throwable e) {
                        m17239a(new C2334a(this.f13800k, e, a2, -49998));
                    }
                    if (this.f13804o == null) {
                        m17239a(new C2334a(this.f13800k, null, a2, -49999));
                    }
                }
                if (mo3530a(this.f13804o)) {
                    str = this.f13804o.f5786a;
                    this.f13805p = m17242b(str);
                    this.f13806q = C4852b.m17241a(str, this.f13800k);
                    this.f13807r = C4852b.mo3521a(str);
                    this.f13808s = C4852b.m17246c(str);
                    this.f13809t = C4852b.m17248d(str);
                    this.f13810u = C4852b.m17249e(str);
                    this.f13811v = C4852b.m17244b(str, this.f13800k);
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("createCodec:");
                        stringBuilder.append(str);
                        C2538t.m7155a(stringBuilder.toString());
                        this.f13803n = MediaCodec.createByCodecName(str);
                        C2538t.m7154a();
                        C2538t.m7155a("configureCodec");
                        mo3518a(this.f13804o, this.f13803n, this.f13800k, a);
                        C2538t.m7154a();
                        C2538t.m7155a("startCodec");
                        this.f13803n.start();
                        C2538t.m7154a();
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        mo3519a(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                        this.f13814y = this.f13803n.getInputBuffers();
                        this.f13815z = this.f13803n.getOutputBuffers();
                    } catch (Throwable e2) {
                        m17239a(new C2334a(this.f13800k, e2, a2, str));
                    }
                    this.f13778A = mo3185d() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                    this.f13779B = -1;
                    this.f13780C = -1;
                    this.f13790M = true;
                    C2249d c2249d = this.f13791a;
                    c2249d.f5365a++;
                }
            }
        }
    }

    /* renamed from: a */
    private void m17239a(C2334a c2334a) {
        throw C2330e.m6459a(c2334a, m16026r());
    }

    /* renamed from: A */
    protected final MediaCodec m17253A() {
        return this.f13803n;
    }

    /* renamed from: B */
    protected final C2333a m17254B() {
        return this.f13804o;
    }

    /* renamed from: a */
    protected void mo3414a(boolean z) {
        this.f13791a = new C2249d();
    }

    /* renamed from: a */
    protected void mo3413a(long j, boolean z) {
        this.f13787J = false;
        this.f13788K = false;
        if (this.f13803n != null) {
            mo3527D();
        }
    }

    /* renamed from: p */
    protected void mo3417p() {
        this.f13800k = null;
        try {
            mo3526C();
            try {
                if (this.f13801l != null) {
                    this.f13793d.m6238a(this.f13801l);
                }
                try {
                    if (!(this.f13802m == null || this.f13802m == this.f13801l)) {
                        this.f13793d.m6238a(this.f13802m);
                    }
                    this.f13801l = null;
                    this.f13802m = null;
                } catch (Throwable th) {
                    this.f13801l = null;
                    this.f13802m = null;
                }
            } catch (Throwable th2) {
                this.f13801l = null;
                this.f13802m = null;
            }
        } catch (Throwable th3) {
            this.f13801l = null;
            this.f13802m = null;
        }
    }

    /* renamed from: C */
    protected void mo3526C() {
        this.f13778A = -9223372036854775807L;
        this.f13779B = -1;
        this.f13780C = -1;
        this.f13789L = false;
        this.f13781D = false;
        this.f13798i.clear();
        this.f13814y = null;
        this.f13815z = null;
        this.f13804o = null;
        this.f13782E = false;
        this.f13785H = false;
        this.f13806q = false;
        this.f13807r = false;
        this.f13805p = 0;
        this.f13808s = false;
        this.f13809t = false;
        this.f13811v = false;
        this.f13812w = false;
        this.f13813x = false;
        this.f13786I = false;
        this.f13783F = 0;
        this.f13784G = 0;
        this.f13795f.f10318b = null;
        if (this.f13803n != null) {
            C2249d c2249d = this.f13791a;
            c2249d.f5366b++;
            try {
                this.f13803n.stop();
                try {
                    this.f13803n.release();
                    this.f13803n = null;
                    if (this.f13801l != null && this.f13802m != this.f13801l) {
                        try {
                            this.f13793d.m6238a(this.f13801l);
                        } finally {
                            this.f13801l = null;
                        }
                    }
                } catch (Throwable th) {
                    this.f13803n = null;
                    if (!(this.f13801l == null || this.f13802m == this.f13801l)) {
                        this.f13793d.m6238a(this.f13801l);
                    }
                } finally {
                    this.f13801l = null;
                }
            } catch (Throwable th2) {
                this.f13803n = null;
                if (!(this.f13801l == null || this.f13802m == this.f13801l)) {
                    try {
                        this.f13793d.m6238a(this.f13801l);
                    } finally {
                        this.f13801l = null;
                    }
                }
            } finally {
                this.f13801l = null;
            }
        }
    }

    /* renamed from: a */
    public void mo3412a(long j, long j2) {
        if (this.f13788K) {
            mo3524y();
            return;
        }
        if (this.f13800k == null) {
            this.f13796g.mo2145a();
            int a = m16000a(this.f13797h, this.f13796g, true);
            if (a == -5) {
                mo3522b(this.f13797h.f6476a);
            } else if (a == -4) {
                C2516a.m7019b(this.f13796g.m6206c());
                this.f13787J = true;
                m17237F();
                return;
            } else {
                return;
            }
        }
        m17280z();
        if (this.f13803n != null) {
            C2538t.m7155a("drainAndFeed");
            while (mo3531b(j, j2)) {
            }
            while (mo3523v() != null) {
            }
            C2538t.m7154a();
        } else {
            j2 = this.f13791a;
            j2.f5368d += m16009b(j);
            this.f13796g.mo2145a();
            j = m16000a((C2543l) this.f13797h, this.f13796g, (boolean) 0);
            if (j == -5) {
                mo3522b(this.f13797h.f6476a);
            } else if (j == -4) {
                C2516a.m7019b(this.f13796g.m6206c());
                this.f13787J = true;
                m17237F();
            }
        }
        this.f13791a.m6220a();
    }

    /* renamed from: D */
    protected void mo3527D() {
        this.f13778A = -9223372036854775807L;
        this.f13779B = -1;
        this.f13780C = -1;
        this.f13790M = true;
        this.f13789L = false;
        this.f13781D = false;
        this.f13798i.clear();
        this.f13812w = false;
        this.f13813x = false;
        if (!this.f13807r) {
            if (!this.f13809t || !this.f13786I) {
                if (this.f13784G != 0) {
                    mo3526C();
                    m17280z();
                } else {
                    this.f13803n.flush();
                    this.f13785H = false;
                }
                if (this.f13782E && this.f13800k != null) {
                    this.f13783F = 1;
                    return;
                }
            }
        }
        mo3526C();
        m17280z();
        if (this.f13782E) {
        }
    }

    /* renamed from: v */
    private boolean mo3523v() {
        if (!(this.f13803n == null || this.f13784G == 2)) {
            if (!this.f13787J) {
                if (this.f13779B < 0) {
                    this.f13779B = this.f13803n.dequeueInputBuffer(0);
                    if (this.f13779B < 0) {
                        return false;
                    }
                    this.f13795f.f10318b = this.f13814y[this.f13779B];
                    this.f13795f.mo2145a();
                }
                if (this.f13784G == 1) {
                    if (!this.f13808s) {
                        this.f13786I = true;
                        this.f13803n.queueInputBuffer(this.f13779B, 0, 0, 0, 4);
                        this.f13779B = -1;
                    }
                    this.f13784G = 2;
                    return false;
                } else if (this.f13812w) {
                    this.f13812w = false;
                    this.f13795f.f10318b.put(f13777b);
                    this.f13803n.queueInputBuffer(this.f13779B, 0, f13777b.length, 0, 0);
                    this.f13779B = -1;
                    this.f13785H = true;
                    return true;
                } else {
                    int i;
                    int i2;
                    if (this.f13789L) {
                        i = -4;
                        i2 = 0;
                    } else {
                        if (this.f13783F == 1) {
                            for (i = 0; i < this.f13800k.f6382h.size(); i++) {
                                this.f13795f.f10318b.put((byte[]) this.f13800k.f6382h.get(i));
                            }
                            this.f13783F = 2;
                        }
                        i = this.f13795f.f10318b.position();
                        i2 = i;
                        i = m16000a(this.f13797h, this.f13795f, false);
                    }
                    if (i == -3) {
                        return false;
                    }
                    if (i == -5) {
                        if (this.f13783F == 2) {
                            this.f13795f.mo2145a();
                            this.f13783F = 1;
                        }
                        mo3522b(this.f13797h.f6476a);
                        return true;
                    } else if (this.f13795f.m6206c()) {
                        if (this.f13783F == 2) {
                            this.f13795f.mo2145a();
                            this.f13783F = 1;
                        }
                        this.f13787J = true;
                        if (this.f13785H) {
                            try {
                                if (!this.f13808s) {
                                    this.f13786I = true;
                                    this.f13803n.queueInputBuffer(this.f13779B, 0, 0, 0, 4);
                                    this.f13779B = -1;
                                }
                                return false;
                            } catch (Exception e) {
                                throw C2330e.m6459a(e, m16026r());
                            }
                        }
                        m17237F();
                        return false;
                    } else if (!this.f13790M || this.f13795f.m6207d()) {
                        this.f13790M = false;
                        boolean g = this.f13795f.m12755g();
                        this.f13789L = m17245b(g);
                        if (this.f13789L) {
                            return false;
                        }
                        if (this.f13806q && !g) {
                            C2527j.m7064a(this.f13795f.f10318b);
                            if (this.f13795f.f10318b.position() == 0) {
                                return true;
                            }
                            this.f13806q = false;
                        }
                        try {
                            long j = this.f13795f.f10319c;
                            if (this.f13795f.g_()) {
                                this.f13798i.add(Long.valueOf(j));
                            }
                            this.f13795f.m12756h();
                            mo3528a(this.f13795f);
                            if (g) {
                                this.f13803n.queueSecureInputBuffer(this.f13779B, 0, C4852b.m17238a(this.f13795f, i2), j, 0);
                            } else {
                                this.f13803n.queueInputBuffer(this.f13779B, 0, this.f13795f.f10318b.limit(), j, 0);
                            }
                            this.f13779B = -1;
                            this.f13785H = true;
                            this.f13783F = 0;
                            C2249d c2249d = this.f13791a;
                            c2249d.f5367c++;
                            return true;
                        } catch (Exception e2) {
                            throw C2330e.m6459a(e2, m16026r());
                        }
                    } else {
                        this.f13795f.mo2145a();
                        if (this.f13783F == 2) {
                            this.f13783F = 1;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private static CryptoInfo m17238a(C4085e c4085e, int i) {
        c4085e = c4085e.f10317a.m6213a();
        if (i == 0) {
            return c4085e;
        }
        if (c4085e.numBytesOfClearData == null) {
            c4085e.numBytesOfClearData = new int[1];
        }
        int[] iArr = c4085e.numBytesOfClearData;
        iArr[0] = iArr[0] + i;
        return c4085e;
    }

    /* renamed from: b */
    private boolean m17245b(boolean z) {
        if (this.f13801l != null) {
            if (z || !this.f13794e) {
                z = this.f13801l.m6234a();
                boolean z2 = true;
                if (!z) {
                    if (z) {
                        z2 = false;
                    }
                    return z2;
                }
                throw C2330e.m6459a(this.f13801l.m6235b(), m16026r());
            }
        }
        return false;
    }

    /* renamed from: b */
    protected void mo3522b(C2515k c2515k) {
        C2515k c2515k2 = this.f13800k;
        this.f13800k = c2515k;
        boolean z = true;
        if ((C2541v.m7179a(this.f13800k.f6383i, c2515k2 == null ? null : c2515k2.f6383i) ^ 1) != null) {
            if (this.f13800k.f6383i == null) {
                this.f13802m = null;
            } else if (this.f13793d != null) {
                this.f13802m = this.f13793d.m6237a(Looper.myLooper(), this.f13800k.f6383i);
                if (this.f13802m == this.f13801l) {
                    this.f13793d.m6238a(this.f13802m);
                }
            } else {
                throw C2330e.m6459a(new IllegalStateException("Media requires a DrmSessionManager"), m16026r());
            }
        }
        if (this.f13802m == this.f13801l && this.f13803n != null && mo3529a(this.f13803n, this.f13804o.f5787b, c2515k2, this.f13800k) != null) {
            this.f13782E = true;
            this.f13783F = 1;
            if (this.f13805p != 2) {
                if (this.f13805p != 1 || this.f13800k.f6384j != c2515k2.f6384j || this.f13800k.f6385k != c2515k2.f6385k) {
                    z = false;
                }
            }
            this.f13812w = z;
        } else if (this.f13785H != null) {
            this.f13784G = 1;
        } else {
            mo3526C();
            m17280z();
        }
    }

    /* renamed from: u */
    public boolean mo3419u() {
        return this.f13788K;
    }

    /* renamed from: t */
    public boolean mo3418t() {
        return (this.f13800k == null || this.f13789L || (!m16027s() && this.f13780C < 0 && (this.f13778A == -9223372036854775807L || SystemClock.elapsedRealtime() >= this.f13778A))) ? false : true;
    }

    /* renamed from: b */
    private boolean mo3531b(long r17, long r19) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r16 = this;
        r12 = r16;
        r0 = r12.f13780C;
        r13 = -1;
        r14 = 1;
        r15 = 0;
        if (r0 >= 0) goto L_0x00a5;
    L_0x0009:
        r0 = r12.f13810u;
        if (r0 == 0) goto L_0x002c;
    L_0x000d:
        r0 = r12.f13786I;
        if (r0 == 0) goto L_0x002c;
    L_0x0011:
        r0 = r12.f13803n;	 Catch:{ IllegalStateException -> 0x0020 }
        r1 = r12.f13799j;	 Catch:{ IllegalStateException -> 0x0020 }
        r2 = r16.m17257E();	 Catch:{ IllegalStateException -> 0x0020 }
        r0 = r0.dequeueOutputBuffer(r1, r2);	 Catch:{ IllegalStateException -> 0x0020 }
        r12.f13780C = r0;	 Catch:{ IllegalStateException -> 0x0020 }
        goto L_0x003a;
        r16.m17237F();
        r0 = r12.f13788K;
        if (r0 == 0) goto L_0x002b;
    L_0x0028:
        r16.mo3526C();
    L_0x002b:
        return r15;
    L_0x002c:
        r0 = r12.f13803n;
        r1 = r12.f13799j;
        r2 = r16.m17257E();
        r0 = r0.dequeueOutputBuffer(r1, r2);
        r12.f13780C = r0;
    L_0x003a:
        r0 = r12.f13780C;
        if (r0 < 0) goto L_0x0082;
    L_0x003e:
        r0 = r12.f13813x;
        if (r0 == 0) goto L_0x004e;
    L_0x0042:
        r12.f13813x = r15;
        r0 = r12.f13803n;
        r1 = r12.f13780C;
        r0.releaseOutputBuffer(r1, r15);
        r12.f13780C = r13;
        return r14;
    L_0x004e:
        r0 = r12.f13799j;
        r0 = r0.flags;
        r0 = r0 & 4;
        if (r0 == 0) goto L_0x005c;
    L_0x0056:
        r16.m17237F();
        r12.f13780C = r13;
        return r15;
    L_0x005c:
        r0 = r12.f13815z;
        r1 = r12.f13780C;
        r0 = r0[r1];
        if (r0 == 0) goto L_0x0077;
    L_0x0064:
        r1 = r12.f13799j;
        r1 = r1.offset;
        r0.position(r1);
        r1 = r12.f13799j;
        r1 = r1.offset;
        r2 = r12.f13799j;
        r2 = r2.size;
        r1 = r1 + r2;
        r0.limit(r1);
    L_0x0077:
        r0 = r12.f13799j;
        r0 = r0.presentationTimeUs;
        r0 = r12.m17247d(r0);
        r12.f13781D = r0;
        goto L_0x00a5;
    L_0x0082:
        r0 = r12.f13780C;
        r1 = -2;
        if (r0 != r1) goto L_0x008b;
    L_0x0087:
        r16.mo2324w();
        return r14;
    L_0x008b:
        r0 = r12.f13780C;
        r1 = -3;
        if (r0 != r1) goto L_0x0094;
    L_0x0090:
        r16.mo2325x();
        return r14;
    L_0x0094:
        r0 = r12.f13808s;
        if (r0 == 0) goto L_0x00a4;
    L_0x0098:
        r0 = r12.f13787J;
        if (r0 != 0) goto L_0x00a1;
    L_0x009c:
        r0 = r12.f13784G;
        r1 = 2;
        if (r0 != r1) goto L_0x00a4;
    L_0x00a1:
        r16.m17237F();
    L_0x00a4:
        return r15;
    L_0x00a5:
        r0 = r12.f13810u;
        if (r0 == 0) goto L_0x00d8;
    L_0x00a9:
        r0 = r12.f13786I;
        if (r0 == 0) goto L_0x00d8;
    L_0x00ad:
        r5 = r12.f13803n;	 Catch:{ IllegalStateException -> 0x00cc }
        r0 = r12.f13815z;	 Catch:{ IllegalStateException -> 0x00cc }
        r1 = r12.f13780C;	 Catch:{ IllegalStateException -> 0x00cc }
        r6 = r0[r1];	 Catch:{ IllegalStateException -> 0x00cc }
        r7 = r12.f13780C;	 Catch:{ IllegalStateException -> 0x00cc }
        r0 = r12.f13799j;	 Catch:{ IllegalStateException -> 0x00cc }
        r8 = r0.flags;	 Catch:{ IllegalStateException -> 0x00cc }
        r0 = r12.f13799j;	 Catch:{ IllegalStateException -> 0x00cc }
        r9 = r0.presentationTimeUs;	 Catch:{ IllegalStateException -> 0x00cc }
        r11 = r12.f13781D;	 Catch:{ IllegalStateException -> 0x00cc }
        r0 = r16;	 Catch:{ IllegalStateException -> 0x00cc }
        r1 = r17;	 Catch:{ IllegalStateException -> 0x00cc }
        r3 = r19;	 Catch:{ IllegalStateException -> 0x00cc }
        r0 = r0.mo3520a(r1, r3, r5, r6, r7, r8, r9, r11);	 Catch:{ IllegalStateException -> 0x00cc }
        goto L_0x00f6;
        r16.m17237F();
        r0 = r12.f13788K;
        if (r0 == 0) goto L_0x00d7;
    L_0x00d4:
        r16.mo3526C();
    L_0x00d7:
        return r15;
    L_0x00d8:
        r5 = r12.f13803n;
        r0 = r12.f13815z;
        r1 = r12.f13780C;
        r6 = r0[r1];
        r7 = r12.f13780C;
        r0 = r12.f13799j;
        r8 = r0.flags;
        r0 = r12.f13799j;
        r9 = r0.presentationTimeUs;
        r11 = r12.f13781D;
        r0 = r16;
        r1 = r17;
        r3 = r19;
        r0 = r0.mo3520a(r1, r3, r5, r6, r7, r8, r9, r11);
    L_0x00f6:
        if (r0 == 0) goto L_0x0102;
    L_0x00f8:
        r0 = r12.f13799j;
        r0 = r0.presentationTimeUs;
        r12.mo3532c(r0);
        r12.f13780C = r13;
        return r14;
    L_0x0102:
        return r15;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.f.b.b(long, long):boolean");
    }

    /* renamed from: w */
    private void mo2324w() {
        MediaFormat outputFormat = this.f13803n.getOutputFormat();
        if (this.f13805p != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
            this.f13813x = true;
            return;
        }
        if (this.f13811v) {
            outputFormat.setInteger("channel-count", 1);
        }
        mo3517a(this.f13803n, outputFormat);
    }

    /* renamed from: x */
    private void mo2325x() {
        this.f13815z = this.f13803n.getOutputBuffers();
    }

    /* renamed from: F */
    private void m17237F() {
        if (this.f13784G == 2) {
            mo3526C();
            m17280z();
            return;
        }
        this.f13788K = true;
        mo3524y();
    }

    /* renamed from: d */
    private boolean m17247d(long j) {
        int size = this.f13798i.size();
        for (int i = 0; i < size; i++) {
            if (((Long) this.f13798i.get(i)).longValue() == j) {
                this.f13798i.remove(i);
                return 1;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static boolean mo3521a(String str) {
        if (C2541v.f6467a >= 18 && !(C2541v.f6467a == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str)))) {
            if (C2541v.f6467a == 19 && C2541v.f6470d.startsWith("SM-G800")) {
                if (!"OMX.Exynos.avc.dec".equals(str)) {
                    if ("OMX.Exynos.avc.dec.secure".equals(str) != null) {
                    }
                }
            }
            return null;
        }
        return true;
    }

    /* renamed from: b */
    private int m17242b(String str) {
        if (C2541v.f6467a <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (C2541v.f6470d.startsWith("SM-T585") || C2541v.f6470d.startsWith("SM-A510") || C2541v.f6470d.startsWith("SM-A520") || C2541v.f6470d.startsWith("SM-J700"))) {
            return 2;
        }
        return (C2541v.f6467a >= 24 || ((!"OMX.Nvidia.h264.decode".equals(str) && "OMX.Nvidia.h264.decode.secure".equals(str) == null) || ("flounder".equals(C2541v.f6468b) == null && "flounder_lte".equals(C2541v.f6468b) == null && "grouper".equals(C2541v.f6468b) == null && "tilapia".equals(C2541v.f6468b) == null))) ? null : 1;
    }

    /* renamed from: a */
    private static boolean m17241a(String str, C2515k c2515k) {
        return (C2541v.f6467a >= 21 || c2515k.f6382h.isEmpty() == null || "OMX.MTK.VIDEO.DECODER.AVC".equals(str) == null) ? null : true;
    }

    /* renamed from: c */
    private static boolean m17246c(String str) {
        return (C2541v.f6467a > 17 || (!"OMX.rk.video_decoder.avc".equals(str) && "OMX.allwinner.video.decoder.avc".equals(str) == null)) ? null : true;
    }

    /* renamed from: d */
    private static boolean m17248d(String str) {
        return ((C2541v.f6467a > 23 || !"OMX.google.vorbis.decoder".equals(str)) && (C2541v.f6467a > 19 || !"hb2000".equals(C2541v.f6468b) || (!"OMX.amlogic.avc.decoder.awesome".equals(str) && "OMX.amlogic.avc.decoder.awesome.secure".equals(str) == null))) ? null : true;
    }

    /* renamed from: e */
    private static boolean m17249e(String str) {
        return (C2541v.f6467a != 21 || "OMX.google.aac.decoder".equals(str) == null) ? null : true;
    }

    /* renamed from: b */
    private static boolean m17244b(String str, C2515k c2515k) {
        if (C2541v.f6467a > 18 || c2515k.f6392r != 1 || "OMX.MTK.AUDIO.DECODER.MP3".equals(str) == null) {
            return false;
        }
        return true;
    }
}
