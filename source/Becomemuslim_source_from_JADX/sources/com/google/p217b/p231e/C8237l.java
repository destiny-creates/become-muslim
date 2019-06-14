package com.google.p217b.p231e;

import com.google.p217b.C5193a;
import com.google.p217b.C5309g;
import com.google.p217b.p222b.C5202b;
import java.util.Map;

/* compiled from: EAN8Writer */
/* renamed from: com.google.b.e.l */
public final class C8237l extends C7914z {
    /* renamed from: a */
    public C5202b mo4860a(String str, C5193a c5193a, int i, int i2, Map<C5309g, ?> map) {
        if (c5193a == C5193a.EAN_8) {
            return super.mo4860a(str, c5193a, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got ".concat(String.valueOf(c5193a)));
    }

    /* renamed from: a */
    public boolean[] mo6261a(java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = r8.length();
        switch(r0) {
            case 7: goto L_0x002e;
            case 8: goto L_0x0017;
            default: goto L_0x0007;
        };
    L_0x0007:
        r8 = new java.lang.IllegalArgumentException;
        r0 = java.lang.String.valueOf(r0);
        r1 = "Requested contents should be 8 digits long, but got ";
        r0 = r1.concat(r0);
        r8.<init>(r0);
        throw r8;
    L_0x0017:
        r0 = com.google.p217b.p231e.C7913y.m38498a(r8);	 Catch:{ h -> 0x0026 }
        if (r0 == 0) goto L_0x001e;	 Catch:{ h -> 0x0026 }
    L_0x001d:
        goto L_0x0041;	 Catch:{ h -> 0x0026 }
    L_0x001e:
        r8 = new java.lang.IllegalArgumentException;	 Catch:{ h -> 0x0026 }
        r0 = "Contents do not pass checksum";	 Catch:{ h -> 0x0026 }
        r8.<init>(r0);	 Catch:{ h -> 0x0026 }
        throw r8;	 Catch:{ h -> 0x0026 }
    L_0x0026:
        r8 = new java.lang.IllegalArgumentException;
        r0 = "Illegal contents";
        r8.<init>(r0);
        throw r8;
    L_0x002e:
        r0 = com.google.p217b.p231e.C7913y.m38502b(r8);	 Catch:{ h -> 0x008e }
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r8);
        r1.append(r0);
        r8 = r1.toString();
    L_0x0041:
        r0 = 67;
        r0 = new boolean[r0];
        r1 = com.google.p217b.p231e.C7913y.f29521b;
        r2 = 1;
        r3 = 0;
        r1 = com.google.p217b.p231e.C6874s.m32300a(r0, r3, r1, r2);
        r1 = r1 + r3;
        r4 = r1;
        r1 = 0;
    L_0x0050:
        r5 = 3;
        r6 = 10;
        if (r1 > r5) goto L_0x0069;
    L_0x0055:
        r5 = r8.charAt(r1);
        r5 = java.lang.Character.digit(r5, r6);
        r6 = com.google.p217b.p231e.C7913y.f29524e;
        r5 = r6[r5];
        r5 = com.google.p217b.p231e.C6874s.m32300a(r0, r4, r5, r3);
        r4 = r4 + r5;
        r1 = r1 + 1;
        goto L_0x0050;
    L_0x0069:
        r1 = com.google.p217b.p231e.C7913y.f29522c;
        r1 = com.google.p217b.p231e.C6874s.m32300a(r0, r4, r1, r3);
        r4 = r4 + r1;
        r1 = 4;
    L_0x0071:
        r3 = 7;
        if (r1 > r3) goto L_0x0088;
    L_0x0074:
        r3 = r8.charAt(r1);
        r3 = java.lang.Character.digit(r3, r6);
        r5 = com.google.p217b.p231e.C7913y.f29524e;
        r3 = r5[r3];
        r3 = com.google.p217b.p231e.C6874s.m32300a(r0, r4, r3, r2);
        r4 = r4 + r3;
        r1 = r1 + 1;
        goto L_0x0071;
    L_0x0088:
        r8 = com.google.p217b.p231e.C7913y.f29521b;
        com.google.p217b.p231e.C6874s.m32300a(r0, r4, r8, r2);
        return r0;
    L_0x008e:
        r8 = move-exception;
        r0 = new java.lang.IllegalArgumentException;
        r0.<init>(r8);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.e.l.a(java.lang.String):boolean[]");
    }
}
