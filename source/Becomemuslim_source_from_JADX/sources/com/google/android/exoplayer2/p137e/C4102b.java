package com.google.android.exoplayer2.p137e;

import com.facebook.internal.NativeProtocol;
import com.google.android.exoplayer2.p163k.C2498g;
import com.google.android.exoplayer2.p164l.C2541v;
import java.io.EOFException;
import java.util.Arrays;

/* compiled from: DefaultExtractorInput */
/* renamed from: com.google.android.exoplayer2.e.b */
public final class C4102b implements C2304f {
    /* renamed from: a */
    private static final byte[] f10445a = new byte[4096];
    /* renamed from: b */
    private final C2498g f10446b;
    /* renamed from: c */
    private final long f10447c;
    /* renamed from: d */
    private long f10448d;
    /* renamed from: e */
    private byte[] f10449e = new byte[NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST];
    /* renamed from: f */
    private int f10450f;
    /* renamed from: g */
    private int f10451g;

    public C4102b(C2498g c2498g, long j, long j2) {
        this.f10446b = c2498g;
        this.f10448d = j;
        this.f10447c = j2;
    }

    /* renamed from: a */
    public int mo2182a(byte[] bArr, int i, int i2) {
        int d = m12874d(bArr, i, i2);
        if (d == 0) {
            d = m12873a(bArr, i, i2, 0, true);
        }
        m12878g(d);
        return d;
    }

    /* renamed from: a */
    public boolean mo2184a(byte[] bArr, int i, int i2, boolean z) {
        int d = m12874d(bArr, i, i2);
        while (d < i2 && d != -1) {
            d = m12873a(bArr, i, i2, d, z);
        }
        m12878g(d);
        return d != -1 ? 1 : null;
    }

    /* renamed from: b */
    public void mo2187b(byte[] bArr, int i, int i2) {
        mo2184a(bArr, i, i2, false);
    }

    /* renamed from: a */
    public int mo2181a(int i) {
        int e = m12876e(i);
        if (e == 0) {
            e = m12873a(f10445a, 0, Math.min(i, f10445a.length), 0, true);
        }
        m12878g(e);
        return e;
    }

    /* renamed from: a */
    public boolean m12882a(int i, boolean z) {
        int e = m12876e(i);
        while (e < i && e != -1) {
            e = m12873a(f10445a, -e, Math.min(i, f10445a.length + e), e, z);
        }
        m12878g(e);
        return e != -1;
    }

    /* renamed from: b */
    public void mo2186b(int i) {
        m12882a(i, false);
    }

    /* renamed from: b */
    public boolean mo2188b(byte[] bArr, int i, int i2, boolean z) {
        if (!m12887b(i2, z)) {
            return null;
        }
        System.arraycopy(this.f10449e, this.f10450f - i2, bArr, i, i2);
        return 1;
    }

    /* renamed from: c */
    public void mo2191c(byte[] bArr, int i, int i2) {
        mo2188b(bArr, i, i2, false);
    }

    /* renamed from: b */
    public boolean m12887b(int i, boolean z) {
        m12875d(i);
        int min = Math.min(this.f10451g - this.f10450f, i);
        while (min < i) {
            min = m12873a(this.f10449e, this.f10450f, i, min, z);
            if (min == -1) {
                return false;
            }
        }
        this.f10450f += i;
        this.f10451g = Math.max(this.f10451g, this.f10450f);
        return true;
    }

    /* renamed from: c */
    public void mo2190c(int i) {
        m12887b(i, false);
    }

    /* renamed from: a */
    public void mo2183a() {
        this.f10450f = 0;
    }

    /* renamed from: b */
    public long mo2185b() {
        return this.f10448d + ((long) this.f10450f);
    }

    /* renamed from: c */
    public long mo2189c() {
        return this.f10448d;
    }

    /* renamed from: d */
    public long mo2192d() {
        return this.f10447c;
    }

    /* renamed from: d */
    private void m12875d(int i) {
        int i2 = this.f10450f + i;
        if (i2 > this.f10449e.length) {
            this.f10449e = Arrays.copyOf(this.f10449e, C2541v.m7164a(this.f10449e.length * 2, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST + i2, i2 + 524288));
        }
    }

    /* renamed from: e */
    private int m12876e(int i) {
        i = Math.min(this.f10451g, i);
        m12877f(i);
        return i;
    }

    /* renamed from: d */
    private int m12874d(byte[] bArr, int i, int i2) {
        if (this.f10451g == 0) {
            return 0;
        }
        i2 = Math.min(this.f10451g, i2);
        System.arraycopy(this.f10449e, 0, bArr, i, i2);
        m12877f(i2);
        return i2;
    }

    /* renamed from: f */
    private void m12877f(int i) {
        this.f10451g -= i;
        this.f10450f = 0;
        Object obj = this.f10449e;
        if (this.f10451g < this.f10449e.length - 524288) {
            obj = new byte[(this.f10451g + NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST)];
        }
        System.arraycopy(this.f10449e, i, obj, 0, this.f10451g);
        this.f10449e = obj;
    }

    /* renamed from: a */
    private int m12873a(byte[] bArr, int i, int i2, int i3, boolean z) {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        bArr = this.f10446b.mo2267a(bArr, i + i3, i2 - i3);
        if (bArr != -1) {
            return i3 + bArr;
        }
        if (i3 == 0 && z) {
            return -1;
        }
        throw new EOFException();
    }

    /* renamed from: g */
    private void m12878g(int i) {
        if (i != -1) {
            this.f10448d += (long) i;
        }
    }
}
