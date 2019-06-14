package com.google.android.exoplayer2.p134a;

import com.google.android.exoplayer2.p134a.C2222d.C2221a;
import com.google.android.exoplayer2.p164l.C2541v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: SonicAudioProcessor */
/* renamed from: com.google.android.exoplayer2.a.m */
public final class C4083m implements C2222d {
    /* renamed from: b */
    private int f10293b = -1;
    /* renamed from: c */
    private int f10294c = -1;
    /* renamed from: d */
    private int f10295d = -1;
    /* renamed from: e */
    private C2243l f10296e;
    /* renamed from: f */
    private float f10297f = 1.0f;
    /* renamed from: g */
    private float f10298g = 1.0f;
    /* renamed from: h */
    private int f10299h = -1;
    /* renamed from: i */
    private ByteBuffer f10300i = a;
    /* renamed from: j */
    private ShortBuffer f10301j = this.f10300i.asShortBuffer();
    /* renamed from: k */
    private ByteBuffer f10302k = a;
    /* renamed from: l */
    private long f10303l;
    /* renamed from: m */
    private long f10304m;
    /* renamed from: n */
    private boolean f10305n;

    /* renamed from: c */
    public int mo2112c() {
        return 2;
    }

    /* renamed from: a */
    public float m12724a(float f) {
        this.f10297f = C2541v.m7162a(f, 0.1f, 8.0f);
        return this.f10297f;
    }

    /* renamed from: b */
    public float m12729b(float f) {
        this.f10298g = C2541v.m7162a(f, 0.1f, 8.0f);
        return f;
    }

    /* renamed from: a */
    public long m12725a(long j) {
        if (this.f10304m < 1024) {
            return (long) (((double) this.f10297f) * ((double) j));
        }
        if (this.f10299h == this.f10295d) {
            j = C2541v.m7185b(j, this.f10303l, this.f10304m);
        } else {
            j = C2541v.m7185b(j, this.f10303l * ((long) this.f10299h), this.f10304m * ((long) this.f10295d));
        }
        return j;
    }

    /* renamed from: a */
    public boolean mo2110a(int i, int i2, int i3) {
        if (i3 == 2) {
            i3 = this.f10293b == -1 ? i : this.f10293b;
            if (this.f10295d == i && this.f10294c == i2 && this.f10299h == i3) {
                return false;
            }
            this.f10295d = i;
            this.f10294c = i2;
            this.f10299h = i3;
            return true;
        }
        throw new C2221a(i, i2, i3);
    }

    /* renamed from: a */
    public boolean mo2109a() {
        if (Math.abs(this.f10297f - 1.0f) < 0.01f && Math.abs(this.f10298g - 1.0f) < 0.01f) {
            if (this.f10299h == this.f10295d) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public int mo2111b() {
        return this.f10294c;
    }

    /* renamed from: d */
    public int mo2113d() {
        return this.f10299h;
    }

    /* renamed from: a */
    public void mo2108a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f10303l += (long) remaining;
            this.f10296e.m6200a(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        byteBuffer = (this.f10296e.m6201b() * this.f10294c) * 2;
        if (byteBuffer > null) {
            if (this.f10300i.capacity() < byteBuffer) {
                this.f10300i = ByteBuffer.allocateDirect(byteBuffer).order(ByteOrder.nativeOrder());
                this.f10301j = this.f10300i.asShortBuffer();
            } else {
                this.f10300i.clear();
                this.f10301j.clear();
            }
            this.f10296e.m6202b(this.f10301j);
            this.f10304m += (long) byteBuffer;
            this.f10300i.limit(byteBuffer);
            this.f10302k = this.f10300i;
        }
    }

    /* renamed from: e */
    public void mo2114e() {
        this.f10296e.m6199a();
        this.f10305n = true;
    }

    /* renamed from: f */
    public ByteBuffer mo2115f() {
        ByteBuffer byteBuffer = this.f10302k;
        this.f10302k = a;
        return byteBuffer;
    }

    /* renamed from: g */
    public boolean mo2116g() {
        return this.f10305n && (this.f10296e == null || this.f10296e.m6201b() == 0);
    }

    /* renamed from: h */
    public void mo2117h() {
        this.f10296e = new C2243l(this.f10295d, this.f10294c, this.f10297f, this.f10298g, this.f10299h);
        this.f10302k = a;
        this.f10303l = 0;
        this.f10304m = 0;
        this.f10305n = false;
    }

    /* renamed from: i */
    public void mo2118i() {
        this.f10296e = null;
        this.f10300i = a;
        this.f10301j = this.f10300i.asShortBuffer();
        this.f10302k = a;
        this.f10294c = -1;
        this.f10295d = -1;
        this.f10299h = -1;
        this.f10303l = 0;
        this.f10304m = 0;
        this.f10305n = false;
        this.f10293b = -1;
    }
}
