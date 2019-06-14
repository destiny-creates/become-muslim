package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.atu;
import com.google.android.gms.internal.ads.atw;
import com.google.android.gms.internal.ads.aui;
import com.google.android.gms.internal.ads.jn;
import java.util.List;

final class ah implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ aui f6705a;
    /* renamed from: b */
    private final /* synthetic */ int f6706b;
    /* renamed from: c */
    private final /* synthetic */ List f6707c;
    /* renamed from: d */
    private final /* synthetic */ ae f6708d;

    ah(ae aeVar, aui aui, int i, List list) {
        this.f6708d = aeVar;
        this.f6705a = aui;
        this.f6706b = i;
        this.f6707c = list;
    }

    public final void run() {
        try {
            boolean z = false;
            ae aeVar;
            Object a;
            if ((this.f6705a instanceof atw) && this.f6708d.e.f6809t != null) {
                aeVar = this.f6708d;
                if (this.f6706b != this.f6707c.size() - 1) {
                    z = true;
                }
                aeVar.c = z;
                a = ae.m17641b(this.f6705a);
                this.f6708d.e.f6809t.a(a);
                this.f6708d.m17660a(a.n());
            } else if ((this.f6705a instanceof atw) && this.f6708d.e.f6808s != null) {
                aeVar = this.f6708d;
                if (this.f6706b != this.f6707c.size() - 1) {
                    z = true;
                }
                aeVar.c = z;
                atw atw = (atw) this.f6705a;
                this.f6708d.e.f6808s.a(atw);
                this.f6708d.m17660a(atw.j());
            } else if ((this.f6705a instanceof atu) && this.f6708d.e.f6809t != null) {
                aeVar = this.f6708d;
                if (this.f6706b != this.f6707c.size() - 1) {
                    z = true;
                }
                aeVar.c = z;
                a = ae.m17641b(this.f6705a);
                this.f6708d.e.f6809t.a(a);
                this.f6708d.m17660a(a.n());
            } else if (!(this.f6705a instanceof atu) || this.f6708d.e.f6807r == null) {
                C4736a c4736a = this.f6708d;
                if (this.f6706b != this.f6707c.size() - 1) {
                    z = true;
                }
                c4736a.mo3539a(3, z);
            } else {
                aeVar = this.f6708d;
                if (this.f6706b != this.f6707c.size() - 1) {
                    z = true;
                }
                aeVar.c = z;
                atu atu = (atu) this.f6705a;
                this.f6708d.e.f6807r.a(atu);
                this.f6708d.m17660a(atu.j());
            }
        } catch (Throwable e) {
            jn.d("#007 Could not call remote method.", e);
        }
    }
}
