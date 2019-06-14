package com.RNFetchBlob;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import com.RNFetchBlob.C0869f.C0868a;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.network.CookieJarContainer;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import com.facebook.react.modules.network.OkHttpClientProvider;
import expolib_v1.p321a.C7487t;
import expolib_v1.p321a.C7490w;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RNFetchBlob extends ReactContextBaseJavaModule {
    public static boolean ActionViewVisible = false;
    static ReactApplicationContext RCTContext;
    static LinkedBlockingQueue<Runnable> fsTaskQueue = new LinkedBlockingQueue();
    static ThreadPoolExecutor fsThreadPool = new ThreadPoolExecutor(2, 10, 5000, TimeUnit.MILLISECONDS, taskQueue);
    static HashMap<Integer, Promise> promiseTable = new HashMap();
    static LinkedBlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue();
    static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 5000, TimeUnit.MILLISECONDS, taskQueue);
    private final C7490w mClient = OkHttpClientProvider.getOkHttpClient();
    private final ForwardingCookieHandler mCookieHandler;
    private final CookieJarContainer mCookieJarContainer;

    /* renamed from: com.RNFetchBlob.RNFetchBlob$1 */
    class C33471 implements ActivityEventListener {
        /* renamed from: a */
        final /* synthetic */ RNFetchBlob f8890a;

        public void onNewIntent(Intent intent) {
        }

        C33471(RNFetchBlob rNFetchBlob) {
            this.f8890a = rNFetchBlob;
        }

        public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
            if (i == C0863c.f2414a.intValue() && i2 == -1) {
                ((Promise) RNFetchBlob.promiseTable.get(C0863c.f2414a)).resolve(intent.getData().toString());
                RNFetchBlob.promiseTable.remove(C0863c.f2414a);
            }
        }
    }

    public String getName() {
        return "RNFetchBlob";
    }

    public RNFetchBlob(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mCookieHandler = new ForwardingCookieHandler(reactApplicationContext);
        this.mCookieJarContainer = (CookieJarContainer) this.mClient.g();
        this.mCookieJarContainer.setCookieJar(new C7487t(this.mCookieHandler));
        RCTContext = reactApplicationContext;
        reactApplicationContext.addActivityEventListener(new C33471(this));
    }

    public Map<String, Object> getConstants() {
        return C0867d.m3073a(getReactApplicationContext());
    }

    @ReactMethod
    public void createFile(String str, String str2, String str3, Callback callback) {
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final Callback callback2 = callback;
        threadPool.execute(new Runnable(this) {
            /* renamed from: e */
            final /* synthetic */ RNFetchBlob f2377e;

            public void run() {
                C0867d.m3085a(str4, str5, str6, callback2);
            }
        });
    }

    @ReactMethod
    public void actionViewIntent(String str, String str2, final Promise promise) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("file://");
            stringBuilder.append(str);
            str = intent.setDataAndType(Uri.parse(stringBuilder.toString()), str2);
            str.setFlags(268435456);
            getReactApplicationContext().startActivity(str);
            ActionViewVisible = true;
            RCTContext.addLifecycleEventListener(new LifecycleEventListener(this) {
                /* renamed from: b */
                final /* synthetic */ RNFetchBlob f8892b;

                public void onHostDestroy() {
                }

                public void onHostPause() {
                }

                public void onHostResume() {
                    if (RNFetchBlob.ActionViewVisible) {
                        promise.resolve(null);
                    }
                    RNFetchBlob.RCTContext.removeLifecycleEventListener(this);
                }
            });
        } catch (String str3) {
            promise.reject(str3.getLocalizedMessage());
        }
    }

    @ReactMethod
    public void createFileASCII(final String str, final ReadableArray readableArray, final Callback callback) {
        threadPool.execute(new Runnable(this) {
            /* renamed from: d */
            final /* synthetic */ RNFetchBlob f2381d;

            public void run() {
                C0867d.m3090b(str, readableArray, callback);
            }
        });
    }

    @ReactMethod
    public void writeArrayChunk(String str, ReadableArray readableArray, Callback callback) {
        C0867d.m3078a(str, readableArray, callback);
    }

    @ReactMethod
    public void unlink(String str, Callback callback) {
        C0867d.m3089b(str, callback);
    }

    @ReactMethod
    public void mkdir(String str, Callback callback) {
        C0867d.m3092c(str, callback);
    }

    @ReactMethod
    public void exists(String str, Callback callback) {
        C0867d.m3095d(str, callback);
    }

    @ReactMethod
    public void cp(final String str, final String str2, final Callback callback) {
        threadPool.execute(new Runnable(this) {
            /* renamed from: d */
            final /* synthetic */ RNFetchBlob f2385d;

            public void run() {
                C0867d.m3091b(str, str2, callback);
            }
        });
    }

    @ReactMethod
    public void mv(String str, String str2, Callback callback) {
        C0867d.m3093c(str, str2, callback);
    }

    @ReactMethod
    public void ls(String str, Callback callback) {
        C0867d.m3098e(str, callback);
    }

    @ReactMethod
    public void writeStream(String str, String str2, boolean z, Callback callback) {
        new C0867d(getReactApplicationContext()).m3102a(str, str2, z, callback);
    }

    @ReactMethod
    public void writeChunk(String str, String str2, Callback callback) {
        C0867d.m3081a(str, str2, callback);
    }

    @ReactMethod
    public void closeStream(String str, Callback callback) {
        C0867d.m3077a(str, callback);
    }

    @ReactMethod
    public void removeSession(ReadableArray readableArray, Callback callback) {
        C0867d.m3075a(readableArray, callback);
    }

    @ReactMethod
    public void readFile(final String str, final String str2, final Promise promise) {
        threadPool.execute(new Runnable(this) {
            /* renamed from: d */
            final /* synthetic */ RNFetchBlob f2389d;

            public void run() {
                C0867d.m3082a(str, str2, promise);
            }
        });
    }

    @ReactMethod
    public void writeFileArray(String str, ReadableArray readableArray, boolean z, Promise promise) {
        final String str2 = str;
        final ReadableArray readableArray2 = readableArray;
        final boolean z2 = z;
        final Promise promise2 = promise;
        threadPool.execute(new Runnable(this) {
            /* renamed from: e */
            final /* synthetic */ RNFetchBlob f2394e;

            public void run() {
                C0867d.m3079a(str2, readableArray2, z2, promise2);
            }
        });
    }

    @ReactMethod
    public void writeFile(String str, String str2, String str3, boolean z, Promise promise) {
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final boolean z2 = z;
        final Promise promise2 = promise;
        threadPool.execute(new Runnable(this) {
            /* renamed from: f */
            final /* synthetic */ RNFetchBlob f2359f;

            public void run() {
                C0867d.m3086a(str4, str5, str6, z2, promise2);
            }
        });
    }

    @ReactMethod
    public void lstat(String str, Callback callback) {
        C0867d.m3099f(str, callback);
    }

    @ReactMethod
    public void stat(String str, Callback callback) {
        C0867d.m3100g(str, callback);
    }

    @ReactMethod
    public void scanFile(final ReadableArray readableArray, final Callback callback) {
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        threadPool.execute(new Runnable(this) {
            /* renamed from: d */
            final /* synthetic */ RNFetchBlob f2363d;

            public void run() {
                int size = readableArray.size();
                String[] strArr = new String[size];
                String[] strArr2 = new String[size];
                for (int i = 0; i < size; i++) {
                    ReadableMap map = readableArray.getMap(i);
                    if (map.hasKey("path")) {
                        strArr[i] = map.getString("path");
                        if (map.hasKey("mime")) {
                            strArr2[i] = map.getString("mime");
                        } else {
                            strArr2[i] = null;
                        }
                    }
                }
                new C0867d(reactApplicationContext).m3103a(strArr, strArr2, callback);
            }
        });
    }

    @ReactMethod
    public void readStream(String str, String str2, int i, int i2, String str3) {
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        final String str4 = str;
        final String str5 = str2;
        final int i3 = i;
        final int i4 = i2;
        final String str6 = str3;
        fsThreadPool.execute(new Runnable(this) {
            /* renamed from: g */
            final /* synthetic */ RNFetchBlob f2370g;

            public void run() {
                new C0867d(reactApplicationContext).m3101a(str4, str5, i3, i4, str6);
            }
        });
    }

    @ReactMethod
    public void cancelRequest(String str, Callback callback) {
        try {
            C0874g.m3114a(str);
            callback.invoke(null, str);
        } catch (String str2) {
            callback.invoke(str2.getLocalizedMessage(), null);
        }
    }

    @ReactMethod
    public void slice(String str, String str2, int i, int i2, Promise promise) {
        C0867d.m3080a(str, str2, i, i2, "", promise);
    }

    @ReactMethod
    public void enableProgressReport(String str, int i, int i2) {
        C0874g.f2450b.put(str, new C0869f(true, i, i2, C0868a.Download));
    }

    @ReactMethod
    public void df(final Callback callback) {
        fsThreadPool.execute(new Runnable(this) {
            /* renamed from: b */
            final /* synthetic */ RNFetchBlob f2372b;

            public void run() {
                C0867d.m3074a(callback);
            }
        });
    }

    @ReactMethod
    public void enableUploadProgressReport(String str, int i, int i2) {
        C0874g.f2451c.put(str, new C0869f(true, i, i2, C0868a.Upload));
    }

    @ReactMethod
    public void fetchBlob(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, String str4, Callback callback) {
        new C0874g(readableMap, str, str2, str3, readableMap2, str4, null, this.mClient, callback).run();
    }

    @ReactMethod
    public void fetchBlobForm(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, ReadableArray readableArray, Callback callback) {
        new C0874g(readableMap, str, str2, str3, readableMap2, null, readableArray, this.mClient, callback).run();
    }

    @ReactMethod
    public void getContentIntent(String str, Promise promise) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        if (str != null) {
            intent.setType(str);
        } else {
            intent.setType("*/*");
        }
        promiseTable.put(C0863c.f2414a, promise);
        getReactApplicationContext().startActivityForResult(intent, C0863c.f2414a.intValue(), null);
    }

    @ReactMethod
    public void addCompleteDownload(ReadableMap readableMap, Promise promise) {
        ReactApplicationContext reactApplicationContext = RCTContext;
        ReactApplicationContext reactApplicationContext2 = RCTContext;
        DownloadManager downloadManager = (DownloadManager) reactApplicationContext.getSystemService("download");
        String e = C0867d.m3097e(readableMap.getString("path"));
        if (e == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("RNFetchblob.addCompleteDownload can not resolve URI:");
            stringBuilder.append(readableMap.getString("path"));
            String stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append("RNFetchblob.addCompleteDownload can not resolve URI:");
            stringBuilder.append(e);
            promise.reject(stringBuilder2, stringBuilder.toString());
            return;
        }
        try {
            WritableMap a = C0867d.m3071a(e);
            String string = readableMap.hasKey("title") ? readableMap.getString("title") : "";
            String string2 = readableMap.hasKey("description") ? readableMap.getString("description") : "";
            String string3 = readableMap.hasKey("mime") ? readableMap.getString("mime") : null;
            long longValue = Long.valueOf(a.getString("size")).longValue();
            boolean z = readableMap.hasKey("showNotification") && readableMap.getBoolean("showNotification") != null;
            downloadManager.addCompletedDownload(string, string2, true, string3, e, longValue, z);
            promise.resolve(null);
        } catch (ReadableMap readableMap2) {
            promise.reject("RNFetchblob.addCompleteDownload failed", readableMap2.getStackTrace().toString());
        }
    }
}
