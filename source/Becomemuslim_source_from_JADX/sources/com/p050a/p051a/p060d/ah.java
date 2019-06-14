package com.p050a.p051a.p060d;

import android.util.JsonReader;
import com.p050a.p051a.C0954f;
import com.p050a.p051a.p056c.p057a.C4527h;
import com.p050a.p051a.p056c.p058b.C3380o;

/* compiled from: ShapePathParser */
/* renamed from: com.a.a.d.ah */
class ah {
    /* renamed from: a */
    static C3380o m3238a(JsonReader jsonReader, C0954f c0954f) {
        String str = null;
        C4527h c4527h = null;
        int i = 0;
        while (jsonReader.hasNext()) {
            Object obj;
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode == 3432) {
                if (nextName.equals("ks")) {
                    obj = 2;
                    switch (obj) {
                        case null:
                            str = jsonReader.nextString();
                            break;
                        case 1:
                            i = jsonReader.nextInt();
                            break;
                        case 2:
                            c4527h = C0924d.m3253e(jsonReader, c0954f);
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == 3519) {
                if (nextName.equals("nm")) {
                    obj = null;
                    switch (obj) {
                        case null:
                            str = jsonReader.nextString();
                            break;
                        case 1:
                            i = jsonReader.nextInt();
                            break;
                        case 2:
                            c4527h = C0924d.m3253e(jsonReader, c0954f);
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == 104415) {
                if (nextName.equals("ind")) {
                    obj = 1;
                    switch (obj) {
                        case null:
                            str = jsonReader.nextString();
                            break;
                        case 1:
                            i = jsonReader.nextInt();
                            break;
                        case 2:
                            c4527h = C0924d.m3253e(jsonReader, c0954f);
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            }
            obj = -1;
            switch (obj) {
                case null:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    i = jsonReader.nextInt();
                    break;
                case 2:
                    c4527h = C0924d.m3253e(jsonReader, c0954f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new C3380o(str, i, c4527h);
    }
}
