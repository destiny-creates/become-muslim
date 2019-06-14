package com.google.android.exoplayer2.p134a;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.AudioFormat;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import com.google.android.exoplayer2.C2251b;
import com.google.android.exoplayer2.C2573r;
import com.google.android.exoplayer2.p134a.C2235f.C2231a;
import com.google.android.exoplayer2.p134a.C2235f.C2233c;
import com.google.android.exoplayer2.p134a.C2235f.C2234d;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2541v;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;

/* compiled from: DefaultAudioSink */
/* renamed from: com.google.android.exoplayer2.a.h */
public final class C4080h implements C2235f {
    /* renamed from: a */
    public static boolean f10234a = false;
    /* renamed from: b */
    public static boolean f10235b = false;
    /* renamed from: A */
    private long f10236A;
    /* renamed from: B */
    private ByteBuffer f10237B;
    /* renamed from: C */
    private int f10238C;
    /* renamed from: D */
    private int f10239D;
    /* renamed from: E */
    private int f10240E;
    /* renamed from: F */
    private long f10241F;
    /* renamed from: G */
    private long f10242G;
    /* renamed from: H */
    private boolean f10243H;
    /* renamed from: I */
    private long f10244I;
    /* renamed from: J */
    private Method f10245J;
    /* renamed from: K */
    private int f10246K;
    /* renamed from: L */
    private long f10247L;
    /* renamed from: M */
    private long f10248M;
    /* renamed from: N */
    private int f10249N;
    /* renamed from: O */
    private long f10250O;
    /* renamed from: P */
    private long f10251P;
    /* renamed from: Q */
    private int f10252Q;
    /* renamed from: R */
    private int f10253R;
    /* renamed from: S */
    private long f10254S;
    /* renamed from: T */
    private long f10255T;
    /* renamed from: U */
    private long f10256U;
    /* renamed from: V */
    private float f10257V;
    /* renamed from: W */
    private C2222d[] f10258W;
    /* renamed from: X */
    private ByteBuffer[] f10259X;
    /* renamed from: Y */
    private ByteBuffer f10260Y;
    /* renamed from: Z */
    private ByteBuffer f10261Z;
    private byte[] aa;
    private int ab;
    private int ac;
    private boolean ad;
    private boolean ae;
    private int af;
    private boolean ag;
    private boolean ah;
    private long ai;
    /* renamed from: c */
    private final C2220c f10262c;
    /* renamed from: d */
    private final C4078g f10263d;
    /* renamed from: e */
    private final C4084n f10264e;
    /* renamed from: f */
    private final C4083m f10265f;
    /* renamed from: g */
    private final C2222d[] f10266g;
    /* renamed from: h */
    private final ConditionVariable f10267h = new ConditionVariable(true);
    /* renamed from: i */
    private final long[] f10268i;
    /* renamed from: j */
    private final C2238a f10269j;
    /* renamed from: k */
    private final ArrayDeque<C2240d> f10270k;
    /* renamed from: l */
    private C2233c f10271l;
    /* renamed from: m */
    private AudioTrack f10272m;
    /* renamed from: n */
    private AudioTrack f10273n;
    /* renamed from: o */
    private boolean f10274o;
    /* renamed from: p */
    private int f10275p;
    /* renamed from: q */
    private int f10276q;
    /* renamed from: r */
    private int f10277r;
    /* renamed from: s */
    private int f10278s;
    /* renamed from: t */
    private C2219b f10279t;
    /* renamed from: u */
    private boolean f10280u;
    /* renamed from: v */
    private int f10281v;
    /* renamed from: w */
    private long f10282w;
    /* renamed from: x */
    private C2573r f10283x;
    /* renamed from: y */
    private C2573r f10284y;
    /* renamed from: z */
    private long f10285z;

    /* compiled from: DefaultAudioSink */
    /* renamed from: com.google.android.exoplayer2.a.h$a */
    private static class C2238a {
        /* renamed from: a */
        protected AudioTrack f5311a;
        /* renamed from: b */
        private boolean f5312b;
        /* renamed from: c */
        private int f5313c;
        /* renamed from: d */
        private long f5314d;
        /* renamed from: e */
        private long f5315e;
        /* renamed from: f */
        private long f5316f;
        /* renamed from: g */
        private long f5317g;
        /* renamed from: h */
        private long f5318h;
        /* renamed from: i */
        private long f5319i;
        /* renamed from: j */
        private long f5320j;

        /* renamed from: d */
        public boolean mo2120d() {
            return false;
        }

        private C2238a() {
        }

        /* renamed from: a */
        public void mo2119a(AudioTrack audioTrack, boolean z) {
            this.f5311a = audioTrack;
            this.f5312b = z;
            this.f5317g = -9223372036854775807L;
            this.f5318h = -9223372036854775807L;
            this.f5314d = 0;
            this.f5315e = 0;
            this.f5316f = 0;
            if (audioTrack != null) {
                this.f5313c = audioTrack.getSampleRate();
            }
        }

        /* renamed from: a */
        public void m6166a(long j) {
            this.f5319i = m6168b();
            this.f5317g = SystemClock.elapsedRealtime() * 1000;
            this.f5320j = j;
            this.f5311a.stop();
        }

        /* renamed from: a */
        public void m6165a() {
            if (this.f5317g == -9223372036854775807L) {
                this.f5311a.pause();
            }
        }

        /* renamed from: b */
        public boolean m6169b(long j) {
            return (this.f5318h == -9223372036854775807L || j <= 0 || SystemClock.elapsedRealtime() - this.f5318h < 200) ? 0 : 1;
        }

        /* renamed from: b */
        public long m6168b() {
            if (this.f5317g != -9223372036854775807L) {
                return Math.min(this.f5320j, this.f5319i + ((((SystemClock.elapsedRealtime() * 1000) - this.f5317g) * ((long) this.f5313c)) / 1000000));
            }
            int playState = this.f5311a.getPlayState();
            if (playState == 1) {
                return 0;
            }
            long playbackHeadPosition = 4294967295L & ((long) this.f5311a.getPlaybackHeadPosition());
            if (this.f5312b) {
                if (playState == 2 && playbackHeadPosition == 0) {
                    this.f5316f = this.f5314d;
                }
                playbackHeadPosition += this.f5316f;
            }
            if (C2541v.f6467a <= 26) {
                if (playbackHeadPosition == 0 && this.f5314d > 0 && playState == 3) {
                    if (this.f5318h == -9223372036854775807L) {
                        this.f5318h = SystemClock.elapsedRealtime();
                    }
                    return this.f5314d;
                }
                this.f5318h = -9223372036854775807L;
            }
            if (this.f5314d > playbackHeadPosition) {
                this.f5315e++;
            }
            this.f5314d = playbackHeadPosition;
            return playbackHeadPosition + (this.f5315e << 32);
        }

