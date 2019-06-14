package com.p050a.p051a.p060d;

import android.util.JsonReader;
import android.util.Log;
import com.facebook.ads.internal.p088c.C1354a;
import com.p050a.p051a.C0954f;
import com.p050a.p051a.p056c.p057a.C4524d;
import com.p050a.p051a.p056c.p057a.C4527h;
import com.p050a.p051a.p056c.p058b.C0899g;
import com.p050a.p051a.p056c.p058b.C0899g.C0898a;

/* compiled from: MaskParser */
/* renamed from: com.a.a.d.v */
class C0937v {
    /* renamed from: a */
    static C0899g m3284a(JsonReader jsonReader, C0954f c0954f) {
        jsonReader.beginObject();
        C0898a c0898a = null;
        C4527h c4527h = null;
        C4524d c4524d = c4527h;
        while (jsonReader.hasNext()) {
            Object obj;
            String nextString;
            StringBuilder stringBuilder;
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            Object obj2 = null;
            if (hashCode == 111) {
                if (nextName.equals("o")) {
                    obj = 2;
                    switch (obj) {
                        case null:
                            nextString = jsonReader.nextString();
                            hashCode = nextString.hashCode();
                            if (hashCode == 97) {
                                if (nextString.equals(C1354a.f3934a)) {
                                    switch (obj2) {
                                        case null:
                                            c0898a = C0898a.MaskModeAdd;
                                            break;
                                        case 1:
                                            c0898a = C0898a.MaskModeSubtract;
                                            break;
                                        case 2:
                                            c0898a = C0898a.MaskModeIntersect;
                                            break;
                                        default:
                                            stringBuilder = new StringBuilder();
                                            stringBuilder.append("Unknown mask mode ");
                                            stringBuilder.append(nextName);
                                            stringBuilder.append(". Defaulting to Add.");
                                            Log.w("LOTTIE", stringBuilder.toString());
                                            c0898a = C0898a.MaskModeAdd;
                                            break;
                                    }
                                }
                            } else if (hashCode == 105) {
                                if (nextString.equals("i")) {
                                    obj2 = 2;
                                    switch (obj2) {
                                        case null:
                                            c0898a = C0898a.MaskModeAdd;
                                            break;
                                        case 1:
                                            c0898a = C0898a.MaskModeSubtract;
                                            break;
                                        case 2:
                                            c0898a = C0898a.MaskModeIntersect;
                                            break;
                                        default:
                                            stringBuilder = new StringBuilder();
                                            stringBuilder.append("Unknown mask mode ");
                                            stringBuilder.append(nextName);
                                            stringBuilder.append(". Defaulting to Add.");
                                            Log.w("LOTTIE", stringBuilder.toString());
                                            c0898a = C0898a.MaskModeAdd;
                                            break;
                                    }
                                }
                            } else if (hashCode == 115) {
                                if (nextString.equals("s")) {
                                    obj2 = 1;
                                    switch (obj2) {
                                        case null:
                                            c0898a = C0898a.MaskModeAdd;
                                            break;
                                        case 1:
                                            c0898a = C0898a.MaskModeSubtract;
                                            break;
                                        case 2:
                                            c0898a = C0898a.MaskModeIntersect;
                                            break;
                                        default:
                                            stringBuilder = new StringBuilder();
                                            stringBuilder.append("Unknown mask mode ");
                                            stringBuilder.append(nextName);
                                            stringBuilder.append(". Defaulting to Add.");
                                            Log.w("LOTTIE", stringBuilder.toString());
                                            c0898a = C0898a.MaskModeAdd;
                                            break;
                                    }
                                }
                            }
                            obj2 = -1;
                            switch (obj2) {
                                case null:
                                    c0898a = C0898a.MaskModeAdd;
                                    break;
                                case 1:
                                    c0898a = C0898a.MaskModeSubtract;
                                    break;
                                case 2:
                                    c0898a = C0898a.MaskModeIntersect;
                                    break;
                                default:
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("Unknown mask mode ");
                                    stringBuilder.append(nextName);
                                    stringBuilder.append(". Defaulting to Add.");
                                    Log.w("LOTTIE", stringBuilder.toString());
                                    c0898a = C0898a.MaskModeAdd;
                                    break;
                            }
                        case 1:
                            c4527h = C0924d.m3253e(jsonReader, c0954f);
                            break;
                        case 2:
                            c4524d = C0924d.m3250b(jsonReader, c0954f);
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == 3588) {
                if (nextName.equals("pt")) {
                    obj = 1;
                    switch (obj) {
                        case null:
                            nextString = jsonReader.nextString();
                            hashCode = nextString.hashCode();
                            if (hashCode == 97) {
                                if (nextString.equals(C1354a.f3934a)) {
                                    switch (obj2) {
                                        case null:
                                            c0898a = C0898a.MaskModeAdd;
                                            break;
                                        case 1:
                                            c0898a = C0898a.MaskModeSubtract;
                                            break;
                                        case 2:
                                            c0898a = C0898a.MaskModeIntersect;
                                            break;
                                        default:
                                            stringBuilder = new StringBuilder();
                                            stringBuilder.append("Unknown mask mode ");
                                            stringBuilder.append(nextName);
                                            stringBuilder.append(". Defaulting to Add.");
                                            Log.w("LOTTIE", stringBuilder.toString());
                                            c0898a = C0898a.MaskModeAdd;
                                            break;
                                    }
                                }
                            } else if (hashCode == 105) {
                                if (nextString.equals("i")) {
                                    obj2 = 2;
                                    switch (obj2) {
                                        case null:
                                            c0898a = C0898a.MaskModeAdd;
                                            break;
                                        case 1:
                                            c0898a = C0898a.MaskModeSubtract;
                                            break;
                                        case 2:
                                            c0898a = C0898a.MaskModeIntersect;
                                            break;
                                        default:
                                            stringBuilder = new StringBuilder();
                                            stringBuilder.append("Unknown mask mode ");
                                            stringBuilder.append(nextName);
                                            stringBuilder.append(". Defaulting to Add.");
                                            Log.w("LOTTIE", stringBuilder.toString());
                                            c0898a = C0898a.MaskModeAdd;
                                            break;
                                    }
                                }
                            } else if (hashCode == 115) {
                                if (nextString.equals("s")) {
                                    obj2 = 1;
                                    switch (obj2) {
                                        case null:
                                            c0898a = C0898a.MaskModeAdd;
                                            break;
                                        case 1:
                                            c0898a = C0898a.MaskModeSubtract;
                                            break;
                                        case 2:
                                            c0898a = C0898a.MaskModeIntersect;
                                            break;
                                        default:
                                            stringBuilder = new StringBuilder();
                                            stringBuilder.append("Unknown mask mode ");
                                            stringBuilder.append(nextName);
                                            stringBuilder.append(". Defaulting to Add.");
                                            Log.w("LOTTIE", stringBuilder.toString());
                                            c0898a = C0898a.MaskModeAdd;
                                            break;
                                    }
                                }
                            }
                            obj2 = -1;
                            switch (obj2) {
                                case null:
                                    c0898a = C0898a.MaskModeAdd;
                                    break;
                                case 1:
                                    c0898a = C0898a.MaskModeSubtract;
                                    break;
                                case 2:
                                    c0898a = C0898a.MaskModeIntersect;
                                    break;
                                default:
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("Unknown mask mode ");
                                    stringBuilder.append(nextName);
                                    stringBuilder.append(". Defaulting to Add.");
                                    Log.w("LOTTIE", stringBuilder.toString());
                                    c0898a = C0898a.MaskModeAdd;
                                    break;
                            }
                        case 1:
                            c4527h = C0924d.m3253e(jsonReader, c0954f);
                            break;
                        case 2:
                            c4524d = C0924d.m3250b(jsonReader, c0954f);
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            } else if (hashCode == 3357091) {
                if (nextName.equals("mode")) {
                    obj = null;
                    switch (obj) {
                        case null:
                            nextString = jsonReader.nextString();
                            hashCode = nextString.hashCode();
                            if (hashCode == 97) {
                                if (nextString.equals(C1354a.f3934a)) {
                                    switch (obj2) {
                                        case null:
                                            c0898a = C0898a.MaskModeAdd;
                                            break;
                                        case 1:
                                            c0898a = C0898a.MaskModeSubtract;
                                            break;
                                        case 2:
                                            c0898a = C0898a.MaskModeIntersect;
                                            break;
                                        default:
                                            stringBuilder = new StringBuilder();
                                            stringBuilder.append("Unknown mask mode ");
                                            stringBuilder.append(nextName);
                                            stringBuilder.append(". Defaulting to Add.");
                                            Log.w("LOTTIE", stringBuilder.toString());
                                            c0898a = C0898a.MaskModeAdd;
                                            break;
                                    }
                                }
                            } else if (hashCode == 105) {
                                if (nextString.equals("i")) {
                                    obj2 = 2;
                                    switch (obj2) {
                                        case null:
                                            c0898a = C0898a.MaskModeAdd;
                                            break;
                                        case 1:
                                            c0898a = C0898a.MaskModeSubtract;
                                            break;
                                        case 2:
                                            c0898a = C0898a.MaskModeIntersect;
                                            break;
                                        default:
                                            stringBuilder = new StringBuilder();
                                            stringBuilder.append("Unknown mask mode ");
                                            stringBuilder.append(nextName);
                                            stringBuilder.append(". Defaulting to Add.");
                                            Log.w("LOTTIE", stringBuilder.toString());
                                            c0898a = C0898a.MaskModeAdd;
                                            break;
                                    }
                                }
                            } else if (hashCode == 115) {
                                if (nextString.equals("s")) {
                                    obj2 = 1;
                                    switch (obj2) {
                                        case null:
                                            c0898a = C0898a.MaskModeAdd;
                                            break;
                                        case 1:
                                            c0898a = C0898a.MaskModeSubtract;
                                            break;
                                        case 2:
                                            c0898a = C0898a.MaskModeIntersect;
                                            break;
                                        default:
                                            stringBuilder = new StringBuilder();
                                            stringBuilder.append("Unknown mask mode ");
                                            stringBuilder.append(nextName);
                                            stringBuilder.append(". Defaulting to Add.");
                                            Log.w("LOTTIE", stringBuilder.toString());
                                            c0898a = C0898a.MaskModeAdd;
                                            break;
                                    }
                                }
                            }
                            obj2 = -1;
                            switch (obj2) {
                                case null:
                                    c0898a = C0898a.MaskModeAdd;
                                    break;
                                case 1:
                                    c0898a = C0898a.MaskModeSubtract;
                                    break;
                                case 2:
                                    c0898a = C0898a.MaskModeIntersect;
                                    break;
                                default:
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("Unknown mask mode ");
                                    stringBuilder.append(nextName);
                                    stringBuilder.append(". Defaulting to Add.");
                                    Log.w("LOTTIE", stringBuilder.toString());
                                    c0898a = C0898a.MaskModeAdd;
                                    break;
                            }
                        case 1:
                            c4527h = C0924d.m3253e(jsonReader, c0954f);
                            break;
                        case 2:
                            c4524d = C0924d.m3250b(jsonReader, c0954f);
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
                    nextString = jsonReader.nextString();
                    hashCode = nextString.hashCode();
                    if (hashCode == 97) {
                        if (nextString.equals(C1354a.f3934a)) {
                            switch (obj2) {
                                case null:
                                    c0898a = C0898a.MaskModeAdd;
                                    break;
                                case 1:
                                    c0898a = C0898a.MaskModeSubtract;
                                    break;
                                case 2:
                                    c0898a = C0898a.MaskModeIntersect;
                                    break;
                                default:
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("Unknown mask mode ");
                                    stringBuilder.append(nextName);
                                    stringBuilder.append(". Defaulting to Add.");
                                    Log.w("LOTTIE", stringBuilder.toString());
                                    c0898a = C0898a.MaskModeAdd;
                                    break;
                            }
                        }
                    } else if (hashCode == 105) {
                        if (nextString.equals("i")) {
                            obj2 = 2;
                            switch (obj2) {
                                case null:
                                    c0898a = C0898a.MaskModeAdd;
                                    break;
                                case 1:
                                    c0898a = C0898a.MaskModeSubtract;
                                    break;
                                case 2:
                                    c0898a = C0898a.MaskModeIntersect;
                                    break;
                                default:
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("Unknown mask mode ");
                                    stringBuilder.append(nextName);
                                    stringBuilder.append(". Defaulting to Add.");
                                    Log.w("LOTTIE", stringBuilder.toString());
                                    c0898a = C0898a.MaskModeAdd;
                                    break;
                            }
                        }
                    } else if (hashCode == 115) {
                        if (nextString.equals("s")) {
                            obj2 = 1;
                            switch (obj2) {
                                case null:
                                    c0898a = C0898a.MaskModeAdd;
                                    break;
                                case 1:
                                    c0898a = C0898a.MaskModeSubtract;
                                    break;
                                case 2:
                                    c0898a = C0898a.MaskModeIntersect;
                                    break;
                                default:
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append("Unknown mask mode ");
                                    stringBuilder.append(nextName);
                                    stringBuilder.append(". Defaulting to Add.");
                                    Log.w("LOTTIE", stringBuilder.toString());
                                    c0898a = C0898a.MaskModeAdd;
                                    break;
                            }
                        }
                    }
                    obj2 = -1;
                    switch (obj2) {
                        case null:
                            c0898a = C0898a.MaskModeAdd;
                            break;
                        case 1:
                            c0898a = C0898a.MaskModeSubtract;
                            break;
                        case 2:
                            c0898a = C0898a.MaskModeIntersect;
                            break;
                        default:
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("Unknown mask mode ");
                            stringBuilder.append(nextName);
                            stringBuilder.append(". Defaulting to Add.");
                            Log.w("LOTTIE", stringBuilder.toString());
                            c0898a = C0898a.MaskModeAdd;
                            break;
                    }
                case 1:
                    c4527h = C0924d.m3253e(jsonReader, c0954f);
                    break;
                case 2:
                    c4524d = C0924d.m3250b(jsonReader, c0954f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new C0899g(c0898a, c4527h, c4524d);
    }
}
