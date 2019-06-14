package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.bu;
import com.google.android.gms.p174b.C2758b;
import com.google.android.gms.p174b.C4757d;

@cm
public final class fy extends gj {
    /* renamed from: a */
    private final Context f28657a;
    /* renamed from: b */
    private final Object f28658b;
    /* renamed from: c */
    private final mv f28659c;
    /* renamed from: d */
    private final fz f28660d;

    public fy(Context context, bu buVar, bcy bcy, mv mvVar) {
        this(context, mvVar, new fz(context, buVar, aou.m36924a(), bcy, mvVar));
    }

    private fy(Context context, mv mvVar, fz fzVar) {
        this.f28658b = new Object();
        this.f28657a = context;
        this.f28659c = mvVar;
        this.f28660d = fzVar;
    }

    /* renamed from: a */
    public final void mo4250a() {
        synchronized (this.f28658b) {
            this.f28660d.m43486J();
        }
    }

    /* renamed from: a */
    public final void mo4251a(C2758b c2758b) {
        synchronized (this.f28658b) {
            this.f28660d.n();
        }
    }

    /* renamed from: a */
    public final void mo4252a(aqd aqd) {
        if (((Boolean) aph.m18688f().m18889a(asp.aF)).booleanValue()) {
            synchronized (this.f28658b) {
                this.f28660d.a(aqd);
            }
        }
    }

    /* renamed from: a */
    public final void mo4253a(gf gfVar) {
        synchronized (this.f28658b) {
            this.f28660d.a(gfVar);
        }
    }

    /* renamed from: a */
    public final void mo4254a(gn gnVar) {
        synchronized (this.f28658b) {
            this.f28660d.a(gnVar);
        }
    }

    /* renamed from: a */
    public final void mo4255a(gt gtVar) {
        synchronized (this.f28658b) {
            this.f28660d.m43489a(gtVar);
        }
    }

    /* renamed from: a */
    public final void mo4256a(String str) {
        synchronized (this.f28658b) {
            this.f28660d.a(str);
        }
    }

    /* renamed from: a */
    public final void mo4257a(boolean z) {
        synchronized (this.f28658b) {
            this.f28660d.c(z);
        }
    }

    /* renamed from: b */
    public final Bundle mo4258b() {
        if (!((Boolean) aph.m18688f().m18889a(asp.aF)).booleanValue()) {
            return new Bundle();
        }
        Bundle p;
        synchronized (this.f28658b) {
            p = this.f28660d.p();
        }
        return p;
    }

    /* renamed from: b */
    public final void mo4259b(C2758b c2758b) {
        synchronized (this.f28658b) {
            Context context;
            if (c2758b == null) {
                context = null;
            } else {
                try {
                    context = (Context) C4757d.a(c2758b);
                } catch (Throwable e) {
                    mt.m19921c("Unable to extract updated context.", e);
                }
            }
            if (context != null) {
                this.f28660d.m43488a(context);
            }
            this.f28660d.o();
        }
    }

    /* renamed from: c */
    public final void mo4260c(C2758b c2758b) {
        synchronized (this.f28658b) {
            this.f28660d.i();
        }
    }

    /* renamed from: c */
    public final boolean mo4261c() {
        boolean K;
        synchronized (this.f28658b) {
            K = this.f28660d.m43487K();
        }
        return K;
    }

    /* renamed from: d */
    public final void mo4262d() {
        mo4251a(null);
    }

    /* renamed from: e */
    public final void mo4263e() {
        mo4259b(null);
    }

    /* renamed from: f */
    public final void mo4264f() {
        mo4260c(null);
    }

    /* renamed from: g */
    public final String mo4265g() {
        String a;
        synchronized (this.f28658b) {
            a = this.f28660d.a();
        }
        return a;
    }
}
