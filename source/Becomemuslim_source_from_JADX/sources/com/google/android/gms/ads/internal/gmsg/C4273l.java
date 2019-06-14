package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.jn;
import java.util.Map;

@cm
/* renamed from: com.google.android.gms.ads.internal.gmsg.l */
public final class C4273l implements ae<Object> {
    /* renamed from: a */
    private final C2652m f11303a;

    public C4273l(C2652m c2652m) {
        this.f11303a = c2652m;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = (String) map.get("name");
        if (str == null) {
            jn.e("App event with no name parameter.");
        } else {
            this.f11303a.mo3252a(str, (String) map.get("info"));
        }
    }
}
