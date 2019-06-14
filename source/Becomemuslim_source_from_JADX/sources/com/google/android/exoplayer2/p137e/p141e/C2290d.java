package com.google.android.exoplayer2.p137e.p141e;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2529l;
import java.util.Arrays;

/* compiled from: OggPacket */
/* renamed from: com.google.android.exoplayer2.e.e.d */
final class C2290d {
    /* renamed from: a */
    private final C2291e f5614a = new C2291e();
    /* renamed from: b */
    private final C2529l f5615b = new C2529l(new byte[65025], 0);
    /* renamed from: c */
    private int f5616c = -1;
    /* renamed from: d */
    private int f5617d;
    /* renamed from: e */
    private boolean f5618e;

    C2290d() {
    }

    /* renamed from: a */
    public void m6334a() {
        this.f5614a.m6339a();
        this.f5615b.m7088a();
        this.f5616c = -1;
        this.f5618e = false;
    }

    /* renamed from: a */
    public boolean m6335a(C2304f c2304f) {
        C2516a.m7019b(c2304f != null);
        if (this.f5618e) {
            this.f5618e = false;
            this.f5615b.m7088a();
        }
        while (!this.f5618e) {
            int i;
            int i2;
            if (this.f5616c < 0) {
                if (!this.f5614a.m6340a(c2304f, true)) {
                    return false;
                }
                i = this.f5614a.f5627h;
                if ((this.f5614a.f5621b & 1) == 1 && this.f5615b.m7095c() == 0) {
                    i += m6333a(0);
                    i2 = this.f5617d + 0;
                } else {
                    i2 = 0;
                }
                c2304f.mo2186b(i);
                this.f5616c = i2;
            }
            i = m6333a(this.f5616c);
            i2 = this.f5616c + this.f5617d;
            if (i > 0) {
                if (this.f5615b.m7099e() < this.f5615b.m7095c() + i) {
                    this.f5615b.f6441a = Arrays.copyOf(this.f5615b.f6441a, this.f5615b.m7095c() + i);
                }
                c2304f.mo2187b(this.f5615b.f6441a, this.f5615b.m7095c(), i);
                this.f5615b.m7094b(this.f5615b.m7095c() + i);
                this.f5618e = this.f5614a.f5629j[i2 + -1] != 255;
            }
            if (i2 == this.f5614a.f5626g) {
                i2 = -1;
            }
            this.f5616c = i2;
        }
        return true;
    }

    /* renamed from: b */
    public C2291e m6336b() {
        return this.f5614a;
    }

    /* renamed from: c */
    public C2529l m6337c() {
        return this.f5615b;
    }

    /* renamed from: d */
    public void m6338d() {
        if (this.f5615b.f6441a.length != 65025) {
            this.f5615b.f6441a = Arrays.copyOf(this.f5615b.f6441a, Math.max(65025, this.f5615b.m7095c()));
        }
    }

    /* renamed from: a */
    private int m6333a(int i) {
        int i2 = 0;
        this.f5617d = 0;
        while (this.f5617d + i < this.f5614a.f5626g) {
            int[] iArr = this.f5614a.f5629j;
            int i3 = this.f5617d;
            this.f5617d = i3 + 1;
            int i4 = iArr[i3 + i];
            i2 += i4;
            if (i4 != JfifUtil.MARKER_FIRST_BYTE) {
                break;
            }
        }
        return i2;
    }
}
