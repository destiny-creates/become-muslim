package com.google.android.exoplayer2.p145g;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.C2330e;
import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.C2543l;
import com.google.android.exoplayer2.C4690a;
import com.google.android.exoplayer2.p136c.C2255a;
import com.google.android.exoplayer2.p164l.C2516a;
import java.util.Arrays;

/* compiled from: MetadataRenderer */
/* renamed from: com.google.android.exoplayer2.g.g */
public final class C4853g extends C4690a implements Callback {
    /* renamed from: a */
    private final C2366d f13816a;
    /* renamed from: b */
    private final C2367f f13817b;
    /* renamed from: c */
    private final Handler f13818c;
    /* renamed from: d */
    private final C2543l f13819d;
    /* renamed from: e */
    private final C4709e f13820e;
    /* renamed from: f */
    private final C2344a[] f13821f;
    /* renamed from: g */
    private final long[] f13822g;
    /* renamed from: h */
    private int f13823h;
    /* renamed from: i */
    private int f13824i;
    /* renamed from: j */
    private C2356b f13825j;
    /* renamed from: k */
    private boolean f13826k;

    /* renamed from: t */
    public boolean mo3418t() {
        return true;
    }

    public C4853g(C2367f c2367f, Looper looper) {
        this(c2367f, looper, C2366d.f5826a);
    }

    public C4853g(C2367f c2367f, Looper looper, C2366d c2366d) {
        super(4);
        this.f13817b = (C2367f) C2516a.m7015a((Object) c2367f);
        if (looper == null) {
            c2367f = null;
        } else {
            c2367f = new Handler(looper, this);
        }
        this.f13818c = c2367f;
        this.f13816a = (C2366d) C2516a.m7015a((Object) c2366d);
        this.f13819d = new C2543l();
        this.f13820e = new C4709e();
        this.f13821f = new C2344a[5];
        this.f13822g = new long[5];
    }

    /* renamed from: a */
    public int mo3411a(C2515k c2515k) {
        if (!this.f13816a.mo2228a(c2515k)) {
            return null;
        }
        return C4690a.m15998a(null, (C2255a) c2515k.f6383i) != null ? 4 : 2;
    }

    /* renamed from: a */
    protected void mo3420a(C2515k[] c2515kArr, long j) {
        this.f13825j = this.f13816a.mo2229b(c2515kArr[0]);
    }

    /* renamed from: a */
    protected void mo3413a(long j, boolean z) {
        m17283v();
        this.f13826k = 0;
    }

    /* renamed from: a */
    public void mo3412a(long j, long j2) {
        if (this.f13826k == null && this.f13824i < 5) {
            this.f13820e.mo2145a();
            if (m16000a((C2543l) this.f13819d, this.f13820e, false) == -4) {
                if (this.f13820e.m6206c() != null) {
                    this.f13826k = true;
                } else if (this.f13820e.g_() == null) {
                    this.f13820e.f12728d = this.f13819d.f6476a.f6397w;
                    this.f13820e.m12756h();
                    try {
                        j2 = (this.f13823h + this.f13824i) % 5;
                        this.f13821f[j2] = this.f13825j.mo2227a(this.f13820e);
                        this.f13822g[j2] = this.f13820e.c;
                        this.f13824i++;
                    } catch (long j3) {
                        throw C2330e.m6459a(j3, m16026r());
                    }
                }
            }
        }
        if (this.f13824i > null && this.f13822g[this.f13823h] <= j3) {
            m17281a(this.f13821f[this.f13823h]);
            this.f13821f[this.f13823h] = 0;
            this.f13823h = (this.f13823h + 1) % 5;
            this.f13824i--;
        }
    }

    /* renamed from: p */
    protected void mo3417p() {
        m17283v();
        this.f13825j = null;
    }

    /* renamed from: u */
    public boolean mo3419u() {
        return this.f13826k;
    }

    /* renamed from: a */
    private void m17281a(C2344a c2344a) {
        if (this.f13818c != null) {
            this.f13818c.obtainMessage(0, c2344a).sendToTarget();
        } else {
            m17282b(c2344a);
        }
    }

    /* renamed from: v */
    private void m17283v() {
        Arrays.fill(this.f13821f, null);
        this.f13823h = 0;
        this.f13824i = 0;
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            m17282b((C2344a) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    /* renamed from: b */
    private void m17282b(C2344a c2344a) {
        this.f13817b.mo2334a(c2344a);
    }
}
