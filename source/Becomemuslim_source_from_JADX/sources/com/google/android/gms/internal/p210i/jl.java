package com.google.android.gms.internal.p210i;

import android.text.TextUtils;
import com.google.android.gms.analytics.C2716q;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.i.jl */
public final class jl extends C2716q<jl> {
    /* renamed from: a */
    public int f24538a;
    /* renamed from: b */
    public int f24539b;
    /* renamed from: c */
    public int f24540c;
    /* renamed from: d */
    public int f24541d;
    /* renamed from: e */
    public int f24542e;
    /* renamed from: f */
    private String f24543f;

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("language", this.f24543f);
        hashMap.put("screenColors", Integer.valueOf(this.f24538a));
        hashMap.put("screenWidth", Integer.valueOf(this.f24539b));
        hashMap.put("screenHeight", Integer.valueOf(this.f24540c));
        hashMap.put("viewportWidth", Integer.valueOf(this.f24541d));
        hashMap.put("viewportHeight", Integer.valueOf(this.f24542e));
        return jl.a(hashMap);
    }

    /* renamed from: a */
    public final String m31768a() {
        return this.f24543f;
    }

    /* renamed from: a */
    public final void m31770a(String str) {
        this.f24543f = str;
    }

    /* renamed from: a */
    public final /* synthetic */ void m31769a(C2716q c2716q) {
        jl jlVar = (jl) c2716q;
        if (this.f24538a != 0) {
            jlVar.f24538a = this.f24538a;
        }
        if (this.f24539b != 0) {
            jlVar.f24539b = this.f24539b;
        }
        if (this.f24540c != 0) {
            jlVar.f24540c = this.f24540c;
        }
        if (this.f24541d != 0) {
            jlVar.f24541d = this.f24541d;
        }
        if (this.f24542e != 0) {
            jlVar.f24542e = this.f24542e;
        }
        if (!TextUtils.isEmpty(this.f24543f)) {
            jlVar.f24543f = this.f24543f;
        }
    }
}
