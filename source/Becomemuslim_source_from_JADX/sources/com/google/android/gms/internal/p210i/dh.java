package com.google.android.gms.internal.p210i;

import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.gms.p185e.bs;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.google.android.gms.internal.i.dh */
final class dh implements di {
    /* renamed from: a */
    private HttpURLConnection f24464a;
    /* renamed from: b */
    private InputStream f24465b = null;

    dh() {
    }

    /* renamed from: a */
    public final InputStream mo4426a(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        this.f24464a = httpURLConnection;
        str = this.f24464a;
        int responseCode = str.getResponseCode();
        if (responseCode == HttpStatus.HTTP_OK) {
            this.f24465b = str.getInputStream();
            return this.f24465b;
        }
        StringBuilder stringBuilder = new StringBuilder(25);
        stringBuilder.append("Bad response: ");
        stringBuilder.append(responseCode);
        str = stringBuilder.toString();
        if (responseCode == HttpStatus.HTTP_NOT_FOUND) {
            throw new FileNotFoundException(str);
        } else if (responseCode == 503) {
            throw new dk(str);
        } else {
            throw new IOException(str);
        }
    }

    /* renamed from: a */
    public final void mo4427a() {
        HttpURLConnection httpURLConnection = this.f24464a;
        try {
            if (this.f24465b != null) {
                this.f24465b.close();
            }
        } catch (Throwable e) {
            String str = "HttpUrlConnectionNetworkClient: Error when closing http input stream: ";
            String valueOf = String.valueOf(e.getMessage());
            bs.a(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), e);
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}
