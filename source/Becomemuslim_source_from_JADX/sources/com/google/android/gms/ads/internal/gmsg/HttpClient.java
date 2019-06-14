package com.google.android.gms.ads.internal.gmsg;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.facebook.GraphResponse;
import com.google.android.gms.ads.internal.ax;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.ads.azm;
import com.google.android.gms.internal.ads.cm;
import com.google.android.gms.internal.ads.jn;
import com.google.android.gms.internal.ads.ju;
import com.google.android.gms.internal.ads.jw;
import com.google.android.gms.internal.ads.mm;
import com.google.android.gms.internal.ads.mv;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

@Keep
@KeepName
@cm
public class HttpClient implements ae<azm> {
    private final Context mContext;
    private final mv zzyf;

    @cm
    /* renamed from: com.google.android.gms.ads.internal.gmsg.HttpClient$a */
    static class C2644a {
        /* renamed from: a */
        private final String f6856a;
        /* renamed from: b */
        private final String f6857b;

        public C2644a(String str, String str2) {
            this.f6856a = str;
            this.f6857b = str2;
        }

        /* renamed from: a */
        public final String m7511a() {
            return this.f6856a;
        }

        /* renamed from: b */
        public final String m7512b() {
            return this.f6857b;
        }
    }

    @cm
    /* renamed from: com.google.android.gms.ads.internal.gmsg.HttpClient$b */
    static class C2645b {
        /* renamed from: a */
        private final String f6858a;
        /* renamed from: b */
        private final URL f6859b;
        /* renamed from: c */
        private final ArrayList<C2644a> f6860c;
        /* renamed from: d */
        private final String f6861d;

        C2645b(String str, URL url, ArrayList<C2644a> arrayList, String str2) {
            this.f6858a = str;
            this.f6859b = url;
            this.f6860c = arrayList;
            this.f6861d = str2;
        }

        /* renamed from: a */
        public final String m7513a() {
            return this.f6858a;
        }

        /* renamed from: b */
        public final URL m7514b() {
            return this.f6859b;
        }

        /* renamed from: c */
        public final ArrayList<C2644a> m7515c() {
            return this.f6860c;
        }

        /* renamed from: d */
        public final String m7516d() {
            return this.f6861d;
        }
    }

    @cm
    /* renamed from: com.google.android.gms.ads.internal.gmsg.HttpClient$c */
    class C2646c {
        /* renamed from: a */
        private final C2647d f6862a;
        /* renamed from: b */
        private final boolean f6863b;
        /* renamed from: c */
        private final String f6864c;

        public C2646c(HttpClient httpClient, boolean z, C2647d c2647d, String str) {
            this.f6863b = z;
            this.f6862a = c2647d;
            this.f6864c = str;
        }

        /* renamed from: a */
        public final String m7517a() {
            return this.f6864c;
        }

        /* renamed from: b */
        public final C2647d m7518b() {
            return this.f6862a;
        }

        /* renamed from: c */
        public final boolean m7519c() {
            return this.f6863b;
        }
    }

    @cm
    /* renamed from: com.google.android.gms.ads.internal.gmsg.HttpClient$d */
    static class C2647d {
        /* renamed from: a */
        private final String f6865a;
        /* renamed from: b */
        private final int f6866b;
        /* renamed from: c */
        private final List<C2644a> f6867c;
        /* renamed from: d */
        private final String f6868d;

        C2647d(String str, int i, List<C2644a> list, String str2) {
            this.f6865a = str;
            this.f6866b = i;
            this.f6867c = list;
            this.f6868d = str2;
        }

        /* renamed from: a */
        public final String m7520a() {
            return this.f6865a;
        }

        /* renamed from: b */
        public final int m7521b() {
            return this.f6866b;
        }

        /* renamed from: c */
        public final Iterable<C2644a> m7522c() {
            return this.f6867c;
        }

        /* renamed from: d */
        public final String m7523d() {
            return this.f6868d;
        }
    }

    public HttpClient(Context context, mv mvVar) {
        this.mContext = context;
        this.zzyf = mvVar;
    }

