package net.openid.appauth;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: TokenRequest */
/* renamed from: net.openid.appauth.r */
public class C6608r {
    /* renamed from: j */
    private static final Set<String> f21271j = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"client_id", "code", "code_verifier", "grant_type", ServerProtocol.DIALOG_PARAM_REDIRECT_URI, "refresh_token", "scope"})));
    /* renamed from: a */
    public final C6596h f21272a;
    /* renamed from: b */
    public final String f21273b;
    /* renamed from: c */
    public final String f21274c;
    /* renamed from: d */
    public final Uri f21275d;
    /* renamed from: e */
    public final String f21276e;
    /* renamed from: f */
    public final String f21277f;
    /* renamed from: g */
    public final String f21278g;
    /* renamed from: h */
    public final String f21279h;
    /* renamed from: i */
    public final Map<String, String> f21280i;

    /* compiled from: TokenRequest */
    /* renamed from: net.openid.appauth.r$a */
    public static final class C6607a {
        /* renamed from: a */
        private C6596h f21262a;
        /* renamed from: b */
        private String f21263b;
        /* renamed from: c */
        private String f21264c;
        /* renamed from: d */
        private Uri f21265d;
        /* renamed from: e */
        private String f21266e;
        /* renamed from: f */
        private String f21267f;
        /* renamed from: g */
        private String f21268g;
        /* renamed from: h */
        private String f21269h;
        /* renamed from: i */
        private Map<String, String> f21270i = new LinkedHashMap();

        public C6607a(C6596h c6596h, String str) {
            m26943a(c6596h);
            m26941a(str);
        }

        /* renamed from: a */
        public C6607a m26943a(C6596h c6596h) {
            this.f21262a = (C6596h) C6605p.m26932a(c6596h);
            return this;
        }

        /* renamed from: a */
        public C6607a m26941a(String str) {
            this.f21263b = C6605p.m26934a(str, (Object) "clientId cannot be null or empty");
            return this;
        }

        /* renamed from: b */
        public C6607a m26946b(String str) {
            this.f21264c = C6605p.m26934a(str, (Object) "grantType cannot be null or empty");
            return this;
        }

        /* renamed from: a */
        public C6607a m26939a(Uri uri) {
            if (uri != null) {
                C6605p.m26933a(uri.getScheme(), (Object) "redirectUri must have a scheme");
            }
            this.f21265d = uri;
            return this;
        }

        /* renamed from: c */
        public C6607a m26947c(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f21266e = null;
            } else {
                m26944a(str.split(" +"));
            }
            return this;
        }

        /* renamed from: a */
        public C6607a m26944a(String... strArr) {
            if (strArr == null) {
                strArr = new String[null];
            }
            m26940a(Arrays.asList(strArr));
            return this;
        }

        /* renamed from: a */
        public C6607a m26940a(Iterable<String> iterable) {
            this.f21266e = C6580c.m26816a((Iterable) iterable);
            return this;
        }

        /* renamed from: d */
        public C6607a m26948d(String str) {
            C6605p.m26937b(str, "authorization code must not be empty");
            this.f21267f = str;
            return this;
        }

        /* renamed from: e */
        public C6607a m26949e(String str) {
            if (str != null) {
                C6605p.m26934a(str, (Object) "refresh token cannot be empty if defined");
            }
            this.f21268g = str;
            return this;
        }

        /* renamed from: f */
        public C6607a m26950f(String str) {
            if (str != null) {
                C6601m.m26914a(str);
            }
            this.f21269h = str;
            return this;
        }

        /* renamed from: a */
        public C6607a m26942a(Map<String, String> map) {
            this.f21270i = C6572a.m26792a((Map) map, C6608r.f21271j);
            return this;
        }

        /* renamed from: a */
        public C6608r m26945a() {
            String b = m26938b();
            if ("authorization_code".equals(b)) {
                C6605p.m26933a(this.f21267f, (Object) "authorization code must be specified for grant_type = authorization_code");
            }
            if ("refresh_token".equals(b)) {
                C6605p.m26933a(this.f21268g, (Object) "refresh token must be specified for grant_type = refresh_token");
            }
            if (b.equals("authorization_code")) {
                if (this.f21265d == null) {
                    throw new IllegalStateException("no redirect URI specified on token request for code exchange");
                }
            }
            return new C6608r(this.f21262a, this.f21263b, b, this.f21265d, this.f21266e, this.f21267f, this.f21268g, this.f21269h, Collections.unmodifiableMap(this.f21270i));
        }

        /* renamed from: b */
        private String m26938b() {
            if (this.f21264c != null) {
                return this.f21264c;
            }
            if (this.f21267f != null) {
                return "authorization_code";
            }
            if (this.f21268g != null) {
                return "refresh_token";
            }
            throw new IllegalStateException("grant type not specified and cannot be inferred");
        }
    }

    private C6608r(C6596h c6596h, String str, String str2, Uri uri, String str3, String str4, String str5, String str6, Map<String, String> map) {
        this.f21272a = c6596h;
        this.f21273b = str;
        this.f21274c = str2;
        this.f21275d = uri;
        this.f21277f = str3;
        this.f21276e = str4;
        this.f21278g = str5;
        this.f21279h = str6;
        this.f21280i = map;
    }

    /* renamed from: a */
    public Map<String, String> m26953a() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("grant_type", this.f21274c);
        m26951a(hashMap, ServerProtocol.DIALOG_PARAM_REDIRECT_URI, this.f21275d);
        m26951a(hashMap, "code", this.f21276e);
        m26951a(hashMap, "refresh_token", this.f21278g);
        m26951a(hashMap, "code_verifier", this.f21279h);
        m26951a(hashMap, "scope", this.f21277f);
        for (Entry entry : this.f21280i.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        return hashMap;
    }

    /* renamed from: a */
    private void m26951a(Map<String, String> map, String str, Object obj) {
        if (obj != null) {
            map.put(str, obj.toString());
        }
    }
}
