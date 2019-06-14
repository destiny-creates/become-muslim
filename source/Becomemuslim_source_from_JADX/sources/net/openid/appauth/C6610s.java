package net.openid.appauth;

import android.text.TextUtils;
import com.facebook.AccessToken;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: TokenResponse */
/* renamed from: net.openid.appauth.s */
public class C6610s {
    /* renamed from: i */
    private static final Set<String> f21289i = new HashSet(Arrays.asList(new String[]{"token_type", "access_token", AccessToken.EXPIRES_IN_KEY, "refresh_token", "id_token", "scope"}));
    /* renamed from: a */
    public final C6608r f21290a;
    /* renamed from: b */
    public final String f21291b;
    /* renamed from: c */
    public final String f21292c;
    /* renamed from: d */
    public final Long f21293d;
    /* renamed from: e */
    public final String f21294e;
    /* renamed from: f */
    public final String f21295f;
    /* renamed from: g */
    public final String f21296g;
    /* renamed from: h */
    public final Map<String, String> f21297h;

    /* compiled from: TokenResponse */
    /* renamed from: net.openid.appauth.s$a */
    public static final class C6609a {
        /* renamed from: a */
        private C6608r f21281a;
        /* renamed from: b */
        private String f21282b;
        /* renamed from: c */
        private String f21283c;
        /* renamed from: d */
        private Long f21284d;
        /* renamed from: e */
        private String f21285e;
        /* renamed from: f */
        private String f21286f;
        /* renamed from: g */
        private String f21287g;
        /* renamed from: h */
        private Map<String, String> f21288h = Collections.emptyMap();

        public C6609a(C6608r c6608r) {
            m26959a(c6608r);
        }

        /* renamed from: a */
        public C6609a m26960a(JSONObject jSONObject) {
            m26957a(C6604n.m26919a(jSONObject, "token_type"));
            m26964b(C6604n.m26926b(jSONObject, "access_token"));
            m26963b(C6604n.m26930e(jSONObject, "expires_at"));
            if (jSONObject.has(AccessToken.EXPIRES_IN_KEY)) {
                m26955a(Long.valueOf(jSONObject.getLong(AccessToken.EXPIRES_IN_KEY)));
            }
            m26966d(C6604n.m26926b(jSONObject, "refresh_token"));
            m26965c(C6604n.m26926b(jSONObject, "id_token"));
            m26967e(C6604n.m26926b(jSONObject, "scope"));
            m26958a(C6572a.m26793a(jSONObject, C6610s.f21289i));
            return this;
        }

        /* renamed from: a */
        public C6609a m26959a(C6608r c6608r) {
            this.f21281a = (C6608r) C6605p.m26933a((Object) c6608r, (Object) "request cannot be null");
            return this;
        }

        /* renamed from: a */
        public C6609a m26957a(String str) {
            this.f21282b = C6605p.m26937b(str, "token type must not be empty if defined");
            return this;
        }

        /* renamed from: b */
        public C6609a m26964b(String str) {
            this.f21283c = C6605p.m26937b(str, "access token cannot be empty if specified");
            return this;
        }

        /* renamed from: a */
        public C6609a m26955a(Long l) {
            return m26956a(l, C7647q.f26415a);
        }

        /* renamed from: a */
        C6609a m26956a(Long l, C6600l c6600l) {
            if (l == null) {
                this.f21284d = null;
            } else {
                this.f21284d = Long.valueOf(c6600l.mo5516a() + TimeUnit.SECONDS.toMillis(l.longValue()));
            }
            return this;
        }

        /* renamed from: b */
        public C6609a m26963b(Long l) {
            this.f21284d = l;
            return this;
        }

        /* renamed from: c */
        public C6609a m26965c(String str) {
            this.f21285e = C6605p.m26937b(str, "id token must not be empty if defined");
            return this;
        }

        /* renamed from: d */
        public C6609a m26966d(String str) {
            this.f21286f = C6605p.m26937b(str, "refresh token must not be empty if defined");
            return this;
        }

        /* renamed from: e */
        public C6609a m26967e(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f21287g = null;
            } else {
                m26961a(str.split(" +"));
            }
            return this;
        }

        /* renamed from: a */
        public C6609a m26961a(String... strArr) {
            if (strArr == null) {
                strArr = new String[null];
            }
            m26954a(Arrays.asList(strArr));
            return this;
        }

        /* renamed from: a */
        public C6609a m26954a(Iterable<String> iterable) {
            this.f21287g = C6580c.m26816a((Iterable) iterable);
            return this;
        }

        /* renamed from: a */
        public C6609a m26958a(Map<String, String> map) {
            this.f21288h = C6572a.m26792a((Map) map, C6610s.f21289i);
            return this;
        }

        /* renamed from: a */
        public C6610s m26962a() {
            return new C6610s(this.f21281a, this.f21282b, this.f21283c, this.f21284d, this.f21285e, this.f21286f, this.f21287g, this.f21288h);
        }
    }

    C6610s(C6608r c6608r, String str, String str2, Long l, String str3, String str4, String str5, Map<String, String> map) {
        this.f21290a = c6608r;
        this.f21291b = str;
        this.f21292c = str2;
        this.f21293d = l;
        this.f21294e = str3;
        this.f21295f = str4;
        this.f21296g = str5;
        this.f21297h = map;
    }
}
