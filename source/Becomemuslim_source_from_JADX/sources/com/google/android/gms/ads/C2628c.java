package com.google.android.gms.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.C2683b;
import com.google.android.gms.internal.ads.ard;
import com.google.android.gms.internal.ads.are;
import java.util.Date;

/* renamed from: com.google.android.gms.ads.c */
public final class C2628c {
    /* renamed from: a */
    private final ard f6666a;

    /* renamed from: com.google.android.gms.ads.c$a */
    public static final class C2625a {
        /* renamed from: a */
        private final are f6665a = new are();

        public C2625a() {
            this.f6665a.b("B3EEABB8EE11C2BE770B684D95219ECB");
        }

        /* renamed from: a */
        public final C2625a m7399a(int i) {
            this.f6665a.a(i);
            return this;
        }

        /* renamed from: a */
        public final C2625a m7400a(Location location) {
            this.f6665a.a(location);
            return this;
        }

        /* renamed from: a */
        public final C2625a m7401a(Class<? extends C2683b> cls, Bundle bundle) {
            this.f6665a.a(cls, bundle);
            if (cls.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
                this.f6665a.c("B3EEABB8EE11C2BE770B684D95219ECB");
            }
            return this;
        }

        /* renamed from: a */
        public final C2625a m7402a(String str) {
            this.f6665a.a(str);
            return this;
        }

        /* renamed from: a */
        public final C2625a m7403a(Date date) {
            this.f6665a.a(date);
            return this;
        }

        /* renamed from: a */
        public final C2625a m7404a(boolean z) {
            this.f6665a.a(z);
            return this;
        }

        /* renamed from: a */
        public final C2628c m7405a() {
            return new C2628c();
        }

        /* renamed from: b */
        public final C2625a m7406b(String str) {
            this.f6665a.b(str);
            return this;
        }

        /* renamed from: b */
        public final C2625a m7407b(boolean z) {
            this.f6665a.b(z);
            return this;
        }
    }

    private C2628c(C2625a c2625a) {
        this.f6666a = new ard(c2625a.f6665a);
    }

    /* renamed from: a */
    public final ard m7408a() {
        return this.f6666a;
    }
}
