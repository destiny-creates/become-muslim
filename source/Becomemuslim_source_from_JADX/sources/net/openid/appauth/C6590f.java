package net.openid.appauth;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import net.openid.appauth.C6608r.C6607a;
import net.openid.appauth.p370c.C6579b;
import org.json.JSONObject;

/* compiled from: AuthorizationResponse */
/* renamed from: net.openid.appauth.f */
public class C6590f {
    /* renamed from: j */
    private static final Set<String> f21191j = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"token_type", ServerProtocol.DIALOG_PARAM_STATE, "code", "access_token", AccessToken.EXPIRES_IN_KEY, "id_token", "scope"})));
    /* renamed from: a */
    public final C6587e f21192a;
    /* renamed from: b */
    public final String f21193b;
    /* renamed from: c */
    public final String f21194c;
    /* renamed from: d */
    public final String f21195d;
    /* renamed from: e */
    public final String f21196e;
    /* renamed from: f */
    public final Long f21197f;
    /* renamed from: g */
    public final String f21198g;
    /* renamed from: h */
    public final String f21199h;
    /* renamed from: i */
    public final Map<String, String> f21200i;

    /* compiled from: AuthorizationResponse */
    /* renamed from: net.openid.appauth.f$a */
    public static final class C6589a {
        /* renamed from: a */
        private C6587e f21182a;
        /* renamed from: b */
        private String f21183b;
        /* renamed from: c */
        private String f21184c;
        /* renamed from: d */
        private String f21185d;
        /* renamed from: e */
        private String f21186e;
        /* renamed from: f */
        private Long f21187f;
        /* renamed from: g */
        private String f21188g;
        /* renamed from: h */
        private String f21189h;
        /* renamed from: i */
        private Map<String, String> f21190i = new LinkedHashMap();

        public C6589a(C6587e c6587e) {
            this.f21182a = (C6587e) C6605p.m26933a((Object) c6587e, (Object) "authorization request cannot be null");
        }

        /* renamed from: a */
        public C6589a m26861a(Uri uri) {
            return m26862a(uri, C7647q.f26415a);
        }

        /* renamed from: a */
        C6589a m26862a(Uri uri, C6600l c6600l) {
            m26866a(uri.getQueryParameter(ServerProtocol.DIALOG_PARAM_STATE));
            m26870b(uri.getQueryParameter("token_type"));
            m26871c(uri.getQueryParameter("code"));
            m26872d(uri.getQueryParameter("access_token"));
            m26865a(C6579b.m26811a(uri, AccessToken.EXPIRES_IN_KEY), c6600l);
            m26873e(uri.getQueryParameter("id_token"));
            m26874f(uri.getQueryParameter("scope"));
            m26867a(C6572a.m26791a(uri, C6590f.f21191j));
            return this;
        }

        /* renamed from: a */
        public C6589a m26866a(String str) {
            C6605p.m26937b(str, "state must not be empty");
            this.f21183b = str;
            return this;
        }

        /* renamed from: b */
        public C6589a m26870b(String str) {
            C6605p.m26937b(str, "tokenType must not be empty");
            this.f21184c = str;
            return this;
        }

        /* renamed from: c */
        public C6589a m26871c(String str) {
            C6605p.m26937b(str, "authorizationCode must not be empty");
            this.f21185d = str;
            return this;
        }

        /* renamed from: d */
        public C6589a m26872d(String str) {
            C6605p.m26937b(str, "accessToken must not be empty");
            this.f21186e = str;
            return this;
        }

        /* renamed from: a */
        public C6589a m26865a(Long l, C6600l c6600l) {
            if (l == null) {
                this.f21187f = null;
            } else {
                this.f21187f = Long.valueOf(c6600l.mo5516a() + TimeUnit.SECONDS.toMillis(l.longValue()));
            }
            return this;
        }

        /* renamed from: a */
        public C6589a m26864a(Long l) {
            this.f21187f = l;
            return this;
        }

        /* renamed from: e */
        public C6589a m26873e(String str) {
            C6605p.m26937b(str, "idToken cannot be empty");
            this.f21188g = str;
            return this;
        }

        /* renamed from: f */
        public C6589a m26874f(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f21189h = null;
            } else {
                m26868a(str.split(" +"));
            }
            return this;
        }

        /* renamed from: a */
        public C6589a m26868a(String... strArr) {
            if (strArr == null) {
                this.f21189h = null;
            } else {
                m26863a(Arrays.asList(strArr));
            }
            return this;
        }

        /* renamed from: a */
        public C6589a m26863a(Iterable<String> iterable) {
            this.f21189h = C6580c.m26816a((Iterable) iterable);
            return this;
        }

        /* renamed from: a */
        public C6589a m26867a(Map<String, String> map) {
            this.f21190i = C6572a.m26792a((Map) map, C6590f.f21191j);
            return this;
        }

        /* renamed from: a */
        public C6590f m26869a() {
            return new C6590f(this.f21182a, this.f21183b, this.f21184c, this.f21185d, this.f21186e, this.f21187f, this.f21188g, this.f21189h, Collections.unmodifiableMap(this.f21190i));
        }
    }

    private C6590f(C6587e c6587e, String str, String str2, String str3, String str4, Long l, String str5, String str6, Map<String, String> map) {
        this.f21192a = c6587e;
        this.f21193b = str;
        this.f21194c = str2;
        this.f21195d = str3;
        this.f21196e = str4;
        this.f21197f = l;
        this.f21198g = str5;
        this.f21199h = str6;
        this.f21200i = map;
    }

    /* renamed from: a */
    public C6608r m26879a() {
        return m26880a(Collections.emptyMap());
    }

    /* renamed from: a */
    public C6608r m26880a(Map<String, String> map) {
        C6605p.m26933a((Object) map, (Object) "additionalExchangeParameters cannot be null");
        if (this.f21195d != null) {
            return new C6607a(this.f21192a.f21168a, this.f21192a.f21169b).m26946b("authorization_code").m26939a(this.f21192a.f21174g).m26950f(this.f21192a.f21177j).m26948d(this.f21195d).m26942a((Map) map).m26945a();
        }
        throw new IllegalStateException("authorizationCode not available for exchange request");
    }

    /* renamed from: b */
    public JSONObject m26881b() {
        JSONObject jSONObject = new JSONObject();
        C6604n.m26925a(jSONObject, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, this.f21192a.m26859b());
        C6604n.m26927b(jSONObject, ServerProtocol.DIALOG_PARAM_STATE, this.f21193b);
        C6604n.m26927b(jSONObject, "token_type", this.f21194c);
        C6604n.m26927b(jSONObject, "code", this.f21195d);
        C6604n.m26927b(jSONObject, "access_token", this.f21196e);
        C6604n.m26923a(jSONObject, "expires_at", this.f21197f);
        C6604n.m26927b(jSONObject, "id_token", this.f21198g);
        C6604n.m26927b(jSONObject, "scope", this.f21199h);
        C6604n.m26925a(jSONObject, "additional_parameters", C6604n.m26920a(this.f21200i));
        return jSONObject;
    }

    /* renamed from: c */
    public String m26882c() {
        return m26881b().toString();
    }

    /* renamed from: a */
    public static C6590f m26877a(JSONObject jSONObject) {
        if (jSONObject.has(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID)) {
            return new C6589a(C6587e.m26854a(jSONObject.getJSONObject(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID))).m26870b(C6604n.m26926b(jSONObject, "token_type")).m26872d(C6604n.m26926b(jSONObject, "access_token")).m26871c(C6604n.m26926b(jSONObject, "code")).m26873e(C6604n.m26926b(jSONObject, "id_token")).m26874f(C6604n.m26926b(jSONObject, "scope")).m26866a(C6604n.m26926b(jSONObject, ServerProtocol.DIALOG_PARAM_STATE)).m26864a(C6604n.m26930e(jSONObject, "expires_at")).m26867a(C6604n.m26931f(jSONObject, "additional_parameters")).m26869a();
        }
        throw new IllegalArgumentException("authorization request not provided and not found in JSON");
    }

    /* renamed from: a */
    public static C6590f m26876a(String str) {
        return C6590f.m26877a(new JSONObject(str));
    }

    /* renamed from: d */
    public Intent m26883d() {
        Intent intent = new Intent();
        intent.putExtra("net.openid.appauth.AuthorizationResponse", m26882c());
        return intent;
    }

    /* renamed from: a */
    public static C6590f m26875a(Intent intent) {
        C6605p.m26933a((Object) intent, (Object) "dataIntent must not be null");
        if (!intent.hasExtra("net.openid.appauth.AuthorizationResponse")) {
            return null;
        }
        try {
            return C6590f.m26876a(intent.getStringExtra("net.openid.appauth.AuthorizationResponse"));
        } catch (Intent intent2) {
            throw new IllegalArgumentException("Intent contains malformed auth response", intent2);
        }
    }
}
