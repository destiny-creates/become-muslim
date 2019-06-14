package com.p050a.p051a.p060d;

import android.util.JsonReader;
import com.p050a.p051a.C0954f;
import com.p050a.p051a.p056c.p058b.C0895b;
import com.p050a.p051a.p056c.p058b.C3379n;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShapeGroupParser */
/* renamed from: com.a.a.d.ag */
class ag {
    /* renamed from: a */
    static C3379n m3237a(JsonReader jsonReader, C0954f c0954f) {
        List arrayList = new ArrayList();
        String str = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            int hashCode = nextName.hashCode();
            if (hashCode != 3371) {
                if (hashCode == 3519) {
                    if (nextName.equals("nm")) {
                        obj = null;
                    }
                }
            } else if (nextName.equals("it")) {
                obj = 1;
            }
            switch (obj) {
                case null:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        C0895b a = C0926h.m3257a(jsonReader, c0954f);
                        if (a != null) {
                            arrayList.add(a);
                        }
                    }
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new C3379n(str, arrayList);
    }
}
