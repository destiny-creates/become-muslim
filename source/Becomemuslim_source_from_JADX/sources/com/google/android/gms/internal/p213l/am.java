package com.google.android.gms.internal.p213l;

import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.internal.l.am */
final class am {
    /* renamed from: a */
    final String f16891a;
    /* renamed from: b */
    final String f16892b;
    /* renamed from: c */
    final long f16893c;
    /* renamed from: d */
    final long f16894d;
    /* renamed from: e */
    final long f16895e;
    /* renamed from: f */
    final long f16896f;
    /* renamed from: g */
    final Long f16897g;
    /* renamed from: h */
    final Long f16898h;
    /* renamed from: i */
    final Boolean f16899i;

    am(String str, String str2, long j, long j2, long j3, long j4, Long l, Long l2, Boolean bool) {
        am amVar = this;
        long j5 = j;
        long j6 = j2;
        long j7 = j4;
        C2872v.a(str);
        C2872v.a(str2);
        boolean z = false;
        C2872v.b(j5 >= 0);
        C2872v.b(j6 >= 0);
        if (j7 >= 0) {
            z = true;
        }
        C2872v.b(z);
        amVar.f16891a = str;
        amVar.f16892b = str2;
        amVar.f16893c = j5;
        amVar.f16894d = j6;
        amVar.f16895e = j3;
        amVar.f16896f = j7;
        amVar.f16897g = l;
        amVar.f16898h = l2;
        amVar.f16899i = bool;
    }

    /* renamed from: a */
    final am m21246a() {
        return new am(this.f16891a, this.f16892b, this.f16893c + 1, 1 + this.f16894d, this.f16895e, this.f16896f, this.f16897g, this.f16898h, this.f16899i);
    }

    /* renamed from: a */
    final am m21247a(long j) {
        return new am(this.f16891a, this.f16892b, this.f16893c, this.f16894d, j, this.f16896f, this.f16897g, this.f16898h, this.f16899i);
    }

    /* renamed from: a */
    final am m21248a(Long l, Long l2, Boolean bool) {
        am amVar = this;
        Boolean bool2 = (bool == null || bool.booleanValue()) ? bool : null;
        return new am(amVar.f16891a, amVar.f16892b, amVar.f16893c, amVar.f16894d, amVar.f16895e, amVar.f16896f, l, l2, bool2);
    }

    /* renamed from: b */
    final am m21249b(long j) {
        return new am(this.f16891a, this.f16892b, this.f16893c, this.f16894d, this.f16895e, j, this.f16897g, this.f16898h, this.f16899i);
    }
}
