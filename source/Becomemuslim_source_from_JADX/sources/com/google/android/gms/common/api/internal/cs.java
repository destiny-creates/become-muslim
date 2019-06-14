package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.C4775b;

final class cs implements bl {
    /* renamed from: a */
    private final /* synthetic */ cq f11515a;

    private cs(cq cqVar) {
        this.f11515a = cqVar;
    }

    /* renamed from: a */
    public final void mo2402a(Bundle bundle) {
        this.f11515a.f11513m.lock();
        try {
            this.f11515a.m14218a(bundle);
            this.f11515a.f11510j = C4775b.f13206a;
            this.f11515a.m14230e();
        } finally {
            this.f11515a.f11513m.unlock();
        }
    }

    /* renamed from: a */
    public final void mo2405a(C4775b c4775b) {
        this.f11515a.f11513m.lock();
        try {
            this.f11515a.f11510j = c4775b;
            this.f11515a.m14230e();
        } finally {
            this.f11515a.f11513m.unlock();
        }
    }

    /* renamed from: a */
    public final void mo2401a(int i, boolean z) {
        this.f11515a.f11513m.lock();
        try {
            if (!(this.f11515a.f11512l || this.f11515a.f11511k == null)) {
                if (this.f11515a.f11511k.m16826b()) {
                    this.f11515a.f11512l = true;
                    this.f11515a.f11505e.onConnectionSuspended(i);
                    this.f11515a.f11513m.unlock();
                    return;
                }
            }
            this.f11515a.f11512l = false;
            this.f11515a.m14217a(i, z);
        } finally {
            this.f11515a.f11513m.unlock();
        }
    }
}
