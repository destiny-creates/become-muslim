package com.google.android.exoplayer2.p149h.p150a;

import android.util.SparseArray;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.C2303e;
import com.google.android.exoplayer2.p137e.C2304f;
import com.google.android.exoplayer2.p137e.C2320g;
import com.google.android.exoplayer2.p137e.C2327l;
import com.google.android.exoplayer2.p137e.C2329m;
import com.google.android.exoplayer2.p137e.C2329m.C2328a;
import com.google.android.exoplayer2.p137e.C4115d;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2529l;

/* compiled from: ChunkExtractorWrapper */
/* renamed from: com.google.android.exoplayer2.h.a.d */
public final class C4170d implements C2320g {
    /* renamed from: a */
    public final C2303e f10817a;
    /* renamed from: b */
    private final int f10818b;
    /* renamed from: c */
    private final C2515k f10819c;
    /* renamed from: d */
    private final SparseArray<C4169a> f10820d = new SparseArray();
    /* renamed from: e */
    private boolean f10821e;
    /* renamed from: f */
    private C2370b f10822f;
    /* renamed from: g */
    private C2327l f10823g;
    /* renamed from: h */
    private C2515k[] f10824h;

    /* compiled from: ChunkExtractorWrapper */
    /* renamed from: com.google.android.exoplayer2.h.a.d$b */
    public interface C2370b {
        /* renamed from: a */
        C2329m mo2230a(int i, int i2);
    }

    /* compiled from: ChunkExtractorWrapper */
    /* renamed from: com.google.android.exoplayer2.h.a.d$a */
    private static final class C4169a implements C2329m {
        /* renamed from: a */
        public C2515k f10812a;
        /* renamed from: b */
        private final int f10813b;
        /* renamed from: c */
        private final int f10814c;
        /* renamed from: d */
        private final C2515k f10815d;
        /* renamed from: e */
        private C2329m f10816e;

        public C4169a(int i, int i2, C2515k c2515k) {
            this.f10813b = i;
            this.f10814c = i2;
            this.f10815d = c2515k;
        }

        /* renamed from: a */
        public void m13265a(C2370b c2370b) {
            if (c2370b == null) {
                this.f10816e = new C4115d();
                return;
            }
            this.f10816e = c2370b.mo2230a(this.f10813b, this.f10814c);
            if (this.f10812a != null) {
                this.f10816e.mo2199a(this.f10812a);
            }
        }

        /* renamed from: a */
        public void mo2199a(C2515k c2515k) {
            if (this.f10815d != null) {
                c2515k = c2515k.m7011a(this.f10815d);
            }
            this.f10812a = c2515k;
            this.f10816e.mo2199a(this.f10812a);
        }

        /* renamed from: a */
        public int mo2197a(C2304f c2304f, int i, boolean z) {
            return this.f10816e.mo2197a(c2304f, i, z);
        }

        /* renamed from: a */
        public void mo2200a(C2529l c2529l, int i) {
            this.f10816e.mo2200a(c2529l, i);
        }

        /* renamed from: a */
        public void mo2198a(long j, int i, int i2, int i3, C2328a c2328a) {
            this.f10816e.mo2198a(j, i, i2, i3, c2328a);
        }
    }

    public C4170d(C2303e c2303e, int i, C2515k c2515k) {
        this.f10817a = c2303e;
        this.f10818b = i;
        this.f10819c = c2515k;
    }

    /* renamed from: b */
    public C2327l m13272b() {
        return this.f10823g;
    }

    /* renamed from: c */
    public C2515k[] m13273c() {
        return this.f10824h;
    }

    /* renamed from: a */
    public void m13271a(C2370b c2370b) {
        this.f10822f = c2370b;
        if (this.f10821e) {
            this.f10817a.mo2163a(0, 0);
            for (int i = 0; i < this.f10820d.size(); i++) {
                ((C4169a) this.f10820d.valueAt(i)).m13265a(c2370b);
            }
            return;
        }
        this.f10817a.mo2164a((C2320g) this);
        this.f10821e = true;
    }

    /* renamed from: a */
    public C2329m mo2231a(int i, int i2) {
        C2329m c2329m = (C4169a) this.f10820d.get(i);
        if (c2329m == null) {
            C2516a.m7019b(this.f10824h == null);
            c2329m = new C4169a(i, i2, i2 == this.f10818b ? this.f10819c : null);
            c2329m.m13265a(this.f10822f);
            this.f10820d.put(i, c2329m);
        }
        return c2329m;
    }

    /* renamed from: a */
    public void mo2232a() {
        C2515k[] c2515kArr = new C2515k[this.f10820d.size()];
        for (int i = 0; i < this.f10820d.size(); i++) {
            c2515kArr[i] = ((C4169a) this.f10820d.valueAt(i)).f10812a;
        }
        this.f10824h = c2515kArr;
    }

    /* renamed from: a */
    public void mo2233a(C2327l c2327l) {
        this.f10823g = c2327l;
    }
}
