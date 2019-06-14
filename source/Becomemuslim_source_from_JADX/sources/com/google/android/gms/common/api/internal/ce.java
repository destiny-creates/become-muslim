package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.C4776d;
import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C2798d.C4771a;
import com.google.android.gms.p186f.C2955h;

public final class ce<ResultT> extends bo {
    /* renamed from: a */
    private final C2809o<C2777b, ResultT> f13182a;
    /* renamed from: b */
    private final C2955h<ResultT> f13183b;
    /* renamed from: c */
    private final C2808m f13184c;

    public ce(int i, C2809o<C2777b, ResultT> c2809o, C2955h<ResultT> c2955h, C2808m c2808m) {
        super(i);
        this.f13183b = c2955h;
        this.f13182a = c2809o;
        this.f13184c = c2808m;
    }

    /* renamed from: a */
    public final void mo2428a(C4771a<?> c4771a) {
        try {
            this.f13182a.m8093a(c4771a.m16790b(), this.f13183b);
        } catch (C4771a<?> c4771a2) {
            throw c4771a2;
        } catch (RemoteException e) {
            mo2427a(ar.m7982b(e));
        } catch (RuntimeException e2) {
            mo2430a(e2);
        }
    }

    /* renamed from: a */
    public final void mo2427a(Status status) {
        this.f13183b.m8786b(this.f13184c.mo2383a(status));
    }

    /* renamed from: a */
    public final void mo2430a(RuntimeException runtimeException) {
        this.f13183b.m8786b((Exception) runtimeException);
    }

    /* renamed from: a */
    public final void mo2429a(C2812s c2812s, boolean z) {
        c2812s.m8102a(this.f13183b, z);
    }

    /* renamed from: b */
    public final C4776d[] mo3283b(C4771a<?> c4771a) {
        return this.f13182a.m8094a();
    }

    /* renamed from: c */
    public final boolean mo3284c(C4771a<?> c4771a) {
        return this.f13182a.m8095b();
    }
}
