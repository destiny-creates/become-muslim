package com.p050a.p051a.p060d;

import android.util.JsonReader;
import com.p050a.p051a.p056c.C0915c;

/* compiled from: FontParser */
/* renamed from: com.a.a.d.l */
class C0928l {
    /* renamed from: a */
    static C0915c m3259a(JsonReader jsonReader) {
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = str2;
        float f = 0.0f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            int hashCode = nextName.hashCode();
            if (hashCode != -1866931350) {
                if (hashCode != -1408684838) {
                    if (hashCode != -1294566165) {
                        if (hashCode == 96619537) {
                            if (nextName.equals("fName")) {
                                obj = 1;
                            }
                        }
                    } else if (nextName.equals("fStyle")) {
                        obj = 2;
                    }
                } else if (nextName.equals("ascent")) {
                    obj = 3;
                }
            } else if (nextName.equals("fFamily")) {
                obj = null;
            }
            switch (obj) {
                case null:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    str2 = jsonReader.nextString();
                    break;
                case 2:
                    str3 = jsonReader.nextString();
                    break;
                case 3:
                    f = (float) jsonReader.nextDouble();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new C0915c(str, str2, str3, f);
    }
}
