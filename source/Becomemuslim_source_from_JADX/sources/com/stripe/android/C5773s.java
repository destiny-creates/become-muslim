package com.stripe.android;

import java.util.List;
import java.util.Map;

/* compiled from: StripeResponse */
/* renamed from: com.stripe.android.s */
class C5773s {
    /* renamed from: a */
    private String f19152a;
    /* renamed from: b */
    private int f19153b;
    /* renamed from: c */
    private Map<String, List<String>> f19154c;

    C5773s(int i, String str, Map<String, List<String>> map) {
        this.f19153b = i;
        this.f19152a = str;
        this.f19154c = map;
    }

    /* renamed from: a */
    int m24412a() {
        return this.f19153b;
    }

    /* renamed from: b */
    String m24413b() {
        return this.f19152a;
    }

    /* renamed from: c */
    Map<String, List<String>> m24414c() {
        return this.f19154c;
    }
}
