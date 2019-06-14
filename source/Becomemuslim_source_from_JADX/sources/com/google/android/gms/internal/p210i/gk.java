package com.google.android.gms.internal.p210i;

/* renamed from: com.google.android.gms.internal.i.gk */
final class gk implements gs {
    /* renamed from: a */
    private gs[] f24504a;

    gk(gs... gsVarArr) {
        this.f24504a = gsVarArr;
    }

    /* renamed from: a */
    public final boolean mo4552a(Class<?> cls) {
        for (gs a : this.f24504a) {
            if (a.mo4552a(cls)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public final gr mo4553b(Class<?> cls) {
        for (gs gsVar : this.f24504a) {
            if (gsVar.mo4552a(cls)) {
                return gsVar.mo4553b(cls);
            }
        }
        String str = "No factory is available for message type: ";
        cls = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(cls.length() != 0 ? str.concat(cls) : new String(str));
    }
}
