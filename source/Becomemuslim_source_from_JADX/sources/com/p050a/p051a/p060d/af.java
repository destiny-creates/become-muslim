package com.p050a.p051a.p060d;

import android.graphics.Path.FillType;
import android.util.JsonReader;
import com.p050a.p051a.C0954f;
import com.p050a.p051a.p056c.p057a.C4521a;
import com.p050a.p051a.p056c.p057a.C4524d;
import com.p050a.p051a.p056c.p058b.C3378m;

/* compiled from: ShapeFillParser */
/* renamed from: com.a.a.d.af */
class af {
    /* renamed from: a */
    static C3378m m3236a(JsonReader jsonReader, C0954f c0954f) {
        String str = null;
        C4521a c4521a = str;
        C4524d c4524d = c4521a;
        int i = 1;
        boolean z = false;
        while (jsonReader.hasNext()) {
            Object obj;
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode == -396065730) {
                if (nextName.equals("fillEnabled")) {
                    obj = 3;
                    switch (obj) {
                        case null:
                            str = jsonReader.nextString();
                            break;
                        case 1:
                            c4521a = C0924d.m3255g(jsonReader, c0954f);
                            break;
                        case 2:
                            c4524d = C0924d.m3250b(jsonReader, c0954f);
                            break;
                        case 3:
                            z = jsonReader.nextBoolean();
                            break;
                        case 4:
                            i = jsonReader.nextInt();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == 99) {
                if (nextName.equals("c")) {
                    obj = 1;
                    switch (obj) {
                        case null:
                            str = jsonReader.nextString();
                            break;
                        case 1:
                            c4521a = C0924d.m3255g(jsonReader, c0954f);
                            break;
                        case 2:
                            c4524d = C0924d.m3250b(jsonReader, c0954f);
                            break;
                        case 3:
                            z = jsonReader.nextBoolean();
                            break;
                        case 4:
                            i = jsonReader.nextInt();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == 111) {
                if (nextName.equals("o")) {
                    obj = 2;
                    switch (obj) {
                        case null:
                            str = jsonReader.nextString();
                            break;
                        case 1:
                            c4521a = C0924d.m3255g(jsonReader, c0954f);
                            break;
                        case 2:
                            c4524d = C0924d.m3250b(jsonReader, c0954f);
                            break;
                        case 3:
                            z = jsonReader.nextBoolean();
                            break;
                        case 4:
                            i = jsonReader.nextInt();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == 114) {
                if (nextName.equals("r")) {
                    obj = 4;
                    switch (obj) {
                        case null:
                            str = jsonReader.nextString();
                            break;
                        case 1:
                            c4521a = C0924d.m3255g(jsonReader, c0954f);
                            break;
                        case 2:
                            c4524d = C0924d.m3250b(jsonReader, c0954f);
                            break;
                        case 3:
                            z = jsonReader.nextBoolean();
                            break;
                        case 4:
                            i = jsonReader.nextInt();
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
                            c4521a = C0924d.m3255g(jsonReader, c0954f);
                            break;
                        case 2:
                            c4524d = C0924d.m3250b(jsonReader, c0954f);
                            break;
                        case 3:
                            z = jsonReader.nextBoolean();
                            break;
                        case 4:
                            i = jsonReader.nextInt();
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
                    c4521a = C0924d.m3255g(jsonReader, c0954f);
                    break;
                case 2:
                    c4524d = C0924d.m3250b(jsonReader, c0954f);
                    break;
                case 3:
                    z = jsonReader.nextBoolean();
                    break;
                case 4:
                    i = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new C3378m(str, z, i == 1 ? FillType.WINDING : FillType.EVEN_ODD, c4521a, c4524d);
    }
}
