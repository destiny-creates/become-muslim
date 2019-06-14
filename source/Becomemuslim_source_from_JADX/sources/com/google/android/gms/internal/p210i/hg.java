package com.google.android.gms.internal.p210i;

import com.google.android.gms.internal.p210i.fk.C4996e;

/* renamed from: com.google.android.gms.internal.i.hg */
final class hg implements gr {
    /* renamed from: a */
    private final gt f24528a;
    /* renamed from: b */
    private final String f24529b;
    /* renamed from: c */
    private final Object[] f24530c;
    /* renamed from: d */
    private final int f24531d;

    hg(gt gtVar, String str, Object[] objArr) {
        this.f24528a = gtVar;
        this.f24529b = str;
        this.f24530c = objArr;
        gtVar = str.charAt(null);
        if (gtVar < 55296) {
            this.f24531d = gtVar;
            return;
        }
        gtVar &= 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt >= '?') {
                gtVar |= (charAt & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.f24531d = gtVar | (charAt << i);
                return;
            }
        }
    }

    /* renamed from: d */
    final String m31687d() {
        return this.f24529b;
    }

    /* renamed from: e */
    final Object[] m31688e() {
        return this.f24530c;
    }

    /* renamed from: c */
    public final gt mo4580c() {
        return this.f24528a;
    }

    /* renamed from: a */
    public final int mo4578a() {
        return (this.f24531d & 1) == 1 ? C4996e.f16610h : C4996e.f16611i;
    }

    /* renamed from: b */
    public final boolean mo4579b() {
        return (this.f24531d & 2) == 2;
    }
}
