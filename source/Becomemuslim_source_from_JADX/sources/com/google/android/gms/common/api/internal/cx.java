package com.google.android.gms.common.api.internal;

import android.support.v4.util.C3211a;
import android.util.Log;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.C2783c;
import com.google.android.gms.p186f.C2950c;
import com.google.android.gms.p186f.C2954g;
import java.util.Collections;
import java.util.Map;

final class cx implements C2950c<Map<cg<?>, String>> {
    /* renamed from: a */
    private final /* synthetic */ cv f11539a;

    private cx(cv cvVar) {
        this.f11539a = cvVar;
    }

    public final void onComplete(C2954g<Map<cg<?>, String>> c2954g) {
        this.f11539a.f11526f.lock();
        try {
            if (this.f11539a.f11534n) {
                if (c2954g.mo2589b()) {
                    this.f11539a.f11535o = new C3211a(this.f11539a.f11521a.size());
                    c2954g = this.f11539a.f11521a.values().iterator();
                    while (c2954g.hasNext()) {
                        this.f11539a.f11535o.put(((cu) c2954g.next()).m7951g(), C4775b.f13206a);
                    }
                } else if (c2954g.mo2592e() instanceof C2783c) {
                    C2783c c2783c = (C2783c) c2954g.mo2592e();
                    if (this.f11539a.f11532l) {
                        this.f11539a.f11535o = new C3211a(this.f11539a.f11521a.size());
                        for (cu cuVar : this.f11539a.f11521a.values()) {
                            cg g = cuVar.m7951g();
                            C4775b a = c2783c.m7937a(cuVar);
                            if (this.f11539a.m14259a(cuVar, a)) {
                                this.f11539a.f11535o.put(g, new C4775b(16));
                            } else {
                                this.f11539a.f11535o.put(g, a);
                            }
                        }
                    } else {
                        this.f11539a.f11535o = c2783c.m7936a();
                    }
                    this.f11539a.f11538r = this.f11539a.m14277k();
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", c2954g.mo2592e());
                    this.f11539a.f11535o = Collections.emptyMap();
                    this.f11539a.f11538r = new C4775b(8);
                }
                if (this.f11539a.f11536p != null) {
                    this.f11539a.f11535o.putAll(this.f11539a.f11536p);
                    this.f11539a.f11538r = this.f11539a.m14277k();
                }
                if (this.f11539a.f11538r == null) {
                    this.f11539a.m14271g();
                    this.f11539a.m14274j();
                } else {
                    this.f11539a.f11534n = false;
                    this.f11539a.f11525e.mo2405a(this.f11539a.f11538r);
                }
                this.f11539a.f11529i.signalAll();
                this.f11539a.f11526f.unlock();
            }
        } finally {
            this.f11539a.f11526f.unlock();
        }
    }
}
