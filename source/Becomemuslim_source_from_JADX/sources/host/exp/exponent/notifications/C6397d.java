package host.exp.exponent.notifications;

import android.app.IntentService;
import host.exp.exponent.p334a.C6289b;
import host.exp.exponent.p343g.C6368f;
import host.exp.exponent.p344h.C6373d;
import host.exp.exponent.p346j.C6383a;
import javax.inject.C6562a;

/* compiled from: ExponentNotificationIntentService */
/* renamed from: host.exp.exponent.notifications.d */
public abstract class C6397d extends IntentService {
    /* renamed from: a */
    private static final String f20708a = "d";
    /* renamed from: d */
    private static boolean f20709d = false;
    @C6562a
    /* renamed from: b */
    C6373d f20710b;
    @C6562a
    /* renamed from: c */
    C6368f f20711c;

    /* renamed from: a */
    public abstract String mo5413a();

    /* renamed from: b */
    public abstract String mo5414b();

    /* renamed from: c */
    public abstract String mo5415c();

    public C6397d(String str) {
        super(str);
    }

    /* renamed from: e */
    private void m26263e() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.f20710b;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = host.exp.exponent.p336c.C6294a.m25957a();	 Catch:{ Throwable -> 0x000e }
        r1 = host.exp.exponent.notifications.C6397d.class;	 Catch:{ Throwable -> 0x000e }
        r0.m25961b(r1, r2);	 Catch:{ Throwable -> 0x000e }
    L_0x000e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.notifications.d.e():void");
    }

    public void onCreate() {
        super.onCreate();
        m26263e();
    }

    protected void onHandleIntent(android.content.Intent r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r4.m26263e();
        r5 = r4.f20710b;
        if (r5 != 0) goto L_0x0008;
    L_0x0007:
        return;
    L_0x0008:
        r5 = r4.mo5413a();	 Catch:{ SecurityException -> 0x00b5, IOException -> 0x00b0 }
        if (r5 != 0) goto L_0x0014;	 Catch:{ SecurityException -> 0x00b5, IOException -> 0x00b0 }
    L_0x000e:
        r5 = "Device push token is null";	 Catch:{ SecurityException -> 0x00b5, IOException -> 0x00b0 }
        r4.m26260a(r5);	 Catch:{ SecurityException -> 0x00b5, IOException -> 0x00b0 }
        return;	 Catch:{ SecurityException -> 0x00b5, IOException -> 0x00b0 }
    L_0x0014:
        r0 = r4.f20710b;	 Catch:{ SecurityException -> 0x00b5, IOException -> 0x00b0 }
        r1 = r4.mo5414b();	 Catch:{ SecurityException -> 0x00b5, IOException -> 0x00b0 }
        r0 = r0.m26156b(r1);	 Catch:{ SecurityException -> 0x00b5, IOException -> 0x00b0 }
        if (r0 == 0) goto L_0x002c;	 Catch:{ SecurityException -> 0x00b5, IOException -> 0x00b0 }
    L_0x0020:
        r0 = r0.equals(r5);	 Catch:{ SecurityException -> 0x00b5, IOException -> 0x00b0 }
        if (r0 == 0) goto L_0x002c;	 Catch:{ SecurityException -> 0x00b5, IOException -> 0x00b0 }
    L_0x0026:
        r5 = "devicePushToken";	 Catch:{ SecurityException -> 0x00b5, IOException -> 0x00b0 }
        host.exp.exponent.p346j.C6383a.m26189a(r5);	 Catch:{ SecurityException -> 0x00b5, IOException -> 0x00b0 }
        return;	 Catch:{ SecurityException -> 0x00b5, IOException -> 0x00b0 }
    L_0x002c:
        r0 = 0;	 Catch:{ SecurityException -> 0x00b5, IOException -> 0x00b0 }
        com.facebook.soloader.SoLoader.init(r4, r0);	 Catch:{ SecurityException -> 0x00b5, IOException -> 0x00b0 }
        r0 = r4.f20710b;	 Catch:{ SecurityException -> 0x00b5, IOException -> 0x00b0 }
        r0 = r0.m26164e();	 Catch:{ SecurityException -> 0x00b5, IOException -> 0x00b0 }
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00ab }
        r1.<init>();	 Catch:{ JSONException -> 0x00ab }
        r2 = "deviceToken";	 Catch:{ JSONException -> 0x00ab }
        r1.put(r2, r5);	 Catch:{ JSONException -> 0x00ab }
        r2 = "deviceId";	 Catch:{ JSONException -> 0x00ab }
        r1.put(r2, r0);	 Catch:{ JSONException -> 0x00ab }
        r0 = "appId";	 Catch:{ JSONException -> 0x00ab }
        r2 = r4.getApplicationContext();	 Catch:{ JSONException -> 0x00ab }
        r2 = r2.getPackageName();	 Catch:{ JSONException -> 0x00ab }
        r1.put(r0, r2);	 Catch:{ JSONException -> 0x00ab }
        r0 = "type";	 Catch:{ JSONException -> 0x00ab }
        r2 = r4.mo5415c();	 Catch:{ JSONException -> 0x00ab }
        r1.put(r0, r2);	 Catch:{ JSONException -> 0x00ab }
        r0 = "application/json; charset=utf-8";	 Catch:{ JSONException -> 0x00ab }
        r0 = expolib_v1.p321a.C6240u.m25781a(r0);	 Catch:{ JSONException -> 0x00ab }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x00ab }
        r0 = expolib_v1.p321a.aa.create(r0, r1);	 Catch:{ JSONException -> 0x00ab }
        r1 = "https://exp.host/--/api/v2/push/updateDeviceToken";	 Catch:{ JSONException -> 0x00ab }
        r1 = host.exp.exponent.p339f.C6339i.m26063b(r1);	 Catch:{ JSONException -> 0x00ab }
        r2 = "Content-Type";	 Catch:{ JSONException -> 0x00ab }
        r3 = "application/json";	 Catch:{ JSONException -> 0x00ab }
        r1 = r1.m25816a(r2, r3);	 Catch:{ JSONException -> 0x00ab }
        r0 = r1.m25809a(r0);	 Catch:{ JSONException -> 0x00ab }
        r0 = r0.m25820b();	 Catch:{ JSONException -> 0x00ab }
        r1 = r4.f20711c;	 Catch:{ JSONException -> 0x00ab }
        r1 = r1.m26115a();	 Catch:{ JSONException -> 0x00ab }
        r2 = new host.exp.exponent.notifications.d$1;	 Catch:{ JSONException -> 0x00ab }
        r2.<init>(r4, r5);	 Catch:{ JSONException -> 0x00ab }
        r1.m26103a(r0, r2);	 Catch:{ JSONException -> 0x00ab }
        r0 = f20708a;	 Catch:{ JSONException -> 0x00ab }
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x00ab }
        r1.<init>();	 Catch:{ JSONException -> 0x00ab }
        r2 = r4.mo5415c();	 Catch:{ JSONException -> 0x00ab }
        r1.append(r2);	 Catch:{ JSONException -> 0x00ab }
        r2 = " Registration Token: ";	 Catch:{ JSONException -> 0x00ab }
        r1.append(r2);	 Catch:{ JSONException -> 0x00ab }
        r1.append(r5);	 Catch:{ JSONException -> 0x00ab }
        r5 = r1.toString();	 Catch:{ JSONException -> 0x00ab }
        android.util.Log.i(r0, r5);	 Catch:{ JSONException -> 0x00ab }
        goto L_0x00ba;
    L_0x00ab:
        r5 = move-exception;
        r4.m26259a(r5);	 Catch:{ SecurityException -> 0x00b5, IOException -> 0x00b0 }
        goto L_0x00ba;
    L_0x00b0:
        r5 = move-exception;
        r4.m26259a(r5);
        goto L_0x00ba;
    L_0x00b5:
        r5 = "Are you running in Genymotion? Follow this guide https://inthecheesefactory.com/blog/how-to-install-google-services-on-genymotion/en to install Google Play Services";
        r4.m26260a(r5);
    L_0x00ba:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: host.exp.exponent.notifications.d.onHandleIntent(android.content.Intent):void");
    }

    /* renamed from: d */
    public static boolean m26262d() {
        return f20709d;
    }

    /* renamed from: a */
    private void m26259a(Exception exception) {
        f20709d = true;
        C6383a.m26189a("devicePushToken");
        C6289b.m25950a(f20708a, (Throwable) exception);
    }

    /* renamed from: a */
    private void m26260a(String str) {
        f20709d = true;
        C6383a.m26189a("devicePushToken");
        C6289b.m25953c(f20708a, str);
    }
}
