package com.p050a.p051a.p060d;

import android.util.JsonReader;
import com.facebook.internal.AnalyticsEvents;
import com.p050a.p051a.C0954f;
import com.p050a.p051a.p056c.C0916d;
import com.p050a.p051a.p056c.p058b.C3379n;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FontCharacterParser */
/* renamed from: com.a.a.d.k */
class C0927k {
    /* renamed from: a */
    static C0916d m3258a(JsonReader jsonReader, C0954f c0954f) {
        List arrayList = new ArrayList();
        jsonReader.beginObject();
        String str = null;
        String str2 = str;
        double d = 0.0d;
        double d2 = d;
        char c = '\u0000';
        while (jsonReader.hasNext()) {
            Object obj;
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode == -1866931350) {
                if (nextName.equals("fFamily")) {
                    obj = 4;
                    switch (obj) {
                        case null:
                            c = jsonReader.nextString().charAt(0);
                            break;
                        case 1:
                            d = jsonReader.nextDouble();
                            break;
                        case 2:
                            d2 = jsonReader.nextDouble();
                            break;
                        case 3:
                            str = jsonReader.nextString();
                            break;
                        case 4:
                            str2 = jsonReader.nextString();
                            break;
                        case 5:
                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                if ("shapes".equals(jsonReader.nextName())) {
                                    jsonReader.skipValue();
                                } else {
                                    jsonReader.beginArray();
                                    while (jsonReader.hasNext()) {
                                        arrayList.add((C3379n) C0926h.m3257a(jsonReader, c0954f));
                                    }
                                    jsonReader.endArray();
                                }
                            }
                            jsonReader.endObject();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == 119) {
                if (nextName.equals("w")) {
                    obj = 2;
                    switch (obj) {
                        case null:
                            c = jsonReader.nextString().charAt(0);
                            break;
                        case 1:
                            d = jsonReader.nextDouble();
                            break;
                        case 2:
                            d2 = jsonReader.nextDouble();
                            break;
                        case 3:
                            str = jsonReader.nextString();
                            break;
                        case 4:
                            str2 = jsonReader.nextString();
                            break;
                        case 5:
                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                if ("shapes".equals(jsonReader.nextName())) {
                                    jsonReader.beginArray();
                                    while (jsonReader.hasNext()) {
                                        arrayList.add((C3379n) C0926h.m3257a(jsonReader, c0954f));
                                    }
                                    jsonReader.endArray();
                                } else {
                                    jsonReader.skipValue();
                                }
                            }
                            jsonReader.endObject();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == 3173) {
                if (nextName.equals("ch")) {
                    obj = null;
                    switch (obj) {
                        case null:
                            c = jsonReader.nextString().charAt(0);
                            break;
                        case 1:
                            d = jsonReader.nextDouble();
                            break;
                        case 2:
                            d2 = jsonReader.nextDouble();
                            break;
                        case 3:
                            str = jsonReader.nextString();
                            break;
                        case 4:
                            str2 = jsonReader.nextString();
                            break;
                        case 5:
                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                if ("shapes".equals(jsonReader.nextName())) {
                                    jsonReader.skipValue();
                                } else {
                                    jsonReader.beginArray();
                                    while (jsonReader.hasNext()) {
                                        arrayList.add((C3379n) C0926h.m3257a(jsonReader, c0954f));
                                    }
                                    jsonReader.endArray();
                                }
                            }
                            jsonReader.endObject();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == 3076010) {
                if (nextName.equals("data")) {
                    obj = 5;
                    switch (obj) {
                        case null:
                            c = jsonReader.nextString().charAt(0);
                            break;
                        case 1:
                            d = jsonReader.nextDouble();
                            break;
                        case 2:
                            d2 = jsonReader.nextDouble();
                            break;
                        case 3:
                            str = jsonReader.nextString();
                            break;
                        case 4:
                            str2 = jsonReader.nextString();
                            break;
                        case 5:
                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                if ("shapes".equals(jsonReader.nextName())) {
                                    jsonReader.beginArray();
                                    while (jsonReader.hasNext()) {
                                        arrayList.add((C3379n) C0926h.m3257a(jsonReader, c0954f));
                                    }
                                    jsonReader.endArray();
                                } else {
                                    jsonReader.skipValue();
                                }
                            }
                            jsonReader.endObject();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == 3530753) {
                if (nextName.equals("size")) {
                    obj = 1;
                    switch (obj) {
                        case null:
                            c = jsonReader.nextString().charAt(0);
                            break;
                        case 1:
                            d = jsonReader.nextDouble();
                            break;
                        case 2:
                            d2 = jsonReader.nextDouble();
                            break;
                        case 3:
                            str = jsonReader.nextString();
                            break;
                        case 4:
                            str2 = jsonReader.nextString();
                            break;
                        case 5:
                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                if ("shapes".equals(jsonReader.nextName())) {
                                    jsonReader.skipValue();
                                } else {
                                    jsonReader.beginArray();
                                    while (jsonReader.hasNext()) {
                                        arrayList.add((C3379n) C0926h.m3257a(jsonReader, c0954f));
                                    }
                                    jsonReader.endArray();
                                }
                            }
                            jsonReader.endObject();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == 109780401) {
                if (nextName.equals(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)) {
                    obj = 3;
                    switch (obj) {
                        case null:
                            c = jsonReader.nextString().charAt(0);
                            break;
                        case 1:
                            d = jsonReader.nextDouble();
                            break;
                        case 2:
                            d2 = jsonReader.nextDouble();
                            break;
                        case 3:
                            str = jsonReader.nextString();
                            break;
                        case 4:
                            str2 = jsonReader.nextString();
                            break;
                        case 5:
                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                if ("shapes".equals(jsonReader.nextName())) {
                                    jsonReader.beginArray();
                                    while (jsonReader.hasNext()) {
                                        arrayList.add((C3379n) C0926h.m3257a(jsonReader, c0954f));
                                    }
                                    jsonReader.endArray();
                                } else {
                                    jsonReader.skipValue();
                                }
                            }
                            jsonReader.endObject();
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
                    c = jsonReader.nextString().charAt(0);
                    break;
                case 1:
                    d = jsonReader.nextDouble();
                    break;
                case 2:
                    d2 = jsonReader.nextDouble();
                    break;
                case 3:
                    str = jsonReader.nextString();
                    break;
                case 4:
                    str2 = jsonReader.nextString();
                    break;
                case 5:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if ("shapes".equals(jsonReader.nextName())) {
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                arrayList.add((C3379n) C0926h.m3257a(jsonReader, c0954f));
                            }
                            jsonReader.endArray();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new C0916d(arrayList, c, d, d2, str, str2);
    }
}
