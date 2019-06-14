package com.google.android.exoplayer2.p165m;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodec.OnFrameRenderedListener;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.C4690a;
import com.google.android.exoplayer2.p135b.C2249d;
import com.google.android.exoplayer2.p135b.C4085e;
import com.google.android.exoplayer2.p136c.C2255a;
import com.google.android.exoplayer2.p136c.C2258c;
import com.google.android.exoplayer2.p136c.C4088e;
import com.google.android.exoplayer2.p144f.C2333a;
import com.google.android.exoplayer2.p144f.C2335c;
import com.google.android.exoplayer2.p144f.C2340d;
import com.google.android.exoplayer2.p144f.C4852b;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2524i;
import com.google.android.exoplayer2.p164l.C2538t;
import com.google.android.exoplayer2.p164l.C2541v;
import com.google.android.exoplayer2.p165m.C2565g.C2564a;

@TargetApi(16)
/* compiled from: MediaCodecVideoRenderer */
/* renamed from: com.google.android.exoplayer2.m.e */
public class C4899e extends C4852b {
    /* renamed from: c */
    private static final int[] f14051c = new int[]{1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    /* renamed from: A */
    private int f14052A = -1;
    /* renamed from: B */
    private int f14053B;
    /* renamed from: C */
    private float f14054C = -1.0f;
    /* renamed from: D */
    private int f14055D;
    /* renamed from: E */
    private int f14056E;
    /* renamed from: F */
    private int f14057F;
    /* renamed from: G */
    private float f14058G;
    /* renamed from: H */
    private boolean f14059H;
    /* renamed from: I */
    private int f14060I;
    /* renamed from: J */
    private long f14061J = -9223372036854775807L;
    /* renamed from: K */
    private int f14062K;
    /* renamed from: b */
    C2553b f14063b;
    /* renamed from: d */
    private final Context f14064d;
    /* renamed from: e */
    private final C2556f f14065e;
    /* renamed from: f */
    private final C2564a f14066f;
    /* renamed from: g */
    private final long f14067g;
    /* renamed from: h */
    private final int f14068h;
    /* renamed from: i */
    private final boolean f14069i = C4899e.m17587K();
    /* renamed from: j */
    private final long[] f14070j = new long[10];
    /* renamed from: k */
    private C2515k[] f14071k;
    /* renamed from: l */
    private C2552a f14072l;
    /* renamed from: m */
    private boolean f14073m;
    /* renamed from: n */
    private Surface f14074n;
    /* renamed from: o */
    private Surface f14075o;
    /* renamed from: p */
    private int f14076p = 1;
    /* renamed from: q */
    private boolean f14077q;
    /* renamed from: r */
    private boolean f14078r;
    /* renamed from: s */
    private long f14079s = -9223372036854775807L;
    /* renamed from: t */
    private long f14080t;
    /* renamed from: u */
    private int f14081u;
    /* renamed from: v */
    private int f14082v;
    /* renamed from: w */
    private int f14083w;
    /* renamed from: x */
    private int f14084x;
    /* renamed from: y */
    private float f14085y = -1.0f;
    /* renamed from: z */
    private int f14086z = -1;

    /* compiled from: MediaCodecVideoRenderer */
    /* renamed from: com.google.android.exoplayer2.m.e$a */
    protected static final class C2552a {
        /* renamed from: a */
        public final int f6503a;
        /* renamed from: b */
        public final int f6504b;
        /* renamed from: c */
        public final int f6505c;

        public C2552a(int i, int i2, int i3) {
            this.f6503a = i;
            this.f6504b = i2;
            this.f6505c = i3;
        }
    }

    @TargetApi(23)
    /* compiled from: MediaCodecVideoRenderer */
    /* renamed from: com.google.android.exoplayer2.m.e$b */
    private final class C2553b implements OnFrameRenderedListener {
        /* renamed from: a */
        final /* synthetic */ C4899e f6506a;

        private C2553b(C4899e c4899e, MediaCodec mediaCodec) {
            this.f6506a = c4899e;
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        public void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
            if (this == this.f6506a.f14063b) {
                this.f6506a.mo3523v();
            }
        }
    }

    /* renamed from: d */
    private static boolean m17599d(long j) {
        return j < -30000;
    }

    /* renamed from: e */
    private static boolean m17601e(long j) {
        return j < -500000;
    }

    public C4899e(Context context, C2335c c2335c, long j, C2258c<C4088e> c2258c, boolean z, Handler handler, C2565g c2565g, int i) {
        super(2, c2335c, c2258c, z);
        this.f14067g = j;
        this.f14068h = i;
        this.f14064d = context.getApplicationContext();
        this.f14065e = new C2556f(context);
        this.f14066f = new C2564a(handler, c2565g);
        m17583G();
    }

    /* renamed from: a */
    protected int mo3515a(C2335c c2335c, C2258c<C4088e> c2258c, C2515k c2515k) {
        String str = c2515k.f6380f;
        int i = 0;
        if (!C2524i.m7051b(str)) {
            return 0;
        }
        boolean z;
        C2255a c2255a = c2515k.f6383i;
        if (c2255a != null) {
            z = false;
            for (int i2 = 0; i2 < c2255a.f5387b; i2++) {
                z |= c2255a.m6232a(i2).f5383c;
            }
        } else {
            z = false;
        }
        C2333a a = c2335c.mo2222a(str, z);
        int i3 = 2;
        if (a == null) {
            if (!z || c2335c.mo2222a(str, false) == null) {
                i3 = 1;
            }
            return i3;
        } else if (C4690a.m15998a((C2258c) c2258c, c2255a) == null) {
            return 2;
        } else {
            c2335c = a.m6479b(c2515k.f6377c);
            if (c2335c != null && c2515k.f6384j > null && c2515k.f6385k > null) {
                if (C2541v.f6467a >= 21) {
                    c2335c = a.m6476a(c2515k.f6384j, c2515k.f6385k, (double) c2515k.f6386l);
                } else {
                    c2335c = c2515k.f6384j * c2515k.f6385k <= C2340d.m6496b() ? true : null;
                    if (c2335c == null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("FalseCheck [legacyFrameSize, ");
                        stringBuilder.append(c2515k.f6384j);
                        stringBuilder.append("x");
                        stringBuilder.append(c2515k.f6385k);
                        stringBuilder.append("] [");
                        stringBuilder.append(C2541v.f6471e);
                        stringBuilder.append("]");
                        Log.d("MediaCodecVideoRenderer", stringBuilder.toString());
                    }
                }
            }
            c2258c = a.f5787b != null ? 16 : 8;
            if (a.f5788c != null) {
                i = 32;
            }
            return (c2335c != null ? 4 : 3) | (c2258c | i);
        }
    }

    /* renamed from: a */
    protected void mo3414a(boolean z) {
        super.mo3414a(z);
        this.f14060I = m16025q().f6616b;
        this.f14059H = this.f14060I;
        this.f14066f.m7234a(this.a);
        this.f14065e.m7228a();
    }

    /* renamed from: a */
    protected void mo3420a(C2515k[] c2515kArr, long j) {
        this.f14071k = c2515kArr;
        if (this.f14061J == -9223372036854775807L) {
            this.f14061J = j;
        } else {
            if (this.f14062K == this.f14070j.length) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Too many stream changes, so dropping offset: ");
                stringBuilder.append(this.f14070j[this.f14062K - 1]);
                Log.w("MediaCodecVideoRenderer", stringBuilder.toString());
            } else {
                this.f14062K++;
            }
            this.f14070j[this.f14062K - 1] = j;
        }
        super.mo3420a(c2515kArr, j);
    }

