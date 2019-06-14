package com.p050a.p051a.p060d;

import android.util.JsonReader;
import com.p050a.p051a.C0954f;
import com.p050a.p051a.p056c.p057a.C3369l;
import com.p050a.p051a.p056c.p057a.C4522b;
import com.p050a.p051a.p056c.p058b.C3377k;

/* compiled from: RepeaterParser */
/* renamed from: com.a.a.d.ac */
class ac {
    /* renamed from: a */
    static C3377k m3235a(JsonReader jsonReader, C0954f c0954f) {
        String str = null;
        C4522b c4522b = null;
        C4522b c4522b2 = c4522b;
        C3369l c3369l = c4522b2;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            int hashCode = nextName.hashCode();
            if (hashCode != 99) {
                if (hashCode != 111) {
                    if (hashCode != 3519) {
                        if (hashCode == 3710) {
                            if (nextName.equals("tr")) {
                                obj = 3;
                            }
                        }
                    } else if (nextName.equals("nm")) {
                        obj = null;
                    }
                } else if (nextName.equals("o")) {
                    obj = 2;
                }
            } else if (nextName.equals("c")) {
                obj = 1;
            }
            switch (obj) {
                case null:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    c4522b = C0924d.m3246a(jsonReader, c0954f, false);
                    break;
                case 2:
                    c4522b2 = C0924d.m3246a(jsonReader, c0954f, false);
                    break;
                case 3:
                    c3369l = C0923c.m3244a(jsonReader, c0954f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new C3377k(str, c4522b, c4522b2, c3369l);
    }
}
