package com.google.android.exoplayer2.p149h.p150a;

import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p163k.C2498g;
import com.google.android.exoplayer2.p163k.C2501j;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.Arrays;

/* compiled from: DataChunk */
/* renamed from: com.google.android.exoplayer2.h.a.j */
public abstract class C4710j extends C4168c {
    /* renamed from: i */
    private byte[] f12729i;
    /* renamed from: j */
    private int f12730j;
    /* renamed from: k */
    private volatile boolean f12731k;

    /* renamed from: a */
    protected abstract void mo3421a(byte[] bArr, int i);

    public C4710j(C2498g c2498g, C2501j c2501j, int i, C2515k c2515k, int i2, Object obj, byte[] bArr) {
        super(c2498g, c2501j, i, c2515k, i2, obj, -9223372036854775807L, -9223372036854775807L);
        this.f12729i = bArr;
    }

    /* renamed from: d */
    public byte[] m16061d() {
        return this.f12729i;
    }

    /* renamed from: f */
    public long mo3197f() {
        return (long) this.f12730j;
    }

    /* renamed from: a */
    public final void mo2282a() {
        this.f12731k = true;
    }

    /* renamed from: b */
    public final boolean mo2283b() {
        return this.f12731k;
    }

    /* renamed from: c */
    public final void mo2284c() {
        try {
            this.h.mo2268a(this.a);
            int i = 0;
            this.f12730j = 0;
            while (i != -1 && !this.f12731k) {
                mo3422g();
                i = this.h.mo2267a(this.f12729i, this.f12730j, 16384);
                if (i != -1) {
                    this.f12730j += i;
                }
            }
            if (!this.f12731k) {
                mo3421a(this.f12729i, this.f12730j);
            }
            C2541v.m7174a(this.h);
        } catch (Throwable th) {
            C2541v.m7174a(this.h);
        }
    }

    /* renamed from: g */
    private void mo3422g() {
        if (this.f12729i == null) {
            this.f12729i = new byte[16384];
        } else if (this.f12729i.length < this.f12730j + 16384) {
            this.f12729i = Arrays.copyOf(this.f12729i, this.f12729i.length + 16384);
        }
    }
}
