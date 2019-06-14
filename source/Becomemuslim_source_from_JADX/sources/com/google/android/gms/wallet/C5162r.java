package com.google.android.gms.wallet;

import android.accounts.Account;
import android.app.Activity;
import com.google.android.gms.common.api.C2781a;
import com.google.android.gms.common.api.C2781a.C2779d.C4765a;
import com.google.android.gms.common.api.C2781a.C4337a;
import com.google.android.gms.common.api.C2781a.C4341g;
import com.google.android.gms.common.internal.C2868t;
import com.google.android.gms.internal.p215n.C5062f;
import com.google.android.gms.internal.p215n.C5066k;
import com.google.android.gms.internal.p215n.C6828g;
import com.google.android.gms.internal.p215n.C6831v;
import com.google.android.gms.internal.p215n.C8221b;
import com.google.android.gms.wallet.wobs.C5168i;
import java.util.Locale;

/* renamed from: com.google.android.gms.wallet.r */
public final class C5162r {
    /* renamed from: a */
    public static final C2781a<C8229a> f17440a = new C2781a("Wallet.API", f17443d, f17442c);
    @Deprecated
    /* renamed from: b */
    public static final C5158m f17441b = new C6831v();
    /* renamed from: c */
    private static final C4341g<C8221b> f17442c = new C4341g();
    /* renamed from: d */
    private static final C4337a<C8221b, C8229a> f17443d = new ah();
    /* renamed from: e */
    private static final C5168i f17444e = new C6828g();
    /* renamed from: f */
    private static final C5066k f17445f = new C5062f();

    /* renamed from: com.google.android.gms.wallet.r$a */
    public static final class C8229a implements C4765a {
        /* renamed from: a */
        public final int f32375a;
        /* renamed from: b */
        public final int f32376b;
        /* renamed from: c */
        final boolean f32377c;
        /* renamed from: d */
        private final Account f32378d;

        /* renamed from: com.google.android.gms.wallet.r$a$a */
        public static final class C5161a {
            /* renamed from: a */
            private int f17437a = 3;
            /* renamed from: b */
            private int f17438b = 0;
            /* renamed from: c */
            private boolean f17439c = true;

            /* renamed from: a */
            public final C5161a m21873a(int i) {
                if (!(i == 0 || i == 0 || i == 2 || i == 1)) {
                    if (i != 3) {
                        throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[]{Integer.valueOf(i)}));
                    }
                }
                this.f17437a = i;
                return this;
            }

            /* renamed from: a */
            public final C8229a m21874a() {
                return new C8229a();
            }
        }

        private C8229a() {
            this(new C5161a());
        }

        private C8229a(C5161a c5161a) {
            this.f32375a = c5161a.f17437a;
            this.f32376b = c5161a.f17438b;
            this.f32377c = c5161a.f17439c;
            this.f32378d = null;
        }

        /* renamed from: a */
        public final Account m42742a() {
            return null;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof C8229a)) {
                return false;
            }
            C8229a c8229a = (C8229a) obj;
            return C2868t.a(Integer.valueOf(this.f32375a), Integer.valueOf(c8229a.f32375a)) && C2868t.a(Integer.valueOf(this.f32376b), Integer.valueOf(c8229a.f32376b)) && C2868t.a(null, null) && C2868t.a(Boolean.valueOf(this.f32377c), Boolean.valueOf(c8229a.f32377c));
        }

        public final int hashCode() {
            return C2868t.a(new Object[]{Integer.valueOf(this.f32375a), Integer.valueOf(this.f32376b), null, Boolean.valueOf(this.f32377c)});
        }
    }

    /* renamed from: a */
    public static C6850n m21875a(Activity activity, C8229a c8229a) {
        return new C6850n(activity, c8229a);
    }
}
