package com.google.android.exoplayer2.p163k;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.p164l.C2516a;
import java.io.InputStream;

/* compiled from: DataSourceInputStream */
/* renamed from: com.google.android.exoplayer2.k.i */
public final class C2500i extends InputStream {
    /* renamed from: a */
    private final C2498g f6343a;
    /* renamed from: b */
    private final C2501j f6344b;
    /* renamed from: c */
    private final byte[] f6345c;
    /* renamed from: d */
    private boolean f6346d = false;
    /* renamed from: e */
    private boolean f6347e = false;
    /* renamed from: f */
    private long f6348f;

    public C2500i(C2498g c2498g, C2501j c2501j) {
        this.f6343a = c2498g;
        this.f6344b = c2501j;
        this.f6345c = new byte[1];
    }

    /* renamed from: a */
    public long m6954a() {
        return this.f6348f;
    }

    /* renamed from: b */
    public void m6955b() {
        m6953c();
    }

    public int read() {
        if (read(this.f6345c) == -1) {
            return -1;
        }
        return this.f6345c[0] & JfifUtil.MARKER_FIRST_BYTE;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        C2516a.m7019b(this.f6347e ^ 1);
        m6953c();
        bArr = this.f6343a.mo2267a(bArr, i, i2);
        if (bArr == -1) {
            return -1;
        }
        this.f6348f += (long) bArr;
        return bArr;
    }

    public void close() {
        if (!this.f6347e) {
            this.f6343a.mo2270b();
            this.f6347e = true;
        }
    }

    /* renamed from: c */
    private void m6953c() {
        if (!this.f6346d) {
            this.f6343a.mo2268a(this.f6344b);
            this.f6346d = true;
        }
    }
}
