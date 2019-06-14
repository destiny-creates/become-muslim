package com.google.android.gms.internal.p208g;

import android.util.Log;
import com.google.android.gms.common.api.internal.C2796c.C2795b;
import com.google.android.gms.fitness.p188b.C4799a;

/* renamed from: com.google.android.gms.internal.g.bh */
final class bh extends ad {
    /* renamed from: a */
    private final C2795b<C4799a> f28782a;
    /* renamed from: b */
    private int f28783b;
    /* renamed from: c */
    private C4799a f28784c;

    private bh(C2795b<C4799a> c2795b) {
        this.f28783b = 0;
        this.f28784c = null;
        this.f28782a = c2795b;
    }

    /* renamed from: a */
    public final void mo4399a(C4799a c4799a) {
        synchronized (this) {
            if (Log.isLoggable("Fitness", 2)) {
                int i = this.f28783b;
                StringBuilder stringBuilder = new StringBuilder(33);
                stringBuilder.append("Received batch result ");
                stringBuilder.append(i);
                Log.v("Fitness", stringBuilder.toString());
            }
            if (this.f28784c == null) {
                this.f28784c = c4799a;
            } else {
                this.f28784c.a(c4799a);
            }
            this.f28783b++;
            if (this.f28783b == this.f28784c.d()) {
                this.f28782a.a(this.f28784c);
            }
        }
    }
}
