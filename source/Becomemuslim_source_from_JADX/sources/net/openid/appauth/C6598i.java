package net.openid.appauth;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.openid.appauth.C6604n.C6602b;
import net.openid.appauth.C6604n.C7642a;
import net.openid.appauth.C6604n.C7643d;
import net.openid.appauth.C6604n.C7644e;
import net.openid.appauth.C6604n.C7645f;
import org.json.JSONObject;

/* compiled from: AuthorizationServiceDiscovery */
/* renamed from: net.openid.appauth.i */
public class C6598i {
    /* renamed from: A */
    static final C7645f f21220A = C6598i.m26904b("service_documentation");
    /* renamed from: B */
    static final C7644e f21221B = C6598i.m26905c("claims_locales_supported");
    /* renamed from: C */
    static final C7644e f21222C = C6598i.m26905c("ui_locales_supported");
    /* renamed from: D */
    static final C7642a f21223D = C6598i.m26901a("claims_parameter_supported", false);
    /* renamed from: E */
    static final C7642a f21224E = C6598i.m26901a("request_parameter_supported", false);
    /* renamed from: F */
    static final C7642a f21225F = C6598i.m26901a("request_uri_parameter_supported", true);
    /* renamed from: G */
    static final C7642a f21226G = C6598i.m26901a("require_request_uri_registration", false);
    /* renamed from: H */
    static final C7645f f21227H = C6598i.m26904b("op_policy_uri");
    /* renamed from: I */
    static final C7645f f21228I = C6598i.m26904b("op_tos_uri");
    /* renamed from: K */
    private static final List<String> f21229K = Arrays.asList(new String[]{f21230a.a, f21231b.a, f21234e.a, f21237h.a, f21241l.a, f21242m.a});
    /* renamed from: a */
    static final C7643d f21230a = C6598i.m26902a("issuer");
    /* renamed from: b */
    static final C7645f f21231b = C6598i.m26904b("authorization_endpoint");
    /* renamed from: c */
    static final C7645f f21232c = C6598i.m26904b("token_endpoint");
    /* renamed from: d */
    static final C7645f f21233d = C6598i.m26904b("userinfo_endpoint");
    /* renamed from: e */
    static final C7645f f21234e = C6598i.m26904b("jwks_uri");
    /* renamed from: f */
    static final C7645f f21235f = C6598i.m26904b("registration_endpoint");
    /* renamed from: g */
    static final C7644e f21236g = C6598i.m26905c("scopes_supported");
    /* renamed from: h */
    static final C7644e f21237h = C6598i.m26905c("response_types_supported");
    /* renamed from: i */
    static final C7644e f21238i = C6598i.m26905c("response_modes_supported");
    /* renamed from: j */
    static final C7644e f21239j = C6598i.m26903a("grant_types_supported", Arrays.asList(new String[]{"authorization_code", "implicit"}));
    /* renamed from: k */
    static final C7644e f21240k = C6598i.m26905c("acr_values_supported");
    /* renamed from: l */
    static final C7644e f21241l = C6598i.m26905c("subject_types_supported");
    /* renamed from: m */
    static final C7644e f21242m = C6598i.m26905c("id_token_signing_alg_values_supported");
    /* renamed from: n */
    static final C7644e f21243n = C6598i.m26905c("id_token_encryption_enc_values_supported");
    /* renamed from: o */
    static final C7644e f21244o = C6598i.m26905c("id_token_encryption_enc_values_supported");
    /* renamed from: p */
    static final C7644e f21245p = C6598i.m26905c("userinfo_signing_alg_values_supported");
    /* renamed from: q */
    static final C7644e f21246q = C6598i.m26905c("userinfo_encryption_alg_values_supported");
    /* renamed from: r */
    static final C7644e f21247r = C6598i.m26905c("userinfo_encryption_enc_values_supported");
    /* renamed from: s */
    static final C7644e f21248s = C6598i.m26905c("request_object_signing_alg_values_supported");
    /* renamed from: t */
    static final C7644e f21249t = C6598i.m26905c("request_object_encryption_alg_values_supported");
    /* renamed from: u */
    static final C7644e f21250u = C6598i.m26905c("request_object_encryption_enc_values_supported");
    /* renamed from: v */
    static final C7644e f21251v = C6598i.m26903a("token_endpoint_auth_methods_supported", Collections.singletonList("client_secret_basic"));
    /* renamed from: w */
    static final C7644e f21252w = C6598i.m26905c("token_endpoint_auth_signing_alg_values_supported");
    /* renamed from: x */
    static final C7644e f21253x = C6598i.m26905c("display_values_supported");
    /* renamed from: y */
    static final C7644e f21254y = C6598i.m26903a("claim_types_supported", Collections.singletonList("normal"));
    /* renamed from: z */
    static final C7644e f21255z = C6598i.m26905c("claims_supported");
    /* renamed from: J */
    public final JSONObject f21256J;

    /* compiled from: AuthorizationServiceDiscovery */
    /* renamed from: net.openid.appauth.i$a */
    public static class C6597a extends Exception {
        /* renamed from: a */
        private String f21219a;

        public C6597a(String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Missing mandatory configuration field: ");
            stringBuilder.append(str);
            super(stringBuilder.toString());
            this.f21219a = str;
        }

        /* renamed from: a */
        public String m26899a() {
            return this.f21219a;
        }
    }

    public C6598i(JSONObject jSONObject) {
        this.f21256J = (JSONObject) C6605p.m26932a(jSONObject);
        for (String str : f21229K) {
            if (!this.f21256J.has(str) || this.f21256J.get(str) == null) {
                throw new C6597a(str);
            }
        }
    }

    /* renamed from: a */
    private <T> T m26900a(C6602b<T> c6602b) {
        return C6604n.m26918a(this.f21256J, (C6602b) c6602b);
    }

    /* renamed from: a */
    public Uri m26906a() {
        return (Uri) m26900a(f21231b);
    }

    /* renamed from: b */
    public Uri m26907b() {
        return (Uri) m26900a(f21232c);
    }

    /* renamed from: c */
    public Uri m26908c() {
        return (Uri) m26900a(f21235f);
    }

    /* renamed from: a */
    private static C7643d m26902a(String str) {
        return new C7643d(str);
    }

    /* renamed from: b */
    private static C7645f m26904b(String str) {
        return new C7645f(str);
    }

    /* renamed from: c */
    private static C7644e m26905c(String str) {
        return new C7644e(str);
    }

    /* renamed from: a */
    private static C7644e m26903a(String str, List<String> list) {
        return new C7644e(str, list);
    }

    /* renamed from: a */
    private static C7642a m26901a(String str, boolean z) {
        return new C7642a(str, z);
    }
}
