package net.openid.appauth;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.util.C3211a;
import com.facebook.ads.AdError;
import com.facebook.internal.NativeProtocol;
import com.facebook.stetho.websocket.CloseCodes;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: AuthorizationException */
/* renamed from: net.openid.appauth.d */
public final class C6584d extends Exception {
    /* renamed from: a */
    public final int f21148a;
    /* renamed from: b */
    public final int f21149b;
    /* renamed from: c */
    public final String f21150c;
    /* renamed from: d */
    public final String f21151d;
    /* renamed from: e */
    public final Uri f21152e;

    /* compiled from: AuthorizationException */
    /* renamed from: net.openid.appauth.d$a */
    public static final class C6581a {
        /* renamed from: a */
        public static final C6584d f21120a = C6584d.m26832e(1000, "invalid_request");
        /* renamed from: b */
        public static final C6584d f21121b = C6584d.m26832e(AdError.NO_FILL_ERROR_CODE, "unauthorized_client");
        /* renamed from: c */
        public static final C6584d f21122c = C6584d.m26832e(1002, "access_denied");
        /* renamed from: d */
        public static final C6584d f21123d = C6584d.m26832e(1003, "unsupported_response_type");
        /* renamed from: e */
        public static final C6584d f21124e = C6584d.m26832e(1004, "invalid_scope");
        /* renamed from: f */
        public static final C6584d f21125f = C6584d.m26832e(1005, "server_error");
        /* renamed from: g */
        public static final C6584d f21126g = C6584d.m26832e(CloseCodes.CLOSED_ABNORMALLY, "temporarily_unavailable");
        /* renamed from: h */
        public static final C6584d f21127h = C6584d.m26832e(1007, null);
        /* renamed from: i */
        public static final C6584d f21128i = C6584d.m26832e(1008, null);
        /* renamed from: j */
        public static final C6584d f21129j = C6584d.m26831d(9, "Response state param did not match request state");
        /* renamed from: k */
        private static final Map<String, C6584d> f21130k = C6584d.m26828b(f21120a, f21121b, f21122c, f21123d, f21124e, f21125f, f21126g, f21127h, f21128i);

        /* renamed from: a */
        public static C6584d m26818a(String str) {
            C6584d c6584d = (C6584d) f21130k.get(str);
            if (c6584d != null) {
                return c6584d;
            }
            return f21128i;
        }
    }

    /* compiled from: AuthorizationException */
    /* renamed from: net.openid.appauth.d$b */
    public static final class C6582b {
        /* renamed from: a */
        public static final C6584d f21131a = C6584d.m26831d(0, "Invalid discovery document");
        /* renamed from: b */
        public static final C6584d f21132b = C6584d.m26831d(1, "User cancelled flow");
        /* renamed from: c */
        public static final C6584d f21133c = C6584d.m26831d(2, "Flow cancelled programmatically");
        /* renamed from: d */
        public static final C6584d f21134d = C6584d.m26831d(3, "Network error");
        /* renamed from: e */
        public static final C6584d f21135e = C6584d.m26831d(4, "Server error");
        /* renamed from: f */
        public static final C6584d f21136f = C6584d.m26831d(5, "JSON deserialization error");
        /* renamed from: g */
        public static final C6584d f21137g = C6584d.m26831d(6, "Token response construction error");
        /* renamed from: h */
        public static final C6584d f21138h = C6584d.m26831d(7, "Invalid registration response");
    }

    /* compiled from: AuthorizationException */
    /* renamed from: net.openid.appauth.d$c */
    public static final class C6583c {
        /* renamed from: a */
        public static final C6584d f21139a = C6584d.m26833f(AdError.SERVER_ERROR_CODE, "invalid_request");
        /* renamed from: b */
        public static final C6584d f21140b = C6584d.m26833f(AdError.INTERNAL_ERROR_CODE, "invalid_client");
        /* renamed from: c */
        public static final C6584d f21141c = C6584d.m26833f(AdError.CACHE_ERROR_CODE, "invalid_grant");
        /* renamed from: d */
        public static final C6584d f21142d = C6584d.m26833f(2003, "unauthorized_client");
        /* renamed from: e */
        public static final C6584d f21143e = C6584d.m26833f(2004, "unsupported_grant_type");
        /* renamed from: f */
        public static final C6584d f21144f = C6584d.m26833f(2005, "invalid_scope");
        /* renamed from: g */
        public static final C6584d f21145g = C6584d.m26833f(2006, null);
        /* renamed from: h */
        public static final C6584d f21146h = C6584d.m26833f(2007, null);
        /* renamed from: i */
        private static final Map<String, C6584d> f21147i = C6584d.m26828b(f21139a, f21140b, f21141c, f21142d, f21143e, f21144f, f21145g, f21146h);

        /* renamed from: a */
        public static C6584d m26819a(String str) {
            C6584d c6584d = (C6584d) f21147i.get(str);
            if (c6584d != null) {
                return c6584d;
            }
            return f21146h;
        }
    }

