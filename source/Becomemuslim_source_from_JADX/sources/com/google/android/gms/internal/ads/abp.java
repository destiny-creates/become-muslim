package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C4918e;

final class abp implements acw {
    /* renamed from: a */
    private static final abp f23534a = new abp();

    private abp() {
    }

    /* renamed from: a */
    public static abp m29729a() {
        return f23534a;
    }

    /* renamed from: a */
    public final boolean mo3737a(Class<?> cls) {
        return abq.class.isAssignableFrom(cls);
    }

    /* renamed from: b */
    public final acv mo3738b(Class<?> cls) {
        if (abq.class.isAssignableFrom(cls)) {
            try {
                return (acv) abq.m42171a(cls.asSubclass(abq.class)).mo6835a(C4918e.f14224c, null, null);
            } catch (Throwable e) {
                String str = "Unable to get message info for ";
                String valueOf = String.valueOf(cls.getName());
                throw new RuntimeException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e);
            }
        }
        String str2 = "Unsupported message type: ";
        valueOf = String.valueOf(cls.getName());
        throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }
}