    /* renamed from: a */
    protected void mo3413a(long j, boolean z) {
        super.mo3413a(j, z);
        m17603x();
        this.f14082v = 0;
        if (this.f14062K != 0) {
            this.f14061J = this.f14070j[this.f14062K - 1];
            this.f14062K = 0;
        }
        if (z) {
            m17602w();
        } else {
            this.f14079s = -9223372036854775807L;
        }
    }

    /* renamed from: t */
    public boolean mo3418t() {
        if (super.mo3418t() && (this.f14077q || ((this.f14075o != null && this.f14074n == this.f14075o) || m17253A() == null || this.f14059H))) {
            this.f14079s = -9223372036854775807L;
            return true;
        } else if (this.f14079s == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.f14079s) {
                return true;
            }
            this.f14079s = -9223372036854775807L;
            return false;
        }
    }

    /* renamed from: n */
    protected void mo3415n() {
        super.mo3415n();
        this.f14081u = 0;
        this.f14080t = SystemClock.elapsedRealtime();
    }

    /* renamed from: o */
    protected void mo3416o() {
        this.f14079s = -9223372036854775807L;
        m17586J();
        super.mo3416o();
    }

    /* renamed from: p */
    protected void mo3417p() {
        this.f14086z = -1;
        this.f14052A = -1;
        this.f14054C = -1.0f;
        this.f14085y = -1.0f;
        this.f14061J = -9223372036854775807L;
        this.f14062K = 0;
        m17583G();
        m17603x();
        this.f14065e.m7229b();
        this.f14063b = null;
        this.f14059H = false;
        try {
            super.mo3417p();
        } finally {
            this.a.m6220a();
            this.f14066f.m7237b(this.a);
        }
    }

    /* renamed from: a */
    public void mo3179a(int i, Object obj) {
        if (i == 1) {
            m17593a((Surface) obj);
        } else if (i == 4) {
            this.f14076p = ((Integer) obj).intValue();
            MediaCodec A = m17253A();
            if (A != 0) {
                C4899e.m17590a(A, this.f14076p);
            }
        } else {
            super.mo3179a(i, obj);
        }
    }

    /* renamed from: a */
    private void m17593a(Surface surface) {
        if (surface == null) {
            if (this.f14075o != null) {
                surface = this.f14075o;
            } else {
                C2333a B = m17254B();
                if (B != null && m17596b(B.f5789d)) {
                    this.f14075o = C2549c.m7209a(this.f14064d, B.f5789d);
                    surface = this.f14075o;
                }
            }
        }
        if (this.f14074n != surface) {
            this.f14074n = surface;
            int d = mo3185d();
            if (d == 1 || d == 2) {
                MediaCodec A = m17253A();
                if (C2541v.f6467a < 23 || A == null || surface == null || this.f14073m) {
                    mo3526C();
                    m17280z();
                } else {
                    C4899e.m17591a(A, surface);
                }
            }
            if (surface == null || surface == this.f14075o) {
                m17583G();
                m17603x();
                return;
            }
            m17585I();
            m17603x();
            if (d == 2) {
                m17602w();
            }
        } else if (surface != null && surface != this.f14075o) {
            m17585I();
            m17582F();
        }
    }

    /* renamed from: a */
    protected boolean mo3530a(C2333a c2333a) {
        if (this.f14074n == null) {
            if (m17596b(c2333a.f5789d) == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    protected void mo3518a(C2333a c2333a, MediaCodec mediaCodec, C2515k c2515k, MediaCrypto mediaCrypto) {
        this.f14072l = m17608a(c2333a, c2515k, this.f14071k);
        c2515k = m17607a(c2515k, this.f14072l, this.f14069i, this.f14060I);
        if (this.f14074n == null) {
            C2516a.m7019b(m17596b(c2333a.f5789d));
            if (this.f14075o == null) {
                this.f14075o = C2549c.m7209a(this.f14064d, c2333a.f5789d);
            }
            this.f14074n = this.f14075o;
        }
        mediaCodec.configure(c2515k, this.f14074n, mediaCrypto, 0);
        if (C2541v.f6467a >= 23 && this.f14059H != null) {
            this.f14063b = new C2553b(mediaCodec);
        }
    }

    /* renamed from: C */
    protected void mo3526C() {
        try {
            super.mo3526C();
        } finally {
            this.f14083w = 0;
            this.f14078r = false;
            if (this.f14075o != null) {
                if (this.f14074n == this.f14075o) {
                    this.f14074n = null;
                }
                this.f14075o.release();
                this.f14075o = null;
            }
        }
    }

    /* renamed from: D */
    protected void mo3527D() {
        super.mo3527D();
        this.f14083w = 0;
        this.f14078r = false;
    }

    /* renamed from: a */
    protected void mo3519a(String str, long j, long j2) {
        this.f14066f.m7236a(str, j, j2);
        this.f14073m = C4899e.m17594a(str);
    }

    /* renamed from: b */
    protected void mo3522b(C2515k c2515k) {
        super.mo3522b(c2515k);
        this.f14066f.m7235a(c2515k);
        this.f14085y = C4899e.m17598d(c2515k);
        this.f14084x = C4899e.m17600e(c2515k);
    }

    /* renamed from: a */
    protected void mo3528a(C4085e c4085e) {
        this.f14083w++;
        if (C2541v.f6467a < 23 && this.f14059H != null) {
            mo3523v();
        }
    }

    /* renamed from: a */
    protected void mo3517a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        Object obj = (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) ? 1 : null;
        if (obj != null) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.f14086z = integer;
        if (obj != null) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.f14052A = integer2;
        this.f14054C = this.f14085y;
        if (C2541v.f6467a < 21) {
            this.f14053B = this.f14084x;
        } else if (this.f14084x == 90 || this.f14084x == 270) {
            mediaFormat = this.f14086z;
            this.f14086z = this.f14052A;
            this.f14052A = mediaFormat;
            this.f14054C = 1065353216 / this.f14054C;
        }
        C4899e.m17590a(mediaCodec, this.f14076p);
    }

    /* renamed from: a */
    protected boolean mo3529a(MediaCodec mediaCodec, boolean z, C2515k c2515k, C2515k c2515k2) {
        return (C4899e.m17595a(z, c2515k, c2515k2) == null || c2515k2.f6384j > this.f14072l.f6503a || c2515k2.f6385k > this.f14072l.f6504b || C4899e.m17597c(c2515k2) > this.f14072l.f6505c) ? null : true;
    }

    /* renamed from: a */
    protected boolean mo3520a(long r23, long r25, android.media.MediaCodec r27, java.nio.ByteBuffer r28, int r29, int r30, long r31, boolean r33) {
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
        r22 = this;
        r7 = r22;
        r8 = r25;
        r10 = r27;
        r11 = r29;
        r0 = r31;
    L_0x000a:
        r2 = r7.f14062K;
        r12 = 1;
        r13 = 0;
        if (r2 == 0) goto L_0x002d;
    L_0x0010:
        r2 = r7.f14070j;
        r3 = r2[r13];
        r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r2 < 0) goto L_0x002d;
    L_0x0018:
        r2 = r7.f14070j;
        r3 = r2[r13];
        r7.f14061J = r3;
        r2 = r7.f14062K;
        r2 = r2 - r12;
        r7.f14062K = r2;
        r2 = r7.f14070j;
        r3 = r7.f14070j;
        r4 = r7.f14062K;
        java.lang.System.arraycopy(r2, r12, r3, r13, r4);
        goto L_0x000a;
    L_0x002d:
        r2 = r7.f14061J;
        r14 = r0 - r2;
        if (r33 == 0) goto L_0x0037;
    L_0x0033:
        r7.m17611a(r10, r11, r14);
        return r12;
    L_0x0037:
        r2 = 0;
        r2 = r0 - r23;
        r4 = r7.f14074n;
        r12 = r7.f14075o;
        if (r4 != r12) goto L_0x004e;
    L_0x0040:
        r0 = com.google.android.exoplayer2.p165m.C4899e.m17599d(r2);
        if (r0 == 0) goto L_0x004d;
    L_0x0046:
        r7.f14078r = r13;
        r7.m17611a(r10, r11, r14);
        r0 = 1;
        return r0;
    L_0x004d:
        return r13;
    L_0x004e:
        r4 = r7.f14077q;
        if (r4 == 0) goto L_0x00ea;
    L_0x0052:
        r4 = r7.f14078r;
        if (r4 == 0) goto L_0x0058;
    L_0x0056:
        goto L_0x00ea;
    L_0x0058:
        r4 = r22.mo3185d();
        r12 = 2;
        if (r4 == r12) goto L_0x0060;
    L_0x005f:
        return r13;
    L_0x0060:
        r16 = android.os.SystemClock.elapsedRealtime();
        r18 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r16 = r16 * r18;
        r16 = r16 - r8;
        r2 = r2 - r16;
        r16 = java.lang.System.nanoTime();
        r2 = r2 * r18;
        r2 = r16 + r2;
        r4 = r7.f14065e;
        r20 = r4.m7227a(r0, r2);
        r0 = r20 - r16;
        r3 = r0 / r18;
        r0 = r7.m17629c(r3, r8);
        if (r0 == 0) goto L_0x0098;
    L_0x0084:
        r0 = r22;
        r1 = r27;
        r2 = r29;
        r10 = r3;
        r3 = r14;
        r5 = r23;
        r0 = r0.m17619a(r1, r2, r3, r5);
        if (r0 == 0) goto L_0x0099;
    L_0x0094:
        r0 = 1;
        r7.f14078r = r0;
        return r13;
    L_0x0098:
        r10 = r3;
    L_0x0099:
        r0 = 1;
        r1 = r7.mo3531b(r10, r8);
        if (r1 == 0) goto L_0x00a8;
    L_0x00a0:
        r1 = r27;
        r2 = r29;
        r7.m17623b(r1, r2, r14);
        return r0;
    L_0x00a8:
        r3 = r10;
        r1 = r27;
        r2 = r29;
        r0 = com.google.android.exoplayer2.p164l.C2541v.f6467a;
        r5 = 21;
        if (r0 < r5) goto L_0x00c8;
    L_0x00b3:
        r5 = 50000; // 0xc350 float:7.0065E-41 double:2.47033E-319;
        r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r0 >= 0) goto L_0x00e9;
    L_0x00ba:
        r0 = r22;
        r1 = r27;
        r2 = r29;
        r3 = r14;
        r5 = r20;
        r0.m17624b(r1, r2, r3, r5);
        r0 = 1;
        return r0;
    L_0x00c8:
        r5 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r0 >= 0) goto L_0x00e9;
    L_0x00ce:
        r5 = 11000; // 0x2af8 float:1.5414E-41 double:5.4347E-320;
        r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r0 <= 0) goto L_0x00e4;
    L_0x00d4:
        r5 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r3 = r3 - r5;
        r3 = r3 / r18;	 Catch:{ InterruptedException -> 0x00dd }
        java.lang.Thread.sleep(r3);	 Catch:{ InterruptedException -> 0x00dd }
        goto L_0x00e4;
    L_0x00dd:
        r0 = java.lang.Thread.currentThread();
        r0.interrupt();
    L_0x00e4:
        r7.m17628c(r1, r2, r14);
        r0 = 1;
        return r0;
    L_0x00e9:
        return r13;
    L_0x00ea:
        r1 = r10;
        r2 = r11;
        r7.f14078r = r13;
        r0 = com.google.android.exoplayer2.p164l.C2541v.f6467a;
        r3 = 21;
        if (r0 < r3) goto L_0x0104;
    L_0x00f4:
        r5 = java.lang.System.nanoTime();
        r0 = r22;
        r1 = r27;
        r2 = r29;
        r3 = r14;
        r0.m17624b(r1, r2, r3, r5);
    L_0x0102:
        r0 = 1;
        goto L_0x0108;
    L_0x0104:
        r7.m17628c(r1, r2, r14);
        goto L_0x0102;
    L_0x0108:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.m.e.a(long, long, android.media.MediaCodec, java.nio.ByteBuffer, int, int, long, boolean):boolean");
    }

    /* renamed from: c */
    protected void mo3532c(long j) {
        this.f14083w--;
    }

    /* renamed from: b */
    protected boolean mo3531b(long j, long j2) {
        return C4899e.m17599d(j);
    }

    /* renamed from: c */
    protected boolean m17629c(long j, long j2) {
        return C4899e.m17601e(j);
    }

    /* renamed from: a */
    protected void m17611a(MediaCodec mediaCodec, int i, long j) {
        C2538t.m7155a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, 0);
        C2538t.m7154a();
        mediaCodec = this.a;
        mediaCodec.f5370f++;
    }

    /* renamed from: b */
    protected void m17623b(MediaCodec mediaCodec, int i, long j) {
        C2538t.m7155a("dropVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, 0);
        C2538t.m7154a();
        m17622b(1);
    }

    /* renamed from: a */
    protected boolean m17619a(MediaCodec mediaCodec, int i, long j, long j2) {
        mediaCodec = m16009b(j2);
        if (mediaCodec == null) {
            return null;
        }
        i = this.a;
        i.f5373i++;
        m17622b(this.f14083w + mediaCodec);
        mo3527D();
        return true;
    }

    /* renamed from: b */
    protected void m17622b(int i) {
        C2249d c2249d = this.a;
        c2249d.f5371g += i;
        this.f14081u += i;
        this.f14082v += i;
        this.a.f5372h = Math.max(this.f14082v, this.a.f5372h);
        if (this.f14081u >= this.f14068h) {
            m17586J();
        }
    }

    /* renamed from: c */
    protected void m17628c(MediaCodec mediaCodec, int i, long j) {
        m17584H();
        C2538t.m7155a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        C2538t.m7154a();
        mediaCodec = this.a;
        mediaCodec.f5369e++;
        this.f14082v = null;
        mo3523v();
    }

    @TargetApi(21)
    /* renamed from: b */
    protected void m17624b(MediaCodec mediaCodec, int i, long j, long j2) {
        m17584H();
        C2538t.m7155a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        C2538t.m7154a();
        mediaCodec = this.a;
        mediaCodec.f5369e++;
        this.f14082v = null;
        mo3523v();
    }

    /* renamed from: b */
    private boolean m17596b(boolean z) {
        return C2541v.f6467a >= 23 && !this.f14059H && (!z || C2549c.m7211a(this.f14064d));
    }

    /* renamed from: w */
    private void m17602w() {
        this.f14079s = this.f14067g > 0 ? SystemClock.elapsedRealtime() + this.f14067g : -9223372036854775807L;
    }

    /* renamed from: x */
    private void m17603x() {
        this.f14077q = false;
        if (C2541v.f6467a >= 23 && this.f14059H) {
            MediaCodec A = m17253A();
            if (A != null) {
                this.f14063b = new C2553b(A);
            }
        }
    }

    /* renamed from: v */
    void mo3523v() {
        if (!this.f14077q) {
            this.f14077q = true;
            this.f14066f.m7233a(this.f14074n);
        }
    }

    /* renamed from: F */
    private void m17582F() {
        if (this.f14077q) {
            this.f14066f.m7233a(this.f14074n);
        }
    }

    /* renamed from: G */
    private void m17583G() {
        this.f14055D = -1;
        this.f14056E = -1;
        this.f14058G = -1.0f;
        this.f14057F = -1;
    }

    /* renamed from: H */
    private void m17584H() {
        if (this.f14086z != -1 || this.f14052A != -1) {
            if (this.f14055D != this.f14086z || this.f14056E != this.f14052A || this.f14057F != this.f14053B || this.f14058G != this.f14054C) {
                this.f14066f.m7231a(this.f14086z, this.f14052A, this.f14053B, this.f14054C);
                this.f14055D = this.f14086z;
                this.f14056E = this.f14052A;
                this.f14057F = this.f14053B;
                this.f14058G = this.f14054C;
            }
        }
    }

    /* renamed from: I */
    private void m17585I() {
        if (this.f14055D != -1 || this.f14056E != -1) {
            this.f14066f.m7231a(this.f14055D, this.f14056E, this.f14057F, this.f14058G);
        }
    }

    /* renamed from: J */
    private void m17586J() {
        if (this.f14081u > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f14066f.m7232a(this.f14081u, elapsedRealtime - this.f14080t);
            this.f14081u = 0;
            this.f14080t = elapsedRealtime;
        }
    }

    @TargetApi(23)
    /* renamed from: a */
    private static void m17591a(MediaCodec mediaCodec, Surface surface) {
        mediaCodec.setOutputSurface(surface);
    }

    @TargetApi(21)
    /* renamed from: a */
    private static void m17592a(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    /* renamed from: a */
    protected C2552a m17608a(C2333a c2333a, C2515k c2515k, C2515k[] c2515kArr) {
        int i = c2515k.f6384j;
        int i2 = c2515k.f6385k;
        int c = C4899e.m17597c(c2515k);
        if (c2515kArr.length == 1) {
            return new C2552a(i, i2, c);
        }
        int i3 = i2;
        int i4 = c;
        i2 = 0;
        c = i;
        for (C2515k c2515k2 : c2515kArr) {
            if (C4899e.m17595a(c2333a.f5787b, c2515k, c2515k2)) {
                int i5;
                if (c2515k2.f6384j != -1) {
                    if (c2515k2.f6385k != -1) {
                        i5 = 0;
                        i2 |= i5;
                        c = Math.max(c, c2515k2.f6384j);
                        i3 = Math.max(i3, c2515k2.f6385k);
                        i4 = Math.max(i4, C4899e.m17597c(c2515k2));
                    }
                }
                i5 = 1;
                i2 |= i5;
                c = Math.max(c, c2515k2.f6384j);
                i3 = Math.max(i3, c2515k2.f6385k);
                i4 = Math.max(i4, C4899e.m17597c(c2515k2));
            }
        }
        if (i2 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Resolutions unknown. Codec max resolution: ");
            stringBuilder.append(c);
            stringBuilder.append("x");
            stringBuilder.append(i3);
            Log.w("MediaCodecVideoRenderer", stringBuilder.toString());
            c2333a = C4899e.m17589a(c2333a, c2515k);
            if (c2333a != null) {
                c = Math.max(c, c2333a.x);
                i3 = Math.max(i3, c2333a.y);
                i4 = Math.max(i4, C4899e.m17588a(c2515k.f6380f, c, i3));
                c2515k = new StringBuilder();
                c2515k.append("Codec max resolution adjusted to: ");
                c2515k.append(c);
                c2515k.append("x");
                c2515k.append(i3);
                Log.w("MediaCodecVideoRenderer", c2515k.toString());
            }
        }
        return new C2552a(c, i3, i4);
    }

    @SuppressLint({"InlinedApi"})
    /* renamed from: a */
    protected MediaFormat m17607a(C2515k c2515k, C2552a c2552a, boolean z, int i) {
        MediaFormat b = c2515k.m7013b();
        b.setInteger("max-width", c2552a.f6503a);
        b.setInteger("max-height", c2552a.f6504b);
        if (c2552a.f6505c != -1) {
            b.setInteger("max-input-size", c2552a.f6505c);
        }
        if (z) {
            b.setInteger("auto-frc", false);
        }
        if (i != 0) {
            C4899e.m17592a(b, i);
        }
        return b;
    }

    /* renamed from: a */
    private static Point m17589a(C2333a c2333a, C2515k c2515k) {
        int i = 0;
        Object obj = c2515k.f6385k > c2515k.f6384j ? 1 : null;
        int i2 = obj != null ? c2515k.f6385k : c2515k.f6384j;
        int i3 = obj != null ? c2515k.f6384j : c2515k.f6385k;
        float f = ((float) i3) / ((float) i2);
        int[] iArr = f14051c;
        int length = iArr.length;
        while (i < length) {
            int i4 = iArr[i];
            int i5 = (int) (((float) i4) * f);
            if (i4 > i2) {
                if (i5 > i3) {
                    int i6;
                    if (C2541v.f6467a >= 21) {
                        i6 = obj != null ? i5 : i4;
                        if (obj == null) {
                            i4 = i5;
                        }
                        Point a = c2333a.m6474a(i6, i4);
                        if (c2333a.m6476a(a.x, a.y, (double) c2515k.f6386l)) {
                            return a;
                        }
                    } else {
                        i4 = C2541v.m7163a(i4, 16) * 16;
                        i6 = C2541v.m7163a(i5, 16) * 16;
                        if (i4 * i6 <= C2340d.m6496b()) {
                            c2515k = obj != null ? i6 : i4;
                            if (obj != null) {
                                i6 = i4;
                            }
                            return new Point(c2515k, i6);
                        }
                    }
                    i++;
                }
            }
            return null;
        }
        return null;
    }

    /* renamed from: c */
    private static int m17597c(C2515k c2515k) {
        if (c2515k.f6381g == -1) {
            return C4899e.m17588a(c2515k.f6380f, c2515k.f6384j, c2515k.f6385k);
        }
        int i = 0;
        for (int i2 = 0; i2 < c2515k.f6382h.size(); i2++) {
            i += ((byte[]) c2515k.f6382h.get(i2)).length;
        }
        return c2515k.f6381g + i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static int m17588a(java.lang.String r5, int r6, int r7) {
        /*
        r0 = -1;
        if (r6 == r0) goto L_0x007e;
    L_0x0003:
        if (r7 != r0) goto L_0x0007;
    L_0x0005:
        goto L_0x007e;
    L_0x0007:
        r1 = r5.hashCode();
        r2 = 3;
        r3 = 4;
        r4 = 2;
        switch(r1) {
            case -1664118616: goto L_0x0044;
            case -1662541442: goto L_0x003a;
            case 1187890754: goto L_0x0030;
            case 1331836730: goto L_0x0026;
            case 1599127256: goto L_0x001c;
            case 1599127257: goto L_0x0012;
            default: goto L_0x0011;
        };
    L_0x0011:
        goto L_0x004e;
    L_0x0012:
        r1 = "video/x-vnd.on2.vp9";
        r5 = r5.equals(r1);
        if (r5 == 0) goto L_0x004e;
    L_0x001a:
        r5 = 5;
        goto L_0x004f;
    L_0x001c:
        r1 = "video/x-vnd.on2.vp8";
        r5 = r5.equals(r1);
        if (r5 == 0) goto L_0x004e;
    L_0x0024:
        r5 = 3;
        goto L_0x004f;
    L_0x0026:
        r1 = "video/avc";
        r5 = r5.equals(r1);
        if (r5 == 0) goto L_0x004e;
    L_0x002e:
        r5 = 2;
        goto L_0x004f;
    L_0x0030:
        r1 = "video/mp4v-es";
        r5 = r5.equals(r1);
        if (r5 == 0) goto L_0x004e;
    L_0x0038:
        r5 = 1;
        goto L_0x004f;
    L_0x003a:
        r1 = "video/hevc";
        r5 = r5.equals(r1);
        if (r5 == 0) goto L_0x004e;
    L_0x0042:
        r5 = 4;
        goto L_0x004f;
    L_0x0044:
        r1 = "video/3gpp";
        r5 = r5.equals(r1);
        if (r5 == 0) goto L_0x004e;
    L_0x004c:
        r5 = 0;
        goto L_0x004f;
    L_0x004e:
        r5 = -1;
    L_0x004f:
        switch(r5) {
            case 0: goto L_0x0075;
            case 1: goto L_0x0075;
            case 2: goto L_0x0059;
            case 3: goto L_0x0056;
            case 4: goto L_0x0053;
            case 5: goto L_0x0053;
            default: goto L_0x0052;
        };
    L_0x0052:
        return r0;
    L_0x0053:
        r6 = r6 * r7;
        goto L_0x0078;
    L_0x0056:
        r6 = r6 * r7;
        goto L_0x0077;
    L_0x0059:
        r5 = "BRAVIA 4K 2015";
        r1 = com.google.android.exoplayer2.p164l.C2541v.f6470d;
        r5 = r5.equals(r1);
        if (r5 == 0) goto L_0x0064;
    L_0x0063:
        return r0;
    L_0x0064:
        r5 = 16;
        r6 = com.google.android.exoplayer2.p164l.C2541v.m7163a(r6, r5);
        r7 = com.google.android.exoplayer2.p164l.C2541v.m7163a(r7, r5);
        r6 = r6 * r7;
        r6 = r6 * 16;
        r6 = r6 * 16;
        goto L_0x0077;
    L_0x0075:
        r6 = r6 * r7;
    L_0x0077:
        r3 = 2;
    L_0x0078:
        r6 = r6 * 3;
        r3 = r3 * 2;
        r6 = r6 / r3;
        return r6;
    L_0x007e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.m.e.a(java.lang.String, int, int):int");
    }

    /* renamed from: a */
    private static void m17590a(MediaCodec mediaCodec, int i) {
        mediaCodec.setVideoScalingMode(i);
    }

    /* renamed from: K */
    private static boolean m17587K() {
        return C2541v.f6467a <= 22 && "foster".equals(C2541v.f6468b) && "NVIDIA".equals(C2541v.f6469c);
    }

    /* renamed from: a */
    private static boolean m17594a(String str) {
        if (!(("deb".equals(C2541v.f6468b) || "flo".equals(C2541v.f6468b)) && "OMX.qcom.video.decoder.avc".equals(str))) {
            if ((!"tcl_eu".equals(C2541v.f6468b) && !"SVP-DTV15".equals(C2541v.f6468b) && !"BRAVIA_ATV2".equals(C2541v.f6468b)) || "OMX.MTK.VIDEO.DECODER.AVC".equals(str) == null) {
                return null;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m17595a(boolean z, C2515k c2515k, C2515k c2515k2) {
        return c2515k.f6380f.equals(c2515k2.f6380f) && C4899e.m17600e(c2515k) == C4899e.m17600e(c2515k2) && (z || (c2515k.f6384j == c2515k2.f6384j && c2515k.f6385k == c2515k2.f6385k));
    }

    /* renamed from: d */
    private static float m17598d(C2515k c2515k) {
        return c2515k.f6388n == -1.0f ? 1.0f : c2515k.f6388n;
    }

    /* renamed from: e */
    private static int m17600e(C2515k c2515k) {
        return c2515k.f6387m == -1 ? null : c2515k.f6387m;
    }
}
