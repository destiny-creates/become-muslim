package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.abq.C8281c;
import java.util.Map.Entry;

final class abg extends abf<Object> {
    abg() {
    }

    /* renamed from: a */
    final int mo3726a(Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* renamed from: a */
    final abi<Object> mo3727a(Object obj) {
        return ((C8281c) obj).zzdtz;
    }

    /* renamed from: a */
    final Object mo3728a(abd abd, acx acx, int i) {
        return abd.m17885a(acx, i);
    }

    /* renamed from: a */
    final <UT, UB> UB mo3729a(adp adp, Object obj, abd abd, abi<Object> abi, UB ub, aej<UT, UB> aej) {
        throw new NoSuchMethodError();
    }

    /* renamed from: a */
    final void mo3730a(aai aai, Object obj, abd abd, abi<Object> abi) {
        throw new NoSuchMethodError();
    }

    /* renamed from: a */
    final void mo3731a(adp adp, Object obj, abd abd, abi<Object> abi) {
        throw new NoSuchMethodError();
    }

    /* renamed from: a */
    final void mo3732a(afd afd, Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* renamed from: a */
    final void mo3733a(Object obj, abi<Object> abi) {
        ((C8281c) obj).zzdtz = abi;
    }

    /* renamed from: a */
    final boolean mo3734a(acx acx) {
        return acx instanceof C8281c;
    }

    /* renamed from: b */
    final abi<Object> mo3735b(Object obj) {
        abi<Object> a = mo3727a(obj);
        if (!a.m17915d()) {
            return a;
        }
        abi abi = (abi) a.clone();
        mo3733a(obj, abi);
        return abi;
    }

    /* renamed from: c */
    final void mo3736c(Object obj) {
        mo3727a(obj).m17914c();
    }
}
