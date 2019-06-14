package com.google.android.gms.common.api.internal;

import android.support.v4.util.C3211a;
import android.util.Log;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.C2783c;
import com.google.android.gms.p186f.C2950c;
import com.google.android.gms.p186f.C2954g;
import java.util.Collections;
import java.util.Map;

/* renamed from: com.google.android.gms.common.api.internal.r */
final class C4351r implements C2950c<Map<cg<?>, String>> {
    /* renamed from: a */
    private C2807l f11551a;
    /* renamed from: b */
    private final /* synthetic */ cv f11552b;

    C4351r(cv cvVar, C2807l c2807l) {
        this.f11552b = cvVar;
        this.f11551a = c2807l;
    }

    /* renamed from: a */
    final void m14306a() {
        this.f11551a.mo3270v();
    }

    public final void onComplete(C2954g<Map<cg<?>, String>> c2954g) {
        this.f11552b.f11526f.lock();
        try {
            if (this.f11552b.f11534n) {
                if (c2954g.mo2589b()) {
                    this.f11552b.f11536p = new C3211a(this.f11552b.f11522b.size());
                    c2954g = this.f11552b.f11522b.values().iterator();
                    while (c2954g.hasNext()) {
                        this.f11552b.f11536p.put(((cu) c2954g.next()).m7951g(), C4775b.f13206a);
                    }
                } else if (c2954g.mo2592e() instanceof C2783c) {
                    C2783c c2783c = (C2783c) c2954g.mo2592e();
                    if (this.f11552b.f11532l) {
                        this.f11552b.f11536p = new C3211a(this.f11552b.f11522b.size());
                        for (cu cuVar : this.f11552b.f11522b.values()) {
                            cg g = cuVar.m7951g();
                            C4775b a = c2783c.m7937a(cuVar);
                            if (this.f11552b.m14259a(cuVar, a)) {
                                this.f11552b.f11536p.put(g, new C4775b(16));
                            } else {
                                this.f11552b.f11536p.put(g, a);
                            }
                        }
                    } else {
                        this.f11552b.f11536p = c2783c.m7936a();
                    }
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", c2954g.mo2592e());
                    this.f11552b.f11536p = Collections.emptyMap();
                }
                if (this.f11552b.mo2443f() != null) {
                    this.f11552b.f11535o.putAll(this.f11552b.f11536p);
                    if (this.f11552b.m14277k() == null) {
                        this.f11552b.m14271g();
                        this.f11552b.m14274j();
                        this.f11552b.f11529i.signalAll();
                    }
                }
                this.f11551a.mo3270v();
                this.f11552b.f11526f.unlock();
                return;
            }
            this.f11551a.mo3270v();
        } finally {
            this.f11552b.f11526f.unlock();
        }
    }
}
