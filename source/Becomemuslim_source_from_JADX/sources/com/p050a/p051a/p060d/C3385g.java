package com.p050a.p051a.p060d;

import android.graphics.Color;
import android.util.JsonReader;
import android.util.JsonToken;

/* compiled from: ColorParser */
/* renamed from: com.a.a.d.g */
public class C3385g implements ak<Integer> {
    /* renamed from: a */
    public static final C3385g f9017a = new C3385g();

    /* renamed from: b */
    public /* synthetic */ Object mo739b(JsonReader jsonReader, float f) {
        return m10778a(jsonReader, f);
    }

    private C3385g() {
    }

    /* renamed from: a */
    public Integer m10778a(JsonReader jsonReader, float f) {
        f = jsonReader.peek() == JsonToken.BEGIN_ARRAY ? Float.MIN_VALUE : 0.0f;
        if (f != null) {
            jsonReader.beginArray();
        }
        double nextDouble = jsonReader.nextDouble();
        double nextDouble2 = jsonReader.nextDouble();
        double nextDouble3 = jsonReader.nextDouble();
        double nextDouble4 = jsonReader.nextDouble();
        if (f != null) {
            jsonReader.endArray();
        }
        if (nextDouble <= 1.0d && nextDouble2 <= 1.0d && nextDouble3 <= 1.0d && nextDouble4 <= 1.0d) {
            nextDouble *= 255.0d;
            nextDouble2 *= 255.0d;
            nextDouble3 *= 255.0d;
            nextDouble4 *= 255.0d;
        }
        return Integer.valueOf(Color.argb((int) nextDouble4, (int) nextDouble, (int) nextDouble2, (int) nextDouble3));
    }
}
