package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.jn;
import java.util.Map;

/* renamed from: com.google.android.gms.ads.internal.gmsg.y */
final class C4284y implements ae<Object> {
    C4284y() {
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = "Received log message: ";
        String valueOf = String.valueOf((String) map.get("string"));
        jn.d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }
}
