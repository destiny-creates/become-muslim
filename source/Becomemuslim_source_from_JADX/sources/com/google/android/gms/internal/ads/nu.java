package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

@cm
public final class nu {
    /* renamed from: a */
    public static final Executor f15846a = new nv();
    /* renamed from: b */
    public static final Executor f15847b = new nw();
    /* renamed from: c */
    private static final nt f15848c = m19956a(f15846a);
    /* renamed from: d */
    private static final nt f15849d = m19956a(f15847b);

    /* renamed from: a */
    public static nt m19956a(Executor executor) {
        return new nx(executor, null);
    }
}
