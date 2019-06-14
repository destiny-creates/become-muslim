package com.google.p217b.p231e;

import com.facebook.appevents.AppEventsConstants;
import com.google.p217b.C5193a;
import com.google.p217b.C5309g;
import com.google.p217b.C5318u;
import com.google.p217b.p222b.C5202b;
import java.util.Map;

/* compiled from: UPCAWriter */
/* renamed from: com.google.b.e.u */
public final class C6875u implements C5318u {
    /* renamed from: a */
    private final C8235j f24693a = new C8235j();

    /* renamed from: a */
    public C5202b mo4860a(String str, C5193a c5193a, int i, int i2, Map<C5309g, ?> map) {
        if (c5193a == C5193a.UPC_A) {
            return this.f24693a.mo4860a(AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(str)), C5193a.EAN_13, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(c5193a)));
    }
}
