package com.google.p217b.p222b.p224b;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ReedSolomonEncoder */
/* renamed from: com.google.b.b.b.d */
public final class C5200d {
    /* renamed from: a */
    private final C5197a f17534a;
    /* renamed from: b */
    private final List<C5198b> f17535b = new ArrayList();

    public C5200d(C5197a c5197a) {
        this.f17534a = c5197a;
        this.f17535b.add(new C5198b(c5197a, new int[]{1}));
    }

    /* renamed from: a */
    private C5198b m21995a(int i) {
        if (i >= this.f17535b.size()) {
            C5198b c5198b = (C5198b) this.f17535b.get(this.f17535b.size() - 1);
            for (int size = this.f17535b.size(); size <= i; size++) {
                c5198b = c5198b.m21987b(new C5198b(this.f17534a, new int[]{1, this.f17534a.m21972a((size - 1) + this.f17534a.m21980d())}));
                this.f17535b.add(c5198b);
            }
        }
        return (C5198b) this.f17535b.get(i);
    }

    /* renamed from: a */
    public void m21996a(int[] iArr, int i) {
        if (i != 0) {
            int length = iArr.length - i;
            if (length > 0) {
                C5198b a = m21995a(i);
                Object obj = new int[length];
                System.arraycopy(iArr, 0, obj, 0, length);
                Object a2 = new C5198b(this.f17534a, obj).m21982a(i, 1).m21990c(a)[1].m21984a();
                i -= a2.length;
                for (int i2 = 0; i2 < i; i2++) {
                    iArr[length + i2] = 0;
                }
                System.arraycopy(a2, 0, iArr, length + i, a2.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}
