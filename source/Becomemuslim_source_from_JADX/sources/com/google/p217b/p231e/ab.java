package com.google.p217b.p231e;

import com.google.p217b.C5193a;
import com.google.p217b.C5309g;
import com.google.p217b.p222b.C5202b;
import java.util.Map;

/* compiled from: UPCEWriter */
/* renamed from: com.google.b.e.ab */
public final class ab extends C7914z {
    /* renamed from: a */
    public C5202b mo4860a(String str, C5193a c5193a, int i, int i2, Map<C5309g, ?> map) {
        if (c5193a == C5193a.UPC_E) {
            return super.mo4860a(str, c5193a, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode UPC_E, but got ".concat(String.valueOf(c5193a)));
    }

    /* renamed from: a */
    public boolean[] mo6261a(java.lang.String r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = r10.length();
        switch(r0) {
            case 7: goto L_0x002e;
            case 8: goto L_0x0017;
            default: goto L_0x0007;
        };
    L_0x0007:
        r10 = new java.lang.IllegalArgumentException;
        r0 = java.lang.String.valueOf(r0);
        r1 = "Requested contents should be 8 digits long, but got ";
        r0 = r1.concat(r0);
        r10.<init>(r0);
        throw r10;
    L_0x0017:
        r0 = com.google.p217b.p231e.C7913y.m38498a(r10);	 Catch:{ h -> 0x0026 }
        if (r0 == 0) goto L_0x001e;	 Catch:{ h -> 0x0026 }
    L_0x001d:
        goto L_0x0045;	 Catch:{ h -> 0x0026 }
    L_0x001e:
        r10 = new java.lang.IllegalArgumentException;	 Catch:{ h -> 0x0026 }
        r0 = "Contents do not pass checksum";	 Catch:{ h -> 0x0026 }
        r10.<init>(r0);	 Catch:{ h -> 0x0026 }
        throw r10;	 Catch:{ h -> 0x0026 }
    L_0x0026:
        r10 = new java.lang.IllegalArgumentException;
        r0 = "Illegal contents";
        r10.<init>(r0);
        throw r10;
    L_0x002e:
        r0 = com.google.p217b.p231e.aa.m42776b(r10);	 Catch:{ h -> 0x009f }
        r0 = com.google.p217b.p231e.C7913y.m38502b(r0);	 Catch:{ h -> 0x009f }
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r10);
        r1.append(r0);
        r10 = r1.toString();
    L_0x0045:
        r0 = 0;
        r1 = r10.charAt(r0);
        r2 = 10;
        r1 = java.lang.Character.digit(r1, r2);
        r3 = 1;
        if (r1 == 0) goto L_0x005e;
    L_0x0053:
        if (r1 != r3) goto L_0x0056;
    L_0x0055:
        goto L_0x005e;
    L_0x0056:
        r10 = new java.lang.IllegalArgumentException;
        r0 = "Number system must be 0 or 1";
        r10.<init>(r0);
        throw r10;
    L_0x005e:
        r4 = 7;
        r4 = r10.charAt(r4);
        r4 = java.lang.Character.digit(r4, r2);
        r5 = com.google.p217b.p231e.aa.f32400a;
        r1 = r5[r1];
        r1 = r1[r4];
        r4 = 51;
        r4 = new boolean[r4];
        r5 = com.google.p217b.p231e.C7913y.f29521b;
        r5 = com.google.p217b.p231e.C6874s.m32300a(r4, r0, r5, r3);
        r5 = r5 + r0;
        r6 = r5;
        r5 = 1;
    L_0x007a:
        r7 = 6;
        if (r5 > r7) goto L_0x0099;
    L_0x007d:
        r8 = r10.charAt(r5);
        r8 = java.lang.Character.digit(r8, r2);
        r7 = r7 - r5;
        r7 = r1 >> r7;
        r7 = r7 & r3;
        if (r7 != r3) goto L_0x008d;
    L_0x008b:
        r8 = r8 + 10;
    L_0x008d:
        r7 = com.google.p217b.p231e.C7913y.f29525f;
        r7 = r7[r8];
        r7 = com.google.p217b.p231e.C6874s.m32300a(r4, r6, r7, r0);
        r6 = r6 + r7;
        r5 = r5 + 1;
        goto L_0x007a;
    L_0x0099:
        r10 = com.google.p217b.p231e.C7913y.f29523d;
        com.google.p217b.p231e.C6874s.m32300a(r4, r6, r10, r0);
        return r4;
    L_0x009f:
        r10 = move-exception;
        r0 = new java.lang.IllegalArgumentException;
        r0.<init>(r10);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.e.ab.a(java.lang.String):boolean[]");
    }
}
