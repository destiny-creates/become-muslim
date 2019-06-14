package com.p073d.p074a;

import android.util.Base64;
import com.facebook.stetho.server.http.HttpHeaders;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: ConnectionFactory */
/* renamed from: com.d.a.f */
public class C1147f {
    /* renamed from: e */
    private String m4054e(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Basic ");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(":");
        stringBuilder.append(Base64.encodeToString(stringBuilder2.toString().getBytes(), 2));
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public HttpURLConnection m4055a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://cdn-settings.segment.com/v1/projects/");
        stringBuilder.append(str);
        stringBuilder.append("/settings");
        return m4058d(stringBuilder.toString());
    }

    /* renamed from: b */
    public HttpURLConnection m4056b(String str) {
        HttpURLConnection d = m4058d("https://api.segment.io/v1/import");
        d.setRequestProperty("Authorization", m4054e(str));
        d.setRequestProperty("Content-Encoding", "gzip");
        d.setDoOutput(true);
        d.setChunkedStreamingMode(null);
        return d;
    }

    /* renamed from: c */
    public HttpURLConnection m4057c(String str) {
        HttpURLConnection d = m4058d("https://mobile-service.segment.com/v1/attribution");
        d.setRequestProperty("Authorization", m4054e(str));
        d.setRequestMethod("POST");
        d.setDoOutput(true);
        return d;
    }

    /* renamed from: d */
    protected HttpURLConnection m4058d(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }
}
