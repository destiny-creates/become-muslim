package com.google.android.exoplayer2.p137e.p142g;

import android.util.Log;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p137e.p142g.C2319w.C2318d;
import com.google.android.exoplayer2.p164l.C2529l;

/* compiled from: Id3Reader */
/* renamed from: com.google.android.exoplayer2.e.g.l */
public final class C4138l implements C2305h {
    /* renamed from: a */
    private final C2529l f10682a = new C2529l(10);
    /* renamed from: b */
    private C2329m f10683b;
    /* renamed from: c */
    private boolean f10684c;
    /* renamed from: d */
    private long f10685d;
    /* renamed from: e */
    private int f10686e;
    /* renamed from: f */
    private int f10687f;

    /* renamed from: a */
    public void mo2208a() {
        this.f10684c = false;
    }

    /* renamed from: a */
    public void mo2210a(C2320g c2320g, C2318d c2318d) {
        c2318d.m6431a();
        this.f10683b = c2320g.mo2231a(c2318d.m6432b(), 4);
        this.f10683b.mo2199a(C2515k.m6992a(c2318d.m6433c(), "application/id3", null, -1, null));
    }

    /* renamed from: a */
    public void mo2209a(long j, boolean z) {
        if (z) {
            this.f10684c = true;
            this.f10685d = j;
            this.f10686e = 0;
            this.f10687f = 0;
        }
    }

    /* renamed from: a */
    public void mo2211a(C2529l c2529l) {
        if (this.f10684c) {
            int b = c2529l.m7093b();
            if (this.f10687f < 10) {
                int min = Math.min(b, 10 - this.f10687f);
                System.arraycopy(c2529l.f6441a, c2529l.m7097d(), this.f10682a.f6441a, this.f10687f, min);
                if (this.f10687f + min == 10) {
                    this.f10682a.m7096c(0);
                    if (73 == this.f10682a.m7103g() && 68 == this.f10682a.m7103g()) {
                        if (51 == this.f10682a.m7103g()) {
                            this.f10682a.m7098d(3);
                            this.f10686e = this.f10682a.m7116t() + 10;
                        }
                    }
                    Log.w("Id3Reader", "Discarding invalid ID3 tag");
                    this.f10684c = false;
                    return;
                }
            }
            b = Math.min(b, this.f10686e - this.f10687f);
            this.f10683b.mo2200a(c2529l, b);
            this.f10687f += b;
        }
    }

    /* renamed from: b */
    public void mo2212b() {
        if (this.f10684c && this.f10686e != 0) {
            if (this.f10687f == this.f10686e) {
                this.f10683b.mo2198a(this.f10685d, 1, this.f10686e, 0, null);
                this.f10684c = false;
            }
        }
    }
}
