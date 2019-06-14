package com.p073d.p074a;

import android.text.TextUtils;
import com.facebook.stetho.server.http.HttpStatus;
import com.p073d.p074a.p076b.C1139b;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.zip.GZIPOutputStream;

/* compiled from: Client */
/* renamed from: com.d.a.e */
class C1146e {
    /* renamed from: a */
    final C1147f f3251a;
    /* renamed from: b */
    final String f3252b;

    /* compiled from: Client */
    /* renamed from: com.d.a.e$a */
    static abstract class C1144a implements Closeable {
        /* renamed from: a */
        final HttpURLConnection f3245a;
        /* renamed from: b */
        final InputStream f3246b;
        /* renamed from: c */
        final OutputStream f3247c;

        C1144a(HttpURLConnection httpURLConnection, InputStream inputStream, OutputStream outputStream) {
            if (httpURLConnection != null) {
                this.f3245a = httpURLConnection;
                this.f3246b = inputStream;
                this.f3247c = outputStream;
                return;
            }
            throw new IllegalArgumentException("connection == null");
        }

        public void close() {
            this.f3245a.disconnect();
        }
    }

    /* compiled from: Client */
    /* renamed from: com.d.a.e$b */
    static class C1145b extends IOException {
        /* renamed from: a */
        final int f3248a;
        /* renamed from: b */
        final String f3249b;
        /* renamed from: c */
        final String f3250c;

        C1145b(int i, String str, String str2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("HTTP ");
            stringBuilder.append(i);
            stringBuilder.append(": ");
            stringBuilder.append(str);
            stringBuilder.append(". Response: ");
            stringBuilder.append(str2);
            super(stringBuilder.toString());
            this.f3248a = i;
            this.f3249b = str;
            this.f3250c = str2;
        }
    }

    /* renamed from: a */
    private static C1144a m4049a(HttpURLConnection httpURLConnection) {
        OutputStream gZIPOutputStream;
        if (TextUtils.equals("gzip", httpURLConnection.getRequestProperty("Content-Encoding"))) {
            gZIPOutputStream = new GZIPOutputStream(httpURLConnection.getOutputStream());
        } else {
            gZIPOutputStream = httpURLConnection.getOutputStream();
        }
        return new C1144a(httpURLConnection, null, gZIPOutputStream) {
            public void close() {
                String b;
                try {
                    int responseCode = this.a.getResponseCode();
                    if (responseCode < 300) {
                        super.close();
                        this.c.close();
                        return;
                    }
                    b = C1139b.m4024b(this.a.getInputStream());
                    throw new C1145b(responseCode, this.a.getResponseMessage(), b);
                } catch (IOException e) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Could not read response body for rejected message: ");
                    stringBuilder.append(e.toString());
                    b = stringBuilder.toString();
                } catch (Throwable th) {
                    super.close();
                    this.c.close();
                }
            }
        };
    }

    /* renamed from: b */
    private static C1144a m4050b(HttpURLConnection httpURLConnection) {
        return new C1144a(httpURLConnection, httpURLConnection.getInputStream(), null) {
            public void close() {
                super.close();
                this.b.close();
            }
        };
    }

    C1146e(String str, C1147f c1147f) {
        this.f3252b = str;
        this.f3251a = c1147f;
    }

    /* renamed from: a */
    C1144a m4051a() {
        return C1146e.m4049a(this.f3251a.m4056b(this.f3252b));
    }

    /* renamed from: b */
    C1144a m4052b() {
        return C1146e.m4049a(this.f3251a.m4057c(this.f3252b));
    }

    /* renamed from: c */
    C1144a m4053c() {
        HttpURLConnection a = this.f3251a.m4055a(this.f3252b);
        int responseCode = a.getResponseCode();
        if (responseCode == HttpStatus.HTTP_OK) {
            return C1146e.m4050b(a);
        }
        a.disconnect();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTP ");
        stringBuilder.append(responseCode);
        stringBuilder.append(": ");
        stringBuilder.append(a.getResponseMessage());
        throw new IOException(stringBuilder.toString());
    }
}
