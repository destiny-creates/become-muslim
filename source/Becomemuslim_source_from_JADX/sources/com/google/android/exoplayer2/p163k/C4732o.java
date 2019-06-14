package com.google.android.exoplayer2.p163k;

import android.net.Uri;
import android.util.Log;
import com.facebook.common.util.UriUtil;
import com.facebook.stetho.server.http.HttpStatus;
import com.google.android.exoplayer2.p163k.C4250r.C2504c;
import com.google.android.exoplayer2.p163k.C4250r.C2505f;
import com.google.android.exoplayer2.p163k.C4250r.C4248d;
import com.google.android.exoplayer2.p163k.C4250r.C4249e;
import com.google.android.exoplayer2.p164l.C2516a;
import com.google.android.exoplayer2.p164l.C2531n;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/* compiled from: DefaultHttpDataSource */
/* renamed from: com.google.android.exoplayer2.k.o */
public class C4732o implements C4250r {
    /* renamed from: b */
    private static final Pattern f12923b = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    /* renamed from: c */
    private static final AtomicReference<byte[]> f12924c = new AtomicReference();
    /* renamed from: d */
    private final boolean f12925d;
    /* renamed from: e */
    private final int f12926e;
    /* renamed from: f */
    private final int f12927f;
    /* renamed from: g */
    private final String f12928g;
    /* renamed from: h */
    private final C2531n<String> f12929h;
    /* renamed from: i */
    private final C2505f f12930i;
    /* renamed from: j */
    private final C2505f f12931j = new C2505f();
    /* renamed from: k */
    private final C2514v<? super C4732o> f12932k;
    /* renamed from: l */
    private C2501j f12933l;
    /* renamed from: m */
    private HttpURLConnection f12934m;
    /* renamed from: n */
    private InputStream f12935n;
    /* renamed from: o */
    private boolean f12936o;
    /* renamed from: p */
    private long f12937p;
    /* renamed from: q */
    private long f12938q;
    /* renamed from: r */
    private long f12939r;
    /* renamed from: s */
    private long f12940s;

    public C4732o(String str, C2531n<String> c2531n, C2514v<? super C4732o> c2514v, int i, int i2, boolean z, C2505f c2505f) {
        this.f12928g = C2516a.m7016a(str);
        this.f12929h = c2531n;
        this.f12932k = c2514v;
        this.f12926e = i;
        this.f12927f = i2;
        this.f12925d = z;
        this.f12930i = c2505f;
    }

    /* renamed from: a */
    public Uri mo2269a() {
        return this.f12934m == null ? null : Uri.parse(this.f12934m.getURL().toString());
    }

