package okhttp3.internal.cache;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.server.http.HttpHeaders;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.http.RealResponseBody;
import p286d.C5870l;
import p286d.C5875s;
import p286d.C5876t;
import p286d.C5877u;
import p286d.C7203d;
import p286d.C7204e;
import p286d.C8037c;

public final class CacheInterceptor implements Interceptor {
    final InternalCache cache;

    public CacheInterceptor(InternalCache internalCache) {
        this.cache = internalCache;
    }

    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.cache;
        if (r0 == 0) goto L_0x000f;
    L_0x0004:
        r0 = r5.cache;
        r1 = r6.request();
        r0 = r0.get(r1);
        goto L_0x0010;
    L_0x000f:
        r0 = 0;
    L_0x0010:
        r1 = java.lang.System.currentTimeMillis();
        r3 = new okhttp3.internal.cache.CacheStrategy$Factory;
        r4 = r6.request();
        r3.<init>(r1, r4, r0);
        r1 = r3.get();
        r2 = r1.networkRequest;
        r3 = r1.cacheResponse;
        r4 = r5.cache;
        if (r4 == 0) goto L_0x002e;
    L_0x0029:
        r4 = r5.cache;
        r4.trackResponse(r1);
    L_0x002e:
        if (r0 == 0) goto L_0x0039;
    L_0x0030:
        if (r3 != 0) goto L_0x0039;
    L_0x0032:
        r1 = r0.body();
        okhttp3.internal.Util.closeQuietly(r1);
    L_0x0039:
        if (r2 != 0) goto L_0x0075;
    L_0x003b:
        if (r3 != 0) goto L_0x0075;
    L_0x003d:
        r0 = new okhttp3.Response$Builder;
        r0.<init>();
        r6 = r6.request();
        r6 = r0.request(r6);
        r0 = okhttp3.Protocol.HTTP_1_1;
        r6 = r6.protocol(r0);
        r0 = 504; // 0x1f8 float:7.06E-43 double:2.49E-321;
        r6 = r6.code(r0);
        r0 = "Unsatisfiable Request (only-if-cached)";
        r6 = r6.message(r0);
        r0 = okhttp3.internal.Util.EMPTY_RESPONSE;
        r6 = r6.body(r0);
        r0 = -1;
        r6 = r6.sentRequestAtMillis(r0);
        r0 = java.lang.System.currentTimeMillis();
        r6 = r6.receivedResponseAtMillis(r0);
        r6 = r6.build();
        return r6;
    L_0x0075:
        if (r2 != 0) goto L_0x0088;
    L_0x0077:
        r6 = r3.newBuilder();
        r0 = stripBody(r3);
        r6 = r6.cacheResponse(r0);
        r6 = r6.build();
        return r6;
    L_0x0088:
        r6 = r6.proceed(r2);	 Catch:{ all -> 0x0135 }
        if (r6 != 0) goto L_0x0097;
    L_0x008e:
        if (r0 == 0) goto L_0x0097;
    L_0x0090:
        r0 = r0.body();
        okhttp3.internal.Util.closeQuietly(r0);
    L_0x0097:
        if (r3 == 0) goto L_0x00f2;
    L_0x0099:
        r0 = r6.code();
        r1 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r0 != r1) goto L_0x00eb;
    L_0x00a1:
        r0 = r3.newBuilder();
        r1 = r3.headers();
        r2 = r6.headers();
        r1 = combine(r1, r2);
        r0 = r0.headers(r1);
        r1 = r6.sentRequestAtMillis();
        r0 = r0.sentRequestAtMillis(r1);
        r1 = r6.receivedResponseAtMillis();
        r0 = r0.receivedResponseAtMillis(r1);
        r1 = stripBody(r3);
        r0 = r0.cacheResponse(r1);
        r1 = stripBody(r6);
        r0 = r0.networkResponse(r1);
        r0 = r0.build();
        r6 = r6.body();
        r6.close();
        r6 = r5.cache;
        r6.trackConditionalCacheHit();
        r6 = r5.cache;
        r6.update(r3, r0);
        return r0;
    L_0x00eb:
        r0 = r3.body();
        okhttp3.internal.Util.closeQuietly(r0);
    L_0x00f2:
        r0 = r6.newBuilder();
        r1 = stripBody(r3);
        r0 = r0.cacheResponse(r1);
        r6 = stripBody(r6);
        r6 = r0.networkResponse(r6);
        r6 = r6.build();
        r0 = r5.cache;
        if (r0 == 0) goto L_0x0134;
    L_0x010e:
        r0 = okhttp3.internal.http.HttpHeaders.hasBody(r6);
        if (r0 == 0) goto L_0x0125;
    L_0x0114:
        r0 = okhttp3.internal.cache.CacheStrategy.isCacheable(r6, r2);
        if (r0 == 0) goto L_0x0125;
    L_0x011a:
        r0 = r5.cache;
        r0 = r0.put(r6);
        r6 = r5.cacheWritingResponse(r0, r6);
        return r6;
    L_0x0125:
        r0 = r2.method();
        r0 = okhttp3.internal.http.HttpMethod.invalidatesCache(r0);
        if (r0 == 0) goto L_0x0134;
    L_0x012f:
        r0 = r5.cache;	 Catch:{ IOException -> 0x0134 }
        r0.remove(r2);	 Catch:{ IOException -> 0x0134 }
    L_0x0134:
        return r6;
    L_0x0135:
        r6 = move-exception;
        if (r0 == 0) goto L_0x013f;
    L_0x0138:
        r0 = r0.body();
        okhttp3.internal.Util.closeQuietly(r0);
    L_0x013f:
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.CacheInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    private static Response stripBody(Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body(null).build();
    }

    private Response cacheWritingResponse(final CacheRequest cacheRequest, Response response) {
        if (cacheRequest == null) {
            return response;
        }
        C5875s body = cacheRequest.body();
        if (body == null) {
            return response;
        }
        final C7204e source = response.body().source();
        final C7203d a = C5870l.m24719a(body);
        C5876t c76591 = new C5876t() {
            boolean cacheRequestClosed;

            public long read(C8037c c8037c, long j) {
                try {
                    j = source.read(c8037c, j);
                    if (j == -1) {
                        if (this.cacheRequestClosed == null) {
                            this.cacheRequestClosed = true;
                            a.close();
                        }
                        return -1;
                    }
                    c8037c.m38967a(a.mo6292b(), c8037c.m38961a() - j, j);
                    a.mo6320w();
                    return j;
                } catch (C8037c c8037c2) {
                    if (this.cacheRequestClosed == null) {
                        this.cacheRequestClosed = true;
                        cacheRequest.abort();
                    }
                    throw c8037c2;
                }
            }

            public C5877u timeout() {
                return source.timeout();
            }

            public void close() {
                if (!(this.cacheRequestClosed || Util.discard(this, 100, TimeUnit.MILLISECONDS))) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                source.close();
            }
        };
        return response.newBuilder().body(new RealResponseBody(response.header(HttpHeaders.CONTENT_TYPE), response.body().contentLength(), C5870l.m24720a(c76591))).build();
    }

    private static Headers combine(Headers headers, Headers headers2) {
        Builder builder = new Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            if (!"Warning".equalsIgnoreCase(name) || !value.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                if (isContentSpecificHeader(name) || !isEndToEnd(name) || headers2.get(name) == null) {
                    Internal.instance.addLenient(builder, name, value);
                }
            }
        }
        headers = headers2.size();
        for (int i2 = 0; i2 < headers; i2++) {
            String name2 = headers2.name(i2);
            if (!isContentSpecificHeader(name2) && isEndToEnd(name2)) {
                Internal.instance.addLenient(builder, name2, headers2.value(i2));
            }
        }
        return builder.build();
    }

    static boolean isEndToEnd(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str) != null) ? null : true;
    }

    static boolean isContentSpecificHeader(String str) {
        if (!(HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str))) {
            if (HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(str) == null) {
                return null;
            }
        }
        return true;
    }
}
