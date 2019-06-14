package com.sudoplz.reactnativeamplitudeanalytics;

import android.app.Activity;
import android.app.Application;
import com.amplitude.api.Amplitude;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import org.json.JSONObject;

public class RNAmplitudeSDK extends ReactContextBaseJavaModule {
    private Activity mActivity;
    private Application mApplication;

    /* renamed from: com.sudoplz.reactnativeamplitudeanalytics.RNAmplitudeSDK$1 */
    static /* synthetic */ class C58181 {
        /* renamed from: a */
        static final /* synthetic */ int[] f19257a = new int[ReadableType.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = com.facebook.react.bridge.ReadableType.values();
            r0 = r0.length;
            r0 = new int[r0];
            f19257a = r0;
            r0 = f19257a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = com.facebook.react.bridge.ReadableType.Map;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = f19257a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = com.facebook.react.bridge.ReadableType.String;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = f19257a;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = com.facebook.react.bridge.ReadableType.Number;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = f19257a;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = com.facebook.react.bridge.ReadableType.Boolean;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            r0 = f19257a;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = com.facebook.react.bridge.ReadableType.Array;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            r0 = f19257a;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = com.facebook.react.bridge.ReadableType.Null;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x004b }
            r2 = 6;	 Catch:{ NoSuchFieldError -> 0x004b }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x004b }
        L_0x004b:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sudoplz.reactnativeamplitudeanalytics.RNAmplitudeSDK.1.<clinit>():void");
        }
    }

    public String getName() {
        return "RNAmplitudeSDK";
    }

    public RNAmplitudeSDK(ReactApplicationContext reactApplicationContext, Application application) {
        super(reactApplicationContext);
        this.mActivity = null;
        this.mApplication = null;
        this.mActivity = getCurrentActivity();
        this.mApplication = application;
    }

    @ReactMethod
    public void initialize(String str, Boolean bool) {
        Amplitude.getInstance().initialize(getReactApplicationContext(), str).enableForegroundTracking(this.mApplication);
        Amplitude.getInstance().trackSessionEvents(bool.booleanValue());
    }

    @ReactMethod
    public void setUserId(String str) {
        Amplitude.getInstance().setUserId(str);
    }

    @com.facebook.react.bridge.ReactMethod
    public void setUserProperties(com.facebook.react.bridge.ReadableMap r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r2 = convertReadableToJsonObject(r2);	 Catch:{ JSONException -> 0x000c }
        r0 = com.amplitude.api.Amplitude.getInstance();	 Catch:{ JSONException -> 0x000c }
        r0.setUserProperties(r2);	 Catch:{ JSONException -> 0x000c }
        return;
    L_0x000c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sudoplz.reactnativeamplitudeanalytics.RNAmplitudeSDK.setUserProperties(com.facebook.react.bridge.ReadableMap):void");
    }

    @ReactMethod
    public void setOptOut(Boolean bool) {
        Amplitude.getInstance().setOptOut(bool.booleanValue());
    }

    @ReactMethod
    public void clearUserProperties() {
        Amplitude.getInstance().clearUserProperties();
    }

    @ReactMethod
    public void regenerateDeviceId() {
        Amplitude.getInstance().regenerateDeviceId();
    }

    @ReactMethod
    public void logEvent(String str) {
        Amplitude.getInstance().logEvent(str);
    }

    @com.facebook.react.bridge.ReactMethod
    public void logEventWithProps(java.lang.String r2, com.facebook.react.bridge.ReadableMap r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r3 = convertReadableToJsonObject(r3);	 Catch:{ JSONException -> 0x000c }
        r0 = com.amplitude.api.Amplitude.getInstance();	 Catch:{ JSONException -> 0x000c }
        r0.logEvent(r2, r3);	 Catch:{ JSONException -> 0x000c }
        return;
    L_0x000c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sudoplz.reactnativeamplitudeanalytics.RNAmplitudeSDK.logEventWithProps(java.lang.String, com.facebook.react.bridge.ReadableMap):void");
    }

    @ReactMethod
    public void logRevenue(String str, int i, double d) {
        Amplitude.getInstance().logRevenue(str, i, d);
    }

    public static JSONObject convertReadableToJsonObject(ReadableMap readableMap) {
        JSONObject jSONObject = new JSONObject();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            switch (C58181.f19257a[readableMap.getType(nextKey).ordinal()]) {
                case 1:
                    jSONObject.put(nextKey, convertReadableToJsonObject(readableMap.getMap(nextKey)));
                    break;
                case 2:
                    jSONObject.put(nextKey, readableMap.getString(nextKey));
                    break;
                case 3:
                    jSONObject.put(nextKey, readableMap.getDouble(nextKey));
                    break;
                case 4:
                    jSONObject.put(nextKey, readableMap.getBoolean(nextKey));
                    break;
                case 5:
                    jSONObject.put(nextKey, readableMap.getArray(nextKey));
                    break;
                case 6:
                    jSONObject.put(nextKey, null);
                    break;
                default:
                    break;
            }
        }
        return jSONObject;
    }
}
