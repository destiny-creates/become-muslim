package com.google.p217b;

import com.google.p217b.p218a.C6852b;
import com.google.p217b.p225c.C6858a;
import com.google.p217b.p229d.C6865a;
import com.google.p217b.p231e.C7911p;
import com.google.p217b.p235f.C6877b;
import com.google.p217b.p240g.C6887a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatReader */
/* renamed from: com.google.b.j */
public final class C6892j implements C5312o {
    /* renamed from: a */
    private Map<C5254e, ?> f24701a;
    /* renamed from: b */
    private C5312o[] f24702b;

    /* renamed from: a */
    public C5314q mo4858a(C5232c c5232c, Map<C5254e, ?> map) {
        m32347a((Map) map);
        return m32344b(c5232c);
    }

    /* renamed from: a */
    public C5314q m32345a(C5232c c5232c) {
        if (this.f24702b == null) {
            m32347a(null);
        }
        return m32344b(c5232c);
    }

    /* renamed from: a */
    public void m32347a(Map<C5254e, ?> map) {
        Collection collection;
        this.f24701a = map;
        Object obj = 1;
        Object obj2 = (map == null || !map.containsKey(C5254e.TRY_HARDER)) ? null : 1;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(C5254e.POSSIBLE_FORMATS);
        }
        Collection arrayList = new ArrayList();
        if (collection != null) {
            if (!(collection.contains(C5193a.UPC_A) || collection.contains(C5193a.UPC_E) || collection.contains(C5193a.EAN_13) || collection.contains(C5193a.EAN_8) || collection.contains(C5193a.CODABAR) || collection.contains(C5193a.CODE_39) || collection.contains(C5193a.CODE_93) || collection.contains(C5193a.CODE_128) || collection.contains(C5193a.ITF) || collection.contains(C5193a.RSS_14))) {
                if (!collection.contains(C5193a.RSS_EXPANDED)) {
                    obj = null;
                }
            }
            if (obj != null && obj2 == null) {
                arrayList.add(new C7911p(map));
            }
            if (collection.contains(C5193a.QR_CODE)) {
                arrayList.add(new C6887a());
            }
            if (collection.contains(C5193a.DATA_MATRIX)) {
                arrayList.add(new C6858a());
            }
            if (collection.contains(C5193a.AZTEC)) {
                arrayList.add(new C6852b());
            }
            if (collection.contains(C5193a.PDF_417)) {
                arrayList.add(new C6877b());
            }
            if (collection.contains(C5193a.MAXICODE)) {
                arrayList.add(new C6865a());
            }
            if (!(obj == null || obj2 == null)) {
                arrayList.add(new C7911p(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (obj2 == null) {
                arrayList.add(new C7911p(map));
            }
            arrayList.add(new C6887a());
            arrayList.add(new C6858a());
            arrayList.add(new C6852b());
            arrayList.add(new C6877b());
            arrayList.add(new C6865a());
            if (obj2 != null) {
                arrayList.add(new C7911p(map));
            }
        }
        this.f24702b = (C5312o[]) arrayList.toArray(new C5312o[arrayList.size()]);
    }

    /* renamed from: b */
    private com.google.p217b.C5314q m32344b(com.google.p217b.C5232c r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.f24702b;
        if (r0 == 0) goto L_0x0016;
    L_0x0004:
        r0 = r5.f24702b;
        r1 = r0.length;
        r2 = 0;
    L_0x0008:
        if (r2 >= r1) goto L_0x0016;
    L_0x000a:
        r3 = r0[r2];
        r4 = r5.f24701a;	 Catch:{ p -> 0x0013 }
        r3 = r3.mo4858a(r6, r4);	 Catch:{ p -> 0x0013 }
        return r3;
    L_0x0013:
        r2 = r2 + 1;
        goto L_0x0008;
    L_0x0016:
        r6 = com.google.p217b.C6894l.m32349a();
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.b.j.b(com.google.b.c):com.google.b.q");
    }
}
