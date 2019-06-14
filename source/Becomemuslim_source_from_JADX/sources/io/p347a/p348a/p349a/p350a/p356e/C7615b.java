package io.p347a.p348a.p349a.p350a.p356e;

import com.facebook.common.util.UriUtil;
import io.p347a.p348a.p349a.C6523l;
import io.p347a.p348a.p349a.C7625b;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: DefaultHttpRequestFactory */
/* renamed from: io.a.a.a.a.e.b */
public class C7615b implements C6484e {
    /* renamed from: a */
    private final C6523l f26323a;
    /* renamed from: b */
    private C6486g f26324b;
    /* renamed from: c */
    private SSLSocketFactory f26325c;
    /* renamed from: d */
    private boolean f26326d;

    public C7615b() {
        this(new C7625b());
    }

    public C7615b(C6523l c6523l) {
        this.f26323a = c6523l;
    }

    /* renamed from: a */
    public void mo5457a(C6486g c6486g) {
        if (this.f26324b != c6486g) {
            this.f26324b = c6486g;
            m34387a();
        }
    }

    /* renamed from: a */
    private synchronized void m34387a() {
        this.f26326d = false;
        this.f26325c = null;
    }

    /* renamed from: a */
    public C6483d mo5456a(C6478c c6478c, String str, Map<String, String> map) {
        switch (c6478c) {
            case GET:
                c6478c = C6483d.m26530a((CharSequence) str, (Map) map, true);
                break;
            case POST:
                c6478c = C6483d.m26535b((CharSequence) str, (Map) map, true);
                break;
            case PUT:
                c6478c = C6483d.m26538d((CharSequence) str);
                break;
            case DELETE:
                c6478c = C6483d.m26539e((CharSequence) str);
                break;
            default:
                throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (!(m34388a(str) == null || this.f26324b == null)) {
            str = m34389b();
            if (str != null) {
                ((HttpsURLConnection) c6478c.m26557a()).setSSLSocketFactory(str);
            }
        }
        return c6478c;
    }

    /* renamed from: a */
    private boolean m34388a(String str) {
        return (str == null || str.toLowerCase(Locale.US).startsWith(UriUtil.HTTPS_SCHEME) == null) ? null : true;
    }

    /* renamed from: b */
    private synchronized SSLSocketFactory m34389b() {
        if (this.f26325c == null && !this.f26326d) {
            this.f26325c = m34390c();
        }
        return this.f26325c;
    }

    /* renamed from: c */
    private synchronized SSLSocketFactory m34390c() {
        SSLSocketFactory a;
        this.f26326d = true;
        try {
            a = C6485f.m26585a(this.f26324b);
            this.f26323a.mo5472a("Fabric", "Custom SSL pinning enabled");
        } catch (Throwable e) {
            this.f26323a.mo5480e("Fabric", "Exception while validating pinned certs", e);
            return null;
        }
        return a;
    }
}
