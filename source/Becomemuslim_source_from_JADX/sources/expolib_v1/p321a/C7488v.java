package expolib_v1.p321a;

import com.facebook.stetho.dumpapp.Framer;
import com.facebook.stetho.server.http.HttpHeaders;
import expolib_v1.p321a.p322a.C6165c;
import expolib_v1.p332b.C6251f;
import expolib_v1.p332b.C7496d;
import expolib_v1.p332b.C8170c;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* compiled from: MultipartBody */
/* renamed from: expolib_v1.a.v */
public final class C7488v extends aa {
    /* renamed from: a */
    public static final C6240u f25979a = C6240u.m25781a("multipart/mixed");
    /* renamed from: b */
    public static final C6240u f25980b = C6240u.m25781a("multipart/alternative");
    /* renamed from: c */
    public static final C6240u f25981c = C6240u.m25781a("multipart/digest");
    /* renamed from: d */
    public static final C6240u f25982d = C6240u.m25781a("multipart/parallel");
    /* renamed from: e */
    public static final C6240u f25983e = C6240u.m25781a("multipart/form-data");
    /* renamed from: f */
    private static final byte[] f25984f = new byte[]{(byte) 58, (byte) 32};
    /* renamed from: g */
    private static final byte[] f25985g = new byte[]{(byte) 13, (byte) 10};
    /* renamed from: h */
    private static final byte[] f25986h = new byte[]{Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX};
    /* renamed from: i */
    private final C6251f f25987i;
    /* renamed from: j */
    private final C6240u f25988j;
    /* renamed from: k */
    private final C6240u f25989k;
    /* renamed from: l */
    private final List<C6242b> f25990l;
    /* renamed from: m */
    private long f25991m = -1;

    /* compiled from: MultipartBody */
    /* renamed from: expolib_v1.a.v$a */
    public static final class C6241a {
        /* renamed from: a */
        private final C6251f f20325a;
        /* renamed from: b */
        private C6240u f20326b;
        /* renamed from: c */
        private final List<C6242b> f20327c;

        public C6241a() {
            this(UUID.randomUUID().toString());
        }

        public C6241a(String str) {
            this.f20326b = C7488v.f25979a;
            this.f20327c = new ArrayList();
            this.f20325a = C6251f.m25837a(str);
        }

        /* renamed from: a */
        public C6241a m25786a(C6240u c6240u) {
            if (c6240u == null) {
                throw new NullPointerException("type == null");
            } else if (c6240u.m25782a().equals("multipart")) {
                this.f20326b = c6240u;
                return this;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("multipart != ");
                stringBuilder.append(c6240u);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }

        /* renamed from: a */
        public C6241a m25785a(C6234q c6234q, aa aaVar) {
            return m25787a(C6242b.m25789a(c6234q, aaVar));
        }

        /* renamed from: a */
        public C6241a m25787a(C6242b c6242b) {
            if (c6242b != null) {
                this.f20327c.add(c6242b);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        /* renamed from: a */
        public C7488v m25788a() {
            if (!this.f20327c.isEmpty()) {
                return new C7488v(this.f20325a, this.f20326b, this.f20327c);
            }
            throw new IllegalStateException("Multipart body must have at least one part.");
        }
    }

    /* compiled from: MultipartBody */
    /* renamed from: expolib_v1.a.v$b */
    public static final class C6242b {
        /* renamed from: a */
        final C6234q f20328a;
        /* renamed from: b */
        final aa f20329b;

        /* renamed from: a */
        public static C6242b m25789a(C6234q c6234q, aa aaVar) {
            if (aaVar != null) {
                if (c6234q != null) {
                    if (c6234q.m25718a(HttpHeaders.CONTENT_TYPE) != null) {
                        throw new IllegalArgumentException("Unexpected header: Content-Type");
                    }
                }
                if (c6234q != null) {
                    if (c6234q.m25718a(HttpHeaders.CONTENT_LENGTH) != null) {
                        throw new IllegalArgumentException("Unexpected header: Content-Length");
                    }
                }
                return new C6242b(c6234q, aaVar);
            }
            throw new NullPointerException("body == null");
        }

        private C6242b(C6234q c6234q, aa aaVar) {
            this.f20328a = c6234q;
            this.f20329b = aaVar;
        }
    }

    C7488v(C6251f c6251f, C6240u c6240u, List<C6242b> list) {
        this.f25987i = c6251f;
        this.f25988j = c6240u;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c6240u);
        stringBuilder.append("; boundary=");
        stringBuilder.append(c6251f.mo5355a());
        this.f25989k = C6240u.m25781a(stringBuilder.toString());
        this.f25990l = C6165c.m25310a((List) list);
    }

    public C6240u contentType() {
        return this.f25989k;
    }

    public long contentLength() {
        long j = this.f25991m;
        if (j != -1) {
            return j;
        }
        j = m33955a(null, true);
        this.f25991m = j;
        return j;
    }

    public void writeTo(C7496d c7496d) {
        m33955a(c7496d, false);
    }

    /* renamed from: a */
    private long m33955a(C7496d c7496d, boolean z) {
        C8170c c8170c;
        if (z) {
            c7496d = new C8170c();
            c8170c = c7496d;
        } else {
            c8170c = null;
        }
        int size = this.f25990l.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            C6242b c6242b = (C6242b) this.f25990l.get(i);
            C6234q c6234q = c6242b.f20328a;
            aa aaVar = c6242b.f20329b;
            c7496d.mo6380d(f25986h);
            c7496d.mo6376c(this.f25987i);
            c7496d.mo6380d(f25985g);
            if (c6234q != null) {
                int a = c6234q.m25716a();
                for (int i2 = 0; i2 < a; i2++) {
                    c7496d.mo6373b(c6234q.m25717a(i2)).mo6380d(f25984f).mo6373b(c6234q.m25720b(i2)).mo6380d(f25985g);
                }
            }
            C6240u contentType = aaVar.contentType();
            if (contentType != null) {
                c7496d.mo6373b("Content-Type: ").mo6373b(contentType.toString()).mo6380d(f25985g);
            }
            long contentLength = aaVar.contentLength();
            if (contentLength != -1) {
                c7496d.mo6373b("Content-Length: ").mo6394m(contentLength).mo6380d(f25985g);
            } else if (z) {
                c8170c.m39650u();
                return -1;
            }
            c7496d.mo6380d(f25985g);
            if (z) {
                j += contentLength;
            } else {
                aaVar.writeTo(c7496d);
            }
            c7496d.mo6380d(f25985g);
        }
        c7496d.mo6380d(f25986h);
        c7496d.mo6376c(this.f25987i);
        c7496d.mo6380d(f25986h);
        c7496d.mo6380d(f25985g);
        if (z) {
            j += c8170c.m39582a();
            c8170c.m39650u();
        }
        return j;
    }
}