    /* renamed from: a */
    public long mo2268a(C2501j c2501j) {
        StringBuilder stringBuilder;
        this.f12933l = c2501j;
        long j = 0;
        this.f12940s = 0;
        this.f12939r = 0;
        try {
            this.f12934m = m16368b(c2501j);
            try {
                int responseCode = this.f12934m.getResponseCode();
                if (responseCode >= HttpStatus.HTTP_OK) {
                    if (responseCode <= 299) {
                        String contentType = this.f12934m.getContentType();
                        if (this.f12929h != null) {
                            if (!this.f12929h.mo2321a(contentType)) {
                                m16370e();
                                throw new C4248d(contentType, c2501j);
                            }
                        }
                        if (responseCode == HttpStatus.HTTP_OK && c2501j.f6352d != 0) {
                            j = c2501j.f6352d;
                        }
                        this.f12937p = j;
                        if (c2501j.m6958a(1)) {
                            this.f12938q = c2501j.f6353e;
                        } else {
                            long j2 = -1;
                            if (c2501j.f6353e != -1) {
                                this.f12938q = c2501j.f6353e;
                            } else {
                                j = C4732o.m16363a(this.f12934m);
                                if (j != -1) {
                                    j2 = j - this.f12937p;
                                }
                                this.f12938q = j2;
                            }
                        }
                        try {
                            this.f12935n = this.f12934m.getInputStream();
                            this.f12936o = true;
                            if (this.f12932k != null) {
                                this.f12932k.mo2319a((Object) this, c2501j);
                            }
                            return this.f12938q;
                        } catch (IOException e) {
                            m16370e();
                            throw new C2504c(e, c2501j, 1);
                        }
                    }
                }
                Map headerFields = this.f12934m.getHeaderFields();
                m16370e();
                C4249e c4249e = new C4249e(responseCode, headerFields, c2501j);
                if (responseCode == 416) {
                    c4249e.initCause(new C2499h(0));
                }
                throw c4249e;
            } catch (IOException e2) {
                m16370e();
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to connect to ");
                stringBuilder.append(c2501j.f6349a.toString());
                throw new C2504c(stringBuilder.toString(), e2, c2501j, 1);
            }
        } catch (IOException e22) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to connect to ");
            stringBuilder.append(c2501j.f6349a.toString());
            throw new C2504c(stringBuilder.toString(), e22, c2501j, 1);
        }
    }

    /* renamed from: a */
    public int mo2267a(byte[] bArr, int i, int i2) {
        try {
            m16369d();
            return m16367b(bArr, i, i2);
        } catch (IOException e) {
            throw new C2504c(e, this.f12933l, 2);
        }
    }

    /* renamed from: b */
    public void mo2270b() {
        try {
            if (this.f12935n != null) {
                C4732o.m16366a(this.f12934m, m16375c());
                this.f12935n.close();
            }
            this.f12935n = null;
            m16370e();
            if (this.f12936o) {
                this.f12936o = false;
                if (this.f12932k != null) {
                    this.f12932k.mo2317a(this);
                }
            }
        } catch (IOException e) {
            throw new C2504c(e, this.f12933l, 3);
        } catch (Throwable th) {
            this.f12935n = null;
            m16370e();
            if (this.f12936o) {
                this.f12936o = false;
                if (this.f12932k != null) {
                    this.f12932k.mo2317a(this);
                }
            }
        }
    }

    /* renamed from: c */
    protected final long m16375c() {
        return this.f12938q == -1 ? this.f12938q : this.f12938q - this.f12940s;
    }

    /* renamed from: b */
    private HttpURLConnection m16368b(C2501j c2501j) {
        C2501j c2501j2 = c2501j;
        URL url = new URL(c2501j2.f6349a.toString());
        byte[] bArr = c2501j2.f6350b;
        long j = c2501j2.f6352d;
        long j2 = c2501j2.f6353e;
        boolean a = c2501j2.m6958a(1);
        if (!this.f12925d) {
            return m16364a(url, bArr, j, j2, a, true);
        }
        HttpURLConnection a2;
        int i = 0;
        while (true) {
            int i2 = i + 1;
            int i3;
            if (i <= 20) {
                long j3 = j;
                i3 = i2;
                a2 = m16364a(url, bArr, j, j2, a, false);
                int responseCode = a2.getResponseCode();
                if (!(responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303)) {
                    if (bArr == null) {
                        if (responseCode != 307) {
                            if (responseCode != 308) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        break;
                    }
                }
                bArr = null;
                String headerField = a2.getHeaderField("Location");
                a2.disconnect();
                url = C4732o.m16365a(url, headerField);
                C4732o c4732o = this;
                i = i3;
                j = j3;
            } else {
                i3 = i2;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Too many redirects: ");
                stringBuilder.append(i3);
                throw new NoRouteToHostException(stringBuilder.toString());
            }
        }
        return a2;
    }

    /* renamed from: a */
    private HttpURLConnection m16364a(URL url, byte[] bArr, long j, long j2, boolean z, boolean z2) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f12926e);
        httpURLConnection.setReadTimeout(this.f12927f);
        if (this.f12930i != null) {
            for (Entry entry : this.f12930i.m6962b().entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        for (Entry entry2 : this.f12931j.m6962b().entrySet()) {
            httpURLConnection.setRequestProperty((String) entry2.getKey(), (String) entry2.getValue());
        }
        if (!(j == 0 && j2 == -1)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("bytes=");
            stringBuilder.append(j);
            stringBuilder.append("-");
            String stringBuilder2 = stringBuilder.toString();
            if (j2 != -1) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(stringBuilder2);
                stringBuilder3.append((j + j2) - 1);
                stringBuilder2 = stringBuilder3.toString();
            }
            httpURLConnection.setRequestProperty("Range", stringBuilder2);
        }
        httpURLConnection.setRequestProperty("User-Agent", this.f12928g);
        if (!z) {
            httpURLConnection.setRequestProperty("Accept-Encoding", InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY);
        }
        httpURLConnection.setInstanceFollowRedirects(z2);
        httpURLConnection.setDoOutput(bArr != null ? 1 : null);
        if (bArr != null) {
            httpURLConnection.setRequestMethod("POST");
            if (bArr.length == null) {
                httpURLConnection.connect();
            } else {
                httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                httpURLConnection.connect();
                j = httpURLConnection.getOutputStream();
                j.write(bArr);
                j.close();
            }
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    /* renamed from: a */
    private static URL m16365a(URL url, String str) {
        if (str != null) {
            URL url2 = new URL(url, str);
            url = url2.getProtocol();
            if (UriUtil.HTTPS_SCHEME.equals(url) == null) {
                if (UriUtil.HTTP_SCHEME.equals(url) == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unsupported protocol redirect: ");
                    stringBuilder.append(url);
                    throw new ProtocolException(stringBuilder.toString());
                }
            }
            return url2;
        }
        throw new ProtocolException("Null location redirect");
    }

    /* renamed from: a */
    private static long m16363a(java.net.HttpURLConnection r8) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = "Content-Length";
        r0 = r8.getHeaderField(r0);
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x002c;
    L_0x000c:
        r1 = java.lang.Long.parseLong(r0);	 Catch:{ NumberFormatException -> 0x0011 }
        goto L_0x002e;
    L_0x0011:
        r1 = "DefaultHttpDataSource";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Unexpected Content-Length [";
        r2.append(r3);
        r2.append(r0);
        r3 = "]";
        r2.append(r3);
        r2 = r2.toString();
        android.util.Log.e(r1, r2);
    L_0x002c:
        r1 = -1;
    L_0x002e:
        r3 = "Content-Range";
        r8 = r8.getHeaderField(r3);
        r3 = android.text.TextUtils.isEmpty(r8);
        if (r3 != 0) goto L_0x00ad;
    L_0x003a:
        r3 = f12923b;
        r3 = r3.matcher(r8);
        r4 = r3.find();
        if (r4 == 0) goto L_0x00ad;
    L_0x0046:
        r4 = 2;
        r4 = r3.group(r4);	 Catch:{ NumberFormatException -> 0x0092 }
        r4 = java.lang.Long.parseLong(r4);	 Catch:{ NumberFormatException -> 0x0092 }
        r6 = 1;	 Catch:{ NumberFormatException -> 0x0092 }
        r3 = r3.group(r6);	 Catch:{ NumberFormatException -> 0x0092 }
        r6 = java.lang.Long.parseLong(r3);	 Catch:{ NumberFormatException -> 0x0092 }
        r3 = 0;	 Catch:{ NumberFormatException -> 0x0092 }
        r4 = r4 - r6;	 Catch:{ NumberFormatException -> 0x0092 }
        r6 = 1;	 Catch:{ NumberFormatException -> 0x0092 }
        r4 = r4 + r6;	 Catch:{ NumberFormatException -> 0x0092 }
        r6 = 0;	 Catch:{ NumberFormatException -> 0x0092 }
        r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1));	 Catch:{ NumberFormatException -> 0x0092 }
        if (r3 >= 0) goto L_0x0065;	 Catch:{ NumberFormatException -> 0x0092 }
    L_0x0063:
        r1 = r4;	 Catch:{ NumberFormatException -> 0x0092 }
        goto L_0x00ad;	 Catch:{ NumberFormatException -> 0x0092 }
    L_0x0065:
        r3 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1));	 Catch:{ NumberFormatException -> 0x0092 }
        if (r3 == 0) goto L_0x00ad;	 Catch:{ NumberFormatException -> 0x0092 }
    L_0x0069:
        r3 = "DefaultHttpDataSource";	 Catch:{ NumberFormatException -> 0x0092 }
        r6 = new java.lang.StringBuilder;	 Catch:{ NumberFormatException -> 0x0092 }
        r6.<init>();	 Catch:{ NumberFormatException -> 0x0092 }
        r7 = "Inconsistent headers [";	 Catch:{ NumberFormatException -> 0x0092 }
        r6.append(r7);	 Catch:{ NumberFormatException -> 0x0092 }
        r6.append(r0);	 Catch:{ NumberFormatException -> 0x0092 }
        r0 = "] [";	 Catch:{ NumberFormatException -> 0x0092 }
        r6.append(r0);	 Catch:{ NumberFormatException -> 0x0092 }
        r6.append(r8);	 Catch:{ NumberFormatException -> 0x0092 }
        r0 = "]";	 Catch:{ NumberFormatException -> 0x0092 }
        r6.append(r0);	 Catch:{ NumberFormatException -> 0x0092 }
        r0 = r6.toString();	 Catch:{ NumberFormatException -> 0x0092 }
        android.util.Log.w(r3, r0);	 Catch:{ NumberFormatException -> 0x0092 }
        r3 = java.lang.Math.max(r1, r4);	 Catch:{ NumberFormatException -> 0x0092 }
        r1 = r3;
        goto L_0x00ad;
    L_0x0092:
        r0 = "DefaultHttpDataSource";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Unexpected Content-Range [";
        r3.append(r4);
        r3.append(r8);
        r8 = "]";
        r3.append(r8);
        r8 = r3.toString();
        android.util.Log.e(r0, r8);
    L_0x00ad:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.k.o.a(java.net.HttpURLConnection):long");
    }

    /* renamed from: d */
    private void m16369d() {
        if (this.f12939r != this.f12937p) {
            Object obj = (byte[]) f12924c.getAndSet(null);
            if (obj == null) {
                obj = new byte[4096];
            }
            while (this.f12939r != this.f12937p) {
                int read = this.f12935n.read(obj, 0, (int) Math.min(this.f12937p - this.f12939r, (long) obj.length));
                if (Thread.interrupted()) {
                    throw new InterruptedIOException();
                } else if (read != -1) {
                    this.f12939r += (long) read;
                    if (this.f12932k != null) {
                        this.f12932k.mo2318a((Object) this, read);
                    }
                } else {
                    throw new EOFException();
                }
            }
            f12924c.set(obj);
        }
    }

    /* renamed from: b */
    private int m16367b(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return null;
        }
        if (this.f12938q != -1) {
            long j = this.f12938q - this.f12940s;
            if (j == 0) {
                return -1;
            }
            i2 = (int) Math.min((long) i2, j);
        }
        int read = this.f12935n.read(bArr, i, i2);
        if (read != -1) {
            this.f12940s += (long) read;
            if (this.f12932k != 0) {
                this.f12932k.mo2318a((Object) this, read);
            }
            return read;
        } else if (this.f12938q == -1) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    /* renamed from: a */
    private static void m16366a(java.net.HttpURLConnection r2, long r3) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/127791068.run(Unknown Source)
