package com.p050a.p051a.p060d;

import android.util.JsonReader;
import android.util.JsonToken;
import com.p050a.p051a.C0954f;
import com.p050a.p051a.p062f.C0950a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: KeyframesParser */
/* renamed from: com.a.a.d.s */
class C0934s {
    /* renamed from: a */
    static <T> List<C0950a<T>> m3275a(JsonReader jsonReader, C0954f c0954f, float f, ak<T> akVar) {
        List<C0950a<T>> arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            c0954f.m3338a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            if (nextName.hashCode() == 107) {
                if (nextName.equals("k")) {
                    obj = null;
                }
            }
            if (obj != null) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonToken.NUMBER) {
                    arrayList.add(C0933r.m3271a(jsonReader, c0954f, f, akVar, false));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(C0933r.m3271a(jsonReader, c0954f, f, akVar, true));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(C0933r.m3271a(jsonReader, c0954f, f, akVar, false));
            }
        }
        jsonReader.endObject();
        C0934s.m3276a(arrayList);
        return arrayList;
    }

    /* renamed from: a */
    public static void m3276a(List<? extends C0950a<?>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            C0950a c0950a = (C0950a) list.get(i2);
            i2++;
            c0950a.f2648e = Float.valueOf(((C0950a) list.get(i2)).f2647d);
        }
        C0950a c0950a2 = (C0950a) list.get(i);
        if (c0950a2.f2644a == null) {
            list.remove(c0950a2);
        }
    }
}
