package com.p050a.p051a.p060d;

import android.util.JsonReader;
import android.util.JsonToken;
import com.p050a.p051a.p062f.C0953d;

/* compiled from: ScaleXYParser */
/* renamed from: com.a.a.d.ad */
public class ad implements ak<C0953d> {
    /* renamed from: a */
    public static final ad f9014a = new ad();

    /* renamed from: b */
    public /* synthetic */ Object mo739b(JsonReader jsonReader, float f) {
        return m10771a(jsonReader, f);
    }

    private ad() {
    }

    /* renamed from: a */
    public C0953d m10771a(JsonReader jsonReader, float f) {
        Object obj = jsonReader.peek() == JsonToken.BEGIN_ARRAY ? 1 : null;
        if (obj != null) {
            jsonReader.beginArray();
        }
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (obj != null) {
            jsonReader.endArray();
        }
        return new C0953d((nextDouble / 100.0f) * f, (nextDouble2 / 100.0f) * f);
    }
}
