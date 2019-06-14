package io.p347a.p348a.p349a.p350a.p358g;

import com.facebook.share.internal.ShareConstants;
import com.facebook.stetho.server.http.HttpStatus;
import io.p347a.p348a.p349a.C6514c;
import io.p347a.p348a.p349a.C6520i;
import io.p347a.p348a.p349a.C6523l;
import io.p347a.p348a.p349a.p350a.p352b.C6417a;
import io.p347a.p348a.p349a.p350a.p352b.C6428i;
import io.p347a.p348a.p349a.p350a.p356e.C6478c;
import io.p347a.p348a.p349a.p350a.p356e.C6483d;
import io.p347a.p348a.p349a.p350a.p356e.C6484e;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: DefaultSettingsSpiCall */
/* renamed from: io.a.a.a.a.g.l */
class C7624l extends C6417a implements C6511x {
    /* renamed from: a */
    boolean m34431a(int i) {
        if (!(i == HttpStatus.HTTP_OK || i == 201 || i == 202)) {
            if (i != 203) {
                return false;
            }
        }
        return true;
    }

    public C7624l(C6520i c6520i, String str, String str2, C6484e c6484e) {
        this(c6520i, str, str2, c6484e, C6478c.GET);
    }

    C7624l(C6520i c6520i, String str, String str2, C6484e c6484e, C6478c c6478c) {
        super(c6520i, str, str2, c6484e, c6478c);
    }

    /* renamed from: a */
    public JSONObject mo5470a(C6510w c6510w) {
        C6523l h;
        StringBuilder stringBuilder;
        C6483d c6483d = null;
        try {
            Map b = m34428b(c6510w);
            C6483d a = m26323a(b);
            try {
                c6483d = m34425a(a, c6510w);
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Requesting settings from ");
                stringBuilder2.append(m26324a());
                C6514c.m26634h().mo5472a("Fabric", stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Settings query params were: ");
                stringBuilder2.append(b);
                C6514c.m26634h().mo5472a("Fabric", stringBuilder2.toString());
                c6510w = m34429a(c6483d);
                if (c6483d != null) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Settings request ID: ");
                    stringBuilder2.append(c6483d.m26560b("X-REQUEST-ID"));
                    C6514c.m26634h().mo5472a("Fabric", stringBuilder2.toString());
                }
                return c6510w;
            } catch (Throwable th) {
                c6510w = th;
                c6483d = a;
                if (c6483d != null) {
                    h = C6514c.m26634h();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Settings request ID: ");
                    stringBuilder.append(c6483d.m26560b("X-REQUEST-ID"));
                    h.mo5472a("Fabric", stringBuilder.toString());
                }
                throw c6510w;
            }
        } catch (Throwable th2) {
            c6510w = th2;
            if (c6483d != null) {
                h = C6514c.m26634h();
                stringBuilder = new StringBuilder();
                stringBuilder.append("Settings request ID: ");
                stringBuilder.append(c6483d.m26560b("X-REQUEST-ID"));
                h.mo5472a("Fabric", stringBuilder.toString());
            }
            throw c6510w;
        }
    }

    /* renamed from: a */
    JSONObject m34429a(C6483d c6483d) {
        int b = c6483d.m26558b();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Settings result was: ");
        stringBuilder.append(b);
        C6514c.m26634h().mo5472a("Fabric", stringBuilder.toString());
        if (m34431a(b)) {
            return m34426a(c6483d.m26569e());
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Failed to retrieve settings from ");
        stringBuilder2.append(m26324a());
        C6514c.m26634h().mo5479e("Fabric", stringBuilder2.toString());
        return null;
    }

    /* renamed from: a */
    private JSONObject m34426a(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to parse settings JSON from ");
            stringBuilder.append(m26324a());
            C6514c.m26634h().mo5473a("Fabric", stringBuilder.toString(), e);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Settings response ");
            stringBuilder2.append(str);
            C6514c.m26634h().mo5472a("Fabric", stringBuilder2.toString());
            return null;
        }
    }

    /* renamed from: b */
    private Map<String, String> m34428b(C6510w c6510w) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("build_version", c6510w.f20985j);
        hashMap.put("display_version", c6510w.f20984i);
        hashMap.put(ShareConstants.FEED_SOURCE_PARAM, Integer.toString(c6510w.f20986k));
        if (c6510w.f20987l != null) {
            hashMap.put("icon_hash", c6510w.f20987l);
        }
        String str = c6510w.f20983h;
        if (!C6428i.m26379c(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    /* renamed from: a */
    private C6483d m34425a(C6483d c6483d, C6510w c6510w) {
        m34427a(c6483d, "X-CRASHLYTICS-API-KEY", c6510w.f20976a);
        m34427a(c6483d, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        m34427a(c6483d, "X-CRASHLYTICS-API-CLIENT-VERSION", this.a.mo5486a());
        m34427a(c6483d, "Accept", "application/json");
        m34427a(c6483d, "X-CRASHLYTICS-DEVICE-MODEL", c6510w.f20977b);
        m34427a(c6483d, "X-CRASHLYTICS-OS-BUILD-VERSION", c6510w.f20978c);
        m34427a(c6483d, "X-CRASHLYTICS-OS-DISPLAY-VERSION", c6510w.f20979d);
        m34427a(c6483d, "X-CRASHLYTICS-ADVERTISING-TOKEN", c6510w.f20980e);
        m34427a(c6483d, "X-CRASHLYTICS-INSTALLATION-ID", c6510w.f20981f);
        m34427a(c6483d, "X-CRASHLYTICS-ANDROID-ID", c6510w.f20982g);
        return c6483d;
    }

    /* renamed from: a */
    private void m34427a(C6483d c6483d, String str, String str2) {
        if (str2 != null) {
            c6483d.m26548a(str, str2);
        }
    }
}
