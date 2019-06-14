package com.google.android.gms.ads.internal.gmsg;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.jn;
import java.util.Map;

@cm
public final class ah implements ae<Object> {
    /* renamed from: a */
    private final ai f11282a;

    public ah(ai aiVar) {
        this.f11282a = aiVar;
    }

    public final void zza(Object obj, Map<String, String> map) {
        boolean equals = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("transparentBackground"));
        boolean equals2 = AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(map.get("blur"));
        float f = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f = Float.parseFloat((String) map.get("blurRadius"));
            }
        } catch (Throwable e) {
            jn.b("Fail to parse float", e);
        }
        this.f11282a.mo3589a(equals);
        this.f11282a.mo3590a(equals2, f);
    }
}
