package com.google.p217b.p231e;

import com.google.p217b.C5193a;
import com.google.p217b.C5314q;
import com.google.p217b.C5315r;
import com.google.p217b.C5316s;
import com.google.p217b.C6894l;
import com.google.p217b.p222b.C5196a;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: UPCEANExtension5Support */
/* renamed from: com.google.b.e.w */
final class C5252w {
    /* renamed from: a */
    private static final int[] f17714a = new int[]{24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
    /* renamed from: b */
    private final int[] f17715b = new int[4];
    /* renamed from: c */
    private final StringBuilder f17716c = new StringBuilder();

    C5252w() {
    }

    /* renamed from: a */
    C5314q m22242a(int i, C5196a c5196a, int[] iArr) {
        StringBuilder stringBuilder = this.f17716c;
        stringBuilder.setLength(0);
        c5196a = m22238a(c5196a, iArr, stringBuilder);
        String stringBuilder2 = stringBuilder.toString();
        Map a = C5252w.m22240a(stringBuilder2);
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
    private int m22238a(C5196a c5196a, int[] iArr, StringBuilder stringBuilder) {
        int[] iArr2 = this.f17715b;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int a = c5196a.m21954a();
        int i = iArr[1];
        iArr = null;
        int i2 = 0;
        while (iArr < 5 && i < a) {
            int a2 = C7913y.m38497a(c5196a, iArr2, i, C7913y.f29525f);
            stringBuilder.append((char) ((a2 % 10) + 48));
            int i3 = i;
            for (int i4 : iArr2) {
                i3 += i4;
            }
            if (a2 >= 10) {
                i2 |= 1 << (4 - iArr);
            }
            i = iArr != 4 ? c5196a.m21967d(c5196a.m21965c(i3)) : i3;
            iArr++;
        }
        if (stringBuilder.length() == 5) {
            if (C5252w.m22239a(stringBuilder.toString()) == C5252w.m22237a(i2)) {
                return i;
            }
            throw C6894l.m32349a();
        }
        throw C6894l.m32349a();
    }

    /* renamed from: a */
    private static int m22239a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            i += charSequence.charAt(i2) - 48;
        }
        i *= 3;
        for (length--; length >= 0; length -= 2) {
            i += charSequence.charAt(length) - 48;
        }
        return (i * 3) % 10;
    }

    /* renamed from: a */
    private static int m22237a(int i) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == f17714a[i2]) {
                return i2;
            }
        }
        throw C6894l.m32349a();
    }

    /* renamed from: a */
    private static Map<C5315r, Object> m22240a(String str) {
        if (str.length() != 5) {
            return null;
        }
        str = C5252w.m22241b(str);
        if (str == null) {
            return null;
        }
        Map<C5315r, Object> enumMap = new EnumMap(C5315r.class);
        enumMap.put(C5315r.SUGGESTED_PRICE, str);
        return enumMap;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private static java.lang.String m22241b(java.lang.String r5) {
        /*
        r0 = 0;
        r1 = r5.charAt(r0);
        r2 = 48;
        r3 = 1;
        if (r1 == r2) goto L_0x0052;
    L_0x000a:
        r2 = 53;
        if (r1 == r2) goto L_0x004f;
    L_0x000e:
        r2 = 57;
        if (r1 == r2) goto L_0x0015;
    L_0x0012:
        r0 = "";
        goto L_0x0054;
    L_0x0015:
        r1 = -1;
        r2 = r5.hashCode();
        r4 = 54118329; // 0x339c7b9 float:5.4595884E-37 double:2.6738007E-316;
        if (r2 == r4) goto L_0x0037;
    L_0x001f:
        switch(r2) {
            case 54395376: goto L_0x002d;
            case 54395377: goto L_0x0023;
            default: goto L_0x0022;
        };
    L_0x0022:
        goto L_0x0040;
    L_0x0023:
        r0 = "99991";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0040;
    L_0x002b:
        r0 = 1;
        goto L_0x0041;
    L_0x002d:
        r0 = "99990";
        r0 = r5.equals(r0);
        if (r0 == 0) goto L_0x0040;
    L_0x0035:
        r0 = 2;
        goto L_0x0041;
    L_0x0037:
        r2 = "90000";
        r2 = r5.equals(r2);
        if (r2 == 0) goto L_0x0040;
    L_0x003f:
        goto L_0x0041;
    L_0x0040:
        r0 = -1;
    L_0x0041:
        switch(r0) {
            case 0: goto L_0x004d;
            case 1: goto L_0x004a;
            case 2: goto L_0x0047;
            default: goto L_0x0044;
        };
    L_0x0044:
        r0 = "";
        goto L_0x0054;
    L_0x0047:
        r5 = "Used";
        return r5;
    L_0x004a:
        r5 = "0.00";
        return r5;
    L_0x004d:
        r5 = 0;
        return r5;
    L_0x004f:
        r0 = "$";
        goto L_0x0054;
    L_0x0052:
        r0 = "£";
    L_0x0054:
        r5 = r5.substring(r3);
        r5 = java.lang.Integer.parseInt(r5);
        r1 = r5 / 100;
        r1 = java.lang.String.valueOf(r1);
        r5 = r5 % 100;
        r2 = 10;
        if (r5 >= r2) goto L_0x0073;
    L_0x0068:
        r2 = "0";
        r5 = java.lang.String.valueOf(r5);
        r5 = r2.concat(r5);
        goto L_0x0077;
    L_0x0073:
        r5 = java.lang.String.valueOf(r5);
    L_0x0077:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r0);
        r2.append(r1);
        r0 = 46;
        r2.append(r0);
        r2.append(r5);
        r5 = r2.toString();
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.e.w.b(java.lang.String):java.lang.String");
    }
}
