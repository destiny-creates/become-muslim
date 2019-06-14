package com.google.android.gms.internal.ads;

import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.server.http.HttpHeaders;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.SSLSocketFactory;

public final class rt extends hj {
    /* renamed from: a */
    private final su f28753a;
    /* renamed from: b */
    private final SSLSocketFactory f28754b;

    public rt() {
        this(null);
    }

    private rt(su suVar) {
        this(null, null);
    }

    private rt(su suVar, SSLSocketFactory sSLSocketFactory) {
        this.f28753a = null;
        this.f28754b = null;
    }

    /* renamed from: a */
    private static java.io.InputStream m37651a(java.net.HttpURLConnection r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r1.getInputStream();	 Catch:{ IOException -> 0x0005 }
        goto L_0x0009;
    L_0x0005:
        r0 = r1.getErrorStream();
    L_0x0009:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.rt.a(java.net.HttpURLConnection):java.io.InputStream");
    }

    /* renamed from: a */
    private static List<aqg> m37652a(Map<String, List<String>> map) {
        List<aqg> arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String aqg : (List) entry.getValue()) {
                    arrayList.add(new aqg((String) entry.getKey(), aqg));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m37653a(HttpURLConnection httpURLConnection, awi<?> awi) {
        byte[] a = awi.mo6108a();
        if (a != null) {
            httpURLConnection.setDoOutput(true);
            String str = HttpHeaders.CONTENT_TYPE;
            String str2 = "application/x-www-form-urlencoded; charset=";
            String valueOf = String.valueOf(Utf8Charset.NAME);
            httpURLConnection.addRequestProperty(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(a);
            dataOutputStream.close();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final com.google.android.gms.internal.ads.pr mo6095a(com.google.android.gms.internal.ads.awi<?> r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
        r6 = this;
        r0 = r7.m19065e();
        r1 = new java.util.HashMap;
        r1.<init>();
        r2 = r7.mo6109b();
        r1.putAll(r2);
        r1.putAll(r8);
        r8 = r6.f28753a;
        if (r8 == 0) goto L_0x003c;
    L_0x0017:
        r8 = r6.f28753a;
        r8 = r8.m20103a(r0);
        if (r8 != 0) goto L_0x003d;
    L_0x001f:
        r7 = new java.io.IOException;
        r8 = "URL blocked by rewriter: ";
        r0 = java.lang.String.valueOf(r0);
        r1 = r0.length();
        if (r1 == 0) goto L_0x0032;
    L_0x002d:
        r8 = r8.concat(r0);
        goto L_0x0038;
    L_0x0032:
        r0 = new java.lang.String;
        r0.<init>(r8);
        r8 = r0;
    L_0x0038:
        r7.<init>(r8);
        throw r7;
    L_0x003c:
        r8 = r0;
    L_0x003d:
        r0 = new java.net.URL;
        r0.<init>(r8);
        r8 = r0.openConnection();
        r8 = (java.net.HttpURLConnection) r8;
        r2 = java.net.HttpURLConnection.getFollowRedirects();
        r8.setInstanceFollowRedirects(r2);
        r2 = r7.m19069i();
        r8.setConnectTimeout(r2);
        r8.setReadTimeout(r2);
        r2 = 0;
        r8.setUseCaches(r2);
        r3 = 1;
        r8.setDoInput(r3);
        r4 = "https";
        r0 = r0.getProtocol();
        r4.equals(r0);
        r0 = r1.keySet();
        r0 = r0.iterator();
    L_0x0072:
        r4 = r0.hasNext();
        if (r4 == 0) goto L_0x0088;
    L_0x0078:
        r4 = r0.next();
        r4 = (java.lang.String) r4;
        r5 = r1.get(r4);
        r5 = (java.lang.String) r5;
        r8.addRequestProperty(r4, r5);
        goto L_0x0072;
    L_0x0088:
        r0 = r7.m19062c();
        switch(r0) {
            case -1: goto L_0x00b7;
            case 0: goto L_0x00b2;
            case 1: goto L_0x00a9;
            case 2: goto L_0x00a6;
            case 3: goto L_0x00a3;
            case 4: goto L_0x00a0;
            case 5: goto L_0x009d;
            case 6: goto L_0x009a;
            case 7: goto L_0x0097;
            default: goto L_0x008f;
        };
    L_0x008f:
        r7 = new java.lang.IllegalStateException;
        r8 = "Unknown method type.";
        r7.<init>(r8);
        throw r7;
    L_0x0097:
        r0 = "PATCH";
        goto L_0x00ab;
    L_0x009a:
        r0 = "TRACE";
        goto L_0x00b4;
    L_0x009d:
        r0 = "OPTIONS";
        goto L_0x00b4;
    L_0x00a0:
        r0 = "HEAD";
        goto L_0x00b4;
    L_0x00a3:
        r0 = "DELETE";
        goto L_0x00b4;
    L_0x00a6:
        r0 = "PUT";
        goto L_0x00ab;
    L_0x00a9:
        r0 = "POST";
    L_0x00ab:
        r8.setRequestMethod(r0);
        m37653a(r8, r7);
        goto L_0x00b7;
    L_0x00b2:
        r0 = "GET";
    L_0x00b4:
        r8.setRequestMethod(r0);
    L_0x00b7:
        r0 = r8.getResponseCode();
        r1 = -1;
        if (r0 == r1) goto L_0x00fc;
    L_0x00be:
        r7 = r7.m19062c();
        r1 = 4;
        if (r7 == r1) goto L_0x00d6;
    L_0x00c5:
        r7 = 100;
        if (r7 > r0) goto L_0x00cd;
    L_0x00c9:
        r7 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 < r7) goto L_0x00d6;
    L_0x00cd:
        r7 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
        if (r0 == r7) goto L_0x00d6;
    L_0x00d1:
        r7 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r0 == r7) goto L_0x00d6;
    L_0x00d5:
        r2 = 1;
    L_0x00d6:
        if (r2 != 0) goto L_0x00e6;
    L_0x00d8:
        r7 = new com.google.android.gms.internal.ads.pr;
        r8 = r8.getHeaderFields();
        r8 = m37652a(r8);
        r7.<init>(r0, r8);
        return r7;
    L_0x00e6:
        r7 = new com.google.android.gms.internal.ads.pr;
        r1 = r8.getHeaderFields();
        r1 = m37652a(r1);
        r2 = r8.getContentLength();
        r8 = m37651a(r8);
        r7.<init>(r0, r1, r2, r8);
        return r7;
    L_0x00fc:
        r7 = new java.io.IOException;
        r8 = "Could not retrieve response code from HttpUrlConnection.";
        r7.<init>(r8);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.rt.a(com.google.android.gms.internal.ads.awi, java.util.Map):com.google.android.gms.internal.ads.pr");
    }
}
