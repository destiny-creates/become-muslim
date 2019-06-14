package com.bugsnag;

import android.content.Context;
import com.bugsnag.android.BreadcrumbType;
import com.bugsnag.android.C1080f;
import com.bugsnag.android.C1082i;
import com.bugsnag.android.C1089j;
import com.bugsnag.android.C1091l;
import com.facebook.internal.ServerProtocol;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class BugsnagReactNative extends ReactContextBaseJavaModule {
    static final Logger logger = Logger.getLogger("bugsnag-react-native");
    private String bugsnagAndroidVersion = null;
    private String libraryVersion = null;
    private ReactContext reactContext;

    public String getName() {
        return "BugsnagReactNative";
    }

    public static ReactPackage getPackage() {
        return new C3444a();
    }

    public static C1089j start(Context context) {
        context = C1080f.m3768a(context);
        context.m3803a(false);
        return context;
    }

    public static C1089j startWithApiKey(Context context, String str) {
        context = C1080f.m3770a(context, str);
        context.m3803a((boolean) null);
        return context;
    }

    public static C1089j startWithConfiguration(Context context, C1091l c1091l) {
        c1091l.m3841c(false);
        return C1080f.m3769a(context, c1091l);
    }

    public BugsnagReactNative(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @ReactMethod
    public void startSession() {
        C1080f.m3776b();
    }

    @ReactMethod
    public void stopSession() {
        C1080f.m3778d();
    }

    @ReactMethod
    public void resumeSession() {
        C1080f.m3777c();
    }

    @ReactMethod
    public void startWithOptions(ReadableMap readableMap) {
        C1089j client = getClient(readableMap.hasKey("apiKey") ? readableMap.getString("apiKey") : null);
        this.libraryVersion = readableMap.getString(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
        this.bugsnagAndroidVersion = client.getClass().getPackage().getSpecificationVersion();
        configureRuntimeOptions(client, readableMap);
        logger.info(String.format("Initialized Bugsnag React Native %s/Android %s", new Object[]{this.libraryVersion, this.bugsnagAndroidVersion}));
    }

    @ReactMethod
    public void leaveBreadcrumb(ReadableMap readableMap) {
        C1080f.m3773a(readableMap.getString("name"), parseBreadcrumbType(readableMap.getString("type")), readStringMap(readableMap.getMap("metadata")));
    }

    @ReactMethod
    public void notify(ReadableMap readableMap, Promise promise) {
        if (!readableMap.hasKey("errorClass")) {
            logger.warning("Bugsnag could not notify: No error class");
        } else if (readableMap.hasKey("stacktrace")) {
            String string = readableMap.getString("errorClass");
            String string2 = readableMap.getString("errorMessage");
            String string3 = readableMap.getString("stacktrace");
            Logger logger = logger;
            r5 = new Object[3];
            boolean z = false;
            r5[0] = string;
            r5[1] = string2;
            r5[2] = string3;
            logger.info(String.format("Sending exception: %s - %s %s\n", r5));
            Throwable c3453c = new C3453c(string, string2, string3);
            C1082i c3452b = new C3452b(this.libraryVersion, this.bugsnagAndroidVersion, readableMap);
            Map hashMap = new HashMap();
            string3 = readableMap.getString("severity");
            String string4 = readableMap.getString("severityReason");
            hashMap.put("severity", string3);
            hashMap.put("severityReason", string4);
            if (readableMap.hasKey("blocking") && readableMap.getBoolean("blocking") != null) {
                z = true;
            }
            C1080f.m3775a(c3453c, hashMap, z, c3452b);
            if (promise != null) {
                promise.resolve(null);
            }
        } else {
            logger.warning("Bugsnag could not notify: No stacktrace");
        }
    }

    @ReactMethod
    public void setUser(ReadableMap readableMap) {
        String str = null;
        String string = readableMap.hasKey("id") ? readableMap.getString("id") : null;
        String string2 = readableMap.hasKey("email") ? readableMap.getString("email") : null;
        if (readableMap.hasKey("name")) {
            str = readableMap.getString("name");
        }
        C1080f.m3774a(string, string2, str);
    }

    @ReactMethod
    public void clearUser() {
        C1080f.m3772a();
    }

    private Map<String, String> readStringMap(ReadableMap readableMap) {
        Map<String, String> hashMap = new HashMap();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            ReadableMap map = readableMap.getMap(nextKey);
            String string = map.getString("type");
            Object obj = -1;
            int hashCode = string.hashCode();
            if (hashCode != -1034364087) {
                if (hashCode != -891985903) {
                    if (hashCode != 107868) {
                        if (hashCode == 64711720) {
                            if (string.equals("boolean")) {
                                obj = null;
                            }
                        }
                    } else if (string.equals("map")) {
                        obj = 3;
                    }
                } else if (string.equals("string")) {
                    obj = 2;
                }
            } else if (string.equals("number")) {
                obj = 1;
            }
            switch (obj) {
                case null:
                    hashMap.put(nextKey, String.valueOf(map.getBoolean("value")));
                    break;
                case 1:
                    hashMap.put(nextKey, String.valueOf(map.getDouble("value")));
                    break;
                case 2:
                    hashMap.put(nextKey, map.getString("value"));
                    break;
                case 3:
                    hashMap.put(nextKey, String.valueOf(readStringMap(map.getMap("value"))));
                    break;
                default:
                    break;
            }
        }
        return hashMap;
    }

    private com.bugsnag.android.C1089j getClient(java.lang.String r2) {
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
        r1 = this;
        r0 = com.bugsnag.android.C1080f.m3779e();	 Catch:{ IllegalStateException -> 0x0005 }
        goto L_0x0014;
    L_0x0005:
        if (r2 == 0) goto L_0x000e;
    L_0x0007:
        r0 = r1.reactContext;
        r0 = com.bugsnag.android.C1080f.m3770a(r0, r2);
        goto L_0x0014;
    L_0x000e:
        r2 = r1.reactContext;
        r0 = com.bugsnag.android.C1080f.m3768a(r2);
    L_0x0014:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.BugsnagReactNative.getClient(java.lang.String):com.bugsnag.android.j");
    }

    private BreadcrumbType parseBreadcrumbType(String str) {
        for (BreadcrumbType breadcrumbType : BreadcrumbType.values()) {
            if (breadcrumbType.toString().equals(str)) {
                return breadcrumbType;
            }
        }
        return BreadcrumbType.MANUAL;
    }

    private void configureRuntimeOptions(C1089j c1089j, ReadableMap readableMap) {
        String string;
        c1089j.m3804a("com.facebook.react.common.JavascriptException");
        C1091l o = c1089j.m3826o();
        if (readableMap.hasKey("appVersion")) {
            string = readableMap.getString("appVersion");
            if (string != null && string.length() > 0) {
                c1089j.m3796a(string);
            }
        }
        String str = null;
        string = readableMap.hasKey("endpoint") ? readableMap.getString("endpoint") : null;
        if (readableMap.hasKey("sessionsEndpoint")) {
            str = readableMap.getString("sessionsEndpoint");
        }
        if (string != null && string.length() > 0) {
            o.m3832a(string, str);
        } else if (str != null && str.length() > 0) {
            logger.warning("The session tracking endpoint should not be set without the error reporting endpoint.");
        }
        if (readableMap.hasKey("releaseStage")) {
            string = readableMap.getString("releaseStage");
            if (string != null && string.length() > 0) {
                c1089j.m3809c(string);
            }
        }
        if (readableMap.hasKey("autoNotify")) {
            if (readableMap.getBoolean("autoNotify")) {
                c1089j.m3823l();
            } else {
                c1089j.m3824m();
            }
        }
        if (readableMap.hasKey("codeBundleId")) {
            Object string2 = readableMap.getString("codeBundleId");
            if (string2 != null && string2.length() > 0) {
                c1089j.m3798a("app", "codeBundleId", string2);
            }
        }
        if (readableMap.hasKey("notifyReleaseStages")) {
            ReadableArray array = readableMap.getArray("notifyReleaseStages");
            if (array != null && array.size() > 0) {
                String[] strArr = new String[array.size()];
                for (int i = 0; i < array.size(); i++) {
                    strArr[i] = array.getString(i);
                }
                c1089j.m3807b(strArr);
            }
        }
        if (readableMap.hasKey("automaticallyCollectBreadcrumbs")) {
            o.m3848e(readableMap.getBoolean("automaticallyCollectBreadcrumbs"));
        }
        if (readableMap.hasKey("autoCaptureSessions")) {
            boolean z = readableMap.getBoolean("autoCaptureSessions");
            o.m3841c(z);
            if (z) {
                c1089j.m3814e();
            }
        }
    }
}
