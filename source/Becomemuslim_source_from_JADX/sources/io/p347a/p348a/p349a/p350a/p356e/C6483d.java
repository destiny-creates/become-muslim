package io.p347a.p348a.p349a.p350a.p356e;

import com.facebook.internal.Utility;
import com.facebook.stetho.common.Utf8Charset;
import com.facebook.stetho.server.http.HttpHeaders;
import com.facebook.stetho.server.http.HttpStatus;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.net.URL;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;

/* compiled from: HttpRequest */
/* renamed from: io.a.a.a.a.e.d */
public class C6483d {
    /* renamed from: b */
    private static final String[] f20886b = new String[0];
    /* renamed from: c */
    private static C6479b f20887c = C6479b.f20884a;
    /* renamed from: a */
    public final URL f20888a;
    /* renamed from: d */
    private HttpURLConnection f20889d = null;
    /* renamed from: e */
    private final String f20890e;
    /* renamed from: f */
    private C6482e f20891f;
    /* renamed from: g */
    private boolean f20892g;
    /* renamed from: h */
    private boolean f20893h = true;
    /* renamed from: i */
    private boolean f20894i = false;
    /* renamed from: j */
    private int f20895j = Utility.DEFAULT_STREAM_BUFFER_SIZE;
    /* renamed from: k */
    private String f20896k;
    /* renamed from: l */
    private int f20897l;

    /* compiled from: HttpRequest */
    /* renamed from: io.a.a.a.a.e.d$b */
    public interface C6479b {
        /* renamed from: a */
        public static final C6479b f20884a = new C76171();

        /* compiled from: HttpRequest */
        /* renamed from: io.a.a.a.a.e.d$b$1 */
        static class C76171 implements C6479b {
            C76171() {
            }

            /* renamed from: a */
            public HttpURLConnection mo5459a(URL url) {
                return (HttpURLConnection) url.openConnection();
            }

            /* renamed from: a */
            public HttpURLConnection mo5460a(URL url, Proxy proxy) {
                return (HttpURLConnection) url.openConnection(proxy);
            }
        }

        /* renamed from: a */
        HttpURLConnection mo5459a(URL url);

        /* renamed from: a */
        HttpURLConnection mo5460a(URL url, Proxy proxy);
    }

    /* compiled from: HttpRequest */
    /* renamed from: io.a.a.a.a.e.d$c */
    public static class C6480c extends RuntimeException {
        private static final long serialVersionUID = -1170466989781746231L;

        public /* synthetic */ Throwable getCause() {
            return m26525a();
        }

        protected C6480c(IOException iOException) {
            super(iOException);
        }

        /* renamed from: a */
        public IOException m26525a() {
            return (IOException) super.getCause();
        }
    }

    /* compiled from: HttpRequest */
    /* renamed from: io.a.a.a.a.e.d$d */
    protected static abstract class C6481d<V> implements Callable<V> {
        /* renamed from: b */
        protected abstract V mo6415b();

        /* renamed from: c */
        protected abstract void mo5458c();

        protected C6481d() {
        }

        public V call() {
            Throwable th;
            Object obj = 1;
            try {
                V b = mo6415b();
                try {
                    mo5458c();
                    return b;
                } catch (IOException e) {
                    throw new C6480c(e);
                }
            } catch (C6480c e2) {
                throw e2;
            } catch (IOException e3) {
                throw new C6480c(e3);
            } catch (Throwable th2) {
                th = th2;
                mo5458c();
                throw th;
            }
        }
    }

    /* compiled from: HttpRequest */
    /* renamed from: io.a.a.a.a.e.d$e */
    public static class C6482e extends BufferedOutputStream {
        /* renamed from: a */
        private final CharsetEncoder f20885a;

        public C6482e(OutputStream outputStream, String str, int i) {
            super(outputStream, i);
            this.f20885a = Charset.forName(C6483d.m26541f(str)).newEncoder();
        }

        /* renamed from: a */
        public C6482e m26528a(String str) {
            str = this.f20885a.encode(CharBuffer.wrap(str));
            super.write(str.array(), 0, str.limit());
            return this;
        }
    }

    /* compiled from: HttpRequest */
    /* renamed from: io.a.a.a.a.e.d$a */
    protected static abstract class C7616a<V> extends C6481d<V> {
        /* renamed from: a */
        private final Closeable f26327a;
        /* renamed from: b */
        private final boolean f26328b;

        protected C7616a(Closeable closeable, boolean z) {
            this.f26327a = closeable;
            this.f26328b = z;
        }

