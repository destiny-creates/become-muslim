package com.p050a.p051a.p060d;

import android.util.JsonReader;
import com.p050a.p051a.C0954f;
import com.p050a.p051a.p056c.p057a.C0893m;
import com.p050a.p051a.p056c.p057a.C4522b;
import com.p050a.p051a.p056c.p057a.C4525f;
import com.p050a.p051a.p056c.p058b.C3376j;

/* compiled from: RectangleShapeParser */
/* renamed from: com.a.a.d.ab */
class ab {
    /* renamed from: a */
    static C3376j m3234a(JsonReader jsonReader, C0954f c0954f) {
        String str = null;
        C0893m c0893m = null;
        C4525f c4525f = c0893m;
        C4522b c4522b = c4525f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            int hashCode = nextName.hashCode();
            if (hashCode != 112) {
                if (hashCode != 3519) {
                    switch (hashCode) {
                        case 114:
                            if (nextName.equals("r")) {
                                obj = 3;
                                break;
                            }
                            break;
                        case 115:
                            if (nextName.equals("s")) {
                                obj = 2;
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                } else if (nextName.equals("nm")) {
                    obj = null;
                }
            } else if (nextName.equals("p")) {
                obj = 1;
            }
            switch (obj) {
                case null:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    c0893m = C0921a.m3232b(jsonReader, c0954f);
                    break;
                case 2:
                    c4525f = C0924d.m3251c(jsonReader, c0954f);
                    break;
                case 3:
                    c4522b = C0924d.m3245a(jsonReader, c0954f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new C3376j(str, c0893m, c4525f, c4522b);
    }
}
