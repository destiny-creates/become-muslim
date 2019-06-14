package com.google.android.gms.internal.p208g;

import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.p187a.C4792a;
import com.google.android.gms.fitness.p188b.C4799a;

/* renamed from: com.google.android.gms.internal.g.bg */
final class bg extends C8214i<C4799a> {
    /* renamed from: a */
    private final /* synthetic */ C4792a f32757a;

    bg(be beVar, GoogleApiClient googleApiClient, C4792a c4792a) {
        this.f32757a = c4792a;
        super(googleApiClient);
    }

    /* renamed from: a */
    protected final /* synthetic */ C2814k m43821a(Status status) {
        return C4799a.a(status, this.f32757a.a(), this.f32757a.b());
    }

    /* renamed from: a */
    protected final /* synthetic */ void m43822a(C2777b c2777b) {
        ((ao) ((C8319f) c2777b).w()).mo4401a(new C4792a(this.f32757a, new bh(this)));
    }
}
