package com.idehub.GoogleAnalyticsBridge;

import android.content.Context;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.google.android.gms.common.api.C2814k;
import com.google.android.gms.common.api.C2815l;
import com.google.android.gms.p185e.C2929a.C2928b;
import com.google.android.gms.p185e.C2934c;
import com.google.android.gms.p185e.C2937d;
import com.google.android.gms.p185e.C4391b;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class GoogleTagManagerBridge extends ReactContextBaseJavaModule {
    private final String E_CONTAINER_ALREADY_OPEN = "E_CONTAINER_ALREADY_OPEN";
    private final String E_CONTAINER_NOT_OPENED = "E_CONTAINER_NOT_OPENED";
    private final String E_FUNCTION_CALL_REGISTRATION_FAILED = "E_FUNCTION_CALL_REGISTRATION_FAILED";
    private final String E_ONGOING_OPEN_OPERATION = "E_ONGOING_OPEN_OPERATION";
    private final String E_OPEN_CONTAINER_FAILED = "E_OPEN_CONTAINER_FAILED";
    private final String E_PUSH_EVENT_FAILED = "E_PUSH_EVENT_FAILED";
    private final String FUNCTION_CALL_TAG_EVENT_PREFIX = "GTM_FUNCTION_CALL_TAG_";
    private C4391b mContainerHolder;
    private C2934c mDatalayer;
    private Boolean openOperationInProgress = Boolean.valueOf(null);

    /* renamed from: com.idehub.GoogleAnalyticsBridge.GoogleTagManagerBridge$2 */
    class C69312 implements C2928b {
        /* renamed from: a */
        final /* synthetic */ GoogleTagManagerBridge f24794a;

        C69312(GoogleTagManagerBridge googleTagManagerBridge) {
            this.f24794a = googleTagManagerBridge;
        }

        /* renamed from: a */
        public void m32535a(String str, Map<String, Object> map) {
            ((RCTDeviceEventEmitter) this.f24794a.getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit(this.f24794a.generateFunctionCallTagEventName(str), C5400b.m22947a((Map) map));
        }
    }

    public String getName() {
        return "GoogleTagManagerBridge";
    }

    public GoogleTagManagerBridge(ReactApplicationContext reactApplicationContext, C4391b c4391b) {
        super(reactApplicationContext);
        this.mContainerHolder = c4391b;
    }

    @ReactMethod
    public void openContainerWithId(final String str, final Promise promise) {
        if (this.mContainerHolder != null) {
            promise.reject("E_CONTAINER_ALREADY_OPEN", new Throwable("The container is already open."));
        } else if (this.openOperationInProgress.booleanValue()) {
            promise.reject("E_ONGOING_OPEN_OPERATION", new Throwable("Container open-operation already in progress."));
        } else {
            C2937d a = C2937d.a(getReactApplicationContext());
            this.openOperationInProgress = Boolean.valueOf(true);
            a.a(str, getDefaultContainerResourceId(str)).a(new C2815l<C4391b>(this) {
                /* renamed from: c */
                final /* synthetic */ GoogleTagManagerBridge f24793c;

                public /* synthetic */ void onResult(C2814k c2814k) {
                    m32534a((C4391b) c2814k);
                }

                /* renamed from: a */
                public void m32534a(C4391b c4391b) {
                    if (c4391b == null || !c4391b.b().d()) {
                        promise.reject("E_OPEN_CONTAINER_FAILED", new Throwable(String.format("Failed to open container. Does container with id %s exist?", new Object[]{str})));
                    } else {
                        this.f24793c.mContainerHolder = c4391b;
                        promise.resolve(Boolean.valueOf(true));
                    }
                    this.f24793c.openOperationInProgress = Boolean.valueOf(false);
                }
            }, 2000, TimeUnit.MILLISECONDS);
        }
    }

    @ReactMethod
    public void booleanForKey(String str, Promise promise) {
        if (this.mContainerHolder == null || this.mContainerHolder.c() == null) {
            promise.reject("E_CONTAINER_NOT_OPENED", new Throwable("The container has not been opened. You must call openContainerWithId(..)"));
        } else {
            promise.resolve(Boolean.valueOf(this.mContainerHolder.c().a(str)));
        }
    }

    @ReactMethod
    public void stringForKey(String str, Promise promise) {
        if (this.mContainerHolder == null || this.mContainerHolder.c() == null) {
            promise.reject("E_CONTAINER_NOT_OPENED", new Throwable("The container has not been opened. You must call openContainerWithId(..)"));
        } else {
            promise.resolve(this.mContainerHolder.c().c(str));
        }
    }

    @ReactMethod
    public void doubleForKey(String str, Promise promise) {
        if (this.mContainerHolder == null || this.mContainerHolder.c() == null) {
            promise.reject("E_CONTAINER_NOT_OPENED", new Throwable("The container has not been opened. You must call openContainerWithId(..)"));
        } else {
            promise.resolve(Double.valueOf(this.mContainerHolder.c().b(str)));
        }
    }

    @ReactMethod
    public void pushDataLayerEvent(ReadableMap readableMap, Promise promise) {
        if (this.mContainerHolder != null && isValidMapToPushEvent(readableMap)) {
            getDataLayer().a(C5399a.m22944a(readableMap));
            promise.resolve(Boolean.valueOf(true));
        } else if (this.mContainerHolder == null) {
            promise.reject("E_CONTAINER_NOT_OPENED", new Throwable("The container has not been opened. You must call openContainerWithId(..)"));
        } else {
            promise.reject("E_PUSH_EVENT_FAILED", new Throwable("Validation error, data must have a key \"event\" with valid event name"));
        }
    }

    @ReactMethod
    public void registerFunctionCallTagHandler(String str, Promise promise) {
        if (this.mContainerHolder != null && str != null) {
            this.mContainerHolder.c().a(str, new C69312(this));
            promise.resolve(Boolean.valueOf(true));
        } else if (this.mContainerHolder == null) {
            promise.reject("E_CONTAINER_NOT_OPENED", new Throwable("The container has not been opened. You must call openContainerWithId(..)"));
        } else {
            promise.reject("E_FUNCTION_CALL_REGISTRATION_FAILED", new Throwable("Function name of the tag is not provided"));
        }
    }

    @ReactMethod
    public void setVerboseLoggingEnabled(Boolean bool, Promise promise) {
        C2937d.a(getReactApplicationContext()).a(bool.booleanValue());
        promise.resolve(Boolean.valueOf(true));
    }

    private boolean isValidMapToPushEvent(ReadableMap readableMap) {
        return (readableMap == null || readableMap.getString("event") == null || readableMap.getString("event").length() <= null) ? null : true;
    }

    private C2934c getDataLayer() {
        if (this.mDatalayer == null) {
            this.mDatalayer = C2937d.a(getReactApplicationContext()).a();
        }
        return this.mDatalayer;
    }

    private String generateFunctionCallTagEventName(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GTM_FUNCTION_CALL_TAG_");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private int getDefaultContainerResourceId(String str) {
        Context applicationContext = getReactApplicationContext().getApplicationContext();
        str = applicationContext.getResources().getIdentifier(str.replaceAll("-", "_").toLowerCase(), "raw", applicationContext.getPackageName());
        return str == null ? -1 : str;
    }
}
