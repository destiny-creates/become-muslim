package com.google.android.gms.internal.p210i;

import com.google.android.gms.analytics.C2716q;
import com.google.android.gms.common.internal.C2872v;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.i.ik */
public final class ik extends C2716q<ik> {
    /* renamed from: a */
    private final Map<String, Object> f24536a = new HashMap();

    public final String toString() {
        return ik.a(this.f24536a);
    }

    /* renamed from: a */
    public final void m31753a(String str, String str2) {
        C2872v.a(str);
        if (str != null && str.startsWith("&")) {
            str = str.substring(1);
        }
        C2872v.a(str, "Name can not be empty or \"&\"");
        this.f24536a.put(str, str2);
    }

    /* renamed from: a */
    public final Map<String, Object> m31751a() {
        return Collections.unmodifiableMap(this.f24536a);
    }

    /* renamed from: a */
    public final /* synthetic */ void m31752a(C2716q c2716q) {
        ik ikVar = (ik) c2716q;
        C2872v.a(ikVar);
        ikVar.f24536a.putAll(this.f24536a);
    }
}
