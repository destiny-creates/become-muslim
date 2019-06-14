package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

@cm
public final class atb {
    /* renamed from: a */
    private final Map<String, ata> f14984a = new HashMap();
    /* renamed from: b */
    private final atc f14985b;

    public atb(atc atc) {
        this.f14985b = atc;
    }

    /* renamed from: a */
    public final atc m18913a() {
        return this.f14985b;
    }

    /* renamed from: a */
    public final void m18914a(String str, ata ata) {
        this.f14984a.put(str, ata);
    }

    /* renamed from: a */
    public final void m18915a(String str, String str2, long j) {
        atc atc = this.f14985b;
        ata ata = (ata) this.f14984a.get(str2);
        String[] strArr = new String[]{str};
        if (atc != null) {
            if (ata != null) {
                atc.m18921a(ata, j, strArr);
            }
        }
        Map map = this.f14984a;
        atc = this.f14985b;
        map.put(str, atc == null ? null : atc.m18917a(j));
    }
}
