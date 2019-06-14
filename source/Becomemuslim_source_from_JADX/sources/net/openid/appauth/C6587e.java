package net.openid.appauth;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.internal.ServerProtocol;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import net.openid.appauth.p370c.C6579b;
import org.json.JSONObject;

/* compiled from: AuthorizationRequest */
/* renamed from: net.openid.appauth.e */
public class C6587e {
    /* renamed from: o */
    private static final Set<String> f21167o = C6572a.m26794a("client_id", "code_challenge", "code_challenge_method", "display", "login_hint", "prompt", ServerProtocol.DIALOG_PARAM_REDIRECT_URI, "response_mode", ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, "scope", ServerProtocol.DIALOG_PARAM_STATE);
    /* renamed from: a */
    public final C6596h f21168a;
    /* renamed from: b */
    public final String f21169b;
    /* renamed from: c */
    public final String f21170c;
    /* renamed from: d */
    public final String f21171d;
    /* renamed from: e */
    public final String f21172e;
    /* renamed from: f */
    public final String f21173f;
    /* renamed from: g */
    public final Uri f21174g;
    /* renamed from: h */
    public final String f21175h;
    /* renamed from: i */
    public final String f21176i;
    /* renamed from: j */
    public final String f21177j;
    /* renamed from: k */
    public final String f21178k;
    /* renamed from: l */
    public final String f21179l;
    /* renamed from: m */
    public final String f21180m;
    /* renamed from: n */
    public final Map<String, String> f21181n;

    /* compiled from: AuthorizationRequest */
    /* renamed from: net.openid.appauth.e$a */
    public static final class C6586a {
        /* renamed from: a */
        private C6596h f21153a;
        /* renamed from: b */
        private String f21154b;
        /* renamed from: c */
        private String f21155c;
        /* renamed from: d */
        private String f21156d;
        /* renamed from: e */
        private String f21157e;
        /* renamed from: f */
        private String f21158f;
        /* renamed from: g */
        private Uri f21159g;
        /* renamed from: h */
        private String f21160h;
        /* renamed from: i */
        private String f21161i;
        /* renamed from: j */
        private String f21162j;
        /* renamed from: k */
        private String f21163k;
        /* renamed from: l */
        private String f21164l;
        /* renamed from: m */
        private String f21165m;
        /* renamed from: n */
        private Map<String, String> f21166n = new HashMap();

        public C6586a(C6596h c6596h, String str, String str2, Uri uri) {
            m26842a(c6596h);
            m26839a(str);
            m26848e(str2);
            m26837a(uri);
            m26850g(C6587e.m26857f());
            m26851h(C6601m.m26912a());
        }

        /* renamed from: a */
        public C6586a m26842a(C6596h c6596h) {
            this.f21153a = (C6596h) C6605p.m26933a((Object) c6596h, (Object) "configuration cannot be null");
            return this;
        }

        /* renamed from: a */
        public C6586a m26839a(String str) {
            this.f21154b = C6605p.m26934a(str, (Object) "client ID cannot be null or empty");
            return this;
        }

        /* renamed from: b */
        public C6586a m26845b(String str) {
            this.f21155c = C6605p.m26937b(str, "display must be null or not empty");
            return this;
        }

        /* renamed from: c */
        public C6586a m26846c(String str) {
            this.f21156d = C6605p.m26937b(str, "login hint must be null or not empty");
            return this;
        }

        /* renamed from: d */
        public C6586a m26847d(String str) {
            this.f21157e = C6605p.m26937b(str, "prompt must be null or non-empty");
            return this;
        }

        /* renamed from: e */
        public C6586a m26848e(String str) {
            this.f21158f = C6605p.m26934a(str, (Object) "expected response type cannot be null or empty");
            return this;
        }

        /* renamed from: a */
        public C6586a m26837a(Uri uri) {
            this.f21159g = (Uri) C6605p.m26933a((Object) uri, (Object) "redirect URI cannot be null or empty");
            return this;
        }

        /* renamed from: f */
        public C6586a m26849f(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f21160h = null;
            } else {
                m26843a(str.split(" +"));
            }
            return this;
        }

        /* renamed from: a */
        public C6586a m26843a(String... strArr) {
            if (strArr == null) {
                strArr = new String[null];
            }
            m26838a(Arrays.asList(strArr));
            return this;
        }

        /* renamed from: a */
        public C6586a m26838a(Iterable<String> iterable) {
            this.f21160h = C6580c.m26816a((Iterable) iterable);
            return this;
        }

        /* renamed from: g */
        public C6586a m26850g(String str) {
            this.f21161i = C6605p.m26937b(str, "state cannot be empty if defined");
            return this;
        }

        /* renamed from: h */
        public C6586a m26851h(String str) {
            if (str != null) {
                C6601m.m26914a(str);
                this.f21162j = str;
                this.f21163k = C6601m.m26916b(str);
                this.f21164l = C6601m.m26915b();
            } else {
                this.f21162j = null;
                this.f21163k = null;
                this.f21164l = null;
            }
            return this;
        }

        /* renamed from: a */
        public C6586a m26840a(String str, String str2, String str3) {
            if (str != null) {
                C6601m.m26914a(str);
                C6605p.m26934a(str2, (Object) "code verifier challenge cannot be null or empty if verifier is set");
                C6605p.m26934a(str3, (Object) "code verifier challenge method cannot be null or empty if verifier is set");
            } else {
                boolean z = false;
                C6605p.m26935a(str2 == null, (Object) "code verifier challenge must be null if verifier is null");
                if (str3 == null) {
                    z = true;
                }
                C6605p.m26935a(z, (Object) "code verifier challenge method must be null if verifier is null");
            }
            this.f21162j = str;
            this.f21163k = str2;
            this.f21164l = str3;
            return this;
        }

