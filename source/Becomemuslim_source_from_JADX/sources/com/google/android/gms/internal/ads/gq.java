package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.C2697a;

@cm
public final class gq implements C2697a {
    /* renamed from: a */
    private final gc f24083a;

    public gq(gc gcVar) {
        this.f24083a = gcVar;
    }

    /* renamed from: a */
    public final String m30756a() {
        if (this.f24083a == null) {
            return null;
        }
        try {
            return this.f24083a.mo4247a();
        } catch (Throwable e) {
            mt.m19921c("Could not forward getType to RewardItem", e);
            return null;
        }
    }

    /* renamed from: b */
    public final int m30757b() {
        if (this.f24083a == null) {
            return 0;
        }
        try {
            return this.f24083a.mo4248b();
        } catch (Throwable e) {
            mt.m19921c("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }
}
