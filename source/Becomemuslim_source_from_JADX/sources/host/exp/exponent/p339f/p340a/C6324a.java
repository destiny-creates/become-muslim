package host.exp.exponent.p339f.p340a;

import android.content.Context;
import de.p287a.p288a.C5884c;
import host.exp.exponent.experience.C8362a.C7542a;
import host.exp.exponent.experience.C8362a.C7544d;
import host.exp.exponent.p339f.C6330b;

/* compiled from: BaseKernelService */
/* renamed from: host.exp.exponent.f.a.a */
public abstract class C6324a {
    /* renamed from: a */
    private Context f20541a;
    /* renamed from: b */
    private C6330b f20542b = null;

    /* renamed from: a */
    public abstract void mo5404a(C6330b c6330b);

    /* renamed from: b */
    public abstract void mo5405b(C6330b c6330b);

    public C6324a(Context context) {
        this.f20541a = context;
        C5884c.m24753a().m24765a((Object) this);
    }

    /* renamed from: a */
    protected Context m26011a() {
        return this.f20541a;
    }

    /* renamed from: b */
    protected C6330b m26013b() {
        return this.f20542b;
    }

    public void onEvent(C7542a c7542a) {
        this.f20542b = null;
        mo5405b(c7542a.mo5403a());
    }

    public void onEvent(C7544d c7544d) {
        this.f20542b = c7544d.mo5403a();
        mo5404a(c7544d.mo5403a());
    }
}
