package com.google.android.exoplayer2.p145g.p148c;

import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.p145g.C2344a;
import com.google.android.exoplayer2.p145g.C2344a.C2342a;
import com.google.android.exoplayer2.p145g.C2356b;
import com.google.android.exoplayer2.p145g.C4709e;
import com.google.android.exoplayer2.p164l.C2528k;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2537s;

/* compiled from: SpliceInfoDecoder */
/* renamed from: com.google.android.exoplayer2.g.c.c */
public final class C4165c implements C2356b {
    /* renamed from: a */
    private final C2529l f10799a = new C2529l();
    /* renamed from: b */
    private final C2528k f10800b = new C2528k();
    /* renamed from: c */
    private C2537s f10801c;

    /* renamed from: a */
    public C2344a mo2227a(C4709e c4709e) {
        if (this.f10801c == null || c4709e.f12728d != this.f10801c.m7150c()) {
            this.f10801c = new C2537s(c4709e.c);
            this.f10801c.m7151c(c4709e.c - c4709e.f12728d);
        }
        c4709e = c4709e.b;
        byte[] array = c4709e.array();
        int limit = c4709e.limit();
        this.f10799a.m7091a(array, limit);
        this.f10800b.m7075a(array, limit);
        this.f10800b.m7078b(39);
        long c = (((long) this.f10800b.m7081c(1)) << 32) | ((long) this.f10800b.m7081c(32));
        this.f10800b.m7078b(20);
        c4709e = this.f10800b.m7081c(12);
        int c2 = this.f10800b.m7081c(8);
        C4708g c4708g = null;
        this.f10799a.m7098d(14);
        if (c2 == 0) {
            c4708g = new C4706e();
        } else if (c2 != JfifUtil.MARKER_FIRST_BYTE) {
            switch (c2) {
                case 4:
                    c4708g = C4707f.m16053a(this.f10799a);
                    break;
                case 5:
                    c4708g = C4705d.m16052a(this.f10799a, c, this.f10801c);
                    break;
                case 6:
                    c4708g = C4708g.m16055a(this.f10799a, c, this.f10801c);
                    break;
                default:
                    break;
            }
        } else {
            c4708g = C4704a.m16051a(this.f10799a, c4709e, c);
        }
        if (c4708g == null) {
            return new C2344a(new C2342a[0]);
        }
        return new C2344a(c4708g);
    }
}
