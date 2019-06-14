package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.C2628c;
import com.google.android.gms.ads.reward.C2698b;
import com.google.android.gms.ads.reward.C2699c;

@cm
public final class gv implements C2698b {
    /* renamed from: a */
    private final gh f24084a;
    /* renamed from: b */
    private final Context f24085b;
    /* renamed from: c */
    private final Object f24086c = new Object();
    /* renamed from: d */
    private final gs f24087d = new gs(null);

    public gv(Context context, gh ghVar) {
        this.f24084a = ghVar;
        this.f24085b = context;
    }

    /* renamed from: a */
    private final void m30760a(String str, ard ard) {
        synchronized (this.f24086c) {
            if (this.f24084a == null) {
                return;
            }
            try {
                this.f24084a.mo4255a(new gt(aot.m18660a(this.f24085b, ard), str));
            } catch (Throwable e) {
                mt.m19923d("#007 Could not call remote method.", e);
            }
        }
    }

    /* renamed from: a */
    public final void m30761a(C2699c c2699c) {
        synchronized (this.f24086c) {
            this.f24087d.m37503a(c2699c);
            if (this.f24084a != null) {
                try {
                    this.f24084a.mo4254a(this.f24087d);
                } catch (Throwable e) {
                    mt.m19923d("#007 Could not call remote method.", e);
                }
            }
        }
    }

    /* renamed from: a */
    public final void m30762a(String str, C2628c c2628c) {
        m30760a(str, c2628c.a());
    }

    /* renamed from: a */
    public final boolean m30763a() {
        synchronized (this.f24086c) {
            if (this.f24084a == null) {
                return false;
            }
            try {
                boolean c = this.f24084a.mo4261c();
                return c;
            } catch (Throwable e) {
                mt.m19923d("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    /* renamed from: b */
    public final void m30764b() {
        synchronized (this.f24086c) {
            if (this.f24084a == null) {
                return;
            }
            try {
                this.f24084a.mo4250a();
            } catch (Throwable e) {
                mt.m19923d("#007 Could not call remote method.", e);
            }
        }
    }
}
