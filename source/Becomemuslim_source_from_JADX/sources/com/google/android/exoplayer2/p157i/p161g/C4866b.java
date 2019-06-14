package com.google.android.exoplayer2.p157i.p161g;

import com.google.android.exoplayer2.p157i.C2458b;
import com.google.android.exoplayer2.p157i.C2464e;
import com.google.android.exoplayer2.p157i.C2473g;
import com.google.android.exoplayer2.p157i.C4725c;
import com.google.android.exoplayer2.p157i.p161g.C4232e.C2468a;
import com.google.android.exoplayer2.p164l.C2529l;
import com.google.android.exoplayer2.p164l.C2541v;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: Mp4WebvttDecoder */
/* renamed from: com.google.android.exoplayer2.i.g.b */
public final class C4866b extends C4725c {
    /* renamed from: a */
    private static final int f13907a = C2541v.m7193g("payl");
    /* renamed from: b */
    private static final int f13908b = C2541v.m7193g("sttg");
    /* renamed from: c */
    private static final int f13909c = C2541v.m7193g("vttc");
    /* renamed from: d */
    private final C2529l f13910d = new C2529l();
    /* renamed from: e */
    private final C2468a f13911e = new C2468a();

    /* renamed from: a */
    protected /* synthetic */ C2464e mo3431a(byte[] bArr, int i, boolean z) {
        return m17394b(bArr, i, z);
    }

    public C4866b() {
        super("Mp4WebvttDecoder");
    }

    /* renamed from: b */
    protected C4231c m17394b(byte[] bArr, int i, boolean z) {
        this.f13910d.m7091a(bArr, i);
        bArr = new ArrayList();
        while (this.f13910d.m7093b() > 0) {
            if (this.f13910d.m7093b() >= true) {
                i = this.f13910d.m7111o();
                if (this.f13910d.m7111o() == f13909c) {
                    bArr.add(C4866b.m17392a(this.f13910d, this.f13911e, i - 8));
                } else {
                    this.f13910d.m7098d(i - 8);
                }
            } else {
                throw new C2473g("Incomplete Mp4Webvtt Top Level box header found.");
            }
        }
        return new C4231c(bArr);
    }

    /* renamed from: a */
    private static C2458b m17392a(C2529l c2529l, C2468a c2468a, int i) {
        c2468a.m6880a();
        while (i > 0) {
            if (i >= 8) {
                int o = c2529l.m7111o();
                int o2 = c2529l.m7111o();
                i -= 8;
                o -= 8;
                String str = new String(c2529l.f6441a, c2529l.m7097d(), o);
                c2529l.m7098d(o);
                i -= o;
                if (o2 == f13908b) {
                    C2471f.m6894a(str, c2468a);
                } else if (o2 == f13907a) {
                    C2471f.m6896a(null, str.trim(), c2468a, Collections.emptyList());
                }
            } else {
                throw new C2473g("Incomplete vtt cue box header found.");
            }
        }
        return c2468a.m6884b();
    }
}
