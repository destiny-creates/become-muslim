package host.exp.exponent.p343g;

import expolib_v1.p321a.C6234q;
import expolib_v1.p321a.ab;
import expolib_v1.p321a.ac;
import java.io.InputStream;

/* compiled from: OkHttpV1ExpoResponse */
/* renamed from: host.exp.exponent.g.g */
public class C7579g implements C6364d {
    /* renamed from: a */
    ab f26233a;

    /* compiled from: OkHttpV1ExpoResponse */
    /* renamed from: host.exp.exponent.g.g$a */
    class C7577a implements C6361a {
        /* renamed from: a */
        ac f26229a;
        /* renamed from: b */
        final /* synthetic */ C7579g f26230b;

        public C7577a(C7579g c7579g, ac acVar) {
            this.f26230b = c7579g;
            this.f26229a = acVar;
        }

        /* renamed from: a */
        public String mo5419a() {
            return this.f26229a.string();
        }

        /* renamed from: b */
        public InputStream mo5420b() {
            return this.f26229a.byteStream();
        }

        /* renamed from: c */
        public byte[] mo5421c() {
            return this.f26229a.bytes();
        }
    }

    /* compiled from: OkHttpV1ExpoResponse */
    /* renamed from: host.exp.exponent.g.g$b */
    public class C7578b implements C6362b {
        /* renamed from: a */
        C6234q f26231a;
        /* renamed from: b */
        final /* synthetic */ C7579g f26232b;

        public C7578b(C7579g c7579g, C6234q c6234q) {
            this.f26232b = c7579g;
            this.f26231a = c6234q;
        }

        /* renamed from: a */
        public String mo5422a(String str) {
            return this.f26231a.m25718a(str);
        }
    }

    public C7579g(ab abVar) {
        this.f26233a = abVar;
    }

    /* renamed from: a */
    public boolean mo5423a() {
        return this.f26233a.m25581d();
    }

    /* renamed from: b */
    public C6361a mo5424b() {
        return new C7577a(this, this.f26233a.m25585h());
    }

    /* renamed from: c */
    public int mo5425c() {
        return this.f26233a.m25580c();
    }

    /* renamed from: d */
    public C6362b mo5426d() {
        return new C7578b(this, this.f26233a.m25584g());
    }

    /* renamed from: e */
    public C6364d mo5427e() {
        if (this.f26233a.m25587j() == null) {
            return null;
        }
        return new C7579g(this.f26233a.m25587j());
    }
}
