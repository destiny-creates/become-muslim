package com.facebook.ads.internal.p085a;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.ads.internal.p098m.C1412c;
import com.facebook.ads.internal.p105q.p106a.C1496d;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.a.h */
public abstract class C3545h extends C1297b {
    /* renamed from: d */
    protected final C1304l f9462d;

    public C3545h(Context context, C1412c c1412c, String str, C1304l c1304l) {
        super(context, c1412c, str);
        this.f9462d = c1304l;
    }

    /* renamed from: a */
    protected final void m11492a(Map<String, String> map, C1296a c1296a) {
        if (!TextUtils.isEmpty(this.c)) {
            if (this instanceof C4556f) {
                this.b.mo953h(this.c, map);
            } else {
                this.b.mo948c(this.c, map);
            }
            boolean a = C1296a.m4441a(c1296a);
            if (this.f9462d != null) {
                this.f9462d.m4461a(c1296a);
                if (a) {
                    this.f9462d.m4460a();
                }
            } else {
                Map hashMap = new HashMap();
                hashMap.put("leave_time", Long.toString(-1));
                hashMap.put("back_time", Long.toString(-1));
                hashMap.put("outcome", C1296a.CANNOT_TRACK.name());
                this.b.mo955j(this.c, hashMap);
            }
        }
        C1496d.m5271a(this.a, "Click logged");
    }

    /* renamed from: b */
    public final void mo917b() {
        if (this.f9462d != null) {
            this.f9462d.m4462a(this.c);
        }
        mo2815e();
    }

    /* renamed from: e */
    abstract void mo2815e();
}
