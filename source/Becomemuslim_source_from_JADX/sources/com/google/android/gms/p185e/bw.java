package com.google.android.gms.p185e;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.p210i.C4992a;
import com.google.android.gms.internal.p210i.ct;
import java.util.Map;

/* renamed from: com.google.android.gms.e.bw */
final class bw extends aq {
    /* renamed from: a */
    private static final String f11649a = C4992a.f16233A.toString();
    /* renamed from: b */
    private final Context f11650b;

    public bw(Context context) {
        super(f11649a, new String[0]);
        this.f11650b = context;
    }

    /* renamed from: a */
    public final boolean mo2507a() {
        return true;
    }

    /* renamed from: a */
    public final ct mo2506a(Map<String, ct> map) {
        Object string = Secure.getString(this.f11650b.getContentResolver(), "android_id");
        return string == null ? eu.m8736g() : eu.m8716a(string);
    }
}
