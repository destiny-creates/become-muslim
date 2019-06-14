package com.p050a.p051a.p060d;

import android.support.v4.util.C0452f;
import android.support.v4.util.C0464m;
import android.util.JsonReader;
import com.p050a.p051a.C0940d;
import com.p050a.p051a.C0954f;
import com.p050a.p051a.C0958h;
import com.p050a.p051a.p056c.C0915c;
import com.p050a.p051a.p056c.C0916d;
import com.p050a.p051a.p056c.p059c.C0912d;
import com.p050a.p051a.p056c.p059c.C0912d.C0910a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: LottieCompositionParser */
/* renamed from: com.a.a.d.u */
public class C0936u {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static com.p050a.p051a.C0954f m3279a(android.util.JsonReader r28) {
        /*
        r0 = r28;
        r1 = com.p050a.p051a.p061e.C0948f.m3313a();
        r8 = new android.support.v4.util.f;
        r8.<init>();
        r7 = new java.util.ArrayList;
        r7.<init>();
        r9 = new java.util.HashMap;
        r9.<init>();
        r10 = new java.util.HashMap;
        r10.<init>();
        r12 = new java.util.HashMap;
        r12.<init>();
        r11 = new android.support.v4.util.m;
        r11.<init>();
        r13 = new com.a.a.f;
        r13.<init>();
        r28.beginObject();
        r2 = 0;
        r2 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r14 = 0;
    L_0x0032:
        r15 = r28.hasNext();
        if (r15 == 0) goto L_0x0138;
    L_0x0038:
        r15 = r28.nextName();
        r16 = -1;
        r17 = r15.hashCode();
        r18 = 2;
        r19 = 1;
        switch(r17) {
            case -1408207997: goto L_0x00a7;
            case -1109732030: goto L_0x009d;
            case 104: goto L_0x0093;
            case 118: goto L_0x0089;
            case 119: goto L_0x007f;
            case 3276: goto L_0x0075;
            case 3367: goto L_0x006b;
            case 3553: goto L_0x0061;
            case 94623709: goto L_0x0056;
            case 97615364: goto L_0x004b;
            default: goto L_0x0049;
        };
    L_0x0049:
        goto L_0x00b1;
    L_0x004b:
        r3 = "fonts";
        r3 = r15.equals(r3);
        if (r3 == 0) goto L_0x00b1;
    L_0x0053:
        r3 = 8;
        goto L_0x00b2;
    L_0x0056:
        r3 = "chars";
        r3 = r15.equals(r3);
        if (r3 == 0) goto L_0x00b1;
    L_0x005e:
        r3 = 9;
        goto L_0x00b2;
    L_0x0061:
        r3 = "op";
        r3 = r15.equals(r3);
        if (r3 == 0) goto L_0x00b1;
    L_0x0069:
        r3 = 3;
        goto L_0x00b2;
    L_0x006b:
        r3 = "ip";
        r3 = r15.equals(r3);
        if (r3 == 0) goto L_0x00b1;
    L_0x0073:
        r3 = 2;
        goto L_0x00b2;
    L_0x0075:
        r3 = "fr";
        r3 = r15.equals(r3);
        if (r3 == 0) goto L_0x00b1;
    L_0x007d:
        r3 = 4;
        goto L_0x00b2;
    L_0x007f:
        r3 = "w";
        r3 = r15.equals(r3);
        if (r3 == 0) goto L_0x00b1;
    L_0x0087:
        r3 = 0;
        goto L_0x00b2;
    L_0x0089:
        r3 = "v";
        r3 = r15.equals(r3);
        if (r3 == 0) goto L_0x00b1;
    L_0x0091:
        r3 = 5;
        goto L_0x00b2;
    L_0x0093:
        r3 = "h";
        r3 = r15.equals(r3);
        if (r3 == 0) goto L_0x00b1;
    L_0x009b:
        r3 = 1;
        goto L_0x00b2;
    L_0x009d:
        r3 = "layers";
        r3 = r15.equals(r3);
        if (r3 == 0) goto L_0x00b1;
    L_0x00a5:
        r3 = 6;
        goto L_0x00b2;
    L_0x00a7:
        r3 = "assets";
        r3 = r15.equals(r3);
        if (r3 == 0) goto L_0x00b1;
    L_0x00af:
        r3 = 7;
        goto L_0x00b2;
    L_0x00b1:
        r3 = -1;
    L_0x00b2:
        switch(r3) {
            case 0: goto L_0x012a;
            case 1: goto L_0x0120;
            case 2: goto L_0x0116;
            case 3: goto L_0x0107;
            case 4: goto L_0x00fd;
            case 5: goto L_0x00ce;
            case 6: goto L_0x00ca;
            case 7: goto L_0x00c6;
            case 8: goto L_0x00c2;
            case 9: goto L_0x00be;
            default: goto L_0x00b5;
        };
    L_0x00b5:
        r27 = r11;
        r26 = r12;
        r28.skipValue();
        goto L_0x0132;
    L_0x00be:
        com.p050a.p051a.p060d.C0936u.m3280a(r0, r13, r11);
        goto L_0x0102;
    L_0x00c2:
        com.p050a.p051a.p060d.C0936u.m3283a(r0, r12);
        goto L_0x0102;
    L_0x00c6:
        com.p050a.p051a.p060d.C0936u.m3282a(r0, r13, r9, r10);
        goto L_0x0102;
    L_0x00ca:
        com.p050a.p051a.p060d.C0936u.m3281a(r0, r13, r7, r8);
        goto L_0x0102;
    L_0x00ce:
        r3 = r28.nextString();
        r15 = "\\.";
        r3 = r3.split(r15);
        r15 = 0;
        r16 = r3[r15];
        r20 = java.lang.Integer.parseInt(r16);
        r15 = r3[r19];
        r21 = java.lang.Integer.parseInt(r15);
        r3 = r3[r18];
        r22 = java.lang.Integer.parseInt(r3);
        r23 = 4;
        r24 = 4;
        r25 = 0;
        r3 = com.p050a.p051a.p061e.C0948f.m3319a(r20, r21, r22, r23, r24, r25);
        if (r3 != 0) goto L_0x0102;
    L_0x00f7:
        r3 = "Lottie only supports bodymovin >= 4.4.0";
        r13.m3338a(r3);
        goto L_0x0102;
    L_0x00fd:
        r14 = r28.nextDouble();
        r14 = (float) r14;
    L_0x0102:
        r27 = r11;
        r26 = r12;
        goto L_0x0132;
    L_0x0107:
        r27 = r11;
        r26 = r12;
        r11 = r28.nextDouble();
        r3 = (float) r11;
        r6 = 1008981770; // 0x3c23d70a float:0.01 double:4.9850323E-315;
        r6 = r3 - r6;
        goto L_0x0132;
    L_0x0116:
        r27 = r11;
        r26 = r12;
        r11 = r28.nextDouble();
        r5 = (float) r11;
        goto L_0x0132;
    L_0x0120:
        r27 = r11;
        r26 = r12;
        r3 = r28.nextInt();
        r4 = r3;
        goto L_0x0132;
    L_0x012a:
        r27 = r11;
        r26 = r12;
        r2 = r28.nextInt();
    L_0x0132:
        r12 = r26;
        r11 = r27;
        goto L_0x0032;
    L_0x0138:
        r27 = r11;
        r26 = r12;
        r28.endObject();
        r0 = (float) r2;
        r0 = r0 * r1;
        r0 = (int) r0;
        r2 = (float) r4;
        r2 = r2 * r1;
        r1 = (int) r2;
        r3 = new android.graphics.Rect;
        r2 = 0;
        r3.<init>(r2, r2, r0, r1);
        r2 = r13;
        r4 = r5;
        r5 = r6;
        r6 = r14;
        r2.m3337a(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
        return r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.d.u.a(android.util.JsonReader):com.a.a.f");
    }

    /* renamed from: a */
    private static void m3281a(JsonReader jsonReader, C0954f c0954f, List<C0912d> list, C0452f<C0912d> c0452f) {
        jsonReader.beginArray();
        int i = 0;
        while (jsonReader.hasNext()) {
            C0912d a = C0935t.m3277a(jsonReader, c0954f);
            if (a.m3200k() == C0910a.Image) {
                i++;
            }
            list.add(a);
            c0452f.m1418b(a.m3194e(), a);
            if (i > 4) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("You have ");
                stringBuilder.append(i);
                stringBuilder.append(" images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                C0940d.m3287a(stringBuilder.toString());
            }
        }
        jsonReader.endArray();
    }

