package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.C4775b;

final class ct implements bl {
    /* renamed from: a */
    private final /* synthetic */ cq f11516a;

    private ct(cq cqVar) {
        this.f11516a = cqVar;
    }

    /* renamed from: a */
    public final void mo2402a(Bundle bundle) {
        this.f11516a.f11513m.lock();
        try {
            this.f11516a.f11511k = C4775b.f13206a;
            this.f11516a.m14230e();
        } finally {
            this.f11516a.f11513m.unlock();
        }
    }

    /* renamed from: a */
    public final void mo2405a(C4775b c4775b) {
        this.f11516a.f11513m.lock();
        try {
            this.f11516a.f11511k = c4775b;
            this.f11516a.m14230e();
        } finally {
            this.f11516a.f11513m.unlock();
        }
    }

    /* renamed from: a */
    public final void mo2401a(int i, boolean z) {
        this.f11516a.f11513m.lock();
        try {
            if (this.f11516a.f11512l) {
                this.f11516a.f11512l = false;
                this.f11516a.m14217a(i, z);
                return;
            }
            this.f11516a.f11512l = true;
            this.f11516a.f11504d.onConnectionSuspended(i);
            this.f11516a.f11513m.unlock();
        } finally {
            this.f11516a.f11513m.unlock();
        }
    }
}
