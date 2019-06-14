package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.C4775b;
import com.google.android.gms.common.api.GoogleApiClient.C2775b;
import com.google.android.gms.common.api.GoogleApiClient.C2776c;

final class ak implements C2775b, C2776c {
    /* renamed from: a */
    private final /* synthetic */ ab f11431a;

    private ak(ab abVar) {
        this.f11431a = abVar;
    }

    public final void onConnectionSuspended(int i) {
    }

    public final void onConnected(Bundle bundle) {
        this.f11431a.f11408k.mo3455a(new ai(this.f11431a));
    }

    public final void onConnectionFailed(C4775b c4775b) {
        this.f11431a.f11399b.lock();
        try {
            if (this.f11431a.m14085a(c4775b)) {
                this.f11431a.m14100g();
                this.f11431a.m14095e();
            } else {
                this.f11431a.m14087b(c4775b);
            }
            this.f11431a.f11399b.unlock();
        } catch (Throwable th) {
            this.f11431a.f11399b.unlock();
        }
    }
}
