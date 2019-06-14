package com.google.android.exoplayer2.p201d.p202a;

import android.net.Uri;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.exoplayer2.C2489j;
import com.google.android.exoplayer2.p163k.C2499h;
import com.google.android.exoplayer2.p163k.C2501j;
import com.google.android.exoplayer2.p163k.C2514v;
import com.google.android.exoplayer2.p163k.C4250r;
import com.google.android.exoplayer2.p163k.C4250r.C2504c;
import com.google.android.exoplayer2.p163k.C4250r.C2505f;
import com.google.android.exoplayer2.p163k.C4250r.C4248d;
import com.google.android.exoplayer2.p163k.C4250r.C4249e;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2531n;
import expolib_v1.p321a.C6214d;
import expolib_v1.p321a.C6216e.C6215a;
import expolib_v1.p321a.C6237r;
import expolib_v1.p321a.C6240u;
import expolib_v1.p321a.C6246z;
import expolib_v1.p321a.C6246z.C6245a;
import expolib_v1.p321a.aa;
import expolib_v1.p321a.ab;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: OkHttpDataSource */
/* renamed from: com.google.android.exoplayer2.d.a.a */
public class C4691a implements C4250r {
    /* renamed from: b */
    private static final AtomicReference<byte[]> f12651b = new AtomicReference();
    /* renamed from: c */
    private final C6215a f12652c;
    /* renamed from: d */
    private final C2505f f12653d = new C2505f();
    /* renamed from: e */
    private final String f12654e;
    /* renamed from: f */
    private final C2531n<String> f12655f;
    /* renamed from: g */
    private final C2514v<? super C4691a> f12656g;
    /* renamed from: h */
    private final C6214d f12657h;
    /* renamed from: i */
    private final C2505f f12658i;
    /* renamed from: j */
    private C2501j f12659j;
    /* renamed from: k */
    private ab f12660k;
    /* renamed from: l */
    private InputStream f12661l;
    /* renamed from: m */
    private boolean f12662m;
    /* renamed from: n */
    private long f12663n;
    /* renamed from: o */
    private long f12664o;
    /* renamed from: p */
    private long f12665p;
    /* renamed from: q */
    private long f12666q;

    static {
        C2489j.m6939a("goog.exo.okhttp");
    }

    public C4691a(C6215a c6215a, String str, C2531n<String> c2531n, C2514v<? super C4691a> c2514v, C6214d c6214d, C2505f c2505f) {
        this.f12652c = (C6215a) C2516a.m7015a((Object) c6215a);
        this.f12654e = str;
        this.f12655f = c2531n;
        this.f12656g = c2514v;
        this.f12657h = c6214d;
        this.f12658i = c2505f;
    }

    /* renamed from: a */
    public Uri mo2269a() {
        return this.f12660k == null ? null : Uri.parse(this.f12660k.a().a().toString());
    }

    /* renamed from: a */
    public long mo2268a(C2501j c2501j) {
        this.f12659j = c2501j;
        long j = 0;
        this.f12666q = 0;
        this.f12665p = 0;
        C6246z b = m16029b(c2501j);
        try {
            this.f12660k = this.f12652c.a(b).b();
            this.f12661l = this.f12660k.h().byteStream();
            int c = this.f12660k.c();
            if (this.f12660k.d()) {
                C6240u contentType = this.f12660k.h().contentType();
                String c6240u = contentType != null ? contentType.toString() : null;
                if (this.f12655f != null) {
                    if (!this.f12655f.mo2321a(c6240u)) {
                        m16031d();
                        throw new C4248d(c6240u, c2501j);
                    }
                }
                if (c == HttpStatus.HTTP_OK && c2501j.f6352d != 0) {
                    j = c2501j.f6352d;
                }
                this.f12663n = j;
                long j2 = -1;
                if (c2501j.f6353e != -1) {
                    this.f12664o = c2501j.f6353e;
                } else {
                    j = this.f12660k.h().contentLength();
                    if (j != -1) {
                        j2 = j - this.f12663n;
                    }
                    this.f12664o = j2;
                }
                this.f12662m = true;
                if (this.f12656g != null) {
                    this.f12656g.mo2319a((Object) this, c2501j);
                }
                return this.f12664o;
            }
            Map c2 = b.c().c();
            m16031d();
            C4249e c4249e = new C4249e(c, c2, c2501j);
            if (c == 416) {
                c4249e.initCause(new C2499h(0));
            }
            throw c4249e;
        } catch (IOException e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to connect to ");
            stringBuilder.append(c2501j.f6349a.toString());
            throw new C2504c(stringBuilder.toString(), e, c2501j, 1);
        }
    }

