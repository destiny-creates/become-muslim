package com.google.android.exoplayer2.p137e;

import com.google.android.exoplayer2.C2515k;
import com.google.android.exoplayer2.p137e.C2329m.C2328a;
import com.google.android.exoplayer2.p164l.C2529l;
import java.io.EOFException;

/* compiled from: DummyTrackOutput */
/* renamed from: com.google.android.exoplayer2.e.d */
public final class C4115d implements C2329m {
    /* renamed from: a */
    public void mo2198a(long j, int i, int i2, int i3, C2328a c2328a) {
    }

    /* renamed from: a */
    public void mo2199a(C2515k c2515k) {
    }

    /* renamed from: a */
    public int mo2197a(C2304f c2304f, int i, boolean z) {
        c2304f = c2304f.mo2181a(i);
        if (c2304f != -1) {
            return c2304f;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    /* renamed from: a */
    public void mo2200a(C2529l c2529l, int i) {
        c2529l.m7098d(i);
    }
}
