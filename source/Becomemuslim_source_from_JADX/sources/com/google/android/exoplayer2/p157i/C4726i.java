package com.google.android.exoplayer2.p157i;

import com.google.android.exoplayer2.p135b.C4085e;

/* compiled from: SubtitleInputBuffer */
/* renamed from: com.google.android.exoplayer2.i.i */
public final class C4726i extends C4085e implements Comparable<C4726i> {
    /* renamed from: d */
    public long f12871d;

    public /* synthetic */ int compareTo(Object obj) {
        return m16263a((C4726i) obj);
    }

    public C4726i() {
        super(1);
    }

    /* renamed from: a */
    public int m16263a(C4726i c4726i) {
        int i = -1;
        if (m6206c() != c4726i.m6206c()) {
            if (m6206c() != null) {
                i = 1;
            }
            return i;
        }
        c4726i = ((this.c - c4726i.c) > 0 ? 1 : ((this.c - c4726i.c) == 0 ? 0 : -1));
        if (c4726i == null) {
            return null;
        }
        if (c4726i > null) {
            i = 1;
        }
        return i;
    }
}
