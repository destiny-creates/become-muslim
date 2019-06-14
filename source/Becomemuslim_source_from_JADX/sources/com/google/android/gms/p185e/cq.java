package com.google.android.gms.p185e;

import com.google.android.gms.internal.p210i.ab;
import com.google.android.gms.internal.p210i.ct;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.e.cq */
public abstract class cq extends aq {
    /* renamed from: a */
    private static final String f11666a = ab.f16318f.toString();
    /* renamed from: b */
    private static final String f11667b = ab.f16319g.toString();

    public cq(String str) {
        super(str, f11666a, f11667b);
    }

    /* renamed from: a */
    public final boolean mo2507a() {
        return true;
    }

    /* renamed from: a */
    protected abstract boolean mo3298a(ct ctVar, ct ctVar2, Map<String, ct> map);

    /* renamed from: a */
    public final ct mo2506a(Map<String, ct> map) {
        Iterator it = map.values().iterator();
        do {
            boolean z = false;
            if (!it.hasNext()) {
                ct ctVar = (ct) map.get(f11666a);
                ct ctVar2 = (ct) map.get(f11667b);
                if (ctVar != null) {
                    if (ctVar2 != null) {
                        z = mo3298a(ctVar, ctVar2, map);
                    }
                }
                return eu.m8716a(Boolean.valueOf(z));
            }
        } while (((ct) it.next()) != eu.m8736g());
        return eu.m8716a(Boolean.valueOf(false));
    }

    /* renamed from: c */
    public final /* bridge */ /* synthetic */ Set mo2513c() {
        return super.mo2513c();
    }

    /* renamed from: b */
    public final /* bridge */ /* synthetic */ String mo2512b() {
        return super.mo2512b();
    }
}
