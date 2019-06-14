package com.p050a.p051a.p060d;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;

/* compiled from: PointFParser */
/* renamed from: com.a.a.d.z */
public class C3391z implements ak<PointF> {
    /* renamed from: a */
    public static final C3391z f9023a = new C3391z();

    /* renamed from: b */
    public /* synthetic */ Object mo739b(JsonReader jsonReader, float f) {
        return m10792a(jsonReader, f);
    }

    private C3391z() {
    }

    /* renamed from: a */
    public PointF m10792a(JsonReader jsonReader, float f) {
        JsonToken peek = jsonReader.peek();
        if (peek == JsonToken.BEGIN_ARRAY) {
            return C0932q.m3265b(jsonReader, f);
        }
        if (peek == JsonToken.BEGIN_OBJECT) {
            return C0932q.m3265b(jsonReader, f);
        }
        if (peek == JsonToken.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
            while (jsonReader.hasNext() != null) {
                jsonReader.skipValue();
            }
            return pointF;
        }
        f = new StringBuilder();
        f.append("Cannot convert json to point. Next token is ");
        f.append(peek);
        throw new IllegalArgumentException(f.toString());
    }
}
