package com.google.android.exoplayer2.p134a;

import com.google.android.exoplayer2.p134a.C2222d.C2221a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: ChannelMappingAudioProcessor */
/* renamed from: com.google.android.exoplayer2.a.g */
final class C4078g implements C2222d {
    /* renamed from: b */
    private int f10222b = -1;
    /* renamed from: c */
    private int f10223c = -1;
    /* renamed from: d */
    private int[] f10224d;
    /* renamed from: e */
    private boolean f10225e;
    /* renamed from: f */
    private int[] f10226f;
    /* renamed from: g */
    private ByteBuffer f10227g = a;
    /* renamed from: h */
    private ByteBuffer f10228h = a;
    /* renamed from: i */
    private boolean f10229i;

    /* renamed from: c */
    public int mo2112c() {
        return 2;
    }

    /* renamed from: a */
    public void m12647a(int[] iArr) {
        this.f10224d = iArr;
    }

    /* renamed from: a */
    public boolean mo2110a(int i, int i2, int i3) {
        boolean equals = Arrays.equals(this.f10224d, this.f10226f) ^ true;
        this.f10226f = this.f10224d;
        if (this.f10226f == null) {
            this.f10225e = false;
            return equals;
        } else if (i3 != 2) {
            throw new C2221a(i, i2, i3);
        } else if (!equals && this.f10223c == i && this.f10222b == i2) {
            return false;
        } else {
            this.f10223c = i;
            this.f10222b = i2;
            this.f10225e = i2 != this.f10226f.length;
            int i4 = 0;
            while (i4 < this.f10226f.length) {
                int i5 = this.f10226f[i4];
                if (i5 < i2) {
                    this.f10225e = (i5 != i4 ? 1 : 0) | this.f10225e;
                    i4++;
                } else {
                    throw new C2221a(i, i2, i3);
                }
            }
            return true;
        }
    }

    /* renamed from: a */
    public boolean mo2109a() {
        return this.f10225e;
    }

    /* renamed from: b */
    public int mo2111b() {
        return this.f10226f == null ? this.f10222b : this.f10226f.length;
    }

    /* renamed from: d */
    public int mo2113d() {
        return this.f10223c;
    }

    /* renamed from: a */
    public void mo2108a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = (((limit - position) / (this.f10222b * 2)) * this.f10226f.length) * 2;
        if (this.f10227g.capacity() < length) {
            this.f10227g = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.f10227g.clear();
        }
        while (position < limit) {
            for (int i : this.f10226f) {
                this.f10227g.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.f10222b * 2;
        }
        byteBuffer.position(limit);
        this.f10227g.flip();
        this.f10228h = this.f10227g;
    }

    /* renamed from: e */
    public void mo2114e() {
        this.f10229i = true;
    }

    /* renamed from: f */
    public ByteBuffer mo2115f() {
        ByteBuffer byteBuffer = this.f10228h;
        this.f10228h = a;
        return byteBuffer;
    }

    /* renamed from: g */
    public boolean mo2116g() {
        return this.f10229i && this.f10228h == a;
    }

    /* renamed from: h */
    public void mo2117h() {
        this.f10228h = a;
        this.f10229i = false;
    }

    /* renamed from: i */
    public void mo2118i() {
        mo2117h();
        this.f10227g = a;
        this.f10222b = -1;
        this.f10223c = -1;
        this.f10226f = null;
        this.f10225e = false;
    }
}
