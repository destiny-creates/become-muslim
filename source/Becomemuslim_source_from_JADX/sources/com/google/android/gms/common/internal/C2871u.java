package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.C2782b;
import com.google.android.gms.common.api.C2789g;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.p186f.C2954g;
import com.google.android.gms.p186f.C2955h;

/* renamed from: com.google.android.gms.common.internal.u */
public class C2871u {
    /* renamed from: a */
    private static final C2870b f7335a = new ak();

    /* renamed from: com.google.android.gms.common.internal.u$a */
    public interface C2869a<R extends C2814k, T> {
        /* renamed from: a */
        T mo2359a(R r);
    }

    /* renamed from: com.google.android.gms.common.internal.u$b */
    public interface C2870b {
        /* renamed from: a */
        C2782b mo2466a(Status status);
    }

    /* renamed from: a */
    public static <R extends C2814k, T> C2954g<T> m8378a(C2789g<R> c2789g, C2869a<R, T> c2869a) {
        C2870b c2870b = f7335a;
        C2955h c2955h = new C2955h();
        c2789g.mo2378a(new al(c2789g, c2955h, c2869a, c2870b));
        return c2955h.m8783a();
    }

    /* renamed from: a */
    public static <R extends C2814k> C2954g<Void> m8377a(C2789g<R> c2789g) {
        return C2871u.m8378a(c2789g, new am());
    }
}