    /* renamed from: a */
    public int mo2267a(byte[] bArr, int i, int i2) {
        try {
            m16030c();
            return m16028b(bArr, i, i2);
        } catch (IOException e) {
            throw new C2504c(e, this.f12659j, 2);
        }
    }

    /* renamed from: b */
    public void mo2270b() {
        if (this.f12662m) {
            this.f12662m = false;
            if (this.f12656g != null) {
                this.f12656g.mo2317a(this);
            }
            m16031d();
        }
    }

    /* renamed from: b */
    private C6246z m16029b(C2501j c2501j) {
        long j = c2501j.f6352d;
        long j2 = c2501j.f6353e;
        boolean a = c2501j.m6958a(1);
        C6245a a2 = new C6245a().a(C6237r.e(c2501j.f6349a.toString()));
        if (this.f12657h != null) {
            a2.a(this.f12657h);
        }
        if (this.f12658i != null) {
            for (Entry entry : this.f12658i.m6962b().entrySet()) {
                a2.a((String) entry.getKey(), (String) entry.getValue());
            }
        }
        for (Entry entry2 : this.f12653d.m6962b().entrySet()) {
            a2.a((String) entry2.getKey(), (String) entry2.getValue());
        }
        if (!(j == 0 && j2 == -1)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("bytes=");
            stringBuilder.append(j);
            stringBuilder.append("-");
            String stringBuilder2 = stringBuilder.toString();
            if (j2 != -1) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(stringBuilder2);
                stringBuilder3.append((j + j2) - 1);
                stringBuilder2 = stringBuilder3.toString();
            }
            a2.b("Range", stringBuilder2);
        }
        if (this.f12654e != null) {
            a2.b("User-Agent", this.f12654e);
        }
        if (!a) {
            a2.b("Accept-Encoding", InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY);
        }
        if (c2501j.f6350b != null) {
            a2.a(aa.create(null, c2501j.f6350b));
        }
        return a2.b();
    }

    /* renamed from: c */
    private void m16030c() {
        if (this.f12665p != this.f12663n) {
            Object obj = (byte[]) f12651b.getAndSet(null);
            if (obj == null) {
                obj = new byte[4096];
            }
            while (this.f12665p != this.f12663n) {
                int read = this.f12661l.read(obj, 0, (int) Math.min(this.f12663n - this.f12665p, (long) obj.length));
                if (Thread.interrupted()) {
                    throw new InterruptedIOException();
                } else if (read != -1) {
                    this.f12665p += (long) read;
                    if (this.f12656g != null) {
                        this.f12656g.mo2318a((Object) this, read);
                    }
                } else {
                    throw new EOFException();
                }
            }
            f12651b.set(obj);
        }
    }

    /* renamed from: b */
    private int m16028b(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return null;
        }
        if (this.f12664o != -1) {
            long j = this.f12664o - this.f12666q;
            if (j == 0) {
                return -1;
            }
            i2 = (int) Math.min((long) i2, j);
        }
        int read = this.f12661l.read(bArr, i, i2);
        if (read != -1) {
            this.f12666q += (long) read;
            if (this.f12656g != 0) {
                this.f12656g.mo2318a((Object) this, read);
            }
            return read;
        } else if (this.f12664o == -1) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    /* renamed from: d */
    private void m16031d() {
        this.f12660k.h().close();
        this.f12660k = null;
        this.f12661l = null;
    }
}
