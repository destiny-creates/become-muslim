package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

final class act implements acs {
    act() {
    }

    /* renamed from: a */
    public final int mo3745a(int i, Object obj, Object obj2) {
        acr acr = (acr) obj;
        if (acr.isEmpty()) {
            return 0;
        }
        Iterator it = acr.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Entry entry = (Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    /* renamed from: a */
    public final Object mo3746a(Object obj, Object obj2) {
        obj = (acr) obj;
        acr acr = (acr) obj2;
        if (!acr.isEmpty()) {
            if (!obj.m17980d()) {
                obj = obj.m17978b();
            }
            obj.m17977a(acr);
        }
        return obj;
    }

    /* renamed from: a */
    public final Map<?, ?> mo3747a(Object obj) {
        return (acr) obj;
    }

    /* renamed from: b */
    public final Map<?, ?> mo3748b(Object obj) {
        return (acr) obj;
    }

    /* renamed from: c */
    public final boolean mo3749c(Object obj) {
        return !((acr) obj).m17980d();
    }

    /* renamed from: d */
    public final Object mo3750d(Object obj) {
        ((acr) obj).m17979c();
        return obj;
    }

    /* renamed from: e */
    public final Object mo3751e(Object obj) {
        return acr.m17975a().m17978b();
    }

    /* renamed from: f */
    public final acq<?, ?> mo3752f(Object obj) {
        throw new NoSuchMethodError();
    }
}
