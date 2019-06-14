package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C2782b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C2798d.C4771a;
import com.google.android.gms.p186f.C2955h;

abstract class cc<T> extends bo {
    /* renamed from: a */
    protected final C2955h<T> f13181a;

    public cc(int i, C2955h<T> c2955h) {
        super(i);
        this.f13181a = c2955h;
    }

    /* renamed from: a */
    public void mo2429a(C2812s c2812s, boolean z) {
    }

    /* renamed from: d */
    protected abstract void mo3459d(C4771a<?> c4771a);

    /* renamed from: a */
    public void mo2427a(Status status) {
        this.f13181a.m8786b(new C2782b(status));
    }

    /* renamed from: a */
    public void mo2430a(RuntimeException runtimeException) {
        this.f13181a.m8786b((Exception) runtimeException);
    }

    /* renamed from: a */
    public final void mo2428a(C4771a<?> c4771a) {
        try {
            mo3459d(c4771a);
        } catch (RemoteException e) {
            mo2427a(ar.m7982b(e));
            throw e;
        } catch (RemoteException e2) {
            mo2427a(ar.m7982b(e2));
        } catch (RuntimeException e3) {
            mo2430a(e3);
        }
    }
}
