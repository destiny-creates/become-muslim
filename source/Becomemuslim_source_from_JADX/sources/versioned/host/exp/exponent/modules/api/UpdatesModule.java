package versioned.host.exp.exponent.modules.api;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.share.internal.ShareConstants;
import host.exp.exponent.C6301d;
import host.exp.exponent.C6369g;
import host.exp.exponent.C6369g.C6360b;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p339f.C6355n;
import host.exp.exponent.p344h.C6373d;
import host.exp.p333a.C6271b;
import host.exp.p333a.C6271b.C6266a;
import java.util.Map;
import javax.inject.C6562a;
import org.json.JSONObject;

public class UpdatesModule extends ReactContextBaseJavaModule {
    private static final String TAG = "UpdatesModule";
    private Map<String, Object> mExperienceProperties;
    @C6562a
    C6369g mExponentManifest;
    @C6562a
    C6373d mExponentSharedPreferences;
    private JSONObject mManifest;

    public String getName() {
        return "ExponentUpdates";
    }

    public UpdatesModule(ReactApplicationContext reactApplicationContext, Map<String, Object> map, JSONObject jSONObject) {
        super(reactApplicationContext);
        C6294a.m25957a().m25961b(UpdatesModule.class, this);
        this.mExperienceProperties = map;
        this.mManifest = jSONObject;
    }

    @ReactMethod
    public void reload() {
        C6355n.m26073a().m26070i((String) this.mExperienceProperties.get("experienceUrl"));
    }

    @ReactMethod
    public void reloadFromCache() {
        C6355n.m26073a().mo5409a((String) this.mExperienceProperties.get("experienceUrl"), true);
    }

    @ReactMethod
    public void checkForUpdateAsync(final Promise promise) {
        if (!C6301d.f20505k) {
            promise.reject("E_CHECK_UPDATE_FAILED", "Remote updates are disabled in app.json");
        } else if (C6369g.m26131b(this.mManifest)) {
            promise.reject("E_CHECK_UPDATE_FAILED", "Cannot check for updates in dev mode");
        } else {
            try {
                String str = (String) this.mExperienceProperties.get("experienceUrl");
                final String string = this.mManifest.getString("revisionId");
                this.mExponentManifest.m26142a(str, new C6360b() {
                    public void onCompleted(JSONObject jSONObject) {
                        try {
                            if (string.equals(jSONObject.getString("revisionId"))) {
                                promise.resolve(Boolean.valueOf(false));
                            } else {
                                promise.resolve(jSONObject.toString());
                            }
                        } catch (Exception e) {
                            onError(e);
                        }
                    }

                    public void onError(Exception exception) {
                        promise.reject("E_FETCH_MANIFEST_FAILED", exception);
                    }

                    public void onError(String str) {
                        promise.reject("E_FETCH_MANIFEST_FAILED", str);
                    }
                }, false);
            } catch (Throwable e) {
                promise.reject("E_CHECK_UPDATE_FAILED", e);
            }
        }
    }

    @ReactMethod
    public void fetchUpdateAsync(final Promise promise) {
        if (!C6301d.f20505k) {
            sendErrorAndReject("E_FETCH_UPDATE_FAILED", "Remote updates are disabled in app.json", promise);
        } else if (C6369g.m26131b(this.mManifest)) {
            sendErrorAndReject("E_FETCH_UPDATE_FAILED", "Cannot fetch updates in dev mode", promise);
        } else {
            String str = (String) this.mExperienceProperties.get("experienceUrl");
            final String optString = this.mManifest.optString("revisionId", "");
            this.mExponentManifest.m26141a(str, new C6360b() {
                public void onCompleted(org.json.JSONObject r4) {
                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                    /*
                    r3 = this;
                    r0 = "revisionId";	 Catch:{ Exception -> 0x0018 }
                    r0 = r4.getString(r0);	 Catch:{ Exception -> 0x0018 }
                    r1 = r1;	 Catch:{ Exception -> 0x0018 }
                    r0 = r1.equals(r0);	 Catch:{ Exception -> 0x0018 }
                    if (r0 == 0) goto L_0x0018;	 Catch:{ Exception -> 0x0018 }
                L_0x000e:
                    r0 = versioned.host.exp.exponent.modules.api.UpdatesModule.this;	 Catch:{ Exception -> 0x0018 }
                    r1 = "noUpdateAvailable";	 Catch:{ Exception -> 0x0018 }
                    r2 = r5;	 Catch:{ Exception -> 0x0018 }
                    r0.sendEventAndResolve(r1, r2);	 Catch:{ Exception -> 0x0018 }
                    return;
                L_0x0018:
                    r0 = versioned.host.exp.exponent.modules.api.UpdatesModule.this;
                    r1 = "downloadStart";
                    r2 = 0;
                    r0.sendEventToJS(r1, r2);
                    r0 = versioned.host.exp.exponent.modules.api.UpdatesModule.this;
                    r1 = r5;
                    r0.fetchJSBundleAsync(r4, r1);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.UpdatesModule.2.onCompleted(org.json.JSONObject):void");
                }

                public void onError(Exception exception) {
                    UpdatesModule.this.sendErrorAndReject("E_FETCH_MANIFEST_FAILED", "Unable to fetch updated manifest", exception, promise);
                }

                public void onError(String str) {
                    UpdatesModule.this.sendErrorAndReject("E_FETCH_MANIFEST_FAILED", "Unable to fetch updated manifest", new Exception(str), promise);
                }
            });
        }
    }

    private void fetchJSBundleAsync(final JSONObject jSONObject, final Promise promise) {
        try {
            String string = jSONObject.getString("bundleUrl");
            String string2 = jSONObject.getString("id");
            JSONObject jSONObject2 = jSONObject;
            C6271b.m25897a().m25917a(jSONObject2, string, C6271b.m25897a().m25923c(string2), jSONObject.getString("sdkVersion"), new C6266a() {
                public void onError(Exception exception) {
                    UpdatesModule.this.sendErrorAndReject("E_FETCH_BUNDLE_FAILED", "Failed to fetch new update", exception, promise);
                }

                public void onBundleLoaded(String str) {
                    str = jSONObject.toString();
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("manifestString", str);
                    UpdatesModule.this.sendEventToJS("downloadFinished", createMap);
                    promise.resolve(str);
                    UpdatesModule.this.mExponentSharedPreferences.m26151a((String) UpdatesModule.this.mExperienceProperties.get("experienceUrl"), jSONObject);
                }
            });
        } catch (JSONObject jSONObject3) {
            sendErrorAndReject("E_FETCH_BUNDLE_FAILED", "Failed to fetch new update", jSONObject3, promise);
        }
    }

    private void sendErrorAndReject(String str, String str2, Promise promise) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str2);
        sendEventToJS("error", createMap);
        promise.reject(str, str2);
    }

    private void sendErrorAndReject(String str, String str2, Throwable th, Promise promise) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str2);
        sendEventToJS("error", createMap);
        promise.reject(str, str2, th);
    }

    private void sendEventAndResolve(String str, Promise promise) {
        sendEventToJS(str, null);
        promise.resolve(null);
    }

    private void sendEventToJS(String str, WritableMap writableMap) {
        if (writableMap == null) {
            writableMap = Arguments.createMap();
        }
        writableMap.putString("type", str);
        ((RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(RCTDeviceEventEmitter.class)).emit("Exponent.nativeUpdatesEvent", writableMap);
    }
}
