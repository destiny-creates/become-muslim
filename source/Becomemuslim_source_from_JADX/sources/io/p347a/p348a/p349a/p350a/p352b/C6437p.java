package io.p347a.p348a.p349a.p350a.p352b;

import android.content.Context;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.p350a.p351a.C6416d;
import io.p347a.p348a.p349a.p350a.p351a.C8179b;

/* compiled from: InstallerPackageNameProvider */
/* renamed from: io.a.a.a.a.b.p */
public class C6437p {
    /* renamed from: a */
    private final C6416d<String> f20802a = new C76051(this);
    /* renamed from: b */
    private final C8179b<String> f20803b = new C8179b();

    /* compiled from: InstallerPackageNameProvider */
    /* renamed from: io.a.a.a.a.b.p$1 */
    class C76051 implements C6416d<String> {
        /* renamed from: a */
        final /* synthetic */ C6437p f26304a;

        C76051(C6437p c6437p) {
            this.f26304a = c6437p;
        }

        /* renamed from: c */
        public /* synthetic */ Object mo5436c(Context context) {
            return m34341a(context);
        }

        /* renamed from: a */
        public String m34341a(Context context) {
            context = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            return context == null ? "" : context;
        }
    }

    /* renamed from: a */
    public String m26419a(Context context) {
        try {
            context = (String) this.f20803b.mo5433a(context, this.f20802a);
            if ("".equals(context)) {
                context = null;
            }
            return context;
        } catch (Context context2) {
            C6514c.m26634h().mo5480e("Fabric", "Failed to determine installer package name", context2);
            return null;
        }
    }
}
