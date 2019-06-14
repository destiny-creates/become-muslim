package com.google.android.exoplayer2.p149h.p153c;

import android.text.TextUtils;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.C2571p;
import com.google.android.exoplayer2.p137e.C2303e;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2326k;
import com.google.android.exoplayer2.p137e.C2327l.C4154a;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p157i.p161g.C2472h;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2537s;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: WebvttExtractor */
/* renamed from: com.google.android.exoplayer2.h.c.n */
final class C4202n implements C2303e {
    /* renamed from: a */
    private static final Pattern f11020a = Pattern.compile("LOCAL:([^,]+)");
    /* renamed from: b */
    private static final Pattern f11021b = Pattern.compile("MPEGTS:(\\d+)");
    /* renamed from: c */
    private final String f11022c;
    /* renamed from: d */
    private final C2537s f11023d;
    /* renamed from: e */
    private final C2529l f11024e = new C2529l();
    /* renamed from: f */
    private C2320g f11025f;
    /* renamed from: g */
    private byte[] f11026g = new byte[1024];
    /* renamed from: h */
    private int f11027h;

    /* renamed from: c */
    public void mo2166c() {
    }

    public C4202n(String str, C2537s c2537s) {
        this.f11022c = str;
        this.f11023d = c2537s;
    }

    /* renamed from: a */
    public boolean mo2165a(C2304f c2304f) {
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public void mo2164a(C2320g c2320g) {
        this.f11025f = c2320g;
        c2320g.mo2233a(new C4154a(-9223372036854775807L));
    }

    /* renamed from: a */
    public void mo2163a(long j, long j2) {
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public int mo2162a(C2304f c2304f, C2326k c2326k) {
        Object d = (int) c2304f.mo2192d();
        if (this.f11027h == this.f11026g.length) {
            this.f11026g = Arrays.copyOf(this.f11026g, ((d != -1 ? d : this.f11026g.length) * 3) / 2);
        }
        c2304f = c2304f.mo2182a(this.f11026g, this.f11027h, this.f11026g.length - this.f11027h);
        if (c2304f != -1) {
            this.f11027h += c2304f;
            if (d == -1 || this.f11027h != d) {
                return null;
            }
        }
        m13573a();
        return -1;
    }

    /* renamed from: a */
    private void m13573a() {
        C2529l c2529l = new C2529l(this.f11026g);
        try {
            C2472h.m6906a(c2529l);
            long j = 0;
            long j2 = j;
            while (true) {
                String z = c2529l.m7122z();
                if (TextUtils.isEmpty(z)) {
                    break;
                } else if (z.startsWith("X-TIMESTAMP-MAP")) {
                    Matcher matcher = f11020a.matcher(z);
                    StringBuilder stringBuilder;
                    if (matcher.find()) {
                        Matcher matcher2 = f11021b.matcher(z);
                        if (matcher2.find()) {
                            j2 = C2472h.m6905a(matcher.group(1));
                            j = C2537s.m7144d(Long.parseLong(matcher2.group(1)));
                        } else {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("X-TIMESTAMP-MAP doesn't contain media timestamp: ");
                            stringBuilder.append(z);
                            throw new C2571p(stringBuilder.toString());
                        }
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("X-TIMESTAMP-MAP doesn't contain local timestamp: ");
                    stringBuilder.append(z);
                    throw new C2571p(stringBuilder.toString());
                }
            }
            Matcher b = C2472h.m6908b(c2529l);
            if (b == null) {
                m13572a(0);
                return;
            }
            long a = C2472h.m6905a(b.group(1));
            long b2 = this.f11023d.m7149b(C2537s.m7145e((j + a) - j2));
            C2329m a2 = m13572a(b2 - a);
            this.f11024e.m7091a(this.f11026g, this.f11027h);
            a2.mo2200a(this.f11024e, this.f11027h);
            a2.mo2198a(b2, 1, this.f11027h, 0, null);
        } catch (Throwable e) {
            throw new C2571p(e);
        }
    }

    /* renamed from: a */
    private C2329m m13572a(long j) {
        C2329m a = this.f11025f.mo2231a(0, 3);
        a.mo2199a(C2515k.m6991a(null, "text/vtt", null, -1, 0, this.f11022c, null, j));
        this.f11025f.mo2232a();
        return a;
    }
}