        /* renamed from: c */
        public long m6170c() {
            return (m6168b() * 1000000) / ((long) this.f5313c);
        }

        /* renamed from: e */
        public long mo2121e() {
            throw new UnsupportedOperationException();
        }

        /* renamed from: f */
        public long mo2122f() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: DefaultAudioSink */
    /* renamed from: com.google.android.exoplayer2.a.h$c */
    public static final class C2239c extends RuntimeException {
        public C2239c(String str) {
            super(str);
        }
    }

    /* compiled from: DefaultAudioSink */
    /* renamed from: com.google.android.exoplayer2.a.h$d */
    private static final class C2240d {
        /* renamed from: a */
        private final C2573r f5321a;
        /* renamed from: b */
        private final long f5322b;
        /* renamed from: c */
        private final long f5323c;

        private C2240d(C2573r c2573r, long j, long j2) {
            this.f5321a = c2573r;
            this.f5322b = j;
            this.f5323c = j2;
        }
    }

    @TargetApi(19)
    /* compiled from: DefaultAudioSink */
    /* renamed from: com.google.android.exoplayer2.a.h$b */
    private static class C4079b extends C2238a {
        /* renamed from: b */
        private final AudioTimestamp f10230b = new AudioTimestamp();
        /* renamed from: c */
        private long f10231c;
        /* renamed from: d */
        private long f10232d;
        /* renamed from: e */
        private long f10233e;

        public C4079b() {
            super();
        }

        /* renamed from: a */
        public void mo2119a(AudioTrack audioTrack, boolean z) {
            super.mo2119a(audioTrack, z);
            this.f10231c = 0;
            this.f10232d = 0;
            this.f10233e = 0;
        }

        /* renamed from: d */
        public boolean mo2120d() {
            boolean timestamp = this.a.getTimestamp(this.f10230b);
            if (timestamp) {
                long j = this.f10230b.framePosition;
                if (this.f10232d > j) {
                    this.f10231c++;
                }
                this.f10232d = j;
                this.f10233e = j + (this.f10231c << 32);
            }
            return timestamp;
        }

        /* renamed from: e */
        public long mo2121e() {
            return this.f10230b.nanoTime;
        }

        /* renamed from: f */
        public long mo2122f() {
            return this.f10233e;
        }
    }

    /* renamed from: d */
    private static boolean m12674d(int i) {
        if (!(i == 3 || i == 2 || i == LinearLayoutManager.INVALID_OFFSET || i == 1073741824)) {
            if (i != 4) {
                return false;
            }
        }
        return true;
    }

    public C4080h(com.google.android.exoplayer2.p134a.C2220c r5, com.google.android.exoplayer2.p134a.C2222d[] r6) {
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
        r4 = this;
        r4.<init>();
        r4.f10262c = r5;
        r5 = new android.os.ConditionVariable;
        r0 = 1;
        r5.<init>(r0);
        r4.f10267h = r5;
        r5 = com.google.android.exoplayer2.p164l.C2541v.f6467a;
        r1 = 0;
        r2 = 18;
        if (r5 < r2) goto L_0x0023;
    L_0x0014:
        r5 = android.media.AudioTrack.class;	 Catch:{ NoSuchMethodException -> 0x0022 }
        r2 = "getLatency";	 Catch:{ NoSuchMethodException -> 0x0022 }
        r3 = r1;	 Catch:{ NoSuchMethodException -> 0x0022 }
        r3 = (java.lang.Class[]) r3;	 Catch:{ NoSuchMethodException -> 0x0022 }
        r5 = r5.getMethod(r2, r3);	 Catch:{ NoSuchMethodException -> 0x0022 }
        r4.f10245J = r5;	 Catch:{ NoSuchMethodException -> 0x0022 }
        goto L_0x0023;
    L_0x0023:
        r5 = com.google.android.exoplayer2.p164l.C2541v.f6467a;
        r2 = 19;
        if (r5 < r2) goto L_0x0031;
    L_0x0029:
        r5 = new com.google.android.exoplayer2.a.h$b;
        r5.<init>();
        r4.f10269j = r5;
        goto L_0x0038;
    L_0x0031:
        r5 = new com.google.android.exoplayer2.a.h$a;
        r5.<init>();
        r4.f10269j = r5;
    L_0x0038:
        r5 = new com.google.android.exoplayer2.a.g;
        r5.<init>();
        r4.f10263d = r5;
        r5 = new com.google.android.exoplayer2.a.n;
        r5.<init>();
        r4.f10264e = r5;
        r5 = new com.google.android.exoplayer2.a.m;
        r5.<init>();
        r4.f10265f = r5;
        r5 = r6.length;
        r5 = r5 + 4;
        r5 = new com.google.android.exoplayer2.p134a.C2222d[r5];
        r4.f10266g = r5;
        r5 = r4.f10266g;
        r1 = new com.google.android.exoplayer2.a.k;
        r1.<init>();
        r2 = 0;
        r5[r2] = r1;
        r5 = r4.f10266g;
        r1 = r4.f10263d;
        r5[r0] = r1;
        r5 = r4.f10266g;
        r0 = 2;
        r1 = r4.f10264e;
        r5[r0] = r1;
        r5 = r4.f10266g;
        r0 = r6.length;
        r1 = 3;
        java.lang.System.arraycopy(r6, r2, r5, r1, r0);
        r5 = r4.f10266g;
        r6 = r6.length;
        r6 = r6 + r1;
        r0 = r4.f10265f;
        r5[r6] = r0;
        r5 = 10;
        r5 = new long[r5];
        r4.f10268i = r5;
        r5 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r4.f10257V = r5;
        r4.f10253R = r2;
        r5 = com.google.android.exoplayer2.p134a.C2219b.f5278a;
        r4.f10279t = r5;
        r4.af = r2;
        r5 = com.google.android.exoplayer2.C2573r.f6571a;
        r4.f10284y = r5;
        r5 = -1;
        r4.ac = r5;
        r5 = new com.google.android.exoplayer2.p134a.C2222d[r2];
        r4.f10258W = r5;
        r5 = new java.nio.ByteBuffer[r2];
        r4.f10259X = r5;
        r5 = new java.util.ArrayDeque;
        r5.<init>();
        r4.f10270k = r5;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a.h.<init>(com.google.android.exoplayer2.a.c, com.google.android.exoplayer2.a.d[]):void");
    }