    /* renamed from: a */
    private static void m3282a(JsonReader jsonReader, C0954f c0954f, Map<String, List<C0912d>> map, Map<String, C0958h> map2) {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            List arrayList = new ArrayList();
            C0452f c0452f = new C0452f();
            jsonReader.beginObject();
            String str = null;
            String str2 = str;
            String str3 = str2;
            int i = 0;
            int i2 = 0;
            while (jsonReader.hasNext()) {
                Object obj;
                C0912d a;
                String nextName = jsonReader.nextName();
                int hashCode = nextName.hashCode();
                if (hashCode == -1109732030) {
                    if (nextName.equals("layers")) {
                        obj = 1;
                        switch (obj) {
                            case null:
                                str = jsonReader.nextString();
                                break;
                            case 1:
                                jsonReader.beginArray();
                                while (jsonReader.hasNext()) {
                                    a = C0935t.m3277a(jsonReader, c0954f);
                                    c0452f.m1418b(a.m3194e(), a);
                                    arrayList.add(a);
                                }
                                jsonReader.endArray();
                                break;
                            case 2:
                                i = jsonReader.nextInt();
                                break;
                            case 3:
                                i2 = jsonReader.nextInt();
                                break;
                            case 4:
                                str2 = jsonReader.nextString();
                                break;
                            case 5:
                                str3 = jsonReader.nextString();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                } else if (hashCode == 104) {
                    if (nextName.equals("h")) {
                        obj = 3;
                        switch (obj) {
                            case null:
                                str = jsonReader.nextString();
                                break;
                            case 1:
                                jsonReader.beginArray();
                                while (jsonReader.hasNext()) {
                                    a = C0935t.m3277a(jsonReader, c0954f);
                                    c0452f.m1418b(a.m3194e(), a);
                                    arrayList.add(a);
                                }
                                jsonReader.endArray();
                                break;
                            case 2:
                                i = jsonReader.nextInt();
                                break;
                            case 3:
                                i2 = jsonReader.nextInt();
                                break;
                            case 4:
                                str2 = jsonReader.nextString();
                                break;
                            case 5:
                                str3 = jsonReader.nextString();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                } else if (hashCode == 112) {
                    if (nextName.equals("p")) {
                        obj = 4;
                        switch (obj) {
                            case null:
                                str = jsonReader.nextString();
                                break;
                            case 1:
                                jsonReader.beginArray();
                                while (jsonReader.hasNext()) {
                                    a = C0935t.m3277a(jsonReader, c0954f);
                                    c0452f.m1418b(a.m3194e(), a);
                                    arrayList.add(a);
                                }
                                jsonReader.endArray();
                                break;
                            case 2:
                                i = jsonReader.nextInt();
                                break;
                            case 3:
                                i2 = jsonReader.nextInt();
                                break;
                            case 4:
                                str2 = jsonReader.nextString();
                                break;
                            case 5:
                                str3 = jsonReader.nextString();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                } else if (hashCode == 117) {
                    if (nextName.equals("u")) {
                        obj = 5;
                        switch (obj) {
                            case null:
                                str = jsonReader.nextString();
                                break;
                            case 1:
                                jsonReader.beginArray();
                                while (jsonReader.hasNext()) {
                                    a = C0935t.m3277a(jsonReader, c0954f);
                                    c0452f.m1418b(a.m3194e(), a);
                                    arrayList.add(a);
                                }
                                jsonReader.endArray();
                                break;
                            case 2:
                                i = jsonReader.nextInt();
                                break;
                            case 3:
                                i2 = jsonReader.nextInt();
                                break;
                            case 4:
                                str2 = jsonReader.nextString();
                                break;
                            case 5:
                                str3 = jsonReader.nextString();
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
                                str = jsonReader.nextString();
                                break;
                            case 1:
                                jsonReader.beginArray();
                                while (jsonReader.hasNext()) {
                                    a = C0935t.m3277a(jsonReader, c0954f);
                                    c0452f.m1418b(a.m3194e(), a);
                                    arrayList.add(a);
                                }
                                jsonReader.endArray();
                                break;
                            case 2:
                                i = jsonReader.nextInt();
                                break;
                            case 3:
                                i2 = jsonReader.nextInt();
                                break;
                            case 4:
                                str2 = jsonReader.nextString();
                                break;
                            case 5:
                                str3 = jsonReader.nextString();
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                } else if (hashCode == 3355) {
                    if (nextName.equals("id")) {
                        obj = null;
                        switch (obj) {
                            case null:
                                str = jsonReader.nextString();
                                break;
                            case 1:
                                jsonReader.beginArray();
                                while (jsonReader.hasNext()) {
                                    a = C0935t.m3277a(jsonReader, c0954f);
                                    c0452f.m1418b(a.m3194e(), a);
                                    arrayList.add(a);
                                }
                                jsonReader.endArray();
                                break;
                            case 2:
                                i = jsonReader.nextInt();
                                break;
                            case 3:
                                i2 = jsonReader.nextInt();
                                break;
                            case 4:
                                str2 = jsonReader.nextString();
                                break;
                            case 5:
                                str3 = jsonReader.nextString();
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
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            a = C0935t.m3277a(jsonReader, c0954f);
                            c0452f.m1418b(a.m3194e(), a);
                            arrayList.add(a);
                        }
                        jsonReader.endArray();
                        break;
                    case 2:
                        i = jsonReader.nextInt();
                        break;
                    case 3:
                        i2 = jsonReader.nextInt();
                        break;
                    case 4:
                        str2 = jsonReader.nextString();
                        break;
                    case 5:
                        str3 = jsonReader.nextString();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            if (str2 != null) {
                C0958h c0958h = new C0958h(i, i2, str, str2, str3);
                map2.put(c0958h.m3402a(), c0958h);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.endArray();
    }

    /* renamed from: a */
    private static void m3283a(JsonReader jsonReader, Map<String, C0915c> map) {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            Object obj = -1;
            if (nextName.hashCode() == 3322014) {
                if (nextName.equals("list")) {
                    obj = null;
                }
            }
            if (obj != null) {
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    C0915c a = C0928l.m3259a(jsonReader);
                    map.put(a.m3212b(), a);
                }
                jsonReader.endArray();
            }
        }
        jsonReader.endObject();
    }

    /* renamed from: a */
    private static void m3280a(JsonReader jsonReader, C0954f c0954f, C0464m<C0916d> c0464m) {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            C0916d a = C0927k.m3258a(jsonReader, c0954f);
            c0464m.m1471b(a.hashCode(), a);
        }
        jsonReader.endArray();
    }
}
