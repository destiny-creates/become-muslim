package net.openid.appauth;

import android.net.Uri;
import android.os.AsyncTask;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import net.openid.appauth.C6584d.C6582b;
import net.openid.appauth.C6598i.C6597a;
import net.openid.appauth.p369b.C6575a;
import net.openid.appauth.p370c.C6578a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AuthorizationServiceConfiguration */
/* renamed from: net.openid.appauth.h */
public class C6596h {
    /* renamed from: a */
    public final Uri f21215a;
    /* renamed from: b */
    public final Uri f21216b;
    /* renamed from: c */
    public final Uri f21217c;
    /* renamed from: d */
    public final C6598i f21218d;

    /* compiled from: AuthorizationServiceConfiguration */
    /* renamed from: net.openid.appauth.h$a */
    private static class C6594a extends AsyncTask<Void, Void, C6596h> {
        /* renamed from: a */
        private Uri f21211a;
        /* renamed from: b */
        private C6575a f21212b;
        /* renamed from: c */
        private C6595b f21213c;
        /* renamed from: d */
        private C6584d f21214d = null;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m26894a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m26895a((C6596h) obj);
        }

        C6594a(Uri uri, C6575a c6575a, C6595b c6595b) {
            this.f21211a = uri;
            this.f21212b = c6575a;
            this.f21213c = c6595b;
        }

        /* renamed from: a */
        protected C6596h m26894a(Void... voidArr) {
            InputStream inputStream;
            Throwable e;
            try {
                HttpURLConnection openConnection = this.f21212b.openConnection(this.f21211a);
                openConnection.setRequestMethod("GET");
                openConnection.setDoInput(true);
                openConnection.connect();
                inputStream = openConnection.getInputStream();
                try {
                    C6596h c6596h = new C6596h(new C6598i(new JSONObject(C6611t.m26969a(inputStream))));
                    C6611t.m26970b(inputStream);
                    return c6596h;
                } catch (IOException e2) {
                    e = e2;
                    C6578a.m26806b(e, "Network error when retrieving discovery document", new Object[0]);
                    this.f21214d = C6584d.m26826a(C6582b.f21134d, e);
                    C6611t.m26970b(inputStream);
                    return null;
                } catch (JSONException e3) {
                    e = e3;
                    C6578a.m26806b(e, "Error parsing discovery document", new Object[0]);
                    this.f21214d = C6584d.m26826a(C6582b.f21136f, e);
                    C6611t.m26970b(inputStream);
                    return null;
                } catch (C6597a e4) {
                    e = e4;
                    C6578a.m26806b(e, "Malformed discovery document", new Object[0]);
                    this.f21214d = C6584d.m26826a(C6582b.f21131a, e);
                    C6611t.m26970b(inputStream);
                    return null;
                }
            } catch (IOException e5) {
                e = e5;
                inputStream = null;
                C6578a.m26806b(e, "Network error when retrieving discovery document", new Object[0]);
                this.f21214d = C6584d.m26826a(C6582b.f21134d, e);
                C6611t.m26970b(inputStream);
                return null;
            } catch (JSONException e6) {
                e = e6;
                inputStream = null;
                C6578a.m26806b(e, "Error parsing discovery document", new Object[0]);
                this.f21214d = C6584d.m26826a(C6582b.f21136f, e);
                C6611t.m26970b(inputStream);
                return null;
            } catch (C6597a e7) {
                e = e7;
                inputStream = null;
                C6578a.m26806b(e, "Malformed discovery document", new Object[0]);
                this.f21214d = C6584d.m26826a(C6582b.f21131a, e);
                C6611t.m26970b(inputStream);
                return null;
            } catch (Throwable th) {
                voidArr = th;
                C6611t.m26970b(inputStream);
                throw voidArr;
            }
        }

        /* renamed from: a */
        protected void m26895a(C6596h c6596h) {
            if (this.f21214d != null) {
                this.f21213c.onFetchConfigurationCompleted(null, this.f21214d);
            } else {
                this.f21213c.onFetchConfigurationCompleted(c6596h, null);
            }
        }
    }

    /* compiled from: AuthorizationServiceConfiguration */
    /* renamed from: net.openid.appauth.h$b */
    public interface C6595b {
        void onFetchConfigurationCompleted(C6596h c6596h, C6584d c6584d);
    }

    public C6596h(Uri uri, Uri uri2, Uri uri3) {
        this.f21215a = (Uri) C6605p.m26932a(uri);
        this.f21216b = (Uri) C6605p.m26932a(uri2);
        this.f21217c = uri3;
        this.f21218d = null;
    }

    public C6596h(C6598i c6598i) {
        C6605p.m26933a((Object) c6598i, (Object) "docJson cannot be null");
        this.f21218d = c6598i;
        this.f21215a = c6598i.m26906a();
        this.f21216b = c6598i.m26907b();
        this.f21217c = c6598i.m26908c();
    }

    /* renamed from: a */
    public JSONObject m26898a() {
        JSONObject jSONObject = new JSONObject();
        C6604n.m26924a(jSONObject, "authorizationEndpoint", this.f21215a.toString());
        C6604n.m26924a(jSONObject, "tokenEndpoint", this.f21216b.toString());
        if (this.f21217c != null) {
            C6604n.m26924a(jSONObject, "registrationEndpoint", this.f21217c.toString());
        }
        if (this.f21218d != null) {
            C6604n.m26925a(jSONObject, "discoveryDoc", this.f21218d.f21256J);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static C6596h m26896a(JSONObject jSONObject) {
        C6605p.m26933a((Object) jSONObject, (Object) "json object cannot be null");
        if (jSONObject.has("discoveryDoc")) {
            try {
                return new C6596h(new C6598i(jSONObject.optJSONObject("discoveryDoc")));
            } catch (JSONObject jSONObject2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Missing required field in discovery doc: ");
                stringBuilder.append(jSONObject2.m26899a());
                throw new JSONException(stringBuilder.toString());
            }
        }
        C6605p.m26935a(jSONObject2.has("authorizationEndpoint"), (Object) "missing authorizationEndpoint");
        C6605p.m26935a(jSONObject2.has("tokenEndpoint"), (Object) "missing tokenEndpoint");
        return new C6596h(C6604n.m26928c(jSONObject2, "authorizationEndpoint"), C6604n.m26928c(jSONObject2, "tokenEndpoint"), C6604n.m26929d(jSONObject2, "registrationEndpoint"));
    }

    /* renamed from: a */
    public static void m26897a(Uri uri, C6595b c6595b, C6575a c6575a) {
        C6605p.m26933a((Object) uri, (Object) "openIDConnectDiscoveryUri cannot be null");
        C6605p.m26933a((Object) c6595b, (Object) "callback cannot be null");
        C6605p.m26933a((Object) c6575a, (Object) "connectionBuilder must not be null");
        new C6594a(uri, c6575a, c6595b).execute(new Void[null]);
    }
}
