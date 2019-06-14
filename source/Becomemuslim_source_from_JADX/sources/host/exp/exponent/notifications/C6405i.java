package host.exp.exponent.notifications;

import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.support.v4.app.ac.C0279d;
import android.support.v4.app.ac.C3171c;
import com.facebook.react.uimanager.ViewProps;
import host.exp.exponent.C6301d;
import host.exp.exponent.C6369g;
import host.exp.exponent.C6369g.C6359a;
import host.exp.exponent.fcm.FcmRegistrationIntentService;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p343g.C6363c;
import host.exp.exponent.p343g.C6364d;
import host.exp.exponent.p343g.C6368f;
import host.exp.exponent.p344h.C6371c;
import host.exp.exponent.p344h.C6371c.C6370a;
import host.exp.exponent.p344h.C6373d;
import host.exp.exponent.p344h.C8177a;
import host.exp.exponent.p346j.C6383a;
import host.exp.exponent.p346j.C6383a.C6382a;
import host.exp.exponent.p346j.C6384b;
import host.exp.p333a.C6279c.C6273b;
import host.exp.p333a.C6279c.C6277f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: NotificationHelper */
/* renamed from: host.exp.exponent.notifications.i */
public class C6405i {
    /* renamed from: a */
    private static String f20720a = "i";

    /* compiled from: NotificationHelper */
    /* renamed from: host.exp.exponent.notifications.i$a */
    public interface C6403a {
        void onFailure(Exception exception);

        void onSuccess(int i);
    }

    /* compiled from: NotificationHelper */
    /* renamed from: host.exp.exponent.notifications.i$b */
    public interface C6404b {
        void onFailure(Exception exception);

        void onSuccess(String str);
    }

    /* renamed from: a */
    public static int m26287a(String str, JSONObject jSONObject, C6369g c6369g) {
        JSONObject optJSONObject = jSONObject.optJSONObject("notification");
        if (str == null) {
            if (optJSONObject == null) {
                str = null;
            } else {
                str = optJSONObject.optString(ViewProps.COLOR);
            }
        }
        if (str == null || !C6384b.m26192a(str)) {
            return c6369g.m26136a(jSONObject);
        }
        return Color.parseColor(str);
    }

    /* renamed from: a */
    public static void m26296a(String str, JSONObject jSONObject, C6369g c6369g, C6359a c6359a) {
        JSONObject optJSONObject = jSONObject.optJSONObject("notification");
        if (str == null) {
            str = jSONObject.optString("iconUrl");
            if (optJSONObject != null) {
                str = optJSONObject.optString("iconUrl", null);
            }
        }
        c6369g.m26140a(str, c6359a);
    }

