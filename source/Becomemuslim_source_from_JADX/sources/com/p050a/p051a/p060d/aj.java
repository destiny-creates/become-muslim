package com.p050a.p051a.p060d;

import android.util.JsonReader;
import com.p050a.p051a.C0954f;
import com.p050a.p051a.p056c.p057a.C4522b;
import com.p050a.p051a.p056c.p058b.C3382q;
import com.p050a.p051a.p056c.p058b.C3382q.C0906a;
import com.raizlabs.android.dbflow.config.C5679e;

/* compiled from: ShapeTrimPathParser */
/* renamed from: com.a.a.d.aj */
class aj {
    /* renamed from: a */
    static C3382q m3240a(JsonReader jsonReader, C0954f c0954f) {
        String str = null;
        C0906a c0906a = str;
        C4522b c4522b = c0906a;
        C4522b c4522b2 = c4522b;
        C4522b c4522b3 = c4522b2;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            int hashCode = nextName.hashCode();
            if (hashCode != 101) {
                if (hashCode != 109) {
                    if (hashCode != 111) {
                        if (hashCode != 115) {
                            if (hashCode == 3519) {
                                if (nextName.equals("nm")) {
                                    obj = 3;
                                }
                            }
                        } else if (nextName.equals("s")) {
                            obj = null;
                        }
                    } else if (nextName.equals("o")) {
                        obj = 2;
                    }
                } else if (nextName.equals("m")) {
                    obj = 4;
                }
            } else if (nextName.equals(C5679e.f18978a)) {
                obj = 1;
            }
            switch (obj) {
                case null:
                    c4522b = C0924d.m3246a(jsonReader, c0954f, false);
                    break;
                case 1:
                    c4522b2 = C0924d.m3246a(jsonReader, c0954f, false);
                    break;
                case 2:
                    c4522b3 = C0924d.m3246a(jsonReader, c0954f, false);
                    break;
                case 3:
                    str = jsonReader.nextString();
                    break;
                case 4:
                    c0906a = C0906a.m3188a(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new C3382q(str, c0906a, c4522b, c4522b2, c4522b3);
    }
}
