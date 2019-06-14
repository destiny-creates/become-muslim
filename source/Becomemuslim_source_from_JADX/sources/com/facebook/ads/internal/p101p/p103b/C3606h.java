package com.facebook.ads.internal.p101p.p103b;

import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.Utility;
import com.facebook.stetho.server.http.HttpStatus;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.facebook.ads.internal.p.b.h */
public class C3606h implements C1479n {
    /* renamed from: a */
    public final String f9615a;
    /* renamed from: b */
    private HttpURLConnection f9616b;
    /* renamed from: c */
    private InputStream f9617c;
    /* renamed from: d */
    private volatile int f9618d;
    /* renamed from: e */
    private volatile String f9619e;

    public C3606h(C3606h c3606h) {
        this.f9618d = LinearLayoutManager.INVALID_OFFSET;
        this.f9615a = c3606h.f9615a;
        this.f9619e = c3606h.f9619e;
        this.f9618d = c3606h.f9618d;
    }

    public C3606h(String str) {
        this(str, C1478m.m5227a(str));
    }

    public C3606h(String str, String str2) {
        this.f9618d = LinearLayoutManager.INVALID_OFFSET;
        this.f9615a = (String) C1473j.m5210a(str);
        this.f9619e = str2;
    }

    /* renamed from: a */
    private int m11756a(HttpURLConnection httpURLConnection, int i, int i2) {
        int contentLength = httpURLConnection.getContentLength();
        return i2 == HttpStatus.HTTP_OK ? contentLength : i2 == 206 ? contentLength + i : this.f9618d;
    }

