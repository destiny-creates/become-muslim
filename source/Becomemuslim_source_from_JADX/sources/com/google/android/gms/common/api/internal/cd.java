package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.C2796c.C4770a;
import com.google.android.gms.common.api.internal.C2798d.C4771a;

public final class cd<A extends C4770a<? extends C2814k, C2777b>> extends ar {
    /* renamed from: a */
    private final A f11487a;

    public cd(int i, A a) {
        super(i);
        this.f11487a = a;
    }

    /* renamed from: a */
    public final void mo2428a(C4771a<?> c4771a) {
        try {
            this.f11487a.m16742b(c4771a.m16790b());
        } catch (RuntimeException e) {
            mo2430a(e);
        }
    }

    /* renamed from: a */
    public final void mo2427a(Status status) {
        this.f11487a.m16741b(status);
    }

    /* renamed from: a */
    public final void mo2430a(RuntimeException runtimeException) {
        String simpleName = runtimeException.getClass().getSimpleName();
        runtimeException = runtimeException.getLocalizedMessage();
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(simpleName).length() + 2) + String.valueOf(runtimeException).length());
        stringBuilder.append(simpleName);
        stringBuilder.append(": ");
        stringBuilder.append(runtimeException);
        this.f11487a.m16741b(new Status(10, stringBuilder.toString()));
    }

    /* renamed from: a */
    public final void mo2429a(C2812s c2812s, boolean z) {
        c2812s.m8101a(this.f11487a, z);
    }
}
