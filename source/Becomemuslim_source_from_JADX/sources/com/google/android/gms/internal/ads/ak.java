package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.SystemClock;

@cm
public abstract class ak extends ji {
    /* renamed from: a */
    protected final ap f28110a;
    /* renamed from: b */
    protected final Context f28111b;
    /* renamed from: c */
    protected final Object f28112c = new Object();
    /* renamed from: d */
    protected final Object f28113d = new Object();
    /* renamed from: e */
    protected final it f28114e;
    /* renamed from: f */
    protected dp f28115f;

    protected ak(Context context, it itVar, ap apVar) {
        super(true);
        this.f28111b = context;
        this.f28114e = itVar;
        this.f28115f = itVar.f15601b;
        this.f28110a = apVar;
    }

    /* renamed from: a */
    protected abstract is mo6644a(int i);

    /* renamed from: a */
    public final void mo6079a() {
        synchronized (this.f28112c) {
            mt.m19918b("AdRendererBackgroundTask started.");
            int i = this.f28114e.f15604e;
            try {
                mo6645a(SystemClock.elapsedRealtime());
            } catch (an e) {
                r2 = e.m18651a();
                if (r2 != 3) {
                    int a;
                    if (a != -1) {
                        mt.m19924e(e.getMessage());
                        this.f28115f = this.f28115f != null ? new dp(a) : new dp(a, this.f28115f.f28605j);
                        jw.f15691a.post(new al(this));
                        i = a;
                    }
                }
                mt.m19922d(e.getMessage());
                if (this.f28115f != null) {
                }
                this.f28115f = this.f28115f != null ? new dp(a) : new dp(a, this.f28115f.f28605j);
                jw.f15691a.post(new al(this));
                i = a;
            }
            jw.f15691a.post(new am(this, mo6644a(i)));
        }
    }

    /* renamed from: a */
    protected abstract void mo6645a(long j);

    public void h_() {
    }
}
