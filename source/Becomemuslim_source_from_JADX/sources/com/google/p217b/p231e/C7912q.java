package com.google.p217b.p231e;

import com.google.p217b.C5193a;
import com.google.p217b.C5254e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatUPCEANReader */
/* renamed from: com.google.b.e.q */
public final class C7912q extends C6873r {
    /* renamed from: a */
    private final C7913y[] f29520a;

    public C7912q(Map<C5254e, ?> map) {
        if (map == null) {
            map = null;
        } else {
            map = (Collection) map.get(C5254e.POSSIBLE_FORMATS);
        }
        Collection arrayList = new ArrayList();
        if (map != null) {
            if (map.contains(C5193a.EAN_13)) {
                arrayList.add(new C8234i());
            } else if (map.contains(C5193a.UPC_A)) {
                arrayList.add(new C8238t());
            }
            if (map.contains(C5193a.EAN_8)) {
                arrayList.add(new C8236k());
            }
            if (map.contains(C5193a.UPC_E) != null) {
                arrayList.add(new aa());
            }
        }
        if (arrayList.isEmpty() != null) {
            arrayList.add(new C8234i());
            arrayList.add(new C8236k());
            arrayList.add(new aa());
        }
        this.f29520a = (C7913y[]) arrayList.toArray(new C7913y[arrayList.size()]);
    }

    /* renamed from: a */
    public com.google.p217b.C5314q mo6260a(int r12, com.google.p217b.p222b.C5196a r13, java.util.Map<com.google.p217b.C5254e, ?> r14) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r0 = com.google.p217b.p231e.C7913y.m38499a(r13);
        r1 = r11.f29520a;
        r2 = r1.length;
        r3 = 0;
        r4 = 0;
    L_0x0009:
        if (r4 >= r2) goto L_0x006a;
    L_0x000b:
        r5 = r1[r4];
        r5 = r5.mo6754a(r12, r13, r0, r14);	 Catch:{ p -> 0x0067 }
        r6 = r5.m22577d();	 Catch:{ p -> 0x0067 }
        r7 = com.google.p217b.C5193a.EAN_13;	 Catch:{ p -> 0x0067 }
        r8 = 1;	 Catch:{ p -> 0x0067 }
        if (r6 != r7) goto L_0x0028;	 Catch:{ p -> 0x0067 }
    L_0x001a:
        r6 = r5.m22571a();	 Catch:{ p -> 0x0067 }
        r6 = r6.charAt(r3);	 Catch:{ p -> 0x0067 }
        r7 = 48;	 Catch:{ p -> 0x0067 }
        if (r6 != r7) goto L_0x0028;	 Catch:{ p -> 0x0067 }
    L_0x0026:
        r6 = 1;	 Catch:{ p -> 0x0067 }
        goto L_0x0029;	 Catch:{ p -> 0x0067 }
    L_0x0028:
        r6 = 0;	 Catch:{ p -> 0x0067 }
    L_0x0029:
        if (r14 != 0) goto L_0x002d;	 Catch:{ p -> 0x0067 }
    L_0x002b:
        r7 = 0;	 Catch:{ p -> 0x0067 }
        goto L_0x0035;	 Catch:{ p -> 0x0067 }
    L_0x002d:
        r7 = com.google.p217b.C5254e.POSSIBLE_FORMATS;	 Catch:{ p -> 0x0067 }
        r7 = r14.get(r7);	 Catch:{ p -> 0x0067 }
        r7 = (java.util.Collection) r7;	 Catch:{ p -> 0x0067 }
    L_0x0035:
        if (r7 == 0) goto L_0x0042;	 Catch:{ p -> 0x0067 }
    L_0x0037:
        r9 = com.google.p217b.C5193a.UPC_A;	 Catch:{ p -> 0x0067 }
        r7 = r7.contains(r9);	 Catch:{ p -> 0x0067 }
        if (r7 == 0) goto L_0x0040;	 Catch:{ p -> 0x0067 }
    L_0x003f:
        goto L_0x0042;	 Catch:{ p -> 0x0067 }
    L_0x0040:
        r7 = 0;	 Catch:{ p -> 0x0067 }
        goto L_0x0043;	 Catch:{ p -> 0x0067 }
    L_0x0042:
        r7 = 1;	 Catch:{ p -> 0x0067 }
    L_0x0043:
        if (r6 == 0) goto L_0x0066;	 Catch:{ p -> 0x0067 }
    L_0x0045:
        if (r7 == 0) goto L_0x0066;	 Catch:{ p -> 0x0067 }
    L_0x0047:
        r6 = new com.google.b.q;	 Catch:{ p -> 0x0067 }
        r7 = r5.m22571a();	 Catch:{ p -> 0x0067 }
        r7 = r7.substring(r8);	 Catch:{ p -> 0x0067 }
        r8 = r5.m22575b();	 Catch:{ p -> 0x0067 }
        r9 = r5.m22576c();	 Catch:{ p -> 0x0067 }
        r10 = com.google.p217b.C5193a.UPC_A;	 Catch:{ p -> 0x0067 }
        r6.<init>(r7, r8, r9, r10);	 Catch:{ p -> 0x0067 }
        r5 = r5.m22578e();	 Catch:{ p -> 0x0067 }
        r6.m22573a(r5);	 Catch:{ p -> 0x0067 }
        return r6;
    L_0x0066:
        return r5;
    L_0x0067:
        r4 = r4 + 1;
        goto L_0x0009;
    L_0x006a:
        r12 = com.google.p217b.C6894l.m32349a();
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.e.q.a(int, com.google.b.b.a, java.util.Map):com.google.b.q");
    }
}
