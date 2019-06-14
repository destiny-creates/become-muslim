package com.google.android.gms.p185e;

import android.content.Context;
import com.google.android.gms.internal.p210i.C4992a;
import com.google.android.gms.internal.p210i.ct;
import java.util.Map;

/* renamed from: com.google.android.gms.e.fb */
final class fb extends aq {
    /* renamed from: a */
    private static final String f11728a = C4992a.f16262d.toString();
    /* renamed from: b */
    private final Context f11729b;

    public fb(Context context) {
        super(f11728a, new String[0]);
        this.f11729b = context;
    }

    /* renamed from: a */
    public final boolean mo2507a() {
        return true;
    }

    /* renamed from: a */
    public final ct mo2506a(Map<String, ct> map) {
        try {
            map = this.f11729b.getPackageManager();
            return eu.m8716a(map.getApplicationLabel(map.getApplicationInfo(this.f11729b.getPackageName(), 0)).toString());
        } catch (Map<String, ct> map2) {
            bs.m8583a("App name is not found.", map2);
            return eu.m8736g();
        }
    }
}