        /* renamed from: i */
        public C6586a m26852i(String str) {
            C6605p.m26937b(str, "responseMode must not be empty");
            this.f21165m = str;
            return this;
        }

        /* renamed from: a */
        public C6586a m26841a(Map<String, String> map) {
            this.f21166n = C6572a.m26792a((Map) map, C6587e.f21167o);
            return this;
        }

        /* renamed from: a */
        public C6587e m26844a() {
            return new C6587e(this.f21153a, this.f21154b, this.f21158f, this.f21159g, this.f21155c, this.f21156d, this.f21157e, this.f21160h, this.f21161i, this.f21162j, this.f21163k, this.f21164l, this.f21165m, Collections.unmodifiableMap(new HashMap(this.f21166n)));
        }
    }

    private C6587e(C6596h c6596h, String str, String str2, Uri uri, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Map<String, String> map) {
        this.f21168a = c6596h;
        this.f21169b = str;
        this.f21173f = str2;
        this.f21174g = uri;
        this.f21181n = map;
        this.f21170c = str3;
        this.f21171d = str4;
        this.f21172e = str5;
        this.f21175h = str6;
        this.f21176i = str7;
        this.f21177j = str8;
        this.f21178k = str9;
        this.f21179l = str10;
        this.f21180m = str11;
    }

    /* renamed from: a */
    public Uri m26858a() {
        Builder appendQueryParameter = this.f21168a.f21215a.buildUpon().appendQueryParameter(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, this.f21174g.toString()).appendQueryParameter("client_id", this.f21169b).appendQueryParameter(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, this.f21173f);
        C6579b.m26814a(appendQueryParameter, "display", this.f21170c);
        C6579b.m26814a(appendQueryParameter, "login_hint", this.f21171d);
        C6579b.m26814a(appendQueryParameter, "prompt", this.f21172e);
        C6579b.m26814a(appendQueryParameter, ServerProtocol.DIALOG_PARAM_STATE, this.f21176i);
        C6579b.m26814a(appendQueryParameter, "scope", this.f21175h);
        C6579b.m26814a(appendQueryParameter, "response_mode", this.f21180m);
        if (this.f21177j != null) {
            appendQueryParameter.appendQueryParameter("code_challenge", this.f21178k).appendQueryParameter("code_challenge_method", this.f21179l);
        }
        for (Entry entry : this.f21181n.entrySet()) {
            appendQueryParameter.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        return appendQueryParameter.build();
    }

    /* renamed from: b */
    public JSONObject m26859b() {
        JSONObject jSONObject = new JSONObject();
        C6604n.m26925a(jSONObject, "configuration", this.f21168a.m26898a());
        C6604n.m26924a(jSONObject, "clientId", this.f21169b);
        C6604n.m26924a(jSONObject, "responseType", this.f21173f);
        C6604n.m26924a(jSONObject, "redirectUri", this.f21174g.toString());
        C6604n.m26927b(jSONObject, "display", this.f21170c);
        C6604n.m26927b(jSONObject, "login_hint", this.f21171d);
        C6604n.m26927b(jSONObject, "scope", this.f21175h);
        C6604n.m26927b(jSONObject, "prompt", this.f21172e);
        C6604n.m26927b(jSONObject, ServerProtocol.DIALOG_PARAM_STATE, this.f21176i);
        C6604n.m26927b(jSONObject, "codeVerifier", this.f21177j);
        C6604n.m26927b(jSONObject, "codeVerifierChallenge", this.f21178k);
        C6604n.m26927b(jSONObject, "codeVerifierChallengeMethod", this.f21179l);
        C6604n.m26927b(jSONObject, "responseMode", this.f21180m);
        C6604n.m26925a(jSONObject, "additionalParameters", C6604n.m26920a(this.f21181n));
        return jSONObject;
    }

    /* renamed from: c */
    public String m26860c() {
        return m26859b().toString();
    }

    /* renamed from: a */
    public static C6587e m26854a(JSONObject jSONObject) {
        C6605p.m26933a((Object) jSONObject, (Object) "json cannot be null");
        C6586a a = new C6586a(C6596h.m26896a(jSONObject.getJSONObject("configuration")), C6604n.m26919a(jSONObject, "clientId"), C6604n.m26919a(jSONObject, "responseType"), C6604n.m26928c(jSONObject, "redirectUri")).m26845b(C6604n.m26926b(jSONObject, "display")).m26846c(C6604n.m26926b(jSONObject, "login_hint")).m26847d(C6604n.m26926b(jSONObject, "prompt")).m26850g(C6604n.m26926b(jSONObject, ServerProtocol.DIALOG_PARAM_STATE)).m26840a(C6604n.m26926b(jSONObject, "codeVerifier"), C6604n.m26926b(jSONObject, "codeVerifierChallenge"), C6604n.m26926b(jSONObject, "codeVerifierChallengeMethod")).m26852i(C6604n.m26926b(jSONObject, "responseMode")).m26841a(C6604n.m26931f(jSONObject, "additionalParameters"));
        if (jSONObject.has("scope")) {
            a.m26838a(C6580c.m26817a(C6604n.m26919a(jSONObject, "scope")));
        }
        return a.m26844a();
    }

    /* renamed from: a */
    public static C6587e m26853a(String str) {
        C6605p.m26933a((Object) str, (Object) "json string cannot be null");
        return C6587e.m26854a(new JSONObject(str));
    }

    /* renamed from: f */
    private static String m26857f() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }
}
