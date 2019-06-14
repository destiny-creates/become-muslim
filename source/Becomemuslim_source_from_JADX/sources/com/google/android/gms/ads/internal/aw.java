package com.google.android.gms.ads.internal;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.aoq;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.asp;
import com.google.android.gms.internal.ads.mv;
import java.util.Map;
import java.util.TreeMap;

final class aw {
    /* renamed from: a */
    private final String f6733a;
    /* renamed from: b */
    private final Map<String, String> f6734b = new TreeMap();
    /* renamed from: c */
    private String f6735c;
    /* renamed from: d */
    private String f6736d;

    public aw(String str) {
        this.f6733a = str;
    }

    /* renamed from: a */
    public final String m7449a() {
        return this.f6736d;
    }

    /* renamed from: a */
    public final void m7450a(aoq aoq, mv mvVar) {
        this.f6735c = aoq.f28270j.f28300a;
        Bundle bundle = aoq.f28273m != null ? aoq.f28273m.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle != null) {
            String str = (String) aph.f().a(asp.cy);
            for (String str2 : bundle.keySet()) {
                if (str.equals(str2)) {
                    this.f6736d = bundle.getString(str2);
                } else if (str2.startsWith("csa_")) {
                    this.f6734b.put(str2.substring(4), bundle.getString(str2));
                }
            }
            this.f6734b.put("SDKVersion", mvVar.f28709a);
        }
    }

    /* renamed from: b */
    public final String m7451b() {
        return this.f6735c;
    }

    /* renamed from: c */
    public final String m7452c() {
        return this.f6733a;
    }

    /* renamed from: d */
    public final Map<String, String> m7453d() {
        return this.f6734b;
    }
}
