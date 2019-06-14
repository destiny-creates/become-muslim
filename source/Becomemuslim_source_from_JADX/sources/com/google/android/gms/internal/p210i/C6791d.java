package com.google.android.gms.internal.p210i;

import android.text.TextUtils;
import com.google.android.gms.analytics.C2716q;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.i.d */
public final class C6791d extends C2716q<C6791d> {
    /* renamed from: a */
    public String f24460a;
    /* renamed from: b */
    public long f24461b;
    /* renamed from: c */
    public String f24462c;
    /* renamed from: d */
    public String f24463d;

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("variableName", this.f24460a);
        hashMap.put("timeInMillis", Long.valueOf(this.f24461b));
        hashMap.put("category", this.f24462c);
        hashMap.put("label", this.f24463d);
        return C6791d.a(hashMap);
    }

    /* renamed from: a */
    public final /* synthetic */ void m31328a(C2716q c2716q) {
        C6791d c6791d = (C6791d) c2716q;
        if (!TextUtils.isEmpty(this.f24460a)) {
            c6791d.f24460a = this.f24460a;
        }
        if (this.f24461b != 0) {
            c6791d.f24461b = this.f24461b;
        }
        if (!TextUtils.isEmpty(this.f24462c)) {
            c6791d.f24462c = this.f24462c;
        }
        if (!TextUtils.isEmpty(this.f24463d)) {
            c6791d.f24463d = this.f24463d;
        }
    }
}
