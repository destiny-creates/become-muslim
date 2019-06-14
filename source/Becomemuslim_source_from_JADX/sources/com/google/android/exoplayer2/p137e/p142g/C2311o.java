package com.google.android.exoplayer2.p137e.p142g;

import com.google.android.exoplayer2.p164l.C2516a;
import java.util.Arrays;

/* compiled from: NalUnitTargetBuffer */
/* renamed from: com.google.android.exoplayer2.e.g.o */
final class C2311o {
    /* renamed from: a */
    public byte[] f5729a;
    /* renamed from: b */
    public int f5730b;
    /* renamed from: c */
    private final int f5731c;
    /* renamed from: d */
    private boolean f5732d;
    /* renamed from: e */
    private boolean f5733e;

    public C2311o(int i, int i2) {
        this.f5731c = i;
        this.f5729a = new byte[(i2 + 3)];
        this.f5729a[2] = (byte) 1;
    }

    /* renamed from: a */
    public void m6415a() {
        this.f5732d = false;
        this.f5733e = false;
    }

    /* renamed from: b */
    public boolean m6418b() {
        return this.f5733e;
    }

    /* renamed from: a */
    public void m6416a(int i) {
        boolean z = true;
        C2516a.m7019b(this.f5732d ^ true);
        if (i != this.f5731c) {
            z = false;
        }
        this.f5732d = z;
        if (this.f5732d != 0) {
            this.f5730b = 3;
            this.f5733e = false;
        }
    }

    /* renamed from: a */
    public void m6417a(byte[] bArr, int i, int i2) {
        if (this.f5732d) {
            i2 -= i;
            if (this.f5729a.length < this.f5730b + i2) {
                this.f5729a = Arrays.copyOf(this.f5729a, (this.f5730b + i2) * 2);
            }
            System.arraycopy(bArr, i, this.f5729a, this.f5730b, i2);
            this.f5730b += i2;
        }
    }

    /* renamed from: b */
    public boolean m6419b(int i) {
        if (!this.f5732d) {
            return false;
        }
        this.f5730b -= i;
        this.f5732d = false;
        this.f5733e = true;
        return true;
    }
}
