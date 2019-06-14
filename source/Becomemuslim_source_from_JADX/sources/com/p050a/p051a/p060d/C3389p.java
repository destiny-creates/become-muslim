package com.p050a.p051a.p060d;

import android.util.JsonReader;

/* compiled from: IntegerParser */
/* renamed from: com.a.a.d.p */
public class C3389p implements ak<Integer> {
    /* renamed from: a */
    public static final C3389p f9021a = new C3389p();

    /* renamed from: b */
    public /* synthetic */ Object mo739b(JsonReader jsonReader, float f) {
        return m10788a(jsonReader, f);
    }

    private C3389p() {
    }

    /* renamed from: a */
    public Integer m10788a(JsonReader jsonReader, float f) {
        return Integer.valueOf(Math.round(C0932q.m3264b(jsonReader) * f));
    }
}
