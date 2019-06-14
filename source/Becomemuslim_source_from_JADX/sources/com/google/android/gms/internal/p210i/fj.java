package com.google.android.gms.internal.p210i;

import com.google.android.gms.internal.p210i.fk.C4996e;

/* renamed from: com.google.android.gms.internal.i.fj */
final class fj implements gs {
    /* renamed from: a */
    private static final fj f24499a = new fj();

    private fj() {
    }

    /* renamed from: a */
    public static fj m31595a() {
        return f24499a;
    }

    /* renamed from: a */
    public final boolean mo4552a(Class<?> cls) {
        return fk.class.isAssignableFrom(cls);
    }

    /* renamed from: b */
    public final gr mo4553b(Class<?> cls) {
        if (fk.class.isAssignableFrom(cls)) {
            try {
                return (gr) fk.m42483a(cls.asSubclass(fk.class)).mo6849a(C4996e.f16605c, null, null);
            } catch (Throwable e) {
                String str = "Unable to get message info for ";
                cls = String.valueOf(cls.getName());
                throw new RuntimeException(cls.length() != 0 ? str.concat(cls) : new String(str), e);
            }
        }
        String str2 = "Unsupported message type: ";
        cls = String.valueOf(cls.getName());
        throw new IllegalArgumentException(cls.length() != 0 ? str2.concat(cls) : new String(str2));
    }
}
