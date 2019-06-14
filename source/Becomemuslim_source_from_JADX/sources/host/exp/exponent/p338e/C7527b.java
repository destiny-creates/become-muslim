package host.exp.exponent.p338e;

import android.os.Handler;
import android.os.Looper;
import expo.p318c.p319a.p320a.C6046c;
import host.exp.exponent.C6394j;

/* compiled from: HeadlessAppRecord */
/* renamed from: host.exp.exponent.e.b */
public class C7527b implements C6046c {
    /* renamed from: a */
    private C6394j f26103a;

    /* renamed from: a */
    public void m34147a(C6394j c6394j) {
        this.f26103a = c6394j;
    }

    /* renamed from: a */
    public void mo5399a() {
        if (this.f26103a != null) {
            final C6394j c6394j = this.f26103a;
            this.f26103a = null;
            new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C7527b f20515b;

                public void run() {
                    if (c6394j.m26243b()) {
                        c6394j.m26236a("destroy", new Object[0]);
                    }
                }
            });
        }
    }
}
