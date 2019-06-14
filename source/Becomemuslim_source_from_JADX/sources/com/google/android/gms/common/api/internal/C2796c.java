package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.C2781a;
import com.google.android.gms.common.api.C2781a.C2777b;
import com.google.android.gms.common.api.C2781a.C2778c;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.common.internal.ab;

/* renamed from: com.google.android.gms.common.api.internal.c */
public class C2796c {

    /* renamed from: com.google.android.gms.common.api.internal.c$b */
    public interface C2795b<R> {
        /* renamed from: a */
        void mo3281a(R r);
    }

    /* renamed from: com.google.android.gms.common.api.internal.c$a */
    public static abstract class C4770a<R extends C2814k, A extends C2777b> extends BasePendingResult<R> implements C2795b<R> {
        /* renamed from: a */
        private final C2778c<A> f13179a;
        /* renamed from: b */
        private final C2781a<?> f13180b;

        /* renamed from: a */
        protected abstract void mo3553a(A a);

        /* renamed from: a */
        protected void mo3280a(R r) {
        }

        protected C4770a(C2781a<?> c2781a, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) C2872v.m8381a((Object) googleApiClient, (Object) "GoogleApiClient must not be null"));
            C2872v.m8381a((Object) c2781a, (Object) "Api must not be null");
            this.f13179a = c2781a.m7933c();
            this.f13180b = c2781a;
        }

        /* renamed from: d */
        public final C2778c<A> mo3282d() {
            return this.f13179a;
        }

        /* renamed from: e */
        public final C2781a<?> m16744e() {
            return this.f13180b;
        }

        /* renamed from: b */
        public final void m16742b(A a) {
            if (a instanceof ab) {
                C2777b e = ((ab) a).mo3452e();
            }
            try {
                mo3553a(e);
            } catch (RemoteException e2) {
                m16737a(e2);
                throw e2;
            } catch (RemoteException e22) {
                m16737a(e22);
            }
        }

        /* renamed from: b */
        public final void m16741b(Status status) {
            C2872v.m8391b(status.m16705d() ^ 1, "Failed result must not be success");
            C2814k a = mo3278a(status);
            m14069b(a);
            mo3280a(a);
        }

        /* renamed from: a */
        private void m16737a(RemoteException remoteException) {
            m16741b(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        /* renamed from: a */
        public /* synthetic */ void mo3281a(Object obj) {
            super.m14069b((C2814k) obj);
        }
    }
}