    /* renamed from: a */
    public void mo2129a(C2233c c2233c) {
        this.f10271l = c2233c;
    }

    /* renamed from: a */
    public boolean mo2130a(int i) {
        boolean z = false;
        if (C4080h.m12674d(i)) {
            if (i != 4 || C2541v.f6467a >= 21) {
                z = true;
            }
            return z;
        }
        if (!(this.f10262c == null || this.f10262c.m6118a(i) == 0)) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public long mo2123a(boolean z) {
        if (!m12681p()) {
            return Long.MIN_VALUE;
        }
        if (this.f10273n.getPlayState() == 3) {
            m12682q();
        }
        long nanoTime = System.nanoTime() / 1000;
        if (this.f10243H) {
            nanoTime = m12673d(this.f10269j.mo2122f() + m12675e(nanoTime - (this.f10269j.mo2121e() / 1000)));
        } else {
            if (this.f10240E == 0) {
                nanoTime = this.f10269j.m6170c();
            } else {
                nanoTime += this.f10241F;
            }
            if (!z) {
                nanoTime -= this.f10256U;
            }
        }
        return this.f10254S + m12668b(Math.min(nanoTime, m12673d(m12685t())));
    }

    /* renamed from: a */
    public void mo2127a(int i, int i2, int i3, int i4, int[] iArr, int i5, int i6) {
        this.f10275p = i3;
        this.f10274o = C4080h.m12674d(i);
        if (this.f10274o) {
            this.f10246K = C2541v.m7183b(i, i2);
        }
        int i7 = 4;
        boolean z = true;
        boolean z2 = this.f10274o && i != 4;
        if (z2) {
            this.f10264e.m12738a(i5, i6);
            this.f10263d.m12647a(iArr);
            iArr = this.f10266g;
            i5 = iArr.length;
            int i8 = i;
            i6 = i3;
            i = 0;
            i3 = 0;
            while (i < i5) {
                C2222d c2222d = iArr[i];
                try {
                    i3 |= c2222d.mo2110a(i6, i2, i8);
                    if (c2222d.mo2109a()) {
                        i2 = c2222d.mo2111b();
                        i6 = c2222d.mo2113d();
                        i8 = c2222d.mo2112c();
                    }
                    i++;
                } catch (Throwable e) {
                    throw new C2231a(e);
                }
            }
            i = i8;
        } else {
            i6 = i3;
            i3 = 0;
        }
        iArr = 252;
        switch (i2) {
            case 1:
                break;
            case 2:
                i7 = 12;
                break;
            case 3:
                i7 = 28;
                break;
            case 4:
                i7 = 204;
                break;
            case 5:
                i7 = 220;
                break;
            case 6:
                i7 = 252;
                break;
            case 7:
                i7 = 1276;
                break;
            case 8:
                i7 = C2251b.f5375a;
                break;
            default:
                i3 = new StringBuilder();
                i3.append("Unsupported channel count: ");
                i3.append(i2);
                throw new C2231a(i3.toString());
        }
        if (C2541v.f6467a <= 23 && "foster".equals(C2541v.f6468b) && "NVIDIA".equals(C2541v.f6469c)) {
            if (!(i2 == 3 || i2 == 5)) {
                if (i2 == 7) {
                    iArr = C2251b.f5375a;
                }
            }
            if (C2541v.f6467a <= 25 && "fugu".equals(C2541v.f6468b) && !this.f10274o && i2 == 1) {
                iArr = 12;
            }
            if (i3 == 0 || m12683r() == 0 || this.f10278s != i || this.f10276q != i6 || this.f10277r != iArr) {
                mo2140i();
                this.f10280u = z2;
                this.f10276q = i6;
                this.f10277r = iArr;
                this.f10278s = i;
                if (this.f10274o != 0) {
                    this.f10249N = C2541v.m7183b(this.f10278s, i2);
                }
                if (i4 != 0) {
                    this.f10281v = i4;
                } else if (this.f10274o == 0) {
                    i = AudioTrack.getMinBufferSize(i6, iArr, this.f10278s);
                    if (i != -2) {
                        z = false;
                    }
                    C2516a.m7019b(z);
                    this.f10281v = C2541v.m7164a(i * 4, ((int) m12675e(250000)) * this.f10249N, (int) Math.max((long) i, m12675e(750000) * ((long) this.f10249N)));
                } else {
                    if (this.f10278s != 5) {
                        if (this.f10278s == 6) {
                            this.f10281v = 49152;
                        }
                    }
                    this.f10281v = 20480;
                }
                this.f10282w = this.f10274o == 0 ? m12673d((long) (this.f10281v / this.f10249N)) : -9223372036854775807L;
            }
            return;
        }
        iArr = i7;
        iArr = 12;
        if (i3 == 0) {
        }
        mo2140i();
        this.f10280u = z2;
        this.f10276q = i6;
        this.f10277r = iArr;
        this.f10278s = i;
        if (this.f10274o != 0) {
            this.f10249N = C2541v.m7183b(this.f10278s, i2);
        }
        if (i4 != 0) {
            this.f10281v = i4;
        } else if (this.f10274o == 0) {
            if (this.f10278s != 5) {
                if (this.f10278s == 6) {
                    this.f10281v = 49152;
                }
            }
            this.f10281v = 20480;
        } else {
            i = AudioTrack.getMinBufferSize(i6, iArr, this.f10278s);
            if (i != -2) {
                z = false;
            }
            C2516a.m7019b(z);
            this.f10281v = C2541v.m7164a(i * 4, ((int) m12675e(250000)) * this.f10249N, (int) Math.max((long) i, m12675e(750000) * ((long) this.f10249N)));
        }
        if (this.f10274o == 0) {
        }
        this.f10282w = this.f10274o == 0 ? m12673d((long) (this.f10281v / this.f10249N)) : -9223372036854775807L;
    }

    /* renamed from: k */
    private void m12676k() {
        ArrayList arrayList = new ArrayList();
        for (C2222d c2222d : this.f10266g) {
            if (c2222d.mo2109a()) {
                arrayList.add(c2222d);
            } else {
                c2222d.mo2117h();
            }
        }
        int size = arrayList.size();
        this.f10258W = (C2222d[]) arrayList.toArray(new C2222d[size]);
        this.f10259X = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            C2222d c2222d2 = this.f10258W[i];
            c2222d2.mo2117h();
            this.f10259X[i] = c2222d2.mo2115f();
        }
    }

