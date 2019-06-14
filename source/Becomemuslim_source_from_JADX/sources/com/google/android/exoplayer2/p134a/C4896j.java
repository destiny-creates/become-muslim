package com.google.android.exoplayer2.p134a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer2.C2330e;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.C2573r;
import com.google.android.exoplayer2.C4690a;
import com.google.android.exoplayer2.p134a.C2230e.C2229a;
import com.google.android.exoplayer2.p134a.C2235f.C2233c;
import com.google.android.exoplayer2.p136c.C2255a;
import com.google.android.exoplayer2.p136c.C2258c;
import com.google.android.exoplayer2.p136c.C4088e;
import com.google.android.exoplayer2.p144f.C2333a;
import com.google.android.exoplayer2.p144f.C2335c;
import com.google.android.exoplayer2.p144f.C4852b;
import com.google.android.exoplayer2.p164l.C2523h;
import com.google.android.exoplayer2.p164l.C2524i;
import com.google.android.exoplayer2.p164l.C2541v;
import java.nio.ByteBuffer;

@TargetApi(16)
/* compiled from: MediaCodecAudioRenderer */
/* renamed from: com.google.android.exoplayer2.a.j */
public class C4896j extends C4852b implements C2523h {
    /* renamed from: b */
    private final C2229a f14029b;
    /* renamed from: c */
    private final C2235f f14030c;
    /* renamed from: d */
    private boolean f14031d;
    /* renamed from: e */
    private boolean f14032e;
    /* renamed from: f */
    private MediaFormat f14033f;
    /* renamed from: g */
    private int f14034g;
    /* renamed from: h */
    private int f14035h;
    /* renamed from: i */
    private int f14036i;
    /* renamed from: j */
    private int f14037j;
    /* renamed from: k */
    private long f14038k;
    /* renamed from: l */
    private boolean f14039l;

    /* compiled from: MediaCodecAudioRenderer */
    /* renamed from: com.google.android.exoplayer2.a.j$a */
    private final class C4081a implements C2233c {
        /* renamed from: a */
        final /* synthetic */ C4896j f10286a;

        private C4081a(C4896j c4896j) {
            this.f10286a = c4896j;
        }

        /* renamed from: a */
        public void mo2143a(int i) {
            this.f10286a.f14029b.m6131a(i);
            this.f10286a.m17559b(i);
        }

        /* renamed from: a */
        public void mo2142a() {
            this.f10286a.mo3523v();
            this.f10286a.f14039l = true;
        }

        /* renamed from: a */
        public void mo2144a(int i, long j, long j2) {
            this.f10286a.f14029b.m6132a(i, j, j2);
            this.f10286a.m17550a(i, j, j2);
        }
    }

    /* renamed from: a */
    protected void m17550a(int i, long j, long j2) {
    }

    /* renamed from: b */
    protected void m17559b(int i) {
    }

    /* renamed from: c */
    public C2523h mo3184c() {
        return this;
    }

    /* renamed from: v */
    protected void mo3523v() {
    }

    public C4896j(C2335c c2335c, C2258c<C4088e> c2258c, boolean z, Handler handler, C2230e c2230e, C2220c c2220c, C2222d... c2222dArr) {
        this(c2335c, c2258c, z, handler, c2230e, new C4080h(c2220c, c2222dArr));
    }

    public C4896j(C2335c c2335c, C2258c<C4088e> c2258c, boolean z, Handler handler, C2230e c2230e, C2235f c2235f) {
        super(1, c2335c, c2258c, z);
        this.f14029b = new C2229a(handler, c2230e);
        this.f14030c = c2235f;
        c2235f.mo2129a(new C4081a());
    }

