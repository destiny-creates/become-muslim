package com.google.android.gms.p185e;

import android.content.Context;
import com.google.android.gms.internal.p210i.C4992a;
import com.google.android.gms.internal.p210i.ct;
import java.util.Map;

/* renamed from: com.google.android.gms.e.fa */
final class fa extends aq {
    /* renamed from: a */
    private static final String f11726a = C4992a.f16261c.toString();
    /* renamed from: b */
    private final Context f11727b;

    public fa(Context context) {
        super(f11726a, new String[0]);
        this.f11727b = context;
    }

    /* renamed from: a */
    public final boolean mo2507a() {
        return true;
    }

    /* renamed from: a */
    public final ct mo2506a(Map<String, ct> map) {
        return eu.m8716a(this.f11727b.getPackageName());
    }
}
