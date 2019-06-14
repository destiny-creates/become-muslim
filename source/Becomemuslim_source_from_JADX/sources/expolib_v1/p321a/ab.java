package expolib_v1.p321a;

import com.facebook.stetho.server.http.HttpStatus;
import expolib_v1.p321a.C6234q.C6233a;
import java.io.Closeable;

/* compiled from: Response */
/* renamed from: expolib_v1.a.ab */
public final class ab implements Closeable {
    /* renamed from: a */
    final C6246z f20109a;
    /* renamed from: b */
    final C6244x f20110b;
    /* renamed from: c */
    final int f20111c;
    /* renamed from: d */
    final String f20112d;
    /* renamed from: e */
    final C6232p f20113e;
    /* renamed from: f */
    final C6234q f20114f;
    /* renamed from: g */
    final ac f20115g;
    /* renamed from: h */
    final ab f20116h;
    /* renamed from: i */
    final ab f20117i;
    /* renamed from: j */
    final ab f20118j;
    /* renamed from: k */
    final long f20119k;
    /* renamed from: l */
    final long f20120l;
    /* renamed from: m */
    private volatile C6214d f20121m;

    /* compiled from: Response */
    /* renamed from: expolib_v1.a.ab$a */
    public static class C6208a {
        /* renamed from: a */
        C6246z f20097a;
        /* renamed from: b */
        C6244x f20098b;
        /* renamed from: c */
        int f20099c;
        /* renamed from: d */
        String f20100d;
        /* renamed from: e */
        C6232p f20101e;
        /* renamed from: f */
        C6233a f20102f;
        /* renamed from: g */
        ac f20103g;
        /* renamed from: h */
        ab f20104h;
        /* renamed from: i */
        ab f20105i;
        /* renamed from: j */
        ab f20106j;
        /* renamed from: k */
        long f20107k;
        /* renamed from: l */
        long f20108l;

        public C6208a() {
            this.f20099c = -1;
            this.f20102f = new C6233a();
        }

        C6208a(ab abVar) {
            this.f20099c = -1;
            this.f20097a = abVar.f20109a;
            this.f20098b = abVar.f20110b;
            this.f20099c = abVar.f20111c;
            this.f20100d = abVar.f20112d;
            this.f20101e = abVar.f20113e;
            this.f20102f = abVar.f20114f.m25719b();
            this.f20103g = abVar.f20115g;
            this.f20104h = abVar.f20116h;
            this.f20105i = abVar.f20117i;
            this.f20106j = abVar.f20118j;
            this.f20107k = abVar.f20119k;
            this.f20108l = abVar.f20120l;
        }

        /* renamed from: a */
        public C6208a m25567a(C6246z c6246z) {
            this.f20097a = c6246z;
            return this;
        }

        /* renamed from: a */
        public C6208a m25566a(C6244x c6244x) {
            this.f20098b = c6244x;
            return this;
        }

        /* renamed from: a */
        public C6208a m25560a(int i) {
            this.f20099c = i;
            return this;
        }

        /* renamed from: a */
        public C6208a m25568a(String str) {
            this.f20100d = str;
            return this;
        }

        /* renamed from: a */
        public C6208a m25564a(C6232p c6232p) {
            this.f20101e = c6232p;
            return this;
        }

        /* renamed from: a */
        public C6208a m25569a(String str, String str2) {
            this.f20102f.m25712c(str, str2);
            return this;
        }

        /* renamed from: b */
        public C6208a m25574b(String str, String str2) {
            this.f20102f.m25708a(str, str2);
            return this;
        }

        /* renamed from: b */
        public C6208a m25573b(String str) {
            this.f20102f.m25710b(str);
            return this;
        }

        /* renamed from: a */
        public C6208a m25565a(C6234q c6234q) {
            this.f20102f = c6234q.m25719b();
            return this;
        }

        /* renamed from: a */
        public C6208a m25563a(ac acVar) {
            this.f20103g = acVar;
            return this;
        }

        /* renamed from: a */
        public C6208a m25562a(ab abVar) {
            if (abVar != null) {
                m25558a("networkResponse", abVar);
            }
            this.f20104h = abVar;
            return this;
        }

