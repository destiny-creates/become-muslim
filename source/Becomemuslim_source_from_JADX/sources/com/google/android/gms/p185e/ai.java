package com.google.android.gms.p185e;

import android.os.Build;
import com.google.android.gms.internal.p210i.C4992a;
import com.google.android.gms.internal.p210i.ct;
import java.util.Map;

/* renamed from: com.google.android.gms.e.ai */
final class ai extends aq {
    /* renamed from: a */
    private static final String f11610a = C4992a.f16267i.toString();

    public ai() {
        super(f11610a, new String[0]);
    }

    /* renamed from: a */
    public final boolean mo2507a() {
        return true;
    }

    /* renamed from: a */
    public final ct mo2506a(Map<String, ct> map) {
        map = Build.MANUFACTURER;
        Object obj = Build.MODEL;
        if (!(obj.startsWith(map) || map.equals("unknown"))) {
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(map).length() + 1) + String.valueOf(obj).length());
            stringBuilder.append(map);
            stringBuilder.append(" ");
            stringBuilder.append(obj);
            obj = stringBuilder.toString();
        }
        return eu.m8716a(obj);
    }
}
