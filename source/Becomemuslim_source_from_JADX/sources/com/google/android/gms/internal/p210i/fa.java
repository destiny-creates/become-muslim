package com.google.android.gms.internal.p210i;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.i.fa */
final class fa<FieldDescriptorType extends fc<FieldDescriptorType>> {
    /* renamed from: d */
    private static final fa f16535d = new fa(true);
    /* renamed from: a */
    final hm<FieldDescriptorType, Object> f16536a = hm.m20740a(16);
    /* renamed from: b */
    private boolean f16537b;
    /* renamed from: c */
    private boolean f16538c = false;

    private fa() {
    }

    private fa(boolean z) {
        m20536b();
    }

    /* renamed from: a */
    public static <T extends fc<T>> fa<T> m20525a() {
        return f16535d;
    }

    /* renamed from: b */
    public final void m20536b() {
        if (!this.f16537b) {
            this.f16536a.mo4581a();
            this.f16537b = true;
        }
    }

    /* renamed from: c */
    public final boolean m20537c() {
        return this.f16537b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fa)) {
            return null;
        }
        return this.f16536a.equals(((fa) obj).f16536a);
    }

    public final int hashCode() {
        return this.f16536a.hashCode();
    }

    /* renamed from: d */
    public final Iterator<Entry<FieldDescriptorType, Object>> m20538d() {
        if (this.f16538c) {
            return new fy(this.f16536a.entrySet().iterator());
        }
        return this.f16536a.entrySet().iterator();
    }

    /* renamed from: e */
    final Iterator<Entry<FieldDescriptorType, Object>> m20539e() {
        if (this.f16538c) {
            return new fy(this.f16536a.m20755e().iterator());
        }
        return this.f16536a.m20755e().iterator();
    }

    /* renamed from: a */
    private final Object m20526a(FieldDescriptorType fieldDescriptorType) {
        fieldDescriptorType = this.f16536a.get(fieldDescriptorType);
        return fieldDescriptorType instanceof fv ? fv.m31598a() : fieldDescriptorType;
    }

    /* renamed from: b */
    private final void m20532b(FieldDescriptorType fieldDescriptorType, Object obj) {
        if (!fieldDescriptorType.m20547d()) {
            fa.m20529a(fieldDescriptorType.m20545b(), obj);
        } else if (obj instanceof List) {
            List arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = (ArrayList) arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                fa.m20529a(fieldDescriptorType.m20545b(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof fv) {
            this.f16538c = true;
        }
        this.f16536a.m20749a((Comparable) fieldDescriptorType, obj);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static void m20529a(com.google.android.gms.internal.p210i.ir r2, java.lang.Object r3) {
        /*
        com.google.android.gms.internal.p210i.fm.m20556a(r3);
        r0 = com.google.android.gms.internal.p210i.fb.f16539a;
        r2 = r2.m20888a();
        r2 = r2.ordinal();
        r2 = r0[r2];
        r0 = 1;
        r1 = 0;
        switch(r2) {
            case 1: goto L_0x0040;
            case 2: goto L_0x003d;
            case 3: goto L_0x003a;
            case 4: goto L_0x0037;
            case 5: goto L_0x0034;
            case 6: goto L_0x0031;
            case 7: goto L_0x0028;
            case 8: goto L_0x001e;
            case 9: goto L_0x0015;
            default: goto L_0x0014;
        };
    L_0x0014:
        goto L_0x0043;
    L_0x0015:
        r2 = r3 instanceof com.google.android.gms.internal.p210i.gt;
        if (r2 != 0) goto L_0x0026;
    L_0x0019:
        r2 = r3 instanceof com.google.android.gms.internal.p210i.fv;
        if (r2 == 0) goto L_0x0043;
    L_0x001d:
        goto L_0x0026;
    L_0x001e:
        r2 = r3 instanceof java.lang.Integer;
        if (r2 != 0) goto L_0x0026;
    L_0x0022:
        r2 = r3 instanceof com.google.android.gms.internal.p210i.fn;
        if (r2 == 0) goto L_0x0043;
    L_0x0026:
        r1 = 1;
        goto L_0x0043;
    L_0x0028:
        r2 = r3 instanceof com.google.android.gms.internal.p210i.dy;
        if (r2 != 0) goto L_0x0026;
    L_0x002c:
        r2 = r3 instanceof byte[];
        if (r2 == 0) goto L_0x0043;
    L_0x0030:
        goto L_0x0026;
    L_0x0031:
        r0 = r3 instanceof java.lang.String;
        goto L_0x0042;
    L_0x0034:
        r0 = r3 instanceof java.lang.Boolean;
        goto L_0x0042;
    L_0x0037:
        r0 = r3 instanceof java.lang.Double;
        goto L_0x0042;
    L_0x003a:
        r0 = r3 instanceof java.lang.Float;
        goto L_0x0042;
    L_0x003d:
        r0 = r3 instanceof java.lang.Long;
        goto L_0x0042;
    L_0x0040:
        r0 = r3 instanceof java.lang.Integer;
    L_0x0042:
        r1 = r0;
    L_0x0043:
        if (r1 == 0) goto L_0x0046;
    L_0x0045:
        return;
    L_0x0046:
        r2 = new java.lang.IllegalArgumentException;
        r3 = "Wrong object type used with protocol message reflection.";
        r2.<init>(r3);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.fa.a(com.google.android.gms.internal.i.ir, java.lang.Object):void");
    }

    /* renamed from: f */
    public final boolean m20540f() {
        for (int i = 0; i < this.f16536a.m20753c(); i++) {
            if (!fa.m20530a(this.f16536a.m20751b(i))) {
                return false;
            }
        }
        for (Entry a : this.f16536a.m20754d()) {
            if (!fa.m20530a(a)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m20530a(Entry<FieldDescriptorType, Object> entry) {
        fc fcVar = (fc) entry.getKey();
        if (fcVar.m20546c() == iw.MESSAGE) {
            if (fcVar.m20547d()) {
                for (gt p : (List) entry.getValue()) {
                    if (!p.mo6731p()) {
                        return false;
                    }
                }
            }
            entry = entry.getValue();
            if (entry instanceof gt) {
                if (((gt) entry).mo6731p() == null) {
                    return false;
                }
            } else if ((entry instanceof fv) != null) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    /* renamed from: a */
    public final void m20535a(fa<FieldDescriptorType> faVar) {
        for (int i = 0; i < faVar.f16536a.m20753c(); i++) {
            m20533b(faVar.f16536a.m20751b(i));
        }
        for (FieldDescriptorType b : faVar.f16536a.m20754d()) {
            m20533b(b);
        }
    }

    /* renamed from: a */
    private static Object m20527a(Object obj) {
        if (obj instanceof gz) {
            return ((gz) obj).m37973a();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        Object obj2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, obj2, 0, bArr.length);
        return obj2;
    }

    /* renamed from: b */
    private final void m20533b(Entry<FieldDescriptorType, Object> entry) {
        Comparable comparable = (fc) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof fv) {
            value = fv.m31598a();
        }
        Object a;
        if (comparable.m20547d()) {
            a = m20526a((fc) comparable);
            if (a == null) {
                a = new ArrayList();
            }
            for (Object a2 : (List) value) {
                ((List) a).add(fa.m20527a(a2));
            }
            this.f16536a.m20749a(comparable, a);
        } else if (comparable.m20546c() == iw.MESSAGE) {
            a = m20526a((fc) comparable);
            if (a == null) {
                this.f16536a.m20749a(comparable, fa.m20527a(value));
                return;
            }
            if (a instanceof gz) {
                value = comparable.m20544a((gz) a, (gz) value);
            } else {
                value = comparable.m20543a(((gt) a).mo6737t(), (gt) value).mo6730e();
            }
            this.f16536a.m20749a(comparable, value);
        } else {
            this.f16536a.m20749a(comparable, fa.m20527a(value));
        }
    }

    /* renamed from: a */
    static void m20528a(eq eqVar, ir irVar, int i, Object obj) {
        if (irVar == ir.GROUP) {
            gt gtVar = (gt) obj;
            fm.m20559a(gtVar);
            eqVar.mo6172a(i, 3);
            gtVar.mo6734a(eqVar);
            eqVar.mo6172a(i, 4);
            return;
        }
        eqVar.mo6172a(i, irVar.m20889b());
        switch (fb.f16540b[irVar.ordinal()]) {
            case 1:
                eqVar.m31487a(((Double) obj).doubleValue());
                return;
            case 2:
                eqVar.m31488a(((Float) obj).floatValue());
                return;
            case 3:
                eqVar.mo6179a(((Long) obj).longValue());
                return;
            case 4:
                eqVar.mo6179a(((Long) obj).longValue());
                return;
            case 5:
                eqVar.mo6171a(((Integer) obj).intValue());
                return;
            case 6:
                eqVar.mo6193c(((Long) obj).longValue());
                return;
            case 7:
                eqVar.mo6195d(((Integer) obj).intValue());
                return;
            case 8:
                eqVar.m31505a(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((gt) obj).mo6734a(eqVar);
                return;
            case 10:
                eqVar.mo6181a((gt) obj);
                return;
            case 11:
                if ((obj instanceof dy) != null) {
                    eqVar.mo6180a((dy) obj);
                    return;
                } else {
                    eqVar.mo6183a((String) obj);
                    return;
                }
            case 12:
                if ((obj instanceof dy) != null) {
                    eqVar.mo6180a((dy) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                eqVar.mo6194c(bArr, (int) null, bArr.length);
                return;
            case 13:
                eqVar.mo6186b(((Integer) obj).intValue());
                return;
            case 14:
                eqVar.mo6195d(((Integer) obj).intValue());
                return;
            case 15:
                eqVar.mo6193c(((Long) obj).longValue());
                return;
            case 16:
                eqVar.m31514c(((Integer) obj).intValue());
                return;
            case 17:
                eqVar.m31512b(((Long) obj).longValue());
                return;
            case 18:
                if ((obj instanceof fn) == null) {
                    eqVar.mo6171a(((Integer) obj).intValue());
                    break;
                } else {
                    eqVar.mo6171a(((fn) obj).mo4414a());
                    return;
                }
            default:
                break;
        }
    }

    /* renamed from: g */
    public final int m20541g() {
        int i = 0;
        for (int i2 = 0; i2 < this.f16536a.m20753c(); i2++) {
            i += fa.m20534c(this.f16536a.m20751b(i2));
        }
        for (Entry c : this.f16536a.m20754d()) {
            i += fa.m20534c(c);
        }
        return i;
    }

    /* renamed from: c */
    private static int m20534c(Entry<FieldDescriptorType, Object> entry) {
        fc fcVar = (fc) entry.getKey();
        Object value = entry.getValue();
        if (fcVar.m20546c() != iw.MESSAGE || fcVar.m20547d() || fcVar.m20548e()) {
            return fa.m20523a(fcVar, value);
        }
        if (value instanceof fv) {
            return eq.m31442b(((fc) entry.getKey()).m20542a(), (fv) value);
        }
        return eq.m31459d(((fc) entry.getKey()).m20542a(), (gt) value);
    }

    /* renamed from: a */
    static int m20524a(ir irVar, int i, Object obj) {
        i = eq.m31461e(i);
        if (irVar == ir.GROUP) {
            fm.m20559a((gt) obj);
            i <<= 1;
        }
        return i + fa.m20531b(irVar, obj);
    }

    /* renamed from: b */
    private static int m20531b(ir irVar, Object obj) {
        switch (fb.f16540b[irVar.ordinal()]) {
            case 1:
                return eq.m31438b(((Double) obj).doubleValue());
            case 2:
                return eq.m31439b(((Float) obj).floatValue());
            case 3:
                return eq.m31460d(((Long) obj).longValue());
            case 4:
                return eq.m31463e(((Long) obj).longValue());
            case 5:
                return eq.m31464f(((Integer) obj).intValue());
            case 6:
                return eq.m31471g(((Long) obj).longValue());
            case 7:
                return eq.m31476i(((Integer) obj).intValue());
            case 8:
                return eq.m31450b(((Boolean) obj).booleanValue());
            case 9:
                return eq.m31455c((gt) obj);
            case 10:
                if ((obj instanceof fv) != null) {
                    return eq.m31435a((fv) obj);
                }
                return eq.m31447b((gt) obj);
            case 11:
                if ((obj instanceof dy) != null) {
                    return eq.m31446b((dy) obj);
                }
                return eq.m31449b((String) obj);
            case 12:
                if ((obj instanceof dy) != null) {
                    return eq.m31446b((dy) obj);
                }
                return eq.m31451b((byte[]) obj);
            case 13:
                return eq.m31468g(((Integer) obj).intValue());
            case 14:
                return eq.m31479j(((Integer) obj).intValue());
            case 15:
                return eq.m31475h(((Long) obj).longValue());
            case 16:
                return eq.m31472h(((Integer) obj).intValue());
            case 17:
                return eq.m31467f(((Long) obj).longValue());
            case 18:
                if ((obj instanceof fn) != null) {
                    return eq.m31481k(((fn) obj).mo4414a());
                }
                return eq.m31481k(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* renamed from: a */
    public static int m20523a(fc<?> fcVar, Object obj) {
        ir b = fcVar.m20545b();
        int a = fcVar.m20542a();
        if (!fcVar.m20547d()) {
            return fa.m20524a(b, a, obj);
        }
        int i = 0;
        if (fcVar.m20548e() != null) {
            for (Object obj2 : (List) obj2) {
                i += fa.m20531b(b, obj2);
            }
            return (eq.m31461e(a) + i) + eq.m31483l(i);
        }
        for (Object obj22 : (List) obj22) {
            i += fa.m20524a(b, a, obj22);
        }
        return i;
    }

    public final /* synthetic */ Object clone() {
        fa faVar = new fa();
        for (int i = 0; i < this.f16536a.m20753c(); i++) {
            Entry b = this.f16536a.m20751b(i);
            faVar.m20532b((fc) b.getKey(), b.getValue());
        }
        for (Entry b2 : this.f16536a.m20754d()) {
            faVar.m20532b((fc) b2.getKey(), b2.getValue());
        }
        faVar.f16538c = this.f16538c;
        return faVar;
    }
}
