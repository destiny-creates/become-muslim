package com.google.android.exoplayer2.p137e.p143h;

import android.util.Log;
import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2541v;

/* compiled from: WavHeaderReader */
/* renamed from: com.google.android.exoplayer2.e.h.c */
final class C2322c {

    /* compiled from: WavHeaderReader */
    /* renamed from: com.google.android.exoplayer2.e.h.c$a */
    private static final class C2321a {
        /* renamed from: a */
        public final int f5756a;
        /* renamed from: b */
        public final long f5757b;

        private C2321a(int i, long j) {
            this.f5756a = i;
            this.f5757b = j;
        }

        /* renamed from: a */
        public static C2321a m6440a(C2304f c2304f, C2529l c2529l) {
            c2304f.mo2191c(c2529l.f6441a, 0, 8);
            c2529l.m7096c(0);
            return new C2321a(c2529l.m7111o(), c2529l.m7110n());
        }
    }

    /* renamed from: a */
    public static C4152b m6441a(C2304f c2304f) {
        C2304f c2304f2 = c2304f;
        C2516a.m7015a((Object) c2304f);
        C2529l c2529l = new C2529l(16);
        if (C2321a.m6440a(c2304f2, c2529l).f5756a != C2541v.m7193g("RIFF")) {
            return null;
        }
        int i = 4;
        c2304f2.mo2191c(c2529l.f6441a, 0, 4);
        c2529l.m7096c(0);
        int o = c2529l.m7111o();
        if (o != C2541v.m7193g("WAVE")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported RIFF format: ");
            stringBuilder.append(o);
            Log.e("WavHeaderReader", stringBuilder.toString());
            return null;
        }
        C2321a a = C2321a.m6440a(c2304f2, c2529l);
        while (a.f5756a != C2541v.m7193g("fmt ")) {
            c2304f2.mo2190c((int) a.f5757b);
            a = C2321a.m6440a(c2304f2, c2529l);
        }
        C2516a.m7019b(a.f5757b >= 16);
        c2304f2.mo2191c(c2529l.f6441a, 0, 16);
        c2529l.m7096c(0);
        int i2 = c2529l.m7105i();
        int i3 = c2529l.m7105i();
        int v = c2529l.m7118v();
        int v2 = c2529l.m7118v();
        int i4 = c2529l.m7105i();
        int i5 = c2529l.m7105i();
        int i6 = (i3 * i5) / 8;
        if (i4 == i6) {
            int i7;
            StringBuilder stringBuilder2;
            if (i2 != 1) {
                if (i2 == 3) {
                    if (i5 != 32) {
                        i = 0;
                    }
                    i7 = i;
                    if (i7 != 0) {
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Unsupported WAV bit depth ");
                        stringBuilder2.append(i5);
                        stringBuilder2.append(" for type ");
                        stringBuilder2.append(i2);
                        Log.e("WavHeaderReader", stringBuilder2.toString());
                        return null;
                    }
                    c2304f2.mo2190c(((int) a.f5757b) - 16);
                    return new C4152b(i3, v, v2, i4, i5, i7);
                } else if (i2 != 65534) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Unsupported WAV format type: ");
                    stringBuilder.append(i2);
                    Log.e("WavHeaderReader", stringBuilder.toString());
                    return null;
                }
            }
            i = C2541v.m7182b(i5);
            i7 = i;
            if (i7 != 0) {
                c2304f2.mo2190c(((int) a.f5757b) - 16);
                return new C4152b(i3, v, v2, i4, i5, i7);
            }
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Unsupported WAV bit depth ");
            stringBuilder2.append(i5);
            stringBuilder2.append(" for type ");
            stringBuilder2.append(i2);
            Log.e("WavHeaderReader", stringBuilder2.toString());
            return null;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Expected block alignment: ");
        stringBuilder.append(i6);
        stringBuilder.append("; got: ");
        stringBuilder.append(i4);
        throw new C2571p(stringBuilder.toString());
    }

    /* renamed from: a */
    public static void m6442a(C2304f c2304f, C4152b c4152b) {
        C2516a.m7015a((Object) c2304f);
        C2516a.m7015a((Object) c4152b);
        c2304f.mo2183a();
        C2529l c2529l = new C2529l(8);
        C2321a a = C2321a.m6440a(c2304f, c2529l);
        while (a.f5756a != C2541v.m7193g("data")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Ignoring unknown WAV chunk: ");
            stringBuilder.append(a.f5756a);
            Log.w("WavHeaderReader", stringBuilder.toString());
            long j = a.f5757b + 8;
            if (a.f5756a == C2541v.m7193g("RIFF")) {
                j = 12;
            }
            if (j <= 2147483647L) {
                c2304f.mo2186b((int) j);
                a = C2321a.m6440a(c2304f, c2529l);
            } else {
                c4152b = new StringBuilder();
                c4152b.append("Chunk is too large (~2GB+) to skip; id: ");
                c4152b.append(a.f5756a);
                throw new C2571p(c4152b.toString());
            }
        }
        c2304f.mo2186b(8);
        c4152b.m13203a(c2304f.mo2189c(), a.f5757b);
    }
}
