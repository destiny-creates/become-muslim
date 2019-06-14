package com.google.android.gms.internal.p210i;

import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.internal.i.gp */
final class gp implements go {
    gp() {
    }

    /* renamed from: a */
    public final Map<?, ?> mo4562a(Object obj) {
        return (gn) obj;
    }

    /* renamed from: f */
    public final gm<?, ?> mo4567f(Object obj) {
        throw new NoSuchMethodError();
    }

    /* renamed from: b */
    public final Map<?, ?> mo4563b(Object obj) {
        return (gn) obj;
    }

    /* renamed from: c */
    public final boolean mo4564c(Object obj) {
        return ((gn) obj).m20600d() == null ? true : null;
    }

    /* renamed from: d */
    public final Object mo4565d(Object obj) {
        ((gn) obj).m20599c();
        return obj;
    }

    /* renamed from: e */
    public final Object mo4566e(Object obj) {
        return gn.m20595a().m20598b();
    }

    /* renamed from: a */
    public final Object mo4561a(Object obj, Object obj2) {
        obj = (gn) obj;
        gn gnVar = (gn) obj2;
        if (!gnVar.isEmpty()) {
            if (!obj.m20600d()) {
                obj = obj.m20598b();
            }
            obj.m20597a(gnVar);
        }
        return obj;
    }

    /* renamed from: a */
    public final int mo4560a(int i, Object obj, Object obj2) {
        gn gnVar = (gn) obj;
        if (gnVar.isEmpty() != 0) {
            return 0;
        }
        i = gnVar.entrySet().iterator();
        if (i.hasNext() == null) {
            return 0;
        }
        Entry entry = (Entry) i.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