    /* renamed from: a */
    protected int mo3515a(C2335c c2335c, C2258c<C4088e> c2258c, C2515k c2515k) {
        String str = c2515k.f6380f;
        boolean z = false;
        if (!C2524i.m7050a(str)) {
            return 0;
        }
        int i = C2541v.f6467a >= 21 ? 32 : 0;
        c2258c = C4690a.m15998a((C2258c) c2258c, c2515k.f6383i);
        int i2 = 4;
        if (c2258c != null && mo3521a(str) && c2335c.mo2221a() != null) {
            return (i | 8) | 4;
        }
        int i3 = 1;
        if (("audio/raw".equals(str) && !this.f14030c.mo2130a(c2515k.f6394t)) || !this.f14030c.mo2130a(2)) {
            return 1;
        }
        boolean z2;
        C2255a c2255a = c2515k.f6383i;
        if (c2255a != null) {
            z2 = false;
            for (int i4 = 0; i4 < c2255a.f5387b; i4++) {
                z2 |= c2255a.m6232a(i4).f5383c;
            }
        } else {
            z2 = false;
        }
        C2333a a = c2335c.mo2222a(str, z2);
        if (a == null) {
            if (z2 && c2335c.mo2222a(str, false) != null) {
                i3 = 2;
            }
            return i3;
        } else if (c2258c == null) {
            return 2;
        } else {
            if (C2541v.f6467a < 21 || ((c2515k.f6393s == -1 || a.m6475a(c2515k.f6393s) != null) && (c2515k.f6392r == -1 || a.m6478b(c2515k.f6392r) != null))) {
                z = true;
            }
            if (!z) {
                i2 = 3;
            }
            return (i | 8) | i2;
        }
    }

    /* renamed from: a */
    protected C2333a mo3516a(C2335c c2335c, C2515k c2515k, boolean z) {
        if (mo3521a(c2515k.f6380f)) {
            C2333a a = c2335c.mo2221a();
            if (a != null) {
                this.f14031d = true;
                return a;
            }
        }
        this.f14031d = false;
        return super.mo3516a(c2335c, c2515k, z);
    }

    /* renamed from: a */
    protected boolean mo3521a(String str) {
        int h = C2524i.m7057h(str);
        return (h == null || this.f14030c.mo2130a(h) == null) ? null : true;
    }

    /* renamed from: a */
    protected void mo3518a(C2333a c2333a, MediaCodec mediaCodec, C2515k c2515k, MediaCrypto mediaCrypto) {
        this.f14032e = C4896j.m17546b(c2333a.f5786a);
        if (this.f14031d != null) {
            this.f14033f = c2515k.m7013b();
            this.f14033f.setString("mime", "audio/raw");
            mediaCodec.configure(this.f14033f, null, mediaCrypto, 0);
            this.f14033f.setString("mime", c2515k.f6380f);
            return;
        }
        mediaCodec.configure(c2515k.m7013b(), null, mediaCrypto, 0);
        this.f14033f = null;
    }

    /* renamed from: a */
    protected void mo3519a(String str, long j, long j2) {
        this.f14029b.m6135a(str, j, j2);
    }

    /* renamed from: b */
    protected void mo3522b(C2515k c2515k) {
        super.mo3522b(c2515k);
        this.f14029b.m6134a(c2515k);
        this.f14034g = "audio/raw".equals(c2515k.f6380f) ? c2515k.f6394t : 2;
        this.f14035h = c2515k.f6392r;
        int i = 0;
        this.f14036i = c2515k.f6395u != -1 ? c2515k.f6395u : 0;
        if (c2515k.f6396v != -1) {
            i = c2515k.f6396v;
        }
        this.f14037j = i;
    }

