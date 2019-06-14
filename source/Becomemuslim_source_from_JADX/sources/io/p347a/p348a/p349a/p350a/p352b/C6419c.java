package io.p347a.p348a.p349a.p350a.p352b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.p350a.p357f.C6490c;
import io.p347a.p348a.p349a.p350a.p357f.C7619d;

/* compiled from: AdvertisingInfoProvider */
/* renamed from: io.a.a.a.a.b.c */
class C6419c {
    /* renamed from: a */
    private final Context f20750a;
    /* renamed from: b */
    private final C6490c f20751b;

    public C6419c(Context context) {
        this.f20750a = context.getApplicationContext();
        this.f20751b = new C7619d(context, "TwitterAdvertisingInfoPreferences");
    }

    /* renamed from: a */
    public C6418b m26332a() {
        C6418b b = m26333b();
        if (m26330c(b)) {
            C6514c.m26634h().mo5472a("Fabric", "Using AdvertisingInfo from Preference Store");
            m26327a(b);
            return b;
        }
        b = m26331e();
        m26329b(b);
        return b;
    }

    /* renamed from: a */
    private void m26327a(final C6418b c6418b) {
        new Thread(new C6425h(this) {
            /* renamed from: b */
            final /* synthetic */ C6419c f26295b;

            /* renamed from: a */
            public void mo5434a() {
                C6418b a = this.f26295b.m26331e();
                if (!c6418b.equals(a)) {
                    C6514c.m26634h().mo5472a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
                    this.f26295b.m26329b(a);
                }
            }
        }).start();
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: b */
    private void m26329b(C6418b c6418b) {
        if (m26330c(c6418b)) {
            this.f20751b.mo5463a(this.f20751b.mo5464b().putString("advertising_id", c6418b.f20748a).putBoolean("limit_ad_tracking_enabled", c6418b.f20749b));
        } else {
            this.f20751b.mo5463a(this.f20751b.mo5464b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
        }
    }

    /* renamed from: b */
    protected C6418b m26333b() {
        return new C6418b(this.f20751b.mo5462a().getString("advertising_id", ""), this.f20751b.mo5462a().getBoolean("limit_ad_tracking_enabled", false));
    }

    /* renamed from: c */
    public C6423f m26334c() {
        return new C7599d(this.f20750a);
    }

    /* renamed from: d */
    public C6423f m26335d() {
        return new C7600e(this.f20750a);
    }

    /* renamed from: c */
    private boolean m26330c(C6418b c6418b) {
        return (c6418b == null || TextUtils.isEmpty(c6418b.f20748a) != null) ? null : true;
    }

    /* renamed from: e */
    private C6418b m26331e() {
        C6418b a = m26334c().mo5435a();
        if (m26330c(a)) {
            C6514c.m26634h().mo5472a("Fabric", "Using AdvertisingInfo from Reflection Provider");
        } else {
            a = m26335d().mo5435a();
            if (m26330c(a)) {
                C6514c.m26634h().mo5472a("Fabric", "Using AdvertisingInfo from Service Provider");
            } else {
                C6514c.m26634h().mo5472a("Fabric", "AdvertisingInfo not present");
            }
        }
        return a;
    }
}
