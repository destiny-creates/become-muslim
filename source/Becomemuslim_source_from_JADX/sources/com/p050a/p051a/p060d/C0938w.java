package com.p050a.p051a.p060d;

import android.util.JsonReader;
import com.p050a.p051a.p056c.p058b.C3374h;
import com.p050a.p051a.p056c.p058b.C3374h.C0900a;

/* compiled from: MergePathsParser */
/* renamed from: com.a.a.d.w */
class C0938w {
    /* renamed from: a */
    static C3374h m3285a(JsonReader jsonReader) {
        String str = null;
        C0900a c0900a = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            int hashCode = nextName.hashCode();
            if (hashCode != 3488) {
                if (hashCode == 3519) {
                    if (nextName.equals("nm")) {
                        obj = null;
                    }
                }
            } else if (nextName.equals("mm")) {
                obj = 1;
            }
            switch (obj) {
                case null:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    c0900a = C0900a.m3179a(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new C3374h(str, c0900a);
    }
}
