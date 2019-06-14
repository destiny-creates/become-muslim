package expolib_v1.p321a.p322a.p327e;

import expolib_v1.p321a.C6234q;
import expolib_v1.p321a.C6234q.C6233a;
import expolib_v1.p321a.C6244x;
import expolib_v1.p321a.C6246z;
import expolib_v1.p321a.C7490w;
import expolib_v1.p321a.ab;
import expolib_v1.p321a.ab.C6208a;
import expolib_v1.p321a.ac;
import expolib_v1.p321a.p322a.C6148a;
import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p321a.p322a.p324b.C6154g;
import expolib_v1.p321a.p322a.p325c.C6157c;
import expolib_v1.p321a.p322a.p325c.C6162i;
import expolib_v1.p321a.p322a.p325c.C6163k;
import expolib_v1.p321a.p322a.p325c.C7443h;
import expolib_v1.p332b.C6251f;
import expolib_v1.p332b.C6252l;
import expolib_v1.p332b.C6257r;
import expolib_v1.p332b.C6258s;
import expolib_v1.p332b.C7499h;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: Http2Codec */
/* renamed from: expolib_v1.a.a.e.f */
public final class C7449f implements C6157c {
    /* renamed from: b */
    private static final C6251f f25843b = C6251f.m25837a("connection");
    /* renamed from: c */
    private static final C6251f f25844c = C6251f.m25837a("host");
    /* renamed from: d */
    private static final C6251f f25845d = C6251f.m25837a("keep-alive");
    /* renamed from: e */
    private static final C6251f f25846e = C6251f.m25837a("proxy-connection");
    /* renamed from: f */
    private static final C6251f f25847f = C6251f.m25837a("transfer-encoding");
    /* renamed from: g */
    private static final C6251f f25848g = C6251f.m25837a("te");
    /* renamed from: h */
    private static final C6251f f25849h = C6251f.m25837a("encoding");
    /* renamed from: i */
    private static final C6251f f25850i = C6251f.m25837a("upgrade");
    /* renamed from: j */
    private static final List<C6251f> f25851j = C6165c.m25311a(f25843b, f25844c, f25845d, f25846e, f25848g, f25847f, f25849h, f25850i, C6170c.f19933c, C6170c.f19934d, C6170c.f19935e, C6170c.f19936f);
    /* renamed from: k */
    private static final List<C6251f> f25852k = C6165c.m25311a(f25843b, f25844c, f25845d, f25846e, f25848g, f25847f, f25849h, f25850i);
    /* renamed from: a */
    final C6154g f25853a;
    /* renamed from: l */
    private final C7490w f25854l;
    /* renamed from: m */
    private final C6177g f25855m;
    /* renamed from: n */
    private C6180i f25856n;

    /* compiled from: Http2Codec */
    /* renamed from: expolib_v1.a.a.e.f$a */
    class C8166a extends C7499h {
        /* renamed from: a */
        final /* synthetic */ C7449f f30344a;

        public C8166a(C7449f c7449f, C6258s c6258s) {
            this.f30344a = c7449f;
            super(c6258s);
        }

        public void close() {
            this.f30344a.f25853a.m25260a(false, this.f30344a);
            super.close();
        }
    }

    public C7449f(C7490w c7490w, C6154g c6154g, C6177g c6177g) {
        this.f25854l = c7490w;
        this.f25853a = c6154g;
        this.f25855m = c6177g;
    }

    /* renamed from: a */
    public C6257r mo5263a(C6246z c6246z, long j) {
        return this.f25856n.m25429h();
    }

    /* renamed from: a */
    public void mo5265a(C6246z c6246z) {
        if (this.f25856n == null) {
            this.f25856n = this.f25855m.m25369a(C7449f.m33852b(c6246z), c6246z.m25826d() != null);
            this.f25856n.m25426e().mo5349a((long) this.f25854l.m33972b(), TimeUnit.MILLISECONDS);
            this.f25856n.m25427f().mo5349a((long) this.f25854l.m33973c(), TimeUnit.MILLISECONDS);
        }
    }

    /* renamed from: a */
    public void mo5264a() {
        this.f25855m.m25382b();
    }

    /* renamed from: b */
    public void mo5266b() {
        this.f25856n.m25429h().close();
    }

    /* renamed from: a */
    public C6208a mo5261a(boolean z) {
        C6208a a = C7449f.m33851a(this.f25856n.m25425d());
        return (z && C6148a.f19868a.mo5328a(a)) ? false : a;
    }

    /* renamed from: b */
    public static List<C6170c> m33852b(C6246z c6246z) {
        C6234q c = c6246z.m25825c();
        List<C6170c> arrayList = new ArrayList(c.m25716a() + 4);
        arrayList.add(new C6170c(C6170c.f19933c, c6246z.m25823b()));
        arrayList.add(new C6170c(C6170c.f19934d, C6162i.m25298a(c6246z.m25821a())));
        String a = c6246z.m25822a("Host");
        if (a != null) {
            arrayList.add(new C6170c(C6170c.f19936f, a));
        }
        arrayList.add(new C6170c(C6170c.f19935e, c6246z.m25821a().m25763b()));
        int a2 = c.m25716a();
        for (int i = null; i < a2; i++) {
            C6251f a3 = C6251f.m25837a(c.m25717a(i).toLowerCase(Locale.US));
            if (!f25851j.contains(a3)) {
                arrayList.add(new C6170c(a3, c.m25720b(i)));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static C6208a m33851a(List<C6170c> list) {
        C6233a c6233a = new C6233a();
        int size = list.size();
        C6233a c6233a2 = c6233a;
        C6163k c6163k = null;
        for (int i = 0; i < size; i++) {
            C6170c c6170c = (C6170c) list.get(i);
            if (c6170c != null) {
                C6251f c6251f = c6170c.f19937g;
                String a = c6170c.f19938h.mo5355a();
                if (c6251f.equals(C6170c.f19932b)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("HTTP/1.1 ");
                    stringBuilder.append(a);
                    c6163k = C6163k.m25301a(stringBuilder.toString());
                } else if (!f25852k.contains(c6251f)) {
                    C6148a.f19868a.mo5335a(c6233a2, c6251f.mo5355a(), a);
                }
            } else if (c6163k != null && c6163k.f19905b == 100) {
                c6233a2 = new C6233a();
                c6163k = null;
            }
        }
        if (c6163k != null) {
            return new C6208a().m25566a(C6244x.HTTP_2).m25560a(c6163k.f19905b).m25568a(c6163k.f19906c).m25565a(c6233a2.m25709a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    /* renamed from: a */
    public ac mo5262a(ab abVar) {
        return new C7443h(abVar.m25584g(), C6252l.m25859a(new C8166a(this, this.f25856n.m25428g())));
    }

    /* renamed from: c */
    public void mo5267c() {
        if (this.f25856n != null) {
            this.f25856n.m25421b(C6169b.CANCEL);
        }
    }
}
