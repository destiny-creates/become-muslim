package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Headers.Builder;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.DiskLruCache.Editor;
import okhttp3.internal.cache.DiskLruCache.Snapshot;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import p286d.C5869f;
import p286d.C5870l;
import p286d.C5875s;
import p286d.C5876t;
import p286d.C7203d;
import p286d.C7204e;
import p286d.C7205g;
import p286d.C7206h;
import p286d.C8037c;

public final class Cache implements Closeable, Flushable {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    final DiskLruCache cache;
    private int hitCount;
    final InternalCache internalCache;
    private int networkCount;
    private int requestCount;
    int writeAbortCount;
    int writeSuccessCount;

    /* renamed from: okhttp3.Cache$2 */
    class C66122 implements Iterator<String> {
        boolean canRemove;
        final Iterator<Snapshot> delegate = Cache.this.cache.snapshots();
        String nextUrl;

        C66122() {
        }

        public boolean hasNext() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = r4.nextUrl;
            r1 = 1;
            if (r0 == 0) goto L_0x0006;
        L_0x0005:
            return r1;
        L_0x0006:
            r0 = 0;
            r4.canRemove = r0;
        L_0x0009:
            r2 = r4.delegate;
            r2 = r2.hasNext();
            if (r2 == 0) goto L_0x0034;
        L_0x0011:
            r2 = r4.delegate;
            r2 = r2.next();
            r2 = (okhttp3.internal.cache.DiskLruCache.Snapshot) r2;
            r3 = r2.getSource(r0);	 Catch:{ IOException -> 0x0030, all -> 0x002b }
            r3 = p286d.C5870l.m24720a(r3);	 Catch:{ IOException -> 0x0030, all -> 0x002b }
            r3 = r3.mo6318r();	 Catch:{ IOException -> 0x0030, all -> 0x002b }
            r4.nextUrl = r3;	 Catch:{ IOException -> 0x0030, all -> 0x002b }
            r2.close();
            return r1;
        L_0x002b:
            r0 = move-exception;
            r2.close();
            throw r0;
        L_0x0030:
            r2.close();
            goto L_0x0009;
        L_0x0034:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.2.hasNext():boolean");
        }

        public String next() {
            if (hasNext()) {
                String str = this.nextUrl;
                this.nextUrl = null;
                this.canRemove = true;
                return str;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            if (this.canRemove) {
                this.delegate.remove();
                return;
            }
            throw new IllegalStateException("remove() before next()");
        }
    }

    private static final class Entry {
        private static final String RECEIVED_MILLIS;
        private static final String SENT_MILLIS;
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final String url;
        private final Headers varyHeaders;

        static {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Platform.get().getPrefix());
            stringBuilder.append("-Sent-Millis");
            SENT_MILLIS = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(Platform.get().getPrefix());
            stringBuilder.append("-Received-Millis");
            RECEIVED_MILLIS = stringBuilder.toString();
        }

        Entry(C5876t c5876t) {
            try {
                C7204e a = C5870l.m24720a(c5876t);
                this.url = a.mo6318r();
                this.requestMethod = a.mo6318r();
                Builder builder = new Builder();
                int readInt = Cache.readInt(a);
                for (int i = 0; i < readInt; i++) {
                    builder.addLenient(a.mo6318r());
                }
                this.varyHeaders = builder.build();
                StatusLine parse = StatusLine.parse(a.mo6318r());
                this.protocol = parse.protocol;
                this.code = parse.code;
                this.message = parse.message;
                builder = new Builder();
                readInt = Cache.readInt(a);
                for (int i2 = 0; i2 < readInt; i2++) {
                    builder.addLenient(a.mo6318r());
                }
                String str = builder.get(SENT_MILLIS);
                String str2 = builder.get(RECEIVED_MILLIS);
                builder.removeAll(SENT_MILLIS);
                builder.removeAll(RECEIVED_MILLIS);
                long j = 0;
                this.sentRequestMillis = str != null ? Long.parseLong(str) : 0;
                if (str2 != null) {
                    j = Long.parseLong(str2);
                }
                this.receivedResponseMillis = j;
                this.responseHeaders = builder.build();
                if (isHttps()) {
                    String r = a.mo6318r();
                    if (r.length() <= 0) {
                        TlsVersion tlsVersion;
                        CipherSuite forJavaName = CipherSuite.forJavaName(a.mo6318r());
                        List readCertificateList = readCertificateList(a);
                        List readCertificateList2 = readCertificateList(a);
                        if (a.mo6300e()) {
                            tlsVersion = TlsVersion.SSL_3_0;
                        } else {
                            tlsVersion = TlsVersion.forJavaName(a.mo6318r());
                        }
                        this.handshake = Handshake.get(tlsVersion, forJavaName, readCertificateList, readCertificateList2);
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("expected \"\" but was \"");
                        stringBuilder.append(r);
                        stringBuilder.append("\"");
                        throw new IOException(stringBuilder.toString());
                    }
                }
                this.handshake = null;
                c5876t.close();
            } catch (Throwable th) {
                c5876t.close();
            }
        }

