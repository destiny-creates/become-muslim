package versioned.host.exp.exponent.modules.api;

import android.app.Activity;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class ScreenOrientationModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private Integer mInitialOrientation = null;

    public String getName() {
        return "ExponentScreenOrientation";
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
    }

    public ScreenOrientationModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addLifecycleEventListener(this);
    }

    public void onHostResume() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null && this.mInitialOrientation == null) {
            this.mInitialOrientation = Integer.valueOf(currentActivity.getRequestedOrientation());
        }
    }

    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null && this.mInitialOrientation != null) {
            currentActivity.setRequestedOrientation(this.mInitialOrientation.intValue());
        }
    }

    @ReactMethod
    public void allowAsync(String str, Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.setRequestedOrientation(convertToOrientationEnum(str));
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void doesSupportAsync(String str, Promise promise) {
        try {
            convertToOrientationEnum(str);
            promise.resolve(Boolean.valueOf(true));
        } catch (String str2) {
            promise.reject(str2);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int convertToOrientationEnum(java.lang.String r7) {
        /*
        r6 = this;
        r0 = r7.hashCode();
        r1 = 0;
        r2 = 6;
        r3 = 1;
        r4 = 7;
        r5 = 4;
        switch(r0) {
            case -2100659533: goto L_0x0053;
            case -490317377: goto L_0x0049;
            case -420432085: goto L_0x003f;
            case -142831784: goto L_0x0035;
            case -77725029: goto L_0x002b;
            case 64897: goto L_0x0021;
            case 1250898630: goto L_0x0017;
            case 1511893915: goto L_0x000d;
            default: goto L_0x000c;
        };
    L_0x000c:
        goto L_0x005d;
    L_0x000d:
        r0 = "PORTRAIT";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x005d;
    L_0x0015:
        r0 = 2;
        goto L_0x005e;
    L_0x0017:
        r0 = "PORTRAIT_DOWN";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x005d;
    L_0x001f:
        r0 = 4;
        goto L_0x005e;
    L_0x0021:
        r0 = "ALL";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x005d;
    L_0x0029:
        r0 = 0;
        goto L_0x005e;
    L_0x002b:
        r0 = "LANDSCAPE";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x005d;
    L_0x0033:
        r0 = 5;
        goto L_0x005e;
    L_0x0035:
        r0 = "LANDSCAPE_RIGHT";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x005d;
    L_0x003d:
        r0 = 7;
        goto L_0x005e;
    L_0x003f:
        r0 = "LANDSCAPE_LEFT";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x005d;
    L_0x0047:
        r0 = 6;
        goto L_0x005e;
    L_0x0049:
        r0 = "PORTRAIT_UP";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x005d;
    L_0x0051:
        r0 = 3;
        goto L_0x005e;
    L_0x0053:
        r0 = "ALL_BUT_UPSIDE_DOWN";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x005d;
    L_0x005b:
        r0 = 1;
        goto L_0x005e;
    L_0x005d:
        r0 = -1;
    L_0x005e:
        switch(r0) {
            case 0: goto L_0x0083;
            case 1: goto L_0x0082;
            case 2: goto L_0x0081;
            case 3: goto L_0x0080;
            case 4: goto L_0x007d;
            case 5: goto L_0x007c;
            case 6: goto L_0x007b;
            case 7: goto L_0x0078;
            default: goto L_0x0061;
        };
    L_0x0061:
        r0 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Invalid screen orientation ";
        r1.append(r2);
        r1.append(r7);
        r7 = r1.toString();
        r0.<init>(r7);
        throw r0;
    L_0x0078:
        r7 = 8;
        return r7;
    L_0x007b:
        return r1;
    L_0x007c:
        return r2;
    L_0x007d:
        r7 = 9;
        return r7;
    L_0x0080:
        return r3;
    L_0x0081:
        return r4;
    L_0x0082:
        return r5;
    L_0x0083:
        r7 = 10;
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.ScreenOrientationModule.convertToOrientationEnum(java.lang.String):int");
    }
}
