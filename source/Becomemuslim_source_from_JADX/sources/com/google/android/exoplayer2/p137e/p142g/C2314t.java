package com.google.android.exoplayer2.p137e.p142g;

import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2318d;
import com.google.android.exoplayer2.p157i.p158a.C2447g;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2529l;
import java.util.List;

/* compiled from: SeiReader */
/* renamed from: com.google.android.exoplayer2.e.g.t */
final class C2314t {
    /* renamed from: a */
    private final List<C2515k> f5742a;
    /* renamed from: b */
    private final C2329m[] f5743b;

    public C2314t(List<C2515k> list) {
        this.f5742a = list;
        this.f5743b = new C2329m[list.size()];
    }

    /* renamed from: a */
    public void m6427a(C2320g c2320g, C2318d c2318d) {
        for (int i = 0; i < this.f5743b.length; i++) {
            boolean z;
            StringBuilder stringBuilder;
            c2318d.m6431a();
            C2329m a = c2320g.mo2231a(c2318d.m6432b(), 3);
            C2515k c2515k = (C2515k) this.f5742a.get(i);
            String str = c2515k.f6380f;
            if (!"application/cea-608".equals(str)) {
                if (!"application/cea-708".equals(str)) {
                    z = false;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid closed caption mime type provided: ");
                    stringBuilder.append(str);
                    C2516a.m7018a(z, stringBuilder.toString());
                    a.mo2199a(C2515k.m6989a(c2515k.f6375a == null ? c2515k.f6375a : c2318d.m6433c(), str, null, -1, c2515k.f6398x, c2515k.f6399y, c2515k.f6400z, null));
                    this.f5743b[i] = a;
                }
            }
            z = true;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid closed caption mime type provided: ");
            stringBuilder.append(str);
            C2516a.m7018a(z, stringBuilder.toString());
            if (c2515k.f6375a == null) {
            }
            a.mo2199a(C2515k.m6989a(c2515k.f6375a == null ? c2515k.f6375a : c2318d.m6433c(), str, null, -1, c2515k.f6398x, c2515k.f6399y, c2515k.f6400z, null));
            this.f5743b[i] = a;
        }
    }

    /* renamed from: a */
    public void m6426a(long j, C2529l c2529l) {
        C2447g.m6765a(j, c2529l, this.f5743b);
    }
}
