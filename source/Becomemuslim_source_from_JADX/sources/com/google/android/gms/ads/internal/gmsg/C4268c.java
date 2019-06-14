package com.google.android.gms.ads.internal.gmsg;

import android.content.Context;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.internal.ads.cm;
import java.util.Map;

@cm
/* renamed from: com.google.android.gms.ads.internal.gmsg.c */
public final class C4268c implements ae<Object> {
    /* renamed from: a */
    private final Context f11284a;

    public C4268c(Context context) {
        this.f11284a = context;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (ax.m7455B().a(this.f11284a)) {
            ax.m7455B().a(this.f11284a, (String) map.get("eventName"), (String) map.get("eventId"));
        }
    }
}
