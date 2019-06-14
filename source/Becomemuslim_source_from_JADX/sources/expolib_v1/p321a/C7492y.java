package expolib_v1.p321a;

import expolib_v1.p321a.p322a.C6155b;
import expolib_v1.p321a.p322a.p323a.C7436a;
import expolib_v1.p321a.p322a.p324b.C6154g;
import expolib_v1.p321a.p322a.p324b.C7437a;
import expolib_v1.p321a.p322a.p325c.C7440a;
import expolib_v1.p321a.p322a.p325c.C7441b;
import expolib_v1.p321a.p322a.p325c.C7442g;
import expolib_v1.p321a.p322a.p325c.C7444j;
import expolib_v1.p321a.p322a.p329g.C6192e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RealCall */
/* renamed from: expolib_v1.a.y */
final class C7492y implements C6216e {
    /* renamed from: a */
    final C7490w f26022a;
    /* renamed from: b */
    final C7444j f26023b;
    /* renamed from: c */
    final C6246z f26024c;
    /* renamed from: d */
    final boolean f26025d;
    /* renamed from: e */
    private boolean f26026e;

    /* compiled from: RealCall */
    /* renamed from: expolib_v1.a.y$a */
    final class C7491a extends C6155b {
        /* renamed from: a */
        final /* synthetic */ C7492y f26020a;
        /* renamed from: c */
        private final C6217f f26021c;

        C7491a(C7492y c7492y, C6217f c6217f) {
            this.f26020a = c7492y;
            super("OkHttp %s", c7492y.m34008h());
            this.f26021c = c6217f;
        }

        /* renamed from: a */
        String m33996a() {
            return this.f26020a.f26024c.m25821a().m25769f();
        }

        /* renamed from: b */
        C7492y m33997b() {
            return this.f26020a;
        }

        /* renamed from: c */
        protected void mo5268c() {
            Throwable e;
            C6192e b;
            StringBuilder stringBuilder;
            Object obj = 1;
            try {
                ab i = this.f26020a.m34009i();
                if (this.f26020a.f26023b.m33830b()) {
                    try {
                        this.f26021c.onFailure(this.f26020a, new IOException("Canceled"));
                    } catch (IOException e2) {
                        e = e2;
                        if (obj == null) {
                            this.f26021c.onFailure(this.f26020a, e);
                        } else {
                            try {
                                b = C6192e.m25495b();
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("Callback failure for ");
                                stringBuilder.append(this.f26020a.m34007g());
                                b.mo5296a(4, stringBuilder.toString(), e);
                            } catch (Throwable th) {
                                this.f26020a.f26022a.m33990t().m25695b(this);
                            }
                        }
                        this.f26020a.f26022a.m33990t().m25695b(this);
                    }
                }
                this.f26021c.onResponse(this.f26020a, i);
            } catch (Throwable e3) {
                e = e3;
                obj = null;
                if (obj == null) {
                    b = C6192e.m25495b();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Callback failure for ");
                    stringBuilder.append(this.f26020a.m34007g());
                    b.mo5296a(4, stringBuilder.toString(), e);
                } else {
                    this.f26021c.onFailure(this.f26020a, e);
                }
                this.f26020a.f26022a.m33990t().m25695b(this);
            }
            this.f26020a.f26022a.m33990t().m25695b(this);
        }
    }

    public /* synthetic */ Object clone() {
        return m34005e();
    }

    C7492y(C7490w c7490w, C6246z c6246z, boolean z) {
        this.f26022a = c7490w;
        this.f26024c = c6246z;
        this.f26025d = z;
        this.f26023b = new C7444j(c7490w, z);
    }

    /* renamed from: a */
    public C6246z mo5340a() {
        return this.f26024c;
    }

    /* renamed from: b */
    public ab mo5342b() {
        synchronized (this) {
            if (this.f26026e) {
                throw new IllegalStateException("Already Executed");
            }
            this.f26026e = true;
        }
        m33999j();
        try {
            this.f26022a.m33990t().m25693a(this);
            ab i = m34009i();
            if (i != null) {
                return i;
            }
            throw new IOException("Canceled");
        } finally {
            this.f26022a.m33990t().m25696b(this);
        }
    }

    /* renamed from: j */
    private void m33999j() {
        this.f26023b.m33829a(C6192e.m25495b().mo5293a("response.body().close()"));
    }

    /* renamed from: a */
    public void mo5341a(C6217f c6217f) {
        synchronized (this) {
            if (this.f26026e) {
                throw new IllegalStateException("Already Executed");
            }
            this.f26026e = true;
        }
        m33999j();
        this.f26022a.m33990t().m25692a(new C7491a(this, c6217f));
    }

    /* renamed from: c */
    public void mo5343c() {
        this.f26023b.m33828a();
    }

    /* renamed from: d */
    public boolean mo5344d() {
        return this.f26023b.m33830b();
    }

    /* renamed from: e */
    public C7492y m34005e() {
        return new C7492y(this.f26022a, this.f26024c, this.f26025d);
    }

    /* renamed from: f */
    C6154g m34006f() {
        return this.f26023b.m33831c();
    }

    /* renamed from: g */
    String m34007g() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mo5344d() ? "canceled " : "");
        stringBuilder.append(this.f26025d ? "web socket" : "call");
        stringBuilder.append(" to ");
        stringBuilder.append(m34008h());
        return stringBuilder.toString();
    }

    /* renamed from: h */
    String m34008h() {
        return this.f26024c.m25821a().m25777n();
    }

    /* renamed from: i */
    ab m34009i() {
        List arrayList = new ArrayList();
        arrayList.addAll(this.f26022a.m33993w());
        arrayList.add(this.f26023b);
        arrayList.add(new C7440a(this.f26022a.m33977g()));
        arrayList.add(new C7436a(this.f26022a.m33978h()));
        arrayList.add(new C7437a(this.f26022a));
        if (!this.f26025d) {
            arrayList.addAll(this.f26022a.m33994x());
        }
        arrayList.add(new C7441b(this.f26025d));
        return new C7442g(arrayList, null, null, null, 0, this.f26024c).mo5252a(this.f26024c);
    }
}
