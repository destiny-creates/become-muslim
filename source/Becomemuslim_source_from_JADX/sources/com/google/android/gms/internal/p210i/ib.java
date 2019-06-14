package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.ib */
abstract class ib<T, B> {
    ib() {
    }

    /* renamed from: a */
    abstract B mo4585a();

    /* renamed from: a */
    abstract T mo4586a(B b);

    /* renamed from: a */
    abstract void mo4587a(B b, int i, int i2);

    /* renamed from: a */
    abstract void mo4588a(B b, int i, long j);

    /* renamed from: a */
    abstract void mo4589a(B b, int i, dy dyVar);

    /* renamed from: a */
    abstract void mo4590a(B b, int i, T t);

    /* renamed from: a */
    abstract void mo4591a(T t, ix ixVar);

    /* renamed from: a */
    abstract void mo4592a(Object obj, T t);

    /* renamed from: a */
    abstract boolean mo4593a(hh hhVar);

    /* renamed from: b */
    abstract T mo4594b(Object obj);

    /* renamed from: b */
    abstract void mo4595b(B b, int i, long j);

    /* renamed from: b */
    abstract void mo4596b(T t, ix ixVar);

    /* renamed from: b */
    abstract void mo4597b(Object obj, B b);

    /* renamed from: c */
    abstract B mo4598c(Object obj);

    /* renamed from: c */
    abstract T mo4599c(T t, T t2);

    /* renamed from: d */
    abstract void mo4600d(Object obj);

    /* renamed from: e */
    abstract int mo4601e(T t);

    /* renamed from: f */
    abstract int mo4602f(T t);

    /* renamed from: a */
    final boolean m20773a(B b, hh hhVar) {
        int b2 = hhVar.mo4464b();
        int i = b2 >>> 3;
        switch (b2 & 7) {
            case 0:
                mo4588a((Object) b, i, hhVar.mo4476g());
                return true;
            case 1:
                mo4595b(b, i, hhVar.mo4480i());
                return true;
            case 2:
                mo4589a((Object) b, i, hhVar.mo4490n());
                return true;
            case 3:
                Object a = mo4585a();
                int i2 = (i << 3) | 4;
                while (hhVar.mo4459a() != Integer.MAX_VALUE) {
                    if (!m20773a(a, hhVar)) {
                        if (i2 != hhVar.mo4464b()) {
                            mo4590a((Object) b, i, mo4586a(a));
                            return true;
                        }
                        throw fs.m20571d();
                    }
                }
                if (i2 != hhVar.mo4464b()) {
                    throw fs.m20571d();
                }
                mo4590a((Object) b, i, mo4586a(a));
                return true;
            case 4:
                return null;
            case 5:
                mo4587a((Object) b, i, hhVar.mo4482j());
                return true;
            default:
                throw fs.m20572e();
        }
    }
}
