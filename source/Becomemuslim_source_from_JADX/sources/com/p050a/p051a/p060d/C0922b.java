package com.p050a.p051a.p060d;

import android.util.JsonReader;
import com.facebook.ads.internal.p088c.C1354a;
import com.p050a.p051a.C0954f;
import com.p050a.p051a.p056c.p057a.C0892k;
import com.p050a.p051a.p056c.p057a.C4521a;
import com.p050a.p051a.p056c.p057a.C4522b;

/* compiled from: AnimatableTextPropertiesParser */
/* renamed from: com.a.a.d.b */
public class C0922b {
    /* renamed from: a */
    public static C0892k m3242a(JsonReader jsonReader, C0954f c0954f) {
        jsonReader.beginObject();
        C0892k c0892k = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            if (nextName.hashCode() == 97) {
                if (nextName.equals(C1354a.f3934a)) {
                    obj = null;
                }
            }
            if (obj != null) {
                jsonReader.skipValue();
            } else {
                c0892k = C0922b.m3243b(jsonReader, c0954f);
            }
        }
        jsonReader.endObject();
        return c0892k == null ? new C0892k(null, null, null, null) : c0892k;
    }

    /* renamed from: b */
    private static C0892k m3243b(JsonReader jsonReader, C0954f c0954f) {
        jsonReader.beginObject();
        C4521a c4521a = null;
        C4521a c4521a2 = null;
        C4522b c4522b = c4521a2;
        C4522b c4522b2 = c4522b;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            int hashCode = nextName.hashCode();
            if (hashCode != 116) {
                if (hashCode != 3261) {
                    if (hashCode != 3664) {
                        if (hashCode == 3684) {
                            if (nextName.equals("sw")) {
                                obj = 2;
                            }
                        }
                    } else if (nextName.equals("sc")) {
                        obj = 1;
                    }
                } else if (nextName.equals("fc")) {
                    obj = null;
                }
            } else if (nextName.equals("t")) {
                obj = 3;
            }
            switch (obj) {
                case null:
                    c4521a = C0924d.m3255g(jsonReader, c0954f);
                    break;
                case 1:
                    c4521a2 = C0924d.m3255g(jsonReader, c0954f);
                    break;
                case 2:
                    c4522b = C0924d.m3245a(jsonReader, c0954f);
                    break;
                case 3:
                    c4522b2 = C0924d.m3245a(jsonReader, c0954f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new C0892k(c4521a, c4521a2, c4522b, c4522b2);
    }
}