    /* renamed from: a */
    protected void mo3517a(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        if (this.f14033f != null) {
            mediaCodec = C2524i.m7057h(this.f14033f.getString("mime"));
            mediaFormat = this.f14033f;
        } else {
            mediaCodec = this.f14034g;
        }
        int i = mediaCodec;
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.f14032e == null || integer != 6 || this.f14035h >= 6) {
            mediaCodec = null;
        } else {
            mediaCodec = new int[this.f14035h];
            for (mediaFormat = null; mediaFormat < this.f14035h; mediaFormat++) {
                mediaCodec[mediaFormat] = mediaFormat;
            }
        }
        try {
            this.f14030c.mo2127a(i, integer, integer2, 0, mediaCodec, this.f14036i, this.f14037j);
        } catch (MediaCodec mediaCodec2) {
            throw C2330e.m6459a(mediaCodec2, m16026r());
        }
    }

    /* renamed from: a */
    protected void mo3414a(boolean z) {
        super.mo3414a(z);
        this.f14029b.m6133a(this.a);
        z = m16025q().f6616b;
        if (z) {
            this.f14030c.mo2133b(z);
        } else {
            this.f14030c.mo2138g();
        }
    }

    /* renamed from: a */
    protected void mo3413a(long j, boolean z) {
        super.mo3413a(j, z);
        this.f14030c.mo2140i();
        this.f14038k = j;
        this.f14039l = 1;
    }

    /* renamed from: n */
    protected void mo3415n() {
        super.mo3415n();
        this.f14030c.mo2125a();
    }

    /* renamed from: o */
    protected void mo3416o() {
        this.f14030c.mo2139h();
        super.mo3416o();
    }

    /* renamed from: p */
    protected void mo3417p() {
        try {
            this.f14030c.mo2141j();
            try {
                super.mo3417p();
            } finally {
                this.a.m6220a();
                this.f14029b.m6136b(this.a);
            }
        } catch (Throwable th) {
            super.mo3417p();
        } finally {
            this.a.m6220a();
            this.f14029b.m6136b(this.a);
        }
    }

    /* renamed from: u */
    public boolean mo3419u() {
        return super.mo3419u() && this.f14030c.mo2135d();
    }

    /* renamed from: t */
    public boolean mo3418t() {
        if (!this.f14030c.mo2136e()) {
            if (!super.mo3418t()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: w */
    public long mo2324w() {
        long a = this.f14030c.mo2123a(mo3419u());
        if (a != Long.MIN_VALUE) {
            if (!this.f14039l) {
                a = Math.max(this.f14038k, a);
            }
            this.f14038k = a;
            this.f14039l = false;
        }
        return this.f14038k;
    }

    /* renamed from: a */
    public C2573r mo2323a(C2573r c2573r) {
        return this.f14030c.mo2124a(c2573r);
    }

    /* renamed from: x */
    public C2573r mo2325x() {
        return this.f14030c.mo2137f();
    }

    /* renamed from: a */
    protected boolean mo3520a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        if (this.f14031d != null && (i2 & 2) != null) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            j = this.a;
            j.f5370f++;
            this.f14030c.mo2132b();
            return true;
        } else {
            try {
                if (this.f14030c.mo2131a(byteBuffer, j3) == null) {
                    return false;
                }
                mediaCodec.releaseOutputBuffer(i, false);
                j = this.a;
                j.f5369e++;
                return true;
            } catch (long j4) {
                throw C2330e.m6459a(j4, m16026r());
            }
        }
    }

    /* renamed from: y */
    protected void mo3524y() {
        try {
            this.f14030c.mo2134c();
        } catch (Exception e) {
            throw C2330e.m6459a(e, m16026r());
        }
    }

    /* renamed from: a */
    public void mo3179a(int i, Object obj) {
        switch (i) {
            case 2:
                this.f14030c.mo2126a(((Float) obj).floatValue());
                return;
            case 3:
                this.f14030c.mo2128a((C2219b) obj);
                return;
            default:
                super.mo3179a(i, obj);
                return;
        }
    }

    /* renamed from: b */
    private static boolean m17546b(String str) {
        return (C2541v.f6467a >= 24 || "OMX.SEC.aac.dec".equals(str) == null || "samsung".equals(C2541v.f6469c) == null || (C2541v.f6468b.startsWith("zeroflte") == null && C2541v.f6468b.startsWith("herolte") == null && C2541v.f6468b.startsWith("heroqlte") == null)) ? null : true;
    }
}
