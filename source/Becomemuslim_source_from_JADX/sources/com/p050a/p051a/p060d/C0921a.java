package com.p050a.p051a.p060d;

import android.util.JsonReader;
import android.util.JsonToken;
import com.p050a.p051a.C0954f;
import com.p050a.p051a.p056c.p057a.C3367e;
import com.p050a.p051a.p061e.C0948f;
import com.p050a.p051a.p062f.C0950a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AnimatablePathValueParser */
/* renamed from: com.a.a.d.a */
public class C0921a {
    /* renamed from: a */
    public static C3367e m3231a(JsonReader jsonReader, C0954f c0954f) {
        List arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(C0939x.m3286a(jsonReader, c0954f));
            }
            jsonReader.endArray();
            C0934s.m3276a(arrayList);
        } else {
            arrayList.add(new C0950a(C0932q.m3265b(jsonReader, C0948f.m3313a())));
        }
        return new C3367e(arrayList);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    static com.p050a.p051a.p056c.p057a.C0893m<android.graphics.PointF, android.graphics.PointF> m3232b(android.util.JsonReader r10, com.p050a.p051a.C0954f r11) {
        /*
        r10.beginObject();
        r0 = 0;
        r1 = 0;
        r2 = r1;
        r3 = r2;
        r4 = r3;
        r1 = 0;
    L_0x0009:
        r5 = r10.peek();
        r6 = android.util.JsonToken.END_OBJECT;
        if (r5 == r6) goto L_0x0071;
    L_0x0011:
        r5 = r10.nextName();
        r6 = -1;
        r7 = r5.hashCode();
        r8 = 107; // 0x6b float:1.5E-43 double:5.3E-322;
        r9 = 1;
        if (r7 == r8) goto L_0x0037;
    L_0x001f:
        switch(r7) {
            case 120: goto L_0x002d;
            case 121: goto L_0x0023;
            default: goto L_0x0022;
        };
    L_0x0022:
        goto L_0x0041;
    L_0x0023:
        r7 = "y";
        r5 = r5.equals(r7);
        if (r5 == 0) goto L_0x0041;
    L_0x002b:
        r5 = 2;
        goto L_0x0042;
    L_0x002d:
        r7 = "x";
        r5 = r5.equals(r7);
        if (r5 == 0) goto L_0x0041;
    L_0x0035:
        r5 = 1;
        goto L_0x0042;
    L_0x0037:
        r7 = "k";
        r5 = r5.equals(r7);
        if (r5 == 0) goto L_0x0041;
    L_0x003f:
        r5 = 0;
        goto L_0x0042;
    L_0x0041:
        r5 = -1;
    L_0x0042:
        switch(r5) {
            case 0: goto L_0x006c;
            case 1: goto L_0x005a;
            case 2: goto L_0x0049;
            default: goto L_0x0045;
        };
    L_0x0045:
        r10.skipValue();
        goto L_0x0009;
    L_0x0049:
        r5 = r10.peek();
        r6 = android.util.JsonToken.STRING;
        if (r5 != r6) goto L_0x0055;
    L_0x0051:
        r10.skipValue();
        goto L_0x0065;
    L_0x0055:
        r4 = com.p050a.p051a.p060d.C0924d.m3245a(r10, r11);
        goto L_0x0009;
    L_0x005a:
        r5 = r10.peek();
        r6 = android.util.JsonToken.STRING;
        if (r5 != r6) goto L_0x0067;
    L_0x0062:
        r10.skipValue();
    L_0x0065:
        r1 = 1;
        goto L_0x0009;
    L_0x0067:
        r3 = com.p050a.p051a.p060d.C0924d.m3245a(r10, r11);
        goto L_0x0009;
    L_0x006c:
        r2 = com.p050a.p051a.p060d.C0921a.m3231a(r10, r11);
        goto L_0x0009;
    L_0x0071:
        r10.endObject();
        if (r1 == 0) goto L_0x007b;
    L_0x0076:
        r10 = "Lottie doesn't support expressions.";
        r11.m3338a(r10);
    L_0x007b:
        if (r2 == 0) goto L_0x007e;
    L_0x007d:
        return r2;
    L_0x007e:
        r10 = new com.a.a.c.a.i;
        r10.<init>(r3, r4);
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.d.a.b(android.util.JsonReader, com.a.a.f):com.a.a.c.a.m<android.graphics.PointF, android.graphics.PointF>");
    }
}
