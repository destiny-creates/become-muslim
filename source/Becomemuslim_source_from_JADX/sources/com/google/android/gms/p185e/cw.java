package com.google.android.gms.p185e;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.p210i.C4992a;
import com.google.android.gms.internal.p210i.ct;
import java.util.Map;

/* renamed from: com.google.android.gms.e.cw */
final class cw extends aq {
    /* renamed from: a */
    private static final String f11676a = C4992a.f16274p.toString();
    /* renamed from: b */
    private final Context f11677b;

    public cw(Context context) {
        super(f11676a, new String[0]);
        this.f11677b = context;
    }

    /* renamed from: a */
    public final boolean mo2507a() {
        return true;
    }

    /* renamed from: a */
    public final ct mo2506a(Map<String, ct> map) {
        map = new DisplayMetrics();
        ((WindowManager) this.f11677b.getSystemService("window")).getDefaultDisplay().getMetrics(map);
        int i = map.widthPixels;
        map = map.heightPixels;
        StringBuilder stringBuilder = new StringBuilder(23);
        stringBuilder.append(i);
        stringBuilder.append("x");
        stringBuilder.append(map);
        return eu.m8716a(stringBuilder.toString());
    }
}
