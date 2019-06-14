package versioned.host.exp.exponent.modules.api.notifications;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.iid.C3060a;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.iid.FirebaseInstanceId;
import host.exp.exponent.C6301d;
import host.exp.exponent.C6369g;
import host.exp.exponent.notifications.C6398e;
import host.exp.exponent.notifications.C6400g;
import host.exp.exponent.notifications.C6405i;
import host.exp.exponent.notifications.C6405i.C6403a;
import host.exp.exponent.notifications.C6405i.C6404b;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p343g.C6368f;
import host.exp.exponent.p344h.C6373d;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.inject.C6562a;
import org.json.JSONException;
import org.json.JSONObject;

public class NotificationsModule extends ReactContextBaseJavaModule {
    private static final String TAG = "NotificationsModule";
    @C6562a
    C6369g mExponentManifest;
    @C6562a
    C6368f mExponentNetwork;
    @C6562a
    C6373d mExponentSharedPreferences;
    private final JSONObject mManifest;

    public String getName() {
        return "ExponentNotifications";
    }

    public NotificationsModule(ReactApplicationContext reactApplicationContext, JSONObject jSONObject, Map<String, Object> map) {
        super(reactApplicationContext);
        C6294a.m25957a().m25961b(NotificationsModule.class, this);
        this.mManifest = jSONObject;
    }

    @ReactMethod
    public void createCategoryAsync(String str, ReadableArray readableArray, Promise promise) {
        str = getScopedIdIfNotDetached(str);
        List arrayList = new ArrayList();
        readableArray = readableArray.toArrayList().iterator();
        while (readableArray.hasNext()) {
            Object next = readableArray.next();
            if (next instanceof Map) {
                arrayList.add((Map) next);
            }
        }
        C6400g.m26286a(str, arrayList);
        promise.resolve(null);
    }

    @ReactMethod
    public void deleteCategoryAsync(String str, Promise promise) {
        C6400g.m26284a(getScopedIdIfNotDetached(str));
        promise.resolve(null);
    }