    /* renamed from: l */
    private void m12677l() {
        this.f10267h.block();
        this.f10273n = m12689x();
        mo2124a(this.f10284y);
        m12676k();
        int audioSessionId = this.f10273n.getAudioSessionId();
        if (f10234a && C2541v.f6467a < 21) {
            if (!(this.f10272m == null || audioSessionId == this.f10272m.getAudioSessionId())) {
                m12680o();
            }
            if (this.f10272m == null) {
                this.f10272m = m12672c(audioSessionId);
            }
        }
        if (this.af != audioSessionId) {
            this.af = audioSessionId;
            if (this.f10271l != null) {
                this.f10271l.mo2143a(audioSessionId);
            }
        }
        this.f10269j.mo2119a(this.f10273n, m12687v());
        m12679n();
        this.ah = false;
    }

    /* renamed from: a */
    public void mo2125a() {
        this.ae = true;
        if (m12683r()) {
            this.f10255T = System.nanoTime() / 1000;
            this.f10273n.play();
        }
    }

    /* renamed from: b */
    public void mo2132b() {
        if (this.f10253R == 1) {
            this.f10253R = 2;
        }
    }

    /* renamed from: a */
    public boolean mo2131a(ByteBuffer byteBuffer, long j) {
        boolean z;
        long c;
        int i;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j2 = j;
        if (this.f10260Y != null) {
            if (byteBuffer2 != r0.f10260Y) {
                z = false;
                C2516a.m7017a(z);
                if (!m12683r()) {
                    m12677l();
                    if (r0.ae) {
                        mo2125a();
                    }
                }
                if (m12687v()) {
                    if (r0.f10273n.getPlayState() != 2) {
                        r0.ah = false;
                        return false;
                    } else if (r0.f10273n.getPlayState() == 1 && r0.f10269j.m6168b() != 0) {
                        return false;
                    }
                }
                z = r0.ah;
                r0.ah = mo2136e();
                if (!(!z || r0.ah || r0.f10273n.getPlayState() == 1 || r0.f10271l == null)) {
                    r0.f10271l.mo2144a(r0.f10281v, C2251b.m6221a(r0.f10282w), SystemClock.elapsedRealtime() - r0.ai);
                }
                if (r0.f10260Y == null) {
                    if (!byteBuffer.hasRemaining()) {
                        return true;
                    }
                    if (!r0.f10274o && r0.f10252Q == 0) {
                        r0.f10252Q = C4080h.m12662a(r0.f10278s, byteBuffer2);
                    }
                    if (r0.f10283x != null) {
                        if (!m12678m()) {
                            return false;
                        }
                        ArrayDeque arrayDeque = r0.f10270k;
                        C2240d c2240d = r11;
                        C2240d c2240d2 = new C2240d(r0.f10283x, Math.max(0, j2), m12673d(m12685t()));
                        arrayDeque.add(c2240d);
                        r0.f10283x = null;
                        m12676k();
                    }
                    if (r0.f10253R != 0) {
                        r0.f10254S = Math.max(0, j2);
                        r0.f10253R = 1;
                    } else {
                        c = r0.f10254S + m12671c(m12684s());
                        if (r0.f10253R == 1 || Math.abs(c - j2) <= 200000) {
                            i = 2;
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Discontinuity detected [expected ");
                            stringBuilder.append(c);
                            stringBuilder.append(", got ");
                            stringBuilder.append(j2);
                            stringBuilder.append("]");
                            Log.e("AudioTrack", stringBuilder.toString());
                            i = 2;
                            r0.f10253R = 2;
                        }
                        if (r0.f10253R == i) {
                            r0.f10254S += j2 - c;
                            r0.f10253R = 1;
                            if (r0.f10271l != null) {
                                r0.f10271l.mo2142a();
                            }
                        }
                    }
                    if (r0.f10274o) {
                        r0.f10248M += (long) r0.f10252Q;
                    } else {
                        r0.f10247L += (long) byteBuffer.remaining();
                    }
                    r0.f10260Y = byteBuffer2;
                }
                if (r0.f10280u) {
                    m12670b(r0.f10260Y, j2);
                } else {
                    m12666a(j2);
                }
                if (!r0.f10260Y.hasRemaining()) {
                    r0.f10260Y = null;
                    return true;
                } else if (r0.f10269j.m6169b(m12685t())) {
                    return false;
                } else {
                    Log.w("AudioTrack", "Resetting stalled audio track");
                    mo2140i();
                    return true;
                }
            }
        }
        z = true;
        C2516a.m7017a(z);
        if (m12683r()) {
            m12677l();
            if (r0.ae) {
                mo2125a();
            }
        }
        if (m12687v()) {
            if (r0.f10273n.getPlayState() != 2) {
                return false;
            }
            r0.ah = false;
            return false;
        }
        z = r0.ah;
        r0.ah = mo2136e();
        r0.f10271l.mo2144a(r0.f10281v, C2251b.m6221a(r0.f10282w), SystemClock.elapsedRealtime() - r0.ai);
        if (r0.f10260Y == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            r0.f10252Q = C4080h.m12662a(r0.f10278s, byteBuffer2);
            if (r0.f10283x != null) {
                if (!m12678m()) {
                    return false;
                }
                ArrayDeque arrayDeque2 = r0.f10270k;
                C2240d c2240d3 = c2240d2;
                C2240d c2240d22 = new C2240d(r0.f10283x, Math.max(0, j2), m12673d(m12685t()));
                arrayDeque2.add(c2240d3);
                r0.f10283x = null;
                m12676k();
            }
            if (r0.f10253R != 0) {
                c = r0.f10254S + m12671c(m12684s());
                if (r0.f10253R == 1) {
                }
                i = 2;
                if (r0.f10253R == i) {
                    r0.f10254S += j2 - c;
                    r0.f10253R = 1;
                    if (r0.f10271l != null) {
                        r0.f10271l.mo2142a();
                    }
                }
            } else {
                r0.f10254S = Math.max(0, j2);
                r0.f10253R = 1;
            }
            if (r0.f10274o) {
                r0.f10248M += (long) r0.f10252Q;
            } else {
                r0.f10247L += (long) byteBuffer.remaining();
            }
            r0.f10260Y = byteBuffer2;
        }
        if (r0.f10280u) {
            m12670b(r0.f10260Y, j2);
        } else {
            m12666a(j2);
        }
        if (!r0.f10260Y.hasRemaining()) {
            r0.f10260Y = null;
            return true;
        } else if (r0.f10269j.m6169b(m12685t())) {
            return false;
        } else {
            Log.w("AudioTrack", "Resetting stalled audio track");
            mo2140i();
            return true;
        }
    }

    /* renamed from: a */
    private void m12666a(long j) {
        int length = this.f10258W.length;
        int i = length;
        while (i >= 0) {
            ByteBuffer byteBuffer = i > 0 ? this.f10259X[i - 1] : this.f10260Y != null ? this.f10260Y : C2222d.f5286a;
            if (i == length) {
                m12670b(byteBuffer, j);
            } else {
                C2222d c2222d = this.f10258W[i];
                c2222d.mo2108a(byteBuffer);
                ByteBuffer f = c2222d.mo2115f();
                this.f10259X[i] = f;
                if (f.hasRemaining()) {
                    i++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i--;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    private void m12670b(ByteBuffer byteBuffer, long j) {
        if (byteBuffer.hasRemaining()) {
            int remaining;
            boolean z = true;
            int i = 0;
            if (this.f10261Z != null) {
                C2516a.m7017a(this.f10261Z == byteBuffer);
            } else {
                this.f10261Z = byteBuffer;
                if (C2541v.f6467a < 21) {
                    remaining = byteBuffer.remaining();
                    if (this.aa == null || this.aa.length < remaining) {
                        this.aa = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.aa, 0, remaining);
                    byteBuffer.position(position);
                    this.ab = 0;
                }
            }
            remaining = byteBuffer.remaining();
            if (C2541v.f6467a < 21) {
                int b = this.f10281v - ((int) (this.f10250O - (this.f10269j.m6168b() * ((long) this.f10249N))));
                if (b > 0) {
                    i = this.f10273n.write(this.aa, this.ab, Math.min(remaining, b));
                    if (i > 0) {
                        this.ab += i;
                        byteBuffer.position(byteBuffer.position() + i);
                    }
                }
            } else if (this.ag) {
                if (j == -9223372036854775807L) {
                    z = false;
                }
                C2516a.m7019b(z);
                i = m12664a(this.f10273n, byteBuffer, remaining, j);
            } else {
                i = C4080h.m12663a(this.f10273n, byteBuffer, remaining);
            }
            this.ai = SystemClock.elapsedRealtime();
            if (i >= 0) {
                if (this.f10274o != null) {
                    this.f10250O += (long) i;
                }
                if (i == remaining) {
                    if (this.f10274o == null) {
                        this.f10251P += (long) this.f10252Q;
                    }
                    this.f10261Z = null;
                }
                return;
            }
            throw new C2234d(i);
        }
    }

    /* renamed from: c */
    public void mo2134c() {
        if (!this.ad) {
            if (m12683r()) {
                if (m12678m()) {
                    this.f10269j.m6166a(m12685t());
                    this.f10238C = 0;
                    this.ad = true;
                }
            }
        }
    }

    /* renamed from: m */
    private boolean m12678m() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:37)
	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:61)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r8 = this;
        r0 = r8.ac;
        r1 = -1;
        r2 = 1;
        r3 = 0;
        if (r0 != r1) goto L_0x0014;
    L_0x0007:
        r0 = r8.f10280u;
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        r0 = 0;
        goto L_0x0010;
    L_0x000d:
        r0 = r8.f10258W;
        r0 = r0.length;
    L_0x0010:
        r8.ac = r0;
    L_0x0012:
        r0 = 1;
        goto L_0x0015;
    L_0x0014:
        r0 = 0;
    L_0x0015:
        r4 = r8.ac;
        r5 = r8.f10258W;
        r5 = r5.length;
        r6 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        if (r4 >= r5) goto L_0x003c;
    L_0x0021:
        r4 = r8.f10258W;
        r5 = r8.ac;
        r4 = r4[r5];
        if (r0 == 0) goto L_0x002c;
    L_0x0029:
        r4.mo2114e();
    L_0x002c:
        r8.m12666a(r6);
        r0 = r4.mo2116g();
        if (r0 != 0) goto L_0x0036;
    L_0x0035:
        return r3;
    L_0x0036:
        r0 = r8.ac;
        r0 = r0 + r2;
        r8.ac = r0;
        goto L_0x0012;
    L_0x003c:
        r0 = r8.f10261Z;
        if (r0 == 0) goto L_0x004a;
    L_0x0040:
        r0 = r8.f10261Z;
        r8.m12670b(r0, r6);
        r0 = r8.f10261Z;
        if (r0 == 0) goto L_0x004a;
    L_0x0049:
        return r3;
    L_0x004a:
        r8.ac = r1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a.h.m():boolean");
    }

    /* renamed from: d */
    public boolean mo2135d() {
        if (m12683r()) {
            if (!this.ad || mo2136e()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    public boolean mo2136e() {
        return m12683r() && (m12685t() > this.f10269j.m6168b() || m12688w());
    }

    /* renamed from: a */
    public C2573r mo2124a(C2573r c2573r) {
        if (!m12683r() || this.f10280u) {
            C2573r c2573r2 = new C2573r(this.f10265f.m12724a(c2573r.f6572b), this.f10265f.m12729b(c2573r.f6573c));
            c2573r = this.f10283x != null ? this.f10283x : this.f10270k.isEmpty() == null ? ((C2240d) this.f10270k.getLast()).f5321a : this.f10284y;
            if (c2573r2.equals(c2573r) == null) {
                if (m12683r() != null) {
                    this.f10283x = c2573r2;
                } else {
                    this.f10284y = c2573r2;
                }
            }
            return this.f10284y;
        }
        this.f10284y = C2573r.f6571a;
        return this.f10284y;
    }

    /* renamed from: f */
    public C2573r mo2137f() {
        return this.f10284y;
    }

    /* renamed from: a */
    public void mo2128a(C2219b c2219b) {
        if (!this.f10279t.equals(c2219b)) {
            this.f10279t = c2219b;
            if (this.ag == null) {
                mo2140i();
                this.af = null;
            }
        }
    }

    /* renamed from: b */
    public void mo2133b(int i) {
        C2516a.m7019b(C2541v.f6467a >= 21);
        if (!this.ag || this.af != i) {
            this.ag = true;
            this.af = i;
            mo2140i();
        }
    }

    /* renamed from: g */
    public void mo2138g() {
        if (this.ag) {
            this.ag = false;
            this.af = 0;
            mo2140i();
        }
    }

    /* renamed from: a */
    public void mo2126a(float f) {
        if (this.f10257V != f) {
            this.f10257V = f;
            m12679n();
        }
    }

    /* renamed from: n */
    private void m12679n() {
        if (!m12683r()) {
            return;
        }
        if (C2541v.f6467a >= 21) {
            C4080h.m12667a(this.f10273n, this.f10257V);
        } else {
            C4080h.m12669b(this.f10273n, this.f10257V);
        }
    }

    /* renamed from: h */
    public void mo2139h() {
        this.ae = false;
        if (m12683r()) {
            m12686u();
            this.f10269j.m6165a();
        }
    }

    /* renamed from: i */
    public void mo2140i() {
        if (m12683r()) {
            this.f10247L = 0;
            this.f10248M = 0;
            this.f10250O = 0;
            this.f10251P = 0;
            this.f10252Q = 0;
            if (this.f10283x != null) {
                this.f10284y = this.f10283x;
                this.f10283x = null;
            } else if (!this.f10270k.isEmpty()) {
                this.f10284y = ((C2240d) this.f10270k.getLast()).f5321a;
            }
            this.f10270k.clear();
            this.f10285z = 0;
            this.f10236A = 0;
            this.f10260Y = null;
            this.f10261Z = null;
            for (int i = 0; i < this.f10258W.length; i++) {
                C2222d c2222d = this.f10258W[i];
                c2222d.mo2117h();
                this.f10259X[i] = c2222d.mo2115f();
            }
            this.ad = false;
            this.ac = -1;
            this.f10237B = null;
            this.f10238C = 0;
            this.f10253R = 0;
            this.f10256U = 0;
            m12686u();
            if (this.f10273n.getPlayState() == 3) {
                this.f10273n.pause();
            }
            final AudioTrack audioTrack = this.f10273n;
            this.f10273n = null;
            this.f10269j.mo2119a(null, false);
            this.f10267h.close();
            new Thread(this) {
                /* renamed from: b */
                final /* synthetic */ C4080h f5308b;

                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        this.f5308b.f10267h.open();
                    }
                }
            }.start();
        }
    }

    /* renamed from: j */
    public void mo2141j() {
        mo2140i();
        m12680o();
        for (C2222d i : this.f10266g) {
            i.mo2118i();
        }
        this.af = 0;
        this.ae = false;
    }

    /* renamed from: o */
    private void m12680o() {
        if (this.f10272m != null) {
            final AudioTrack audioTrack = this.f10272m;
            this.f10272m = null;
            new Thread(this) {
                /* renamed from: b */
                final /* synthetic */ C4080h f5310b;

                public void run() {
                    audioTrack.release();
                }
            }.start();
        }
    }

    /* renamed from: p */
    private boolean m12681p() {
        return m12683r() && this.f10253R != 0;
    }

    /* renamed from: b */
    private long m12668b(long j) {
        while (!this.f10270k.isEmpty() && j >= ((C2240d) this.f10270k.getFirst()).f5323c) {
            C2240d c2240d = (C2240d) this.f10270k.remove();
            this.f10284y = c2240d.f5321a;
            this.f10236A = c2240d.f5323c;
            this.f10285z = c2240d.f5322b - this.f10254S;
        }
        if (this.f10284y.f6572b == 1.0f) {
            return (j + this.f10285z) - this.f10236A;
        }
        if (this.f10270k.isEmpty()) {
            return this.f10285z + this.f10265f.m12725a(j - this.f10236A);
        }
        return this.f10285z + ((long) (((double) this.f10284y.f6572b) * ((double) (j - this.f10236A))));
    }

    /* renamed from: q */
    private void m12682q() {
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
        r0 = r16;
        r1 = r0.f10269j;
        r1 = r1.m6170c();
        r3 = 0;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 != 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r5 = java.lang.System.nanoTime();
        r7 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r5 = r5 / r7;
        r9 = r0.f10242G;
        r9 = r5 - r9;
        r11 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r13 = 0;
        r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1));
        if (r9 < 0) goto L_0x0057;
    L_0x0021:
        r9 = r0.f10268i;
        r10 = r0.f10239D;
        r11 = r1 - r5;
        r9[r10] = r11;
        r9 = r0.f10239D;
        r9 = r9 + 1;
        r10 = 10;
        r9 = r9 % r10;
        r0.f10239D = r9;
        r9 = r0.f10240E;
        if (r9 >= r10) goto L_0x003c;
    L_0x0036:
        r9 = r0.f10240E;
        r9 = r9 + 1;
        r0.f10240E = r9;
    L_0x003c:
        r0.f10242G = r5;
        r0.f10241F = r3;
        r9 = 0;
    L_0x0041:
        r10 = r0.f10240E;
        if (r9 >= r10) goto L_0x0057;
    L_0x0045:
        r10 = r0.f10241F;
        r12 = r0.f10268i;
        r14 = r12[r9];
        r12 = r0.f10240E;
        r3 = (long) r12;
        r14 = r14 / r3;
        r10 = r10 + r14;
        r0.f10241F = r10;
        r9 = r9 + 1;
        r3 = 0;
        goto L_0x0041;
    L_0x0057:
        r3 = r16.m12687v();
        if (r3 == 0) goto L_0x005e;
    L_0x005d:
        return;
    L_0x005e:
        r3 = r0.f10244I;
        r3 = r5 - r3;
        r9 = 500000; // 0x7a120 float:7.00649E-40 double:2.47033E-318;
        r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1));
        if (r3 < 0) goto L_0x01a1;
    L_0x0069:
        r3 = r0.f10269j;
        r3 = r3.mo2120d();
        r0.f10243H = r3;
        r3 = r0.f10243H;
        r9 = 5000000; // 0x4c4b40 float:7.006492E-39 double:2.470328E-317;
        if (r3 == 0) goto L_0x014d;
    L_0x0078:
        r3 = r0.f10269j;
        r3 = r3.mo2121e();
        r3 = r3 / r7;
        r11 = r0.f10269j;
        r11 = r11.mo2122f();
        r14 = r0.f10255T;
        r14 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1));
        if (r14 >= 0) goto L_0x008f;
    L_0x008b:
        r0.f10243H = r13;
        goto L_0x014d;
    L_0x008f:
        r14 = 0;
        r14 = r3 - r5;
        r14 = java.lang.Math.abs(r14);
        r14 = (r14 > r9 ? 1 : (r14 == r9 ? 0 : -1));
        if (r14 <= 0) goto L_0x00ed;
    L_0x009a:
        r14 = new java.lang.StringBuilder;
        r14.<init>();
        r15 = "Spurious audio timestamp (system clock mismatch): ";
        r14.append(r15);
        r14.append(r11);
        r11 = ", ";
        r14.append(r11);
        r14.append(r3);
        r3 = ", ";
        r14.append(r3);
        r14.append(r5);
        r3 = ", ";
        r14.append(r3);
        r14.append(r1);
        r1 = ", ";
        r14.append(r1);
        r1 = r16.m12684s();
        r14.append(r1);
        r1 = ", ";
        r14.append(r1);
        r1 = r16.m12685t();
        r14.append(r1);
        r1 = r14.toString();
        r2 = f10235b;
        if (r2 != 0) goto L_0x00e7;
    L_0x00df:
        r2 = "AudioTrack";
        android.util.Log.w(r2, r1);
        r0.f10243H = r13;
        goto L_0x014d;
    L_0x00e7:
        r2 = new com.google.android.exoplayer2.a.h$c;
        r2.<init>(r1);
        throw r2;
    L_0x00ed:
        r14 = r0.m12673d(r11);
        r14 = r14 - r1;
        r14 = java.lang.Math.abs(r14);
        r14 = (r14 > r9 ? 1 : (r14 == r9 ? 0 : -1));
        if (r14 <= 0) goto L_0x014d;
    L_0x00fa:
        r14 = new java.lang.StringBuilder;
        r14.<init>();
        r15 = "Spurious audio timestamp (frame position mismatch): ";
        r14.append(r15);
        r14.append(r11);
        r11 = ", ";
        r14.append(r11);
        r14.append(r3);
        r3 = ", ";
        r14.append(r3);
        r14.append(r5);
        r3 = ", ";
        r14.append(r3);
        r14.append(r1);
        r1 = ", ";
        r14.append(r1);
        r1 = r16.m12684s();
        r14.append(r1);
        r1 = ", ";
        r14.append(r1);
        r1 = r16.m12685t();
        r14.append(r1);
        r1 = r14.toString();
        r2 = f10235b;
        if (r2 != 0) goto L_0x0147;
    L_0x013f:
        r2 = "AudioTrack";
        android.util.Log.w(r2, r1);
        r0.f10243H = r13;
        goto L_0x014d;
    L_0x0147:
        r2 = new com.google.android.exoplayer2.a.h$c;
        r2.<init>(r1);
        throw r2;
    L_0x014d:
        r1 = r0.f10245J;
        if (r1 == 0) goto L_0x019f;
    L_0x0151:
        r1 = r0.f10274o;
        if (r1 == 0) goto L_0x019f;
    L_0x0155:
        r1 = 0;
        r2 = r0.f10245J;	 Catch:{ Exception -> 0x019d }
        r3 = r0.f10273n;	 Catch:{ Exception -> 0x019d }
        r4 = r1;	 Catch:{ Exception -> 0x019d }
        r4 = (java.lang.Object[]) r4;	 Catch:{ Exception -> 0x019d }
        r2 = r2.invoke(r3, r4);	 Catch:{ Exception -> 0x019d }
        r2 = (java.lang.Integer) r2;	 Catch:{ Exception -> 0x019d }
        r2 = r2.intValue();	 Catch:{ Exception -> 0x019d }
        r2 = (long) r2;	 Catch:{ Exception -> 0x019d }
        r2 = r2 * r7;	 Catch:{ Exception -> 0x019d }
        r7 = r0.f10282w;	 Catch:{ Exception -> 0x019d }
        r4 = 0;	 Catch:{ Exception -> 0x019d }
        r2 = r2 - r7;	 Catch:{ Exception -> 0x019d }
        r0.f10256U = r2;	 Catch:{ Exception -> 0x019d }
        r2 = r0.f10256U;	 Catch:{ Exception -> 0x019d }
        r7 = 0;	 Catch:{ Exception -> 0x019d }
        r2 = java.lang.Math.max(r2, r7);	 Catch:{ Exception -> 0x019d }
        r0.f10256U = r2;	 Catch:{ Exception -> 0x019d }
        r2 = r0.f10256U;	 Catch:{ Exception -> 0x019d }
        r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1));	 Catch:{ Exception -> 0x019d }
        if (r2 <= 0) goto L_0x019f;	 Catch:{ Exception -> 0x019d }
    L_0x0180:
        r2 = "AudioTrack";	 Catch:{ Exception -> 0x019d }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x019d }
        r3.<init>();	 Catch:{ Exception -> 0x019d }
        r4 = "Ignoring impossibly large audio latency: ";	 Catch:{ Exception -> 0x019d }
        r3.append(r4);	 Catch:{ Exception -> 0x019d }
        r7 = r0.f10256U;	 Catch:{ Exception -> 0x019d }
        r3.append(r7);	 Catch:{ Exception -> 0x019d }
        r3 = r3.toString();	 Catch:{ Exception -> 0x019d }
        android.util.Log.w(r2, r3);	 Catch:{ Exception -> 0x019d }
        r2 = 0;	 Catch:{ Exception -> 0x019d }
        r0.f10256U = r2;	 Catch:{ Exception -> 0x019d }
        goto L_0x019f;
    L_0x019d:
        r0.f10245J = r1;
    L_0x019f:
        r0.f10244I = r5;
    L_0x01a1:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a.h.q():void");
    }

    /* renamed from: r */
    private boolean m12683r() {
        return this.f10273n != null;
    }

    /* renamed from: c */
    private long m12671c(long j) {
        return (j * 1000000) / ((long) this.f10275p);
    }

    /* renamed from: d */
    private long m12673d(long j) {
        return (j * 1000000) / ((long) this.f10276q);
    }

    /* renamed from: e */
    private long m12675e(long j) {
        return (j * ((long) this.f10276q)) / 1000000;
    }

    /* renamed from: s */
    private long m12684s() {
        return this.f10274o ? this.f10247L / ((long) this.f10246K) : this.f10248M;
    }

    /* renamed from: t */
    private long m12685t() {
        return this.f10274o ? this.f10250O / ((long) this.f10249N) : this.f10251P;
    }

    /* renamed from: u */
    private void m12686u() {
        this.f10241F = 0;
        this.f10240E = 0;
        this.f10239D = 0;
        this.f10242G = 0;
        this.f10243H = false;
        this.f10244I = 0;
    }

    /* renamed from: v */
    private boolean m12687v() {
        return C2541v.f6467a < 23 && (this.f10278s == 5 || this.f10278s == 6);
    }

    /* renamed from: w */
    private boolean m12688w() {
        return m12687v() && this.f10273n.getPlayState() == 2 && this.f10273n.getPlaybackHeadPosition() == 0;
    }

    /* renamed from: x */
    private android.media.AudioTrack m12689x() {
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
        r9 = this;
        r0 = com.google.android.exoplayer2.p164l.C2541v.f6467a;
        r1 = 21;
        if (r0 < r1) goto L_0x000b;
    L_0x0006:
        r0 = r9.m12690y();
        goto L_0x0038;
    L_0x000b:
        r0 = r9.f10279t;
        r0 = r0.f5281d;
        r2 = com.google.android.exoplayer2.p164l.C2541v.m7187c(r0);
        r0 = r9.af;
        if (r0 != 0) goto L_0x0027;
    L_0x0017:
        r0 = new android.media.AudioTrack;
        r3 = r9.f10276q;
        r4 = r9.f10277r;
        r5 = r9.f10278s;
        r6 = r9.f10281v;
        r7 = 1;
        r1 = r0;
        r1.<init>(r2, r3, r4, r5, r6, r7);
        goto L_0x0038;
    L_0x0027:
        r0 = new android.media.AudioTrack;
        r3 = r9.f10276q;
        r4 = r9.f10277r;
        r5 = r9.f10278s;
        r6 = r9.f10281v;
        r7 = 1;
        r8 = r9.af;
        r1 = r0;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8);
    L_0x0038:
        r1 = r0.getState();
        r2 = 1;
        if (r1 != r2) goto L_0x0040;
    L_0x003f:
        return r0;
    L_0x0040:
        r0.release();	 Catch:{ Exception -> 0x0043 }
    L_0x0043:
        r0 = new com.google.android.exoplayer2.a.f$b;
        r2 = r9.f10276q;
        r3 = r9.f10277r;
        r4 = r9.f10281v;
        r0.<init>(r1, r2, r3, r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a.h.x():android.media.AudioTrack");
    }

    @TargetApi(21)
    /* renamed from: y */
    private AudioTrack m12690y() {
        AudioAttributes build;
        if (this.ag) {
            build = new Builder().setContentType(3).setFlags(16).setUsage(1).build();
        } else {
            build = this.f10279t.m6115a();
        }
        return new AudioTrack(build, new AudioFormat.Builder().setChannelMask(this.f10277r).setEncoding(this.f10278s).setSampleRate(this.f10276q).build(), this.f10281v, 1, this.af != 0 ? this.af : 0);
    }

    /* renamed from: c */
    private AudioTrack m12672c(int i) {
        return new AudioTrack(3, 4000, 4, 2, 2, 0, i);
    }

    /* renamed from: a */
    private static int m12662a(int i, ByteBuffer byteBuffer) {
        if (i != 7) {
            if (i != 8) {
                if (i == 5) {
                    return C2216a.m6107a();
                }
                if (i == 6) {
                    return C2216a.m6109a(byteBuffer);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected audio encoding: ");
                stringBuilder.append(i);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
        return C2241i.m6177a(byteBuffer);
    }

    @TargetApi(21)
    /* renamed from: a */
    private static int m12663a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    @TargetApi(21)
    /* renamed from: a */
    private int m12664a(AudioTrack audioTrack, ByteBuffer byteBuffer, int i, long j) {
        if (this.f10237B == null) {
            this.f10237B = ByteBuffer.allocate(16);
            this.f10237B.order(ByteOrder.BIG_ENDIAN);
            this.f10237B.putInt(1431633921);
        }
        if (this.f10238C == 0) {
            this.f10237B.putInt(4, i);
            this.f10237B.putLong(8, j * 1000);
            this.f10237B.position(0);
            this.f10238C = i;
        }
        j = this.f10237B.remaining();
        if (j > null) {
            int write = audioTrack.write(this.f10237B, j, 1);
            if (write < 0) {
                this.f10238C = 0;
                return write;
            } else if (write < j) {
                return 0;
            }
        }
        audioTrack = C4080h.m12663a(audioTrack, byteBuffer, i);
        if (audioTrack < null) {
            this.f10238C = 0;
            return audioTrack;
        }
        this.f10238C -= audioTrack;
        return audioTrack;
    }

    @TargetApi(21)
    /* renamed from: a */
    private static void m12667a(AudioTrack audioTrack, float f) {
        audioTrack.setVolume(f);
    }

    /* renamed from: b */
    private static void m12669b(AudioTrack audioTrack, float f) {
        audioTrack.setStereoVolume(f, f);
    }
}
