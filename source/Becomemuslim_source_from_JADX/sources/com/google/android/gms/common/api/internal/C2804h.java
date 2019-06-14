package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.p205d.C4956e;

/* renamed from: com.google.android.gms.common.api.internal.h */
public final class C2804h<L> {
    /* renamed from: a */
    private final C4350c f7204a;
    /* renamed from: b */
    private volatile L f7205b;
    /* renamed from: c */
    private final C2802a<L> f7206c;

    /* renamed from: com.google.android.gms.common.api.internal.h$a */
    public static final class C2802a<L> {
        /* renamed from: a */
        private final L f7202a;
        /* renamed from: b */
        private final String f7203b;

        C2802a(L l, String str) {
            this.f7202a = l;
            this.f7203b = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C2802a)) {
                return false;
            }
            C2802a c2802a = (C2802a) obj;
            return this.f7202a == c2802a.f7202a && this.f7203b.equals(c2802a.f7203b) != null;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f7202a) * 31) + this.f7203b.hashCode();
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.h$b */
    public interface C2803b<L> {
        /* renamed from: a */
        void mo2593a();

        /* renamed from: a */
        void mo2594a(L l);
    }

    /* renamed from: com.google.android.gms.common.api.internal.h$c */
    private final class C4350c extends C4956e {
        /* renamed from: a */
        private final /* synthetic */ C2804h f11550a;

        public C4350c(C2804h c2804h, Looper looper) {
            this.f11550a = c2804h;
            super(looper);
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            if (message.what != 1) {
                z = false;
            }
            C2872v.m8390b(z);
            this.f11550a.m8083b((C2803b) message.obj);
        }
    }

    C2804h(Looper looper, L l, String str) {
        this.f7204a = new C4350c(this, looper);
        this.f7205b = C2872v.m8381a((Object) l, (Object) "Listener must not be null");
        this.f7206c = new C2802a(l, C2872v.m8382a(str));
    }

    /* renamed from: a */
    public final void m8081a(C2803b<? super L> c2803b) {
        C2872v.m8381a((Object) c2803b, (Object) "Notifier must not be null");
        this.f7204a.sendMessage(this.f7204a.obtainMessage(1, c2803b));
    }

    /* renamed from: a */
    public final void m8080a() {
        this.f7205b = null;
    }

    /* renamed from: b */
    public final C2802a<L> m8082b() {
        return this.f7206c;
    }

    /* renamed from: b */
    final void m8083b(C2803b<? super L> c2803b) {
        Object obj = this.f7205b;
        if (obj == null) {
            c2803b.mo2593a();
            return;
        }
        try {
            c2803b.mo2594a(obj);
        } catch (RuntimeException e) {
            c2803b.mo2593a();
            throw e;
        }
    }
}
