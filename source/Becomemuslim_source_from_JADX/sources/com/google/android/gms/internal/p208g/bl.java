package com.google.android.gms.internal.p208g;

import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.p187a.C4793b;
import com.google.android.gms.fitness.p188b.C4800b;
import java.util.Collections;

/* renamed from: com.google.android.gms.internal.g.bl */
final class bl extends C8216u<C4800b> {
    /* renamed from: a */
    private final /* synthetic */ C4793b f32758a;

    bl(bk bkVar, GoogleApiClient googleApiClient, C4793b c4793b) {
        this.f32758a = c4793b;
        super(googleApiClient);
    }

    /* renamed from: a */
    protected final /* synthetic */ C2814k m43823a(Status status) {
        return new C4800b(Collections.emptyList(), status);
    }

    /* renamed from: a */
    protected final /* synthetic */ void m43824a(C2777b c2777b) {
        ((at) ((C8323r) c2777b).w()).mo4404a(new C4793b(this.f32758a, new bt(this)));
    }
}
