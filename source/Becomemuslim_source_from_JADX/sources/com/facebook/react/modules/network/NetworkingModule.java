package com.facebook.react.modules.network;

import android.net.Uri;
import android.util.Base64;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.network.OkHttpCallUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import expolib_v1.p321a.C6216e;
import expolib_v1.p321a.C6217f;
import expolib_v1.p321a.C6229m;
import expolib_v1.p321a.C6234q;
import expolib_v1.p321a.C6234q.C6233a;
import expolib_v1.p321a.C6239s;
import expolib_v1.p321a.C6239s.C6238a;
import expolib_v1.p321a.C6240u;
import expolib_v1.p321a.C6246z.C6245a;
import expolib_v1.p321a.C7487t;
import expolib_v1.p321a.C7488v.C6241a;
import expolib_v1.p321a.C7490w;
import expolib_v1.p321a.C7490w.C6243a;
import expolib_v1.p321a.aa;
import expolib_v1.p321a.ab;
import expolib_v1.p321a.ac;
import expolib_v1.p332b.C6251f;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import versioned.host.exp.exponent.modules.api.viewshot.ViewShot.Results;

@ReactModule(name = "Networking")
public class NetworkingModule extends ReactContextBaseJavaModule {
    public static int CHUNK_TIMEOUT_NS = 100000000;
    public static String CONTENT_ENCODING_HEADER_NAME = "content-encoding";
    public static String CONTENT_TYPE_HEADER_NAME = "content-type";
    public static int MAX_CHUNK_SIZE_BETWEEN_FLUSHES = 8192;
    public static final String NAME = "Networking";
    public static String REQUEST_BODY_KEY_BASE64 = "base64";
    public static String REQUEST_BODY_KEY_FORMDATA = "formData";
    public static String REQUEST_BODY_KEY_STRING = "string";
    public static String REQUEST_BODY_KEY_URI = "uri";
    public static String USER_AGENT_HEADER_NAME = "user-agent";
    public final C7490w mClient;
    public final ForwardingCookieHandler mCookieHandler;
    public final CookieJarContainer mCookieJarContainer;
    public final String mDefaultUserAgent;
    public final List<RequestBodyHandler> mRequestBodyHandlers;
    public final Set<Integer> mRequestIds;
    public final List<ResponseHandler> mResponseHandlers;
    public boolean mShuttingDown;
    public final List<UriHandler> mUriHandlers;

    public interface RequestBodyHandler {
        boolean supports(ReadableMap readableMap);

        aa toRequestBody(ReadableMap readableMap, String str);
    }

    public interface ResponseHandler {
        boolean supports(String str);

        WritableMap toResponseData(ac acVar);
    }

    public interface UriHandler {
        WritableMap fetch(Uri uri);

        boolean supports(Uri uri, String str);
    }

    public String getName() {
        return NAME;
    }

    NetworkingModule(ReactApplicationContext reactApplicationContext, String str, C7490w c7490w, List<NetworkInterceptorCreator> list) {
        super(reactApplicationContext);
        this.mRequestBodyHandlers = new ArrayList();
        this.mUriHandlers = new ArrayList();
        this.mResponseHandlers = new ArrayList();
        if (list != null) {
            c7490w = c7490w.y();
            for (NetworkInterceptorCreator create : list) {
                c7490w.b(create.create());
            }
            c7490w = c7490w.a();
        }
        this.mClient = c7490w;
        this.mCookieHandler = new ForwardingCookieHandler(reactApplicationContext);
        this.mCookieJarContainer = (CookieJarContainer) this.mClient.g();
        this.mShuttingDown = null;
        this.mDefaultUserAgent = str;
        this.mRequestIds = new HashSet();
    }

