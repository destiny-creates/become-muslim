package com.polidea.reactnativeble.p269e;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import p289e.C5989l;

/* compiled from: DisposableMap */
/* renamed from: com.polidea.reactnativeble.e.b */
public class C5642b {
    /* renamed from: a */
    private final Map<String, C5989l> f18878a = new HashMap();

    /* renamed from: a */
    public synchronized void m23972a(String str, C5989l c5989l) {
        C5989l c5989l2 = (C5989l) this.f18878a.put(str, c5989l);
        if (c5989l2 != null && c5989l2.mo5121b() == null) {
            c5989l2.U_();
        }
    }

    /* renamed from: a */
    public synchronized boolean m23973a(String str) {
        C5989l c5989l = (C5989l) this.f18878a.remove(str);
        if (c5989l == null) {
            return null;
        }
        if (!c5989l.mo5121b()) {
            c5989l.U_();
        }
        return true;
    }

    /* renamed from: a */
    public synchronized void m23971a() {
        Iterator it = this.f18878a.entrySet().iterator();
        while (it.hasNext()) {
            C5989l c5989l = (C5989l) ((Entry) it.next()).getValue();
            it.remove();
            if (!c5989l.mo5121b()) {
                c5989l.U_();
            }
        }
    }
}
