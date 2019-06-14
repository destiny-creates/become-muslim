package com.google.android.gms.internal.p210i;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.google.android.gms.analytics.C2716q;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.i.c */
public final class C6790c extends C2716q<C6790c> {
    /* renamed from: a */
    public String f24455a;
    /* renamed from: b */
    public String f24456b;
    /* renamed from: c */
    public String f24457c;

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("network", this.f24455a);
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, this.f24456b);
        hashMap.put(TouchesHelper.TARGET_KEY, this.f24457c);
        return C6790c.a(hashMap);
    }

    /* renamed from: a */
    public final /* synthetic */ void m31323a(C2716q c2716q) {
        C6790c c6790c = (C6790c) c2716q;
        if (!TextUtils.isEmpty(this.f24455a)) {
            c6790c.f24455a = this.f24455a;
        }
        if (!TextUtils.isEmpty(this.f24456b)) {
            c6790c.f24456b = this.f24456b;
        }
        if (!TextUtils.isEmpty(this.f24457c)) {
            c6790c.f24457c = this.f24457c;
        }
    }
}
