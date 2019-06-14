package com.google.android.gms.internal.ads;

final class aco implements acw {
    /* renamed from: a */
    private acw[] f23539a;

    aco(acw... acwArr) {
        this.f23539a = acwArr;
    }

    /* renamed from: a */
    public final boolean mo3737a(Class<?> cls) {
        for (acw a : this.f23539a) {
            if (a.mo3737a(cls)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public final acv mo3738b(Class<?> cls) {
        for (acw acw : this.f23539a) {
            if (acw.mo3737a(cls)) {
                return acw.mo3738b(cls);
            }
        }
        String str = "No factory is available for message type: ";
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }
}
