package com.google.android.gms.p185e;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.p185e.C2934c.C2932b;
import java.util.Map;

/* renamed from: com.google.android.gms.e.el */
final class el implements C2932b {
    /* renamed from: a */
    private final Context f11714a;

    public el(Context context) {
        this.f11714a = context;
    }

    /* renamed from: a */
    public final void mo2559a(Map<String, Object> map) {
        Object obj = map.get("gtm.url");
        if (obj == null) {
            map = map.get("gtm");
            if (map != null && (map instanceof Map)) {
                obj = map.get("url");
            }
        }
        if (obj != null) {
            if ((obj instanceof String) != null) {
                map = Uri.parse((String) obj).getQueryParameter("referrer");
                if (map != null) {
                    bf.m8573b(this.f11714a, map);
                }
            }
        }
    }
}