        Entry(Response response) {
            this.url = response.request().url().toString();
            this.varyHeaders = HttpHeaders.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }

        public void writeTo(Editor editor) {
            int i = 0;
            editor = C5870l.m24719a(editor.newSink(0));
            editor.mo6294b(this.url).mo6307i(10);
            editor.mo6294b(this.requestMethod).mo6307i(10);
            editor.mo6316n((long) this.varyHeaders.size()).mo6307i(10);
            int size = this.varyHeaders.size();
            for (int i2 = 0; i2 < size; i2++) {
                editor.mo6294b(this.varyHeaders.name(i2)).mo6294b(": ").mo6294b(this.varyHeaders.value(i2)).mo6307i(10);
            }
            editor.mo6294b(new StatusLine(this.protocol, this.code, this.message).toString()).mo6307i(10);
            editor.mo6316n((long) (this.responseHeaders.size() + 2)).mo6307i(10);
            size = this.responseHeaders.size();
            while (i < size) {
                editor.mo6294b(this.responseHeaders.name(i)).mo6294b(": ").mo6294b(this.responseHeaders.value(i)).mo6307i(10);
                i++;
            }
            editor.mo6294b(SENT_MILLIS).mo6294b(": ").mo6316n(this.sentRequestMillis).mo6307i(10);
            editor.mo6294b(RECEIVED_MILLIS).mo6294b(": ").mo6316n(this.receivedResponseMillis).mo6307i(10);
            if (isHttps()) {
                editor.mo6307i(10);
                editor.mo6294b(this.handshake.cipherSuite().javaName()).mo6307i(10);
                writeCertList(editor, this.handshake.peerCertificates());
                writeCertList(editor, this.handshake.localCertificates());
                editor.mo6294b(this.handshake.tlsVersion().javaName()).mo6307i(10);
            }
            editor.close();
        }

        private boolean isHttps() {
            return this.url.startsWith("https://");
        }

        private List<Certificate> readCertificateList(C7204e c7204e) {
            int readInt = Cache.readInt(c7204e);
            if (readInt == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                List<Certificate> arrayList = new ArrayList(readInt);
                for (int i = 0; i < readInt; i++) {
                    String r = c7204e.mo6318r();
                    C8037c c8037c = new C8037c();
                    c8037c.m38968a(C5869f.m24700b(r));
                    arrayList.add(instance.generateCertificate(c8037c.mo6301f()));
                }
                return arrayList;
            } catch (C7204e c7204e2) {
                throw new IOException(c7204e2.getMessage());
            }
        }

        private void writeCertList(C7203d c7203d, List<Certificate> list) {
            try {
                c7203d.mo6316n((long) list.size()).mo6307i(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    c7203d.mo6294b(C5869f.m24699a(((Certificate) list.get(i)).getEncoded()).mo5103b()).mo6307i(10);
                }
            } catch (C7203d c7203d2) {
                throw new IOException(c7203d2.getMessage());
            }
        }

        public boolean matches(Request request, Response response) {
            return (this.url.equals(request.url().toString()) && this.requestMethod.equals(request.method()) && HttpHeaders.varyMatches(response, this.varyHeaders, request) != null) ? true : null;
        }