    /* renamed from: d */
    private static C6584d m26831d(int i, String str) {
        return new C6584d(0, i, null, str, null, null);
    }

    /* renamed from: e */
    private static C6584d m26832e(int i, String str) {
        return new C6584d(1, i, str, null, null, null);
    }

    /* renamed from: f */
    private static C6584d m26833f(int i, String str) {
        return new C6584d(2, i, str, null, null, null);
    }

    /* renamed from: a */
    public static C6584d m26826a(C6584d c6584d, Throwable th) {
        return new C6584d(c6584d.f21148a, c6584d.f21149b, c6584d.f21150c, c6584d.f21151d, c6584d.f21152e, th);
    }

    /* renamed from: a */
    public static C6584d m26825a(C6584d c6584d, String str, String str2, Uri uri) {
        int i = c6584d.f21148a;
        int i2 = c6584d.f21149b;
        if (str == null) {
            str = c6584d.f21150c;
        }
        String str3 = str;
        if (str2 == null) {
            str2 = c6584d.f21151d;
        }
        String str4 = str2;
        if (uri == null) {
            uri = c6584d.f21152e;
        }
        return new C6584d(i, i2, str3, str4, uri, null);
    }

    /* renamed from: a */
    public static C6584d m26823a(Uri uri) {
        String queryParameter = uri.getQueryParameter("error");
        String queryParameter2 = uri.getQueryParameter(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
        uri = uri.getQueryParameter("error_uri");
        C6584d a = C6581a.m26818a(queryParameter);
        int i = a.f21148a;
        int i2 = a.f21149b;
        if (queryParameter2 == null) {
            queryParameter2 = a.f21151d;
        }
        return new C6584d(i, i2, queryParameter, queryParameter2, uri != null ? Uri.parse(uri) : a.f21152e, null);
    }

    /* renamed from: a */
    public static C6584d m26824a(String str) {
        C6605p.m26934a(str, (Object) "jsonStr cannot be null or empty");
        return C6584d.m26827a(new JSONObject(str));
    }

    /* renamed from: a */
    public static C6584d m26827a(JSONObject jSONObject) {
        C6605p.m26933a((Object) jSONObject, (Object) "json cannot be null");
        return new C6584d(jSONObject.getInt("type"), jSONObject.getInt("code"), C6604n.m26926b(jSONObject, "error"), C6604n.m26926b(jSONObject, "errorDescription"), C6604n.m26929d(jSONObject, "errorUri"), null);
    }

    /* renamed from: a */
    public static C6584d m26822a(Intent intent) {
        C6605p.m26932a(intent);
        if (!intent.hasExtra("net.openid.appauth.AuthorizationException")) {
            return null;
        }
        try {
            return C6584d.m26824a(intent.getStringExtra("net.openid.appauth.AuthorizationException"));
        } catch (Intent intent2) {
            throw new IllegalArgumentException("Intent contains malformed exception data", intent2);
        }
    }

    /* renamed from: b */
    private static Map<String, C6584d> m26828b(C6584d... c6584dArr) {
        Map c3211a = new C3211a(c6584dArr != null ? c6584dArr.length : 0);
        if (c6584dArr != null) {
            for (C6584d c6584d : c6584dArr) {
                if (c6584d.f21150c != null) {
                    c3211a.put(c6584d.f21150c, c6584d);
                }
            }
        }
        return Collections.unmodifiableMap(c3211a);
    }

    public C6584d(int i, int i2, String str, String str2, Uri uri, Throwable th) {
        super(str2, th);
        this.f21148a = i;
        this.f21149b = i2;
        this.f21150c = str;
        this.f21151d = str2;
        this.f21152e = uri;
    }

    /* renamed from: a */
    public JSONObject m26834a() {
        JSONObject jSONObject = new JSONObject();
        C6604n.m26921a(jSONObject, "type", this.f21148a);
        C6604n.m26921a(jSONObject, "code", this.f21149b);
        C6604n.m26927b(jSONObject, "error", this.f21150c);
        C6604n.m26927b(jSONObject, "errorDescription", this.f21151d);
        C6604n.m26922a(jSONObject, "errorUri", this.f21152e);
        return jSONObject;
    }

    /* renamed from: b */
    public String m26835b() {
        return m26834a().toString();
    }

    /* renamed from: c */
    public Intent m26836c() {
        Intent intent = new Intent();
        intent.putExtra("net.openid.appauth.AuthorizationException", m26835b());
        return intent;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (obj != null) {
            if (obj instanceof C6584d) {
                C6584d c6584d = (C6584d) obj;
                if (this.f21148a != c6584d.f21148a || this.f21149b != c6584d.f21149b) {
                    z = false;
                }
                return z;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f21148a + 31) * 31) + this.f21149b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AuthorizationException: ");
        stringBuilder.append(m26835b());
        return stringBuilder.toString();
    }
}
