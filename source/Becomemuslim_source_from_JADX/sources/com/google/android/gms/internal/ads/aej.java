package com.google.android.gms.internal.ads;

abstract class aej<T, B> {
    aej() {
    }

    /* renamed from: a */
    abstract B mo3771a();

    /* renamed from: a */
    abstract T mo3772a(B b);

    /* renamed from: a */
    abstract void mo3773a(B b, int i, int i2);

    /* renamed from: a */
    abstract void mo3774a(B b, int i, long j);

    /* renamed from: a */
    abstract void mo3775a(B b, int i, aai aai);

    /* renamed from: a */
    abstract void mo3776a(B b, int i, T t);

    /* renamed from: a */
    abstract void mo3777a(T t, afd afd);

    /* renamed from: a */
    abstract void mo3778a(Object obj, T t);

    /* renamed from: a */
    abstract boolean mo3779a(adp adp);

    /* renamed from: a */
    final boolean m18185a(B b, adp adp) {
        int b2 = adp.mo3648b();
        int i = b2 >>> 3;
        switch (b2 & 7) {
            case 0:
                mo3774a((Object) b, i, adp.mo3660g());
                return true;
            case 1:
                mo3781b(b, i, adp.mo3664i());
                return true;
            case 2:
                mo3775a((Object) b, i, adp.mo3674n());
                return true;
            case 3:
                Object a = mo3771a();
                int i2 = (i << 3) | 4;
                while (adp.mo3643a() != Integer.MAX_VALUE) {
                    if (!m18185a(a, adp)) {
                        if (i2 != adp.mo3648b()) {
                            mo3776a((Object) b, i, mo3772a(a));
                            return true;
                        }
                        throw abw.m17949e();
                    }
                }
                if (i2 != adp.mo3648b()) {
                    throw abw.m17949e();
                }
                mo3776a((Object) b, i, mo3772a(a));
                return true;
            case 4:
                return false;
            case 5:
                mo3773a((Object) b, i, adp.mo3666j());
                return true;
            default:
                throw abw.m17950f();
        }
    }

    /* renamed from: b */
    abstract T mo3780b(Object obj);

    /* renamed from: b */
    abstract void mo3781b(B b, int i, long j);

    /* renamed from: b */
    abstract void mo3782b(T t, afd afd);

    /* renamed from: b */
    abstract void mo3783b(Object obj, B b);

    /* renamed from: c */
    abstract B mo3784c(Object obj);

    /* renamed from: c */
    abstract T mo3785c(T t, T t2);

    /* renamed from: d */
    abstract void mo3786d(Object obj);

    /* renamed from: e */
    abstract int mo3787e(T t);

    /* renamed from: f */
    abstract int mo3788f(T t);
}