    private String getScopedIdIfNotDetached(String str) {
        if (!C6301d.m26001a()) {
            try {
                String string = this.mManifest.getString("id");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(":");
                stringBuilder.append(str);
                return stringBuilder.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    @ReactMethod
    public void getDevicePushTokenAsync(ReadableMap readableMap, Promise promise) {
        if (!C6301d.m26001a()) {
            promise.reject("getDevicePushTokenAsync is only accessible within standalone applications");
        }
        try {
            WritableMap createMap;
            if (C6301d.f20507m) {
                readableMap = FirebaseInstanceId.m22665a().m22687e();
                if (readableMap == null) {
                    promise.reject("FCM token has not been set");
                    return;
                }
                createMap = Arguments.createMap();
                createMap.putString("type", AppMeasurement.FCM_ORIGIN);
                createMap.putString("data", readableMap);
                promise.resolve(createMap);
                return;
            }
            C3060a c = C3060a.c(getReactApplicationContext());
            readableMap = readableMap.getString("gcmSenderId");
            if (readableMap == null || readableMap.length() == 0) {
                throw new InvalidParameterException("GCM Sender ID is null/empty");
            }
            readableMap = c.a(readableMap, "GCM", null);
            if (readableMap == null) {
                promise.reject("GCM token has not been set");
                return;
            }
            createMap = Arguments.createMap();
            createMap.putString("type", "gcm");
            createMap.putString("data", readableMap);
            promise.resolve(createMap);
        } catch (ReadableMap readableMap2) {
            C6289b.m25953c(TAG, readableMap2.getMessage());
            promise.reject(readableMap2.getMessage());
        }
    }

    @ReactMethod
    public void getExponentPushTokenAsync(final Promise promise) {
        String d = this.mExponentSharedPreferences.m26162d();
        if (d == null) {
            promise.reject("Couldn't get GCM token on device.");
            return;
        }
        try {
            C6405i.m26295a(d, this.mManifest.getString("id"), this.mExponentNetwork, this.mExponentSharedPreferences, new C6404b() {
                public void onSuccess(String str) {
                    promise.resolve(str);
                }

                public void onFailure(Exception exception) {
                    promise.reject("E_GET_GCM_TOKEN_FAILED", "Couldn't get GCM token for device", exception);
                }
            });
        } catch (Throwable e) {
            promise.reject("E_GET_GCM_TOKEN_FAILED", "Couldn't get GCM token for device", e);
        }
    }

    @com.facebook.react.bridge.ReactMethod
    public void createChannel(java.lang.String r4, com.facebook.react.bridge.ReadableMap r5, com.facebook.react.bridge.Promise r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.mManifest;	 Catch:{ Exception -> 0x0037 }
        r1 = "id";	 Catch:{ Exception -> 0x0037 }
        r0 = r0.getString(r1);	 Catch:{ Exception -> 0x0037 }
        r1 = "name";
        r1 = r5.hasKey(r1);
        if (r1 == 0) goto L_0x002f;
    L_0x0010:
        r1 = "name";
        r1 = r5.getString(r1);
        r2 = r3.getReactApplicationContext();	 Catch:{ Exception -> 0x0026 }
        r5 = r5.toHashMap();	 Catch:{ Exception -> 0x0026 }
        host.exp.exponent.notifications.C6405i.m26292a(r2, r0, r4, r1, r5);	 Catch:{ Exception -> 0x0026 }
        r4 = 0;	 Catch:{ Exception -> 0x0026 }
        r6.resolve(r4);	 Catch:{ Exception -> 0x0026 }
        goto L_0x002e;
    L_0x0026:
        r4 = move-exception;
        r5 = "E_FAILED_CREATING_CHANNEL";
        r0 = "Could not create channel";
        r6.reject(r5, r0, r4);
    L_0x002e:
        return;
    L_0x002f:
        r4 = "E_FAILED_CREATING_CHANNEL";
        r5 = "Requires channel name";
        r6.reject(r4, r5);
        return;
    L_0x0037:
        r4 = "E_FAILED_CREATING_CHANNEL";
        r5 = "Requires Experience ID";
        r6.reject(r4, r5);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.notifications.NotificationsModule.createChannel(java.lang.String, com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.Promise):void");
    }

    @com.facebook.react.bridge.ReactMethod
    public void deleteChannel(java.lang.String r3, com.facebook.react.bridge.Promise r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mManifest;	 Catch:{ Exception -> 0x001d }
        r1 = "id";	 Catch:{ Exception -> 0x001d }
        r0 = r0.getString(r1);	 Catch:{ Exception -> 0x001d }
        r1 = r2.getReactApplicationContext();	 Catch:{ Exception -> 0x0014 }
        host.exp.exponent.notifications.C6405i.m26290a(r1, r0, r3);	 Catch:{ Exception -> 0x0014 }
        r3 = 0;	 Catch:{ Exception -> 0x0014 }
        r4.resolve(r3);	 Catch:{ Exception -> 0x0014 }
        goto L_0x001c;
    L_0x0014:
        r3 = move-exception;
        r0 = "E_FAILED_DELETING_CHANNEL";
        r1 = "Could not delete channel";
        r4.reject(r0, r1, r3);
    L_0x001c:
        return;
    L_0x001d:
        r3 = "E_FAILED_DELETING_CHANNEL";
        r0 = "Requires Experience ID";
        r4.reject(r3, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.notifications.NotificationsModule.deleteChannel(java.lang.String, com.facebook.react.bridge.Promise):void");
    }

    @ReactMethod
    public void presentLocalNotification(ReadableMap readableMap, Promise promise) {
        presentLocalNotificationWithChannel(readableMap, null, promise);
    }

    @com.facebook.react.bridge.ReactMethod
    public void presentLocalNotificationWithChannel(com.facebook.react.bridge.ReadableMap r5, com.facebook.react.bridge.ReadableMap r6, final com.facebook.react.bridge.Promise r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = r5.toHashMap();
        r2 = "categoryId";
        r2 = r5.hasKey(r2);
        if (r2 == 0) goto L_0x0020;
    L_0x0011:
        r2 = "categoryId";
        r3 = "categoryId";
        r3 = r5.getString(r3);
        r3 = r4.getScopedIdIfNotDetached(r3);
        r1.put(r2, r3);
    L_0x0020:
        r2 = "data";
        r0.put(r2, r1);
        r1 = r4.mManifest;	 Catch:{ Exception -> 0x0067 }
        r2 = "id";	 Catch:{ Exception -> 0x0067 }
        r1 = r1.getString(r2);	 Catch:{ Exception -> 0x0067 }
        r2 = "experienceId";	 Catch:{ Exception -> 0x0067 }
        r0.put(r2, r1);	 Catch:{ Exception -> 0x0067 }
        if (r6 == 0) goto L_0x004f;
    L_0x0034:
        r2 = "channelId";
        r5 = r5.getString(r2);
        if (r5 != 0) goto L_0x0044;
    L_0x003c:
        r5 = "E_FAILED_PRESENTING_NOTIFICATION";
        r6 = "legacyChannelData was nonnull with no channelId";
        r7.reject(r5, r6);
        return;
    L_0x0044:
        r2 = r4.getReactApplicationContext();
        r6 = r6.toHashMap();
        host.exp.exponent.notifications.C6405i.m26293a(r2, r1, r5, r6);
    L_0x004f:
        r5 = new java.util.Random;
        r5.<init>();
        r5 = r5.nextInt();
        r6 = r4.getReactApplicationContext();
        r1 = r4.mExponentManifest;
        r2 = new versioned.host.exp.exponent.modules.api.notifications.NotificationsModule$2;
        r2.<init>(r7);
        host.exp.exponent.notifications.C6405i.m26288a(r6, r5, r0, r1, r2);
        return;
    L_0x0067:
        r5 = "E_FAILED_PRESENTING_NOTIFICATION";
        r6 = "Requires Experience ID";
        r7.reject(r5, r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: versioned.host.exp.exponent.modules.api.notifications.NotificationsModule.presentLocalNotificationWithChannel(com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.Promise):void");
    }

    @ReactMethod
    public void scheduleLocalNotification(ReadableMap readableMap, ReadableMap readableMap2, Promise promise) {
        scheduleLocalNotificationWithChannel(readableMap, readableMap2, null, promise);
    }

    @ReactMethod
    public void scheduleLocalNotificationWithChannel(ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, final Promise promise) {
        if (readableMap3 != null) {
            String optString = this.mManifest.optString("id", null);
            String string = readableMap.getString("channelId");
            if (string != null) {
                if (optString != null) {
                    C6405i.m26293a(getReactApplicationContext(), optString, string, readableMap3.toHashMap());
                }
            }
            promise.reject("E_FAILED_PRESENTING_NOTIFICATION", "legacyChannelData was nonnull with no channelId or no experienceId");
            return;
        }
        int nextInt = new Random().nextInt();
        HashMap toHashMap = readableMap.toHashMap();
        if (readableMap.hasKey("categoryId") != null) {
            toHashMap.put("categoryId", getScopedIdIfNotDetached(readableMap.getString("categoryId")));
        }
        C6405i.m26289a(getReactApplicationContext(), nextInt, toHashMap, readableMap2.toHashMap(), this.mManifest, new C6403a() {
            public void onSuccess(int i) {
                promise.resolve(Integer.valueOf(i));
            }

            public void onFailure(Exception exception) {
                promise.reject(exception);
            }
        });
    }

    @ReactMethod
    public void dismissNotification(int i, Promise promise) {
        try {
            new C6398e(getReactApplicationContext()).m26270a(this.mManifest.getString("id"), i);
            promise.resolve(Boolean.valueOf(1));
        } catch (int i2) {
            promise.reject(i2);
        }
    }

    @ReactMethod
    public void dismissAllNotifications(Promise promise) {
        try {
            new C6398e(getReactApplicationContext()).m26269a(this.mManifest.getString("id"));
            promise.resolve(Boolean.valueOf(true));
        } catch (Throwable e) {
            promise.reject(e);
        }
    }

    @ReactMethod
    public void cancelScheduledNotificationAsync(int i, Promise promise) {
        try {
            new C6398e(getReactApplicationContext()).m26278b(this.mManifest.getString("id"), i);
            promise.resolve(0);
        } catch (int i2) {
            promise.reject(i2);
        }
    }

    @ReactMethod
    public void cancelAllScheduledNotificationsAsync(Promise promise) {
        try {
            new C6398e(getReactApplicationContext()).m26277b(this.mManifest.getString("id"));
            promise.resolve(null);
        } catch (Throwable e) {
            promise.reject(e);
        }
    }
}