        /* renamed from: c */
        protected void mo5458c() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r1 = this;
            r0 = r1.f26327a;
            r0 = r0 instanceof java.io.Flushable;
            if (r0 == 0) goto L_0x000d;
        L_0x0006:
            r0 = r1.f26327a;
            r0 = (java.io.Flushable) r0;
            r0.flush();
        L_0x000d:
            r0 = r1.f26328b;
            if (r0 == 0) goto L_0x0017;
        L_0x0011:
            r0 = r1.f26327a;	 Catch:{ IOException -> 0x001c }
            r0.close();	 Catch:{ IOException -> 0x001c }
            goto L_0x001c;
        L_0x0017:
            r0 = r1.f26327a;
            r0.close();
        L_0x001c:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.e.d.a.c():void");
        }
    }

    /* renamed from: f */
    private static String m26541f(String str) {
        return (str == null || str.length() <= 0) ? Utf8Charset.NAME : str;
    }

    /* renamed from: a */
    private static StringBuilder m26533a(String str, StringBuilder stringBuilder) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            stringBuilder.append('/');
        }
        return stringBuilder;
    }

    /* renamed from: b */
    private static StringBuilder m26536b(String str, StringBuilder stringBuilder) {
        int indexOf = str.indexOf(63);
        int length = stringBuilder.length() - 1;
        if (indexOf == -1) {
            stringBuilder.append('?');
        } else if (indexOf < length && str.charAt(length) != 38) {
            stringBuilder.append('&');
        }
        return stringBuilder;
    }

    /* renamed from: a */
    public static String m26531a(CharSequence charSequence) {
        try {
            URL url = new URL(charSequence.toString());
            charSequence = url.getHost();
            int port = url.getPort();
            if (port != -1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(charSequence);
                stringBuilder.append(':');
                stringBuilder.append(Integer.toString(port));
                charSequence = stringBuilder.toString();
            }
            try {
                charSequence = new URI(url.getProtocol(), charSequence, url.getPath(), url.getQuery(), null).toASCIIString();
                int indexOf = charSequence.indexOf(63);
                if (indexOf <= 0) {
                    return charSequence;
                }
                indexOf++;
                if (indexOf >= charSequence.length()) {
                    return charSequence;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(charSequence.substring(0, indexOf));
                stringBuilder2.append(charSequence.substring(indexOf).replace("+", "%2B"));
                return stringBuilder2.toString();
            } catch (CharSequence charSequence2) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(charSequence2);
                throw new C6480c(iOException);
            }
        } catch (CharSequence charSequence22) {
            throw new C6480c(charSequence22);
        }
    }

    /* renamed from: a */
    public static String m26532a(CharSequence charSequence, Map<?, ?> map) {
        String charSequence2 = charSequence.toString();
        if (map != null) {
            if (!map.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder(charSequence2);
                C6483d.m26533a(charSequence2, stringBuilder);
                C6483d.m26536b(charSequence2, stringBuilder);
                charSequence = map.entrySet().iterator();
                Entry entry = (Entry) charSequence.next();
                stringBuilder.append(entry.getKey().toString());
                stringBuilder.append('=');
                map = entry.getValue();
                if (map != null) {
                    stringBuilder.append(map);
                }
                while (charSequence.hasNext() != null) {
                    stringBuilder.append('&');
                    entry = (Entry) charSequence.next();
                    stringBuilder.append(entry.getKey().toString());
                    stringBuilder.append('=');
                    map = entry.getValue();
                    if (map != null) {
                        stringBuilder.append(map);
                    }
                }
                return stringBuilder.toString();
            }
        }
        return charSequence2;
    }

    /* renamed from: b */
    public static C6483d m26534b(CharSequence charSequence) {
        return new C6483d(charSequence, "GET");
    }

    /* renamed from: a */
    public static C6483d m26530a(CharSequence charSequence, Map<?, ?> map, boolean z) {
        charSequence = C6483d.m26532a(charSequence, (Map) map);
        if (z) {
            charSequence = C6483d.m26531a(charSequence);
        }
        return C6483d.m26534b(charSequence);
    }

    /* renamed from: c */
    public static C6483d m26537c(CharSequence charSequence) {
        return new C6483d(charSequence, "POST");
    }

    /* renamed from: b */
    public static C6483d m26535b(CharSequence charSequence, Map<?, ?> map, boolean z) {
        charSequence = C6483d.m26532a(charSequence, (Map) map);
        if (z) {
            charSequence = C6483d.m26531a(charSequence);
        }
        return C6483d.m26537c(charSequence);
    }

    /* renamed from: d */
    public static C6483d m26538d(CharSequence charSequence) {
        return new C6483d(charSequence, "PUT");
    }

    /* renamed from: e */
    public static C6483d m26539e(CharSequence charSequence) {
        return new C6483d(charSequence, "DELETE");
    }

    public C6483d(CharSequence charSequence, String str) {
        try {
            this.f20888a = new URL(charSequence.toString());
            this.f20890e = str;
        } catch (CharSequence charSequence2) {
            throw new C6480c(charSequence2);
        }
    }

    /* renamed from: q */
    private Proxy m26542q() {
        return new Proxy(Type.HTTP, new InetSocketAddress(this.f20896k, this.f20897l));
    }

    /* renamed from: r */
    private HttpURLConnection m26543r() {
        try {
            HttpURLConnection a;
            if (this.f20896k != null) {
                a = f20887c.mo5460a(this.f20888a, m26542q());
            } else {
                a = f20887c.mo5459a(this.f20888a);
            }
            a.setRequestMethod(this.f20890e);
            return a;
        } catch (IOException e) {
            throw new C6480c(e);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(m26582p());
        stringBuilder.append(' ');
        stringBuilder.append(m26581o());
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public HttpURLConnection m26557a() {
        if (this.f20889d == null) {
            this.f20889d = m26543r();
        }
        return this.f20889d;
    }

    /* renamed from: b */
    public int m26558b() {
        try {
            m26577k();
            return m26557a().getResponseCode();
        } catch (IOException e) {
            throw new C6480c(e);
        }
    }

    /* renamed from: c */
    public boolean m26564c() {
        return HttpStatus.HTTP_OK == m26558b();
    }

    /* renamed from: d */
    protected ByteArrayOutputStream m26567d() {
        int j = m26576j();
        if (j > 0) {
            return new ByteArrayOutputStream(j);
        }
        return new ByteArrayOutputStream();
    }

    /* renamed from: a */
    public String m26556a(String str) {
        OutputStream d = m26567d();
        try {
            m26546a(m26572f(), d);
            return d.toString(C6483d.m26541f(str));
        } catch (String str2) {
            throw new C6480c(str2);
        }
    }

    /* renamed from: e */
    public String m26569e() {
        return m26556a(m26574h());
    }

    /* renamed from: f */
    public BufferedInputStream m26572f() {
        return new BufferedInputStream(m26573g(), this.f20895j);
    }

    /* renamed from: g */
    public InputStream m26573g() {
        InputStream inputStream;
        if (m26558b() < 400) {
            try {
                inputStream = m26557a().getInputStream();
            } catch (IOException e) {
                throw new C6480c(e);
            }
        }
        inputStream = m26557a().getErrorStream();
        if (inputStream == null) {
            try {
                inputStream = m26557a().getInputStream();
            } catch (IOException e2) {
                throw new C6480c(e2);
            }
        }
        if (this.f20894i) {
            if ("gzip".equals(m26575i())) {
                try {
                    return new GZIPInputStream(inputStream);
                } catch (IOException e22) {
                    throw new C6480c(e22);
                }
            }
        }
        return inputStream;
    }

    /* renamed from: a */
    public C6483d m26545a(int i) {
        m26557a().setConnectTimeout(i);
        return this;
    }

    /* renamed from: a */
    public C6483d m26548a(String str, String str2) {
        m26557a().setRequestProperty(str, str2);
        return this;
    }

    /* renamed from: a */
    public C6483d m26554a(Entry<String, String> entry) {
        return m26548a((String) entry.getKey(), (String) entry.getValue());
    }

    /* renamed from: b */
    public String m26560b(String str) {
        m26578l();
        return m26557a().getHeaderField(str);
    }

    /* renamed from: c */
    public int m26562c(String str) {
        return m26544a(str, -1);
    }

    /* renamed from: a */
    public int m26544a(String str, int i) {
        m26578l();
        return m26557a().getHeaderFieldInt(str, i);
    }

    /* renamed from: b */
    public String m26561b(String str, String str2) {
        return m26563c(m26560b(str), str2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    protected java.lang.String m26563c(java.lang.String r9, java.lang.String r10) {
        /*
        r8 = this;
        r0 = 0;
        if (r9 == 0) goto L_0x0071;
    L_0x0003:
        r1 = r9.length();
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        goto L_0x0071;
    L_0x000a:
        r1 = r9.length();
        r2 = 59;
        r3 = r9.indexOf(r2);
        r4 = 1;
        r3 = r3 + r4;
        if (r3 == 0) goto L_0x0070;
    L_0x0018:
        if (r3 != r1) goto L_0x001b;
    L_0x001a:
        goto L_0x0070;
    L_0x001b:
        r5 = r9.indexOf(r2, r3);
        r6 = -1;
        if (r5 != r6) goto L_0x0023;
    L_0x0022:
        r5 = r1;
    L_0x0023:
        if (r3 >= r5) goto L_0x006f;
    L_0x0025:
        r7 = 61;
        r7 = r9.indexOf(r7, r3);
        if (r7 == r6) goto L_0x0066;
    L_0x002d:
        if (r7 >= r5) goto L_0x0066;
    L_0x002f:
        r3 = r9.substring(r3, r7);
        r3 = r3.trim();
        r3 = r10.equals(r3);
        if (r3 == 0) goto L_0x0066;
    L_0x003d:
        r7 = r7 + 1;
        r3 = r9.substring(r7, r5);
        r3 = r3.trim();
        r7 = r3.length();
        if (r7 == 0) goto L_0x0066;
    L_0x004d:
        r9 = 2;
        if (r7 <= r9) goto L_0x0065;
    L_0x0050:
        r9 = 0;
        r9 = r3.charAt(r9);
        r10 = 34;
        if (r10 != r9) goto L_0x0065;
    L_0x0059:
        r7 = r7 - r4;
        r9 = r3.charAt(r7);
        if (r10 != r9) goto L_0x0065;
    L_0x0060:
        r9 = r3.substring(r4, r7);
        return r9;
    L_0x0065:
        return r3;
    L_0x0066:
        r3 = r5 + 1;
        r5 = r9.indexOf(r2, r3);
        if (r5 != r6) goto L_0x0023;
    L_0x006e:
        goto L_0x0022;
    L_0x006f:
        return r0;
    L_0x0070:
        return r0;
    L_0x0071:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.e.d.c(java.lang.String, java.lang.String):java.lang.String");
    }

    /* renamed from: h */
    public String m26574h() {
        return m26561b(HttpHeaders.CONTENT_TYPE, "charset");
    }

    /* renamed from: a */
    public C6483d m26555a(boolean z) {
        m26557a().setUseCaches(z);
        return this;
    }

    /* renamed from: i */
    public String m26575i() {
        return m26560b("Content-Encoding");
    }

    /* renamed from: d */
    public C6483d m26565d(String str) {
        return m26566d(str, null);
    }

    /* renamed from: d */
    public C6483d m26566d(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return m26548a(HttpHeaders.CONTENT_TYPE, str);
        }
        String str3 = HttpHeaders.CONTENT_TYPE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("; charset=");
        stringBuilder.append(str2);
        return m26548a(str3, stringBuilder.toString());
    }

    /* renamed from: j */
    public int m26576j() {
        return m26562c(HttpHeaders.CONTENT_LENGTH);
    }

    /* renamed from: a */
    protected C6483d m26546a(InputStream inputStream, OutputStream outputStream) {
        final InputStream inputStream2 = inputStream;
        final OutputStream outputStream2 = outputStream;
        return (C6483d) new C7616a<C6483d>(this, inputStream, this.f20893h) {
            /* renamed from: c */
            final /* synthetic */ C6483d f30387c;

            /* renamed from: b */
            public /* synthetic */ Object mo6415b() {
                return m39742a();
            }

            /* renamed from: a */
            public C6483d m39742a() {
                byte[] bArr = new byte[this.f30387c.f20895j];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read == -1) {
                        return this.f30387c;
                    }
                    outputStream2.write(bArr, 0, read);
                }
            }
        }.call();
    }

    /* renamed from: k */
    protected io.p347a.p348a.p349a.p350a.p356e.C6483d m26577k() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.f20891f;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return r2;
    L_0x0005:
        r0 = r2.f20892g;
        if (r0 == 0) goto L_0x0010;
    L_0x0009:
        r0 = r2.f20891f;
        r1 = "\r\n--00content0boundary00--\r\n";
        r0.m26528a(r1);
    L_0x0010:
        r0 = r2.f20893h;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r2.f20891f;	 Catch:{ IOException -> 0x001f }
        r0.close();	 Catch:{ IOException -> 0x001f }
        goto L_0x001f;
    L_0x001a:
        r0 = r2.f20891f;
        r0.close();
    L_0x001f:
        r0 = 0;
        r2.f20891f = r0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.e.d.k():io.a.a.a.a.e.d");
    }

    /* renamed from: l */
    protected C6483d m26578l() {
        try {
            return m26577k();
        } catch (IOException e) {
            throw new C6480c(e);
        }
    }

    /* renamed from: m */
    protected C6483d m26579m() {
        if (this.f20891f != null) {
            return this;
        }
        m26557a().setDoOutput(true);
        this.f20891f = new C6482e(m26557a().getOutputStream(), m26563c(m26557a().getRequestProperty(HttpHeaders.CONTENT_TYPE), "charset"), this.f20895j);
        return this;
    }

    /* renamed from: n */
    protected C6483d m26580n() {
        if (this.f20892g) {
            this.f20891f.m26528a("\r\n--00content0boundary00\r\n");
        } else {
            this.f20892g = true;
            m26565d("multipart/form-data; boundary=00content0boundary00").m26579m();
            this.f20891f.m26528a("--00content0boundary00\r\n");
        }
        return this;
    }

    /* renamed from: a */
    protected C6483d m26550a(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("form-data; name=\"");
        stringBuilder.append(str);
        if (str2 != null) {
            stringBuilder.append("\"; filename=\"");
            stringBuilder.append(str2);
        }
        stringBuilder.append('\"');
        m26571f("Content-Disposition", stringBuilder.toString());
        if (str3 != null) {
            m26571f(HttpHeaders.CONTENT_TYPE, str3);
        }
        return m26570f((CharSequence) "\r\n");
    }

    /* renamed from: e */
    public C6483d m26568e(String str, String str2) {
        return m26559b(str, null, str2);
    }

    /* renamed from: b */
    public C6483d m26559b(String str, String str2, String str3) {
        return m26553a(str, str2, null, str3);
    }

    /* renamed from: a */
    public C6483d m26553a(String str, String str2, String str3, String str4) {
        try {
            m26580n();
            m26550a(str, str2, str3);
            this.f20891f.m26528a(str4);
            return this;
        } catch (String str5) {
            throw new C6480c(str5);
        }
    }

    /* renamed from: a */
    public C6483d m26547a(String str, Number number) {
        return m26549a(str, null, number);
    }

    /* renamed from: a */
    public C6483d m26549a(String str, String str2, Number number) {
        return m26559b(str, str2, number != null ? number.toString() : null);
    }

    /* renamed from: a */
    public io.p347a.p348a.p349a.p350a.p356e.C6483d m26551a(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.io.File r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 0;
        r1 = new java.io.BufferedInputStream;	 Catch:{ IOException -> 0x001b }
        r2 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x001b }
        r2.<init>(r7);	 Catch:{ IOException -> 0x001b }
        r1.<init>(r2);	 Catch:{ IOException -> 0x001b }
        r4 = r3.m26552a(r4, r5, r6, r1);	 Catch:{ IOException -> 0x0016, all -> 0x0013 }
        r1.close();	 Catch:{ IOException -> 0x0012 }
    L_0x0012:
        return r4;
    L_0x0013:
        r4 = move-exception;
        r0 = r1;
        goto L_0x0022;
    L_0x0016:
        r4 = move-exception;
        r0 = r1;
        goto L_0x001c;
    L_0x0019:
        r4 = move-exception;
        goto L_0x0022;
    L_0x001b:
        r4 = move-exception;
    L_0x001c:
        r5 = new io.a.a.a.a.e.d$c;	 Catch:{ all -> 0x0019 }
        r5.<init>(r4);	 Catch:{ all -> 0x0019 }
        throw r5;	 Catch:{ all -> 0x0019 }
    L_0x0022:
        if (r0 == 0) goto L_0x0027;
    L_0x0024:
        r0.close();	 Catch:{ IOException -> 0x0027 }
    L_0x0027:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.a.a.a.a.e.d.a(java.lang.String, java.lang.String, java.lang.String, java.io.File):io.a.a.a.a.e.d");
    }

    /* renamed from: a */
    public C6483d m26552a(String str, String str2, String str3, InputStream inputStream) {
        try {
            m26580n();
            m26550a(str, str2, str3);
            m26546a(inputStream, this.f20891f);
            return this;
        } catch (String str4) {
            throw new C6480c(str4);
        }
    }

    /* renamed from: f */
    public C6483d m26571f(String str, String str2) {
        return m26570f((CharSequence) str).m26570f((CharSequence) ": ").m26570f((CharSequence) str2).m26570f((CharSequence) "\r\n");
    }

    /* renamed from: f */
    public C6483d m26570f(CharSequence charSequence) {
        try {
            m26579m();
            this.f20891f.m26528a(charSequence.toString());
            return this;
        } catch (CharSequence charSequence2) {
            throw new C6480c(charSequence2);
        }
    }

    /* renamed from: o */
    public URL m26581o() {
        return m26557a().getURL();
    }

    /* renamed from: p */
    public String m26582p() {
        return m26557a().getRequestMethod();
    }
}
