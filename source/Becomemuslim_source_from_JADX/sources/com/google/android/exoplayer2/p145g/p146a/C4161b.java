package com.google.android.exoplayer2.p145g.p146a;

import com.google.android.exoplayer2.p145g.C2344a;
import com.google.android.exoplayer2.p145g.C2356b;
import com.google.android.exoplayer2.p145g.C4709e;
import com.google.android.exoplayer2.p164l.C2529l;
import java.util.Arrays;

/* compiled from: EventMessageDecoder */
/* renamed from: com.google.android.exoplayer2.g.a.b */
public final class C4161b implements C2356b {
    /* renamed from: a */
    public C2344a mo2227a(C4709e c4709e) {
        c4709e = c4709e.b;
        byte[] array = c4709e.array();
        c4709e = c4709e.limit();
        C2529l c2529l = new C2529l(array, c4709e);
        String y = c2529l.m7121y();
        String y2 = c2529l.m7121y();
        long m = c2529l.m7109m();
        c2529l.m7098d(4);
        m = (c2529l.m7109m() * 1000) / m;
        long m2 = c2529l.m7109m();
        byte[] copyOfRange = Arrays.copyOfRange(array, c2529l.m7097d(), c4709e);
        return new C2344a(new C4160a(y, y2, m, m2, copyOfRange));
    }
}
