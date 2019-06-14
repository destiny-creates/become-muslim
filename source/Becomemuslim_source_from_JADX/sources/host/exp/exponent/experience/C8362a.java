package host.exp.exponent.experience;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.android.gms.common.C4361e;
import de.p287a.p288a.C5884c;
import host.exp.exponent.C6301d;
import host.exp.exponent.C6394j;
import host.exp.exponent.experience.C8355f.C6321a;
import host.exp.exponent.gcm.GcmRegistrationIntentService;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p339f.C6330b;
import host.exp.exponent.p339f.C6332e;
import host.exp.exponent.p339f.C6333f;
import host.exp.exponent.p339f.C7560j;
import host.exp.exponent.p346j.C6383a;
import host.exp.exponent.p346j.C6383a.C6382a;
import host.exp.p333a.C6271b;
import javax.inject.C6562a;

/* compiled from: BaseExperienceActivity */
/* renamed from: host.exp.exponent.experience.a */
public abstract class C8362a extends C8359e {
    /* renamed from: b */
    private static C8362a f32969b;
    @C6562a
    /* renamed from: a */
    C7560j f32970a;
    /* renamed from: t */
    private long f32971t;

    /* compiled from: BaseExperienceActivity */
    /* renamed from: host.exp.exponent.experience.a$2 */
    class C63152 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C8362a f20536a;

        C63152(C8362a c8362a) {
            this.f20536a = c8362a;
        }

        public void run() {
            if (!C8355f.f32899q.isEmpty()) {
                Pair j = C8362a.mo6917a();
                boolean booleanValue = ((Boolean) j.first).booleanValue();
                C6333f c6333f = (C6333f) j.second;
                if (this.f20536a.m44467a(c6333f) && booleanValue) {
                    if (!this.f20536a.mo6900h()) {
                        this.f20536a.m44478x();
                        this.f20536a.c.m26242b(null);
                        this.f20536a.l.m26242b(null);
                    }
                    this.f20536a.d = true;
                    this.f20536a.m = false;
                    Intent intent = new Intent(this.f20536a, ErrorActivity.class);
                    intent.addFlags(603979776);
                    this.f20536a.mo6909a(intent);
                    intent.putExtra("isDebugModeEnabled", this.f20536a.mo6900h());
                    intent.putExtra("userErrorMessage", c6333f.m26053a());
                    intent.putExtra("developerErrorMessage", c6333f.m26055b());
                    this.f20536a.startActivity(intent);
                    C5884c.m24753a().m24769d(new C6321a());
                }
            }
        }
    }

    /* compiled from: BaseExperienceActivity */
    /* renamed from: host.exp.exponent.experience.a$c */
    private static abstract class C6316c {
        /* renamed from: a */
        private C6330b f20537a;

        C6316c(C6330b c6330b) {
            this.f20537a = c6330b;
        }

        /* renamed from: a */
        public C6330b mo5403a() {
            return this.f20537a;
        }
    }

    /* compiled from: BaseExperienceActivity */
    /* renamed from: host.exp.exponent.experience.a$1 */
    class C75411 implements C6382a {
        /* renamed from: a */
        final /* synthetic */ C8362a f26139a;

        C75411(C8362a c8362a) {
            this.f26139a = c8362a;
        }

        /* renamed from: a */
        public boolean mo5390a() {
            if (this.f26139a.h == null) {
                if (!(this.f26139a instanceof HomeActivity)) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: b */
        public void mo5391b() {
            C5884c.m24753a().m24769d(new C7544d(this.f26139a.h));
        }
    }

    /* compiled from: BaseExperienceActivity */
    /* renamed from: host.exp.exponent.experience.a$a */
    public static class C7542a extends C6316c {
        /* renamed from: a */
        public /* bridge */ /* synthetic */ C6330b mo5403a() {
            return super.mo5403a();
        }

        C7542a(C6330b c6330b) {
            super(c6330b);
        }
    }

    /* compiled from: BaseExperienceActivity */
    /* renamed from: host.exp.exponent.experience.a$b */
    public static class C7543b extends C6316c {
        /* renamed from: a */
        public /* bridge */ /* synthetic */ C6330b mo5403a() {
            return super.mo5403a();
        }

        public C7543b(C6330b c6330b) {
            super(c6330b);
        }
    }

    /* compiled from: BaseExperienceActivity */
    /* renamed from: host.exp.exponent.experience.a$d */
    public static class C7544d extends C6316c {
        /* renamed from: a */
        public /* bridge */ /* synthetic */ C6330b mo5403a() {
            return super.mo5403a();
        }

        C7544d(C6330b c6330b) {
            super(c6330b);
        }
    }

    /* renamed from: a */
    protected void mo6909a(Intent intent) {
    }

    /* renamed from: b */
    protected void mo6910b(C6332e c6332e) {
    }

    /* renamed from: h */
    public boolean mo6900h() {
        return false;
    }

    /* renamed from: a */
    public static void m44555a(C6332e c6332e) {
        q.add(c6332e);
        if (f32969b != null) {
            f32969b.m44560g();
        } else if (ErrorActivity.m44447a() != null) {
            C8362a.mo6917a();
        }
    }

    /* renamed from: f */
    public static C8362a m44556f() {
        return f32969b;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.p = true;
        this.l = new C6394j("com.facebook.react.ReactRootView");
        C6294a.m25957a().m25961b(C8362a.class, this);
    }

    protected void onResume() {
        super.onResume();
        this.f32970a.m34239a((Activity) this);
        C6271b.m25897a().m25911a((Activity) this);
        f32969b = this;
        m44560g();
        this.p = true;
        this.f32971t = System.currentTimeMillis();
        C6383a.m26190a("experienceIdSetForActivity", new C75411(this));
    }

    protected void onPause() {
        C5884c.m24753a().m24769d(new C7542a(this.h));
        super.onPause();
        if (System.currentTimeMillis() - this.f32971t > 500) {
            this.p = false;
            if (f32969b == this) {
                f32969b = null;
            }
        }
    }

    public void onBackPressed() {
        if (this.c == null || !this.c.m26243b() || this.d) {
            moveTaskToBack(true);
        } else {
            this.c.m26236a("onBackPressed", new Object[0]);
        }
    }

    public void invokeDefaultOnBackPressed() {
        moveTaskToBack(true);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!(this instanceof HomeActivity)) {
            if (this.c != null && this.c.m26243b()) {
                this.c.m26250g();
                this.c.m26242b(null);
            }
            this.l.m26242b(null);
            Fresco.initialize(getApplicationContext());
        }
    }

    /* renamed from: g */
    protected void m44560g() {
        if (!q.isEmpty()) {
            runOnUiThread(new C63152(this));
        }
    }

    /* renamed from: a */
    private static Pair<Boolean, C6333f> mo6917a() {
        boolean z;
        Object a = C6333f.m26051a("");
        synchronized (q) {
            z = false;
            while (!q.isEmpty()) {
                C6332e c6332e = (C6332e) q.remove();
                ErrorActivity.m44450a(c6332e);
                if (f32969b != null) {
                    f32969b.mo6910b(c6332e);
                }
                C6333f c6333f = c6332e.f20571a;
                if (c6332e.f20574d) {
                    z = true;
                }
                C6333f c6333f2 = c6333f;
            }
        }
        return new Pair(Boolean.valueOf(z), a);
    }

    /* renamed from: i */
    protected void m44562i() {
        if (C4361e.a().a(this) == 0 && !C6301d.f20507m) {
            startService(new Intent(this, GcmRegistrationIntentService.class));
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        C6271b.m25897a().m25910a(i, strArr, iArr);
    }
}
