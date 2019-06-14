package com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.internal.p105q.p106a.C1496d;
import com.facebook.ads.internal.p111r.C1545a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.adapters.b */
public abstract class C1323b {
    /* renamed from: a */
    protected final C1324c f3848a;
    /* renamed from: b */
    protected final C1545a f3849b;
    /* renamed from: c */
    private final Context f3850c;
    /* renamed from: d */
    private boolean f3851d;

    public C1323b(Context context, C1324c c1324c, C1545a c1545a) {
        this.f3850c = context;
        this.f3848a = c1324c;
        this.f3849b = c1545a;
    }

    /* renamed from: a */
    public final void m4591a() {
        if (!this.f3851d) {
            if (this.f3848a != null) {
                this.f3848a.mo929a();
            }
            Map hashMap = new HashMap();
            if (this.f3849b != null) {
                this.f3849b.m5433a(hashMap);
            }
            mo920a(hashMap);
            this.f3851d = true;
            C1496d.m5271a(this.f3850c, "Impression logged");
            if (this.f3848a != null) {
                this.f3848a.mo965b();
            }
        }
    }

    /* renamed from: a */
    protected abstract void mo920a(Map<String, String> map);
}