        /* renamed from: b */
        public C6208a m25572b(ab abVar) {
            if (abVar != null) {
                m25558a("cacheResponse", abVar);
            }
            this.f20105i = abVar;
            return this;
        }

        /* renamed from: a */
        private void m25558a(String str, ab abVar) {
            StringBuilder stringBuilder;
            if (abVar.f20115g != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(".body != null");
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (abVar.f20116h != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(".networkResponse != null");
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (abVar.f20117i != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(".cacheResponse != null");
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (abVar.f20118j != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(".priorResponse != null");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }

        /* renamed from: c */
        public C6208a m25575c(ab abVar) {
            if (abVar != null) {
                m25559d(abVar);
            }
            this.f20106j = abVar;
            return this;
        }

        /* renamed from: d */
        private void m25559d(ab abVar) {
            if (abVar.f20115g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        /* renamed from: a */
        public C6208a m25561a(long j) {
            this.f20107k = j;
            return this;
        }

        /* renamed from: b */
        public C6208a m25571b(long j) {
            this.f20108l = j;
            return this;
        }

        /* renamed from: a */
        public ab m25570a() {
            if (this.f20097a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f20098b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f20099c >= 0) {
                return new ab(this);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("code < 0: ");
                stringBuilder.append(this.f20099c);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    ab(C6208a c6208a) {
        this.f20109a = c6208a.f20097a;
        this.f20110b = c6208a.f20098b;
        this.f20111c = c6208a.f20099c;
        this.f20112d = c6208a.f20100d;
        this.f20113e = c6208a.f20101e;
        this.f20114f = c6208a.f20102f.m25709a();
        this.f20115g = c6208a.f20103g;
        this.f20116h = c6208a.f20104h;
        this.f20117i = c6208a.f20105i;
        this.f20118j = c6208a.f20106j;
        this.f20119k = c6208a.f20107k;
        this.f20120l = c6208a.f20108l;
    }

    /* renamed from: a */
    public C6246z m25576a() {
        return this.f20109a;
    }

    /* renamed from: b */
    public C6244x m25579b() {
        return this.f20110b;
    }

    /* renamed from: c */
    public int m25580c() {
        return this.f20111c;
    }

    /* renamed from: d */
    public boolean m25581d() {
        return this.f20111c >= HttpStatus.HTTP_OK && this.f20111c < 300;
    }

    /* renamed from: e */
    public String m25582e() {
        return this.f20112d;
    }

    /* renamed from: f */
    public C6232p m25583f() {
        return this.f20113e;
    }

    /* renamed from: a */
    public String m25577a(String str) {
        return m25578a(str, null);
    }

    /* renamed from: a */
    public String m25578a(String str, String str2) {
        str = this.f20114f.m25718a(str);
        return str != null ? str : str2;
    }

    /* renamed from: g */
    public C6234q m25584g() {
        return this.f20114f;
    }

    /* renamed from: h */
    public ac m25585h() {
        return this.f20115g;
    }

    /* renamed from: i */
    public C6208a m25586i() {
        return new C6208a(this);
    }

    /* renamed from: j */
    public ab m25587j() {
        return this.f20116h;
    }

    /* renamed from: k */
    public C6214d m25588k() {
        C6214d c6214d = this.f20121m;
        if (c6214d != null) {
            return c6214d;
        }
        c6214d = C6214d.m25621a(this.f20114f);
        this.f20121m = c6214d;
        return c6214d;
    }

    /* renamed from: l */
    public long m25589l() {
        return this.f20119k;
    }

    /* renamed from: m */
    public long m25590m() {
        return this.f20120l;
    }

    public void close() {
        this.f20115g.close();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Response{protocol=");
        stringBuilder.append(this.f20110b);
        stringBuilder.append(", code=");
        stringBuilder.append(this.f20111c);
        stringBuilder.append(", message=");
        stringBuilder.append(this.f20112d);
        stringBuilder.append(", url=");
        stringBuilder.append(this.f20109a.m25821a());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
