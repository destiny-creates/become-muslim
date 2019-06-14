package com.google.android.gms.ads;

import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.ads.aqv;
import com.google.android.gms.internal.ads.arx;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.mt;

@cm
/* renamed from: com.google.android.gms.ads.k */
public final class C2678k {
    /* renamed from: a */
    private final Object f6919a = new Object();
    /* renamed from: b */
    private aqv f6920b;
    /* renamed from: c */
    private C2677a f6921c;

    /* renamed from: com.google.android.gms.ads.k$a */
    public static abstract class C2677a {
        /* renamed from: a */
        public void m7562a() {
        }

        /* renamed from: a */
        public void m7563a(boolean z) {
        }

        /* renamed from: b */
        public void m7564b() {
        }

        /* renamed from: c */
        public void m7565c() {
        }

        /* renamed from: d */
        public void m7566d() {
        }
    }

    /* renamed from: a */
    public final aqv m7567a() {
        aqv aqv;
        synchronized (this.f6919a) {
            aqv = this.f6920b;
        }
        return aqv;
    }

    /* renamed from: a */
    public final void m7568a(C2677a c2677a) {
        C2872v.m8381a((Object) c2677a, (Object) "VideoLifecycleCallbacks may not be null.");
        synchronized (this.f6919a) {
            this.f6921c = c2677a;
            if (this.f6920b == null) {
                return;
            }
            try {
                this.f6920b.a(new arx(c2677a));
            } catch (Throwable e) {
                mt.b("Unable to call setVideoLifecycleCallbacks on video controller.", e);
            }
        }
    }

    /* renamed from: a */
    public final void m7569a(aqv aqv) {
        synchronized (this.f6919a) {
            this.f6920b = aqv;
            if (this.f6921c != null) {
                m7568a(this.f6921c);
            }
        }
    }
}
