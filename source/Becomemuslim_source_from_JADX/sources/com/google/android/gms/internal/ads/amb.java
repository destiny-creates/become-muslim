package com.google.android.gms.internal.ads;

import java.util.PriorityQueue;

@cm
public final class amb {
    /* renamed from: a */
    private static long m18623a(long j, int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return j;
        }
        return (i % 2 == 0 ? m18623a((j * j) % 1073807359, i / 2) : j * (m18623a((j * j) % 1073807359, i / 2) % 1073807359)) % 1073807359;
    }

    /* renamed from: a */
    private static String m18624a(String[] strArr, int i, int i2) {
        i2 += i;
        if (strArr.length < i2) {
            mt.m19920c("Unable to construct shingle");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int i3 = i2 - 1;
            if (i < i3) {
                stringBuilder.append(strArr[i]);
                stringBuilder.append(' ');
                i++;
            } else {
                stringBuilder.append(strArr[i3]);
                return stringBuilder.toString();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static void m18625a(int r1, long r2, java.lang.String r4, int r5, java.util.PriorityQueue<com.google.android.gms.internal.ads.amc> r6) {
        /*
        r0 = new com.google.android.gms.internal.ads.amc;
        r0.<init>(r2, r4, r5);
        r2 = r6.size();
        if (r2 != r1) goto L_0x0026;
    L_0x000b:
        r2 = r6.peek();
        r2 = (com.google.android.gms.internal.ads.amc) r2;
        r2 = r2.f14750c;
        r3 = r0.f14750c;
        if (r2 > r3) goto L_0x0025;
    L_0x0017:
        r2 = r6.peek();
        r2 = (com.google.android.gms.internal.ads.amc) r2;
        r2 = r2.f14748a;
        r4 = r0.f14748a;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x0026;
    L_0x0025:
        return;
    L_0x0026:
        r2 = r6.contains(r0);
        if (r2 == 0) goto L_0x002d;
    L_0x002c:
        return;
    L_0x002d:
        r6.add(r0);
        r2 = r6.size();
        if (r2 <= r1) goto L_0x0039;
    L_0x0036:
        r6.poll();
    L_0x0039:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.amb.a(int, long, java.lang.String, int, java.util.PriorityQueue):void");
    }

    /* renamed from: a */
    public static void m18626a(String[] strArr, int i, int i2, PriorityQueue<amc> priorityQueue) {
        String[] strArr2 = strArr;
        int i3 = i2;
        if (strArr2.length < i3) {
            m18625a(i, m18627b(strArr2, 0, strArr2.length), m18624a(strArr2, 0, strArr2.length), strArr2.length, priorityQueue);
            return;
        }
        long b = m18627b(strArr2, 0, i3);
        m18625a(i, b, m18624a(strArr2, 0, i3), i2, priorityQueue);
        long a = m18623a(16785407, i3 - 1);
        for (int i4 = 1; i4 < (strArr2.length - i3) + 1; i4++) {
            b += 1073807359;
            b = (((((b - ((((((long) aly.m18618a(strArr2[i4 - 1])) + 2147483647L) % 1073807359) * a) % 1073807359)) % 1073807359) * 16785407) % 1073807359) + ((((long) aly.m18618a(strArr2[(i4 + i3) - 1])) + 2147483647L) % 1073807359)) % 1073807359;
            m18625a(i, b, m18624a(strArr2, i4, i3), strArr2.length, priorityQueue);
        }
    }

    /* renamed from: b */
    private static long m18627b(String[] strArr, int i, int i2) {
        long a = (((long) aly.m18618a(strArr[0])) + 2147483647L) % 1073807359;
        for (i = 1; i < i2; i++) {
            a = (((a * 16785407) % 1073807359) + ((((long) aly.m18618a(strArr[i])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return a;
    }
}
