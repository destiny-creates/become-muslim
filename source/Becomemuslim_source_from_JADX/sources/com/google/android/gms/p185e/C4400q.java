package com.google.android.gms.p185e;

import com.google.android.gms.internal.p210i.C4992a;
import com.google.android.gms.internal.p210i.ab;
import com.google.android.gms.internal.p210i.ct;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.google.android.gms.e.q */
final class C4400q extends aq {
    /* renamed from: a */
    private static final String f11744a = C4992a.f16269k.toString();
    /* renamed from: b */
    private static final String f11745b = ab.f16330r.toString();
    /* renamed from: c */
    private static final String f11746c = ab.f16313b.toString();
    /* renamed from: d */
    private final C2943r f11747d;

    public C4400q(C2943r c2943r) {
        super(f11744a, f11745b);
        this.f11747d = c2943r;
    }

    /* renamed from: a */
    public final boolean mo2507a() {
        return false;
    }

    /* renamed from: a */
    public final ct mo2506a(Map<String, ct> map) {
        String a = eu.m8719a((ct) map.get(f11745b));
        Map hashMap = new HashMap();
        ct ctVar = (ct) map.get(f11746c);
        if (ctVar != null) {
            map = eu.m8734f(ctVar);
            if (map instanceof Map) {
                map = map.entrySet().iterator();
                while (map.hasNext()) {
                    Entry entry = (Entry) map.next();
                    hashMap.put(entry.getKey().toString(), entry.getValue());
                }
            } else {
                bs.m8584b("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return eu.m8736g();
            }
        }
        try {
            return eu.m8716a(this.f11747d.mo2495a(a, hashMap));
        } catch (Map<String, ct> map2) {
            map2 = map2.getMessage();
            StringBuilder stringBuilder = new StringBuilder((String.valueOf(a).length() + 34) + String.valueOf(map2).length());
            stringBuilder.append("Custom macro/tag ");
            stringBuilder.append(a);
            stringBuilder.append(" threw exception ");
            stringBuilder.append(map2);
            bs.m8584b(stringBuilder.toString());
            return eu.m8736g();
        }
    }
}
