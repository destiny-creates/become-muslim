package com.google.p217b.p231e;

import com.google.p217b.C5193a;
import com.google.p217b.C5254e;
import com.google.p217b.p231e.p232a.C8233e;
import com.google.p217b.p231e.p232a.p233a.C8232d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatOneDReader */
/* renamed from: com.google.b.e.p */
public final class C7911p extends C6873r {
    /* renamed from: a */
    private final C6873r[] f29519a;

    public C7911p(Map<C5254e, ?> map) {
        Collection collection;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(C5254e.POSSIBLE_FORMATS);
        }
        boolean z = (map == null || map.get(C5254e.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        Collection arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(C5193a.EAN_13) || collection.contains(C5193a.UPC_A) || collection.contains(C5193a.EAN_8) || collection.contains(C5193a.UPC_E)) {
                arrayList.add(new C7912q(map));
            }
            if (collection.contains(C5193a.CODE_39)) {
                arrayList.add(new C7905e(z));
            }
            if (collection.contains(C5193a.CODE_93)) {
                arrayList.add(new C7907g());
            }
            if (collection.contains(C5193a.CODE_128)) {
                arrayList.add(new C7903c());
            }
            if (collection.contains(C5193a.ITF)) {
                arrayList.add(new C7909n());
            }
            if (collection.contains(C5193a.CODABAR)) {
                arrayList.add(new C7901a());
            }
            if (collection.contains(C5193a.RSS_14)) {
                arrayList.add(new C8233e());
            }
            if (collection.contains(C5193a.RSS_EXPANDED)) {
                arrayList.add(new C8232d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new C7912q(map));
            arrayList.add(new C7905e());
            arrayList.add(new C7901a());
            arrayList.add(new C7907g());
            arrayList.add(new C7903c());
            arrayList.add(new C7909n());
            arrayList.add(new C8233e());
            arrayList.add(new C8232d());
        }
        this.f29519a = (C6873r[]) arrayList.toArray(new C6873r[arrayList.size()]);
    }

    /* renamed from: a */
    public com.google.p217b.C5314q mo6260a(int r5, com.google.p217b.p222b.C5196a r6, java.util.Map<com.google.p217b.C5254e, ?> r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.f29519a;
        r1 = r0.length;
        r2 = 0;
    L_0x0004:
        if (r2 >= r1) goto L_0x0010;
    L_0x0006:
        r3 = r0[r2];
        r3 = r3.mo6260a(r5, r6, r7);	 Catch:{ p -> 0x000d }
        return r3;
    L_0x000d:
        r2 = r2 + 1;
        goto L_0x0004;
    L_0x0010:
        r5 = com.google.p217b.C6894l.m32349a();
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.e.p.a(int, com.google.b.b.a, java.util.Map):com.google.b.q");
    }
}
