package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* renamed from: com.google.android.gms.auth.api.signin.f */
final /* synthetic */ class C2737f implements Comparator {
    /* renamed from: a */
    static final Comparator f7028a = new C2737f();

    private C2737f() {
    }

    public final int compare(Object obj, Object obj2) {
        return ((Scope) obj).m16700a().compareTo(((Scope) obj2).m16700a());
    }
}