    private final C2646c zza(C2645b c2645b) {
        Exception e;
        C2646c c2646c;
        Throwable th;
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection) c2645b.m7514b().openConnection();
            try {
                byte[] bArr;
                ax.m7464e().a(this.mContext, this.zzyf.f28709a, false, httpURLConnection);
                ArrayList c = c2645b.m7515c();
                int size = c.size();
                int i = 0;
                while (i < size) {
                    Object obj = c.get(i);
                    i++;
                    C2644a c2644a = (C2644a) obj;
                    httpURLConnection.addRequestProperty(c2644a.m7511a(), c2644a.m7512b());
                }
                if (TextUtils.isEmpty(c2645b.m7516d())) {
                    bArr = null;
                } else {
                    httpURLConnection.setDoOutput(true);
                    bArr = c2645b.m7516d().getBytes();
                    httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                    bufferedOutputStream.write(bArr);
                    bufferedOutputStream.close();
                }
                mm mmVar = new mm();
                mmVar.a(httpURLConnection, bArr);
                List arrayList = new ArrayList();
                if (httpURLConnection.getHeaderFields() != null) {
                    for (Entry entry : httpURLConnection.getHeaderFields().entrySet()) {
                        for (String c2644a2 : (List) entry.getValue()) {
                            arrayList.add(new C2644a((String) entry.getKey(), c2644a2));
                        }
                    }
                }
                String a = c2645b.m7513a();
                int responseCode = httpURLConnection.getResponseCode();
                ax.m7464e();
                C2647d c2647d = new C2647d(a, responseCode, arrayList, jw.a(new InputStreamReader(httpURLConnection.getInputStream())));
                mmVar.a(httpURLConnection, c2647d.m7521b());
                mmVar.a(c2647d.m7523d());
                C2646c c2646c2 = new C2646c(this, true, c2647d, null);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return c2646c2;
            } catch (Exception e2) {
                e = e2;
                try {
                    c2646c = new C2646c(this, false, null, e.toString());
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return c2646c;
                } catch (Throwable th2) {
                    th = th2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            httpURLConnection = null;
            c2646c = new C2646c(this, false, null, e.toString());
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return c2646c;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private static JSONObject zza(C2647d c2647d) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", c2647d.m7520a());
            if (c2647d.m7523d() != null) {
                jSONObject.put("body", c2647d.m7523d());
            }
            JSONArray jSONArray = new JSONArray();
            for (C2644a c2644a : c2647d.m7522c()) {
                jSONArray.put(new JSONObject().put("key", c2644a.m7511a()).put("value", c2644a.m7512b()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", c2647d.m7521b());
        } catch (Throwable e) {
            jn.b("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    private static C2645b zzc(JSONObject jSONObject) {
        String optString = jSONObject.optString("http_request_id");
        String optString2 = jSONObject.optString("url");
        URL url = null;
        String optString3 = jSONObject.optString("post_body", null);
        try {
            url = new URL(optString2);
        } catch (Throwable e) {
            jn.b("Error constructing http request.", e);
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new C2644a(optJSONObject.optString("key"), optJSONObject.optString("value")));
            }
        }
        return new C2645b(optString, url, arrayList, optString3);
    }

    @Keep
    @KeepName
    public JSONObject send(JSONObject jSONObject) {
        Object optString;
        Throwable e;
        JSONObject jSONObject2 = new JSONObject();
        String str = "";
        try {
            optString = jSONObject.optString("http_request_id");
            try {
                C2646c zza = zza(zzc(jSONObject));
                if (zza.m7519c()) {
                    jSONObject2.put("response", zza(zza.m7518b()));
                    jSONObject2.put(GraphResponse.SUCCESS_KEY, true);
                } else {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", optString));
                    jSONObject2.put(GraphResponse.SUCCESS_KEY, false);
                    jSONObject2.put("reason", zza.m7517a());
                }
            } catch (Exception e2) {
                e = e2;
                jn.b("Error executing http request.", e);
                try {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", optString));
                    jSONObject2.put(GraphResponse.SUCCESS_KEY, false);
                    jSONObject2.put("reason", e.toString());
                } catch (Throwable e3) {
                    jn.b("Error executing http request.", e3);
                }
                return jSONObject2;
            }
        } catch (Exception e4) {
            e3 = e4;
            optString = str;
            jn.b("Error executing http request.", e3);
            jSONObject2.put("response", new JSONObject().put("http_request_id", optString));
            jSONObject2.put(GraphResponse.SUCCESS_KEY, false);
            jSONObject2.put("reason", e3.toString());
            return jSONObject2;
        }
        return jSONObject2;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        ju.a(new af(this, map, (azm) obj));
    }
}
