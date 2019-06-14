package com.google.android.gms.internal.p210i;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.analytics.C2716q;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.i.jn */
public final class jn extends C2716q<jn> {
    /* renamed from: a */
    private String f24548a;
    /* renamed from: b */
    private String f24549b;
    /* renamed from: c */
    private String f24550c;
    /* renamed from: d */
    private long f24551d;

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("category", this.f24548a);
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, this.f24549b);
        hashMap.put("label", this.f24550c);
        hashMap.put("value", Long.valueOf(this.f24551d));
        return jn.a(hashMap);
    }

    /* renamed from: a */
    public final String m31776a() {
        return this.f24548a;
    }

    /* renamed from: b */
    public final String m31778b() {
        return this.f24549b;
    }

    /* renamed from: c */
    public final String m31779c() {
        return this.f24550c;
    }

    /* renamed from: d */
    public final long m31780d() {
        return this.f24551d;
    }

    /* renamed from: a */
    public final /* synthetic */ void m31777a(C2716q c2716q) {
        jn jnVar = (jn) c2716q;
        if (!TextUtils.isEmpty(this.f24548a)) {
            jnVar.f24548a = this.f24548a;
        }
        if (!TextUtils.isEmpty(this.f24549b)) {
            jnVar.f24549b = this.f24549b;
        }
        if (!TextUtils.isEmpty(this.f24550c)) {
            jnVar.f24550c = this.f24550c;
        }
        if (this.f24551d != 0) {
            jnVar.f24551d = this.f24551d;
        }
    }
}
