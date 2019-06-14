package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.C4772j;
import com.google.android.gms.common.api.internal.C4773n;
import com.google.android.gms.common.internal.C2872v;

/* renamed from: com.google.android.gms.common.api.h */
public final class C2790h {

    /* renamed from: com.google.android.gms.common.api.h$a */
    private static final class C4768a<R extends C2814k> extends BasePendingResult<R> {
        /* renamed from: a */
        private final R f13162a;

        public C4768a(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.f13162a = r;
        }

        /* renamed from: a */
        protected final R mo3278a(Status status) {
            return this.f13162a;
        }
    }

    /* renamed from: com.google.android.gms.common.api.h$b */
    private static final class C4769b<R extends C2814k> extends BasePendingResult<R> {
        public C4769b(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: a */
        protected final R mo3278a(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    /* renamed from: a */
    public static C2789g<Status> m7965a(Status status, GoogleApiClient googleApiClient) {
        C2872v.m8381a((Object) status, (Object) "Result must not be null");
        C2789g c4773n = new C4773n(googleApiClient);
        c4773n.m14069b(status);
        return c4773n;
    }

    /* renamed from: a */
    public static <R extends C2814k> C2789g<R> m7966a(R r, GoogleApiClient googleApiClient) {
        C2872v.m8381a((Object) r, (Object) "Result must not be null");
        C2872v.m8391b(r.mo2360b().m16705d() ^ 1, "Status code must not be SUCCESS");
        C2789g c4768a = new C4768a(googleApiClient, r);
        c4768a.m14069b(r);
        return c4768a;
    }

    /* renamed from: b */
    public static <R extends C2814k> C4345f<R> m7967b(R r, GoogleApiClient googleApiClient) {
        C2872v.m8381a((Object) r, (Object) "Result must not be null");
        C2789g c4769b = new C4769b(googleApiClient);
        c4769b.m14069b(r);
        return new C4772j(c4769b);
    }
}
