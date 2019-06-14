package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import java.util.Iterator;
import org.json.JSONObject;

class FacebookSDKJSInterface {
    private static final String PARAMETER_FBSDK_PIXEL_REFERRAL = "_fb_pixel_referral_id";
    private static final String PROTOCOL = "fbmq-0.1";
    public static final String TAG = "FacebookSDKJSInterface";
    private Context context;

    @JavascriptInterface
    public String getProtocol() {
        return PROTOCOL;
    }

    public FacebookSDKJSInterface(Context context) {
        this.context = context;
    }

    private static Bundle jsonToBundle(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            bundle.putString(str, jSONObject.getString(str));
        }
        return bundle;
    }

    private static android.os.Bundle jsonStringToBundle(java.lang.String r1) {
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
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x000a }
        r0.<init>(r1);	 Catch:{ JSONException -> 0x000a }
        r1 = jsonToBundle(r0);	 Catch:{ JSONException -> 0x000a }
        return r1;
    L_0x000a:
        r1 = new android.os.Bundle;
        r1.<init>();
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.FacebookSDKJSInterface.jsonStringToBundle(java.lang.String):android.os.Bundle");
    }

    @JavascriptInterface
    public void sendEvent(String str, String str2, String str3) {
        if (str == null) {
            Logger.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "Can't bridge an event without a referral Pixel ID. Check your webview Pixel configuration");
            return;
        }
        AppEventsLogger newLogger = AppEventsLogger.newLogger(this.context);
        Bundle jsonStringToBundle = jsonStringToBundle(str3);
        jsonStringToBundle.putString(PARAMETER_FBSDK_PIXEL_REFERRAL, str);
        newLogger.logEvent(str2, jsonStringToBundle);
    }
}
