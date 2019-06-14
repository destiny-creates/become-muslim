package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.internal.C2850d.C2844a;

final class aml implements C2844a {
    /* renamed from: a */
    private final /* synthetic */ ami f23726a;

    aml(ami ami) {
        this.f23726a = ami;
    }

    /* renamed from: a */
    public final void m30041a(int i) {
        synchronized (this.f23726a.f14761b) {
            this.f23726a.f14764e = null;
            this.f23726a.f14761b.notifyAll();
        }
    }

    /* renamed from: a */
    public final void m30042a(Bundle bundle) {
        synchronized (this.f23726a.f14761b) {
            try {
                if (this.f23726a.f14762c != null) {
                    this.f23726a.f14764e = this.f23726a.f14762c.m30046e();
                }
            } catch (Throwable e) {
                mt.m19919b("Unable to obtain a cache service instance.", e);
                this.f23726a.m18635c();
            }
            this.f23726a.f14761b.notifyAll();
        }
    }
}