        public Response response(Snapshot snapshot) {
            String str = this.responseHeaders.get(com.facebook.stetho.server.http.HttpHeaders.CONTENT_TYPE);
            String str2 = this.responseHeaders.get(com.facebook.stetho.server.http.HttpHeaders.CONTENT_LENGTH);
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }
    }

    /* renamed from: okhttp3.Cache$1 */
    class C76491 implements InternalCache {
        C76491() {
        }

        public Response get(Request request) {
            return Cache.this.get(request);
        }

        public CacheRequest put(Response response) {
            return Cache.this.put(response);
        }

        public void remove(Request request) {
            Cache.this.remove(request);
        }

        public void update(Response response, Response response2) {
            Cache.this.update(response, response2);
        }

        public void trackConditionalCacheHit() {
            Cache.this.trackConditionalCacheHit();
        }

        public void trackResponse(CacheStrategy cacheStrategy) {
            Cache.this.trackResponse(cacheStrategy);
        }
    }

    private final class CacheRequestImpl implements CacheRequest {
        private C5875s body;
        private C5875s cacheOut;
        boolean done;
        private final Editor editor;

        CacheRequestImpl(final Editor editor) {
            this.editor = editor;
            this.cacheOut = editor.newSink(1);
            this.body = new C7205g(this.cacheOut, Cache.this) {
                public void close() {
                    synchronized (Cache.this) {
                        if (CacheRequestImpl.this.done) {
                            return;
                        }
                        CacheRequestImpl.this.done = true;
                        Cache cache = Cache.this;
                        cache.writeSuccessCount++;
                        super.close();
                        editor.commit();
                    }
                }
            };
        }

        public void abort() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = okhttp3.Cache.this;
            monitor-enter(r0);
            r1 = r4.done;	 Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x0009;	 Catch:{ all -> 0x001f }
        L_0x0007:
            monitor-exit(r0);	 Catch:{ all -> 0x001f }
            return;	 Catch:{ all -> 0x001f }
        L_0x0009:
            r1 = 1;	 Catch:{ all -> 0x001f }
            r4.done = r1;	 Catch:{ all -> 0x001f }
            r2 = okhttp3.Cache.this;	 Catch:{ all -> 0x001f }
            r3 = r2.writeAbortCount;	 Catch:{ all -> 0x001f }
            r3 = r3 + r1;	 Catch:{ all -> 0x001f }
            r2.writeAbortCount = r3;	 Catch:{ all -> 0x001f }
            monitor-exit(r0);	 Catch:{ all -> 0x001f }
            r0 = r4.cacheOut;
            okhttp3.internal.Util.closeQuietly(r0);
            r0 = r4.editor;	 Catch:{ IOException -> 0x001e }
            r0.abort();	 Catch:{ IOException -> 0x001e }
        L_0x001e:
            return;
        L_0x001f:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x001f }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.CacheRequestImpl.abort():void");
        }

        public C5875s body() {
            return this.body;
        }
    }

    private static class CacheResponseBody extends ResponseBody {
        private final C7204e bodySource;
        private final String contentLength;
        private final String contentType;
        final Snapshot snapshot;

        CacheResponseBody(final Snapshot snapshot, String str, String str2) {
            this.snapshot = snapshot;
            this.contentType = str;
            this.contentLength = str2;
            this.bodySource = C5870l.m24720a(new C7206h(snapshot.getSource(1)) {
                public void close() {
                    snapshot.close();
                    super.close();
                }
            });
        }

        public MediaType contentType() {
            return this.contentType != null ? MediaType.parse(this.contentType) : null;
        }

        public long contentLength() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = -1;
            r2 = r4.contentLength;	 Catch:{ NumberFormatException -> 0x000e }
            if (r2 == 0) goto L_0x000d;	 Catch:{ NumberFormatException -> 0x000e }
        L_0x0006:
            r2 = r4.contentLength;	 Catch:{ NumberFormatException -> 0x000e }
            r2 = java.lang.Long.parseLong(r2);	 Catch:{ NumberFormatException -> 0x000e }
            r0 = r2;
        L_0x000d:
            return r0;
        L_0x000e:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.CacheResponseBody.contentLength():long");
        }

        public C7204e source() {
            return this.bodySource;
        }
    }

    public Cache(File file, long j) {
        this(file, j, FileSystem.SYSTEM);
    }

    Cache(File file, long j, FileSystem fileSystem) {
        this.internalCache = new C76491();
        this.cache = DiskLruCache.create(fileSystem, file, VERSION, 2, j);
    }

    public static String key(HttpUrl httpUrl) {
        return C5869f.m24697a(httpUrl.toString()).mo5104c().mo5108f();
    }

    okhttp3.Response get(okhttp3.Request r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r5.url();
        r0 = key(r0);
        r1 = 0;
        r2 = r4.cache;	 Catch:{ IOException -> 0x0033 }
        r0 = r2.get(r0);	 Catch:{ IOException -> 0x0033 }
        if (r0 != 0) goto L_0x0012;
    L_0x0011:
        return r1;
    L_0x0012:
        r2 = new okhttp3.Cache$Entry;	 Catch:{ IOException -> 0x002f }
        r3 = 0;	 Catch:{ IOException -> 0x002f }
        r3 = r0.getSource(r3);	 Catch:{ IOException -> 0x002f }
        r2.<init>(r3);	 Catch:{ IOException -> 0x002f }
        r0 = r2.response(r0);
        r5 = r2.matches(r5, r0);
        if (r5 != 0) goto L_0x002e;
    L_0x0026:
        r5 = r0.body();
        okhttp3.internal.Util.closeQuietly(r5);
        return r1;
    L_0x002e:
        return r0;
    L_0x002f:
        okhttp3.internal.Util.closeQuietly(r0);
        return r1;
    L_0x0033:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.get(okhttp3.Request):okhttp3.Response");
    }

    okhttp3.internal.cache.CacheRequest put(okhttp3.Response r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r4.request();
        r0 = r0.method();
        r1 = r4.request();
        r1 = r1.method();
        r1 = okhttp3.internal.http.HttpMethod.invalidatesCache(r1);
        r2 = 0;
        if (r1 == 0) goto L_0x001f;
    L_0x0017:
        r4 = r4.request();	 Catch:{ IOException -> 0x001e }
        r3.remove(r4);	 Catch:{ IOException -> 0x001e }
    L_0x001e:
        return r2;
    L_0x001f:
        r1 = "GET";
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x0028;
    L_0x0027:
        return r2;
    L_0x0028:
        r0 = okhttp3.internal.http.HttpHeaders.hasVaryAll(r4);
        if (r0 == 0) goto L_0x002f;
    L_0x002e:
        return r2;
    L_0x002f:
        r0 = new okhttp3.Cache$Entry;
        r0.<init>(r4);
        r1 = r3.cache;	 Catch:{ IOException -> 0x0052 }
        r4 = r4.request();	 Catch:{ IOException -> 0x0052 }
        r4 = r4.url();	 Catch:{ IOException -> 0x0052 }
        r4 = key(r4);	 Catch:{ IOException -> 0x0052 }
        r4 = r1.edit(r4);	 Catch:{ IOException -> 0x0052 }
        if (r4 != 0) goto L_0x0049;
    L_0x0048:
        return r2;
    L_0x0049:
        r0.writeTo(r4);	 Catch:{ IOException -> 0x0053 }
        r0 = new okhttp3.Cache$CacheRequestImpl;	 Catch:{ IOException -> 0x0053 }
        r0.<init>(r4);	 Catch:{ IOException -> 0x0053 }
        return r0;
    L_0x0052:
        r4 = r2;
    L_0x0053:
        r3.abortQuietly(r4);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.put(okhttp3.Response):okhttp3.internal.cache.CacheRequest");
    }

    void remove(Request request) {
        this.cache.remove(key(request.url()));
    }

    void update(okhttp3.Response r2, okhttp3.Response r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = new okhttp3.Cache$Entry;
        r0.<init>(r3);
        r2 = r2.body();
        r2 = (okhttp3.Cache.CacheResponseBody) r2;
        r2 = r2.snapshot;
        r2 = r2.edit();	 Catch:{ IOException -> 0x001a }
        if (r2 == 0) goto L_0x001e;
    L_0x0013:
        r0.writeTo(r2);	 Catch:{ IOException -> 0x001b }
        r2.commit();	 Catch:{ IOException -> 0x001b }
        goto L_0x001e;
    L_0x001a:
        r2 = 0;
    L_0x001b:
        r1.abortQuietly(r2);
    L_0x001e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.update(okhttp3.Response, okhttp3.Response):void");
    }

    private void abortQuietly(okhttp3.internal.cache.DiskLruCache.Editor r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        if (r1 == 0) goto L_0x0005;
    L_0x0002:
        r1.abort();	 Catch:{ IOException -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.abortQuietly(okhttp3.internal.cache.DiskLruCache$Editor):void");
    }

    public void initialize() {
        this.cache.initialize();
    }

    public void delete() {
        this.cache.delete();
    }

    public void evictAll() {
        this.cache.evictAll();
    }

    public Iterator<String> urls() {
        return new C66122();
    }

    public synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    public long size() {
        return this.cache.size();
    }

    public long maxSize() {
        return this.cache.getMaxSize();
    }

    public void flush() {
        this.cache.flush();
    }

    public void close() {
        this.cache.close();
    }

    public File directory() {
        return this.cache.getDirectory();
    }

    public boolean isClosed() {
        return this.cache.isClosed();
    }

    synchronized void trackResponse(CacheStrategy cacheStrategy) {
        this.requestCount++;
        if (cacheStrategy.networkRequest != null) {
            this.networkCount++;
        } else if (cacheStrategy.cacheResponse != null) {
            this.hitCount++;
        }
    }

    synchronized void trackConditionalCacheHit() {
        this.hitCount++;
    }

    public synchronized int networkCount() {
        return this.networkCount;
    }

    public synchronized int hitCount() {
        return this.hitCount;
    }

    public synchronized int requestCount() {
        return this.requestCount;
    }

    static int readInt(C7204e c7204e) {
        try {
            long n = c7204e.mo6315n();
            c7204e = c7204e.mo6318r();
            if (n >= 0 && n <= 2147483647L && c7204e.isEmpty()) {
                return (int) n;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("expected an int but was \"");
            stringBuilder.append(n);
            stringBuilder.append(c7204e);
            stringBuilder.append("\"");
            throw new IOException(stringBuilder.toString());
        } catch (C7204e c7204e2) {
            throw new IOException(c7204e2.getMessage());
        }
    }
}
