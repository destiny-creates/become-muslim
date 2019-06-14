package com.google.android.exoplayer2.p137e.p138a;

import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p137e.p138a.C2260d.C4095a;
import com.google.android.exoplayer2.p164l.C2527j;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p165m.C2544a;

/* compiled from: VideoTagPayloadReader */
/* renamed from: com.google.android.exoplayer2.e.a.e */
final class C4096e extends C2260d {
    /* renamed from: b */
    private final C2529l f10374b = new C2529l(C2527j.f6433a);
    /* renamed from: c */
    private final C2529l f10375c = new C2529l(4);
    /* renamed from: d */
    private int f10376d;
    /* renamed from: e */
    private boolean f10377e;
    /* renamed from: f */
    private int f10378f;

    public C4096e(C2329m c2329m) {
        super(c2329m);
    }

    /* renamed from: a */
    protected boolean mo2160a(C2529l c2529l) {
        c2529l = c2529l.m7103g();
        int i = (c2529l >> 4) & 15;
        c2529l &= 15;
        if (c2529l == 7) {
            this.f10378f = i;
            return i != 5 ? true : null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Video format not supported: ");
            stringBuilder.append(c2529l);
            throw new C4095a(stringBuilder.toString());
        }
    }

    /* renamed from: a */
    protected void mo2159a(C2529l c2529l, long j) {
        int g = c2529l.m7103g();
        long l = j + (((long) c2529l.m7108l()) * 1000);
        if (g == 0 && !this.f10377e) {
            C2529l c2529l2 = new C2529l(new byte[c2529l.m7093b()]);
            c2529l.m7092a(c2529l2.f6441a, 0, c2529l.m7093b());
            c2529l = C2544a.m7201a(c2529l2);
            this.f10376d = c2529l.f6478b;
            this.a.mo2199a(C2515k.m6984a(null, "video/avc", null, -1, -1, c2529l.f6479c, c2529l.f6480d, -1.0f, c2529l.f6477a, -1, c2529l.f6481e, null));
            this.f10377e = true;
        } else if (g == 1 && this.f10377e) {
            byte[] bArr = this.f10375c.f6441a;
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 0;
            bArr[2] = (byte) 0;
            g = 4 - this.f10376d;
            int i = 0;
            while (c2529l.m7093b() > 0) {
                c2529l.m7092a(this.f10375c.f6441a, g, this.f10376d);
                this.f10375c.m7096c(0);
                int u = this.f10375c.m7117u();
                this.f10374b.m7096c(0);
                this.a.mo2200a(this.f10374b, 4);
                i += 4;
                this.a.mo2200a(c2529l, u);
                i += u;
            }
            this.a.mo2198a(l, this.f10378f == 1 ? 1 : 0, i, 0, null);
        }
    }
}
