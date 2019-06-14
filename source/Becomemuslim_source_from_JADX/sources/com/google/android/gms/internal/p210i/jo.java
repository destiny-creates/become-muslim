package com.google.android.gms.internal.p210i;

import android.text.TextUtils;
import com.google.android.gms.analytics.C2716q;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.i.jo */
public final class jo extends C2716q<jo> {
    /* renamed from: a */
    public String f24552a;
    /* renamed from: b */
    public boolean f24553b;

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("description", this.f24552a);
        hashMap.put("fatal", Boolean.valueOf(this.f24553b));
        return jo.a(hashMap);
    }

    /* renamed from: a */
    public final /* synthetic */ void m31781a(C2716q c2716q) {
        jo joVar = (jo) c2716q;
        if (!TextUtils.isEmpty(this.f24552a)) {
            joVar.f24552a = this.f24552a;
        }
        if (this.f24553b) {
            joVar.f24553b = this.f24553b;
        }
    }
}
