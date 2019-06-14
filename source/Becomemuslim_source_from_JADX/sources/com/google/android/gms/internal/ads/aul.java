package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.gmsg.ae;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class aul implements ae<Object> {
    /* renamed from: a */
    private final WeakReference<auh> f23811a;
    /* renamed from: b */
    private final String f23812b;

    public aul(auh auh, String str) {
        this.f23811a = new WeakReference(auh);
        this.f23812b = str;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = (String) map.get("ads_id");
        String str2 = (String) map.get("eventName");
        if (!TextUtils.isEmpty(str)) {
            if (this.f23812b.equals(str)) {
                try {
                    Integer.parseInt((String) map.get("eventType"));
                } catch (Throwable e) {
                    mt.m19919b("Parse Scion log event type error", e);
                }
                auh auh;
                if ("_ai".equals(str2)) {
                    auh = (auh) this.f23811a.get();
                    if (auh != null) {
                        auh.m18977x();
                    }
                } else if ("_ac".equals(str2)) {
                    auh = (auh) this.f23811a.get();
                    if (auh != null) {
                        auh.m18978y();
                    }
                }
            }
        }
    }
}
