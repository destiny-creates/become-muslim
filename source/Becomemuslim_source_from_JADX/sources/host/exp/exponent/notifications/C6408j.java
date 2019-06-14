package host.exp.exponent.notifications;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.ac.C0279d;
import android.support.v4.app.ac.C0281g;
import android.support.v4.app.ac.C3171c;
import android.support.v4.app.ac.C3172f;
import android.support.v4.app.af;
import com.facebook.share.internal.ShareConstants;
import de.p287a.p288a.C5884c;
import host.exp.exponent.C6301d;
import host.exp.exponent.C6369g;
import host.exp.exponent.C6369g.C6359a;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p336c.C6294a;
import host.exp.exponent.p339f.C6352l;
import host.exp.exponent.p344h.C6371c;
import host.exp.exponent.p344h.C6371c.C6370a;
import host.exp.exponent.p344h.C6373d;
import host.exp.p333a.C6279c.C6273b;
import host.exp.p333a.C6279c.C6277f;
import java.util.HashMap;
import java.util.Random;
import javax.inject.C6562a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PushNotificationHelper */
/* renamed from: host.exp.exponent.notifications.j */
public class C6408j {
    /* renamed from: c */
    private static final String f20729c = "j";
    /* renamed from: d */
    private static C6408j f20730d;
    @C6562a
    /* renamed from: a */
    C6369g f20731a;
    @C6562a
    /* renamed from: b */
    C6373d f20732b;

    /* compiled from: PushNotificationHelper */
    /* renamed from: host.exp.exponent.notifications.j$a */
    private enum C6407a {
        f20726a,
        COLLAPSE
    }

    /* renamed from: a */
    public static C6408j m26297a() {
        if (f20730d == null) {
            f20730d = new C6408j();
        }
        return f20730d;
    }

    public C6408j() {
        C6294a.m25957a().m25961b(C6408j.class, this);
    }

    /* renamed from: a */
    public void m26305a(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        final Context context2 = context;
        final String str7 = str3;
        final String str8 = str;
        final String str9 = str2;
        final String str10 = str4;
        final String str11 = str5;
        final String str12 = str6;
        C6370a c75921 = new C6370a(this) {
            /* renamed from: h */
            final /* synthetic */ C6408j f26274h;

            /* renamed from: a */
            public void mo5432a(host.exp.exponent.p344h.C8177a r11) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r10 = this;
                r6 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x001d }
                r0 = r11.f30373d;	 Catch:{ JSONException -> 0x001d }
                r6.<init>(r0);	 Catch:{ JSONException -> 0x001d }
                r0 = r10.f26274h;	 Catch:{ JSONException -> 0x001d }
                r1 = r2;	 Catch:{ JSONException -> 0x001d }
                r2 = r3;	 Catch:{ JSONException -> 0x001d }
                r3 = r4;	 Catch:{ JSONException -> 0x001d }
                r4 = r5;	 Catch:{ JSONException -> 0x001d }
                r5 = r11.f30371b;	 Catch:{ JSONException -> 0x001d }
                r7 = r6;	 Catch:{ JSONException -> 0x001d }
                r8 = r7;	 Catch:{ JSONException -> 0x001d }
                r9 = r8;	 Catch:{ JSONException -> 0x001d }
                r0.m26300a(r1, r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ JSONException -> 0x001d }
                goto L_0x0037;
            L_0x001d:
                r11 = host.exp.exponent.notifications.C6408j.f20729c;
                r0 = new java.lang.StringBuilder;
                r0.<init>();
                r1 = "Couldn't deserialize JSON for experience id ";
                r0.append(r1);
                r1 = r4;
                r0.append(r1);
                r0 = r0.toString();
                host.exp.exponent.p334a.C6289b.m25953c(r11, r0);
            L_0x0037:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.notifications.j.1.a(host.exp.exponent.h.a):void");
            }

