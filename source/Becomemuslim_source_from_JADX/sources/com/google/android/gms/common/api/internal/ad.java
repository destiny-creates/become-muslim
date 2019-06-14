package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.C2781a;
import com.google.android.gms.common.internal.C2850d.C2846c;
import com.google.android.gms.common.internal.C2872v;
import java.lang.ref.WeakReference;

final class ad implements C2846c {
    /* renamed from: a */
    private final WeakReference<ab> f11419a;
    /* renamed from: b */
    private final C2781a<?> f11420b;
    /* renamed from: c */
    private final boolean f11421c;

    public ad(ab abVar, C2781a<?> c2781a, boolean z) {
        this.f11419a = new WeakReference(abVar);
        this.f11420b = c2781a;
        this.f11421c = z;
    }

    /* renamed from: a */
    public final void mo2393a(C4775b c4775b) {
        ab abVar = (ab) this.f11419a.get();
        if (abVar != null) {
            C2872v.m8387a(Looper.myLooper() == abVar.f11398a.f13166d.mo2412c(), (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            abVar.f11399b.lock();
            try {
                if (abVar.m14089b(0)) {
                    if (!c4775b.m16826b()) {
                        abVar.m14088b(c4775b, this.f11420b, this.f11421c);
                    }
                    if (abVar.m14094d() != null) {
                        abVar.m14095e();
                    }
                    abVar.f11399b.unlock();
                }
            } finally {
                abVar.f11399b.unlock();
            }
        }
    }
}
