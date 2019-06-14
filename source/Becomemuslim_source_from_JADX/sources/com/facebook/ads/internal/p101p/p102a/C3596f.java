package com.facebook.ads.internal.p101p.p102a;

import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.server.http.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.facebook.ads.internal.p.a.f */
public abstract class C3596f implements C1453q {
    /* renamed from: a */
    private final C1454r f9601a;

    public C3596f() {
        this(new C3597g());
    }

    public C3596f(C1454r c1454r) {
        this.f9601a = c1454r;
    }

    /* renamed from: a */
    public OutputStream mo970a(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getOutputStream();
    }

    /* renamed from: a */
    public HttpURLConnection mo971a(String str) {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    /* renamed from: a */
    public void mo972a(OutputStream outputStream, byte[] bArr) {
        outputStream.write(bArr);
    }

    /* renamed from: a */
    public void mo973a(HttpURLConnection httpURLConnection, C1447j c1447j, String str) {
        httpURLConnection.setRequestMethod(c1447j.m5127c());
        httpURLConnection.setDoOutput(c1447j.m5126b());
        httpURLConnection.setDoInput(c1447j.m5125a());
        if (str != null) {
            httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, str);
        }
        httpURLConnection.setRequestProperty("Accept-Charset", Utf8Charset.NAME);
    }

    /* renamed from: a */
    public boolean mo974a(C1449m c1449m) {
        C1450n a = c1449m.m5132a();
        if (this.f9601a.mo980a()) {
            this.f9601a.mo978a("BasicRequestHandler.onError got");
            c1449m.printStackTrace();
        }
        return a != null && a.m5133a() > 0;
    }

    /* renamed from: a */
    public byte[] mo975a(InputStream inputStream) {
        byte[] bArr = new byte[16384];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* renamed from: b */
    public InputStream mo976b(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getInputStream();
    }
}
