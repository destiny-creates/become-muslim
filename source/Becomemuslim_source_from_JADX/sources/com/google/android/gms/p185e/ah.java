package com.google.android.gms.p185e;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.p210i.C4992a;
import com.google.android.gms.internal.p210i.ct;
import java.util.Map;

/* renamed from: com.google.android.gms.e.ah */
final class ah extends aq {
    /* renamed from: a */
    private static final String f11608a = C4992a.f16279u.toString();
    /* renamed from: b */
    private final Context f11609b;

    public ah(Context context) {
        super(f11608a, new String[0]);
        this.f11609b = context;
    }

    /* renamed from: a */
    public final boolean mo2507a() {
        return true;
    }

    /* renamed from: a */
    public final ct mo2506a(Map<String, ct> map) {
        Object string = Secure.getString(this.f11609b.getContentResolver(), "android_id");
        return string == null ? eu.m8736g() : eu.m8716a(string);
    }
}