    /* renamed from: a */
    public static void m26295a(String str, String str2, C6368f c6368f, C6373d c6373d, C6404b c6404b) {
        if (C6301d.f20507m) {
            FcmRegistrationIntentService.m34269a(c6373d.m26149a());
        }
        final C6373d c6373d2 = c6373d;
        final C6404b c6404b2 = c6404b;
        final String str3 = str;
        final String str4 = str2;
        final C6368f c6368f2 = c6368f;
        C6383a.m26190a("devicePushToken", new C6382a() {

            /* compiled from: NotificationHelper */
            /* renamed from: host.exp.exponent.notifications.i$1$1 */
            class C75871 implements C6363c {
                /* renamed from: a */
                final /* synthetic */ C75881 f26248a;

                C75871(C75881 c75881) {
                    this.f26248a = c75881;
                }

                /* renamed from: a */
                public void mo5371a(IOException iOException) {
                    c6404b2.onFailure(iOException);
                }

                /* renamed from: a */
                public void mo5370a(C6364d c6364d) {
                    if (c6364d.mo5423a()) {
                        try {
                            c6404b2.onSuccess(new JSONObject(c6364d.mo5424b().mo5419a()).getJSONObject("data").getString("expoPushToken"));
                        } catch (C6364d c6364d2) {
                            c6404b2.onFailure(c6364d2);
                        }
                        return;
                    }
                    c6404b2.onFailure(new Exception("Couldn't get android push token for device"));
                }
            }

            /* renamed from: a */
            public boolean mo5390a() {
                if (c6373d2.m26156b(C6301d.f20507m ? "fcm_token" : "gcm_token") == null) {
                    if (!C6397d.m26262d()) {
                        return false;
                    }
                }
                return true;
            }

            /* renamed from: b */
            public void mo5391b() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r4 = this;
                r0 = r2;
                r1 = host.exp.exponent.C6301d.f20507m;
                if (r1 == 0) goto L_0x0009;
            L_0x0006:
                r1 = "fcm_token";
                goto L_0x000b;
            L_0x0009:
                r1 = "gcm_token";
            L_0x000b:
                r0 = r0.m26156b(r1);
                if (r0 == 0) goto L_0x0098;
            L_0x0011:
                r1 = r0.length();
                if (r1 != 0) goto L_0x0019;
            L_0x0017:
                goto L_0x0098;
            L_0x0019:
                r1 = new org.json.JSONObject;
                r1.<init>();
                r2 = "deviceId";	 Catch:{ JSONException -> 0x008b }
                r3 = r4;	 Catch:{ JSONException -> 0x008b }
                r1.put(r2, r3);	 Catch:{ JSONException -> 0x008b }
                r2 = "experienceId";	 Catch:{ JSONException -> 0x008b }
                r3 = r5;	 Catch:{ JSONException -> 0x008b }
                r1.put(r2, r3);	 Catch:{ JSONException -> 0x008b }
                r2 = "appId";	 Catch:{ JSONException -> 0x008b }
                r3 = r2;	 Catch:{ JSONException -> 0x008b }
                r3 = r3.m26149a();	 Catch:{ JSONException -> 0x008b }
                r3 = r3.getApplicationContext();	 Catch:{ JSONException -> 0x008b }
                r3 = r3.getPackageName();	 Catch:{ JSONException -> 0x008b }
                r1.put(r2, r3);	 Catch:{ JSONException -> 0x008b }
                r2 = "deviceToken";	 Catch:{ JSONException -> 0x008b }
                r1.put(r2, r0);	 Catch:{ JSONException -> 0x008b }
                r0 = "type";	 Catch:{ JSONException -> 0x008b }
                r2 = host.exp.exponent.C6301d.f20507m;	 Catch:{ JSONException -> 0x008b }
                if (r2 == 0) goto L_0x004d;	 Catch:{ JSONException -> 0x008b }
            L_0x004a:
                r2 = "fcm";	 Catch:{ JSONException -> 0x008b }
                goto L_0x004f;	 Catch:{ JSONException -> 0x008b }
            L_0x004d:
                r2 = "gcm";	 Catch:{ JSONException -> 0x008b }
            L_0x004f:
                r1.put(r0, r2);	 Catch:{ JSONException -> 0x008b }
                r0 = "development";	 Catch:{ JSONException -> 0x008b }
                r2 = 0;	 Catch:{ JSONException -> 0x008b }
                r1.put(r0, r2);	 Catch:{ JSONException -> 0x008b }
                r0 = "application/json; charset=utf-8";
                r0 = expolib_v1.p321a.C6240u.m25781a(r0);
                r1 = r1.toString();
                r0 = expolib_v1.p321a.aa.create(r0, r1);
                r1 = "https://exp.host/--/api/v2/push/getExpoPushToken";
                r1 = host.exp.exponent.p339f.C6339i.m26063b(r1);
                r2 = "Content-Type";
                r3 = "application/json";
                r1 = r1.m25816a(r2, r3);
                r0 = r1.m25809a(r0);
                r0 = r0.m25820b();
                r1 = r6;
                r1 = r1.m26115a();
                r2 = new host.exp.exponent.notifications.i$1$1;
                r2.<init>(r4);
                r1.m26103a(r0, r2);
                return;
            L_0x008b:
                r0 = r3;
                r1 = new java.lang.Exception;
                r2 = "Error constructing request";
                r1.<init>(r2);
                r0.onFailure(r1);
                return;
            L_0x0098:
                r0 = "No device token found.";
                r1 = host.exp.exponent.C6301d.f20507m;
                if (r1 != 0) goto L_0x00af;
            L_0x009e:
                r1 = new java.lang.StringBuilder;
                r1.<init>();
                r1.append(r0);
                r0 = " Expo support for GCM is deprecated. Follow this guide to set up FCM for your standalone app: https://docs.expo.io/versions/latest/guides/using-fcm";
                r1.append(r0);
                r0 = r1.toString();
            L_0x00af:
                r1 = r3;
                r2 = new java.lang.Exception;
                r2.<init>(r0);
                r1.onFailure(r2);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.notifications.i.1.b():void");
            }
        });
    }

    /* renamed from: a */
    public static void m26292a(Context context, String str, String str2, String str3, HashMap hashMap) {
        if (VERSION.SDK_INT >= 26) {
            Boolean bool = null;
            String str4 = hashMap.containsKey("priority") ? (String) hashMap.get("priority") : null;
            Boolean bool2 = hashMap.containsKey("sound") ? (Boolean) hashMap.get("sound") : null;
            Object obj = hashMap.containsKey("vibrate") ? hashMap.get("vibrate") : null;
            String str5 = hashMap.containsKey("description") ? (String) hashMap.get("description") : null;
            if (hashMap.containsKey("badge")) {
                bool = (Boolean) hashMap.get("badge");
            }
            C6405i.m26291a(context, str, str2, str3, str5, str4, bool2, obj, bool);
            return;
        }
        new C6398e(context).m26274a(str, str2, hashMap);
    }

    /* renamed from: a */
    public static void m26294a(Context context, String str, String str2, JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("name");
            String optString = !jSONObject.isNull("description") ? jSONObject.optString("description") : null;
            String optString2 = !jSONObject.isNull("priority") ? jSONObject.optString("priority") : null;
            Boolean valueOf = !jSONObject.isNull("sound") ? Boolean.valueOf(jSONObject.optBoolean("sound")) : null;
            Boolean valueOf2 = !jSONObject.isNull("badge") ? Boolean.valueOf(jSONObject.optBoolean("badge", true)) : null;
            JSONArray optJSONArray = jSONObject.optJSONArray("vibrate");
            int i = 0;
            if (optJSONArray != null) {
                jSONObject = new ArrayList();
                while (i < optJSONArray.length()) {
                    jSONObject.add(Double.valueOf(optJSONArray.getDouble(i)));
                    i++;
                }
            } else {
                jSONObject = Boolean.valueOf(jSONObject.optBoolean("vibrate", false));
            }
            C6405i.m26291a(context, str, str2, string, optString, optString2, valueOf, jSONObject, valueOf2);
        } catch (Context context2) {
            str = f20720a;
            str2 = new StringBuilder();
            str2.append("Could not create channel from stored JSON Object: ");
            str2.append(context2.getMessage());
            C6289b.m25953c(str, str2.toString());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static void m26291a(android.content.Context r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.Boolean r13, java.lang.Object r14, java.lang.Boolean r15) {
        /*
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 26;
        if (r0 < r1) goto L_0x00bf;
    L_0x0006:
        r0 = 0;
        r1 = 1;
        r2 = 2;
        r3 = 3;
        if (r12 == 0) goto L_0x0057;
    L_0x000c:
        r4 = -1;
        r5 = r12.hashCode();
        r6 = 107348; // 0x1a354 float:1.50427E-40 double:5.3037E-319;
        if (r5 == r6) goto L_0x0044;
    L_0x0016:
        r6 = 107876; // 0x1a564 float:1.51166E-40 double:5.3298E-319;
        if (r5 == r6) goto L_0x003a;
    L_0x001b:
        r6 = 108114; // 0x1a652 float:1.515E-40 double:5.34154E-319;
        if (r5 == r6) goto L_0x0030;
    L_0x0020:
        r6 = 3202466; // 0x30dda2 float:4.48761E-39 double:1.5822284E-317;
        if (r5 == r6) goto L_0x0026;
    L_0x0025:
        goto L_0x004d;
    L_0x0026:
        r5 = "high";
        r12 = r12.equals(r5);
        if (r12 == 0) goto L_0x004d;
    L_0x002e:
        r4 = 1;
        goto L_0x004d;
    L_0x0030:
        r5 = "min";
        r12 = r12.equals(r5);
        if (r12 == 0) goto L_0x004d;
    L_0x0038:
        r4 = 3;
        goto L_0x004d;
    L_0x003a:
        r5 = "max";
        r12 = r12.equals(r5);
        if (r12 == 0) goto L_0x004d;
    L_0x0042:
        r4 = 0;
        goto L_0x004d;
    L_0x0044:
        r5 = "low";
        r12 = r12.equals(r5);
        if (r12 == 0) goto L_0x004d;
    L_0x004c:
        r4 = 2;
    L_0x004d:
        switch(r4) {
            case 0: goto L_0x0055;
            case 1: goto L_0x0053;
            case 2: goto L_0x0051;
            case 3: goto L_0x0058;
            default: goto L_0x0050;
        };
    L_0x0050:
        goto L_0x0057;
    L_0x0051:
        r1 = 2;
        goto L_0x0058;
    L_0x0053:
        r1 = 4;
        goto L_0x0058;
    L_0x0055:
        r1 = 5;
        goto L_0x0058;
    L_0x0057:
        r1 = 3;
    L_0x0058:
        r12 = new android.app.NotificationChannel;
        r9 = host.exp.exponent.notifications.C6398e.m26267a(r8, r9);
        r12.<init>(r9, r10, r1);
        if (r13 == 0) goto L_0x0069;
    L_0x0063:
        r9 = r13.booleanValue();
        if (r9 != 0) goto L_0x006d;
    L_0x0069:
        r9 = 0;
        r12.setSound(r9, r9);
    L_0x006d:
        if (r14 == 0) goto L_0x00a9;
    L_0x006f:
        r9 = r14 instanceof java.util.ArrayList;
        if (r9 == 0) goto L_0x0095;
    L_0x0073:
        r14 = (java.util.ArrayList) r14;
        r9 = r14.size();
        r9 = new long[r9];
    L_0x007b:
        r10 = r14.size();
        if (r0 >= r10) goto L_0x0091;
    L_0x0081:
        r10 = r14.get(r0);
        r10 = (java.lang.Double) r10;
        r10 = r10.intValue();
        r1 = (long) r10;
        r9[r0] = r1;
        r0 = r0 + 1;
        goto L_0x007b;
    L_0x0091:
        r12.setVibrationPattern(r9);
        goto L_0x00a9;
    L_0x0095:
        r9 = r14 instanceof java.lang.Boolean;
        if (r9 == 0) goto L_0x00a9;
    L_0x0099:
        r14 = (java.lang.Boolean) r14;
        r9 = r14.booleanValue();
        if (r9 == 0) goto L_0x00a9;
    L_0x00a1:
        r9 = new long[r2];
        r9 = {0, 500};
        r12.setVibrationPattern(r9);
    L_0x00a9:
        if (r11 == 0) goto L_0x00ae;
    L_0x00ab:
        r12.setDescription(r11);
    L_0x00ae:
        if (r15 == 0) goto L_0x00b7;
    L_0x00b0:
        r9 = r15.booleanValue();
        r12.setShowBadge(r9);
    L_0x00b7:
        r9 = new host.exp.exponent.notifications.e;
        r9.<init>(r7);
        r9.m26273a(r8, r12);
    L_0x00bf:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.notifications.i.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Object, java.lang.Boolean):void");
    }

    /* renamed from: a */
    public static void m26293a(Context context, String str, String str2, HashMap hashMap) {
        if (new C6398e(context).m26279c(str, str2) == null && hashMap.containsKey("name")) {
            C6405i.m26292a(context, str, str2, (String) hashMap.get("name"), hashMap);
        }
    }

    /* renamed from: a */
    public static void m26290a(Context context, String str, String str2) {
        if (VERSION.SDK_INT >= 26) {
            new C6398e(context).m26280d(str, str2);
        }
    }

    /* renamed from: a */
    public static void m26288a(Context context, int i, HashMap hashMap, C6369g c6369g, C6403a c6403a) {
        String str;
        int i2;
        Context context2 = context;
        HashMap hashMap2 = hashMap;
        final C6398e c6398e = new C6398e(context);
        String str2 = (String) hashMap.get("experienceId");
        final C0279d c0279d = new C0279d(context, C6398e.m26267a(str2, "expo-default"));
        c0279d.a(C6301d.m26001a() ? C6273b.shell_notification_icon : C6273b.notification_icon);
        int i3 = 1;
        c0279d.d(true);
        final HashMap hashMap3 = (HashMap) hashMap.get("data");
        if (hashMap3.containsKey("channelId")) {
            str = (String) hashMap3.get("channelId");
            c0279d.b(C6398e.m26267a(str2, str));
            if (VERSION.SDK_INT < 26) {
                JSONObject b = c6398e.m26276b(str2, str);
                String str3;
                StringBuilder stringBuilder;
                if (b != null) {
                    Object obj;
                    JSONArray optJSONArray;
                    long[] jArr;
                    i2 = 0;
                    if (b.optBoolean("sound", false)) {
                        c0279d.c(1);
                    }
                    str = b.optString("priority");
                    int hashCode = str.hashCode();
                    if (hashCode != 107348) {
                        if (hashCode != 107876) {
                            if (hashCode != 108114) {
                                if (hashCode == 3202466) {
                                    if (str.equals("high")) {
                                        obj = 1;
                                        switch (obj) {
                                            case null:
                                                i3 = 2;
                                                break;
                                            case 1:
                                                break;
                                            case 2:
                                                i3 = -1;
                                                break;
                                            case 3:
                                                i3 = -2;
                                                break;
                                            default:
                                                i3 = 0;
                                                break;
                                        }
                                        c0279d.d(i3);
                                        optJSONArray = b.optJSONArray("vibrate");
                                        if (optJSONArray != null) {
                                            jArr = new long[optJSONArray.length()];
                                            while (i2 < optJSONArray.length()) {
                                                jArr[i2] = (long) Double.valueOf(optJSONArray.getDouble(i2)).intValue();
                                                i2++;
                                            }
                                            c0279d.a(jArr);
                                        } else if (b.optBoolean("vibrate", false)) {
                                            c0279d.a(new long[]{0, 500});
                                        }
                                    }
                                }
                            } else if (str.equals("min")) {
                                obj = 3;
                                switch (obj) {
                                    case null:
                                        i3 = 2;
                                        break;
                                    case 1:
                                        break;
                                    case 2:
                                        i3 = -1;
                                        break;
                                    case 3:
                                        i3 = -2;
                                        break;
                                    default:
                                        i3 = 0;
                                        break;
                                }
                                c0279d.d(i3);
                                optJSONArray = b.optJSONArray("vibrate");
                                if (optJSONArray != null) {
                                    jArr = new long[optJSONArray.length()];
                                    while (i2 < optJSONArray.length()) {
                                        jArr[i2] = (long) Double.valueOf(optJSONArray.getDouble(i2)).intValue();
                                        i2++;
                                    }
                                    c0279d.a(jArr);
                                } else if (b.optBoolean("vibrate", false)) {
                                    c0279d.a(new long[]{0, 500});
                                }
                            }
                        } else if (str.equals("max")) {
                            obj = null;
                            switch (obj) {
                                case null:
                                    i3 = 2;
                                    break;
                                case 1:
                                    break;
                                case 2:
                                    i3 = -1;
                                    break;
                                case 3:
                                    i3 = -2;
                                    break;
                                default:
                                    i3 = 0;
                                    break;
                            }
                            c0279d.d(i3);
                            optJSONArray = b.optJSONArray("vibrate");
                            if (optJSONArray != null) {
                                jArr = new long[optJSONArray.length()];
                                while (i2 < optJSONArray.length()) {
                                    jArr[i2] = (long) Double.valueOf(optJSONArray.getDouble(i2)).intValue();
                                    i2++;
                                }
                                c0279d.a(jArr);
                            } else if (b.optBoolean("vibrate", false)) {
                                c0279d.a(new long[]{0, 500});
                            }
                        }
                    } else if (str.equals("low")) {
                        obj = 2;
                        switch (obj) {
                            case null:
                                i3 = 2;
                                break;
                            case 1:
                                break;
                            case 2:
                                i3 = -1;
                                break;
                            case 3:
                                i3 = -2;
                                break;
                            default:
                                i3 = 0;
                                break;
                        }
                        c0279d.d(i3);
                        optJSONArray = b.optJSONArray("vibrate");
                        if (optJSONArray != null) {
                            jArr = new long[optJSONArray.length()];
                            while (i2 < optJSONArray.length()) {
                                jArr[i2] = (long) Double.valueOf(optJSONArray.getDouble(i2)).intValue();
                                i2++;
                            }
                            c0279d.a(jArr);
                        } else if (b.optBoolean("vibrate", false)) {
                            c0279d.a(new long[]{0, 500});
                        }
                    }
                    obj = -1;
                    switch (obj) {
                        case null:
                            i3 = 2;
                            break;
                        case 1:
                            break;
                        case 2:
                            i3 = -1;
                            break;
                        case 3:
                            i3 = -2;
                            break;
                        default:
                            i3 = 0;
                            break;
                    }
                    c0279d.d(i3);
                    try {
                        optJSONArray = b.optJSONArray("vibrate");
                        if (optJSONArray != null) {
                            jArr = new long[optJSONArray.length()];
                            while (i2 < optJSONArray.length()) {
                                jArr[i2] = (long) Double.valueOf(optJSONArray.getDouble(i2)).intValue();
                                i2++;
                            }
                            c0279d.a(jArr);
                        } else if (b.optBoolean("vibrate", false)) {
                            c0279d.a(new long[]{0, 500});
                        }
                    } catch (Exception e) {
                        str3 = f20720a;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Failed to set vibrate settings on notification from stored channel: ");
                        stringBuilder.append(e.getMessage());
                        C6289b.m25953c(str3, stringBuilder.toString());
                    }
                } else {
                    str3 = f20720a;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("No stored channel found for ");
                    stringBuilder.append(str2);
                    stringBuilder.append(": ");
                    stringBuilder.append(str);
                    C6289b.m25953c(str3, stringBuilder.toString());
                }
            } else if (c6398e.m26279c(str2, str) == null) {
                JSONObject b2 = c6398e.m26276b(str2, str);
                if (b2 != null) {
                    C6405i.m26294a(context, str2, str, b2);
                }
            }
        } else {
            C6405i.m26292a(context, str2, "expo-default", context.getString(C6277f.default_notification_channel_group), new HashMap());
        }
        if (hashMap3.containsKey("title")) {
            str = (String) hashMap3.get("title");
            c0279d.a(str);
            c0279d.c(str);
        }
        if (hashMap3.containsKey("body")) {
            c0279d.b((String) hashMap3.get("body"));
            c0279d.a(new C3171c().a((String) hashMap3.get("body")));
        }
        if (hashMap3.containsKey("count")) {
            c0279d.b(((Double) hashMap3.get("count")).intValue());
        }
        if (hashMap3.containsKey("sticky")) {
            c0279d.b(((Boolean) hashMap3.get("sticky")).booleanValue());
        }
        context2 = context;
        final String str4 = str2;
        i2 = i;
        final C6369g c6369g2 = c6369g;
        final C6403a c6403a2 = c6403a;
        C6371c.m26147a(str2, new C6370a() {
            /* renamed from: a */
            public void mo5432a(final C8177a c8177a) {
                new Thread(new Runnable(this) {
                    /* renamed from: b */
                    final /* synthetic */ C75912 f20719b;

                    public void run() {
                        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                        /*
                        r10 = this;
                        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0113 }
                        r1 = r3;	 Catch:{ JSONException -> 0x0113 }
                        r1 = r1.f30373d;	 Catch:{ JSONException -> 0x0113 }
                        r0.<init>(r1);	 Catch:{ JSONException -> 0x0113 }
                        r1 = r10.f20719b;	 Catch:{ JSONException -> 0x0113 }
                        r1 = r2;	 Catch:{ JSONException -> 0x0113 }
                        r2 = "link";	 Catch:{ JSONException -> 0x0113 }
                        r1 = r1.containsKey(r2);	 Catch:{ JSONException -> 0x0113 }
                        if (r1 == 0) goto L_0x002d;	 Catch:{ JSONException -> 0x0113 }
                    L_0x0015:
                        r1 = new android.content.Intent;	 Catch:{ JSONException -> 0x0113 }
                        r2 = "android.intent.action.VIEW";	 Catch:{ JSONException -> 0x0113 }
                        r3 = r10.f20719b;	 Catch:{ JSONException -> 0x0113 }
                        r3 = r2;	 Catch:{ JSONException -> 0x0113 }
                        r4 = "link";	 Catch:{ JSONException -> 0x0113 }
                        r3 = r3.get(r4);	 Catch:{ JSONException -> 0x0113 }
                        r3 = (java.lang.String) r3;	 Catch:{ JSONException -> 0x0113 }
                        r3 = android.net.Uri.parse(r3);	 Catch:{ JSONException -> 0x0113 }
                        r1.<init>(r2, r3);	 Catch:{ JSONException -> 0x0113 }
                        goto L_0x0042;	 Catch:{ JSONException -> 0x0113 }
                    L_0x002d:
                        r1 = host.exp.exponent.p339f.C6352l.f20614b;	 Catch:{ JSONException -> 0x0113 }
                        r2 = new android.content.Intent;	 Catch:{ JSONException -> 0x0113 }
                        r3 = r10.f20719b;	 Catch:{ JSONException -> 0x0113 }
                        r3 = r3;	 Catch:{ JSONException -> 0x0113 }
                        r2.<init>(r3, r1);	 Catch:{ JSONException -> 0x0113 }
                        r1 = "notificationExperienceUrl";	 Catch:{ JSONException -> 0x0113 }
                        r3 = r3;	 Catch:{ JSONException -> 0x0113 }
                        r3 = r3.f30371b;	 Catch:{ JSONException -> 0x0113 }
                        r2.putExtra(r1, r3);	 Catch:{ JSONException -> 0x0113 }
                        r1 = r2;	 Catch:{ JSONException -> 0x0113 }
                    L_0x0042:
                        r2 = r10.f20719b;	 Catch:{ JSONException -> 0x0113 }
                        r2 = r2;	 Catch:{ JSONException -> 0x0113 }
                        r3 = "data";	 Catch:{ JSONException -> 0x0113 }
                        r2 = r2.containsKey(r3);	 Catch:{ JSONException -> 0x0113 }
                        if (r2 == 0) goto L_0x005d;	 Catch:{ JSONException -> 0x0113 }
                    L_0x004e:
                        r2 = r10.f20719b;	 Catch:{ JSONException -> 0x0113 }
                        r2 = r2;	 Catch:{ JSONException -> 0x0113 }
                        r3 = "data";	 Catch:{ JSONException -> 0x0113 }
                        r2 = r2.get(r3);	 Catch:{ JSONException -> 0x0113 }
                        r2 = host.exp.exponent.p346j.C6389g.m26207a(r2);	 Catch:{ JSONException -> 0x0113 }
                        goto L_0x005f;	 Catch:{ JSONException -> 0x0113 }
                    L_0x005d:
                        r2 = "";	 Catch:{ JSONException -> 0x0113 }
                    L_0x005f:
                        r9 = new host.exp.exponent.notifications.k;	 Catch:{ JSONException -> 0x0113 }
                        r3 = r10.f20719b;	 Catch:{ JSONException -> 0x0113 }
                        r4 = r4;	 Catch:{ JSONException -> 0x0113 }
                        r3 = r10.f20719b;	 Catch:{ JSONException -> 0x0113 }
                        r6 = r5;	 Catch:{ JSONException -> 0x0113 }
                        r7 = 0;	 Catch:{ JSONException -> 0x0113 }
                        r8 = 0;	 Catch:{ JSONException -> 0x0113 }
                        r3 = r9;	 Catch:{ JSONException -> 0x0113 }
                        r5 = r2;	 Catch:{ JSONException -> 0x0113 }
                        r3.<init>(r4, r5, r6, r7, r8);	 Catch:{ JSONException -> 0x0113 }
                        r3 = "notification";	 Catch:{ JSONException -> 0x0113 }
                        r1.putExtra(r3, r2);	 Catch:{ JSONException -> 0x0113 }
                        r3 = "notification_object";	 Catch:{ JSONException -> 0x0113 }
                        r4 = 0;	 Catch:{ JSONException -> 0x0113 }
                        r5 = r9.m26254b(r4);	 Catch:{ JSONException -> 0x0113 }
                        r5 = r5.toString();	 Catch:{ JSONException -> 0x0113 }
                        r1.putExtra(r3, r5);	 Catch:{ JSONException -> 0x0113 }
                        r3 = r10.f20719b;	 Catch:{ JSONException -> 0x0113 }
                        r3 = r3;	 Catch:{ JSONException -> 0x0113 }
                        r5 = r10.f20719b;	 Catch:{ JSONException -> 0x0113 }
                        r5 = r5;	 Catch:{ JSONException -> 0x0113 }
                        r6 = 134217728; // 0x8000000 float:3.85186E-34 double:6.63123685E-316;	 Catch:{ JSONException -> 0x0113 }
                        r1 = android.app.PendingIntent.getActivity(r3, r5, r1, r6);	 Catch:{ JSONException -> 0x0113 }
                        r3 = r10.f20719b;	 Catch:{ JSONException -> 0x0113 }
                        r3 = r6;	 Catch:{ JSONException -> 0x0113 }
                        r3.a(r1);	 Catch:{ JSONException -> 0x0113 }
                        r1 = r10.f20719b;	 Catch:{ JSONException -> 0x0113 }
                        r1 = r2;	 Catch:{ JSONException -> 0x0113 }
                        r3 = "categoryId";	 Catch:{ JSONException -> 0x0113 }
                        r1 = r1.containsKey(r3);	 Catch:{ JSONException -> 0x0113 }
                        if (r1 == 0) goto L_0x00c4;	 Catch:{ JSONException -> 0x0113 }
                    L_0x00a4:
                        r1 = r3;	 Catch:{ JSONException -> 0x0113 }
                        r1 = r1.f30371b;	 Catch:{ JSONException -> 0x0113 }
                        r3 = r10.f20719b;	 Catch:{ JSONException -> 0x0113 }
                        r3 = r2;	 Catch:{ JSONException -> 0x0113 }
                        r5 = "categoryId";	 Catch:{ JSONException -> 0x0113 }
                        r3 = r3.get(r5);	 Catch:{ JSONException -> 0x0113 }
                        r3 = (java.lang.String) r3;	 Catch:{ JSONException -> 0x0113 }
                        r5 = r10.f20719b;	 Catch:{ JSONException -> 0x0113 }
                        r5 = r6;	 Catch:{ JSONException -> 0x0113 }
                        r6 = r10.f20719b;	 Catch:{ JSONException -> 0x0113 }
                        r6 = r3;	 Catch:{ JSONException -> 0x0113 }
                        r7 = new host.exp.exponent.notifications.i$2$1$1;	 Catch:{ JSONException -> 0x0113 }
                        r7.<init>(r10, r1, r2);	 Catch:{ JSONException -> 0x0113 }
                        host.exp.exponent.notifications.C6400g.m26285a(r3, r5, r6, r7);	 Catch:{ JSONException -> 0x0113 }
                    L_0x00c4:
                        r1 = r10.f20719b;	 Catch:{ JSONException -> 0x0113 }
                        r1 = r2;	 Catch:{ JSONException -> 0x0113 }
                        r2 = "color";	 Catch:{ JSONException -> 0x0113 }
                        r1 = r1.containsKey(r2);	 Catch:{ JSONException -> 0x0113 }
                        if (r1 == 0) goto L_0x00dd;	 Catch:{ JSONException -> 0x0113 }
                    L_0x00d0:
                        r1 = r10.f20719b;	 Catch:{ JSONException -> 0x0113 }
                        r1 = r2;	 Catch:{ JSONException -> 0x0113 }
                        r2 = "color";	 Catch:{ JSONException -> 0x0113 }
                        r1 = r1.get(r2);	 Catch:{ JSONException -> 0x0113 }
                        r1 = (java.lang.String) r1;	 Catch:{ JSONException -> 0x0113 }
                        goto L_0x00de;	 Catch:{ JSONException -> 0x0113 }
                    L_0x00dd:
                        r1 = r4;	 Catch:{ JSONException -> 0x0113 }
                    L_0x00de:
                        r2 = r10.f20719b;	 Catch:{ JSONException -> 0x0113 }
                        r2 = r7;	 Catch:{ JSONException -> 0x0113 }
                        r1 = host.exp.exponent.notifications.C6405i.m26287a(r1, r0, r2);	 Catch:{ JSONException -> 0x0113 }
                        r2 = r10.f20719b;	 Catch:{ JSONException -> 0x0113 }
                        r2 = r6;	 Catch:{ JSONException -> 0x0113 }
                        r2.e(r1);	 Catch:{ JSONException -> 0x0113 }
                        r1 = r10.f20719b;	 Catch:{ JSONException -> 0x0113 }
                        r1 = r2;	 Catch:{ JSONException -> 0x0113 }
                        r2 = "icon";	 Catch:{ JSONException -> 0x0113 }
                        r1 = r1.containsKey(r2);	 Catch:{ JSONException -> 0x0113 }
                        if (r1 == 0) goto L_0x0106;	 Catch:{ JSONException -> 0x0113 }
                    L_0x00f9:
                        r1 = r10.f20719b;	 Catch:{ JSONException -> 0x0113 }
                        r1 = r2;	 Catch:{ JSONException -> 0x0113 }
                        r2 = "icon";	 Catch:{ JSONException -> 0x0113 }
                        r1 = r1.get(r2);	 Catch:{ JSONException -> 0x0113 }
                        r4 = r1;	 Catch:{ JSONException -> 0x0113 }
                        r4 = (java.lang.String) r4;	 Catch:{ JSONException -> 0x0113 }
                    L_0x0106:
                        r1 = r10.f20719b;	 Catch:{ JSONException -> 0x0113 }
                        r1 = r7;	 Catch:{ JSONException -> 0x0113 }
                        r2 = new host.exp.exponent.notifications.i$2$1$2;	 Catch:{ JSONException -> 0x0113 }
                        r2.<init>(r10, r9);	 Catch:{ JSONException -> 0x0113 }
                        host.exp.exponent.notifications.C6405i.m26296a(r4, r0, r1, r2);	 Catch:{ JSONException -> 0x0113 }
                        goto L_0x0134;
                    L_0x0113:
                        r0 = r10.f20719b;
                        r0 = r9;
                        r1 = new java.lang.Exception;
                        r2 = new java.lang.StringBuilder;
                        r2.<init>();
                        r3 = "Couldn't deserialize JSON for experience id ";
                        r2.append(r3);
                        r3 = r10.f20719b;
                        r3 = r4;
                        r2.append(r3);
                        r2 = r2.toString();
                        r1.<init>(r2);
                        r0.onFailure(r1);
                    L_0x0134:
                        return;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.notifications.i.2.1.run():void");
                    }
                }).start();
            }

            /* renamed from: a */
            public void mo5431a() {
                C6403a c6403a = c6403a2;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("No experience found for id ");
                stringBuilder.append(str4);
                c6403a.onFailure(new Exception(stringBuilder.toString()));
            }
        });
    }

    /* renamed from: a */
    public static void m26289a(android.content.Context r8, int r9, java.util.HashMap<java.lang.String, java.lang.Object> r10, java.util.HashMap r11, org.json.JSONObject r12, host.exp.exponent.notifications.C6405i.C6403a r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = new java.util.HashMap;
        r3.<init>();
        r0 = "data";
        r3.put(r0, r10);
        r10 = "id";	 Catch:{ Exception -> 0x011f }
        r1 = r12.getString(r10);	 Catch:{ Exception -> 0x011f }
        r10 = "experienceId";	 Catch:{ Exception -> 0x011f }
        r3.put(r10, r1);	 Catch:{ Exception -> 0x011f }
        r4 = 0;
        r10 = "time";
        r10 = r11.containsKey(r10);
        if (r10 == 0) goto L_0x0060;
    L_0x001f:
        r10 = "time";	 Catch:{ ParseException -> 0x005b }
        r10 = r11.get(r10);	 Catch:{ ParseException -> 0x005b }
        r12 = r10 instanceof java.lang.String;	 Catch:{ ParseException -> 0x005b }
        if (r12 == 0) goto L_0x004a;	 Catch:{ ParseException -> 0x005b }
    L_0x0029:
        r12 = new java.text.SimpleDateFormat;	 Catch:{ ParseException -> 0x005b }
        r0 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";	 Catch:{ ParseException -> 0x005b }
        r12.<init>(r0);	 Catch:{ ParseException -> 0x005b }
        r0 = "UTC";	 Catch:{ ParseException -> 0x005b }
        r0 = java.util.TimeZone.getTimeZone(r0);	 Catch:{ ParseException -> 0x005b }
        r12.setTimeZone(r0);	 Catch:{ ParseException -> 0x005b }
        r10 = (java.lang.String) r10;	 Catch:{ ParseException -> 0x005b }
        r10 = r12.parse(r10);	 Catch:{ ParseException -> 0x005b }
        r4 = r10.getTime();	 Catch:{ ParseException -> 0x005b }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ ParseException -> 0x005b }
        r10 = 0;	 Catch:{ ParseException -> 0x005b }
        r4 = r4 - r6;	 Catch:{ ParseException -> 0x005b }
        goto L_0x0060;	 Catch:{ ParseException -> 0x005b }
    L_0x004a:
        r10 = (java.lang.String) r10;	 Catch:{ ParseException -> 0x005b }
        r10 = java.lang.Long.valueOf(r10);	 Catch:{ ParseException -> 0x005b }
        r4 = r10.longValue();	 Catch:{ ParseException -> 0x005b }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ ParseException -> 0x005b }
        r10 = 0;
        r4 = r4 - r6;
        goto L_0x0060;
    L_0x005b:
        r8 = move-exception;
        r13.onFailure(r8);
        return;
    L_0x0060:
        r6 = android.os.SystemClock.elapsedRealtime();
        r4 = r4 + r6;
        r0 = new host.exp.exponent.notifications.e;
        r0.<init>(r8);
        r8 = 0;
        r10 = "repeat";
        r10 = r11.containsKey(r10);
        if (r10 == 0) goto L_0x0101;
    L_0x0073:
        r8 = "repeat";
        r8 = r11.get(r8);
        r8 = (java.lang.String) r8;
        r10 = -1;
        r11 = r8.hashCode();
        switch(r11) {
            case -1074026988: goto L_0x00b6;
            case 99228: goto L_0x00ac;
            case 3208676: goto L_0x00a2;
            case 3645428: goto L_0x0098;
            case 3704893: goto L_0x008e;
            case 104080000: goto L_0x0084;
            default: goto L_0x0083;
        };
    L_0x0083:
        goto L_0x00bf;
    L_0x0084:
        r11 = "month";
        r8 = r8.equals(r11);
        if (r8 == 0) goto L_0x00bf;
    L_0x008c:
        r10 = 4;
        goto L_0x00bf;
    L_0x008e:
        r11 = "year";
        r8 = r8.equals(r11);
        if (r8 == 0) goto L_0x00bf;
    L_0x0096:
        r10 = 5;
        goto L_0x00bf;
    L_0x0098:
        r11 = "week";
        r8 = r8.equals(r11);
        if (r8 == 0) goto L_0x00bf;
    L_0x00a0:
        r10 = 3;
        goto L_0x00bf;
    L_0x00a2:
        r11 = "hour";
        r8 = r8.equals(r11);
        if (r8 == 0) goto L_0x00bf;
    L_0x00aa:
        r10 = 1;
        goto L_0x00bf;
    L_0x00ac:
        r11 = "day";
        r8 = r8.equals(r11);
        if (r8 == 0) goto L_0x00bf;
    L_0x00b4:
        r10 = 2;
        goto L_0x00bf;
    L_0x00b6:
        r11 = "minute";
        r8 = r8.equals(r11);
        if (r8 == 0) goto L_0x00bf;
    L_0x00be:
        r10 = 0;
    L_0x00bf:
        switch(r10) {
            case 0: goto L_0x00f9;
            case 1: goto L_0x00f1;
            case 2: goto L_0x00e9;
            case 3: goto L_0x00e1;
            case 4: goto L_0x00d7;
            case 5: goto L_0x00cd;
            default: goto L_0x00c2;
        };
    L_0x00c2:
        r8 = new java.lang.Exception;
        r9 = "Invalid repeat interval specified";
        r8.<init>(r9);
        r13.onFailure(r8);
        return;
    L_0x00cd:
        r10 = 31536000000; // 0x757b12c00 float:3.89605073E14 double:1.55808542072E-313;
        r8 = java.lang.Long.valueOf(r10);
        goto L_0x0111;
    L_0x00d7:
        r10 = 2592000000; // 0x9a7ec800 float:-5.2687528E-23 double:1.280618154E-314;
        r8 = java.lang.Long.valueOf(r10);
        goto L_0x0111;
    L_0x00e1:
        r10 = 604800000; // 0x240c8400 float:3.046947E-17 double:2.988109026E-315;
        r8 = java.lang.Long.valueOf(r10);
        goto L_0x0111;
    L_0x00e9:
        r10 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r8 = java.lang.Long.valueOf(r10);
        goto L_0x0111;
    L_0x00f1:
        r10 = 3600000; // 0x36ee80 float:5.044674E-39 double:1.7786363E-317;
        r8 = java.lang.Long.valueOf(r10);
        goto L_0x0111;
    L_0x00f9:
        r10 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r8 = java.lang.Long.valueOf(r10);
        goto L_0x0111;
    L_0x0101:
        r10 = "intervalMs";
        r10 = r11.containsKey(r10);
        if (r10 == 0) goto L_0x0111;
    L_0x0109:
        r8 = "intervalMs";
        r8 = r11.get(r8);
        r8 = (java.lang.Long) r8;
    L_0x0111:
        r6 = r8;
        r2 = r9;
        r0.m26272a(r1, r2, r3, r4, r6);	 Catch:{ Exception -> 0x011a }
        r13.onSuccess(r9);	 Catch:{ Exception -> 0x011a }
        goto L_0x011e;
    L_0x011a:
        r8 = move-exception;
        r13.onFailure(r8);
    L_0x011e:
        return;
    L_0x011f:
        r8 = new java.lang.Exception;
        r9 = "Requires Experience Id";
        r8.<init>(r9);
        r13.onFailure(r8);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.notifications.i.a(android.content.Context, int, java.util.HashMap, java.util.HashMap, org.json.JSONObject, host.exp.exponent.notifications.i$a):void");
    }
}
