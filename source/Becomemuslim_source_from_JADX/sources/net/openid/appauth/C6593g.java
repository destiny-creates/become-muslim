package net.openid.appauth;

import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.p015c.C0107c;
import android.support.p015c.C0107c.C0106a;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.facebook.stetho.server.http.HttpHeaders;
import com.facebook.stetho.server.http.HttpStatus;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URLConnection;
import java.util.Map;
import java.util.Map.Entry;
import net.openid.appauth.C6584d.C6582b;
import net.openid.appauth.C6584d.C6583c;
import net.openid.appauth.C6610s.C6609a;
import net.openid.appauth.p368a.C6568b;
import net.openid.appauth.p368a.C6570d;
import net.openid.appauth.p368a.C6571e;
import net.openid.appauth.p369b.C6575a;
import net.openid.appauth.p370c.C6578a;
import net.openid.appauth.p370c.C6579b;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AuthorizationService */
/* renamed from: net.openid.appauth.g */
public class C6593g {
    /* renamed from: a */
    Context f21206a;
    /* renamed from: b */
    private final C6576b f21207b;
    /* renamed from: c */
    private final C6571e f21208c;
    /* renamed from: d */
    private final C6568b f21209d;
    /* renamed from: e */
    private boolean f21210e;

    /* compiled from: AuthorizationService */
    /* renamed from: net.openid.appauth.g$a */
    private static class C6591a extends AsyncTask<Void, Void, JSONObject> {
        /* renamed from: a */
        private C6608r f21201a;
        /* renamed from: b */
        private C6599j f21202b;
        /* renamed from: c */
        private final C6575a f21203c;
        /* renamed from: d */
        private C6592b f21204d;
        /* renamed from: e */
        private C6584d f21205e;

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m26885a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m26886a((JSONObject) obj);
        }

        C6591a(C6608r c6608r, C6599j c6599j, C6575a c6575a, C6592b c6592b) {
            this.f21201a = c6608r;
            this.f21202b = c6599j;
            this.f21203c = c6575a;
            this.f21204d = c6592b;
        }

        /* renamed from: a */
        protected JSONObject m26885a(Void... voidArr) {
            InputStream errorStream;
            Throwable th;
            InputStream inputStream;
            Throwable th2;
            InputStream inputStream2 = null;
            try {
                URLConnection openConnection = this.f21203c.openConnection(this.f21201a.f21272a.f21216b);
                openConnection.setRequestMethod("POST");
                openConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
                m26884a(openConnection);
                openConnection.setDoOutput(true);
                Map a = this.f21202b.mo5513a(this.f21201a.f21273b);
                if (a != null) {
                    for (Entry entry : a.entrySet()) {
                        openConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                a = this.f21201a.m26953a();
                Map b = this.f21202b.mo5514b(this.f21201a.f21273b);
                if (b != null) {
                    a.putAll(b);
                }
                String a2 = C6579b.m26812a(a);
                openConnection.setRequestProperty(HttpHeaders.CONTENT_LENGTH, String.valueOf(a2.length()));
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openConnection.getOutputStream());
                outputStreamWriter.write(a2);
                outputStreamWriter.flush();
                if (openConnection.getResponseCode() < HttpStatus.HTTP_OK || openConnection.getResponseCode() >= 300) {
                    errorStream = openConnection.getErrorStream();
                } else {
                    errorStream = openConnection.getInputStream();
                }
                try {
                    JSONObject jSONObject = new JSONObject(C6611t.m26969a(errorStream));
                    C6611t.m26970b(errorStream);
                    return jSONObject;
                } catch (Throwable e) {
                    th = e;
                    inputStream = errorStream;
                    th2 = th;
                    C6578a.m26804a(th2, "Failed to complete exchange request", new Object[0]);
                    this.f21205e = C6584d.m26826a(C6582b.f21134d, th2);
                    C6611t.m26970b(inputStream);
                    return null;
                } catch (Throwable e2) {
                    th = e2;
                    inputStream = errorStream;
                    th2 = th;
                    C6578a.m26804a(th2, "Failed to complete exchange request", new Object[0]);
                    this.f21205e = C6584d.m26826a(C6582b.f21136f, th2);
                    C6611t.m26970b(inputStream);
                    return null;
                } catch (Throwable th3) {
                    voidArr = th3;
                    inputStream2 = errorStream;
                    C6611t.m26970b(inputStream2);
                    throw voidArr;
                }
            } catch (IOException e3) {
                th2 = e3;
                inputStream = null;
                C6578a.m26804a(th2, "Failed to complete exchange request", new Object[0]);
                this.f21205e = C6584d.m26826a(C6582b.f21134d, th2);
                C6611t.m26970b(inputStream);
                return null;
            } catch (JSONException e4) {
                th2 = e4;
                inputStream = null;
                C6578a.m26804a(th2, "Failed to complete exchange request", new Object[0]);
                this.f21205e = C6584d.m26826a(C6582b.f21136f, th2);
                C6611t.m26970b(inputStream);
                return null;
            } catch (Throwable th4) {
                voidArr = th4;
                inputStream2 = inputStream;
                C6611t.m26970b(inputStream2);
                throw voidArr;
            }
        }

        /* renamed from: a */
        protected void m26886a(JSONObject jSONObject) {
            if (this.f21205e != null) {
                this.f21204d.onTokenRequestCompleted(null, this.f21205e);
            } else if (jSONObject.has("error")) {
                try {
                    String string = jSONObject.getString("error");
                    jSONObject = C6584d.m26825a(C6583c.m26819a(string), string, jSONObject.optString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION, null), C6579b.m26810a(jSONObject.optString("error_uri")));
                } catch (Throwable e) {
                    jSONObject = C6584d.m26826a(C6582b.f21136f, e);
                }
                this.f21204d.onTokenRequestCompleted(null, jSONObject);
            } else {
                try {
                    jSONObject = new C6609a(this.f21201a).m26960a(jSONObject).m26962a();
                    C6578a.m26803a("Token exchange with %s completed", this.f21201a.f21272a.f21216b);
                    this.f21204d.onTokenRequestCompleted(jSONObject, null);
                } catch (Throwable e2) {
                    this.f21204d.onTokenRequestCompleted(null, C6584d.m26826a(C6582b.f21136f, e2));
                }
            }
        }

