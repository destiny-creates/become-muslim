package com.facebook.ads.internal.p101p.p102a;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.p.a.n */
public class C1450n {
    /* renamed from: a */
    private int f4306a;
    /* renamed from: b */
    private String f4307b;
    /* renamed from: c */
    private Map<String, List<String>> f4308c;
    /* renamed from: d */
    private byte[] f4309d;

    public C1450n(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            this.f4306a = httpURLConnection.getResponseCode();
            this.f4307b = httpURLConnection.getURL().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f4308c = httpURLConnection.getHeaderFields();
        this.f4309d = bArr;
    }

    /* renamed from: a */
    public int m5133a() {
        return this.f4306a;
    }

    /* renamed from: b */
    public String m5134b() {
        return this.f4307b;
    }

    /* renamed from: c */
    public Map<String, List<String>> m5135c() {
        return this.f4308c;
    }

    /* renamed from: d */
    public byte[] m5136d() {
        return this.f4309d;
    }

    /* renamed from: e */
    public String m5137e() {
        return this.f4309d != null ? new String(this.f4309d) : null;
    }
}
