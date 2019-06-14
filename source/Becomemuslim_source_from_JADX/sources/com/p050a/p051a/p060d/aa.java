package com.p050a.p051a.p060d;

import android.util.JsonReader;
import com.p050a.p051a.C0954f;
import com.p050a.p051a.p056c.p057a.C0893m;
import com.p050a.p051a.p056c.p057a.C4522b;
import com.p050a.p051a.p056c.p058b.C3375i;
import com.p050a.p051a.p056c.p058b.C3375i.C0901a;

/* compiled from: PolystarShapeParser */
/* renamed from: com.a.a.d.aa */
class aa {
    /* renamed from: a */
    static C3375i m3233a(JsonReader jsonReader, C0954f c0954f) {
        String str = null;
        C0901a c0901a = str;
        C4522b c4522b = c0901a;
        C0893m c0893m = c4522b;
        C4522b c4522b2 = c0893m;
        C4522b c4522b3 = c4522b2;
        C4522b c4522b4 = c4522b3;
        C4522b c4522b5 = c4522b4;
        C4522b c4522b6 = c4522b5;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            switch (nextName.hashCode()) {
                case 112:
                    if (nextName.equals("p")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 114:
                    if (nextName.equals("r")) {
                        obj = 4;
                        break;
                    }
                    break;
                case 3369:
                    if (nextName.equals("ir")) {
                        obj = 7;
                        break;
                    }
                    break;
                case 3370:
                    if (nextName.equals("is")) {
                        obj = 8;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        obj = null;
                        break;
                    }
                    break;
                case 3555:
                    if (nextName.equals("or")) {
                        obj = 5;
                        break;
                    }
                    break;
                case 3556:
                    if (nextName.equals("os")) {
                        obj = 6;
                        break;
                    }
                    break;
                case 3588:
                    if (nextName.equals("pt")) {
                        obj = 2;
                        break;
                    }
                    break;
                case 3686:
                    if (nextName.equals("sy")) {
                        obj = 1;
                        break;
                    }
                    break;
                default:
                    break;
            }
            switch (obj) {
                case null:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    c0901a = C0901a.m3180a(jsonReader.nextInt());
                    break;
                case 2:
                    c4522b = C0924d.m3246a(jsonReader, c0954f, false);
                    break;
                case 3:
                    c0893m = C0921a.m3232b(jsonReader, c0954f);
                    break;
                case 4:
                    c4522b2 = C0924d.m3246a(jsonReader, c0954f, false);
                    break;
                case 5:
                    c4522b4 = C0924d.m3245a(jsonReader, c0954f);
                    break;
                case 6:
                    c4522b6 = C0924d.m3246a(jsonReader, c0954f, false);
                    break;
                case 7:
                    c4522b3 = C0924d.m3245a(jsonReader, c0954f);
                    break;
                case 8:
                    c4522b5 = C0924d.m3246a(jsonReader, c0954f, false);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new C3375i(str, c0901a, c4522b, c0893m, c4522b2, c4522b3, c4522b4, c4522b5, c4522b6);
    }
}
