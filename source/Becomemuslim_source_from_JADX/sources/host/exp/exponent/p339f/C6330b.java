package host.exp.exponent.p339f;

import com.facebook.stetho.common.Utf8Charset;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ExperienceId */
/* renamed from: host.exp.exponent.f.b */
public class C6330b {
    /* renamed from: a */
    private static final Map<String, C6330b> f20568a = new HashMap();
    /* renamed from: b */
    private String f20569b;

    /* renamed from: a */
    public static C6330b m26047a(String str) {
        if (!f20568a.containsKey(str)) {
            f20568a.put(str, new C6330b(str));
        }
        return (C6330b) f20568a.get(str);
    }

    private C6330b(String str) {
        this.f20569b = str;
    }

    /* renamed from: a */
    public String m26048a() {
        return this.f20569b;
    }

    /* renamed from: b */
    public String m26049b() {
        return URLEncoder.encode(this.f20569b, Utf8Charset.NAME);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C6330b)) {
            return false;
        }
        if (this.f20569b != ((C6330b) obj).f20569b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f20569b.hashCode();
    }
}
