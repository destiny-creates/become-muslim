package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class abi<FieldDescriptorType extends abk<FieldDescriptorType>> {
    /* renamed from: d */
    private static final abi f14156d = new abi(true);
    /* renamed from: a */
    private final adt<FieldDescriptorType, Object> f14157a = adt.m18151a(16);
    /* renamed from: b */
    private boolean f14158b;
    /* renamed from: c */
    private boolean f14159c = false;

    private abi() {
    }

    private abi(boolean z) {
        m17914c();
    }

    /* renamed from: a */
    static int m17900a(aex aex, int i, Object obj) {
        i = aaw.m29617e(i);
        if (aex == aex.GROUP) {
            abs.m17936a((acx) obj);
            i <<= 1;
        }
        return i + m17909b(aex, obj);
    }

    /* renamed from: a */
    public static <T extends abk<T>> abi<T> m17901a() {
        return f14156d;
    }

    /* renamed from: a */
    private final Object m17902a(FieldDescriptorType fieldDescriptorType) {
        Object obj = this.f14157a.get(fieldDescriptorType);
        return obj instanceof abz ? abz.m29732a() : obj;
    }

    /* renamed from: a */
    private static Object m17903a(Object obj) {
        if (obj instanceof adf) {
            return ((adf) obj).m36737a();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        Object obj2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, obj2, 0, bArr.length);
        return obj2;
    }

    /* renamed from: a */
    static void m17904a(aaw aaw, aex aex, int i, Object obj) {
        if (aex == aex.GROUP) {
            acx acx = (acx) obj;
            abs.m17936a(acx);
            aaw.mo6049a(i, 3);
            acx.mo6635a(aaw);
            aaw.mo6049a(i, 4);
            return;
        }
        aaw.mo6049a(i, aex.m18278b());
        switch (abj.f14161b[aex.ordinal()]) {
            case 1:
                aaw.m29643a(((Double) obj).doubleValue());
                break;
            case 2:
                aaw.m29644a(((Float) obj).floatValue());
                return;
            case 3:
                aaw.mo6056a(((Long) obj).longValue());
                return;
            case 4:
                aaw.mo6056a(((Long) obj).longValue());
                return;
            case 5:
                aaw.mo6048a(((Integer) obj).intValue());
                return;
            case 6:
                aaw.mo6067c(((Long) obj).longValue());
                return;
            case 7:
                aaw.mo6069d(((Integer) obj).intValue());
                return;
            case 8:
                aaw.m29660a(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((acx) obj).mo6635a(aaw);
                return;
            case 10:
                aaw.mo6058a((acx) obj);
                return;
            case 11:
                if (obj instanceof aai) {
                    aaw.mo6057a((aai) obj);
                    return;
                } else {
                    aaw.mo6059a((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof aai) {
                    aaw.mo6057a((aai) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                aaw.mo6068c(bArr, 0, bArr.length);
                return;
            case 13:
                aaw.mo6061b(((Integer) obj).intValue());
                return;
            case 14:
                aaw.mo6069d(((Integer) obj).intValue());
                return;
            case 15:
                aaw.mo6067c(((Long) obj).longValue());
                return;
            case 16:
                aaw.m29668c(((Integer) obj).intValue());
                return;
            case 17:
                aaw.m29666b(((Long) obj).longValue());
                return;
            case 18:
                if (!(obj instanceof abt)) {
                    aaw.mo6048a(((Integer) obj).intValue());
                    break;
                } else {
                    aaw.mo6048a(((abt) obj).mo3849a());
                    return;
                }
            default:
                break;
        }
    }

    /* renamed from: a */
    private final void m17905a(FieldDescriptorType fieldDescriptorType, Object obj) {
        if (!fieldDescriptorType.m17926d()) {
            m17906a(fieldDescriptorType.m17924b(), obj);
        } else if (obj instanceof List) {
            List arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = (ArrayList) arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                m17906a(fieldDescriptorType.m17924b(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof abz) {
            this.f14159c = true;
        }
        this.f14157a.m18160a((Comparable) fieldDescriptorType, obj);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static void m17906a(com.google.android.gms.internal.ads.aex r2, java.lang.Object r3) {
        /*
        com.google.android.gms.internal.ads.abs.m17933a(r3);
        r0 = com.google.android.gms.internal.ads.abj.f14160a;
        r2 = r2.m18277a();
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
        r2 = r3 instanceof com.google.android.gms.internal.ads.acx;
        if (r2 != 0) goto L_0x0026;
    L_0x0019:
        r2 = r3 instanceof com.google.android.gms.internal.ads.abz;
        if (r2 == 0) goto L_0x0043;
    L_0x001d:
        goto L_0x0026;
    L_0x001e:
        r2 = r3 instanceof java.lang.Integer;
        if (r2 != 0) goto L_0x0026;
    L_0x0022:
        r2 = r3 instanceof com.google.android.gms.internal.ads.abt;
        if (r2 == 0) goto L_0x0043;
    L_0x0026:
        r1 = 1;
        goto L_0x0043;
    L_0x0028:
        r2 = r3 instanceof com.google.android.gms.internal.ads.aai;
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.abi.a(com.google.android.gms.internal.ads.aex, java.lang.Object):void");
    }

    /* renamed from: a */
    private static boolean m17907a(Entry<FieldDescriptorType, Object> entry) {
        abk abk = (abk) entry.getKey();
        if (abk.m17925c() == afc.MESSAGE) {
            if (abk.m17926d()) {
                for (acx k : (List) entry.getValue()) {
                    if (!k.mo6632k()) {
                        return false;
                    }
                }
            }
            Object value = entry.getValue();
            if (value instanceof acx) {
                if (!((acx) value).mo6632k()) {
                    return false;
                }
            } else if (value instanceof abz) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    /* renamed from: b */
    private static int m17908b(abk<?> abk, Object obj) {
        aex b = abk.m17924b();
        int a = abk.m17921a();
        if (!abk.m17926d()) {
            return m17900a(b, a, obj);
        }
        int i = 0;
        if (abk.m17927e()) {
            for (Object obj2 : (List) obj2) {
                i += m17909b(b, obj2);
            }
            return (aaw.m29617e(a) + i) + aaw.m29639l(i);
        }
        for (Object obj22 : (List) obj22) {
            i += m17900a(b, a, obj22);
        }
        return i;
    }

    /* renamed from: b */
    private static int m17909b(aex aex, Object obj) {
        switch (abj.f14161b[aex.ordinal()]) {
            case 1:
                return aaw.m29596b(((Double) obj).doubleValue());
            case 2:
                return aaw.m29597b(((Float) obj).floatValue());
            case 3:
                return aaw.m29616d(((Long) obj).longValue());
            case 4:
                return aaw.m29619e(((Long) obj).longValue());
            case 5:
                return aaw.m29620f(((Integer) obj).intValue());
            case 6:
                return aaw.m29627g(((Long) obj).longValue());
            case 7:
                return aaw.m29632i(((Integer) obj).intValue());
            case 8:
                return aaw.m29608b(((Boolean) obj).booleanValue());
            case 9:
                return aaw.m29612c((acx) obj);
            case 10:
                return obj instanceof abz ? aaw.m29593a((abz) obj) : aaw.m29606b((acx) obj);
            case 11:
                return obj instanceof aai ? aaw.m29605b((aai) obj) : aaw.m29607b((String) obj);
            case 12:
                return obj instanceof aai ? aaw.m29605b((aai) obj) : aaw.m29609b((byte[]) obj);
            case 13:
                return aaw.m29624g(((Integer) obj).intValue());
            case 14:
                return aaw.m29635j(((Integer) obj).intValue());
            case 15:
                return aaw.m29631h(((Long) obj).longValue());
            case 16:
                return aaw.m29628h(((Integer) obj).intValue());
            case 17:
                return aaw.m29623f(((Long) obj).longValue());
            case 18:
                return obj instanceof abt ? aaw.m29637k(((abt) obj).mo3849a()) : aaw.m29637k(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* renamed from: b */
    private final void m17910b(Entry<FieldDescriptorType, Object> entry) {
        Comparable comparable = (abk) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof abz) {
            value = abz.m29732a();
        }
        Object a;
        if (comparable.m17926d()) {
            a = m17902a((abk) comparable);
            if (a == null) {
                a = new ArrayList();
            }
            for (Object a2 : (List) value) {
                ((List) a).add(m17903a(a2));
            }
            this.f14157a.m18160a(comparable, a);
        } else if (comparable.m17925c() == afc.MESSAGE) {
            a = m17902a((abk) comparable);
            if (a == null) {
                this.f14157a.m18160a(comparable, m17903a(value));
            } else {
                this.f14157a.m18160a(comparable, a instanceof adf ? comparable.m17923a((adf) a, (adf) value) : comparable.m17922a(((acx) a).mo6638n(), (acx) value).mo6631e());
            }
        } else {
            this.f14157a.m18160a(comparable, m17903a(value));
        }
    }

    /* renamed from: c */
    private static int m17911c(Entry<FieldDescriptorType, Object> entry) {
        abk abk = (abk) entry.getKey();
        Object value = entry.getValue();
        return (abk.m17925c() != afc.MESSAGE || abk.m17926d() || abk.m17927e()) ? m17908b(abk, value) : value instanceof abz ? aaw.m29600b(((abk) entry.getKey()).m17921a(), (abz) value) : aaw.m29601b(((abk) entry.getKey()).m17921a(), (acx) value);
    }

    /* renamed from: a */
    public final void m17912a(abi<FieldDescriptorType> abi) {
        for (int i = 0; i < abi.f14157a.m18164c(); i++) {
            m17910b(abi.f14157a.m18162b(i));
        }
        for (Entry b : abi.f14157a.m18165d()) {
            m17910b(b);
        }
    }

    /* renamed from: b */
    final boolean m17913b() {
        return this.f14157a.isEmpty();
    }

    /* renamed from: c */
    public final void m17914c() {
        if (!this.f14158b) {
            this.f14157a.mo3767a();
            this.f14158b = true;
        }
    }

    public final /* synthetic */ Object clone() {
        abi abi = new abi();
        for (int i = 0; i < this.f14157a.m18164c(); i++) {
            Entry b = this.f14157a.m18162b(i);
            abi.m17905a((abk) b.getKey(), b.getValue());
        }
        for (Entry b2 : this.f14157a.m18165d()) {
            abi.m17905a((abk) b2.getKey(), b2.getValue());
        }
        abi.f14159c = this.f14159c;
        return abi;
    }

    /* renamed from: d */
    public final boolean m17915d() {
        return this.f14158b;
    }

    /* renamed from: e */
    public final Iterator<Entry<FieldDescriptorType, Object>> m17916e() {
        return this.f14159c ? new acd(this.f14157a.entrySet().iterator()) : this.f14157a.entrySet().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof abi)) {
            return false;
        }
        return this.f14157a.equals(((abi) obj).f14157a);
    }

    /* renamed from: f */
    final Iterator<Entry<FieldDescriptorType, Object>> m17917f() {
        return this.f14159c ? new acd(this.f14157a.m18166e().iterator()) : this.f14157a.m18166e().iterator();
    }

    /* renamed from: g */
    public final boolean m17918g() {
        for (int i = 0; i < this.f14157a.m18164c(); i++) {
            if (!m17907a(this.f14157a.m18162b(i))) {
                return false;
            }
        }
        for (Entry a : this.f14157a.m18165d()) {
            if (!m17907a(a)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: h */
    public final int m17919h() {
        int i = 0;
        for (int i2 = 0; i2 < this.f14157a.m18164c(); i2++) {
            Entry b = this.f14157a.m18162b(i2);
            i += m17908b((abk) b.getKey(), b.getValue());
        }
        for (Entry b2 : this.f14157a.m18165d()) {
            i += m17908b((abk) b2.getKey(), b2.getValue());
        }
        return i;
    }

    public final int hashCode() {
        return this.f14157a.hashCode();
    }

    /* renamed from: i */
    public final int m17920i() {
        int i = 0;
        for (int i2 = 0; i2 < this.f14157a.m18164c(); i2++) {
            i += m17911c(this.f14157a.m18162b(i2));
        }
        for (Entry c : this.f14157a.m18165d()) {
            i += m17911c(c);
        }
        return i;
    }
}