    /* renamed from: a */
    private HttpURLConnection m11757a(int i, int i2) {
        HttpURLConnection httpURLConnection;
        String str = this.f9615a;
        int i3 = 0;
        Object obj;
        do {
            String stringBuilder;
            String str2 = "ProxyCache";
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Open connection ");
            if (i > 0) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(" with offset ");
                stringBuilder3.append(i);
                stringBuilder = stringBuilder3.toString();
            } else {
                stringBuilder = "";
            }
            stringBuilder2.append(stringBuilder);
            stringBuilder2.append(" to ");
            stringBuilder2.append(str);
            Log.d(str2, stringBuilder2.toString());
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (i > 0) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("bytes=");
                stringBuilder3.append(i);
                stringBuilder3.append("-");
                httpURLConnection.setRequestProperty("Range", stringBuilder3.toString());
            }
            if (i2 > 0) {
                httpURLConnection.setConnectTimeout(i2);
                httpURLConnection.setReadTimeout(i2);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (!(responseCode == 301 || responseCode == 302)) {
                if (responseCode != 303) {
                    obj = null;
                    if (obj != null) {
                        str = httpURLConnection.getHeaderField("Location");
                        i3++;
                        httpURLConnection.disconnect();
                    }
                    if (i3 <= 5) {
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append("Too many redirects: ");
                        stringBuilder4.append(i3);
                        throw new C1477l(stringBuilder4.toString());
                    }
                }
            }
            obj = 1;
            if (obj != null) {
                str = httpURLConnection.getHeaderField("Location");
                i3++;
                httpURLConnection.disconnect();
            }
            if (i3 <= 5) {
                StringBuilder stringBuilder42 = new StringBuilder();
                stringBuilder42.append("Too many redirects: ");
                stringBuilder42.append(i3);
                throw new C1477l(stringBuilder42.toString());
            }
        } while (obj != null);
        return httpURLConnection;
    }

    /* renamed from: d */
    private void m11758d() {
        HttpURLConnection a;
        Closeable inputStream;
        Throwable th;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Read content info from ");
        stringBuilder2.append(this.f9615a);
        Log.d("ProxyCache", stringBuilder2.toString());
        try {
            a = m11757a(0, 10000);
            try {
                this.f9618d = a.getContentLength();
                this.f9619e = a.getContentType();
                inputStream = a.getInputStream();
            } catch (Throwable e) {
                th = e;
                inputStream = null;
                try {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Error fetching info from ");
                    stringBuilder.append(this.f9615a);
                    Log.e("ProxyCache", stringBuilder.toString(), th);
                    C1478m.m5229a(inputStream);
                    if (a == null) {
                        return;
                    }
                    a.disconnect();
                } catch (Throwable th2) {
                    th = th2;
                    C1478m.m5229a(inputStream);
                    if (a != null) {
                        a.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable e2) {
                th = e2;
                inputStream = null;
                C1478m.m5229a(inputStream);
                if (a != null) {
                    a.disconnect();
                }
                throw th;
            }
            try {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Content info for `");
                stringBuilder3.append(this.f9615a);
                stringBuilder3.append("`: mime: ");
                stringBuilder3.append(this.f9619e);
                stringBuilder3.append(", content-length: ");
                stringBuilder3.append(this.f9618d);
                Log.i("ProxyCache", stringBuilder3.toString());
                C1478m.m5229a(inputStream);
                if (a != null) {
                    a.disconnect();
                }
            } catch (IOException e3) {
                th = e3;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Error fetching info from ");
                stringBuilder.append(this.f9615a);
                Log.e("ProxyCache", stringBuilder.toString(), th);
                C1478m.m5229a(inputStream);
                if (a == null) {
                    return;
                }
                a.disconnect();
            }
        } catch (Throwable e4) {
            inputStream = null;
            th = e4;
            a = inputStream;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Error fetching info from ");
            stringBuilder.append(this.f9615a);
            Log.e("ProxyCache", stringBuilder.toString(), th);
            C1478m.m5229a(inputStream);
            if (a == null) {
                return;
            }
            a.disconnect();
        } catch (Throwable e42) {
            inputStream = null;
            th = e42;
            a = inputStream;
            C1478m.m5229a(inputStream);
            if (a != null) {
                a.disconnect();
            }
            throw th;
        }
    }

    /* renamed from: a */
    public synchronized int mo992a() {
        if (this.f9618d == LinearLayoutManager.INVALID_OFFSET) {
            m11758d();
        }
        return this.f9618d;
    }

    /* renamed from: a */
    public int mo993a(byte[] bArr) {
        StringBuilder stringBuilder;
        if (this.f9617c != null) {
            try {
                return this.f9617c.read(bArr, 0, bArr.length);
            } catch (Throwable e) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Reading source ");
                stringBuilder.append(this.f9615a);
                stringBuilder.append(" is interrupted");
                throw new C3607i(stringBuilder.toString(), e);
            } catch (Throwable e2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Error reading data from ");
                stringBuilder.append(this.f9615a);
                throw new C1477l(stringBuilder.toString(), e2);
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Error reading data from ");
        stringBuilder2.append(this.f9615a);
        stringBuilder2.append(": connection is absent!");
        throw new C1477l(stringBuilder2.toString());
    }

    /* renamed from: a */
    public void mo994a(int i) {
        try {
            this.f9616b = m11757a(i, -1);
            this.f9619e = this.f9616b.getContentType();
            this.f9617c = new BufferedInputStream(this.f9616b.getInputStream(), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            this.f9618d = m11756a(this.f9616b, i, this.f9616b.getResponseCode());
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error opening connection for ");
            stringBuilder.append(this.f9615a);
            stringBuilder.append(" with offset ");
            stringBuilder.append(i);
            throw new C1477l(stringBuilder.toString(), e);
        }
    }

    /* renamed from: b */
    public void mo995b() {
        if (this.f9616b != null) {
            try {
                this.f9616b.disconnect();
            } catch (Throwable e) {
                throw new C1477l("Error disconnecting HttpUrlConnection", e);
            }
        }
    }

    /* renamed from: c */
    public synchronized String m11763c() {
        if (TextUtils.isEmpty(this.f9619e)) {
            m11758d();
        }
        return this.f9619e;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HttpUrlSource{url='");
        stringBuilder.append(this.f9615a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
