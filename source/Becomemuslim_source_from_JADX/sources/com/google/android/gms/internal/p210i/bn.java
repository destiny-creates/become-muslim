package com.google.android.gms.internal.p210i;

import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.react.views.textinput.ReactEditTextInputConnectionWrapper;
import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.gms.common.internal.C2872v;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.zip.GZIPOutputStream;

/* renamed from: com.google.android.gms.internal.i.bn */
final class bn extends C6797o {
    /* renamed from: c */
    private static final byte[] f28806c = ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE.getBytes();
    /* renamed from: a */
    private final String f28807a;
    /* renamed from: b */
    private final by f28808b;

    bn(C5008q c5008q) {
        super(c5008q);
        String str = C5007p.f16813a;
        String str2 = VERSION.RELEASE;
        String a = bz.m20370a(Locale.getDefault());
        String str3 = Build.MODEL;
        String str4 = Build.ID;
        this.f28807a = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{"GoogleAnalytics", str, str2, a, str3, str4});
        this.f28808b = new by(c5008q.m21061c());
    }

    /* renamed from: a */
    protected final void mo6145a() {
        m21026a("Network initialized. User agent", this.f28807a);
    }

    /* renamed from: b */
    public final boolean m37769b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:56)
	at jadx.core.ProcessClass.process(ProcessClass.java:39)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r2 = this;
        com.google.android.gms.analytics.C2721s.d();
        r2.m31800z();
        r0 = r2.m21044k();
        r1 = "connectivity";
        r0 = r0.getSystemService(r1);
        r0 = (android.net.ConnectivityManager) r0;
        r0 = r0.getActiveNetworkInfo();	 Catch:{ SecurityException -> 0x0017 }
        goto L_0x0018;
    L_0x0017:
        r0 = 0;
    L_0x0018:
        if (r0 == 0) goto L_0x0023;
    L_0x001a:
        r0 = r0.isConnected();
        if (r0 != 0) goto L_0x0021;
    L_0x0020:
        goto L_0x0023;
    L_0x0021:
        r0 = 1;
        return r0;
    L_0x0023:
        r0 = "No network connectivity";
        r2.m21036e(r0);
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.bn.b():boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final java.util.List<java.lang.Long> m37767a(java.util.List<com.google.android.gms.internal.p210i.bg> r9) {
        /*
        r8 = this;
        com.google.android.gms.analytics.C2721s.d();
        r8.m31800z();
        com.google.android.gms.common.internal.C2872v.a(r9);
        r0 = r8.m21046m();
        r0 = r0.m20298k();
        r0 = r0.isEmpty();
        r1 = 0;
        r2 = 1;
        if (r0 != 0) goto L_0x0059;
    L_0x0019:
        r0 = r8.f28808b;
        r3 = com.google.android.gms.internal.p210i.ba.f16403v;
        r3 = r3.m20315a();
        r3 = (java.lang.Integer) r3;
        r3 = r3.intValue();
        r3 = (long) r3;
        r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r3 = r3 * r5;
        r0 = r0.m20366a(r3);
        if (r0 != 0) goto L_0x0033;
    L_0x0032:
        goto L_0x0059;
    L_0x0033:
        r0 = com.google.android.gms.internal.p210i.ba.f16397p;
        r0 = r0.m20315a();
        r0 = (java.lang.String) r0;
        r0 = com.google.android.gms.internal.p210i.ai.m20278a(r0);
        r3 = com.google.android.gms.internal.p210i.ai.NONE;
        if (r0 == r3) goto L_0x0045;
    L_0x0043:
        r0 = 1;
        goto L_0x0046;
    L_0x0045:
        r0 = 0;
    L_0x0046:
        r3 = com.google.android.gms.internal.p210i.ba.f16398q;
        r3 = r3.m20315a();
        r3 = (java.lang.String) r3;
        r3 = com.google.android.gms.internal.p210i.ao.m20281a(r3);
        r4 = com.google.android.gms.internal.p210i.ao.GZIP;
        if (r3 != r4) goto L_0x005a;
    L_0x0056:
        r3 = r0;
        r0 = 1;
        goto L_0x005c;
    L_0x0059:
        r0 = 0;
    L_0x005a:
        r3 = r0;
        r0 = 0;
    L_0x005c:
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r3 == 0) goto L_0x0105;
    L_0x0060:
        r1 = r9.isEmpty();
        r1 = r1 ^ r2;
        com.google.android.gms.common.internal.C2872v.b(r1);
        r1 = "Uploading batched hits. compression, count";
        r2 = java.lang.Boolean.valueOf(r0);
        r3 = r9.size();
        r3 = java.lang.Integer.valueOf(r3);
        r8.m21027a(r1, r2, r3);
        r1 = new com.google.android.gms.internal.i.bo;
        r1.<init>(r8);
        r2 = new java.util.ArrayList;
        r2.<init>();
        r9 = r9.iterator();
    L_0x0087:
        r3 = r9.hasNext();
        if (r3 == 0) goto L_0x00a5;
    L_0x008d:
        r3 = r9.next();
        r3 = (com.google.android.gms.internal.p210i.bg) r3;
        r5 = r1.m20343a(r3);
        if (r5 == 0) goto L_0x00a5;
    L_0x0099:
        r5 = r3.m20322c();
        r3 = java.lang.Long.valueOf(r5);
        r2.add(r3);
        goto L_0x0087;
    L_0x00a5:
        r9 = r1.m20342a();
        if (r9 != 0) goto L_0x00ac;
    L_0x00ab:
        return r2;
    L_0x00ac:
        r9 = r8.m37765d();
        if (r9 != 0) goto L_0x00b8;
    L_0x00b2:
        r9 = "Failed to build batching endpoint url";
        r8.m21042i(r9);
        goto L_0x0100;
    L_0x00b8:
        if (r0 == 0) goto L_0x00c3;
    L_0x00ba:
        r0 = r1.m20344b();
        r9 = r8.m37762b(r9, r0);
        goto L_0x00cb;
    L_0x00c3:
        r0 = r1.m20344b();
        r9 = r8.m37757a(r9, r0);
    L_0x00cb:
        if (r4 != r9) goto L_0x00db;
    L_0x00cd:
        r9 = "Batched upload completed. Hits batched";
        r0 = r1.m20342a();
        r0 = java.lang.Integer.valueOf(r0);
        r8.m21026a(r9, r0);
        return r2;
    L_0x00db:
        r0 = "Network error uploading hits. status code";
        r1 = java.lang.Integer.valueOf(r9);
        r8.m21026a(r0, r1);
        r0 = r8.m21046m();
        r0 = r0.m20298k();
        r9 = java.lang.Integer.valueOf(r9);
        r9 = r0.contains(r9);
        if (r9 == 0) goto L_0x0100;
    L_0x00f6:
        r9 = "Server instructed the client to stop batching";
        r8.m21040h(r9);
        r9 = r8.f28808b;
        r9.m20365a();
    L_0x0100:
        r9 = java.util.Collections.emptyList();
        return r9;
    L_0x0105:
        r0 = new java.util.ArrayList;
        r3 = r9.size();
        r0.<init>(r3);
        r9 = r9.iterator();
    L_0x0112:
        r3 = r9.hasNext();
        if (r3 == 0) goto L_0x01b4;
    L_0x0118:
        r3 = r9.next();
        r3 = (com.google.android.gms.internal.p210i.bg) r3;
        com.google.android.gms.common.internal.C2872v.a(r3);
        r5 = r3.m20325f();
        r5 = r5 ^ r2;
        r5 = r8.m37766a(r3, r5);
        if (r5 != 0) goto L_0x0137;
    L_0x012c:
        r5 = r8.m21045l();
        r6 = "Error formatting hit for upload";
        r5.m37754a(r3, r6);
    L_0x0135:
        r5 = 1;
        goto L_0x019d;
    L_0x0137:
        r6 = r5.length();
        r7 = com.google.android.gms.internal.p210i.ba.f16396o;
        r7 = r7.m20315a();
        r7 = (java.lang.Integer) r7;
        r7 = r7.intValue();
        if (r6 > r7) goto L_0x015c;
    L_0x0149:
        r5 = r8.m37759a(r3, r5);
        if (r5 != 0) goto L_0x0155;
    L_0x014f:
        r5 = "Failed to build collect GET endpoint url";
        r8.m21042i(r5);
        goto L_0x019c;
    L_0x0155:
        r5 = r8.m37756a(r5);
        if (r5 != r4) goto L_0x019c;
    L_0x015b:
        goto L_0x0135;
    L_0x015c:
        r5 = r8.m37766a(r3, r1);
        if (r5 != 0) goto L_0x016c;
    L_0x0162:
        r5 = r8.m21045l();
        r6 = "Error formatting hit for POST upload";
        r5.m37754a(r3, r6);
        goto L_0x0135;
    L_0x016c:
        r5 = r5.getBytes();
        r6 = r5.length;
        r7 = com.google.android.gms.internal.p210i.ba.f16400s;
        r7 = r7.m20315a();
        r7 = (java.lang.Integer) r7;
        r7 = r7.intValue();
        if (r6 <= r7) goto L_0x0189;
    L_0x017f:
        r5 = r8.m21045l();
        r6 = "Hit payload exceeds size limit";
        r5.m37754a(r3, r6);
        goto L_0x0135;
    L_0x0189:
        r6 = r8.m37758a(r3);
        if (r6 != 0) goto L_0x0195;
    L_0x018f:
        r5 = "Failed to build collect POST endpoint url";
        r8.m21042i(r5);
        goto L_0x019c;
    L_0x0195:
        r5 = r8.m37757a(r6, r5);
        if (r5 != r4) goto L_0x019c;
    L_0x019b:
        goto L_0x015b;
    L_0x019c:
        r5 = 0;
    L_0x019d:
        if (r5 == 0) goto L_0x01b4;
    L_0x019f:
        r5 = r3.m20322c();
        r3 = java.lang.Long.valueOf(r5);
        r0.add(r3);
        r3 = r0.size();
        r5 = com.google.android.gms.internal.p210i.as.m20291f();
        if (r3 < r5) goto L_0x0112;
    L_0x01b4:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.i.bn.a(java.util.List):java.util.List<java.lang.Long>");
    }

    /* renamed from: a */
    private final int m37756a(URL url) {
        Object e;
        Throwable th;
        C2872v.a(url);
        m21029b("GET request", url);
        try {
            url = m37763b(url);
            try {
                url.connect();
                m37761a((HttpURLConnection) url);
                int responseCode = url.getResponseCode();
                if (responseCode == HttpStatus.HTTP_OK) {
                    m21049p().m37946h();
                }
                m21029b("GET status", Integer.valueOf(responseCode));
                if (url != null) {
                    url.disconnect();
                }
                return responseCode;
            } catch (IOException e2) {
                e = e2;
                try {
                    m21034d("Network GET connection error", e);
                    if (url != null) {
                        url.disconnect();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (url != null) {
                        url.disconnect();
                    }
                    throw th;
                }
            }
        } catch (URL url2) {
            e = url2;
            url2 = null;
            m21034d("Network GET connection error", e);
            if (url2 != null) {
                url2.disconnect();
            }
            return null;
        } catch (URL url22) {
            th = url22;
            url22 = null;
            if (url22 != null) {
                url22.disconnect();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private final int m37757a(URL url, byte[] bArr) {
        OutputStream outputStream;
        C2872v.a(url);
        C2872v.a(bArr);
        m21030b("POST bytes, url", Integer.valueOf(bArr.length), url);
        if (C5006n.m21025x()) {
            m21026a("Post payload\n", new String(bArr));
        }
        OutputStream outputStream2 = null;
        try {
            m21044k().getPackageName();
            url = m37763b(url);
            try {
                url.setDoOutput(true);
                url.setFixedLengthStreamingMode(bArr.length);
                url.connect();
                outputStream = url.getOutputStream();
            } catch (IOException e) {
                bArr = e;
                try {
                    m21034d("Network POST connection error", bArr);
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (byte[] bArr2) {
                            m21037e("Error closing http post connection output stream", bArr2);
                        }
                    }
                    if (url != null) {
                        url.disconnect();
                    }
                    return null;
                } catch (Throwable th) {
                    bArr2 = th;
                    if (outputStream2 != null) {
                        try {
                            outputStream2.close();
                        } catch (IOException e2) {
                            m21037e("Error closing http post connection output stream", e2);
                        }
                    }
                    if (url != null) {
                        url.disconnect();
                    }
                    throw bArr2;
                }
            }
            try {
                outputStream.write(bArr2);
                m37761a((HttpURLConnection) url);
                bArr2 = url.getResponseCode();
                if (bArr2 == 200) {
                    m21049p().m37946h();
                }
                m21029b("POST status", Integer.valueOf(bArr2));
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e22) {
                        m21037e("Error closing http post connection output stream", e22);
                    }
                }
                if (url != null) {
                    url.disconnect();
                }
                return bArr2;
            } catch (IOException e3) {
                bArr2 = e3;
                outputStream2 = outputStream;
                m21034d("Network POST connection error", bArr2);
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                if (url != null) {
                    url.disconnect();
                }
                return null;
            } catch (Throwable th2) {
                bArr2 = th2;
                outputStream2 = outputStream;
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                if (url != null) {
                    url.disconnect();
                }
                throw bArr2;
            }
        } catch (IOException e4) {
            bArr2 = e4;
            url = null;
            m21034d("Network POST connection error", bArr2);
            if (outputStream2 != null) {
                outputStream2.close();
            }
            if (url != null) {
                url.disconnect();
            }
            return null;
        } catch (Throwable th3) {
            bArr2 = th3;
            url = null;
            if (outputStream2 != null) {
                outputStream2.close();
            }
            if (url != null) {
                url.disconnect();
            }
            throw bArr2;
        }
    }

    /* renamed from: b */
    private final int m37762b(URL url, byte[] bArr) {
        byte[] bArr2;
        C2872v.a(url);
        C2872v.a(bArr);
        OutputStream outputStream = null;
        try {
            m21044k().getPackageName();
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            m21028a("POST compressed size, ratio %, url", Integer.valueOf(toByteArray.length), Long.valueOf((((long) toByteArray.length) * 100) / ((long) bArr.length)), url);
            if (toByteArray.length > bArr.length) {
                m21033c("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(toByteArray.length), Integer.valueOf(bArr.length));
            }
            if (C5006n.m21025x()) {
                String str = "Post payload";
                String str2 = ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE;
                bArr = String.valueOf(new String(bArr));
                m21026a(str, bArr.length() != 0 ? str2.concat(bArr) : new String(str2));
            }
            HttpURLConnection b = m37763b(url);
            try {
                b.setDoOutput(1);
                b.addRequestProperty("Content-Encoding", "gzip");
                b.setFixedLengthStreamingMode(toByteArray.length);
                b.connect();
                bArr = b.getOutputStream();
                try {
                    bArr.write(toByteArray);
                    bArr.close();
                    m37761a(b);
                    bArr = b.getResponseCode();
                    if (bArr == 200) {
                        m21049p().m37946h();
                    }
                    m21029b("POST status", Integer.valueOf(bArr));
                    if (b != null) {
                        b.disconnect();
                    }
                    return bArr;
                } catch (IOException e) {
                    bArr2 = bArr;
                    bArr = b;
                    url = e;
                    outputStream = bArr2;
                    try {
                        m21034d("Network compressed POST connection error", url);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (URL url2) {
                                m21037e("Error closing http compressed post connection output stream", url2);
                            }
                        }
                        if (bArr != null) {
                            bArr.disconnect();
                        }
                        return null;
                    } catch (Throwable th) {
                        url2 = th;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e2) {
                                m21037e("Error closing http compressed post connection output stream", e2);
                            }
                        }
                        if (bArr != null) {
                            bArr.disconnect();
                        }
                        throw url2;
                    }
                } catch (Throwable th2) {
                    bArr2 = bArr;
                    bArr = b;
                    url2 = th2;
                    outputStream = bArr2;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (bArr != null) {
                        bArr.disconnect();
                    }
                    throw url2;
                }
            } catch (byte[] bArr3) {
                bArr2 = bArr3;
                bArr3 = b;
                url2 = bArr2;
                m21034d("Network compressed POST connection error", url2);
                if (outputStream != null) {
                    outputStream.close();
                }
                if (bArr3 != null) {
                    bArr3.disconnect();
                }
                return null;
            } catch (byte[] bArr32) {
                bArr2 = bArr32;
                bArr32 = b;
                url2 = bArr2;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (bArr32 != null) {
                    bArr32.disconnect();
                }
                throw url2;
            }
        } catch (IOException e3) {
            url2 = e3;
            bArr32 = null;
            m21034d("Network compressed POST connection error", url2);
            if (outputStream != null) {
                outputStream.close();
            }
            if (bArr32 != null) {
                bArr32.disconnect();
            }
            return null;
        } catch (Throwable th3) {
            url2 = th3;
            bArr32 = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (bArr32 != null) {
                bArr32.disconnect();
            }
            throw url2;
        }
    }

    /* renamed from: a */
    private final void m37761a(HttpURLConnection httpURLConnection) {
        Throwable th;
        try {
            httpURLConnection = httpURLConnection.getInputStream();
            try {
                do {
                } while (httpURLConnection.read(new byte[1024]) > 0);
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.close();
                    } catch (HttpURLConnection httpURLConnection2) {
                        m21037e("Error closing http connection input stream", httpURLConnection2);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (httpURLConnection2 != null) {
                    try {
                        httpURLConnection2.close();
                    } catch (HttpURLConnection httpURLConnection22) {
                        m21037e("Error closing http connection input stream", httpURLConnection22);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection22 = null;
            if (httpURLConnection22 != null) {
                httpURLConnection22.close();
            }
            throw th;
        }
    }

    /* renamed from: b */
    private final HttpURLConnection m37763b(URL url) {
        url = url.openConnection();
        if (url instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(((Integer) ba.f16404w.m20315a()).intValue());
            httpURLConnection.setReadTimeout(((Integer) ba.f16405x.m20315a()).intValue());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("User-Agent", this.f28807a);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain http connection");
    }

    /* renamed from: a */
    private final URL m37758a(bg bgVar) {
        String valueOf;
        if (bgVar.m20325f() != null) {
            bgVar = String.valueOf(as.m20293h());
            valueOf = String.valueOf(as.m20295j());
            if (valueOf.length() != 0) {
                bgVar = bgVar.concat(valueOf);
                return new URL(bgVar);
            }
            valueOf = new String(bgVar);
        } else {
            bgVar = String.valueOf(as.m20294i());
            valueOf = String.valueOf(as.m20295j());
            if (valueOf.length() != 0) {
                bgVar = bgVar.concat(valueOf);
                return new URL(bgVar);
            }
            valueOf = new String(bgVar);
        }
        bgVar = valueOf;
        try {
            return new URL(bgVar);
        } catch (bg bgVar2) {
            m21037e("Error trying to parse the hardcoded host url", bgVar2);
            return null;
        }
    }

    /* renamed from: a */
    private final URL m37759a(bg bgVar, String str) {
        String j;
        StringBuilder stringBuilder;
        if (bgVar.m20325f() != null) {
            bgVar = as.m20293h();
            j = as.m20295j();
            stringBuilder = new StringBuilder(((String.valueOf(bgVar).length() + 1) + String.valueOf(j).length()) + String.valueOf(str).length());
            stringBuilder.append(bgVar);
            stringBuilder.append(j);
            stringBuilder.append("?");
            stringBuilder.append(str);
            bgVar = stringBuilder.toString();
        } else {
            bgVar = as.m20294i();
            j = as.m20295j();
            stringBuilder = new StringBuilder(((String.valueOf(bgVar).length() + 1) + String.valueOf(j).length()) + String.valueOf(str).length());
            stringBuilder.append(bgVar);
            stringBuilder.append(j);
            stringBuilder.append("?");
            stringBuilder.append(str);
            bgVar = stringBuilder.toString();
        }
        try {
            return new URL(bgVar);
        } catch (bg bgVar2) {
            m21037e("Error trying to parse the hardcoded host url", bgVar2);
            return null;
        }
    }

    /* renamed from: d */
    private final URL m37765d() {
        String valueOf = String.valueOf(as.m20293h());
        String valueOf2 = String.valueOf((String) ba.f16395n.m20315a());
        try {
            return new URL(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        } catch (MalformedURLException e) {
            m21037e("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    /* renamed from: a */
    final String m37766a(bg bgVar, boolean z) {
        C2872v.a(bgVar);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            for (Entry entry : bgVar.m20321b().entrySet()) {
                String str = (String) entry.getKey();
                if (!("ht".equals(str) || "qt".equals(str) || "AppUID".equals(str) || "z".equals(str) || "_gmsv".equals(str))) {
                    bn.m37760a(stringBuilder, str, (String) entry.getValue());
                }
            }
            bn.m37760a(stringBuilder, "ht", String.valueOf(bgVar.m20323d()));
            bn.m37760a(stringBuilder, "qt", String.valueOf(m21043j().a() - bgVar.m20323d()));
            if (z) {
                long g = bgVar.m20326g();
                if (g != 0) {
                    bgVar = String.valueOf(g);
                } else {
                    bgVar = String.valueOf(bgVar.m20322c());
                }
                bn.m37760a(stringBuilder, "z", bgVar);
            }
            return stringBuilder.toString();
        } catch (bg bgVar2) {
            m21037e("Failed to encode name or value", bgVar2);
            return null;
        }
    }

    /* renamed from: a */
    private static void m37760a(StringBuilder stringBuilder, String str, String str2) {
        if (stringBuilder.length() != 0) {
            stringBuilder.append('&');
        }
        stringBuilder.append(URLEncoder.encode(str, Utf8Charset.NAME));
        stringBuilder.append('=');
        stringBuilder.append(URLEncoder.encode(str2, Utf8Charset.NAME));
    }
}
