package com.google.android.gms.iid;

/* renamed from: com.google.android.gms.iid.k */
public abstract class C3065k {
    /* renamed from: a */
    private static C3065k f7838a;

    /* renamed from: a */
    public abstract C3066l<Boolean> mo2604a(String str, boolean z);

    /* renamed from: a */
    public static synchronized C3065k m8972a() {
        C3065k c3065k;
        synchronized (C3065k.class) {
            if (f7838a == null) {
                f7838a = new C4430e();
            }
            c3065k = f7838a;
        }
        return c3065k;
    }
}
