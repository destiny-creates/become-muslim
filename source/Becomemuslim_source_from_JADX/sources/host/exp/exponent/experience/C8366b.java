package host.exp.exponent.experience;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import expo.adapters.react.C7372e;
import expo.p304a.p305a.C6002i;
import expo.p304a.p305a.C6003j;
import host.exp.exponent.C6301d;
import host.exp.p333a.C6263a;
import java.util.List;
import versioned.host.exp.exponent.ExponentPackageDelegate;
import versioned.host.exp.exponent.modules.universal.ExpoModuleRegistryAdapter;

/* compiled from: DetachActivity */
/* renamed from: host.exp.exponent.experience.b */
public abstract class C8366b extends ExperienceActivity implements ExponentPackageDelegate {
    /* renamed from: a */
    public abstract String mo6917a();

    /* renamed from: b */
    public abstract String mo6918b();

    /* renamed from: e */
    public abstract boolean mo6919e();

    /* renamed from: l */
    public ExponentPackageDelegate mo5397l() {
        return this;
    }

    protected void onCreate(Bundle bundle) {
        C6263a.f20400b = mo6919e();
        C6301d.f20496b = mo6919e() ? mo6918b() : mo6917a();
        this.f = C6301d.f20496b;
        super.onCreate(bundle);
        this.a.m34240a((Activity) this, getIntent());
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.a.m34240a((Activity) this, intent);
    }

    /* renamed from: k */
    public void mo6921k() {
        if (this.f != null && this.a.m34249b(this.f).booleanValue()) {
            m44591a(this.a.m34253c(this.f));
        } else if (mo6919e() && this.a.m34249b(mo6917a()).booleanValue()) {
            m44591a(this.a.m34253c(mo6917a()));
        }
    }

    public ExpoModuleRegistryAdapter getScopedModuleRegistryAdapterForPackages(List<C6002i> list, List<C6003j> list2) {
        return new C8264c(new C7372e(list, list2));
    }
}
