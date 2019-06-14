package android.support.p015c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.C0296g;
import android.support.v4.content.C0366b;
import java.util.ArrayList;

/* compiled from: CustomTabsIntent */
/* renamed from: android.support.c.c */
public final class C0107c {
    /* renamed from: a */
    public final Intent f240a;
    /* renamed from: b */
    public final Bundle f241b;

    /* compiled from: CustomTabsIntent */
    /* renamed from: android.support.c.c$a */
    public static final class C0106a {
        /* renamed from: a */
        private final Intent f235a;
        /* renamed from: b */
        private ArrayList<Bundle> f236b;
        /* renamed from: c */
        private Bundle f237c;
        /* renamed from: d */
        private ArrayList<Bundle> f238d;
        /* renamed from: e */
        private boolean f239e;

        public C0106a() {
            this(null);
        }

        public C0106a(C0109e c0109e) {
            this.f235a = new Intent("android.intent.action.VIEW");
            IBinder iBinder = null;
            this.f236b = null;
            this.f237c = null;
            this.f238d = null;
            this.f239e = true;
            if (c0109e != null) {
                this.f235a.setPackage(c0109e.m220b().getPackageName());
            }
            Bundle bundle = new Bundle();
            String str = "android.support.customtabs.extra.SESSION";
            if (c0109e != null) {
                iBinder = c0109e.m218a();
            }
            C0296g.m872a(bundle, str, iBinder);
            this.f235a.putExtras(bundle);
        }

        /* renamed from: a */
        public C0107c m215a() {
            if (this.f236b != null) {
                this.f235a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", this.f236b);
            }
            if (this.f238d != null) {
                this.f235a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", this.f238d);
            }
            this.f235a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f239e);
            return new C0107c(this.f235a, this.f237c);
        }
    }

    /* renamed from: a */
    public void m216a(Context context, Uri uri) {
        this.f240a.setData(uri);
        C0366b.m1105a(context, this.f240a, this.f241b);
    }

    private C0107c(Intent intent, Bundle bundle) {
        this.f240a = intent;
        this.f241b = bundle;
    }
}
