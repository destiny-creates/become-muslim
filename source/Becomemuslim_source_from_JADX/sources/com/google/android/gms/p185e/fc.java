package com.google.android.gms.p185e;

import android.content.Context;
import com.google.android.gms.internal.p210i.C4992a;
import com.google.android.gms.internal.p210i.ct;
import java.util.Map;

/* renamed from: com.google.android.gms.e.fc */
final class fc extends aq {
    /* renamed from: a */
    private static final String f11730a = C4992a.f16263e.toString();
    /* renamed from: b */
    private final Context f11731b;

    public fc(Context context) {
        super(f11730a, new String[0]);
        this.f11731b = context;
    }

    /* renamed from: a */
    public final boolean mo2507a() {
        return true;
    }

    /* renamed from: a */
    public final ct mo2506a(Map<String, ct> map) {
        try {
            return eu.m8716a(Integer.valueOf(this.f11731b.getPackageManager().getPackageInfo(this.f11731b.getPackageName(), 0).versionCode));
        } catch (Map<String, ct> map2) {
            String packageName = this.f11731b.getPackageName();
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
