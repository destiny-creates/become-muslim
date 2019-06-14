package com.google.p217b.p231e;

import com.google.p217b.C5193a;
import com.google.p217b.C5314q;
import com.google.p217b.C5315r;
import com.google.p217b.C5316s;
import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5196a;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: UPCEANExtension2Support */
/* renamed from: com.google.b.e.v */
final class C5251v {
    /* renamed from: a */
    private final int[] f17712a = new int[4];
    /* renamed from: b */
    private final StringBuilder f17713b = new StringBuilder();

    C5251v() {
    }

    /* renamed from: a */
    C5314q m22236a(int i, C5196a c5196a, int[] iArr) {
        StringBuilder stringBuilder = this.f17713b;
        stringBuilder.setLength(0);
        c5196a = m22234a(c5196a, iArr, stringBuilder);
        String stringBuilder2 = stringBuilder.toString();
        Map a = C5251v.m22235a(stringBuilder2);
        r4 = new C5316s[2];
        i = (float) i;
        r4[0] = new C5316s(((float) (iArr[0] + iArr[1])) / 2.0f, i);
        r4[1] = new C5316s((float) c5196a, i);
        C5314q c5314q = new C5314q(stringBuilder2, null, r4, C5193a.UPC_EAN_EXTENSION);
        if (a != null) {
            c5314q.m22573a(a);
        }
        return c5314q;
    }

    /* renamed from: a */
    private int m22234a(C5196a c5196a, int[] iArr, StringBuilder stringBuilder) {
        int[] iArr2 = this.f17712a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a = c5196a.m21954a();
        int i = iArr[1];
        iArr = null;
        int i2 = 0;
        while (iArr < 2 && i < a) {
            int a2 = C7913y.m38497a(c5196a, iArr2, i, C7913y.f29525f);
            stringBuilder.append((char) ((a2 % 10) + 48));
            int i3 = i;
            for (int i4 : iArr2) {
                i3 += i4;
            }
            if (a2 >= 10) {
                i2 = (1 << (1 - iArr)) | i2;
            }
            i = iArr != 1 ? c5196a.m21967d(c5196a.m21965c(i3)) : i3;
            iArr++;
        }
        if (stringBuilder.length() != 2) {
            throw C6894l.m32349a();
        } else if (Integer.parseInt(stringBuilder.toString()) % 4 == i2) {
            return i;
        } else {
            throw C6894l.m32349a();
        }
    }

    /* renamed from: a */
    private static Map<C5315r, Object> m22235a(String str) {
        if (str.length() != 2) {
            return null;
        }
        Map<C5315r, Object> enumMap = new EnumMap(C5315r.class);
        enumMap.put(C5315r.ISSUE_NUMBER, Integer.valueOf(str));
        return enumMap;
    }
}
