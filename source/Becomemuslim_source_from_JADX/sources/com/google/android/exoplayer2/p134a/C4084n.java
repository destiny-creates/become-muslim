package com.google.android.exoplayer2.p134a;

import com.google.android.exoplayer2.p134a.C2222d.C2221a;
import com.google.android.exoplayer2.p164l.C2541v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: TrimmingAudioProcessor */
/* renamed from: com.google.android.exoplayer2.a.n */
final class C4084n implements C2222d {
    /* renamed from: b */
    private boolean f10306b;
    /* renamed from: c */
    private int f10307c;
    /* renamed from: d */
    private int f10308d;
    /* renamed from: e */
    private int f10309e = -1;
    /* renamed from: f */
    private int f10310f;
    /* renamed from: g */
    private int f10311g;
    /* renamed from: h */
    private ByteBuffer f10312h = a;
    /* renamed from: i */
    private ByteBuffer f10313i = a;
    /* renamed from: j */
    private byte[] f10314j;
    /* renamed from: k */
    private int f10315k;
    /* renamed from: l */
    private boolean f10316l;

    /* renamed from: c */
    public int mo2112c() {
        return 2;
    }

    /* renamed from: a */
    public void m12738a(int i, int i2) {
        this.f10307c = i;
        this.f10308d = i2;
    }

    /* renamed from: a */
    public boolean mo2110a(int i, int i2, int i3) {
        if (i3 == 2) {
            this.f10309e = i2;
            this.f10310f = i;
            this.f10314j = new byte[((this.f10308d * i2) * 2)];
            this.f10315k = 0;
            this.f10311g = (this.f10307c * i2) * 2;
            i2 = this.f10306b;
            if (this.f10307c == 0) {
                if (this.f10308d == 0) {
                    i3 = 0;
                    this.f10306b = i3;
                    if (i2 == this.f10306b) {
                        return true;
                    }
                    return false;
                }
            }
            i3 = 1;
            this.f10306b = i3;
            if (i2 == this.f10306b) {
                return false;
            }
            return true;
        }
        throw new C2221a(i, i2, i3);
    }

    /* renamed from: a */
    public boolean mo2109a() {
        return this.f10306b;
    }

    /* renamed from: b */
    public int mo2111b() {
        return this.f10309e;
    }

    /* renamed from: d */
    public int mo2113d() {
        return this.f10310f;
    }

    /* renamed from: a */
    public void mo2108a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int min = Math.min(i, this.f10311g);
        this.f10311g -= min;
        byteBuffer.position(position + min);
        if (this.f10311g <= 0) {
            i -= min;
            position = (this.f10315k + i) - this.f10314j.length;
            if (this.f10312h.capacity() < position) {
                this.f10312h = ByteBuffer.allocateDirect(position).order(ByteOrder.nativeOrder());
            } else {
                this.f10312h.clear();
            }
            min = C2541v.m7164a(position, 0, this.f10315k);
            this.f10312h.put(this.f10314j, 0, min);
            position = C2541v.m7164a(position - min, 0, i);
            byteBuffer.limit(byteBuffer.position() + position);
            this.f10312h.put(byteBuffer);
            byteBuffer.limit(limit);
            i -= position;
            this.f10315k -= min;
            System.arraycopy(this.f10314j, min, this.f10314j, 0, this.f10315k);
            byteBuffer.get(this.f10314j, this.f10315k, i);
            this.f10315k += i;
            this.f10312h.flip();
            this.f10313i = this.f10312h;
        }
    }

    /* renamed from: e */
    public void mo2114e() {
        this.f10316l = true;
    }

    /* renamed from: f */
    public ByteBuffer mo2115f() {
        ByteBuffer byteBuffer = this.f10313i;
        this.f10313i = a;
        return byteBuffer;
    }

    /* renamed from: g */
    public boolean mo2116g() {
        return this.f10316l && this.f10313i == a;
    }

    /* renamed from: h */
    public void mo2117h() {
        this.f10313i = a;
        this.f10316l = false;
        this.f10311g = 0;
        this.f10315k = 0;
    }

    /* renamed from: i */
    public void mo2118i() {
        mo2117h();
        this.f10312h = a;
        this.f10309e = -1;
        this.f10310f = -1;
        this.f10314j = null;
    }
}
