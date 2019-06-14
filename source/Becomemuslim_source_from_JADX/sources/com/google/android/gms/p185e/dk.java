package com.google.android.gms.p185e;

import android.content.Context;
import com.google.android.gms.internal.p210i.C4992a;
import com.google.android.gms.internal.p210i.ct;
import java.util.Map;

/* renamed from: com.google.android.gms.e.dk */
final class dk extends aq {
    /* renamed from: a */
    private static final String f11679a = C4992a.f16260b.toString();
    /* renamed from: b */
    private final C2938e f11680b;

    public dk(Context context) {
        this(C2938e.m8691a(context));
    }

    /* renamed from: a */
    public final boolean mo2507a() {
        return false;
    }

    private dk(C2938e c2938e) {
        super(f11679a, new String[0]);
        this.f11680b = c2938e;
    }

    /* renamed from: a */
    public final ct mo2506a(Map<String, ct> map) {
        return eu.m8716a(Boolean.valueOf(this.f11680b.m8698b() ^ 1));
    }
}
