package com.google.android.gms.p185e;

import android.content.Context;
import com.google.android.gms.internal.p210i.C4992a;
import com.google.android.gms.internal.p210i.ct;
import java.util.Map;

/* renamed from: com.google.android.gms.e.fd */
final class fd extends aq {
    /* renamed from: a */
    private static final String f11732a = C4992a.f16249Q.toString();
    /* renamed from: b */
    private final Context f11733b;

    public fd(Context context) {
        super(f11732a, new String[0]);
        this.f11733b = context;
    }

    /* renamed from: a */
    public final boolean mo2507a() {
        return true;
    }

    /* renamed from: a */
    public final ct mo2506a(Map<String, ct> map) {
        try {
            return eu.m8716a(this.f11733b.getPackageManager().getPackageInfo(this.f11733b.getPackageName(), 0).versionName);
        } catch (Map<String, ct> map2) {
            String packageName = this.f11733b.getPackageName();
            map2 = map2.getMessage();
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(packageName).length() + 25) + String.valueOf(map2).length());
            stringBuilder.append("Package name ");
            stringBuilder.append(packageName);
            stringBuilder.append(" not found. ");
            stringBuilder.append(map2);
            bs.m8582a(stringBuilder.toString());
            return eu.m8736g();
        }
    }
}
