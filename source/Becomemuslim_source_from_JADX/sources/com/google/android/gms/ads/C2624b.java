package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.p168b.C2611d;
import com.google.android.gms.ads.p168b.C2618k.C2616a;
import com.google.android.gms.ads.p168b.C2618k.C2617b;
import com.google.android.gms.ads.p168b.C2620m.C2619a;
import com.google.android.gms.ads.p168b.C4259g.C2614a;
import com.google.android.gms.ads.p168b.C4261i.C2615a;
import com.google.android.gms.common.internal.C2872v;
import com.google.android.gms.internal.ads.aom;
import com.google.android.gms.internal.ads.aot;
import com.google.android.gms.internal.ads.aph;
import com.google.android.gms.internal.ads.apq;
import com.google.android.gms.internal.ads.apt;
import com.google.android.gms.internal.ads.ard;
import com.google.android.gms.internal.ads.aus;
import com.google.android.gms.internal.ads.axf;
import com.google.android.gms.internal.ads.axg;
import com.google.android.gms.internal.ads.axh;
import com.google.android.gms.internal.ads.axj;
import com.google.android.gms.internal.ads.axk;
import com.google.android.gms.internal.ads.bcx;
import com.google.android.gms.internal.ads.mt;

/* renamed from: com.google.android.gms.ads.b */
public class C2624b {
    /* renamed from: a */
    private final aot f6662a;
    /* renamed from: b */
    private final Context f6663b;
    /* renamed from: c */
    private final apq f6664c;

    /* renamed from: com.google.android.gms.ads.b$a */
    public static class C2604a {
        /* renamed from: a */
        private final Context f6643a;
        /* renamed from: b */
        private final apt f6644b;

        private C2604a(Context context, apt apt) {
            this.f6643a = context;
            this.f6644b = apt;
        }

        public C2604a(Context context, String str) {
            this((Context) C2872v.m8381a((Object) context, (Object) "context cannot be null"), aph.b().a(context, str, new bcx()));
        }

        /* renamed from: a */
        public C2604a m7344a(C2603a c2603a) {
            try {
                this.f6644b.a(new aom(c2603a));
            } catch (Throwable e) {
                mt.c("Failed to set AdListener.", e);
            }
            return this;
        }

        /* renamed from: a */
        public C2604a m7345a(C2611d c2611d) {
            try {
                this.f6644b.a(new aus(c2611d));
            } catch (Throwable e) {
                mt.c("Failed to specify native ad options", e);
            }
            return this;
        }

        /* renamed from: a */
        public C2604a m7346a(C2614a c2614a) {
            try {
                this.f6644b.a(new axf(c2614a));
            } catch (Throwable e) {
                mt.c("Failed to add app install ad listener", e);
            }
            return this;
        }

        /* renamed from: a */
        public C2604a m7347a(C2615a c2615a) {
            try {
                this.f6644b.a(new axg(c2615a));
            } catch (Throwable e) {
                mt.c("Failed to add content ad listener", e);
            }
            return this;
        }

        /* renamed from: a */
        public C2604a m7348a(C2619a c2619a) {
            try {
                this.f6644b.a(new axk(c2619a));
            } catch (Throwable e) {
                mt.c("Failed to add google native ad listener", e);
            }
            return this;
        }

        /* renamed from: a */
        public C2604a m7349a(String str, C2617b c2617b, C2616a c2616a) {
            try {
                this.f6644b.a(str, new axj(c2617b), c2616a == null ? null : new axh(c2616a));
            } catch (Throwable e) {
                mt.c("Failed to add custom template ad listener", e);
            }
            return this;
        }

        /* renamed from: a */
        public C2624b m7350a() {
            try {
                return new C2624b(this.f6643a, this.f6644b.a());
            } catch (Throwable e) {
                mt.b("Failed to build AdLoader.", e);
                return null;
            }
        }
    }

    C2624b(Context context, apq apq) {
        this(context, apq, aot.f14795a);
    }

    private C2624b(Context context, apq apq, aot aot) {
        this.f6663b = context;
        this.f6664c = apq;
        this.f6662a = aot;
    }

    /* renamed from: a */
    private final void m7396a(ard ard) {
        try {
            this.f6664c.a(aot.a(this.f6663b, ard));
        } catch (Throwable e) {
            mt.b("Failed to load ad.", e);
        }
    }

    /* renamed from: a */
    public void m7397a(C2628c c2628c) {
        m7396a(c2628c.m7408a());
    }
}
