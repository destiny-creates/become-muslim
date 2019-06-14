package host.exp.exponent.notifications;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.app.af;
import host.exp.exponent.C6301d;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p344h.C6373d;
import host.exp.p333a.C6279c.C6277f;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.inject.C6562a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ExponentNotificationManager */
/* renamed from: host.exp.exponent.notifications.e */
public class C6398e {
    /* renamed from: b */
    private static String f20712b = "e";
    /* renamed from: d */
    private static Set<String> f20713d = new HashSet();
    /* renamed from: e */
    private static boolean f20714e = false;
    @C6562a
    /* renamed from: a */
    C6373d f20715a;
    /* renamed from: c */
    private Context f20716c;

    public C6398e(Context context) {
        this.f20716c = context;
        C6294a.m25957a().m25961b(C6398e.class, this);
    }

    /* renamed from: a */
    public static String m26267a(String str, String str2) {
        if (C6301d.m26001a()) {
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("/");
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    /* renamed from: a */
    public void m26275a(JSONObject jSONObject) {
        if (!C6301d.m26001a() && VERSION.SDK_INT >= 26) {
            String string;
            try {
                string = jSONObject.getString("id");
                if (!f20713d.contains(string)) {
                    ((NotificationManager) this.f20716c.getSystemService(NotificationManager.class)).createNotificationChannelGroup(new NotificationChannelGroup(string, jSONObject.optString("name", string)));
                    f20713d.add(string);
                }
            } catch (JSONObject jSONObject2) {
                string = f20712b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not create notification channel: ");
                stringBuilder.append(jSONObject2.getMessage());
                C6289b.m25953c(string, stringBuilder.toString());
            }
        }
    }

    /* renamed from: a */
    public void m26268a() {
        if (VERSION.SDK_INT >= 26 && !f20714e) {
            NotificationManager notificationManager = (NotificationManager) this.f20716c.getSystemService(NotificationManager.class);
            NotificationChannel notificationChannel = new NotificationChannel("expo-experience", this.f20716c.getString(C6277f.persistent_notification_channel_name), 3);
            notificationChannel.setSound(null, null);
            notificationChannel.setDescription(this.f20716c.getString(C6277f.persistent_notification_channel_desc));
            if (!C6301d.m26001a()) {
                notificationManager.createNotificationChannelGroup(new NotificationChannelGroup("expo-experience-group", this.f20716c.getString(C6277f.persistent_notification_channel_group)));
                notificationChannel.setGroup("expo-experience-group");
            }
            notificationManager.createNotificationChannel(notificationChannel);
            f20714e = true;
        }
    }

    /* renamed from: a */
    public void m26273a(String str, NotificationChannel notificationChannel) {
        if (VERSION.SDK_INT >= 26) {
            if (!C6301d.m26001a()) {
                notificationChannel.setGroup(str);
            }
            ((NotificationManager) this.f20716c.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
        }
    }

    /* renamed from: a */
    public void m26274a(String str, String str2, HashMap hashMap) {
        try {
            JSONObject jSONObject;
            JSONObject e = this.f20715a.m26165e(str);
            if (e == null) {
                e = new JSONObject();
            }
            if (e.has("notificationChannels")) {
                jSONObject = e.getJSONObject("notificationChannels");
            } else {
                jSONObject = new JSONObject();
            }
            jSONObject.put(str2, new JSONObject(hashMap));
            e.put("notificationChannels", jSONObject);
            this.f20715a.m26158b(str, e);
        } catch (String str3) {
            str2 = f20712b;
            hashMap = new StringBuilder();
            hashMap.append("Could not store channel in shared preferences: ");
            hashMap.append(str3.getMessage());
            C6289b.m25953c(str2, hashMap.toString());
        }
    }

    /* renamed from: b */
    public JSONObject m26276b(String str, String str2) {
        try {
            str = this.f20715a.m26165e(str);
            if (str == null) {
                str = new JSONObject();
            }
            if (str.has("notificationChannels")) {
                str = str.getJSONObject("notificationChannels");
            } else {
                str = new JSONObject();
            }
            return str.optJSONObject(str2);
        } catch (String str3) {
            str2 = f20712b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not read channel from shared preferences: ");
            stringBuilder.append(str3.getMessage());
            C6289b.m25953c(str2, stringBuilder.toString());
            return null;
        }
    }

    /* renamed from: c */
    public NotificationChannel m26279c(String str, String str2) {
        return VERSION.SDK_INT >= 26 ? ((NotificationManager) this.f20716c.getSystemService(NotificationManager.class)).getNotificationChannel(C6398e.m26267a(str, str2)) : null;
    }

    /* renamed from: d */
    public void m26280d(String str, String str2) {
        if (VERSION.SDK_INT >= 26) {
            ((NotificationManager) this.f20716c.getSystemService(NotificationManager.class)).deleteNotificationChannel(C6398e.m26267a(str, str2));
        }
    }

    /* renamed from: a */
    public void m26271a(String str, int i, Notification notification) {
        af.a(this.f20716c).a(str, i, notification);
        try {
            JSONObject e = this.f20715a.m26165e(str);
            if (e == null) {
                e = new JSONObject();
            }
            JSONArray optJSONArray = e.optJSONArray("allNotificationIds");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            optJSONArray.put(i);
            e.put("allNotificationIds", optJSONArray);
            this.f20715a.m26158b(str, e);
        } catch (String str2) {
            str2.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m26270a(String str, int i) {
        af.a(this.f20716c).a(str, i);
        try {
            JSONObject e = this.f20715a.m26165e(str);
            if (e != null) {
                JSONArray optJSONArray = e.optJSONArray("allNotificationIds");
                if (optJSONArray != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        if (optJSONArray.getInt(i2) != i) {
                            jSONArray.put(optJSONArray.getInt(i2));
                        }
                    }
                    e.put("allNotificationIds", jSONArray);
                    this.f20715a.m26158b(str, e);
                }
            }
        } catch (String str2) {
            str2.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m26269a(String str) {
        try {
            JSONObject e = this.f20715a.m26165e(str);
            if (e != null) {
                JSONArray optJSONArray = e.optJSONArray("allNotificationIds");
                if (optJSONArray != null) {
                    af a = af.a(this.f20716c);
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        a.a(str, optJSONArray.getInt(i));
                    }
                    e.put("allNotificationIds", null);
                    e.put("unreadNotifications", null);
                    this.f20715a.m26158b(str, e);
                }
            }
        } catch (String str2) {
            str2.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m26272a(String str, int i, HashMap hashMap, long j, Long l) {
        String str2 = str;
        int i2 = i;
        Intent intent = new Intent(this.f20716c, ScheduledNotificationReceiver.class);
        intent.setType(str);
        intent.setAction(String.valueOf(i));
        intent.putExtra("notification_id", i2);
        intent.putExtra("notification_object", hashMap);
        PendingIntent broadcast = PendingIntent.getBroadcast(this.f20716c, 0, intent, 134217728);
        AlarmManager alarmManager = (AlarmManager) this.f20716c.getSystemService("alarm");
        if (l != null) {
            alarmManager.setRepeating(2, j, l.longValue(), broadcast);
        } else {
            alarmManager.set(2, j, broadcast);
        }
        try {
            JSONObject e = r1.f20715a.m26165e(str);
            if (e == null) {
                e = new JSONObject();
            }
            JSONArray optJSONArray = e.optJSONArray("allScheduledNotificationIds");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            optJSONArray.put(i2);
            e.put("allScheduledNotificationIds", optJSONArray);
            r1.f20715a.m26158b(str, e);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m26278b(String str, int i) {
        Intent intent = new Intent(this.f20716c, ScheduledNotificationReceiver.class);
        intent.setType(str);
        intent.setAction(String.valueOf(i));
        ((AlarmManager) this.f20716c.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(this.f20716c, 0, intent, 134217728));
        m26270a(str, i);
    }

    /* renamed from: b */
    public void m26277b(String str) {
        try {
            JSONObject e = this.f20715a.m26165e(str);
            if (e != null) {
                JSONArray optJSONArray = e.optJSONArray("allScheduledNotificationIds");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        m26278b(str, optJSONArray.getInt(i));
                    }
                    e.put("allScheduledNotificationIds", null);
                    this.f20715a.m26158b(str, e);
                }
            }
        } catch (String str2) {
            str2.printStackTrace();
        }
    }
}
