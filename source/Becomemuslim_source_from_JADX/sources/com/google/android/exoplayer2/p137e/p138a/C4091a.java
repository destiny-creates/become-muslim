package com.google.android.exoplayer2.p137e.p138a;

import android.util.Pair;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p137e.p138a.C2260d.C4095a;
import com.google.android.exoplayer2.p164l.C2518c;
import com.google.android.exoplayer2.p164l.C2529l;
import java.util.Collections;

/* compiled from: AudioTagPayloadReader */
/* renamed from: com.google.android.exoplayer2.e.a.a */
final class C4091a extends C2260d {
    /* renamed from: b */
    private static final int[] f10352b = new int[]{5512, 11025, 22050, 44100};
    /* renamed from: c */
    private boolean f10353c;
    /* renamed from: d */
    private boolean f10354d;
    /* renamed from: e */
    private int f10355e;

    public C4091a(C2329m c2329m) {
        super(c2329m);
    }

    /* renamed from: a */
    protected boolean mo2160a(C2529l c2529l) {
        if (this.f10353c) {
            c2529l.m7098d(1);
        } else {
            int g = c2529l.m7103g();
            r0.f10355e = (g >> 4) & 15;
            if (r0.f10355e == 2) {
                r0.a.mo2199a(C2515k.m6988a(null, "audio/mpeg", null, -1, -1, 1, f10352b[(g >> 2) & 3], null, null, 0, null));
                r0.f10354d = true;
            } else {
                if (r0.f10355e != 7) {
                    if (r0.f10355e != 8) {
                        if (r0.f10355e != 10) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Audio format not supported: ");
                            stringBuilder.append(r0.f10355e);
                            throw new C4095a(stringBuilder.toString());
                        }
                    }
                }
                r0.a.mo2199a(C2515k.m6987a(null, r0.f10355e == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", null, -1, -1, 1, 8000, (g & 1) == 1 ? 2 : 3, null, null, 0, null));
                r0.f10354d = true;
            }
            r0.f10353c = true;
        }
        return true;
    }

    /* renamed from: a */
    protected void mo2159a(C2529l c2529l, long j) {
        C2529l c2529l2 = c2529l;
        if (this.f10355e == 2) {
            int b = c2529l.m7093b();
            r0.a.mo2200a(c2529l2, b);
            r0.a.mo2198a(j, 1, b, 0, null);
            return;
        }
        int g = c2529l.m7103g();
        if (g == 0 && !r0.f10354d) {
            byte[] bArr = new byte[c2529l.m7093b()];
            c2529l2.m7092a(bArr, 0, bArr.length);
            Pair a = C2518c.m7025a(bArr);
            r0.a.mo2199a(C2515k.m6988a(null, "audio/mp4a-latm", null, -1, -1, ((Integer) a.second).intValue(), ((Integer) a.first).intValue(), Collections.singletonList(bArr), null, 0, null));
            r0.f10354d = true;
        } else if (r0.f10355e != 10 || g == 1) {
            int b2 = c2529l.m7093b();
            r0.a.mo2200a(c2529l2, b2);
            r0.a.mo2198a(j, 1, b2, 0, null);
        }
    }
}
