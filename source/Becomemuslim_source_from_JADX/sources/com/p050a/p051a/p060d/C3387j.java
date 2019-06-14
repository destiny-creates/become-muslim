package com.p050a.p051a.p060d;

import android.util.JsonReader;

/* compiled from: FloatParser */
/* renamed from: com.a.a.d.j */
public class C3387j implements ak<Float> {
    /* renamed from: a */
    public static final C3387j f9019a = new C3387j();

    /* renamed from: b */
    public /* synthetic */ Object mo739b(JsonReader jsonReader, float f) {
        return m10782a(jsonReader, f);
    }

    private C3387j() {
    }

    /* renamed from: a */
    public Float m10782a(JsonReader jsonReader, float f) {
        return Float.valueOf(C0932q.m3264b(jsonReader) * f);
    }
}