        /* renamed from: a */
        private void m26884a(URLConnection uRLConnection) {
            if (TextUtils.isEmpty(uRLConnection.getRequestProperty("Accept"))) {
                uRLConnection.setRequestProperty("Accept", "application/json");
            }
        }
    }

    /* compiled from: AuthorizationService */
    /* renamed from: net.openid.appauth.g$b */
    public interface C6592b {
        void onTokenRequestCompleted(C6610s c6610s, C6584d c6584d);
    }

    public C6593g(Context context) {
        this(context, C6576b.f21114a);
    }

    public C6593g(Context context, C6576b c6576b) {
        this(context, c6576b, C6570d.m26782a(context, c6576b.m26797a()), new C6571e(context));
    }

    C6593g(Context context, C6576b c6576b, C6568b c6568b, C6571e c6571e) {
        this.f21210e = false;
        this.f21206a = (Context) C6605p.m26932a(context);
        this.f21207b = c6576b;
        this.f21208c = c6571e;
        this.f21209d = c6568b;
        if (c6568b != null && c6568b.f21106d.booleanValue() != null) {
            this.f21208c.m26790a(c6568b.f21103a);
        }
    }

    /* renamed from: a */
    public C0106a m26889a(Uri... uriArr) {
        m26888a();
        return this.f21208c.m26788a(uriArr);
    }

    /* renamed from: a */
    public void m26890a(C6587e c6587e, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
        m26891a(c6587e, pendingIntent, pendingIntent2, m26889a(new Uri[0]).a());
    }

    /* renamed from: a */
    public void m26891a(C6587e c6587e, PendingIntent pendingIntent, PendingIntent pendingIntent2, C0107c c0107c) {
        m26888a();
        C6605p.m26932a(c6587e);
        C6605p.m26932a(pendingIntent);
        C6605p.m26932a(c0107c);
        this.f21206a.startActivity(AuthorizationManagementActivity.m26773a(this.f21206a, c6587e, m26887a(c6587e, c0107c), pendingIntent, pendingIntent2));
    }

    /* renamed from: a */
    public void m26892a(C6608r c6608r, C6592b c6592b) {
        m26893a(c6608r, C7646o.f26414a, c6592b);
    }

    /* renamed from: a */
    public void m26893a(C6608r c6608r, C6599j c6599j, C6592b c6592b) {
        m26888a();
        C6578a.m26803a("Initiating code exchange request to %s", c6608r.f21272a.f21216b);
        new C6591a(c6608r, c6599j, this.f21207b.m26798b(), c6592b).execute(new Void[0]);
    }

    /* renamed from: a */
    private void m26888a() {
        if (this.f21210e) {
            throw new IllegalStateException("Service has been disposed and rendered inoperable");
        }
    }

    /* renamed from: a */
    private Intent m26887a(C6587e c6587e, C0107c c0107c) {
        m26888a();
        if (this.f21209d != null) {
            Uri a = c6587e.m26858a();
            if (this.f21209d.f21106d.booleanValue()) {
                c0107c = c0107c.f240a;
            } else {
                c0107c = new Intent("android.intent.action.VIEW");
            }
            c0107c.setPackage(this.f21209d.f21103a);
            c0107c.setData(a);
            C6578a.m26803a("Using %s as browser for auth, custom tab = %s", c0107c.getPackage(), this.f21209d.f21106d.toString());
            C6578a.m26803a("Initiating authorization request to %s", c6587e.f21168a.f21215a);
            return c0107c;
        }
        throw new ActivityNotFoundException();
    }
}
