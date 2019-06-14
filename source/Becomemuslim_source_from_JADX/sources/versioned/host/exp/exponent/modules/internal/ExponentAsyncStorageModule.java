package versioned.host.exp.exponent.modules.internal;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.modules.storage.AsyncStorageModule;
import com.facebook.stetho.common.Utf8Charset;
import java.net.URLEncoder;

public class ExponentAsyncStorageModule extends AsyncStorageModule {
    public boolean canOverrideExistingModule() {
        return true;
    }

    public static String experienceIdToDatabaseName(String str) {
        str = URLEncoder.encode(str, Utf8Charset.NAME);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RKStorage-scoped-experience-");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public ExponentAsyncStorageModule(com.facebook.react.bridge.ReactApplicationContext r2, org.json.JSONObject r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r1.<init>(r2);
        r0 = "id";	 Catch:{ JSONException -> 0x001f, UnsupportedEncodingException -> 0x0015 }
        r3 = r3.getString(r0);	 Catch:{ JSONException -> 0x001f, UnsupportedEncodingException -> 0x0015 }
        r3 = experienceIdToDatabaseName(r3);	 Catch:{ JSONException -> 0x001f, UnsupportedEncodingException -> 0x0015 }
        r0 = new com.facebook.react.modules.storage.ReactDatabaseSupplier;	 Catch:{ JSONException -> 0x001f, UnsupportedEncodingException -> 0x0015 }
        r0.<init>(r2, r3);	 Catch:{ JSONException -> 0x001f, UnsupportedEncodingException -> 0x0015 }
        r1.mReactDatabaseSupplier = r0;	 Catch:{ JSONException -> 0x001f, UnsupportedEncodingException -> 0x0015 }
        goto L_0x0028;
    L_0x0015:
        r2 = host.exp.exponent.p339f.C6355n.m26073a();
        r3 = "Couldn't URL encode Experience Id";
        r2.mo5408a(r3);
        goto L_0x0028;
    L_0x001f:
        r2 = host.exp.exponent.p339f.C6355n.m26073a();
        r3 = "Requires Experience Id";
        r2.mo5408a(r3);
    L_0x0028:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.internal.ExponentAsyncStorageModule.<init>(com.facebook.react.bridge.ReactApplicationContext, org.json.JSONObject):void");
    }

    @ReactMethod
    public void multiGet(ReadableArray readableArray, Callback callback) {
        super.multiGet(readableArray, callback);
    }

    @ReactMethod
    public void multiSet(ReadableArray readableArray, Callback callback) {
        super.multiSet(readableArray, callback);
    }

    @ReactMethod
    public void multiRemove(ReadableArray readableArray, Callback callback) {
        super.multiRemove(readableArray, callback);
    }

    @ReactMethod
    public void multiMerge(ReadableArray readableArray, Callback callback) {
        super.multiMerge(readableArray, callback);
    }

    @ReactMethod
    public void clear(Callback callback) {
        super.clear(callback);
    }

    @ReactMethod
    public void getAllKeys(Callback callback) {
        super.getAllKeys(callback);
    }
}
