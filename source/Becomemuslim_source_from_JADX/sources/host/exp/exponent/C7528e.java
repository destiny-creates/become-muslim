package host.exp.exponent;

import android.app.Application;
import android.content.Context;
import android.support.p019f.C0213b;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.soloader.SoLoader;
import com.p064b.p065a.C3414a;
import com.p064b.p065a.C3414a.C0981a;
import com.p064b.p065a.p068c.C1037i;
import com.p064b.p065a.p068c.C3424f;
import com.p064b.p065a.p068c.C3424f.C1030a;
import expo.p318c.p319a.C6047a;
import host.exp.exponent.modules.ExponentKernelModule;
import host.exp.exponent.p334a.C6288a;
import host.exp.exponent.p334a.C6288a.C6287a;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p335b.C6291a;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p338e.C7526a;
import host.exp.exponent.p339f.C6334g;
import host.exp.exponent.p339f.C6338h;
import host.exp.exponent.p339f.C6338h.C6335a;
import host.exp.exponent.p339f.C6352l;
import host.exp.exponent.p339f.C6353m;
import host.exp.exponent.p339f.C6355n;
import host.exp.exponent.p339f.C6355n.C6354a;
import host.exp.exponent.p339f.C7560j;
import host.exp.exponent.p344h.C6373d;
import host.exp.p333a.C6263a;
import host.exp.p333a.C6271b;
import io.p347a.p348a.p349a.C6514c;
import javax.inject.C6562a;
import me.leolin.shortcutbadger.C6565c;

/* compiled from: ExpoApplication */
/* renamed from: host.exp.exponent.e */
public abstract class C7528e extends C0213b {
    /* renamed from: b */
    private static final String f26104b = "e";
    @C6562a
    /* renamed from: a */
    C6373d f26105a;

    /* compiled from: ExpoApplication */
    /* renamed from: host.exp.exponent.e$1 */
    class C75201 implements C6354a {
        /* renamed from: a */
        final /* synthetic */ C7528e f26082a;

        C75201(C7528e c7528e) {
            this.f26082a = c7528e;
        }

        /* renamed from: a */
        public C6353m mo5382a() {
            return new C7560j();
        }
    }

    /* compiled from: ExpoApplication */
    /* renamed from: host.exp.exponent.e$2 */
    class C75212 implements C6335a {
        /* renamed from: a */
        final /* synthetic */ C7528e f26083a;

        C75212(C7528e c7528e) {
            this.f26083a = c7528e;
        }

        /* renamed from: a */
        public C6334g mo5383a(ReactApplicationContext reactApplicationContext) {
            return new ExponentKernelModule(reactApplicationContext);
        }
    }

    /* compiled from: ExpoApplication */
    /* renamed from: host.exp.exponent.e$3 */
    class C75223 implements C1037i {
        /* renamed from: a */
        final /* synthetic */ C7528e f26084a;

        C75223(C7528e c7528e) {
            this.f26084a = c7528e;
        }

        /* renamed from: a */
        public void m34105a() {
            this.f26084a.f26105a.m26153a("should_not_use_kernel_cache", true);
        }
    }

    /* renamed from: c */
    public abstract String mo6406c();

    /* renamed from: d */
    public abstract boolean mo6407d();

    /* renamed from: e */
    public abstract boolean mo6408e();

    public void onCreate() {
        super.onCreate();
        C6263a.f20400b = mo6407d();
        C6263a.f20399a = mo6408e();
        boolean z = C6263a.f20400b;
        if (!C6301d.m26001a()) {
            C6352l.f20614b = LauncherActivity.class;
        }
        C6047a.m25174a("react-native-experience", C7526a.class);
        C6355n.m26074a(new C75201(this));
        C6338h.m26058a(new C75212(this));
        C6271b.m25899a((Context) this, (Application) this);
        C6294a.m25957a().m25960a(C7560j.class, C6355n.m26073a());
        C6271b.m25897a().m25921b(mo6406c());
        C6294a.m25957a().m25961b(C7528e.class, this);
        if (!C6263a.f20400b) {
            C3424f a = new C1030a().a(new C75223(this)).a();
            C6514c.m26625a((Context) this, new C0981a().a(a).a());
            try {
                C3414a.a("exp_client_version", C6301d.m25999a((Context) this));
                if (C6301d.f20496b != null) {
                    C3414a.a("initial_url", C6301d.f20496b);
                }
            } catch (Throwable th) {
                C6289b.m25953c(f26104b, th.toString());
            }
        }
        C6291a.m25956a(this);
        try {
            C6565c.m26767a(this);
        } catch (Throwable th2) {
            C6289b.m25950a(f26104b, th2);
        }
        C6288a.m25941a(C6287a.LAUNCHER_ACTIVITY_STARTED);
        SoLoader.init(getApplicationContext(), false);
        Thread.setDefaultUncaughtExceptionHandler(new C6374h(getApplicationContext()));
    }
}