            /* renamed from: a */
            public void mo5431a() {
                String b = C6408j.f20729c;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("No experience found for id ");
                stringBuilder.append(str8);
                C6289b.m25953c(b, stringBuilder.toString());
            }
        };
        String str13 = str;
        C6371c.m26147a(str, c75921);
    }

    /* renamed from: a */
    private void m26300a(Context context, String str, String str2, String str3, String str4, JSONObject jSONObject, String str5, String str6, String str7) {
        JSONObject jSONObject2 = jSONObject;
        final String optString = jSONObject2.optString("name");
        if (optString == null) {
            String str8 = f20729c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("No name found for experience id ");
            stringBuilder.append(str2);
            C6289b.m25953c(str8, stringBuilder.toString());
            return;
        }
        final String str9 = str2;
        final Context context2 = context;
        final C6398e c6398e = new C6398e(context2);
        final JSONObject optJSONObject = jSONObject2.optJSONObject("notification");
        final String str10 = str;
        final String str11 = str3;
        final JSONObject jSONObject3 = jSONObject;
        final String str12 = str5;
        C6359a c6359a = r0;
        final String str13 = str4;
        C6369g c6369g = this.f20731a;
        final String str14 = str6;
        final String str15 = str7;
        C75942 c75942 = new C6359a(this) {
            /* renamed from: m */
            final /* synthetic */ C6408j f26288m;

            /* renamed from: a */
            public void mo5380a(Bitmap bitmap) {
                CharSequence replace;
                Uri defaultUri;
                String a;
                JSONObject b;
                int a2;
                boolean z;
                C7595k c7595k;
                C7595k c7595k2;
                Intent intent;
                PendingIntent activity;
                CharSequence charSequence;
                StringBuilder stringBuilder;
                C0279d a3;
                C0281g a4;
                int i;
                final C0279d c0279d;
                final C7595k c7595k3;
                final Bitmap bitmap2;
                C6407a c6407a = C6407a.f20726a;
                JSONArray jSONArray = new JSONArray();
                if (optJSONObject != null) {
                    if ("collapse".equals(optJSONObject.optString("androidMode"))) {
                        c6407a = C6407a.COLLAPSE;
                    }
                }
                final int hashCode = c6407a == C6407a.COLLAPSE ? str9.hashCode() : new Random().nextInt();
                r7.f26288m.m26303a(str9, str10, hashCode);
                if (c6407a == C6407a.COLLAPSE) {
                    jSONArray = r7.f26288m.m26299a(str9);
                    String optString = optJSONObject.optString("androidCollapsedTitle");
                    if (optString != null) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("");
                        stringBuilder2.append(jSONArray.length());
                        replace = optString.replace("#{unread_notifications}", stringBuilder2.toString());
                        defaultUri = RingtoneManager.getDefaultUri(2);
                        if (str11 == null) {
                            a = C6398e.m26267a(str9, str11);
                            if (VERSION.SDK_INT >= 26) {
                                b = c6398e.m26276b(str9, str11);
                                if (!(b == null || b.optBoolean("sound", true))) {
                                    defaultUri = null;
                                }
                            } else if (c6398e.m26279c(str9, str11) == null) {
                                b = c6398e.m26276b(str9, str11);
                                if (b != null) {
                                    C6405i.m26294a(context2, str9, str11, b);
                                }
                            }
                        } else {
                            a = C6398e.m26267a(str9, "expo-default");
                            C6405i.m26292a(context2, str9, "expo-default", context2.getString(C6277f.default_notification_channel_group), new HashMap());
                        }
                        a2 = C6405i.m26287a(null, jSONObject3, r7.f26288m.f20731a);
                        z = c6407a != C6407a.COLLAPSE && jSONArray.length() > 1;
                        c7595k = c7595k2;
                        c7595k2 = new C7595k(str9, str12, hashCode, z, true);
                        intent = new Intent(context2, C6352l.f20614b);
                        intent.putExtra("notificationExperienceUrl", str13);
                        intent.putExtra("notification", str12);
                        intent.putExtra("notification_object", c7595k.m26254b(null).toString());
                        activity = PendingIntent.getActivity(context2, hashCode, intent, 1207959552);
                        if (z) {
                            if (str14 == null) {
                                charSequence = optString;
                            } else if (C6301d.m26001a()) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(optString);
                                stringBuilder.append(" - ");
                                stringBuilder.append(str14);
                                charSequence = stringBuilder.toString();
                            } else {
                                charSequence = str14;
                            }
                            a3 = new C0279d(context2, a).a(C6301d.m26001a() ? C6273b.shell_notification_icon : C6273b.notification_icon).a(charSequence).e(a2).b(str10).a(new C3171c().a(str10)).d(true).a(defaultUri).a(activity);
                        } else {
                            a4 = new C3172f().a(replace);
                            for (i = 0; i < Math.min(jSONArray.length(), 5); i++) {
                                try {
                                    a4.b(((JSONObject) jSONArray.get(i)).getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (jSONArray.length() > 5) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("and ");
                                stringBuilder.append(jSONArray.length() - 5);
                                stringBuilder.append(" more...");
                                a4.b(stringBuilder.toString());
                            }
                            a3 = new C0279d(context2, a).a(C6301d.m26001a() ? C6273b.shell_notification_icon : C6273b.notification_icon).a(replace).e(a2).b(optString).d(true).a(defaultUri).a(activity).a(a4);
                        }
                        c0279d = a3;
                        c7595k3 = c7595k;
                        bitmap2 = bitmap;
                        new Thread(new Runnable(this) {
                            /* renamed from: e */
                            final /* synthetic */ C75942 f20725e;

                            /* compiled from: PushNotificationHelper */
                            /* renamed from: host.exp.exponent.notifications.j$2$1$1 */
                            class C75931 implements C6399f {
                                /* renamed from: a */
                                final /* synthetic */ C64061 f26275a;

                                C75931(C64061 c64061) {
                                    this.f26275a = c64061;
                                }

                                /* renamed from: a */
                                public Intent mo5430a() {
                                    Intent intent = new Intent(context2, C6352l.f20614b);
                                    intent.putExtra("notificationExperienceUrl", str13);
                                    intent.putExtra("notification", str12);
                                    intent.putExtra("notification_object", c7595k3.m26254b(null).toString());
                                    return intent;
                                }
                            }

                            public void run() {
                                Notification a;
                                if (str15 != null) {
                                    C6400g.m26285a(str15, c0279d, context2, new C75931(this));
                                }
                                if (str13.equals(C6301d.f20496b)) {
                                    a = c0279d.a();
                                } else {
                                    a = c0279d.a(bitmap2).a();
                                }
                                c6398e.m26271a(str9, hashCode, a);
                                C5884c.m24753a().m24769d(c7595k3);
                            }
                        }).start();
                    }
                }
                replace = null;
                defaultUri = RingtoneManager.getDefaultUri(2);
                if (str11 == null) {
                    a = C6398e.m26267a(str9, "expo-default");
                    C6405i.m26292a(context2, str9, "expo-default", context2.getString(C6277f.default_notification_channel_group), new HashMap());
                } else {
                    a = C6398e.m26267a(str9, str11);
                    if (VERSION.SDK_INT >= 26) {
                        b = c6398e.m26276b(str9, str11);
                        defaultUri = null;
                    } else if (c6398e.m26279c(str9, str11) == null) {
                        b = c6398e.m26276b(str9, str11);
                        if (b != null) {
                            C6405i.m26294a(context2, str9, str11, b);
                        }
                    }
                }
                a2 = C6405i.m26287a(null, jSONObject3, r7.f26288m.f20731a);
                if (c6407a != C6407a.COLLAPSE) {
                }
                c7595k = c7595k2;
                c7595k2 = new C7595k(str9, str12, hashCode, z, true);
                intent = new Intent(context2, C6352l.f20614b);
                intent.putExtra("notificationExperienceUrl", str13);
                intent.putExtra("notification", str12);
                intent.putExtra("notification_object", c7595k.m26254b(null).toString());
                activity = PendingIntent.getActivity(context2, hashCode, intent, 1207959552);
                if (z) {
                    if (str14 == null) {
                        charSequence = optString;
                    } else if (C6301d.m26001a()) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(optString);
                        stringBuilder.append(" - ");
                        stringBuilder.append(str14);
                        charSequence = stringBuilder.toString();
                    } else {
                        charSequence = str14;
                    }
                    if (C6301d.m26001a()) {
                    }
                    a3 = new C0279d(context2, a).a(C6301d.m26001a() ? C6273b.shell_notification_icon : C6273b.notification_icon).a(charSequence).e(a2).b(str10).a(new C3171c().a(str10)).d(true).a(defaultUri).a(activity);
                } else {
                    a4 = new C3172f().a(replace);
                    for (i = 0; i < Math.min(jSONArray.length(), 5); i++) {
                        a4.b(((JSONObject) jSONArray.get(i)).getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE));
                    }
                    if (jSONArray.length() > 5) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("and ");
                        stringBuilder.append(jSONArray.length() - 5);
                        stringBuilder.append(" more...");
                        a4.b(stringBuilder.toString());
                    }
                    if (C6301d.m26001a()) {
                    }
                    a3 = new C0279d(context2, a).a(C6301d.m26001a() ? C6273b.shell_notification_icon : C6273b.notification_icon).a(replace).e(a2).b(optString).d(true).a(defaultUri).a(activity).a(a4);
                }
                c0279d = a3;
                c7595k3 = c7595k;
                bitmap2 = bitmap;
                new Thread(/* anonymous class already generated */).start();
            }
        };
        C6405i.m26296a(null, jSONObject, c6369g, c6359a);
    }

    /* renamed from: a */
    private void m26303a(String str, String str2, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str2);
            jSONObject.put("notificationId", i);
            JSONObject e = this.f20732b.m26165e(str);
            if (e == null) {
                e = new JSONObject();
            }
            i = e.optJSONArray("unreadNotifications");
            if (i == 0) {
                i = new JSONArray();
            }
            i.put(jSONObject);
            e.put("unreadNotifications", i);
            this.f20732b.m26158b(str, e);
        } catch (String str3) {
            str3.printStackTrace();
        }
    }

    /* renamed from: a */
    private JSONArray m26299a(String str) {
        str = this.f20732b.m26165e(str);
        if (str != null && str.has("unreadNotifications")) {
            try {
                return str.getJSONArray("unreadNotifications");
            } catch (String str2) {
                str2.printStackTrace();
            }
        }
        return new JSONArray();
    }

    /* renamed from: a */
    public void m26306a(Context context, JSONArray jSONArray) {
        if (jSONArray != null) {
            context = af.a(context);
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    context.a(Integer.parseInt(((JSONObject) jSONArray.get(i)).getString("notificationId")));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
