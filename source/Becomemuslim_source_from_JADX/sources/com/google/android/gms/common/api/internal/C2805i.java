package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.internal.C2804h.C2802a;
import com.google.android.gms.common.internal.C2872v;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.google.android.gms.common.api.internal.i */
public class C2805i {
    /* renamed from: a */
    private final Set<C2804h<?>> f7207a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: a */
    public final void m8086a() {
        for (C2804h a : this.f7207a) {
            a.m8080a();
        }
        this.f7207a.clear();
    }

    /* renamed from: a */
    public static <L> C2804h<L> m8085a(L l, Looper looper, String str) {
        C2872v.m8381a((Object) l, (Object) "Listener must not be null");
        C2872v.m8381a((Object) looper, (Object) "Looper must not be null");
        C2872v.m8381a((Object) str, (Object) "Listener type must not be null");
        return new C2804h(looper, l, str);
    }

    /* renamed from: a */
    public static <L> C2802a<L> m8084a(L l, String str) {
        C2872v.m8381a((Object) l, (Object) "Listener must not be null");
        C2872v.m8381a((Object) str, (Object) "Listener type must not be null");
        C2872v.m8383a(str, (Object) "Listener type must not be empty");
        return new C2802a(l, str);
    }
}