    NetworkingModule(ReactApplicationContext reactApplicationContext, String str, C7490w c7490w) {
        this(reactApplicationContext, str, c7490w, null);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, null, OkHttpClientProvider.createClient(), null);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, List<NetworkInterceptorCreator> list) {
        this(reactApplicationContext, null, OkHttpClientProvider.createClient(), list);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, String str) {
        this(reactApplicationContext, str, OkHttpClientProvider.createClient(), null);
    }

    public void initialize() {
        this.mCookieJarContainer.setCookieJar(new C7487t(this.mCookieHandler));
    }

    public void onCatalystInstanceDestroy() {
        this.mShuttingDown = true;
        cancelAllRequests();
        this.mCookieHandler.destroy();
        this.mCookieJarContainer.removeCookieJar();
        this.mRequestBodyHandlers.clear();
        this.mResponseHandlers.clear();
        this.mUriHandlers.clear();
    }

    public void addUriHandler(UriHandler uriHandler) {
        this.mUriHandlers.add(uriHandler);
    }

    public void addRequestBodyHandler(RequestBodyHandler requestBodyHandler) {
        this.mRequestBodyHandlers.add(requestBodyHandler);
    }

    public void addResponseHandler(ResponseHandler responseHandler) {
        this.mResponseHandlers.add(responseHandler);
    }

    public void removeUriHandler(UriHandler uriHandler) {
        this.mUriHandlers.remove(uriHandler);
    }

    public void removeRequestBodyHandler(RequestBodyHandler requestBodyHandler) {
        this.mRequestBodyHandlers.remove(requestBodyHandler);
    }

    public void removeResponseHandler(ResponseHandler responseHandler) {
        this.mResponseHandlers.remove(responseHandler);
    }

    @ReactMethod
    public void sendRequest(String str, String str2, final int i, ReadableArray readableArray, ReadableMap readableMap, final String str3, boolean z, int i2, boolean z2) {
        final RCTDeviceEventEmitter eventEmitter = getEventEmitter();
        try {
            Uri parse = Uri.parse(str2);
            for (UriHandler uriHandler : this.mUriHandlers) {
                if (uriHandler.supports(parse, str3)) {
                    ResponseUtil.onDataReceived(eventEmitter, i, uriHandler.fetch(parse));
                    ResponseUtil.onRequestSuccess(eventEmitter, i);
                    return;
                }
            }
            try {
                str2 = new C6245a().a(str2);
                if (i != 0) {
                    str2.a(Integer.valueOf(i));
                }
                C6243a y = this.mClient.y();
                if (!z2) {
                    y.a(C6229m.f20280a);
                }
                if (z) {
                    y.b(new C6239s() {

                        /* renamed from: com.facebook.react.modules.network.NetworkingModule$1$1 */
                        class C38541 implements ProgressListener {
                            public long last = System.nanoTime();

                            C38541() {
                            }

                            public void onProgress(long j, long j2, boolean z) {
                                long nanoTime = System.nanoTime();
                                if ((z || NetworkingModule.shouldDispatch(nanoTime, this.last)) && !str3.equals("text")) {
                                    ResponseUtil.onDataReceivedProgress(eventEmitter, i, j, j2);
                                    this.last = nanoTime;
                                }
                            }
                        }

                        public ab intercept(C6238a c6238a) {
                            c6238a = c6238a.a(c6238a.a());
                            return c6238a.i().a(new ProgressResponseBody(c6238a.h(), new C38541())).a();
                        }
                    });
                }
                if (i2 != this.mClient.a()) {
                    y.b((long) i2, TimeUnit.MILLISECONDS);
                }
                i2 = y.a();
                readableArray = extractHeaders(readableArray, readableMap);
                if (readableArray == null) {
                    ResponseUtil.onRequestError(eventEmitter, i, "Unrecognized headers format", null);
                    return;
                }
                final int i3;
                final String str4;
                final boolean z3;
                z2 = readableArray.a(CONTENT_TYPE_HEADER_NAME);
                String a = readableArray.a(CONTENT_ENCODING_HEADER_NAME);
                str2.a(readableArray);
                if (readableMap != null) {
                    for (RequestBodyHandler requestBodyHandler : this.mRequestBodyHandlers) {
                        if (requestBodyHandler.supports(readableMap)) {
                            break;
                        }
                    }
                }
                RequestBodyHandler requestBodyHandler2 = null;
                if (readableMap != null && str.toLowerCase().equals("get") == null) {
                    if (str.toLowerCase().equals("head") == null) {
                        if (requestBodyHandler2 != null) {
                            readableArray = requestBodyHandler2.toRequestBody(readableMap, z2);
                        } else if (readableMap.hasKey(REQUEST_BODY_KEY_STRING) != null) {
                            if (z2) {
                                readableArray = readableMap.getString(REQUEST_BODY_KEY_STRING);
                                readableMap = C6240u.a(z2);
                                if (RequestBodyUtil.isGzipEncoding(a)) {
                                    readableArray = RequestBodyUtil.createGzip(readableMap, readableArray);
                                    if (readableArray == null) {
                                        ResponseUtil.onRequestError(eventEmitter, i, "Failed to gzip request body", null);
                                        return;
                                    }
                                }
                                readableArray = aa.create(readableMap, readableArray);
                            } else {
                                ResponseUtil.onRequestError(eventEmitter, i, "Payload is set but no content-type header specified", null);
                                return;
                            }
                        } else if (readableMap.hasKey(REQUEST_BODY_KEY_BASE64) != null) {
                            if (z2) {
                                readableArray = aa.create(C6240u.a(z2), C6251f.b(readableMap.getString(REQUEST_BODY_KEY_BASE64)));
                            } else {
                                ResponseUtil.onRequestError(eventEmitter, i, "Payload is set but no content-type header specified", null);
                                return;
                            }
                        } else if (readableMap.hasKey(REQUEST_BODY_KEY_URI) != null) {
                            if (z2) {
                                readableArray = readableMap.getString(REQUEST_BODY_KEY_URI);
                                readableMap = RequestBodyUtil.getFileInputStream(getReactApplicationContext(), readableArray);
                                if (readableMap == null) {
                                    str = new StringBuilder();
                                    str.append("Could not retrieve file for uri ");
                                    str.append(readableArray);
                                    ResponseUtil.onRequestError(eventEmitter, i, str.toString(), null);
                                    return;
                                }
                                readableArray = RequestBodyUtil.create(C6240u.a(z2), readableMap);
                            } else {
                                ResponseUtil.onRequestError(eventEmitter, i, "Payload is set but no content-type header specified", null);
                                return;
                            }
                        } else if (readableMap.hasKey(REQUEST_BODY_KEY_FORMDATA) != null) {
                            if (!z2) {
                                z2 = "multipart/form-data";
                            }
                            readableArray = constructMultipartBody(readableMap.getArray(REQUEST_BODY_KEY_FORMDATA), z2, i);
                            if (readableArray != null) {
                                readableArray = readableArray.a();
                            } else {
                                return;
                            }
                        } else {
                            readableArray = RequestBodyUtil.getEmptyBody(str);
                        }
                        str2.a(str, wrapRequestBodyWithProgressEmitter(readableArray, eventEmitter, i));
                        addRequest(i);
                        i3 = i;
                        str4 = str3;
                        z3 = z;
                        i2.a(str2.b()).a(new C6217f() {
                            public void onFailure(C6216e c6216e, IOException iOException) {
                                if (NetworkingModule.this.mShuttingDown == null) {
                                    NetworkingModule.this.removeRequest(i3);
                                    if (iOException.getMessage() != null) {
                                        c6216e = iOException.getMessage();
                                    } else {
                                        c6216e = new StringBuilder();
                                        c6216e.append("Error while executing request: ");
                                        c6216e.append(iOException.getClass().getSimpleName());
                                        c6216e = c6216e.toString();
                                    }
                                    ResponseUtil.onRequestError(eventEmitter, i3, c6216e, iOException);
                                }
                            }

                            public void onResponse(C6216e c6216e, ab abVar) {
                                if (NetworkingModule.this.mShuttingDown == null) {
                                    NetworkingModule.this.removeRequest(i3);
                                    ResponseUtil.onResponseReceived(eventEmitter, i3, abVar.c(), NetworkingModule.translateHeaders(abVar.g()), abVar.a().a().toString());
                                    c6216e = abVar.h();
                                    try {
                                        for (ResponseHandler responseHandler : NetworkingModule.this.mResponseHandlers) {
                                            if (responseHandler.supports(str4)) {
                                                ResponseUtil.onDataReceived(eventEmitter, i3, responseHandler.toResponseData(c6216e));
                                                ResponseUtil.onRequestSuccess(eventEmitter, i3);
                                                return;
                                            }
                                        }
                                        if (z3 && str4.equals("text")) {
                                            NetworkingModule.this.readWithProgress(eventEmitter, i3, c6216e);
                                            ResponseUtil.onRequestSuccess(eventEmitter, i3);
                                            return;
                                        }
                                        String str = "";
                                        if (str4.equals("text")) {
                                            try {
                                                str = c6216e.string();
                                            } catch (C6216e c6216e2) {
                                                if (abVar.a().b().equalsIgnoreCase("HEAD") == null) {
                                                    ResponseUtil.onRequestError(eventEmitter, i3, c6216e2.getMessage(), c6216e2);
                                                }
                                            }
                                        } else if (str4.equals(Results.BASE_64) != null) {
                                            str = Base64.encodeToString(c6216e2.bytes(), 2);
                                        }
                                        ResponseUtil.onDataReceived(eventEmitter, i3, str);
                                        ResponseUtil.onRequestSuccess(eventEmitter, i3);
                                    } catch (C6216e c6216e22) {
                                        ResponseUtil.onRequestError(eventEmitter, i3, c6216e22.getMessage(), c6216e22);
                                    }
                                }
                            }
                        });
                    }
                }
                readableArray = RequestBodyUtil.getEmptyBody(str);
                str2.a(str, wrapRequestBodyWithProgressEmitter(readableArray, eventEmitter, i));
                addRequest(i);
                i3 = i;
                str4 = str3;
                z3 = z;
                i2.a(str2.b()).a(/* anonymous class already generated */);
            } catch (String str5) {
                ResponseUtil.onRequestError(eventEmitter, i, str5.getMessage(), null);
            }
        } catch (String str52) {
            ResponseUtil.onRequestError(eventEmitter, i, str52.getMessage(), str52);
        }
    }

    private aa wrapRequestBodyWithProgressEmitter(aa aaVar, final RCTDeviceEventEmitter rCTDeviceEventEmitter, final int i) {
        return aaVar == null ? null : RequestBodyUtil.createProgressRequest(aaVar, new ProgressListener() {
            public long last = System.nanoTime();

            public void onProgress(long j, long j2, boolean z) {
                long nanoTime = System.nanoTime();
                if (z || NetworkingModule.shouldDispatch(nanoTime, this.last)) {
                    ResponseUtil.onDataSend(rCTDeviceEventEmitter, i, j, j2);
                    this.last = nanoTime;
                }
            }
        });
    }

    private void readWithProgress(com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter r15, int r16, expolib_v1.p321a.ac r17) {
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
        r14 = this;
        r0 = -1;
        r3 = r17;	 Catch:{ ClassCastException -> 0x0010 }
        r3 = (com.facebook.react.modules.network.ProgressResponseBody) r3;	 Catch:{ ClassCastException -> 0x0010 }
        r4 = r3.totalBytesRead();	 Catch:{ ClassCastException -> 0x0010 }
        r6 = r3.contentLength();	 Catch:{ ClassCastException -> 0x0011 }
        r0 = r6;
        goto L_0x0011;
    L_0x0010:
        r4 = r0;
    L_0x0011:
        r3 = r17.contentType();
        if (r3 != 0) goto L_0x001a;
    L_0x0017:
        r3 = com.facebook.react.common.StandardCharsets.UTF_8;
        goto L_0x0024;
    L_0x001a:
        r3 = r17.contentType();
        r6 = com.facebook.react.common.StandardCharsets.UTF_8;
        r3 = r3.a(r6);
    L_0x0024:
        r13 = new com.facebook.react.modules.network.ProgressiveStringDecoder;
        r13.<init>(r3);
        r2 = r17.byteStream();
        r3 = MAX_CHUNK_SIZE_BETWEEN_FLUSHES;	 Catch:{ all -> 0x0049 }
        r3 = new byte[r3];	 Catch:{ all -> 0x0049 }
    L_0x0031:
        r6 = r2.read(r3);	 Catch:{ all -> 0x0049 }
        r7 = -1;	 Catch:{ all -> 0x0049 }
        if (r6 == r7) goto L_0x0045;	 Catch:{ all -> 0x0049 }
    L_0x0038:
        r8 = r13.decodeNext(r3, r6);	 Catch:{ all -> 0x0049 }
        r6 = r15;	 Catch:{ all -> 0x0049 }
        r7 = r16;	 Catch:{ all -> 0x0049 }
        r9 = r4;	 Catch:{ all -> 0x0049 }
        r11 = r0;	 Catch:{ all -> 0x0049 }
        com.facebook.react.modules.network.ResponseUtil.onIncrementalDataReceived(r6, r7, r8, r9, r11);	 Catch:{ all -> 0x0049 }
        goto L_0x0031;
    L_0x0045:
        r2.close();
        return;
    L_0x0049:
        r0 = move-exception;
        r2.close();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.network.NetworkingModule.readWithProgress(com.facebook.react.modules.core.DeviceEventManagerModule$RCTDeviceEventEmitter, int, expolib_v1.a.ac):void");
    }

    private static boolean shouldDispatch(long j, long j2) {
        return j2 + ((long) CHUNK_TIMEOUT_NS) < j ? 1 : 0;
    }

    private synchronized void addRequest(int i) {
        this.mRequestIds.add(Integer.valueOf(i));
    }

    private synchronized void removeRequest(int i) {
        this.mRequestIds.remove(Integer.valueOf(i));
    }

    private synchronized void cancelAllRequests() {
        for (Integer intValue : this.mRequestIds) {
            cancelRequest(intValue.intValue());
        }
        this.mRequestIds.clear();
    }

    private static WritableMap translateHeaders(C6234q c6234q) {
        WritableMap createMap = Arguments.createMap();
        for (int i = 0; i < c6234q.a(); i++) {
            String a = c6234q.a(i);
            if (createMap.hasKey(a)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(createMap.getString(a));
                stringBuilder.append(", ");
                stringBuilder.append(c6234q.b(i));
                createMap.putString(a, stringBuilder.toString());
            } else {
                createMap.putString(a, c6234q.b(i));
            }
        }
        return createMap;
    }

    @ReactMethod
    public void abortRequest(int i) {
        cancelRequest(i);
        removeRequest(i);
    }

    private void cancelRequest(final int i) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            protected void doInBackgroundGuarded(Void... voidArr) {
                OkHttpCallUtil.cancelTag(NetworkingModule.this.mClient, Integer.valueOf(i));
            }
        }.execute(new Void[0]);
    }

    @ReactMethod
    public void clearCookies(Callback callback) {
        this.mCookieHandler.clearCookies(callback);
    }

    private C6241a constructMultipartBody(ReadableArray readableArray, String str, int i) {
        RCTDeviceEventEmitter eventEmitter = getEventEmitter();
        C6241a c6241a = new C6241a();
        c6241a.a(C6240u.a(str));
        str = readableArray.size();
        for (int i2 = 0; i2 < str; i2++) {
            ReadableMap map = readableArray.getMap(i2);
            C6234q extractHeaders = extractHeaders(map.getArray("headers"), null);
            if (extractHeaders == null) {
                ResponseUtil.onRequestError(eventEmitter, i, "Missing or invalid header format for FormData part.", null);
                return null;
            }
            C6240u a;
            String a2 = extractHeaders.a(CONTENT_TYPE_HEADER_NAME);
            if (a2 != null) {
                a = C6240u.a(a2);
                extractHeaders = extractHeaders.b().b(CONTENT_TYPE_HEADER_NAME).a();
            } else {
                a = null;
            }
            if (map.hasKey(REQUEST_BODY_KEY_STRING)) {
                c6241a.a(extractHeaders, aa.create(a, map.getString(REQUEST_BODY_KEY_STRING)));
            } else if (!map.hasKey(REQUEST_BODY_KEY_URI)) {
                ResponseUtil.onRequestError(eventEmitter, i, "Unrecognized FormData part.", null);
            } else if (a == null) {
                ResponseUtil.onRequestError(eventEmitter, i, "Binary FormData part needs a content-type header.", null);
                return null;
            } else {
                String string = map.getString(REQUEST_BODY_KEY_URI);
                InputStream fileInputStream = RequestBodyUtil.getFileInputStream(getReactApplicationContext(), string);
                if (fileInputStream == null) {
                    readableArray = new StringBuilder();
                    readableArray.append("Could not retrieve file for uri ");
                    readableArray.append(string);
                    ResponseUtil.onRequestError(eventEmitter, i, readableArray.toString(), null);
                    return null;
                }
                c6241a.a(extractHeaders, RequestBodyUtil.create(a, fileInputStream));
            }
        }
        return c6241a;
    }

    private C6234q extractHeaders(ReadableArray readableArray, ReadableMap readableMap) {
        if (readableArray == null) {
            return null;
        }
        C6233a c6233a = new C6233a();
        int size = readableArray.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            ReadableArray array = readableArray.getArray(i2);
            if (array != null) {
                if (array.size() == 2) {
                    String string = array.getString(0);
                    String string2 = array.getString(1);
                    if (string != null) {
                        if (string2 != null) {
                            c6233a.a(string, string2);
                            i2++;
                        }
                    }
                    return null;
                }
            }
            return null;
        }
        if (c6233a.c(USER_AGENT_HEADER_NAME) == null && this.mDefaultUserAgent != null) {
            c6233a.a(USER_AGENT_HEADER_NAME, this.mDefaultUserAgent);
        }
        if (!(readableMap == null || readableMap.hasKey(REQUEST_BODY_KEY_STRING) == null)) {
            i = 1;
        }
        if (i == 0) {
            c6233a.b(CONTENT_ENCODING_HEADER_NAME);
        }
        return c6233a.a();
    }

    private RCTDeviceEventEmitter getEventEmitter() {
        return (RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class);
    }
}
