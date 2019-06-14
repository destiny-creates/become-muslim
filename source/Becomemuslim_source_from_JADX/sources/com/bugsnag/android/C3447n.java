package com.bugsnag.android;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bugsnag.android.ab.C1071a;
import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.server.http.HttpHeaders;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: DefaultDelivery */
/* renamed from: com.bugsnag.android.n */
class C3447n implements C1094o {
    /* renamed from: a */
    private final ConnectivityManager f9200a;

    C3447n(ConnectivityManager connectivityManager) {
        this.f9200a = connectivityManager;
    }

    /* renamed from: a */
    public void mo780a(am amVar, C1091l c1091l) {
        amVar = m11059a(c1091l.m3846e(), amVar, c1091l.m3871x());
        if (amVar != 202) {
            c1091l = new StringBuilder();
            c1091l.append("Session API request failed with status ");
            c1091l.append(amVar);
            ad.m3733a(c1091l.toString(), null);
            return;
        }
        ad.m3732a("Completed session tracking request");
    }

    /* renamed from: a */
    public void mo779a(ai aiVar, C1091l c1091l) {
        aiVar = m11059a(c1091l.m3843d(), aiVar, c1091l.m3870w());
        if (aiVar / 100 != 2) {
            c1091l = new StringBuilder();
            c1091l.append("Error API request failed with status ");
            c1091l.append(aiVar);
            ad.m3733a(c1091l.toString(), null);
            return;
        }
        ad.m3732a("Completed error API request");
    }

    /* renamed from: a */
    int m11059a(String str, C1071a c1071a, Map<String, String> map) {
        Closeable closeable;
        m11058a();
        URLConnection uRLConnection = null;
        try {
            URLConnection uRLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                uRLConnection2.setDoOutput(true);
                uRLConnection2.setChunkedStreamingMode(0);
                uRLConnection2.addRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
                map = map.entrySet().iterator();
                while (map.hasNext()) {
                    Entry entry = (Entry) map.next();
                    uRLConnection2.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                try {
                    Closeable abVar = new ab(new BufferedWriter(new OutputStreamWriter(uRLConnection2.getOutputStream(), Charset.forName(Utf8Charset.NAME))));
                    try {
                        c1071a.toStream(abVar);
                        aa.m3708a(abVar);
                        c1071a = uRLConnection2.getResponseCode();
                        aa.m3709a(uRLConnection2);
                        return c1071a;
                    } catch (Throwable th) {
                        c1071a = th;
                        closeable = abVar;
                        aa.m3708a(closeable);
                        throw c1071a;
                    }
                } catch (Throwable th2) {
                    c1071a = th2;
                    aa.m3708a(closeable);
                    throw c1071a;
                }
            } catch (IOException e) {
                c1071a = e;
                uRLConnection = uRLConnection2;
                throw new C1095p("IOException encountered in request", c1071a);
            } catch (Exception e2) {
                c1071a = e2;
                uRLConnection = uRLConnection2;
                try {
                    ad.m3733a("Unexpected error delivering payload", c1071a);
                    aa.m3709a(uRLConnection);
                    return 0;
                } catch (Throwable th3) {
                    c1071a = th3;
                    uRLConnection2 = uRLConnection;
                    aa.m3709a(uRLConnection2);
                    throw c1071a;
                }
            } catch (Throwable th4) {
                c1071a = th4;
                aa.m3709a(uRLConnection2);
                throw c1071a;
            }
        } catch (IOException e3) {
            c1071a = e3;
            throw new C1095p("IOException encountered in request", c1071a);
        } catch (Exception e4) {
            c1071a = e4;
            ad.m3733a("Unexpected error delivering payload", c1071a);
            aa.m3709a(uRLConnection);
            return 0;
        }
    }

    /* renamed from: a */
    private void m11058a() {
        if (this.f9200a != null) {
            NetworkInfo activeNetworkInfo = this.f9200a.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                throw new C1095p("No network connection available", null);
            }
        }
    }
}
