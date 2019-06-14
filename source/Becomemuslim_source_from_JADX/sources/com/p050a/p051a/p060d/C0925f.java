package com.p050a.p051a.p060d;

import android.util.JsonReader;
import com.p050a.p051a.C0954f;
import com.p050a.p051a.p056c.p057a.C4525f;
import com.p050a.p051a.p056c.p058b.C3371a;

/* compiled from: CircleShapeParser */
/* renamed from: com.a.a.d.f */
class C0925f {
    /* renamed from: a */
    static C3371a m3256a(JsonReader jsonReader, C0954f c0954f, int i) {
        String str = null;
        boolean z = i == 3;
        i = 0;
        C4525f c4525f = i;
        while (jsonReader.hasNext()) {
            Object obj;
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode == 100) {
                if (nextName.equals("d")) {
                    obj = 3;
                    switch (obj) {
                        case null:
                            str = jsonReader.nextString();
                            break;
                        case 1:
                            i = C0921a.m3232b(jsonReader, c0954f);
                            break;
                        case 2:
                            c4525f = C0924d.m3251c(jsonReader, c0954f);
                            break;
                        case 3:
                            if (jsonReader.nextInt() != 3) {
                                z = true;
                                break;
                            }
                            z = false;
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == 112) {
                if (nextName.equals("p")) {
                    obj = 1;
                    switch (obj) {
                        case null:
                            str = jsonReader.nextString();
                            break;
                        case 1:
                            i = C0921a.m3232b(jsonReader, c0954f);
                            break;
                        case 2:
                            c4525f = C0924d.m3251c(jsonReader, c0954f);
                            break;
                        case 3:
                            if (jsonReader.nextInt() != 3) {
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == 115) {
                if (nextName.equals("s")) {
                    obj = 2;
                    switch (obj) {
                        case null:
                            str = jsonReader.nextString();
                            break;
                        case 1:
                            i = C0921a.m3232b(jsonReader, c0954f);
                            break;
                        case 2:
                            c4525f = C0924d.m3251c(jsonReader, c0954f);
                            break;
                        case 3:
                            if (jsonReader.nextInt() != 3) {
                                z = true;
                                break;
                            }
                            z = false;
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
                            i = C0921a.m3232b(jsonReader, c0954f);
                            break;
                        case 2:
                            c4525f = C0924d.m3251c(jsonReader, c0954f);
                            break;
                        case 3:
                            if (jsonReader.nextInt() != 3) {
                                z = false;
                                break;
                            }
                            z = true;
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
                    i = C0921a.m3232b(jsonReader, c0954f);
                    break;
                case 2:
                    c4525f = C0924d.m3251c(jsonReader, c0954f);
                    break;
                case 3:
                    if (jsonReader.nextInt() != 3) {
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new C3371a(str, i, c4525f, z);
    }
}
