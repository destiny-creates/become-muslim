package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

/* renamed from: com.google.android.gms.common.internal.l */
public abstract class C2859l {
    /* renamed from: a */
    private static final Object f7325a = new Object();
    /* renamed from: b */
    private static C2859l f7326b;

    /* renamed from: com.google.android.gms.common.internal.l$a */
    protected static final class C2858a {
        /* renamed from: a */
        private final String f7321a;
        /* renamed from: b */
        private final String f7322b;
        /* renamed from: c */
        private final ComponentName f7323c;
        /* renamed from: d */
        private final int f7324d;

        public C2858a(String str, String str2, int i) {
            this.f7321a = C2872v.m8382a(str);
            this.f7322b = C2872v.m8382a(str2);
            this.f7323c = null;
            this.f7324d = i;
        }

        public C2858a(ComponentName componentName, int i) {
            this.f7321a = null;
            this.f7322b = null;
            this.f7323c = (ComponentName) C2872v.m8380a((Object) componentName);
            this.f7324d = 129;
        }

        public final String toString() {
            return this.f7321a == null ? this.f7323c.flattenToString() : this.f7321a;
        }

        /* renamed from: a */
        public final String m8353a() {
            return this.f7322b;
        }

        /* renamed from: b */
        public final ComponentName m8354b() {
            return this.f7323c;
        }

        /* renamed from: c */
        public final int m8355c() {
            return this.f7324d;
        }

        /* renamed from: a */
        public final Intent m8352a(Context context) {
            if (this.f7321a != null) {
                return new Intent(this.f7321a).setPackage(this.f7322b);
            }
            return new Intent().setComponent(this.f7323c);
        }

        public final int hashCode() {
            return C2868t.m8372a(this.f7321a, this.f7322b, this.f7323c, Integer.valueOf(this.f7324d));
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C2858a)) {
                return false;
            }
            C2858a c2858a = (C2858a) obj;
            return C2868t.m8374a(this.f7321a, c2858a.f7321a) && C2868t.m8374a(this.f7322b, c2858a.f7322b) && C2868t.m8374a(this.f7323c, c2858a.f7323c) && this.f7324d == c2858a.f7324d;
        }
    }

    /* renamed from: a */
    protected abstract boolean mo2467a(C2858a c2858a, ServiceConnection serviceConnection, String str);

    /* renamed from: b */
    protected abstract void mo2468b(C2858a c2858a, ServiceConnection serviceConnection, String str);

    /* renamed from: a */
    public static C2859l m8356a(Context context) {
        synchronized (f7325a) {
            if (f7326b == null) {
                f7326b = new at(context.getApplicationContext());
            }
        }
        return f7326b;
    }

    /* renamed from: a */
    public boolean m8358a(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return mo2467a(new C2858a(componentName, 129), serviceConnection, str);
    }

    /* renamed from: a */
    public final void m8357a(String str, String str2, int i, ServiceConnection serviceConnection, String str3) {
        mo2468b(new C2858a(str, str2, i), serviceConnection, str3);
    }

    /* renamed from: b */
    public void m8360b(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        mo2468b(new C2858a(componentName, 129), serviceConnection, str);
    }
}
