package com.onesignal;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build.VERSION;
import com.onesignal.am.C5464i;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: NotificationChannelManager */
/* renamed from: com.onesignal.r */
class C5530r {
    /* renamed from: a */
    private static int m23549a(int i) {
        return i > 9 ? 5 : i > 7 ? 4 : i > 5 ? 3 : i > 3 ? 2 : i > 1 ? 1 : 0;
    }

    /* renamed from: a */
    static String m23552a(C5538t c5538t) {
        if (VERSION.SDK_INT < 26) {
            return "fcm_fallback_notification_channel";
        }
        Context context = c5538t.f18576a;
        JSONObject jSONObject = c5538t.f18577b;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (c5538t.f18578c != null) {
            return C5530r.m23554b(notificationManager);
        }
        if (jSONObject.has("oth_chnl") != null) {
            c5538t = jSONObject.optString("oth_chnl");
            if (notificationManager.getNotificationChannel(c5538t) != null) {
                return c5538t;
            }
        }
        if (jSONObject.has("chnl") == null) {
            return C5530r.m23550a(notificationManager);
        }
        try {
            return C5530r.m23551a(context, notificationManager, jSONObject);
        } catch (Throwable e) {
            am.m23161a(C5464i.ERROR, "Could not create notification channel due to JSON payload error!", e);
            return "fcm_fallback_notification_channel";
        }
    }

    /* renamed from: a */
    private static String m23551a(Context context, NotificationManager notificationManager, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        NotificationChannel notificationChannel;
        String optString;
        boolean z;
        long[] a;
        Object opt = jSONObject.opt("chnl");
        if (opt instanceof String) {
            jSONObject2 = new JSONObject((String) opt);
        } else {
            jSONObject2 = (JSONObject) opt;
        }
        String optString2 = jSONObject2.optString("id", "fcm_fallback_notification_channel");
        if (optString2.equals("miscellaneous")) {
            optString2 = "fcm_fallback_notification_channel";
        }
        if (jSONObject2.has("langs")) {
            jSONObject3 = jSONObject2.getJSONObject("langs");
            String f = al.m23099f();
            if (jSONObject3.has(f)) {
                jSONObject3 = jSONObject3.optJSONObject(f);
                notificationChannel = new NotificationChannel(optString2, jSONObject3.optString("nm", "Miscellaneous"), C5530r.m23549a(jSONObject.optInt("pri", 6)));
                notificationChannel.setDescription(jSONObject3.optString("dscr", null));
                if (jSONObject2.has("grp_id")) {
                    optString = jSONObject2.optString("grp_id");
                    notificationManager.createNotificationChannelGroup(new NotificationChannelGroup(optString, jSONObject3.optString("grp_nm")));
                    notificationChannel.setGroup(optString);
                }
                if (jSONObject.has("ledc")) {
                    notificationChannel.setLightColor(new BigInteger(jSONObject.optString("ledc"), 16).intValue());
                }
                z = true;
                notificationChannel.enableLights(jSONObject.optInt("led", 1) != 1);
                if (jSONObject.has("vib_pt")) {
                    a = al.m23094a(jSONObject);
                    if (a != null) {
                        notificationChannel.setVibrationPattern(a);
                    }
                }
                notificationChannel.enableVibration(jSONObject.optInt("vib", 1) != 1);
                if (jSONObject.has("sound")) {
                    optString = jSONObject.optString("sound", null);
                    context = al.m23096b(context, optString);
                    if (context == null) {
                        notificationChannel.setSound(context, null);
                    } else if (!("null".equals(optString) == null && "nil".equals(optString) == null)) {
                        notificationChannel.setSound(null, null);
                    }
                }
                notificationChannel.setLockscreenVisibility(jSONObject.optInt("vis", 0));
                notificationChannel.setShowBadge(jSONObject.optInt("bdg", 1) != 1 ? true : null);
                if (jSONObject.optInt("bdnd", 0) == 1) {
                    z = false;
                }
                notificationChannel.setBypassDnd(z);
                notificationManager.createNotificationChannel(notificationChannel);
                return optString2;
            }
        }
        jSONObject3 = jSONObject2;
        notificationChannel = new NotificationChannel(optString2, jSONObject3.optString("nm", "Miscellaneous"), C5530r.m23549a(jSONObject.optInt("pri", 6)));
        notificationChannel.setDescription(jSONObject3.optString("dscr", null));
        if (jSONObject2.has("grp_id")) {
            optString = jSONObject2.optString("grp_id");
            notificationManager.createNotificationChannelGroup(new NotificationChannelGroup(optString, jSONObject3.optString("grp_nm")));
            notificationChannel.setGroup(optString);
        }
        if (jSONObject.has("ledc")) {
            notificationChannel.setLightColor(new BigInteger(jSONObject.optString("ledc"), 16).intValue());
        }
        z = true;
        if (jSONObject.optInt("led", 1) != 1) {
        }
        notificationChannel.enableLights(jSONObject.optInt("led", 1) != 1);
        if (jSONObject.has("vib_pt")) {
            a = al.m23094a(jSONObject);
            if (a != null) {
                notificationChannel.setVibrationPattern(a);
            }
        }
        if (jSONObject.optInt("vib", 1) != 1) {
        }
        notificationChannel.enableVibration(jSONObject.optInt("vib", 1) != 1);
        if (jSONObject.has("sound")) {
            optString = jSONObject.optString("sound", null);
            context = al.m23096b(context, optString);
            if (context == null) {
                notificationChannel.setSound(null, null);
            } else {
                notificationChannel.setSound(context, null);
            }
        }
        notificationChannel.setLockscreenVisibility(jSONObject.optInt("vis", 0));
        if (jSONObject.optInt("bdg", 1) != 1) {
        }
        notificationChannel.setShowBadge(jSONObject.optInt("bdg", 1) != 1 ? true : null);
        if (jSONObject.optInt("bdnd", 0) == 1) {
            z = false;
        }
        notificationChannel.setBypassDnd(z);
        notificationManager.createNotificationChannel(notificationChannel);
        return optString2;
    }

    /* renamed from: a */
    private static String m23550a(NotificationManager notificationManager) {
        NotificationChannel notificationChannel = new NotificationChannel("fcm_fallback_notification_channel", "Miscellaneous", 3);
        notificationChannel.enableLights(true);
        notificationChannel.enableVibration(true);
        notificationManager.createNotificationChannel(notificationChannel);
        return "fcm_fallback_notification_channel";
    }

    /* renamed from: b */
    private static String m23554b(NotificationManager notificationManager) {
        notificationManager.createNotificationChannel(new NotificationChannel("restored_OS_notifications", "Restored", 2));
        return "restored_OS_notifications";
    }

    /* renamed from: a */
    static void m23553a(Context context, JSONObject jSONObject) {
        if (VERSION.SDK_INT >= 26 && jSONObject.has("chnl_lst")) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            Set hashSet = new HashSet();
            jSONObject = jSONObject.optJSONArray("chnl_lst");
            int length = jSONObject.length();
            for (int i = 0; i < length; i++) {
                try {
                    hashSet.add(C5530r.m23551a(context, notificationManager, jSONObject.getJSONObject(i)));
                } catch (Throwable e) {
                    am.m23161a(C5464i.ERROR, "Could not create notification channel due to JSON payload error!", e);
                }
            }
            for (NotificationChannel id : notificationManager.getNotificationChannels()) {
                jSONObject = id.getId();
                if (jSONObject.startsWith("OS_") && !hashSet.contains(jSONObject)) {
                    notificationManager.deleteNotificationChannel(jSONObject);
                }
            }
        }
    }
}