*/
        /*
        r0 = com.google.android.exoplayer2.p164l.C2541v.f6467a;
        r1 = 19;
        if (r0 == r1) goto L_0x000d;
    L_0x0006:
        r0 = com.google.android.exoplayer2.p164l.C2541v.f6467a;
        r1 = 20;
        if (r0 == r1) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r2 = r2.getInputStream();	 Catch:{ Exception -> 0x0058 }
        r0 = -1;	 Catch:{ Exception -> 0x0058 }
        r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));	 Catch:{ Exception -> 0x0058 }
        if (r0 != 0) goto L_0x001f;	 Catch:{ Exception -> 0x0058 }
    L_0x0017:
        r3 = r2.read();	 Catch:{ Exception -> 0x0058 }
        r4 = -1;	 Catch:{ Exception -> 0x0058 }
        if (r3 != r4) goto L_0x0026;	 Catch:{ Exception -> 0x0058 }
    L_0x001e:
        return;	 Catch:{ Exception -> 0x0058 }
    L_0x001f:
        r0 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;	 Catch:{ Exception -> 0x0058 }
        r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));	 Catch:{ Exception -> 0x0058 }
        if (r3 > 0) goto L_0x0026;	 Catch:{ Exception -> 0x0058 }
    L_0x0025:
        return;	 Catch:{ Exception -> 0x0058 }
    L_0x0026:
        r3 = r2.getClass();	 Catch:{ Exception -> 0x0058 }
        r3 = r3.getName();	 Catch:{ Exception -> 0x0058 }
        r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream";	 Catch:{ Exception -> 0x0058 }
        r4 = r3.equals(r4);	 Catch:{ Exception -> 0x0058 }
        if (r4 != 0) goto L_0x003e;	 Catch:{ Exception -> 0x0058 }
    L_0x0036:
        r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream";	 Catch:{ Exception -> 0x0058 }
        r3 = r3.equals(r4);	 Catch:{ Exception -> 0x0058 }
        if (r3 == 0) goto L_0x0058;	 Catch:{ Exception -> 0x0058 }
    L_0x003e:
        r3 = r2.getClass();	 Catch:{ Exception -> 0x0058 }
        r3 = r3.getSuperclass();	 Catch:{ Exception -> 0x0058 }
        r4 = "unexpectedEndOfInput";	 Catch:{ Exception -> 0x0058 }
        r0 = 0;	 Catch:{ Exception -> 0x0058 }
        r1 = new java.lang.Class[r0];	 Catch:{ Exception -> 0x0058 }
        r3 = r3.getDeclaredMethod(r4, r1);	 Catch:{ Exception -> 0x0058 }
        r4 = 1;	 Catch:{ Exception -> 0x0058 }
        r3.setAccessible(r4);	 Catch:{ Exception -> 0x0058 }
        r4 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x0058 }
        r3.invoke(r2, r4);	 Catch:{ Exception -> 0x0058 }
    L_0x0058:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.k.o.a(java.net.HttpURLConnection, long):void");
    }

    /* renamed from: e */
    private void m16370e() {
        if (this.f12934m != null) {
            try {
                this.f12934m.disconnect();
            } catch (Throwable e) {
                Log.e("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.f12934m = null;
        }
    }
}
